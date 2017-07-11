package ;

import java.io.Serializable;

/**
 * 评价表 儌僨儖僋儔僗.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Appraise implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 评价ID. */
	private Integer productAppriseId;

	/** 产品id. */
	private Integer productId;

	/**
	 * 僐儞僗僩儔僋僞.
	 */
	public Appraise() {
	}

	/**
	 * 评价ID 傪愝掕偟傑偡.
	 * 
	 * @param productAppriseId
	 *            评价ID
	 */
	public void setProductAppriseId(Integer productAppriseId) {
		this.productAppriseId = productAppriseId;
	}

	/**
	 * 评价ID 傪庢摼偟傑偡.
	 * 
	 * @return 评价ID
	 */
	public Integer getProductAppriseId() {
		return this.productAppriseId;
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
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productAppriseId == null) ? 0 : productAppriseId.hashCode());

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
		Appraise other = (Appraise) obj;
		if (productAppriseId == null) {
			if (other.productAppriseId != null) {
				return false;
			}
		} else if (!productAppriseId.equals(other.productAppriseId)) {
			return false;
		}

		return true;
	}

}
