package co.jufeng.core.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesUtil {

	static PropertiesUtil uniqueInstance = null;

	static Properties PROPERTIES;
	
	PropertiesUtil() {
	}

	public static PropertiesUtil getInstance(String propertiesPath) {
		try {
			if (uniqueInstance == null) {
				uniqueInstance = new PropertiesUtil();
				FileInputStream fileInputStream = new FileInputStream(propertiesPath);
				InputStream in = new BufferedInputStream(fileInputStream);
				PROPERTIES = new Properties();
				PROPERTIES.load(in);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return uniqueInstance;
	}

	public String getString(String key) {
		return PROPERTIES.getProperty(key);
	}
	
	public String[] getStringArray(String key, String split) {
		return PROPERTIES.getProperty(key).split(split);
	}
	
	public Object getObject(String key) {
		return PROPERTIES.get(key);
	}
	
	public Enumeration<?> getKeys() {
		return PROPERTIES.keys();
	}

	public int getInt(String key) {
		try {
			String value = PROPERTIES.getProperty(key);
			if (null != value) {
				return Integer.valueOf(value);
			} else {
				return -1;
			}
		} catch (Exception e) {
			return -1;
		}
	}

	public boolean update(String propertiesFilePath, String key, int value) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(key, value);

			File file = new File(propertiesFilePath);
			Properties pro = new Properties();
			FileInputStream fis = null;
			BufferedInputStream bis = null;

			if (!map.isEmpty()) {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				pro.load(bis);
				FileOutputStream fos = new FileOutputStream(file);
				Set<Map.Entry<String, Object>> set = map.entrySet();
				Iterator<Map.Entry<String, Object>> it = set.iterator();
				while (it.hasNext()) {
					Map.Entry<java.lang.String, java.lang.Object> entry = (Map.Entry<java.lang.String, java.lang.Object>) it
							.next();
					pro.setProperty(entry.getKey(),
							String.valueOf(entry.getValue()));
				}
				pro.store(fos, null);
				fos.close();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// 写入Properties信息
	public void add(String filePath, String pKey, String pValue)
			throws IOException {
		Properties pps = new Properties();
		InputStream in = new FileInputStream(filePath);
		// 从输入流中读取属性列表（键和元素对）
		pps.load(in);
		// 调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
		// 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
		OutputStream out = new FileOutputStream(filePath);
		pps.setProperty(pKey, pValue);
		// 以适合使用 load 方法加载到 Properties 表中的格式，
		// 将此 Properties 表中的属性列表（键和元素对）写入输出流
		pps.store(out, "Update " + pKey + " name");
	}

}
