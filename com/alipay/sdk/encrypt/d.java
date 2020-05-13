package com.alipay.sdk.encrypt;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public final class d {
  private static final String a = "RSA";
  
  public static byte[] a(String paramString1, String paramString2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokestatic a : (Ljava/lang/String;)[B
    //   6: astore_1
    //   7: new java/security/spec/X509EncodedKeySpec
    //   10: astore_3
    //   11: aload_3
    //   12: aload_1
    //   13: invokespecial <init> : ([B)V
    //   16: ldc 'RSA'
    //   18: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/KeyFactory;
    //   21: aload_3
    //   22: invokevirtual generatePublic : (Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   25: astore_3
    //   26: ldc 'RSA/ECB/PKCS1Padding'
    //   28: invokestatic getInstance : (Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   31: astore_1
    //   32: aload_1
    //   33: iconst_1
    //   34: aload_3
    //   35: invokevirtual init : (ILjava/security/Key;)V
    //   38: aload_0
    //   39: ldc 'UTF-8'
    //   41: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   44: astore_3
    //   45: aload_1
    //   46: invokevirtual getBlockSize : ()I
    //   49: istore #4
    //   51: new java/io/ByteArrayOutputStream
    //   54: astore_0
    //   55: aload_0
    //   56: invokespecial <init> : ()V
    //   59: iconst_0
    //   60: istore #5
    //   62: iload #5
    //   64: aload_3
    //   65: arraylength
    //   66: if_icmpge -> 116
    //   69: aload_3
    //   70: arraylength
    //   71: iload #5
    //   73: isub
    //   74: iload #4
    //   76: if_icmpge -> 109
    //   79: aload_3
    //   80: arraylength
    //   81: iload #5
    //   83: isub
    //   84: istore #6
    //   86: aload_0
    //   87: aload_1
    //   88: aload_3
    //   89: iload #5
    //   91: iload #6
    //   93: invokevirtual doFinal : ([BII)[B
    //   96: invokevirtual write : ([B)V
    //   99: iload #5
    //   101: iload #4
    //   103: iadd
    //   104: istore #5
    //   106: goto -> 62
    //   109: iload #4
    //   111: istore #6
    //   113: goto -> 86
    //   116: aload_0
    //   117: invokevirtual toByteArray : ()[B
    //   120: astore_1
    //   121: aload_0
    //   122: invokevirtual close : ()V
    //   125: aload_1
    //   126: astore_0
    //   127: aload_0
    //   128: areturn
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_2
    //   133: astore_0
    //   134: aload_1
    //   135: ifnull -> 127
    //   138: aload_1
    //   139: invokevirtual close : ()V
    //   142: aload_2
    //   143: astore_0
    //   144: goto -> 127
    //   147: astore_0
    //   148: aload_2
    //   149: astore_0
    //   150: goto -> 127
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_0
    //   156: aload_0
    //   157: ifnull -> 164
    //   160: aload_0
    //   161: invokevirtual close : ()V
    //   164: aload_1
    //   165: athrow
    //   166: astore_0
    //   167: aload_1
    //   168: astore_0
    //   169: goto -> 127
    //   172: astore_0
    //   173: goto -> 164
    //   176: astore_1
    //   177: goto -> 156
    //   180: astore_1
    //   181: aload_0
    //   182: astore_1
    //   183: goto -> 132
    // Exception table:
    //   from	to	target	type
    //   2	59	129	java/lang/Exception
    //   2	59	153	finally
    //   62	86	180	java/lang/Exception
    //   62	86	176	finally
    //   86	99	180	java/lang/Exception
    //   86	99	176	finally
    //   116	121	180	java/lang/Exception
    //   116	121	176	finally
    //   121	125	166	java/io/IOException
    //   138	142	147	java/io/IOException
    //   160	164	172	java/io/IOException
  }
  
  private static PublicKey b(String paramString1, String paramString2) throws NoSuchAlgorithmException, Exception {
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(a.a(paramString2));
    return KeyFactory.getInstance(paramString1).generatePublic(x509EncodedKeySpec);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\encrypt\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */