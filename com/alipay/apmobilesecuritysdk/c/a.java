package com.alipay.apmobilesecuritysdk.c;

import android.content.Context;
import android.os.Build;

public final class a {
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/c/a
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: aload_2
    //   6: aload_3
    //   7: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/alipay/security/mobile/module/d/a;
    //   10: astore_1
    //   11: new java/lang/StringBuilder
    //   14: astore_2
    //   15: aload_2
    //   16: invokespecial <init> : ()V
    //   19: aload_2
    //   20: aload_0
    //   21: invokevirtual getFilesDir : ()Ljava/io/File;
    //   24: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc '/log/ap'
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual toString : ()Ljava/lang/String;
    //   38: astore_0
    //   39: invokestatic getInstance : ()Ljava/util/Calendar;
    //   42: invokevirtual getTime : ()Ljava/util/Date;
    //   45: astore_3
    //   46: new java/text/SimpleDateFormat
    //   49: astore_2
    //   50: aload_2
    //   51: ldc 'yyyyMMdd'
    //   53: invokespecial <init> : (Ljava/lang/String;)V
    //   56: aload_2
    //   57: aload_3
    //   58: invokevirtual format : (Ljava/util/Date;)Ljava/lang/String;
    //   61: astore_2
    //   62: new java/lang/StringBuilder
    //   65: astore_3
    //   66: aload_3
    //   67: invokespecial <init> : ()V
    //   70: aload_0
    //   71: aload_3
    //   72: aload_2
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc '.log'
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual toString : ()Ljava/lang/String;
    //   84: aload_1
    //   85: invokevirtual toString : ()Ljava/lang/String;
    //   88: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   91: ldc com/alipay/apmobilesecuritysdk/c/a
    //   93: monitorexit
    //   94: return
    //   95: astore_0
    //   96: ldc com/alipay/apmobilesecuritysdk/c/a
    //   98: monitorexit
    //   99: aload_0
    //   100: athrow
    // Exception table:
    //   from	to	target	type
    //   3	91	95	finally
  }
  
  public static void a(String paramString) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/c/a
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic a : (Ljava/lang/String;)V
    //   7: ldc com/alipay/apmobilesecuritysdk/c/a
    //   9: monitorexit
    //   10: return
    //   11: astore_0
    //   12: ldc com/alipay/apmobilesecuritysdk/c/a
    //   14: monitorexit
    //   15: aload_0
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	11	finally
  }
  
  public static void a(Throwable paramThrowable) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/c/a
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic a : (Ljava/lang/Throwable;)V
    //   7: ldc com/alipay/apmobilesecuritysdk/c/a
    //   9: monitorexit
    //   10: return
    //   11: astore_0
    //   12: ldc com/alipay/apmobilesecuritysdk/c/a
    //   14: monitorexit
    //   15: aload_0
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	11	finally
  }
  
  private static com.alipay.security.mobile.module.d.a b(Context paramContext, String paramString1, String paramString2, String paramString3) {
    String str1;
    String str2 = "";
    try {
      str1 = paramContext.getPackageName();
    } catch (Throwable throwable) {
      str1 = str2;
    } 
    return new com.alipay.security.mobile.module.d.a(Build.MODEL, str1, "APPSecuritySDK-ALIPAYSDK", "3.2.2-20180307", paramString1, paramString2, paramString3);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */