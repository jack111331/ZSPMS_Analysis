package cn.com.chinatelecom.account.api;

import android.content.Context;
import android.net.Network;
import android.os.Build;
import cn.com.chinatelecom.account.api.b.c;
import cn.com.chinatelecom.account.api.b.d;
import cn.com.chinatelecom.account.api.b.e;
import cn.com.chinatelecom.account.api.b.f;
import cn.com.chinatelecom.account.api.c.a;
import cn.com.chinatelecom.account.api.c.f;
import cn.com.chinatelecom.account.api.c.i;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class a {
  private static final String a = a.class.getSimpleName();
  
  private String a(Context paramContext, String paramString1, String paramString2, String paramString3, CtSetting paramCtSetting) {
    String str;
    try {
      long l = a.a(paramContext);
      paramString2 = f.a(paramContext, paramString1, paramString2, paramString3, a.a(paramString3), l, "");
      JSONObject jSONObject = new JSONObject();
      this(paramString2);
      paramString2 = jSONObject.optString("p");
      String str1 = jSONObject.optString("k");
      str = a.a(paramContext, (c.a(paramContext, f.a(), paramString2, paramCtSetting, null, false, 0, "Auth")).b, str1);
    } catch (Throwable throwable) {
      str = "{\"result\":\"-8001\",\"msg\":\"请求网络异常\"}";
      CtAuth.warn(a, "AuthManager requestNetworkAuth() exception", throwable);
    } 
    return str;
  }
  
  private String a(Context paramContext, String paramString1, String paramString2, String paramString3, CtSetting paramCtSetting, Network paramNetwork) {
    String str;
    try {
      long l = a.a(paramContext);
      String str1 = f.a(paramContext);
      String str2 = f.a(paramContext, paramString1, paramString2, paramString3, l, "");
      JSONObject jSONObject = new JSONObject();
      this(str2);
      str2 = jSONObject.optString("p");
      String str3 = jSONObject.optString("k");
      e e = c.a(paramContext, str1, str2, paramCtSetting, paramNetwork, true, 0, "preAuth");
      if (e.c)
        return b(paramContext, paramString1, paramString2, paramString3, paramCtSetting, paramNetwork); 
      str = a.a(paramContext, e, str3, paramNetwork, true);
    } catch (Throwable throwable) {
      str = "{\"result\":\"-8001\",\"msg\":\"请求网络异常\"}";
      CtAuth.warn(a, "AuthManager getPreMobile() exception", throwable);
    } 
    return str;
  }
  
  private void a(f.a parama, int paramInt, ResultListener paramResultListener) {
    f.a(new Runnable(this, f.b((Runnable)parama), paramInt, parama, paramResultListener) {
          public void run() {
            try {
              this.a.get(this.b, TimeUnit.MILLISECONDS);
              return;
            } catch (Throwable throwable) {
              this.c.a(true);
              if (throwable instanceof java.util.concurrent.TimeoutException) {
                CtAuth.postResultOnMainThread("{\"result\":-8003,\"msg\":\"请求超时\"}", this.d);
              } else {
                CtAuth.warn(a.a(), "submitOnTimeoutInterrupted other exception", throwable);
                CtAuth.postResultOnMainThread("{\"result\":\"-8001\",\"msg\":\"请求网络异常\"}", this.d);
              } 
              return;
            } finally {
              if (this.a != null && !this.a.isDone())
                this.a.cancel(true); 
            } 
          }
        });
  }
  
  private String b(Context paramContext, String paramString1, String paramString2, String paramString3, CtSetting paramCtSetting, Network paramNetwork) {
    String str;
    try {
      long l = a.a(paramContext);
      String str2 = f.a(paramContext);
      paramString1 = f.a(paramContext, paramString1, paramString2, paramString3, l, "");
      JSONObject jSONObject = new JSONObject();
      this(paramString1);
      paramString1 = jSONObject.optString("p");
      String str1 = jSONObject.optString("k");
      str = a.a(paramContext, c.a(paramContext, str2, paramString1, paramCtSetting, paramNetwork, true, 0, "preAuth"), str1, paramNetwork, true);
    } catch (Throwable throwable) {
      str = "{\"result\":\"-8001\",\"msg\":\"请求网络异常\"}";
      CtAuth.warn(a, "AuthManager retryPreMobile() exception", throwable);
    } 
    return str;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, CtSetting paramCtSetting, ResultListener paramResultListener) {
    int i = CtSetting.getTotalTimeout(paramCtSetting);
    a(new f.a(this, paramContext, paramString1, paramString2, paramString3, paramCtSetting, paramResultListener) {
          public void run() {
            String str = a.a(this.g, this.a, this.b, this.c, this.d, this.e, null);
            if (!a())
              CtAuth.postResultOnMainThread(str, this.f); 
          }
        }i, paramResultListener);
  }
  
  public void b(Context paramContext, String paramString1, String paramString2, String paramString3, CtSetting paramCtSetting, ResultListener paramResultListener) {
    int i = CtSetting.getTotalTimeout(paramCtSetting);
    if (Build.VERSION.SDK_INT >= 21) {
      d d = new d();
      d.a(paramContext, new d.a(this, paramContext, paramString1, paramString2, paramString3, paramCtSetting, paramResultListener) {
            private boolean h = false;
            
            private boolean i = false;
            
            public void a() {
              // Byte code:
              //   0: aload_0
              //   1: monitorenter
              //   2: aload_0
              //   3: iconst_1
              //   4: putfield h : Z
              //   7: aload_0
              //   8: getfield i : Z
              //   11: ifne -> 23
              //   14: ldc '{"result":-8003,"msg":"请求超时"}'
              //   16: aload_0
              //   17: getfield f : Lcn/com/chinatelecom/account/api/ResultListener;
              //   20: invokestatic postResultOnMainThread : (Ljava/lang/String;Lcn/com/chinatelecom/account/api/ResultListener;)V
              //   23: aload_0
              //   24: monitorexit
              //   25: return
              //   26: astore_1
              //   27: aload_0
              //   28: monitorexit
              //   29: aload_1
              //   30: athrow
              // Exception table:
              //   from	to	target	type
              //   2	23	26	finally
            }
            
            public void a(int param1Int, String param1String, long param1Long) {
              // Byte code:
              //   0: aload_0
              //   1: monitorenter
              //   2: aload_0
              //   3: getfield h : Z
              //   6: ifne -> 20
              //   9: aload_0
              //   10: getfield i : Z
              //   13: istore #5
              //   15: iload #5
              //   17: ifeq -> 23
              //   20: aload_0
              //   21: monitorexit
              //   22: return
              //   23: aload_0
              //   24: iconst_1
              //   25: putfield i : Z
              //   28: iload_1
              //   29: aload_2
              //   30: invokestatic a : (ILjava/lang/String;)Ljava/lang/String;
              //   33: aload_0
              //   34: getfield f : Lcn/com/chinatelecom/account/api/ResultListener;
              //   37: invokestatic postResultOnMainThread : (Ljava/lang/String;Lcn/com/chinatelecom/account/api/ResultListener;)V
              //   40: invokestatic a : ()Ljava/lang/String;
              //   43: astore #6
              //   45: new java/lang/StringBuilder
              //   48: astore #7
              //   50: aload #7
              //   52: invokespecial <init> : ()V
              //   55: aload #6
              //   57: aload #7
              //   59: ldc 'Switching network failed (L), errorMsg :'
              //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   64: aload_2
              //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   68: ldc ' , expendTime ：'
              //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   73: lload_3
              //   74: invokevirtual append : (J)Ljava/lang/StringBuilder;
              //   77: invokevirtual toString : ()Ljava/lang/String;
              //   80: invokestatic info : (Ljava/lang/String;Ljava/lang/String;)V
              //   83: goto -> 20
              //   86: astore_2
              //   87: aload_0
              //   88: monitorexit
              //   89: aload_2
              //   90: athrow
              // Exception table:
              //   from	to	target	type
              //   2	15	86	finally
              //   23	83	86	finally
            }
            
            public void a(Network param1Network, long param1Long) {
              // Byte code:
              //   0: invokestatic a : ()Ljava/lang/String;
              //   3: new java/lang/StringBuilder
              //   6: dup
              //   7: invokespecial <init> : ()V
              //   10: ldc 'Switching network successfully (L) , expendTime ：'
              //   12: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   15: lload_2
              //   16: invokevirtual append : (J)Ljava/lang/StringBuilder;
              //   19: invokevirtual toString : ()Ljava/lang/String;
              //   22: invokestatic info : (Ljava/lang/String;Ljava/lang/String;)V
              //   25: aload_0
              //   26: getfield h : Z
              //   29: ifne -> 39
              //   32: aload_0
              //   33: getfield i : Z
              //   36: ifeq -> 40
              //   39: return
              //   40: aload_0
              //   41: getfield g : Lcn/com/chinatelecom/account/api/a;
              //   44: aload_0
              //   45: getfield a : Landroid/content/Context;
              //   48: aload_0
              //   49: getfield b : Ljava/lang/String;
              //   52: aload_0
              //   53: getfield c : Ljava/lang/String;
              //   56: aload_0
              //   57: getfield d : Ljava/lang/String;
              //   60: aload_0
              //   61: getfield e : Lcn/com/chinatelecom/account/api/CtSetting;
              //   64: aload_1
              //   65: invokestatic a : (Lcn/com/chinatelecom/account/api/a;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcn/com/chinatelecom/account/api/CtSetting;Landroid/net/Network;)Ljava/lang/String;
              //   68: astore_1
              //   69: aload_0
              //   70: monitorenter
              //   71: aload_0
              //   72: getfield h : Z
              //   75: ifne -> 85
              //   78: aload_0
              //   79: getfield i : Z
              //   82: ifeq -> 95
              //   85: aload_0
              //   86: monitorexit
              //   87: goto -> 39
              //   90: astore_1
              //   91: aload_0
              //   92: monitorexit
              //   93: aload_1
              //   94: athrow
              //   95: aload_0
              //   96: iconst_1
              //   97: putfield i : Z
              //   100: aload_1
              //   101: aload_0
              //   102: getfield f : Lcn/com/chinatelecom/account/api/ResultListener;
              //   105: invokestatic postResultOnMainThread : (Ljava/lang/String;Lcn/com/chinatelecom/account/api/ResultListener;)V
              //   108: aload_0
              //   109: monitorexit
              //   110: goto -> 39
              // Exception table:
              //   from	to	target	type
              //   71	85	90	finally
              //   85	87	90	finally
              //   91	93	90	finally
              //   95	110	90	finally
            }
          });
      d.a(i);
      return;
    } 
    a(new f.a(this, paramContext, paramString1, paramString2, paramString3, paramCtSetting, paramResultListener) {
          public void run() {
            if ((new d()).a(this.a, f.a(this.a))) {
              if (!a()) {
                String str = a.a(this.g, this.a, this.b, this.c, this.d, this.e, null);
                if (!a())
                  CtAuth.postResultOnMainThread(str, this.f); 
              } 
              return;
            } 
            if (!a())
              CtAuth.postResultOnMainThread(i.a(-720002, "切换移动网络超时(4.x)"), this.f); 
          }
        }i, paramResultListener);
  }
  
  public void c(Context paramContext, String paramString1, String paramString2, String paramString3, CtSetting paramCtSetting, ResultListener paramResultListener) {
    int i = CtSetting.getTotalTimeout(paramCtSetting);
    a(new f.a(this, paramContext, paramString1, paramString2, paramString3, paramCtSetting, paramResultListener) {
          public void run() {
            String str = a.a(this.g, this.a, this.b, this.c, this.d, this.e);
            if (!a())
              CtAuth.postResultOnMainThread(str, this.f); 
          }
        }i, paramResultListener);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */