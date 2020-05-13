package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ab extends Thread {
  private boolean a = false;
  
  private List<aa> b = Collections.synchronizedList(new ArrayList<aa>());
  
  private List<ac> c = Collections.synchronizedList(new ArrayList<ac>());
  
  private void a(Handler paramHandler) {
    if (paramHandler == null) {
      x.e("removeThread handler should not be null", new Object[0]);
      return;
    } 
    for (byte b = 0; b < this.b.size(); b++) {
      if (((aa)this.b.get(b)).e().equals(paramHandler.getLooper().getThread().getName())) {
        x.c("remove handler::%s", new Object[] { this.b.get(b) });
        this.b.remove(b);
      } 
    } 
  }
  
  private void a(Handler paramHandler, long paramLong) {
    if (paramHandler == null) {
      x.e("addThread handler should not be null", new Object[0]);
      return;
    } 
    String str = paramHandler.getLooper().getThread().getName();
    for (byte b = 0; b < this.b.size(); b++) {
      if (((aa)this.b.get(b)).e().equals(paramHandler.getLooper().getThread().getName())) {
        x.e("addThread fail ,this thread has been added in monitor queue", new Object[0]);
        return;
      } 
    } 
    this.b.add(new aa(paramHandler, str, 5000L));
  }
  
  public final void a() {
    a(new Handler(Looper.getMainLooper()), 5000L);
  }
  
  public final void a(ac paramac) {
    if (this.c.contains(paramac)) {
      x.e("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
      return;
    } 
    this.c.add(paramac);
  }
  
  public final void b() {
    a(new Handler(Looper.getMainLooper()));
  }
  
  public final void b(ac paramac) {
    this.c.remove(paramac);
  }
  
  public final boolean c() {
    this.a = true;
    if (!isAlive())
      return false; 
    try {
      interrupt();
    } catch (Exception exception) {
      x.e(exception.getStackTrace().toString(), new Object[0]);
    } 
    return true;
  }
  
  public final boolean d() {
    boolean bool = isAlive();
    boolean bool1 = false;
    if (bool)
      return false; 
    try {
      start();
      bool1 = true;
    } catch (Exception exception) {
      x.e(exception.getStackTrace().toString(), new Object[0]);
    } 
    return bool1;
  }
  
  public final void run() {
    while (!this.a) {
      int i;
      for (i = 0; i < this.b.size(); i++)
        ((aa)this.b.get(i)).a(); 
      long l1 = SystemClock.uptimeMillis();
      long l2;
      for (l2 = 2000L; l2 > 0L && !isInterrupted(); l2 = 2000L - SystemClock.uptimeMillis() - l1) {
        try {
          sleep(l2);
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      } 
      byte b = 0;
      i = 0;
      while (b < this.b.size()) {
        i = Math.max(i, ((aa)this.b.get(b)).c());
        b++;
      } 
      if (i != 0 && i != 1) {
        ArrayList<aa> arrayList = new ArrayList();
        for (i = 0; i < this.b.size(); i++) {
          aa aa = this.b.get(i);
          if (aa.b()) {
            arrayList.add(aa);
            aa.a(Long.MAX_VALUE);
          } 
        } 
        b = 0;
        i = 0;
        while (b < arrayList.size()) {
          aa aa = arrayList.get(b);
          Thread thread = aa.d();
          for (byte b1 = 0; b1 < this.c.size(); b1++) {
            if (((ac)this.c.get(b1)).a(thread))
              i = 1; 
          } 
          if (i == 0 && aa.e().contains("main")) {
            aa.f();
            x.d("although thread is blocked ,may not be anr error,so restore handler check wait time and restart check main thread", new Object[0]);
          } 
          b++;
        } 
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */