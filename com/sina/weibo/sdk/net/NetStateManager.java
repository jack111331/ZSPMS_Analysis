package com.sina.weibo.sdk.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import org.apache.http.HttpHost;

public class NetStateManager {
  public static NetState CUR_NETSTATE = NetState.Mobile;
  
  private static Context mContext;
  
  public static HttpHost getAPN() {
    HttpHost httpHost;
    Uri uri = Uri.parse("content://telephony/carriers/preferapn");
    Context context1 = mContext;
    Context context2 = null;
    Context context3 = null;
    if (context1 != null) {
      Cursor cursor = mContext.getContentResolver().query(uri, null, null, null, null);
    } else {
      uri = null;
    } 
    context1 = context2;
    if (uri != null) {
      context1 = context2;
      if (uri.moveToFirst()) {
        String str = uri.getString(uri.getColumnIndex("proxy"));
        context1 = context3;
        if (str != null) {
          context1 = context3;
          if (str.trim().length() > 0)
            httpHost = new HttpHost(str, 80); 
        } 
        uri.close();
      } 
    } 
    return httpHost;
  }
  
  public enum NetState {
    Mobile, NOWAY, WIFI;
    
    static {
      ENUM$VALUES = new NetState[] { Mobile, WIFI, NOWAY };
    }
  }
  
  public class NetStateReceive extends BroadcastReceiver {
    public void onReceive(Context param1Context, Intent param1Intent) {
      NetStateManager.mContext = param1Context;
      if ("android.net.conn.CONNECTIVITY_CHANGE".equals(param1Intent.getAction())) {
        WifiManager wifiManager = (WifiManager)param1Context.getSystemService("wifi");
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (!wifiManager.isWifiEnabled() || -1 == wifiInfo.getNetworkId())
          NetStateManager.CUR_NETSTATE = NetStateManager.NetState.Mobile; 
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\net\NetStateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */