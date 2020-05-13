package org.jar.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable;

class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {
  private final ParcelableCompatCreatorCallbacks<T> mCallbacks;
  
  public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks) {
    this.mCallbacks = paramParcelableCompatCreatorCallbacks;
  }
  
  public T createFromParcel(Parcel paramParcel) {
    return this.mCallbacks.createFromParcel(paramParcel, null);
  }
  
  public T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader) {
    return this.mCallbacks.createFromParcel(paramParcel, paramClassLoader);
  }
  
  public T[] newArray(int paramInt) {
    return this.mCallbacks.newArray(paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\os\ParcelableCompatCreatorHoneycombMR2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */