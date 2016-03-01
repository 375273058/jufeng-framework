
package co.jufeng.core.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;

import co.jufeng.core.json.parser.DefaultJSONParser;
import co.jufeng.core.json.parser.JSONLexer;
import co.jufeng.core.json.parser.JSONToken;
import co.jufeng.core.json.parser.deserializer.ObjectDeserializer;
import co.jufeng.core.json.util.TypeUtils;

public class LongCodec implements ObjectSerializer, ObjectDeserializer {

    public static LongCodec instance = new LongCodec();

    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType) throws IOException {
        SerializeWriter out = serializer.getWriter();

        if (object == null) {
            if (out.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
                out.write('0');
            } else {
                out.writeNull();
            }
            return;
        }

        long value = ((Long) object).longValue();
        out.writeLong(value);

        if (serializer.isEnabled(SerializerFeature.WriteClassName)) {
            if (value <= Integer.MAX_VALUE && value >= Integer.MIN_VALUE) {
                if (fieldType != Long.class) {
                    out.write('L');
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
        final JSONLexer lexer = parser.getLexer();

        Long longObject;
        if (lexer.token() == JSONToken.LITERAL_INT) {
            long longValue = lexer.longValue();
            lexer.nextToken(JSONToken.COMMA);
            longObject = Long.valueOf(longValue);
        } else {

            Object value = parser.parse();

            if (value == null) {
                return null;
            }

            longObject = TypeUtils.castToLong(value);
        }
        
        if (clazz == AtomicLong.class) {
            return (T) new AtomicLong(longObject.longValue());
        }
        
        return (T) longObject;
    }

    public int getFastMatchToken() {
        return JSONToken.LITERAL_INT;
    }
}
