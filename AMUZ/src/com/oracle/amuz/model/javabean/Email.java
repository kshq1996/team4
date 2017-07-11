package com.oracle.amuz.model.javabean;

import java.io.Serializable;

public class Email implements Serializable{
	private static final String myEmailAccount = "didisend_test@163.com";
	private static final String myEmailPassword = "Archer666";
	private static final String myEmailSMTPHost = "smtp.163.com";
	
	public static String getMyemailaccount() {
		return myEmailAccount;
	}
	public static String getMyemailpassword() {
		return myEmailPassword;
	}
	public static String getMyemailsmtphost() {
		return myEmailSMTPHost;
	}
	
	
}
