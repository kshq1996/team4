package com.oracle.amuz.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class EmailCodeDAOImp extends BaseDAOImp implements EmailCodeDAO {

	public boolean add(Object obj) {
		return false;
	}

	public boolean update(Object obj) {
		return false;
	}

	public boolean delete(Object obj) {
		return false;
	}

	public void list() {

	}

	@Override
	public boolean changeEmailStatus(int id, String emailaddress) {
		Connection c=getConnection();
		try {
			PreparedStatement pre=c.prepareStatement("update USERTABLE  set emailstatus=1,email=? where user_id=?");
			pre.setString(1, emailaddress);
			pre.setInt(2, id);
			boolean result=pre.executeUpdate()==0?false:true;
			disposeResource(c, pre, null);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}



}
