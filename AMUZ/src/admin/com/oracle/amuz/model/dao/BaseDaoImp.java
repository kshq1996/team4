package admin.com.oracle.amuz.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
