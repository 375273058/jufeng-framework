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
public abstract class EntityStrategyIdentity<E> extends EntityFactory implements IEntityFactory, Cloneable, Serializable {

	private static final long serialVersionUID = -7358052664222681948L;
	
	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "identity")
	@Column(name = "ID")
	private Long id;

	
	@Column(name = "ADD_DATE", nullable = false)
	private Date addDate;

	@Version
	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
//	@Column(name = "CALENDAR")
//	private Timestamp calendar = new Timestamp(System.currentTimeMillis());

	@Transient
	@XmlTransient
	private Class<E> entityClass;

	public EntityStrategyIdentity(Long id) {
		this.id = id;
	}
	
	public EntityStrategyIdentity(Long id, Date addDate) {
		this.id = id;
		this.addDate = addDate;
	}

	public EntityStrategyIdentity() {
		try {
			Class<?> c = super.getClass();
			Type type = c.getGenericSuperclass();
			if (type instanceof ParameterizedType) {
				Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
				this.entityClass = ((Class<E>) parameterizedType[0]);
			}
			
//			Calendar ccc = Calendar.getInstance();   
//			//用当前时间初始化日历时间
//			ccc.setTime(new Date());
			if(addDate == null){
				addDate = new Date();
				//创建一个日历对象
				
//			    new Timestamp(System.currentTimeMillis());
//			addDate = new Timestamp(System.currentTimeMillis());
//			String str = DateUtil.getDateToString(new Date(), "yyyy-MM-dd HH:mm:ss.sss");
//			addDate = Timestamp.valueOf(str);
//			System.out.println(str);
//			
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			}
			if(updateDate == null){
				updateDate = new Date();
			}
		} catch (Exception e) {
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
