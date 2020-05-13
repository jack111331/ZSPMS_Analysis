package org.apache.commons.logging;

import java.lang.reflect.Constructor;
import java.util.Hashtable;

@Deprecated
public class LogSource {
  protected static boolean jdk14IsAvailable;
  
  protected static boolean log4jIsAvailable;
  
  protected static Constructor logImplctor;
  
  protected static Hashtable logs;
  
  LogSource() {
    throw new RuntimeException("Stub!");
  }
  
  public static Log getInstance(Class paramClass) {
    throw new RuntimeException("Stub!");
  }
  
  public static Log getInstance(String paramString) {
    throw new RuntimeException("Stub!");
  }
  
  public static String[] getLogNames() {
    throw new RuntimeException("Stub!");
  }
  
  public static Log makeNewLogInstance(String paramString) {
    throw new RuntimeException("Stub!");
  }
  
  public static void setLogImplementation(Class paramClass) throws LinkageError, ExceptionInInitializerError, NoSuchMethodException, SecurityException {
    throw new RuntimeException("Stub!");
  }
  
  public static void setLogImplementation(String paramString) throws LinkageError, ExceptionInInitializerError, NoSuchMethodException, SecurityException, ClassNotFoundException {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\commons\logging\LogSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */