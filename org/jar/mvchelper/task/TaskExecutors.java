package org.jar.mvchelper.task;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import org.jar.mvchelper.mvc.IAsyncDataSource;
import org.jar.mvchelper.mvc.IDataSource;
import org.jar.mvchelper.mvc.ProgressSender;
import org.jar.mvchelper.mvc.RequestHandle;
import org.jar.mvchelper.mvc.ResponseSender;

class TaskExecutors {
  public static <DATA> TaskExecutor<DATA> create(IAsyncDataSource<DATA> paramIAsyncDataSource, boolean paramBoolean, ICallback<DATA> paramICallback) {
    return new AsyncDataSourceExecutor<DATA>(paramIAsyncDataSource, paramBoolean, paramICallback);
  }
  
  public static <DATA> TaskExecutor<DATA> create(IDataSource<DATA> paramIDataSource, boolean paramBoolean, ICallback<DATA> paramICallback) {
    return new SyncDataSourceExecutor<DATA>(paramIDataSource, paramBoolean, paramICallback);
  }
  
  public static <DATA> TaskExecutor<DATA> create(IAsyncTask<DATA> paramIAsyncTask, ICallback<DATA> paramICallback) {
    return new AsyncTaskExecutor<DATA>(paramIAsyncTask, paramICallback);
  }
  
  public static <DATA> TaskExecutor<DATA> create(ITask<DATA> paramITask, ICallback<DATA> paramICallback) {
    return new SyncTaskExecutor<DATA>(paramITask, paramICallback);
  }
  
  private static abstract class AbsAsyncTaskExecutor<DATA> implements TaskExecutor<DATA> {
    private ICallback<DATA> callback;
    
    private final ISuperTask<DATA> realTask;
    
    private RequestHandle requestHandle;
    
    private TaskExecutors.TaskResponseSender<DATA> responseSender;
    
    public AbsAsyncTaskExecutor(ISuperTask<DATA> param1ISuperTask, ICallback<DATA> param1ICallback) {
      this.realTask = param1ISuperTask;
      this.callback = param1ICallback;
      if (param1ICallback == null) {
        this.responseSender = new TaskExecutors.TaskNoCallbackResponseSender<DATA>();
      } else {
        this.responseSender = new TaskExecutors.TaskHasCallbackResponseSender<DATA>();
      } 
    }
    
    public void cancle() {
      if (this.requestHandle != null)
        this.requestHandle.cancle(); 
      this.responseSender.sendCancel();
    }
    
    public final RequestHandle execute() {
      this.responseSender.sendPreExecute(this.realTask, this.callback);
      try {
        this.requestHandle = executeImp(this.responseSender);
      } catch (Exception exception) {
        this.responseSender.sendError(exception);
      } 
      return this;
    }
    
    protected abstract RequestHandle executeImp(ResponseSender<DATA> param1ResponseSender) throws Exception;
    
    public ICallback<DATA> getCallback() {
      return this.callback;
    }
    
    public ISuperTask<DATA> getTask() {
      return this.realTask;
    }
    
    public boolean isRunning() {
      return this.responseSender.isRunning();
    }
  }
  
  private static abstract class AbsSyncTaskExecutor<DATA> extends AsyncTask<Object, Object, DATA> implements TaskExecutor<DATA> {
    private ICallback<DATA> callback;
    
    private final ISuperTask<DATA> realTask;
    
    private final TaskExecutors.TaskResponseSender<DATA> responseSender;
    
    public AbsSyncTaskExecutor(ISuperTask<DATA> param1ISuperTask, ICallback<DATA> param1ICallback) {
      this.callback = param1ICallback;
      this.realTask = param1ISuperTask;
      if (param1ICallback == null) {
        this.responseSender = new TaskExecutors.TaskNoCallbackResponseSender<DATA>();
      } else {
        this.responseSender = new TaskExecutors.TaskHasCallbackResponseSender<DATA>();
      } 
    }
    
    protected abstract void cancelImp();
    
    public void cancle() {
      cancelImp();
      cancel(true);
      this.responseSender.sendCancel();
    }
    
    protected DATA doInBackground(Object... param1VarArgs) {
      try {
        return executeImp((ProgressSender)this.responseSender);
      } catch (Exception exception) {
        if (exception instanceof InterruptedException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.realTask.toString());
          stringBuilder.append(exception);
          Log.d("TaskHelper", stringBuilder.toString());
        } else {
          exception.printStackTrace();
        } 
        this.responseSender.sendError(exception);
        return null;
      } 
    }
    
    public RequestHandle execute() {
      this.responseSender.sendPreExecute(this.realTask, this.callback);
      if (Build.VERSION.SDK_INT >= 11) {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[] { Boolean.TRUE });
      } else {
        execute(new Object[] { Boolean.TRUE });
      } 
      return this;
    }
    
    protected abstract DATA executeImp(ProgressSender param1ProgressSender) throws Exception;
    
    public ICallback<DATA> getCallback() {
      return this.callback;
    }
    
    public ISuperTask<DATA> getTask() {
      return this.realTask;
    }
    
    public boolean isRunning() {
      return this.responseSender.isRunning();
    }
    
    protected void onPostExecute(DATA param1DATA) {
      super.onPostExecute(param1DATA);
      this.responseSender.sendData(param1DATA);
    }
  }
  
  private static class AsyncDataSourceExecutor<DATA> extends AbsAsyncTaskExecutor<DATA> {
    private IAsyncDataSource<DATA> dataSource;
    
    private final boolean isExeRefresh;
    
    public AsyncDataSourceExecutor(IAsyncDataSource<DATA> param1IAsyncDataSource, boolean param1Boolean, ICallback<DATA> param1ICallback) {
      super((ISuperTask<DATA>)param1IAsyncDataSource, param1ICallback);
      this.dataSource = param1IAsyncDataSource;
      this.isExeRefresh = param1Boolean;
    }
    
    protected RequestHandle executeImp(ResponseSender<DATA> param1ResponseSender) throws Exception {
      return this.isExeRefresh ? this.dataSource.refresh(param1ResponseSender) : this.dataSource.loadMore(param1ResponseSender);
    }
    
    public boolean isExeRefresh() {
      return this.isExeRefresh;
    }
  }
  
  private static class AsyncTaskExecutor<DATA> extends AbsAsyncTaskExecutor<DATA> {
    private IAsyncTask<DATA> task;
    
    public AsyncTaskExecutor(IAsyncTask<DATA> param1IAsyncTask, ICallback<DATA> param1ICallback) {
      super(param1IAsyncTask, param1ICallback);
      this.task = param1IAsyncTask;
    }
    
    protected RequestHandle executeImp(ResponseSender<DATA> param1ResponseSender) throws Exception {
      return this.task.execute(param1ResponseSender);
    }
    
    public boolean isExeRefresh() {
      return true;
    }
  }
  
  private static class SyncDataSourceExecutor<DATA> extends AbsSyncTaskExecutor<DATA> {
    private final boolean isExeRefresh;
    
    private IDataSource<DATA> task;
    
    public SyncDataSourceExecutor(IDataSource<DATA> param1IDataSource, boolean param1Boolean, ICallback<DATA> param1ICallback) {
      super((ISuperTask<DATA>)param1IDataSource, param1ICallback);
      this.task = param1IDataSource;
      this.isExeRefresh = param1Boolean;
    }
    
    protected void cancelImp() {}
    
    protected DATA executeImp(ProgressSender param1ProgressSender) throws Exception {
      return (DATA)(this.isExeRefresh ? this.task.refresh() : this.task.loadMore());
    }
    
    public boolean isExeRefresh() {
      return this.isExeRefresh;
    }
  }
  
  private static class SyncTaskExecutor<DATA> extends AbsSyncTaskExecutor<DATA> {
    private ITask<DATA> task;
    
    public SyncTaskExecutor(ITask<DATA> param1ITask, ICallback<DATA> param1ICallback) {
      super(param1ITask, param1ICallback);
      this.task = param1ITask;
    }
    
    protected void cancelImp() {
      this.task.cancel();
    }
    
    protected DATA executeImp(ProgressSender param1ProgressSender) throws Exception {
      return this.task.execute(param1ProgressSender);
    }
    
    public boolean isExeRefresh() {
      return true;
    }
  }
  
  private static class TaskHasCallbackResponseSender<DATA> implements TaskResponseSender<DATA> {
    private ICallback<DATA> callback;
    
    private Handler handler = new Handler(Looper.getMainLooper());
    
    private boolean isRunning;
    
    private Object realTask;
    
    private void onPostExecute(final Code code, final Exception exception, final DATA data) {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        this.handler.post(new Runnable() {
              public void run() {
                TaskExecutors.TaskHasCallbackResponseSender.this.onPostExecuteMainThread(code, exception, (DATA)data);
              }
            });
      } else {
        onPostExecuteMainThread(code, exception, data);
      } 
    }
    
    private void onPostExecuteMainThread(Code param1Code, Exception param1Exception, DATA param1DATA) {
      if (!this.isRunning)
        return; 
      this.isRunning = false;
      ICallback<DATA> iCallback = this.callback;
      if (iCallback != null)
        iCallback.onPostExecute(this.realTask, param1Code, param1Exception, param1DATA); 
      this.realTask = null;
      this.callback = null;
    }
    
    private void onPreExecute() {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        this.handler.post(new Runnable() {
              public void run() {
                TaskExecutors.TaskHasCallbackResponseSender.this.onPreExecuteMainThread();
              }
            });
      } else {
        onPreExecuteMainThread();
      } 
    }
    
    private void onPreExecuteMainThread() {
      ICallback<DATA> iCallback = this.callback;
      if (iCallback != null)
        iCallback.onPreExecute(this.realTask); 
    }
    
    private void onProgress(final int percent, final long current, final long total, final Object extraData) {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        this.handler.post(new Runnable() {
              public void run() {
                TaskExecutors.TaskHasCallbackResponseSender.this.onProgressMainThread(percent, current, total, extraData);
              }
            });
      } else {
        onProgressMainThread(percent, current, total, extraData);
      } 
    }
    
    private void onProgressMainThread(int param1Int, long param1Long1, long param1Long2, Object param1Object) {
      ICallback<DATA> iCallback = this.callback;
      if (iCallback != null)
        iCallback.onProgress(this.realTask, param1Int, param1Long1, param1Long2, param1Object); 
    }
    
    public boolean isRunning() {
      return this.isRunning;
    }
    
    public void sendCancel() {
      onPostExecute(Code.CANCEL, null, null);
    }
    
    public void sendData(DATA param1DATA) {
      onPostExecute(Code.SUCCESS, null, param1DATA);
    }
    
    public void sendError(Exception param1Exception) {
      onPostExecute(Code.EXCEPTION, param1Exception, null);
    }
    
    public void sendPreExecute(Object param1Object, ICallback<DATA> param1ICallback) {
      this.realTask = param1Object;
      this.callback = param1ICallback;
      this.isRunning = true;
      onPreExecute();
    }
    
    public void sendProgress(long param1Long1, long param1Long2, Object param1Object) {
      int i;
      if (param1Long1 == 0L || param1Long2 == 0L) {
        i = 0;
      } else {
        i = (int)(100L * param1Long1 / param1Long2);
      } 
      onProgress(i, param1Long1, param1Long2, param1Object);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.onPreExecuteMainThread();
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.onProgressMainThread(percent, current, total, extraData);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.onPostExecuteMainThread(code, exception, (DATA)data);
    }
  }
  
  private static class TaskNoCallbackResponseSender<DATA> implements TaskResponseSender<DATA> {
    private volatile boolean isRunning;
    
    private TaskNoCallbackResponseSender() {}
    
    public boolean isRunning() {
      return this.isRunning;
    }
    
    public void sendCancel() {
      this.isRunning = false;
    }
    
    public void sendData(DATA param1DATA) {
      this.isRunning = false;
    }
    
    public void sendError(Exception param1Exception) {
      this.isRunning = false;
    }
    
    public void sendPreExecute(Object param1Object, ICallback<DATA> param1ICallback) {
      this.isRunning = true;
    }
    
    public void sendProgress(long param1Long1, long param1Long2, Object param1Object) {}
  }
  
  private static interface TaskResponseSender<DATA> extends ResponseSender<DATA> {
    boolean isRunning();
    
    void sendCancel();
    
    void sendPreExecute(Object param1Object, ICallback<DATA> param1ICallback);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\task\TaskExecutors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */