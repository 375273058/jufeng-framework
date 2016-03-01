
package co.jufeng.core.json.serializer;

public interface NameFilter extends SerializeFilter {
    String process(Object object, String name, Object value);
}
