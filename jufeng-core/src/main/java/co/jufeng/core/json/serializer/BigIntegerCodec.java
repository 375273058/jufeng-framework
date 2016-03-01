package co.jufeng.core.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;

import co.jufeng.core.json.parser.DefaultJSONParser;
import co.jufeng.core.json.parser.JSONLexer;
import co.jufeng.core.json.parser.JSONToken;
import co.jufeng.core.json.parser.deserializer.ObjectDeserializer;
import co.jufeng.core.json.util.TypeUtils;

public class BigIntegerCodec implements ObjectSerializer, ObjectDeserializer {

    public final static BigIntegerCodec instance = new BigIntegerCodec();

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
        
        BigInteger val = (BigInteger) object;
        out.write(val.toString());
    }

    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
        return (T) deserialze(parser);
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserialze(DefaultJSONParser parser) {
        final JSONLexer lexer = parser.getLexer();
        if (lexer.token() == JSONToken.LITERAL_INT) {
            String val = lexer.numberString();
            lexer.nextToken(JSONToken.COMMA);
            return (T) new BigInteger(val);
        }

        Object value = parser.parse();

        if (value == null) {
            return null;
        }

        return (T) TypeUtils.castToBigInteger(value);
    }

    public int getFastMatchToken() {
        return JSONToken.LITERAL_INT;
    }
}
