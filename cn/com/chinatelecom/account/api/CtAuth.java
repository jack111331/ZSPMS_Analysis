package cn.com.chinatelecom.account.api;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.a.d;
import cn.com.chinatelecom.account.api.c.b;
import cn.com.chinatelecom.account.api.c.e;

public class CtAuth {
  private static final String TAG = CtAuth.class.getSimpleName();
  
  private static volatile CtAuth instance;
  
  public static String mAppKey = "";
  
  public static String mAppSecret = "";
  
  public static Context mContext;
  
  public static Handler mHandler = new Handler(Looper.getMainLooper());
  
  public static TraceLogger mTraceLogger;
  
  public static CtAuth getInstance() {
    // Byte code:
    //   0: getstatic cn/com/chinatelecom/account/api/CtAuth.instance : Lcn/com/chinatelecom/account/api/CtAuth;
    //   3: ifnonnull -> 30
    //   6: ldc cn/com/chinatelecom/account/api/CtAuth
    //   8: monitorenter
    //   9: getstatic cn/com/chinatelecom/account/api/CtAuth.instance : Lcn/com/chinatelecom/account/api/CtAuth;
    //   12: ifnonnull -> 27
    //   15: new cn/com/chinatelecom/account/api/CtAuth
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic cn/com/chinatelecom/account/api/CtAuth.instance : Lcn/com/chinatelecom/account/api/CtAuth;
    //   27: ldc cn/com/chinatelecom/account/api/CtAuth
    //   29: monitorexit
    //   30: getstatic cn/com/chinatelecom/account/api/CtAuth.instance : Lcn/com/chinatelecom/account/api/CtAuth;
    //   33: areturn
    //   34: astore_0
    //   35: ldc cn/com/chinatelecom/account/api/CtAuth
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public static void info(String paramString1, String paramString2) {
    if (mTraceLogger != null) {
      paramString1 = "CT_" + paramString1;
      mTraceLogger.info(paramString1, paramString2);
    } 
  }
  
  public static void postResultOnMainThread(String paramString, ResultListener paramResultListener) {
    Runnable runnable = new Runnable(paramResultListener, paramString) {
        public void run() {
          if (this.a != null) {
            CtAuth.info(CtAuth.TAG, "callback result : " + this.b);
            this.a.onResult(this.b);
          } 
        }
      };
    mHandler.post(runnable);
  }
  
  public static void warn(String paramString1, String paramString2, Throwable paramThrowable) {
    if (mTraceLogger != null) {
      paramString1 = "CT_" + paramString1;
      mTraceLogger.warn(paramString1, paramString2, paramThrowable);
    } 
  }
  
  public void init(Context paramContext, String paramString1, String paramString2, TraceLogger paramTraceLogger) {
    if (paramContext == null)
      throw new IllegalArgumentException("context must not be null!"); 
    if (paramString1 == null)
      throw new IllegalArgumentException("appKey must not be null!"); 
    if (paramString2 == null)
      throw new IllegalArgumentException("appSecret must not be null!"); 
    if (paramContext instanceof android.app.Application) {
      mContext = paramContext;
    } else {
      mContext = paramContext.getApplicationContext();
    } 
    mAppKey = paramString1;
    mAppSecret = paramString2;
    mTraceLogger = paramTraceLogger;
  }
  
  public void requestLogin(String paramString, CtSetting paramCtSetting, ResultListener paramResultListener) {
    info(TAG, "call requestNetworkAuth()   accessCode：" + paramString);
    if (paramResultListener != null) {
      if (mContext == null || TextUtils.isEmpty(mAppKey) || TextUtils.isEmpty(mAppSecret)) {
        paramResultListener.onResult("{\"result\":\"-8005\",\"msg\":\"请先初始化SDK\"}");
        return;
      } 
      if (!e.b(mContext)) {
        paramResultListener.onResult("{\"result\":\"-8100\",\"msg\":\"网络无连接\"}");
        return;
      } 
      (new a()).c(mContext, mAppKey, mAppSecret, paramString, paramCtSetting, paramResultListener);
    } 
  }
  
  @Deprecated
  public void requestNetworkAuth(String paramString, CtSetting paramCtSetting, ResultListener paramResultListener) {
    requestLogin(paramString, paramCtSetting, paramResultListener);
  }
  
  @Deprecated
  public void requestPreCode(CtSetting paramCtSetting, ResultListener paramResultListener) {
    requestPreLogin(paramCtSetting, paramResultListener);
  }
  
  public void requestPreLogin(CtSetting paramCtSetting, ResultListener paramResultListener) {
    info(TAG, "call requestPreCode()");
    if (paramResultListener != null) {
      if (mContext == null || TextUtils.isEmpty(mAppKey) || TextUtils.isEmpty(mAppSecret)) {
        paramResultListener.onResult("{\"result\":\"-8005\",\"msg\":\"请先初始化SDK\"}");
        return;
      } 
      if (!e.b(mContext)) {
        paramResultListener.onResult("{\"result\":\"-8100\",\"msg\":\"网络无连接\"}");
        return;
      } 
      if (e.d(mContext)) {
        (new a()).a(mContext, mAppKey, mAppSecret, d.a(b.a), paramCtSetting, paramResultListener);
        return;
      } 
      if (e.e(mContext)) {
        (new a()).b(mContext, mAppKey, mAppSecret, d.a(b.a), paramCtSetting, paramResultListener);
        return;
      } 
      paramResultListener.onResult("{\"result\":-8004,\"msg\":\"移动网络未开启\"}");
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\CtAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */