package co.jufeng.core.util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtils {
	
	public static boolean isEmpty(Object str) {
		if (str == null || str.equals("") || "null".equals(str) || "-1".equals(str + "")) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String str = "-1";
		System.out.println(isEmpty(str));
	}

	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
	
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

}
