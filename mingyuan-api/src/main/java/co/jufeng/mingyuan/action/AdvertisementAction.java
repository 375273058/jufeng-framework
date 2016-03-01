package co.jufeng.mingyuan.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jufeng.core.enums.OutTypeEnum;
import co.jufeng.core.enums.PropertyEnum;
import co.jufeng.core.net.HttpRequestUtil;
import co.jufeng.core.util.OutUtil;
import co.jufeng.core.util.RequestUtil;
import co.jufeng.dao.hibernate.criterion.impl.Eq;
import co.jufeng.dao.hibernate.criterion.impl.Property;
import co.jufeng.dao.hibernate.factory.impl.EntityFactory;
import co.jufeng.model.mingyuan.Advertisement;
import co.jufeng.model.vo.AdvertisementVO;
import co.jufeng.model.vo.ApiResultVo;

@WebServlet(value = { "/advertisement", "/advertisement1" }, description = "广告数据API", initParams = { @WebInitParam(name = "type", value = "0") })
public class AdvertisementAction extends BaseHttpServlet {
	private static final long serialVersionUID = 9128208958838336726L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
//			String type = request.getAttribute("type").toString();
			String type = request.getParameter("type").toString();
//			String type = RequestUtil.toObject(request).getOrDefault("type",
//					"-1");
			List<AdvertisementVO> userList = (List<AdvertisementVO>) getAccessor()
					.get(EntityFactory.add(PropertyEnum.ALIAS, true,
							Advertisement.class),
							Eq.add("type", Integer.valueOf(type)),
							Property.add(AdvertisementVO.class.getName(), "url"));

			ApiResultVo apiResultVo = new ApiResultVo(userList, "广告API");
			OutUtil.out(response, apiResultVo, OutTypeEnum.JSON);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
