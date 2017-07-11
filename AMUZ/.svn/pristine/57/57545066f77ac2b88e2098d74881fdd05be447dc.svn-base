package com.oracle.amuz.model.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.oracle.amuz.model.javabean.Orders;
import com.oracle.amuz.model.javabean.Product;
import com.oracle.amuz.model.javabean.ProductInfo;

public class OrderDAOImp extends BaseDAOImp implements OrderDAO {

	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object obj) {
		Orders orders = (Orders) obj;
		Connection c = getConnection();
		System.out.println(orders.getOrder_id());
		try {
			c.setAutoCommit(false);
			PreparedStatement pre = c
					.prepareStatement("insert into ORDERS values(?,to_date(?,'yyyy-mm-dd hh24:mi:ss'),?,?)");
			pre.setLong(1, orders.getOrder_id().longValue());
			pre.setString(2, orders.getDate());
			pre.setInt(3, orders.getUser_id());
			pre.setInt(4, 0);
			boolean bl = pre.executeUpdate() > 0 ? true : false;
			if (bl) {
				PreparedStatement prep =null;
				for (Integer i : orders.getShopcarts().keySet()) {
					prep = c.prepareStatement("insert into ORDERSDETAIL values(ordersdetail_id_sequence.nextval,?,?,?,?,?)");
					prep.setInt(1, orders.getShopcarts().get(i).getProductId());
					prep.setInt(2, orders.getUser_id());
					prep.setLong(3, orders.getOrder_id().longValue());
					prep.setInt(4, orders.getAddress_id()); // orders.getAddress_id()
					prep.setInt(5, orders.getShopcarts().get(i).getNum());
					boolean bln = prep.executeUpdate() > 0 ? true : false;
					if (!bln) {
						c.rollback();
						return false;
					}
				}
					c.commit();
					disposeResource(c, prep, null);
					return true;
			} else {
				c.rollback();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				c.rollback();
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Orders> getAllOrdersByUserid(int user_id) {
		Connection c = getConnection();
		Orders orders = null;
		PreparedStatement pre;
		List<Orders> listOrders = null;
		try {
			pre = c.prepareStatement("select * from ORDERS where user_id=?");
			pre.setInt(1, user_id);
			ResultSet rs = pre.executeQuery();
			listOrders = new ArrayList<>();
			while (rs.next()) {
				orders = new Orders();
				Long val = rs.getLong("order_id");
				orders.setOrder_id(new BigInteger(val.toString()));
				orders.setDate(rs.getString("order_time"));
				orders.setUser_id(rs.getInt("user_id"));
				orders.setOrderstatus(rs.getInt("orderstatus"));
				listOrders.add(orders);
			}
			return listOrders;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return listOrders;
		}
	}

	@Override
	public HashMap<Long, List<ProductInfo>> getOrdersdetailByOrdersid(List<Orders> listOrders) {
		ArrayList<Orders> arraylistOrders = (ArrayList<Orders>) listOrders;
		Connection c = getConnection();
		ProductInfo productinfo = null;
		PreparedStatement pre = null;
		PreparedStatement pre2 = null;
		List<ProductInfo> productinfos =null ;
		HashMap<Long, List<ProductInfo>> hashmapproduct=new HashMap<>();
		for (Orders orders : arraylistOrders) {
			productinfos=new ArrayList<>();
			try {
				pre = c.prepareStatement("select * from ORDERSDETAIL where order_id=?");
				pre.setLong(1, orders.getOrder_id().longValue());
				ResultSet rs = pre.executeQuery();
				while (rs.next()) {
					int productid = rs.getInt("product_id");
					int num=rs.getInt("buy_num");
					pre2 = c.prepareStatement("select * from PRODUCT,DISCOUNT where PRODUCT.product_id=? and  DISCOUNT.product_id=?");
					pre2.setInt(1, productid);
					pre2.setInt(2, productid);
					ResultSet rs2 = pre2.executeQuery();
					while (rs2.next()) {
						productinfo = new ProductInfo();
						productinfo.setDiscount(rs2.getFloat("discount"));
						productinfo.setProductBrand(rs2.getString("product_Brand"));
						productinfo.setProductCost(rs2.getFloat("product_Cost"));
						productinfo.setProductDetail(rs2.getString("product_Detail"));
						productinfo.setProductForPeople(rs2.getString("product_Forpeople"));
						productinfo.setProductFrom(rs2.getString("product_From"));
						productinfo.setProductId(productid);
						productinfo.setProductImg1(rs2.getString("product_Img1"));
						productinfo.setProductImg2(rs2.getString("product_Img2"));
						productinfo.setProductImg3(rs2.getString("product_Img3"));
						productinfo.setProductName(rs2.getString("product_Name"));
						productinfo.setNum(num); 
						productinfos.add(productinfo);
					}
				}
				hashmapproduct.put(orders.getOrder_id().longValue(), productinfos);
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return hashmapproduct;
	}
}
