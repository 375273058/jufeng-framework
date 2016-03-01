package co.jufeng.core.json.asm;

public interface MethodVisitor {

    void visitInsn(int opcode);

    void visitIntInsn(int opcode, int operand);

    void visitVarInsn(int opcode, int var);

    void visitTypeInsn(int opcode, String type);

    void visitFieldInsn(int opcode, String owner, String name, String desc);

    void visitMethodInsn(int opcode, String owner, String name, String desc);

    void visitJumpInsn(int opcode, Label label);

    void visitLabel(Label label);

    void visitLdcInsn(Object cst);

    void visitIincInsn(int var, int increment);

    void visitMaxs(int maxStack, int maxLocals);

    void visitEnd();
}
