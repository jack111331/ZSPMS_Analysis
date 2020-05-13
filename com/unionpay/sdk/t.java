package com.unionpay.sdk;

import android.util.Log;
import java.util.HashMap;

class t {
  private static volatile t a = null;
  
  static {
    try {
      ah.a().register(a());
    } catch (Throwable throwable) {}
  }
  
  private t() {
    Thread.setDefaultUncaughtExceptionHandler(new a());
  }
  
  public static t a() {
    // Byte code:
    //   0: getstatic com/unionpay/sdk/t.a : Lcom/unionpay/sdk/t;
    //   3: ifnonnull -> 30
    //   6: ldc com/unionpay/sdk/t
    //   8: monitorenter
    //   9: getstatic com/unionpay/sdk/t.a : Lcom/unionpay/sdk/t;
    //   12: ifnonnull -> 27
    //   15: new com/unionpay/sdk/t
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/unionpay/sdk/t.a : Lcom/unionpay/sdk/t;
    //   27: ldc com/unionpay/sdk/t
    //   29: monitorexit
    //   30: getstatic com/unionpay/sdk/t.a : Lcom/unionpay/sdk/t;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/unionpay/sdk/t
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
  }
  
  private static final String a(Throwable paramThrowable) {
    int i = 50;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramThrowable.toString());
    stringBuilder.append("\r\n");
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    if (arrayOfStackTraceElement.length <= 50)
      i = arrayOfStackTraceElement.length; 
    for (byte b = 0; b < i; b++) {
      stringBuilder.append("\t");
      stringBuilder.append(arrayOfStackTraceElement[b]);
      stringBuilder.append("\r\n");
    } 
    paramThrowable = paramThrowable.getCause();
    if (paramThrowable != null)
      a(stringBuilder, arrayOfStackTraceElement, paramThrowable, 1); 
    return stringBuilder.toString();
  }
  
  private static final void a(StringBuilder paramStringBuilder, StackTraceElement[] paramArrayOfStackTraceElement, Throwable paramThrowable, int paramInt) {
    int i = paramInt;
    while (true) {
      StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
      paramInt = arrayOfStackTraceElement.length;
      int j = paramArrayOfStackTraceElement.length;
      while (paramInt >= 0 && --j >= 0 && arrayOfStackTraceElement[--paramInt].equals(paramArrayOfStackTraceElement[j])) {
        j--;
        paramInt--;
      } 
      j = paramInt;
      if (paramInt > 50)
        j = 50; 
      paramStringBuilder.append("Caused by : ");
      paramStringBuilder.append(paramThrowable);
      paramStringBuilder.append("\r\n");
      for (paramInt = 0; paramInt <= j; paramInt++) {
        paramStringBuilder.append("\t");
        paramStringBuilder.append(arrayOfStackTraceElement[paramInt]);
        paramStringBuilder.append("\r\n");
      } 
      if (i < 5 && paramThrowable.getCause() != null) {
        i++;
        paramArrayOfStackTraceElement = arrayOfStackTraceElement;
        continue;
      } 
      return;
    } 
  }
  
  static final void a(Throwable paramThrowable, String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   5: ifnonnull -> 9
    //   8: return
    //   9: aload_0
    //   10: astore_3
    //   11: aload_3
    //   12: invokevirtual getCause : ()Ljava/lang/Throwable;
    //   15: ifnull -> 26
    //   18: aload_3
    //   19: invokevirtual getCause : ()Ljava/lang/Throwable;
    //   22: astore_3
    //   23: goto -> 11
    //   26: aload_3
    //   27: invokevirtual getStackTrace : ()[Ljava/lang/StackTraceElement;
    //   30: astore #4
    //   32: new java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial <init> : ()V
    //   39: astore #5
    //   41: aload #5
    //   43: aload_3
    //   44: invokevirtual getClass : ()Ljava/lang/Class;
    //   47: invokevirtual getName : ()Ljava/lang/String;
    //   50: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc ':'
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   62: invokevirtual getPackageName : ()Ljava/lang/String;
    //   65: astore_3
    //   66: iconst_0
    //   67: istore #6
    //   69: iload #6
    //   71: iconst_3
    //   72: if_icmpge -> 217
    //   75: iload_2
    //   76: aload #4
    //   78: arraylength
    //   79: if_icmpge -> 217
    //   82: aload #4
    //   84: iload_2
    //   85: aaload
    //   86: invokevirtual getClassName : ()Ljava/lang/String;
    //   89: astore #7
    //   91: aload #7
    //   93: ldc 'java.'
    //   95: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   98: ifeq -> 114
    //   101: iload #6
    //   103: istore #8
    //   105: aload_3
    //   106: ldc 'java.'
    //   108: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   111: ifeq -> 207
    //   114: aload #7
    //   116: ldc 'javax.'
    //   118: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   121: ifeq -> 137
    //   124: iload #6
    //   126: istore #8
    //   128: aload_3
    //   129: ldc 'javax.'
    //   131: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   134: ifeq -> 207
    //   137: aload #7
    //   139: ldc 'android.'
    //   141: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   144: ifeq -> 160
    //   147: iload #6
    //   149: istore #8
    //   151: aload_3
    //   152: ldc 'android.'
    //   154: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   157: ifeq -> 207
    //   160: aload #7
    //   162: ldc 'com.android.'
    //   164: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   167: ifeq -> 183
    //   170: iload #6
    //   172: istore #8
    //   174: aload_3
    //   175: ldc 'com.android.'
    //   177: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   180: ifeq -> 207
    //   183: aload #5
    //   185: aload #4
    //   187: iload_2
    //   188: aaload
    //   189: invokevirtual toString : ()Ljava/lang/String;
    //   192: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc ':'
    //   197: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: iload #6
    //   203: iconst_1
    //   204: iadd
    //   205: istore #8
    //   207: iinc #2, 1
    //   210: iload #8
    //   212: istore #6
    //   214: goto -> 69
    //   217: aload_1
    //   218: invokevirtual trim : ()Ljava/lang/String;
    //   221: invokevirtual isEmpty : ()Z
    //   224: ifeq -> 266
    //   227: invokestatic currentTimeMillis : ()J
    //   230: lstore #9
    //   232: invokestatic d : ()Lcom/unionpay/sdk/bc;
    //   235: invokevirtual a : ()V
    //   238: invokestatic d : ()Lcom/unionpay/sdk/bc;
    //   241: lload #9
    //   243: aload_0
    //   244: invokestatic a : (Ljava/lang/Throwable;)Ljava/lang/String;
    //   247: invokevirtual a : (JLjava/lang/String;)J
    //   250: pop2
    //   251: invokestatic d : ()Lcom/unionpay/sdk/bc;
    //   254: invokevirtual b : ()V
    //   257: invokestatic currentTimeMillis : ()J
    //   260: invokestatic a : (J)V
    //   263: goto -> 8
    //   266: aload_1
    //   267: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   270: invokevirtual longValue : ()J
    //   273: lstore #9
    //   275: goto -> 232
  }
  
  public final void onTDEBEventError(w.a parama) {
    if (parama != null && parama.a != null && Integer.parseInt(String.valueOf(parama.a.get("apiType"))) == 5) {
      parama.a.put("controller", a());
      HashMap hashMap = parama.a;
      try {
        if (hashMap.containsKey("throwable")) {
          if (hashMap.containsKey("occurTime")) {
            a((Throwable)hashMap.get("throwable"), String.valueOf(hashMap.get("occurTime")));
            return;
          } 
          a((Throwable)hashMap.get("throwable"), "");
        } 
      } catch (Throwable throwable) {}
    } 
  }
  
  static final class a implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
    
    public final void uncaughtException(Thread param1Thread, Throwable param1Throwable) {
      if (ab.b) {
        t.a(param1Throwable, String.valueOf(System.currentTimeMillis()));
        Log.w("UPLog", "UncaughtException in Thread " + param1Thread.getName(), param1Throwable);
      } 
      if (this.a != null)
        this.a.uncaughtException(param1Thread, param1Throwable); 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */