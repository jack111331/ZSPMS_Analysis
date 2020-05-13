package com.zz.sdk.i;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class bi {
  public static HttpClient a(Context paramContext) {
    if (b(paramContext) == null)
      return null; 
    if (d(paramContext)) {
      BasicHttpParams basicHttpParams = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout((HttpParams)basicHttpParams, 30000);
      HttpConnectionParams.setSoTimeout((HttpParams)basicHttpParams, 30000);
      HttpConnectionParams.setSocketBufferSize((HttpParams)basicHttpParams, 102400);
      HttpClientParams.setRedirecting((HttpParams)basicHttpParams, true);
      basicHttpParams.setParameter("http.route.default-proxy", new HttpHost("10.0.0.172", 80));
      return (HttpClient)new DefaultHttpClient((HttpParams)basicHttpParams);
    } 
    DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
    HttpParams httpParams = defaultHttpClient.getParams();
    httpParams.setParameter("http.connection.timeout", Integer.valueOf(30000));
    httpParams.setParameter("http.socket.timeout", Integer.valueOf(30000));
    return (HttpClient)defaultHttpClient;
  }
  
  public static String b(Context paramContext) {
    NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (networkInfo == null)
      return null; 
    bp.a("activeNetworkInfo.getType():" + networkInfo.getType());
    switch (networkInfo.getType()) {
      default:
        return "3";
      case 1:
        return "1";
      case 0:
        break;
    } 
    return "2";
  }
  
  public static boolean c(Context paramContext) {
    if (paramContext != null) {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo != null)
        return networkInfo.isAvailable(); 
    } 
    return false;
  }
  
  private static boolean d(Context paramContext) {
    boolean bool = false;
    String str = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().getExtraInfo();
    if (str != null) {
      if ("cmwap".equalsIgnoreCase(str) || "3gwap".equalsIgnoreCase(str) || "uniwap".equalsIgnoreCase(str))
        return true; 
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */