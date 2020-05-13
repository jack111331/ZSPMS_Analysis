package com.alipay.sdk.packet;

import com.alipay.sdk.cons.a;
import com.alipay.sdk.encrypt.c;
import com.alipay.sdk.encrypt.d;
import com.alipay.sdk.util.l;
import java.util.Locale;

public final class e {
  private boolean a;
  
  private String b;
  
  public e(boolean paramBoolean) {
    this.a = paramBoolean;
    this.b = l.d();
  }
  
  private static int a(String paramString) {
    return Integer.parseInt(paramString);
  }
  
  private static String a(int paramInt) {
    return String.format(Locale.getDefault(), "%05d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  private static byte[] a(String paramString1, String paramString2) {
    return d.a(paramString1, paramString2);
  }
  
  private static byte[] a(String paramString, byte[] paramArrayOfbyte) {
    return com.alipay.sdk.encrypt.e.a(paramString, paramArrayOfbyte);
  }
  
  private static byte[] a(byte[]... paramVarArgs) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: arraylength
    //   6: ifne -> 13
    //   9: aload_2
    //   10: astore_3
    //   11: aload_3
    //   12: areturn
    //   13: new java/io/ByteArrayOutputStream
    //   16: astore #4
    //   18: aload #4
    //   20: invokespecial <init> : ()V
    //   23: new java/io/DataOutputStream
    //   26: astore_3
    //   27: aload_3
    //   28: aload #4
    //   30: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   33: iload_1
    //   34: aload_0
    //   35: arraylength
    //   36: if_icmpge -> 85
    //   39: aload_0
    //   40: iload_1
    //   41: aaload
    //   42: arraylength
    //   43: istore #5
    //   45: aload_3
    //   46: invokestatic getDefault : ()Ljava/util/Locale;
    //   49: ldc '%05d'
    //   51: iconst_1
    //   52: anewarray java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: iload #5
    //   59: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   62: aastore
    //   63: invokestatic format : (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   66: invokevirtual getBytes : ()[B
    //   69: invokevirtual write : ([B)V
    //   72: aload_3
    //   73: aload_0
    //   74: iload_1
    //   75: aaload
    //   76: invokevirtual write : ([B)V
    //   79: iinc #1, 1
    //   82: goto -> 33
    //   85: aload_3
    //   86: invokevirtual flush : ()V
    //   89: aload #4
    //   91: invokevirtual toByteArray : ()[B
    //   94: astore_0
    //   95: aload #4
    //   97: invokevirtual close : ()V
    //   100: aload_3
    //   101: invokevirtual close : ()V
    //   104: aload_0
    //   105: astore_3
    //   106: goto -> 11
    //   109: astore_3
    //   110: aload_0
    //   111: astore_3
    //   112: goto -> 11
    //   115: astore_0
    //   116: aconst_null
    //   117: astore_0
    //   118: aconst_null
    //   119: astore #4
    //   121: aload #4
    //   123: ifnull -> 131
    //   126: aload #4
    //   128: invokevirtual close : ()V
    //   131: aload_2
    //   132: astore_3
    //   133: aload_0
    //   134: ifnull -> 11
    //   137: aload_0
    //   138: invokevirtual close : ()V
    //   141: aload_2
    //   142: astore_3
    //   143: goto -> 11
    //   146: astore_0
    //   147: aload_2
    //   148: astore_3
    //   149: goto -> 11
    //   152: astore_0
    //   153: aconst_null
    //   154: astore #4
    //   156: aconst_null
    //   157: astore_3
    //   158: aload #4
    //   160: ifnull -> 168
    //   163: aload #4
    //   165: invokevirtual close : ()V
    //   168: aload_3
    //   169: ifnull -> 176
    //   172: aload_3
    //   173: invokevirtual close : ()V
    //   176: aload_0
    //   177: athrow
    //   178: astore #4
    //   180: goto -> 100
    //   183: astore_3
    //   184: goto -> 131
    //   187: astore #4
    //   189: goto -> 168
    //   192: astore_3
    //   193: goto -> 176
    //   196: astore_0
    //   197: aconst_null
    //   198: astore_3
    //   199: goto -> 158
    //   202: astore_0
    //   203: goto -> 158
    //   206: astore_0
    //   207: aconst_null
    //   208: astore_0
    //   209: goto -> 121
    //   212: astore_0
    //   213: aload_3
    //   214: astore_0
    //   215: goto -> 121
    // Exception table:
    //   from	to	target	type
    //   13	23	115	java/lang/Exception
    //   13	23	152	finally
    //   23	33	206	java/lang/Exception
    //   23	33	196	finally
    //   33	79	212	java/lang/Exception
    //   33	79	202	finally
    //   85	95	212	java/lang/Exception
    //   85	95	202	finally
    //   95	100	178	java/lang/Exception
    //   100	104	109	java/lang/Exception
    //   126	131	183	java/lang/Exception
    //   137	141	146	java/lang/Exception
    //   163	168	187	java/lang/Exception
    //   172	176	192	java/lang/Exception
  }
  
  private static byte[] b(String paramString, byte[] paramArrayOfbyte) {
    return com.alipay.sdk.encrypt.e.b(paramString, paramArrayOfbyte);
  }
  
  public final b a(c paramc) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new java/io/ByteArrayInputStream
    //   5: astore_3
    //   6: aload_3
    //   7: aload_1
    //   8: getfield b : [B
    //   11: invokespecial <init> : ([B)V
    //   14: iconst_5
    //   15: newarray byte
    //   17: astore #4
    //   19: aload_3
    //   20: aload #4
    //   22: invokevirtual read : ([B)I
    //   25: pop
    //   26: new java/lang/String
    //   29: astore #5
    //   31: aload #5
    //   33: aload #4
    //   35: invokespecial <init> : ([B)V
    //   38: aload #5
    //   40: invokestatic parseInt : (Ljava/lang/String;)I
    //   43: newarray byte
    //   45: astore #5
    //   47: aload_3
    //   48: aload #5
    //   50: invokevirtual read : ([B)I
    //   53: pop
    //   54: new java/lang/String
    //   57: astore #4
    //   59: aload #4
    //   61: aload #5
    //   63: invokespecial <init> : ([B)V
    //   66: iconst_5
    //   67: newarray byte
    //   69: astore #6
    //   71: aload_3
    //   72: aload #6
    //   74: invokevirtual read : ([B)I
    //   77: pop
    //   78: new java/lang/String
    //   81: astore #5
    //   83: aload #5
    //   85: aload #6
    //   87: invokespecial <init> : ([B)V
    //   90: aload #5
    //   92: invokestatic parseInt : (Ljava/lang/String;)I
    //   95: istore #7
    //   97: iload #7
    //   99: ifle -> 281
    //   102: iload #7
    //   104: newarray byte
    //   106: astore #6
    //   108: aload_3
    //   109: aload #6
    //   111: invokevirtual read : ([B)I
    //   114: pop
    //   115: aload #6
    //   117: astore #5
    //   119: aload_0
    //   120: getfield a : Z
    //   123: ifeq -> 137
    //   126: aload_0
    //   127: getfield b : Ljava/lang/String;
    //   130: aload #6
    //   132: invokestatic b : (Ljava/lang/String;[B)[B
    //   135: astore #5
    //   137: aload_1
    //   138: getfield a : Z
    //   141: ifeq -> 275
    //   144: aload #5
    //   146: invokestatic b : ([B)[B
    //   149: astore_1
    //   150: new java/lang/String
    //   153: astore #5
    //   155: aload #5
    //   157: aload_1
    //   158: invokespecial <init> : ([B)V
    //   161: aload #5
    //   163: astore_1
    //   164: aload_3
    //   165: invokevirtual close : ()V
    //   168: aload #4
    //   170: astore #5
    //   172: aload #5
    //   174: ifnonnull -> 232
    //   177: aload_1
    //   178: ifnonnull -> 232
    //   181: aload_2
    //   182: astore_1
    //   183: aload_1
    //   184: areturn
    //   185: astore #5
    //   187: aload #4
    //   189: astore #5
    //   191: goto -> 172
    //   194: astore_1
    //   195: aconst_null
    //   196: astore_3
    //   197: aconst_null
    //   198: astore #5
    //   200: aload_3
    //   201: ifnull -> 270
    //   204: aload_3
    //   205: invokevirtual close : ()V
    //   208: aconst_null
    //   209: astore_1
    //   210: goto -> 172
    //   213: astore_1
    //   214: aconst_null
    //   215: astore_1
    //   216: goto -> 172
    //   219: astore_1
    //   220: aconst_null
    //   221: astore_3
    //   222: aload_3
    //   223: ifnull -> 230
    //   226: aload_3
    //   227: invokevirtual close : ()V
    //   230: aload_1
    //   231: athrow
    //   232: new com/alipay/sdk/packet/b
    //   235: dup
    //   236: aload #5
    //   238: aload_1
    //   239: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   242: astore_1
    //   243: goto -> 183
    //   246: astore #5
    //   248: goto -> 230
    //   251: astore_1
    //   252: goto -> 222
    //   255: astore_1
    //   256: aconst_null
    //   257: astore #5
    //   259: goto -> 200
    //   262: astore_1
    //   263: aload #4
    //   265: astore #5
    //   267: goto -> 200
    //   270: aconst_null
    //   271: astore_1
    //   272: goto -> 172
    //   275: aload #5
    //   277: astore_1
    //   278: goto -> 150
    //   281: aconst_null
    //   282: astore_1
    //   283: goto -> 164
    // Exception table:
    //   from	to	target	type
    //   2	14	194	java/lang/Exception
    //   2	14	219	finally
    //   14	66	255	java/lang/Exception
    //   14	66	251	finally
    //   66	97	262	java/lang/Exception
    //   66	97	251	finally
    //   102	115	262	java/lang/Exception
    //   102	115	251	finally
    //   119	137	262	java/lang/Exception
    //   119	137	251	finally
    //   137	150	262	java/lang/Exception
    //   137	150	251	finally
    //   150	161	262	java/lang/Exception
    //   150	161	251	finally
    //   164	168	185	java/lang/Exception
    //   204	208	213	java/lang/Exception
    //   226	230	246	java/lang/Exception
  }
  
  public final c a(b paramb, boolean paramBoolean) {
    byte[] arrayOfByte2 = paramb.a.getBytes();
    byte[] arrayOfByte3 = paramb.b.getBytes();
    byte[] arrayOfByte1 = arrayOfByte3;
    boolean bool = paramBoolean;
    if (paramBoolean) {
      try {
        arrayOfByte1 = c.a(arrayOfByte3);
        bool = paramBoolean;
        if (this.a) {
          arrayOfByte1 = a(new byte[][] { arrayOfByte2, d.a(this.b, a.c), com.alipay.sdk.encrypt.e.a(this.b, arrayOfByte1) });
          return new c(bool, arrayOfByte1);
        } 
      } catch (Exception exception) {
        bool = false;
        arrayOfByte1 = arrayOfByte3;
        if (this.a) {
          arrayOfByte1 = a(new byte[][] { arrayOfByte2, d.a(this.b, a.c), com.alipay.sdk.encrypt.e.a(this.b, arrayOfByte1) });
          return new c(bool, arrayOfByte1);
        } 
      } 
      arrayOfByte1 = a(new byte[][] { arrayOfByte2, arrayOfByte1 });
      return new c(bool, arrayOfByte1);
    } 
    if (this.a) {
      arrayOfByte1 = a(new byte[][] { arrayOfByte2, d.a(this.b, a.c), com.alipay.sdk.encrypt.e.a(this.b, arrayOfByte1) });
      return new c(bool, arrayOfByte1);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\packet\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */