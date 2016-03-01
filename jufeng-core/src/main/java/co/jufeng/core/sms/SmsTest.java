package co.jufeng.core.sms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import co.jufeng.core.ISerializableType;
import co.jufeng.core.SerializableMap;
import co.jufeng.core.config.ConfigFactory;
import co.jufeng.core.enums.ConfigTypeEnum;
import co.jufeng.core.javabean.SmsVO;
import co.jufeng.core.logger.LoggerUtils;

public class SmsTest{
	

	public static void main(String[] args) {
//		LoggerUtils.info(SmsTest.class, enumsSend());
		LoggerUtils.info(SmsTest.class, send());
	}
	
	private static SmsVO getSmsVO() {
		List<String> moblies = new ArrayList<String>();
//		moblies.add("18122328912");
//		moblies.add("18122328850");
//		moblies.add("15902013452");
//		moblies.add("13680699966");
		moblies.add("13822119203");
//		String context = "病从口入，埃博拉极瘟疫来自外国流入中国，简称SARS变种，不要吃街边摆摊和露天食物，买回家的食物务必煮开用，防范在行切记！";
		String context = "天天好心情。";
//		String context = "最近天气老耍酷，不是降温就下雾。诸葛赤壁借东风，我趁寒潮送祝福。寒潮来时祝福到，祝福里面捎棉袄。天冷穿上能御寒，祝你健康到永远！";
		
		SmsVO smsVO = new SmsVO(moblies, context, new SerializableMap());
		return smsVO;
	}
	
	private static Serializable send() {
		SmsVO smsVO = getSmsVO();
		Serializable serializable = Sms.getInstance().send(smsVO);
		return serializable;
	}
	
	//http://121.199.45.184/login.do 后台登录
	private static Serializable enumsSend() {
		SmsVO smsVO = getSmsVO();
		Serializable serializable = SmsEnums.INSTANCE.send(smsVO);
		return serializable;
	}

}
