package com.tencent.tp;

import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ac {
  private static String a(String paramString) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
      noSuchAlgorithmException = null;
    } 
    noSuchAlgorithmException.update(paramString.getBytes(), 0, paramString.length());
    return b(noSuchAlgorithmException.digest());
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    String str;
    try {
      String str1;
      CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream();
      this(paramArrayOfbyte);
      String str2 = ((X509Certificate)certificateFactory.generateCertificate(byteArrayInputStream)).getPublicKey().toString();
      certificateFactory = null;
      paramArrayOfbyte = null;
      boolean bool = str2.contains("modulus=");
      byte b = 0;
      if (bool) {
        Matcher matcher = Pattern.compile("\\{[^,]+").matcher(str2);
        byte[] arrayOfByte = paramArrayOfbyte;
        while (true) {
          paramArrayOfbyte = arrayOfByte;
          if (matcher.find()) {
            String[] arrayOfString = matcher.group().split("=");
            for (b = 0; b < arrayOfString.length; b++) {
              if (arrayOfString[b].length() > 100) {
                str1 = arrayOfString[b];
                break;
              } 
            } 
            continue;
          } 
          break;
        } 
      } else {
        str = str1;
        if (str2.contains("modulus:")) {
          String[] arrayOfString = str2.split(" ");
          while (true) {
            str = str1;
            if (b < arrayOfString.length) {
              if (arrayOfString[b].length() > 100) {
                str = arrayOfString[b];
                break;
              } 
              b++;
              continue;
            } 
            break;
          } 
        } 
      } 
      if (str == null)
        str = str2; 
      str = a(str.trim().toLowerCase(Locale.US));
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      str = "EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE";
    } 
    return str;
  }
  
  private static String b(byte[] paramArrayOfbyte) {
    String str = "";
    for (byte b = 0; b < paramArrayOfbyte.length; b++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(Integer.toString((paramArrayOfbyte[b] & 0xFF) + 256, 16).substring(1));
      str = stringBuilder.toString();
    } 
    return str.toUpperCase(Locale.US);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */