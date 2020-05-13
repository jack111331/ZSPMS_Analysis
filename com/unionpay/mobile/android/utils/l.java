package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.os.Handler;
import com.unionpay.mobile.android.nocard.views.b;
import org.simalliance.openmobileapi.SEService;

public final class l implements SEService.CallBack {
  private static SEService b = null;
  
  private Context a;
  
  private b c;
  
  private Handler.Callback d = new m(this);
  
  private Handler e = new Handler(this.d);
  
  public l() {}
  
  public l(Context paramContext, b paramb) {
    this.a = paramContext;
    this.c = paramb;
    if (b == null) {
      try {
        SEService sEService = new SEService();
        this(this.a, this);
        b = sEService;
        n n = new n();
        this(this);
        n.start();
      } catch (Throwable throwable) {
        throwable.printStackTrace();
        k.c("uppay", " service ERROR!!!");
        this.e.sendEmptyMessage(2);
      } 
      return;
    } 
    ((com.unionpay.mobile.android.nocard.views.l)this.c).v();
  }
  
  public static SEService a() {
    return b;
  }
  
  public final void serviceConnected(SEService paramSEService) {
    k.c("uppay", "se service connected");
    k.c("uppay", "mSEService:" + b);
    k.c("uppay", "mSEService.isConnected:" + b.isConnected());
    this.e.sendEmptyMessage(1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\utils\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */