package com.zz.a.a.c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a {
  static {
    a = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, i, h, new ThreadPoolExecutor.DiscardOldestPolicy());
    if (ac.c()) {
      h h = new h(null);
    } else {
      executorService = Executors.newSingleThreadExecutor(h);
    } 
    b = executorService;
    c = Executors.newFixedThreadPool(2, h);
    l = new g(null);
    m = b;
  }
  
  public static void a() {
    l.getLooper();
  }
  
  public static void a(Runnable paramRunnable) {
    m.execute(paramRunnable);
  }
  
  public static void a(Executor paramExecutor) {
    m = paramExecutor;
  }
  
  private void c(Object paramObject) {
    if (!this.r.get())
      d(paramObject); 
  }
  
  private Object d(Object paramObject) {
    l.obtainMessage(1, new f(this, new Object[] { paramObject })).sendToTarget();
    return paramObject;
  }
  
  private void e(Object paramObject) {
    if (e()) {
      b(paramObject);
    } else {
      a(paramObject);
    } 
    this.p = j.c;
  }
  
  public final a a(Executor paramExecutor, Object... paramVarArgs) {
    if (this.p != j.a) {
      switch (e.a[this.p.ordinal()]) {
        default:
          this.p = j.b;
          c();
          this.n.b = paramVarArgs;
          paramExecutor.execute(this.o);
          return this;
        case 1:
          throw new IllegalStateException("Cannot execute task: the task is already running.");
        case 2:
          break;
      } 
      throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    } 
  }
  
  public final Object a(long paramLong, TimeUnit paramTimeUnit) {
    return this.o.get(paramLong, paramTimeUnit);
  }
  
  protected abstract Object a(Object... paramVarArgs);
  
  protected void a(Object paramObject) {}
  
  public final boolean a(boolean paramBoolean) {
    this.q.set(true);
    return this.o.cancel(paramBoolean);
  }
  
  public final j b() {
    return this.p;
  }
  
  protected void b(Object paramObject) {
    d();
  }
  
  protected void b(Object... paramVarArgs) {}
  
  public final a c(Object... paramVarArgs) {
    return a(m, paramVarArgs);
  }
  
  protected void c() {}
  
  protected void d() {}
  
  protected final void d(Object... paramVarArgs) {
    if (!e())
      l.obtainMessage(2, new f(this, paramVarArgs)).sendToTarget(); 
  }
  
  public final boolean e() {
    return this.q.get();
  }
  
  public final Object f() {
    return this.o.get();
  }
  
  static {
    ExecutorService executorService;
  }
  
  public static final Executor a;
  
  public static final Executor b;
  
  public static final Executor c;
  
  private static final String d = "AsyncTask";
  
  private static final int e = 5;
  
  private static final int f = 128;
  
  private static final int g = 1;
  
  private static final ThreadFactory h = new b();
  
  private static final BlockingQueue i = new LinkedBlockingQueue(10);
  
  private static final int j = 1;
  
  private static final int k = 2;
  
  private static final g l;
  
  private static volatile Executor m;
  
  private final k n = new c(this);
  
  private final FutureTask o = new d(this, this.n);
  
  private volatile j p = j.a;
  
  private final AtomicBoolean q = new AtomicBoolean();
  
  private final AtomicBoolean r = new AtomicBoolean();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */