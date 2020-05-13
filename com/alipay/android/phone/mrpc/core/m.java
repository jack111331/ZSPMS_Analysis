package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

final class m extends FutureTask<u> {
  m(l paraml, Callable<u> paramCallable, q paramq) {
    super(paramCallable);
  }
  
  protected final void done() {
    o o = this.a.a();
    if (o.f() == null) {
      super.done();
      return;
    } 
    try {
      get();
      if (isCancelled() || o.h()) {
        o.g();
        if (!isCancelled() || !isDone())
          cancel(false); 
      } 
      return;
    } catch (InterruptedException interruptedException) {
      (new StringBuilder()).append(interruptedException);
      return;
    } catch (ExecutionException executionException) {
      HttpException httpException;
      if (executionException.getCause() != null && executionException.getCause() instanceof HttpException) {
        httpException = (HttpException)executionException.getCause();
        httpException.getCode();
        httpException.getMsg();
        return;
      } 
      (new StringBuilder()).append(httpException);
      return;
    } catch (CancellationException cancellationException) {
      o.g();
      return;
    } catch (Throwable throwable) {
      throw new RuntimeException("An error occured while executing http request", throwable);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */