package com.aliyun.sls.android.sdk.core.callback;

import com.aliyun.sls.android.sdk.LogException;

public interface CompletedCallback<T1 extends com.aliyun.sls.android.sdk.core.Request, T2 extends com.aliyun.sls.android.sdk.core.Result> {
  void onFailure(T1 paramT1, LogException paramLogException);
  
  void onSuccess(T1 paramT1, T2 paramT2);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\core\callback\CompletedCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */