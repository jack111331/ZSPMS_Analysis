package com.zz.sdk.i;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

public enum cd {
  a(16.0F, 2.0F, 16.0F, 2.0F),
  b(16.0F, 16.0F, 16.0F, 16.0F),
  c(0.0F, 0.0F, 5.0F, 0.0F),
  d(8.0F, 0.0F, 8.0F, 0.0F),
  e(8.0F, 8.0F, 8.0F, 8.0F),
  f(0.0F, 0.0F, 0.0F, 0.0F),
  g(12.0F, 8.0F, 32.0F, 8.0F),
  h(8.0F, 4.0F, 8.0F, 4.0F),
  i(0.0F, 4.0F, 0.0F, 4.0F),
  j(0.0F, 0.0F, 0.0F, 0.0F),
  k(16.0F, 8.0F, 16.0F, 8.0F),
  l(16.0F, 4.0F, 16.0F, 4.0F),
  m(12.0F, 8.0F, 12.0F, 8.0F),
  n(12.0F, 8.0F, 180.0F, 8.0F),
  o(12.0F, 6.0F, 12.0F, 6.0F),
  p(8.0F, 4.0F, 8.0F, 4.0F),
  q(8.0F, 8.0F, 8.0F, 8.0F),
  r(12.0F, 8.0F, 12.0F, 8.0F),
  s(6.0F, 4.0F, 6.0F, 4.0F),
  t(16.0F, 8.0F, 6.0F, 6.0F),
  u(16.0F, 8.0F, 0.0F, 8.0F),
  v(16.0F, 12.0F, 16.0F, 12.0F),
  w(4.0F, 2.0F, 4.0F, 2.0F);
  
  private float A;
  
  private float x;
  
  private float y;
  
  private float z;
  
  static {
    B = new cd[] { 
        a, b, c, d, e, f, g, h, i, j, 
        k, l, m, n, o, p, q, r, s, t, 
        u, v, w };
  }
  
  cd(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    this.A = paramFloat4;
  }
  
  public Rect a() {
    return new Rect(cc.a(this.x), cc.a(this.y), cc.a(this.z), cc.a(this.A));
  }
  
  public void a(View paramView) {
    paramView.setPadding(cc.a(this.x), cc.a(this.y), cc.a(this.z), cc.a(this.A));
  }
  
  public void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams) {
    paramMarginLayoutParams.setMargins(cc.a(this.x), cc.a(this.y), cc.a(this.z), cc.a(this.A));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */