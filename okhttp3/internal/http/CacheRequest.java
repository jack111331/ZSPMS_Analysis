package okhttp3.internal.http;

import java.io.IOException;
import okio.Sink;

public interface CacheRequest {
  void abort();
  
  Sink body() throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\http\CacheRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */