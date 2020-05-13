package com.zz.sdk.a;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

class ac implements TextWatcher {
  ac(ab paramab) {}
  
  public void afterTextChanged(Editable paramEditable) {
    boolean bool;
    ImageView imageView = this.a.n;
    if (!this.a.a.hasFocus() || paramEditable.length() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    imageView.setVisibility(bool);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */