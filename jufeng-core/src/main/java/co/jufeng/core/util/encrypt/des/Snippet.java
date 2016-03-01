package co.jufeng.core.util.encrypt.des;

import co.jufeng.core.util.encrypt.Key;

public class Snippet {
	public static void main(String[] args) {
			DES des = new DES(Key.DES_KEY); // 实例化一个对像
			String strEnc = des.getEncString("123456");// 加密字符串,返回String的密文
			System.out.println(strEnc);
			String strDes = des.getDesString(strEnc);// 把String 类型的密文解密
			System.out.println(strDes);
	
		}
}

