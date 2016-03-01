package co.jufeng.core.json.parser.deserializer;

import java.lang.reflect.Type;

import co.jufeng.core.json.parser.DefaultJSONParser;

public interface ObjectDeserializer {
    <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName);
    
    int getFastMatchToken();
}
