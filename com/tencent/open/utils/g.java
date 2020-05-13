package com.tencent.open.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.open.a.f;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

public class g {
  public static int a(String paramString) {
    return "shareToQQ".equals(paramString) ? 10103 : ("shareToQzone".equals(paramString) ? 10104 : ("addToQQFavorites".equals(paramString) ? 10105 : ("sendToMyComputer".equals(paramString) ? 10106 : ("shareToTroopBar".equals(paramString) ? 10107 : ("action_login".equals(paramString) ? 11101 : ("action_request".equals(paramString) ? 10100 : -1))))));
  }
  
  public static int a(String paramString1, String paramString2) {
    int i = 0;
    if (paramString1 != null || paramString2 != null) {
      if (paramString1 != null && paramString2 == null)
        return 1; 
      if (paramString1 == null && paramString2 != null)
        return -1; 
      String[] arrayOfString1 = paramString1.split("\\.");
      String[] arrayOfString2 = paramString2.split("\\.");
      byte b = 0;
      try {
        while (b < arrayOfString1.length && b < arrayOfString2.length) {
          int k = Integer.parseInt(arrayOfString1[b]);
          int m = Integer.parseInt(arrayOfString2[b]);
          if (k < m)
            return -1; 
          if (k > m)
            return 1; 
          b++;
        } 
        if (arrayOfString1.length > b)
          return 1; 
        int j = arrayOfString2.length;
        if (j > b)
          i = -1; 
      } catch (NumberFormatException numberFormatException) {
        i = paramString1.compareTo(paramString2);
      } 
    } 
    return i;
  }
  
  private static long a(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    long l = 0L;
    byte[] arrayOfByte = new byte[8192];
    while (true) {
      int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i != -1) {
        paramOutputStream.write(arrayOfByte, 0, i);
        l += i;
        continue;
      } 
      f.c("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + l);
      return l;
    } 
  }
  
  public static String a(int paramInt) {
    return (paramInt == 10103) ? "shareToQQ" : ((paramInt == 10104) ? "shareToQzone" : ((paramInt == 10105) ? "addToQQFavorites" : ((paramInt == 10106) ? "sendToMyComputer" : ((paramInt == 10107) ? "shareToTroopBar" : ((paramInt == 11101) ? "action_login" : ((paramInt == 10100) ? "action_request" : null))))));
  }
  
  public static String a(Context paramContext) {
    return paramContext.getApplicationInfo().loadLabel(paramContext.getPackageManager()).toString();
  }
  
  public static String a(Context paramContext, String paramString) {
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      String str = (packageManager.getPackageInfo(paramString, 0)).versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException = null;
    } 
    return (String)nameNotFoundException;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramContext != null) {
      if (paramIntent == null)
        return bool1; 
    } else {
      return bool2;
    } 
    bool2 = bool1;
    if (paramContext.getPackageManager().queryIntentActivities(paramIntent, 0).size() != 0)
      bool2 = true; 
    return bool2;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2) {
    boolean bool2;
    boolean bool1 = false;
    f.a("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramString1, 64);
      Signature[] arrayOfSignature = packageInfo.signatures;
      int i = arrayOfSignature.length;
      for (byte b = 0;; b++) {
        bool2 = bool1;
        if (b < i) {
          if (i.f(arrayOfSignature[b].toCharsString()).equals(paramString2))
            return true; 
        } else {
          return bool2;
        } 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      bool2 = bool1;
    } 
    return bool2;
  }
  
  @SuppressLint({"SdCardPath"})
  public static boolean a(String paramString1, String paramString2, int paramInt) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: aconst_null
    //   6: astore #5
    //   8: aconst_null
    //   9: astore #6
    //   11: iconst_0
    //   12: istore #7
    //   14: ldc 'openSDK_LOG.SystemUtils'
    //   16: new java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: ldc '-->extractSecureLib, libName: '
    //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual toString : ()Ljava/lang/String;
    //   35: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   38: invokestatic a : ()Landroid/content/Context;
    //   41: astore #8
    //   43: aload #8
    //   45: ifnonnull -> 62
    //   48: ldc 'openSDK_LOG.SystemUtils'
    //   50: ldc '-->extractSecureLib, global context is null. '
    //   52: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   55: iload #7
    //   57: istore #9
    //   59: iload #9
    //   61: ireturn
    //   62: aload #8
    //   64: ldc 'secure_lib'
    //   66: iconst_0
    //   67: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   70: astore #10
    //   72: new java/io/File
    //   75: dup
    //   76: aload #8
    //   78: invokevirtual getFilesDir : ()Ljava/io/File;
    //   81: aload_1
    //   82: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   85: astore #11
    //   87: aload #11
    //   89: invokevirtual exists : ()Z
    //   92: ifne -> 249
    //   95: aload #11
    //   97: invokevirtual getParentFile : ()Ljava/io/File;
    //   100: astore #12
    //   102: aload #12
    //   104: ifnull -> 121
    //   107: aload #12
    //   109: invokevirtual mkdirs : ()Z
    //   112: ifeq -> 121
    //   115: aload #11
    //   117: invokevirtual createNewFile : ()Z
    //   120: pop
    //   121: aload #8
    //   123: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   126: aload_0
    //   127: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   130: astore_0
    //   131: aload_0
    //   132: astore_3
    //   133: aload #4
    //   135: astore_0
    //   136: aload_3
    //   137: astore #4
    //   139: aload #5
    //   141: astore #6
    //   143: aload #8
    //   145: aload_1
    //   146: iconst_0
    //   147: invokevirtual openFileOutput : (Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   150: astore_1
    //   151: aload_1
    //   152: astore_0
    //   153: aload_3
    //   154: astore #4
    //   156: aload_1
    //   157: astore #6
    //   159: aload_3
    //   160: aload_1
    //   161: invokestatic a : (Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   164: pop2
    //   165: aload_1
    //   166: astore_0
    //   167: aload_3
    //   168: astore #4
    //   170: aload_1
    //   171: astore #6
    //   173: aload #10
    //   175: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   180: astore #5
    //   182: aload_1
    //   183: astore_0
    //   184: aload_3
    //   185: astore #4
    //   187: aload_1
    //   188: astore #6
    //   190: aload #5
    //   192: ldc 'version'
    //   194: iload_2
    //   195: invokeinterface putInt : (Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   200: pop
    //   201: aload_1
    //   202: astore_0
    //   203: aload_3
    //   204: astore #4
    //   206: aload_1
    //   207: astore #6
    //   209: aload #5
    //   211: invokeinterface commit : ()Z
    //   216: pop
    //   217: aload_3
    //   218: ifnull -> 225
    //   221: aload_3
    //   222: invokevirtual close : ()V
    //   225: aload_1
    //   226: ifnull -> 233
    //   229: aload_1
    //   230: invokevirtual close : ()V
    //   233: iconst_1
    //   234: istore #9
    //   236: goto -> 59
    //   239: astore #11
    //   241: aload #11
    //   243: invokevirtual printStackTrace : ()V
    //   246: goto -> 121
    //   249: aload #10
    //   251: ldc 'version'
    //   253: iconst_0
    //   254: invokeinterface getInt : (Ljava/lang/String;I)I
    //   259: istore #13
    //   261: ldc 'openSDK_LOG.SystemUtils'
    //   263: new java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial <init> : ()V
    //   270: ldc '-->extractSecureLib, libVersion: '
    //   272: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: iload_2
    //   276: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   279: ldc ' | oldVersion: '
    //   281: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: iload #13
    //   286: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   289: invokevirtual toString : ()Ljava/lang/String;
    //   292: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   295: iload_2
    //   296: iload #13
    //   298: if_icmpne -> 121
    //   301: iconst_1
    //   302: istore #9
    //   304: goto -> 59
    //   307: astore_1
    //   308: aconst_null
    //   309: astore_3
    //   310: aload #6
    //   312: astore_0
    //   313: aload_3
    //   314: astore #4
    //   316: ldc 'openSDK_LOG.SystemUtils'
    //   318: ldc '-->extractSecureLib, when copy lib execption.'
    //   320: aload_1
    //   321: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   324: aload_3
    //   325: ifnull -> 332
    //   328: aload_3
    //   329: invokevirtual close : ()V
    //   332: iload #7
    //   334: istore #9
    //   336: aload #6
    //   338: ifnull -> 59
    //   341: aload #6
    //   343: invokevirtual close : ()V
    //   346: iload #7
    //   348: istore #9
    //   350: goto -> 59
    //   353: astore_0
    //   354: iload #7
    //   356: istore #9
    //   358: goto -> 59
    //   361: astore_1
    //   362: aconst_null
    //   363: astore #4
    //   365: aload_3
    //   366: astore_0
    //   367: aload #4
    //   369: ifnull -> 377
    //   372: aload #4
    //   374: invokevirtual close : ()V
    //   377: aload_0
    //   378: ifnull -> 385
    //   381: aload_0
    //   382: invokevirtual close : ()V
    //   385: aload_1
    //   386: athrow
    //   387: astore_0
    //   388: goto -> 225
    //   391: astore_0
    //   392: goto -> 233
    //   395: astore_0
    //   396: goto -> 332
    //   399: astore #4
    //   401: goto -> 377
    //   404: astore_0
    //   405: goto -> 385
    //   408: astore_1
    //   409: goto -> 367
    //   412: astore_1
    //   413: goto -> 310
    // Exception table:
    //   from	to	target	type
    //   115	121	239	java/io/IOException
    //   121	131	307	java/lang/Exception
    //   121	131	361	finally
    //   143	151	412	java/lang/Exception
    //   143	151	408	finally
    //   159	165	412	java/lang/Exception
    //   159	165	408	finally
    //   173	182	412	java/lang/Exception
    //   173	182	408	finally
    //   190	201	412	java/lang/Exception
    //   190	201	408	finally
    //   209	217	412	java/lang/Exception
    //   209	217	408	finally
    //   221	225	387	java/io/IOException
    //   229	233	391	java/io/IOException
    //   316	324	408	finally
    //   328	332	395	java/io/IOException
    //   341	346	353	java/io/IOException
    //   372	377	399	java/io/IOException
    //   381	385	404	java/io/IOException
  }
  
  public static String b(Context paramContext, String paramString) {
    String str;
    f.a("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
    try {
      String str1 = paramContext.getPackageName();
      Signature[] arrayOfSignature = (paramContext.getPackageManager().getPackageInfo(str1, 64)).signatures;
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(arrayOfSignature[0].toByteArray());
      str = i.a(messageDigest.digest());
      messageDigest.reset();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      f.a("openSDK_LOG.SystemUtils", stringBuilder.append("-->sign: ").append(str).toString());
      stringBuilder = new StringBuilder();
      this();
      messageDigest.update(i.i(stringBuilder.append(str1).append("_").append(str).append("_").append(paramString).append("").toString()));
      str = i.a(messageDigest.digest());
      try {
        messageDigest.reset();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        f.a("openSDK_LOG.SystemUtils", stringBuilder1.append("-->signEncryped: ").append(str).toString());
        return str;
      } catch (Exception null) {}
    } catch (Exception exception) {
      str = "";
    } 
    exception.printStackTrace();
    f.b("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", exception);
    return str;
  }
  
  public static int c(Context paramContext, String paramString) {
    return a(a(paramContext, "com.tencent.mobileqq"), paramString);
  }
  
  public static int d(Context paramContext, String paramString) {
    return a(a(paramContext, "com.tencent.tim"), paramString);
  }
  
  public static int e(Context paramContext, String paramString) {
    return a(a(paramContext, "com.tencent.qim"), paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\ope\\utils\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */