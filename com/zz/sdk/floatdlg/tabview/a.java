package com.zz.sdk.floatdlg.tabview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class a implements View.OnClickListener {
  a(TabView paramTabView, ImageView paramImageView, c paramc, TextView paramTextView, int paramInt) {}
  
  public void onClick(View paramView) {
    TabView.a(this.e);
    this.a.setImageResource(this.b.a());
    this.c.setText(this.b.c());
    this.c.setTextColor(TabView.b(this.e));
    TabView.a(this.e, this.d);
    TabView.c(this.e);
    if (TabView.d(this.e) != null)
      TabView.d(this.e).a(this.d, this.a, this.c); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\tabview\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */