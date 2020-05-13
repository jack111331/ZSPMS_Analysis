package com.sdk.base.framework.c;

import java.util.HashMap;

public class c {
  public static String a = "aes_key";
  
  @Deprecated
  public static String b;
  
  @Deprecated
  public static String c;
  
  public static String d;
  
  public static String e;
  
  public static String f;
  
  public static boolean g;
  
  public static boolean h;
  
  public static boolean i;
  
  public static boolean j;
  
  public static String k;
  
  public static boolean l;
  
  private static HashMap<String, String> m = new HashMap<String, String>();
  
  static {
    b = "loginTime_string";
    c = "loginTime_long";
    d = "installTime";
    e = "simImsi";
    f = "cpk";
    g = true;
    h = false;
    i = false;
    j = false;
    k = "057156694441";
    l = false;
  }
  
  public enum a {
    a {
      public String a() {
        return "http://ms.zzx9.cn";
      }
    },
    b {
      public String a() {
        return "http://app.zzx9.cn";
      }
    },
    c {
      public String a() {
        return "http://sdk2.zzx9.cn";
      }
    },
    d {
      public String a() {
        return "https://hmrz.wo.cn";
      }
    },
    e {
      public String a() {
        return "http://push.zzx9.cn";
      }
    },
    f {
      public String a() {
        return "http://testsdk.cnklog.com";
      }
    };
    
    public abstract String a();
  }
  
  enum null {
    public String a() {
      return "http://ms.zzx9.cn";
    }
  }
  
  enum null {
    public String a() {
      return "http://app.zzx9.cn";
    }
  }
  
  enum null {
    public String a() {
      return "http://sdk2.zzx9.cn";
    }
  }
  
  enum null {
    public String a() {
      return "https://hmrz.wo.cn";
    }
  }
  
  enum null {
    public String a() {
      return "http://push.zzx9.cn";
    }
  }
  
  enum null {
    public String a() {
      return "http://testsdk.cnklog.com";
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */