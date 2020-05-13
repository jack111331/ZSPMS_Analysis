package com.jdpaysdk.author.browser;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.jdpaysdk.author.c.c;
import com.jdpaysdk.author.c.f;
import com.jdpaysdk.author.entity.a;
import com.jdpaysdk.author.entity.b;
import com.jdpaysdk.author.protocol.RequestParam;
import com.jdpaysdk.author.web.PayJsFunction;

public class BrowserActivity extends Activity {
  private WebView a;
  
  private ImageView b;
  
  private ProgressBar c;
  
  private TextView d;
  
  private d e = null;
  
  private void b() {
    this.a.getSettings().setDefaultTextEncodingName("utf-8");
    this.a.getSettings().setJavaScriptEnabled(true);
    PayJsFunction payJsFunction = new PayJsFunction(this.a);
    this.a.addJavascriptInterface(payJsFunction, "JDPaySdk");
    this.a.setWebChromeClient(new a(this));
    this.a.setWebViewClient(new b(this));
    this.b.setOnClickListener(new c(this));
    if ("DATA".equals(this.e.h)) {
      a(this.e.a);
      return;
    } 
    this.a.loadUrl(this.e.a);
  }
  
  private boolean c() {
    return this.a.canGoBack();
  }
  
  public void a() {
    if (c()) {
      if (this.e.a() != null) {
        b("");
        return;
      } 
      this.a.goBack();
      return;
    } 
    b("");
  }
  
  public void a(String paramString) {
    this.a.loadDataWithBaseURL(null, paramString, "text/html", "utf-8", null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3) {
    b b = new b();
    b.setCode(paramString1);
    b.setData(paramString3);
    b.setMessage(paramString2);
    this.e.a(b);
  }
  
  public void b(String paramString) {
    b b2 = this.e.a();
    b b1 = b2;
    if (b2 == null) {
      b1 = new b();
      b1.setCode("JDP000001");
    } 
    Intent intent = new Intent();
    a a = new a();
    if ("000000".equals(b1.getCode())) {
      a.payStatus = "JDP_PAY_SUCCESS";
    } else if ("JDP000001".equals(b1.getCode())) {
      a.payStatus = "JDP_PAY_CANCEL";
    } else {
      a.payStatus = "JDP_PAY_FAIL";
      a.errorCode = b1.getCode();
    } 
    if (b1.getData() != null)
      a.extraMsg = b1.getData(); 
    intent.putExtra("jdpay_Result", c.a(a, a.class));
    setResult(1005, intent);
    finish();
  }
  
  public void onBackPressed() {
    a();
  }
  
  @SuppressLint({"JavascriptInterface"})
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    f.a((Context)this);
    setContentView(f.a("activity_brower"));
    this.e = new d();
    this.e.b = getIntent().getStringExtra("title");
    this.e.a = getIntent().getStringExtra("url");
    this.e.e = getIntent().getBooleanExtra("post", false);
    this.e.h = getIntent().getStringExtra("type");
    this.e.f = (RequestParam)getIntent().getSerializableExtra("postParams");
    this.e.i = getIntent().getStringExtra("closeSDK");
    this.a = (WebView)findViewById(f.e("web_show"));
    this.b = (ImageView)findViewById(f.e("title_back"));
    this.c = (ProgressBar)findViewById(f.e("progressbar_internal"));
    this.d = (TextView)findViewById(f.e("top"));
    b();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\browser\BrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */