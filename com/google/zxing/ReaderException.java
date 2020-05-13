package com.google.zxing;

public abstract class ReaderException extends Exception {
  protected static final StackTraceElement[] NO_TRACE;
  
  protected static final boolean isStackTrace;
  
  static {
    boolean bool;
    if (System.getProperty("surefire.test.class.path") != null) {
      bool = true;
    } else {
      bool = false;
    } 
    isStackTrace = bool;
    NO_TRACE = new StackTraceElement[0];
  }
  
  ReaderException() {}
  
  ReaderException(Throwable paramThrowable) {
    super(paramThrowable);
  }
  
  public final Throwable fillInStackTrace() {
    /* monitor enter ThisExpression{ObjectType{com/google/zxing/ReaderException}} */
    /* monitor exit ThisExpression{ObjectType{com/google/zxing/ReaderException}} */
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\ReaderException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */