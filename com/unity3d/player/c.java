package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class c {
  protected o a = null;
  
  protected f b = null;
  
  protected Context c = null;
  
  protected String d = null;
  
  protected String e = "";
  
  c(String paramString, f paramf) {
    this.e = paramString;
    this.b = paramf;
  }
  
  protected void reportError(String paramString) {
    if (this.b != null) {
      f f1 = this.b;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.e);
      stringBuilder1.append(" Error [");
      stringBuilder1.append(this.d);
      stringBuilder1.append("]");
      f1.reportError(stringBuilder1.toString(), paramString);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.e);
    stringBuilder.append(" Error [");
    stringBuilder.append(this.d);
    stringBuilder.append("]: ");
    stringBuilder.append(paramString);
    g.Log(6, stringBuilder.toString());
  }
  
  protected void runOnUiThread(Runnable paramRunnable) {
    if (this.c instanceof Activity) {
      ((Activity)this.c).runOnUiThread(paramRunnable);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder("Not running ");
    stringBuilder.append(this.e);
    stringBuilder.append(" from an Activity; Ignoring execution request...");
    g.Log(5, stringBuilder.toString());
  }
  
  protected boolean runOnUiThreadWithSync(Runnable paramRunnable) {
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
      paramRunnable.run();
      return true;
    } 
    boolean bool = false;
    Semaphore semaphore = new Semaphore(0);
    runOnUiThread(new Runnable(this, paramRunnable, semaphore) {
          public final void run() {
            try {
              this.a.run();
            } catch (Exception exception) {
            
            } finally {
              Exception exception;
            } 
            this.b.release();
          }
        });
    try {
      if (!semaphore.tryAcquire(4L, TimeUnit.SECONDS)) {
        reportError("Timeout waiting for vr state change!");
      } else {
        bool = true;
      } 
    } catch (InterruptedException interruptedException) {
      StringBuilder stringBuilder = new StringBuilder("Interrupted while trying to acquire sync lock. ");
      stringBuilder.append(interruptedException.getLocalizedMessage());
      reportError(stringBuilder.toString());
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */