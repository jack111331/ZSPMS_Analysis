package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.resource.c;

public final class as extends LinearLayout {
  private c a = null;
  
  private ImageView b = null;
  
  private ImageView c = null;
  
  public as(Context paramContext) {
    super(paramContext);
    this.a = c.a(paramContext);
    setBackgroundColor(0);
    setOrientation(1);
    this.c = new ImageView(paramContext);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, a.C);
    layoutParams.gravity = 80;
    addView((View)this.c, (ViewGroup.LayoutParams)layoutParams);
    Drawable drawable = this.a.a(1001);
    if (this.b != null)
      this.b.setBackgroundDrawable(drawable); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */