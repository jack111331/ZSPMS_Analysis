package org.jar.mvchelper.task.imp;

import org.jar.mvchelper.task.ICallback;

public abstract class SimpleCallback<DATA> implements ICallback<DATA> {
  public void onPreExecute(Object paramObject) {}
  
  public void onProgress(Object paramObject1, int paramInt, long paramLong1, long paramLong2, Object paramObject2) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\task\imp\SimpleCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */