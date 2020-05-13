package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public final class e {
  private static Map<String, String> a = null;
  
  private static final String[] b = new String[] { 
      "AD1", "AD2", "AD3", "AD8", "AD9", "AD10", "AD11", "AD12", "AD14", "AD15", 
      "AD16", "AD18", "AD20", "AD21", "AD23", "AD24", "AD26", "AD27", "AD28", "AD29", 
      "AD30", "AD31", "AD34", "AA1", "AA2", "AA3", "AA4", "AA5", "AC4", "AC10", 
      "AE1", "AE2", "AE3", "AE4", "AE5", "AE6", "AE7", "AE8", "AE9", "AE10", 
      "AE11", "AE12", "AE13", "AE14", "AE15" };
  
  private static String a(Map<String, String> paramMap) {
    StringBuffer stringBuffer = new StringBuffer();
    ArrayList<Comparable> arrayList = new ArrayList(paramMap.keySet());
    Collections.sort(arrayList);
    for (byte b = 0; b < arrayList.size(); b++) {
      String str1 = (String)arrayList.get(b);
      String str2 = paramMap.get(str1);
      String str3 = str2;
      if (str2 == null)
        str3 = ""; 
      StringBuilder stringBuilder = new StringBuilder();
      if (b == 0) {
        str2 = "";
      } else {
        str2 = "&";
      } 
      stringBuffer.append(stringBuilder.append(str2).append(str1).append("=").append(str3).toString());
    } 
    return stringBuffer.toString();
  }
  
  public static Map<String, String> a(Context paramContext, Map<String, String> paramMap) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/d/e
    //   2: monitorenter
    //   3: getstatic com/alipay/apmobilesecuritysdk/d/e.a : Ljava/util/Map;
    //   6: ifnonnull -> 14
    //   9: aload_0
    //   10: aload_1
    //   11: invokestatic c : (Landroid/content/Context;Ljava/util/Map;)V
    //   14: getstatic com/alipay/apmobilesecuritysdk/d/e.a : Ljava/util/Map;
    //   17: invokestatic a : ()Ljava/util/Map;
    //   20: invokeinterface putAll : (Ljava/util/Map;)V
    //   25: getstatic com/alipay/apmobilesecuritysdk/d/e.a : Ljava/util/Map;
    //   28: astore_0
    //   29: ldc com/alipay/apmobilesecuritysdk/d/e
    //   31: monitorexit
    //   32: aload_0
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/alipay/apmobilesecuritysdk/d/e
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   3	14	34	finally
    //   14	29	34	finally
  }
  
  public static void a() {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/d/e
    //   2: monitorenter
    //   3: aconst_null
    //   4: putstatic com/alipay/apmobilesecuritysdk/d/e.a : Ljava/util/Map;
    //   7: ldc com/alipay/apmobilesecuritysdk/d/e
    //   9: monitorexit
    //   10: return
    //   11: astore_0
    //   12: ldc com/alipay/apmobilesecuritysdk/d/e
    //   14: monitorexit
    //   15: aload_0
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	11	finally
  }
  
  public static String b(Context paramContext, Map<String, String> paramMap) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/d/e
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: invokestatic a : (Landroid/content/Context;Ljava/util/Map;)Ljava/util/Map;
    //   8: pop
    //   9: new java/util/TreeMap
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial <init> : ()V
    //   17: getstatic com/alipay/apmobilesecuritysdk/d/e.b : [Ljava/lang/String;
    //   20: astore_1
    //   21: aload_1
    //   22: arraylength
    //   23: istore_2
    //   24: iconst_0
    //   25: istore_3
    //   26: iload_3
    //   27: iload_2
    //   28: if_icmpge -> 74
    //   31: aload_1
    //   32: iload_3
    //   33: aaload
    //   34: astore #4
    //   36: getstatic com/alipay/apmobilesecuritysdk/d/e.a : Ljava/util/Map;
    //   39: aload #4
    //   41: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   46: ifeq -> 68
    //   49: aload_0
    //   50: aload #4
    //   52: getstatic com/alipay/apmobilesecuritysdk/d/e.a : Ljava/util/Map;
    //   55: aload #4
    //   57: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   62: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   67: pop
    //   68: iinc #3, 1
    //   71: goto -> 26
    //   74: aload_0
    //   75: invokestatic a : (Ljava/util/Map;)Ljava/lang/String;
    //   78: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   81: astore_0
    //   82: ldc com/alipay/apmobilesecuritysdk/d/e
    //   84: monitorexit
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: ldc com/alipay/apmobilesecuritysdk/d/e
    //   90: monitorexit
    //   91: aload_0
    //   92: athrow
    // Exception table:
    //   from	to	target	type
    //   3	24	87	finally
    //   36	68	87	finally
    //   74	82	87	finally
  }
  
  private static void c(Context paramContext, Map<String, String> paramMap) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/d/e
    //   2: monitorenter
    //   3: new java/util/TreeMap
    //   6: astore_2
    //   7: aload_2
    //   8: invokespecial <init> : ()V
    //   11: aload_2
    //   12: putstatic com/alipay/apmobilesecuritysdk/d/e.a : Ljava/util/Map;
    //   15: aload_2
    //   16: aload_0
    //   17: aload_1
    //   18: invokestatic a : (Landroid/content/Context;Ljava/util/Map;)Ljava/util/Map;
    //   21: invokeinterface putAll : (Ljava/util/Map;)V
    //   26: getstatic com/alipay/apmobilesecuritysdk/d/e.a : Ljava/util/Map;
    //   29: aload_0
    //   30: invokestatic a : (Landroid/content/Context;)Ljava/util/Map;
    //   33: invokeinterface putAll : (Ljava/util/Map;)V
    //   38: getstatic com/alipay/apmobilesecuritysdk/d/e.a : Ljava/util/Map;
    //   41: aload_0
    //   42: invokestatic a : (Landroid/content/Context;)Ljava/util/Map;
    //   45: invokeinterface putAll : (Ljava/util/Map;)V
    //   50: getstatic com/alipay/apmobilesecuritysdk/d/e.a : Ljava/util/Map;
    //   53: aload_0
    //   54: aload_1
    //   55: invokestatic a : (Landroid/content/Context;Ljava/util/Map;)Ljava/util/Map;
    //   58: invokeinterface putAll : (Ljava/util/Map;)V
    //   63: ldc com/alipay/apmobilesecuritysdk/d/e
    //   65: monitorexit
    //   66: return
    //   67: astore_0
    //   68: ldc com/alipay/apmobilesecuritysdk/d/e
    //   70: monitorexit
    //   71: aload_0
    //   72: athrow
    // Exception table:
    //   from	to	target	type
    //   3	63	67	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */