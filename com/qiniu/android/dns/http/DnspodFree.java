package com.qiniu.android.dns.http;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class DnspodFree implements IResolver {
  private final String ip;
  
  private final int timeout;
  
  public DnspodFree() {
    this("119.29.29.29");
  }
  
  public DnspodFree(String paramString) {
    this(paramString, 10);
  }
  
  public DnspodFree(String paramString, int paramInt) {
    this.ip = paramString;
    this.timeout = paramInt;
  }
  
  public Record[] resolve(Domain paramDomain, NetworkInfo paramNetworkInfo) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("http://");
    stringBuilder.append(this.ip);
    stringBuilder.append("/d?ttl=1&dn=");
    stringBuilder.append(paramDomain.domain);
    HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(stringBuilder.toString())).openConnection();
    httpURLConnection.setConnectTimeout(3000);
    httpURLConnection.setReadTimeout(this.timeout * 1000);
    if (httpURLConnection.getResponseCode() != 200)
      return null; 
    int i = httpURLConnection.getContentLength();
    if (i <= 0 || i > 1024)
      return null; 
    InputStream inputStream = httpURLConnection.getInputStream();
    byte[] arrayOfByte = new byte[i];
    int j = inputStream.read(arrayOfByte);
    inputStream.close();
    if (j <= 0)
      return null; 
    i = 0;
    String[] arrayOfString = (new String(arrayOfByte, 0, j)).split(",");
    if (arrayOfString.length != 2)
      return null; 
    try {
      j = Integer.parseInt(arrayOfString[1]);
      arrayOfString = arrayOfString[0].split(";");
      if (arrayOfString.length == 0)
        return null; 
      Record[] arrayOfRecord = new Record[arrayOfString.length];
      long l = System.currentTimeMillis() / 1000L;
      while (i < arrayOfString.length) {
        arrayOfRecord[i] = new Record(arrayOfString[i], 1, j, l);
        i++;
      } 
      return arrayOfRecord;
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\dns\http\DnspodFree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */