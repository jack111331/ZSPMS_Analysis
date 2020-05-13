package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.a.a.f;

public class UTDevice {
  private static String a(Context paramContext) {
    a a = b.b(paramContext);
    return (a == null || f.isEmpty(a.getUtdid())) ? "ffffffffffffffffffffffff" : a.getUtdid();
  }
  
  private static String b(Context paramContext) {
    String str = c.a(paramContext).d();
    if (str != null) {
      String str1 = str;
      return f.isEmpty(str) ? "ffffffffffffffffffffffff" : str1;
    } 
    return "ffffffffffffffffffffffff";
  }
  
  @Deprecated
  public static String getUtdid(Context paramContext) {
    return a(paramContext);
  }
  
  @Deprecated
  public static String getUtdidForUpdate(Context paramContext) {
    return b(paramContext);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\t\\utdid2\device\UTDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */