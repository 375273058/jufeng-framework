package co.jufeng.core.sms;


import java.io.Serializable;

import co.jufeng.core.config.ConfigFactory;
import co.jufeng.core.enums.ConfigTypeEnum;
import co.jufeng.core.javabean.SmsVO;

public enum SmsEnums implements ISms {

	INSTANCE;

	@Override
	public Serializable send(SmsVO smsVO) {
//		return ExecuteAction.send(smsVO);
		String xml = ConfigFactory.getInstance().getString(ConfigTypeEnum.PROPERTIES, "sms.xml");
		if(smsVO.getSerializableType() == null){
			return xml;
		}else{
			return smsVO.getSerializableType().toType(xml);
		}
	}
}