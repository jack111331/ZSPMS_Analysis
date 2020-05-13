package okhttp3.internal;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;

class AndroidPlatform extends Platform {
  private static final int MAX_LOG_LENGTH = 4000;
  
  private final OptionalMethod<Socket> getAlpnSelectedProtocol;
  
  private final OptionalMethod<Socket> setAlpnProtocols;
  
  private final OptionalMethod<Socket> setHostname;
  
  private final OptionalMethod<Socket> setUseSessionTickets;
  
  private final Class<?> sslParametersClass;
  
  public AndroidPlatform(Class<?> paramClass, OptionalMethod<Socket> paramOptionalMethod1, OptionalMethod<Socket> paramOptionalMethod2, OptionalMethod<Socket> paramOptionalMethod3, OptionalMethod<Socket> paramOptionalMethod4) {
    this.sslParametersClass = paramClass;
    this.setUseSessionTickets = paramOptionalMethod1;
    this.setHostname = paramOptionalMethod2;
    this.getAlpnSelectedProtocol = paramOptionalMethod3;
    this.setAlpnProtocols = paramOptionalMethod4;
  }
  
  public static Platform buildIfSupported() {
    Class<?> clazz;
    try {
      clazz = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
    } catch (ClassNotFoundException classNotFoundException) {}
    try {
      OptionalMethod<Socket> optionalMethod1 = new OptionalMethod();
      this(null, "setUseSessionTickets", new Class[] { boolean.class });
      OptionalMethod<Socket> optionalMethod2 = new OptionalMethod();
      this(null, "setHostname", new Class[] { String.class });
      OptionalMethod<Socket> optionalMethod3 = null;
      OptionalMethod<Socket> optionalMethod4 = null;
      try {
        Class.forName("android.net.Network");
        OptionalMethod optionalMethod = new OptionalMethod();
        this(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
        try {
          optionalMethod3 = new OptionalMethod();
          this(null, "setAlpnProtocols", new Class[] { byte[].class });
          optionalMethod4 = optionalMethod3;
        } catch (ClassNotFoundException classNotFoundException1) {}
      } catch (ClassNotFoundException classNotFoundException2) {
        classNotFoundException2 = classNotFoundException1;
      } 
      AndroidPlatform androidPlatform1 = new AndroidPlatform();
      this(clazz, optionalMethod1, optionalMethod2, (OptionalMethod<Socket>)classNotFoundException2, optionalMethod4);
      AndroidPlatform androidPlatform2 = androidPlatform1;
    } catch (ClassNotFoundException classNotFoundException) {
      classNotFoundException = null;
    } 
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList) {
    if (paramString != null) {
      this.setUseSessionTickets.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
      this.setHostname.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
    } 
    if (this.setAlpnProtocols != null && this.setAlpnProtocols.isSupported(paramSSLSocket)) {
      byte[] arrayOfByte = concatLengthPrefixed(paramList);
      this.setAlpnProtocols.invokeWithoutCheckedException(paramSSLSocket, new Object[] { arrayOfByte });
    } 
  }
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt) throws IOException {
    try {
      paramSocket.connect(paramInetSocketAddress, paramInt);
      return;
    } catch (AssertionError assertionError) {
      if (Util.isAndroidGetsocknameError(assertionError))
        throw new IOException(assertionError); 
      throw assertionError;
    } catch (SecurityException securityException) {
      IOException iOException = new IOException("Exception in connect");
      iOException.initCause(securityException);
      throw iOException;
    } 
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket) {
    byte[] arrayOfByte = null;
    if (this.getAlpnSelectedProtocol != null && this.getAlpnSelectedProtocol.isSupported(paramSSLSocket)) {
      byte[] arrayOfByte1 = (byte[])this.getAlpnSelectedProtocol.invokeWithoutCheckedException(paramSSLSocket, new Object[0]);
      if (arrayOfByte1 != null) {
        String str = new String(arrayOfByte1, Util.UTF_8);
      } else {
        arrayOfByte1 = null;
      } 
      arrayOfByte = arrayOfByte1;
    } 
    return (String)arrayOfByte;
  }
  
  public boolean isCleartextTrafficPermitted() {
    try {
      Class<?> clazz = Class.forName("android.security.NetworkSecurityPolicy");
      Object object = clazz.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      return ((Boolean)clazz.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(object, new Object[0])).booleanValue();
    } catch (ClassNotFoundException classNotFoundException) {
      return super.isCleartextTrafficPermitted();
    } catch (NoSuchMethodException noSuchMethodException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (IllegalArgumentException illegalArgumentException) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    throw new AssertionError();
  }
  
  public void log(int paramInt, String paramString, Throwable paramThrowable) {
    byte b = 5;
    if (paramInt != 5)
      b = 3; 
    String str = paramString;
    if (paramThrowable != null)
      str = paramString + '\n' + Log.getStackTraceString(paramThrowable); 
    paramInt = 0;
    int i = str.length();
    while (paramInt < i) {
      int j = str.indexOf('\n', paramInt);
      if (j == -1)
        j = i; 
      while (true) {
        int k = Math.min(j, paramInt + 4000);
        Log.println(b, "OkHttp", str.substring(paramInt, k));
        paramInt = k;
        if (k >= j)
          paramInt = k + 1; 
      } 
    } 
  }
  
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory) {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield sslParametersClass : Ljava/lang/Class;
    //   5: ldc 'sslParameters'
    //   7: invokestatic readFieldOrNull : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
    //   10: astore_2
    //   11: aload_2
    //   12: astore_3
    //   13: aload_2
    //   14: ifnonnull -> 37
    //   17: aload_1
    //   18: ldc 'com.google.android.gms.org.conscrypt.SSLParametersImpl'
    //   20: iconst_0
    //   21: aload_1
    //   22: invokevirtual getClass : ()Ljava/lang/Class;
    //   25: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   28: invokestatic forName : (Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   31: ldc 'sslParameters'
    //   33: invokestatic readFieldOrNull : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
    //   36: astore_3
    //   37: aload_3
    //   38: ldc javax/net/ssl/X509TrustManager
    //   40: ldc 'x509TrustManager'
    //   42: invokestatic readFieldOrNull : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
    //   45: checkcast javax/net/ssl/X509TrustManager
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull -> 65
    //   53: aload_1
    //   54: areturn
    //   55: astore_3
    //   56: aload_0
    //   57: aload_1
    //   58: invokespecial trustManager : (Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;
    //   61: astore_1
    //   62: goto -> 53
    //   65: aload_3
    //   66: ldc javax/net/ssl/X509TrustManager
    //   68: ldc 'trustManager'
    //   70: invokestatic readFieldOrNull : (Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
    //   73: checkcast javax/net/ssl/X509TrustManager
    //   76: astore_1
    //   77: goto -> 53
    // Exception table:
    //   from	to	target	type
    //   17	37	55	java/lang/ClassNotFoundException
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\AndroidPlatform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */