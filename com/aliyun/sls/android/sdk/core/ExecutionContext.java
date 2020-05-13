package com.aliyun.sls.android.sdk.core;

import com.aliyun.sls.android.sdk.core.callback.CompletedCallback;
import okhttp3.OkHttpClient;

public class ExecutionContext<T extends Request> {
  private CancellationHandler cancellationHandler = new CancellationHandler();
  
  private OkHttpClient client;
  
  private CompletedCallback completedCallback;
  
  private T request;
  
  public ExecutionContext(OkHttpClient paramOkHttpClient, T paramT) {
    setClient(paramOkHttpClient);
    setRequest(paramT);
  }
  
  public CancellationHandler getCancellationHandler() {
    return this.cancellationHandler;
  }
  
  public OkHttpClient getClient() {
    return this.client;
  }
  
  public CompletedCallback getCompletedCallback() {
    return this.completedCallback;
  }
  
  public T getRequest() {
    return this.request;
  }
  
  public void setClient(OkHttpClient paramOkHttpClient) {
    this.client = paramOkHttpClient;
  }
  
  public void setCompletedCallback(CompletedCallback paramCompletedCallback) {
    this.completedCallback = paramCompletedCallback;
  }
  
  public void setRequest(T paramT) {
    this.request = paramT;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\core\ExecutionContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */