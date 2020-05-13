package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;

public class UpdateInfo implements Parcelable {
  public static final Parcelable.Creator<UpdateInfo> CREATOR = new UpdateInfo$1();
  
  public static final String TYPE_MUST = "02";
  
  public static final String TYPE_NONE = "00";
  
  public static final String TYPE_OPTION = "01";
  
  private String mClientDigest;
  
  private String[] mDesc;
  
  private String mDownloadUrl;
  
  private String mType;
  
  public UpdateInfo() {}
  
  public UpdateInfo(Parcel paramParcel) {
    this.mType = paramParcel.readString();
    this.mDownloadUrl = paramParcel.readString();
    this.mClientDigest = paramParcel.readString();
    this.mDesc = paramParcel.createStringArray();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getClientDigest() {
    return this.mClientDigest;
  }
  
  public String[] getDesc() {
    return this.mDesc;
  }
  
  public String getDownloadUrl() {
    return this.mDownloadUrl;
  }
  
  public String getType() {
    return this.mType;
  }
  
  public void setClientDigest(String paramString) {
    this.mClientDigest = paramString;
  }
  
  public void setDesc(String[] paramArrayOfString) {
    this.mDesc = paramArrayOfString;
  }
  
  public void setDownloadUrl(String paramString) {
    this.mDownloadUrl = paramString;
  }
  
  public void setType(String paramString) {
    this.mType = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.mType);
    paramParcel.writeString(this.mDownloadUrl);
    paramParcel.writeString(this.mClientDigest);
    paramParcel.writeStringArray(this.mDesc);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\data\UpdateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */