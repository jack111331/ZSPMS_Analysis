package com.tencent.open.b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

public class b implements Serializable {
  public final HashMap<String, String> a = new HashMap<String, String>();
  
  public b(Bundle paramBundle) {
    if (paramBundle != null)
      for (String str : paramBundle.keySet())
        this.a.put(str, paramBundle.getString(str));  
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\open\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */