package com.sdk.mobile.b;

import android.content.Context;
import com.sdk.base.framework.a.c;
import com.sdk.base.framework.a.d;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.c.b;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.app.AppUtils;
import com.sdk.base.module.b.a;
import com.sdk.mobile.config.MobileConfig;

public class a<T> extends a<T> {
  private static final String e = a.class.getSimpleName();
  
  private static final boolean f = c.h;
  
  public a(Context paramContext, com.sdk.base.framework.b.a<T> parama) {
    super(paramContext, parama, (b)new MobileConfig());
  }
  
  public c<T> a(int paramInt) {
    DataInfo dataInfo = new DataInfo();
    dataInfo.putData("serviceType", Integer.valueOf(paramInt));
    dataInfo.putData("privateIp", AppUtils.getLocalIPAddress());
    return a(this.d, "/dro/netm/v1.0/qc", dataInfo, a(), 0, d.a.b);
  }
  
  public c a(String paramString) {
    DataInfo dataInfo = new DataInfo();
    dataInfo.putData("accessCode", paramString);
    return a(this.d, "/api/netm/v1.0/qhbt", dataInfo, a(), 0, d.a.b);
  }
  
  public c a(String paramString1, String paramString2) {
    DataInfo dataInfo = new DataInfo();
    dataInfo.putData("accessCode", paramString1);
    dataInfo.putData("mobile", paramString2);
    return a(this.d, "/api/netm/v1.0/qhbv", dataInfo, a(), 0, d.a.b);
  }
  
  public c<T> b(int paramInt) {
    DataInfo dataInfo = new DataInfo();
    dataInfo.putData("serviceType", Integer.valueOf(paramInt));
    return a(this.d, "/dro/netm/v1.0/gctcbs", dataInfo, a(), 0, d.a.b);
  }
  
  public c b(String paramString1, String paramString2) {
    DataInfo dataInfo = new DataInfo();
    dataInfo.putData("accessCode", paramString1);
    dataInfo.putData("mobile", paramString2);
    return a(this.d, "/dro/netm/v1.0/gmctc", dataInfo, a(), 0, d.a.b);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\mobile\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */