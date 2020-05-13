package com.zz.a.c;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class b {
  public static String a(InputStream paramInputStream, String paramString) {
    ByteArrayOutputStream byteArrayOutputStream;
    try {
      byte[] arrayOfByte;
      byteArrayOutputStream = new ByteArrayOutputStream();
      this();
      if (paramString.equals("1")) {
        GZIPInputStream gZIPInputStream = new GZIPInputStream();
        this(paramInputStream);
        arrayOfByte = new byte[1024];
        while (true) {
          int i = gZIPInputStream.read(arrayOfByte);
          if (i > 0) {
            byteArrayOutputStream.write(arrayOfByte, 0, i);
            continue;
          } 
          break;
        } 
      } else {
        byte[] arrayOfByte1 = new byte[1024];
        while (true) {
          int i = arrayOfByte.read(arrayOfByte1);
          if (i > 0) {
            byteArrayOutputStream.write(arrayOfByte1, 0, i);
            continue;
          } 
          break;
        } 
      } 
    } catch (Exception exception) {
      paramInputStream = null;
      exception.printStackTrace();
    } 
    byteArrayOutputStream.flush();
    String str = byteArrayOutputStream.toString("utf-8");
    try {
      byteArrayOutputStream.close();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return str;
  }
  
  public static String a(String paramString1, String paramString2) {
    if (paramString1 == null || paramString1.length() == 0)
      paramString1 = ""; 
    switch (Integer.parseInt(paramString2)) {
      default:
        return paramString1;
      case 4:
        break;
    } 
    paramString1 = c.a(paramString1);
  }
  
  public static void a(OutputStream paramOutputStream, String paramString1, String paramString2) {
    try {
      if (paramString2.equals("1")) {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream();
        this(paramOutputStream);
        gZIPOutputStream.write(paramString1.getBytes("utf-8"));
        gZIPOutputStream.flush();
        gZIPOutputStream.close();
        return;
      } 
      paramOutputStream.write(paramString1.getBytes("utf-8"));
      paramOutputStream.flush();
      paramOutputStream.close();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static String b(String paramString1, String paramString2) {
    if (paramString1 == null || paramString1.length() == 0)
      paramString1 = ""; 
    switch (Integer.parseInt(paramString2)) {
      default:
        return paramString1;
      case 4:
        break;
    } 
    paramString1 = c.b(paramString1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */