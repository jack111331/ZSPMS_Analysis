package com.herosdk.d;

import com.herosdk.bean.RoleInfo;
import com.herosdk.bean.UserInfo;
import com.herosdk.bean.b;
import java.util.Iterator;
import java.util.List;

class h implements Runnable {
  h(g paramg, RoleInfo paramRoleInfo) {}
  
  public void run() {
    try {
      String str = this.a.getRoleId();
      List<b> list = this.b.c();
      if (list != null) {
        Iterator<b> iterator = list.iterator();
        while (iterator.hasNext()) {
          if (((b)iterator.next()).c().getRoleId().equals(str))
            iterator.remove(); 
        } 
      } else {
        return;
      } 
    } catch (Exception exception) {
      return;
    } 
    UserInfo userInfo = x.a().h();
    b b = new b();
    this();
    b.a(userInfo);
    b.a(this.a);
    exception.add(b);
    this.b.a((List<b>)exception);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */