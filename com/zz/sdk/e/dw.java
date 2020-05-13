package com.zz.sdk.e;

import com.zz.sdk.i.t;
import java.io.UnsupportedEncodingException;

class dw extends Thread {
  private final t b = this.a.getConnectionUtil();
  
  private final String c = du.a(this.a);
  
  private final String d = du.b(this.a);
  
  private final String e = null;
  
  dw(du paramdu, String paramString) {
    super(paramString);
  }
  
  public void run() {
    String str;
    try {
      str = new String();
      this(this.c.getBytes(), "utf-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
      str = "";
    } 
    this.b.b(this.d, str, this.e);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */