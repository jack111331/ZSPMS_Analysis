package com.tencent.tp.a;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class b {
  public static String a(Context paramContext) {
    String str = b(paramContext, "tmp");
    return (str != null) ? b(str) : null;
  }
  
  public static String a(Context paramContext, String paramString) throws IOException {
    return (new File(paramContext.getFilesDir(), paramString)).getAbsolutePath();
  }
  
  public static void a(String paramString1, String paramString2) throws IOException {
    File file1 = new File(paramString1);
    File file2 = new File(paramString2);
    if (file2.exists())
      file2.delete(); 
    file1.renameTo(file2);
  }
  
  public static boolean a(String paramString) throws IOException {
    return (new File(paramString)).exists();
  }
  
  public static boolean a(String paramString, int paramInt) throws IOException {
    if (paramInt < 1)
      return false; 
    File file = new File(paramString);
    return (file.exists() && file.length() == paramInt);
  }
  
  public static String b(Context paramContext, String paramString) {
    try {
      return a(paramContext, paramString);
    } catch (IOException iOException) {
      return null;
    } 
  }
  
  public static String b(String paramString) {
    int i = paramString.lastIndexOf("/");
    String str = paramString;
    if (i > -1)
      str = paramString.substring(0, i); 
    return str;
  }
  
  public static boolean b(Context paramContext) {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static String c(Context paramContext) throws IOException {
    return !b(paramContext) ? null : Environment.getExternalStorageDirectory().getPath();
  }
  
  public static String c(Context paramContext, String paramString) throws IOException {
    if (!b(paramContext))
      return a(paramContext, paramString); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    stringBuilder.append("/");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  public static String c(String paramString) {
    int i = paramString.lastIndexOf("/");
    String str = paramString;
    if (i > -1)
      str = paramString.substring(i + 1, paramString.length()); 
    return str;
  }
  
  public static String d(Context paramContext) throws IOException {
    if (!b(paramContext))
      return null; 
    String str = paramContext.getExternalFilesDir(null).getPath();
    return str.substring(0, str.lastIndexOf('/'));
  }
  
  public static void d(String paramString) throws IOException {
    i(b(paramString));
  }
  
  public static void e(String paramString) throws IOException {
    File file = new File(paramString);
    if (file.exists())
      file.delete(); 
  }
  
  public static void f(String paramString) {
    try {
      e(paramString);
    } catch (IOException iOException) {}
  }
  
  public static String[] g(String paramString) throws IOException {
    ArrayList<String> arrayList = new ArrayList();
    File[] arrayOfFile = (new File(paramString)).listFiles();
    if (arrayOfFile != null)
      for (byte b1 = 0; b1 < arrayOfFile.length; b1++)
        arrayList.add(arrayOfFile[b1].getName());  
    return arrayList.<String>toArray(new String[arrayList.size()]);
  }
  
  public static long h(String paramString) throws IOException {
    long l;
    File file = new File(paramString);
    if (file.exists()) {
      l = file.length();
    } else {
      l = 0L;
    } 
    return l;
  }
  
  private static void i(String paramString) throws IOException {
    File file = new File(paramString);
    if (!file.exists())
      file.mkdirs(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */