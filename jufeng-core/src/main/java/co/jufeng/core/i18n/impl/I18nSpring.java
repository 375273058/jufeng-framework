//package co.jufeng.core.i18n.impl;
//
//import java.util.Locale;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//import org.springframework.web.servlet.support.RequestContext;
//
//import co.jufeng.core.i18n.II18n;
//
//public class I18nSpring implements II18n{
//	
//	String WARNING;
//	
//	Object[] ARGS;
//	
//	public static I18nSpring newInstance(){
//		return new I18nSpring();
//	}
//	
//	private I18nSpring() {
//	}
//	
//	
//
//	/**
//	 * 获取信息
//	 * @param request 请求对象
//	 * @param key 国际化资源文件中所定义的key
//	 * @return 字符串
//	 */
//	public String getMessage(HttpServletRequest request, String key){
//		return getMessage(request, key, ARGS);
//	}
//	
//	/**
//	 * 获取信息
//	 * @param request 请求对象
//	 * @param key 国际化资源文件中所定义的key
//	 * @param args 参数值一个或多个 对应国际化资源文件中value中的{0}{1}
//	 * @return 字符串
//	 */
//	@Override
//	public String getMessage(HttpServletRequest request, String key, Object... args){
//		RequestContext requestContext = new RequestContext(request);
//    	Locale locale = requestContext.getLocale();
//    	ServletContext servletContext = request.getServletContext();
//    	ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext); 
//    	if(null == WARNING || "".equals(WARNING)){
//    		WARNING = applicationContext.getMessage("i18nNoKeyWarning", null, locale);
//    	}
//		return applicationContext.getMessage(key, args, WARNING, locale);
//	}
//	
//	public String getMessage(Locale locale, String key) {
//		return getMessage(locale, key, ARGS);
//	}
//
//	@Override
//	public String getMessage(Locale locale, String key, Object... args) {
//		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
//    	ServletContext servletContext = request.getServletContext();
//    	ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext); 
//    	if(null == WARNING || "".equals(WARNING)){
//    		WARNING = applicationContext.getMessage("i18nNoKeyWarning", null, locale);
//    	}
//		return applicationContext.getMessage(key, args, WARNING, locale);
//	}
//
//}
