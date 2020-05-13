package com.tencent.open.b;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.open.utils.i;

public class d {
  protected static d a;
  
  public static d a() {
    // Byte code:
    //   0: ldc com/tencent/open/b/d
    //   2: monitorenter
    //   3: getstatic com/tencent/open/b/d.a : Lcom/tencent/open/b/d;
    //   6: ifnonnull -> 21
    //   9: new com/tencent/open/b/d
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: putstatic com/tencent/open/b/d.a : Lcom/tencent/open/b/d;
    //   21: getstatic com/tencent/open/b/d.a : Lcom/tencent/open/b/d;
    //   24: astore_0
    //   25: ldc com/tencent/open/b/d
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/tencent/open/b/d
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong, int paramInt2, int paramInt3, String paramString5) {
    long l = SystemClock.elapsedRealtime() - paramLong.longValue();
    if (paramLong.longValue() == 0L || l < 0L)
      l = 0L; 
    StringBuffer stringBuffer = new StringBuffer("http://c.isdspeed.qq.com/code.cgi");
    stringBuffer.append("?domain=mobile.opensdk.com&cgi=opensdk&type=").append(paramInt1).append("&code=").append(paramInt2).append("&time=").append(l).append("&rate=").append(paramInt3).append("&uin=").append(paramString2).append("&data=");
    Bundle bundle = i.a(String.valueOf(paramInt1), String.valueOf(paramInt2), String.valueOf(l), String.valueOf(paramInt3), paramString1, paramString2, paramString3, paramString4, paramString5);
    g.a().a(stringBuffer.toString(), "GET", bundle, true);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
    Bundle bundle = i.a(paramString1, paramString3, paramString4, paramString5, paramString2, paramString6);
    g.a().a(bundle, paramString2, true);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
    Bundle bundle = i.a(paramString1, paramString4, paramString5, paramString3, paramString2, paramString6, "", paramString7, paramString8, "", "", "");
    g.a().a(bundle, paramString2, false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10) {
    Bundle bundle = i.a(paramString1, paramString4, paramString5, paramString3, paramString2, paramString6, paramString7, "", "", paramString8, paramString9, paramString10);
    g.a().a(bundle, paramString2, false);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\open\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */