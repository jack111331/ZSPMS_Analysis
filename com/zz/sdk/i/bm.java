package com.zz.sdk.i;

class bm extends Thread {
  bm(bl parambl) {}
  
  public void run() {
    byte b = 0;
    while (!bl.a(this.a) && this.a.getVisibility() == 0) {
      bl.b(this.a).sendEmptyMessage(b);
      if (b == 3) {
        b = 0;
      } else {
        b++;
      } 
      try {
        Thread.sleep(500L);
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */