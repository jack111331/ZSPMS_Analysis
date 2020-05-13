package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import com.unionpay.mobile.android.hce.c;
import com.unionpay.mobile.android.hce.f;
import com.unionpay.mobile.android.model.a;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.views.ao;
import com.unionpay.mobile.android.pro.pboc.engine.b;
import com.unionpay.uppay.PayActivity;
import java.util.Iterator;

public final class v extends ao {
  public v(Context paramContext, e parame) {
    super(paramContext, parame);
  }
  
  protected final void a(Handler paramHandler) {
    Object object = ((PayActivity)this.d).a(f.class.toString());
    if (object != null)
      ((f)object).a(paramHandler); 
  }
  
  protected final void d(String paramString1, String paramString2) {
    if (b.bn) {
      a(this.a.ap, false);
      return;
    } 
    Object object = ((PayActivity)this.d).a(b.class.toString());
    if (object != null)
      ((b)object).a(new Handler(new w(this)), paramString1, paramString2); 
  }
  
  protected final boolean w() {
    return true;
  }
  
  protected final void x() {
    if (b.bb != null) {
      Iterator<c> iterator = b.bb.iterator();
      while (iterator.hasNext()) {
        ServiceConnection serviceConnection = ((c)iterator.next()).h();
        try {
          this.d.unbindService(serviceConnection);
        } catch (IllegalArgumentException illegalArgumentException) {}
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */