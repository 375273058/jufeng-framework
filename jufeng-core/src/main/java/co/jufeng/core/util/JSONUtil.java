//package co.jufeng.core.util;
//
//import java.beans.IntrospectionException;
//import java.beans.Introspector;
//import java.beans.PropertyDescriptor;
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import net.sf.json.JsonConfig;
//import net.sf.json.util.CycleDetectionStrategy;
//import net.sf.json.util.PropertyFilter;
//
//
//
//import com.alibaba.fastjson.JSON;
//
//
//public class JSONUtil {
//	
//	/**
//	 * 把对象转换成JSON字体串
//	 * 
//	 * @param object
//	 * @return String
//	 */
//	public static String toJSONString(Object object) {
//		return toJSONString(object, null);
//	}
//
//	public static String toJSONString(Object object, String dateFormat) {
//		StringBuffer sb = new StringBuffer();
//		String jsonString = null;
//		if ("".equals(dateFormat) || null == dateFormat) {
//			sb.append("yyyy-MM-dd HH:mm:ss.sss");
//		} else {
//			sb.append(dateFormat);
//		}
////		if(object instanceof List){
////			jsonString = com.alibaba.fastjson.JSON.toJSONStringWithDateFormat(object, sb.toString()).replaceFirst("\\[", "").replaceFirst("\\]", "");
////		}else{
//			jsonString = com.alibaba.fastjson.JSON.toJSONStringWithDateFormat(object, sb.toString());
////		}
//		return jsonString;
//	}
//
//	public static String toJSONStringNull(Object object){
//		return toJSONStringNull(object, null);
//	}
//
//	public static String toJSONStringNull(Object object, String dateFormat) {
//		return toJSONStringNull(object, dateFormat, null);
//	}
//
//	public static String toJSONStringNull(Object object, String dateFormat,	final String excludes){
//		String jsonString = null;
//		try {
//			JsonConfig jsonConfig = new JsonConfig();
//			jsonConfig.setIgnoreDefaultExcludes(false);
//			jsonConfig
//					.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
//			jsonConfig.registerJsonValueProcessor(java.util.Date.class,
//					new JsonDateProcessor(dateFormat));
//			jsonConfig.registerJsonValueProcessor(java.sql.Timestamp.class,
//					new JsonDateProcessor(dateFormat));
//			jsonConfig.setExcludes(new String[] { "hibernateLazyInitializer",
//					"handler", "creator", "modifier" }); 
//			jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
//				@Override
//				public boolean apply(Object source, String name, Object value) {
//					String[] array;
//					if (excludes == null) {
//						array = new String[] { "creator", "modifier" };
//					} else {
//						array = excludes.split(",");
//					}
//					for (int i = 0; i < array.length;) {
//						if (name.equals(array[i])) {
//							return true;
//						} else {
//							return false;
//						}
//					}
//					return false;
//				}
//			});
//			if (object != null) {
//				if (object instanceof Collection || object instanceof Object[]) {
//					jsonString = JSONArray.fromObject(object, jsonConfig)
//							.toString();
//				} else {
//					jsonString = JSONObject.fromObject(object, jsonConfig)
//							.toString();
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return jsonString == null ? "{}" : jsonString;
//	}
//
//	public static String toMapJSONStr(Map<?, ?> map) {
//		JsonConfig jsonConfig = new JsonConfig();
//		JsonDateProcessor beanProcessor = new JsonDateProcessor();
//		jsonConfig.registerJsonValueProcessor(Date.class, beanProcessor);
//		JSONObject jsonObject = JSONObject.fromObject(map, jsonConfig);
//		return jsonObject.toString();
//	}
//
//	public static Object toJavaObject(String jsonStr, Class<?> clazz) {
//		return JSON.toJavaObject(JSON.parseObject(jsonStr), clazz);
//	}
//	
//	
//	public static String object2json(Object obj) {
//		StringBuilder json = new StringBuilder();
//		if (obj == null) {
//			json.append("\"\"");
//		} else if (obj instanceof String || obj instanceof Integer
//				|| obj instanceof Float || obj instanceof Boolean
//				|| obj instanceof Short || obj instanceof Double
//				|| obj instanceof Long || obj instanceof BigDecimal
//				|| obj instanceof BigInteger || obj instanceof Byte) {
//			json.append("\"").append(string2json(obj.toString())).append("\"");
//		} else if (obj instanceof Object[]) {
//			json.append(array2json((Object[]) obj));
//		} else if (obj instanceof List) {
//			json.append(list2json((List<?>) obj));
//		} else if (obj instanceof Map) {
//			json.append(map2json((Map<?, ?>) obj));
//		} else if (obj instanceof Set) {
//			json.append(set2json((Set<?>) obj));
//		} else {
//			json.append(bean2json(obj));
//		}
//		return json.toString();
//	}
//
//	public static String bean2json(Object bean) {
//		StringBuilder json = new StringBuilder();
//		json.append("{");
//		PropertyDescriptor[] props = null;
//		try {
//			props = Introspector.getBeanInfo(bean.getClass(), Object.class)
//					.getPropertyDescriptors();
//		} catch (IntrospectionException e) {
//		}
//		if (props != null) {
//			for (int i = 0; i < props.length; i++) {
//				try {
//					String name = object2json(props[i].getName());
//					String value = object2json(props[i].getReadMethod().invoke(
//							bean));
//					json.append(name);
//					json.append(":");
//					json.append(value);
//					json.append(",");
//				} catch (Exception e) {
//				}
//			}
//			json.setCharAt(json.length() - 1, '}');
//		} else {
//			json.append("}");
//		}
//		return json.toString();
//	}
//
//	public static String list2json(List<?> list) {
//		StringBuilder json = new StringBuilder();
//		json.append("[");
//		if (list != null && list.size() > 0) {
//			for (Object obj : list) {
//				json.append(object2json(obj));
//				json.append(",");
//			}
//			json.setCharAt(json.length() - 1, ']');
//		} else {
//			json.append("]");
//		}
//		return json.toString();
//	}
//
//	public static String array2json(Object[] array) {
//		StringBuilder json = new StringBuilder();
//		json.append("[");
//		if (array != null && array.length > 0) {
//			for (Object obj : array) {
//				json.append(object2json(obj));
//				json.append(",");
//			}
//			json.setCharAt(json.length() - 1, ']');
//		} else {
//			json.append("]");
//		}
//		return json.toString();
//	}
//
//	public static String map2json(Map<?, ?> map) {
//		StringBuilder json = new StringBuilder();
//		json.append("{");
//		if (map != null && map.size() > 0) {
//			for (Object key : map.keySet()) {
//				json.append(object2json(key));
//				json.append(":");
//				json.append(object2json(map.get(key)));
//				json.append(",");
//			}
//			json.setCharAt(json.length() - 1, '}');
//		} else {
//			json.append("}");
//		}
//		return json.toString();
//	}
//
//	public static String set2json(Set<?> set) {
//		StringBuilder json = new StringBuilder();
//		json.append("[");
//		if (set != null && set.size() > 0) {
//			for (Object obj : set) {
//				json.append(object2json(obj));
//				json.append(",");
//			}
//			json.setCharAt(json.length() - 1, ']');
//		} else {
//			json.append("]");
//		}
//		return json.toString();
//	}
//
//	public static String string2json(String s) {
//		if (s == null)
//			return "";
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < s.length(); i++) {
//			char ch = s.charAt(i);
//			switch (ch) {
//			case '"':
//				sb.append("\\\"");
//				break;
//			case '\\':
//				sb.append("\\\\");
//				break;
//			case '\b':
//				sb.append("\\b");
//				break;
//			case '\f':
//				sb.append("\\f");
//				break;
//			case '\n':
//				sb.append("\\n");
//				break;
//			case '\r':
//				sb.append("\\r");
//				break;
//			case '\t':
//				sb.append("\\t");
//				break;
//			case '/':
////				sb.append("\\/");
//				sb.append("/");
//				break;
//			default:
//				if (ch >= '\u0000' && ch <= '\u001F') {
//					String ss = Integer.toHexString(ch);
//					sb.append("\\u");
//					for (int k = 0; k < 4 - ss.length(); k++) {
//						sb.append('0');
//					}
//					sb.append(ss.toUpperCase());
//				} else {
//					sb.append(ch);
//				}
//			}
//		}
//		return sb.toString();
//	}
//
//	
//}
