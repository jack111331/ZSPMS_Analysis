package org.apache.http;

import java.util.Iterator;

@Deprecated
public interface HeaderElementIterator extends Iterator {
  boolean hasNext();
  
  HeaderElement nextElement();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\HeaderElementIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */