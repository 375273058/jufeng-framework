package co.jufeng.core.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanSerializer implements ObjectSerializer {

    public final static AtomicBooleanSerializer instance = new AtomicBooleanSerializer();

    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType) throws IOException {
        SerializeWriter out = serializer.getWriter();

        AtomicBoolean val = (AtomicBoolean) object;
        if (val.get()) {
            out.append("true");
        } else {
            out.append("false");
        }
    }

}
