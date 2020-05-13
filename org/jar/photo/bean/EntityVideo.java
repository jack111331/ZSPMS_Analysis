package org.jar.photo.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class EntityVideo implements Parcelable {
  public static final Parcelable.Creator<EntityVideo> CREATOR = new a();
  
  private boolean a = false;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private int f;
  
  private String g;
  
  private String h;
  
  public EntityVideo() {}
  
  protected EntityVideo(Parcel paramParcel) {
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
  }
  
  public String a() {
    return this.b;
  }
  
  public void a(int paramInt) {
    this.f = paramInt;
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public String b() {
    return this.e;
  }
  
  public void b(String paramString) {
    this.c = paramString;
  }
  
  public int c() {
    return this.f;
  }
  
  public void c(String paramString) {
    this.e = paramString;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\bean\EntityVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */