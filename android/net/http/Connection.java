package android.net.http;

import android.content.Context;
import org.apache.http.HttpHost;

abstract class Connection {
  protected SslCertificate mCertificate;
  
  protected AndroidHttpClientConnection mHttpClientConnection;
  
  protected Connection(Context paramContext, HttpHost paramHttpHost, RequestFeeder paramRequestFeeder) {
    throw new RuntimeException("Stub!");
  }
  
  public String toString() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/RuntimeException
    //   5: astore_1
    //   6: aload_1
    //   7: ldc 'Stub!'
    //   9: invokespecial <init> : (Ljava/lang/String;)V
    //   12: aload_1
    //   13: athrow
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	14	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\net\http\Connection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */