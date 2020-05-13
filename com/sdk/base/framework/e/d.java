package com.sdk.base.framework.e;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;

public abstract class d {
  protected abstract int a();
  
  protected int a(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iconst_m1
    //   1: istore #5
    //   3: iconst_0
    //   4: istore #6
    //   6: iload #6
    //   8: iload #4
    //   10: if_icmpge -> 57
    //   13: aload_1
    //   14: invokevirtual read : ()I
    //   17: istore #7
    //   19: iload #7
    //   21: iconst_m1
    //   22: if_icmpne -> 41
    //   25: iload #6
    //   27: ifne -> 35
    //   30: iload #5
    //   32: istore_3
    //   33: iload_3
    //   34: ireturn
    //   35: iload #6
    //   37: istore_3
    //   38: goto -> 33
    //   41: aload_2
    //   42: iload #6
    //   44: iload_3
    //   45: iadd
    //   46: iload #7
    //   48: i2b
    //   49: i2b
    //   50: bastore
    //   51: iinc #6, 1
    //   54: goto -> 6
    //   57: iload #4
    //   59: istore_3
    //   60: goto -> 33
  }
  
  public void a(InputStream paramInputStream, OutputStream paramOutputStream) {
    paramInputStream = new PushbackInputStream(paramInputStream);
    a((PushbackInputStream)paramInputStream, paramOutputStream);
    int i = 0;
    while (true) {
      try {
        int j = c((PushbackInputStream)paramInputStream, paramOutputStream);
        int k;
        for (k = 0; a() + k < j; k += a()) {
          a((PushbackInputStream)paramInputStream, paramOutputStream, a());
          i += a();
        } 
        if (a() + k == j) {
          a((PushbackInputStream)paramInputStream, paramOutputStream, a());
          i += a();
        } else {
          a((PushbackInputStream)paramInputStream, paramOutputStream, j - k);
          i += j - k;
        } 
        d((PushbackInputStream)paramInputStream, paramOutputStream);
      } catch (c c) {
        b((PushbackInputStream)paramInputStream, paramOutputStream);
        return;
      } 
    } 
  }
  
  protected void a(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream) {}
  
  protected void a(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream, int paramInt) {
    throw new c();
  }
  
  public byte[] a(String paramString) {
    byte[] arrayOfByte = new byte[paramString.length()];
    paramString.getBytes(0, paramString.length(), arrayOfByte, 0);
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    a(byteArrayInputStream, byteArrayOutputStream);
    return byteArrayOutputStream.toByteArray();
  }
  
  protected abstract int b();
  
  protected void b(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream) {}
  
  protected int c(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream) {
    return b();
  }
  
  protected void d(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */