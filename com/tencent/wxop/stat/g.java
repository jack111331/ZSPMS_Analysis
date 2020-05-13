package com.tencent.wxop.stat;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class g {
  private static g bg = null;
  
  private List<String> bc = null;
  
  private volatile HttpHost bd = null;
  
  private f be = null;
  
  private int bf = 0;
  
  private Context bh = null;
  
  private b bi = null;
  
  private volatile String c = "";
  
  private volatile int g = 2;
  
  private g(Context paramContext) {
    this.bh = paramContext.getApplicationContext();
    this.be = new f();
    ak.j(paramContext);
    this.bi = l.av();
    Y();
    this.bc = new ArrayList<String>(10);
    this.bc.add("117.135.169.101");
    this.bc.add("140.207.54.125");
    this.bc.add("180.153.8.53");
    this.bc.add("120.198.203.175");
    this.bc.add("14.17.43.18");
    this.bc.add("163.177.71.186");
    this.bc.add("111.30.131.31");
    this.bc.add("123.126.121.167");
    this.bc.add("123.151.152.111");
    this.bc.add("113.142.45.79");
    this.bc.add("123.138.162.90");
    this.bc.add("103.7.30.94");
    Z();
  }
  
  private String O() {
    try {
      if (!d("pingma.qq.com"))
        return InetAddress.getByName("pingma.qq.com").getHostAddress(); 
    } catch (Exception exception) {
      this.bi.b(exception);
    } 
    return "";
  }
  
  private void Y() {
    this.g = 0;
    this.bd = null;
    this.c = null;
  }
  
  private static boolean d(String paramString) {
    return Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})").matcher(paramString).matches();
  }
  
  public static g r(Context paramContext) {
    // Byte code:
    //   0: getstatic com/tencent/wxop/stat/g.bg : Lcom/tencent/wxop/stat/g;
    //   3: ifnonnull -> 31
    //   6: ldc com/tencent/wxop/stat/g
    //   8: monitorenter
    //   9: getstatic com/tencent/wxop/stat/g.bg : Lcom/tencent/wxop/stat/g;
    //   12: ifnonnull -> 28
    //   15: new com/tencent/wxop/stat/g
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: aload_1
    //   25: putstatic com/tencent/wxop/stat/g.bg : Lcom/tencent/wxop/stat/g;
    //   28: ldc com/tencent/wxop/stat/g
    //   30: monitorexit
    //   31: getstatic com/tencent/wxop/stat/g.bg : Lcom/tencent/wxop/stat/g;
    //   34: areturn
    //   35: astore_0
    //   36: ldc com/tencent/wxop/stat/g
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   9	28	35	finally
    //   28	31	35	finally
  }
  
  public final int D() {
    return this.g;
  }
  
  public final void I() {
    this.bf = (this.bf + 1) % this.bc.size();
  }
  
  public final HttpHost V() {
    return this.bd;
  }
  
  public final boolean W() {
    boolean bool = true;
    if (this.g != 1)
      bool = false; 
    return bool;
  }
  
  public final boolean X() {
    return (this.g != 0);
  }
  
  final void Z() {
    if (r.W(this.bh)) {
      if (c.ad) {
        String str = O();
        if (c.k())
          this.bi.b("remoteIp ip is " + str); 
        if (l.e(str)) {
          String str1;
          if (this.bc.contains(str)) {
            str1 = str;
          } else {
            String str2 = this.bc.get(this.bf);
            str1 = str2;
            if (c.k()) {
              this.bi.c(str + " not in ip list, change to:" + str2);
              str1 = str2;
            } 
          } 
          c.o("http://" + str1 + ":80/mstat/report");
        } 
      } 
      this.c = l.E(this.bh);
      if (c.k())
        this.bi.b("NETWORK name:" + this.c); 
      if (l.e(this.c)) {
        if ("WIFI".equalsIgnoreCase(this.c)) {
          this.g = 1;
        } else {
          this.g = 2;
        } 
        this.bd = l.v(this.bh);
      } 
      if (e.a())
        e.n(this.bh); 
      return;
    } 
    if (c.k())
      this.bi.b("NETWORK TYPE: network is close."); 
    Y();
  }
  
  public final void aa() {
    this.bh.getApplicationContext().registerReceiver(new z(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  public final String b() {
    return this.c;
  }
  
  public final void b(String paramString) {
    if (c.k())
      this.bi.b("updateIpList " + paramString); 
    try {
      if (l.e(paramString)) {
        JSONObject jSONObject = new JSONObject();
        this(paramString);
        if (jSONObject.length() > 0) {
          Iterator<String> iterator = jSONObject.keys();
          while (iterator.hasNext()) {
            String str = jSONObject.getString(iterator.next());
            if (l.e(str))
              for (String str1 : str.split(";")) {
                if (l.e(str1)) {
                  String[] arrayOfString = str1.split(":");
                  if (arrayOfString.length > 1) {
                    String str2 = arrayOfString[0];
                    if (d(str2) && !this.bc.contains(str2)) {
                      if (c.k()) {
                        b b1 = this.bi;
                        StringBuilder stringBuilder = new StringBuilder();
                        this("add new ip:");
                        b1.b(stringBuilder.append(str2).toString());
                      } 
                      this.bc.add(str2);
                    } 
                  } 
                } 
              }  
          } 
        } 
      } 
    } catch (Exception exception) {
      this.bi.b(exception);
    } 
    this.bf = (new Random()).nextInt(this.bc.size());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */