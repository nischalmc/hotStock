package com.hotstock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotstock.models.Broker;
import com.hotstock.models.Stock;
import com.hotstock.models.StockTrade;
import com.hotstock.repositories.BrokerRepository;
import com.hotstock.repositories.StockRepository;
import com.hotstock.repositories.StockTradeRepository;


@Controller
public class LoginController {

	@Autowired
	private BrokerRepository brokerRepo;
	
	@Autowired
	private StockRepository stockRepo;
	
	@Autowired
	private StockTradeRepository stockTradeRepo;
	
	@RequestMapping(path="/login")
	public String login(){
		String forwardPage = "login";
		return forwardPage;
	}
	
	@RequestMapping(path="/submitLogin", method = RequestMethod.POST)
	public String login(@RequestParam("username") String brokerName, Model model){
		String forwardPage = "login";
		Broker broker = brokerRepo.findByUsername(brokerName);
		
		if (broker != null) {
			if (broker.getRole().equals("ADMIN")) {
				forwardPage = "adminOptions";
			}
			else {
				List<Stock> stockList = stockRepo.findAll();
				model.addAttribute("stockList", stockList);
				model.addAttribute("broker", broker);
				forwardPage = "stockList";
			}
		}
		
		return forwardPage;
	}
	
	@RequestMapping(path="/register")
	public String register(@RequestParam("name") String name, @RequestParam("username") String username,
			@RequestParam("role") String role){
		String forwardPage = "login";
		
		Broker broker = new Broker();
		broker.setName(name);
		broker.setUsername(username);
		broker.setRole(role);
		
		brokerRepo.save(broker);
		
		return forwardPage;
	}

}
