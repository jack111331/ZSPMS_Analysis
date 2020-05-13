package com.tencent.mm.opensdk.diffdev.a;

public enum g {
  D(402),
  E(403),
  F(404),
  G(405),
  H(408),
  I(500);
  
  private int code;
  
  g(int paramInt1) {
    this.code = paramInt1;
  }
  
  public final int getCode() {
    return this.code;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("UUIDStatusCode:");
    stringBuilder.append(this.code);
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\diffdev\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */