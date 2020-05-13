package com.zz.sdk.i;

import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class e {
  public static final int a = 1;
  
  public static final int b = 0;
  
  public Rect c = new Rect();
  
  public int[] d;
  
  public int[] e;
  
  public int[] f;
  
  private static void a(int paramInt) {
    if (paramInt == 0 || (paramInt & 0x1) != 0)
      throw new RuntimeException("invalid nine-patch: " + paramInt); 
  }
  
  private static void a(int[] paramArrayOfint, ByteBuffer paramByteBuffer) {
    byte b = 0;
    int i = paramArrayOfint.length;
    while (b < i) {
      paramArrayOfint[b] = paramByteBuffer.getInt();
      b++;
    } 
  }
  
  private static e b(byte[] paramArrayOfbyte) {
    ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte).order(ByteOrder.nativeOrder());
    if (byteBuffer.get() == 0)
      return null; 
    e e1 = new e();
    e1.d = new int[byteBuffer.get()];
    e1.e = new int[byteBuffer.get()];
    e1.f = new int[byteBuffer.get()];
    a(e1.d.length);
    a(e1.e.length);
    byteBuffer.getInt();
    byteBuffer.getInt();
    e1.c.left = byteBuffer.getInt();
    e1.c.right = byteBuffer.getInt();
    e1.c.top = byteBuffer.getInt();
    e1.c.bottom = byteBuffer.getInt();
    byteBuffer.getInt();
    a(e1.d, byteBuffer);
    a(e1.e, byteBuffer);
    a(e1.f, byteBuffer);
    return e1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */