package co.jufeng.dao.hibernate.criterion.impl;


import co.jufeng.dao.hibernate.criterion.IQuery;

public class Query extends Restrictions implements IQuery{

	private static final long serialVersionUID = 2661410186685630234L;
	
	IQuery query;

	@Override
	public String getQuery() {
		return query.getQuery();
	}

	@Override
	public void setCacheable(boolean cacheable) {
		query.setCacheable(cacheable);
	}
}
