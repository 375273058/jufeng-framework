package co.jufeng.model.mingyuan;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import co.jufeng.dao.hibernate.strategy.EntityStrategyAutoNullDate;

/**
 * 广告
 * @author jufeng
 *
 */
@Entity(name = "MY_ADVERTISEMENT")
public class Advertisement extends EntityStrategyAutoNullDate {

	private static final long serialVersionUID = 5975324441978600108L;

	@Column(name = "URL", unique = true, nullable = false)
	private String url;
	
	/**
	 * 0、首页幻灯片广告轮播
	 */
	@Column(name = "TYPE", length = 1)
	private int type = 0;
	
	@Column(name = "ADD_DATE", nullable = false)
	private Date addDate = new Date();
	
	public Advertisement() {
	}

	public Advertisement(String url) {
		this.url = url;
	}
	public Advertisement(String url, int type) {
		this.url = url;
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

}
