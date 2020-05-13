package okhttp3;

import java.io.IOException;

public interface Call {
  void cancel();
  
  void enqueue(Callback paramCallback);
  
  Response execute() throws IOException;
  
  boolean isCanceled();
  
  boolean isExecuted();
  
  Request request();
  
  public static interface Factory {
    Call newCall(Request param1Request);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\Call.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */