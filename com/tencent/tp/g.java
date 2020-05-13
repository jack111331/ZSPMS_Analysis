package com.tencent.tp;

import android.app.Activity;
import android.content.Context;

public class g {
  private static volatile g d;
  
  public m.a a = new h(this);
  
  private m b;
  
  private String c;
  
  public static g a() {
    // Byte code:
    //   0: getstatic com/tencent/tp/g.d : Lcom/tencent/tp/g;
    //   3: ifnonnull -> 39
    //   6: ldc com/tencent/tp/g
    //   8: monitorenter
    //   9: getstatic com/tencent/tp/g.d : Lcom/tencent/tp/g;
    //   12: ifnonnull -> 27
    //   15: new com/tencent/tp/g
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/tencent/tp/g.d : Lcom/tencent/tp/g;
    //   27: ldc com/tencent/tp/g
    //   29: monitorexit
    //   30: goto -> 39
    //   33: astore_0
    //   34: ldc com/tencent/tp/g
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    //   39: getstatic com/tencent/tp/g.d : Lcom/tencent/tp/g;
    //   42: areturn
    // Exception table:
    //   from	to	target	type
    //   9	27	33	finally
    //   27	30	33	finally
    //   34	37	33	finally
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, m.a parama) {
    this.b = new m(paramContext, paramString1, paramString2, paramString3, parama);
    this.b.a();
  }
  
  private void a(m paramm) {
    if (paramm == null)
      return; 
    if (this.b == paramm) {
      this.b.c();
      this.b = null;
    } 
  }
  
  private void b(String paramString) {
    a(this.b);
  }
  
  private void c(String paramString) {
    try {
      d(paramString);
    } catch (Throwable throwable) {}
  }
  
  private void d(String paramString) {
    if (!paramString.startsWith("msgbox:"))
      return; 
    String[] arrayOfString = paramString.substring(7).split("\\|");
    if (arrayOfString == null || arrayOfString.length < 8) {
      u.a("*#07#:TssSdkMessageBox.parseAndShow cmd err");
      return;
    } 
    paramString = arrayOfString[0];
    String str2 = arrayOfString[1];
    String str3 = arrayOfString[2];
    String str1 = arrayOfString[4];
    Activity activity = TssSdkRuntime.getCurrentActivity();
    if (activity == null) {
      u.a("*#07#:getCurrentActivity failed");
      return;
    } 
    this.c = paramString;
    a((Context)activity, str2, str3, str1, this.a);
  }
  
  public void a(String paramString) {
    if (paramString.startsWith("msgbox:")) {
      c(paramString);
    } else if (paramString.startsWith("hide_msgbox:")) {
      b(paramString);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */