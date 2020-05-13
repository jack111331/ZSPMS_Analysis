package com.alipay.security.mobile.module.c;

import android.content.Context;

public class a {
  public static String a(Context paramContext, String paramString1, String paramString2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: ldc com/alipay/security/mobile/module/c/a
    //   7: monitorenter
    //   8: aload_0
    //   9: ifnull -> 26
    //   12: aload_1
    //   13: invokestatic a : (Ljava/lang/String;)Z
    //   16: ifne -> 26
    //   19: aload_2
    //   20: invokestatic a : (Ljava/lang/String;)Z
    //   23: ifeq -> 34
    //   26: ldc com/alipay/security/mobile/module/c/a
    //   28: monitorexit
    //   29: aload #4
    //   31: astore_0
    //   32: aload_0
    //   33: areturn
    //   34: aload_0
    //   35: aload_1
    //   36: aload_2
    //   37: ldc ''
    //   39: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: invokestatic a : (Ljava/lang/String;)Z
    //   47: istore #5
    //   49: iload #5
    //   51: ifeq -> 69
    //   54: ldc com/alipay/security/mobile/module/c/a
    //   56: monitorexit
    //   57: aload #4
    //   59: astore_0
    //   60: goto -> 32
    //   63: astore_0
    //   64: ldc com/alipay/security/mobile/module/c/a
    //   66: monitorexit
    //   67: aload_0
    //   68: athrow
    //   69: invokestatic a : ()Ljava/lang/String;
    //   72: aload_0
    //   73: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   76: astore_0
    //   77: ldc com/alipay/security/mobile/module/c/a
    //   79: monitorexit
    //   80: goto -> 32
    //   83: astore_0
    //   84: aload_3
    //   85: astore_0
    //   86: goto -> 77
    // Exception table:
    //   from	to	target	type
    //   12	26	63	finally
    //   26	29	63	finally
    //   34	49	83	java/lang/Throwable
    //   34	49	63	finally
    //   54	57	63	finally
    //   69	77	83	java/lang/Throwable
    //   69	77	63	finally
    //   77	80	63	finally
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: ldc com/alipay/security/mobile/module/c/a
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic a : (Ljava/lang/String;)Z
    //   7: ifne -> 21
    //   10: aload_2
    //   11: invokestatic a : (Ljava/lang/String;)Z
    //   14: ifne -> 21
    //   17: aload_0
    //   18: ifnonnull -> 25
    //   21: ldc com/alipay/security/mobile/module/c/a
    //   23: monitorexit
    //   24: return
    //   25: invokestatic a : ()Ljava/lang/String;
    //   28: aload_3
    //   29: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   32: astore #4
    //   34: new java/util/HashMap
    //   37: astore_3
    //   38: aload_3
    //   39: invokespecial <init> : ()V
    //   42: aload_3
    //   43: aload_2
    //   44: aload #4
    //   46: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: pop
    //   52: aload_0
    //   53: aload_1
    //   54: aload_3
    //   55: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V
    //   58: ldc com/alipay/security/mobile/module/c/a
    //   60: monitorexit
    //   61: goto -> 24
    //   64: astore_0
    //   65: ldc com/alipay/security/mobile/module/c/a
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    //   70: astore_0
    //   71: goto -> 58
    // Exception table:
    //   from	to	target	type
    //   3	17	64	finally
    //   21	24	64	finally
    //   25	58	70	java/lang/Throwable
    //   25	58	64	finally
    //   58	61	64	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */