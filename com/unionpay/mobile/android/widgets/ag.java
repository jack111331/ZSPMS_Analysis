package com.unionpay.mobile.android.widgets;

import android.text.Editable;
import android.text.TextWatcher;

final class ag implements TextWatcher {
  private boolean b = true;
  
  private int c;
  
  private boolean d = false;
  
  ag(af paramaf) {}
  
  private String a(CharSequence paramCharSequence, int paramInt) {
    byte b1 = 0;
    int i = paramCharSequence.length();
    StringBuffer stringBuffer = new StringBuffer();
    byte b2 = 0;
    while (b2 < i) {
      char c = paramCharSequence.charAt(b2);
      byte b = b1;
      if (c != ' ') {
        b = ++b1;
        if (b2 != 0) {
          b = b1;
          if ((b1 & 0x3) == 1) {
            stringBuffer.append(' ');
            b = b1;
          } 
        } 
      } 
      if (b2 == paramInt)
        this.c = stringBuffer.length(); 
      if (c != ' ')
        stringBuffer.append(c); 
      b2++;
      b1 = b;
    } 
    if (paramInt == i)
      this.c = stringBuffer.length(); 
    return stringBuffer.toString();
  }
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 == 1 && paramInt3 == 0 && paramCharSequence.charAt(paramInt1) == ' ')
      this.d = true; 
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    if (this.b) {
      CharSequence charSequence;
      if (this.d) {
        CharSequence charSequence1 = paramCharSequence.subSequence(0, paramInt1 - 1);
        charSequence = charSequence1;
        if (paramInt1 < paramCharSequence.length())
          charSequence = charSequence1.toString() + paramCharSequence.subSequence(paramInt1, paramCharSequence.length()); 
        paramInt1--;
        this.d = false;
      } else {
        charSequence = paramCharSequence;
      } 
      this.b = false;
      paramCharSequence = a(charSequence, paramInt1 + paramInt3);
      this.a.b.c((String)paramCharSequence);
      u u = this.a.b;
      if (this.c <= 23) {
        paramInt1 = this.c;
      } else {
        paramInt1 = 23;
      } 
      u.b(paramInt1);
      this.b = true;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */