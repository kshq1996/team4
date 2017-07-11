package com.oracle.amuz.model.javabean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	public static void main(String[] args) {
	    Date date = new Date();
	    long times = date.getTime();//时间戳
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String dateString = formatter.format(date);
	    System.out.println(dateString);
	}

}
