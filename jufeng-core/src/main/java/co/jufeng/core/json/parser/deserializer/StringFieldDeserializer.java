package co.jufeng.core.json.parser.deserializer;

import java.lang.reflect.Type;
import java.util.Map;

import co.jufeng.core.json.parser.DefaultJSONParser;
import co.jufeng.core.json.parser.JSONLexer;
import co.jufeng.core.json.parser.JSONToken;
import co.jufeng.core.json.parser.ParserConfig;
import co.jufeng.core.json.util.FieldInfo;

public class StringFieldDeserializer extends FieldDeserializer {

    private final ObjectDeserializer fieldValueDeserilizer;

    public StringFieldDeserializer(ParserConfig config, Class<?> clazz, FieldInfo fieldInfo){
        super(clazz, fieldInfo);

        fieldValueDeserilizer = config.getDeserializer(fieldInfo);
    }

    @Override
    public void parseField(DefaultJSONParser parser, Object object, Type objectType, Map<String, Object> fieldValues) {
        String value;

        final JSONLexer lexer = parser.getLexer();
        if (lexer.token() == JSONToken.LITERAL_STRING) {
            value = lexer.stringVal();
            lexer.nextToken(JSONToken.COMMA);
        } else {

            Object obj = parser.parse();

            if (obj == null) {
                value = null;
            } else {
                value = obj.toString();
            }
        }

        if (object == null) {
            fieldValues.put(fieldInfo.getName(), value);
        } else {
            setValue(object, value);
        }
    }

    public int getFastMatchToken() {
        return fieldValueDeserilizer.getFastMatchToken();
    }
}
