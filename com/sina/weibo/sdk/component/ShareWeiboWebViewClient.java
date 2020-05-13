package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.utils.Utility;

class ShareWeiboWebViewClient extends WeiboWebViewClient {
  private static final String RESP_PARAM_CODE = "code";
  
  private static final String RESP_PARAM_MSG = "msg";
  
  private static final String RESP_SUCC_CODE = "0";
  
  private Activity mAct;
  
  private WeiboAuthListener mListener;
  
  private ShareRequestParam mShareRequestParam;
  
  public ShareWeiboWebViewClient(Activity paramActivity, ShareRequestParam paramShareRequestParam) {
    this.mAct = paramActivity;
    this.mShareRequestParam = paramShareRequestParam;
    this.mListener = paramShareRequestParam.getAuthListener();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    if (this.mCallBack != null)
      this.mCallBack.onPageFinishedCallBack(paramWebView, paramString); 
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
    if (this.mCallBack != null)
      this.mCallBack.onPageStartedCallBack(paramWebView, paramString, paramBitmap); 
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    if (this.mCallBack != null)
      this.mCallBack.onReceivedErrorCallBack(paramWebView, paramInt, paramString1, paramString2); 
    this.mShareRequestParam.sendSdkErrorResponse(this.mAct, paramString1);
    WeiboSdkBrowser.closeBrowser(this.mAct, this.mShareRequestParam.getAuthListenerKey(), null);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
    if (this.mCallBack != null)
      this.mCallBack.onReceivedSslErrorCallBack(paramWebView, paramSslErrorHandler, paramSslError); 
    paramSslErrorHandler.cancel();
    this.mShareRequestParam.sendSdkErrorResponse(this.mAct, "ReceivedSslError");
    WeiboSdkBrowser.closeBrowser(this.mAct, this.mShareRequestParam.getAuthListenerKey(), null);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    String str1;
    String str2;
    if (this.mCallBack != null)
      this.mCallBack.shouldOverrideUrlLoadingCallBack(paramWebView, paramString); 
    if (paramString.startsWith("sinaweibo://browser/close")) {
      Bundle bundle = Utility.parseUri(paramString);
      if (!bundle.isEmpty() && this.mListener != null)
        this.mListener.onComplete(bundle); 
      str1 = bundle.getString("code");
      str2 = bundle.getString("msg");
      if (TextUtils.isEmpty(str1)) {
        this.mShareRequestParam.sendSdkCancleResponse(this.mAct);
      } else if (!"0".equals(str1)) {
        this.mShareRequestParam.sendSdkErrorResponse(this.mAct, str2);
      } else {
        this.mShareRequestParam.sendSdkOkResponse(this.mAct);
      } 
      WeiboSdkBrowser.closeBrowser(this.mAct, this.mShareRequestParam.getAuthListenerKey(), null);
      return true;
    } 
    return super.shouldOverrideUrlLoading((WebView)str1, str2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\component\ShareWeiboWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */