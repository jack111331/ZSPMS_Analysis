package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class PreferenceUtils {
  public static String a(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'UnionPayPluginEx.pref'
    //   3: iconst_0
    //   4: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 'uid'
    //   11: ldc ''
    //   13: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_2
    //   19: aload_1
    //   20: ldc 'tag1'
    //   22: ldc ''
    //   24: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_3
    //   30: aload_2
    //   31: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   34: ifne -> 132
    //   37: aload_2
    //   38: invokevirtual length : ()I
    //   41: bipush #32
    //   43: if_icmpne -> 102
    //   46: aload_2
    //   47: invokestatic a : (Ljava/lang/String;)Z
    //   50: ifeq -> 96
    //   53: aload_1
    //   54: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   59: astore_3
    //   60: aload_3
    //   61: ldc 'uid'
    //   63: invokeinterface remove : (Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   68: pop
    //   69: aload_3
    //   70: invokeinterface commit : ()Z
    //   75: pop
    //   76: aload_2
    //   77: astore_3
    //   78: aload_2
    //   79: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   82: ifne -> 94
    //   85: aload_0
    //   86: aload_2
    //   87: ldc 'tag1'
    //   89: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_2
    //   93: astore_3
    //   94: aload_3
    //   95: areturn
    //   96: ldc ''
    //   98: astore_2
    //   99: goto -> 53
    //   102: aload_0
    //   103: aload_2
    //   104: invokestatic e : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   107: astore_3
    //   108: aload_3
    //   109: invokevirtual length : ()I
    //   112: bipush #32
    //   114: if_icmpne -> 126
    //   117: aload_3
    //   118: astore_2
    //   119: aload_3
    //   120: invokestatic a : (Ljava/lang/String;)Z
    //   123: ifne -> 53
    //   126: ldc ''
    //   128: astore_2
    //   129: goto -> 53
    //   132: aload_3
    //   133: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   136: ifne -> 148
    //   139: aload_0
    //   140: aload_3
    //   141: invokestatic e : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   144: astore_3
    //   145: goto -> 94
    //   148: ldc ''
    //   150: astore_3
    //   151: goto -> 94
  }
  
  public static String a(Context paramContext, String paramString) {
    return e(paramContext, paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0).getString(paramString, ""));
  }
  
  private static String a(String paramString1, String paramString2) {
    String str;
    try {
      byte[] arrayOfByte = paramString1.getBytes("utf-8");
      str = b.a(e.a(b.a(paramString2), arrayOfByte));
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    String str1 = f.c(paramContext);
    String str2 = (str1 + "23456789abcdef12123456786789abcd").substring(0, 32);
    str1 = a(paramString1 + str1, str2);
    paramString1 = str1;
    if (str1 == null)
      paramString1 = ""; 
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
    editor.putString(paramString2, paramString1);
    editor.commit();
  }
  
  public static String b(Context paramContext) {
    return b(paramContext, "last_pay_method", "tag2");
  }
  
  private static String b(Context paramContext, String paramString1, String paramString2) {
    String str1;
    String str2;
    SharedPreferences.Editor editor2;
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0);
    String str3 = sharedPreferences.getString(paramString1, "");
    String str4 = sharedPreferences.getString(paramString2, "");
    paramString2 = "";
    if (!TextUtils.isEmpty(str3)) {
      str1 = "";
      editor2 = sharedPreferences.edit();
      editor2.remove(paramString1);
      editor2.commit();
      return str1;
    } 
    SharedPreferences.Editor editor1 = editor2;
    if (!TextUtils.isEmpty(str4))
      str2 = e((Context)str1, str4); 
    return str2;
  }
  
  private static String b(String paramString1, String paramString2) {
    String str;
    if (TextUtils.isEmpty(paramString1))
      return ""; 
    try {
      byte[] arrayOfByte = e.b(b.a(paramString2), b.a(paramString1));
      paramString1 = new String();
      this(arrayOfByte, "utf-8");
      paramString1 = paramString1.trim();
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public static void b(Context paramContext, String paramString) {
    a(paramContext, paramString, "tag1");
  }
  
  public static String c(Context paramContext) {
    return b(paramContext, "last_user", "tag3");
  }
  
  public static void c(Context paramContext, String paramString) {
    a(paramContext, paramString, "tag2");
  }
  
  public static void d(Context paramContext, String paramString) {
    a(paramContext, paramString, "tag3");
  }
  
  public static native String decPrefData(String paramString1, String paramString2);
  
  private static String e(Context paramContext, String paramString) {
    null = f.c(paramContext);
    paramString = b(paramString, (null + "23456789abcdef12123456786789abcd").substring(0, 32));
    return (paramString == null) ? "" : (!paramString.endsWith(null) ? "" : paramString.substring(0, paramString.length() - null.length()));
  }
  
  public static native String forConfig(int paramInt, String paramString);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\utils\PreferenceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */