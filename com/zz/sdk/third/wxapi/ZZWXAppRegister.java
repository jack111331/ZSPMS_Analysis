package com.zz.sdk.third.wxapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.zz.sdk.i.cv;

public class ZZWXAppRegister extends BroadcastReceiver {
  public void onReceive(Context paramContext, Intent paramIntent) {
    String str;
    paramIntent = (Intent)cv.g().get("WE_CHAT_APP_ID");
    if (paramIntent == null) {
      paramIntent = null;
    } else {
      str = paramIntent + "";
    } 
    if (!TextUtils.isEmpty(str))
      WXAPIFactory.createWXAPI(paramContext, null).registerApp(str); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\third\wxapi\ZZWXAppRegister.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */