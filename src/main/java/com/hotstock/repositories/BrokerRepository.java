package com.hotstock.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotstock.models.Broker;

@Transactional
public interface BrokerRepository extends JpaRepository<Broker, Long>{
	
	Broker findByUsername(String username);
	
	List<Broker> findByRole(String role);
	
	Broker findByname(String name);
}
