package android.net.http;

public interface EventHandler {
  public static final int ERROR = -1;
  
  public static final int ERROR_AUTH = -4;
  
  public static final int ERROR_BAD_URL = -12;
  
  public static final int ERROR_CONNECT = -6;
  
  public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
  
  public static final int ERROR_IO = -7;
  
  public static final int ERROR_LOOKUP = -2;
  
  public static final int ERROR_PROXYAUTH = -5;
  
  public static final int ERROR_REDIRECT_LOOP = -9;
  
  public static final int ERROR_TIMEOUT = -8;
  
  public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
  
  public static final int ERROR_UNSUPPORTED_SCHEME = -10;
  
  public static final int FILE_ERROR = -13;
  
  public static final int FILE_NOT_FOUND_ERROR = -14;
  
  public static final int OK = 0;
  
  public static final int TOO_MANY_REQUESTS_ERROR = -15;
  
  void certificate(SslCertificate paramSslCertificate);
  
  void data(byte[] paramArrayOfbyte, int paramInt);
  
  void endData();
  
  void error(int paramInt, String paramString);
  
  boolean handleSslErrorRequest(SslError paramSslError);
  
  void headers(Headers paramHeaders);
  
  void status(int paramInt1, int paramInt2, int paramInt3, String paramString);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\net\http\EventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */