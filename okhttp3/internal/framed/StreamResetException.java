package okhttp3.internal.framed;

import java.io.IOException;

public final class StreamResetException extends IOException {
  public final ErrorCode errorCode;
  
  public StreamResetException(ErrorCode paramErrorCode) {
    super("stream was reset: " + paramErrorCode);
    this.errorCode = paramErrorCode;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\framed\StreamResetException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */