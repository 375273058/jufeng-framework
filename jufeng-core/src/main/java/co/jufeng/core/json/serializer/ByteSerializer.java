package co.jufeng.core.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class ByteSerializer implements ObjectSerializer {

    public static ByteSerializer instance = new ByteSerializer();

    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType) throws IOException {
        SerializeWriter out = serializer.getWriter();

        Number numberValue = (Number) object;

        if (numberValue == null) {
            if (out.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
                out.write('0');
            } else {
                out.writeNull();
            }
            return;
        }

        short value = ((Number) object).shortValue();
        out.writeInt(value);

        if (serializer.isEnabled(SerializerFeature.WriteClassName)) {
            out.write('B');
        }
    }
}
