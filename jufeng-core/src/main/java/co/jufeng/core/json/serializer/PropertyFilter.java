package co.jufeng.core.json.serializer;

public interface PropertyFilter extends SerializeFilter {

    boolean apply(Object object, String name, Object value);
}
