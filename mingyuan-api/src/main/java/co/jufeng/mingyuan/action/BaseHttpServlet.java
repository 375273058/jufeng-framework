package co.jufeng.mingyuan.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.hibernate.Session;

import co.jufeng.dao.hibernate.dao.IHibernateAccessor;
import co.jufeng.dao.hibernate.dao.impl.HibernateAccessor;
import co.jufeng.model.util.HibernateUtil;

public class BaseHttpServlet extends HttpServlet {

	private static final long serialVersionUID = -8694011421056374507L;
	
	private IHibernateAccessor accessor;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			accessor = HibernateAccessor.newInstance(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public IHibernateAccessor getAccessor() {
		return accessor;
	}

	public void setAccessor(IHibernateAccessor accessor) {
		this.accessor = accessor;
	}
	
	


}
