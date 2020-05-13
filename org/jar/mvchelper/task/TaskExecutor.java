package org.jar.mvchelper.task;

import org.jar.mvchelper.mvc.RequestHandle;

public interface TaskExecutor<DATA> extends RequestHandle {
  RequestHandle execute();
  
  ICallback<DATA> getCallback();
  
  Object getTask();
  
  boolean isExeRefresh();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\task\TaskExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */