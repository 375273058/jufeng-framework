package co.jufeng.web.servlet;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
 
	private static final long serialVersionUID = 7458814851615064912L;
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String uri = request.getRequestURI();
        uri = uri.substring(request.getContextPath().length(), uri.length() - 3);
        String methodName = null;
        if(uri.indexOf("!") > 0){
        	String[] uriAndMethodName = uri.split("!");
        	uri = uriAndMethodName[0];
        	methodName = uriAndMethodName[1];
        }
        @SuppressWarnings("unchecked")
        Map<String,Object> map = (Map<String,Object>) this.getServletContext().getAttribute("mapPath");
         
        if (map.containsKey(uri)) {
            Object obj = map.get(uri);
            if (methodName == null) {
                methodName = "index";
            }
            Method method = null;
            try {
                method = obj.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            } catch (Exception e) {
                throw new RuntimeException(obj.getClass().getName()  + " no " + methodName);
            }
            try {
                method.invoke(obj, request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    
}