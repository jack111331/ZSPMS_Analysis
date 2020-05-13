package com.zz.sdk.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.util.Log;

public class s {
  public static final String a = "zz_sdk";
  
  private static final String b = "zz_sdk";
  
  private static final String c = "/zzsdk/data/sharedpref";
  
  public static int a(String paramString, int paramInt) {
    int i = paramInt;
    if (paramString != null)
      try {
        i = Integer.parseInt(paramString);
      } catch (Exception exception) {
        i = paramInt;
      }  
    return i;
  }
  
  public static SharedPreferences a(Context paramContext) {
    return paramContext.getSharedPreferences("zz_sdk", 0);
  }
  
  public static String a(Context paramContext, String paramString) {
    try {
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (applicationInfo != null && applicationInfo.metaData != null)
        return applicationInfo.metaData.getString(paramString); 
    } catch (Exception exception) {
      Log.d("zz_sdk", "read " + paramString + " error!");
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/s
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic a : (Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   7: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   12: aload_1
    //   13: iload_2
    //   14: invokeinterface putInt : (Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   19: invokeinterface commit : ()Z
    //   24: istore_3
    //   25: ldc com/zz/sdk/i/s
    //   27: monitorexit
    //   28: iload_3
    //   29: ireturn
    //   30: astore_0
    //   31: aload_0
    //   32: invokevirtual printStackTrace : ()V
    //   35: iconst_0
    //   36: istore_3
    //   37: goto -> 25
    //   40: astore_0
    //   41: ldc com/zz/sdk/i/s
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    // Exception table:
    //   from	to	target	type
    //   3	25	30	java/lang/Exception
    //   3	25	40	finally
    //   31	35	40	finally
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/s
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic a : (Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   7: astore_0
    //   8: aload_2
    //   9: ifnonnull -> 45
    //   12: aload_0
    //   13: aload_1
    //   14: invokeinterface contains : (Ljava/lang/String;)Z
    //   19: ifeq -> 76
    //   22: aload_0
    //   23: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   28: aload_1
    //   29: invokeinterface remove : (Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   34: invokeinterface commit : ()Z
    //   39: istore_3
    //   40: ldc com/zz/sdk/i/s
    //   42: monitorexit
    //   43: iload_3
    //   44: ireturn
    //   45: aload_0
    //   46: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   51: aload_1
    //   52: aload_2
    //   53: aload_1
    //   54: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   57: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   62: invokeinterface commit : ()Z
    //   67: istore_3
    //   68: goto -> 40
    //   71: astore_0
    //   72: aload_0
    //   73: invokevirtual printStackTrace : ()V
    //   76: iconst_0
    //   77: istore_3
    //   78: goto -> 40
    //   81: astore_0
    //   82: ldc com/zz/sdk/i/s
    //   84: monitorexit
    //   85: aload_0
    //   86: athrow
    // Exception table:
    //   from	to	target	type
    //   3	8	71	java/lang/Exception
    //   3	8	81	finally
    //   12	40	71	java/lang/Exception
    //   12	40	81	finally
    //   45	68	71	java/lang/Exception
    //   45	68	81	finally
    //   72	76	81	finally
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: iconst_1
    //   1: istore #4
    //   3: ldc com/zz/sdk/i/s
    //   5: monitorenter
    //   6: ldc 'mounted'
    //   8: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   11: invokevirtual equals : (Ljava/lang/Object;)Z
    //   14: istore #5
    //   16: iload #5
    //   18: ifne -> 30
    //   21: iconst_0
    //   22: istore #5
    //   24: ldc com/zz/sdk/i/s
    //   26: monitorexit
    //   27: iload #5
    //   29: ireturn
    //   30: new java/io/File
    //   33: astore #6
    //   35: aload #6
    //   37: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   40: aload_1
    //   41: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   44: aload #6
    //   46: invokevirtual isFile : ()Z
    //   49: ifeq -> 60
    //   52: aload #6
    //   54: invokevirtual delete : ()Z
    //   57: ifeq -> 21
    //   60: aload #6
    //   62: invokevirtual exists : ()Z
    //   65: ifeq -> 76
    //   68: aload #6
    //   70: invokevirtual isFile : ()Z
    //   73: ifeq -> 84
    //   76: aload #6
    //   78: invokevirtual mkdirs : ()Z
    //   81: ifeq -> 21
    //   84: new java/io/File
    //   87: astore_0
    //   88: aload_0
    //   89: aload #6
    //   91: iconst_1
    //   92: anewarray [B
    //   95: dup
    //   96: iconst_0
    //   97: aload_2
    //   98: invokevirtual getBytes : ()[B
    //   101: aastore
    //   102: invokestatic a : ([[B)Ljava/lang/String;
    //   105: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   108: aload_0
    //   109: invokevirtual exists : ()Z
    //   112: ifeq -> 120
    //   115: aload_0
    //   116: invokevirtual delete : ()Z
    //   119: pop
    //   120: iload #4
    //   122: istore #5
    //   124: aload_3
    //   125: ifnull -> 24
    //   128: new java/io/FileOutputStream
    //   131: astore_1
    //   132: aload_1
    //   133: aload_0
    //   134: invokespecial <init> : (Ljava/io/File;)V
    //   137: aload_1
    //   138: aload_3
    //   139: aload_2
    //   140: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   143: invokevirtual getBytes : ()[B
    //   146: invokevirtual write : ([B)V
    //   149: aload_1
    //   150: invokevirtual close : ()V
    //   153: iload #4
    //   155: istore #5
    //   157: goto -> 24
    //   160: astore_0
    //   161: aload_0
    //   162: invokevirtual printStackTrace : ()V
    //   165: goto -> 21
    //   168: astore_0
    //   169: ldc com/zz/sdk/i/s
    //   171: monitorexit
    //   172: aload_0
    //   173: athrow
    // Exception table:
    //   from	to	target	type
    //   6	16	168	finally
    //   30	60	168	finally
    //   60	76	168	finally
    //   76	84	168	finally
    //   84	120	168	finally
    //   128	153	160	java/lang/Exception
    //   128	153	168	finally
    //   161	165	168	finally
  }
  
  public static int b(Context paramContext, String paramString, int paramInt) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/s
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic a : (Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   7: aload_1
    //   8: iload_2
    //   9: invokeinterface getInt : (Ljava/lang/String;I)I
    //   14: istore_3
    //   15: iload_3
    //   16: istore_2
    //   17: ldc com/zz/sdk/i/s
    //   19: monitorexit
    //   20: iload_2
    //   21: ireturn
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual printStackTrace : ()V
    //   27: goto -> 17
    //   30: astore_0
    //   31: ldc com/zz/sdk/i/s
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	15	22	java/lang/Exception
    //   3	15	30	finally
    //   23	27	30	finally
  }
  
  public static String b(Context paramContext, String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc com/zz/sdk/i/s
    //   4: monitorenter
    //   5: aload_0
    //   6: invokestatic a : (Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   9: aload_1
    //   10: aconst_null
    //   11: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnonnull -> 28
    //   21: aload_2
    //   22: astore_0
    //   23: ldc com/zz/sdk/i/s
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_0
    //   34: goto -> 23
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual printStackTrace : ()V
    //   42: aload_2
    //   43: astore_0
    //   44: goto -> 23
    //   47: astore_0
    //   48: ldc com/zz/sdk/i/s
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   5	17	37	java/lang/Exception
    //   5	17	47	finally
    //   28	34	37	java/lang/Exception
    //   28	34	47	finally
    //   38	42	47	finally
  }
  
  public static boolean b(Context paramContext) {
    return d(paramContext, "android.permission.SEND_SMS");
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2) {
    return a(paramContext, "/zzsdk/data/sharedpref", paramString1, paramString2);
  }
  
  public static String c(Context paramContext, String paramString) {
    return c(paramContext, "/zzsdk/data/sharedpref", paramString);
  }
  
  public static String c(Context paramContext, String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/s
    //   2: monitorenter
    //   3: new java/io/File
    //   6: astore_0
    //   7: aload_0
    //   8: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   11: aload_1
    //   12: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   15: new java/io/File
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: iconst_1
    //   22: anewarray [B
    //   25: dup
    //   26: iconst_0
    //   27: aload_2
    //   28: invokevirtual getBytes : ()[B
    //   31: aastore
    //   32: invokestatic a : ([[B)Ljava/lang/String;
    //   35: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   38: aload_1
    //   39: invokevirtual exists : ()Z
    //   42: ifeq -> 180
    //   45: aload_1
    //   46: invokevirtual isFile : ()Z
    //   49: ifeq -> 180
    //   52: aload_1
    //   53: invokevirtual canRead : ()Z
    //   56: ifeq -> 180
    //   59: aload_1
    //   60: invokevirtual length : ()J
    //   63: lstore_3
    //   64: lload_3
    //   65: ldc2_w 2097152
    //   68: lcmp
    //   69: ifge -> 180
    //   72: aload_1
    //   73: invokevirtual length : ()J
    //   76: l2i
    //   77: newarray byte
    //   79: astore_0
    //   80: new java/io/FileInputStream
    //   83: astore #5
    //   85: aload #5
    //   87: aload_1
    //   88: invokespecial <init> : (Ljava/io/File;)V
    //   91: aload #5
    //   93: aload_0
    //   94: iconst_0
    //   95: aload_0
    //   96: arraylength
    //   97: invokevirtual read : ([BII)I
    //   100: istore #6
    //   102: iload #6
    //   104: aload_0
    //   105: arraylength
    //   106: if_icmpeq -> 177
    //   109: iload #6
    //   111: newarray byte
    //   113: astore_1
    //   114: aload_0
    //   115: iconst_0
    //   116: aload_1
    //   117: iconst_0
    //   118: iload #6
    //   120: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   123: aload_1
    //   124: astore_0
    //   125: new java/lang/String
    //   128: astore_1
    //   129: aload_1
    //   130: aload_0
    //   131: invokespecial <init> : ([B)V
    //   134: new java/lang/String
    //   137: astore_0
    //   138: aload_0
    //   139: aload_1
    //   140: aload_2
    //   141: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   144: invokespecial <init> : (Ljava/lang/String;)V
    //   147: aload #5
    //   149: invokevirtual close : ()V
    //   152: ldc com/zz/sdk/i/s
    //   154: monitorexit
    //   155: aload_0
    //   156: areturn
    //   157: astore_1
    //   158: aconst_null
    //   159: astore_0
    //   160: aload_1
    //   161: invokevirtual printStackTrace : ()V
    //   164: goto -> 152
    //   167: astore_0
    //   168: ldc com/zz/sdk/i/s
    //   170: monitorexit
    //   171: aload_0
    //   172: athrow
    //   173: astore_1
    //   174: goto -> 160
    //   177: goto -> 125
    //   180: aconst_null
    //   181: astore_0
    //   182: goto -> 152
    // Exception table:
    //   from	to	target	type
    //   3	64	167	finally
    //   72	123	157	java/lang/Exception
    //   72	123	167	finally
    //   125	147	157	java/lang/Exception
    //   125	147	167	finally
    //   147	152	173	java/lang/Exception
    //   147	152	167	finally
    //   160	164	167	finally
  }
  
  public static boolean c(Context paramContext) {
    return d(paramContext, "android.permission.RECEIVE_SMS");
  }
  
  public static boolean d(Context paramContext, String paramString) {
    try {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      if (i == 0)
        return true; 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */