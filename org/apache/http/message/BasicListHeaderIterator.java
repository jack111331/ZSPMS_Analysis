package org.apache.http.message;

import java.util.List;
import java.util.NoSuchElementException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;

@Deprecated
public class BasicListHeaderIterator implements HeaderIterator {
  protected final List allHeaders;
  
  protected int currentIndex;
  
  protected String headerName;
  
  protected int lastIndex;
  
  public BasicListHeaderIterator(List paramList, String paramString) {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean filterHeader(int paramInt) {
    throw new RuntimeException("Stub!");
  }
  
  protected int findNext(int paramInt) {
    throw new RuntimeException("Stub!");
  }
  
  public boolean hasNext() {
    throw new RuntimeException("Stub!");
  }
  
  public final Object next() throws NoSuchElementException {
    throw new RuntimeException("Stub!");
  }
  
  public Header nextHeader() throws NoSuchElementException {
    throw new RuntimeException("Stub!");
  }
  
  public void remove() throws UnsupportedOperationException {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\message\BasicListHeaderIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */