package com.unionpay.sdk;

import android.app.Activity;
import android.content.Context;
import java.util.Map;

public final class zz implements v {
  private static volatile zz a = null;
  
  public zz() {
    a = this;
  }
  
  static zz a() {
    // Byte code:
    //   0: ldc com/unionpay/sdk/zz
    //   2: monitorenter
    //   3: getstatic com/unionpay/sdk/zz.a : Lcom/unionpay/sdk/zz;
    //   6: ifnonnull -> 33
    //   9: ldc com/unionpay/sdk/zz
    //   11: monitorenter
    //   12: getstatic com/unionpay/sdk/zz.a : Lcom/unionpay/sdk/zz;
    //   15: ifnonnull -> 30
    //   18: new com/unionpay/sdk/zz
    //   21: astore_0
    //   22: aload_0
    //   23: invokespecial <init> : ()V
    //   26: aload_0
    //   27: putstatic com/unionpay/sdk/zz.a : Lcom/unionpay/sdk/zz;
    //   30: ldc com/unionpay/sdk/zz
    //   32: monitorexit
    //   33: getstatic com/unionpay/sdk/zz.a : Lcom/unionpay/sdk/zz;
    //   36: astore_0
    //   37: ldc com/unionpay/sdk/zz
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: astore_0
    //   43: ldc com/unionpay/sdk/zz
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    //   48: astore_0
    //   49: ldc com/unionpay/sdk/zz
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	48	finally
    //   12	30	42	finally
    //   30	33	42	finally
    //   33	37	48	finally
    //   43	48	48	finally
  }
  
  public final void a(Activity paramActivity) {
    try {
      w.a(paramActivity);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public final void a(Context paramContext) {
    try {
      a(paramContext, null, null);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2) {
    try {
      w.a(paramContext, paramString1, paramString2);
      t.a();
      au au = new au();
      this(this);
      k.execute(au);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, Map paramMap) {
    try {
      w.a(paramContext, paramString1, paramString2, paramMap);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public final void a(Context paramContext, Throwable paramThrowable) {
    try {
      w.a(paramContext, paramThrowable);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public final String b(Context paramContext) {
    try {
      String str = w.a(paramContext);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public final void b(Activity paramActivity) {
    try {
      w.b(paramActivity);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public final void c(boolean paramBoolean) {
    try {
      ab.b = paramBoolean;
      if (UPAgent.LOG_ON) {
        StringBuilder stringBuilder = new StringBuilder();
        this("[PreSettings] setReportUncaughtExceptions: ");
        ay.a(stringBuilder.append(paramBoolean).toString());
      } 
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public final void onPageEnd(Context paramContext, String paramString) {
    try {
      w.b(paramContext, paramString);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public final void onPageStart(Context paramContext, String paramString) {
    try {
      w.a(paramContext, paramString);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  public final void onResume(Activity paramActivity, String paramString1, String paramString2) {
    try {
      w.a(paramActivity, paramString1, paramString2);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\zz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */