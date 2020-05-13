package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import android.util.Base64;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.security.mobile.module.b.b;
import java.util.Map;
import java.util.Set;

public final class a {
  private static String a(Context paramContext) {
    String str1;
    b.a();
    Map map = b.q(paramContext);
    String str2 = h.b();
    String str3 = h.a();
    if (str3.length() <= 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str3 + ":");
    if (str2.length() <= 0)
      return stringBuilder.toString(); 
    String[] arrayOfString = str2.split(",");
    if (arrayOfString == null || arrayOfString.length <= 0)
      return stringBuilder.toString(); 
    if (map.size() <= 0)
      return stringBuilder.toString(); 
    Set set = map.keySet();
    if (set == null || set.size() <= 0)
      return stringBuilder.toString(); 
    try {
      byte[] arrayOfByte = new byte[arrayOfString.length / 8 + 1];
      byte b1;
      for (b1 = 0; b1 < arrayOfByte.length; b1++)
        arrayOfByte[b1] = (byte)0; 
      int i = arrayOfString.length;
      b1 = 0;
      byte b2 = 0;
      while (b1 < i) {
        str3 = arrayOfString[b1];
        byte b = arrayOfByte[b2 / 8];
        int j = b;
        if (set.contains(str3))
          j = b | 128 >> b2 % 8; 
        arrayOfByte[b2 / 8] = (byte)(byte)(j & 0xFF);
        b2++;
        b1++;
      } 
      String str = new String();
      this(Base64.encode(arrayOfByte, 2));
      stringBuilder.append(str);
      str1 = stringBuilder.toString();
    } catch (Throwable throwable) {}
    return str1;
  }
  
  public static Map<String, String> a(Context paramContext, Map<String, String> paramMap) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/d/a
    //   2: monitorenter
    //   3: aload_1
    //   4: ldc 'appchannel'
    //   6: ldc ''
    //   8: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_2
    //   12: new java/util/HashMap
    //   15: astore_1
    //   16: aload_1
    //   17: invokespecial <init> : ()V
    //   20: aload_1
    //   21: ldc 'AA1'
    //   23: aload_0
    //   24: invokevirtual getPackageName : ()Ljava/lang/String;
    //   27: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: pop
    //   33: invokestatic a : ()Lcom/alipay/security/mobile/module/b/a;
    //   36: pop
    //   37: aload_1
    //   38: ldc 'AA2'
    //   40: aload_0
    //   41: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   44: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: pop
    //   50: aload_1
    //   51: ldc 'AA3'
    //   53: ldc 'APPSecuritySDK-ALIPAYSDK'
    //   55: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   60: pop
    //   61: aload_1
    //   62: ldc 'AA4'
    //   64: ldc '3.2.2-20180307'
    //   66: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   71: pop
    //   72: aload_1
    //   73: ldc 'AA5'
    //   75: aload_0
    //   76: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   79: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   84: pop
    //   85: aload_1
    //   86: ldc 'AA6'
    //   88: aload_2
    //   89: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: ldc com/alipay/apmobilesecuritysdk/d/a
    //   97: monitorexit
    //   98: aload_1
    //   99: areturn
    //   100: astore_0
    //   101: ldc com/alipay/apmobilesecuritysdk/d/a
    //   103: monitorexit
    //   104: aload_0
    //   105: athrow
    // Exception table:
    //   from	to	target	type
    //   3	95	100	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */