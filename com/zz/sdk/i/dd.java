package com.zz.sdk.i;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.zz.sdk.SampleWXPayEntryActivity;
import com.zz.sdk.b.a.at;

public class dd {
  static final boolean a = true;
  
  private static String b;
  
  private static Object c;
  
  private static Object d;
  
  private static SampleWXPayEntryActivity e;
  
  public static void a() {}
  
  private static void a(Context paramContext, String paramString) {
    String str = c();
    if (str == null || c == null || !str.equals(paramString)) {
      a(paramString);
      IWXAPI iWXAPI = WXAPIFactory.createWXAPI(paramContext, paramString);
      iWXAPI.registerApp(paramString);
      c = iWXAPI;
    } 
  }
  
  public static void a(SampleWXPayEntryActivity paramSampleWXPayEntryActivity) {
    e = null;
  }
  
  private static void a(String paramString) {
    b = paramString;
  }
  
  public static boolean a(Context paramContext, at paramat) {
    a(paramContext, paramat.v);
    if (c instanceof IWXAPI) {
      boolean bool;
      IWXAPI iWXAPI = (IWXAPI)c;
      if (iWXAPI.getWXAppSupportAPI() >= 570425345) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        PayReq payReq = new PayReq();
        payReq.appId = paramat.v;
        payReq.partnerId = paramat.w;
        payReq.prepayId = paramat.x;
        payReq.nonceStr = paramat.y;
        payReq.timeStamp = String.valueOf(paramat.A);
        payReq.packageValue = paramat.z;
        payReq.sign = paramat.B;
        d = new de();
        if (iWXAPI.sendReq((BaseReq)payReq))
          return true; 
      } 
    } 
    return false;
  }
  
  public static boolean a(SampleWXPayEntryActivity paramSampleWXPayEntryActivity, Intent paramIntent) {
    if (c instanceof IWXAPI) {
      IWXAPI iWXAPI = (IWXAPI)c;
      e = paramSampleWXPayEntryActivity;
      if (d instanceof IWXAPIEventHandler)
        return iWXAPI.handleIntent(paramIntent, (IWXAPIEventHandler)d); 
    } 
    return false;
  }
  
  public static void b() {
    if (c != null) {
      if (c instanceof IWXAPI)
        ((IWXAPI)c).unregisterApp(); 
      c = null;
      b = null;
      d = null;
    } 
  }
  
  private static String c() {
    return b;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */