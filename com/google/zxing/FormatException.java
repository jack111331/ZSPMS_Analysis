package com.google.zxing;

public final class FormatException extends ReaderException {
  private static final FormatException INSTANCE;
  
  static {
    FormatException formatException = new FormatException();
    INSTANCE = formatException;
    formatException.setStackTrace(NO_TRACE);
  }
  
  private FormatException() {}
  
  private FormatException(Throwable paramThrowable) {
    super(paramThrowable);
  }
  
  public static FormatException getFormatInstance() {
    return isStackTrace ? new FormatException() : INSTANCE;
  }
  
  public static FormatException getFormatInstance(Throwable paramThrowable) {
    return isStackTrace ? new FormatException(paramThrowable) : INSTANCE;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\FormatException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */