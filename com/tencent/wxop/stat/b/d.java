package com.tencent.wxop.stat.b;

import android.content.Context;
import com.tencent.wxop.stat.g;
import org.json.JSONObject;

public final class d {
  static e cw;
  
  private static b cx = l.av();
  
  private static JSONObject cz = new JSONObject();
  
  String c = null;
  
  Integer cy = null;
  
  public d(Context paramContext) {
    try {
      u(paramContext);
      this.cy = l.F(paramContext.getApplicationContext());
      this.c = g.r(paramContext).b();
    } catch (Throwable throwable) {
      cx.b(throwable);
    } 
  }
  
  private static e u(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/wxop/stat/b/d
    //   2: monitorenter
    //   3: getstatic com/tencent/wxop/stat/b/d.cw : Lcom/tencent/wxop/stat/b/e;
    //   6: ifnonnull -> 26
    //   9: new com/tencent/wxop/stat/b/e
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   18: iconst_0
    //   19: invokespecial <init> : (Landroid/content/Context;B)V
    //   22: aload_1
    //   23: putstatic com/tencent/wxop/stat/b/d.cw : Lcom/tencent/wxop/stat/b/e;
    //   26: getstatic com/tencent/wxop/stat/b/d.cw : Lcom/tencent/wxop/stat/b/e;
    //   29: astore_0
    //   30: ldc com/tencent/wxop/stat/b/d
    //   32: monitorexit
    //   33: aload_0
    //   34: areturn
    //   35: astore_0
    //   36: ldc com/tencent/wxop/stat/b/d
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   3	26	35	finally
    //   26	30	35	finally
  }
  
  public final void a(JSONObject paramJSONObject, Thread paramThread) {
    JSONObject jSONObject = new JSONObject();
    try {
      if (cw != null)
        cw.a(jSONObject, paramThread); 
      r.a(jSONObject, "cn", this.c);
      if (this.cy != null)
        jSONObject.put("tn", this.cy); 
      if (paramThread == null) {
        paramJSONObject.put("ev", jSONObject);
      } else {
        paramJSONObject.put("errkv", jSONObject.toString());
      } 
      if (cz != null && cz.length() > 0)
        paramJSONObject.put("eva", cz); 
    } catch (Throwable throwable) {
      cx.b(throwable);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */