package co.jufeng.dao.hibernate.criterion.impl;

import java.io.Serializable;

import co.jufeng.dao.hibernate.annotation.Immutable;
import co.jufeng.dao.hibernate.criterion.IProjection;
import co.jufeng.dao.hibernate.criterion.enums.ProjectionMode;


@Immutable
public class Count extends Projection implements IProjection, Cloneable, Serializable {

	private static final long serialVersionUID = -6501363760844928178L;
	
	String name;
	
	ProjectionMode projectionMode;

	public static Count add(ProjectionMode projectionMode){
		return new Count(projectionMode);
	}
	
	public static Count add(ProjectionMode projectionMode, String name){
		return new Count(projectionMode, name);
	}
	
	public Count(ProjectionMode projectionMode) {
		this.projectionMode = projectionMode;
	}

	public Count(ProjectionMode projectionMode, String name) {
		this.projectionMode = projectionMode;
		this.name = name;
	}

	public ProjectionMode getProjectionMode() {
		return projectionMode;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	
	
}
