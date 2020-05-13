package org.apache.http.impl.conn.tsccm;

import java.util.Date;
import java.util.concurrent.locks.Condition;

@Deprecated
public class WaitingThread {
  public WaitingThread(Condition paramCondition, RouteSpecificPool paramRouteSpecificPool) {
    throw new RuntimeException("Stub!");
  }
  
  public boolean await(Date paramDate) throws InterruptedException {
    throw new RuntimeException("Stub!");
  }
  
  public final Condition getCondition() {
    throw new RuntimeException("Stub!");
  }
  
  public final RouteSpecificPool getPool() {
    throw new RuntimeException("Stub!");
  }
  
  public final Thread getThread() {
    throw new RuntimeException("Stub!");
  }
  
  public void interrupt() {
    throw new RuntimeException("Stub!");
  }
  
  public void wakeup() {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\conn\tsccm\WaitingThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */