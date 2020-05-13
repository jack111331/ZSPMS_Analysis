package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

public final class RetryableSink implements Sink {
  private boolean closed;
  
  private final Buffer content = new Buffer();
  
  private final int limit;
  
  public RetryableSink() {
    this(-1);
  }
  
  public RetryableSink(int paramInt) {
    this.limit = paramInt;
  }
  
  public void close() throws IOException {
    if (!this.closed) {
      this.closed = true;
      if (this.content.size() < this.limit)
        throw new ProtocolException("content-length promised " + this.limit + " bytes, but received " + this.content.size()); 
    } 
  }
  
  public long contentLength() throws IOException {
    return this.content.size();
  }
  
  public void flush() throws IOException {}
  
  public Timeout timeout() {
    return Timeout.NONE;
  }
  
  public void write(Buffer paramBuffer, long paramLong) throws IOException {
    if (this.closed)
      throw new IllegalStateException("closed"); 
    Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
    if (this.limit != -1 && this.content.size() > this.limit - paramLong)
      throw new ProtocolException("exceeded content-length limit of " + this.limit + " bytes"); 
    this.content.write(paramBuffer, paramLong);
  }
  
  public void writeToSocket(Sink paramSink) throws IOException {
    Buffer buffer = new Buffer();
    this.content.copyTo(buffer, 0L, this.content.size());
    paramSink.write(buffer, buffer.size());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\http\RetryableSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */