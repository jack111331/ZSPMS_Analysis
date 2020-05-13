package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Amount implements Parcelable {
  public static final Parcelable.Creator<Amount> CREATOR = new Amount$1();
  
  private String mCurrencyType = "CNY";
  
  private String mProductPrice = "0.0";
  
  public Amount() {}
  
  public Amount(Parcel paramParcel) {
    this.mCurrencyType = paramParcel.readString();
    this.mProductPrice = paramParcel.readString();
  }
  
  public Amount(String paramString1, String paramString2) {
    this.mCurrencyType = paramString1;
    this.mProductPrice = paramString2;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getCurrencyType() {
    return this.mCurrencyType;
  }
  
  public String getProductPrice() {
    return this.mProductPrice;
  }
  
  public void setCurrencyType(String paramString) {
    this.mCurrencyType = paramString;
  }
  
  public void setProductPrice(String paramString) {
    this.mProductPrice = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.mCurrencyType);
    paramParcel.writeString(this.mProductPrice);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\data\Amount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */