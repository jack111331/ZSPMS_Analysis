package com.sdk.base.module.permission;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

public class PermissionActivity extends Activity {
  private static a a;
  
  @SuppressLint({"NewApi"})
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    String[] arrayOfString = getIntent().getStringArrayExtra("KEY_INPUT_PERMISSIONS");
    if (arrayOfString == null) {
      finish();
      return;
    } 
    if (a != null)
      requestPermissions(arrayOfString, 1); 
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    if (a != null)
      a.a(paramArrayOfString, paramArrayOfint); 
    a = null;
    finish();
  }
  
  protected static interface a {
    void a(String[] param1ArrayOfString, int[] param1ArrayOfint);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\module\permission\PermissionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */