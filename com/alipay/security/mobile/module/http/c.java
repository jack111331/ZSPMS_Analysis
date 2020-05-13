package com.alipay.security.mobile.module.http;

import com.alipay.security.mobile.module.a.a;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

final class c implements Runnable {
  c(b paramb, DataReportRequest paramDataReportRequest) {}
  
  public final void run() {
    try {
      b.a(b.a(this.b).reportData(this.a));
    } catch (Throwable throwable) {
      b.a(new DataReportResult());
      (b.a()).success = false;
      (b.a()).resultCode = "static data rpc upload error, " + a.a(throwable);
      a.a(throwable);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\http\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */