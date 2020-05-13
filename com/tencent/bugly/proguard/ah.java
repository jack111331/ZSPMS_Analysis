package com.tencent.bugly.proguard;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ah implements aj {
  private String a = null;
  
  public final void a(String paramString) {
    if (paramString != null) {
      for (int i = paramString.length(); i < 16; i++) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append("0");
        paramString = stringBuilder.toString();
      } 
      this.a = paramString.substring(0, 16);
    } 
  }
  
  public final byte[] a(byte[] paramArrayOfbyte) throws Exception {
    if (this.a == null || paramArrayOfbyte == null)
      return null; 
    StringBuffer stringBuffer1 = new StringBuffer();
    int i = paramArrayOfbyte.length;
    byte b1 = 0;
    byte b2;
    for (b2 = 0; b2 < i; b2++) {
      byte b = paramArrayOfbyte[b2];
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b);
      stringBuilder.append(" ");
      stringBuffer1.append(stringBuilder.toString());
    } 
    SecretKeySpec secretKeySpec = new SecretKeySpec(this.a.getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(2, secretKeySpec, new IvParameterSpec(this.a.getBytes()));
    byte[] arrayOfByte = cipher.doFinal(paramArrayOfbyte);
    StringBuffer stringBuffer2 = new StringBuffer();
    i = arrayOfByte.length;
    for (b2 = b1; b2 < i; b2++) {
      b1 = arrayOfByte[b2];
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b1);
      stringBuilder.append(" ");
      stringBuffer2.append(stringBuilder.toString());
    } 
    return arrayOfByte;
  }
  
  public final byte[] b(byte[] paramArrayOfbyte) throws Exception, NoSuchAlgorithmException {
    if (this.a == null || paramArrayOfbyte == null)
      return null; 
    StringBuffer stringBuffer2 = new StringBuffer();
    int i = paramArrayOfbyte.length;
    byte b1 = 0;
    byte b2;
    for (b2 = 0; b2 < i; b2++) {
      byte b = paramArrayOfbyte[b2];
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b);
      stringBuilder.append(" ");
      stringBuffer2.append(stringBuilder.toString());
    } 
    SecretKeySpec secretKeySpec = new SecretKeySpec(this.a.getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(1, secretKeySpec, new IvParameterSpec(this.a.getBytes()));
    byte[] arrayOfByte = cipher.doFinal(paramArrayOfbyte);
    StringBuffer stringBuffer1 = new StringBuffer();
    i = arrayOfByte.length;
    for (b2 = b1; b2 < i; b2++) {
      b1 = arrayOfByte[b2];
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b1);
      stringBuilder.append(" ");
      stringBuffer1.append(stringBuilder.toString());
    } 
    return arrayOfByte;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */