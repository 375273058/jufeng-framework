package co.jufeng.dao.hibernate.criterion;

public abstract interface IPaging extends IRestrictions {
	
	int getFirstResult();
	
	int getMaxResults();
	
}
