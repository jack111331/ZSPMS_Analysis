package com.alipay.tscenter.biz.rpc.deviceFp;

import com.alipay.mobile.framework.service.annotation.OperationType;

public interface BugTrackMessageService {
  @OperationType("alipay.security.errorLog.collect")
  String logCollect(String paramString);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\tscenter\biz\rpc\deviceFp\BugTrackMessageService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */