package co.jufeng.core.json.parser;

import java.util.HashMap;
import java.util.Map;

public class Keywords {

    private final Map<String, Integer> keywords;

    public static Keywords               DEFAULT_KEYWORDS;

    static {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("null", JSONToken.NULL);
        map.put("new", JSONToken.NEW);
        map.put("true", JSONToken.TRUE);
        map.put("false", JSONToken.FALSE);
        DEFAULT_KEYWORDS = new Keywords(map);
    }

    public Keywords(Map<String, Integer> keywords){
        this.keywords = keywords;
    }

    public Integer getKeyword(String key) {
        return keywords.get(key);
    }

}
