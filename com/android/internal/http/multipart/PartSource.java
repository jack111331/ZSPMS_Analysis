package com.android.internal.http.multipart;

import java.io.IOException;
import java.io.InputStream;

public interface PartSource {
  InputStream createInputStream() throws IOException;
  
  String getFileName();
  
  long getLength();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\android\internal\http\multipart\PartSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */