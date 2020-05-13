package com.zz.sdk.i;

public enum ce {
  A,
  a(-1),
  b(-13421773),
  c(-1),
  d(-10066330),
  e(-236427),
  f(-1069267900),
  g(-16777216),
  h(-3355444),
  i(-2529267),
  j(-65536),
  k(-12303292),
  l(-101887),
  m(-16777216),
  n(-12303292),
  o(-1),
  p(-3355444),
  q(-16777216),
  r(-7829368),
  s(-954304),
  t(-16777216),
  u(-1),
  v(-7829368),
  w(-1),
  x(-16777216),
  y(-8947849),
  z(9421605);
  
  private int B;
  
  static {
    A = new ce("CC_YB_ITEM", 26, -1009901);
    C = new ce[] { 
        a, b, c, d, e, f, g, h, i, j, 
        k, l, m, n, o, p, q, r, s, t, 
        u, v, w, x, y, z, A };
  }
  
  ce(int paramInt1) {
    this.B = paramInt1;
  }
  
  ce(ce paramce) {
    this.B = paramce.B;
  }
  
  public int a() {
    return this.B;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */