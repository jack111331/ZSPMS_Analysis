package com.zz.sdk.i;

import android.widget.TextView;

public enum cf {
  a(20.0F),
  b(16.0F),
  c(15.0F),
  d(16.0F),
  e(22.0F),
  f(16.0F),
  g(20.0F),
  h(14.0F),
  i(12.0F),
  j(12.0F),
  k(12.0F),
  l(18.0F),
  m(18.0F),
  n(22.0F),
  o(25.0F),
  p(16.0F),
  q(13.0F),
  r(20.0F),
  s(16.0F),
  t(18.0F),
  u(12.0F);
  
  private float v;
  
  cf(float paramFloat) {
    this.v = paramFloat;
  }
  
  public void a(TextView paramTextView) {
    paramTextView.setTextSize(1, this.v);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */