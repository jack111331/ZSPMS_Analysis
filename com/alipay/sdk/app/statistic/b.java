package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.packet.impl.c;
import com.alipay.sdk.util.i;
import java.io.IOException;

final class b implements Runnable {
  b(Context paramContext, String paramString) {}
  
  public final void run() {
    c c = new c();
    try {
      String str = i.b(this.a, "alipay_cashier_statistic_record", null);
      if (!TextUtils.isEmpty(str) && c.a(this.a, str) != null)
        i.a(this.a, "alipay_cashier_statistic_record"); 
    } catch (Throwable throwable) {}
    try {
      if (!TextUtils.isEmpty(this.b))
        c.a(this.a, this.b); 
    } catch (IOException iOException) {
      i.a(this.a, "alipay_cashier_statistic_record", this.b);
    } catch (Throwable throwable) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\app\statistic\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */