package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.d;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.f;
import org.json.JSONObject;

public final class i extends d {
  private d bJ;
  
  private JSONObject bK = null;
  
  public i(Context paramContext, int paramInt, JSONObject paramJSONObject, f paramf) {
    super(paramContext, paramInt, paramf);
    this.bJ = new d(paramContext);
    this.bK = paramJSONObject;
  }
  
  public final e ac() {
    return e.by;
  }
  
  public final boolean b(JSONObject paramJSONObject) {
    if (this.bp != null)
      paramJSONObject.put("ut", this.bp.as()); 
    if (this.bK != null)
      paramJSONObject.put("cfg", this.bK); 
    if (l.P(this.bv))
      paramJSONObject.put("ncts", 1); 
    this.bJ.a(paramJSONObject, null);
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */