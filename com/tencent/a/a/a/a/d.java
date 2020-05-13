package com.tencent.a.a.a.a;

import android.content.Context;

final class d extends f {
  public d(Context paramContext) {
    super(paramContext);
  }
  
  protected final boolean a() {
    return true;
  }
  
  protected final String b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'MID'
    //   4: ldc 'read mid from sharedPreferences'
    //   6: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: getfield e : Landroid/content/Context;
    //   14: invokestatic getDefaultSharedPreferences : (Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   17: ldc '4kU71lN96TJUomD1vOU9lgj9Tw=='
    //   19: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   22: aconst_null
    //   23: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   2	31	33	finally
  }
  
  protected final void b(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'MID'
    //   4: ldc 'write mid to sharedPreferences'
    //   6: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: getfield e : Landroid/content/Context;
    //   14: invokestatic getDefaultSharedPreferences : (Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   17: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   22: astore_2
    //   23: aload_2
    //   24: ldc '4kU71lN96TJUomD1vOU9lgj9Tw=='
    //   26: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   29: aload_1
    //   30: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   35: pop
    //   36: aload_2
    //   37: invokeinterface commit : ()Z
    //   42: pop
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Exception table:
    //   from	to	target	type
    //   2	45	46	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\a\a\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */