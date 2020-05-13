package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import android.util.Log;

public class WXAPIFactory {
  private static final String TAG = "MicroMsg.PaySdk.WXFactory";
  
  private WXAPIFactory() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append(" should not be instantiated");
    throw new RuntimeException(stringBuilder.toString());
  }
  
  public static IWXAPI createWXAPI(Context paramContext, String paramString) {
    return createWXAPI(paramContext, paramString, false);
  }
  
  public static IWXAPI createWXAPI(Context paramContext, String paramString, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder("createWXAPI, appId = ");
    stringBuilder.append(paramString);
    stringBuilder.append(", checkSignature = ");
    stringBuilder.append(paramBoolean);
    Log.d("MicroMsg.PaySdk.WXFactory", stringBuilder.toString());
    return new WXApiImplV10(paramContext, paramString, paramBoolean);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\openapi\WXAPIFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */