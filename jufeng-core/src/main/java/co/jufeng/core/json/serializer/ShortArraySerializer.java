package co.jufeng.core.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class ShortArraySerializer implements ObjectSerializer {

    public static ShortArraySerializer instance = new ShortArraySerializer();

    public final void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType) throws IOException {
        SerializeWriter out = serializer.getWriter();
        
        if (object == null) {
            if (out.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
                out.write("[]");
            } else {
                out.writeNull();
            }
            return;
        }
        
        short[] array = (short[]) object;
        out.write('[');
        for (int i = 0; i < array.length; ++i) {
            if (i != 0) {
                out.write(',');
            }
            out.writeInt(array[i]);
        }
        out.write(']');
    }
}
