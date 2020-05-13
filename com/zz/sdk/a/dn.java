package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.zz.sdk.b.a.ab;
import com.zz.sdk.i.a;

public class dn extends w implements View.OnClickListener {
  private WebView a;
  
  public dn(Activity paramActivity) {
    super(paramActivity);
  }
  
  public dn(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    (new dq(this)).start();
  }
  
  private void a(WebView paramWebView, String paramString1, String paramString2, String paramString3) {
    if (paramWebView == null || paramString2 == null || paramString1 == null)
      return; 
    if (Build.VERSION.SDK_INT >= 19) {
      try {
        if (TextUtils.isEmpty(paramString3)) {
          StringBuilder stringBuilder1 = new StringBuilder();
          this();
          paramWebView.evaluateJavascript(stringBuilder1.append("replace(\"").append(paramString1).append("\", '')").toString(), null);
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
        if (TextUtils.isEmpty(paramString3)) {
          paramWebView.loadUrl("javascript:replace(\"" + paramString1 + "\", '')");
          return;
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      paramWebView.evaluateJavascript(stringBuilder.append("replace(\"").append(paramString1).append("\", '").append(paramString2).append(paramString3).append("')").toString(), null);
      return;
    } 
    if (TextUtils.isEmpty(paramString3)) {
      paramWebView.loadUrl("javascript:replace(\"" + paramString1 + "\", '')");
      return;
    } 
  }
  
  private void a(ab paramab) {
    if (this.a != null && paramab != null && paramab.c())
      this.k.post(new dr(this, paramab)); 
  }
  
  public int D() {
    return -1;
  }
  
  public int E() {
    return -1;
  }
  
  void a() {
    A();
    setTitle(2131165366);
    LinearLayout linearLayout = (LinearLayout)findViewById(2131296362);
    if (a.a()) {
      str = "usercenter_helpcomm.html";
    } else {
      str = "usercenter_help.html";
    } 
    String str = "file:///android_asset/zz_res/" + str;
    this.a = new WebView((Context)this.b);
    this.a.setBackgroundColor(0);
    this.a.setLayerType(1, null);
    this.a.getSettings().setJavaScriptEnabled(true);
    this.a.setWebChromeClient(new WebChromeClient());
    this.a.loadUrl(str);
    this.a.setWebViewClient(new do(this));
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
    linearLayout.addView((View)this.a, (ViewGroup.LayoutParams)layoutParams);
  }
  
  int c() {
    return 2130903079;
  }
  
  public void onClick(View paramView) {}
  
  public void show() {
    super.show();
    getWindow().setSoftInputMode(3);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */