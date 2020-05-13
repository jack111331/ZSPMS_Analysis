package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.a.a.a.a.h;
import com.tencent.wxop.stat.b.c;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.c;
import com.tencent.wxop.stat.f;
import com.tencent.wxop.stat.t;
import org.json.JSONObject;

public abstract class d {
  protected static String bt = null;
  
  protected int L;
  
  protected long aZ;
  
  protected String b = null;
  
  protected int bf;
  
  protected c bp = null;
  
  protected String bq = null;
  
  protected String br = null;
  
  protected String bs = null;
  
  protected boolean bu = false;
  
  protected Context bv;
  
  private f bw = null;
  
  d(Context paramContext, int paramInt, f paramf) {
    this.bv = paramContext;
    this.aZ = System.currentTimeMillis() / 1000L;
    this.L = paramInt;
    this.br = c.e(paramContext);
    this.bs = l.D(paramContext);
    this.b = c.d(paramContext);
    if (paramf != null) {
      this.bw = paramf;
      if (l.e(paramf.S()))
        this.b = paramf.S(); 
      if (l.e(paramf.T()))
        this.br = paramf.T(); 
      if (l.e(paramf.getVersion()))
        this.bs = paramf.getVersion(); 
      this.bu = paramf.U();
    } 
    this.bq = c.g(paramContext);
    this.bp = t.s(paramContext).t(paramContext);
    if (ac() != e.bF) {
      this.bf = l.K(paramContext).intValue();
    } else {
      this.bf = -e.bF.r();
    } 
    if (!h.e(bt)) {
      String str = c.h(paramContext);
      bt = str;
      if (!l.e(str))
        bt = "0"; 
    } 
  }
  
  private boolean c(JSONObject paramJSONObject) {
    boolean bool2;
    boolean bool1 = false;
    try {
      r.a(paramJSONObject, "ky", this.b);
      paramJSONObject.put("et", ac().r());
      if (this.bp != null) {
        paramJSONObject.put("ui", this.bp.b());
        r.a(paramJSONObject, "mc", this.bp.ar());
        int i = this.bp.as();
        paramJSONObject.put("ut", i);
        if (i == 0 && l.N(this.bv) == 1)
          paramJSONObject.put("ia", 1); 
      } 
      r.a(paramJSONObject, "cui", this.bq);
      if (ac() != e.by) {
        r.a(paramJSONObject, "av", this.bs);
        r.a(paramJSONObject, "ch", this.br);
      } 
      if (this.bu)
        paramJSONObject.put("impt", 1); 
      r.a(paramJSONObject, "mid", bt);
      paramJSONObject.put("idx", this.bf);
      paramJSONObject.put("si", this.L);
      paramJSONObject.put("ts", this.aZ);
      paramJSONObject.put("dts", l.a(this.bv, false));
      bool2 = b(paramJSONObject);
    } catch (Throwable throwable) {
      bool2 = bool1;
    } 
    return bool2;
  }
  
  public final Context J() {
    return this.bv;
  }
  
  public final boolean X() {
    return this.bu;
  }
  
  public abstract e ac();
  
  public final long ad() {
    return this.aZ;
  }
  
  public final f ae() {
    return this.bw;
  }
  
  public final String af() {
    String str;
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      c(jSONObject);
      str = jSONObject.toString();
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
  
  public abstract boolean b(JSONObject paramJSONObject);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */