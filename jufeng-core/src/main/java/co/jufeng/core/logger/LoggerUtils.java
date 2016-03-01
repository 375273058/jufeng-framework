package co.jufeng.core.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.jufeng.core.util.TraceInfoUtil;



public final class LoggerUtils {

	public static Logger logger;
	
	static{
//		init();
	}
//	
//	public static void init() {
//		System.out.println(PathUtil.getClassesPath());
////		String logbackCfg = PathUtil.getClassesPath() + "co/jufeng/config/logger/logback.xml"; 
//		String logbackCfg = "/co/jufeng/config/logger/logback.xml";
//		try {
//			URL logURL = new ClassPathResource(logbackCfg).getURL();
//			ILoggerFactory loggerFactory = LoggerFactory.getILoggerFactory();  
//			LoggerContext loggerContext = (LoggerContext) loggerFactory;  
////			loggerContext.shutdownAndReset();  
//			JoranConfigurator configurator = new JoranConfigurator();  
//			configurator.setContext(loggerContext);  
//			configurator.doConfigure(logURL); 
//			StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}  
//		 debug(LoggerUtils.class, "init {}", "debug message"); 
//	}

	public static void error(Class<?> clazz, Object... messages) {
		logger = LoggerFactory.getLogger(clazz);
		logger.error(toString(messages));
	}
	
	public static void error(Class<?> clazz, String format, Object... messages) {
		logger = LoggerFactory.getLogger(clazz);
		logger.error(format, toString(messages));
	}
	
	public static void error(Class<?> clazz, Throwable throwable, Object... messages) {
		logger = LoggerFactory.getLogger(clazz);
		int exceptionLine = TraceInfoUtil.getExceptionLine(clazz, throwable);
		String exceptionType = TraceInfoUtil.getExceptionMessage(throwable);
		logger.error(toString(messages) + throwable.getMessage() + " - " + exceptionType + " line number - " + exceptionLine);
	}
	
	public static void error(Class<?> clazz, String format, Throwable throwable, Object... messages) {
		logger = LoggerFactory.getLogger(clazz);
		int exceptionLine = TraceInfoUtil.getExceptionLine(clazz, throwable);
		String exceptionType = TraceInfoUtil.getExceptionMessage(throwable);
		logger.error(format, toString(messages) + throwable.getMessage() + " - " + exceptionType + " line number - " + exceptionLine);
	}
	
	public static void debug(Class<?> clazz, Object... messages) {
		logger = LoggerFactory.getLogger(clazz);
		logger.debug(toString(messages));
	}
	
	public static void debug(Class<?> clazz, String format, Object... messages) {
		logger = LoggerFactory.getLogger(clazz);
		logger.debug(format, toString(messages));
	}

	public static void debug(Class<?> clazz, Throwable throwable, Object... messages) {
		logger = LoggerFactory.getLogger(clazz);
		int exceptionLine = TraceInfoUtil.getExceptionLine(clazz, throwable);
		String exceptionType = TraceInfoUtil.getExceptionMessage(throwable);
		logger.debug(toString(messages) + throwable.getMessage() + " - " + exceptionType + " line number - " + exceptionLine);
	}
	
	public static void debug(Class<?> clazz, String format, Throwable throwable, Object... messages) {
		logger = LoggerFactory.getLogger(clazz);
		int exceptionLine = TraceInfoUtil.getExceptionLine(clazz, throwable);
		String exceptionType = TraceInfoUtil.getExceptionMessage(throwable);
		logger.debug(format, toString(messages) + throwable.getMessage() + " - " + exceptionType + " line number - " + exceptionLine);
	}

	public static void info(Class<?> clazz, Object... messages) {
		logger = LoggerFactory.getLogger(clazz);
		logger.info(toString(messages));
	}
	
	public static void info(Class<?> clazz, String format, Object... messages) {
		logger = LoggerFactory.getLogger(clazz);
		logger.info(format, toString(messages));
	}

	public static void info(Class<?> clazz, Throwable throwable, Object... messages) {
		logger = LoggerFactory.getLogger(clazz);
		int exceptionLine = TraceInfoUtil.getExceptionLine(clazz, throwable);
		String exceptionType = TraceInfoUtil.getExceptionMessage(throwable);
		logger.info(toString(messages) + throwable.getMessage() + " - " + exceptionType + " line number - " + exceptionLine);
	}
	
	public static void info(Class<?> clazz, String format, Throwable throwable, Object... messages) {
		logger = LoggerFactory.getLogger(clazz);
		int exceptionLine = TraceInfoUtil.getExceptionLine(clazz, throwable);
		String exceptionType = TraceInfoUtil.getExceptionMessage(throwable);
		logger.info(format, toString(messages) + throwable.getMessage() + " - " + exceptionType + " line number - " + exceptionLine);
	}
	
	public static String toString(Object...messages){
		String string = "";
		for (int i = 0; i < messages.length; i++) {
			string += messages[i];
		}
		return string;
	}

}












