package com.tencent.tp;

public class v {
  private static ITssNativeMethod2 a;
  
  static {
    a();
  }
  
  public static String a(String paramString) {
    return (a != null) ? a.ioctl(paramString) : "-1";
  }
  
  private static void a() {
    if (a == null) {
      try {
        Class<ITssNativeMethod2> clazz = c.a("com.tencent.tp.TssNativeMethodImp2");
        if (clazz != null)
          a = clazz.newInstance(); 
      } catch (Exception exception) {}
      ITssNativeMethod2 iTssNativeMethod2 = a;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */