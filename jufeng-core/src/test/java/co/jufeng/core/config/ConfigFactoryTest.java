package co.jufeng.core.config;

import co.jufeng.core.config.ConfigFactory;
import junit.framework.TestCase;

public class ConfigFactoryTest extends TestCase{
	
	public void testGetAll() {
		System.out.println(ConfigFactory.getInstance().getAll());
	}
	
	public static void main(String[] ager){
		System.out.println(ConfigFactory.getInstance().getAll());
	}
}
