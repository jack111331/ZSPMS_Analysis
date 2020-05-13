package com.alipay.security.mobile.module.c;

import com.alipay.security.mobile.module.a.a;
import java.io.File;

public final class b {
  public static String a(String paramString) {
    String str1 = "";
    try {
      String str = f.a(paramString);
      str1 = str;
    } catch (Throwable throwable) {}
    String str2 = str1;
    if (a.a(str1))
      str2 = c.a(".SystemConfig" + File.separator + paramString); 
    return str2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */