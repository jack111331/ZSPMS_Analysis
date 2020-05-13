package com.sdk.base.api;

public interface CallBack<T> {
  void onFailed(int paramInt1, int paramInt2, String paramString);
  
  void onSuccess(int paramInt1, String paramString1, int paramInt2, T paramT, String paramString2);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\api\CallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */