package org.jar.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import java.io.File;

public class ContextCompat {
  private static final String DIR_ANDROID = "Android";
  
  private static final String DIR_CACHE = "cache";
  
  private static final String DIR_DATA = "data";
  
  private static final String DIR_FILES = "files";
  
  private static final String DIR_OBB = "obb";
  
  private static final String TAG = "ContextCompat";
  
  private static File buildPath(File paramFile, String... paramVarArgs) {
    int i = paramVarArgs.length;
    byte b = 0;
    File file;
    for (file = paramFile; b < i; file = paramFile) {
      String str = paramVarArgs[b];
      if (file == null) {
        paramFile = new File(str);
      } else {
        paramFile = file;
        if (str != null)
          paramFile = new File(file, str); 
      } 
      b++;
    } 
    return file;
  }
  
  public static int checkSelfPermission(Context paramContext, String paramString) {
    if (paramString != null)
      return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()); 
    throw new IllegalArgumentException("permission is null");
  }
  
  private static File createFilesDir(File paramFile) {
    // Byte code:
    //   0: ldc org/jar/support/v4/content/ContextCompat
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual exists : ()Z
    //   7: ifne -> 70
    //   10: aload_0
    //   11: invokevirtual mkdirs : ()Z
    //   14: ifne -> 70
    //   17: aload_0
    //   18: invokevirtual exists : ()Z
    //   21: istore_1
    //   22: iload_1
    //   23: ifeq -> 31
    //   26: ldc org/jar/support/v4/content/ContextCompat
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: new java/lang/StringBuilder
    //   34: astore_2
    //   35: aload_2
    //   36: invokespecial <init> : ()V
    //   39: aload_2
    //   40: ldc 'Unable to create files subdir '
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_2
    //   47: aload_0
    //   48: invokevirtual getPath : ()Ljava/lang/String;
    //   51: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: ldc 'ContextCompat'
    //   57: aload_2
    //   58: invokevirtual toString : ()Ljava/lang/String;
    //   61: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   64: pop
    //   65: ldc org/jar/support/v4/content/ContextCompat
    //   67: monitorexit
    //   68: aconst_null
    //   69: areturn
    //   70: ldc org/jar/support/v4/content/ContextCompat
    //   72: monitorexit
    //   73: aload_0
    //   74: areturn
    //   75: astore_0
    //   76: ldc org/jar/support/v4/content/ContextCompat
    //   78: monitorexit
    //   79: aload_0
    //   80: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	75	finally
    //   31	65	75	finally
  }
  
  public static File getCodeCacheDir(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 21) ? ContextCompatApi21.getCodeCacheDir(paramContext) : createFilesDir(new File((paramContext.getApplicationInfo()).dataDir, "code_cache"));
  }
  
  public static final int getColor(Context paramContext, int paramInt) {
    return (Build.VERSION.SDK_INT >= 23) ? ContextCompatApi23.getColor(paramContext, paramInt) : paramContext.getResources().getColor(paramInt);
  }
  
  public static final ColorStateList getColorStateList(Context paramContext, int paramInt) {
    return (Build.VERSION.SDK_INT >= 23) ? ContextCompatApi23.getColorStateList(paramContext, paramInt) : paramContext.getResources().getColorStateList(paramInt);
  }
  
  public static final Drawable getDrawable(Context paramContext, int paramInt) {
    return (Build.VERSION.SDK_INT >= 21) ? ContextCompatApi21.getDrawable(paramContext, paramInt) : paramContext.getResources().getDrawable(paramInt);
  }
  
  public static File[] getExternalCacheDirs(Context paramContext) {
    File file;
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
      return ContextCompatKitKat.getExternalCacheDirs(paramContext); 
    if (i >= 8) {
      file = ContextCompatFroyo.getExternalCacheDir(paramContext);
    } else {
      file = buildPath(Environment.getExternalStorageDirectory(), new String[] { "Android", "data", file.getPackageName(), "cache" });
    } 
    return new File[] { file };
  }
  
  public static File[] getExternalFilesDirs(Context paramContext, String paramString) {
    File file;
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
      return ContextCompatKitKat.getExternalFilesDirs(paramContext, paramString); 
    if (i >= 8) {
      file = ContextCompatFroyo.getExternalFilesDir(paramContext, paramString);
    } else {
      file = buildPath(Environment.getExternalStorageDirectory(), new String[] { "Android", "data", file.getPackageName(), "files", paramString });
    } 
    return new File[] { file };
  }
  
  public static File[] getObbDirs(Context paramContext) {
    File file;
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
      return ContextCompatKitKat.getObbDirs(paramContext); 
    if (i >= 11) {
      file = ContextCompatHoneycomb.getObbDir(paramContext);
    } else {
      file = buildPath(Environment.getExternalStorageDirectory(), new String[] { "Android", "obb", file.getPackageName() });
    } 
    return new File[] { file };
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent) {
    return startActivities(paramContext, paramArrayOfIntent, null);
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle) {
    int i = Build.VERSION.SDK_INT;
    if (i >= 16) {
      ContextCompatJellybean.startActivities(paramContext, paramArrayOfIntent, paramBundle);
      return true;
    } 
    if (i >= 11) {
      ContextCompatHoneycomb.startActivities(paramContext, paramArrayOfIntent);
      return true;
    } 
    return false;
  }
  
  public final File getNoBackupFilesDir(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 21) ? ContextCompatApi21.getNoBackupFilesDir(paramContext) : createFilesDir(new File((paramContext.getApplicationInfo()).dataDir, "no_backup"));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\content\ContextCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */