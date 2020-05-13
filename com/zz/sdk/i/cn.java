package com.zz.sdk.i;

public class cn {
  public static final String a = "SHA-256";
  
  public static final String b = "SHA-1";
  
  public static final String c = "MD5";
  
  protected static final char[] d = "0123456789abcdef".toCharArray();
  
  protected static final char[] e = "0123456789ABCDEF".toCharArray();
  
  public static String a(String paramString) {
    return c(paramString.getBytes());
  }
  
  public static String a(String paramString1, String paramString2) {
    return a("MD5", new Object[] { "SDK", paramString1, paramString2 });
  }
  
  public static String a(String paramString, Object... paramVarArgs) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 118
    //   4: aload_0
    //   5: ifnull -> 17
    //   8: aload_0
    //   9: astore_2
    //   10: aload_0
    //   11: invokevirtual length : ()I
    //   14: ifne -> 20
    //   17: ldc 'SHA-256'
    //   19: astore_2
    //   20: aload_2
    //   21: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
    //   24: astore_2
    //   25: aload_1
    //   26: arraylength
    //   27: istore_3
    //   28: iconst_0
    //   29: istore #4
    //   31: iload #4
    //   33: iload_3
    //   34: if_icmpge -> 107
    //   37: aload_1
    //   38: iload #4
    //   40: aaload
    //   41: astore_0
    //   42: aload_0
    //   43: instanceof [B
    //   46: ifeq -> 63
    //   49: aload_2
    //   50: aload_0
    //   51: checkcast [B
    //   54: invokevirtual update : ([B)V
    //   57: iinc #4, 1
    //   60: goto -> 31
    //   63: aload_0
    //   64: instanceof java/lang/String
    //   67: ifeq -> 89
    //   70: aload_2
    //   71: aload_0
    //   72: checkcast java/lang/String
    //   75: invokevirtual getBytes : ()[B
    //   78: invokevirtual update : ([B)V
    //   81: goto -> 57
    //   84: astore_0
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_0
    //   88: areturn
    //   89: aload_0
    //   90: ifnull -> 57
    //   93: aload_2
    //   94: aload_0
    //   95: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   98: invokevirtual getBytes : ()[B
    //   101: invokevirtual update : ([B)V
    //   104: goto -> 57
    //   107: aload_2
    //   108: invokevirtual digest : ()[B
    //   111: invokestatic a : ([B)Ljava/lang/String;
    //   114: astore_0
    //   115: goto -> 87
    //   118: aconst_null
    //   119: astore_0
    //   120: goto -> 87
    // Exception table:
    //   from	to	target	type
    //   10	17	84	java/security/NoSuchAlgorithmException
    //   20	28	84	java/security/NoSuchAlgorithmException
    //   42	57	84	java/security/NoSuchAlgorithmException
    //   63	81	84	java/security/NoSuchAlgorithmException
    //   93	104	84	java/security/NoSuchAlgorithmException
    //   107	115	84	java/security/NoSuchAlgorithmException
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, d);
  }
  
  private static String a(byte[] paramArrayOfbyte, char[] paramArrayOfchar) {
    int i = 0;
    char[] arrayOfChar = new char[paramArrayOfbyte.length + paramArrayOfbyte.length];
    for (byte b = 0; b < paramArrayOfbyte.length; b++) {
      byte b1 = paramArrayOfbyte[b];
      int j = i + 1;
      arrayOfChar[i] = (char)paramArrayOfchar[(b1 & 0xF0) >> 4];
      i = j + 1;
      arrayOfChar[j] = (char)paramArrayOfchar[b1 & 0xF];
    } 
    return new String(arrayOfChar);
  }
  
  public static String b(String paramString) {
    return d(paramString.getBytes());
  }
  
  public static String b(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, d);
  }
  
  public static String c(byte[] paramArrayOfbyte) {
    return a("MD5", new Object[] { "SDK", paramArrayOfbyte, "YINGXIONG-2015" });
  }
  
  public static String d(byte[] paramArrayOfbyte) {
    return a("MD5", new Object[] { "YINGXIONG-2015", paramArrayOfbyte, "DKS" });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */