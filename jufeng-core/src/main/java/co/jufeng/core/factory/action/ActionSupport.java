package co.jufeng.core.factory.action;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Provides a default implementation for the most common actions.
 * See the documentation for all the interfaces this class implements for more detailed information.
 */
public class ActionSupport implements IAction, Serializable {

	private static final long serialVersionUID = 9181740824201219443L;
	
	protected static Logger LOG = LoggerFactory.getLogger(ActionSupport.class);

	@Override
	public void index() throws Exception {
	}
	
	@Override
	public void index(HttpServletRequest request) throws Exception {
	}
	
	@Override
	public void index(HttpServletResponse response) throws Exception {
	}

	@Override
	public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
	}

}
