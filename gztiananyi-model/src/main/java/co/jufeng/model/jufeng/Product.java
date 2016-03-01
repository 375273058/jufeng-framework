package co.jufeng.model.jufeng;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import co.jufeng.dao.hibernate.strategy.EntityStrategyAuto;

/**
 * 产品
 * @author jufeng
 *
 */
@Entity(name = "JF_PRODUCT")
public class Product extends EntityStrategyAuto{

	private static final long serialVersionUID = 4364396278119442969L;

	/**
	 * 名称
	 */
	@Column(name = "NAME", length = 64, unique = true, nullable = false)
	private String name;

	/**
	 * 图片
	 */
	@Column(name = "PHOTOS", length = 128, nullable = false)
	private String photos;
	
	/**
	 * 详情
	 */
	@Column(name = "DETAILS", length = 200, nullable = false)
	private String details;
	
	/**
	 * 价格
	 */
	@Column(name = "PRICE")
	private BigDecimal price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	

}
