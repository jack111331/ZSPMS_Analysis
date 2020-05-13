package com.alipay.sdk.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.util.l;
import com.alipay.sdk.widget.a;

public final class b extends WebViewClient {
  Activity a;
  
  Handler b;
  
  boolean c;
  
  private boolean d;
  
  private a e;
  
  private Runnable f = new f(this);
  
  public b(Activity paramActivity) {
    this.a = paramActivity;
    this.b = new Handler(this.a.getMainLooper());
  }
  
  private void a() {
    if (this.e == null) {
      this.e = new a(this.a, "正在加载");
      this.e.e = true;
    } 
    this.e.a();
  }
  
  private void b() {
    if (this.e != null)
      this.e.b(); 
    this.e = null;
  }
  
  private void c() {
    this.b = null;
    this.a = null;
  }
  
  private boolean d() {
    return this.c;
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString) {
    if (this.b != null) {
      b();
      this.b.removeCallbacks(this.f);
    } 
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
    if (this.b != null) {
      if (this.e == null) {
        this.e = new a(this.a, "正在加载");
        this.e.e = true;
      } 
      this.e.a();
      this.b.postDelayed(this.f, 30000L);
    } 
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    this.c = true;
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
    a.a("net", "SSLError", "证书错误");
    if (this.d) {
      paramSslErrorHandler.proceed();
      this.d = false;
      return;
    } 
    this.a.runOnUiThread(new c(this, paramSslErrorHandler));
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    return l.a(paramWebView, paramString, this.a);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\app\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */