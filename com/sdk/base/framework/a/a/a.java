package com.sdk.base.framework.a.a;

import java.util.concurrent.ConcurrentHashMap;

public class a<K, V> extends ConcurrentHashMap<K, Long> {
  public a() {}
  
  public a(int paramInt, float paramFloat) {
    super(paramInt, paramFloat, 16);
  }
  
  public Long a(Object paramObject) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   7: ifeq -> 23
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast java/lang/Long
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: areturn
    //   23: aconst_null
    //   24: astore_1
    //   25: goto -> 19
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	28	finally
  }
  
  public Long a(K paramK, Long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   7: ifeq -> 16
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual b : (Ljava/lang/Object;)Ljava/lang/Long;
    //   15: pop
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: invokespecial put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast java/lang/Long
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
    //   2	16	30	finally
    //   16	26	30	finally
  }
  
  public Long b(Object paramObject) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast java/lang/Long
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: areturn
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	15	finally
  }
  
  public void clear() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial clear : ()V
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: athrow
    // Exception table:
    //   from	to	target	type
    //   2	6	9	finally
  }
  
  public boolean containsKey(Object paramObject) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast java/lang/Long
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull -> 40
    //   15: invokestatic currentTimeMillis : ()J
    //   18: lstore_3
    //   19: aload_2
    //   20: invokevirtual longValue : ()J
    //   23: lstore #5
    //   25: lload_3
    //   26: lload #5
    //   28: lcmp
    //   29: ifge -> 40
    //   32: iconst_1
    //   33: istore #7
    //   35: aload_0
    //   36: monitorexit
    //   37: iload #7
    //   39: ireturn
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual b : (Ljava/lang/Object;)Ljava/lang/Long;
    //   45: pop
    //   46: iconst_0
    //   47: istore #7
    //   49: goto -> 35
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	52	finally
    //   15	25	52	finally
    //   40	46	52	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */