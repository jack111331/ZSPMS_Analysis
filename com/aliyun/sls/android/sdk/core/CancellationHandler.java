package com.aliyun.sls.android.sdk.core;

import okhttp3.Call;

public class CancellationHandler {
  private volatile Call call;
  
  private volatile boolean isCancelled;
  
  public void cancel() {
    if (this.call != null)
      this.call.cancel(); 
    this.isCancelled = true;
  }
  
  public boolean isCancelled() {
    return this.isCancelled;
  }
  
  public void setCall(Call paramCall) {
    this.call = paramCall;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\core\CancellationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */