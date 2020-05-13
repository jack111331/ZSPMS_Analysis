package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;

public class d {
  private static final String a = d.class.getCanonicalName();
  
  private static String b = "";
  
  private static int c = 0;
  
  private static int d = 5;
  
  public static String a(Context paramContext) {
    String str;
    try {
      if (!h.a(paramContext))
        return ""; 
      String str1 = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      str = str1;
      if (str1 == null)
        str = ""; 
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
  
  public static String a(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramString.startsWith("46000") || paramString.startsWith("46002") || paramString.startsWith("46004") || paramString.startsWith("46007"))
        return "cm"; 
      if (paramString.startsWith("46003") || paramString.startsWith("46005") || paramString.startsWith("46011"))
        return "ct"; 
      if (paramString.startsWith("46001") || paramString.startsWith("46006") || paramString.startsWith("46009"))
        return "cu"; 
    } 
    return "";
  }
  
  public static String b(Context paramContext) {
    String str;
    try {
      if (!h.a(paramContext))
        return ""; 
      String str1 = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      str = str1;
      if (str1 == null)
        str = ""; 
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  public static String c(Context paramContext) {
    String str = "";
    try {
      String str8;
      String str9;
      if (!h.a(paramContext))
        return str; 
      String str3 = "";
      String str4 = "";
      String str5 = "";
      try {
        if ((d != 0 && c % d == 0) || c == 0) {
          TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
          Class<?> clazz = telephonyManager.getClass();
          Method method = clazz.getDeclaredMethod("getImei", new Class[] { int.class });
          str8 = (String)method.invoke(telephonyManager, new Object[] { Integer.valueOf(0) });
          try {
            str7 = (String)method.invoke(telephonyManager, new Object[] { Integer.valueOf(1) });
            try {
              Method method1 = clazz.getDeclaredMethod("getSubscriberId", new Class[] { int.class });
              str6 = (String)method1.invoke(telephonyManager, new Object[] { Integer.valueOf(0) });
              try {
                str9 = (String)method1.invoke(telephonyManager, new Object[] { Integer.valueOf(1) });
                if (str8 == null)
                  str8 = ""; 
                String str10 = str7;
                if (str7 == null)
                  str10 = ""; 
                if (str6 == null) {
                  str7 = "";
                } else {
                  str7 = str6;
                } 
                str6 = str9;
                if (str9 == null)
                  str6 = ""; 
                str9 = str6;
                try {
                  c = 0;
                  str9 = str6;
                  str6 = str7;
                  str7 = str8;
                  str8 = str10;
                  str10 = str6;
                } catch (Exception exception1) {
                  str6 = str7;
                  Exception exception2 = exception1;
                  str5 = str10;
                  exception = exception2;
                  str7 = str8;
                  str8 = str5;
                } 
              } catch (Exception null) {
                str9 = str7;
                str7 = str8;
                str8 = str9;
                str9 = str5;
              } 
            } catch (Exception null) {
              str6 = str7;
              str7 = str8;
              str8 = str6;
              str9 = str5;
              str6 = str4;
            } 
          } catch (Exception null) {
            str7 = str8;
            str8 = str3;
            str9 = str5;
            str6 = str4;
          } 
        } else {
          str6 = "";
          str7 = "";
          str8 = "";
          str = "";
          str9 = str6;
          str6 = str7;
          str7 = str8;
          str8 = str;
          str = str6;
        } 
      } catch (Exception exception) {
        str7 = "";
        str6 = str4;
        str9 = str5;
        str8 = str3;
      } 
      if (c >= 0)
        c++; 
      if (c > 50)
        d = 10; 
      exception.printStackTrace();
      String str2 = str6;
      String str6 = str7;
      if (TextUtils.isEmpty(str7))
        str6 = b(paramContext); 
      String str7 = str2;
      if (TextUtils.isEmpty(str2))
        str7 = a(paramContext); 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      String str1 = stringBuilder.append(str6).append("-").append(str8).append("-").append(str7).append("-").append(str9).toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      String str1 = "";
    } catch (Error error) {}
    return (String)error;
  }
  
  public static String d(Context paramContext) {
    String str1;
    if (paramContext == null)
      return ""; 
    String str2 = c(paramContext);
    String str3 = "";
    String str4 = "";
    String str5 = str3;
    try {
      String[] arrayOfString = str2.split("-", 4);
      String str = str4;
      str2 = str3;
      str5 = str3;
      if (arrayOfString.length == 4) {
        str2 = arrayOfString[2];
        str = arrayOfString[3];
      } 
      str5 = str2;
      if (TextUtils.isEmpty(str2))
        str5 = a(paramContext); 
      str1 = a(str5);
      str2 = a(str);
      str1 = str1 + "," + str2;
    } catch (Exception exception) {
      exception.printStackTrace();
      String str7 = str4;
      String str6 = str5;
    } 
    return str1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */