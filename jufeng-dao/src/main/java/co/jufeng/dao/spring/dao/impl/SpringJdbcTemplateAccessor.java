package co.jufeng.dao.spring.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.core.StatementCreatorUtils;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import co.jufeng.core.logger.LoggerUtils;
import co.jufeng.core.reflect.NameValuePair;
import co.jufeng.dao.AbstractAccessor;
import co.jufeng.dao.EntityUtil;
import co.jufeng.dao.hibernate.criterion.ICriterion;
import co.jufeng.dao.hibernate.factory.IEntityFactory;
import co.jufeng.dao.spring.dao.ISpringJdbcTemplateAccessor;

public class SpringJdbcTemplateAccessor extends AbstractAccessor implements ISpringJdbcTemplateAccessor{

	private static final long serialVersionUID = 6791079119446982894L;
	
	private JdbcTemplate jdbcTemplate;
	
	private DataSourceTransactionManager transactionManager;
	
	private DefaultTransactionDefinition transactionDefinition;

	public SpringJdbcTemplateAccessor(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.transactionManager = new DataSourceTransactionManager(dataSource);
		this.transactionDefinition = new DefaultTransactionDefinition();
		this.transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public DataSourceTransactionManager getTransactionManager() {
		return transactionManager;
	}

	/**
	 * 事务定义类
	 * @return
	 */
	public DefaultTransactionDefinition getTransactionDefinition() {
		return transactionDefinition;
	}

	/**
	 * 返回事务对象
	 * @return
	 */
	public TransactionStatus getTransaction() {
		return transactionManager.getTransaction(getTransactionDefinition());
	}

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(jdbcTemplate);
	}
	
	public String getIdColumn() {
		return "id";
	}

	@SuppressWarnings("unchecked")
	@Override
	public Serializable save(Object... entitys) throws Exception {
		if(entitys[0] instanceof Collection || entitys[0] instanceof List || entitys[0] instanceof Set){
			return save((Collection<Serializable>) entitys[0]);
		}else {
			return save(Arrays.asList(entitys));
		}
	}
	
	@Override
	public Serializable save(Collection<Serializable> entities) throws Exception {
		Collection<Serializable> ids = null;
		int i = 0;
		try {
			ids = new ArrayList<Serializable>();
			Iterator<?> it = entities.iterator();
			while (it.hasNext()) {
				SimpleJdbcInsertOperations simpleJdbc = new SimpleJdbcInsert(jdbcTemplate);
				Serializable entity = (Serializable) it.next();
				simpleJdbc.withTableName(EntityUtil.getTableName(entity.getClass()));
				SqlParameterSource sps = new BeanPropertySqlParameterSource(entity);
				Long id = (Long) simpleJdbc.usingGeneratedKeyColumns(EntityUtil.getPrimaryKey(entity.getClass())).executeAndReturnKey(sps); 
			    ids.add(id);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(i > 1){
			return (Serializable) ids;
		}else{
			return ids.iterator().next();
		}
	}

	@Deprecated
	public Serializable saveDeprecated(Collection<Serializable> entities) throws Exception {
		Collection<Serializable> ids = null;
		int i = 0;
		try {
			ids = new ArrayList<Serializable>();
			Iterator<?> it = entities.iterator();
			while (it.hasNext()) {
				Serializable entity = (Serializable) it.next();
				String[] nameArray = NameValuePair.getInstance().getFiledName(entity);
				for (int j = 0; j < nameArray.length; j++) {
					nameArray[j] = EntityUtil.getColumnName(entity.getClass(), nameArray[j]);
				}
				Object[] valueArray = NameValuePair.getInstance().getFiledValues(entity);
				StringBuffer sql = new StringBuffer();
				sql.append("INSERT INTO ");
				sql.append(EntityUtil.getTableName(entity.getClass()));
				sql.append("(");
				sql.append(StringUtils.join(nameArray, ","));
				sql.append(")");
				sql.append(" VALUES(");
				List<String> list = new ArrayList<String>();
				for (int j = 0; j < nameArray.length; j++) {
					list.add("?");
				}
				sql.append(StringUtils.join(list.toArray(), ","));
				sql.append(")");
				LoggerUtils.info(getClass(), sql);
				KeyHolder keyHolder = new GeneratedKeyHolder();  
			    int autoIncId = 0;  
			    getJdbcTemplate().update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement ps = con.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
						
						for (int j = 0; j < valueArray.length; j++) {
							Object arg = valueArray[j];
							doSetValue(ps, j + 1, arg);
						}
						return ps;
					}
				}, keyHolder);
			    autoIncId = keyHolder.getKey().intValue();  
			    ids.add(autoIncId);
				i++;
			}
			getTransactionManager().commit(getTransaction());
		} catch (Exception e) {
			e.printStackTrace();
			getTransactionManager().rollback(getTransaction());
		}
		if(i > 1){
			return (Serializable) ids;
		}else{
			return ids.iterator().next();
		}
	}
	protected void doSetValue(PreparedStatement ps, int parameterPosition, Object argValue) throws SQLException {
		if (argValue instanceof SqlParameterValue) {
			SqlParameterValue paramValue = (SqlParameterValue) argValue;
			StatementCreatorUtils.setParameterValue(ps, parameterPosition, paramValue, paramValue.getValue());
		} else {
			StatementCreatorUtils.setParameterValue(ps, parameterPosition, SqlTypeValue.TYPE_UNKNOWN, argValue);
		}
	}
	@Override
	public boolean delete(Object... entity) throws Exception {
		return false;
	}

	@Override
	public boolean delete(Class<?> entity, Serializable... id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Class<?> entity, Collection<Serializable> ids)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Collection<Serializable> entities) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll(IEntityFactory entityFactory) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object... entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Collection<Serializable> entities) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T getById(Serializable id, Class<T> T) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable get(ICriterion... criterions) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable getFunction(ICriterion... criterion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty(Class<?> clazz, String criteriaKey, String criteriaValue) throws Exception {
		
		return false;
	}
	
}
