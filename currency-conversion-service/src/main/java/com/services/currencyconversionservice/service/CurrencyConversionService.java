package com.services.currencyconversionservice.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.services.currencyconversionservice.bean.CurrencyConversion;

@Service
public class CurrencyConversionService {

	@Autowired
	private RestTemplate restTemplate;

	public CurrencyConversion calculateCurrencyConversion(String from, String to, BigDecimal quantity) {
		CurrencyConversion currencyConversion = getCurrencyExchange(from, to);
		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));
		return currencyConversion;
	}

	private CurrencyConversion getCurrencyExchange(String from, String to) {
		Map<String, String> requestParam = new HashMap<>();
		requestParam.put("from", from);
		requestParam.put("to", to);
		CurrencyConversion currencyConversion = restTemplate.getForObject(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, requestParam);
		if (currencyConversion == null) {
			throw new RuntimeException("Error while calling currency exchange service");
		}
		return currencyConversion;
	}

}
