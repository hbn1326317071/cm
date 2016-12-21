package org.cm.entity;

public class Car {
	private Integer id;//车的id
	private String direction;
	private Integer running_type;//
	private Integer current_id;//线路id
	private Long departure_time;
	private String current_location;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Integer getRunning_type() {
		return running_type;
	}
	public void setRunning_type(Integer running_type) {
		this.running_type = running_type;
	}
	public Integer getCurrent_id() {
		return current_id;
	}
	public void setCurrent_id(Integer current_id) {
		this.current_id = current_id;
	}
	public String getCurrent_location() {
		return current_location;
	}
	public void setCurrent_location(String current_location) {
		this.current_location = current_location;
	}
	public Long getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(Long departure_time) {
		this.departure_time = departure_time;
	}
	
	
}
