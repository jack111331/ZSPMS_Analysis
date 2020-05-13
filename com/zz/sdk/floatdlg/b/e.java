package com.zz.sdk.floatdlg.b;

import android.view.View;
import android.widget.ImageView;

class e implements View.OnFocusChangeListener {
  e(a parama) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    byte b;
    ImageView imageView = this.a.c;
    if (paramBoolean && this.a.b.getText().length() > 0) {
      b = 0;
    } else {
      b = 8;
    } 
    imageView.setVisibility(b);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */