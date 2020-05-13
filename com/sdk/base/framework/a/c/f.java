package com.sdk.base.framework.a.c;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class f<E> extends AbstractQueue<E> implements Serializable, BlockingQueue<E> {
  transient a<E> a;
  
  private final int b;
  
  private final AtomicInteger c = new AtomicInteger();
  
  private transient a<E> d;
  
  private final ReentrantLock e = new ReentrantLock();
  
  private final Condition f = this.e.newCondition();
  
  private final ReentrantLock g = new ReentrantLock();
  
  private final Condition h = this.g.newCondition();
  
  public f() {
    this(2147483647);
  }
  
  public f(int paramInt) {
    if (paramInt <= 0)
      throw new IllegalArgumentException(); 
    this.b = paramInt;
    a<E> a1 = new a(null);
    this.a = a1;
    this.d = a1;
  }
  
  private E a(a<E> parama) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 15
    //   6: aload_0
    //   7: invokespecial e : ()Ljava/lang/Object;
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: areturn
    //   15: aload_0
    //   16: aload_1
    //   17: invokespecial b : (Lcom/sdk/base/framework/a/c/a;)V
    //   20: aconst_null
    //   21: astore_1
    //   22: goto -> 11
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   6	11	25	finally
    //   15	20	25	finally
  }
  
  private void b(a<E> parama) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Lcom/sdk/base/framework/a/c/a;
    //   4: astore_2
    //   5: aload_2
    //   6: getfield a : Lcom/sdk/base/framework/a/c/a;
    //   9: ifnull -> 74
    //   12: aload_2
    //   13: getfield a : Lcom/sdk/base/framework/a/c/a;
    //   16: astore_3
    //   17: aload_3
    //   18: invokevirtual a : ()Lcom/sdk/base/framework/a/c/b;
    //   21: invokevirtual ordinal : ()I
    //   24: aload_1
    //   25: invokevirtual a : ()Lcom/sdk/base/framework/a/c/b;
    //   28: invokevirtual ordinal : ()I
    //   31: if_icmple -> 66
    //   34: aload_2
    //   35: aload_1
    //   36: putfield a : Lcom/sdk/base/framework/a/c/a;
    //   39: aload_1
    //   40: aload_3
    //   41: putfield a : Lcom/sdk/base/framework/a/c/a;
    //   44: iconst_1
    //   45: istore #4
    //   47: iload #4
    //   49: ifne -> 65
    //   52: aload_0
    //   53: getfield d : Lcom/sdk/base/framework/a/c/a;
    //   56: aload_1
    //   57: putfield a : Lcom/sdk/base/framework/a/c/a;
    //   60: aload_0
    //   61: aload_1
    //   62: putfield d : Lcom/sdk/base/framework/a/c/a;
    //   65: return
    //   66: aload_2
    //   67: getfield a : Lcom/sdk/base/framework/a/c/a;
    //   70: astore_2
    //   71: goto -> 5
    //   74: iconst_0
    //   75: istore #4
    //   77: goto -> 47
  }
  
  private void c() {
    ReentrantLock reentrantLock = this.e;
    reentrantLock.lock();
    try {
      this.f.signal();
      return;
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  private void d() {
    ReentrantLock reentrantLock = this.g;
    reentrantLock.lock();
    try {
      this.h.signal();
      return;
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  private E e() {
    a<E> a1 = this.a;
    a<E> a2 = a1.a;
    a1.a = a1;
    this.a = a2;
    a1 = (a<E>)a2.b();
    a2.a(null);
    return (E)a1;
  }
  
  void a() {
    this.g.lock();
    this.e.lock();
  }
  
  void a(a<E> parama1, a<E> parama2) {
    parama1.a(null);
    parama2.a = parama1.a;
    if (this.d == parama1)
      this.d = parama2; 
    if (this.c.getAndDecrement() == this.b)
      this.h.signal(); 
  }
  
  void b() {
    this.e.unlock();
    this.g.unlock();
  }
  
  public void clear() {
    a();
    try {
      a<E> a1 = this.a;
      while (true) {
        a<E> a2 = a1.a;
        if (a2 != null) {
          a1.a = a1;
          a2.a(null);
          a1 = a2;
          continue;
        } 
        this.a = this.d;
        if (this.c.getAndSet(0) == this.b)
          this.h.signal(); 
        return;
      } 
    } finally {
      b();
    } 
  }
  
  public boolean contains(Object paramObject) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: ifnonnull -> 8
    //   6: iload_2
    //   7: ireturn
    //   8: aload_0
    //   9: invokevirtual a : ()V
    //   12: aload_0
    //   13: getfield a : Lcom/sdk/base/framework/a/c/a;
    //   16: getfield a : Lcom/sdk/base/framework/a/c/a;
    //   19: astore_3
    //   20: aload_3
    //   21: ifnull -> 56
    //   24: aload_1
    //   25: aload_3
    //   26: invokevirtual b : ()Ljava/lang/Object;
    //   29: invokevirtual equals : (Ljava/lang/Object;)Z
    //   32: istore #4
    //   34: iload #4
    //   36: ifeq -> 48
    //   39: iconst_1
    //   40: istore_2
    //   41: aload_0
    //   42: invokevirtual b : ()V
    //   45: goto -> 6
    //   48: aload_3
    //   49: getfield a : Lcom/sdk/base/framework/a/c/a;
    //   52: astore_3
    //   53: goto -> 20
    //   56: aload_0
    //   57: invokevirtual b : ()V
    //   60: goto -> 6
    //   63: astore_1
    //   64: aload_0
    //   65: invokevirtual b : ()V
    //   68: aload_1
    //   69: athrow
    // Exception table:
    //   from	to	target	type
    //   12	20	63	finally
    //   24	34	63	finally
    //   48	53	63	finally
  }
  
  public int drainTo(Collection<? super E> paramCollection) {
    return drainTo(paramCollection, 2147483647);
  }
  
  public int drainTo(Collection<? super E> paramCollection, int paramInt) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_1
    //   3: istore #4
    //   5: iconst_0
    //   6: istore #5
    //   8: iconst_0
    //   9: istore #6
    //   11: aload_1
    //   12: ifnonnull -> 23
    //   15: new java/lang/NullPointerException
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: athrow
    //   23: aload_1
    //   24: aload_0
    //   25: if_acmpne -> 36
    //   28: new java/lang/IllegalArgumentException
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: athrow
    //   36: iload_2
    //   37: ifgt -> 45
    //   40: iload #6
    //   42: istore_2
    //   43: iload_2
    //   44: ireturn
    //   45: aload_0
    //   46: getfield e : Ljava/util/concurrent/locks/ReentrantLock;
    //   49: astore #7
    //   51: aload #7
    //   53: invokevirtual lock : ()V
    //   56: iload_2
    //   57: aload_0
    //   58: getfield c : Ljava/util/concurrent/atomic/AtomicInteger;
    //   61: invokevirtual get : ()I
    //   64: invokestatic min : (II)I
    //   67: istore #6
    //   69: aload_0
    //   70: getfield a : Lcom/sdk/base/framework/a/c/a;
    //   73: astore #8
    //   75: iconst_0
    //   76: istore_2
    //   77: iload_2
    //   78: iload #6
    //   80: if_icmpge -> 125
    //   83: aload #8
    //   85: getfield a : Lcom/sdk/base/framework/a/c/a;
    //   88: astore #9
    //   90: aload_1
    //   91: aload #9
    //   93: invokevirtual b : ()Ljava/lang/Object;
    //   96: invokeinterface add : (Ljava/lang/Object;)Z
    //   101: pop
    //   102: aload #9
    //   104: aconst_null
    //   105: invokevirtual a : (Ljava/lang/Object;)V
    //   108: aload #8
    //   110: aload #8
    //   112: putfield a : Lcom/sdk/base/framework/a/c/a;
    //   115: iinc #2, 1
    //   118: aload #9
    //   120: astore #8
    //   122: goto -> 77
    //   125: iload_2
    //   126: ifle -> 252
    //   129: aload_0
    //   130: aload #8
    //   132: putfield a : Lcom/sdk/base/framework/a/c/a;
    //   135: aload_0
    //   136: getfield c : Ljava/util/concurrent/atomic/AtomicInteger;
    //   139: iload_2
    //   140: ineg
    //   141: invokevirtual getAndAdd : (I)I
    //   144: istore_2
    //   145: aload_0
    //   146: getfield b : I
    //   149: istore_3
    //   150: iload_2
    //   151: iload_3
    //   152: if_icmpne -> 177
    //   155: iload #4
    //   157: istore_2
    //   158: aload #7
    //   160: invokevirtual unlock : ()V
    //   163: iload_2
    //   164: ifeq -> 171
    //   167: aload_0
    //   168: invokespecial d : ()V
    //   171: iload #6
    //   173: istore_2
    //   174: goto -> 43
    //   177: iconst_0
    //   178: istore_2
    //   179: goto -> 158
    //   182: astore_1
    //   183: iload_2
    //   184: ifle -> 247
    //   187: aload_0
    //   188: aload #8
    //   190: putfield a : Lcom/sdk/base/framework/a/c/a;
    //   193: aload_0
    //   194: getfield c : Ljava/util/concurrent/atomic/AtomicInteger;
    //   197: iload_2
    //   198: ineg
    //   199: invokevirtual getAndAdd : (I)I
    //   202: istore #6
    //   204: aload_0
    //   205: getfield b : I
    //   208: istore_2
    //   209: iload #6
    //   211: iload_2
    //   212: if_icmpne -> 235
    //   215: iload_3
    //   216: istore_2
    //   217: aload_1
    //   218: athrow
    //   219: astore_1
    //   220: aload #7
    //   222: invokevirtual unlock : ()V
    //   225: iload_2
    //   226: ifeq -> 233
    //   229: aload_0
    //   230: invokespecial d : ()V
    //   233: aload_1
    //   234: athrow
    //   235: iconst_0
    //   236: istore_2
    //   237: goto -> 217
    //   240: astore_1
    //   241: iload #5
    //   243: istore_2
    //   244: goto -> 220
    //   247: iconst_0
    //   248: istore_2
    //   249: goto -> 217
    //   252: iconst_0
    //   253: istore_2
    //   254: goto -> 158
    // Exception table:
    //   from	to	target	type
    //   56	75	240	finally
    //   83	115	182	finally
    //   129	150	240	finally
    //   187	209	240	finally
    //   217	219	219	finally
  }
  
  public Iterator<E> iterator() {
    return new a(this);
  }
  
  public boolean offer(E paramE) {
    boolean bool = false;
    if (paramE == null)
      throw new NullPointerException(); 
    AtomicInteger atomicInteger = this.c;
    if (atomicInteger.get() != this.b) {
      int i = -1;
      a<E> a1 = new a<E>(paramE);
      ReentrantLock reentrantLock = this.g;
      reentrantLock.lock();
      try {
        if (atomicInteger.get() < this.b) {
          a(a1);
          int j = atomicInteger.getAndIncrement();
          i = j;
          if (j + 1 < this.b) {
            this.h.signal();
            i = j;
          } 
        } 
        reentrantLock.unlock();
        if (i == 0)
          c(); 
      } finally {
        reentrantLock.unlock();
      } 
      bool = false;
    } 
    return bool;
  }
  
  public boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit) {
    if (paramE == null)
      throw new NullPointerException(); 
    paramLong = paramTimeUnit.toNanos(paramLong);
    ReentrantLock reentrantLock = this.g;
    AtomicInteger atomicInteger = this.c;
    reentrantLock.lockInterruptibly();
    try {
      while (true) {
        int i = atomicInteger.get();
        int j = this.b;
        if (i == j) {
          if (paramLong <= 0L)
            return false; 
          paramLong = this.h.awaitNanos(paramLong);
          continue;
        } 
        a<E> a1 = new a();
        this(paramE);
        a(a1);
        j = atomicInteger.getAndIncrement();
        if (j + 1 < this.b)
          this.h.signal(); 
        reentrantLock.unlock();
        return true;
      } 
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  public E peek() {
    E e = null;
    if (this.c.get() != 0) {
      ReentrantLock reentrantLock = this.e;
      reentrantLock.lock();
      try {
        a<E> a1 = this.a.a;
        if (a1 == null)
          return e; 
        e = a1.b();
      } finally {
        reentrantLock.unlock();
      } 
    } 
    return e;
  }
  
  public E poll() {
    E e1;
    Exception exception = null;
    E e2 = null;
    AtomicInteger atomicInteger = this.c;
    if (atomicInteger.get() != 0) {
      int i = -1;
      ReentrantLock reentrantLock = this.e;
      reentrantLock.lock();
      try {
        E e3;
        if (atomicInteger.get() > 0) {
          e2 = a(null);
          int j = atomicInteger.getAndDecrement();
          i = j;
          E e = e2;
          if (j > 1) {
            this.f.signal();
            e3 = e2;
            i = j;
          } 
        } 
        reentrantLock.unlock();
        E e4 = e3;
      } finally {
        reentrantLock.unlock();
      } 
    } 
    return e1;
  }
  
  public E poll(long paramLong, TimeUnit paramTimeUnit) {
    null = null;
    paramLong = paramTimeUnit.toNanos(paramLong);
    AtomicInteger atomicInteger = this.c;
    ReentrantLock reentrantLock = this.e;
    reentrantLock.lockInterruptibly();
    try {
      while (true) {
        int i = atomicInteger.get();
        if (i == 0) {
          if (paramLong <= 0L)
            return (E)null; 
          paramLong = this.f.awaitNanos(paramLong);
          continue;
        } 
        null = (ReentrantLock)a(null);
        i = atomicInteger.getAndDecrement();
        if (i > 1)
          this.f.signal(); 
        reentrantLock.unlock();
        reentrantLock = null;
        return (E)reentrantLock;
      } 
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  public void put(E paramE) {
    if (paramE == null)
      throw new NullPointerException(); 
    a<E> a1 = new a<E>(paramE);
    ReentrantLock reentrantLock = this.g;
    null = this.c;
    reentrantLock.lockInterruptibly();
    try {
      while (null.get() == this.b)
        this.h.await(); 
    } finally {
      reentrantLock.unlock();
    } 
    int i = SYNTHETIC_LOCAL_VARIABLE_3.getAndIncrement();
    if (i + 1 < this.b)
      this.h.signal(); 
    reentrantLock.unlock();
    if (i == 0)
      c(); 
  }
  
  public int remainingCapacity() {
    return this.b - this.c.get();
  }
  
  public boolean remove(Object paramObject) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: ifnonnull -> 8
    //   6: iload_2
    //   7: ireturn
    //   8: aload_0
    //   9: invokevirtual a : ()V
    //   12: aload_0
    //   13: getfield a : Lcom/sdk/base/framework/a/c/a;
    //   16: astore_3
    //   17: aload_3
    //   18: getfield a : Lcom/sdk/base/framework/a/c/a;
    //   21: astore #4
    //   23: aload #4
    //   25: ifnull -> 73
    //   28: aload_1
    //   29: aload #4
    //   31: invokevirtual b : ()Ljava/lang/Object;
    //   34: invokevirtual equals : (Ljava/lang/Object;)Z
    //   37: ifeq -> 56
    //   40: aload_0
    //   41: aload #4
    //   43: aload_3
    //   44: invokevirtual a : (Lcom/sdk/base/framework/a/c/a;Lcom/sdk/base/framework/a/c/a;)V
    //   47: iconst_1
    //   48: istore_2
    //   49: aload_0
    //   50: invokevirtual b : ()V
    //   53: goto -> 6
    //   56: aload #4
    //   58: getfield a : Lcom/sdk/base/framework/a/c/a;
    //   61: astore #5
    //   63: aload #4
    //   65: astore_3
    //   66: aload #5
    //   68: astore #4
    //   70: goto -> 23
    //   73: aload_0
    //   74: invokevirtual b : ()V
    //   77: goto -> 6
    //   80: astore_1
    //   81: aload_0
    //   82: invokevirtual b : ()V
    //   85: aload_1
    //   86: athrow
    // Exception table:
    //   from	to	target	type
    //   12	23	80	finally
    //   28	47	80	finally
    //   56	63	80	finally
  }
  
  public int size() {
    return this.c.get();
  }
  
  public E take() {
    E e;
    null = this.c;
    ReentrantLock reentrantLock = this.e;
    reentrantLock.lockInterruptibly();
    try {
      while (null.get() == 0)
        this.f.await(); 
    } finally {
      reentrantLock.unlock();
    } 
    int i = SYNTHETIC_LOCAL_VARIABLE_1.getAndDecrement();
    if (i > 1)
      this.f.signal(); 
    reentrantLock.unlock();
    if (i == this.b)
      d(); 
    return e;
  }
  
  public Object[] toArray() {
    a();
    try {
      Object[] arrayOfObject = new Object[this.c.get()];
      byte b = 0;
      a<E> a1 = this.a.a;
      while (a1 != null) {
        arrayOfObject[b] = a1.b();
        a1 = a1.a;
        b++;
      } 
      return arrayOfObject;
    } finally {
      b();
    } 
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    a();
    try {
      int i = this.c.get();
      T[] arrayOfT = paramArrayOfT;
      if (paramArrayOfT.length < i)
        arrayOfT = (T[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i); 
      i = 0;
      a<E> a1 = this.a.a;
      while (a1 != null) {
        arrayOfT[i] = (T)a1.b();
        a1 = a1.a;
        i++;
      } 
      if (arrayOfT.length > i)
        arrayOfT[i] = null; 
      return arrayOfT;
    } finally {
      b();
    } 
  }
  
  private class a implements Iterator<E> {
    private a<E> b;
    
    private a<E> c;
    
    private E d;
    
    a(f this$0) {
      this$0.a();
      try {
        this.b = this$0.a.a;
        if (this.b != null)
          this.d = this.b.b(); 
        return;
      } finally {
        this$0.b();
      } 
    }
    
    private a<E> a(a<E> param1a) {
      a<E> a1 = param1a;
      while (true) {
        param1a = a1.a;
        if (param1a == a1)
          return this.a.a.a; 
        a1 = param1a;
        if (param1a != null) {
          a1 = param1a;
          if (param1a.b() == null) {
            a1 = param1a;
            continue;
          } 
        } 
        return a1;
      } 
    }
    
    public boolean hasNext() {
      return (this.b != null);
    }
    
    public E next() {
      E e2;
      this.a.a();
      try {
        if (this.b == null) {
          NoSuchElementException noSuchElementException = new NoSuchElementException();
          this();
          throw noSuchElementException;
        } 
      } finally {
        this.a.b();
      } 
      this.c = this.b;
      this.b = a(this.b);
      if (this.b == null) {
        E e = null;
        this.d = e;
        this.a.b();
        return e2;
      } 
      E e1 = this.b.b();
      this.d = e1;
      this.a.b();
      return e2;
    }
    
    public void remove() {
      if (this.c == null)
        throw new IllegalStateException(); 
      this.a.a();
      try {
        a<E> a1 = this.c;
        this.c = null;
        a<E> a2 = this.a.a;
        a<E> a3 = a2.a;
        while (true) {
          if (a3 != null)
            if (a3 == a1) {
              this.a.a(a3, a2);
            } else {
              a<E> a4 = a3.a;
              a2 = a3;
              a3 = a4;
              continue;
            }  
          return;
        } 
      } finally {
        this.a.b();
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\a\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */