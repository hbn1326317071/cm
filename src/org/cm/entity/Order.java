package org.cm.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
	private Integer id;//订单的id
	private String from_station;
	private String to_station;
	private Integer car_id;//车的id；
	private Long startTime;//开始时间
	private Long endtime;//结束时间
	private double fee;//乘坐本次公交所花费的钱
	private Integer current_id; //当前线路id
	private String pay_state;//支付的状态
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFrom_station() {
		return from_station;
	}
	public void setFrom_station(String from_station) {
		this.from_station = from_station;
	}
	public String getTo_station() {
		return to_station;
	}
	public void setTo_station(String to_station) {
		this.to_station = to_station;
	}
	public Integer getCar_id() {
		return car_id;
	}
	public void setCar_id(Integer car_id) {
		this.car_id = car_id;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndtime() {
		return endtime;
	}
	public void setEndtime(Long endtime) {
		this.endtime = endtime;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public Integer getCurrent_id() {
		return current_id;
	}
	public void setCurrent_id(Integer current_id) {
		this.current_id = current_id;
	}
	public String getPay_state() {
		return pay_state;
	}
	public void setPay_state(String pay_state) {
		this.pay_state = pay_state;
	}
	

}
