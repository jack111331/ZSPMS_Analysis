package com.herosdk.listener;

import com.herosdk.bean.UserInfo;

public interface ILoginListener {
  void onCancel();
  
  void onFailed(String paramString);
  
  void onSuccess(UserInfo paramUserInfo);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\ILoginListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */