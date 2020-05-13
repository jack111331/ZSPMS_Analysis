package com.bun.miitmdid.c;

import android.support.annotation.Keep;

@Keep
public enum a {
  b(-1, "unsupport"),
  c(0, "HUAWEI"),
  d(1, "Xiaomi"),
  e(2, "vivo"),
  f(3, "oppo"),
  g(4, "motorola"),
  h(5, "lenovo"),
  i(6, "asus"),
  j(7, "samsung"),
  k(8, "meizu"),
  l(10, "nubia"),
  m(11, "ZTE"),
  n(12, "OnePlus"),
  o(13, "blackshark"),
  p(30, "freemeos"),
  q(31, "ssui");
  
  @Keep
  private String a;
  
  @Keep
  a(int paramInt1, String paramString1) {
    this.a = paramString1;
  }
  
  @Keep
  public static native a a(String paramString);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\miitmdid\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */