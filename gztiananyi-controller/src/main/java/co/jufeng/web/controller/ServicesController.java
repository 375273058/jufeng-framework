package co.jufeng.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jufeng.web.servlet.bind.annotation.RestController;

@RestController
public class ServicesController {
	
    public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	System.out.println(this);
    	request.setAttribute("title", "关于我们");
        request.getRequestDispatcher("/WEB-INF/views/jsp/services.jsp").forward(request, response);
    }
    
}