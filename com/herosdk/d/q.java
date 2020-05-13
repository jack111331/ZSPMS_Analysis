package com.herosdk.d;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class q {
  static final int a = 4096;
  
  public static InputStream a(String paramString) {
    return new ByteArrayInputStream(paramString.getBytes("UTF-8"));
  }
  
  public static InputStream a(byte[] paramArrayOfbyte) {
    return new ByteArrayInputStream(paramArrayOfbyte);
  }
  
  public static String a(InputStream paramInputStream) {
    return a(paramInputStream, "UTF-8");
  }
  
  public static String a(InputStream paramInputStream, String paramString) {
    StringBuffer stringBuffer = new StringBuffer();
    new String();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
    while (true) {
      String str = bufferedReader.readLine();
      if (str != null) {
        stringBuffer.append(str).append("\n");
        continue;
      } 
      bufferedReader.close();
      return stringBuffer.toString();
    } 
  }
  
  public static String b(byte[] paramArrayOfbyte) {
    return a(a(paramArrayOfbyte));
  }
  
  public static byte[] b(InputStream paramInputStream) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[4096];
    while (true) {
      int i = paramInputStream.read(arrayOfByte, 0, 4096);
      if (i != -1) {
        byteArrayOutputStream.write(arrayOfByte, 0, i);
        continue;
      } 
      return byteArrayOutputStream.toByteArray();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */