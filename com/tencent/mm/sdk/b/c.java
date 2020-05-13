package com.tencent.mm.sdk.b;

import java.util.LinkedHashMap;

public final class c<K, V> {
  private int A;
  
  private int B;
  
  private int C;
  
  private int D;
  
  private int size;
  
  private final LinkedHashMap<K, V> u;
  
  private int v;
  
  private void trimToSize(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield size : I
    //   6: iflt -> 26
    //   9: aload_0
    //   10: getfield u : Ljava/util/LinkedHashMap;
    //   13: invokevirtual isEmpty : ()Z
    //   16: ifeq -> 68
    //   19: aload_0
    //   20: getfield size : I
    //   23: ifeq -> 68
    //   26: new java/lang/IllegalStateException
    //   29: astore_2
    //   30: new java/lang/StringBuilder
    //   33: astore_3
    //   34: aload_3
    //   35: invokespecial <init> : ()V
    //   38: aload_2
    //   39: aload_3
    //   40: aload_0
    //   41: invokevirtual getClass : ()Ljava/lang/Class;
    //   44: invokevirtual getName : ()Ljava/lang/String;
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc '.sizeOf() is reporting inconsistent results!'
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual toString : ()Ljava/lang/String;
    //   58: invokespecial <init> : (Ljava/lang/String;)V
    //   61: aload_2
    //   62: athrow
    //   63: astore_3
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_3
    //   67: athrow
    //   68: aload_0
    //   69: getfield size : I
    //   72: iload_1
    //   73: if_icmple -> 86
    //   76: aload_0
    //   77: getfield u : Ljava/util/LinkedHashMap;
    //   80: invokevirtual isEmpty : ()Z
    //   83: ifeq -> 89
    //   86: aload_0
    //   87: monitorexit
    //   88: return
    //   89: aload_0
    //   90: getfield u : Ljava/util/LinkedHashMap;
    //   93: invokevirtual entrySet : ()Ljava/util/Set;
    //   96: invokeinterface iterator : ()Ljava/util/Iterator;
    //   101: invokeinterface next : ()Ljava/lang/Object;
    //   106: checkcast java/util/Map$Entry
    //   109: astore_2
    //   110: aload_2
    //   111: invokeinterface getKey : ()Ljava/lang/Object;
    //   116: astore_3
    //   117: aload_2
    //   118: invokeinterface getValue : ()Ljava/lang/Object;
    //   123: pop
    //   124: aload_0
    //   125: getfield u : Ljava/util/LinkedHashMap;
    //   128: aload_3
    //   129: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   132: pop
    //   133: aload_0
    //   134: aload_0
    //   135: getfield size : I
    //   138: iconst_1
    //   139: isub
    //   140: putfield size : I
    //   143: aload_0
    //   144: aload_0
    //   145: getfield B : I
    //   148: iconst_1
    //   149: iadd
    //   150: putfield B : I
    //   153: aload_0
    //   154: monitorexit
    //   155: goto -> 0
    // Exception table:
    //   from	to	target	type
    //   2	26	63	finally
    //   26	63	63	finally
    //   68	86	63	finally
    //   86	88	63	finally
    //   89	155	63	finally
  }
  
  public final boolean a(K paramK) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield u : Ljava/util/LinkedHashMap;
    //   6: aload_1
    //   7: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   10: istore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: iload_2
    //   14: ireturn
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	15	finally
  }
  
  public final V get(K paramK) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 14
    //   4: new java/lang/NullPointerException
    //   7: dup
    //   8: ldc 'key == null'
    //   10: invokespecial <init> : (Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield u : Ljava/util/LinkedHashMap;
    //   20: aload_1
    //   21: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull -> 43
    //   29: aload_0
    //   30: aload_0
    //   31: getfield C : I
    //   34: iconst_1
    //   35: iadd
    //   36: putfield C : I
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: areturn
    //   43: aload_0
    //   44: aload_0
    //   45: getfield D : I
    //   48: iconst_1
    //   49: iadd
    //   50: putfield D : I
    //   53: aload_0
    //   54: monitorexit
    //   55: aconst_null
    //   56: astore_1
    //   57: goto -> 41
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Exception table:
    //   from	to	target	type
    //   16	25	60	finally
    //   29	41	60	finally
    //   43	55	60	finally
  }
  
  public final V put(K paramK, V paramV) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 8
    //   4: aload_2
    //   5: ifnonnull -> 18
    //   8: new java/lang/NullPointerException
    //   11: dup
    //   12: ldc 'key == null || value == null'
    //   14: invokespecial <init> : (Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_0
    //   19: monitorenter
    //   20: aload_0
    //   21: aload_0
    //   22: getfield A : I
    //   25: iconst_1
    //   26: iadd
    //   27: putfield A : I
    //   30: aload_0
    //   31: aload_0
    //   32: getfield size : I
    //   35: iconst_1
    //   36: iadd
    //   37: putfield size : I
    //   40: aload_0
    //   41: getfield u : Ljava/util/LinkedHashMap;
    //   44: aload_1
    //   45: aload_2
    //   46: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull -> 64
    //   54: aload_0
    //   55: aload_0
    //   56: getfield size : I
    //   59: iconst_1
    //   60: isub
    //   61: putfield size : I
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_0
    //   67: aload_0
    //   68: getfield v : I
    //   71: invokespecial trimToSize : (I)V
    //   74: aload_1
    //   75: areturn
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Exception table:
    //   from	to	target	type
    //   20	50	76	finally
    //   54	64	76	finally
    //   64	66	76	finally
  }
  
  public final String toString() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield C : I
    //   8: aload_0
    //   9: getfield D : I
    //   12: iadd
    //   13: istore_2
    //   14: iload_2
    //   15: ifeq -> 28
    //   18: aload_0
    //   19: getfield C : I
    //   22: bipush #100
    //   24: imul
    //   25: iload_2
    //   26: idiv
    //   27: istore_1
    //   28: ldc 'LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]'
    //   30: iconst_4
    //   31: anewarray java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload_0
    //   37: getfield v : I
    //   40: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: aload_0
    //   47: getfield C : I
    //   50: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   53: aastore
    //   54: dup
    //   55: iconst_2
    //   56: aload_0
    //   57: getfield D : I
    //   60: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   63: aastore
    //   64: dup
    //   65: iconst_3
    //   66: iload_1
    //   67: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   70: aastore
    //   71: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   74: astore_3
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_3
    //   78: areturn
    //   79: astore_3
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_3
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   4	14	79	finally
    //   18	28	79	finally
    //   28	75	79	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */