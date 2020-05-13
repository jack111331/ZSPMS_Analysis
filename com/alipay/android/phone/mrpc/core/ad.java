package com.alipay.android.phone.mrpc.core;

import java.io.IOException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

public class ad implements HttpRequestRetryHandler {
  static final String a = ad.class.getSimpleName();
  
  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #4
    //   3: iload_2
    //   4: iconst_3
    //   5: if_icmplt -> 15
    //   8: iload #4
    //   10: istore #5
    //   12: iload #5
    //   14: ireturn
    //   15: aload_1
    //   16: instanceof org/apache/http/NoHttpResponseException
    //   19: ifeq -> 28
    //   22: iconst_1
    //   23: istore #5
    //   25: goto -> 12
    //   28: aload_1
    //   29: instanceof java/net/SocketException
    //   32: ifne -> 46
    //   35: iload #4
    //   37: istore #5
    //   39: aload_1
    //   40: instanceof javax/net/ssl/SSLException
    //   43: ifeq -> 12
    //   46: iload #4
    //   48: istore #5
    //   50: aload_1
    //   51: invokevirtual getMessage : ()Ljava/lang/String;
    //   54: ifnull -> 12
    //   57: iload #4
    //   59: istore #5
    //   61: aload_1
    //   62: invokevirtual getMessage : ()Ljava/lang/String;
    //   65: ldc 'Broken pipe'
    //   67: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   70: ifeq -> 12
    //   73: iconst_1
    //   74: istore #5
    //   76: goto -> 12
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */