package com.sdk.base.framework.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.sdk.base.framework.a.a.b;
import java.util.concurrent.ConcurrentHashMap;

public class b {
  private static long c = 60000L;
  
  private static final ConcurrentHashMap<String, Boolean> d = new ConcurrentHashMap<String, Boolean>(10);
  
  private static ConcurrentHashMap<String, Object> e = new ConcurrentHashMap<String, Object>(10);
  
  private final b<String, String> a;
  
  private int b = 102400;
  
  public b() {
    this(102400, 60000L);
  }
  
  public b(int paramInt, long paramLong) {
    this.b = paramInt;
    c = paramLong;
    this.a = new b<String, String>(this, this.b) {
        protected int a(String param1String1, String param1String2) {
          return (param1String2 == null) ? 0 : param1String2.length();
        }
      };
  }
  
  public static long a() {
    return c;
  }
  
  public String a(String paramString) {
    return (paramString != null) ? (String)this.a.a(paramString) : null;
  }
  
  public void a(String paramString1, String paramString2, long paramLong) {
    if (paramString1 != null && paramString2 != null && paramLong >= 1L)
      this.a.a(paramString1, paramString2, System.currentTimeMillis() + paramLong); 
  }
  
  @SuppressLint({"DefaultLocale"})
  public boolean b(String paramString) {
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString)) {
      Boolean bool1 = d.get(paramString.toUpperCase());
      if (bool1 == null)
        return false; 
      bool = bool1.booleanValue();
    } 
    return bool;
  }
  
  static {
    d.put(d.a.a.toString(), Boolean.valueOf(true));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */