package co.jufeng.dao.mybatis.dao.impl;

import java.io.Serializable;
import java.util.Collection;

import co.jufeng.dao.AbstractAccessor;
import co.jufeng.dao.hibernate.criterion.ICriterion;
import co.jufeng.dao.hibernate.factory.IEntityFactory;
import co.jufeng.dao.mybatis.dao.IMyBatisAccessor;

public class MyBatisAccessor extends AbstractAccessor implements IMyBatisAccessor{

	private static final long serialVersionUID = 6791079119446982894L;

	@Override
	public Serializable save(Object... entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(Collection<Serializable> entities)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Object... entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Class<?> entity, Serializable... id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Class<?> entity, Collection<Serializable> ids)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Collection<Serializable> entities) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll(IEntityFactory entityFactory) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object... entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Collection<Serializable> entities) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T getById(Serializable id, Class<T> T) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable get(ICriterion... criterions) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable getFunction(ICriterion... criterion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty(Class<?> clazz, String criteriaKey,
			String criteriaValue) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
