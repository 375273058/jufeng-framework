package co.jufeng.dao.hibernate.criterion.impl;

import java.io.Serializable;

import co.jufeng.dao.hibernate.annotation.Immutable;
import co.jufeng.dao.hibernate.criterion.IQuery;


@Immutable
public class Hql extends Query implements IQuery, Cloneable, Serializable {

	private static final long serialVersionUID = 8225546616051786763L;

	private String hql;
	
	private Object objects;
	
	public static Hql add(String hql, Object...objects){
		return new Hql(hql, objects);
	}

	Hql(String hql, Object...objects) {
		if (hql == null) {
		      throw new IllegalArgumentException("Hql may not be null");
	    }
	    this.hql = hql;
	    this.objects = objects;
	}

	@Override
	public Object getValue() {
		return this.objects;
	}
	
	@Override
	public String getQuery() {
		return this.hql;
	}
	
}
