package ;

import java.io.Serializable;

/**
 * 产品表 儌僨儖僋儔僗.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Product implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 产品id. */
	private Integer productId;

	/** 产品名称. */
	private String productName;

	/** 产品介绍. */
	private String productDetail;

	/** 产品价格. */
	private Float productCost;

	/** 产品品牌. */
	private String productBrand;

	/** 产品类型id. */
	private Integer productTypeId;

	/** 产品产地. */
	private String productFrom;

	/** 产品图片1. */
	private String productImg1;

	/** 产品图片2. */
	private String productImg2;

	/** 产品图片3. */
	private String productImg3;

	/** 产品评价. */
	private Integer productAppraise;

	/** 用户对商品的评价. */
	private Integer productAppraiseId;

	/** 产品适合人群. */
	private String productForpeople;

	/**
	 * 僐儞僗僩儔僋僞.
	 */
	public Product() {
	}

	/**
	 * 产品id 傪愝掕偟傑偡.
	 * 
	 * @param productId
	 *            产品id
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * 产品id 傪庢摼偟傑偡.
	 * 
	 * @return 产品id
	 */
	public Integer getProductId() {
		return this.productId;
	}

	/**
	 * 产品名称 傪愝掕偟傑偡.
	 * 
	 * @param productName
	 *            产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * 产品名称 傪庢摼偟傑偡.
	 * 
	 * @return 产品名称
	 */
	public String getProductName() {
		return this.productName;
	}

	/**
	 * 产品介绍 傪愝掕偟傑偡.
	 * 
	 * @param productDetail
	 *            产品介绍
	 */
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	/**
	 * 产品介绍 傪庢摼偟傑偡.
	 * 
	 * @return 产品介绍
	 */
	public String getProductDetail() {
		return this.productDetail;
	}

	/**
	 * 产品价格 傪愝掕偟傑偡.
	 * 
	 * @param productCost
	 *            产品价格
	 */
	public void setProductCost(Float productCost) {
		this.productCost = productCost;
	}

	/**
	 * 产品价格 傪庢摼偟傑偡.
	 * 
	 * @return 产品价格
	 */
	public Float getProductCost() {
		return this.productCost;
	}

	/**
	 * 产品品牌 傪愝掕偟傑偡.
	 * 
	 * @param productBrand
	 *            产品品牌
	 */
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	/**
	 * 产品品牌 傪庢摼偟傑偡.
	 * 
	 * @return 产品品牌
	 */
	public String getProductBrand() {
		return this.productBrand;
	}

	/**
	 * 产品类型id 傪愝掕偟傑偡.
	 * 
	 * @param productTypeId
	 *            产品类型id
	 */
	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}

	/**
	 * 产品类型id 傪庢摼偟傑偡.
	 * 
	 * @return 产品类型id
	 */
	public Integer getProductTypeId() {
		return this.productTypeId;
	}

	/**
	 * 产品产地 傪愝掕偟傑偡.
	 * 
	 * @param productFrom
	 *            产品产地
	 */
	public void setProductFrom(String productFrom) {
		this.productFrom = productFrom;
	}

	/**
	 * 产品产地 傪庢摼偟傑偡.
	 * 
	 * @return 产品产地
	 */
	public String getProductFrom() {
		return this.productFrom;
	}

	/**
	 * 产品图片1 傪愝掕偟傑偡.
	 * 
	 * @param productImg1
	 *            产品图片1
	 */
	public void setProductImg1(String productImg1) {
		this.productImg1 = productImg1;
	}

	/**
	 * 产品图片1 傪庢摼偟傑偡.
	 * 
	 * @return 产品图片1
	 */
	public String getProductImg1() {
		return this.productImg1;
	}

	/**
	 * 产品图片2 傪愝掕偟傑偡.
	 * 
	 * @param productImg2
	 *            产品图片2
	 */
	public void setProductImg2(String productImg2) {
		this.productImg2 = productImg2;
	}

	/**
	 * 产品图片2 傪庢摼偟傑偡.
	 * 
	 * @return 产品图片2
	 */
	public String getProductImg2() {
		return this.productImg2;
	}

	/**
	 * 产品图片3 傪愝掕偟傑偡.
	 * 
	 * @param productImg3
	 *            产品图片3
	 */
	public void setProductImg3(String productImg3) {
		this.productImg3 = productImg3;
	}

	/**
	 * 产品图片3 傪庢摼偟傑偡.
	 * 
	 * @return 产品图片3
	 */
	public String getProductImg3() {
		return this.productImg3;
	}

	/**
	 * 产品评价 傪愝掕偟傑偡.
	 * 
	 * @param productAppraise
	 *            产品评价
	 */
	public void setProductAppraise(Integer productAppraise) {
		this.productAppraise = productAppraise;
	}

	/**
	 * 产品评价 傪庢摼偟傑偡.
	 * 
	 * @return 产品评价
	 */
	public Integer getProductAppraise() {
		return this.productAppraise;
	}

	/**
	 * 用户对商品的评价 傪愝掕偟傑偡.
	 * 
	 * @param productAppraiseId
	 *            用户对商品的评价
	 */
	public void setProductAppraiseId(Integer productAppraiseId) {
		this.productAppraiseId = productAppraiseId;
	}

	/**
	 * 用户对商品的评价 傪庢摼偟傑偡.
	 * 
	 * @return 用户对商品的评价
	 */
	public Integer getProductAppraiseId() {
		return this.productAppraiseId;
	}

	/**
	 * 产品适合人群 傪愝掕偟傑偡.
	 * 
	 * @param productForpeople
	 *            产品适合人群
	 */
	public void setProductForpeople(String productForpeople) {
		this.productForpeople = productForpeople;
	}

	/**
	 * 产品适合人群 傪庢摼偟傑偡.
	 * 
	 * @return 产品适合人群
	 */
	public String getProductForpeople() {
		return this.productForpeople;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null) {
				return false;
			}
		} else if (!productId.equals(other.productId)) {
			return false;
		}

		return true;
	}

}