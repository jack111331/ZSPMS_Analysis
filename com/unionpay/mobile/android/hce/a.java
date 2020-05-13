package com.unionpay.mobile.android.hce;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public final class a {
  public static String a(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'UTF-8'
    //   3: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   6: astore_2
    //   7: aload_0
    //   8: ifnull -> 20
    //   11: aload_0
    //   12: ldc ''
    //   14: invokevirtual equals : (Ljava/lang/Object;)Z
    //   17: ifeq -> 76
    //   20: aconst_null
    //   21: astore_0
    //   22: new javax/crypto/spec/DESedeKeySpec
    //   25: astore_1
    //   26: aload_1
    //   27: aload_2
    //   28: invokespecial <init> : ([B)V
    //   31: ldc 'desede'
    //   33: invokestatic getInstance : (Ljava/lang/String;)Ljavax/crypto/SecretKeyFactory;
    //   36: aload_1
    //   37: invokevirtual generateSecret : (Ljava/security/spec/KeySpec;)Ljavax/crypto/SecretKey;
    //   40: astore_2
    //   41: ldc 'DESEDE/ECB/PKCS5Padding'
    //   43: invokestatic getInstance : (Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   46: astore_1
    //   47: aload_1
    //   48: iconst_2
    //   49: aload_2
    //   50: invokevirtual init : (ILjava/security/Key;)V
    //   53: aload_1
    //   54: aload_0
    //   55: invokevirtual doFinal : ([B)[B
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull -> 158
    //   63: new java/lang/String
    //   66: astore_0
    //   67: aload_0
    //   68: aload_1
    //   69: ldc 'UTF-8'
    //   71: invokespecial <init> : ([BLjava/lang/String;)V
    //   74: aload_0
    //   75: areturn
    //   76: aload_0
    //   77: invokevirtual toUpperCase : ()Ljava/lang/String;
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual length : ()I
    //   85: iconst_2
    //   86: idiv
    //   87: istore_3
    //   88: aload_0
    //   89: invokevirtual toCharArray : ()[C
    //   92: astore #4
    //   94: iload_3
    //   95: newarray byte
    //   97: astore_1
    //   98: iconst_0
    //   99: istore #5
    //   101: aload_1
    //   102: astore_0
    //   103: iload #5
    //   105: iload_3
    //   106: if_icmpge -> 22
    //   109: iload #5
    //   111: iconst_2
    //   112: imul
    //   113: istore #6
    //   115: ldc '0123456789ABCDEF'
    //   117: aload #4
    //   119: iload #6
    //   121: caload
    //   122: invokevirtual indexOf : (I)I
    //   125: i2b
    //   126: istore #7
    //   128: aload_1
    //   129: iload #5
    //   131: ldc '0123456789ABCDEF'
    //   133: aload #4
    //   135: iload #6
    //   137: iconst_1
    //   138: iadd
    //   139: caload
    //   140: invokevirtual indexOf : (I)I
    //   143: i2b
    //   144: iload #7
    //   146: iconst_4
    //   147: ishl
    //   148: ior
    //   149: i2b
    //   150: i2b
    //   151: bastore
    //   152: iinc #5, 1
    //   155: goto -> 101
    //   158: ldc ''
    //   160: astore_0
    //   161: goto -> 74
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual printStackTrace : ()V
    //   169: aconst_null
    //   170: astore_0
    //   171: goto -> 74
    // Exception table:
    //   from	to	target	type
    //   0	7	164	java/lang/Exception
    //   11	20	164	java/lang/Exception
    //   22	59	164	java/lang/Exception
    //   63	74	164	java/lang/Exception
    //   76	98	164	java/lang/Exception
    //   115	152	164	java/lang/Exception
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder("");
    if (paramArrayOfbyte == null || paramArrayOfbyte.length <= 0)
      return null; 
    int i = paramArrayOfbyte.length;
    for (byte b = 0; b < i; b++) {
      String str = Integer.toHexString(paramArrayOfbyte[b] & 0xFF);
      if (str.length() < 2)
        stringBuilder.append(0); 
      stringBuilder.append(str);
    } 
    return stringBuilder.toString();
  }
  
  public static String b(String paramString1, String paramString2) {
    Exception exception2 = null;
    try {
      byte[] arrayOfByte2 = paramString2.getBytes("UTF-8");
      byte[] arrayOfByte1 = paramString1.getBytes();
      DESedeKeySpec dESedeKeySpec = new DESedeKeySpec();
      this(arrayOfByte2);
      SecretKey secretKey = SecretKeyFactory.getInstance("desede").generateSecret(dESedeKeySpec);
      Cipher cipher = Cipher.getInstance("desede/ECB/PKCS5Padding");
      cipher.init(1, secretKey);
      arrayOfByte1 = cipher.doFinal(arrayOfByte1);
    } catch (Exception exception1) {
      exception1.printStackTrace();
      exception1 = exception2;
    } 
    return a((byte[])exception1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\hce\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */