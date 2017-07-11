package com.oracle.amuz.model.javabean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class Orders implements Serializable{
	private BigInteger order_id;
	private String date;
	private int user_id;
	private int orderstatus;
	private int address_id;
	private HashMap<Integer, ProductInfo> shopcarts;
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public HashMap<Integer, ProductInfo> getShopcarts() {
		return shopcarts;
	}
	public void setShopcarts(HashMap<Integer, ProductInfo> shopcarts) {
		this.shopcarts = shopcarts;
	}
	public BigInteger getOrder_id() {
		return order_id;
	}
	public void setOrder_id(BigInteger order_id) {
		this.order_id = order_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", date=" + date + ", user_id=" + user_id + ", orderstatus="
				+ orderstatus + ", address_id=" + address_id + ", shopcarts=" + shopcarts + "]";
	}
	public Orders() {
		super();
	}
	public Orders(BigInteger order_id, String date, int user_id, int orderstatus, int address_id,
			HashMap<Integer, ProductInfo> shopcarts) {
		super();
		this.order_id = order_id;
		this.date = date;
		this.user_id = user_id;
		this.orderstatus = orderstatus;
		this.address_id = address_id;
		this.shopcarts = shopcarts;
	}
	
	
}
