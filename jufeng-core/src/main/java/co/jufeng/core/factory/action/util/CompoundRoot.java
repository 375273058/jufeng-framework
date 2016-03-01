package co.jufeng.core.factory.action.util;
import java.util.ArrayList;
import java.util.List;


public class CompoundRoot extends ArrayList<Object> {

	private static final long serialVersionUID = -2996735100293531096L;

	public CompoundRoot() {
    }

    public CompoundRoot(List<?> list) {
        super(list);
    }


    public CompoundRoot cutStack(int index) {
        return new CompoundRoot(subList(index, size()));
    }

    public Object peek() {
        return get(0);
    }

    public Object pop() {
        return remove(0);
    }

    public void push(Object o) {
        add(0, o);
    }
}
