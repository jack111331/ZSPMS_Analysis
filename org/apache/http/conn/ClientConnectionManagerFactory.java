package org.apache.http.conn;

import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpParams;

@Deprecated
public interface ClientConnectionManagerFactory {
  ClientConnectionManager newInstance(HttpParams paramHttpParams, SchemeRegistry paramSchemeRegistry);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\conn\ClientConnectionManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */