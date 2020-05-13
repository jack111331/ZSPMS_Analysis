package com.bun.miitmdid.c.j.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Keep;

@Keep
public class b {
  @Keep
  private static Context a;
  
  @Keep
  private static boolean b;
  
  @Keep
  private static b c;
  
  @Keep
  private static a d;
  
  @Keep
  private static c e;
  
  @Keep
  private static c f;
  
  @Keep
  private static c g;
  
  @Keep
  private static Object h = new Object();
  
  @Keep
  private static HandlerThread i;
  
  @Keep
  private static Handler j;
  
  @Keep
  private static String k;
  
  @Keep
  private static String l;
  
  @Keep
  private static String m;
  
  @Keep
  private static String n;
  
  @Keep
  public static native b a(Context paramContext);
  
  @Keep
  public static native String a(String paramString1, String paramString2);
  
  @Keep
  private static native void a(Context paramContext, int paramInt, String paramString);
  
  @Keep
  private native void b(int paramInt, String paramString);
  
  @Keep
  public static native void e();
  
  @Keep
  private static native void f();
  
  @Keep
  public native String a();
  
  @Keep
  public native String a(String paramString);
  
  @Keep
  public native void a(int paramInt, String paramString);
  
  @Keep
  public native String b(String paramString);
  
  @Keep
  public native boolean b();
  
  @Keep
  static final class a extends Handler {
    @Keep
    a(Looper param1Looper) {
      super(param1Looper);
    }
    
    @Keep
    public native void handleMessage(Message param1Message);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\miitmdid\c\j\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */