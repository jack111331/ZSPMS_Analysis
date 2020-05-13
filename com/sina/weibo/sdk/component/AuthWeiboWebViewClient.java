package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.Utility;

class AuthWeiboWebViewClient extends WeiboWebViewClient {
  private boolean isCallBacked = false;
  
  private Activity mAct;
  
  private AuthRequestParam mAuthRequestParam;
  
  private WeiboAuthListener mListener;
  
  public AuthWeiboWebViewClient(Activity paramActivity, AuthRequestParam paramAuthRequestParam) {
    this.mAct = paramActivity;
    this.mAuthRequestParam = paramAuthRequestParam;
    this.mListener = this.mAuthRequestParam.getAuthListener();
  }
  
  private void handleRedirectUrl(String paramString) {
    Bundle bundle = Utility.parseUrl(paramString);
    paramString = bundle.getString("error");
    String str1 = bundle.getString("error_code");
    String str2 = bundle.getString("error_description");
    if (paramString == null && str1 == null) {
      if (this.mListener != null)
        this.mListener.onComplete(bundle); 
    } else if (this.mListener != null) {
      this.mListener.onWeiboException((WeiboException)new WeiboAuthException(str1, paramString, str2));
    } 
  }
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    if (this.mCallBack != null)
      this.mCallBack.onPageFinishedCallBack(paramWebView, paramString); 
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
    if (this.mCallBack != null)
      this.mCallBack.onPageStartedCallBack(paramWebView, paramString, paramBitmap); 
    if (paramString.startsWith(this.mAuthRequestParam.getAuthInfo().getRedirectUrl()) && !this.isCallBacked) {
      this.isCallBacked = true;
      handleRedirectUrl(paramString);
      paramWebView.stopLoading();
      WeiboSdkBrowser.closeBrowser(this.mAct, this.mAuthRequestParam.getAuthListenerKey(), null);
      return;
    } 
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    if (this.mCallBack != null)
      this.mCallBack.onReceivedErrorCallBack(paramWebView, paramInt, paramString1, paramString2); 
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
    if (this.mCallBack != null)
      this.mCallBack.onReceivedSslErrorCallBack(paramWebView, paramSslErrorHandler, paramSslError); 
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    Intent intent;
    if (this.mCallBack != null)
      this.mCallBack.shouldOverrideUrlLoadingCallBack(paramWebView, paramString); 
    if (paramString.startsWith("sms:")) {
      intent = new Intent("android.intent.action.VIEW");
      intent.putExtra("address", paramString.replace("sms:", ""));
      intent.setType("vnd.android-dir/mms-sms");
      this.mAct.startActivity(intent);
      return true;
    } 
    if (paramString.startsWith("sinaweibo://browser/close")) {
      if (this.mListener != null)
        this.mListener.onCancel(); 
      WeiboSdkBrowser.closeBrowser(this.mAct, this.mAuthRequestParam.getAuthListenerKey(), null);
      return true;
    } 
    return super.shouldOverrideUrlLoading((WebView)intent, paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\component\AuthWeiboWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */