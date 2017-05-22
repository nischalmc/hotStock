package com.hotstock.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotstock.enums.Status;
import com.hotstock.models.Broker;
import com.hotstock.models.Stock;
import com.hotstock.models.StockTrade;
import com.hotstock.repositories.BrokerRepository;
import com.hotstock.repositories.StockRepository;
import com.hotstock.repositories.StockTradeRepository;

@Controller
public class BuyerSellerController {
	
	@Autowired
	private BrokerRepository brokerRepo;
	
	@Autowired
	private StockRepository stockRepo;
	
	@Autowired
	private StockTradeRepository stockTradeRepo;
	
	@RequestMapping(path="/stockList")
	public String stockList(Model model){
		String forwardPage = "stockList";
		List<Stock> stockList = stockRepo.findAll();
		model.addAttribute("stockList", stockList);
		return forwardPage;
	}
	
	@RequestMapping(path="/buyStock")
	public String buyStock(@RequestParam("stockName") String stockName, 
			@RequestParam("brokerUserName") String brokerUserName, Model model){
		String forwardPage = "buyStock";
		Stock stock = stockRepo.findByName(stockName);
		model.addAttribute("stock", stock);
		model.addAttribute("brokerUserName", brokerUserName);
		return forwardPage;
	}
	
	@RequestMapping(path="/saveStockTrade")
	public String saveStockTrade(@RequestParam("stockName") String stockName, 
			@RequestParam("quotePrice") String quotePrice,
			@RequestParam("loggedInBroker") String loggedInBroker, Model model){
		String forwardPage = "stockList";
		
		Stock stock = stockRepo.findByName(stockName);
		stock.setStatus(Status.OPEN);
		Broker stockOwnerBroker = stock.getBroker();
		Broker buyRequestBroker = brokerRepo.findByUsername(loggedInBroker);
		
		StockTrade stockTrade = new StockTrade();
		stockTrade.setStock(stock);
		stockTrade.setBuyer(buyRequestBroker);
		stockTrade.setSeller(stockOwnerBroker);
		stockTrade.setQuotePrice(quotePrice);
		stockTrade.setCreatedDate(new Date());
		stockTrade.setLastUpdatedDate(new Date());
		
		stockTradeRepo.save(stockTrade);
		
		List<Stock> stockList = stockRepo.findAll();
		model.addAttribute("stockList", stockList);
		model.addAttribute("broker", buyRequestBroker);
		
		return forwardPage;
	}
	
	@RequestMapping(path="/sellStock")
	public String sellStock(@RequestParam("stockName") String stockName, 
			@RequestParam("brokerUserName") String brokerUserName, Model model){
		String forwardPage = "sellStock";
		Stock stock = stockRepo.findByName(stockName);
		StockTrade stockTrade = stockTradeRepo.findByStock(stock);
		Broker broker = brokerRepo.findByUsername(brokerUserName);
		
		model.addAttribute("stockTrade", stockTrade);
		model.addAttribute("stock", stock);
		model.addAttribute("broker", broker);
		return forwardPage;
	}
	
	
	@RequestMapping(path="/acceptOffer")
	public String acceptOffer(@RequestParam("stockName") String stockName, 
			@RequestParam("brokerUserName") String brokerUserName, Model model){
		String forwardPage = "stockList";
		Stock stock = stockRepo.findByName(stockName);
		Broker stockOwner = brokerRepo.findByUsername(brokerUserName);
		StockTrade stockTrade = stockTradeRepo.findByStockAndSeller(stock, stockOwner);
		
		stock.setBroker(stockTrade.getBuyer());
		stock.setStatus(null);
		stock.setPrice(stockTrade.getQuotePrice());
		stockRepo.save(stock);
	
		List<Stock> stockList = stockRepo.findAll();
		model.addAttribute("stockList", stockList);
		model.addAttribute("broker", stockOwner);
		
		return forwardPage;
	}
	
	
	@RequestMapping(path="/rejectOffer")
	public String rejectOffer(@RequestParam("stockName") String stockName, 
			@RequestParam("brokerUserName") String brokerUserName, Model model){
		String forwardPage = "stockList";
		Stock stock = stockRepo.findByName(stockName);
		Broker stockOwner = brokerRepo.findByUsername(brokerUserName);
		
		stock.setStatus(null);
		stockRepo.save(stock);
	
		List<Stock> stockList = stockRepo.findAll();
		model.addAttribute("stockList", stockList);
		model.addAttribute("broker", stockOwner);
		
		return forwardPage;
	}
}
