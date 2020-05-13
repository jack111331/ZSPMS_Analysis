package com.herosdk.b;

import android.content.Context;
import android.util.Log;
import com.herosdk.bean.OrderInfo;
import com.herosdk.bean.RoleInfo;
import com.herosdk.bean.UserInfo;
import com.herosdk.d.ba;
import com.herosdk.d.r;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.ICommonListener;
import com.herosdk.listener.ILoginListener;
import com.herosdk.listener.IPayListener;
import com.herosdk.listener.ISinglePayListener;
import com.herosdk.listener.f;
import org.json.JSONObject;

public class a {
  private static String a = "frameLib.hpa";
  
  private static final int b = 0;
  
  private static final int c = 1;
  
  private static final int d = 2;
  
  private static final int e = 0;
  
  private static final int f = 1001;
  
  private static final int g = 1002;
  
  private static final int h = 1003;
  
  private static final int i = 1004;
  
  private static final int j = 1005;
  
  private static volatile a k;
  
  private aq l = new aq();
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/herosdk/b/a.k : Lcom/herosdk/b/a;
    //   3: ifnonnull -> 30
    //   6: ldc com/herosdk/b/a
    //   8: monitorenter
    //   9: getstatic com/herosdk/b/a.k : Lcom/herosdk/b/a;
    //   12: ifnonnull -> 27
    //   15: new com/herosdk/b/a
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/b/a.k : Lcom/herosdk/b/a;
    //   27: ldc com/herosdk/b/a
    //   29: monitorexit
    //   30: getstatic com/herosdk/b/a.k : Lcom/herosdk/b/a;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/herosdk/b/a
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public void a(Context paramContext) {
    Log.d(a, "rak");
    n n = new n(this, paramContext);
    ba.a().a(n);
  }
  
  public void a(Context paramContext, OrderInfo paramOrderInfo, RoleInfo paramRoleInfo, String paramString, IPayListener paramIPayListener) {
    Log.d(a, "p");
    u u = new u(this, paramIPayListener, paramOrderInfo, paramContext, paramRoleInfo, paramString);
    r.a().a(paramContext);
    ba.a().a(u);
  }
  
  public void a(Context paramContext, RoleInfo paramRoleInfo) {
    Log.d(a, "rom");
    g g = new g(this, paramContext, paramRoleInfo);
    ba.a().a(g);
  }
  
  public void a(Context paramContext, RoleInfo paramRoleInfo, int paramInt) {
    Log.d(a, "sr");
    t t = new t(this, paramRoleInfo, paramContext, paramInt);
    ba.a().a(t);
  }
  
  public void a(Context paramContext, UserInfo paramUserInfo, String paramString, ILoginListener paramILoginListener) {
    Log.d(a, "l");
    p p = new p(this, paramILoginListener, paramContext, paramUserInfo, paramString);
    r.a().a(paramContext);
    ba.a().a(p);
  }
  
  public void a(Context paramContext, f paramf) {
    Log.d(a, "i");
    b b = new b(this, paramContext, paramf);
    ba.a().a(b);
  }
  
  public void a(Context paramContext, Object paramObject) {
    Log.d(a, "uai");
    j j = new j(this, paramContext, paramObject);
    ba.a().a(j);
  }
  
  public void a(Context paramContext, String paramString) {
    Log.d(a, "re");
    c c = new c(this, paramContext, paramString);
    ba.a().a(c);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, ICommonListener paramICommonListener) {
    Log.d(a, "idfs");
    k k = new k(this, paramContext, paramString1, paramString2, paramICommonListener);
    ba.a().a(k);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, ISinglePayListener paramISinglePayListener) {
    Log.d(a, "cpr");
    ac ac = new ac(this, paramISinglePayListener, paramString1, paramContext, paramString2);
    r.a().a(paramContext);
    ba.a().a(ac);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    Log.d(a, "nps");
    ad ad = new ad(this, paramString1, paramContext, paramString3);
    r.a().a(paramContext);
    ba.a().a(ad);
  }
  
  public JSONObject b(Context paramContext, String paramString1, String paramString2, String paramString3) {
    Log.d(a, "yp");
    try {
      JSONObject jSONObject;
      ar ar = this.l.a(paramContext, paramString1, paramString2, paramString3);
      if (ar != null && ar.b()) {
        JSONObject jSONObject1 = ar.e();
        if (jSONObject1 != null) {
          int i = jSONObject1.optInt("code", -9999);
          jSONObject = new JSONObject();
          this();
          if (i == 0) {
            jSONObject.put("result", true);
            return jSONObject;
          } 
          if (i == 1001) {
            Log.d(a, "yp aki");
            a().a(paramContext);
            return jSONObject;
          } 
          if (i == 1002) {
            Log.d(a, "yp ate");
            x.a().Q();
            return jSONObject;
          } 
          jSONObject.put("result", false);
          jSONObject.put("msg", jSONObject1.optString("msg"));
          return jSONObject;
        } 
      } else {
        paramString2 = a;
        StringBuilder stringBuilder = new StringBuilder();
        this();
        Log.e(paramString2, stringBuilder.append("do yp but error:").append(jSONObject.a()).toString());
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
    return null;
  }
  
  public void b(Context paramContext) {
    Log.d(a, "rsee");
    o o = new o(this, paramContext);
    ba.a().a(o);
  }
  
  public void b(Context paramContext, OrderInfo paramOrderInfo, RoleInfo paramRoleInfo, String paramString, IPayListener paramIPayListener) {
    Log.d(a, "rp gId:" + paramOrderInfo.getGoodsId());
    z z = new z(this, paramContext, paramOrderInfo, paramRoleInfo, paramString, paramIPayListener);
    r.a().a(paramContext);
    ba.a().a(z);
  }
  
  public void b(Context paramContext, String paramString) {
    Log.d(a, "rc");
    d d = new d(this, paramContext, paramString);
    ba.a().a(d);
  }
  
  public void c(Context paramContext, String paramString) {
    Log.d(a, "rnfs");
    e e = new e(this, paramContext, paramString);
    ba.a().a(e);
  }
  
  public void d(Context paramContext, String paramString) {
    Log.d(a, "rlem");
    f f = new f(this, paramContext, paramString);
    ba.a().a(f);
  }
  
  public JSONObject e(Context paramContext, String paramString) {
    Log.d(a, "cyb");
    try {
      String str;
      ar ar = this.l.f(paramContext, paramString);
      if (ar != null && ar.b()) {
        JSONObject jSONObject = ar.e();
        if (jSONObject != null) {
          int i = jSONObject.optInt("code", -9999);
          if (i == 0)
            return jSONObject; 
          if (i == 1001) {
            Log.d(a, "cyb aki");
            a().a(paramContext);
          } else if (i == 1002) {
            Log.d(a, "cyb ate");
            x.a().Q();
          } else {
            String str1 = jSONObject.optString("msg");
            str = a;
            StringBuilder stringBuilder = new StringBuilder();
            this();
            Log.d(str, stringBuilder.append("cyb failed code:").append(i).append(",msg:").append(str1).toString());
          } 
        } 
      } else {
        String str1 = a;
        StringBuilder stringBuilder = new StringBuilder();
        this();
        Log.e(str1, stringBuilder.append("do cyb but error:").append(str.a()).toString());
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
    return null;
  }
  
  public JSONObject f(Context paramContext, String paramString) {
    Log.d(a, "cidc");
    try {
      JSONObject jSONObject;
      ar ar = this.l.g(paramContext, paramString);
      if (ar != null && ar.b()) {
        jSONObject = ar.e();
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        this();
        Log.d(str, stringBuilder.append("cidc jsonObject:").append(jSONObject.toString()).toString());
        if (jSONObject != null) {
          int i = jSONObject.optInt("code", -9999);
          if (i == 1001) {
            Log.d(a, "cidc aki");
            a().a(paramContext);
            return jSONObject;
          } 
          JSONObject jSONObject1 = jSONObject;
          if (i == 1002) {
            Log.d(a, "cidc ate");
            x.a().Q();
            jSONObject1 = jSONObject;
          } 
          return jSONObject1;
        } 
      } else {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        this();
        Log.e(str, stringBuilder.append("do cidc but error:").append(jSONObject.a()).toString());
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
    return null;
  }
  
  public void g(Context paramContext, String paramString) {
    Log.d(a, "kc value:" + paramString);
    m m = new m(this, paramContext, paramString);
    ba.a().a(m);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */