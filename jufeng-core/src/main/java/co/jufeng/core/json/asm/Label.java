package co.jufeng.core.json.asm;

public class Label {

    static final int RESOLVED = 2;

    public Object    info;

    int              status;

    int              line;

    int              position;

    private int      referenceCount;

    private int[]    srcAndRefPositions;

    int              inputStackTop;

    int              outputStackMax;

    Label            successor;

    Label            next;

    public Label(){
    }

    void put(final MethodWriter owner, final ByteVector out, final int source) {
        if ((status & RESOLVED) == 0) {
            addReference(source, out.length);
            out.putShort(-1);
        } else {
            out.putShort(position - source);
        }
    }

    private void addReference(final int sourcePosition, final int referencePosition) {
        if (srcAndRefPositions == null) {
            srcAndRefPositions = new int[6];
        }
        if (referenceCount >= srcAndRefPositions.length) {
            int[] a = new int[srcAndRefPositions.length + 6];
            System.arraycopy(srcAndRefPositions, 0, a, 0, srcAndRefPositions.length);
            srcAndRefPositions = a;
        }
        srcAndRefPositions[referenceCount++] = sourcePosition;
        srcAndRefPositions[referenceCount++] = referencePosition;
    }

    void resolve(final MethodWriter owner, final int position, final byte[] data) {
        this.status |= RESOLVED;
        this.position = position;
        int i = 0;
        while (i < referenceCount) {
            int source = srcAndRefPositions[i++];
            int reference = srcAndRefPositions[i++];
            int offset = position - source;
            data[reference++] = (byte) (offset >>> 8);
            data[reference] = (byte) offset;

        }
    }

}
