package co.jufeng.dao.hibernate.strategy;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import co.jufeng.core.string.ToStringBuilder;
import co.jufeng.dao.hibernate.factory.IEntityFactory;
import co.jufeng.dao.hibernate.factory.impl.EntityFactory;

@MappedSuperclass
public abstract class EntityStrategyAutoNullDate extends EntityFactory implements IEntityFactory, Cloneable, Serializable {

	private static final long serialVersionUID = 7110625171763157114L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;


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

	
}
