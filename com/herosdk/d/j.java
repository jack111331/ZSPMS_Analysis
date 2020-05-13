package com.herosdk.d;

import com.herosdk.bean.OrderInfo;
import java.util.ArrayList;
import java.util.List;

public class j {
  public static List<OrderInfo> a = new ArrayList<OrderInfo>();
  
  public static void a() {
    try {
      if (a != null)
        a.clear(); 
    } catch (Exception exception) {}
  }
  
  public static void a(OrderInfo paramOrderInfo) {
    try {
      if (a != null && paramOrderInfo != null)
        a.add(paramOrderInfo); 
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */