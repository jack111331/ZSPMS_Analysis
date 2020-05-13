package com.aliyun.sls.android.sdk.core.retry;

import com.aliyun.sls.android.sdk.LogException;
import com.aliyun.sls.android.sdk.SLSLog;

public class RetryHandler {
  private int maxRetryCount = 2;
  
  public RetryHandler(int paramInt) {
    setMaxRetryCount(paramInt);
  }
  
  public void setMaxRetryCount(int paramInt) {
    this.maxRetryCount = paramInt;
  }
  
  public RetryType shouldRetry(LogException paramLogException, int paramInt) {
    if (paramLogException == null || paramInt >= this.maxRetryCount)
      return RetryType.RetryTypeShouldNotRetry; 
    if (paramLogException.canceled.booleanValue())
      return RetryType.RetryTypeShouldNotRetry; 
    paramLogException.getErrorCode();
    paramLogException.getErrorMessage();
    if (paramLogException.responseCode >= 500)
      return RetryType.RetryTypeShouldRetry; 
    Exception exception = (Exception)paramLogException.getCause();
    if (exception instanceof java.io.InterruptedIOException && !(exception instanceof java.net.SocketTimeoutException)) {
      SLSLog.logError("[shouldRetry] - is interrupted!");
      return RetryType.RetryTypeShouldNotRetry;
    } 
    return (exception instanceof IllegalArgumentException) ? RetryType.RetryTypeShouldNotRetry : RetryType.RetryTypeShouldRetry;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\core\retry\RetryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */