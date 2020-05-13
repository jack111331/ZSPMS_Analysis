package org.apache.http.impl.conn.tsccm;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.conn.AbstractPoolEntry;
import org.apache.http.impl.conn.AbstractPooledConnAdapter;

@Deprecated
public class BasicPooledConnAdapter extends AbstractPooledConnAdapter {
  protected BasicPooledConnAdapter(ThreadSafeClientConnManager paramThreadSafeClientConnManager, AbstractPoolEntry paramAbstractPoolEntry) {
    super((ClientConnectionManager)null, (AbstractPoolEntry)null);
    throw new RuntimeException("Stub!");
  }
  
  protected void detach() {
    throw new RuntimeException("Stub!");
  }
  
  protected ClientConnectionManager getManager() {
    throw new RuntimeException("Stub!");
  }
  
  protected AbstractPoolEntry getPoolEntry() {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\conn\tsccm\BasicPooledConnAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */