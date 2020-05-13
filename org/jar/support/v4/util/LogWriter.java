package org.jar.support.v4.util;

import android.util.Log;
import java.io.Writer;

public class LogWriter extends Writer {
  private StringBuilder mBuilder = new StringBuilder(128);
  
  private final String mTag;
  
  public LogWriter(String paramString) {
    this.mTag = paramString;
  }
  
  private void flushBuilder() {
    if (this.mBuilder.length() > 0) {
      Log.d(this.mTag, this.mBuilder.toString());
      this.mBuilder.delete(0, this.mBuilder.length());
    } 
  }
  
  public void close() {
    flushBuilder();
  }
  
  public void flush() {
    flushBuilder();
  }
  
  public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    for (byte b = 0; b < paramInt2; b++) {
      char c = paramArrayOfchar[paramInt1 + b];
      if (c == '\n') {
        flushBuilder();
      } else {
        this.mBuilder.append(c);
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v\\util\LogWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */