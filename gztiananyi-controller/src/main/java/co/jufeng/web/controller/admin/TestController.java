package co.jufeng.web.controller.admin;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jufeng.core.enums.ScopeTypeEnum;
import co.jufeng.core.factory.action.ActionSupport;
import co.jufeng.web.servlet.ModelAndView;
import co.jufeng.web.servlet.bind.annotation.RestController;

@RestController
public class TestController extends ActionSupport{
	
	private static final long serialVersionUID = -7255404790942629299L;
	

	@Override
	public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("====" + 99);
		String strValue = "this is String";  
        Date myDate  = new Date();  
        Object[] objectArray = new Object[]{1,"str",1.2};  
          
        Set<Object> setData = new HashSet<Object>();  
        setData.add("dataValue1");  
        setData.add("dataValue2");  
        setData.add("dataValue3");  
          
        List<String> strList = new ArrayList<String>();  
        strList.add("字符串1");  
        strList.add("字符串2");  
        strList.add("字符串3");  
          
        Map<String,Object> map = new HashMap<String, Object>();  
        map.put("key1", "value1");  
        map.put("key2", "value2");  
        map.put("key3", "value3");  
          
        ModelAndView modelAndView = new ModelAndView(request, response); 
        modelAndView.addObject("strValue", strValue). 
        addObject("objectArray", objectArray).
        addObject("strList", strList).
        addObject("map", map).
        addObject("myDate", myDate). 
        addObject("setData", setData).
        addViewName("ftl/admin/test.ftl").action();
        
        
	}
	
	public void main(HttpServletRequest request, HttpServletResponse response){
		try {
			System.out.println("main...");
			ModelAndView modelAndView = new ModelAndView(request, response); 
			modelAndView.addObject("request", "请求响应后自动消除").
			addObject("session", "请求会话结束后清除", ScopeTypeEnum.SESSION).
			addObject("application", "应用服务器重启或停止后清除", ScopeTypeEnum.APPLICATION).
			addViewName("/WEB-INF/views/ftl/admin/main.ftl").action();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}