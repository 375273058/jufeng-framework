package co.jufeng.dao.hibernate.factory.impl;

import java.io.Serializable;

import org.hibernate.Session;

import co.jufeng.dao.hibernate.factory.IDataSourceFactory;

public class SessionDataSource implements IDataSourceFactory{
	
	Session session;
	
	@Override
	public <T> T setDataSource(Object object, Class<T> t) {
		this.session = (Session) t.cast(object);
		return t.cast(object);
	}

	@Override
	public Serializable save(Object object) {
		return session.save(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getDateSource() {
		return (T) session;
	}
	
	

}
