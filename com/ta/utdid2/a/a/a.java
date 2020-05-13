package com.ta.utdid2.a.a;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a {
  public static String a(String paramString) {
    String str = null;
    try {
      byte[] arrayOfByte = a(a(), paramString.getBytes());
    } catch (Exception exception) {
      exception = null;
    } 
    if (exception != null)
      str = a((byte[])exception); 
    return str;
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer(paramArrayOfbyte.length * 2);
    for (byte b = 0; b < paramArrayOfbyte.length; b++)
      a(stringBuffer, paramArrayOfbyte[b]); 
    return stringBuffer.toString();
  }
  
  private static void a(StringBuffer paramStringBuffer, byte paramByte) {
    paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte >> 4 & 0xF)).append("0123456789ABCDEF".charAt(paramByte & 0xF));
  }
  
  private static byte[] a() {
    return e.a(new byte[] { 
          33, 83, -50, -89, -84, -114, 80, 99, 10, 63, 
          22, -65, -11, 30, 101, -118 });
  }
  
  private static byte[] a(String paramString) {
    int i = paramString.length() / 2;
    byte[] arrayOfByte = new byte[i];
    for (byte b = 0; b < i; b++)
      arrayOfByte[b] = Integer.valueOf(paramString.substring(b * 2, b * 2 + 2), 16).byteValue(); 
    return arrayOfByte;
  }
  
  private static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte1, "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
    return cipher.doFinal(paramArrayOfbyte2);
  }
  
  public static String b(String paramString) {
    try {
      byte[] arrayOfByte = b(a(), a(paramString));
      paramString = new String();
      this(arrayOfByte);
    } catch (Exception exception) {
      exception = null;
    } 
    return (String)exception;
  }
  
  private static byte[] b(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte1, "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
    return cipher.doFinal(paramArrayOfbyte2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\t\\utdid2\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */