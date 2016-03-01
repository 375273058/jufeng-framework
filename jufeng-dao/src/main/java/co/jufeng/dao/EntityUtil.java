package co.jufeng.dao;

import java.util.Iterator;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.PrimaryKey;
import org.hibernate.mapping.Property;
import org.hibernate.service.ServiceRegistry;

/**
 * 功能描述：根据实体类得到对应的表名、主键名、字段名工具类
 * 
 */
public class EntityUtil {

	private static Configuration hibernateConf;

	private static Configuration getHibernateConf() {
		if (hibernateConf == null) {
			// hibernateConf=new Configuration();//*.hbm.xml方式
			hibernateConf = new AnnotationConfiguration().configure();// 注解方式
			hibernateConf.buildSessionFactory();// 注解方式必须的
		}
		return hibernateConf;
	}

	private static PersistentClass getPersistentClass(Class<?> clazz) {
		synchronized (EntityUtil.class) {
			PersistentClass pc = getHibernateConf().getClassMapping(
					clazz.getName());
			if (pc == null) {
				// hibernateConf =
				// getHibernateConf().addClass(clazz);//*.hbm.xml方式
				pc = getHibernateConf().getClassMapping(clazz.getName());

			}
			return pc;
		}
	}

	/**
	 * 功能描述：获取实体对应的表名
	 */
	public static String getTableName(Class<?> clazz) {
		return getPersistentClass(clazz).getTable().getName();
	}

	/**
	 * 功能描述：获取实体对应表的主键字段名称，只适用于唯一主键的情况
	 */
	public static String getPrimaryKey(Class<?> clazz) {

		return getPrimaryKeys(clazz).getColumn(0).getName();

	}

	/**
	 * 功能描述：获取实体对应表的主键字段名称
	 */
	public static PrimaryKey getPrimaryKeys(Class<?> clazz) {

		return getPersistentClass(clazz).getTable().getPrimaryKey();

	}

	/**
	 * 功能描述：通过实体类和属性，获取实体类属性对应的表字段名称
	 */
	public static String getColumnName(Class<?> clazz, String propertyName) {
		PersistentClass persistentClass = getPersistentClass(clazz);
		Property property = persistentClass.getProperty(propertyName);
		Iterator<?> it = property.getColumnIterator();
		if (it.hasNext()) {
			Column column = (Column) it.next();
			return column.getName();
		}
		return null;
	}

}