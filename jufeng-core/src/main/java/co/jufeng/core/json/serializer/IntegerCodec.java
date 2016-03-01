package co.jufeng.core.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

import co.jufeng.core.json.parser.DefaultJSONParser;
import co.jufeng.core.json.parser.JSONLexer;
import co.jufeng.core.json.parser.JSONToken;
import co.jufeng.core.json.parser.deserializer.ObjectDeserializer;
import co.jufeng.core.json.util.TypeUtils;

public class IntegerCodec implements ObjectSerializer, ObjectDeserializer {

    public static IntegerCodec instance = new IntegerCodec();

    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType) throws IOException {
        SerializeWriter out = serializer.getWriter();

        Number value = (Number) object;
        
        if (value == null) {
            if (out.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
                out.write('0');
            } else {
                out.writeNull();
            }
            return;
        }
        
        out.writeInt(value.intValue());
    }
    
    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
        final JSONLexer lexer = parser.getLexer();

        if (lexer.token() == JSONToken.NULL) {
            lexer.nextToken(JSONToken.COMMA);
            return null;
        }

        Integer intObj;
        if (lexer.token() == JSONToken.LITERAL_INT) {
            int val = lexer.intValue();
            lexer.nextToken(JSONToken.COMMA);
            intObj = Integer.valueOf(val);
        } else if (lexer.token() == JSONToken.LITERAL_FLOAT) {
            BigDecimal decimalValue = lexer.decimalValue();
            lexer.nextToken(JSONToken.COMMA);
            intObj = Integer.valueOf(decimalValue.intValue());
        } else {
            Object value = parser.parse();

            intObj = TypeUtils.castToInt(value);
        }
        
        if (clazz == AtomicInteger.class) {
            return (T) new AtomicInteger(intObj.intValue());
        }
        
        return (T) intObj;
    }

    public int getFastMatchToken() {
        return JSONToken.LITERAL_INT;
    }
}
