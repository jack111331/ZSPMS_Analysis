package okhttp3.internal.http;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RouteException extends Exception {
  private static final Method addSuppressedExceptionMethod;
  
  private IOException lastException;
  
  static {
    try {
      Method method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
    } catch (Exception exception) {
      exception = null;
    } 
    addSuppressedExceptionMethod = (Method)exception;
  }
  
  public RouteException(IOException paramIOException) {
    super(paramIOException);
    this.lastException = paramIOException;
  }
  
  private void addSuppressedIfPossible(IOException paramIOException1, IOException paramIOException2) {
    if (addSuppressedExceptionMethod != null)
      try {
        addSuppressedExceptionMethod.invoke(paramIOException1, new Object[] { paramIOException2 });
      } catch (InvocationTargetException invocationTargetException) {
      
      } catch (IllegalAccessException illegalAccessException) {} 
  }
  
  public void addConnectException(IOException paramIOException) {
    addSuppressedIfPossible(paramIOException, this.lastException);
    this.lastException = paramIOException;
  }
  
  public IOException getLastConnectException() {
    return this.lastException;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\http\RouteException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */