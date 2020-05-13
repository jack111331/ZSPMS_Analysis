package com.qiniu.android.dns.http;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import com.qiniu.android.dns.util.Hex;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class DnspodEnterprise implements IResolver {
  private final String id;
  
  private final String ip;
  
  private final SecretKeySpec key;
  
  private final int timeout;
  
  public DnspodEnterprise(String paramString1, String paramString2) {
    this(paramString1, paramString2, "119.29.29.29");
  }
  
  public DnspodEnterprise(String paramString1, String paramString2, String paramString3) {
    this(paramString1, paramString2, paramString3, 10);
  }
  
  public DnspodEnterprise(String paramString1, String paramString2, String paramString3, int paramInt) {
    this.id = paramString1;
    this.ip = paramString3;
    this.timeout = paramInt;
    try {
      byte[] arrayOfByte = paramString2.getBytes("utf-8");
      this.key = new SecretKeySpec(arrayOfByte, "DES");
      return;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new AssertionError(unsupportedEncodingException);
    } 
  }
  
  private String decrypt(String paramString) {
    try {
      Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
      cipher.init(2, this.key);
      return new String(cipher.doFinal(Hex.decodeHex(paramString.toCharArray())));
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  private String encrypt(String paramString) {
    try {
      Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
      cipher.init(1, this.key);
      byte[] arrayOfByte = cipher.doFinal(paramString.getBytes("utf-8"));
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(Hex.encodeHexString(arrayOfByte));
      stringBuilder.append("&id=");
      stringBuilder.append(this.id);
      return stringBuilder.toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public Record[] resolve(Domain paramDomain, NetworkInfo paramNetworkInfo) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("http://");
    stringBuilder.append(this.ip);
    stringBuilder.append("/d?ttl=1&dn=");
    stringBuilder.append(encrypt(paramDomain.domain));
    stringBuilder.append("&id=");
    stringBuilder.append(this.id);
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
    String[] arrayOfString = decrypt(new String(arrayOfByte, 0, j)).split(",");
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\dns\http\DnspodEnterprise.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */