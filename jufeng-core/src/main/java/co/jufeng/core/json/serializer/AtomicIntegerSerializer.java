package co.jufeng.core.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerSerializer implements ObjectSerializer {

    public final static AtomicIntegerSerializer instance = new AtomicIntegerSerializer();

    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType) throws IOException {
        SerializeWriter out = serializer.getWriter();

        AtomicInteger val = (AtomicInteger) object;
        out.writeInt(val.get());
    }

}
