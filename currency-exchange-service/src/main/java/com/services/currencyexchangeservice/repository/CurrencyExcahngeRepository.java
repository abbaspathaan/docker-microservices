package com.services.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.services.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExcahngeRepository extends JpaRepository<CurrencyExchange, Long> {

	public CurrencyExchange findByFromAndTo(String from, String to);
}
