package co.jufeng.web.www.core.base;

import java.io.Serializable;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public abstract class BaseInterceptor<I extends java.io.Serializable, INTERCEPTOR extends java.io.Serializable> extends AbstractInterceptor implements Serializable {
	
	private static final long serialVersionUID = 4875505033678124522L;
	
	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	private Map<String, Object> sessionMap; 
	
	private Map<String, Object> applicationMap; 

	public void init(ActionInvocation invocation) throws Exception {
		request = (HttpServletRequest) invocation.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		response = (HttpServletResponse) invocation.getInvocationContext().get(StrutsStatics.HTTP_RESPONSE); 
		sessionMap = invocation.getInvocationContext().getSession();
		applicationMap = invocation.getInvocationContext().getApplication();
	}

	public HttpServletRequest getRequest() {
		return request;
	}
	
	

	public HttpServletResponse getResponse() {
		return response;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	
	public HttpSession getSession() {
		return request.getSession();
	}

	public Map<String, Object> getApplicationMap() {
		return applicationMap;
	}
	
}
