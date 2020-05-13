package com.jdpaysdk.author.c;

import android.content.Context;

public class f {
  private static Context a;
  
  public static int a(String paramString) {
    return (a == null) ? 0 : a.getResources().getIdentifier(paramString, "layout", a.getPackageName());
  }
  
  public static void a(Context paramContext) {
    if (paramContext != null)
      a = paramContext; 
  }
  
  public static int b(String paramString) {
    return (a == null) ? 0 : a.getResources().getIdentifier(paramString, "string", a.getPackageName());
  }
  
  public static int c(String paramString) {
    return (a == null) ? 0 : a.getResources().getIdentifier(paramString, "drawable", a.getPackageName());
  }
  
  public static int d(String paramString) {
    return (a == null) ? 0 : a.getResources().getIdentifier(paramString, "style", a.getPackageName());
  }
  
  public static int e(String paramString) {
    return (a == null) ? 0 : a.getResources().getIdentifier(paramString, "id", a.getPackageName());
  }
  
  public static int f(String paramString) {
    return (a == null) ? 0 : a.getResources().getIdentifier(paramString, "anim", a.getPackageName());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */