package com.herosdk.base;

import android.app.Activity;
import com.herosdk.bean.RoleInfo;

public interface IUserBase {
  String getChannelLoginParams();
  
  void login(Activity paramActivity);
  
  void logout(Activity paramActivity);
  
  void submitRoleInfo(Activity paramActivity, RoleInfo paramRoleInfo, int paramInt);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\base\IUserBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */