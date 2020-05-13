package org.jar.photo.bean;

import android.os.Parcel;
import android.os.Parcelable;

final class a implements Parcelable.Creator<EntityVideo> {
  public EntityVideo a(Parcel paramParcel) {
    return new EntityVideo(paramParcel);
  }
  
  public EntityVideo[] a(int paramInt) {
    return new EntityVideo[paramInt];
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\bean\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */