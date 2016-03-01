package co.jufeng.model.mingyuan;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import co.jufeng.core.util.MD5EncryptUtil;
import co.jufeng.dao.hibernate.strategy.EntityStrategyAutoNullDate;
import co.jufeng.model.exception.ModelBusinessException;
import co.jufeng.model.exception.BusinessExConstants.WrongPassWordFormat;

@Entity(name = "MY_USER")
public class User extends EntityStrategyAutoNullDate {

	private static final long serialVersionUID = 4742880169528830911L;
	
	@Column(name = "USER_NAME", length = 64, unique = true, nullable = false)
	private String userName;

	@Column(name = "PASSWORD", length = 128, nullable = false)
	private String password;
	
	@Column(name = "STATUS", length = 1)
	private int status = 0;
	
	@Column(name = "ADD_DATE", nullable = false)
	private Date addDate = new Date();
	
	public User() {
		super();
	}
	public User(String userName, String password) {
		this.userName = userName;
		this.setPassword(password);
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
	
	/**
	 * 加密后的密码格式：utf-8 32 位 小写
	 */
	public void setPassword(String password) {
		if(password.matches("[0-9a-f]{32}")){
			this.password = MD5EncryptUtil.getMd5KL(password);
		}else{
			throw new ModelBusinessException(WrongPassWordFormat.code, WrongPassWordFormat.desc);
		}
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

}
