package org.apache.http.impl.client;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;

@Deprecated
public class BasicCredentialsProvider implements CredentialsProvider {
  public BasicCredentialsProvider() {
    throw new RuntimeException("Stub!");
  }
  
  public void clear() {
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
  
  public Credentials getCredentials(AuthScope paramAuthScope) {
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
  
  public void setCredentials(AuthScope paramAuthScope, Credentials paramCredentials) {
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
  
  public String toString() {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\client\BasicCredentialsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */