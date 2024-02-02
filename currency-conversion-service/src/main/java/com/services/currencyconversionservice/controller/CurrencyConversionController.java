package com.services.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.services.currencyconversionservice.bean.CurrencyConversion;
import com.services.currencyconversionservice.service.CurrencyConversionService;

@RestController
public class CurrencyConversionController {

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyConversionService conversionService;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveValues(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversion currencyExchange = conversionService.calculateCurrencyConversion(from, to, quantity);
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
	}

	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveValuesUsingFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversion currencyExchange = conversionService.calculateCurrencyConversion(from, to, quantity);
		currencyExchange.setEnvironment(environment.getProperty("local.server.port") + " Feign");
		return currencyExchange;
	}
}
