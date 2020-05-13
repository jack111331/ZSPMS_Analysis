package com.sdk.base.framework.a.b;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class a {
  public byte[] a(HttpURLConnection paramHttpURLConnection) {
    if (paramHttpURLConnection == null)
      return null; 
    InputStream inputStream = paramHttpURLConnection.getInputStream();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[4096];
    while (true) {
      int i = inputStream.read(arrayOfByte);
      if (i != -1) {
        byteArrayOutputStream.write(arrayOfByte, 0, i);
        continue;
      } 
      byteArrayOutputStream.flush();
      return byteArrayOutputStream.toByteArray();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */