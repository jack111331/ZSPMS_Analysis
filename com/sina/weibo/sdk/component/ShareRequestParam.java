package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MusicObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.VideoObject;
import com.sina.weibo.sdk.api.VoiceObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.BaseRequest;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareRequestParam extends BrowserRequestParamBase {
  public static final String REQ_PARAM_AID = "aid";
  
  public static final String REQ_PARAM_KEY_HASH = "key_hash";
  
  public static final String REQ_PARAM_PACKAGENAME = "packagename";
  
  public static final String REQ_PARAM_PICINFO = "picinfo";
  
  public static final String REQ_PARAM_SOURCE = "source";
  
  public static final String REQ_PARAM_TITLE = "title";
  
  public static final String REQ_PARAM_TOKEN = "access_token";
  
  public static final String REQ_PARAM_VERSION = "version";
  
  public static final String REQ_UPLOAD_PIC_PARAM_IMG = "img";
  
  public static final String RESP_UPLOAD_PIC_PARAM_CODE = "code";
  
  public static final String RESP_UPLOAD_PIC_PARAM_DATA = "data";
  
  public static final int RESP_UPLOAD_PIC_SUCC_CODE = 1;
  
  private static final String SHARE_URL = "http://service.weibo.com/share/mobilesdk.php";
  
  public static final String UPLOAD_PIC_URL = "http://service.weibo.com/share/mobilesdk_uppic.php";
  
  private String mAppKey;
  
  private String mAppPackage;
  
  private WeiboAuthListener mAuthListener;
  
  private String mAuthListenerKey;
  
  private byte[] mBase64ImgData;
  
  private BaseRequest mBaseRequest;
  
  private String mHashKey;
  
  private String mShareContent;
  
  private String mToken;
  
  public ShareRequestParam(Context paramContext) {
    super(paramContext);
  }
  
  private void handleMblogPic(String paramString, byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifne -> 114
    //   7: new java/io/File
    //   10: astore_3
    //   11: aload_3
    //   12: aload_1
    //   13: invokespecial <init> : (Ljava/lang/String;)V
    //   16: aload_3
    //   17: invokevirtual exists : ()Z
    //   20: ifeq -> 114
    //   23: aload_3
    //   24: invokevirtual canRead : ()Z
    //   27: ifeq -> 114
    //   30: aload_3
    //   31: invokevirtual length : ()J
    //   34: lconst_0
    //   35: lcmp
    //   36: ifle -> 114
    //   39: aload_3
    //   40: invokevirtual length : ()J
    //   43: l2i
    //   44: newarray byte
    //   46: astore #4
    //   48: new java/io/FileInputStream
    //   51: astore_1
    //   52: aload_1
    //   53: aload_3
    //   54: invokespecial <init> : (Ljava/io/File;)V
    //   57: aload_1
    //   58: aload #4
    //   60: invokevirtual read : ([B)I
    //   63: pop
    //   64: aload_0
    //   65: aload #4
    //   67: invokestatic encodebyte : ([B)[B
    //   70: putfield mBase64ImgData : [B
    //   73: aload_1
    //   74: invokevirtual close : ()V
    //   77: return
    //   78: astore_3
    //   79: aload_1
    //   80: astore #4
    //   82: aload_3
    //   83: astore_1
    //   84: goto -> 91
    //   87: astore_1
    //   88: aconst_null
    //   89: astore #4
    //   91: aload #4
    //   93: ifnull -> 101
    //   96: aload #4
    //   98: invokevirtual close : ()V
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull -> 114
    //   110: aload_1
    //   111: invokevirtual close : ()V
    //   114: aload_2
    //   115: ifnull -> 131
    //   118: aload_2
    //   119: arraylength
    //   120: ifle -> 131
    //   123: aload_0
    //   124: aload_2
    //   125: invokestatic encodebyte : ([B)[B
    //   128: putfield mBase64ImgData : [B
    //   131: return
    //   132: astore_1
    //   133: goto -> 114
    //   136: astore_3
    //   137: goto -> 106
    //   140: astore_1
    //   141: goto -> 77
    //   144: astore_3
    //   145: goto -> 101
    // Exception table:
    //   from	to	target	type
    //   0	48	132	java/lang/SecurityException
    //   48	57	103	java/io/IOException
    //   48	57	87	finally
    //   57	73	136	java/io/IOException
    //   57	73	78	finally
    //   73	77	140	java/lang/Exception
    //   73	77	132	java/lang/SecurityException
    //   96	101	144	java/lang/Exception
    //   96	101	132	java/lang/SecurityException
    //   101	103	132	java/lang/SecurityException
    //   110	114	132	java/lang/Exception
    //   110	114	132	java/lang/SecurityException
  }
  
  private void handleSharedMessage(Bundle paramBundle) {
    WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
    weiboMultiMessage.toObject(paramBundle);
    StringBuilder stringBuilder = new StringBuilder();
    if (weiboMultiMessage.textObject instanceof TextObject)
      stringBuilder.append(weiboMultiMessage.textObject.text); 
    if (weiboMultiMessage.imageObject instanceof ImageObject) {
      ImageObject imageObject = weiboMultiMessage.imageObject;
      handleMblogPic(imageObject.imagePath, imageObject.imageData);
    } 
    if (weiboMultiMessage.mediaObject instanceof TextObject)
      stringBuilder.append(((TextObject)weiboMultiMessage.mediaObject).text); 
    if (weiboMultiMessage.mediaObject instanceof ImageObject) {
      ImageObject imageObject = (ImageObject)weiboMultiMessage.mediaObject;
      handleMblogPic(imageObject.imagePath, imageObject.imageData);
    } 
    if (weiboMultiMessage.mediaObject instanceof WebpageObject) {
      WebpageObject webpageObject = (WebpageObject)weiboMultiMessage.mediaObject;
      stringBuilder.append(" ");
      stringBuilder.append(webpageObject.actionUrl);
    } 
    if (weiboMultiMessage.mediaObject instanceof MusicObject) {
      MusicObject musicObject = (MusicObject)weiboMultiMessage.mediaObject;
      stringBuilder.append(" ");
      stringBuilder.append(musicObject.actionUrl);
    } 
    if (weiboMultiMessage.mediaObject instanceof VideoObject) {
      VideoObject videoObject = (VideoObject)weiboMultiMessage.mediaObject;
      stringBuilder.append(" ");
      stringBuilder.append(videoObject.actionUrl);
    } 
    if (weiboMultiMessage.mediaObject instanceof VoiceObject) {
      VoiceObject voiceObject = (VoiceObject)weiboMultiMessage.mediaObject;
      stringBuilder.append(" ");
      stringBuilder.append(voiceObject.actionUrl);
    } 
    this.mShareContent = stringBuilder.toString();
  }
  
  private void sendSdkResponse(Activity paramActivity, int paramInt, String paramString) {
    Bundle bundle = paramActivity.getIntent().getExtras();
    if (bundle == null)
      return; 
    Intent intent = new Intent("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
    intent.setFlags(131072);
    intent.setPackage(bundle.getString("_weibo_appPackage"));
    intent.putExtras(bundle);
    intent.putExtra("_weibo_appPackage", paramActivity.getPackageName());
    intent.putExtra("_weibo_resp_errcode", paramInt);
    intent.putExtra("_weibo_resp_errstr", paramString);
    try {
      paramActivity.startActivityForResult(intent, 765);
    } catch (ActivityNotFoundException activityNotFoundException) {}
  }
  
  public WeiboParameters buildUploadPicParam(WeiboParameters paramWeiboParameters) {
    if (!hasImage())
      return paramWeiboParameters; 
    paramWeiboParameters.put("img", new String(this.mBase64ImgData));
    return paramWeiboParameters;
  }
  
  public String buildUrl(String paramString) {
    Uri.Builder builder = Uri.parse("http://service.weibo.com/share/mobilesdk.php").buildUpon();
    builder.appendQueryParameter("title", this.mShareContent);
    builder.appendQueryParameter("version", "0031105000");
    if (!TextUtils.isEmpty(this.mAppKey))
      builder.appendQueryParameter("source", this.mAppKey); 
    if (!TextUtils.isEmpty(this.mToken))
      builder.appendQueryParameter("access_token", this.mToken); 
    String str = Utility.getAid(this.mContext, this.mAppKey);
    if (!TextUtils.isEmpty(str))
      builder.appendQueryParameter("aid", str); 
    if (!TextUtils.isEmpty(this.mAppPackage))
      builder.appendQueryParameter("packagename", this.mAppPackage); 
    if (!TextUtils.isEmpty(this.mHashKey))
      builder.appendQueryParameter("key_hash", this.mHashKey); 
    if (!TextUtils.isEmpty(paramString))
      builder.appendQueryParameter("picinfo", paramString); 
    return builder.build().toString();
  }
  
  public void execRequest(Activity paramActivity, int paramInt) {
    if (paramInt == 3) {
      sendSdkCancleResponse(paramActivity);
      WeiboSdkBrowser.closeBrowser(paramActivity, this.mAuthListenerKey, null);
    } 
  }
  
  public String getAppKey() {
    return this.mAppKey;
  }
  
  public String getAppPackage() {
    return this.mAppPackage;
  }
  
  public WeiboAuthListener getAuthListener() {
    return this.mAuthListener;
  }
  
  public String getAuthListenerKey() {
    return this.mAuthListenerKey;
  }
  
  public byte[] getBase64ImgData() {
    return this.mBase64ImgData;
  }
  
  public String getHashKey() {
    return this.mHashKey;
  }
  
  public String getShareContent() {
    return this.mShareContent;
  }
  
  public String getToken() {
    return this.mToken;
  }
  
  public boolean hasImage() {
    return (this.mBase64ImgData != null && this.mBase64ImgData.length > 0);
  }
  
  public void onCreateRequestParamBundle(Bundle paramBundle) {
    if (this.mBaseRequest != null)
      this.mBaseRequest.toBundle(paramBundle); 
    if (!TextUtils.isEmpty(this.mAppPackage))
      this.mHashKey = MD5.hexdigest(Utility.getSign(this.mContext, this.mAppPackage)); 
    paramBundle.putString("access_token", this.mToken);
    paramBundle.putString("source", this.mAppKey);
    paramBundle.putString("packagename", this.mAppPackage);
    paramBundle.putString("key_hash", this.mHashKey);
    paramBundle.putString("_weibo_appPackage", this.mAppPackage);
    paramBundle.putString("_weibo_appKey", this.mAppKey);
    paramBundle.putInt("_weibo_flag", 538116905);
    paramBundle.putString("_weibo_sign", this.mHashKey);
    if (this.mAuthListener != null) {
      WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance(this.mContext);
      this.mAuthListenerKey = weiboCallbackManager.genCallbackKey();
      weiboCallbackManager.setWeiboAuthListener(this.mAuthListenerKey, this.mAuthListener);
      paramBundle.putString("key_listener", this.mAuthListenerKey);
    } 
  }
  
  protected void onSetupRequestParam(Bundle paramBundle) {
    this.mAppKey = paramBundle.getString("source");
    this.mAppPackage = paramBundle.getString("packagename");
    this.mHashKey = paramBundle.getString("key_hash");
    this.mToken = paramBundle.getString("access_token");
    this.mAuthListenerKey = paramBundle.getString("key_listener");
    if (!TextUtils.isEmpty(this.mAuthListenerKey))
      this.mAuthListener = WeiboCallbackManager.getInstance(this.mContext).getWeiboAuthListener(this.mAuthListenerKey); 
    handleSharedMessage(paramBundle);
    this.mUrl = buildUrl("");
  }
  
  public void sendSdkCancleResponse(Activity paramActivity) {
    sendSdkResponse(paramActivity, 1, "send cancel!!!");
  }
  
  public void sendSdkErrorResponse(Activity paramActivity, String paramString) {
    sendSdkResponse(paramActivity, 2, paramString);
  }
  
  public void sendSdkOkResponse(Activity paramActivity) {
    sendSdkResponse(paramActivity, 0, "send ok!!!");
  }
  
  public void setAppKey(String paramString) {
    this.mAppKey = paramString;
  }
  
  public void setAppPackage(String paramString) {
    this.mAppPackage = paramString;
  }
  
  public void setAuthListener(WeiboAuthListener paramWeiboAuthListener) {
    this.mAuthListener = paramWeiboAuthListener;
  }
  
  public void setBaseRequest(BaseRequest paramBaseRequest) {
    this.mBaseRequest = paramBaseRequest;
  }
  
  public void setToken(String paramString) {
    this.mToken = paramString;
  }
  
  public static class UploadPicResult {
    private int code = -2;
    
    private String picId;
    
    public static UploadPicResult parse(String param1String) {
      if (TextUtils.isEmpty(param1String))
        return null; 
      UploadPicResult uploadPicResult = new UploadPicResult();
      try {
        JSONObject jSONObject = new JSONObject();
        this(param1String);
        uploadPicResult.code = jSONObject.optInt("code", -2);
        uploadPicResult.picId = jSONObject.optString("data", "");
      } catch (JSONException jSONException) {}
      return uploadPicResult;
    }
    
    public int getCode() {
      return this.code;
    }
    
    public String getPicId() {
      return this.picId;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\component\ShareRequestParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */