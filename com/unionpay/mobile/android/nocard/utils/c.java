package com.unionpay.mobile.android.nocard.utils;

import android.content.Context;
import android.text.TextUtils;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.views.order.l;

public final class c {
  public static int a(Context paramContext, b paramb) {
    String str = PreferenceUtils.b(paramContext);
    int i = l.b.intValue();
    int j = i;
    if (!TextUtils.isEmpty(str)) {
      j = i;
      if (TextUtils.isDigitsOnly(str))
        j = Integer.valueOf(str).intValue(); 
    } 
    boolean bool1 = "0".equalsIgnoreCase(paramb.an);
    boolean bool2 = bool1;
    if (paramb.aw) {
      bool2 = bool1;
      if ((paramb.ao & 0x11101) == 0)
        bool2 = true; 
    } 
    if (bool2)
      return l.a.intValue(); 
    if (!TextUtils.isEmpty(paramb.u))
      j = l.b.intValue(); 
    if (f.a(paramb.t))
      j = l.b.intValue(); 
    return j;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocar\\utils\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */