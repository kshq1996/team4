package admin.com.oracle.amuz.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BaseDaoImp implements BaseDao {
	ResourceBundle p=ResourceBundle.getBundle("database");

	public final Connection getConnection(){
		Connection connection=null;
		try {
			Class.forName(p.getString("driver"));
			connection=DriverManager.getConnection(p.getString("url"), p.getString("username"), p.getString("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public void disposeResource(Connection c,PreparedStatement pre,ResultSet rs) throws SQLException{
		if(rs!=null)
			rs.close();
		if(pre!=null)
			pre.close();
		if(c!=null)
			c.close();
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}

}
