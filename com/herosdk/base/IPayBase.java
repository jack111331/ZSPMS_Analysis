package com.herosdk.base;

import android.app.Activity;
import com.herosdk.bean.OrderInfo;
import com.herosdk.bean.RoleInfo;

public interface IPayBase {
  String getChannelPayParams();
  
  void pay(Activity paramActivity, OrderInfo paramOrderInfo, RoleInfo paramRoleInfo);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\base\IPayBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */