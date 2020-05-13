package com.alipay.security.mobile.module.http.model;

import com.alipay.security.mobile.module.a.a;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import java.util.HashMap;
import java.util.Map;

public final class b {
  public static c a(DataReportResult paramDataReportResult) {
    c c = new c();
    if (paramDataReportResult == null)
      return null; 
    c.a = paramDataReportResult.success;
    c.b = paramDataReportResult.resultCode;
    Map map = paramDataReportResult.resultData;
    if (map != null) {
      c.h = (String)map.get("apdid");
      c.i = (String)map.get("apdidToken");
      c.l = (String)map.get("dynamicKey");
      c.m = (String)map.get("timeInterval");
      c.n = (String)map.get("webrtcUrl");
      c.o = "";
      String str = (String)map.get("drmSwitch");
      if (a.b(str)) {
        if (str.length() > 0)
          c.j = str.charAt(0); 
        if (str.length() >= 3)
          c.k = str.charAt(2); 
      } 
      if (map.containsKey("apse_degrade"))
        c.p = (String)map.get("apse_degrade"); 
    } 
    return c;
  }
  
  private static DataReportRequest a(d paramd) {
    HashMap<Object, Object> hashMap;
    Map<String, String> map;
    DataReportRequest dataReportRequest = new DataReportRequest();
    if (paramd == null)
      return null; 
    dataReportRequest.os = a.d(paramd.a);
    dataReportRequest.rpcVersion = paramd.j;
    dataReportRequest.bizType = "1";
    dataReportRequest.bizData = new HashMap<Object, Object>();
    dataReportRequest.bizData.put("apdid", a.d(paramd.b));
    dataReportRequest.bizData.put("apdidToken", a.d(paramd.c));
    dataReportRequest.bizData.put("umidToken", a.d(paramd.d));
    dataReportRequest.bizData.put("dynamicKey", paramd.e);
    if (paramd.f == null) {
      hashMap = new HashMap<Object, Object>();
    } else {
      map = ((d)hashMap).f;
    } 
    dataReportRequest.deviceData = map;
    return dataReportRequest;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\http\model\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */