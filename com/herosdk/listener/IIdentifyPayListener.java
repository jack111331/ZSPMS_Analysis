package com.herosdk.listener;

import com.herosdk.bean.OrderInfo;
import com.herosdk.bean.RoleInfo;

public interface IIdentifyPayListener {
  void onResult(IPayListener paramIPayListener, OrderInfo paramOrderInfo, RoleInfo paramRoleInfo, String paramString1, int paramInt, String paramString2);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\IIdentifyPayListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */