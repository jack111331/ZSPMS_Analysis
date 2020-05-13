package com.herosdk.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.herosdk.error.ErrorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class k {
  private static final String d = "frameLib.cfgus";
  
  private static volatile k e;
  
  public List<String> a = new ArrayList<String>();
  
  public HashMap<String, List<String>> b = new HashMap<String, List<String>>();
  
  public HashMap<String, String> c = new HashMap<String, String>();
  
  private String f = "";
  
  private String g = "";
  
  private String h = "";
  
  private String i = "";
  
  private int j = 0;
  
  private int k = 0;
  
  private Boolean l = Boolean.valueOf(false);
  
  public static k a() {
    // Byte code:
    //   0: getstatic com/herosdk/d/k.e : Lcom/herosdk/d/k;
    //   3: ifnonnull -> 30
    //   6: ldc com/herosdk/d/k
    //   8: monitorenter
    //   9: getstatic com/herosdk/d/k.e : Lcom/herosdk/d/k;
    //   12: ifnonnull -> 27
    //   15: new com/herosdk/d/k
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/d/k.e : Lcom/herosdk/d/k;
    //   27: ldc com/herosdk/d/k
    //   29: monitorexit
    //   30: getstatic com/herosdk/d/k.e : Lcom/herosdk/d/k;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/herosdk/d/k
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  private String d(String paramString) {
    String str;
    try {
      if ((String)this.c.get(paramString) == null)
        return ""; 
      paramString = this.c.get(paramString);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      str = "";
    } 
    return str;
  }
  
  private void k() {
    try {
      this.f = g();
      h();
      String str = d(o.b("LEelhf079uS784tsmBCW1A==", o.b())).trim();
      if (!TextUtils.isEmpty(str))
        this.h = str; 
      str = d(o.b("K3ErCUWst7bvZHO0DhmhJQ==", o.b())).trim();
      if (!TextUtils.isEmpty(str))
        this.i = str; 
      str = d(o.b("YOXb1P0Y3SiyZc/UMc1S0Q==", o.b()));
      boolean bool = TextUtils.isEmpty(str);
      if (!bool) {
        try {
          this.j = Integer.parseInt(str.trim());
        } catch (NumberFormatException numberFormatException) {}
      } else {
        this.j = 0;
      } 
      str = d(o.b("x2IIsrhRE8vyvVvhl7yqEA==", o.b()));
      bool = TextUtils.isEmpty(str);
      if (!bool)
        try {
          this.k = Integer.parseInt(str.trim());
        } catch (NumberFormatException numberFormatException) {} 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public String a(String paramString) {
    String str;
    try {
      if (this.a.contains(paramString))
        return ""; 
      if ((String)this.c.get(paramString) == null)
        return ""; 
      paramString = this.c.get(paramString);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      str = "";
    } 
    return str;
  }
  
  public void a(Context paramContext) {
    try {
      bh.a(paramContext);
      k();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void a(Boolean paramBoolean) {
    this.l = paramBoolean;
  }
  
  public void a(String paramString1, String paramString2) {
    if (this.c.containsKey(paramString1))
      this.c.remove(paramString1); 
    this.c.put(paramString1, paramString2);
  }
  
  public void a(String paramString, List<String> paramList) {
    if (this.b.containsKey(paramString))
      this.b.remove(paramString); 
    this.b.put(paramString, paramList);
  }
  
  public String b() {
    return this.f;
  }
  
  public void b(String paramString) {
    this.h = paramString;
  }
  
  public String c() {
    return this.g;
  }
  
  public void c(String paramString) {
    this.i = paramString;
  }
  
  public int d() {
    return this.j;
  }
  
  public int e() {
    return this.k;
  }
  
  public boolean f() {
    return this.l.booleanValue();
  }
  
  public String g() {
    String str1 = d(o.d());
    String str2 = str1;
    if (TextUtils.isEmpty(str1))
      str2 = o.b("RIKhWTow1uj+B/kDPQSLrw==", o.b()); 
    return str2;
  }
  
  public void h() {
    this.g = d(o.b("0Sf0qXEOlzA21uZBhxbf2w==", o.b()));
    if (TextUtils.isEmpty(this.g))
      this.g = o.b("RIKhWTow1uj+B/kDPQSLrw==", o.b()); 
  }
  
  public String i() {
    if (TextUtils.isEmpty(this.h))
      Log.d("frameLib.cfgus", "gpk is empty"); 
    return this.h;
  }
  
  public String j() {
    if (TextUtils.isEmpty(this.i))
      Log.d("frameLib.cfgus", "gpi is empty"); 
    return this.i;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */