package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.util.Log;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import org.json.JSONObject;

final class f extends AsyncTask<Void, Void, f.a> {
  private int A;
  
  private OAuthListener r;
  
  private String u;
  
  private String url;
  
  public f(String paramString, OAuthListener paramOAuthListener) {
    this.u = paramString;
    this.r = paramOAuthListener;
    this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[] { paramString });
  }
  
  static final class a {
    public String B;
    
    public int C;
    
    public OAuthErrCode t;
    
    public static a b(byte[] param1ArrayOfbyte) {
      OAuthErrCode oAuthErrCode2;
      Object[] arrayOfObject;
      String str;
      a a1 = new a();
      if (param1ArrayOfbyte == null || param1ArrayOfbyte.length == 0) {
        Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NetworkErr;
        a1.t = oAuthErrCode2;
        return a1;
      } 
      try {
        str = new String();
        this((byte[])oAuthErrCode2, "utf-8");
        try {
          OAuthErrCode oAuthErrCode;
          JSONObject jSONObject = new JSONObject();
          this(str);
          a1.C = jSONObject.getInt("wx_errcode");
          Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", new Object[] { Integer.valueOf(a1.C) }));
          int i = a1.C;
          if (i != 408) {
            if (i != 500) {
              switch (i) {
                default:
                  oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                  a1.t = oAuthErrCode;
                  return a1;
                case 405:
                  a1.t = OAuthErrCode.WechatAuth_Err_OK;
                  a1.B = oAuthErrCode.getString("wx_code");
                  return a1;
                case 404:
                  oAuthErrCode = OAuthErrCode.WechatAuth_Err_OK;
                  a1.t = oAuthErrCode;
                  return a1;
                case 403:
                  oAuthErrCode = OAuthErrCode.WechatAuth_Err_Cancel;
                  a1.t = oAuthErrCode;
                  return a1;
                case 402:
                  break;
              } 
              oAuthErrCode = OAuthErrCode.WechatAuth_Err_Timeout;
            } else {
              oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
            } 
          } else {
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_OK;
          } 
          a1.t = oAuthErrCode;
          return a1;
        } catch (Exception exception) {
          str = "parse json fail, ex = %s";
          arrayOfObject = new Object[1];
          arrayOfObject[0] = exception.getMessage();
        } 
      } catch (Exception exception) {
        str = "parse fail, build String fail, ex = %s";
        arrayOfObject = new Object[1];
        arrayOfObject[0] = exception.getMessage();
      } 
      Log.e("MicroMsg.SDK.NoopingResult", String.format(str, arrayOfObject));
      OAuthErrCode oAuthErrCode1 = OAuthErrCode.WechatAuth_Err_NormalErr;
      a1.t = oAuthErrCode1;
      return a1;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\diffdev\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */