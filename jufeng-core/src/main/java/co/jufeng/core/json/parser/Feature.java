package co.jufeng.core.json.parser;

public enum Feature {
    /**
	 * 
	 */
    AutoCloseSource,
    /**
	 * 
	 */
    AllowComment,
    /**
	 * 
	 */
    AllowUnQuotedFieldNames,
    /**
	 * 
	 */
    AllowSingleQuotes,
    /**
	 * 
	 */
    InternFieldNames,
    /**
	 * 
	 */
    AllowISO8601DateFormat,

    /**
     * {"a":1,,,"b":2}
     */
    AllowArbitraryCommas,

    /**
     * 
     */
    UseBigDecimal,
    
    /**
     *  1.1.2
     */
    IgnoreNotMatch,

    /**
     *  1.1.3
     */
    SortFeidFastMatch,
    
    /**
     *  1.1.3
     */
    DisableASM,
    
    /**
     *  1.1.7
     */
    DisableCircularReferenceDetect,
    
    /**
     *  1.1.10
     */
    InitStringFieldAsEmpty,
    
    /**
     *  1.1.35
     * 
     */
    SupportArrayToBean
    ;

    private Feature(){
        mask = (1 << ordinal());
    }

    private final int mask;

    public final int getMask() {
        return mask;
    }

    public static boolean isEnabled(int features, Feature feature) {
        return (features & feature.getMask()) != 0;
    }

    public static int config(int features, Feature feature, boolean state) {
        if (state) {
            features |= feature.getMask();
        } else {
            features &= ~feature.getMask();
        }

        return features;
    }
}
