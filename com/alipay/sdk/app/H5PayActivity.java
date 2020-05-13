package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.util.l;

public class H5PayActivity extends Activity {
  private WebView a;
  
  private WebViewClient b;
  
  private void b() {
    try {
      requestWindowFeature(1);
    } catch (Throwable throwable) {}
  }
  
  public void a() {
    synchronized (PayTask.a) {
      null.notify();
    } 
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_1} */
  }
  
  public void finish() {
    a();
    super.finish();
  }
  
  public void onBackPressed() {
    if (this.a.canGoBack()) {
      if (((b)this.b).c) {
        j j = j.a(j.d.h);
        i.a = i.a(j.h, j.i, "");
        finish();
      } 
      return;
    } 
    i.a = i.a();
    finish();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle) {
    try {
      requestWindowFeature(1);
    } catch (Throwable throwable) {}
    super.onCreate(paramBundle);
    try {
      Bundle bundle = getIntent().getExtras();
      String str1 = bundle.getString("url");
      if (!l.b(str1)) {
        finish();
        return;
      } 
      String str2 = bundle.getString("cookie");
      try {
        this.a = l.a(this, str1, str2);
        b b = new b();
        this(this);
        this.b = b;
        this.a.setWebViewClient(this.b);
      } catch (Throwable throwable) {
        a.a("biz", "GetInstalledAppEx", throwable);
        finish();
      } 
    } catch (Exception exception) {
      finish();
    } 
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.a != null) {
      this.a.removeAllViews();
      ((ViewGroup)this.a.getParent()).removeAllViews();
      try {
        this.a.destroy();
      } catch (Throwable throwable) {}
      this.a = null;
    } 
    if (this.b != null) {
      b b = (b)this.b;
      b.b = null;
      b.a = null;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\app\H5PayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */