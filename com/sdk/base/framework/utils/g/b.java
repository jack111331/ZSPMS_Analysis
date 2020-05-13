package com.sdk.base.framework.utils.g;

import android.content.Context;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.a;
import java.util.ArrayList;

public class b extends a {
  private static final String a = b.class.getName();
  
  private static boolean b = c.h;
  
  public static a a(Context paramContext, ArrayList<String> paramArrayList) {
    a a1 = a.c;
    return (paramArrayList != null) ? a.a(paramContext, paramArrayList, true) : a.a(paramContext, null, false);
  }
  
  public enum a {
    a {
      public int a() {
        return 0;
      }
    },
    b {
      public int a() {
        return 1;
      }
    },
    c {
      public int a() {
        return -1;
      }
    };
    
    public abstract int a();
  }
  
  enum null {
    public int a() {
      return 0;
    }
  }
  
  enum null {
    public int a() {
      return 1;
    }
  }
  
  enum null {
    public int a() {
      return -1;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */