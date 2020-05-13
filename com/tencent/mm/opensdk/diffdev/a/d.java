package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;

public final class d extends AsyncTask<Void, Void, d.a> {
  private static final boolean m;
  
  private static final String n;
  
  private static String o = null;
  
  private String appId;
  
  private String p;
  
  private String q;
  
  private OAuthListener r;
  
  private f s;
  
  private String scope;
  
  private String signature;
  
  static {
    o = "http://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener) {
    this.appId = paramString1;
    this.scope = paramString2;
    this.p = paramString3;
    this.q = paramString4;
    this.signature = paramString5;
    this.r = paramOAuthListener;
  }
  
  public final boolean a() {
    Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
    return (this.s == null) ? cancel(true) : this.s.cancel(true);
  }
  
  static {
    boolean bool;
    if (Environment.getExternalStorageState().equals("mounted") && (new File(Environment.getExternalStorageDirectory().getAbsolutePath())).canWrite()) {
      bool = true;
    } else {
      bool = false;
    } 
    m = bool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    stringBuilder.append("/tencent/MicroMsg/oauth_qrcode.png");
    n = stringBuilder.toString();
  }
  
  static final class a {
    public OAuthErrCode t;
    
    public String u;
    
    public String v;
    
    public String w;
    
    public int x;
    
    public String y;
    
    public byte[] z;
    
    public static a a(byte[] param1ArrayOfbyte) {
      OAuthErrCode oAuthErrCode2;
      Object[] arrayOfObject;
      String str;
      a a1 = new a();
      if (param1ArrayOfbyte == null || param1ArrayOfbyte.length == 0) {
        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NetworkErr;
        a1.t = oAuthErrCode2;
        return a1;
      } 
      try {
        str = new String();
        this((byte[])oAuthErrCode2, "utf-8");
        try {
          JSONObject jSONObject = new JSONObject();
          this(str);
          int i = jSONObject.getInt("errcode");
          if (i != 0) {
            Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", new Object[] { Integer.valueOf(i) }));
            a1.t = OAuthErrCode.WechatAuth_Err_NormalErr;
            a1.x = i;
            a1.y = jSONObject.optString("errmsg");
            return a1;
          } 
          str = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
          if (str == null || str.length() == 0) {
            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
            a1.t = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
            return a1;
          } 
          byte[] arrayOfByte = Base64.decode(str, 0);
          if (arrayOfByte == null || arrayOfByte.length == 0) {
            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
            a1.t = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
            return a1;
          } 
          if (d.b()) {
            File file = new File();
            this(d.c());
            file.mkdirs();
            if (file.exists())
              file.delete(); 
            if (!a(d.c(), arrayOfByte)) {
              Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("writeToFile fail, qrcodeBuf length = %d", new Object[] { Integer.valueOf(arrayOfByte.length) }));
              a1.t = OAuthErrCode.WechatAuth_Err_NormalErr;
              return a1;
            } 
            a1.t = OAuthErrCode.WechatAuth_Err_OK;
            a1.w = d.c();
            a1.u = jSONObject.getString("uuid");
            a1.v = jSONObject.getString("appname");
            Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in external storage, uuid = %s, appname = %s, imgPath = %s", new Object[] { a1.u, a1.v, a1.w }));
            return a1;
          } 
          a1.t = OAuthErrCode.WechatAuth_Err_OK;
          a1.z = arrayOfByte;
          a1.u = jSONObject.getString("uuid");
          a1.v = jSONObject.getString("appname");
          Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[] { a1.u, a1.v, Integer.valueOf(a1.z.length) }));
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
      Log.e("MicroMsg.SDK.GetQRCodeResult", String.format(str, arrayOfObject));
      OAuthErrCode oAuthErrCode1 = OAuthErrCode.WechatAuth_Err_NormalErr;
      a1.t = oAuthErrCode1;
      return a1;
    }
    
    private static boolean a(String param1String, byte[] param1ArrayOfbyte) {
      String str1 = null;
      FileOutputStream fileOutputStream1 = null;
      FileOutputStream fileOutputStream2 = fileOutputStream1;
      try {
        FileOutputStream fileOutputStream = new FileOutputStream();
        fileOutputStream2 = fileOutputStream1;
        this(param1String);
        try {
          fileOutputStream.write(param1ArrayOfbyte);
          fileOutputStream.flush();
          try {
            fileOutputStream.close();
          } catch (IOException iOException) {
            StringBuilder stringBuilder1 = new StringBuilder("fout.close() exception:");
            stringBuilder1.append(iOException.getMessage());
            Log.e("MicroMsg.SDK.GetQRCodeResult", stringBuilder1.toString());
          } 
          return true;
        } catch (Exception null) {
        
        } finally {
          param1String = null;
        } 
      } catch (Exception exception) {
        param1String = str1;
      } finally {}
      String str2 = param1String;
      StringBuilder stringBuilder = new StringBuilder();
      str2 = param1String;
      this("write to file error, exception:");
      str2 = param1String;
      stringBuilder.append(exception.getMessage());
      str2 = param1String;
      Log.w("MicroMsg.SDK.GetQRCodeResult", stringBuilder.toString());
      if (param1String != null)
        try {
          param1String.close();
        } catch (IOException iOException) {
          StringBuilder stringBuilder1 = new StringBuilder("fout.close() exception:");
          stringBuilder1.append(iOException.getMessage());
          Log.e("MicroMsg.SDK.GetQRCodeResult", stringBuilder1.toString());
        }  
      return false;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\diffdev\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */