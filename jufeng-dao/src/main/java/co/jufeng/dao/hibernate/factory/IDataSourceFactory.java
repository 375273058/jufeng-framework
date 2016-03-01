package co.jufeng.dao.hibernate.factory;

import java.io.Serializable;

public interface IDataSourceFactory {
	
	<T> T getDateSource();
	
	<T> T setDataSource(Object object, Class<T> t);

	Serializable save(Object object);
	

}
