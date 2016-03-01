package co.jufeng.dao.spring;

import org.springframework.jdbc.core.JdbcOperations;

public interface JdbcTemplate extends JdbcOperations {
	
	public abstract void beginTranstaion();

	public abstract void commit();

	public abstract void rollback();
}