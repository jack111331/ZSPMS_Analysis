package com.xy.whf.base;

import java.util.ArrayList;
import java.util.List;

public class a {
  private static final a a = new a();
  
  private List<RootActivity> b = new ArrayList<RootActivity>();
  
  public static a a() {
    return a;
  }
  
  public void a(RootActivity paramRootActivity) {
    this.b.add(paramRootActivity);
  }
  
  public void b(RootActivity paramRootActivity) {
    this.b.remove(paramRootActivity);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\base\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */