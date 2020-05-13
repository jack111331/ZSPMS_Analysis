package com.chuanglan.shanyan_sdk.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import com.chuanglan.shanyan_sdk.utils.LCMResource;

public class ProgressWebView extends WebView {
  private ProgressBar a;
  
  public ProgressWebView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = new ProgressBar(paramContext, null, 16842872);
    this.a.setLayoutParams((ViewGroup.LayoutParams)new AbsoluteLayout.LayoutParams(-1, 5, 0, 0));
    Drawable drawable = LCMResource.getInstance(paramContext).getDrawable("progress_bar_states");
    this.a.setProgressDrawable(drawable);
    addView((View)this.a);
    setWebViewClient(new b(this));
    setWebChromeClient(new a(this));
    getSettings().setSupportZoom(true);
    getSettings().setBuiltInZoomControls(true);
    getSettings().setCacheMode(2);
    getSettings().setSupportMultipleWindows(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().setDomStorageEnabled(true);
    getSettings().setPluginState(WebSettings.PluginState.ON);
    if (Build.VERSION.SDK_INT >= 21)
      getSettings().setMixedContentMode(0); 
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams)this.a.getLayoutParams();
    layoutParams.x = paramInt1;
    layoutParams.y = paramInt2;
    this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  class a extends WebChromeClient {
    a(ProgressWebView this$0) {}
    
    public boolean onCreateWindow(WebView param1WebView, boolean param1Boolean1, boolean param1Boolean2, Message param1Message) {
      param1WebView = new WebView(param1WebView.getContext());
      ((WebView.WebViewTransport)param1Message.obj).setWebView(param1WebView);
      param1Message.sendToTarget();
      return true;
    }
    
    public void onProgressChanged(WebView param1WebView, int param1Int) {
      if (param1Int == 100) {
        ProgressWebView.a(this.a).setVisibility(8);
      } else {
        if (ProgressWebView.a(this.a).getVisibility() == 8)
          ProgressWebView.a(this.a).setVisibility(0); 
        ProgressWebView.a(this.a).setProgress(param1Int);
      } 
      super.onProgressChanged(param1WebView, param1Int);
    }
  }
  
  class b extends WebViewClient {
    b(ProgressWebView this$0) {}
    
    public void onReceivedSslError(WebView param1WebView, SslErrorHandler param1SslErrorHandler, SslError param1SslError) {
      AlertDialog.Builder builder = new AlertDialog.Builder(param1WebView.getContext());
      builder.setMessage("SSL认证失败，是否继续访问？");
      builder.setPositiveButton("确定", new DialogInterface.OnClickListener(this, param1SslErrorHandler) {
            public void onClick(DialogInterface param2DialogInterface, int param2Int) {
              this.a.proceed();
            }
          });
      builder.setNegativeButton("取消", new DialogInterface.OnClickListener(this, param1SslErrorHandler) {
            public void onClick(DialogInterface param2DialogInterface, int param2Int) {
              this.a.cancel();
            }
          });
      builder.create().show();
    }
    
    public boolean shouldOverrideKeyEvent(WebView param1WebView, KeyEvent param1KeyEvent) {
      return super.shouldOverrideKeyEvent(param1WebView, param1KeyEvent);
    }
    
    public boolean shouldOverrideUrlLoading(WebView param1WebView, String param1String) {
      param1WebView.loadUrl(param1String);
      return true;
    }
  }
  
  class null implements DialogInterface.OnClickListener {
    null(ProgressWebView this$0, SslErrorHandler param1SslErrorHandler) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      this.a.proceed();
    }
  }
  
  class null implements DialogInterface.OnClickListener {
    null(ProgressWebView this$0, SslErrorHandler param1SslErrorHandler) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      this.a.cancel();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\view\ProgressWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */