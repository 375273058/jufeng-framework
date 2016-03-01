package co.jufeng.core.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import co.jufeng.core.enums.OutTypeEnum;

public class OutUtil {
	
	public synchronized static boolean out(HttpServletResponse response, Object content){
		return out(response, content, OutTypeEnum.HTML);
	}
	
	public synchronized static boolean out(HttpServletResponse response, Object content, OutTypeEnum outType){
		PrintWriter printWriter = null;
		try {
			switch (outType) {
			case JSON:
				content = JSONObject.toJSONString(content);
				break;

			default:
				break;
			}
			printWriter = getResponse(response, outType).getWriter();
			printWriter.write(content.toString());
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}finally{
			if(null != printWriter){
				printWriter.flush();
				printWriter.close();
			}
		}
		return true;
	}
	
	public static HttpServletResponse getResponse(HttpServletResponse response, OutTypeEnum outType) {
		response.setContentType(outType.getValue() + ";charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		return response;
	}

}
