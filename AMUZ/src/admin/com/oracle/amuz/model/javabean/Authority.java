package admin.com.oracle.amuz.model.javabean;

import java.io.Serializable;

public class Authority implements Serializable{
	private int authorityid;
	private String authority_parents;
	private String authority_children;
	private String method;
	private int authority_parents_id;
	public int getAuthorityid() {
		return authorityid;
	}
	public void setAuthorityid(int authorityid) {
		this.authorityid = authorityid;
	}
	public String getAuthority_parents() {
		return authority_parents;
	}
	public void setAuthority_parents(String authority_parents) {
		this.authority_parents = authority_parents;
	}
	public String getAuthority_children() {
		return authority_children;
	}
	public void setAuthority_children(String authority_children) {
		this.authority_children = authority_children;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public int getAuthority_parents_id() {
		return authority_parents_id;
	}
	public void setAuthority_parents_id(int authority_parents_id) {
		this.authority_parents_id = authority_parents_id;
	}
	public Authority(int authorityid, String authority_parents, String authority_children, String method,
			int authority_parents_id) {
		super();
		this.authorityid = authorityid;
		this.authority_parents = authority_parents;
		this.authority_children = authority_children;
		this.method = method;
		this.authority_parents_id = authority_parents_id;
	}
	
	public Authority() {
		super();
	}
	
	@Override
	public String toString() {
		return "Authority [authorityid=" + authorityid + ", authority_parents=" + authority_parents
				+ ", authority_children=" + authority_children + ", method=" + method + ", authority_parents_id="
				+ authority_parents_id + "]";
	}
	
	
}
