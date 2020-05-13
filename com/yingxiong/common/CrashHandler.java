package com.yingxiong.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import com.yingxiong.recordsdk.RecordSDK;
import com.yingxiong.until.MLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
  private static CrashHandler INSTANCE;
  
  private static final String TAG = "RecordSDK";
  
  private Context mContext;
  
  private Thread.UncaughtExceptionHandler mDefaultHandler;
  
  private String getCrashReport(Context paramContext, Throwable paramThrowable) {
    PackageInfo packageInfo = getPackageInfo(paramContext);
    StringBuffer stringBuffer = new StringBuffer();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("Version: ");
    stringBuilder3.append(packageInfo.versionName);
    stringBuilder3.append("(");
    stringBuilder3.append(packageInfo.versionCode);
    stringBuilder3.append(")\n");
    stringBuffer.append(stringBuilder3.toString());
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("Android: ");
    stringBuilder2.append(Build.VERSION.RELEASE);
    stringBuilder2.append("(");
    stringBuilder2.append(Build.MODEL);
    stringBuilder2.append(")\n");
    stringBuffer.append(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("Exception: ");
    stringBuilder2.append(paramThrowable.getMessage());
    stringBuilder2.append("\n");
    stringBuffer.append(stringBuilder2.toString());
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    for (byte b = 0; b < arrayOfStackTraceElement.length; b++) {
      stringBuilder3 = new StringBuilder();
      stringBuilder3.append(arrayOfStackTraceElement[b].toString());
      stringBuilder3.append("\n");
      stringBuffer.append(stringBuilder3.toString());
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Cause: ");
    stringBuilder1.append(paramThrowable.getCause());
    stringBuilder1.append("\n");
    stringBuffer.append(stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("LocalizedMessage: ");
    stringBuilder1.append(paramThrowable.getLocalizedMessage());
    stringBuilder1.append("\n");
    stringBuffer.append(stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("StrintData: ");
    stringBuilder1.append(paramThrowable.toString());
    stringBuilder1.append("\n");
    stringBuffer.append(stringBuilder1.toString());
    return stringBuffer.toString();
  }
  
  public static CrashHandler getInstance() {
    // Byte code:
    //   0: ldc com/yingxiong/common/CrashHandler
    //   2: monitorenter
    //   3: getstatic com/yingxiong/common/CrashHandler.INSTANCE : Lcom/yingxiong/common/CrashHandler;
    //   6: ifnonnull -> 21
    //   9: new com/yingxiong/common/CrashHandler
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: putstatic com/yingxiong/common/CrashHandler.INSTANCE : Lcom/yingxiong/common/CrashHandler;
    //   21: ldc com/yingxiong/common/CrashHandler
    //   23: monitorexit
    //   24: getstatic com/yingxiong/common/CrashHandler.INSTANCE : Lcom/yingxiong/common/CrashHandler;
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/yingxiong/common/CrashHandler
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	28	finally
    //   21	24	28	finally
    //   29	32	28	finally
  }
  
  private PackageInfo getPackageInfo(Context paramContext) {
    PackageInfo packageInfo;
    try {
      PackageInfo packageInfo1 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException1) {
      nameNotFoundException1 = null;
    } 
    PackageManager.NameNotFoundException nameNotFoundException2 = nameNotFoundException1;
    if (nameNotFoundException1 == null)
      packageInfo = new PackageInfo(); 
    return packageInfo;
  }
  
  private File save2File(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("crash-");
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append(".txt");
    String str = stringBuilder.toString();
    if (Environment.getExternalStorageState().equals("mounted"))
      try {
        File file1 = new File();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        stringBuilder1.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        stringBuilder1.append(File.separator);
        stringBuilder1.append("crash");
        this(stringBuilder1.toString());
        if (!file1.exists())
          file1.mkdir(); 
        File file2 = new File();
        this(file1, str);
        FileOutputStream fileOutputStream = new FileOutputStream();
        this(file2);
        fileOutputStream.write(paramString.toString().getBytes());
        fileOutputStream.close();
        return file2;
      } catch (FileNotFoundException fileNotFoundException) {
        fileNotFoundException.printStackTrace();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
    return null;
  }
  
  public boolean handleException(Throwable paramThrowable) {
    if (paramThrowable == null || this.mContext == null)
      return false; 
    final String crashReport = getCrashReport(this.mContext, paramThrowable);
    Log.i("error", str);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("异常");
    stringBuilder.append(str);
    MLog.e("RecordSDK", stringBuilder.toString());
    (new Thread() {
        public void run() {
          RecordSDK.getInstance().recordUserInfoAction(crashReport);
        }
      }).start();
    return true;
  }
  
  public void init(Context paramContext) {
    this.mContext = paramContext;
    this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    try {
      if (!handleException(paramThrowable) && this.mDefaultHandler != null)
        this.mDefaultHandler.uncaughtException(paramThread, paramThrowable); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxiong\common\CrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */