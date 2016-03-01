package co.jufeng.core.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

import co.jufeng.core.json.parser.DefaultJSONParser;
import co.jufeng.core.json.parser.JSONToken;
import co.jufeng.core.json.parser.deserializer.ObjectDeserializer;
import co.jufeng.core.json.util.TypeUtils;

public class CharacterCodec implements ObjectSerializer, ObjectDeserializer {

    public final static CharacterCodec instance = new CharacterCodec();

    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType) throws IOException {
        SerializeWriter out = serializer.getWriter();

        Character value = (Character) object;
        if (value == null) {
            out.writeString("");
            return;
        }

        char c = value.charValue();
        if (c == 0) {
            out.writeString("\u0000");
        } else {
            out.writeString(value.toString());
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
        Object value = parser.parse();

        if (value == null) {
            return null;
        }
        
        return (T) TypeUtils.castToChar(value);
    }

    public int getFastMatchToken() {
        return JSONToken.LITERAL_STRING;
    }
}
