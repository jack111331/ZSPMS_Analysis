package com.alibaba.fastjson.asm;

public interface MethodVisitor {
  void visitEnd();
  
  void visitFieldInsn(int paramInt, String paramString1, String paramString2, String paramString3);
  
  void visitIincInsn(int paramInt1, int paramInt2);
  
  void visitInsn(int paramInt);
  
  void visitIntInsn(int paramInt1, int paramInt2);
  
  void visitJumpInsn(int paramInt, Label paramLabel);
  
  void visitLabel(Label paramLabel);
  
  void visitLdcInsn(Object paramObject);
  
  void visitMaxs(int paramInt1, int paramInt2);
  
  void visitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3);
  
  void visitTypeInsn(int paramInt, String paramString);
  
  void visitVarInsn(int paramInt1, int paramInt2);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\asm\MethodVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */