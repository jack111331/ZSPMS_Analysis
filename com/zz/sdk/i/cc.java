package com.zz.sdk.i;

public enum cc {
  A,
  B,
  C,
  a(12.0F),
  b(55.0F),
  c(45.0F),
  d(40.0F),
  e(52.0F),
  f(25.0F),
  g(20.0F),
  h(25.0F),
  i(35.0F),
  j(30.0F),
  k(15.0F),
  l(16.0F),
  m(2.0F),
  n(1.0F),
  o(62.0F),
  p(40.0F),
  q(108.0F),
  r(150.0F),
  s(32.0F),
  t(16.0F),
  u(50.0F),
  v(48.0F),
  w(48.0F),
  x(8.0F),
  y(80.0F),
  z(8.0F);
  
  private float D;
  
  static {
    A = new cc("CC_YB_GRIDVIEW_SPACE_V", 26, 8.0F);
    B = new cc("CC_YB_GRIDVIEW_ITEM_HEIGHT", 27, 48.0F);
    C = new cc("CC_PAY_DIVIDER_LINE_HEIGHT", 28, 4.0F);
    E = new cc[] { 
        a, b, c, d, e, f, g, h, i, j, 
        k, l, m, n, o, p, q, r, s, t, 
        u, v, w, x, y, z, A, B, C };
  }
  
  cc(float paramFloat) {
    this.D = paramFloat;
  }
  
  public static int a(float paramFloat) {
    return (int)(bz.b() * paramFloat + 0.5F);
  }
  
  public int a() {
    return (int)(this.D * bz.b() + 0.5F);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */