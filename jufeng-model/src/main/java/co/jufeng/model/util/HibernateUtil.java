package co.jufeng.model.util;

import java.util.Map;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import co.jufeng.core.config.ConfigFactory;
import co.jufeng.core.enums.ConfigTypeEnum;
import co.jufeng.core.util.MD5EncryptUtil;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		Map<Object, Object> map = ConfigFactory.getInstance().get(ConfigTypeEnum.PROPERTIES);
		Configuration configuration = new Configuration().configure();
		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.url", map.get("url").toString());
		properties.setProperty("hibernate.connection.username", map.get("username").toString());
		String password = MD5EncryptUtil.getDecrypt(map.get("password").toString());
		properties.setProperty("hibernate.connection.password", password);
		properties.setProperty("hibernate.connection.driver_class", map.get("driver.class").toString());
		configuration.addProperties(properties);
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		ServiceRegistry serviceRegistry = serviceRegistryBuilder.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSession(Session session) {
		if (session != null) {
			if (session.isOpen()) {
				session.close();
			}
		}
	}
	
	
}