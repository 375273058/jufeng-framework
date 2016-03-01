package co.jufeng.dao.spring.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public interface IJdbcTemplate {
	
	public void setJdbcTemplate(DataSource dataSource);
	
	public JdbcTemplate getJdbcTemplate();


}
