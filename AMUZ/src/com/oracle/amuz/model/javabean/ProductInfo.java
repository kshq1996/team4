package com.oracle.amuz.model.javabean;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductInfo implements Serializable {
	private int productId;
	private String productName;
	private String productDetail;
	private float productCost;
	private String productBrand;
	private String productFrom;
	private String productImg1;
	private String productImg2;
	private String productImg3;
	private String productForPeople;

	private int soldnum;
	private int residuenum;

	private Combo combo = new Combo();
	private Type type = new Type();
	private ArrayList<Appraise> appraiselist = new ArrayList<>();

	public ArrayList<Appraise> getAppraiselist() {
		return appraiselist;
	}

	public void setAppraiselist(ArrayList<Appraise> appraiselist) {
		this.appraiselist = appraiselist;
	}

	public int getSoldnum() {
		return soldnum;
	}

	public void setSoldnum(int soldnum) {
		this.soldnum = soldnum;
	}

	public int getResiduenum() {
		return residuenum;
	}

	public void setResiduenum(int residuenum) {
		this.residuenum = residuenum;
	}

	public Combo getCombo() {
		return combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	private float discount;

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public float getProductCost() {
		return productCost;
	}

	public void setProductCost(float productCost) {
		this.productCost = productCost;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductFrom() {
		return productFrom;
	}

	public void setProductFrom(String productFrom) {
		this.productFrom = productFrom;
	}

	public String getProductImg1() {
		return productImg1;
	}

	public void setProductImg1(String productImg1) {
		this.productImg1 = productImg1;
	}

	public String getProductImg2() {
		return productImg2;
	}

	public void setProductImg2(String productImg2) {
		this.productImg2 = productImg2;
	}

	public String getProductImg3() {
		return productImg3;
	}

	public void setProductImg3(String productImg3) {
		this.productImg3 = productImg3;
	}

	public String getProductForPeople() {
		return productForPeople;
	}

	public void setProductForPeople(String productForPeople) {
		this.productForPeople = productForPeople;
	}

	public ProductInfo(int productId, String productName, String productDetail, float productCost, String productBrand,
			int productTypeId, String productFrom, String productImg1, String productImg2, String productImg3,
			String productForPeople) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDetail = productDetail;
		this.productCost = productCost;
		this.productBrand = productBrand;
		this.productFrom = productFrom;
		this.productImg1 = productImg1;
		this.productImg2 = productImg2;
		this.productImg3 = productImg3;
		this.productForPeople = productForPeople;
	}

	public ProductInfo() {
		super();
	}

	@Override
	public String toString() {
		return "ProductInfo [productId=" + productId + ", productName=" + productName + ", productDetail="
				+ productDetail + ", productCost=" + productCost + ", productBrand=" + productBrand + ", productFrom="
				+ productFrom + ", productImg1=" + productImg1 + ", productImg2=" + productImg2 + ", productImg3="
				+ productImg3 + ", productForPeople=" + productForPeople + ", soldnum=" + soldnum + ", residuenum="
				+ residuenum + ", combo=" + combo + ", type=" + type + ", appraiselist=" + appraiselist + ", discount="
				+ discount + ", num=" + num + "]";
	}

}
