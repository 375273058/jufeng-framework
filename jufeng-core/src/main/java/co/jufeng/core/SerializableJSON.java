package co.jufeng.core;

import java.io.Serializable;


import co.jufeng.core.json.JSONObject;
import co.jufeng.core.util.XmlConverUtil;

public class SerializableJSON implements ISerializableType {

	@Override
	public Serializable toType(Object object) {
		String jsonString = XmlConverUtil.toJsonString(object.toString());
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		return jsonObject;
	}
	

}
