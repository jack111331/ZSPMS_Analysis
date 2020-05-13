package com.herosdk.widget;

import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class b {
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
    byte b1 = 0;
    int i = paramArrayOfint.length;
    while (b1 < i) {
      paramArrayOfint[b1] = paramByteBuffer.getInt();
      b1++;
    } 
  }
  
  private static b b(byte[] paramArrayOfbyte) {
    ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte).order(ByteOrder.nativeOrder());
    if (byteBuffer.get() == 0)
      return null; 
    b b1 = new b();
    b1.d = new int[byteBuffer.get()];
    b1.e = new int[byteBuffer.get()];
    b1.f = new int[byteBuffer.get()];
    a(b1.d.length);
    a(b1.e.length);
    byteBuffer.getInt();
    byteBuffer.getInt();
    b1.c.left = byteBuffer.getInt();
    b1.c.right = byteBuffer.getInt();
    b1.c.top = byteBuffer.getInt();
    b1.c.bottom = byteBuffer.getInt();
    byteBuffer.getInt();
    a(b1.d, byteBuffer);
    a(b1.e, byteBuffer);
    a(b1.f, byteBuffer);
    return b1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\widget\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */