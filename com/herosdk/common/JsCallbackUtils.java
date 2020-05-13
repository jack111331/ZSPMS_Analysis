package com.herosdk.common;

import android.util.Log;
import android.webkit.JavascriptInterface;
import com.herosdk.HeroSdk;
import com.herosdk.activity.HuspActivity;
import com.herosdk.activity.HuwActivity;
import com.herosdk.d.bb;
import com.herosdk.d.e;
import com.herosdk.d.g;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;

public class JsCallbackUtils {
  private static final int c = 0;
  
  private static String d = "frameLib.jcus";
  
  private HuwActivity a = null;
  
  private HuspActivity b = null;
  
  public JsCallbackUtils(HuspActivity paramHuspActivity) {
    this.b = paramHuspActivity;
  }
  
  public JsCallbackUtils(HuwActivity paramHuwActivity) {
    this.a = paramHuwActivity;
  }
  
  @JavascriptInterface
  public void close() {
    Log.d(d, "close");
    if (this.a != null) {
      this.a.finish();
      this.a = null;
    } 
    if (this.b != null) {
      this.b.finish();
      this.b = null;
    } 
  }
  
  @JavascriptInterface
  public String getCacheInfo() {
    return g.a().b();
  }
  
  @JavascriptInterface
  public int getChannelId() {
    return x.a().c();
  }
  
  @JavascriptInterface
  public String getChannelName() {
    return x.a().f();
  }
  
  @JavascriptInterface
  public String getPaySuccessInfo() {
    return x.a().B();
  }
  
  @JavascriptInterface
  public int getThirdChannelId() {
    return x.a().d();
  }
  
  public void jsLoginRet(Boolean paramBoolean) {
    Log.d(d, "jsLoginRet:" + paramBoolean);
    if (paramBoolean.booleanValue()) {
      this.a.b().loadUrl("javascript:loginRet(0)");
      return;
    } 
    this.a.b().loadUrl("javascript:loginRet(1)");
  }
  
  @JavascriptInterface
  public void onLoginRet(String paramString) {
    bb.a(new a(this, paramString));
  }
  
  @JavascriptInterface
  public int onNoticeOrderResult(String paramString1, String paramString2, String paramString3) {
    byte b;
    try {
      String str = d;
      StringBuilder stringBuilder = new StringBuilder();
      this();
      Log.d(str, stringBuilder.append("onNoticeOrderResult sdkOrderId:").append(paramString1).append(",cpOrderId:").append(paramString2).append(",statusKey:").append(paramString3).toString());
      if (HeroSdk.getInstance().getSinglePayListener() != null) {
        Log.d(d, "onNoticeOrderResult...onSuccess");
        e.a().a(paramString1, paramString2);
        HeroSdk.getInstance().getSinglePayListener().onSuccess(paramString1, paramString2, paramString3);
      } 
      b = 0;
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      b = -1;
    } 
    return b;
  }
  
  @JavascriptInterface
  public void screenshots() {
    bb.a(new b(this));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\common\JsCallbackUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */