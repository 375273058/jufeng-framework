package co.jufeng.dao.hibernate.criterion;

import co.jufeng.dao.hibernate.criterion.enums.MatchMode;

public abstract interface Iilike extends IRestrictions{
	
	public abstract MatchMode getMatchMode();


}
