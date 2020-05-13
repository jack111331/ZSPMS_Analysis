package org.apache.http.impl.conn.tsccm;

import java.lang.ref.ReferenceQueue;

@Deprecated
public class RefQueueWorker implements Runnable {
  protected final RefQueueHandler refHandler;
  
  protected final ReferenceQueue<?> refQueue;
  
  protected volatile Thread workerThread;
  
  public RefQueueWorker(ReferenceQueue<?> paramReferenceQueue, RefQueueHandler paramRefQueueHandler) {
    throw new RuntimeException("Stub!");
  }
  
  public void run() {
    throw new RuntimeException("Stub!");
  }
  
  public void shutdown() {
    throw new RuntimeException("Stub!");
  }
  
  public String toString() {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\conn\tsccm\RefQueueWorker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */