package co.jufeng.context;

import java.util.Locale;

public interface MessageSource {

	String getMessage(String code, Object[] args, String defaultMessage, Locale locale);

	String getMessage(String code, Object[] args, Locale locale) throws Exception;

	String getMessage(MessageSourceResolvable resolvable, Locale locale) throws Exception;

}
