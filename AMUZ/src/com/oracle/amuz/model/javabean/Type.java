package com.oracle.amuz.model.javabean;

import java.io.Serializable;

public class Type implements Serializable {
	private String firsttype;
	private String secondtype;
	private String thirdtype;
	private String forthtype;
	private String fifthtype;
	public String getFirsttype() {
		return firsttype;
	}
	public void setFirsttype(String firsttype) {
		this.firsttype = firsttype;
	}
	public String getSecondtype() {
		return secondtype;
	}
	public void setSecondtype(String secondtype) {
		this.secondtype = secondtype;
	}
	public String getThirdtype() {
		return thirdtype;
	}
	public void setThirdtype(String thirdtype) {
		this.thirdtype = thirdtype;
	}
	public String getForthtype() {
		return forthtype;
	}
	public void setForthtype(String forthtype) {
		this.forthtype = forthtype;
	}
	public String getFifthtype() {
		return fifthtype;
	}
	public void setFifthtype(String fifthtype) {
		this.fifthtype = fifthtype;
	}
}
