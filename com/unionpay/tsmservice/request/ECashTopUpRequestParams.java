package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.unionpay.tsmservice.AppID;

public class ECashTopUpRequestParams extends RequestParams {
  public static final Parcelable.Creator<ECashTopUpRequestParams> CREATOR = new ECashTopUpRequestParams$1();
  
  private String mAmount;
  
  private AppID mAppID;
  
  private String mEncrpytPin;
  
  private String mType = "0";
  
  public ECashTopUpRequestParams() {}
  
  public ECashTopUpRequestParams(Parcel paramParcel) {
    super(paramParcel);
    this.mAppID = (AppID)paramParcel.readParcelable(AppID.class.getClassLoader());
    this.mType = paramParcel.readString();
    this.mAmount = paramParcel.readString();
    this.mEncrpytPin = paramParcel.readString();
  }
  
  public String getAmount() {
    return this.mAmount;
  }
  
  public AppID getAppID() {
    return this.mAppID;
  }
  
  public String getEncrpytPin() {
    return this.mEncrpytPin;
  }
  
  public String getType() {
    return this.mType;
  }
  
  public void setAmount(String paramString) {
    this.mAmount = paramString;
  }
  
  public void setAppID(AppID paramAppID) {
    this.mAppID = paramAppID;
  }
  
  public void setEncrpytPin(String paramString) {
    this.mEncrpytPin = paramString;
  }
  
  public void setType(String paramString) {
    this.mType = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable((Parcelable)this.mAppID, paramInt);
    paramParcel.writeString(this.mType);
    paramParcel.writeString(this.mAmount);
    paramParcel.writeString(this.mEncrpytPin);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\request\ECashTopUpRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */