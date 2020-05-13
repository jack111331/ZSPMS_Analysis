package com.zz.sdk.e;

import android.content.Context;
import android.view.View;
import android.widget.GridView;

final class dr extends GridView {
  public dr(Context paramContext) {
    super(paramContext);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */