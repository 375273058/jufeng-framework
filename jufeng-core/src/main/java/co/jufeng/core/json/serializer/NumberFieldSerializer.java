package co.jufeng.core.json.serializer;

import co.jufeng.core.json.util.FieldInfo;

final class NumberFieldSerializer extends FieldSerializer {

    public NumberFieldSerializer(FieldInfo fieldInfo){
        super(fieldInfo);
    }

    public void writeProperty(JSONSerializer serializer, Object propertyValue) throws Exception {
        writePrefix(serializer);
        this.writeValue(serializer, propertyValue);
    }

    @Override
    public void writeValue(JSONSerializer serializer, Object propertyValue) throws Exception {
        SerializeWriter out = serializer.getWriter();

        Object value = propertyValue;

        if (value == null) {
            if (out.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
                out.write('0');
            } else {
                out.writeNull();
            }
            return;
        }

        out.append(value.toString());
    }
}
