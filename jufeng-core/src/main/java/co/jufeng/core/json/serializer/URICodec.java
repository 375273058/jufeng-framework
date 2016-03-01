package co.jufeng.core.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;

import co.jufeng.core.json.parser.DefaultJSONParser;
import co.jufeng.core.json.parser.JSONToken;
import co.jufeng.core.json.parser.deserializer.ObjectDeserializer;

public class URICodec implements ObjectSerializer, ObjectDeserializer {

    public final static URICodec instance = new URICodec();

    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType) throws IOException {
        if (object == null) {
            serializer.writeNull();
            return;
        }

        URI uri = (URI) object;
        serializer.write(uri.toString());
    }

    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type clazz, Object fieldName) {
        
        String uri = (String) parser.parse();
        
        if (uri == null) {
            return null;
        }
        
        return (T) URI.create(uri);
    }

    public int getFastMatchToken() {
        return JSONToken.LITERAL_STRING;
    }
}
