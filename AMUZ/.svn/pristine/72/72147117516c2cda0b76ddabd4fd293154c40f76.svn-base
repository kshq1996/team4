package com.oracle.amuz.model.dao;

import com.oracle.amuz.model.javabean.User;

public interface UserDAO extends BaseDAO{
	public User login(String username,String password);
	public boolean add(String username,String password);
	public boolean searchUserByUsername(String username);
	public boolean deleteAddress(int address_id,int user_id);
	public boolean insertAddress(int user_id,Object obj);
}
