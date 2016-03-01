package co.jufeng.core.sms.action;

import java.io.Serializable;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import co.jufeng.core.ISerializableType;
import co.jufeng.core.config.ConfigFactory;
import co.jufeng.core.enums.ConfigTypeEnum;
import co.jufeng.core.javabean.SmsVO;

public final class ExecuteAction {
	
	public static Serializable send(SmsVO smsVO){
		Serializable result = null;
		try {
			HttpClient client = new HttpClient();
			client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
			PostMethod post = new PostMethod(ConfigFactory.getInstance().getString(ConfigTypeEnum.PROPERTIES, "sms.url"));
			NameValuePair username = new NameValuePair("username", ConfigFactory.getInstance().getString(ConfigTypeEnum.PROPERTIES, "sms.userName"));
			NameValuePair password = new NameValuePair("password", ConfigFactory.getInstance().getString(ConfigTypeEnum.PROPERTIES, "sms.password"));
			NameValuePair mobile = new NameValuePair("mobile", smsVO.getMoblies().toString().replace("[", "").replace("]", ""));
			NameValuePair content = new NameValuePair("content", smsVO.getContent());
			NameValuePair[] nameValuePairs = new NameValuePair[] { username, password, mobile, content };
			post.setRequestBody(nameValuePairs);
			client.executeMethod(post);
			result = post.getResponseBodyAsString();
			post.releaseConnection();
			ISerializableType serializableType = smsVO.getSerializableType();
			if(null == serializableType){
				return result;
			}else{
				return serializableType.toType(result);
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
