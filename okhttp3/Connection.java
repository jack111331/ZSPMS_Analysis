package okhttp3;

import java.net.Socket;

public interface Connection {
  Handshake handshake();
  
  Protocol protocol();
  
  Route route();
  
  Socket socket();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\Connection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */