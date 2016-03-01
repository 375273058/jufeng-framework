//package co.jufeng.core.util;
//
//import java.io.Writer;
//import java.lang.reflect.Type;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.codehaus.jackson.map.ObjectMapper;
//
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.serializer.JSONSerializer;
//import com.alibaba.fastjson.serializer.SerializeConfig;
//import com.alibaba.fastjson.serializer.SerializeWriter;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
//import com.alibaba.fastjson.serializer.ValueFilter;
//
//public class JSONUtils extends JSONObject{
//	
//	public static final long serialVersionUID = 3010936258853728396L;
//	
//	public static SerializeConfig SERIALIZE_CONFIG = new SerializeConfig();  
//	
//	public static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
//    
//    static{  
//    	setDateFormat(Date.class, DEFAULT_DATE_FORMAT);
//    } 
//    
//    public JSONUtils() {
//	}
//    
//    static void setDateFormat(Type type, String dateFormat){
//    	if(dateFormat.equals("") || dateFormat == null){
//    		SERIALIZE_CONFIG.put(Date.class, new SimpleDateFormatSerializer(DEFAULT_DATE_FORMAT));
//    	}else{
//    		SERIALIZE_CONFIG.put(type, new SimpleDateFormatSerializer(dateFormat));
//    	}
//    }
//    
//    public static String toString(Object object) {
//    	return toString(object, DEFAULT_DATE_FORMAT);
//    }
//	
//    public static String toString(Object object, String dateFormat) {
//    	return toString(object, null, dateFormat);
//    }
//    
//    public static String toString(Object object, Type type) {
//    	return toString(object, type, DEFAULT_DATE_FORMAT);
//    }
//    
//    public static String toString(Object object, Type type, String dateFormat) {
//    	if(null == type){
//    		setDateFormat(Date.class, dateFormat);
//    	}else{
//    		setDateFormat(type, dateFormat);
//    	}
//    	return toJSONString(object, SERIALIZE_CONFIG);
//    }
//    
//    /**
//     * 输出JSON字符串null值不转换
//     * @param w
//     * @param value
//     */
//    public static void writeAsNull(Writer w, Object object){
//	    try {//2014-04-09T02:39:16.968+0000
////	    	objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,  false);
//	    	ObjectMapper objectMapper = new ObjectMapper();  
//            SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);  
//            objectMapper.setDateFormat(format); 
//	    	objectMapper.writeValue(w, object);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//    }
//    
//    /**
//     * 输出JSON字符串null值不转换
//     * @param w
//     * @param value
//     */
//    public static void writeAsString(Writer w, Object object, SerializerFeature... features){
//    	writeJSONStringTo(object, w, features);
//    }
//    
//    /**
//     * null值不转换
//     * @param object
//     * @return
//     */
//    public static String toStringAsNull(Object object){
//    	String jsonString = null;
//	    try {
//	    	ObjectMapper objectMapper = new ObjectMapper();  
//            SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);  
//            objectMapper.setDateFormat(format); 
//            jsonString = objectMapper.writeValueAsString(object);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return jsonString;
//    }
//    
//    /**
//     * null值转换为""
//     * @param object
//     * @param features
//     * @return
//     */
//    public static String toStringAsString(Object object, SerializerFeature ...features) {  
//        SerializeWriter out = new SerializeWriter();  
//        String s;  
//        JSONSerializer serializer = new JSONSerializer(out);  
//        SerializerFeature arr$[] = features;  
//        int len$ = arr$.length;  
//        for (int i$ = 0; i$ < len$; i$++) {  
//            SerializerFeature feature = arr$[i$];  
//            serializer.config(feature, true);  
//        }  
//  
//        serializer.getValueFilters().add(new ValueFilter() {  
//            public Object process(Object obj, String s, Object value) {  
//                if(null!=value) {  
//                    if(value instanceof java.util.Date) {  
//                        return String.format("%1$tF %1tT", value);  
//                    }  
//                    return value;  
//                }else {  
//                    return "";  
//                }  
//            }  
//        });  
//        serializer.write(object);  
//        s = out.toString();  
//        out.close();  
//        return s;  
//    }  
//    
//}
//
//
//
//
//
//
//
//
//
//
//
//
