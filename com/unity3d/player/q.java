package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class q {
  private UnityPlayer a = null;
  
  private Context b = null;
  
  private a c;
  
  private final Semaphore d = new Semaphore(0);
  
  private final Lock e = new ReentrantLock();
  
  private p f = null;
  
  private int g = 2;
  
  private boolean h = false;
  
  private boolean i = false;
  
  q(UnityPlayer paramUnityPlayer) {
    this.a = paramUnityPlayer;
  }
  
  private void d() {
    if (this.f != null) {
      this.a.removeViewFromPlayer((View)this.f);
      this.i = false;
      this.f.destroyPlayer();
      this.f = null;
      if (this.c != null)
        this.c.a(); 
    } 
  }
  
  public final void a() {
    this.e.lock();
    if (this.f != null)
      if (this.g == 0) {
        this.f.CancelOnPrepare();
      } else if (this.i) {
        this.h = this.f.a();
        if (!this.h)
          this.f.pause(); 
      }  
    this.e.unlock();
  }
  
  public final boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong1, long paramLong2, a parama) {
    Runnable runnable;
    this.e.lock();
    this.c = parama;
    this.b = paramContext;
    this.d.drainPermits();
    this.g = 2;
    runOnUiThread(new Runnable(this, paramString, paramInt1, paramInt2, paramInt3, paramBoolean, paramLong1, paramLong2) {
          public final void run() {
            if (q.a(this.h) != null) {
              g.Log(5, "Video already playing");
              q.a(this.h, 2);
              q.b(this.h).release();
              return;
            } 
            q.a(this.h, new p(q.c(this.h), this.a, this.b, this.c, this.d, this.e, this.f, this.g, new p.a(this) {
                    public final void a(int param2Int) {
                      q.d(this.a.h).lock();
                      q.a(this.a.h, param2Int);
                      if (param2Int == 3 && q.e(this.a.h))
                        this.a.h.runOnUiThread(new Runnable(this) {
                              public final void run() {
                                q.f(this.a.a.h);
                                q.g(this.a.a.h).resume();
                              }
                            }); 
                      if (param2Int != 0)
                        q.b(this.a.h).release(); 
                      q.d(this.a.h).unlock();
                    }
                  }));
            if (q.a(this.h) != null)
              q.g(this.h).addView((View)q.a(this.h)); 
          }
        });
    paramBoolean = false;
    try {
      this.e.unlock();
      this.d.acquire();
      this.e.lock();
      paramInt1 = this.g;
      if (paramInt1 != 2)
        paramBoolean = true; 
    } catch (InterruptedException interruptedException) {}
    runOnUiThread(new Runnable(this) {
          public final void run() {
            q.g(this.a).pause();
          }
        });
    if (paramBoolean && this.g != 3) {
      runnable = new Runnable(this) {
          public final void run() {
            if (q.a(this.a) != null) {
              q.g(this.a).addViewToPlayer((View)q.a(this.a), true);
              q.h(this.a);
              q.a(this.a).requestFocus();
            } 
          }
        };
    } else {
      runnable = new Runnable(this) {
          public final void run() {
            q.f(this.a);
            q.g(this.a).resume();
          }
        };
    } 
    runOnUiThread(runnable);
    this.e.unlock();
    return paramBoolean;
  }
  
  public final void b() {
    this.e.lock();
    if (this.f != null && this.i && !this.h)
      this.f.start(); 
    this.e.unlock();
  }
  
  public final void c() {
    this.e.lock();
    if (this.f != null)
      this.f.updateVideoLayout(); 
    this.e.unlock();
  }
  
  protected final void runOnUiThread(Runnable paramRunnable) {
    if (this.b instanceof Activity) {
      ((Activity)this.b).runOnUiThread(paramRunnable);
      return;
    } 
    g.Log(5, "Not running from an Activity; Ignoring execution request...");
  }
  
  public static interface a {
    void a();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */