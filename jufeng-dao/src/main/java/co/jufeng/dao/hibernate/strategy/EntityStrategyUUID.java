package co.jufeng.dao.hibernate.strategy;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.GenericGenerator;

import co.jufeng.core.string.ToStringBuilder;
import co.jufeng.dao.hibernate.factory.IEntityFactory;
import co.jufeng.dao.hibernate.factory.impl.EntityFactory;

@SuppressWarnings({ "unchecked" })
@MappedSuperclass
public abstract class EntityStrategyUUID<E> extends EntityFactory implements IEntityFactory, Cloneable, Serializable {


	private static final long serialVersionUID = -7695230587155918888L;

	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")//uuid.hex
	private String id;

	@Column(name = "ADD_DATE", nullable = false)
	private Date addDate;

	@Version
	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	@Transient
	@XmlTransient
	private Class<E> entityClass;

	public EntityStrategyUUID() {
		try {
			Class<?> c = super.getClass();
			Type type = c.getGenericSuperclass();
			if (type instanceof ParameterizedType) {
				Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
				this.entityClass = ((Class<E>) parameterizedType[0]);
			}
			if(addDate == null){
				addDate = new Date();
			}
			if(updateDate == null){
				updateDate = new Date();
			}
		} catch (Exception e) {
		}
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Class<E> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<E> entityClass) {
		this.entityClass = entityClass;
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
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
