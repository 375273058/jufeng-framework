package co.jufeng.web.www.core.base;


import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import co.jufeng.core.enums.ActionWrapperTypeEnum;
import co.jufeng.core.enums.KeyEnum;
import co.jufeng.core.enums.OutTypeEnum;
import co.jufeng.core.factory.action.IAction;
import co.jufeng.core.io.FileUtil;
import co.jufeng.core.util.FreeMarkerUtil;
import co.jufeng.core.util.PathUtil;
import co.jufeng.core.util.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport implements ServletResponseAware, ServletRequestAware, ServletContextAware, RequestAware, SessionAware, ApplicationAware {

	private static final long serialVersionUID = 475550380959389466L;
	
	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	private ServletContext context;
	
	private Map<String, Object> requestMap;
	
	private Map<String, Object> sessionMap;
	
	private Map<String, Object> application;
	
	private PrintWriter printWriter;
	
	@Deprecated
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	public Map<String, Object> getApplication() {
		return application;
	}
	
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	
	public HttpSession getHttpSession() {
		return request.getSession();
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public Map<String, Object> getRequestMap() {
		return requestMap;
	}
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.requestMap = request;
	}

	public ServletContext getContext() {
		return context;
	}
	
	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
	
	//获取请求上下文，  页面读取可以使用：${requestScope.version} 或 ${key} ActionContext 和HttpServletRequest对象是同等级。
	public ActionContext getActionContext() {
		return ActionContext.getContext();
	}

	public HttpServletRequest getHttpRequest() {
		return request;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public HttpServletResponse getResponse() {
		return getResponse(OutTypeEnum.HTML);
	}
	
	public HttpServletResponse getResponse(OutTypeEnum OutTypeEnum) {
		response.setContentType(OutTypeEnum.getValue() + ";charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		return response;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
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
		out(content, OutTypeEnum.HTML);
	}
	
	public void out(Object content, OutTypeEnum type) {
		try {
			printWriter = getResponse(type).getWriter();
			printWriter.write(content.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != printWriter){
				printWriter.flush();
				printWriter.close();
			}
		}
	}

	//设置页面不缓存
	public void setResponseNoCache() {
		getResponse().setHeader("progma", "no-cache");
		getResponse().setHeader("Cache-Control", "no-cache");
		getResponse().setHeader("Cache-Control", "no-store");
		getResponse().setDateHeader("Expires", 0);
	}
	
	protected String getCurrentAction(){
		return getHttpRequest().getHeader("referer");
	}
	
	public static String getIpAddr() {
        Object ip = ServletActionContext.getRequest().getHeader("X-Forwarded-For".toLowerCase());
        if (ip == null  || "unknown".equalsIgnoreCase(ip.toString())) {
            ip = ServletActionContext.getRequest().getHeader("Proxy-Client-IP".toLowerCase());
        }
        if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
            ip = ServletActionContext.getRequest().getHeader("WL-Proxy-Client-IP".toLowerCase());
        }
        if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
            ip = ServletActionContext.getRequest().getHeader("HTTP_CLIENT_IP".toLowerCase());
        }
        if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
            ip = ServletActionContext.getRequest().getHeader("HTTP_X_FORWARDED_FOR".toLowerCase());
        }
        if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
            ip = ServletActionContext.getRequest().getRemoteAddr();
        }
        return ip.toString();
    }
	
	//打开浏览器
	protected Process openYourBrowser(String url) throws Exception{
		Process process = Runtime.getRuntime().exec("cmd /c start " + url); 
		process .waitFor();
		return process;
	}
	
	protected Process openURL(String url) throws Exception {
		String osName = System.getProperty("os.name");
		System.out.println("###osName:" + osName);
		// System.gc();
		Process p = null;
		int exitCode = 1;
		if (osName.startsWith("Mac")) {// Mac OS
			Class<?> fileMgr = Class.forName("com.apple.eio.FileManager");
			Method openURL = fileMgr.getDeclaredMethod("openURL",
					new Class[] { String.class });
			openURL.invoke(null, new Object[] { url });
		} else if (osName.startsWith("Windows")) {// Windows
			
//			p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
			
			p = Runtime.getRuntime().exec("cmd /c start " + url); 

			// System.out.println("###p:" + p);
			// System.out.println("###p.hashCode():" + p.hashCode());

			exitCode = p.waitFor();
			System.out.println("###exitCode:" + exitCode);
		} else { // Unix or Linux
			String[] browsers = { "firefox", "opera", "konqueror",
					"epiphany", "mozilla", "netscape" };
			String browser = null;
			for (int count = 0; count < browsers.length && browser == null; count++) {
				if (Runtime.getRuntime()
						.exec(new String[] { "which", browsers[count] })
						.waitFor() == 0) {
					browser = browsers[count];
				}
			}
			if (browser == null) {
				throw new Exception("Could not find web browser");
			} else {
				Runtime.getRuntime().exec(new String[] { browser, url });
			}
		}
		return p;
	}
	
	public void getRequestDispatcher(String actionView) throws ServletException, IOException{
		getHttpRequest().getRequestDispatcher(getApplication().get("basePath") + actionView).forward(getHttpRequest(), getResponse());
	}
	
	public void sendRedirect(String actionView) throws IOException{
		getResponse().sendRedirect(actionView);
	}

