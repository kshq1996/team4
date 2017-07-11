package ;

import java.io.Serializable;

/**
 * 用户表 儌僨儖僋儔僗.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Usertable implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 用户编号. */
	private Integer userId;

	/** 用户名. */
	private String username;

	/** 密码. */
	private String password;

	/** 性别. */
	private Boolean sex;

	/** 真实姓名. */
	private String truename;

	/** 收货地址编号. */
	private Integer addressId;

	/** 头像. */
	private String headimg;

	/** 状态. */
	private Boolean status;

	/**
	 * 僐儞僗僩儔僋僞.
	 */
	public Usertable() {
	}

	/**
	 * 用户编号 傪愝掕偟傑偡.
	 * 
	 * @param userId
	 *            用户编号
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 用户编号 傪庢摼偟傑偡.
	 * 
	 * @return 用户编号
	 */
	public Integer getUserId() {
		return this.userId;
	}

	/**
	 * 用户名 傪愝掕偟傑偡.
	 * 
	 * @param username
	 *            用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 用户名 傪庢摼偟傑偡.
	 * 
	 * @return 用户名
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * 密码 傪愝掕偟傑偡.
	 * 
	 * @param password
	 *            密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 密码 傪庢摼偟傑偡.
	 * 
	 * @return 密码
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * 性别 傪愝掕偟傑偡.
	 * 
	 * @param sex
	 *            性别
	 */
	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	/**
	 * 性别 傪庢摼偟傑偡.
	 * 
	 * @return 性别
	 */
	public Boolean getSex() {
		return this.sex;
	}

	/**
	 * 真实姓名 傪愝掕偟傑偡.
	 * 
	 * @param truename
	 *            真实姓名
	 */
	public void setTruename(String truename) {
		this.truename = truename;
	}

	/**
	 * 真实姓名 傪庢摼偟傑偡.
	 * 
	 * @return 真实姓名
	 */
	public String getTruename() {
		return this.truename;
	}

	/**
	 * 收货地址编号 傪愝掕偟傑偡.
	 * 
	 * @param addressId
	 *            收货地址编号
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	/**
	 * 收货地址编号 傪庢摼偟傑偡.
	 * 
	 * @return 收货地址编号
	 */
	public Integer getAddressId() {
		return this.addressId;
	}

	/**
	 * 头像 傪愝掕偟傑偡.
	 * 
	 * @param headimg
	 *            头像
	 */
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	/**
	 * 头像 傪庢摼偟傑偡.
	 * 
	 * @return 头像
	 */
	public String getHeadimg() {
		return this.headimg;
	}

	/**
	 * 状态 傪愝掕偟傑偡.
	 * 
	 * @param status
	 *            状态
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * 状态 傪庢摼偟傑偡.
	 * 
	 * @return 状态
	 */
	public Boolean getStatus() {
		return this.status;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());

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
		Usertable other = (Usertable) obj;
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}

		return true;
	}

}