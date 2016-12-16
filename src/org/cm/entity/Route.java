package org.cm.entity;

import java.io.Serializable;

public class Route implements Serializable {
	private Integer id;
	private String station_name;
	private String prev;
	private String next;
	private String direction;
	private Integer circuit_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public String getPrev() {
		return prev;
	}
	public void setPrev(String prev) {
		this.prev = prev;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Integer getCircuit_id() {
		return circuit_id;
	}
	public void setCircuit_id(Integer circuit_id) {
		this.circuit_id = circuit_id;
	}
	
	
	

}
