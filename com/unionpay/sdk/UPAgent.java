package com.unionpay.sdk;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import java.util.Map;

public final class UPAgent {
  public static boolean ENABLE_MULTI_PROCESS_POST;
  
  public static boolean LOG_ON = true;
  
  private static v a;
  
  static {
    ENABLE_MULTI_PROCESS_POST = false;
  }
  
  private static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/unionpay/sdk/UPAgent
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   7: putstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   10: getstatic com/unionpay/sdk/UPAgent.a : Lcom/unionpay/sdk/v;
    //   13: ifnonnull -> 26
    //   16: invokestatic currentTimeMillis : ()J
    //   19: pop2
    //   20: invokestatic a : ()Lcom/unionpay/sdk/zz;
    //   23: putstatic com/unionpay/sdk/UPAgent.a : Lcom/unionpay/sdk/v;
    //   26: ldc com/unionpay/sdk/UPAgent
    //   28: monitorexit
    //   29: return
    //   30: astore_0
    //   31: ldc com/unionpay/sdk/UPAgent
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	26	30	finally
  }
  
  public static String getDeviceId(Context paramContext) {
    // Byte code:
    //   0: ldc com/unionpay/sdk/UPAgent
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic a : (Landroid/content/Context;)V
    //   7: getstatic com/unionpay/sdk/UPAgent.a : Lcom/unionpay/sdk/v;
    //   10: aload_0
    //   11: invokeinterface b : (Landroid/content/Context;)Ljava/lang/String;
    //   16: astore_0
    //   17: ldc com/unionpay/sdk/UPAgent
    //   19: monitorexit
    //   20: aload_0
    //   21: areturn
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual printStackTrace : ()V
    //   27: aconst_null
    //   28: astore_0
    //   29: goto -> 17
    //   32: astore_0
    //   33: ldc com/unionpay/sdk/UPAgent
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   3	17	22	java/lang/Throwable
    //   3	17	32	finally
    //   23	27	32	finally
  }
  
  public static int getNFCStatus(Context paramContext) {
    return e.b(paramContext);
  }
  
  public static void init(Context paramContext) {
    // Byte code:
    //   0: ldc com/unionpay/sdk/UPAgent
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic a : (Landroid/content/Context;)V
    //   7: getstatic com/unionpay/sdk/UPAgent.a : Lcom/unionpay/sdk/v;
    //   10: aload_0
    //   11: invokeinterface a : (Landroid/content/Context;)V
    //   16: ldc com/unionpay/sdk/UPAgent
    //   18: monitorexit
    //   19: return
    //   20: astore_0
    //   21: aload_0
    //   22: invokevirtual printStackTrace : ()V
    //   25: goto -> 16
    //   28: astore_0
    //   29: ldc com/unionpay/sdk/UPAgent
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	20	java/lang/Throwable
    //   3	16	28	finally
    //   21	25	28	finally
  }
  
  public static void init(Context paramContext, String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/unionpay/sdk/UPAgent
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic a : (Landroid/content/Context;)V
    //   7: getstatic com/unionpay/sdk/UPAgent.a : Lcom/unionpay/sdk/v;
    //   10: aload_0
    //   11: aload_1
    //   12: aload_2
    //   13: invokeinterface a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   18: ldc com/unionpay/sdk/UPAgent
    //   20: monitorexit
    //   21: return
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual printStackTrace : ()V
    //   27: goto -> 18
    //   30: astore_0
    //   31: ldc com/unionpay/sdk/UPAgent
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	18	22	java/lang/Throwable
    //   3	18	30	finally
    //   23	27	30	finally
  }
  
  public static void onError(Context paramContext, Throwable paramThrowable) {
    try {
      a(paramContext);
      a.a(paramContext, paramThrowable);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public static void onEvent(Context paramContext, String paramString) {
    onEvent(paramContext, paramString, "", null);
  }
  
  public static void onEvent(Context paramContext, String paramString1, String paramString2) {
    onEvent(paramContext, paramString1, paramString2, null);
  }
  
  public static void onEvent(Context paramContext, String paramString1, String paramString2, Map paramMap) {
    try {
      a(paramContext);
      a.a(paramContext, paramString1, paramString2, paramMap);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public static void onPageEnd(Context paramContext, String paramString) {
    try {
      a(paramContext);
      a.onPageEnd(paramContext, paramString);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public static void onPageStart(Context paramContext, String paramString) {
    try {
      a(paramContext);
      a.onPageStart(paramContext, paramString);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public static void onPause(Activity paramActivity) {
    try {
      a((Context)paramActivity);
      a.b(paramActivity);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public static void onResume(Activity paramActivity) {
    try {
      a((Context)paramActivity);
      a.a(paramActivity);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public static void onResume(Activity paramActivity, String paramString1, String paramString2) {
    try {
      a((Context)paramActivity);
      a.onResume(paramActivity, paramString1, paramString2);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public static void removeGlobalKV(String paramString) {
    if (LOG_ON && paramString != null)
      Log.i("UPLog", "removeGlobalKV# key:" + paramString); 
    ab.a.remove(paramString);
  }
  
  public static void setAdditionalVersionNameAndCode(String paramString, long paramLong) {
    try {
      w.a(paramString, paramLong);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public static void setGlobalKV(String paramString, Object paramObject) {
    if (LOG_ON && paramString != null && paramObject != null)
      Log.i("UPLog", "setGlobalKV# key:" + paramString + " value:" + paramObject.toString()); 
    ab.a.put(paramString, paramObject);
  }
  
  public static void setReportUncaughtExceptions(boolean paramBoolean) {
    try {
      ab.b = paramBoolean;
      if (LOG_ON) {
        StringBuilder stringBuilder = new StringBuilder();
        this("[PreSettings] setReportUncaughtExceptions: ");
        Log.i("UPLog", stringBuilder.append(paramBoolean).toString());
      } 
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\UPAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */