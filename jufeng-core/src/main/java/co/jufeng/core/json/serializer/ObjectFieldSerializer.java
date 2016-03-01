package co.jufeng.core.json.serializer;

import java.util.Collection;

import co.jufeng.core.json.annotation.JSONField;
import co.jufeng.core.json.util.FieldInfo;

public class ObjectFieldSerializer extends FieldSerializer {

    private ObjectSerializer fieldSerializer;

    private Class<?>         runtimeFieldClass;
    private String           format;
    private boolean          writeNumberAsZero       = false;
    boolean                  writeNullStringAsEmpty  = false;
    boolean                  writeNullBooleanAsFalse = false;
    boolean                  writeNullListAsEmpty    = false;
    boolean                  writeEnumUsingToString  = false;

    public ObjectFieldSerializer(FieldInfo fieldInfo){
        super(fieldInfo);

        JSONField annotation = fieldInfo.getAnnotation(JSONField.class);

        if (annotation != null) {
            format = annotation.format();

            if (format.trim().length() == 0) {
                format = null;
            }

            for (SerializerFeature feature : annotation.serialzeFeatures()) {
                if (feature == SerializerFeature.WriteNullNumberAsZero) {
                    writeNumberAsZero = true;
                } else if (feature == SerializerFeature.WriteNullStringAsEmpty) {
                    writeNullStringAsEmpty = true;
                } else if (feature == SerializerFeature.WriteNullBooleanAsFalse) {
                    writeNullBooleanAsFalse = true;
                } else if (feature == SerializerFeature.WriteNullListAsEmpty) {
                    writeNullListAsEmpty = true;
                } else if (feature == SerializerFeature.WriteEnumUsingToString) {
                    writeEnumUsingToString = true;
                }
            }
        }
    }

    public void writeProperty(JSONSerializer serializer, Object propertyValue) throws Exception {
        writePrefix(serializer);
        writeValue(serializer, propertyValue);
    }

    @Override
    public void writeValue(JSONSerializer serializer, Object propertyValue) throws Exception {
        if (format != null) {
            serializer.writeWithFormat(propertyValue, format);
            return;
        }

        if (fieldSerializer == null) {

            if (propertyValue == null) {
                runtimeFieldClass = this.fieldInfo.getFieldClass();
            } else {
                runtimeFieldClass = propertyValue.getClass();
            }

            fieldSerializer = serializer.getObjectWriter(runtimeFieldClass);
        }

        if (propertyValue == null) {
            if (writeNumberAsZero && Number.class.isAssignableFrom(runtimeFieldClass)) {
                serializer.getWriter().write('0');
                return;
            } else if (writeNullStringAsEmpty && String.class == runtimeFieldClass) {
                serializer.getWriter().write("\"\"");
                return;
            } else if (writeNullBooleanAsFalse && Boolean.class == runtimeFieldClass) {
                serializer.getWriter().write("false");
                return;
            } else if (writeNullListAsEmpty && Collection.class.isAssignableFrom(runtimeFieldClass)) {
                serializer.getWriter().write("[]");
                return;
            }

            fieldSerializer.write(serializer, null, fieldInfo.getName(), null);
            return;
        }

        if (writeEnumUsingToString == true && runtimeFieldClass.isEnum()) {
            serializer.getWriter().writeString(((Enum<?>) propertyValue).name());
            return;
        }

        Class<?> valueClass = propertyValue.getClass();
        if (valueClass == runtimeFieldClass) {
            fieldSerializer.write(serializer, propertyValue, fieldInfo.getName(), fieldInfo.getFieldType());
            return;
        }

        ObjectSerializer valueSerializer = serializer.getObjectWriter(valueClass);
        valueSerializer.write(serializer, propertyValue, fieldInfo.getName(), fieldInfo.getFieldType());
    }

}