//	@Override
//	public <T> T getBean(ActionWrapperTypeEnum actionWrapperType, Class<T> clazz) {
//		T t = null;
//		
//		switch (actionWrapperType) {
//		case REQUEST:
//			t = clazz.cast(request);
//			break;
//
//		case SESSION:
//			HttpSession session = request.getSession();
//			t = clazz.cast(session);
//			break;
//			
//		case RESPONSE:
//			t = clazz.cast(response);
//			break;
//			
//		case PRINT_WRITER:
//			t = clazz.cast(printWriter);
//			break;
//			
//		default:
//			break;
//		}
//		return t;
//	}
//
//	@Override
//	public HttpServletRequest getRequest() {
//		return request;
//	}
//
//	@Override
//	public HttpSession getSession() {
//		return request.getSession();
//	}
//
//	@Override
//	public ServletContext getServletContext() {
//		return request.getSession().getServletContext();
//	}
	
//	public String createHTML(String ftlName, Map<String, Object> root){
//		return createHTML(ftlName, null, root);
//	}
	
//	public String createHTML(String ftlName, String folder, Map<String, Object> root){
//		return createHTML(ftlName, null, folder, root);
//	}
	
//	public String createHTML(String ftlName, String htmlName, String folder, Map<String, Object> root){
//		try {
//			String path = null;
//			if(null == htmlName){
//				htmlName = ftlName;
//			}
//			if(StringUtils.isEmpty(folder)){
//				path = PathUtil.getWebRootPath();
//				FreeMarkerUtil.createFile(ftlName + ".ftl", getClientTemplatePath(), root, path + htmlName + ".html");
//			
//			}else{
//				path = PathUtil.getWebRootPath() + "html" + PathUtil.separator() + folder + PathUtil.separator() ;
//				if(FileUtil.creatDirs(path)){
//					FreeMarkerUtil.createFile(ftlName + ".ftl", getClientTemplatePath(), root, path + htmlName + ".html");
//				}
//			}
//		} catch (Exception e) {
//			return "error";
//		}
//		if(null != folder){
//			return getSession().getAttribute(KeyEnum.BASE_PATH.getValue()) + "html" + PathUtil.separator() + folder + PathUtil.separator() + ftlName + ".html";
//		}else{
//			return getSession().getAttribute(KeyEnum.BASE_PATH.getValue()) + ftlName + ".html";
//		}
//	}
	
//	public String getClientTemplatePath(){
//		return PathUtil.getWEBINFPath() + "views/ftl/"+ getSession().getAttribute(KeyEnum.ADMIN_SKIN.getValue());
//	}
	
}



