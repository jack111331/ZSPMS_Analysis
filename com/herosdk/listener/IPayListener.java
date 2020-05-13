package com.herosdk.listener;

public interface IPayListener {
  void onCancel(String paramString);
  
  void onFailed(String paramString1, String paramString2);
  
  void onSuccess(String paramString1, String paramString2, String paramString3);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\IPayListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */