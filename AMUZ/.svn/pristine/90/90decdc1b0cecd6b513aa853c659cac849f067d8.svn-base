package com.oracle.amuz.model.dao;

import java.util.HashMap;
import java.util.List;

import com.oracle.amuz.model.javabean.Orders;
import com.oracle.amuz.model.javabean.Product;
import com.oracle.amuz.model.javabean.ProductInfo;

public interface OrderDAO extends BaseDAO {
	public List<Orders> getAllOrdersByUserid(int user_id);
	public HashMap<Long, List<ProductInfo>> getOrdersdetailByOrdersid(List<Orders> listOrders);
	public boolean update(Object obj);
}
