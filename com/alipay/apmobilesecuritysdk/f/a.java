package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import com.alipay.security.mobile.module.a.a.c;
import com.alipay.security.mobile.module.c.e;
import java.util.HashMap;

public class a {
  public static String a(Context paramContext, String paramString1, String paramString2) {
    String str1 = null;
    String str2 = str1;
    if (paramContext != null) {
      str2 = str1;
      if (!com.alipay.security.mobile.module.a.a.a(paramString1)) {
        if (com.alipay.security.mobile.module.a.a.a(paramString2))
          return str1; 
      } else {
        return str2;
      } 
    } else {
      return str2;
    } 
    try {
      String str = e.a(paramContext, paramString1, paramString2, "");
      str2 = str1;
      if (!com.alipay.security.mobile.module.a.a.a(str))
        str2 = c.b(c.a(), str); 
    } catch (Throwable throwable) {
      str2 = str1;
    } 
    return str2;
  }
  
  public static String a(String paramString1, String paramString2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc com/alipay/apmobilesecuritysdk/f/a
    //   4: monitorenter
    //   5: aload_0
    //   6: invokestatic a : (Ljava/lang/String;)Z
    //   9: ifne -> 19
    //   12: aload_1
    //   13: invokestatic a : (Ljava/lang/String;)Z
    //   16: ifeq -> 26
    //   19: ldc com/alipay/apmobilesecuritysdk/f/a
    //   21: monitorexit
    //   22: aload_2
    //   23: astore_0
    //   24: aload_0
    //   25: areturn
    //   26: aload_0
    //   27: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_3
    //   31: aload_3
    //   32: invokestatic a : (Ljava/lang/String;)Z
    //   35: istore #4
    //   37: iload #4
    //   39: ifeq -> 56
    //   42: ldc com/alipay/apmobilesecuritysdk/f/a
    //   44: monitorexit
    //   45: aload_2
    //   46: astore_0
    //   47: goto -> 24
    //   50: astore_0
    //   51: ldc com/alipay/apmobilesecuritysdk/f/a
    //   53: monitorexit
    //   54: aload_0
    //   55: athrow
    //   56: new org/json/JSONObject
    //   59: astore_0
    //   60: aload_0
    //   61: aload_3
    //   62: invokespecial <init> : (Ljava/lang/String;)V
    //   65: aload_0
    //   66: aload_1
    //   67: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   70: astore_0
    //   71: aload_0
    //   72: invokestatic a : (Ljava/lang/String;)Z
    //   75: istore #4
    //   77: iload #4
    //   79: ifeq -> 90
    //   82: ldc com/alipay/apmobilesecuritysdk/f/a
    //   84: monitorexit
    //   85: aload_2
    //   86: astore_0
    //   87: goto -> 24
    //   90: invokestatic a : ()Ljava/lang/String;
    //   93: aload_0
    //   94: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   97: astore_0
    //   98: ldc com/alipay/apmobilesecuritysdk/f/a
    //   100: monitorexit
    //   101: goto -> 24
    //   104: astore_0
    //   105: ldc com/alipay/apmobilesecuritysdk/f/a
    //   107: monitorexit
    //   108: aload_2
    //   109: astore_0
    //   110: goto -> 24
    // Exception table:
    //   from	to	target	type
    //   5	19	50	finally
    //   19	22	50	finally
    //   26	37	104	java/lang/Throwable
    //   26	37	50	finally
    //   42	45	50	finally
    //   56	77	104	java/lang/Throwable
    //   56	77	50	finally
    //   82	85	50	finally
    //   90	98	104	java/lang/Throwable
    //   90	98	50	finally
    //   98	101	50	finally
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    if (!com.alipay.security.mobile.module.a.a.a(paramString1) && !com.alipay.security.mobile.module.a.a.a(paramString2) && paramContext != null)
      try {
        String str = c.a(c.a(), paramString3);
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        this();
        hashMap.put(paramString2, str);
        e.a(paramContext, paramString1, hashMap);
      } catch (Throwable throwable) {} 
  }
  
  public static void a(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/f/a
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic a : (Ljava/lang/String;)Z
    //   7: ifne -> 17
    //   10: aload_1
    //   11: invokestatic a : (Ljava/lang/String;)Z
    //   14: ifeq -> 21
    //   17: ldc com/alipay/apmobilesecuritysdk/f/a
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_3
    //   26: new org/json/JSONObject
    //   29: astore #4
    //   31: aload #4
    //   33: invokespecial <init> : ()V
    //   36: aload_3
    //   37: invokestatic b : (Ljava/lang/String;)Z
    //   40: istore #5
    //   42: iload #5
    //   44: ifeq -> 58
    //   47: new org/json/JSONObject
    //   50: astore #4
    //   52: aload #4
    //   54: aload_3
    //   55: invokespecial <init> : (Ljava/lang/String;)V
    //   58: aload #4
    //   60: aload_1
    //   61: invokestatic a : ()Ljava/lang/String;
    //   64: aload_2
    //   65: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   68: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   71: pop
    //   72: aload #4
    //   74: invokevirtual toString : ()Ljava/lang/String;
    //   77: pop
    //   78: aload_0
    //   79: invokestatic clearProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   82: pop
    //   83: invokestatic a : ()Z
    //   86: ifeq -> 151
    //   89: new java/lang/StringBuilder
    //   92: astore_1
    //   93: aload_1
    //   94: ldc '.SystemConfig'
    //   96: invokespecial <init> : (Ljava/lang/String;)V
    //   99: aload_1
    //   100: getstatic java/io/File.separator : Ljava/lang/String;
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual toString : ()Ljava/lang/String;
    //   113: astore_1
    //   114: invokestatic a : ()Z
    //   117: ifeq -> 151
    //   120: new java/io/File
    //   123: astore_0
    //   124: aload_0
    //   125: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   128: aload_1
    //   129: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   132: aload_0
    //   133: invokevirtual exists : ()Z
    //   136: ifeq -> 151
    //   139: aload_0
    //   140: invokevirtual isFile : ()Z
    //   143: ifeq -> 151
    //   146: aload_0
    //   147: invokevirtual delete : ()Z
    //   150: pop
    //   151: ldc com/alipay/apmobilesecuritysdk/f/a
    //   153: monitorexit
    //   154: goto -> 20
    //   157: astore_0
    //   158: ldc com/alipay/apmobilesecuritysdk/f/a
    //   160: monitorexit
    //   161: aload_0
    //   162: athrow
    //   163: astore #4
    //   165: new org/json/JSONObject
    //   168: dup
    //   169: invokespecial <init> : ()V
    //   172: astore #4
    //   174: goto -> 58
    //   177: astore_0
    //   178: goto -> 151
    //   181: astore_1
    //   182: goto -> 83
    //   185: astore_0
    //   186: goto -> 151
    // Exception table:
    //   from	to	target	type
    //   3	17	157	finally
    //   17	20	157	finally
    //   21	42	177	java/lang/Throwable
    //   21	42	157	finally
    //   47	58	163	java/lang/Exception
    //   47	58	177	java/lang/Throwable
    //   47	58	157	finally
    //   58	78	177	java/lang/Throwable
    //   58	78	157	finally
    //   78	83	181	java/lang/Throwable
    //   78	83	157	finally
    //   83	114	177	java/lang/Throwable
    //   83	114	157	finally
    //   114	151	185	java/lang/Exception
    //   114	151	177	java/lang/Throwable
    //   114	151	157	finally
    //   151	154	157	finally
    //   165	174	177	java/lang/Throwable
    //   165	174	157	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */