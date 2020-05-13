package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.os.Build;

@SuppressLint({"NewApi"})
public class a {
  static int a() {
    return a(b());
  }
  
  private static int a(a parama) {
    switch (null.a[parama.ordinal()]) {
      default:
        return -1;
      case 1:
        return 0;
      case 2:
        break;
    } 
    return 1;
  }
  
  private static a b() {
    String str = Build.BRAND;
    return str.equalsIgnoreCase("samsung") ? a.b : (str.equalsIgnoreCase("Huawei") ? a.c : a.a);
  }
  
  public enum a {
    a, b, c;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */