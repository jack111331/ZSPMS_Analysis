package com.zz.sdk.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.zz.sdk.i.h;

class ba implements View.OnFocusChangeListener {
  ba(ay paramay) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    byte b;
    ImageView imageView = this.a.o;
    if (paramBoolean && this.a.a.getText().length() > 0) {
      b = 0;
    } else {
      b = 8;
    } 
    imageView.setVisibility(b);
    h.a((Context)this.a.b, null, paramBoolean, null, null, ay.a(this.a));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */