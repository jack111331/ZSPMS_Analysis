package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.c.a;
import com.alipay.security.mobile.module.a.a;
import org.json.JSONObject;

public final class d {
  private static c a(String paramString) {
    try {
      if (!a.a(paramString)) {
        JSONObject jSONObject = new JSONObject();
        this(paramString);
        c c = new c();
        this(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"), jSONObject.optString("tid"), jSONObject.optString("utdid"));
        return c;
      } 
    } catch (Exception exception) {
      a.a(exception);
    } 
    return null;
  }
  
  public static void a() {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/d}} */
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/d}} */
  }
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/d
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'vkeyid_profiles_v4'
    //   6: ldc 'key_deviceid_v4'
    //   8: ldc ''
    //   10: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   13: ldc 'wxcasxx_v4'
    //   15: ldc 'key_wxcasxx_v4'
    //   17: ldc ''
    //   19: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc com/alipay/apmobilesecuritysdk/e/d
    //   24: monitorexit
    //   25: return
    //   26: astore_0
    //   27: ldc com/alipay/apmobilesecuritysdk/e/d
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	26	finally
  }
  
  public static void a(Context paramContext, c paramc) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/d
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
    //   45: ldc 'tid'
    //   47: aload_1
    //   48: invokevirtual d : ()Ljava/lang/String;
    //   51: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   54: pop
    //   55: aload_2
    //   56: ldc 'utdid'
    //   58: aload_1
    //   59: invokevirtual e : ()Ljava/lang/String;
    //   62: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   65: pop
    //   66: aload_2
    //   67: invokevirtual toString : ()Ljava/lang/String;
    //   70: astore_1
    //   71: aload_0
    //   72: ldc 'vkeyid_profiles_v4'
    //   74: ldc 'key_deviceid_v4'
    //   76: aload_1
    //   77: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   80: ldc 'wxcasxx_v4'
    //   82: ldc 'key_wxcasxx_v4'
    //   84: aload_1
    //   85: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   88: ldc com/alipay/apmobilesecuritysdk/e/d
    //   90: monitorexit
    //   91: return
    //   92: astore_0
    //   93: aload_0
    //   94: invokestatic a : (Ljava/lang/Throwable;)V
    //   97: goto -> 88
    //   100: astore_0
    //   101: ldc com/alipay/apmobilesecuritysdk/e/d
    //   103: monitorexit
    //   104: aload_0
    //   105: athrow
    // Exception table:
    //   from	to	target	type
    //   3	88	92	java/lang/Exception
    //   3	88	100	finally
    //   93	97	100	finally
  }
  
  public static c b() {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/d
    //   2: monitorenter
    //   3: ldc 'wxcasxx_v4'
    //   5: ldc 'key_wxcasxx_v4'
    //   7: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_0
    //   11: aload_0
    //   12: invokestatic a : (Ljava/lang/String;)Z
    //   15: istore_1
    //   16: iload_1
    //   17: ifeq -> 27
    //   20: aconst_null
    //   21: astore_0
    //   22: ldc com/alipay/apmobilesecuritysdk/e/d
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: aload_0
    //   28: invokestatic a : (Ljava/lang/String;)Lcom/alipay/apmobilesecuritysdk/e/c;
    //   31: astore_0
    //   32: goto -> 22
    //   35: astore_0
    //   36: ldc com/alipay/apmobilesecuritysdk/e/d
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	35	finally
    //   27	32	35	finally
  }
  
  public static c b(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/d
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'vkeyid_profiles_v4'
    //   6: ldc 'key_deviceid_v4'
    //   8: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_1
    //   12: aload_1
    //   13: astore_0
    //   14: aload_1
    //   15: invokestatic a : (Ljava/lang/String;)Z
    //   18: ifeq -> 29
    //   21: ldc 'wxcasxx_v4'
    //   23: ldc 'key_wxcasxx_v4'
    //   25: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_0
    //   29: aload_0
    //   30: invokestatic a : (Ljava/lang/String;)Lcom/alipay/apmobilesecuritysdk/e/c;
    //   33: astore_0
    //   34: ldc com/alipay/apmobilesecuritysdk/e/d
    //   36: monitorexit
    //   37: aload_0
    //   38: areturn
    //   39: astore_0
    //   40: ldc com/alipay/apmobilesecuritysdk/e/d
    //   42: monitorexit
    //   43: aload_0
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	39	finally
    //   14	29	39	finally
    //   29	34	39	finally
  }
  
  public static c c(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/d
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'vkeyid_profiles_v4'
    //   6: ldc 'key_deviceid_v4'
    //   8: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_0
    //   12: aload_0
    //   13: invokestatic a : (Ljava/lang/String;)Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq -> 28
    //   21: aconst_null
    //   22: astore_0
    //   23: ldc com/alipay/apmobilesecuritysdk/e/d
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: aload_0
    //   29: invokestatic a : (Ljava/lang/String;)Lcom/alipay/apmobilesecuritysdk/e/c;
    //   32: astore_0
    //   33: goto -> 23
    //   36: astore_0
    //   37: ldc com/alipay/apmobilesecuritysdk/e/d
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	17	36	finally
    //   28	33	36	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */