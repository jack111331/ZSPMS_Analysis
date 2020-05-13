package com.herosdk.channel.hero;

import com.herosdk.HeroSdk;
import com.zz.sdk.listener.IKickOffListener;

class Sdk$1 implements IKickOffListener {
  Sdk$1(Sdk paramSdk) {}
  
  public void onKickOff(int paramInt, String paramString) {
    if (HeroSdk.getInstance().getKickListener() != null)
      HeroSdk.getInstance().getKickListener().onKick(paramInt, paramString); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\channel\hero\Sdk$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */