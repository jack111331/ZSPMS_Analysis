package com.herosdk;

class i implements Runnable {
  i(g paramg, String paramString1, String paramString2) {}
  
  public void run() {
    if (HeroSdk.getInstance().getPayListener() != null)
      HeroSdk.getInstance().getPayListener().onFailed(this.a, this.b); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */