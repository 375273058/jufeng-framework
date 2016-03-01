//package co.jufeng.core.exception;
//
//import co.jufeng.core.util.TraceInfoUtil;
//import co.jufeng.hibernate.dao.IHibernateAccessor;
//import co.jufeng.logger.util.LoggerUtils;
//import co.jufeng.model.entity.Exceptions;
//
///**
// * 处理异常和日志
// * @author Administrator
// *
// */
//public class BaseException extends Exception{
//
//	private static final long serialVersionUID = 6885698426846999041L;
//	
//	public BaseException() {
//	}
//
//	public BaseException(String smg) {
//		super(smg);
//	}
//	
//	@Override
//	public void printStackTrace() {
//		printStackTrace(System.err);
//	}
//	
//	public void printStackTrace(Class<?> clazz, Exception e) {
//		throwsException(clazz, e);
//	}
//	
//	public void printStackTrace(Class<?> clazz, Exception e, IHibernateAccessor hibernateAccessor) {
//		throwsException(clazz, e, hibernateAccessor);
//	}
//	
//	public static void throwsException(Class<?> clazz, Throwable throwable) {
//		throwsException(clazz, throwable.getMessage(), throwable, null);
//	}
//
//	public static void throwsException(Class<?> clazz, Throwable throwable, IHibernateAccessor hibernateAccessor) {
//		throwsException(clazz, throwable.getMessage(), throwable, hibernateAccessor);
//	}
//	
//	public static void throwsException(Class<?> clazz, String addExceptionNoteMessage, Throwable throwable, IHibernateAccessor hibernateAccessor) {
//		try {
//			int exceptionLine = TraceInfoUtil.getExceptionLine(clazz, throwable);
//			String exceptionType = TraceInfoUtil.getExceptionMessage(throwable);
//			LoggerUtils.error(clazz, throwable);
//			if(null != hibernateAccessor){
//				Exceptions exceptions = new Exceptions(clazz.toString(), addExceptionNoteMessage, exceptionType, exceptionLine);
//				hibernateAccessor.beginTransaction();
//				hibernateAccessor.save(exceptions);
//				hibernateAccessor.commit();
//			}
//		} catch (Exception e) {
//			LoggerUtils.error(BaseException.class, e);
//		}
//	}
//
//	
//}
