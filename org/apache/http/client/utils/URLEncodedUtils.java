package org.apache.http.client.utils;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Scanner;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;

@Deprecated
public class URLEncodedUtils {
  public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
  
  public URLEncodedUtils() {
    throw new RuntimeException("Stub!");
  }
  
  public static String format(List<? extends NameValuePair> paramList, String paramString) {
    throw new RuntimeException("Stub!");
  }
  
  public static boolean isEncoded(HttpEntity paramHttpEntity) {
    throw new RuntimeException("Stub!");
  }
  
  public static List<NameValuePair> parse(URI paramURI, String paramString) {
    throw new RuntimeException("Stub!");
  }
  
  public static List<NameValuePair> parse(HttpEntity paramHttpEntity) throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public static void parse(List<NameValuePair> paramList, Scanner paramScanner, String paramString) {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\clien\\utils\URLEncodedUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */