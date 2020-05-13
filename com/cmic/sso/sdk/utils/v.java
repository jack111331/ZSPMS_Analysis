package com.cmic.sso.sdk.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class v {
  private static String a(String[] paramArrayOfString) {
    StringBuilder stringBuilder = new StringBuilder();
    ProcessBuilder processBuilder = new ProcessBuilder(paramArrayOfString);
    try {
      Process process = processBuilder.start();
      BufferedReader bufferedReader = new BufferedReader();
      InputStreamReader inputStreamReader = new InputStreamReader();
      this(process.getInputStream());
      this(inputStreamReader);
      while (true) {
        String str = bufferedReader.readLine();
        if (str != null) {
          stringBuilder.append(str);
          continue;
        } 
        process.getInputStream().close();
        process.destroy();
        return stringBuilder.toString();
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return stringBuilder.toString();
  }
  
  public static boolean a() {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: bipush #6
    //   4: anewarray java/lang/String
    //   7: astore_1
    //   8: aload_1
    //   9: iconst_0
    //   10: ldc '/system/xbin/'
    //   12: aastore
    //   13: aload_1
    //   14: iconst_1
    //   15: ldc '/system/bin/'
    //   17: aastore
    //   18: aload_1
    //   19: iconst_2
    //   20: ldc '/system/sbin/'
    //   22: aastore
    //   23: aload_1
    //   24: iconst_3
    //   25: ldc '/sbin/'
    //   27: aastore
    //   28: aload_1
    //   29: iconst_4
    //   30: ldc '/vendor/bin/'
    //   32: aastore
    //   33: aload_1
    //   34: iconst_5
    //   35: ldc '/su/bin/'
    //   37: aastore
    //   38: aload_1
    //   39: arraylength
    //   40: istore_2
    //   41: iconst_0
    //   42: istore_3
    //   43: iload_3
    //   44: iload_2
    //   45: if_icmpge -> 198
    //   48: aload_1
    //   49: iload_3
    //   50: aaload
    //   51: astore #4
    //   53: new java/lang/StringBuilder
    //   56: astore #5
    //   58: aload #5
    //   60: invokespecial <init> : ()V
    //   63: aload #5
    //   65: aload #4
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 'su'
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual toString : ()Ljava/lang/String;
    //   78: astore #5
    //   80: new java/io/File
    //   83: astore #4
    //   85: aload #4
    //   87: aload #5
    //   89: invokespecial <init> : (Ljava/lang/String;)V
    //   92: aload #4
    //   94: invokevirtual exists : ()Z
    //   97: ifeq -> 187
    //   100: iconst_3
    //   101: anewarray java/lang/String
    //   104: dup
    //   105: iconst_0
    //   106: ldc 'ls'
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: ldc '-l'
    //   113: aastore
    //   114: dup
    //   115: iconst_2
    //   116: aload #5
    //   118: aastore
    //   119: invokestatic a : ([Ljava/lang/String;)Ljava/lang/String;
    //   122: astore #5
    //   124: new java/lang/StringBuilder
    //   127: astore_1
    //   128: aload_1
    //   129: invokespecial <init> : ()V
    //   132: ldc 'cyb'
    //   134: aload_1
    //   135: ldc 'isRooted='
    //   137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload #5
    //   142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual toString : ()Ljava/lang/String;
    //   148: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload #5
    //   153: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   156: ifne -> 182
    //   159: aload #5
    //   161: ldc 'root'
    //   163: invokevirtual indexOf : (Ljava/lang/String;)I
    //   166: istore_2
    //   167: aload #5
    //   169: ldc 'root'
    //   171: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   174: istore_3
    //   175: iload_2
    //   176: iload_3
    //   177: if_icmpeq -> 182
    //   180: iload_0
    //   181: ireturn
    //   182: iconst_0
    //   183: istore_0
    //   184: goto -> 180
    //   187: iinc #3, 1
    //   190: goto -> 43
    //   193: astore_1
    //   194: aload_1
    //   195: invokevirtual printStackTrace : ()V
    //   198: iconst_0
    //   199: istore_0
    //   200: goto -> 180
    // Exception table:
    //   from	to	target	type
    //   38	41	193	java/lang/Exception
    //   53	175	193	java/lang/Exception
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */