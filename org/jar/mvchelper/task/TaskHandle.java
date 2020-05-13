package org.jar.mvchelper.task;

import java.lang.ref.WeakReference;
import org.jar.mvchelper.mvc.RequestHandle;

public class TaskHandle implements RequestHandle {
  public static final int TYPE_ATTACH = 3;
  
  public static final int TYPE_CACHE = 2;
  
  public static final int TYPE_RUN = 1;
  
  private WeakReference<TaskHelper.MultiTaskBindProxyCallBack> taskImpWeakReference;
  
  private final WeakReference<Object> taskReference;
  
  private final int type;
  
  public TaskHandle(int paramInt, Object paramObject, TaskHelper.MultiTaskBindProxyCallBack paramMultiTaskBindProxyCallBack) {
    this.type = paramInt;
    this.taskReference = new WeakReference(paramObject);
    if (paramMultiTaskBindProxyCallBack != null)
      this.taskImpWeakReference = new WeakReference<TaskHelper.MultiTaskBindProxyCallBack>(paramMultiTaskBindProxyCallBack); 
  }
  
  public void cancle() {
    if (this.taskImpWeakReference == null)
      return; 
    TaskHelper.MultiTaskBindProxyCallBack multiTaskBindProxyCallBack = this.taskImpWeakReference.get();
    Object object = this.taskReference.get();
    if (multiTaskBindProxyCallBack == null || object == null)
      return; 
    multiTaskBindProxyCallBack.cancel(object);
  }
  
  public int getRunType() {
    return this.type;
  }
  
  public boolean isRunning() {
    if (this.taskImpWeakReference == null)
      return false; 
    TaskHelper.MultiTaskBindProxyCallBack multiTaskBindProxyCallBack = this.taskImpWeakReference.get();
    return (multiTaskBindProxyCallBack != null) ? multiTaskBindProxyCallBack.isRunning() : false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\task\TaskHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */