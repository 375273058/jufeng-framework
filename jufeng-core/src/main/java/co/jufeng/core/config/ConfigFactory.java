package co.jufeng.core.config;


import java.io.File;
import java.io.IOException;
import java.io.InputStream; 
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties; 
import java.util.Set;

import co.jufeng.core.enums.ConfigTypeEnum;
import co.jufeng.core.io.FileUtil;
import co.jufeng.core.json.JSONObject;
import co.jufeng.core.util.XmlConverUtil;

public class ConfigFactory implements IConfig{
	
	private final static Map<Object, Object> CONTENT_MAP_DATA = new HashMap<Object, Object>();
	
	private ConfigFactory(){
		Map<ConfigTypeEnum, File> fileMap = new HashMap<ConfigTypeEnum, File>();
		String dir = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    	File file = new File(dir);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			String extensionName = FileUtil.getExtensionName(files[i].getName());
			if(extensionName.equals(ConfigTypeEnum.PROPERTIES.value)){
				fileMap.put(ConfigTypeEnum.PROPERTIES, files[i]);
				this.load(fileMap);
			}else if (extensionName.equals(ConfigTypeEnum.JSON.value)){
				fileMap.put(ConfigTypeEnum.JSON, files[i]);
				this.load(fileMap);
			}else if (extensionName.equals(ConfigTypeEnum.XML.value)){
				fileMap.put(ConfigTypeEnum.XML, files[i]);
				this.load(fileMap);
			}
		}
	}
	
    private static final class Holder{
        private static final ConfigFactory instance = new ConfigFactory();
    }
    
    public static ConfigFactory getInstance(){
        return Holder.instance;
    }

	@Override
	public void load(Map<ConfigTypeEnum, File> fileMap) {
		try {
			InputStream inputStream = null;
			for (int i = 0; i < fileMap.size(); i++) {
				Set<ConfigTypeEnum> set = fileMap.keySet();
				for (ConfigTypeEnum type : set) {
					switch (type) {
					case PROPERTIES:
						Map<Object, Object> properties = get(type);
						if(properties == null){
							properties = new HashMap<Object, Object>();
						}
						inputStream = getInputStream(fileMap, type);
		            	Properties props = new Properties();
		            	props.load(inputStream);
		    			@SuppressWarnings({ "unchecked", "rawtypes" })
						Map<String, String> map = new HashMap<String, String>((Map) props);  
		    			Set<Map.Entry<String, String>> propertySet = map.entrySet();
		    			Iterator<Map.Entry<String, String>> it = propertySet.iterator();
		    			while (it.hasNext()) {
							Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
							properties.put(entry.getKey(), entry.getValue());
						}
		    			
		                CONTENT_MAP_DATA.put(type, properties);
						break;
						
					case JSON:
						Map<Object, Object> json = new HashMap<Object, Object>();
						inputStream = getInputStream(fileMap, type);
						StringBuffer sb = inputStreamToString(inputStream);
				        JSONObject jsonObject = JSONObject.parseObject(sb.toString());  
				        Iterator<String> jsonIt = jsonObject.keySet().iterator();
				        while (jsonIt.hasNext()) {  
				           String key = String.valueOf(jsonIt.next());  
				           Object value = jsonObject.get(key);  
				           json.put(key, value);  
				        }  
				        CONTENT_MAP_DATA.put(type, json);
						break;
						
					case XML:
						inputStream = getInputStream(fileMap, type);
						StringBuffer xmlSb = inputStreamToString(inputStream);
						CONTENT_MAP_DATA.put(type, XmlConverUtil.xml2map(xmlSb.toString()));
						break;
	
					default:
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private StringBuffer inputStreamToString(InputStream inputStream) {
		StringBuffer sb = new StringBuffer();
		byte[] b = new byte[1024];
		int len = 0;
		try {
			while ((len = inputStream.read(b)) != -1) {
				sb.append(new String(b, 0, len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb;
	}


	private InputStream getInputStream(Map<ConfigTypeEnum, File> fileMap, ConfigTypeEnum type) {
		File file = fileMap.get(type);
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(file.getName());
		return inputStream;
	}
	
	public Object get(String key) {
		return CONTENT_MAP_DATA.get(key);
	}
	
	public String getString(String key) {
		return String.valueOf(CONTENT_MAP_DATA.get(key));
	}
	
	@SuppressWarnings("unchecked")
	public Map<Object, Object> get(ConfigTypeEnum configTypeEnum) {
		return (Map<Object, Object> )CONTENT_MAP_DATA.get(configTypeEnum);
	}
	
	@SuppressWarnings("unchecked")
	public String getString(ConfigTypeEnum configTypeEnum, String key) {
		Map<Object, Object> map = (Map<Object, Object>) CONTENT_MAP_DATA.get(configTypeEnum);
		return String.valueOf(map.get(key));
	}
	
	public Map<Object, Object> getAll() {
		return CONTENT_MAP_DATA;
	}
	
}