package com.unionpay.sdk;

import android.content.Context;
import android.os.Message;
import java.util.HashMap;
import java.util.Map;

final class z implements Runnable {
  z(String paramString1, String paramString2, Map paramMap, Context paramContext) {}
  
  public final void run() {
    try {
      String str;
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("onEvent being called! eventId: ");
      stringBuilder.append(this.a);
      stringBuilder.append(", eventLabel: ");
      stringBuilder.append(this.b);
      stringBuilder.append(", eventMap: ");
      if (this.c == null) {
        str = "null";
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        this("mapSize: ");
        str = stringBuilder1.append(String.valueOf(this.c.size())).toString();
      } 
      stringBuilder.append(str);
      ay.a(stringBuilder.toString());
      w.a a = new w.a();
      this();
      a.a.put("context", this.d);
      a.a.put("apiType", Integer.valueOf(4));
      a.a.put("eventId", k.a(this.a));
      HashMap<String, String> hashMap = a.a;
      if (this.b == null) {
        str = null;
      } else {
        str = k.a(this.b);
      } 
      hashMap.put("eventLabel", str);
      a.a.put("map", this.c);
      a.a.put("occurTime", String.valueOf(System.currentTimeMillis()));
      Message.obtain(aw.a(), 102, a).sendToTarget();
    } catch (Throwable throwable) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */