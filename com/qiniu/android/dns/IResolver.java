package com.qiniu.android.dns;

import java.io.IOException;

public interface IResolver {
  public static final int DNS_DEFAULT_TIMEOUT = 10;
  
  Record[] resolve(Domain paramDomain, NetworkInfo paramNetworkInfo) throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\dns\IResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */