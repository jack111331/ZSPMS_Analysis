package com.zz.sdk.e;

import android.content.Context;
import android.widget.LinearLayout;

final class ah extends LinearLayout {
  public ah(af paramaf, Context paramContext) {
    super(paramContext);
  }
  
  protected void drawableStateChanged() {
    Object object = getTag();
    if (object instanceof ag)
      ((ag)object).a(getDrawableState()); 
    super.drawableStateChanged();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */