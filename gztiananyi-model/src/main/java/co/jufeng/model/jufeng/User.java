package co.jufeng.model.jufeng;


import javax.persistence.Column;
import javax.persistence.Entity;

import co.jufeng.dao.hibernate.strategy.EntityStrategyAutoNullDate;

@Entity(name = "JF_USER")
public class User extends EntityStrategyAutoNullDate{

	private static final long serialVersionUID = 4742880169528830911L;
	
	@Column(name = "USER_NAME", length = 64, unique = true, nullable = false)
	private String userName;

	@Column(name = "PASSWORD", length = 128, nullable = false)
	private String password;
	
	@Column(name = "STATUS", length = 1)
	private int status = 0;
	
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
