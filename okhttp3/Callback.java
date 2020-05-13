package okhttp3;

import java.io.IOException;

public interface Callback {
  void onFailure(Call paramCall, IOException paramIOException);
  
  void onResponse(Call paramCall, Response paramResponse) throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\Callback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */