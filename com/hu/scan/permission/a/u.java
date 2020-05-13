package com.hu.scan.permission.a;

import android.content.Context;
import android.net.sip.SipManager;
import android.net.sip.SipProfile;

class u implements o {
  private Context a;
  
  u(Context paramContext) {
    this.a = paramContext;
  }
  
  public boolean a() {
    if (!SipManager.isApiSupported(this.a))
      return true; 
    SipManager sipManager = SipManager.newInstance(this.a);
    if (sipManager == null)
      return true; 
    SipProfile.Builder builder = new SipProfile.Builder("Permission", "127.0.0.1");
    builder.setPassword("password");
    SipProfile sipProfile = builder.build();
    sipManager.open(sipProfile);
    sipManager.close(sipProfile.getUriString());
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */