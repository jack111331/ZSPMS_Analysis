package com.sdk.base.framework.a;

import android.os.SystemClock;
import com.sdk.base.framework.a.b.a;
import com.sdk.base.framework.a.b.b;
import com.sdk.base.framework.a.b.c;
import com.sdk.base.framework.a.b.d;
import com.sdk.base.framework.a.c.c;
import com.sdk.base.framework.b.b;
import com.sdk.base.framework.utils.f.b;
import java.io.File;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public class c<T> extends c<Object, Object, Void> implements c {
  public static final b a = new b();
  
  private long d = b.a();
  
  private b<T> e;
  
  private String f;
  
  private String g;
  
  private a h = a.a;
  
  private int i;
  
  private boolean j = true;
  
  private long k;
  
  private String l = null;
  
  private boolean m = false;
  
  private Boolean n = Boolean.valueOf(false);
  
  private Boolean o = Boolean.valueOf(false);
  
  private Boolean p = Boolean.valueOf(false);
  
  private e<T> q;
  
  public c(d<T> paramd) {
    if (paramd != null) {
      this.q = paramd.b();
      if (this.q != null) {
        this.f = this.q.a();
        this.g = this.q.d();
        this.i = this.q.f();
        this.e = this.q.h();
      } 
    } 
  }
  
  private f<T> a(d<T> paramd, HttpURLConnection paramHttpURLConnection) {
    f<T> f2 = null;
    try {
      if (a.b(this.f)) {
        String str = a.a(this.g);
        if (str != null) {
          f2 = new f();
          this(0, (T)str, true);
          return f2;
        } 
      } 
      if (this.n.booleanValue() && this.m) {
        long l;
        File file = new File();
        this(this.l);
        if (file.isFile() && file.exists()) {
          l = file.length();
        } else {
          l = 0L;
        } 
        if (l > 0L) {
          StringBuilder stringBuilder = new StringBuilder();
          this();
          paramHttpURLConnection.setRequestProperty("RANGE", stringBuilder.append("bytes=").append(l).append("-").toString());
        } 
      } 
      if (!d())
        f2 = c(paramd, paramd.a(paramHttpURLConnection)); 
    } catch (Throwable throwable) {
      b.c("PriorityAsyncTask", throwable.getMessage(), this.c);
      f2 = b(paramd, paramHttpURLConnection);
    } 
    f<T> f1 = f2;
    if (f2 == null)
      f1 = new f<T>(1, (T)"网络连接失败", false); 
    return f1;
  }
  
  private f<T> b(d<T> paramd, HttpURLConnection paramHttpURLConnection) {
    f<T> f = null;
    if (this.i > 0) {
      this.i--;
      f = a(paramd, paramHttpURLConnection);
    } 
    return f;
  }
  
  private f<T> c(d<T> paramd, HttpURLConnection paramHttpURLConnection) {
    if (d())
      return (f)new f<String>(1, "网络访问已取消", false); 
    int i = -1;
    int j = i;
    try {
      String str;
      f f1;
      long l = System.currentTimeMillis();
      j = i;
      if (paramHttpURLConnection != null) {
        j = i;
        i = paramHttpURLConnection.getResponseCode();
        j = i;
        StringBuilder stringBuilder = new StringBuilder();
        j = i;
        this();
        j = i;
        b.b("PriorityAsyncTask", stringBuilder.append("net请求host：").append(paramHttpURLConnection.getURL().getHost()).append("\n net请求path：").append(paramHttpURLConnection.getURL().getPath()).append("\n  net请求码：").append(i).toString(), this.c);
        j = i;
      } 
      if (j < 300) {
        try {
          if (this.c.booleanValue()) {
            StringBuilder stringBuilder = new StringBuilder();
            this();
            b.a("PriorityAsyncTask", stringBuilder.append("响应返回：code=").append(j).append(";耗时=").append(System.currentTimeMillis() - l).toString(), this.c);
          } 
          if (paramHttpURLConnection != null) {
            this.j = false;
            if (this.m) {
              boolean bool;
              if (this.n.booleanValue() && com.sdk.base.framework.utils.d.a.a(paramHttpURLConnection)) {
                bool = true;
              } else {
                bool = false;
              } 
              this.n = Boolean.valueOf(bool);
              if (this.o.booleanValue()) {
                str = com.sdk.base.framework.utils.d.a.b(paramHttpURLConnection);
              } else {
                paramd = null;
              } 
              b b1 = new b();
              this();
              b1.a(paramHttpURLConnection, this, this.l, this.n.booleanValue(), (String)paramd);
            } 
            if (this.p.booleanValue()) {
              a a1 = new a();
              this();
              byte[] arrayOfByte = a1.a(paramHttpURLConnection);
            } else {
              d d1 = new d();
              this();
              String str1 = d1.a(paramHttpURLConnection, this, "UTF-8");
              str = str1;
              if (a.b(this.f)) {
                a.a(this.g, str1, this.d);
                str = str1;
              } 
            } 
          } else {
            paramd = null;
          } 
          f1 = new f();
          this(0, (T)paramd, false);
          f f2 = f1;
        } catch (Exception exception1) {}
        return (f<T>)exception1;
      } 
      if (j == 301 || j == 302) {
        String str1 = f1.getHeaderField("Location");
        if (com.sdk.base.framework.utils.k.a.b(str1).booleanValue() && exception1 != null) {
          HttpURLConnection httpURLConnection = exception1.a(str1);
          if (httpURLConnection == null)
            return (f)new f<String>(0, e(), false); 
          String str2 = f1.getHeaderField("Set-Cookie");
          if (com.sdk.base.framework.utils.k.a.b(str2).booleanValue())
            httpURLConnection.setRequestProperty("Cookie", str2); 
          if (httpURLConnection != null) {
            exception1.c();
            return a((d<T>)exception1, httpURLConnection);
          } 
        } 
      } 
      if (this.c.booleanValue()) {
        str = "网络连接失败 code=" + j;
      } else {
        str = "网络连接失败";
      } 
      f<String> f = new f<String>(1, str, false);
    } catch (Exception exception) {}
    return (f<T>)exception;
  }
  
  private String e() {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("code", 1);
      jSONObject.put("status", 100021);
      jSONObject.put("msg", "选择流量通道失败！");
      String str = jSONObject.toString();
    } catch (JSONException jSONException) {
      jSONException = null;
    } 
    return (String)jSONException;
  }
  
  protected Void a(Object... paramVarArgs) {
    if (this.h != a.e && paramVarArgs != null && paramVarArgs.length != 0) {
      d<T> d;
      if (paramVarArgs.length == 4) {
        boolean bool;
        this.l = String.valueOf(paramVarArgs[1]);
        if (this.l != null) {
          bool = true;
        } else {
          bool = false;
        } 
        this.m = bool;
        this.n = (Boolean)paramVarArgs[2];
        this.o = (Boolean)paramVarArgs[3];
      } 
      if (paramVarArgs.length == 2)
        this.p = (Boolean)paramVarArgs[1]; 
      try {
        this.k = SystemClock.uptimeMillis();
        e(new Object[] { Integer.valueOf(1) });
        d = (d)paramVarArgs[0];
        this.g = d.a();
        HttpURLConnection httpURLConnection = d.a(this.g);
        if (httpURLConnection == null) {
          f f1 = new f();
          this(0, (T)e(), false);
          e(new Object[] { Integer.valueOf(4), f1 });
          return null;
        } 
      } catch (Exception exception) {
        e(new Object[] { Integer.valueOf(3), Integer.valueOf(100001), "网络访问出错" });
        return null;
      } 
      f<T> f = a(d, (HttpURLConnection)exception);
      if (f != null) {
        if (f.a() == 0) {
          e(new Object[] { Integer.valueOf(4), f });
          return null;
        } 
        e(new Object[] { Integer.valueOf(3), Integer.valueOf(f.a()), f.b() });
      } 
    } 
    return null;
  }
  
  public void a() {
    this.h = a.e;
    if (!d())
      try {
        a(true);
      } catch (Throwable throwable) {
        b.c("PriorityAsyncTask", throwable.getMessage(), this.c);
      }  
    if (this.e != null)
      this.e.c(); 
  }
  
  public boolean a(long paramLong1, long paramLong2, boolean paramBoolean) {
    boolean bool = true;
    if (this.e != null && this.h != a.e)
      if (paramBoolean) {
        e(new Object[] { Integer.valueOf(2), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      } else {
        long l = SystemClock.uptimeMillis();
        if (l - this.k >= this.e.a()) {
          this.k = l;
          e(new Object[] { Integer.valueOf(2), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
        } 
      }  
    return (this.h != a.e) ? bool : false;
  }
  
  protected void b(Object... paramVarArgs) {
    if (this.h == a.e || paramVarArgs == null || paramVarArgs.length == 0 || this.e == null);
    switch (((Integer)paramVarArgs[0]).intValue()) {
      default:
        return;
      case 1:
        this.h = a.b;
        this.e.b();
      case 2:
        if (paramVarArgs.length == 3) {
          this.h = a.c;
          this.e.a(Long.parseLong(String.valueOf(paramVarArgs[1])), Long.parseLong(String.valueOf(paramVarArgs[2])), this.j);
        } 
      case 3:
        if (paramVarArgs.length == 3) {
          this.h = a.d;
          this.e.a(((Integer)paramVarArgs[1]).intValue(), paramVarArgs[2]);
        } 
      case 4:
        break;
    } 
    if (paramVarArgs.length == 2) {
      this.h = a.f;
      this.e.a((f)paramVarArgs[1], this.q.d());
    } 
  }
  
  public enum a {
    a(0),
    b(1),
    c(2),
    d(3),
    e(4),
    f(5);
    
    private int g = 0;
    
    a(int param1Int1) {
      this.g = param1Int1;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */