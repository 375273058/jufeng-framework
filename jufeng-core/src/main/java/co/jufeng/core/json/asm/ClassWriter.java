package co.jufeng.core.json.asm;

public class ClassWriter {

    public static final int COMPUTE_MAXS            = 1;

    public static final int COMPUTE_FRAMES          = 2;

    static final int        ACC_SYNTHETIC_ATTRIBUTE = 0x40000;

    static final int        NOARG_INSN              = 0;

    static final int        SBYTE_INSN              = 1;

    static final int        SHORT_INSN              = 2;

    static final int        VAR_INSN                = 3;

    static final int        IMPLVAR_INSN            = 4;

    static final int        TYPE_INSN               = 5;

    static final int        FIELDORMETH_INSN        = 6;

    static final int        ITFDYNMETH_INSN         = 7;

    static final int        LABEL_INSN              = 8;

    static final int        LABELW_INSN             = 9;

    static final int        LDC_INSN                = 10;

    static final int        LDCW_INSN               = 11;

    static final int        IINC_INSN               = 12;

    static final int        TABL_INSN               = 13;

    static final int        LOOK_INSN               = 14;

    static final int        MANA_INSN               = 15;

    static final int        WIDE_INSN               = 16;

    static final byte[]     TYPE;

    static final int        CLASS                   = 7;

    static final int        FIELD                   = 9;

    static final int        METH                    = 10;

    static final int        IMETH                   = 11;

    static final int        STR                     = 8;

    static final int        INT                     = 3;

    static final int        FLOAT                   = 4;

    static final int        LONG                    = 5;

    static final int        DOUBLE                  = 6;

    static final int        NAME_TYPE               = 12;

    static final int        UTF8                    = 1;

    static final int        TYPE_NORMAL             = 13;

    static final int        TYPE_UNINIT             = 14;

    static final int        TYPE_MERGED             = 15;

    int                     version;

    int                     index;

    final ByteVector        pool;

    Item[]                  items;

    int                     threshold;

    final Item              key;

    final Item              key2;

    final Item              key3;

    Item[]                  typeTable;

    private int             access;

    private int             name;

    String                  thisName;

    private int             superName;

    private int             interfaceCount;

    private int[]           interfaces;

    FieldWriter             firstField;

    FieldWriter             lastField;

    MethodWriter            firstMethod;

    MethodWriter            lastMethod;

    static {
        int i;
        byte[] b = new byte[220];
        String s = "AAAAAAAAAAAAAAAABCKLLDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADD" + "DDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + "AAAAAAAAAAAAAAAAAMAAAAAAAAAAAAAAAAAAAAIIIIIIIIIIIIIIIIDNOAA" + "AAAAGGGGGGGHHFBFAAFFAAQPIIJJIIIIIIIIIIIIIIIIII";
        for (i = 0; i < b.length; ++i) {
            b[i] = (byte) (s.charAt(i) - 'A');
        }
        TYPE = b;

        // code to generate the above string
        //
        // // SBYTE_INSN instructions
        // b[Constants.NEWARRAY] = SBYTE_INSN;
        // b[Constants.BIPUSH] = SBYTE_INSN;
        //
        // // SHORT_INSN instructions
        // b[Constants.SIPUSH] = SHORT_INSN;
        //
        // // (IMPL)VAR_INSN instructions
        // b[Constants.RET] = VAR_INSN;
        // for (i = Constants.ILOAD; i <= Constants.ALOAD; ++i) {
        // b[i] = VAR_INSN;
        // }
        // for (i = Constants.ISTORE; i <= Constants.ASTORE; ++i) {
        // b[i] = VAR_INSN;
        // }
        // for (i = 26; i <= 45; ++i) { // ILOAD_0 to ALOAD_3
        // b[i] = IMPLVAR_INSN;
        // }
        // for (i = 59; i <= 78; ++i) { // ISTORE_0 to ASTORE_3
        // b[i] = IMPLVAR_INSN;
        // }
        //
        // // TYPE_INSN instructions
        // b[Constants.NEW] = TYPE_INSN;
        // b[Constants.ANEWARRAY] = TYPE_INSN;
        // b[Constants.CHECKCAST] = TYPE_INSN;
        // b[Constants.INSTANCEOF] = TYPE_INSN;
        //
        // // (Set)FIELDORMETH_INSN instructions
        // for (i = Constants.GETSTATIC; i <= Constants.INVOKESTATIC; ++i) {
        // b[i] = FIELDORMETH_INSN;
        // }
        // b[Constants.INVOKEINTERFACE] = ITFDYNMETH_INSN;
        // b[Constants.INVOKEDYNAMIC] = ITFDYNMETH_INSN;
        //
        // // LABEL(W)_INSN instructions
        // for (i = Constants.IFEQ; i <= Constants.JSR; ++i) {
        // b[i] = LABEL_INSN;
        // }
        // b[Constants.IFNULL] = LABEL_INSN;
        // b[Constants.IFNONNULL] = LABEL_INSN;
        // b[200] = LABELW_INSN; // GOTO_W
        // b[201] = LABELW_INSN; // JSR_W
        // // temporary opcodes used internally by ASM - see Label and
        // MethodWriter
        // for (i = 202; i < 220; ++i) {
        // b[i] = LABEL_INSN;
        // }
        //
        // // LDC(_W) instructions
        // b[Constants.LDC] = LDC_INSN;
        // b[19] = LDCW_INSN; // LDC_W
        // b[20] = LDCW_INSN; // LDC2_W
        //
        // // special instructions
        // b[Constants.IINC] = IINC_INSN;
        // b[Constants.TABLESWITCH] = TABL_INSN;
        // b[Constants.LOOKUPSWITCH] = LOOK_INSN;
        // b[Constants.MULTIANEWARRAY] = MANA_INSN;
        // b[196] = WIDE_INSN; // WIDE
        //
        // for (i = 0; i < b.length; ++i) {
        // System.err.print((char)('A' + b[i]));
        // }
        // System.err.println();
    }

    public ClassWriter(){
        this(0);
    }

    private ClassWriter(final int flags){
        index = 1;
        pool = new ByteVector();
        items = new Item[256];
        threshold = (int) (0.75d * items.length);
        key = new Item();
        key2 = new Item();
        key3 = new Item();
    }


    public void visit(final int version, final int access, final String name, final String superName, final String[] interfaces) {
        this.version = version;
        this.access = access;
        this.name = newClass(name);
        thisName = name;
        this.superName = superName == null ? 0 : newClass(superName);
        if (interfaces != null && interfaces.length > 0) {
            interfaceCount = interfaces.length;
            this.interfaces = new int[interfaceCount];
            for (int i = 0; i < interfaceCount; ++i) {
                this.interfaces[i] = newClass(interfaces[i]);
            }
        }
    }

