package com.sina.weibo.sdk.utils;

public class MD5 {
  private static final char[] hexDigits = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  public static String hexdigest(String paramString) {
    try {
      paramString = hexdigest(paramString.getBytes());
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (String)exception;
  }
  
  public static String hexdigest(byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: ldc 'MD5'
    //   2: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_1
    //   6: aload_1
    //   7: aload_0
    //   8: invokevirtual update : ([B)V
    //   11: aload_1
    //   12: invokevirtual digest : ()[B
    //   15: astore_0
    //   16: bipush #32
    //   18: newarray char
    //   20: astore_1
    //   21: iconst_0
    //   22: istore_2
    //   23: iconst_0
    //   24: istore_3
    //   25: iload_2
    //   26: bipush #16
    //   28: if_icmplt -> 43
    //   31: new java/lang/String
    //   34: astore_0
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial <init> : ([C)V
    //   40: goto -> 100
    //   43: aload_0
    //   44: iload_2
    //   45: baload
    //   46: istore #4
    //   48: iload_3
    //   49: iconst_1
    //   50: iadd
    //   51: istore #5
    //   53: aload_1
    //   54: iload_3
    //   55: getstatic com/sina/weibo/sdk/utils/MD5.hexDigits : [C
    //   58: iload #4
    //   60: iconst_4
    //   61: iushr
    //   62: bipush #15
    //   64: iand
    //   65: caload
    //   66: i2c
    //   67: castore
    //   68: iload #5
    //   70: iconst_1
    //   71: iadd
    //   72: istore_3
    //   73: aload_1
    //   74: iload #5
    //   76: getstatic com/sina/weibo/sdk/utils/MD5.hexDigits : [C
    //   79: iload #4
    //   81: bipush #15
    //   83: iand
    //   84: caload
    //   85: i2c
    //   86: castore
    //   87: iinc #2, 1
    //   90: goto -> 25
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual printStackTrace : ()V
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: areturn
    // Exception table:
    //   from	to	target	type
    //   0	21	93	java/lang/Exception
    //   31	40	93	java/lang/Exception
    //   53	68	93	java/lang/Exception
    //   73	87	93	java/lang/Exception
  }
  
  public static void main(String[] paramArrayOfString) {
    System.out.println(hexdigest("c"));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sd\\utils\MD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */