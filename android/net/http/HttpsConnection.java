package android.net.http;

import android.content.Context;
import java.io.File;
import org.apache.http.HttpHost;

public class HttpsConnection extends Connection {
  protected SslCertificate mCertificate;
  
  protected AndroidHttpClientConnection mHttpClientConnection;
  
  HttpsConnection() {
    super((Context)null, (HttpHost)null, (RequestFeeder)null);
    throw new RuntimeException("Stub!");
  }
  
  public static void initializeEngine(File paramFile) {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\net\http\HttpsConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */