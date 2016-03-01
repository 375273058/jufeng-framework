package co.jufeng.web.controller.admin;
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
    	request.setAttribute("title", "后台首页");
    	request.setAttribute("uri", "index");
        request.getRequestDispatcher("/WEB-INF/views/jsp/admin/index.jsp").forward(request, response);
    }
    
}