package co.jufeng.dao;

import java.io.Serializable;
import java.util.Collection;

import co.jufeng.dao.hibernate.criterion.ICriterion;
import co.jufeng.dao.hibernate.factory.IEntityFactory;

public interface IAccessor extends Cloneable, Serializable {
	
	public Serializable save(Object... entity) throws Exception;
	
	public Serializable save(Collection<Serializable> entities) throws Exception;
	
	public boolean delete(Object... entity) throws Exception;
	
	public boolean delete(Class<?> entity, Serializable... id) throws Exception;
	
	public boolean delete(Class<?> entity, Collection<Serializable> ids) throws Exception;
	
	public boolean delete(Collection<Serializable> entities) throws Exception;
	
	public boolean deleteAll(IEntityFactory entityFactory) throws Exception;
	
	public boolean update(Object... entity) throws Exception;
	
	public boolean update(Collection<Serializable> entities) throws Exception;
	
	public <T> T getById(Serializable id, Class<T> T) throws Exception;
	
	public Serializable get(ICriterion... criterions) throws Exception;
	
	public Serializable getFunction(ICriterion... criterion) throws Exception;
	
	public boolean isEmpty(Class<?> clazz, String criteriaKey, String criteriaValue) throws Exception;

	public Object beginTransaction() throws Exception ;

	public void commit() throws Exception ;
	
	public void rollback() throws Exception ;
	
	
	
	
	
	
	
	

}
