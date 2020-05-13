package okio;

import java.io.IOException;

public abstract class ForwardingSink implements Sink {
  private final Sink delegate;
  
  public ForwardingSink(Sink paramSink) {
    if (paramSink == null)
      throw new IllegalArgumentException("delegate == null"); 
    this.delegate = paramSink;
  }
  
  public void close() throws IOException {
    this.delegate.close();
  }
  
  public final Sink delegate() {
    return this.delegate;
  }
  
  public void flush() throws IOException {
    this.delegate.flush();
  }
  
  public Timeout timeout() {
    return this.delegate.timeout();
  }
  
  public String toString() {
    return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
  }
  
  public void write(Buffer paramBuffer, long paramLong) throws IOException {
    this.delegate.write(paramBuffer, paramLong);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okio\ForwardingSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */