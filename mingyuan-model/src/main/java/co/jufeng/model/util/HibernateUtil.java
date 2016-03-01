package co.jufeng.model.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		ServiceRegistry serviceRegistry = serviceRegistryBuilder.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
//		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
//		factory = cfg.buildSessionFactory(sr);
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