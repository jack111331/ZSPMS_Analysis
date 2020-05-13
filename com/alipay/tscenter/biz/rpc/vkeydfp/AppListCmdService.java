package com.alipay.tscenter.biz.rpc.vkeydfp;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.tscenter.biz.rpc.vkeydfp.request.AppListCmdRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.AppListCmdResult;

public interface AppListCmdService {
  @OperationType("alipay.security.vkeyDFP.appListCmd.get")
  AppListCmdResult getAppListCmd(AppListCmdRequest paramAppListCmdRequest);
  
  @OperationType("alipay.security.vkeyDFP.appListCmd.reGet")
  AppListCmdResult reGetAppListCmd(AppListCmdRequest paramAppListCmdRequest);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\tscenter\biz\rpc\vkeydfp\AppListCmdService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */