package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.f;
import org.json.JSONObject;

public final class h extends d {
  String aR;
  
  String aS;
  
  Long bI = null;
  
  public h(Context paramContext, String paramString1, String paramString2, int paramInt, Long paramLong, f paramf) {
    super(paramContext, paramInt, paramf);
    this.aS = paramString1;
    this.aR = paramString2;
    this.bI = paramLong;
  }
  
  public final e ac() {
    return e.bx;
  }
  
  public final boolean b(JSONObject paramJSONObject) {
    r.a(paramJSONObject, "pi", this.aR);
    r.a(paramJSONObject, "rf", this.aS);
    if (this.bI != null)
      paramJSONObject.put("du", this.bI); 
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */