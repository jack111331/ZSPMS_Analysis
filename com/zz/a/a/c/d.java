package com.zz.a.a.c;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class d extends FutureTask {
  d(a parama, Callable<V> paramCallable) {
    super(paramCallable);
  }
  
  protected void done() {
    try {
      a.b(this.a, get());
    } catch (InterruptedException interruptedException) {
      Log.w("AsyncTask", interruptedException);
    } catch (ExecutionException executionException) {
      throw new RuntimeException("An error occured while executing doInBackground()", executionException.getCause());
    } catch (CancellationException cancellationException) {
      a.b(this.a, null);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */