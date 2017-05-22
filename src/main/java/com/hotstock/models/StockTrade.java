package com.hotstock.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hotstock.enums.Status;

@Entity
@Table(name = "stock_trade")
public class StockTrade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	@JoinColumn(name="stock_id", foreignKey=@ForeignKey(name="stock_trade_fk1"))
	private Stock stock;
	
	@OneToOne(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	@JoinColumn(name="seller_id", foreignKey=@ForeignKey(name="stock_trade_fk2"))
	private Broker seller;
	
	@OneToOne(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	@JoinColumn(name="buyer_id", foreignKey=@ForeignKey(name="stock_trade_fk3"))
	private Broker buyer;
	
	private String quotePrice;
	
	private Date createdDate;
	
	private Date lastUpdatedDate;


	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public String getQuotePrice() {
		return quotePrice;
	}

	public void setQuotePrice(String quotePrice) {
		this.quotePrice = quotePrice;
	}

	public Broker getSeller() {
		return seller;
	}

	public void setSeller(Broker seller) {
		this.seller = seller;
	}

	public Broker getBuyer() {
		return buyer;
	}

	public void setBuyer(Broker buyer) {
		this.buyer = buyer;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

}
