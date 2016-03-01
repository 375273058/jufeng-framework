package co.jufeng.core.sms;

import java.io.Serializable;

import co.jufeng.core.javabean.SmsVO;

public interface ISms extends Cloneable {
	
	public Serializable send(SmsVO smsVO);
	
	
	
}
