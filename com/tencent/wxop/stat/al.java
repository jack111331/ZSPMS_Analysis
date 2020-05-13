package com.tencent.wxop.stat;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

final class al extends DefaultConnectionKeepAliveStrategy {
  al(ak paramak) {}
  
  public final long getKeepAliveDuration(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
    long l1 = super.getKeepAliveDuration(paramHttpResponse, paramHttpContext);
    long l2 = l1;
    if (l1 == -1L)
      l2 = 30000L; 
    return l2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */