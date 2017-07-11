package admin.com.oracle.amuz.model.javabean;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable{
	private String username;
	private String password;
	private String actor;
	private Set<Authority> authority;
	
}
