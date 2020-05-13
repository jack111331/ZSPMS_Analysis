package com.sdk.base.framework.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.f.b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@SuppressLint({"NewApi"})
public class a {
  public static ConnectivityManager.NetworkCallback b;
  
  private static final String c = a.class.getName();
  
  private static Boolean d = Boolean.valueOf(c.h);
  
  public boolean a = false;
  
  private HttpURLConnection e;
  
  public a(Context paramContext, URL paramURL) {
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      NetworkRequest.Builder builder = new NetworkRequest.Builder();
      this();
      builder.addCapability(12);
      builder.addTransportType(0);
      NetworkRequest networkRequest = builder.build();
      ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
          public void onAvailable(Network param1Network) {
            super.onAvailable(param1Network);
            try {
              a.a(this.b, (HttpURLConnection)param1Network.openConnection(this.a));
            } catch (IOException iOException) {}
          }
        };
      super(this, paramURL);
      b = networkCallback;
      connectivityManager.requestNetwork(networkRequest, b);
    } catch (Exception exception) {
      b.c(c, exception.toString(), d);
    } 
  }
  
  public HttpURLConnection a() {
    // Byte code:
    //   0: new com/sdk/base/framework/a/a$a
    //   3: dup
    //   4: aload_0
    //   5: ldc2_w 2000
    //   8: invokespecial <init> : (Lcom/sdk/base/framework/a/a;J)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual a : ()Z
    //   16: ifne -> 33
    //   19: aload_0
    //   20: getfield e : Ljava/net/HttpURLConnection;
    //   23: ifnull -> 12
    //   26: aload_0
    //   27: getfield e : Ljava/net/HttpURLConnection;
    //   30: astore_1
    //   31: aload_1
    //   32: areturn
    //   33: aconst_null
    //   34: astore_1
    //   35: goto -> 31
  }
  
  class a {
    private long b = 1500L;
    
    private long c;
    
    public a(a this$0, long param1Long) {
      this.b = param1Long;
      this.c = System.currentTimeMillis();
    }
    
    public boolean a() {
      return (System.currentTimeMillis() - this.c > this.b);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */