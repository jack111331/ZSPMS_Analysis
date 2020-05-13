package com.tencent.wxop.stat.a;

public enum e {
  bA,
  bB,
  bC,
  bD,
  bE,
  bF,
  bx(1),
  by(2),
  bz(3);
  
  private int bG;
  
  static {
    bA = new e("CUSTOM", 3, 1000);
    bB = new e("ADDITION", 4, 1001);
    bC = new e("MONITOR_STAT", 5, 1002);
    bD = new e("MTA_GAME_USER", 6, 1003);
    bE = new e("NETWORK_MONITOR", 7, 1004);
    bF = new e("NETWORK_DETECTOR", 8, 1005);
    bH = new e[] { bx, by, bz, bA, bB, bC, bD, bE, bF };
  }
  
  e(int paramInt1) {
    this.bG = paramInt1;
  }
  
  public final int r() {
    return this.bG;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */