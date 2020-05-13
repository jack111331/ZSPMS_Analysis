package com.chuanglan.shanyan_sdk.utils;

import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

public class AbUniqueCodeUtil {
  private static String a(String paramString) {
    ParseException parseException2 = null;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      long l = simpleDateFormat.parse(paramString).getTime();
      paramString = String.valueOf(l);
    } catch (ParseException parseException1) {
      parseException1.printStackTrace();
      L.d("ExceptionLogger", "getTime()Exception == " + parseException1.toString());
      parseException1 = parseException2;
    } 
    return (String)parseException1;
  }
  
  private static Date a() {
    Date date;
    try {
      TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
      URL uRL = new URL();
      this("https://www.baidu.com");
      URLConnection uRLConnection = uRL.openConnection();
      uRLConnection.setReadTimeout(3000);
      uRLConnection.setConnectTimeout(3000);
      uRLConnection.connect();
      long l = uRLConnection.getDate();
      if (l > 0L) {
        Date date1 = new Date();
        this(l);
        return date1;
      } 
      date = new Date();
    } catch (Exception exception) {
      exception.printStackTrace();
      L.d("ExceptionLogger", "getDate()Exception == " + exception.toString());
      date = new Date();
    } 
    return date;
  }
  
  public static String getNetworkTime() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
    return a(simpleDateFormat.format(a()));
  }
  
  public static String getUUID() {
    return UUID.randomUUID().toString().replace("-", "");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\AbUniqueCodeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */