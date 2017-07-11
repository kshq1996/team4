package com.oracle.amuz.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oracle.amuz.model.javabean.Appraise;
import com.oracle.amuz.model.javabean.Product;
import com.oracle.amuz.model.javabean.ProductInfo;
import com.oracle.amuz.model.javabean.User;

public class ProductDAOImp extends BaseDAOImp implements ProductDAD {

	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
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
	public List<Product> listAllByProductType(String typeName) {
		return null;
	}

	@Override
	public List<Product> listAllByProductName(String productName) {
		List<Product> plList=null;
		Connection connection=getConnection();
		Product p=null;
		String $productName="'%"+productName+"%'";
		int id=0;
		try {
			Statement statement  = connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from PRODUCT where product_name like "+$productName);
			plList=	new ArrayList<>();
			while(rs.next()){
				p=new Product();
				id=rs.getInt("product_id");
				p.setProductId(rs.getInt("product_id"));
				p.setProductName(rs.getString("product_name"));
				p.setProductDetail(rs.getString("product_detail"));
				p.setProductCost(rs.getFloat("product_cost"));
				p.setProductBrand(rs.getString("product_brand"));
				p.setProductFrom(rs.getString("product_from"));
				p.setProductImg1(rs.getString("product_img1"));
				p.setProductImg2(rs.getString("product_img2"));
				p.setProductImg3(rs.getString("product_img3"));
				p.setProductForpeople(rs.getString("product_forpeople"));
				plList.add(p);
			}
			statementclose(connection, statement, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plList;
	}

	@Override
	public ProductInfo getProductDetailInfoById(int id) {
		ProductInfo pInfo=null;
		Connection connection=getConnection();
		Appraise appraise=null;
		ArrayList<Appraise> appraiselist=null;
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("select * from PRODUCT,DISCOUNT,SELL,COMBO,TYPETABLE where PRODUCT.PRODUCT_ID=? and DISCOUNT.PRODUCT_ID=? and SELL.PRODUCT_ID=? and COMBO.PRODUCT_ID=? and TYPETABLE.TYPE_ID=?");
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, id);
			preparedStatement.setInt(3, id);
			preparedStatement.setInt(4, id);
			preparedStatement.setInt(5, id);
			ResultSet RS=preparedStatement.executeQuery();
			if (RS.next()) {
				pInfo=new ProductInfo();
				pInfo.setProductId(RS.getInt("product_id"));
				pInfo.setProductName(RS.getString("product_name"));
				pInfo.setProductDetail(RS.getString("product_detail"));
				pInfo.setProductCost(RS.getInt("product_cost"));
				pInfo.setProductBrand(RS.getString("product_brand"));
				pInfo.setProductFrom(RS.getString("product_from"));
				pInfo.setProductImg1(RS.getString("product_img1"));
				pInfo.setProductImg2(RS.getString("product_img2"));
				pInfo.setProductImg3(RS.getString("product_img3"));
				pInfo.setProductForPeople(RS.getString("product_forpeople"));
				pInfo.setDiscount(RS.getFloat("discount"));
				pInfo.setSoldnum(RS.getInt("soldnum"));
				pInfo.setResiduenum(RS.getInt("residuenum"));
				pInfo.getCombo().setFirstcombo(RS.getString("firstcombo"));
				pInfo.getCombo().setSecondcombo(RS.getString("secondcombo"));
				pInfo.getCombo().setThirdcombo(RS.getString("thirdcombo"));
				pInfo.getCombo().setForthcombo(RS.getString("forthcombo"));
				pInfo.getCombo().setFifthcombo(RS.getString("fifthcombo"));
				pInfo.getType().setFirsttype(RS.getString("firsttype"));
				pInfo.getType().setSecondtype(RS.getString("secondtype"));
				pInfo.getType().setThirdtype(RS.getString("thirdtype"));
				pInfo.getType().setForthtype(RS.getString("forthtype"));
				pInfo.getType().setFifthtype(RS.getString("fifthtype"));
				PreparedStatement pre = connection.prepareStatement("select * from APPRAISE where product_id=?");
				pre.setInt(1, id);
				ResultSet rs2 = pre.executeQuery();
				appraise = new Appraise();
				appraiselist = new ArrayList<>();
				UserDAOImp daoImp=new UserDAOImp();
				if (rs2.next()) {
					appraise.setAppraisedetail(rs2.getString("appraisedetail"));
					appraise.setAppraisescore(rs2.getInt("appraisescore"));
					appraise.setTime(rs2.getString("appraisetime"));
					appraise.setUserid(rs2.getInt("user_id"));
					User user=daoImp.getUserById(id);
					appraise.setTruename(user.getTruename());
					appraiselist.add(appraise);
				}
				pInfo.setAppraiselist(appraiselist);
				disposeResource(connection, pre, RS);
				disposeResource(connection, pre, rs2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pInfo;
	}

	@Override
	public List<Product> listProductByPage(int page, int count,String productName) {
		String $productName="%"+productName+"%";
		Connection  c=getConnection();
		List<Product> lp=null;
		Product p=null;
		ResultSet rs=null;
		try {
			PreparedStatement pre=c.prepareStatement("SELECT * FROM(SELECT A.*, ROWNUM RN  FROM (select * from product where product_name like ? ) A) WHERE RN BETWEEN ? AND ? ");
			pre.setString(1, $productName);
			pre.setInt(2, (page-1)*count+1);
			pre.setInt(3, page*count);
			rs=pre.executeQuery();
			lp=new ArrayList<>();
			while(rs.next()){
				p=new Product();
				p.setProductId(rs.getInt("product_id"));
				p.setProductCost(rs.getFloat("product_cost"));
				p.setProductName(rs.getString("product_Name"));
				p.setProductImg1(rs.getString("product_Img1"));
				lp.add(p);
			}
			return lp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getAllProductCount(String key) {
		String $key="%"+key+"%";
		Connection c=getConnection();
		try {
			PreparedStatement pre=c.prepareStatement("select count(*) from product where product_name like ?");
			pre.setString(1, $key);
			ResultSet rs=pre.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			disposeResource(c, pre, rs);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
