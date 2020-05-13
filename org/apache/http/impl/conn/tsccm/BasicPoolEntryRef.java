package org.apache.http.impl.conn.tsccm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import org.apache.http.conn.routing.HttpRoute;

@Deprecated
public class BasicPoolEntryRef extends WeakReference<BasicPoolEntry> {
  public BasicPoolEntryRef(BasicPoolEntry paramBasicPoolEntry, ReferenceQueue<Object> paramReferenceQueue) {
    super(null, (ReferenceQueue<? super BasicPoolEntry>)null);
    throw new RuntimeException("Stub!");
  }
  
  public final HttpRoute getRoute() {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\conn\tsccm\BasicPoolEntryRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */