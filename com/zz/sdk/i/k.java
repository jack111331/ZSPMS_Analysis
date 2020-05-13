package com.zz.sdk.i;

import android.app.Activity;
import android.content.Context;
import android.view.View;

final class k implements View.OnClickListener {
  public void onClick(View paramView) {
    Context context = paramView.getContext();
    if (context instanceof Activity)
      h.a((Activity)context, "库洛游戏隐私政策"); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */