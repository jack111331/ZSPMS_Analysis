package com.aliyun.sls.android.sdk.core.retry;

public enum RetryType {
  RetryTypeShouldFixedTimeSkewedAndRetry, RetryTypeShouldNotRetry, RetryTypeShouldRetry;
  
  static {
    RetryTypeShouldFixedTimeSkewedAndRetry = new RetryType("RetryTypeShouldFixedTimeSkewedAndRetry", 2);
    $VALUES = new RetryType[] { RetryTypeShouldNotRetry, RetryTypeShouldRetry, RetryTypeShouldFixedTimeSkewedAndRetry };
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\core\retry\RetryType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */