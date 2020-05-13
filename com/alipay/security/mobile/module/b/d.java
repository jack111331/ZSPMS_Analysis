package com.alipay.security.mobile.module.b;

import android.content.Context;
import android.os.Build;

public final class d {
  private static d a = new d();
  
  public static d a() {
    return a;
  }
  
  private static String a(String paramString1, String paramString2) {
    try {
      paramString1 = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 });
      paramString2 = paramString1;
    } catch (Exception exception) {}
    return paramString2;
  }
  
  public static boolean a(Context paramContext) {
    // Byte code:
    //   0: getstatic android/os/Build.HARDWARE : Ljava/lang/String;
    //   3: ldc 'goldfish'
    //   5: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   8: ifne -> 33
    //   11: getstatic android/os/Build.PRODUCT : Ljava/lang/String;
    //   14: ldc 'sdk'
    //   16: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   19: ifne -> 33
    //   22: getstatic android/os/Build.FINGERPRINT : Ljava/lang/String;
    //   25: ldc 'generic'
    //   27: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   30: ifeq -> 37
    //   33: iconst_1
    //   34: istore_1
    //   35: iload_1
    //   36: ireturn
    //   37: aload_0
    //   38: ldc 'phone'
    //   40: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   43: checkcast android/telephony/TelephonyManager
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull -> 132
    //   51: aload_2
    //   52: invokevirtual getDeviceId : ()Ljava/lang/String;
    //   55: astore_2
    //   56: aload_2
    //   57: ifnull -> 69
    //   60: aload_2
    //   61: invokevirtual length : ()I
    //   64: istore_3
    //   65: iload_3
    //   66: ifne -> 82
    //   69: iconst_1
    //   70: istore #4
    //   72: iload #4
    //   74: ifeq -> 132
    //   77: iconst_1
    //   78: istore_1
    //   79: goto -> 35
    //   82: iconst_0
    //   83: istore #4
    //   85: iload #4
    //   87: iload_3
    //   88: if_icmpge -> 126
    //   91: aload_2
    //   92: iload #4
    //   94: invokevirtual charAt : (I)C
    //   97: invokestatic isWhitespace : (C)Z
    //   100: ifne -> 120
    //   103: aload_2
    //   104: iload #4
    //   106: invokevirtual charAt : (I)C
    //   109: bipush #48
    //   111: if_icmpeq -> 120
    //   114: iconst_0
    //   115: istore #4
    //   117: goto -> 72
    //   120: iinc #4, 1
    //   123: goto -> 85
    //   126: iconst_1
    //   127: istore #4
    //   129: goto -> 72
    //   132: aload_0
    //   133: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   136: ldc 'android_id'
    //   138: invokestatic getString : (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   141: invokestatic a : (Ljava/lang/String;)Z
    //   144: istore_1
    //   145: goto -> 35
    //   148: astore_0
    //   149: iconst_0
    //   150: istore_1
    //   151: goto -> 35
    // Exception table:
    //   from	to	target	type
    //   0	33	148	java/lang/Exception
    //   37	47	148	java/lang/Exception
    //   51	56	148	java/lang/Exception
    //   60	65	148	java/lang/Exception
    //   91	114	148	java/lang/Exception
    //   132	145	148	java/lang/Exception
  }
  
  public static String b() {
    return "android";
  }
  
  public static boolean c() {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: iconst_0
    //   3: istore_1
    //   4: iload_1
    //   5: iconst_5
    //   6: if_icmpge -> 88
    //   9: new java/io/File
    //   12: astore_2
    //   13: new java/lang/StringBuilder
    //   16: astore_3
    //   17: aload_3
    //   18: invokespecial <init> : ()V
    //   21: aload_2
    //   22: aload_3
    //   23: iconst_5
    //   24: anewarray java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: ldc '/system/bin/'
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: ldc '/system/xbin/'
    //   36: aastore
    //   37: dup
    //   38: iconst_2
    //   39: ldc '/system/sbin/'
    //   41: aastore
    //   42: dup
    //   43: iconst_3
    //   44: ldc '/sbin/'
    //   46: aastore
    //   47: dup
    //   48: iconst_4
    //   49: ldc '/vendor/bin/'
    //   51: aastore
    //   52: iload_1
    //   53: aaload
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc 'su'
    //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual toString : ()Ljava/lang/String;
    //   65: invokespecial <init> : (Ljava/lang/String;)V
    //   68: aload_2
    //   69: invokevirtual exists : ()Z
    //   72: istore #4
    //   74: iload #4
    //   76: ifeq -> 81
    //   79: iload_0
    //   80: ireturn
    //   81: iinc #1, 1
    //   84: goto -> 4
    //   87: astore_2
    //   88: iconst_0
    //   89: istore_0
    //   90: goto -> 79
    // Exception table:
    //   from	to	target	type
    //   9	74	87	java/lang/Exception
  }
  
  public static String d() {
    return Build.BOARD;
  }
  
  public static String e() {
    return Build.BRAND;
  }
  
  public static String f() {
    return Build.DEVICE;
  }
  
  public static String g() {
    return Build.DISPLAY;
  }
  
  public static String h() {
    return Build.VERSION.INCREMENTAL;
  }
  
  public static String i() {
    return Build.MANUFACTURER;
  }
  
  public static String j() {
    return Build.MODEL;
  }
  
  public static String k() {
    return Build.PRODUCT;
  }
  
  public static String l() {
    return Build.VERSION.RELEASE;
  }
  
  public static String m() {
    return Build.VERSION.SDK;
  }
  
  public static String n() {
    return Build.TAGS;
  }
  
  public static String o() {
    return a("ro.kernel.qemu", "0");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */