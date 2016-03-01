package co.jufeng.dao.hibernate.criterion.impl;

import co.jufeng.dao.hibernate.factory.IEntityFactory;

public class Entitys {

	final IEntityFactory entityFactory;

	public Entitys(Object entityClass){
		this.entityFactory = (IEntityFactory) entityClass;
	}


}
