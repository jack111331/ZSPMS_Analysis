package com.tencent.tp;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class k implements e {
  private static volatile k d;
  
  private e a;
  
  private boolean b = true;
  
  private boolean c = false;
  
  private k() {
    try {
      Class<e> clazz = c.a("com.tencent.up_tp.SMI");
      if (clazz != null) {
        this.a = clazz.newInstance();
      } else {
        Exception exception = new Exception();
        this("com.tencent.up_tp.SMI NOT found");
        throw exception;
      } 
    } catch (Throwable throwable) {
      try {
        Class<e> clazz = c.a("com.tencent.tp.SMI");
        if (clazz != null) {
          this.a = clazz.newInstance();
        } else {
          Exception exception = new Exception();
          this("com.tencent.tp.SMI NOT found");
          throw exception;
        } 
      } catch (Throwable throwable1) {
        this.a = null;
      } 
    } 
    b();
    c();
  }
  
  public static k a() {
    // Byte code:
    //   0: getstatic com/tencent/tp/k.d : Lcom/tencent/tp/k;
    //   3: ifnonnull -> 39
    //   6: ldc com/tencent/tp/k
    //   8: monitorenter
    //   9: getstatic com/tencent/tp/k.d : Lcom/tencent/tp/k;
    //   12: ifnonnull -> 27
    //   15: new com/tencent/tp/k
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/tencent/tp/k.d : Lcom/tencent/tp/k;
    //   27: ldc com/tencent/tp/k
    //   29: monitorexit
    //   30: goto -> 39
    //   33: astore_0
    //   34: ldc com/tencent/tp/k
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    //   39: getstatic com/tencent/tp/k.d : Lcom/tencent/tp/k;
    //   42: areturn
    // Exception table:
    //   from	to	target	type
    //   9	27	33	finally
    //   27	30	33	finally
    //   34	37	33	finally
  }
  
  private String a(String paramString) {
    if (paramString == null || paramString.length() == 0)
      return null; 
    int i = paramString.length();
    char[] arrayOfChar = new char[i];
    for (byte b = 0; b < i; b++)
      arrayOfChar[b] = (char)(char)(paramString.charAt(b) ^ 0x2A); 
    return new String(arrayOfChar);
  }
  
  private void b() {
    String str = a(new String(new byte[] { 
            99, 89, 111, 68, 75, 72, 70, 79, 78, 117, 
            27, 16, 75, 70, 70, 69, 93, 117, 89, 79, 
            68, 89, 67, 94, 67, 92, 79 }));
    if (str != null) {
      str = v.a(str);
      if (str != null) {
        boolean bool;
        if (Integer.parseInt(str) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.b = bool;
      } 
    } 
  }
  
  private void c() {
    String str = v.a("IsEnabled_1:is_mtp");
    if (str != null) {
      int i = Integer.parseInt(str);
      boolean bool = true;
      if (i != 1)
        bool = false; 
      this.c = bool;
    } 
  }
  
  public String a(Context paramContext) {
    return (this.a != null && this.b) ? this.a.a(paramContext) : "NotImp";
  }
  
  public String b(Context paramContext) {
    return (this.a != null && this.b) ? this.a.b(paramContext) : "NotImp";
  }
  
  public String c(Context paramContext) {
    return (this.a != null && this.b) ? this.a.c(paramContext) : "NotImp";
  }
  
  public String d(Context paramContext) {
    return (this.a != null && this.b) ? this.a.d(paramContext) : "NotImp";
  }
  
  public String e(Context paramContext) {
    return (this.a != null && this.b) ? this.a.e(paramContext) : "NotImp";
  }
  
  public String f(Context paramContext) {
    return (this.a != null && this.b) ? this.a.f(paramContext) : "NotImp";
  }
  
  public String g(Context paramContext) {
    return (this.a != null && this.b) ? this.a.g(paramContext) : "NotImp";
  }
  
  public String h(Context paramContext) {
    return (this.a != null && this.b) ? this.a.h(paramContext) : "NotImp";
  }
  
  public String i(Context paramContext) {
    return (this.a != null && this.b) ? this.a.i(paramContext) : "NotImp";
  }
  
  public String j(Context paramContext) {
    return (this.a != null && this.b) ? this.a.j(paramContext) : "NotImp";
  }
  
  public String k(Context paramContext) {
    return (this.a != null && this.b) ? this.a.k(paramContext) : "NotImp";
  }
  
  public String l(Context paramContext) {
    return (this.a != null && this.b) ? this.a.l(paramContext) : "NotImp";
  }
  
  public List m(Context paramContext) {
    return (this.a != null && (this.b || this.c)) ? this.a.m(paramContext) : new ArrayList();
  }
  
  public List n(Context paramContext) {
    return (this.a != null && this.b) ? this.a.n(paramContext) : new ArrayList();
  }
  
  public List o(Context paramContext) {
    if (this.a != null)
      boolean bool = this.b; 
    return new ArrayList();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */