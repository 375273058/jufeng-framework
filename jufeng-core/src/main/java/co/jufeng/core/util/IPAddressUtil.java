package co.jufeng.core.util;

import javax.servlet.http.HttpServletRequest;

public class IPAddressUtil {
	
	public String getIpAddr(HttpServletRequest request) {
        Object ip = request.getHeader("X-Forwarded-For".toLowerCase());
        if (ip == null  || "unknown".equalsIgnoreCase(ip.toString())) {
            ip = request.getHeader("Proxy-Client-IP".toLowerCase());
        }
        if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
            ip = request.getHeader("WL-Proxy-Client-IP".toLowerCase());
        }
        if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
            ip = request.getHeader("HTTP_CLIENT_IP".toLowerCase());
        }
        if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR".toLowerCase());
        }
        if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
            ip = request.getRemoteAddr();
        }
        return ip.toString();
    }

}
