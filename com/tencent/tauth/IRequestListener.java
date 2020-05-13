package com.tencent.tauth;

import com.tencent.open.utils.HttpUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public interface IRequestListener {
  void onComplete(JSONObject paramJSONObject);
  
  void onConnectTimeoutException(ConnectTimeoutException paramConnectTimeoutException);
  
  void onHttpStatusException(HttpUtils.HttpStatusException paramHttpStatusException);
  
  void onIOException(IOException paramIOException);
  
  void onJSONException(JSONException paramJSONException);
  
  void onMalformedURLException(MalformedURLException paramMalformedURLException);
  
  void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException paramNetworkUnavailableException);
  
  void onSocketTimeoutException(SocketTimeoutException paramSocketTimeoutException);
  
  void onUnknowException(Exception paramException);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tauth\IRequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */