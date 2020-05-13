package com.zz.sdk.i;

public class a {
  private static boolean a = false;
  
  private static boolean b = false;
  
  public static void a(boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/a
    //   2: monitorenter
    //   3: iload_0
    //   4: putstatic com/zz/sdk/i/a.b : Z
    //   7: ldc com/zz/sdk/i/a
    //   9: monitorexit
    //   10: return
    //   11: astore_1
    //   12: ldc com/zz/sdk/i/a
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	11	finally
  }
  
  public static boolean a() {
    // Byte code:
    //   0: ldc com/zz/sdk/i/a
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/i/a.b : Z
    //   6: istore_0
    //   7: ldc com/zz/sdk/i/a
    //   9: monitorexit
    //   10: iload_0
    //   11: ireturn
    //   12: astore_1
    //   13: ldc com/zz/sdk/i/a
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static void b(boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/zz/sdk/i/a
    //   2: monitorenter
    //   3: iload_0
    //   4: putstatic com/zz/sdk/i/a.a : Z
    //   7: ldc com/zz/sdk/i/a
    //   9: monitorexit
    //   10: return
    //   11: astore_1
    //   12: ldc com/zz/sdk/i/a
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	11	finally
  }
  
  public static boolean b() {
    // Byte code:
    //   0: ldc com/zz/sdk/i/a
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/i/a.a : Z
    //   6: istore_0
    //   7: ldc com/zz/sdk/i/a
    //   9: monitorexit
    //   10: iload_0
    //   11: ireturn
    //   12: astore_1
    //   13: ldc com/zz/sdk/i/a
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */