package admin.com.oracle.amuz.model.dao;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import admin.com.oracle.amuz.model.javabean.Authority;
import admin.com.oracle.amuz.model.javabean.User;

public class UserDaoImp extends BaseDaoImp implements UserDao {

	@Override
	public User login(String username, String password) {
		User user = null;
		Set<Authority> authorities = null;
		Authority authority = null;
		Connection connection = getConnection();
		try {
			PreparedStatement pre = connection
					.prepareStatement("select * from adminuser where username=? and password=?");
			pre.setString(1, username);
			pre.setString(2, password);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				user = new User();
				System.out.println(rs);
				user.setUserid(rs.getInt("userid"));
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(rs.getString("email"));
				user.setPhonenum(rs.getString("phonenum"));
				user.setSex(rs.getInt("sex") == 0 ? "男" : "女");
				user.setOther(rs.getString("otherss"));
				user.setLoginedIP(rs.getString("loginedIP"));
				user.setLoginednum(rs.getInt("loginednum"));
				user.setLoginedtime(rs.getString("loginedtime"));
				// 查询角色
				PreparedStatement pre2 = connection.prepareStatement("select * from actor where actorid=?");
				pre2.setInt(1, rs.getInt("actorid"));
				ResultSet rs2 = pre2.executeQuery();
				if (rs2.next())
					user.setActor(rs2.getString("actorname"));
				// 获取权限
				PreparedStatement pre3 = connection.prepareStatement("select * from adminuser_authority where userid=?");
				pre3.setInt(1, user.getUserid());
				ResultSet rs3 = pre3.executeQuery();
				authorities = new HashSet<>();
				while (rs3.next()) {
					System.out.println(rs3.getInt("authorityid"));
					PreparedStatement pre4 = connection.prepareStatement("select * from authority where authorityid=?");
					pre4.setInt(1, rs3.getInt("authorityid"));
					ResultSet rs4 = pre4.executeQuery();
					if (rs4.next()) {
						authority = new Authority();
						authority.setAuthorityid(rs4.getInt("authorityid"));
						authority.setAuthority_parents(rs4.getString("authority_parents"));
						authority.setMethod(rs4.getString("method"));
						authority.setAuthority_children(rs4.getString("authority_children"));
						authority.setAuthority_parents_id(rs4.getInt("authority_parents_id"));
						System.out.println(authority);
						authorities.add(authority);

						// set权限集合 内容
					}
					user.setAuthority(authorities);
				}
				disposeResource(connection, pre2, rs2);
				disposeResource(connection, pre, rs);
				
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public boolean updateLoginedHistory(int userid,int loginednum) {
		String localIP=null;
		InetAddress ia=null;
		try {
			ia=ia.getLocalHost();
			localIP=ia.getHostAddress();  //获取本机ip地址
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		
		Connection c = getConnection();
		PreparedStatement pre=null;
		try {
			pre=c.prepareStatement("update adminuser set loginedIP=?,loginednum=?,loginedtime=to_date(?,'yyyy-mm-dd hh24:mi:ss')  where userid=?");
			pre.setString(1, localIP);
			pre.setInt(2, ++loginednum);
			pre.setString(3, df.format(new Date()));
			pre.setInt(4, userid);
			
			boolean result= pre.executeUpdate()>0?true:false;
			disposeResource(c, pre, null);
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
