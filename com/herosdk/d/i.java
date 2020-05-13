package com.herosdk.d;

import com.herosdk.bean.UserInfo;
import com.herosdk.bean.b;
import java.util.List;

class i implements Runnable {
  i(g paramg, String paramString1, UserInfo paramUserInfo, String paramString2) {}
  
  public void run() {
    try {
      List<b> list = this.d.c();
      if (list != null) {
        for (byte b = 0; b < list.size(); b++) {
          b b1 = list.get(b);
          b1.a("0");
          if (b1.b().getUid().equals(this.a)) {
            b1.b().setToken(this.b.getToken());
            b1.b().setChannelToken(this.b.getChannelToken());
            if (b1.c().getRoleId().equals(this.c))
              b1.a("1"); 
          } 
        } 
        this.d.a(list);
      } 
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */