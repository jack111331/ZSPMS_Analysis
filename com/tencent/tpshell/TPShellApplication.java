package com.tencent.tpshell;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

public class TPShellApplication extends Application {
  static {
    System.loadLibrary("tprt");
  }
  
  private static final native int chmod(String paramString, int paramInt);
  
  private final native int initialize(String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString, String paramString5, String paramString6);
  
  protected final void Initial() {
    File file;
    Throwable throwable;
    ApplicationInfo applicationInfo = getApplicationInfo();
    String str1 = "";
    try {
      BufferedReader bufferedReader = new BufferedReader();
      InputStreamReader inputStreamReader = new InputStreamReader();
      FileInputStream fileInputStream = new FileInputStream();
      this("/proc/self/cmdline");
      this(fileInputStream);
      this(inputStreamReader);
      String str7 = bufferedReader.readLine().toString();
      bufferedReader.close();
      String str6 = str7.substring(0, str7.indexOf(false));
      str1 = str6;
    } catch (Throwable null) {
    
    } catch (Exception null) {
      throwable.printStackTrace();
      System.exit(1);
      return;
    } 
    String str2 = applicationInfo.packageName;
    String str4 = applicationInfo.dataDir;
    String str5 = applicationInfo.nativeLibraryDir;
    String str3 = applicationInfo.sourceDir;
    if (this == null) {
      file = new File();
      this(str4, "files");
      if (!file.exists()) {
        file.mkdir();
        chmod(file.getAbsolutePath(), 505);
      } 
    } else {
      file = getFilesDir();
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      Field field = applicationInfo.getClass().getDeclaredField("splitSourceDirs");
      field.setAccessible(true);
      String[] arrayOfString = (String[])field.get(applicationInfo);
      if (initialize(str2, file.getAbsolutePath(), str5, str3, arrayOfString, str1, str4) != 0) {
        throwable = new Exception();
        this("initialize failed.");
        throw throwable;
      } 
      return;
    } 
    if (initialize(str2, throwable.getAbsolutePath(), str5, str3, null, str1, str4) != 0) {
      throwable = new Exception();
      super("initialize failed.");
      throw throwable;
    } 
  }
  
  protected void attachBaseContext(Context paramContext) {
    super.attachBaseContext(paramContext);
    Initial();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tpshell\TPShellApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */