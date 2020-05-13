package org.apache.http;

import java.util.Iterator;

@Deprecated
public interface TokenIterator extends Iterator {
  boolean hasNext();
  
  String nextToken();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\TokenIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */