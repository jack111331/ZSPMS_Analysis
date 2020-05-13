package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;

public interface HostNameResolver {
  InetAddress resolve(String paramString) throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\conn\scheme\HostNameResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */