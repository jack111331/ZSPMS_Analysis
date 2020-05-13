package com.cmic.sso.sdk.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.cmic.sso.sdk.utils.z;

public class a extends Dialog {
  private WebView a;
  
  private String b;
  
  public a(Context paramContext, int paramInt, String paramString) {
    super(paramContext, paramInt);
    this.b = paramString;
    a();
  }
  
  private int a(int paramInt) {
    return (int)((getContext().getResources().getDisplayMetrics()).density * paramInt + 0.5F);
  }
  
  private ViewGroup b() {
    LinearLayout linearLayout = new LinearLayout(getContext());
    linearLayout.setOrientation(1);
    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    linearLayout.addView((View)z.a(getContext(), 1118481, 2236962, "服务条款", new View.OnClickListener(this) {
            public void onClick(View param1View) {
              a.a(this.a).stopLoading();
              this.a.cancel();
            }
          }), (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, a(50)));
    this.a = new WebView(getContext());
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
    linearLayout.addView((View)this.a, (ViewGroup.LayoutParams)layoutParams);
    return (ViewGroup)linearLayout;
  }
  
  protected void a() {
    requestWindowFeature(1);
    getWindow().setFeatureDrawableAlpha(0, 0);
    setContentView((View)b());
    if (Build.VERSION.SDK_INT < 17) {
      this.a.removeJavascriptInterface("searchBoxJavaBridge_");
      this.a.removeJavascriptInterface("accessibility");
      this.a.removeJavascriptInterface("accessibilityTraversal");
    } 
    this.a.setWebViewClient(new WebViewClient(this) {
          public boolean shouldOverrideUrlLoading(WebView param1WebView, String param1String) {
            a.a(this.a).loadUrl(param1String);
            return true;
          }
        });
    this.a.loadUrl(this.b);
  }
  
  public void dismiss() {
    super.dismiss();
    this.a.stopLoading();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\widget\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */