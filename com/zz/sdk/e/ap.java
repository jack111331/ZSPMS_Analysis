package com.zz.sdk.e;

import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.zz.sdk.IJSInterface;
import com.zz.sdk.i.bp;
import org.json.JSONObject;

class ap implements IJSInterface {
  ap(al paramal) {}
  
  @JavascriptInterface
  public void callPay() {
    al.p(this.a).showPaymentView(al.l(this.a), 2015, "厂商自定义参数（长度限制100个字符）", 0, false, true, false, "充值" + Character.MIN_VALUE + "游戏币", "cp_" + System.currentTimeMillis());
  }
  
  @JavascriptInterface
  public void callToast() {
    Toast.makeText(al.q(this.a), "支付成功", 0).show();
  }
  
  @JavascriptInterface
  public void jsOpenShare(String paramString) {
    bp.a("float webShare, msg:" + paramString);
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      paramString = jSONObject.getString("title");
      String str = jSONObject.getString("url");
      al al1 = this.a;
      StringBuilder stringBuilder = new StringBuilder();
      this();
      al.c(al1, stringBuilder.append(paramString).append(" ").append(str).toString());
    } catch (Exception exception) {
      bp.a("float webShare exception:" + exception.toString());
    } 
  }
  
  @JavascriptInterface
  public void shareInfo(String paramString) {
    bp.a("shareInfo, msg:" + paramString);
    al.d(this.a, paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */