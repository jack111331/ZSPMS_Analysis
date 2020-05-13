package com.bun.miitmdid.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.Keep;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.zip.CRC32;

@Keep
public class Utils {
  @Keep
  public static final String CPU_ABI_X86 = "x86";
  
  @Keep
  private static String CPUABI() {
    String str = "arm";
    try {
      BufferedReader bufferedReader = new BufferedReader();
      InputStreamReader inputStreamReader = new InputStreamReader();
      this(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream());
      this(inputStreamReader);
      boolean bool = bufferedReader.readLine().contains("x86");
      if (bool)
        str = "x86"; 
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      str = "arm";
    } 
    return str;
  }
  
  public static void PrintClassMethod(Class<?> paramClass) {
    Method[] arrayOfMethod = paramClass.getMethods();
    int i = arrayOfMethod.length;
    for (byte b = 0;; b++) {
      if (b >= i)
        return; 
      Method method = arrayOfMethod[b];
      System.out.println(method.getName());
    } 
  }
  
  public static void PrintObjectType(Class<?> paramClass) {
    String str = paramClass.getName();
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder("PrintObjectType:");
    stringBuilder.append(str);
    printStream.println(stringBuilder.toString());
  }
  
  public static void PrintObjectType(Object paramObject) {
    String str = paramObject.getClass().getName();
    paramObject = System.out;
    StringBuilder stringBuilder = new StringBuilder("PrintObjectType:");
    stringBuilder.append(str);
    paramObject.println(stringBuilder.toString());
  }
  
  @Keep
  public static long getFileCRC(String paramString) {
    try {
      long l;
      File file = new File();
      this(paramString);
      if (!file.exists())
        return -1L; 
      int i = (int)file.length();
      FileInputStream fileInputStream = new FileInputStream();
      this(paramString);
      CRC32 cRC32 = new CRC32();
      this();
      byte[] arrayOfByte = new byte[i];
      int j;
      for (j = 0;; j += k) {
        if (j >= i) {
          cRC32.update(i);
          l = cRC32.getValue();
          break;
        } 
        int k = fileInputStream.read(arrayOfByte, j, i - j);
      } 
      return l;
    } catch (IOException iOException) {}
    return -1L;
  }
  
  @Keep
  public static void getFileListame(String paramString) {
    File[] arrayOfFile = (new File(paramString)).listFiles();
    if (arrayOfFile != null)
      for (byte b = 0; b < arrayOfFile.length; b++) {
        Log.i("Utils", arrayOfFile[b].getName());
        if (arrayOfFile[b].isDirectory()) {
          getFileListame(arrayOfFile[b].getAbsolutePath());
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(arrayOfFile[b].getAbsolutePath()));
          stringBuilder.append(arrayOfFile[b].getName());
          Log.i("Utils", stringBuilder.toString());
        } 
      }  
  }
  
  @Keep
  public static String getLibraryDir(Context paramContext) {
    return (paramContext.getApplicationInfo()).nativeLibraryDir;
  }
  
  @Keep
  public static String getUserDir(Context paramContext) {
    return paramContext.getFilesDir().getParent();
  }
  
  @Keep
  public static String getXdataDir(Context paramContext, String paramString) {
    StringBuffer stringBuffer = new StringBuffer();
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(getUserDir(paramContext)));
    stringBuilder.append("/");
    stringBuilder.append(JLibrary.xdata);
    stringBuilder.append("/");
    stringBuilder.append(paramString);
    stringBuffer.append(stringBuilder.toString());
    return stringBuffer.toString();
  }
  
  @Keep
  public static String getYdataDir(Context paramContext, String paramString) {
    StringBuffer stringBuffer = new StringBuffer();
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(getUserDir(paramContext)));
    stringBuilder.append("/");
    stringBuilder.append(JLibrary.ydata);
    stringBuilder.append("/");
    stringBuilder.append(paramString);
    stringBuffer.append(stringBuilder.toString());
    return stringBuffer.toString();
  }
  
  @Keep
  public static boolean isX86() {
    return (Build.CPU_ABI.equals("x86") || CPUABI().equals("x86"));
  }
  
  @Keep
  public static boolean update(Context paramContext) throws Exception {
    long l = ZipUtils.getZipCrc(new File((paramContext.getApplicationInfo()).sourceDir));
    boolean bool = false;
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences("update", 0);
    if (l != sharedPreferences.getLong("crc", 0L))
      bool = true; 
    sharedPreferences.edit().putLong("crc", l).commit();
    return bool;
  }
  
  @Keep
  public static void x0xooXdata(InputStream paramInputStream, String paramString, Context paramContext) throws Exception {
    try {
      File file = new File();
      this(paramString);
      byte[] arrayOfByte = new byte[65536];
      BufferedInputStream bufferedInputStream = new BufferedInputStream();
      this(paramInputStream);
      BufferedOutputStream bufferedOutputStream = new BufferedOutputStream();
      FileOutputStream fileOutputStream = new FileOutputStream();
      this(file);
      this(fileOutputStream);
      while (true) {
        int i = bufferedInputStream.read(arrayOfByte);
        if (i <= 0) {
          bufferedOutputStream.flush();
          bufferedOutputStream.close();
          bufferedInputStream.close();
          return;
        } 
        bufferedOutputStream.write(arrayOfByte, 0, i);
      } 
    } catch (Exception exception) {
      throw exception;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\miitmdid\core\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */