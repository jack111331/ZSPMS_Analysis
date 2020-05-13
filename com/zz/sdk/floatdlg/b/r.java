package com.zz.sdk.floatdlg.b;

import android.view.View;
import android.widget.ImageView;
import com.zz.sdk.i.h;

class r implements View.OnFocusChangeListener {
  r(p paramp) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    byte b;
    ImageView imageView = this.a.b;
    if (paramBoolean && this.a.a.getText().length() > 0) {
      b = 0;
    } else {
      b = 8;
    } 
    imageView.setVisibility(b);
    h.a(p.a(this.a), null, paramBoolean, null, null, p.b(this.a));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */