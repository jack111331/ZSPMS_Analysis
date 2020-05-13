package com.hu.scan.permission.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

class q implements o {
  private Context a;
  
  q(Context paramContext) {
    this.a = paramContext;
  }
  
  @SuppressLint({"HardwareIds"})
  public boolean a() {
    TelephonyManager telephonyManager = (TelephonyManager)this.a.getSystemService("phone");
    return (!TextUtils.isEmpty(telephonyManager.getDeviceId()) || !TextUtils.isEmpty(telephonyManager.getSubscriberId()));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */