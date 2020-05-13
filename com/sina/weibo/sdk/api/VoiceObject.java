package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceObject extends BaseMediaObject {
  public static final Parcelable.Creator<VoiceObject> CREATOR = new Parcelable.Creator<VoiceObject>() {
      public VoiceObject createFromParcel(Parcel param1Parcel) {
        return new VoiceObject(param1Parcel);
      }
      
      public VoiceObject[] newArray(int param1Int) {
        return new VoiceObject[param1Int];
      }
    };
  
  public static final String EXTRA_KEY_DEFAULTTEXT = "extra_key_defaulttext";
  
  public String dataHdUrl;
  
  public String dataUrl;
  
  public String defaultText;
  
  public int duration;
  
  public String h5Url;
  
  public VoiceObject() {}
  
  public VoiceObject(Parcel paramParcel) {
    super(paramParcel);
    this.h5Url = paramParcel.readString();
    this.dataUrl = paramParcel.readString();
    this.dataHdUrl = paramParcel.readString();
    this.duration = paramParcel.readInt();
  }
  
  public boolean checkArgs() {
    if (!super.checkArgs())
      return false; 
    if (this.dataUrl != null && this.dataUrl.length() > 512) {
      LogUtil.e("Weibo.VoiceObject", "checkArgs fail, dataUrl is invalid");
      return false;
    } 
    if (this.dataHdUrl != null && this.dataHdUrl.length() > 512) {
      LogUtil.e("Weibo.VoiceObject", "checkArgs fail, dataHdUrl is invalid");
      return false;
    } 
    if (this.duration <= 0) {
      LogUtil.e("Weibo.VoiceObject", "checkArgs fail, duration is invalid");
      return false;
    } 
    return true;
  }
  
  public int getObjType() {
    return 6;
  }
  
  protected BaseMediaObject toExtraMediaObject(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      try {
        JSONObject jSONObject = new JSONObject();
        this(paramString);
        this.defaultText = jSONObject.optString("extra_key_defaulttext");
      } catch (JSONException jSONException) {} 
    return this;
  }
  
  protected String toExtraMediaString() {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      if (!TextUtils.isEmpty(this.defaultText))
        jSONObject.put("extra_key_defaulttext", this.defaultText); 
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      return "";
    } 
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.h5Url);
    paramParcel.writeString(this.dataUrl);
    paramParcel.writeString(this.dataHdUrl);
    paramParcel.writeInt(this.duration);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\api\VoiceObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */