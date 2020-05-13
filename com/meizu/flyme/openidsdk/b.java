package com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.Keep;

@Keep
public class b {
  @Keep
  public static volatile b g;
  
  @Keep
  public static boolean h;
  
  @Keep
  public OpenId a = new OpenId("udid");
  
  @Keep
  public OpenId b = new OpenId("oaid");
  
  @Keep
  public OpenId c = new OpenId("aaid");
  
  @Keep
  public OpenId d = new OpenId("vaid");
  
  @Keep
  public Boolean e;
  
  @Keep
  public BroadcastReceiver f;
  
  @Keep
  public static native ValueData a(Cursor paramCursor);
  
  @Keep
  public static final native b a();
  
  @Keep
  public static native void b(String paramString);
  
  @Keep
  public native OpenId a(String paramString);
  
  @Keep
  public final native String a(Context paramContext, OpenId paramOpenId);
  
  @Keep
  public final synchronized native void a(Context paramContext);
  
  @Keep
  public final native boolean a(Context paramContext, boolean paramBoolean);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\meizu\flyme\openidsdk\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */