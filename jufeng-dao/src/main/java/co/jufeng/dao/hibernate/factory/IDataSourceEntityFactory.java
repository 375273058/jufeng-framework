package co.jufeng.dao.hibernate.factory;

public interface IDataSourceEntityFactory {
	
	void setBean(Object object);
	
	void setEntity(IEntityFactory entityFactory);

}
