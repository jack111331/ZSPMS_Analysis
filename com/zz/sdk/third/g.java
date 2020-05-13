package com.zz.sdk.third;

import android.text.TextUtils;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.zz.sdk.third.a.a;
import org.json.JSONObject;

class g implements IUiListener {
  g(f paramf) {}
  
  public void onCancel() {
    if (f.a(this.a) != null)
      f.a(this.a).a(this.a.e()); 
  }
  
  public void onComplete(Object paramObject) {
    if (f.a(this.a) != null) {
      if (paramObject == null || !(paramObject instanceof JSONObject)) {
        f.a(this.a).a(this.a.e(), null);
        return;
      } 
    } else {
      return;
    } 
    JSONObject jSONObject = (JSONObject)paramObject;
    if (jSONObject.length() == 0) {
      f.a(this.a).a(this.a.e(), null);
      return;
    } 
    paramObject = jSONObject.optString("access_token");
    long l = jSONObject.optLong("expires_in", 0L);
    String str2 = jSONObject.optString("openid");
    String str1 = jSONObject.optString("pf");
    if (TextUtils.isEmpty((CharSequence)paramObject) || l == 0L || TextUtils.isEmpty(str2)) {
      f.a(this.a).a(this.a.e(), null);
      return;
    } 
    this.a.b = new a(str2, (String)paramObject, l);
    this.a.b.a(this.a.e());
    this.a.b.a("pf", str1);
    this.a.a(this.a.b);
    if (this.a.b != null) {
      f.a(this.a).a(this.a.e(), this.a.b);
      return;
    } 
    f.a(this.a).a(this.a.e(), null);
  }
  
  public void onError(UiError paramUiError) {
    if (f.a(this.a) != null)
      f.a(this.a).a(this.a.e(), paramUiError.toString()); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\third\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */