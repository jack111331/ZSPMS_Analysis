package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;

public final class g {
  public static String a(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/g
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: astore_2
    //   7: aload_2
    //   8: ldc 'openApi'
    //   10: invokespecial <init> : (Ljava/lang/String;)V
    //   13: aload_0
    //   14: ldc 'openapi_file_pri'
    //   16: aload_2
    //   17: aload_1
    //   18: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual toString : ()Ljava/lang/String;
    //   24: ldc ''
    //   26: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_0
    //   30: aload_0
    //   31: invokestatic a : (Ljava/lang/String;)Z
    //   34: ifeq -> 45
    //   37: ldc ''
    //   39: astore_0
    //   40: ldc com/alipay/apmobilesecuritysdk/e/g
    //   42: monitorexit
    //   43: aload_0
    //   44: areturn
    //   45: invokestatic a : ()Ljava/lang/String;
    //   48: aload_0
    //   49: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_1
    //   53: aload_1
    //   54: astore_0
    //   55: aload_1
    //   56: invokestatic a : (Ljava/lang/String;)Z
    //   59: ifeq -> 40
    //   62: ldc ''
    //   64: astore_0
    //   65: goto -> 40
    //   68: astore_0
    //   69: ldc com/alipay/apmobilesecuritysdk/e/g
    //   71: monitorexit
    //   72: aload_0
    //   73: athrow
    // Exception table:
    //   from	to	target	type
    //   3	37	68	finally
    //   45	53	68	finally
    //   55	62	68	finally
  }
  
  public static void a() {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/g}} */
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/g}} */
  }
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/g
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'openapi_file_pri'
    //   6: iconst_0
    //   7: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   10: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   15: astore_0
    //   16: aload_0
    //   17: ifnull -> 34
    //   20: aload_0
    //   21: invokeinterface clear : ()Landroid/content/SharedPreferences$Editor;
    //   26: pop
    //   27: aload_0
    //   28: invokeinterface commit : ()Z
    //   33: pop
    //   34: ldc com/alipay/apmobilesecuritysdk/e/g
    //   36: monitorexit
    //   37: return
    //   38: astore_0
    //   39: ldc com/alipay/apmobilesecuritysdk/e/g
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	38	finally
    //   20	34	38	finally
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/g
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'openapi_file_pri'
    //   6: iconst_0
    //   7: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   10: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull -> 59
    //   20: new java/lang/StringBuilder
    //   23: astore_0
    //   24: aload_0
    //   25: ldc 'openApi'
    //   27: invokespecial <init> : (Ljava/lang/String;)V
    //   30: aload_3
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual toString : ()Ljava/lang/String;
    //   39: invokestatic a : ()Ljava/lang/String;
    //   42: aload_2
    //   43: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   46: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   51: pop
    //   52: aload_3
    //   53: invokeinterface commit : ()Z
    //   58: pop
    //   59: ldc com/alipay/apmobilesecuritysdk/e/g
    //   61: monitorexit
    //   62: return
    //   63: astore_0
    //   64: ldc com/alipay/apmobilesecuritysdk/e/g
    //   66: monitorexit
    //   67: aload_0
    //   68: athrow
    //   69: astore_0
    //   70: goto -> 59
    // Exception table:
    //   from	to	target	type
    //   3	16	69	java/lang/Throwable
    //   3	16	63	finally
    //   20	59	69	java/lang/Throwable
    //   20	59	63	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */