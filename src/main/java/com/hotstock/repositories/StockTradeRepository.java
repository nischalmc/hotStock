package com.hotstock.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotstock.models.Broker;
import com.hotstock.models.Stock;
import com.hotstock.models.StockTrade;

@Transactional
public interface StockTradeRepository extends JpaRepository<StockTrade, Long>{
	StockTrade findByStock(Stock stock);
	
	StockTrade findByStockAndSeller(Stock stock, Broker seller);
	
	List<StockTrade> findByCreatedDateAfter(Date date);
}
