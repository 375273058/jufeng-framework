package co.jufeng.core.i18n;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

public interface II18n {
	
	public String getMessage(Locale locale, String key, Object... args);
	
	public String getMessage(HttpServletRequest request, String key, Object... args);

}
