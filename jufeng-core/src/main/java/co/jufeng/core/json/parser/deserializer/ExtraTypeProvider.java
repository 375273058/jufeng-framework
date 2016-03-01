package co.jufeng.core.json.parser.deserializer;

import java.lang.reflect.Type;

public interface ExtraTypeProvider extends ParseProcess {

    Type getExtraType(Object object, String key);
}
