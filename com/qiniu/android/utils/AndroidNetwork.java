package com.qiniu.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class AndroidNetwork {
  public static boolean isNetWorkReady() {
    Context context = ContextGetter.applicationContext();
    boolean bool = true;
    if (context == null)
      return true; 
    ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
    try {
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      if (networkInfo != null) {
        boolean bool1 = networkInfo.isConnected();
        if (bool1)
          return bool; 
      } 
      return false;
    } catch (Exception exception) {
      return true;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\androi\\utils\AndroidNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */