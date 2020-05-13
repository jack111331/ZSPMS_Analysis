package com.jdpaysdk.author.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.jdpaysdk.author.a.a;

public class e {
  public static a a(Context paramContext, Exception paramException) {
    a a = new a();
    if (paramException instanceof java.net.SocketException) {
      a.a(paramContext.getString(f.b("net_error")));
      a.b("1002");
      return a;
    } 
    if (paramException instanceof java.net.ConnectException) {
      a.a(paramContext.getString(f.b("net_connect_timeout")));
      a.b("1001");
      return a;
    } 
    if (paramException instanceof java.io.IOException) {
      a.a(paramContext.getString(f.b("net_fatal_error")));
      a.b("1000");
    } 
    return a;
  }
  
  public static boolean a(Context paramContext) {
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (connectivityManager != null) {
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      if (networkInfo != null && networkInfo.isConnected() && networkInfo.getState() == NetworkInfo.State.CONNECTED)
        return true; 
    } 
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */