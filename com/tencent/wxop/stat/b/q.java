package com.tencent.wxop.stat.b;

import android.content.Context;
import android.content.SharedPreferences;

public final class q {
  private static SharedPreferences db = null;
  
  private static SharedPreferences S(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/wxop/stat/b/q
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc '.mta-wxop'
    //   6: iconst_0
    //   7: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   10: astore_1
    //   11: aload_1
    //   12: putstatic com/tencent/wxop/stat/b/q.db : Landroid/content/SharedPreferences;
    //   15: aload_1
    //   16: ifnonnull -> 26
    //   19: aload_0
    //   20: invokestatic getDefaultSharedPreferences : (Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   23: putstatic com/tencent/wxop/stat/b/q.db : Landroid/content/SharedPreferences;
    //   26: getstatic com/tencent/wxop/stat/b/q.db : Landroid/content/SharedPreferences;
    //   29: astore_0
    //   30: ldc com/tencent/wxop/stat/b/q
    //   32: monitorexit
    //   33: aload_0
    //   34: areturn
    //   35: astore_0
    //   36: ldc com/tencent/wxop/stat/b/q
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   3	15	35	finally
    //   19	26	35	finally
    //   26	30	35	finally
  }
  
  public static int a(Context paramContext, String paramString, int paramInt) {
    paramString = l.e(paramContext, "wxop_" + paramString);
    return S(paramContext).getInt(paramString, paramInt);
  }
  
  public static void a(Context paramContext, String paramString, long paramLong) {
    paramString = l.e(paramContext, "wxop_" + paramString);
    SharedPreferences.Editor editor = S(paramContext).edit();
    editor.putLong(paramString, paramLong);
    editor.commit();
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2) {
    paramString1 = l.e(paramContext, "wxop_" + paramString1);
    return S(paramContext).getString(paramString1, paramString2);
  }
  
  public static void b(Context paramContext, String paramString, int paramInt) {
    paramString = l.e(paramContext, "wxop_" + paramString);
    SharedPreferences.Editor editor = S(paramContext).edit();
    editor.putInt(paramString, paramInt);
    editor.commit();
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2) {
    paramString1 = l.e(paramContext, "wxop_" + paramString1);
    SharedPreferences.Editor editor = S(paramContext).edit();
    editor.putString(paramString1, paramString2);
    editor.commit();
  }
  
  public static long f(Context paramContext, String paramString) {
    paramString = l.e(paramContext, "wxop_" + paramString);
    return S(paramContext).getLong(paramString, 0L);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\b\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */