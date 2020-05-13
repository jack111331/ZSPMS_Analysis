package com.hu.plugin.bloc;

import android.app.Activity;
import android.util.Log;
import com.herosdk.bean.RoleInfo;
import com.herosdk.bean.UserInfo;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.IPluginListener;

public class SubmitRoleInfoPlugin implements IPluginListener {
  public void invokePlugin(Object... paramVarArgs) {
    try {
      Activity activity = (Activity)paramVarArgs[0];
      StringBuilder stringBuilder = new StringBuilder();
      this();
      Log.d("plugin.bloc", stringBuilder.append("call SubmitRoleInfoPlugin, activity = ").append(activity).toString());
      RoleInfo roleInfo = (RoleInfo)paramVarArgs[1];
      UserInfo userInfo = (UserInfo)paramVarArgs[2];
      ((Integer)paramVarArgs[3]).intValue();
      if (roleInfo != null && userInfo != null)
        BlocSdk.submitRoleInfo(activity, userInfo.getUid(), roleInfo.getServerId(), roleInfo.getServerName(), roleInfo.getRoleId(), roleInfo.getRoleName(), roleInfo.getRoleLevel(), roleInfo.getVipLevel(), roleInfo.getSumPay(), roleInfo.getBalanceLevelOne(), roleInfo.getBalanceLevelTwo()); 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\plugin\bloc\SubmitRoleInfoPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */