package okhttp3.internal;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

class FaultHidingSink extends ForwardingSink {
  private boolean hasErrors;
  
  public FaultHidingSink(Sink paramSink) {
    super(paramSink);
  }
  
  public void close() throws IOException {
    if (!this.hasErrors)
      try {
        super.close();
      } catch (IOException iOException) {
        this.hasErrors = true;
        onException(iOException);
      }  
  }
  
  public void flush() throws IOException {
    if (!this.hasErrors)
      try {
        super.flush();
      } catch (IOException iOException) {
        this.hasErrors = true;
        onException(iOException);
      }  
  }
  
  protected void onException(IOException paramIOException) {}
  
  public void write(Buffer paramBuffer, long paramLong) throws IOException {
    if (this.hasErrors) {
      paramBuffer.skip(paramLong);
      return;
    } 
    try {
      super.write(paramBuffer, paramLong);
    } catch (IOException iOException) {
      this.hasErrors = true;
      onException(iOException);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\FaultHidingSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */