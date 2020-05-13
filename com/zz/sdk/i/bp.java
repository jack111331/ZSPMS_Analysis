package com.zz.sdk.i;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.zz.sdk.SDKManager;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class bp {
  public static final boolean a = false;
  
  public static final String b = "zz_sdk";
  
  private static Logger c = null;
  
  public static void a(Context paramContext) {
    if (c == null) {
      bq bq = new bq();
      Logger logger = Logger.getLogger("zz_sdk");
      logger.setUseParentHandlers(false);
      logger.setLevel(Level.ALL);
      String str = null;
      try {
        String str1 = b(paramContext);
        str = str1;
        FileHandler fileHandler = new FileHandler();
        str = str1;
        this(str1, true);
        str = str1;
        fileHandler.setLevel(Level.ALL);
        str = str1;
        fileHandler.setFormatter(bq);
        str = str1;
        logger.addHandler(fileHandler);
      } catch (IOException iOException) {
        Log.w("zz_sdk", "jar " + str);
      } 
      c = logger;
      b();
      a("\n\n" + SDKManager.getVersionDesc());
      Log.d("zz_sdk", SDKManager.getVersionDesc() + ":" + paramContext.getPackageName());
    } 
  }
  
  public static void a(Object paramObject) {
    if (c != null)
      c.log(Level.INFO, c(paramObject)); 
  }
  
  private static String b(Context paramContext) {
    File file = new File(new File(new File(Environment.getExternalStorageDirectory(), "zzsdk"), "log"), paramContext.getPackageName());
    String str = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    return (new File(file, str + ".log")).getAbsolutePath();
  }
  
  private static void b() {
    Thread.setDefaultUncaughtExceptionHandler(new br(Thread.getDefaultUncaughtExceptionHandler()));
  }
  
  public static void b(Object paramObject) {
    if (c != null)
      c.log(Level.WARNING, c(paramObject)); 
  }
  
  private static String c(Object paramObject) {
    if (paramObject == null)
      return "null"; 
    Class<?> clazz = paramObject.getClass();
    if (clazz.isArray()) {
      StringBuilder stringBuilder = new StringBuilder(clazz.getSimpleName());
      stringBuilder.append(" [ ");
      int i = Array.getLength(paramObject);
      for (byte b = 0; b < i; b++) {
        if (b != 0)
          stringBuilder.append(", "); 
        stringBuilder.append(Array.get(paramObject, b));
      } 
      stringBuilder.append(" ]");
      return stringBuilder.toString();
    } 
    return String.valueOf(paramObject);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */