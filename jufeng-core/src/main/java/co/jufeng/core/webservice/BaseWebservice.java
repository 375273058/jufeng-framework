//package co.jufeng.core.webservice;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import javax.xml.ws.WebServiceContext;
//import javax.xml.ws.handler.MessageContext;
//
//import co.jufeng.core.enums.KeyEnum;
//import co.jufeng.core.util.MD5EncryptUtil;
//import co.jufeng.core.util.StringUtils;
//
//import com.alibaba.fastjson.JSONObject;
//
//public class BaseWebservice implements IBaseWebservice {
//
//	@Resource
//	private WebServiceContext wsContext;
//	private MessageContext mc;
//	private HttpSession session;
//	private HttpServletRequest request;
//
//	@Override
//	public AuthenticateResult validRequest(String jsonString) {
//		if (StringUtils.isEmpty(jsonString)) {
//			return null;
//		}
//		init();
//		JSONObject jsonObject = JSONObject.parseObject(jsonString);
//		String userName = jsonObject.getString(KeyEnum.USER_NAME.getValue());
//		String password = jsonObject.getString(KeyEnum.PASSWORD.getValue());
//		String md5KL = MD5EncryptUtil.getMd5KL(password);
//		// 暂时代码验证
//		if ("短信受权人名".equals(userName)&& "LDBDDDC@@A@DLADGACA".equals(md5KL)) {
//			AuthenticateResult authenticateResult = new AuthenticateResult();
//			authenticateResult.setAttribute("userName", userName);
//			return authenticateResult;
//		}
//		return null;
//	}
//
//	/**
//	 * 初始化内置对象
//	 */
//	private void init() {
//		try {
//			
//			mc = wsContext.getMessageContext();
//			request = (HttpServletRequest) mc.get(MessageContext.SERVLET_REQUEST);
//			System.out.println(request.getLocalAddr());
//			if (mc != null) {
////				session = request.getSession(true);
//				session = (HttpSession) ((javax.servlet.ServletContext) mc.get(MessageContext.SERVLET_CONTEXT)).getAttribute("session");
//				if (session != null) {
//					session.getAttribute("key").toString();
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
