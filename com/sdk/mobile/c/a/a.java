package com.sdk.mobile.c.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.a.c;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.f.b;
import com.sdk.base.framework.utils.i.b;

public class a<T> {
  private static final String a = a.class.getName();
  
  private static Boolean b = Boolean.valueOf(c.h);
  
  private a c;
  
  private Context d;
  
  private c e;
  
  private int f;
  
  private CallBack<T> g;
  
  public a(Context paramContext, int paramInt, CallBack<T> paramCallBack) {
    this.d = paramContext;
    this.f = paramInt;
    this.g = paramCallBack;
    this.c = new a(this, (paramInt * 1000));
    this.c.a();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString) {
    if (this.c != null)
      this.c.b(); 
    if (this.g != null) {
      this.g.onFailed(paramInt1, paramInt2, paramString);
      this.g = null;
    } 
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, T paramT, String paramString2) {
    if (this.c != null)
      this.c.b(); 
    if (this.g != null) {
      this.g.onSuccess(paramInt1, paramString1, paramInt2, paramT, paramString2);
      this.g = null;
    } 
  }
  
  public void a(int paramInt) {
    if (!b.a(this.d)) {
      a(1, 100020, "操作频繁,请稍后再试！");
      return;
    } 
    this.e = (new com.sdk.mobile.a.a()).b(this.d, paramInt, new com.sdk.base.framework.b.a<T>(this, paramInt) {
          public void a(int param1Int1, int param1Int2, String param1String) {
            a.a(this.b, param1Int1, param1Int2, param1String);
          }
          
          public void a(int param1Int1, String param1String1, int param1Int2, T param1T, String param1String2) {
            // Byte code:
            //   0: aload_0
            //   1: getfield b : Lcom/sdk/mobile/c/a/a;
            //   4: invokestatic a : (Lcom/sdk/mobile/c/a/a;)Landroid/content/Context;
            //   7: invokestatic b : (Landroid/content/Context;)V
            //   10: iload_1
            //   11: ifne -> 152
            //   14: aload_0
            //   15: getfield b : Lcom/sdk/mobile/c/a/a;
            //   18: invokestatic a : (Lcom/sdk/mobile/c/a/a;)Landroid/content/Context;
            //   21: aload #4
            //   23: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
            //   26: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
            //   29: astore #6
            //   31: aload #6
            //   33: astore #4
            //   35: aload #4
            //   37: astore #6
            //   39: aload_0
            //   40: getfield a : I
            //   43: iconst_1
            //   44: if_icmpne -> 77
            //   47: new org/json/JSONObject
            //   50: astore #6
            //   52: aload #6
            //   54: aload #4
            //   56: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
            //   59: invokespecial <init> : (Ljava/lang/String;)V
            //   62: aload #6
            //   64: ldc 'fakeMobile'
            //   66: invokevirtual remove : (Ljava/lang/String;)Ljava/lang/Object;
            //   69: pop
            //   70: aload #6
            //   72: invokevirtual toString : ()Ljava/lang/String;
            //   75: astore #6
            //   77: aload #6
            //   79: astore #4
            //   81: aload_0
            //   82: getfield b : Lcom/sdk/mobile/c/a/a;
            //   85: iload_1
            //   86: aload_2
            //   87: iload_3
            //   88: aload #4
            //   90: aload #5
            //   92: invokestatic a : (Lcom/sdk/mobile/c/a/a;ILjava/lang/String;ILjava/lang/Object;Ljava/lang/String;)V
            //   95: return
            //   96: astore_2
            //   97: aload_0
            //   98: getfield b : Lcom/sdk/mobile/c/a/a;
            //   101: iconst_1
            //   102: ldc 'sdk解密异常！'
            //   104: ldc 100019
            //   106: aload #4
            //   108: aload #5
            //   110: invokestatic a : (Lcom/sdk/mobile/c/a/a;ILjava/lang/String;ILjava/lang/Object;Ljava/lang/String;)V
            //   113: invokestatic a : ()Ljava/lang/String;
            //   116: new java/lang/StringBuilder
            //   119: dup
            //   120: invokespecial <init> : ()V
            //   123: ldc 'sdk解密异常！\\n'
            //   125: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   128: aload_2
            //   129: invokevirtual toString : ()Ljava/lang/String;
            //   132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   135: invokevirtual toString : ()Ljava/lang/String;
            //   138: invokestatic b : ()Ljava/lang/Boolean;
            //   141: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)I
            //   144: pop
            //   145: goto -> 95
            //   148: astore_2
            //   149: goto -> 97
            //   152: goto -> 81
            // Exception table:
            //   from	to	target	type
            //   14	31	96	java/lang/Exception
            //   39	77	148	java/lang/Exception
          }
        });
  }
  
  public void a(String paramString1, String paramString2) {
    this.e = (new com.sdk.mobile.a.a()).b(this.d, paramString1, paramString2, new com.sdk.base.framework.b.a<T>(this, paramString2) {
          public void a(int param1Int1, int param1Int2, String param1String) {
            a.a(this.b, param1Int1, param1Int2, param1String);
          }
          
          public void a(int param1Int1, String param1String1, int param1Int2, T param1T, String param1String2) {
            String str;
            if (param1Int1 == 0 && com.sdk.base.framework.utils.k.a.a(this.a).booleanValue()) {
              try {
                String str1 = com.sdk.base.framework.utils.l.a.a(a.a(this.b), String.valueOf(param1T));
                str = str1;
                a.a(this.b, param1Int1, param1String1, param1Int2, str, param1String2);
              } catch (Exception exception) {
                a.a(this.b, 1, "sdk解密异常！", 100019, str, param1String2);
                b.c(a.a(), "sdk解密异常！\n" + exception.toString(), a.b());
              } 
              return;
            } 
            a.a(this.b, param1Int1, (String)exception, param1Int2, str, param1String2);
          }
        });
  }
  
  public class a implements Runnable {
    private Handler b = new Handler(Looper.getMainLooper());
    
    private long c;
    
    a(a this$0, long param1Long) {
      this.c = param1Long;
    }
    
    private void c() {
      if (a.b(this.a) != null) {
        b.d(a.a(), "超时，已取消请求", a.b());
        a.b(this.a).a();
      } 
      a.a(this.a, 1, 100008, "超时！");
    }
    
    public void a() {
      this.b.postDelayed(this, this.c);
    }
    
    public void b() {
      this.b.removeCallbacks(this);
    }
    
    public void run() {
      c();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\mobile\c\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */