package co.jufeng.web.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.jufeng.core.enums.OutTypeEnum;
import co.jufeng.core.enums.ScopeTypeEnum;
import co.jufeng.core.logger.LoggerUtils;
import co.jufeng.core.util.OutUtil;
import co.jufeng.core.util.StringUtils;

public class ModelAndView extends ServletRequestWrapper {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext context;
	private PrintWriter printWriter;

	public ModelAndView(HttpServletRequest request, HttpServletResponse response) {
		super(request);
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		this.context = this.session.getServletContext();
	}

	private Object view;

	private boolean cleared = false;

	public boolean isCleared() {
		return cleared;
	}

	public void setCleared(boolean cleared) {
		this.cleared = cleared;
	}

	public ModelAndView addViewName(String viewName) {
		this.view = viewName;
		return this;
	}
	
	@Override
	public void setAttribute(String name, Object o) {
		this.addObject(name, o);
	}
	
	public ModelAndView addObject(String attributeName, Object attributeValue) {
		return this.addObject(attributeName, attributeValue, ScopeTypeEnum.REQUEST);
	}
	
	public ModelAndView addObject(String attributeName, Object attributeValue, ScopeTypeEnum scopeTypeEnum) {
		switch (scopeTypeEnum) {
		case REQUEST:
			request.setAttribute(attributeName, attributeValue);
			break;
		
		case SESSION:
			session.setAttribute(attributeName, attributeValue);
			break;

		case APPLICATION:
			context.setAttribute(attributeName, attributeValue);
			break;

		default:
			break;
		}
		return this;
	}
	
	public void action(){
		try {
			Object viewPath = this.getServletContext().getAttribute("view");
			if(StringUtils.isEmpty(viewPath)){
				LoggerUtils.error(getClass(), "on view..");
			}else{
				viewPath += view.toString();
			}
			request.getRequestDispatcher(viewPath.toString()).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public HttpServletResponse getResponse() {
		return OutUtil.getResponse(response, OutTypeEnum.HTML);
	}
	
	public ServletContext getApplication() {
		return context;
	}

	public PrintWriter getPrintWriter() {
		try {
			return getResponse().getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return printWriter;
	}

	public PrintStream getPrintStream() throws IOException {
		return new PrintStream(getResponse().getOutputStream());
	}

	public ServletOutputStream getServletOutputStream() throws IOException {
		return getResponse().getOutputStream();
	}
	
	public void out(Object content) {
		this.out(content, OutTypeEnum.HTML);
	}
	
	public void out(Object content, OutTypeEnum outType) {
		OutUtil.out(response, content, outType);
	}
	
	public void setResponseNoCache() {
		getResponse().setHeader("progma", "no-cache");
		getResponse().setHeader("Cache-Control", "no-cache");
		getResponse().setHeader("Cache-Control", "no-store");
		getResponse().setDateHeader("Expires", 0);
	}
	
	protected String getCurrentAction(){
		return request.getHeader("referer");
	}
	
	
}
