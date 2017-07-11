package com.oracle.amuz.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public abstract class BaseDAOImp implements BaseDAO {

	ResourceBundle p=ResourceBundle.getBundle("database");

	public final Connection getConnection(){
		Connection c=null;
		try {
			Class.forName(p.getString("driver"));
			c=DriverManager.getConnection(p.getString("url"), p.getString("username"),p.getString("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public void disposeResource(Connection c,PreparedStatement pre,ResultSet rs) throws SQLException{
		if(rs!=null)
			rs.close();
		if(pre!=null)
			pre.close();
		if(c!=null)
			c.close();
	}
	
	public void statementclose(Connection c,Statement s,ResultSet rs) throws SQLException{
		if(rs!=null)
			rs.close();
		if(s!=null)
			s.close();
		if(c!=null)
			c.close();
		
	}
}
