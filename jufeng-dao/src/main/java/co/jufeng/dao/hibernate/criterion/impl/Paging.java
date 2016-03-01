package co.jufeng.dao.hibernate.criterion.impl;

import java.io.Serializable;

import co.jufeng.dao.hibernate.annotation.Immutable;
import co.jufeng.dao.hibernate.criterion.IPaging;
import co.jufeng.dao.hibernate.criterion.IRestrictions;

/**
 * 分页
 * @author Administrator
 *
 */
@Immutable
public class Paging extends Restrictions implements IPaging ,IRestrictions, Cloneable, Serializable {

	private static final long serialVersionUID = -8775112666380985698L;
	
	int firstResult;
	
	int maxResults;

	public static Paging add(int firstResult, int maxResults){
		return new Paging(firstResult, maxResults);
	}

	Paging(int firstResult, int maxResults) {
		if (firstResult == 0) {
		      throw new IllegalArgumentException("firstResult may not be 0");
	    }
		this.firstResult = firstResult;
		this.maxResults = maxResults;
	}

	@Override
	public int getMaxResults() {
		return maxResults;
	}

	@Override
	public int getFirstResult() {
		return firstResult;
	}

}
