package com.limitservice.limitservice.bean;

public class Limit {

	private String minmumLimit;
	private String maximumLimit;

	public Limit(String minmumLimit, String maximumLimit) {
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

}
