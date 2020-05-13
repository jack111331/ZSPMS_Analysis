package com.chuanglan.shanyan_sdk.b;

import java.io.UnsupportedEncodingException;

public abstract class e extends b {
  private String a = null;
  
  public e() {
    this("utf-8");
  }
  
  private e(String paramString) {
    this.a = paramString;
  }
  
  protected abstract void a(String paramString);
  
  public void a(byte[] paramArrayOfbyte) {
    try {
      String str = new String();
      this(paramArrayOfbyte, this.a);
      a(str);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      a(unsupportedEncodingException.toString(), unsupportedEncodingException.getClass().getName());
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */