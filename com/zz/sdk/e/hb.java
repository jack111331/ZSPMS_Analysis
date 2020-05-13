package com.zz.sdk.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.zz.sdk.a.bs;
import com.zz.sdk.i.a;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.df;

@SuppressLint({"ViewConstructor"})
public class hb extends LinearLayout {
  private String a;
  
  public hb(Context paramContext, String paramString) {
    super(paramContext);
    this.a = paramString;
    a(paramContext);
    (bs.a(paramContext)).q = 10;
  }
  
  @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
  private void a(Context paramContext) {
    LinearLayout linearLayout1 = new LinearLayout(paramContext);
    linearLayout1.setOrientation(1);
    addView((View)linearLayout1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    LinearLayout linearLayout2 = new LinearLayout(paramContext);
    linearLayout2.setOrientation(1);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
    layoutParams.setMargins(df.a(paramContext, 4.0F), 0, df.a(paramContext, 4.0F), df.a(paramContext, 0.0F));
    linearLayout2.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    linearLayout1.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams);
    String str = "";
    if (this.a.equals("库洛游戏隐私政策")) {
      if (a.a()) {
        str = cv.h().t();
      } else {
        str = cv.h().s();
      } 
    } else if (this.a.equals("库洛游戏用户协议")) {
      if (a.a()) {
        str = cv.h().r();
      } else {
        str = cv.h().q();
      } 
    } 
    WebView webView = new WebView(paramContext);
    webView.setBackgroundColor(0);
    webView.setLayerType(1, null);
    WebSettings webSettings = webView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setUseWideViewPort(true);
    webSettings.setLoadWithOverviewMode(true);
    webSettings.setTextZoom(350);
    webView.setHorizontalScrollBarEnabled(false);
    webView.setWebChromeClient(new WebChromeClient());
    webView.loadUrl(str);
    webView.setWebViewClient(new hc(this));
    linearLayout2.addView((View)webView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\hb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */