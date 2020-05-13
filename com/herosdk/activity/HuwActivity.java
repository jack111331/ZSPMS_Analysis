package com.herosdk.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.herosdk.common.JsCallbackUtils;
import com.herosdk.d.bb;
import com.herosdk.d.r;
import com.herosdk.error.ErrorUtils;

public class HuwActivity extends Activity {
  public static final String a = "HU_WEB_URL";
  
  public static final String b = "HU_WEB_FORCE";
  
  public String c;
  
  public Boolean d;
  
  public WebView e;
  
  public TextView f;
  
  private void a(Boolean paramBoolean) {
    this.e = new WebView((Context)this);
    setContentView((View)this.e);
    if (!paramBoolean.booleanValue())
      a(); 
    WebSettings webSettings = this.e.getSettings();
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
    if (Build.VERSION.SDK_INT >= 21)
      webSettings.setMixedContentMode(0); 
    this.e.setDrawingCacheEnabled(true);
    this.e.setWebChromeClient(new c(this));
    this.e.setWebViewClient(new d(this));
    this.e.addJavascriptInterface(new JsCallbackUtils(this), "AndroidApi");
    this.e.setDownloadListener(new e(this));
    this.e.setBackgroundColor(Color.parseColor("#00000000"));
    r.a().a((Context)this);
  }
  
  @TargetApi(11)
  private void a(String paramString) {
    DownloadManager downloadManager = (DownloadManager)getSystemService("download");
    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(paramString));
    request.setMimeType("application/vnd.android.package-archive");
    request.setAllowedNetworkTypes(2);
    request.setVisibleInDownloadsUi(true);
    request.setDestinationInExternalFilesDir((Context)this, Environment.DIRECTORY_DOWNLOADS, "" + paramString.hashCode());
    request.setNotificationVisibility(1);
    downloadManager.enqueue(request);
  }
  
  public void a() {
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
    layoutParams.gravity = 53;
    layoutParams.setMargins(0, bb.a((Context)this, 15.0F), bb.a((Context)this, 40.0F), 0);
    this.f = new TextView((Context)this);
    this.f.setText("关闭");
    this.f.setTextColor(-1);
    this.f.setGravity(17);
    addContentView((View)this.f, (ViewGroup.LayoutParams)layoutParams);
    this.f.setOnClickListener(new f(this));
  }
  
  public WebView b() {
    return this.e;
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    try {
      requestWindowFeature(1);
      this.c = getIntent().getStringExtra("HU_WEB_URL");
      this.d = Boolean.valueOf(getIntent().getBooleanExtra("HU_WEB_FORCE", false));
      a(this.d);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    boolean bool = true;
    if (paramInt != 4 || (!this.d.booleanValue() && !this.e.canGoBack()))
      bool = super.onKeyUp(paramInt, paramKeyEvent); 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\activity\HuwActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */