package org.jar.mvchelper.task;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jar.mvchelper.mvc.IAsyncDataSource;
import org.jar.mvchelper.mvc.IDataSource;
import org.jar.mvchelper.mvc.RequestHandle;
import org.jar.mvchelper.task.imp.MemoryCacheStore;

public class TaskHelper<BASE_DATA> implements RequestHandle {
  private ICacheStore cacheStore;
  
  private Set<ICallback<BASE_DATA>> callBacks = new LinkedHashSet<ICallback<BASE_DATA>>();
  
  private List<MultiTaskBindProxyCallBack<?, BASE_DATA>> taskImps = new LinkedList<MultiTaskBindProxyCallBack<?, BASE_DATA>>();
  
  public TaskHelper() {
    this((ICacheStore)new MemoryCacheStore(100));
  }
  
  public TaskHelper(ICacheStore paramICacheStore) {
    this.cacheStore = paramICacheStore;
  }
  
  public static <DATA> TaskExecutor<DATA> createExecutor(IAsyncDataSource<DATA> paramIAsyncDataSource, boolean paramBoolean, ICallback<DATA> paramICallback) {
    return TaskExecutors.create(paramIAsyncDataSource, paramBoolean, paramICallback);
  }
  
  public static <DATA> TaskExecutor<DATA> createExecutor(IDataSource<DATA> paramIDataSource, boolean paramBoolean, ICallback<DATA> paramICallback) {
    return TaskExecutors.create(paramIDataSource, paramBoolean, paramICallback);
  }
  
  public static <DATA> TaskExecutor<DATA> createExecutor(IAsyncTask<DATA> paramIAsyncTask, ICallback<DATA> paramICallback) {
    return TaskExecutors.create(paramIAsyncTask, paramICallback);
  }
  
  public static <DATA> TaskExecutor<DATA> createExecutor(ITask<DATA> paramITask, ICallback<DATA> paramICallback) {
    return TaskExecutors.create(paramITask, paramICallback);
  }
  
  private <DATA extends BASE_DATA> TaskHandle executeImp(ICacheConfig<DATA> paramICacheConfig, ISuperTask<DATA> paramISuperTask, boolean paramBoolean, ICallback<DATA> paramICallback) {
    if (paramISuperTask != null) {
      TaskHandle taskHandle1;
      if (paramICacheConfig != null) {
        String str = paramICacheConfig.getTaskKey(paramISuperTask);
        if (!TextUtils.isEmpty(str)) {
          MultiTaskBindProxyCallBack<Object, ?> multiTaskBindProxyCallBack = getTaskImpByTask(str);
          if (multiTaskBindProxyCallBack != null) {
            paramICallback.onPreExecute(paramISuperTask);
            multiTaskBindProxyCallBack.addCallBack(paramISuperTask, paramICallback);
            return new TaskHandle(3, paramISuperTask, multiTaskBindProxyCallBack);
          } 
        } else {
          throw new RuntimeException("ICacheConfig 返回的taskkey不能为空");
        } 
      } 
      TaskHandle taskHandle2 = loadCache(paramICacheConfig, paramISuperTask, paramICallback);
      if (taskHandle2 == null) {
        TaskExecutor<DATA> taskExecutor;
        paramICallback = new MultiTaskBindProxyCallBack<DATA, BASE_DATA>(paramICacheConfig, paramISuperTask, paramICallback, this.callBacks, this.taskImps, this.cacheStore);
        if (paramISuperTask instanceof IDataSource) {
          taskExecutor = TaskExecutors.create((IDataSource<DATA>)paramISuperTask, paramBoolean, paramICallback);
        } else if (paramISuperTask instanceof IAsyncDataSource) {
          taskExecutor = TaskExecutors.create((IAsyncDataSource<DATA>)paramISuperTask, paramBoolean, paramICallback);
        } else if (paramISuperTask instanceof ITask) {
          taskExecutor = TaskExecutors.create((ITask<DATA>)paramISuperTask, paramICallback);
        } else {
          taskExecutor = TaskExecutors.create((IAsyncTask<DATA>)paramISuperTask, paramICallback);
        } 
        MultiTaskBindProxyCallBack.access$102((MultiTaskBindProxyCallBack)paramICallback, taskExecutor);
        this.taskImps.add(paramICallback);
        taskExecutor.execute();
        taskHandle1 = new TaskHandle(1, paramISuperTask, (MultiTaskBindProxyCallBack)paramICallback);
      } else {
        taskHandle1 = taskHandle2;
      } 
      return taskHandle1;
    } 
    throw new RuntimeException("task不能为空");
  }
  
  private <DATA extends BASE_DATA> MultiTaskBindProxyCallBack<DATA, BASE_DATA> getTaskImpByTask(String paramString) {
    for (MultiTaskBindProxyCallBack<DATA, BASE_DATA> multiTaskBindProxyCallBack : this.taskImps) {
      if (paramString.equals(multiTaskBindProxyCallBack.taskKey))
        return multiTaskBindProxyCallBack; 
    } 
    return null;
  }
  
  private <DATA extends BASE_DATA> TaskHandle loadCache(ICacheConfig<DATA> paramICacheConfig, Object paramObject, ICallback<DATA> paramICallback) {
    if (paramICacheConfig != null) {
      String str = paramICacheConfig.getTaskKey(paramObject);
      ICacheStore.Cache cache = this.cacheStore.getCache(str);
      if (cache != null) {
        Object object = cache.data;
        if (paramICacheConfig.isUsefulCacheData(paramObject, cache.requestTime, cache.saveTime, (DATA)object)) {
          paramICallback.onPreExecute(paramObject);
          paramICallback.onPostExecute(paramObject, Code.SUCCESS, null, (DATA)object);
          return new TaskHandle(2, paramICallback, null);
        } 
      } 
      return null;
    } 
    return null;
  }
  
  public void cancel(Object paramObject) {
    if (paramObject == null)
      return; 
    if (paramObject instanceof TaskHandle) {
      ((TaskHandle)paramObject).cancle();
      return;
    } 
    Iterator<MultiTaskBindProxyCallBack<?, BASE_DATA>> iterator = this.taskImps.iterator();
    do {
    
    } while (iterator.hasNext() && !((MultiTaskBindProxyCallBack)iterator.next()).cancel(paramObject));
  }
  
  public void cancelAll() {
    if (this.taskImps.isEmpty())
      return; 
    Iterator<?> iterator = (new HashSet(this.taskImps)).iterator();
    while (iterator.hasNext())
      ((MultiTaskBindProxyCallBack)iterator.next()).cancelAllTaskBinder(); 
    this.taskImps.clear();
  }
  
  public void cancelAllWithTaskKey(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    MultiTaskBindProxyCallBack<Object, ?> multiTaskBindProxyCallBack = getTaskImpByTask(paramString);
    if (multiTaskBindProxyCallBack != null)
      multiTaskBindProxyCallBack.cancelAllTaskBinder(); 
  }
  
  public void cancle() {
    cancelAll();
  }
  
  public void destroy() {
    cancelAll();
  }
  
  public <DATA extends BASE_DATA> TaskHandle execute(IAsyncDataSource<DATA> paramIAsyncDataSource, ICallback<DATA> paramICallback) {
    return executeImp(null, (ISuperTask<DATA>)paramIAsyncDataSource, true, paramICallback);
  }
  
  public <DATA extends BASE_DATA> TaskHandle execute(IAsyncDataSource<DATA> paramIAsyncDataSource, boolean paramBoolean, ICallback<DATA> paramICallback) {
    return executeImp(null, (ISuperTask<DATA>)paramIAsyncDataSource, paramBoolean, paramICallback);
  }
  
  public <DATA extends BASE_DATA> TaskHandle execute(IDataSource<DATA> paramIDataSource, ICallback<DATA> paramICallback) {
    return executeImp(null, (ISuperTask<DATA>)paramIDataSource, true, paramICallback);
  }
  
  public <DATA extends BASE_DATA> TaskHandle execute(IDataSource<DATA> paramIDataSource, boolean paramBoolean, ICallback<DATA> paramICallback) {
    return executeImp(null, (ISuperTask<DATA>)paramIDataSource, paramBoolean, paramICallback);
  }
  
  public <DATA extends BASE_DATA> TaskHandle execute(IAsyncTask<DATA> paramIAsyncTask, ICallback<DATA> paramICallback) {
    return executeImp(null, paramIAsyncTask, true, paramICallback);
  }
  
  public <DATA extends BASE_DATA> TaskHandle execute(ITask<DATA> paramITask, ICallback<DATA> paramICallback) {
    return executeImp(null, paramITask, true, paramICallback);
  }
  
  public <DATA extends BASE_DATA> TaskHandle executeCache(IAsyncDataSource<DATA> paramIAsyncDataSource, ICallback<DATA> paramICallback, ICacheConfig<DATA> paramICacheConfig) {
    return executeImp(paramICacheConfig, (ISuperTask<DATA>)paramIAsyncDataSource, true, paramICallback);
  }
  
  public <DATA extends BASE_DATA> TaskHandle executeCache(IDataSource<DATA> paramIDataSource, ICallback<DATA> paramICallback, ICacheConfig<DATA> paramICacheConfig) {
    return executeImp(paramICacheConfig, (ISuperTask<DATA>)paramIDataSource, true, paramICallback);
  }
  
  public <DATA extends BASE_DATA> TaskHandle executeCache(IAsyncTask<DATA> paramIAsyncTask, ICallback<DATA> paramICallback, ICacheConfig<DATA> paramICacheConfig) {
    return executeImp(paramICacheConfig, paramIAsyncTask, true, paramICallback);
  }
  
  public <DATA extends BASE_DATA> TaskHandle executeCache(ITask<DATA> paramITask, ICallback<DATA> paramICallback, ICacheConfig<DATA> paramICacheConfig) {
    return executeImp(paramICacheConfig, paramITask, true, paramICallback);
  }
  
  public ICacheStore getCacheStore() {
    return this.cacheStore;
  }
  
  public boolean isRunning() {
    return false;
  }
  
  public void registerCallBack(ICallback<BASE_DATA> paramICallback) {
    this.callBacks.add(paramICallback);
  }
  
  public void unRegisterCallBack(ICallback<BASE_DATA> paramICallback) {
    this.callBacks.remove(paramICallback);
  }
  
  static class MultiTaskBindProxyCallBack<DATA extends BASE_DATA, BASE_DATA> implements ICallback<DATA> {
    private ICacheConfig<DATA> cacheConfig;
    
    private ICacheStore cacheStore;
    
    private ICallback<DATA> callback;
    
    private Set<ICallback<BASE_DATA>> callbacks;
    
    private Object realTask;
    
    private long requestTime;
    
    private Map<Object, ICallback<DATA>> selfCallBacks = new LinkedHashMap<Object, ICallback<DATA>>();
    
    private TaskExecutor<DATA> taskExecutor;
    
    private List<MultiTaskBindProxyCallBack<?, BASE_DATA>> taskImps;
    
    private String taskKey;
    
    public MultiTaskBindProxyCallBack(ICacheConfig<DATA> param1ICacheConfig, Object param1Object, ICallback<DATA> param1ICallback, Set<ICallback<BASE_DATA>> param1Set, List<MultiTaskBindProxyCallBack<?, BASE_DATA>> param1List, ICacheStore param1ICacheStore) {
      this.cacheConfig = param1ICacheConfig;
      this.requestTime = System.currentTimeMillis();
      if (param1ICacheConfig != null)
        this.taskKey = param1ICacheConfig.getTaskKey(param1Object); 
      this.callback = param1ICallback;
      this.callbacks = param1Set;
      this.taskImps = param1List;
      this.cacheStore = param1ICacheStore;
      this.realTask = param1Object;
    }
    
    public void addCallBack(Object param1Object, ICallback<DATA> param1ICallback) {
      if (this.selfCallBacks != null)
        this.selfCallBacks.put(param1Object, param1ICallback); 
    }
    
    public boolean cancel(Object param1Object) {
      Map<Object, ICallback<DATA>> map = getCallbacks();
      if (map == null)
        return false; 
      if (param1Object.equals(this.realTask)) {
        if (!map.isEmpty()) {
          if (this.callback != null)
            this.callback.onPostExecute(this.realTask, Code.CANCEL, null, null); 
          this.callback = null;
        } else {
          cancelAllTaskBinder();
        } 
        return true;
      } 
      Iterator<Map.Entry> iterator = map.entrySet().iterator();
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        Object object = entry.getKey();
        if (param1Object.equals(object)) {
          iterator.remove();
          ((ICallback)entry.getValue()).onPostExecute(object, Code.CANCEL, null, null);
          return true;
        } 
      } 
      return false;
    }
    
    public void cancelAllTaskBinder() {
      if (this.taskExecutor != null)
        this.taskExecutor.cancle(); 
    }
    
    public Map<Object, ICallback<DATA>> getCallbacks() {
      return this.selfCallBacks;
    }
    
    public boolean isRunning() {
      return (this.taskExecutor != null) ? this.taskExecutor.isRunning() : false;
    }
    
    public void onPostExecute(Object param1Object, Code param1Code, Exception param1Exception, DATA param1DATA) {
      for (Map.Entry<Object, ICallback<DATA>> entry : this.selfCallBacks.entrySet()) {
        Object object = entry.getKey();
        ((ICallback<DATA>)entry.getValue()).onPostExecute(object, param1Code, param1Exception, param1DATA);
      } 
      if (this.callback != null)
        this.callback.onPostExecute(param1Object, param1Code, param1Exception, param1DATA); 
      Iterator<ICallback<BASE_DATA>> iterator = this.callbacks.iterator();
      while (iterator.hasNext())
        ((ICallback<DATA>)iterator.next()).onPostExecute(param1Object, param1Code, param1Exception, param1DATA); 
      this.taskImps.remove(this);
      if (param1Code == Code.SUCCESS && this.cacheConfig != null) {
        long l = System.currentTimeMillis();
        if (this.cacheConfig.isNeedSave(param1Object, this.requestTime, l, param1DATA)) {
          param1Object = this.cacheConfig.getTaskKey(param1Object);
          this.cacheStore.saveCache((String)param1Object, this.requestTime, l, param1DATA);
        } 
      } 
      this.cacheStore = null;
      this.callbacks = null;
      this.cacheConfig = null;
      this.taskExecutor = null;
      this.taskImps = null;
      this.callback = null;
      this.selfCallBacks = null;
      this.realTask = null;
      this.taskKey = null;
    }
    
    public void onPreExecute(Object param1Object) {
      for (Map.Entry<Object, ICallback<DATA>> entry : this.selfCallBacks.entrySet()) {
        Object object = entry.getKey();
        ((ICallback)entry.getValue()).onPreExecute(object);
      } 
      if (this.callback != null)
        this.callback.onPreExecute(param1Object); 
      Iterator<ICallback<BASE_DATA>> iterator = this.callbacks.iterator();
      while (iterator.hasNext())
        ((ICallback)iterator.next()).onPreExecute(param1Object); 
    }
    
    public void onProgress(Object param1Object1, int param1Int, long param1Long1, long param1Long2, Object param1Object2) {
      for (Map.Entry<Object, ICallback<DATA>> entry : this.selfCallBacks.entrySet()) {
        Object object = entry.getKey();
        ((ICallback)entry.getValue()).onProgress(object, param1Int, param1Long1, param1Long2, param1Object2);
      } 
      if (this.callback != null)
        this.callback.onProgress(param1Object1, param1Int, param1Long1, param1Long2, param1Object2); 
      Iterator<ICallback<BASE_DATA>> iterator = this.callbacks.iterator();
      while (iterator.hasNext())
        ((ICallback)iterator.next()).onProgress(param1Object1, param1Int, param1Long1, param1Long2, param1Object2); 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\task\TaskHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */