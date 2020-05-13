package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;

public final class WXAppLaunchData {
  public static final String ACTION_HANDLE_WXAPPLAUNCH = ".ACTION_HANDLE_WXAPPLAUNCH";
  
  public static final String ACTION_HANDLE_WXAPP_RESULT = ".ACTION_HANDLE_WXAPP_RESULT";
  
  public static final String ACTION_HANDLE_WXAPP_SHOW = ".ACTION_HANDLE_WXAPP_SHOW";
  
  public int launchType;
  
  public String message;
  
  public static class Builder {
    public static WXAppLaunchData fromBundle(Bundle param1Bundle) {
      WXAppLaunchData wXAppLaunchData = new WXAppLaunchData();
      wXAppLaunchData.launchType = param1Bundle.getInt("_wxapplaunchdata_launchType");
      wXAppLaunchData.message = param1Bundle.getString("_wxapplaunchdata_message");
      return wXAppLaunchData;
    }
    
    public static Bundle toBundle(WXAppLaunchData param1WXAppLaunchData) {
      Bundle bundle = new Bundle();
      bundle.putInt("_wxapplaunchdata_launchType", param1WXAppLaunchData.launchType);
      bundle.putString("_wxapplaunchdata_message", param1WXAppLaunchData.message);
      return bundle;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\modelmsg\WXAppLaunchData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */