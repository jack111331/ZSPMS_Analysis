package com.aliyun.sls.android.sdk.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class DateUtil {
  private static final String ALTERNATIVE_ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
  
  private static final String ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  
  private static final String RFC822_DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss 'GMT'";
  
  private static volatile long amendTimeSkewed;
  
  public static String currentFixedSkewedTimeInRFC822Format() {
    // Byte code:
    //   0: ldc com/aliyun/sls/android/sdk/utils/DateUtil
    //   2: monitorenter
    //   3: new java/util/Date
    //   6: astore_0
    //   7: aload_0
    //   8: invokestatic getFixedSkewedTimeMillis : ()J
    //   11: invokespecial <init> : (J)V
    //   14: aload_0
    //   15: invokestatic formatRfc822Date : (Ljava/util/Date;)Ljava/lang/String;
    //   18: astore_0
    //   19: ldc com/aliyun/sls/android/sdk/utils/DateUtil
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: astore_0
    //   25: ldc com/aliyun/sls/android/sdk/utils/DateUtil
    //   27: monitorexit
    //   28: aload_0
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	24	finally
  }
  
  public static String formatAlternativeIso8601Date(Date paramDate) {
    return getAlternativeIso8601DateFormat().format(paramDate);
  }
  
  public static String formatIso8601Date(Date paramDate) {
    return getIso8601DateFormat().format(paramDate);
  }
  
  public static String formatRfc822Date(Date paramDate) {
    return getRfc822DateFormat().format(paramDate);
  }
  
  private static DateFormat getAlternativeIso8601DateFormat() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    return simpleDateFormat;
  }
  
  public static long getFixedSkewedTimeMillis() {
    return System.currentTimeMillis() + amendTimeSkewed;
  }
  
  private static DateFormat getIso8601DateFormat() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    return simpleDateFormat;
  }
  
  private static DateFormat getRfc822DateFormat() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
    simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    return simpleDateFormat;
  }
  
  public static Date parseIso8601Date(String paramString) throws ParseException {
    try {
      return getIso8601DateFormat().parse(paramString);
    } catch (ParseException parseException) {
      return getAlternativeIso8601DateFormat().parse(paramString);
    } 
  }
  
  public static Date parseRfc822Date(String paramString) throws ParseException {
    return getRfc822DateFormat().parse(paramString);
  }
  
  public static void setCurrentServerTime(long paramLong) {
    // Byte code:
    //   0: ldc com/aliyun/sls/android/sdk/utils/DateUtil
    //   2: monitorenter
    //   3: lload_0
    //   4: invokestatic currentTimeMillis : ()J
    //   7: lsub
    //   8: putstatic com/aliyun/sls/android/sdk/utils/DateUtil.amendTimeSkewed : J
    //   11: ldc com/aliyun/sls/android/sdk/utils/DateUtil
    //   13: monitorexit
    //   14: return
    //   15: astore_2
    //   16: ldc com/aliyun/sls/android/sdk/utils/DateUtil
    //   18: monitorexit
    //   19: aload_2
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	15	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sd\\utils\DateUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */