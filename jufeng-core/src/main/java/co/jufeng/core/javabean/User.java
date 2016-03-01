package co.jufeng.core.javabean;

import co.jufeng.core.string.ToStringBuilder;
import co.jufeng.core.string.ToStringStyle;

public class User{
	
	private int id;
	private String userName = "jufeng";
	private String password = "a1234567";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
