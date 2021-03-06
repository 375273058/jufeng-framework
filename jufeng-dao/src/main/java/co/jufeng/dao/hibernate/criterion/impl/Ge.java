package co.jufeng.dao.hibernate.criterion.impl;

import java.io.Serializable;

import co.jufeng.dao.hibernate.annotation.Immutable;
import co.jufeng.dao.hibernate.criterion.IRestrictions;


@Immutable
public class Ge extends Restrictions implements IRestrictions, Cloneable, Serializable {

	private static final long serialVersionUID = -3214735620513544468L;

	private String name;
	
	private Object value;
	
	public static Ge add(String name, Object...value){
		return new Ge(name, value);
	}

	/**
	 * cannot be instantiated
	 * @param name
	 * @param value
	 */
	Ge(String name, Object...value) {
		if (name == null) {
		      throw new IllegalArgumentException("Name may not be null");
	    }
	    this.name = name;
	    this.value = value;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Object getValue() {
		return this.value;
	}

}
