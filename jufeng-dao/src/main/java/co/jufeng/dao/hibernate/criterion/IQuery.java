package co.jufeng.dao.hibernate.criterion;

public interface IQuery extends ICriterion {
	
	String getQuery();
	
	void setCacheable(boolean cacheable);
	

}
