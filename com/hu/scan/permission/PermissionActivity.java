package com.hu.scan.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.a.aa;
import android.support.a.ab;
import android.support.a.af;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

@af(b = 23)
public final class PermissionActivity extends Activity {
  private static final String a = "KEY_INPUT_PERMISSIONS";
  
  private static l b;
  
  private static void a(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 21) {
      Window window = paramActivity.getWindow();
      View view = window.getDecorView();
      view.setSystemUiVisibility(view.getSystemUiVisibility() | 0x400 | 0x100);
      window.addFlags(-2147483648);
      window.setStatusBarColor(0);
    } 
  }
  
  public static void a(Context paramContext, String[] paramArrayOfString, l paraml) {
    b = paraml;
    Intent intent = new Intent(paramContext, PermissionActivity.class);
    intent.setFlags(268435456);
    intent.putExtra("KEY_INPUT_PERMISSIONS", paramArrayOfString);
    paramContext.startActivity(intent);
  }
  
  protected void onCreate(@ab Bundle paramBundle) {
    super.onCreate(paramBundle);
    a(this);
    String[] arrayOfString = getIntent().getStringArrayExtra("KEY_INPUT_PERMISSIONS");
    if (arrayOfString != null && b != null) {
      requestPermissions(arrayOfString, 1);
    } else {
      b = null;
      finish();
    } 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    return (paramInt == 4) ? true : super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRequestPermissionsResult(int paramInt, @aa String[] paramArrayOfString, @aa int[] paramArrayOfint) {
    if (b != null) {
      b.b(paramArrayOfString);
      b = null;
    } 
    finish();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\PermissionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */