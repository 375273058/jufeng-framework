package co.jufeng.dao.hibernate.criterion.impl;

import java.io.Serializable;

import co.jufeng.dao.hibernate.criterion.IRestrictions;

/**
 * 过虑查询
 * @author jufeng
 *
 */
public class Property  extends Restrictions implements IRestrictions, Cloneable, Serializable {
	private static final long serialVersionUID = -3822647765647696242L;
	private String name;
	private Object value;
	public static Property add(String classNameVO, Object...value){
		return new Property(classNameVO, value);
	}
	Property(String classNameVO, Object...value) {
		if (value == null) {
		      throw new IllegalArgumentException("Name may not be null");
	    }
		this.name = classNameVO;
	    this.value = value;
	}
	@Override
	public Object getValue() {
		return this.value;
	}
	@Override
	public String getName() {
		return name;
	}

}
