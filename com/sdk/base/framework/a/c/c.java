package com.sdk.base.framework.a.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class c<Params, Progress, Result> {
  private static final b a = new b();
  
  public static final Executor b = new d();
  
  protected Boolean c = Boolean.valueOf(com.sdk.base.framework.c.c.h);
  
  private final c<Params, Result> d = new c<Params, Result>(this) {
      public Result call() {
        c.a(this.a).set(true);
        Process.setThreadPriority(10);
        return (Result)c.a(this.a, this.a.c((Object[])this.b));
      }
    };
  
  private final FutureTask<Result> e = new FutureTask<Result>(this, this.d) {
      protected void done() {
        try {
          c.b(this.a, get());
        } catch (Exception exception) {
          c.b(this.a, null);
          com.sdk.base.framework.utils.f.b.c("PriorityAsyncTask", exception.getMessage(), this.a.c);
        } 
      }
    };
  
  private final AtomicBoolean f = new AtomicBoolean();
  
  private final AtomicBoolean g = new AtomicBoolean();
  
  private volatile boolean h = false;
  
  private b i;
  
  private void c(Result paramResult) {
    if (!this.g.get())
      d(paramResult); 
  }
  
  private Result d(Result paramResult) {
    a.obtainMessage(1, new a(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }
  
  private void e(Result paramResult) {
    if (d()) {
      b(paramResult);
      return;
    } 
    a(paramResult);
  }
  
  public final c<Params, Progress, Result> a(Executor paramExecutor, Params... paramVarArgs) {
    if (this.h)
      throw new IllegalStateException("Cannot execute task: the task is already executed."); 
    this.h = true;
    b();
    this.d.b = paramVarArgs;
    paramExecutor.execute(new g(this.i, this.e));
    return this;
  }
  
  public void a() {
    a(true);
  }
  
  protected void a(Result paramResult) {}
  
  public final boolean a(boolean paramBoolean) {
    this.f.set(true);
    return this.e.cancel(paramBoolean);
  }
  
  protected void b() {}
  
  protected void b(Result paramResult) {
    c();
  }
  
  protected void b(Progress... paramVarArgs) {}
  
  protected abstract Result c(Params... paramVarArgs);
  
  protected void c() {}
  
  public final c<Params, Progress, Result> d(Params... paramVarArgs) {
    return a(b, paramVarArgs);
  }
  
  public final boolean d() {
    return this.f.get();
  }
  
  protected final void e(Progress... paramVarArgs) {
    if (!d())
      a.obtainMessage(2, new a<Progress>(this, paramVarArgs)).sendToTarget(); 
  }
  
  private static class a<Data> {
    final c a;
    
    final Data[] b;
    
    a(c param1c, Data... param1VarArgs) {
      this.a = param1c;
      this.b = param1VarArgs;
    }
  }
  
  private static class b extends Handler {
    private b() {
      super(Looper.getMainLooper());
    }
    
    public void handleMessage(Message param1Message) {
      c.a a = (c.a)param1Message.obj;
      switch (param1Message.what) {
        default:
          return;
        case 1:
          c.c(a.a, a.b[0]);
        case 2:
          break;
      } 
      a.a.b((Object[])a.b);
    }
  }
  
  private static abstract class c<Params, Result> implements Callable<Result> {
    Params[] b;
    
    private c() {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\a\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */