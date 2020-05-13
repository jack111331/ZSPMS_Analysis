package org.jar.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class AbsSavedState implements Parcelable {
  public static final Parcelable.Creator<AbsSavedState> CREATOR;
  
  public static final AbsSavedState EMPTY_STATE = new AbsSavedState() {
    
    };
  
  private final Parcelable mSuperState;
  
  static {
    CREATOR = new Parcelable.Creator<AbsSavedState>() {
        public AbsSavedState createFromParcel(Parcel param1Parcel) {
          if (param1Parcel.readParcelable(null) == null)
            return AbsSavedState.EMPTY_STATE; 
          throw new IllegalStateException("superState must be null");
        }
        
        public AbsSavedState[] newArray(int param1Int) {
          return new AbsSavedState[param1Int];
        }
      };
  }
  
  private AbsSavedState() {
    this.mSuperState = null;
  }
  
  protected AbsSavedState(Parcel paramParcel) {
    Parcelable parcelable = paramParcel.readParcelable(null);
    if (parcelable == null)
      parcelable = EMPTY_STATE; 
    this.mSuperState = parcelable;
  }
  
  protected AbsSavedState(Parcelable paramParcelable) {
    if (paramParcelable != null) {
      if (paramParcelable == EMPTY_STATE)
        paramParcelable = null; 
      this.mSuperState = paramParcelable;
      return;
    } 
    throw new IllegalArgumentException("superState must not be null");
  }
  
  public int describeContents() {
    return 0;
  }
  
  public final Parcelable getSuperState() {
    return this.mSuperState;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable(this.mSuperState, paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\view\AbsSavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */