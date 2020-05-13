package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.e;
import com.tencent.wxop.stat.f;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends d {
  protected b bj = new b();
  
  private long bk = -1L;
  
  public a(Context paramContext, int paramInt, String paramString, f paramf) {
    super(paramContext, paramInt, paramf);
    this.bj.a = paramString;
  }
  
  public final b ab() {
    return this.bj;
  }
  
  public final e ac() {
    return e.bA;
  }
  
  public final boolean b(JSONObject paramJSONObject) {
    paramJSONObject.put("ei", this.bj.a);
    if (this.bk > 0L)
      paramJSONObject.put("du", this.bk); 
    if (this.bj.bl == null) {
      if (this.bj.a != null) {
        Properties properties = e.p(this.bj.a);
        if (properties != null && properties.size() > 0)
          if (this.bj.bm == null || this.bj.bm.length() == 0) {
            this.bj.bm = new JSONObject(properties);
          } else {
            Iterator<Map.Entry<Object, Object>> iterator = properties.entrySet().iterator();
            while (true) {
              if (iterator.hasNext()) {
                Map.Entry entry = iterator.next();
                try {
                  this.bj.bm.put(entry.getKey().toString(), entry.getValue());
                } catch (JSONException jSONException) {
                  jSONException.printStackTrace();
                } 
                continue;
              } 
              paramJSONObject.put("kv", this.bj.bm);
              return true;
            } 
          }  
      } 
    } else {
      paramJSONObject.put("ar", this.bj.bl);
      return true;
    } 
    paramJSONObject.put("kv", this.bj.bm);
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */