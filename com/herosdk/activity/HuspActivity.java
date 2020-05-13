package com.herosdk.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.herosdk.common.JsCallbackUtils;
import com.herosdk.d.bb;
import com.herosdk.d.m;
import com.herosdk.d.r;
import com.herosdk.error.ErrorUtils;

public class HuspActivity extends Activity {
  public static final String a = "HU_WEB_URL";
  
  public String b;
  
  public WebView c;
  
  private void a() {
    this.c = new WebView((Context)this);
    setContentView((View)this.c);
    WebSettings webSettings = this.c.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setDomStorageEnabled(true);
    webSettings.setUseWideViewPort(true);
    webSettings.setLoadWithOverviewMode(true);
    webSettings.setDatabaseEnabled(true);
    webSettings.setGeolocationEnabled(true);
    webSettings.setGeolocationDatabasePath(getDir("database", 0).getPath());
    webSettings.setAppCacheEnabled(true);
    webSettings.setAppCachePath(getDir("cache", 0).getPath());
    webSettings.setCacheMode(-1);
    webSettings.setAllowFileAccess(true);
    this.c.setDrawingCacheEnabled(true);
    this.c.setWebChromeClient(new a(this));
    this.c.setWebViewClient(new b(this));
    this.c.addJavascriptInterface(new JsCallbackUtils(this), "AndroidApi");
    r.a().a((Context)this);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    try {
      requestWindowFeature(1);
      this.b = getIntent().getStringExtra("HU_WEB_URL");
      a();
      int i = m.a((Context)this).p();
      int j = m.a((Context)this).q();
      ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
      if (i > j) {
        layoutParams.width = j;
        layoutParams.height = i - bb.e((Context)this);
      } 
      this.c.setLayoutParams(layoutParams);
      this.c.loadUrl(this.b);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    return (paramInt == 4 && this.c.canGoBack()) ? true : super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\activity\HuspActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */