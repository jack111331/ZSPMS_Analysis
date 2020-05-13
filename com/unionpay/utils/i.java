package com.unionpay.utils;

import java.util.Locale;

public class i {
  private static i g = null;
  
  public String a = "";
  
  public String b = "";
  
  public String c = "";
  
  public String d = "";
  
  public String e = "";
  
  public String f = "";
  
  public static i a() {
    if (g == null) {
      if (Locale.getDefault().toString().startsWith("zh")) {
        g = new j();
        return g;
      } 
    } else {
      return g;
    } 
    g = new k();
    return g;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpa\\utils\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */