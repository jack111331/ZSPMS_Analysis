package com.tencent.mm.opensdk.diffdev.a;

import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

public final class e {
  public static byte[] a(String paramString, int paramInt) {
    if (paramString == null || paramString.length() == 0) {
      Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
      return null;
    } 
    DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
    HttpGet httpGet = new HttpGet(paramString);
    if (paramInt >= 0)
      try {
        HttpConnectionParams.setSoTimeout(defaultHttpClient.getParams(), paramInt);
      } catch (Exception exception) {
      
      } catch (IncompatibleClassChangeError null) {
      
      } catch (Throwable throwable) {} 
    HttpResponse httpResponse = throwable.execute((HttpUriRequest)exception);
    if (httpResponse.getStatusLine().getStatusCode() != 200) {
      StringBuilder stringBuilder = new StringBuilder();
      this("httpGet fail, status code = ");
      stringBuilder.append(httpResponse.getStatusLine().getStatusCode());
      Log.e("MicroMsg.SDK.NetUtil", stringBuilder.toString());
      return null;
    } 
    return EntityUtils.toByteArray(httpResponse.getEntity());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\diffdev\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */