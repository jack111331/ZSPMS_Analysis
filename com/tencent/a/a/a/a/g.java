package com.tencent.a.a.a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class g {
  private static g i = null;
  
  private Map<Integer, f> f = null;
  
  private int g = 0;
  
  private Context h = null;
  
  private g(Context paramContext) {
    this.h = paramContext.getApplicationContext();
    this.f = new HashMap<Integer, f>(3);
    this.f.put(Integer.valueOf(1), new e(paramContext));
    this.f.put(Integer.valueOf(2), new b(paramContext));
    this.f.put(Integer.valueOf(4), new d(paramContext));
  }
  
  private c a(List<Integer> paramList) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 78
    //   4: aload_1
    //   5: invokeinterface size : ()I
    //   10: iflt -> 78
    //   13: aload_1
    //   14: invokeinterface iterator : ()Ljava/util/Iterator;
    //   19: astore_2
    //   20: aload_2
    //   21: invokeinterface hasNext : ()Z
    //   26: ifeq -> 78
    //   29: aload_2
    //   30: invokeinterface next : ()Ljava/lang/Object;
    //   35: checkcast java/lang/Integer
    //   38: astore_1
    //   39: aload_0
    //   40: getfield f : Ljava/util/Map;
    //   43: aload_1
    //   44: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   49: checkcast com/tencent/a/a/a/a/f
    //   52: astore_1
    //   53: aload_1
    //   54: ifnull -> 20
    //   57: aload_1
    //   58: invokevirtual e : ()Lcom/tencent/a/a/a/a/c;
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull -> 20
    //   66: aload_1
    //   67: getfield c : Ljava/lang/String;
    //   70: invokestatic e : (Ljava/lang/String;)Z
    //   73: ifeq -> 20
    //   76: aload_1
    //   77: areturn
    //   78: new com/tencent/a/a/a/a/c
    //   81: dup
    //   82: invokespecial <init> : ()V
    //   85: astore_1
    //   86: goto -> 76
  }
  
  public static g a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/a/a/a/a/g
    //   2: monitorenter
    //   3: getstatic com/tencent/a/a/a/a/g.i : Lcom/tencent/a/a/a/a/g;
    //   6: ifnonnull -> 22
    //   9: new com/tencent/a/a/a/a/g
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: invokespecial <init> : (Landroid/content/Context;)V
    //   18: aload_1
    //   19: putstatic com/tencent/a/a/a/a/g.i : Lcom/tencent/a/a/a/a/g;
    //   22: getstatic com/tencent/a/a/a/a/g.i : Lcom/tencent/a/a/a/a/g;
    //   25: astore_0
    //   26: ldc com/tencent/a/a/a/a/g
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: ldc com/tencent/a/a/a/a/g
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	31	finally
    //   22	26	31	finally
  }
  
  public final void b(String paramString) {
    c c = f();
    c.c = paramString;
    if (!h.d(c.a))
      c.a = h.b(this.h); 
    if (!h.d(c.b))
      c.b = h.c(this.h); 
    c.d = System.currentTimeMillis();
    Iterator<Map.Entry> iterator = this.f.entrySet().iterator();
    while (iterator.hasNext())
      ((f)((Map.Entry)iterator.next()).getValue()).a(c); 
  }
  
  public final c f() {
    return a(new ArrayList<Integer>(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4) })));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\a\a\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */