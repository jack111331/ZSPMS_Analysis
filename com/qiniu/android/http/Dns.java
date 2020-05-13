package com.qiniu.android.http;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public interface Dns {
  List<InetAddress> lookup(String paramString) throws UnknownHostException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\http\Dns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */