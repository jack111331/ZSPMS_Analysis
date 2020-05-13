package com.alipay.security.mobile.module.http.v2;

import android.content.Context;
import com.alipay.security.mobile.module.a.a;
import com.alipay.security.mobile.module.http.a;
import com.alipay.security.mobile.module.http.model.c;
import com.alipay.security.mobile.module.http.model.d;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import java.util.HashMap;
import java.util.Map;

public final class b implements a {
  private static a a = null;
  
  private static a b = null;
  
  public static a a(Context paramContext, String paramString) {
    Context context1 = null;
    Context context2 = null;
    if (paramContext == null)
      return (a)context2; 
    if (a == null) {
      com.alipay.security.mobile.module.http.b b1;
      if (paramContext == null) {
        paramContext = context1;
      } else {
        b1 = com.alipay.security.mobile.module.http.b.a(paramContext, paramString);
      } 
      b = (a)b1;
      a = new b();
    } 
    return a;
  }
  
  public final c a(d paramd) {
    HashMap<Object, Object> hashMap;
    DataReportRequest dataReportRequest = new DataReportRequest();
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
      dataReportRequest.deviceData = hashMap;
      return com.alipay.security.mobile.module.http.model.b.a(b.a(dataReportRequest));
    } 
    Map map = ((d)hashMap).f;
    dataReportRequest.deviceData = map;
    return com.alipay.security.mobile.module.http.model.b.a(b.a(dataReportRequest));
  }
  
  public final boolean a(String paramString) {
    return b.a(paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\http\v2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */