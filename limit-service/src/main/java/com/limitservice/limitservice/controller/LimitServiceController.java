package com.limitservice.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limitservice.limitservice.bean.Limit;
import com.limitservice.limitservice.config.LimitConfiguration;

@RestController
public class LimitServiceController {

	@Autowired
	private LimitConfiguration configuration;

	@GetMapping(path = "/limit-service")
	public Limit getLimit() {
		return new Limit(configuration.getMinmumLimit(), configuration.getMaximumLimit());
	}

}
