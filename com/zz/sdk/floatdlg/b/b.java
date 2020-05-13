package com.zz.sdk.floatdlg.b;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

class b implements TextWatcher {
  b(a parama) {}
  
  public void afterTextChanged(Editable paramEditable) {
    boolean bool;
    ImageView imageView = this.a.c;
    if (!this.a.b.hasFocus() || paramEditable.length() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    imageView.setVisibility(bool);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */