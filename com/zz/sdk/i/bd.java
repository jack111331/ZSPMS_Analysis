package com.zz.sdk.i;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public class bd {
  private static final String a = "zz_sdk.ExUtils";
  
  public static String a(Throwable paramThrowable) {
    StringWriter stringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(stringWriter));
    return stringWriter.toString();
  }
  
  public static void b(Throwable paramThrowable) {
    Log.e("zz_sdk.ExUtils", "=>printExceptionInfo");
    Log.e("zz_sdk.ExUtils", a(paramThrowable));
    Log.e("zz_sdk.ExUtils", "<=printExceptionInfo");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */