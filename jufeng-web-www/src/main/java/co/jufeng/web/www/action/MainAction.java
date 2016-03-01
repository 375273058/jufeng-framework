package co.jufeng.web.www.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;

import co.jufeng.core.logger.LoggerUtils;
import co.jufeng.web.www.core.base.BaseAction;

//http://127.0.0.1:8080/jufeng-web-www/config-browser/actionNames.jf
@InterceptorRefs({
	@InterceptorRef("systemInterceptor"),
	@InterceptorRef("defaultStack")
})
public class MainAction extends BaseAction{
	
	private static final long serialVersionUID = 5766620234375010913L;
	
	@Override
	public void validate() {
		super.validate();
	}
	
	public String index() throws Exception {
		LoggerUtils.debug(getClass(), getCurrentAction());
		return "index";
	}
	
	public String contact() throws Exception {
		LoggerUtils.debug(getClass(), getCurrentAction());
		return "contact";
	}

	
}
