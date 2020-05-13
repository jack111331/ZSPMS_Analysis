package okhttp3;

import java.io.IOException;

public interface Interceptor {
  Response intercept(Chain paramChain) throws IOException;
  
  public static interface Chain {
    Connection connection();
    
    Response proceed(Request param1Request) throws IOException;
    
    Request request();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\Interceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */