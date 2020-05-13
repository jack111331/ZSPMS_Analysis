package com.google.zxing;

public final class ChecksumException extends ReaderException {
  private static final ChecksumException INSTANCE;
  
  static {
    ChecksumException checksumException = new ChecksumException();
    INSTANCE = checksumException;
    checksumException.setStackTrace(NO_TRACE);
  }
  
  private ChecksumException() {}
  
  private ChecksumException(Throwable paramThrowable) {
    super(paramThrowable);
  }
  
  public static ChecksumException getChecksumInstance() {
    return isStackTrace ? new ChecksumException() : INSTANCE;
  }
  
  public static ChecksumException getChecksumInstance(Throwable paramThrowable) {
    return isStackTrace ? new ChecksumException(paramThrowable) : INSTANCE;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\ChecksumException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */