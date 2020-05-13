package com.zz.sdk.i;

import java.util.HashMap;
import java.util.Random;

public class c {
  static final boolean a = false;
  
  static final HashMap b = new HashMap<Object, Object>();
  
  public static final c c = a("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
  
  public static final c d = a("GxU3wLPAzOpEbDH5mKRaVZfSNgs07.q8Y4I2CMnoW-6dtke9XvijFyl1BcQrhTJu");
  
  public static final c e = a("JRps7QAydqSkYFN-T4wnBDhKLr8H3.u69mG2WjPgOxco0avZE5IUflMVbtzeX1iC");
  
  private static final String f = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
  
  private final byte[] g;
  
  private final byte[] h;
  
  private c(String paramString) {
    byte b3;
    if (paramString == null || paramString.length() != 64)
      throw new IllegalArgumentException("tableKey.length!=64"); 
    this.g = paramString.getBytes();
    this.h = new byte[128];
    byte b2 = 0;
    while (true) {
      b3 = b1;
      if (b2 < '') {
        this.h[b2] = (byte)-1;
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.g.length) {
      this.h[this.g[b3]] = (byte)(byte)b3;
      b3++;
    } 
  }
  
  public static c a(String paramString) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/c
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/i/c.b : Ljava/util/HashMap;
    //   6: aload_0
    //   7: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast com/zz/sdk/i/c
    //   13: astore_1
    //   14: aload_1
    //   15: astore_2
    //   16: aload_1
    //   17: ifnonnull -> 38
    //   20: new com/zz/sdk/i/c
    //   23: astore_2
    //   24: aload_2
    //   25: aload_0
    //   26: invokespecial <init> : (Ljava/lang/String;)V
    //   29: getstatic com/zz/sdk/i/c.b : Ljava/util/HashMap;
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   37: pop
    //   38: ldc com/zz/sdk/i/c
    //   40: monitorexit
    //   41: aload_2
    //   42: areturn
    //   43: astore_0
    //   44: ldc com/zz/sdk/i/c
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   3	14	43	finally
    //   20	38	43	finally
  }
  
  public static final String a(String paramString, long paramLong) {
    byte[] arrayOfByte = paramString.getBytes();
    int i = arrayOfByte.length;
    arrayOfByte[i - 2] = (byte)45;
    arrayOfByte[i - 1] = (byte)46;
    long l = paramLong;
    if (paramLong == 0L)
      l = 19881224L; 
    Random random = new Random(l);
    for (byte b = 1; b < i; b++) {
      int j = i - b;
      int k = random.nextInt(j);
      byte b1 = arrayOfByte[k];
      arrayOfByte[k] = (byte)arrayOfByte[j];
      arrayOfByte[j] = (byte)b1;
    } 
    return new String(arrayOfByte);
  }
  
  public static void a(String[] paramArrayOfString) {}
  
  public static byte[] c(String paramString) {
    return c.b(paramString);
  }
  
  public static byte[] c(byte[] paramArrayOfbyte) {
    return c.a(paramArrayOfbyte);
  }
  
  public static byte[] d(byte[] paramArrayOfbyte) {
    return e.a(paramArrayOfbyte);
  }
  
  public byte[] a(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = new byte[(paramArrayOfbyte.length * 4 + 2) / 3];
    byte b = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    while (true) {
      if (b < paramArrayOfbyte.length) {
        int m = paramArrayOfbyte[b] & 0xFF | k;
        k = i + 2;
        i = j + 1;
        arrayOfByte[j] = (byte)this.g[m >> k & 0x3F];
        if (k == 6) {
          j = i + 1;
          arrayOfByte[i] = (byte)this.g[m & 0x3F];
          i = 0;
        } else {
          j = i;
          i = k;
        } 
        b++;
        k = m << 8;
        continue;
      } 
      if (i > 0)
        arrayOfByte[j] = (byte)this.g[k >> i + 2 & 0x3F]; 
      return arrayOfByte;
    } 
  }
  
  public byte[] b(String paramString) {
    return b(paramString.getBytes());
  }
  
  public byte[] b(byte[] paramArrayOfbyte) {
    byte b1 = 0;
    int i = paramArrayOfbyte.length;
    byte b2 = 0;
    while (b2 < i) {
      byte b = paramArrayOfbyte[b2];
      if (b >= 0 && b < 128 && this.h[b] != -1) {
        b2++;
        continue;
      } 
      return null;
    } 
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length * 3 / 4];
    b2 = 0;
    i = 0;
    int j = 0;
    while (b1 < paramArrayOfbyte.length) {
      j = this.h[paramArrayOfbyte[b1]] | j;
      if (b2 >= 2) {
        b2 -= 2;
        arrayOfByte[i] = (byte)(byte)(j >> b2 & 0xFF);
        i++;
      } else {
        b2 += 6;
      } 
      j <<= 6;
      b1++;
    } 
    return arrayOfByte;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */