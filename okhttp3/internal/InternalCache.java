package okhttp3.internal;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.CacheRequest;
import okhttp3.internal.http.CacheStrategy;

public interface InternalCache {
  Response get(Request paramRequest) throws IOException;
  
  CacheRequest put(Response paramResponse) throws IOException;
  
  void remove(Request paramRequest) throws IOException;
  
  void trackConditionalCacheHit();
  
  void trackResponse(CacheStrategy paramCacheStrategy);
  
  void update(Response paramResponse1, Response paramResponse2) throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\InternalCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */