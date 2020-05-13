package com.zz.sdk.lib.widget;

import android.text.Editable;
import android.text.TextWatcher;

class k implements TextWatcher {
  k(EditTextWithDel paramEditTextWithDel) {}
  
  public void afterTextChanged(Editable paramEditable) {
    EditTextWithDel.a(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */