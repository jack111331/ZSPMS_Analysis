package com.unionpay.tsmservice;

import android.os.Parcel;
import android.os.Parcelable;

public class AppID implements Parcelable {
  public static final Parcelable.Creator<AppID> CREATOR = new AppID$1();
  
  String a = "";
  
  String b = "";
  
  public AppID(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public AppID(String paramString1, String paramString2) {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getAppAid() {
    return this.a;
  }
  
  public String getAppVersion() {
    return this.b;
  }
  
  public void setAppAid(String paramString) {
    this.a = paramString;
  }
  
  public void setAppVersion(String paramString) {
    this.b = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\AppID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */