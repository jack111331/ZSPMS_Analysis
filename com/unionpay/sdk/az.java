package com.unionpay.sdk;

final class az {
  static String a() {
    String str = null;
    if (ab.mContext != null)
      str = h.b(ab.mContext, "UPpref_longtime", "UPaes_key", (String)null); 
    return str;
  }
  
  static void a(long paramLong) {
    if (ab.mContext != null)
      h.a(ab.mContext, "UPpref_shorttime", "UPpref.end.key", paramLong); 
  }
  
  static void a(String paramString) {
    if (ab.mContext != null)
      h.a(ab.mContext, "UPpref_shorttime", "UPpref.lastactivity.key", paramString); 
  }
  
  static String b() {
    String str = null;
    if (ab.mContext != null)
      str = h.b(ab.mContext, "UPpref_longtime", "UPpref.session.key", (String)null); 
    return str;
  }
  
  static void b(String paramString) {
    if (ab.mContext != null)
      h.a(ab.mContext, "UPpref_longtime", "UPisAppQuiting", paramString); 
  }
  
  static String c() {
    return (ab.mContext == null) ? "" : h.b(ab.mContext, "UPpref_shorttime", "UPpref.lastactivity.key", "");
  }
  
  static long d() {
    long l = 0L;
    if (ab.mContext != null)
      l = h.b(ab.mContext, "UPpref_longtime", "UPpref.start.key", 0L); 
    return l;
  }
  
  static long e() {
    long l = 0L;
    if (ab.mContext != null)
      l = h.b(ab.mContext, "UPpref_longtime", "UPpref.init.key", 0L); 
    return l;
  }
  
  static long f() {
    long l = 0L;
    if (ab.mContext != null)
      l = h.b(ab.mContext, "UPpref_shorttime", "UPpref.end.key", 0L); 
    return l;
  }
  
  static String g() {
    return (ab.mContext == null) ? "-1" : h.b(ab.mContext, "UPpref_longtime", "UPisAppQuiting", "-1");
  }
  
  static int h() {
    byte b;
    try {
      if (k() != -1L)
        return Integer.parseInt(String.valueOf(k())); 
      b = a.a().b(ab.mContext);
    } catch (Throwable throwable) {
      b = -1;
    } 
    return b;
  }
  
  static String i() {
    String str;
    try {
      if (j() != null)
        return j(); 
      str = a.a().c(ab.mContext);
    } catch (Throwable throwable) {
      str = "unknown";
    } 
    return str;
  }
  
  private static String j() {
    String str = null;
    if (ab.mContext != null)
      str = h.b(ab.mContext, "UPpref_longtime", "UPadditionalVersionName", (String)null); 
    return str;
  }
  
  private static long k() {
    long l = -1L;
    if (ab.mContext != null)
      l = h.b(ab.mContext, "UPpref_longtime", "UPadditionalVersionCode", -1L); 
    return l;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */