package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public final class i {
  private static String a = "";
  
  private static String b = "";
  
  private static String c = "";
  
  private static String d = "";
  
  private static String e = "";
  
  private static Map<String, String> f = new HashMap<String, String>();
  
  public static String a(String paramString) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: astore_1
    //   7: aload_1
    //   8: ldc 'apdidTokenCache'
    //   10: invokespecial <init> : (Ljava/lang/String;)V
    //   13: aload_1
    //   14: aload_0
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual toString : ()Ljava/lang/String;
    //   21: astore_0
    //   22: getstatic com/alipay/apmobilesecuritysdk/e/i.f : Ljava/util/Map;
    //   25: aload_0
    //   26: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   31: ifeq -> 61
    //   34: getstatic com/alipay/apmobilesecuritysdk/e/i.f : Ljava/util/Map;
    //   37: aload_0
    //   38: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast java/lang/String
    //   46: astore_0
    //   47: aload_0
    //   48: invokestatic b : (Ljava/lang/String;)Z
    //   51: istore_2
    //   52: iload_2
    //   53: ifeq -> 61
    //   56: ldc com/alipay/apmobilesecuritysdk/e/i
    //   58: monitorexit
    //   59: aload_0
    //   60: areturn
    //   61: ldc ''
    //   63: astore_0
    //   64: goto -> 56
    //   67: astore_0
    //   68: ldc com/alipay/apmobilesecuritysdk/e/i
    //   70: monitorexit
    //   71: aload_0
    //   72: athrow
    // Exception table:
    //   from	to	target	type
    //   3	52	67	finally
  }
  
  public static void a() {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/i}} */
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/i}} */
  }
  
  public static void a(b paramb) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 28
    //   7: aload_0
    //   8: invokevirtual a : ()Ljava/lang/String;
    //   11: putstatic com/alipay/apmobilesecuritysdk/e/i.a : Ljava/lang/String;
    //   14: aload_0
    //   15: invokevirtual b : ()Ljava/lang/String;
    //   18: putstatic com/alipay/apmobilesecuritysdk/e/i.b : Ljava/lang/String;
    //   21: aload_0
    //   22: invokevirtual c : ()Ljava/lang/String;
    //   25: putstatic com/alipay/apmobilesecuritysdk/e/i.c : Ljava/lang/String;
    //   28: ldc com/alipay/apmobilesecuritysdk/e/i
    //   30: monitorexit
    //   31: return
    //   32: astore_0
    //   33: ldc com/alipay/apmobilesecuritysdk/e/i
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   7	28	32	finally
  }
  
  public static void a(c paramc) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 42
    //   7: aload_0
    //   8: invokevirtual a : ()Ljava/lang/String;
    //   11: putstatic com/alipay/apmobilesecuritysdk/e/i.a : Ljava/lang/String;
    //   14: aload_0
    //   15: invokevirtual b : ()Ljava/lang/String;
    //   18: putstatic com/alipay/apmobilesecuritysdk/e/i.b : Ljava/lang/String;
    //   21: aload_0
    //   22: invokevirtual d : ()Ljava/lang/String;
    //   25: putstatic com/alipay/apmobilesecuritysdk/e/i.d : Ljava/lang/String;
    //   28: aload_0
    //   29: invokevirtual e : ()Ljava/lang/String;
    //   32: putstatic com/alipay/apmobilesecuritysdk/e/i.e : Ljava/lang/String;
    //   35: aload_0
    //   36: invokevirtual c : ()Ljava/lang/String;
    //   39: putstatic com/alipay/apmobilesecuritysdk/e/i.c : Ljava/lang/String;
    //   42: ldc com/alipay/apmobilesecuritysdk/e/i
    //   44: monitorexit
    //   45: return
    //   46: astore_0
    //   47: ldc com/alipay/apmobilesecuritysdk/e/i
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   7	42	46	finally
  }
  
  public static void a(String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: astore_2
    //   7: aload_2
    //   8: ldc 'apdidTokenCache'
    //   10: invokespecial <init> : (Ljava/lang/String;)V
    //   13: aload_2
    //   14: aload_0
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual toString : ()Ljava/lang/String;
    //   21: astore_0
    //   22: getstatic com/alipay/apmobilesecuritysdk/e/i.f : Ljava/util/Map;
    //   25: aload_0
    //   26: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   31: ifeq -> 44
    //   34: getstatic com/alipay/apmobilesecuritysdk/e/i.f : Ljava/util/Map;
    //   37: aload_0
    //   38: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   43: pop
    //   44: getstatic com/alipay/apmobilesecuritysdk/e/i.f : Ljava/util/Map;
    //   47: aload_0
    //   48: aload_1
    //   49: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: ldc com/alipay/apmobilesecuritysdk/e/i
    //   57: monitorexit
    //   58: return
    //   59: astore_0
    //   60: ldc com/alipay/apmobilesecuritysdk/e/i
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    // Exception table:
    //   from	to	target	type
    //   3	44	59	finally
    //   44	55	59	finally
  }
  
  public static boolean a(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc2_w 86400000
    //   3: lstore_2
    //   4: ldc com/alipay/apmobilesecuritysdk/e/i
    //   6: monitorenter
    //   7: aload_0
    //   8: invokestatic a : (Landroid/content/Context;)J
    //   11: lstore #4
    //   13: lload #4
    //   15: lconst_0
    //   16: lcmp
    //   17: ifge -> 77
    //   20: lload_2
    //   21: lstore #4
    //   23: invokestatic currentTimeMillis : ()J
    //   26: aload_0
    //   27: aload_1
    //   28: invokestatic h : (Landroid/content/Context;Ljava/lang/String;)J
    //   31: lsub
    //   32: invokestatic abs : (J)J
    //   35: lstore_2
    //   36: lload_2
    //   37: lload #4
    //   39: lcmp
    //   40: ifge -> 57
    //   43: iconst_1
    //   44: istore #6
    //   46: ldc com/alipay/apmobilesecuritysdk/e/i
    //   48: monitorexit
    //   49: iload #6
    //   51: ireturn
    //   52: astore_0
    //   53: aload_0
    //   54: invokestatic a : (Ljava/lang/Throwable;)V
    //   57: iconst_0
    //   58: istore #6
    //   60: goto -> 46
    //   63: astore #7
    //   65: lload_2
    //   66: lstore #4
    //   68: goto -> 23
    //   71: astore_0
    //   72: ldc com/alipay/apmobilesecuritysdk/e/i
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    //   77: goto -> 23
    // Exception table:
    //   from	to	target	type
    //   7	13	63	java/lang/Throwable
    //   7	13	71	finally
    //   23	36	52	java/lang/Throwable
    //   23	36	71	finally
    //   53	57	71	finally
  }
  
  public static String b() {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: getstatic com/alipay/apmobilesecuritysdk/e/i.a : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/alipay/apmobilesecuritysdk/e/i
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/alipay/apmobilesecuritysdk/e/i
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static void b(String paramString) {
    a = paramString;
  }
  
  public static String c() {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: getstatic com/alipay/apmobilesecuritysdk/e/i.b : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/alipay/apmobilesecuritysdk/e/i
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/alipay/apmobilesecuritysdk/e/i
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static void c(String paramString) {
    b = paramString;
  }
  
  public static String d() {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: getstatic com/alipay/apmobilesecuritysdk/e/i.d : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/alipay/apmobilesecuritysdk/e/i
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/alipay/apmobilesecuritysdk/e/i
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static void d(String paramString) {
    c = paramString;
  }
  
  public static String e() {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: getstatic com/alipay/apmobilesecuritysdk/e/i.e : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/alipay/apmobilesecuritysdk/e/i
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/alipay/apmobilesecuritysdk/e/i
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static void e(String paramString) {
    d = paramString;
  }
  
  public static String f() {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: getstatic com/alipay/apmobilesecuritysdk/e/i.c : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/alipay/apmobilesecuritysdk/e/i
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/alipay/apmobilesecuritysdk/e/i
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static void f(String paramString) {
    e = paramString;
  }
  
  public static c g() {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/i
    //   2: monitorenter
    //   3: new com/alipay/apmobilesecuritysdk/e/c
    //   6: dup
    //   7: getstatic com/alipay/apmobilesecuritysdk/e/i.a : Ljava/lang/String;
    //   10: getstatic com/alipay/apmobilesecuritysdk/e/i.b : Ljava/lang/String;
    //   13: getstatic com/alipay/apmobilesecuritysdk/e/i.c : Ljava/lang/String;
    //   16: getstatic com/alipay/apmobilesecuritysdk/e/i.d : Ljava/lang/String;
    //   19: getstatic com/alipay/apmobilesecuritysdk/e/i.e : Ljava/lang/String;
    //   22: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   25: astore_0
    //   26: ldc com/alipay/apmobilesecuritysdk/e/i
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: ldc com/alipay/apmobilesecuritysdk/e/i
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	26	31	finally
  }
  
  public static void h() {
    f.clear();
    a = "";
    b = "";
    d = "";
    e = "";
    c = "";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\e\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */