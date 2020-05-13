package com.herosdk.channel.hero;

import com.herosdk.base.IFactoryBase;
import com.herosdk.base.ILifecycleBase;
import com.herosdk.base.IPayBase;
import com.herosdk.base.ISdkBase;
import com.herosdk.base.IUserBase;

public class Factory implements IFactoryBase {
  public ILifecycleBase getLifecycle() {
    return Lifecycle.getInstance();
  }
  
  public IPayBase getPay() {
    return Pay.getInstance();
  }
  
  public ISdkBase getSdk() {
    return Sdk.getInstance();
  }
  
  public IUserBase getUser() {
    return User.getInstance();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\channel\hero\Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */