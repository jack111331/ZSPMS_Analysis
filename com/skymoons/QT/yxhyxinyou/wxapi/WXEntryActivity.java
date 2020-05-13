package com.skymoons.QT.yxhyxinyou.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.zz.sdk.third.wxapi.ZZWXEntryActivity;

public class WXEntryActivity extends ZZWXEntryActivity {
  public static String TAG = "herosdk.WXEntryActivity";
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    try {
      Class.forName("org.jar.bloc.third.wxapi.BlocWXEntryActivity").getMethod("onCreate", new Class[] { Activity.class }).invoke(null, new Object[] { this });
    } catch (Exception exception) {
      Log.d(TAG, "onCreate:" + exception.getMessage());
    } 
  }
  
  protected void onDestroy() {
    super.onDestroy();
    try {
      Class.forName("org.jar.bloc.third.wxapi.BlocWXEntryActivity").getMethod("onDestroy", new Class[0]).invoke(null, new Object[0]);
    } catch (Exception exception) {
      Log.d(TAG, "onDestroy:" + exception.getMessage());
    } 
  }
  
  protected void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    try {
      Class.forName("org.jar.bloc.third.wxapi.BlocWXEntryActivity").getMethod("onNewIntent", new Class[] { Activity.class, Intent.class }).invoke(null, new Object[] { this, paramIntent });
    } catch (Exception exception) {
      Log.d(TAG, "onNewIntent:" + exception.getMessage());
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\skymoons\QT\yxhyxinyou\wxapi\WXEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */