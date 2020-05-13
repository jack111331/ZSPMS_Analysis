package com.chuanglan.shanyan_sdk.utils;

import android.os.Build;
import android.text.TextUtils;

public class RomUtils {
  private static final String a = "Rom";
  
  private static final String b = "MIUI";
  
  private static final String c = "EMUI";
  
  private static final String d = "FLYME";
  
  private static final String e = "OPPO";
  
  private static final String f = "SMARTISAN";
  
  private static final String g = "VIVO";
  
  private static final String h = "QIKU";
  
  private static final String i = "ro.miui.ui.version.name";
  
  private static final String j = "ro.build.version.emui";
  
  private static final String k = "ro.build.version.opporom";
  
  private static final String l = "ro.smartisan.version";
  
  private static final String m = "ro.vivo.os.version";
  
  private static String n;
  
  private static String o;
  
  private static boolean a(String paramString) {
    if (n != null)
      return n.equals(paramString); 
    String str = b("ro.miui.ui.version.name");
    o = str;
    if (!TextUtils.isEmpty(str)) {
      n = "MIUI";
    } else {
      str = b("ro.build.version.emui");
      o = str;
      if (!TextUtils.isEmpty(str)) {
        n = "EMUI";
      } else {
        str = b("ro.build.version.opporom");
        o = str;
        if (!TextUtils.isEmpty(str)) {
          n = "OPPO";
        } else {
          str = b("ro.vivo.os.version");
          o = str;
          if (!TextUtils.isEmpty(str)) {
            n = "VIVO";
          } else {
            str = b("ro.smartisan.version");
            o = str;
            if (!TextUtils.isEmpty(str)) {
              n = "SMARTISAN";
            } else {
              o = Build.DISPLAY;
              if (o.toUpperCase().contains("FLYME")) {
                n = "FLYME";
              } else {
                o = "unknown";
                n = Build.MANUFACTURER.toUpperCase();
              } 
            } 
          } 
        } 
      } 
    } 
    return n.equals(paramString);
  }
  
  private static String b(String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   5: astore_2
    //   6: new java/lang/StringBuilder
    //   9: astore_3
    //   10: aload_3
    //   11: invokespecial <init> : ()V
    //   14: aload_2
    //   15: aload_3
    //   16: ldc 'getprop '
    //   18: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual toString : ()Ljava/lang/String;
    //   28: invokevirtual exec : (Ljava/lang/String;)Ljava/lang/Process;
    //   31: astore_3
    //   32: new java/io/BufferedReader
    //   35: astore_2
    //   36: new java/io/InputStreamReader
    //   39: astore_0
    //   40: aload_0
    //   41: aload_3
    //   42: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   45: invokespecial <init> : (Ljava/io/InputStream;)V
    //   48: aload_2
    //   49: aload_0
    //   50: sipush #1024
    //   53: invokespecial <init> : (Ljava/io/Reader;I)V
    //   56: aload_2
    //   57: astore_0
    //   58: aload_2
    //   59: invokevirtual readLine : ()Ljava/lang/String;
    //   62: astore_1
    //   63: aload_2
    //   64: astore_0
    //   65: aload_2
    //   66: invokevirtual close : ()V
    //   69: aload_1
    //   70: astore_0
    //   71: aload_2
    //   72: ifnull -> 81
    //   75: aload_2
    //   76: invokevirtual close : ()V
    //   79: aload_1
    //   80: astore_0
    //   81: aload_0
    //   82: areturn
    //   83: astore_0
    //   84: aload_0
    //   85: invokevirtual printStackTrace : ()V
    //   88: ldc 'ExceptionLogger'
    //   90: new java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial <init> : ()V
    //   97: ldc 'getProp()Exception == '
    //   99: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: invokevirtual toString : ()Ljava/lang/String;
    //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual toString : ()Ljava/lang/String;
    //   112: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_1
    //   116: astore_0
    //   117: goto -> 81
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: astore_0
    //   125: aload_1
    //   126: invokevirtual printStackTrace : ()V
    //   129: aload_2
    //   130: astore_0
    //   131: new java/lang/StringBuilder
    //   134: astore_3
    //   135: aload_2
    //   136: astore_0
    //   137: aload_3
    //   138: invokespecial <init> : ()V
    //   141: aload_2
    //   142: astore_0
    //   143: ldc 'ExceptionLogger'
    //   145: aload_3
    //   146: ldc 'getProp()Exception == '
    //   148: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_1
    //   152: invokevirtual toString : ()Ljava/lang/String;
    //   155: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual toString : ()Ljava/lang/String;
    //   161: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload_2
    //   165: ifnull -> 172
    //   168: aload_2
    //   169: invokevirtual close : ()V
    //   172: aconst_null
    //   173: astore_0
    //   174: goto -> 81
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual printStackTrace : ()V
    //   182: ldc 'ExceptionLogger'
    //   184: new java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial <init> : ()V
    //   191: ldc 'getProp()Exception == '
    //   193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: invokevirtual toString : ()Ljava/lang/String;
    //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual toString : ()Ljava/lang/String;
    //   206: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   209: goto -> 172
    //   212: astore_0
    //   213: aload_1
    //   214: astore_2
    //   215: aload_2
    //   216: ifnull -> 223
    //   219: aload_2
    //   220: invokevirtual close : ()V
    //   223: aload_0
    //   224: athrow
    //   225: astore_2
    //   226: aload_2
    //   227: invokevirtual printStackTrace : ()V
    //   230: ldc 'ExceptionLogger'
    //   232: new java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial <init> : ()V
    //   239: ldc 'getProp()Exception == '
    //   241: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_2
    //   245: invokevirtual toString : ()Ljava/lang/String;
    //   248: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual toString : ()Ljava/lang/String;
    //   254: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   257: goto -> 223
    //   260: astore_2
    //   261: aload_0
    //   262: astore_1
    //   263: aload_2
    //   264: astore_0
    //   265: aload_1
    //   266: astore_2
    //   267: goto -> 215
    //   270: astore_1
    //   271: goto -> 123
    // Exception table:
    //   from	to	target	type
    //   2	56	120	java/io/IOException
    //   2	56	212	finally
    //   58	63	270	java/io/IOException
    //   58	63	260	finally
    //   65	69	270	java/io/IOException
    //   65	69	260	finally
    //   75	79	83	java/io/IOException
    //   125	129	260	finally
    //   131	135	260	finally
    //   137	141	260	finally
    //   143	164	260	finally
    //   168	172	177	java/io/IOException
    //   219	223	225	java/io/IOException
  }
  
  public static String getName() {
    if (n == null)
      a(""); 
    return n;
  }
  
  public static String getVersion() {
    if (o == null)
      a(""); 
    return o;
  }
  
  public static boolean is360() {
    return (a("QIKU") || a("360"));
  }
  
  public static boolean isEmui() {
    return a("EMUI");
  }
  
  public static boolean isFlyme() {
    return a("FLYME");
  }
  
  public static boolean isMiui() {
    return a("MIUI");
  }
  
  public static boolean isOppo() {
    return a("OPPO");
  }
  
  public static boolean isSmartisan() {
    return a("SMARTISAN");
  }
  
  public static boolean isVivo() {
    return a("VIVO");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\RomUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */