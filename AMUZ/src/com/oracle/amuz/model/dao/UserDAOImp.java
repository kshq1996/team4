package com.oracle.amuz.model.dao;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.oracle.amuz.model.dao.BaseDAOImp;
import com.oracle.amuz.model.javabean.Address;
import com.oracle.amuz.model.javabean.Orders;
import com.oracle.amuz.model.javabean.ProductInfo;
import com.oracle.amuz.model.javabean.User;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xpath.internal.operations.Or;

public  class UserDAOImp extends BaseDAOImp implements UserDAO {

	public boolean add(String username,String password) {
		Connection c=getConnection();
		try {
			PreparedStatement pre =c.prepareStatement("insert into USERTABLE values(user_id_sequence.nextval,?,?,?,?,?,?,?,0,null,0)");
			pre.setString(1, username);
			pre.setString(2, password);
			pre.setString(3, "M");
			pre.setString(4, "用户");
			pre.setInt(5, 1);
			pre.setString(6, "images/no-img_mid_.jpg");
			pre.setString(7, "T");
			boolean isOk=pre.executeUpdate()>0?true:false;
			System.out.println("注册成功！");
			disposeResource(c, pre, null);
			return isOk;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	return false;
	}

	@Override
	public boolean update(Object obj) {
		User user=(User)obj;
		Connection c=getConnection();
		try {
			PreparedStatement pre=c.prepareStatement("update USERTABLE  set truename=?,sex=?,email=?,emailstatus=0  where user_id=?");
			pre.setString(1, user.getTruename());
			
			pre.setString(2, user.getSex());
			pre.setString(3, user.getEmail());
			pre.setInt(4, user.getUser_id());
			boolean bl=pre.executeUpdate()==0?false:true;
			disposeResource(c, pre, null);
			return bl;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
	}

	@Override
	public User login(String username, String password) {
		User user=null;
		Connection c=getConnection();
		PreparedStatement pre=null;
		try {
			pre=c.prepareStatement("select * from USERTABLE where username=? and password=?");
			pre.setString(1, username);
			pre.setString(2, password);
			ResultSet rs=pre.executeQuery();
			if(rs.next()){
				user=new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setTruename(rs.getString("truename"));
				user.setAddress_id(rs.getInt("address_id"));
				user.setHeadimg(rs.getString("headimg"));
				user.setStatus(rs.getString("status"));
				user.setEmail(rs.getString("email"));
				user.setEmailstatus(rs.getString("emailstatus"));
			}
			disposeResource(c, pre, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public User getUserById(int id) {
		User user=null;
		Connection c=getConnection();
		PreparedStatement pre=null;
		try {
			pre=c.prepareStatement("select * from USERTABLE where user_id=?");
			pre.setInt(1, id);
			ResultSet rs=pre.executeQuery();
			if(rs.next()){
				user=new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setTruename(rs.getString("truename"));
				user.setAddress_id(rs.getInt("address_id"));
				user.setHeadimg(rs.getString("headimg"));
				user.setStatus(rs.getString("status"));
			}
			disposeResource(c, pre, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean add(Object obj) {
		return true;
	}
	
	public ArrayList<Address> getAddressById(int id){
		Connection c=getConnection();
		PreparedStatement pre =null;
		Address address=null;
		ArrayList<Address> addresses=null;
		try {
			pre=c.prepareStatement("select * from ADDRESS where user_id=?");
			pre.setInt(1, id);
			ResultSet rs=pre.executeQuery();
			addresses=new ArrayList<>();
			while(rs.next()){
				address=new Address();
				address.setAddress_id(rs.getInt("address_id"));
				address.setCity(rs.getString("city"));
				address.setProvince(rs.getString("province"));
				address.setState(rs.getString("state"));
				address.setStreet(rs.getString("street"));
				address.setAddressdetail(rs.getString("addressdetail"));
				address.setUser_id(rs.getInt("user_id"));
				address.setPhonenum(rs.getInt("phonenum"));
				address.setName(rs.getString("name"));
				addresses.add(address);
			}
			disposeResource(c, pre, rs);
			return addresses;
		} catch (SQLException e) {
			e.printStackTrace();
			return addresses;
		}
	}

	@Override
	public boolean searchUserByUsername(String username) {
		Connection c=getConnection();
		try {
			PreparedStatement pre=c.prepareStatement("select * from USERTABLE where username=?");
			pre.setString(1, username);
			ResultSet rs=pre.executeQuery();
			if(rs.next()){
				disposeResource(c, pre, rs);
				return false;
			}else{
				disposeResource(c, pre, rs);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
	}
	
	public boolean deleteAddress(int address_id,int user_id){
		Connection c=getConnection();
		try {
			PreparedStatement pre=c.prepareStatement("delete from ADDRESS where user_id=? and address_id=?");
			pre.setInt(1, user_id);
			pre.setInt(2, address_id);
			boolean bl=pre.executeUpdate()==0?false:true;
			disposeResource(c, pre, null);
			return bl;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean insertAddress(int user_id, Object obj) {
		Address address=(Address)obj;
		Connection c=getConnection();
		try {
			PreparedStatement pre=c.prepareStatement("insert into ADDRESS values(address_id_sequence.nextval,?,?,?,?,?,?,?,?) ");
			pre.setString(1, address.getCity());
			pre.setString(2, address.getProvince());
			pre.setString(3, address.getState());
			pre.setString(4, address.getStreet());
			pre.setString(5, address.getAddressdetail());
			pre.setInt(6, user_id);
			pre.setInt(7, address.getPhonenum());
			pre.setString(8, address.getName());
			boolean bl=pre.executeUpdate()>0?true:false;
			disposeResource(c, pre, null);
			return bl;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