    public FieldVisitor visitField(final int access, final String name, final String desc) {
        return new FieldWriter(this, access, name, desc);
    }

    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        return new MethodWriter(this, access, name, desc, signature, exceptions);
    }

    public byte[] toByteArray() {
        // computes the real size of the bytecode of this class
        int size = 24 + 2 * interfaceCount;
        int nbFields = 0;
        FieldWriter fb = firstField;
        while (fb != null) {
            ++nbFields;
            size += fb.getSize();
            fb = fb.next;
        }
        int nbMethods = 0;
        MethodWriter mb = firstMethod;
        while (mb != null) {
            ++nbMethods;
            size += mb.getSize();
            mb = mb.next;
        }
        int attributeCount = 0;
        size += pool.length;
        // allocates a byte vector of this size, in order to avoid unnecessary
        // arraycopy operations in the ByteVector.enlarge() method
        ByteVector out = new ByteVector(size);
        out.putInt(0xCAFEBABE).putInt(version);
        out.putShort(index).putByteArray(pool.data, 0, pool.length);
        int mask = Opcodes.ACC_DEPRECATED | ClassWriter.ACC_SYNTHETIC_ATTRIBUTE | ((access & ClassWriter.ACC_SYNTHETIC_ATTRIBUTE) / (ClassWriter.ACC_SYNTHETIC_ATTRIBUTE / Opcodes.ACC_SYNTHETIC));
        out.putShort(access & ~mask).putShort(name).putShort(superName);
        out.putShort(interfaceCount);
        for (int i = 0; i < interfaceCount; ++i) {
            out.putShort(interfaces[i]);
        }
        out.putShort(nbFields);
        fb = firstField;
        while (fb != null) {
            fb.put(out);
            fb = fb.next;
        }
        out.putShort(nbMethods);
        mb = firstMethod;
        while (mb != null) {
            mb.put(out);
            mb = mb.next;
        }
        out.putShort(attributeCount);
        return out.data;
    }

    Item newConstItem(final Object cst) {
        if (cst instanceof Integer) {
            int val = ((Integer) cst).intValue();
            return newInteger(val);
        } else if (cst instanceof String) {
            return newString((String) cst);
        } else if (cst instanceof Type) {
            Type t = (Type) cst;
            return newClassItem(t.getSort() == Type.OBJECT ? t.getInternalName() : t.getDescriptor());
        } else {
            throw new IllegalArgumentException("value " + cst);
        }
    }
    
    Item newInteger(final int value) {
        key.set(value);
        Item result = get(key);
        if (result == null) {
            pool.putByte(INT).putInt(value);
            result = new Item(index++, key);
            put(result);
        }
        return result;
    }

    public int newUTF8(final String value) {
        key.set(UTF8, value, null, null);
        Item result = get(key);
        if (result == null) {
            pool.putByte(UTF8).putUTF8(value);
            result = new Item(index++, key);
            put(result);
        }
        return result.index;
    }

    Item newClassItem(final String value) {
        key2.set(CLASS, value, null, null);
        Item result = get(key2);
        if (result == null) {
            pool.put12(CLASS, newUTF8(value));
            result = new Item(index++, key2);
            put(result);
        }
        return result;
    }

    public int newClass(final String value) {
        return newClassItem(value).index;
    }

    Item newFieldItem(final String owner, final String name, final String desc) {
        key3.set(FIELD, owner, name, desc);
        Item result = get(key3);
        if (result == null) {
            put122(FIELD, newClass(owner), newNameType(name, desc));
            result = new Item(index++, key3);
            put(result);
        }
        return result;
    }

    Item newMethodItem(final String owner, final String name, final String desc, final boolean itf) {
        int type = itf ? IMETH : METH;
        key3.set(type, owner, name, desc);
        Item result = get(key3);
        if (result == null) {
            put122(type, newClass(owner), newNameType(name, desc));
            result = new Item(index++, key3);
            put(result);
        }
        return result;
    }

    private Item newString(final String value) {
        key2.set(STR, value, null, null);
        Item result = get(key2);
        if (result == null) {
            pool.put12(STR, newUTF8(value));
            result = new Item(index++, key2);
            put(result);
        }
        return result;
    }

    public int newNameType(final String name, final String desc) {
        return newNameTypeItem(name, desc).index;
    }

    Item newNameTypeItem(final String name, final String desc) {
        key2.set(NAME_TYPE, name, desc, null);
        Item result = get(key2);
        if (result == null) {
            put122(NAME_TYPE, newUTF8(name), newUTF8(desc));
            result = new Item(index++, key2);
            put(result);
        }
        return result;
    }

    private Item get(final Item key) {
        Item i = items[key.hashCode % items.length];
        while (i != null && (i.type != key.type || !key.isEqualTo(i))) {
            i = i.next;
        }
        return i;
    }

    private void put(final Item i) {
        if (index > threshold) {
            int ll = items.length;
            int nl = ll * 2 + 1;
            Item[] newItems = new Item[nl];
            for (int l = ll - 1; l >= 0; --l) {
                Item j = items[l];
                while (j != null) {
                    int index = j.hashCode % newItems.length;
                    Item k = j.next;
                    j.next = newItems[index];
                    newItems[index] = j;
                    j = k;
                }
            }
            items = newItems;
            threshold = (int) (nl * 0.75);
        }
        int index = i.hashCode % items.length;
        i.next = items[index];
        items[index] = i;
    }

    private void put122(final int b, final int s1, final int s2) {
        pool.put12(b, s1).putShort(s2);
    }
}
