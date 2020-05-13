package com.herosdk.error;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorUtils {
  private static final String a = "frameLib.ExUtils";
  
  public static String a(Throwable paramThrowable) {
    StringWriter stringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(stringWriter));
    return stringWriter.toString();
  }
  
  public static void printExceptionInfo(Throwable paramThrowable) {
    Log.e("frameLib.ExUtils", "=>printExceptionInfo");
    Log.e("frameLib.ExUtils", a(paramThrowable));
    Log.e("frameLib.ExUtils", "<=printExceptionInfo");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\error\ErrorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */