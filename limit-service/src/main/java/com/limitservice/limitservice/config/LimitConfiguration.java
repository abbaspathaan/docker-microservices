package com.limitservice.limitservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit-service")
public class LimitConfiguration {

	private String minmumLimit;
	private String maximumLimit;

	public LimitConfiguration() {

	}

	public LimitConfiguration(String minmumLimit, String maximumLimit) {
		super();
		this.minmumLimit = minmumLimit;
		this.maximumLimit = maximumLimit;
	}

	public String getMinmumLimit() {
		return minmumLimit;
	}

	public void setMinmumLimit(String minmumLimit) {
		this.minmumLimit = minmumLimit;
	}

	public String getMaximumLimit() {
		return maximumLimit;
	}

	public void setMaximumLimit(String maximumLimit) {
		this.maximumLimit = maximumLimit;
	}

	@Override
	public String toString() {
		return "LimitConfiguration [minmumLimit=" + minmumLimit + ", maximumLimit=" + maximumLimit + "]";
	}

}
