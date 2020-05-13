package com.tencent.tp;

import java.io.UnsupportedEncodingException;

public class u {
  private static ITssNativeMethod a;
  
  static {
    e();
  }
  
  public static void a() {
    if (a != null)
      a.setcancelupdaterootkit(); 
  }
  
  public static void a(int paramInt) {
    if (a != null)
      a.setrootkittipstate(paramInt); 
  }
  
  public static void a(Object paramObject) {
    if (a != null)
      a.loadConfig(paramObject); 
  }
  
  public static void a(String paramString) {
    try {
      b(paramString);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {}
  }
  
  public static int b(int paramInt) {
    return (a != null) ? a.hasMatchRate(paramInt) : 0;
  }
  
  public static void b() {
    if (a != null)
      a.forceExit(); 
  }
  
  public static void b(Object paramObject) {
    if (a != null)
      a.loadRootkitTipStr(paramObject); 
  }
  
  public static void b(String paramString) throws UnsupportedEncodingException {
    if (a != null)
      a.onRuntimeInfo(paramString); 
  }
  
  public static int c() {
    return (a != null) ? a.isToastEnabled() : 0;
  }
  
  public static void c(Object paramObject) {
    if (a != null)
      a.loadMessageBoxInfo(paramObject); 
  }
  
  public static void c(String paramString) throws UnsupportedEncodingException {
    if (a != null)
      a.sendStringToSvr(paramString); 
  }
  
  public static int d() {
    return (a != null) ? a.isRookitRunning() : 0;
  }
  
  private static void e() {
    if (a == null) {
      try {
        Class<ITssNativeMethod> clazz = c.a("com.tencent.tp.TssNativeMethodImp");
        if (clazz != null)
          a = clazz.newInstance(); 
      } catch (Exception exception) {}
      ITssNativeMethod iTssNativeMethod = a;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\t\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */