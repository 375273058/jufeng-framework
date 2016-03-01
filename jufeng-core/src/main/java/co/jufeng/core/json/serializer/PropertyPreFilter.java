package co.jufeng.core.json.serializer;

public interface PropertyPreFilter extends SerializeFilter {

    boolean apply(JSONSerializer serializer, Object object, String name);
}
