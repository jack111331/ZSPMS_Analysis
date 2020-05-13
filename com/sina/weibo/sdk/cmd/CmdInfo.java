package com.sina.weibo.sdk.cmd;

import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class CmdInfo {
  private static final String TAG = BaseCmd.class.getName();
  
  private int frequency;
  
  private List<AppInstallCmd> mInstallCmds;
  
  private List<AppInvokeCmd> mInvokeCmds;
  
  public CmdInfo(String paramString) throws WeiboException {
    initFromJsonStr(paramString);
  }
  
  private void initFromJsonStr(String paramString) throws WeiboException {
    if (paramString == null)
      return; 
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      if (!jSONObject.has("error") && !jSONObject.has("error_code")) {
        jSONObject = jSONObject.optJSONObject("cmd");
        if (jSONObject != null) {
          this.frequency = jSONObject.optInt("frequency");
          JSONArray jSONArray = jSONObject.optJSONArray("app_install");
          byte b = 0;
          if (jSONArray != null) {
            ArrayList<AppInstallCmd> arrayList = new ArrayList();
            this();
            this.mInstallCmds = arrayList;
            for (byte b1 = 0; b1 < jSONArray.length(); b1++) {
              JSONObject jSONObject1 = jSONArray.getJSONObject(b1);
              List<AppInstallCmd> list = this.mInstallCmds;
              AppInstallCmd appInstallCmd = new AppInstallCmd();
              this(jSONObject1);
              list.add(appInstallCmd);
            } 
          } 
          jSONArray = jSONObject.optJSONArray("app_invoke");
          if (jSONArray != null) {
            ArrayList<AppInvokeCmd> arrayList = new ArrayList();
            this();
            this.mInvokeCmds = arrayList;
            for (byte b1 = b; b1 < jSONArray.length(); b1++) {
              JSONObject jSONObject1 = jSONArray.getJSONObject(b1);
              List<AppInvokeCmd> list = this.mInvokeCmds;
              AppInvokeCmd appInvokeCmd = new AppInvokeCmd();
              this(jSONObject1);
              list.add(appInvokeCmd);
            } 
          } 
        } 
      } else {
        LogUtil.w(TAG, "load cmd api has error !!!");
        WeiboException weiboException = new WeiboException();
        this("load cmd api has error !!!");
        throw weiboException;
      } 
    } catch (JSONException jSONException) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder("parse NotificationInfo error: ");
      stringBuilder.append(jSONException.getMessage());
      LogUtil.d(str, stringBuilder.toString());
    } 
  }
  
  public int getFrequency() {
    return this.frequency;
  }
  
  public List<AppInstallCmd> getInstallCmds() {
    return this.mInstallCmds;
  }
  
  public List<AppInvokeCmd> getInvokeCmds() {
    return this.mInvokeCmds;
  }
  
  public void setFrequency(int paramInt) {
    this.frequency = paramInt;
  }
  
  public void setInstallCmds(List<AppInstallCmd> paramList) {
    this.mInstallCmds = paramList;
  }
  
  public void setInvokeCmds(List<AppInvokeCmd> paramList) {
    this.mInvokeCmds = paramList;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\cmd\CmdInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */