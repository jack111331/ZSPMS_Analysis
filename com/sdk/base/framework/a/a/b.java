package com.sdk.base.framework.a.a;

import java.util.LinkedHashMap;
import java.util.Map;

public class b<K, V> {
  private final LinkedHashMap<K, V> a;
  
  private int b;
  
  private int c;
  
  private a<K, Long> d;
  
  public b(int paramInt) {
    if (paramInt <= 0)
      throw new IllegalArgumentException("maxSize <= 0"); 
    this.c = paramInt;
    this.a = new LinkedHashMap<K, V>(0, 0.75F, true);
    this.d = new a<K, Long>(0, 0.75F);
  }
  
  private void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : I
    //   6: iload_1
    //   7: if_icmple -> 20
    //   10: aload_0
    //   11: getfield a : Ljava/util/LinkedHashMap;
    //   14: invokevirtual isEmpty : ()Z
    //   17: ifeq -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield a : Ljava/util/LinkedHashMap;
    //   27: invokevirtual entrySet : ()Ljava/util/Set;
    //   30: invokeinterface iterator : ()Ljava/util/Iterator;
    //   35: invokeinterface next : ()Ljava/lang/Object;
    //   40: checkcast java/util/Map$Entry
    //   43: astore_2
    //   44: aload_2
    //   45: invokeinterface getKey : ()Ljava/lang/Object;
    //   50: astore_3
    //   51: aload_2
    //   52: invokeinterface getValue : ()Ljava/lang/Object;
    //   57: astore_2
    //   58: aload_0
    //   59: getfield a : Ljava/util/LinkedHashMap;
    //   62: aload_3
    //   63: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: aload_0
    //   68: getfield d : Lcom/sdk/base/framework/a/a/a;
    //   71: aload_3
    //   72: invokevirtual b : (Ljava/lang/Object;)Ljava/lang/Long;
    //   75: pop
    //   76: aload_0
    //   77: aload_0
    //   78: getfield b : I
    //   81: aload_0
    //   82: aload_3
    //   83: aload_2
    //   84: invokespecial b : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   87: isub
    //   88: putfield b : I
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_0
    //   94: iconst_1
    //   95: aload_3
    //   96: aload_2
    //   97: aconst_null
    //   98: invokevirtual a : (ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   101: goto -> 0
    //   104: astore_3
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_3
    //   108: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	104	finally
    //   20	22	104	finally
    //   23	93	104	finally
    //   105	107	104	finally
  }
  
  private int b(K paramK, V paramV) {
    int i = a(paramK, paramV);
    if (i <= 0) {
      this.b = 0;
      for (Map.Entry<K, V> entry : this.a.entrySet()) {
        int j = this.b;
        this.b = a((K)entry.getKey(), (V)entry.getValue()) + j;
      } 
    } 
    return i;
  }
  
  protected int a(K paramK, V paramV) {
    return 1;
  }
  
  public final V a(K paramK) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: ifnonnull -> 16
    //   6: new java/lang/NullPointerException
    //   9: dup
    //   10: ldc 'key == null'
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: athrow
    //   16: aload_0
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield d : Lcom/sdk/base/framework/a/a/a;
    //   22: aload_1
    //   23: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   26: ifne -> 39
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual b : (Ljava/lang/Object;)Ljava/lang/Object;
    //   34: pop
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: areturn
    //   39: aload_0
    //   40: getfield a : Ljava/util/LinkedHashMap;
    //   43: aload_1
    //   44: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull -> 59
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_3
    //   55: astore_2
    //   56: goto -> 37
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_0
    //   62: aload_1
    //   63: invokevirtual c : (Ljava/lang/Object;)Ljava/lang/Object;
    //   66: astore_3
    //   67: aload_3
    //   68: ifnull -> 37
    //   71: aload_0
    //   72: monitorenter
    //   73: aload_0
    //   74: getfield a : Ljava/util/LinkedHashMap;
    //   77: aload_1
    //   78: aload_3
    //   79: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   82: astore_2
    //   83: aload_2
    //   84: ifnull -> 119
    //   87: aload_0
    //   88: getfield a : Ljava/util/LinkedHashMap;
    //   91: aload_1
    //   92: aload_2
    //   93: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   96: pop
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_2
    //   100: ifnull -> 142
    //   103: aload_0
    //   104: iconst_0
    //   105: aload_1
    //   106: aload_3
    //   107: aload_2
    //   108: invokevirtual a : (ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   111: goto -> 37
    //   114: astore_1
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    //   119: aload_0
    //   120: aload_0
    //   121: getfield b : I
    //   124: aload_0
    //   125: aload_1
    //   126: aload_3
    //   127: invokespecial b : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   130: iadd
    //   131: putfield b : I
    //   134: goto -> 97
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    //   142: aload_0
    //   143: aload_0
    //   144: getfield c : I
    //   147: invokespecial a : (I)V
    //   150: aload_3
    //   151: astore_2
    //   152: goto -> 37
    // Exception table:
    //   from	to	target	type
    //   18	37	114	finally
    //   39	48	114	finally
    //   52	54	114	finally
    //   59	61	114	finally
    //   73	83	137	finally
    //   87	97	137	finally
    //   97	99	137	finally
    //   115	117	114	finally
    //   119	134	137	finally
    //   138	140	137	finally
  }
  
  public final V a(K paramK, V paramV, long paramLong) {
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
    //   22: getfield b : I
    //   25: aload_0
    //   26: aload_1
    //   27: aload_2
    //   28: invokespecial b : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   31: iadd
    //   32: putfield b : I
    //   35: aload_0
    //   36: getfield a : Ljava/util/LinkedHashMap;
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: astore #5
    //   46: aload_0
    //   47: getfield d : Lcom/sdk/base/framework/a/a/a;
    //   50: aload_1
    //   51: lload_3
    //   52: invokestatic valueOf : (J)Ljava/lang/Long;
    //   55: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Long;)Ljava/lang/Long;
    //   58: pop
    //   59: aload #5
    //   61: ifnull -> 80
    //   64: aload_0
    //   65: aload_0
    //   66: getfield b : I
    //   69: aload_0
    //   70: aload_1
    //   71: aload #5
    //   73: invokespecial b : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   76: isub
    //   77: putfield b : I
    //   80: aload_0
    //   81: monitorexit
    //   82: aload #5
    //   84: ifnull -> 96
    //   87: aload_0
    //   88: iconst_0
    //   89: aload_1
    //   90: aload #5
    //   92: aload_2
    //   93: invokevirtual a : (ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   96: aload_0
    //   97: aload_0
    //   98: getfield c : I
    //   101: invokespecial a : (I)V
    //   104: aload #5
    //   106: areturn
    //   107: astore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    // Exception table:
    //   from	to	target	type
    //   20	59	107	finally
    //   64	80	107	finally
    //   80	82	107	finally
    //   108	110	107	finally
  }
  
  protected void a(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public final V b(K paramK) {
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
    //   17: getfield a : Ljava/util/LinkedHashMap;
    //   20: aload_1
    //   21: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   24: astore_2
    //   25: aload_0
    //   26: getfield d : Lcom/sdk/base/framework/a/a/a;
    //   29: aload_1
    //   30: invokevirtual b : (Ljava/lang/Object;)Ljava/lang/Long;
    //   33: pop
    //   34: aload_2
    //   35: ifnull -> 53
    //   38: aload_0
    //   39: aload_0
    //   40: getfield b : I
    //   43: aload_0
    //   44: aload_1
    //   45: aload_2
    //   46: invokespecial b : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   49: isub
    //   50: putfield b : I
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_2
    //   56: ifnull -> 67
    //   59: aload_0
    //   60: iconst_0
    //   61: aload_1
    //   62: aload_2
    //   63: aconst_null
    //   64: invokevirtual a : (ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   67: aload_2
    //   68: areturn
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Exception table:
    //   from	to	target	type
    //   16	34	69	finally
    //   38	53	69	finally
    //   53	55	69	finally
    //   70	72	69	finally
  }
  
  protected V c(K paramK) {
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */