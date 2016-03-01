package co.jufeng.web.controller.admin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jufeng.model.jufeng.Product;
import co.jufeng.web.servlet.bind.annotation.RestController;

@RestController
public class ServicesController {
	
    public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	System.out.println("================================index");
    	List<Product> productList = new ArrayList<Product>();
    	for (int i = 0; i < 30; i++) {
    		Product product = new Product();
    		product.setName("梦想" + i);
    		product.setPhotos("bd_logo1_31bdc765.png");
    		product.setDetails("产品详情产品详情产品详情产品详情产品详情产品详情产品详情产品");
    		product.setPrice(new BigDecimal(i + 1.5));
    		productList.add(product);
		}
    	request.setAttribute("title", "列表");
    	request.setAttribute("uri", "services");
    	request.setAttribute("productList", productList);
        request.getRequestDispatcher("/WEB-INF/views/jsp/admin/services.jsp").forward(request, response);
    }
    
}