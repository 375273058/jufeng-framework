package co.jufeng.core.json;

import java.io.IOException;

public interface JSONStreamAware {

    public void writeJSONString(Appendable out) throws IOException;
}
