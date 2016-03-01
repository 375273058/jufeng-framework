package co.jufeng.core;

import java.io.Serializable;
import java.util.HashMap;

import co.jufeng.core.json.JSONObject;


public class SerializableMap implements ISerializableType {

	@Override
	public Serializable toType(Object object) {
		SerializableJSON json = new SerializableJSON();
		JSONObject jsonObject = (JSONObject) json.toType(object);
		return new HashMap<String, Object>(jsonObject);
	}

}
