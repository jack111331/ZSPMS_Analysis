package com.zz.sdk.e;

import android.text.Editable;
import android.text.TextWatcher;

class do implements TextWatcher {
  private int b;
  
  do(cr paramcr, int paramInt) {
    this.b = paramInt;
  }
  
  public void afterTextChanged(Editable paramEditable) {
    cr.b(this.a, this.b);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */