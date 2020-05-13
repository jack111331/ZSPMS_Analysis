package org.jar.support.v4.content;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask<Params, Progress, Result> {
  private static final int CORE_POOL_SIZE = 5;
  
  private static final int KEEP_ALIVE = 1;
  
  private static final String LOG_TAG = "AsyncTask";
  
  private static final int MAXIMUM_POOL_SIZE = 128;
  
  private static final int MESSAGE_POST_PROGRESS = 2;
  
  private static final int MESSAGE_POST_RESULT = 1;
  
  public static final Executor THREAD_POOL_EXECUTOR;
  
  private static volatile Executor sDefaultExecutor;
  
  private static final InternalHandler sHandler;
  
  private static final BlockingQueue<Runnable> sPoolWorkQueue;
  
  private static final ThreadFactory sThreadFactory = new ThreadFactory() {
      private final AtomicInteger mCount = new AtomicInteger(1);
      
      public Thread newThread(Runnable param1Runnable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ModernAsyncTask #");
        stringBuilder.append(this.mCount.getAndIncrement());
        return new Thread(param1Runnable, stringBuilder.toString());
      }
    };
  
  private final FutureTask<Result> mFuture = new FutureTask<Result>(this.mWorker) {
      protected void done() {
        try {
          Result result = get();
          ModernAsyncTask.this.postResultIfNotInvoked(result);
        } catch (InterruptedException interruptedException) {
          Log.w("AsyncTask", interruptedException);
        } catch (ExecutionException executionException) {
          throw new RuntimeException("An error occured while executing doInBackground()", executionException.getCause());
        } catch (CancellationException cancellationException) {
          ModernAsyncTask.this.postResultIfNotInvoked(null);
        } catch (Throwable throwable) {
          throw new RuntimeException("An error occured while executing doInBackground()", throwable);
        } 
      }
    };
  
  private volatile Status mStatus = Status.PENDING;
  
  private final AtomicBoolean mTaskInvoked = new AtomicBoolean();
  
  private final WorkerRunnable<Params, Result> mWorker = new WorkerRunnable<Params, Result>() {
      public Result call() throws Exception {
        ModernAsyncTask.this.mTaskInvoked.set(true);
        Process.setThreadPriority(10);
        return ModernAsyncTask.this.postResult((Result)ModernAsyncTask.this.doInBackground((Object[])this.mParams));
      }
    };
  
  static {
    sPoolWorkQueue = new LinkedBlockingQueue<Runnable>(10);
    THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    sHandler = new InternalHandler();
    sDefaultExecutor = THREAD_POOL_EXECUTOR;
  }
  
  public static void execute(Runnable paramRunnable) {
    sDefaultExecutor.execute(paramRunnable);
  }
  
  private void finish(Result paramResult) {
    if (isCancelled()) {
      onCancelled(paramResult);
    } else {
      onPostExecute(paramResult);
    } 
    this.mStatus = Status.FINISHED;
  }
  
  public static void init() {
    sHandler.getLooper();
  }
  
  private Result postResult(Result paramResult) {
    sHandler.obtainMessage(1, new AsyncTaskResult(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }
  
  private void postResultIfNotInvoked(Result paramResult) {
    if (!this.mTaskInvoked.get())
      postResult(paramResult); 
  }
  
  public static void setDefaultExecutor(Executor paramExecutor) {
    sDefaultExecutor = paramExecutor;
  }
  
  public final boolean cancel(boolean paramBoolean) {
    return this.mFuture.cancel(paramBoolean);
  }
  
  protected abstract Result doInBackground(Params... paramVarArgs);
  
  public final ModernAsyncTask<Params, Progress, Result> execute(Params... paramVarArgs) {
    return executeOnExecutor(sDefaultExecutor, paramVarArgs);
  }
  
  public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor paramExecutor, Params... paramVarArgs) {
    if (this.mStatus != Status.PENDING) {
      switch (this.mStatus) {
        default:
          this.mStatus = Status.RUNNING;
          onPreExecute();
          this.mWorker.mParams = paramVarArgs;
          paramExecutor.execute(this.mFuture);
          return this;
        case FINISHED:
          throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
        case RUNNING:
          break;
      } 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    } 
  }
  
  public final Result get() throws InterruptedException, ExecutionException {
    return this.mFuture.get();
  }
  
  public final Result get(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
    return this.mFuture.get(paramLong, paramTimeUnit);
  }
  
  public final Status getStatus() {
    return this.mStatus;
  }
  
  public final boolean isCancelled() {
    return this.mFuture.isCancelled();
  }
  
  protected void onCancelled() {}
  
  protected void onCancelled(Result paramResult) {
    onCancelled();
  }
  
  protected void onPostExecute(Result paramResult) {}
  
  protected void onPreExecute() {}
  
  protected void onProgressUpdate(Progress... paramVarArgs) {}
  
  protected final void publishProgress(Progress... paramVarArgs) {
    if (!isCancelled())
      sHandler.obtainMessage(2, new AsyncTaskResult<Progress>(this, paramVarArgs)).sendToTarget(); 
  }
  
  private static class AsyncTaskResult<Data> {
    final Data[] mData;
    
    final ModernAsyncTask mTask;
    
    AsyncTaskResult(ModernAsyncTask param1ModernAsyncTask, Data... param1VarArgs) {
      this.mTask = param1ModernAsyncTask;
      this.mData = param1VarArgs;
    }
  }
  
  private static class InternalHandler extends Handler {
    private InternalHandler() {}
    
    public void handleMessage(Message param1Message) {
      ModernAsyncTask.AsyncTaskResult asyncTaskResult = (ModernAsyncTask.AsyncTaskResult)param1Message.obj;
      switch (param1Message.what) {
        default:
          return;
        case 2:
          asyncTaskResult.mTask.onProgressUpdate((Object[])asyncTaskResult.mData);
        case 1:
          break;
      } 
      asyncTaskResult.mTask.finish((Result)asyncTaskResult.mData[0]);
    }
  }
  
  public enum Status {
    FINISHED, PENDING, RUNNING;
    
    static {
      $VALUES = new Status[] { PENDING, RUNNING, FINISHED };
    }
  }
  
  private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
    Params[] mParams;
    
    private WorkerRunnable() {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\content\ModernAsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */