package com.services.currencyconversionservice.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.currencyconversionservice.bean.CurrencyConversion;
import com.services.currencyconversionservice.proxy.CurrencyExchangeProxy;

@Service
public class CurrencyConversionServiceUsingFeign {

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	public CurrencyConversion calculateCurrencyConversion(String from, String to, BigDecimal quantity) {
		CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveValues(from, to);
		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));
		return currencyConversion;
	}
}
