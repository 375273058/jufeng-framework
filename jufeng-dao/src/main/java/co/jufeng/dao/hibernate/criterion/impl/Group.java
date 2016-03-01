package co.jufeng.dao.hibernate.criterion.impl;

import java.io.Serializable;

import co.jufeng.dao.hibernate.annotation.Immutable;
import co.jufeng.dao.hibernate.criterion.IProjection;
import co.jufeng.dao.hibernate.criterion.enums.ProjectionMode;


@Immutable
public class Group extends Projection implements IProjection, Cloneable, Serializable {

	private static final long serialVersionUID = -2579414297905494968L;
	
	private String name;
	
	ProjectionMode projectionMode;
	
	public static Group add(String name, ProjectionMode projectionMode){
		return new Group(name, projectionMode);
	}

	Group(String name, ProjectionMode projectionMode) {
		if (name == null) {
		      throw new IllegalArgumentException("Name may not be null");
	    }
	    this.name = name;
	    this.projectionMode = projectionMode;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	public ProjectionMode getProjectionMode() {
		return this.projectionMode;
	}
}
