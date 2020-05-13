package com.unionpay.utils;

public final class h {
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
    //   9: ifnull -> 207
    //   12: iload_3
    //   13: istore #5
    //   15: aload_2
    //   16: ifnull -> 207
    //   19: iload_0
    //   20: tableswitch default -> 56, 2 -> 237, 3 -> 210, 4 -> 228, 5 -> 246, 6 -> 219
    //   56: iload #4
    //   58: istore_0
    //   59: iload_0
    //   60: istore #5
    //   62: getstatic com/unionpay/utils/h.a : Z
    //   65: ifeq -> 207
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
    //   156: astore #7
    //   158: aload #7
    //   160: invokespecial <init> : ()V
    //   163: aload #7
    //   165: aload_2
    //   166: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc '\\n'
    //   171: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual toString : ()Ljava/lang/String;
    //   177: astore_2
    //   178: new java/io/FileOutputStream
    //   181: astore #7
    //   183: aload #7
    //   185: aload_1
    //   186: iconst_1
    //   187: invokespecial <init> : (Ljava/io/File;Z)V
    //   190: aload #7
    //   192: aload_2
    //   193: invokevirtual getBytes : ()[B
    //   196: invokevirtual write : ([B)V
    //   199: aload #7
    //   201: invokevirtual close : ()V
    //   204: iload_0
    //   205: istore #5
    //   207: iload #5
    //   209: ireturn
    //   210: aload_1
    //   211: aload_2
    //   212: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   215: istore_0
    //   216: goto -> 59
    //   219: aload_1
    //   220: aload_2
    //   221: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   224: istore_0
    //   225: goto -> 59
    //   228: aload_1
    //   229: aload_2
    //   230: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   233: istore_0
    //   234: goto -> 59
    //   237: aload_1
    //   238: aload_2
    //   239: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   242: istore_0
    //   243: goto -> 59
    //   246: aload_1
    //   247: aload_2
    //   248: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   251: istore_0
    //   252: goto -> 59
    //   255: astore_1
    //   256: aload_1
    //   257: invokevirtual printStackTrace : ()V
    //   260: iload_0
    //   261: istore #5
    //   263: goto -> 207
    // Exception table:
    //   from	to	target	type
    //   94	153	255	java/io/IOException
    //   153	204	255	java/io/IOException
  }
  
  public static int a(String paramString1, String paramString2) {
    if (b <= 3)
      a(3, paramString1, paramString2); 
    return 0;
  }
  
  public static int b(String paramString1, String paramString2) {
    int i = 0;
    if (b <= 6)
      i = a(6, paramString1, paramString2); 
    return i;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpa\\utils\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */