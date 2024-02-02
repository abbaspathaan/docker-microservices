package com.services.currencyconversionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.services.currencyconversionservice.bean.CurrencyConversion;

//Below use when we don't have any load balancer and only one url to call another service
//@FeignClient(name = "currency-exchange", url = "localhost:8000") 
//Below config is for eureka will auto redirected using loadbalncer
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveValues(@PathVariable String from, @PathVariable String to);
}
