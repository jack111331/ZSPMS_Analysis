package org.apache.http.protocol;

import java.util.TimeZone;

@Deprecated
public class HttpDateGenerator {
  public static final TimeZone GMT = null;
  
  public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
  
  public HttpDateGenerator() {
    throw new RuntimeException("Stub!");
  }
  
  public String getCurrentDate() {
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\protocol\HttpDateGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */