package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import org.json.JSONObject;

public final class a {
  private static b a(String paramString) {
    try {
      if (!com.alipay.security.mobile.module.a.a.a(paramString)) {
        JSONObject jSONObject = new JSONObject();
        this(paramString);
        b b = new b();
        this(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"));
        return b;
      } 
    } catch (Exception exception) {
      com.alipay.apmobilesecuritysdk.c.a.a(exception);
    } 
    return null;
  }
  
  public static void a() {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/a}} */
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/a}} */
  }
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/a
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'vkeyid_profiles_v3'
    //   6: ldc 'deviceid'
    //   8: ldc ''
    //   10: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   13: ldc 'wxcasxx_v3'
    //   15: ldc 'wxcasxx'
    //   17: ldc ''
    //   19: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc com/alipay/apmobilesecuritysdk/e/a
    //   24: monitorexit
    //   25: return
    //   26: astore_0
    //   27: ldc com/alipay/apmobilesecuritysdk/e/a
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	26	finally
  }
  
  public static void a(Context paramContext, b paramb) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/a
    //   2: monitorenter
    //   3: new org/json/JSONObject
    //   6: astore_2
    //   7: aload_2
    //   8: invokespecial <init> : ()V
    //   11: aload_2
    //   12: ldc 'apdid'
    //   14: aload_1
    //   15: invokevirtual a : ()Ljava/lang/String;
    //   18: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   21: pop
    //   22: aload_2
    //   23: ldc 'deviceInfoHash'
    //   25: aload_1
    //   26: invokevirtual b : ()Ljava/lang/String;
    //   29: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   32: pop
    //   33: aload_2
    //   34: ldc 'timestamp'
    //   36: aload_1
    //   37: invokevirtual c : ()Ljava/lang/String;
    //   40: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload_2
    //   45: invokevirtual toString : ()Ljava/lang/String;
    //   48: astore_1
    //   49: aload_0
    //   50: ldc 'vkeyid_profiles_v3'
    //   52: ldc 'deviceid'
    //   54: aload_1
    //   55: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   58: ldc 'wxcasxx_v3'
    //   60: ldc 'wxcasxx'
    //   62: aload_1
    //   63: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   66: ldc com/alipay/apmobilesecuritysdk/e/a
    //   68: monitorexit
    //   69: return
    //   70: astore_0
    //   71: aload_0
    //   72: invokestatic a : (Ljava/lang/Throwable;)V
    //   75: goto -> 66
    //   78: astore_0
    //   79: ldc com/alipay/apmobilesecuritysdk/e/a
    //   81: monitorexit
    //   82: aload_0
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   3	66	70	java/lang/Exception
    //   3	66	78	finally
    //   71	75	78	finally
  }
  
  public static b b() {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/a
    //   2: monitorenter
    //   3: ldc 'wxcasxx_v3'
    //   5: ldc 'wxcasxx'
    //   7: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_0
    //   11: aload_0
    //   12: invokestatic a : (Ljava/lang/String;)Z
    //   15: istore_1
    //   16: iload_1
    //   17: ifeq -> 27
    //   20: aconst_null
    //   21: astore_0
    //   22: ldc com/alipay/apmobilesecuritysdk/e/a
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: aload_0
    //   28: invokestatic a : (Ljava/lang/String;)Lcom/alipay/apmobilesecuritysdk/e/b;
    //   31: astore_0
    //   32: goto -> 22
    //   35: astore_0
    //   36: ldc com/alipay/apmobilesecuritysdk/e/a
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	35	finally
    //   27	32	35	finally
  }
  
  public static b b(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/a
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'vkeyid_profiles_v3'
    //   6: ldc 'deviceid'
    //   8: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_1
    //   12: aload_1
    //   13: astore_0
    //   14: aload_1
    //   15: invokestatic a : (Ljava/lang/String;)Z
    //   18: ifeq -> 29
    //   21: ldc 'wxcasxx_v3'
    //   23: ldc 'wxcasxx'
    //   25: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_0
    //   29: aload_0
    //   30: invokestatic a : (Ljava/lang/String;)Lcom/alipay/apmobilesecuritysdk/e/b;
    //   33: astore_0
    //   34: ldc com/alipay/apmobilesecuritysdk/e/a
    //   36: monitorexit
    //   37: aload_0
    //   38: areturn
    //   39: astore_0
    //   40: ldc com/alipay/apmobilesecuritysdk/e/a
    //   42: monitorexit
    //   43: aload_0
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	39	finally
    //   14	29	39	finally
    //   29	34	39	finally
  }
  
  public static b c(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/a
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'vkeyid_profiles_v3'
    //   6: ldc 'deviceid'
    //   8: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_0
    //   12: aload_0
    //   13: invokestatic a : (Ljava/lang/String;)Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq -> 28
    //   21: aconst_null
    //   22: astore_0
    //   23: ldc com/alipay/apmobilesecuritysdk/e/a
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: aload_0
    //   29: invokestatic a : (Ljava/lang/String;)Lcom/alipay/apmobilesecuritysdk/e/b;
    //   32: astore_0
    //   33: goto -> 23
    //   36: astore_0
    //   37: ldc com/alipay/apmobilesecuritysdk/e/a
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	17	36	finally
    //   28	33	36	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */