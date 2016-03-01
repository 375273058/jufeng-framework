package co.jufeng.core.json.serializer;

public enum SerializerFeature {
    QuoteFieldNames,
    /**
     * 
     */
    UseSingleQuotes,
    /**
     * 
     */
    WriteMapNullValue,
    /**
     * 
     */
    WriteEnumUsingToString,
    /**
     * 
     */
    UseISO8601DateFormat,
    /**
     *  1.1
     */
    WriteNullListAsEmpty,
    /**
     *  1.1
     */
    WriteNullStringAsEmpty,
    /**
     *  1.1
     */
    WriteNullNumberAsZero,
    /**
     *  1.1
     */
    WriteNullBooleanAsFalse,
    /**
     *  1.1
     */
    SkipTransientField,
    /**
     *  1.1
     */
    SortField,
    /**
     *  1.1.1
     */
    @Deprecated
    WriteTabAsSpecial,
    /**
     *  1.1.2
     */
    PrettyFormat,
    /**
     *  1.1.2
     */
    WriteClassName,

    /**
     *  1.1.6
     */
    DisableCircularReferenceDetect,

    /**
     *  1.1.9
     */
    WriteSlashAsSpecial,

    /**
     *  1.1.10
     */
    BrowserCompatible,

    /**
     *  1.1.14
     */
    WriteDateUseDateFormat,

    /**
     *  1.1.15
     */
    NotWriteRootClassName,

    /**
     *  1.1.19
     */
    DisableCheckSpecialChar,

    /**
     *  1.1.35
     */
    BeanToArray,

    /**
     *  1.1.37
     */
    WriteNonStringKeyAsString;

    private SerializerFeature(){
        mask = (1 << ordinal());
    }

    private final int mask;

    public final int getMask() {
        return mask;
    }

    public static boolean isEnabled(int features, SerializerFeature feature) {
        return (features & feature.getMask()) != 0;
    }

    public static int config(int features, SerializerFeature feature, boolean state) {
        if (state) {
            features |= feature.getMask();
        } else {
            features &= ~feature.getMask();
        }

        return features;
    }
}
