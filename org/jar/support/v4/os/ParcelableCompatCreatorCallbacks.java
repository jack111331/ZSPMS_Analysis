package org.jar.support.v4.os;

import android.os.Parcel;

public interface ParcelableCompatCreatorCallbacks<T> {
  T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader);
  
  T[] newArray(int paramInt);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\os\ParcelableCompatCreatorCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */