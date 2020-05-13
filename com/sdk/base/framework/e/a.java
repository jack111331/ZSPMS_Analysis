package com.sdk.base.framework.e;

import java.io.OutputStream;
import java.io.PushbackInputStream;

public class a extends d {
  private static final char[] b = new char[] { 
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
      'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
      'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
      'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
      'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
      'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
      '8', '9', '+', '/' };
  
  private static final byte[] c = new byte[256];
  
  byte[] a = new byte[4];
  
  static {
    byte b2 = 0;
    while (true) {
      b3 = b1;
      if (b2 < 'ÿ') {
        c[b2] = (byte)-1;
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < b.length) {
      c[b[b3]] = (byte)(byte)b3;
      b3++;
    } 
  }
  
  protected int a() {
    return 4;
  }
  
  protected void a(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream, int paramInt) {
    // Byte code:
    //   0: iconst_m1
    //   1: istore #4
    //   3: iload_3
    //   4: iconst_2
    //   5: if_icmpge -> 18
    //   8: new com/sdk/base/framework/e/b
    //   11: dup
    //   12: ldc 'BASE64Decoder: Not enough bytes for an atom.'
    //   14: invokespecial <init> : (Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_1
    //   19: invokevirtual read : ()I
    //   22: istore #5
    //   24: iload #5
    //   26: iconst_m1
    //   27: if_icmpne -> 38
    //   30: new com/sdk/base/framework/e/c
    //   33: dup
    //   34: invokespecial <init> : ()V
    //   37: athrow
    //   38: iload #5
    //   40: bipush #10
    //   42: if_icmpeq -> 18
    //   45: iload #5
    //   47: bipush #13
    //   49: if_icmpeq -> 18
    //   52: aload_0
    //   53: getfield a : [B
    //   56: iconst_0
    //   57: iload #5
    //   59: i2b
    //   60: i2b
    //   61: bastore
    //   62: aload_0
    //   63: aload_1
    //   64: aload_0
    //   65: getfield a : [B
    //   68: iconst_1
    //   69: iload_3
    //   70: iconst_1
    //   71: isub
    //   72: invokevirtual a : (Ljava/io/InputStream;[BII)I
    //   75: iconst_m1
    //   76: if_icmpne -> 87
    //   79: new com/sdk/base/framework/e/c
    //   82: dup
    //   83: invokespecial <init> : ()V
    //   86: athrow
    //   87: iload_3
    //   88: iconst_3
    //   89: if_icmple -> 408
    //   92: aload_0
    //   93: getfield a : [B
    //   96: iconst_3
    //   97: baload
    //   98: bipush #61
    //   100: if_icmpne -> 408
    //   103: iconst_3
    //   104: istore_3
    //   105: iload_3
    //   106: iconst_2
    //   107: if_icmple -> 402
    //   110: aload_0
    //   111: getfield a : [B
    //   114: iconst_2
    //   115: baload
    //   116: bipush #61
    //   118: if_icmpne -> 402
    //   121: iconst_2
    //   122: istore #6
    //   124: iload #4
    //   126: istore #5
    //   128: iload #6
    //   130: tableswitch default -> 156, 2 -> 397, 3 -> 209, 4 -> 193
    //   156: iconst_m1
    //   157: istore #7
    //   159: iconst_m1
    //   160: istore #5
    //   162: iconst_m1
    //   163: istore_3
    //   164: iload #6
    //   166: tableswitch default -> 192, 2 -> 269, 3 -> 291, 4 -> 334
    //   192: return
    //   193: getstatic com/sdk/base/framework/e/a.c : [B
    //   196: aload_0
    //   197: getfield a : [B
    //   200: iconst_3
    //   201: baload
    //   202: sipush #255
    //   205: iand
    //   206: baload
    //   207: istore #5
    //   209: getstatic com/sdk/base/framework/e/a.c : [B
    //   212: aload_0
    //   213: getfield a : [B
    //   216: iconst_2
    //   217: baload
    //   218: sipush #255
    //   221: iand
    //   222: baload
    //   223: istore_3
    //   224: iload #5
    //   226: istore #4
    //   228: getstatic com/sdk/base/framework/e/a.c : [B
    //   231: aload_0
    //   232: getfield a : [B
    //   235: iconst_1
    //   236: baload
    //   237: sipush #255
    //   240: iand
    //   241: baload
    //   242: istore #5
    //   244: getstatic com/sdk/base/framework/e/a.c : [B
    //   247: aload_0
    //   248: getfield a : [B
    //   251: iconst_0
    //   252: baload
    //   253: sipush #255
    //   256: iand
    //   257: baload
    //   258: istore #8
    //   260: iload_3
    //   261: istore #7
    //   263: iload #8
    //   265: istore_3
    //   266: goto -> 164
    //   269: aload_2
    //   270: iload_3
    //   271: iconst_2
    //   272: ishl
    //   273: sipush #252
    //   276: iand
    //   277: iload #5
    //   279: iconst_4
    //   280: iushr
    //   281: iconst_3
    //   282: iand
    //   283: ior
    //   284: i2b
    //   285: invokevirtual write : (I)V
    //   288: goto -> 192
    //   291: aload_2
    //   292: iload_3
    //   293: iconst_2
    //   294: ishl
    //   295: sipush #252
    //   298: iand
    //   299: iload #5
    //   301: iconst_4
    //   302: iushr
    //   303: iconst_3
    //   304: iand
    //   305: ior
    //   306: i2b
    //   307: invokevirtual write : (I)V
    //   310: aload_2
    //   311: iload #5
    //   313: iconst_4
    //   314: ishl
    //   315: sipush #240
    //   318: iand
    //   319: iload #7
    //   321: iconst_2
    //   322: iushr
    //   323: bipush #15
    //   325: iand
    //   326: ior
    //   327: i2b
    //   328: invokevirtual write : (I)V
    //   331: goto -> 192
    //   334: aload_2
    //   335: iload_3
    //   336: iconst_2
    //   337: ishl
    //   338: sipush #252
    //   341: iand
    //   342: iload #5
    //   344: iconst_4
    //   345: iushr
    //   346: iconst_3
    //   347: iand
    //   348: ior
    //   349: i2b
    //   350: invokevirtual write : (I)V
    //   353: aload_2
    //   354: iload #5
    //   356: iconst_4
    //   357: ishl
    //   358: sipush #240
    //   361: iand
    //   362: iload #7
    //   364: iconst_2
    //   365: iushr
    //   366: bipush #15
    //   368: iand
    //   369: ior
    //   370: i2b
    //   371: invokevirtual write : (I)V
    //   374: aload_2
    //   375: iload #4
    //   377: bipush #63
    //   379: iand
    //   380: iload #7
    //   382: bipush #6
    //   384: ishl
    //   385: sipush #192
    //   388: iand
    //   389: ior
    //   390: i2b
    //   391: invokevirtual write : (I)V
    //   394: goto -> 192
    //   397: iconst_m1
    //   398: istore_3
    //   399: goto -> 228
    //   402: iload_3
    //   403: istore #6
    //   405: goto -> 124
    //   408: goto -> 105
  }
  
  protected int b() {
    return 72;
  }
  
  static {
    byte b3;
    byte b1 = 0;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */