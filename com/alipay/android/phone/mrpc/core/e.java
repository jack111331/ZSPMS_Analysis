package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

final class e extends DefaultRedirectHandler {
  int a;
  
  e(d paramd) {}
  
  public final boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
    this.a++;
    boolean bool = super.isRedirectRequested(paramHttpResponse, paramHttpContext);
    null = bool;
    if (!bool) {
      null = bool;
      if (this.a < 5) {
        int i = paramHttpResponse.getStatusLine().getStatusCode();
        if (i != 301) {
          null = bool;
          return (i == 302) ? true : null;
        } 
      } else {
        return null;
      } 
    } else {
      return null;
    } 
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */