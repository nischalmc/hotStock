package com.hotstock.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotstock.models.Stock;

@Transactional
public interface StockRepository extends JpaRepository<Stock, Long>{
	
	Stock findByName(String stockName);
	
}
