package co.jufeng.core.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameValuePair {
	
	String[] filterName = {"serialVersionUID"};
	
	private NameValuePair(){
	}
	
    private static final class NameValuePairHolder{
        private static final NameValuePair instance = new NameValuePair();
    }
    
    public static NameValuePair getInstance(){
        return NameValuePairHolder.instance;
    }
	
	//根据属性名获取属性值
	public Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			return null;
		}
	}

	//获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
	public List<Map<String, Object>> getFiledsInfo(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> infoMap = null;
		for (int i = 0; i < fields.length; i++) {
			infoMap = new HashMap<String, Object>();
			infoMap.put("type", fields[i].getType().toString());
			infoMap.put("name", fields[i].getName());
			infoMap.put("value", getFieldValueByName(fields[i].getName(), o));
			list.add(infoMap);
		}
		return list;
	}
	
	//获取属性名(name)，属性值(value)的map
	public Map<String, Object> getFiledsInfoMap(Object o) {
		return getFiledsInfoMap(o, filterName);
	}

	//获取属性名(name)，属性值(value)的map
	public Map<String, Object> getFiledsInfoMap(Object o, String... filterName) {
		Field[] fields = o.getClass().getDeclaredFields();
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			for (int j = 0; j < filterName.length; j++) {
				if(name.equals(filterName[j])){
					continue;
				}
				map.put(name, getFieldValueByName(name, o));
			}
		}
		return map;
	}
	
	//获取属性名数组
	public String[] getFiledName(Object o) {
		return getFiledName(o, filterName);
	}
	
	//获取属性名数组
	public String[] getFiledName(Object o, String... filterName) {
		Field[] fields = o.getClass().getDeclaredFields();
		List<String> nameList = new ArrayList<String>();
		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			for (int j = 0; j < filterName.length; j++) {
				if(name.equals(filterName[j])){
					continue;
				}
				nameList.add(name);
			}
		}
		String[] stringArray = new String[nameList.size()];
		return nameList.toArray(stringArray);
	}
	
	//获取对象的所有属性值，返回一个对象数组
	public Object[] getFiledValues(Object o) {
		return getFiledValues(o, filterName);
	}

	//获取对象的所有属性值，返回一个对象数组
	public Object[] getFiledValues(Object o, String... filterName) {
		String[] fieldNames = this.getFiledName(o);
		List<Object> valueList = new ArrayList<Object>();
		for (int i = 0; i < fieldNames.length; i++) {
			for (int j = 0; j < filterName.length; j++) {
				String name = fieldNames[i];
				if(name.equals(filterName[j])){
					continue;
				}
				Object valueObject = getFieldValueByName(fieldNames[i], o);
				valueList.add(valueObject);
			}
		}
		return valueList.toArray();
	}

}
