package com.chuanglan.shanyan_sdk.b;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;

public abstract class b {
  private void a() {}
  
  private void a(d paramd) {}
  
  private byte[] a(InputStream paramInputStream) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[2048];
    while (true) {
      int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i != -1) {
        byteArrayOutputStream.write(arrayOfByte, 0, i);
        continue;
      } 
      byteArrayOutputStream.flush();
      byteArrayOutputStream.close();
      return byteArrayOutputStream.toByteArray();
    } 
  }
  
  public abstract void a(String paramString1, String paramString2);
  
  public void a(HttpURLConnection paramHttpURLConnection) {
    try {
      if (paramHttpURLConnection.getResponseCode() >= 200 && paramHttpURLConnection.getResponseCode() < 300) {
        String str = paramHttpURLConnection.getContentType();
        int i = paramHttpURLConnection.getContentLength();
        d d = new d();
        this(str, i);
        a(d);
        BufferedInputStream bufferedInputStream = new BufferedInputStream();
        this(paramHttpURLConnection.getInputStream());
        a(a(bufferedInputStream));
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        String str = stringBuilder.append("Bad Response Code").append(paramHttpURLConnection.getResponseCode()).toString();
        stringBuilder = new StringBuilder();
        this();
        a(str, stringBuilder.append(paramHttpURLConnection.getResponseCode()).append("").toString());
      } 
      return;
    } catch (IOException iOException) {
      a(iOException.toString(), iOException.getClass().getName());
      return;
    } finally {
      paramHttpURLConnection.disconnect();
      a();
    } 
  }
  
  public void a(HttpsURLConnection paramHttpsURLConnection) {
    try {
      if (paramHttpsURLConnection.getResponseCode() >= 200 && paramHttpsURLConnection.getResponseCode() < 300) {
        String str = paramHttpsURLConnection.getContentType();
        int i = paramHttpsURLConnection.getContentLength();
        d d = new d();
        this(str, i);
        a(d);
        BufferedInputStream bufferedInputStream = new BufferedInputStream();
        this(paramHttpsURLConnection.getInputStream());
        a(a(bufferedInputStream));
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        String str = stringBuilder.append("Bad Response Code").append(paramHttpsURLConnection.getResponseCode()).toString();
        stringBuilder = new StringBuilder();
        this();
        a(str, stringBuilder.append(paramHttpsURLConnection.getResponseCode()).append("").toString());
      } 
      return;
    } catch (IOException iOException) {
      a(iOException.toString(), iOException.getClass().getName());
      return;
    } finally {
      if (paramHttpsURLConnection != null)
        paramHttpsURLConnection.disconnect(); 
      a();
    } 
  }
  
  public abstract void a(byte[] paramArrayOfbyte);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */