package com.aliyun.sls.android.sdk.utils;

import com.aliyun.sls.android.sdk.LogException;
import com.aliyun.sls.android.sdk.core.auth.HmacSHA1Signature;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Deflater;

public class Utils {
  public static String GetMGTTime() {
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return simpleDateFormat.format(calendar.getTime());
  }
  
  public static byte[] GzipFrom(byte[] paramArrayOfbyte) throws LogException {
    Deflater deflater = new Deflater();
    Exception exception = null;
    ByteArrayOutputStream byteArrayOutputStream1 = null;
    ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream1;
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      byteArrayOutputStream2 = byteArrayOutputStream1;
    } catch (Exception exception1) {
    
    } finally {
      deflater.end();
      try {
        if (byteArrayOutputStream2.size() != 0)
          byteArrayOutputStream2.close(); 
      } catch (IOException iOException) {}
    } 
    byte[] arrayOfByte = paramArrayOfbyte;
    LogException logException = new LogException();
    arrayOfByte = paramArrayOfbyte;
    this("LogClientError", "fail to zip data", "");
    arrayOfByte = paramArrayOfbyte;
    throw logException;
  }
  
  public static String ParseToMd5U32(byte[] paramArrayOfbyte) throws LogException {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      BigInteger bigInteger = new BigInteger();
      this(1, messageDigest.digest(paramArrayOfbyte));
      String str = bigInteger.toString(16).toUpperCase();
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      for (byte b = 0; str.length() + b < 32; b++)
        stringBuilder1.append("0"); 
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      stringBuilder2.append(stringBuilder1.toString());
      stringBuilder2.append(str);
      return stringBuilder2.toString();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new LogException("LogClientError", "Not Supported signature method MD5", noSuchAlgorithmException, "");
    } 
  }
  
  public static void assertTrue(boolean paramBoolean, String paramString) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(paramString);
  }
  
  public static String sign(String paramString1, String paramString2, String paramString3) {
    try {
      HmacSHA1Signature hmacSHA1Signature = new HmacSHA1Signature();
      this();
      paramString2 = hmacSHA1Signature.computeSignature(paramString2, paramString3).trim();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("LOG ");
      stringBuilder.append(paramString1);
      stringBuilder.append(":");
      stringBuilder.append(paramString2);
      return stringBuilder.toString();
    } catch (Exception exception) {
      throw new IllegalStateException("Compute signature failed!", exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sd\\utils\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */