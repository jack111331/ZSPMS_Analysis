package com.zz.sdk.a;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

class jx implements TextWatcher {
  View a;
  
  View b;
  
  public jx(jl paramjl, View paramView1, View paramView2) {
    this.a = paramView1;
    this.b = paramView2;
  }
  
  public void afterTextChanged(Editable paramEditable) {
    byte b = 8;
    if (this.a != null) {
      boolean bool;
      View view = this.a;
      if (!this.a.hasFocus() && paramEditable.length() == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      view.setVisibility(bool);
    } 
    if (this.b != null) {
      boolean bool;
      View view = this.b;
      if (!this.a.hasFocus() && paramEditable.length() == 0) {
        bool = b;
      } else {
        bool = false;
      } 
      view.setVisibility(bool);
    } 
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\jx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */