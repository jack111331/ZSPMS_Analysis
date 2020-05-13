package okhttp3.internal.framed;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class Ping {
  private final CountDownLatch latch = new CountDownLatch(1);
  
  private long received = -1L;
  
  private long sent = -1L;
  
  void cancel() {
    if (this.received != -1L || this.sent == -1L)
      throw new IllegalStateException(); 
    this.received = this.sent - 1L;
    this.latch.countDown();
  }
  
  void receive() {
    if (this.received != -1L || this.sent == -1L)
      throw new IllegalStateException(); 
    this.received = System.nanoTime();
    this.latch.countDown();
  }
  
  public long roundTripTime() throws InterruptedException {
    this.latch.await();
    return this.received - this.sent;
  }
  
  public long roundTripTime(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return this.latch.await(paramLong, paramTimeUnit) ? (this.received - this.sent) : -2L;
  }
  
  void send() {
    if (this.sent != -1L)
      throw new IllegalStateException(); 
    this.sent = System.nanoTime();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\framed\Ping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */