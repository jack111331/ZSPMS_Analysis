package com.chuanglan.shanyan_sdk.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chuanglan.shanyan_sdk.utils.AppStringUtils;
import com.chuanglan.shanyan_sdk.utils.LCMResource;

public class CTCCPrivacyProtocolActivity extends Activity {
  private ProgressWebView a;
  
  private Boolean b = Boolean.valueOf(false);
  
  private void a(String paramString) {
    this.a.loadUrl(paramString);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(LCMResource.getInstance((Context)this).getLayoutForView("activity_ctcc_privacy_protocol"));
    TextView textView = (TextView)findViewById(LCMResource.getInstance((Context)this).getId("oauth_title"));
    RelativeLayout relativeLayout = (RelativeLayout)findViewById(LCMResource.getInstance((Context)this).getId("agreement_title"));
    Intent intent = getIntent();
    String str1 = intent.getStringExtra("url");
    String str2 = intent.getStringExtra("title");
    textView.setText(str2);
    if ("中国联通认证服务协议".equals(str2)) {
      relativeLayout.setVisibility(8);
      this.b = Boolean.valueOf(true);
    } 
    findViewById(LCMResource.getInstance((Context)this).getId("ctcc_agreement_back")).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (CTCCPrivacyProtocolActivity.a(this.a) != null) {
              if (CTCCPrivacyProtocolActivity.a(this.a).canGoBack()) {
                CTCCPrivacyProtocolActivity.a(this.a).goBack();
                return;
              } 
              this.a.finish();
              return;
            } 
            this.a.finish();
          }
        });
    this.a = (ProgressWebView)findViewById(LCMResource.getInstance((Context)this).getId("baseweb_webview"));
    this.a.getSettings().setJavaScriptEnabled(true);
    this.a.getSettings().setSupportZoom(true);
    this.a.getSettings().setBuiltInZoomControls(true);
    this.a.getSettings().setCacheMode(2);
    this.a.getSettings().setSupportMultipleWindows(true);
    this.a.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.a.setWebViewClient(new WebViewClient(this) {
          public boolean shouldOverrideUrlLoading(WebView param1WebView, String param1String) {
            if (CTCCPrivacyProtocolActivity.b(this.a).booleanValue()) {
              this.a.finish();
              return true;
            } 
            return super.shouldOverrideUrlLoading(param1WebView, param1String);
          }
        });
    if (AppStringUtils.isNotEmpty(str1))
      a(str1); 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    null = true;
    if (paramInt == 4 && this.a.canGoBack()) {
      this.a.goBack();
      return null;
    } 
    if (paramInt == 4 && paramKeyEvent.getRepeatCount() == 0) {
      finish();
      return null;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\view\CTCCPrivacyProtocolActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */