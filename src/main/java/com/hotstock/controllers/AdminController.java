package com.hotstock.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotstock.models.Broker;
import com.hotstock.models.Stock;
import com.hotstock.models.StockTrade;
import com.hotstock.repositories.BrokerRepository;
import com.hotstock.repositories.StockRepository;
import com.hotstock.repositories.StockTradeRepository;

@Controller
public class AdminController {
	
	@Autowired
	private BrokerRepository brokerRepo;
	
	@Autowired
	private StockRepository stockRepo;
	
	@Autowired
	private StockTradeRepository stockTradeRepo;
	
	@RequestMapping(path="/createStock")
	public String createStock(){
		String forwardPage = "createStock";
		return forwardPage;
	}
	
	@RequestMapping(path="/adminStockList")
	public String stockList(Model model){
		String forwardPage = "adminStockList";
		List<Stock> stockList = stockRepo.findAll();
		model.addAttribute("stockList", stockList);
		return forwardPage;
	}
	
	@RequestMapping(path="/stockReport")
	public String stockReport(Model model){
		String forwardPage = "stockReport";
		
		List<StockTrade> stockTradeList = stockTradeRepo.findAll();
		model.addAttribute("stockTradeList", stockTradeList);
		
		return forwardPage;
	}

	@RequestMapping(path="/saveStock")
	public String saveStock(@RequestParam("stockName") String stockName, @RequestParam("symbol") String symbol,
			@RequestParam("price") String price, @RequestParam("brokerUsername") String brokerUsername){
		String forwardPage = "createStock";
		
		Stock stock = new Stock();
		stock.setName(stockName);
		stock.setSymbol(symbol);
		stock.setPrice(price);
		
		Broker broker = brokerRepo.findByUsername(brokerUsername);
		stock.setBroker(broker);
		
		stockRepo.save(stock);
		
		return forwardPage;
	}
}
