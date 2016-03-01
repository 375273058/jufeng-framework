package co.jufeng.core.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicIntegerArray;

import co.jufeng.core.json.JSONArray;
import co.jufeng.core.json.parser.DefaultJSONParser;
import co.jufeng.core.json.parser.JSONToken;
import co.jufeng.core.json.parser.deserializer.ObjectDeserializer;

public class AtomicIntegerArrayCodec implements ObjectSerializer, ObjectDeserializer {

    public final static AtomicIntegerArrayCodec instance = new AtomicIntegerArrayCodec();

    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType) throws IOException {
        SerializeWriter out = serializer.getWriter();

        if (object == null) {
            if (out.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
                out.write("[]");
            } else {
                out.writeNull();
            }
            return;
        }

        AtomicIntegerArray array = (AtomicIntegerArray) object;
        int len = array.length();
        out.append('[');
        for (int i = 0; i < len; ++i) {
            int val = array.get(i);
            if (i != 0) {
                out.write(',');
            }
            out.writeInt(val);
        }
        out.append(']');
    }

    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
        if (parser.getLexer().token() == JSONToken.NULL) {
            parser.getLexer().nextToken(JSONToken.COMMA);
            return null;
        }

        JSONArray array = new JSONArray();
        parser.parseArray(array);

        AtomicIntegerArray atomicArray = new AtomicIntegerArray(array.size());
        for (int i = 0; i < array.size(); ++i) {
            atomicArray.set(i, array.getInteger(i));
        }

        return (T) atomicArray;
    }

    public int getFastMatchToken() {
        return JSONToken.LBRACKET;
    }
}
