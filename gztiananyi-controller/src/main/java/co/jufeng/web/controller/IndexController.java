package co.jufeng.web.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jufeng.web.servlet.bind.annotation.RestController;

@RestController
public class IndexController {
	
    public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	System.out.println("================================index");
    	request.setAttribute("title", "首页");
        request.getRequestDispatcher("/WEB-INF/views/jsp/index.jsp").forward(request, response);
    }
    
    public void main(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	System.out.println("=================main=================");
    	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("zs", "张三");
    	map.put("ls", "李四");
    	list.add(map);
    	request.setAttribute("main", list);
        request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request, response);
    }
}