package android.net.http;

import android.content.Context;
import android.net.compatibility.WebAddress;
import java.io.InputStream;
import java.util.Map;
import org.apache.http.HttpHost;

public class RequestQueue implements RequestFeeder {
  public RequestQueue(Context paramContext) {
    throw new RuntimeException("Stub!");
  }
  
  public RequestQueue(Context paramContext, int paramInt) {
    throw new RuntimeException("Stub!");
  }
  
  public void disablePlatformNotifications() {
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
  
  public void enablePlatformNotifications() {
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
  
  public HttpHost getProxyHost() {
    throw new RuntimeException("Stub!");
  }
  
  public Request getRequest() {
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
  
  public Request getRequest(HttpHost paramHttpHost) {
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
  
  public boolean haveRequest(HttpHost paramHttpHost) {
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
  
  public RequestHandle queueRequest(String paramString1, WebAddress paramWebAddress, String paramString2, Map<String, String> paramMap, EventHandler paramEventHandler, InputStream paramInputStream, int paramInt) {
    throw new RuntimeException("Stub!");
  }
  
  public RequestHandle queueRequest(String paramString1, String paramString2, Map<String, String> paramMap, EventHandler paramEventHandler, InputStream paramInputStream, int paramInt) {
    throw new RuntimeException("Stub!");
  }
  
  protected void queueRequest(Request paramRequest, boolean paramBoolean) {
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
  
  public RequestHandle queueSynchronousRequest(String paramString1, WebAddress paramWebAddress, String paramString2, Map<String, String> paramMap, EventHandler paramEventHandler, InputStream paramInputStream, int paramInt) {
    throw new RuntimeException("Stub!");
  }
  
  public void requeueRequest(Request paramRequest) {
    throw new RuntimeException("Stub!");
  }
  
  public void shutdown() {
    throw new RuntimeException("Stub!");
  }
  
  public void startTiming() {
    throw new RuntimeException("Stub!");
  }
  
  public void stopTiming() {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\net\http\RequestQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */