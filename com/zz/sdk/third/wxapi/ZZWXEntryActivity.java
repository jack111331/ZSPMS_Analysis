package com.zz.sdk.third.wxapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.zz.sdk.third.k;

public abstract class ZZWXEntryActivity extends Activity {
  private static Object a;
  
  private static Object a(Activity paramActivity) {
    return new a(paramActivity);
  }
  
  public static void onCreate(Activity paramActivity) {
    try {
      a = null;
      if (k.d != null) {
        IWXAPI iWXAPI = WXAPIFactory.createWXAPI((Context)paramActivity, k.e);
        a = iWXAPI;
        iWXAPI.handleIntent(paramActivity.getIntent(), (IWXAPIEventHandler)a(paramActivity));
      } 
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      paramActivity.finish();
    } 
  }
  
  public static void onDestroy(Activity paramActivity) {
    a = null;
  }
  
  public static void onNewIntent(Activity paramActivity, Intent paramIntent) {
    if (a != null)
      try {
        ((IWXAPI)a).handleIntent(paramIntent, (IWXAPIEventHandler)a(paramActivity));
      } catch (Throwable throwable) {
        throwable.printStackTrace();
      }  
  }
  
  public static void onWxResp(Activity paramActivity, BaseResp paramBaseResp) {
    k.a(paramActivity, paramBaseResp);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    onCreate(this);
  }
  
  protected void onDestroy() {
    super.onDestroy();
    onDestroy(this);
  }
  
  protected void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    onNewIntent(this, paramIntent);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\third\wxapi\ZZWXEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */