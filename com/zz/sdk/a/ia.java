package com.zz.sdk.a;

import android.view.View;
import android.widget.ImageView;

class ia implements View.OnFocusChangeListener {
  ia(hy paramhy) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    byte b;
    ImageView imageView = this.a.n;
    if (paramBoolean && this.a.a.getText().length() > 0) {
      b = 0;
    } else {
      b = 8;
    } 
    imageView.setVisibility(b);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */