package com.unionpay.mobile.android.pboctransaction;

import android.os.Parcel;
import android.os.Parcelable;

public class AppIdentification implements Parcelable, Comparable<AppIdentification> {
  public static final Parcelable.Creator<AppIdentification> CREATOR = new a();
  
  private String a = "";
  
  private String b = "";
  
  private AppIdentification() {}
  
  public AppIdentification(String paramString1, String paramString2) {}
  
  public final String a() {
    return this.a;
  }
  
  public final String b() {
    String str;
    try {
      str = this.a.substring(14, 16);
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public final boolean c() {
    return (this.a != null) ? this.a.startsWith("A000000333") : false;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramObject != null) {
      if (!(paramObject instanceof AppIdentification))
        return bool1; 
    } else {
      return bool2;
    } 
    paramObject = paramObject;
    bool2 = bool1;
    if (this.a.equalsIgnoreCase(((AppIdentification)paramObject).a)) {
      bool2 = bool1;
      if (this.b.equalsIgnoreCase(((AppIdentification)paramObject).b))
        bool2 = true; 
    } 
    return bool2;
  }
  
  public int hashCode() {
    return (this.a.hashCode() + 31) * 31 + this.b.hashCode();
  }
  
  public String toString() {
    return "{appId:" + this.a + ", appVersion:" + this.b + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\AppIdentification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */