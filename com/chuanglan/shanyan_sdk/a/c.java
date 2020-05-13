package com.chuanglan.shanyan_sdk.a;

import android.content.Context;
import android.os.Environment;
import java.io.File;

class c {
  private static final String a = "ulucu_huidian";
  
  private static final String b = "database";
  
  private static Context c;
  
  private static File d = null;
  
  private static final String e = File.separator;
  
  public static File a() {
    if (d == null)
      d = a(c, b() + e + "database"); 
    return d;
  }
  
  private static File a(Context paramContext, String paramString) {
    File file;
    if (!Environment.getExternalStorageState().equals("mounted")) {
      file = new File(paramContext.getCacheDir(), paramString);
    } else {
      file = new File(Environment.getExternalStorageDirectory(), paramString);
    } 
    if (!file.exists())
      file.mkdirs(); 
    return file;
  }
  
  public static File a(File paramFile, String paramString) {
    File file = new File(paramFile, paramString);
    try {
      if (!file.exists())
        file.createNewFile(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return file;
  }
  
  public static void a(Context paramContext) {
    c = paramContext;
  }
  
  private static String b() {
    return (c != null) ? "chuanglan" : "ulucu_huidian";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */