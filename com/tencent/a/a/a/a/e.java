package com.tencent.a.a.a.a;

import android.content.Context;

public final class e extends f {
  public e(Context paramContext) {
    super(paramContext);
  }
  
  protected final boolean a() {
    return h.a(this.e, "android.permission.WRITE_SETTINGS");
  }
  
  protected final String b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'MID'
    //   4: ldc 'read mid from Settings.System'
    //   6: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: getfield e : Landroid/content/Context;
    //   14: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   17: ldc '4kU71lN96TJUomD1vOU9lgj9Tw=='
    //   19: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   22: invokestatic getString : (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	28	30	finally
  }
  
  protected final void b(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'MID'
    //   4: ldc 'write mid to Settings.System'
    //   6: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: getfield e : Landroid/content/Context;
    //   14: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   17: ldc '4kU71lN96TJUomD1vOU9lgj9Tw=='
    //   19: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   22: aload_1
    //   23: invokestatic putString : (Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Z
    //   26: pop
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	30	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\a\a\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */