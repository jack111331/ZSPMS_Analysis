package com.zz.sdk.lib.widget;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.zz.sdk.i.ci;

class o implements TextWatcher {
  o(SecurityCodeView paramSecurityCodeView) {}
  
  public void afterTextChanged(Editable paramEditable) {
    try {
      if (!TextUtils.isEmpty(paramEditable.toString())) {
        if (SecurityCodeView.a(this.a).length() > 3) {
          SecurityCodeView.b(this.a).setText("");
          return;
        } 
      } else {
        return;
      } 
      SecurityCodeView.a(this.a).append((CharSequence)paramEditable);
      SecurityCodeView.b(this.a).setText("");
      SecurityCodeView.a(this.a, SecurityCodeView.a(this.a).length());
      SecurityCodeView.a(this.a, SecurityCodeView.a(this.a).toString());
      if (SecurityCodeView.c(this.a) == 4 && SecurityCodeView.d(this.a) != null)
        SecurityCodeView.d(this.a).a(); 
      byte b = 0;
      while (true) {
        if (b < SecurityCodeView.c(this.a)) {
          SecurityCodeView.f(this.a)[b].setText(String.valueOf(SecurityCodeView.e(this.a).charAt(b)));
          SecurityCodeView.f(this.a)[b].setBackgroundResource(ci.a(SecurityCodeView.g(this.a), 2130837679));
          b++;
          continue;
        } 
        return;
      } 
    } catch (Exception exception) {}
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */