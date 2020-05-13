package com.google.zxing;

public final class NotFoundException extends ReaderException {
  private static final NotFoundException INSTANCE;
  
  static {
    NotFoundException notFoundException = new NotFoundException();
    INSTANCE = notFoundException;
    notFoundException.setStackTrace(NO_TRACE);
  }
  
  public static NotFoundException getNotFoundInstance() {
    return INSTANCE;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\NotFoundException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */