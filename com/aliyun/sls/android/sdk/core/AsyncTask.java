package com.aliyun.sls.android.sdk.core;

import com.aliyun.sls.android.sdk.LogException;
import java.util.concurrent.Future;

public class AsyncTask<T extends Result> {
  private volatile boolean canceled;
  
  private ExecutionContext context;
  
  private Future<T> future;
  
  public static AsyncTask wrapRequestTask(Future<Result> paramFuture, ExecutionContext paramExecutionContext) {
    AsyncTask<Result> asyncTask = new AsyncTask<Result>();
    asyncTask.future = paramFuture;
    asyncTask.context = paramExecutionContext;
    return asyncTask;
  }
  
  public void cancel() {
    this.canceled = true;
    if (this.context != null)
      this.context.getCancellationHandler().cancel(); 
  }
  
  public T getResult() throws LogException {
    try {
      return this.future.get();
    } catch (Exception exception) {
      throw new LogException("", "", exception.getCause(), "");
    } 
  }
  
  public boolean isCanceled() {
    return this.canceled;
  }
  
  public boolean isCompleted() {
    return this.future.isDone();
  }
  
  public void waitUntilFinished() {
    try {
      this.future.get();
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\core\AsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */