package org.cm.entity;

import java.io.Serializable;

public class CountsOrder implements Serializable{
	private int counts;
	private String from_station;
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public String getFrom_station() {
		return from_station;
	}
	public void setFrom_station(String form_station) {
		this.from_station = form_station;
	}
	
}
