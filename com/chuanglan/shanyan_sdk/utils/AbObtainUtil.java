package com.chuanglan.shanyan_sdk.utils;

import com.chuanglan.shanyan_sdk.tool.c;
import com.chuanglan.shanyan_sdk.tool.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;

public class AbObtainUtil {
  private static String a(String paramString1, String paramString2) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramString2.getBytes("UTF-8"), "HmacSHA1");
      Mac mac = Mac.getInstance("HmacSHA1");
      mac.init(secretKeySpec);
      paramString1 = Base64.encode(mac.doFinal(paramString1.getBytes("UTF-8")));
    } catch (Exception exception) {
      exception.printStackTrace();
      L.d("ExceptionLogger", "hmacSHA1Encrypt()Exception == " + exception.toString());
      exception = null;
    } 
    if (exception == null)
      exception = null; 
    return (String)exception;
  }
  
  public static byte[] aesEncrypt(byte[] paramArrayOfbyte, String paramString1, String paramString2) {
    try {
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramString1.getBytes(), "AES");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(paramString2.getBytes());
      cipher.init(1, secretKeySpec, ivParameterSpec);
      paramArrayOfbyte = cipher.doFinal(paramArrayOfbyte);
    } catch (Exception exception) {
      exception.printStackTrace();
      L.d("ExceptionLogger", "aesEncrypt()Exception == " + exception.toString());
      exception = null;
    } 
    return (byte[])exception;
  }
  
  public static byte[] compressForGzip(String paramString) {
    String str1;
    String str2 = null;
    if (AppStringUtils.isEmpty(paramString))
      return (byte[])str2; 
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      this();
      GZIPOutputStream gZIPOutputStream = new GZIPOutputStream();
      this(byteArrayOutputStream);
      gZIPOutputStream.write(paramString.getBytes("utf-8"));
      gZIPOutputStream.close();
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      byteArrayOutputStream.flush();
      byteArrayOutputStream.close();
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
      L.d("ExceptionLogger", "compressForGzip()Exception == " + unsupportedEncodingException.toString());
      str1 = str2;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      L.d("ExceptionLogger", "compressForGzip()Exception == " + iOException.toString());
      str1 = str2;
    } 
    return (byte[])str1;
  }
  
  public static JSONArray getBehaviorJsonArray(List<c> paramList) {
    JSONArray jSONArray = new JSONArray();
    for (byte b = 0; b < paramList.size(); b++) {
      c c = paramList.get(b);
      JSONArray jSONArray1 = new JSONArray();
      try {
        jSONArray1.put(c.a);
        jSONArray1.put(c.b);
        jSONArray1.put(c.c);
        jSONArray1.put(c.d);
        jSONArray1.put(c.e);
        jSONArray1.put(c.f);
        jSONArray1.put(c.g);
        jSONArray1.put(c.h);
        jSONArray1.put(c.i);
        jSONArray1.put(c.j);
        jSONArray1.put(c.k);
        jSONArray1.put(c.l);
        jSONArray1.put(c.m);
        jSONArray1.put(c.n);
        jSONArray1.put(String.valueOf(c.o));
        jSONArray1.put(String.valueOf(c.p));
        jSONArray1.put(c.q);
        jSONArray1.put(c.r);
        jSONArray1.put(c.s);
        jSONArray1.put(c.t);
        jSONArray1.put(c.u);
        jSONArray1.put(String.valueOf(c.v));
        jSONArray1.put(c.w);
        jSONArray.put(jSONArray1);
      } catch (Exception exception) {
        exception.printStackTrace();
        L.d("ExceptionLogger", "getBehaviorJsonArray()Exception == " + exception.toString());
      } 
    } 
    return jSONArray;
  }
  
  public static JSONArray getDeviceJsonArray(List<d> paramList) {
    JSONArray jSONArray = new JSONArray();
    for (byte b = 0; b < paramList.size(); b++) {
      d d = paramList.get(b);
      JSONArray jSONArray1 = new JSONArray();
      try {
        jSONArray1.put(d.a);
        jSONArray1.put(d.b);
        jSONArray1.put(d.c);
        jSONArray1.put(d.d);
        jSONArray1.put(d.e);
        jSONArray1.put(d.f);
        jSONArray1.put(d.g);
        jSONArray1.put(d.h);
        jSONArray.put(jSONArray1);
      } catch (Exception exception) {
        exception.printStackTrace();
        L.d("ExceptionLogger", "init()Exception == " + exception.toString());
      } 
    } 
    return jSONArray;
  }
  
  public static String getSign(Map<String, Object> paramMap, String paramString) {
    TreeSet treeSet = new TreeSet(paramMap.keySet());
    StringBuilder stringBuilder = new StringBuilder();
    for (String str : treeSet) {
      if (!str.equals("sign"))
        stringBuilder.append(str).append(paramMap.get(str)); 
    } 
    return a(stringBuilder.toString(), paramString);
  }
  
  public static String getSignFullReport(Map<String, Object> paramMap, String paramString) {
    TreeSet treeSet = new TreeSet(paramMap.keySet());
    StringBuilder stringBuilder = new StringBuilder();
    for (String str : treeSet) {
      if (!str.equals("sign"))
        stringBuilder.append(paramMap.get(str)); 
    } 
    return a(stringBuilder.toString(), paramString);
  }
  
  public static String md5(String paramString) {
    String str;
    if (AppStringUtils.isEmpty(paramString))
      return ""; 
    try {
      byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      int i = arrayOfByte.length;
      byte b = 0;
      paramString = "";
      while (true) {
        str = paramString;
        if (b < i) {
          String str1 = Integer.toHexString(arrayOfByte[b] & 0xFF);
          str = str1;
          if (str1.length() == 1) {
            StringBuilder stringBuilder1 = new StringBuilder();
            this();
            str = stringBuilder1.append("0").append(str1).toString();
          } 
          StringBuilder stringBuilder = new StringBuilder();
          this();
          paramString = stringBuilder.append(paramString).append(str).toString();
          b++;
          continue;
        } 
        return str;
      } 
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      L.d("ExceptionLogger", "md5()Exception == " + noSuchAlgorithmException.toString());
      noSuchAlgorithmException.printStackTrace();
      str = "";
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\AbObtainUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */