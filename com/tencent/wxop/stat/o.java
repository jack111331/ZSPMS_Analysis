package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.a.g;
import com.tencent.wxop.stat.b.b;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

final class o implements Runnable {
  private f bM = null;
  
  private Map<String, Integer> bO = null;
  
  private Context e = null;
  
  public o(Context paramContext) {
    this.e = paramContext;
    this.bM = null;
  }
  
  private static b a(String paramString, int paramInt) {
    b b = new b();
    Socket socket = new Socket();
    boolean bool = false;
    try {
      b.setDomain(paramString);
      b.setPort(paramInt);
      long l = System.currentTimeMillis();
      InetSocketAddress inetSocketAddress = new InetSocketAddress();
      this(paramString, paramInt);
      socket.connect(inetSocketAddress, 30000);
      b.a(System.currentTimeMillis() - l);
      b.k(inetSocketAddress.getAddress().getHostAddress());
      socket.close();
      try {
        socket.close();
        paramInt = bool;
      } catch (Throwable throwable) {
        e.K().b(throwable);
        paramInt = bool;
      } 
      return b;
    } catch (IOException iOException) {
      paramInt = -1;
      e.K().b(iOException);
      try {
        socket.close();
      } catch (Throwable throwable) {
        e.K().b(throwable);
      } 
      return b;
    } finally {
      try {
        socket.close();
      } catch (Throwable throwable) {
        e.K().b(throwable);
      } 
    } 
  }
  
  private static Map<String, Integer> ag() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    String str = c.l("__MTA_TEST_SPEED__");
    if (str != null && str.trim().length() != 0) {
      String[] arrayOfString = str.split(";");
      int i = arrayOfString.length;
      byte b = 0;
      while (true) {
        if (b < i) {
          String[] arrayOfString1 = arrayOfString[b].split(",");
          if (arrayOfString1 != null && arrayOfString1.length == 2) {
            String str1 = arrayOfString1[0];
            if (str1 != null && str1.trim().length() != 0)
              try {
                int j = Integer.valueOf(arrayOfString1[1]).intValue();
                hashMap.put(str1, Integer.valueOf(j));
              } catch (NumberFormatException numberFormatException) {
                e.K().b(numberFormatException);
              }  
          } 
          b++;
          continue;
        } 
        return (Map)hashMap;
      } 
    } 
    return (Map)hashMap;
  }
  
  public final void run() {
    try {
      if (this.bO == null)
        this.bO = ag(); 
      if (this.bO == null || this.bO.size() == 0) {
        e.K().b("empty domain list.");
        return;
      } 
      JSONArray jSONArray = new JSONArray();
      this();
      for (Map.Entry<String, Integer> entry : this.bO.entrySet()) {
        b b;
        String str = (String)entry.getKey();
        if (str == null || str.length() == 0) {
          e.K().c("empty domain name.");
          continue;
        } 
        if ((Integer)entry.getValue() == null) {
          b = e.K();
          StringBuilder stringBuilder = new StringBuilder();
          this("port is null for ");
          b.c(stringBuilder.append(str).toString());
          continue;
        } 
        jSONArray.put(a((String)b.getKey(), ((Integer)b.getValue()).intValue()).i());
      } 
    } catch (Throwable throwable) {
      e.K().b(throwable);
      return;
    } 
    if (throwable.length() != 0) {
      g g = new g();
      this(this.e, e.a(this.e, false, this.bM), this.bM);
      g.b(throwable.toString());
      p p = new p();
      this((d)g);
      p.ah();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */