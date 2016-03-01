//package co.jufeng.core.i18n.impl;
//
//import java.text.MessageFormat;
//import java.util.Locale;
//
//import javax.servlet.http.HttpServletRequest;
//
//import co.jufeng.core.i18n.II18n;
//
//import com.opensymphony.xwork2.ActionContext;
//import com.opensymphony.xwork2.ActionSupport;
//
//public class I18nStruts extends ActionSupport implements II18n{
//	
//	private static final long serialVersionUID = -390419034504204813L;
//
//	String WARNING = "i18n.no.key.warning";
//	
//	Object[] ARGS;
//	
//	private static final class Holder{
//		 private static final I18nStruts I18N_STRUTS = new I18nStruts();
//	}
//	
//	public static I18nStruts newInstance(){
//		return Holder.I18N_STRUTS;
//	}
//	
//	private I18nStruts() {
//	}
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
//		return getMessage(request.getLocale(), key, args);
//	}
//	
//	public String getMessage(Locale locale, String key) {
//		return getMessage(locale, key, ARGS);
//	}
//
//	@Override
//	public String getMessage(Locale locale, String key, Object... args) {
//		ActionContext actionContext = ActionContext.getContext();
//		actionContext.setLocale(locale);
//		String value = getText(key);
//		if(key.equals(value)){
//			return getText(WARNING);
//		}else{
//			return MessageFormat.format(value, args);
//		}
//	}
//
//}
