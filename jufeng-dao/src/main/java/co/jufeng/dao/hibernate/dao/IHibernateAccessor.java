package co.jufeng.dao.hibernate.dao;

import java.io.Serializable;

import org.hibernate.Criteria;

import co.jufeng.dao.IAccessor;
import co.jufeng.dao.hibernate.criterion.ICriterion;

public abstract interface IHibernateAccessor extends IAccessor, Cloneable, Serializable {
	
	/**
	 * 获取面向对象的查询方式
	 * @param object
	 * @return
	 */
	public Criteria getCriteria(Class<?> object) throws Exception;
	
	/**
	 * 获取面向对象的查询方式
	 * @param object
	 * @return
	 */
	public Criteria getCriteria(String object) throws Exception;
	
	/**
	 * 获取面向对象的查询方式
	 * @param criterions
	 * @return 对象数组
	 */
	public Criteria[] getCriteria(ICriterion... criterions) throws Exception;
	
	/**
	 * 创建面向对象的查询分组条件
	 * @param criteria
	 * @param criterions
	 * @return
	 */
	public Criteria createAGroupCriteria(Criteria criteria,  ICriterion... criterions) throws Exception;
	
	/**
	 * 创建HQL的查询分组条件
	 * @param query
	 * @param criterions
	 * @return
	 */
	public org.hibernate.Query createAGroupCriteria(org.hibernate.Query query, ICriterion... criterions) throws Exception;
	
	/**
	 * 获取会话工厂
	 * @return
	 */
	public org.hibernate.SessionFactory getSessionFactory();
	 
	/**
	 * 开打会话
	 * @return
	 */
	public org.hibernate.Session openSession();
   	
	/**
	 * 关闭会话
	 */
	public void closeSession() throws Exception;

	/**
	 * 将指定的持久化对象从一级缓存中清除,释放对象所占用的内存资源,指定对象从持久化状态变为脱管状态,从而成为游离对象
	 * @param entity
	 */
	public void evict(Object entity) throws Exception;
	
	/**
	 * 将一级缓存中的所有持久化对象清除,释放其占用的内存资源
	 */
	public void clear() throws Exception;
	
	/**
	 * 判断指定的对象是否存在于一级缓存中
	 * @param entity
	 */
	public void contains(Object entity) throws Exception;
	
	/**
	 * 刷新一级缓存区的内容,使之与数据库数据保持同步
	 */
	public void flush() throws Exception;
}
