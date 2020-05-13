package com.bun.miitmdid.c.k;

import android.content.Context;
import android.support.annotation.Keep;
import java.lang.reflect.Method;

@Keep
public class a {
  @Keep
  private static Object a;
  
  @Keep
  private static Class<?> b;
  
  @Keep
  private static Method c;
  
  @Keep
  private static Method d;
  
  @Keep
  private static Method e;
  
  static {
    try {
      b = Class.forName("com.android.id.impl.IdProviderImpl");
      a = b.newInstance();
    } catch (Exception exception) {
      com.bun.lib.a.a("IdentifierManager", "reflect exception!", exception);
    } 
    try {
      if (b != null)
        c = b.getMethod("getOAID", new Class[] { Context.class }); 
    } catch (Exception exception) {
      com.bun.lib.a.a("IdentifierManager", "reflect exception!", exception);
    } 
    try {
      if (b != null)
        d = b.getMethod("getVAID", new Class[] { Context.class }); 
    } catch (Exception exception) {
      com.bun.lib.a.a("IdentifierManager", "reflect exception!", exception);
    } 
    try {
      if (b != null)
        e = b.getMethod("getAAID", new Class[] { Context.class }); 
    } catch (Exception exception) {
      com.bun.lib.a.a("IdentifierManager", "reflect exception!", exception);
    } 
  }
  
  @Keep
  public static native String a(Context paramContext);
  
  @Keep
  private static native String a(Context paramContext, Method paramMethod);
  
  @Keep
  public static native boolean a();
  
  @Keep
  public static native String b(Context paramContext);
  
  @Keep
  public static native String c(Context paramContext);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\miitmdid\c\k\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */