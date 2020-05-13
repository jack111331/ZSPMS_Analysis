package com.zz.sdk.floatdlg;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.zz.sdk.b.a.r;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.v;
import java.net.URLEncoder;

public class WiKiActivity extends Activity implements View.OnClickListener {
  private WebView a;
  
  private LinearLayout b;
  
  private LinearLayout c;
  
  private ProgressBar d;
  
  private String e;
  
  private void a() {
    if (this.a != null) {
      this.a.destroy();
      this.a = null;
    } 
    setResult(-1);
    finish();
    overridePendingTransition(0, 0);
  }
  
  public void onBackPressed() {
    if (this.a.canGoBack()) {
      this.a.goBack();
      return;
    } 
    a();
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == ci.a((Context)this, 2131296526)) {
      a();
      return;
    } 
    if (paramView.getId() == ci.a((Context)this, 2131296525)) {
      if (this.a.canGoBack()) {
        this.a.goBack();
        return;
      } 
      a();
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    setContentView(ci.a((Context)this, 2130903108));
    if (cv.u((Context)this)) {
      setRequestedOrientation(0);
    } else {
      setRequestedOrientation(1);
    } 
    try {
      this.a = (WebView)findViewById(ci.a((Context)this, 2131296528));
      cv.w((Context)this);
      this.b = (LinearLayout)findViewById(ci.a((Context)this, 2131296526));
      this.b.setOnClickListener(this);
      this.c = (LinearLayout)findViewById(ci.a((Context)this, 2131296525));
      this.c.setOnClickListener(this);
      this.d = (ProgressBar)findViewById(ci.a((Context)this, 2131296527));
      WebSettings webSettings = this.a.getSettings();
      webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
      webSettings.setJavaScriptEnabled(true);
      webSettings.setUseWideViewPort(true);
      webSettings.setLoadWithOverviewMode(true);
      webSettings.setDomStorageEnabled(true);
      webSettings.setCacheMode(2);
      WebView webView = this.a;
      d d = new d();
      this(this);
      webView.setWebViewClient(d);
      webView = this.a;
      e e = new e();
      this(this);
      webView.setWebChromeClient(e);
      r r = cv.h();
      if (r != null && !TextUtils.isEmpty((r.u()).h)) {
        String str4;
        StringBuilder stringBuilder3 = new StringBuilder();
        this((r.u()).h);
        StringBuilder stringBuilder2 = new StringBuilder();
        this();
        bp.a(stringBuilder2.append("wiki base url:").append(stringBuilder3.toString()).toString());
        if (v.z == null) {
          str1 = "";
        } else {
          str1 = v.z.f();
        } 
        if (v.z == null) {
          str2 = "";
        } else {
          str2 = v.z.d();
        } 
        if (v.z == null) {
          str3 = "";
        } else {
          str3 = v.z.g();
        } 
        if (v.z == null) {
          str4 = "";
        } else {
          str4 = v.z.e();
        } 
        String str1 = h.a(new Object[] { 
              "roleId", str1, "channelId", "", "serverId", str2, "roleName", str3, "vipLevel", "", 
              "serverName", str4, "rankLevel", "", "level", "" });
        String str2 = h.a(true, new String[] { "data", str1, "timestamp", String.valueOf(System.currentTimeMillis() / 1000L) });
        String str3 = h.b((Context)this).toLowerCase();
        stringBuilder3.append("&data=").append(URLEncoder.encode(str1)).append("&timestamp=").append(String.valueOf(System.currentTimeMillis() / 1000L)).append("&sign=").append(str2).append("&lang=").append(str3);
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        bp.a(stringBuilder1.append("wiki url:").append(stringBuilder3.toString()).toString());
        this.a.loadUrl(stringBuilder3.toString());
      } 
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\WiKiActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */