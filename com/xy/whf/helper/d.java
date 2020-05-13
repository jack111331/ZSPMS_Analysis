package com.xy.whf.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class d {
  public static long a(String paramString1, String paramString2) {
    long l = 0L;
    if (!LangHelper.isNullOrEmpty(paramString1)) {
      String str = paramString2;
      if (LangHelper.isNullOrEmpty(paramString2))
        str = "yyyy.MM.dd"; 
      Calendar calendar = Calendar.getInstance();
      try {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        this(str, Locale.CHINA);
        calendar.setTime(simpleDateFormat.parse(paramString1));
        long l1 = calendar.getTimeInMillis();
        l = l1;
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
    return l;
  }
  
  public static String a(Date paramDate, String paramString) {
    if (paramDate == null)
      return ""; 
    String str = paramString;
    if (LangHelper.isNullOrEmpty(paramString))
      str = "yyyy.MM.dd"; 
    return (new SimpleDateFormat(str, Locale.CHINA)).format(paramDate);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */