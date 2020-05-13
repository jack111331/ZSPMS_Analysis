package com.unionpay.sdk;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.UUID;

class u {
  private static volatile u a = null;
  
  private HashMap b = new HashMap<Object, Object>();
  
  private String c = null;
  
  private as d = bc.d();
  
  private boolean e = false;
  
  static {
    try {
      ah.a().register(a());
    } catch (Throwable throwable) {}
  }
  
  public static u a() {
    // Byte code:
    //   0: getstatic com/unionpay/sdk/u.a : Lcom/unionpay/sdk/u;
    //   3: ifnonnull -> 30
    //   6: ldc com/unionpay/sdk/u
    //   8: monitorenter
    //   9: getstatic com/unionpay/sdk/u.a : Lcom/unionpay/sdk/u;
    //   12: ifnonnull -> 27
    //   15: new com/unionpay/sdk/u
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/unionpay/sdk/u.a : Lcom/unionpay/sdk/u;
    //   27: ldc com/unionpay/sdk/u
    //   29: monitorexit
    //   30: getstatic com/unionpay/sdk/u.a : Lcom/unionpay/sdk/u;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/unionpay/sdk/u
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
  }
  
  private final void a(long paramLong, String paramString1, String paramString2) {
    w.b = true;
    if (!this.b.containsKey(paramString1)) {
      if (paramString2 != null && !paramString2.isEmpty()) {
        ay.a("onPageStart being called!, pagename: " + paramString1 + ", refer: " + paramString2);
      } else {
        ay.a("onPageStart being called!, pagename: " + paramString1);
      } 
      if (paramString1 != null) {
        if (ab.mContext != null)
          h.a(ab.mContext, "UPpref_shorttime", "UPpref.actstart.key", paramLong); 
        ab.k = this.d.a(az.b(), paramString1, paramLong, paramString2, SystemClock.elapsedRealtime());
        if (!this.b.containsKey(paramString1))
          this.b.put(paramString1, Long.valueOf(ab.k)); 
      } 
    } 
  }
  
  private final void a(String paramString) {
    if (paramString != null && !paramString.trim().isEmpty()) {
      long l1 = az.d();
      long l2 = az.f() - l1;
      l1 = l2;
      if (l2 < 500L)
        l1 = -1000L; 
      this.d.a(paramString, (int)l1 / 1000);
    } 
  }
  
  private final void b(String paramString) {
    if (this.b.containsKey(paramString)) {
      Long long_;
      if (!this.b.containsKey(paramString)) {
        long_ = Long.valueOf(ab.k);
      } else {
        long_ = (Long)this.b.get(paramString);
        this.b.remove(paramString);
      } 
      long l = long_.longValue();
      if (l != -1L)
        this.d.a(l, SystemClock.elapsedRealtime()); 
      if (this.e)
        az.a(paramString); 
      this.c = paramString;
    } 
  }
  
  public final void onTDEBEventSession(w.a parama) {
    long l = 0L;
    byte b = 1;
    if (parama == null || parama.a == null);
    int i = Integer.parseInt(String.valueOf(parama.a.get("apiType")));
    if (i == 1 || i == 2 || i == 3 || i == 6 || i == 7) {
      parama.a.put("controller", a());
      if (!String.valueOf(parama.a.get("occurTime")).trim().isEmpty()) {
        String str;
        HashMap hashMap = parama.a;
        try {
          String str1;
          long l1;
          long l2;
          switch (Integer.parseInt(String.valueOf(hashMap.get("apiType")))) {
            default:
              return;
            case 1:
              c.a().a(true);
            case 2:
              if (Boolean.parseBoolean(hashMap.get("isPageOrSession").toString())) {
                String str2;
                long l3 = Long.valueOf(String.valueOf(hashMap.get("occurTime"))).longValue();
                str = String.valueOf(hashMap.get("pageName"));
                if (this.c == null) {
                  str2 = az.c();
                } else {
                  str2 = this.c;
                } 
                a(l3, str, str2);
              } 
              l2 = az.d();
              l1 = az.f();
              if (l1 <= l2)
                l1 = l2; 
              l2 = Long.valueOf(String.valueOf(str.get("occurTime"))).longValue();
              if (l2 - l1 > ab.l) {
                ay.a("[Session] - New session!");
                a(az.b());
                String str2 = UUID.randomUUID().toString();
                l1 = az.f();
                if (0L == l1) {
                  l1 = l;
                } else {
                  l1 = l2 - l1;
                } 
                if (ab.mContext == null || !f.c(ab.mContext))
                  b = -1; 
                if (ab.mContext != null)
                  h.a(ab.mContext, "UPpref_longtime", "UPpref.session.key", str2); 
                if (ab.mContext != null)
                  h.a(ab.mContext, "UPpref_longtime", "UPpref.start.key", l2); 
                ay.a(String.format("sessionId: %s, status: %s", new Object[] { str2, String.valueOf(this.d.a(str2, l2, l1, b)) }));
                az.a("");
                this.e = true;
              } else {
                ay.a("[Session] - Same session as before!");
              } 
              c.a().a(true);
            case 3:
              if (Boolean.parseBoolean(str.get("isPageOrSession").toString()))
                b(String.valueOf(str.get("pageName"))); 
              str1 = String.valueOf(str.get("pageName"));
              if (str.containsKey("sessionEnd")) {
                a(az.b());
                c.a().a(true);
              } 
              az.a(Long.valueOf(String.valueOf(str.get("occurTime"))).longValue());
              az.a(str1);
              this.e = false;
              this.c = null;
            case 6:
              l1 = Long.valueOf(String.valueOf(str.get("occurTime"))).longValue();
              str = String.valueOf(str.get("pageName"));
              if (this.c == null) {
                str1 = az.c();
              } else {
                str1 = this.c;
              } 
              a(l1, str, str1);
            case 7:
              break;
          } 
        } catch (Throwable throwable) {}
        b(String.valueOf(str.get("pageName")));
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sd\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */