package co.jufeng.dao.hibernate.strategy;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import co.jufeng.core.string.ToStringBuilder;
import co.jufeng.dao.hibernate.factory.IEntityFactory;
import co.jufeng.dao.hibernate.factory.impl.EntityFactory;

@MappedSuperclass
public abstract class EntityStrategyAuto extends EntityFactory implements IEntityFactory, Cloneable, Serializable {

	private static final long serialVersionUID = 7110625171763157114L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "ADD_DATE", nullable = false)
	private Date addDate = new Date();

	@Version
	@Column(name = "UPDATE_DATE", nullable = false)
	private Date updateDate = new Date();

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
