package co.jufeng.dao.hibernate.criterion.impl;

import java.io.Serializable;

import co.jufeng.dao.hibernate.annotation.Immutable;
import co.jufeng.dao.hibernate.criterion.IProjection;


@Immutable
public class Min extends Projection implements IProjection, Cloneable, Serializable {

	private static final long serialVersionUID = 2369423104204638877L;
	
	private String name;
	
	public static Min add(String name){
		return new Min(name);
	}

	Min(String name) {
		if (name == null) {
		      throw new IllegalArgumentException("Name may not be null");
	    }
	    this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}
}
