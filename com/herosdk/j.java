package com.herosdk;

class j implements Runnable {
  j(g paramg, String paramString) {}
  
  public void run() {
    if (HeroSdk.getInstance().getPayListener() != null)
      HeroSdk.getInstance().getPayListener().onCancel(this.a); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */