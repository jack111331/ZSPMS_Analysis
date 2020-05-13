package cn.com.chinatelecom.account.api;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import cn.com.chinatelecom.account.api.a.b;
import cn.com.chinatelecom.account.api.c.d;
import cn.com.chinatelecom.account.api.c.e;
import java.security.interfaces.RSAPublicKey;

public final class ClientUtils {
  private static final String TAG = ClientUtils.class.getSimpleName();
  
  public static String enrdata(String paramString1, String paramString2) {
    String str;
    try {
      paramString1 = b.a(paramString1, (RSAPublicKey)b.a(paramString2));
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  public static String getApiVersion() {
    return "v1.46";
  }
  
  public static String getCurrentNetworkType(Context paramContext) {
    return e.g(paramContext);
  }
  
  public static String getMobileBrand() {
    return Build.BRAND;
  }
  
  public static String getModel() {
    return Build.MODEL;
  }
  
  public static String getOnlineType(Context paramContext) {
    return e.f(paramContext);
  }
  
  public static String getOperatorType(Context paramContext) {
    return d.d(paramContext);
  }
  
  public static String getOs() {
    return getMobileBrand() + "-" + getModel() + "-" + "A:" + Build.VERSION.RELEASE;
  }
  
  public static String getPID() {
    String str1 = "";
    String str2 = str1;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      str2 = str1;
      this();
      str2 = str1;
      str1 = stringBuilder.append(Thread.currentThread().getId()).append("").append(Process.myPid()).toString();
      str2 = str1;
      if (str1.length() > 6) {
        str2 = str1;
        str1 = str1.substring(0, 6);
        return str1;
      } 
      str2 = "ctacco";
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return str2;
  }
  
  public static String getSdkVersion() {
    return "SDK-API-v1.5.1";
  }
  
  public static String getTopActivity(Context paramContext) {
    String str;
    try {
      str = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      str = "error";
    } 
    return str;
  }
  
  public static long getTp() {
    return System.currentTimeMillis();
  }
  
  public static boolean isAT(Context paramContext, String paramString) {
    boolean bool;
    try {
      bool = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName().equals(paramString);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\ClientUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */