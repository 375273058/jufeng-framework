package co.jufeng.core.sms;

import java.io.Serializable;

import co.jufeng.core.config.ConfigFactory;
import co.jufeng.core.javabean.SmsVO;
import co.jufeng.core.sms.action.ExecuteAction;

public class Sms implements ISms {

	private Sms(){
	}
	
    /**
     *    类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     *    没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载。
     */
    private static final class SmsHolder{
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static final Sms instance = new Sms();
    }
    
    public static Sms getInstance(){
        return SmsHolder.instance;
    }

	@Override
	public Serializable send(SmsVO smsVO) {
		return ExecuteAction.send(smsVO);
//		return smsVO.getSerializableType().toType(ConfigFactory.getInstance().getString("xml"));
	}

}
