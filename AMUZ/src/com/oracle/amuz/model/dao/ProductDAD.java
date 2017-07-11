package com.oracle.amuz.model.dao;

import java.util.List;

import com.oracle.amuz.model.javabean.Product;
import com.oracle.amuz.model.javabean.ProductInfo;

interface  ProductDAD extends BaseDAO{
	public List<Product> listAllByProductType(String typeName);
	public List<Product> listAllByProductName(String productName);
	public List<Product> listProductByPage(int page,int count,String productName);
	
	public ProductInfo getProductDetailInfoById(int id);
	public int getAllProductCount(String key);
	
}
