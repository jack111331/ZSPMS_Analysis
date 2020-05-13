package com.unionpay.mobile.android.utils;

public final class k {
  private static boolean a = false;
  
  private static int b;
  
  static {
    a = false;
    b = Integer.MAX_VALUE;
  }
  
  private static int a(int paramInt, String paramString1, String paramString2) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore #4
    //   5: iload_3
    //   6: istore #5
    //   8: aload_1
    //   9: ifnull -> 205
    //   12: iload_3
    //   13: istore #5
    //   15: aload_2
    //   16: ifnull -> 205
    //   19: iload_0
    //   20: tableswitch default -> 56, 2 -> 235, 3 -> 208, 4 -> 226, 5 -> 244, 6 -> 217
    //   56: iload #4
    //   58: istore_0
    //   59: iload_0
    //   60: istore #5
    //   62: getstatic com/unionpay/mobile/android/utils/k.a : Z
    //   65: ifeq -> 205
    //   68: new java/lang/StringBuilder
    //   71: dup
    //   72: ldc '[ ERROR ] '
    //   74: invokespecial <init> : (Ljava/lang/String;)V
    //   77: aload_1
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc ':'
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_2
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual toString : ()Ljava/lang/String;
    //   93: astore_2
    //   94: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   97: astore #6
    //   99: new java/io/File
    //   102: astore_1
    //   103: new java/lang/StringBuilder
    //   106: astore #7
    //   108: aload #7
    //   110: invokespecial <init> : ()V
    //   113: aload_1
    //   114: aload #7
    //   116: aload #6
    //   118: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   121: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: getstatic java/io/File.separator : Ljava/lang/String;
    //   127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 'upmp_log.txt'
    //   132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual toString : ()Ljava/lang/String;
    //   138: invokespecial <init> : (Ljava/lang/String;)V
    //   141: aload_1
    //   142: invokevirtual exists : ()Z
    //   145: ifne -> 153
    //   148: aload_1
    //   149: invokevirtual createNewFile : ()Z
    //   152: pop
    //   153: new java/lang/StringBuilder
    //   156: astore #6
    //   158: aload #6
    //   160: invokespecial <init> : ()V
    //   163: aload #6
    //   165: aload_2
    //   166: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc '\\n'
    //   171: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual toString : ()Ljava/lang/String;
    //   177: astore #6
    //   179: new java/io/FileOutputStream
    //   182: astore_2
    //   183: aload_2
    //   184: aload_1
    //   185: iconst_1
    //   186: invokespecial <init> : (Ljava/io/File;Z)V
    //   189: aload_2
    //   190: aload #6
    //   192: invokevirtual getBytes : ()[B
    //   195: invokevirtual write : ([B)V
    //   198: aload_2
    //   199: invokevirtual close : ()V
    //   202: iload_0
    //   203: istore #5
    //   205: iload #5
    //   207: ireturn
    //   208: aload_1
    //   209: aload_2
    //   210: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   213: istore_0
    //   214: goto -> 59
    //   217: aload_1
    //   218: aload_2
    //   219: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   222: istore_0
    //   223: goto -> 59
    //   226: aload_1
    //   227: aload_2
    //   228: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   231: istore_0
    //   232: goto -> 59
    //   235: aload_1
    //   236: aload_2
    //   237: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   240: istore_0
    //   241: goto -> 59
    //   244: aload_1
    //   245: aload_2
    //   246: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   249: istore_0
    //   250: goto -> 59
    //   253: astore_1
    //   254: aload_1
    //   255: invokevirtual printStackTrace : ()V
    //   258: iload_0
    //   259: istore #5
    //   261: goto -> 205
    // Exception table:
    //   from	to	target	type
    //   94	153	253	java/io/IOException
    //   153	202	253	java/io/IOException
  }
  
  public static int a(String paramString1, String paramString2) {
    if (b <= 3)
      a(3, paramString1, paramString2); 
    return 0;
  }
  
  public static int b(String paramString1, String paramString2) {
    if (b <= 4)
      a(4, paramString1, paramString2); 
    return 0;
  }
  
  public static int c(String paramString1, String paramString2) {
    int i = 0;
    if (b <= 6)
      i = a(6, paramString1, paramString2); 
    return i;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\utils\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */