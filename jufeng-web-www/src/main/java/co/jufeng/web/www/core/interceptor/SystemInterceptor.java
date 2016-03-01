package co.jufeng.web.www.core.interceptor;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import co.jufeng.core.config.ConfigFactory;
import co.jufeng.core.enums.ConfigTypeEnum;
import co.jufeng.core.enums.KeyEnum;
import co.jufeng.web.www.core.base.BaseInterceptor;

import com.opensymphony.xwork2.ActionInvocation;

public class SystemInterceptor extends BaseInterceptor<SystemInterceptor, Serializable> { 

	private static final long serialVersionUID = 7758359832135424902L;
	
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		try {
			super.init(actionInvocation);
			getResponse().setHeader("Access-Control-Allow-Origin", "*");
			getSession().setAttribute(KeyEnum.BASE_PATH.getValue(), ConfigFactory.getInstance().getString(ConfigTypeEnum.PROPERTIES, KeyEnum.BASE_PATH.getValue()));
			System.out.println(getRequest().getRequestURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actionInvocation.invoke(); 
	}

	public Map<String, Object> getSystemMessage() throws UnknownHostException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userAgent", getRequest().getHeader("User-Agent")); //就是取得客户端的系统版本 
		map.put("remoteAddr", getRequest().getRemoteAddr());        //取得客户端的IP   
		map.put("remoteHost", getRequest().getRemoteHost());		//取得客户端的主机名    
		map.put("remotePort", getRequest().getRemotePort());		//取得客户端的端口   
		map.put("remoteUser", getRequest().getRemoteUser());		//取得客户端的用户     
		map.put("localAddr", getRequest().getLocalAddr());			//取得本地IP
		map.put("localPort", getRequest().getLocalPort());			//取得本地端口
		InetAddress inet = InetAddress.getLocalHost();
		map.put("ip",  inet.getHostAddress());
		map.put("userDir",  System.getProperties().get("user.dir"));
		map.put("systemProperties",  System.getProperties());
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
