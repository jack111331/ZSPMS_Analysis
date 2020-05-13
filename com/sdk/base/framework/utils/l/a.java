package com.sdk.base.framework.utils.l;

import android.content.Context;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.h.b;
import org.json.JSONObject;

public class a {
  private static final String a = a.class.getSimpleName();
  
  private static Boolean b = Boolean.valueOf(c.h);
  
  public static String a(Context paramContext, String paramString) {
    JSONObject jSONObject = new JSONObject(paramString);
    String str = b.a(jSONObject.optString("aesKey"), com.sdk.base.framework.utils.a.a.a(paramContext, "public_key"));
    return com.sdk.base.framework.utils.i.a.b(jSONObject.optString("data"), str.substring(0, 16), str.substring(16));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\l\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */