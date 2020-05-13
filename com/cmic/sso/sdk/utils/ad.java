package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ad {
  static ConnectivityManager a;
  
  private static ad b = null;
  
  private Network c;
  
  private ConnectivityManager.NetworkCallback d;
  
  private boolean e;
  
  private ad(Context paramContext) {
    a = (ConnectivityManager)paramContext.getSystemService("connectivity");
  }
  
  static int a(String paramString) {
    byte b;
    try {
      InetAddress inetAddress = InetAddress.getByName(paramString);
      byte[] arrayOfByte = inetAddress.getAddress();
      byte b1 = arrayOfByte[3];
      byte b2 = arrayOfByte[2];
      byte b3 = arrayOfByte[1];
      b = arrayOfByte[0] & 0xFF | (b1 & 0xFF) << 24 | (b2 & 0xFF) << 16 | (b3 & 0xFF) << 8;
    } catch (UnknownHostException unknownHostException) {
      b = -1;
    } 
    return b;
  }
  
  public static ad a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/cmic/sso/sdk/utils/ad.b : Lcom/cmic/sso/sdk/utils/ad;
    //   3: ifnonnull -> 31
    //   6: ldc com/cmic/sso/sdk/utils/ad
    //   8: monitorenter
    //   9: getstatic com/cmic/sso/sdk/utils/ad.b : Lcom/cmic/sso/sdk/utils/ad;
    //   12: ifnonnull -> 28
    //   15: new com/cmic/sso/sdk/utils/ad
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: aload_1
    //   25: putstatic com/cmic/sso/sdk/utils/ad.b : Lcom/cmic/sso/sdk/utils/ad;
    //   28: ldc com/cmic/sso/sdk/utils/ad
    //   30: monitorexit
    //   31: getstatic com/cmic/sso/sdk/utils/ad.b : Lcom/cmic/sso/sdk/utils/ad;
    //   34: areturn
    //   35: astore_0
    //   36: ldc com/cmic/sso/sdk/utils/ad
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   9	28	35	finally
    //   28	31	35	finally
    //   36	39	35	finally
  }
  
  static String b(String paramString) {
    int i = paramString.indexOf("://");
    String str1 = paramString;
    if (i > 0)
      str1 = paramString.substring(i + 3); 
    i = str1.indexOf(':');
    String str2 = str1;
    if (i >= 0)
      str2 = str1.substring(0, i); 
    i = str2.indexOf('/');
    paramString = str2;
    if (i >= 0)
      paramString = str2.substring(0, i); 
    i = paramString.indexOf('?');
    str1 = paramString;
    if (i >= 0)
      str1 = paramString.substring(0, i); 
    return str1;
  }
  
  public void a() {
    try {
      if (Build.VERSION.SDK_INT >= 21 && a != null && this.d != null) {
        a.unregisterNetworkCallback(this.d);
        this.d = null;
        this.c = null;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  void a(a parama) {
    if (Build.VERSION.SDK_INT >= 21) {
      if (this.c != null && !this.e) {
        NetworkInfo networkInfo = a.getNetworkInfo(this.c);
        if (networkInfo != null && networkInfo.isAvailable()) {
          parama.a(this.c);
          h.a("HttpUtils", "reuse network: " + this.c.toString());
          return;
        } 
      } 
      if (this.d != null) {
        try {
          a.unregisterNetworkCallback(this.d);
        } catch (Exception exception) {
          exception.printStackTrace();
          this.d = null;
        } 
        h.a("HttpUtils", "clear: ");
      } 
      NetworkRequest networkRequest = (new NetworkRequest.Builder()).addCapability(12).addTransportType(0).build();
      this.d = new ConnectivityManager.NetworkCallback(this, parama) {
          public void onAvailable(Network param1Network) {
            ad.a(this.b, param1Network);
            this.a.a(param1Network);
            ad.a(this.b, false);
          }
          
          public void onLost(Network param1Network) {
            ad.a(this.b, true);
          }
        };
      a.requestNetwork(networkRequest, this.d);
    } 
  }
  
  public static interface a {
    void a(Network param1Network);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */