package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

public interface IMediaControllerCallback extends IInterface {
  void onEvent(String paramString, Bundle paramBundle);
  
  void onExtrasChanged(Bundle paramBundle);
  
  void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat);
  
  void onPlaybackStateChanged(PlaybackStateCompat paramPlaybackStateCompat);
  
  void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList);
  
  void onQueueTitleChanged(CharSequence paramCharSequence);
  
  void onRepeatModeChanged(int paramInt);
  
  void onSessionDestroyed();
  
  void onShuffleModeChanged(boolean paramBoolean);
  
  void onVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo);
  
  public static abstract class Stub extends Binder implements IMediaControllerCallback {
    private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaControllerCallback";
    
    static final int TRANSACTION_onEvent = 1;
    
    static final int TRANSACTION_onExtrasChanged = 7;
    
    static final int TRANSACTION_onMetadataChanged = 4;
    
    static final int TRANSACTION_onPlaybackStateChanged = 3;
    
    static final int TRANSACTION_onQueueChanged = 5;
    
    static final int TRANSACTION_onQueueTitleChanged = 6;
    
    static final int TRANSACTION_onRepeatModeChanged = 9;
    
    static final int TRANSACTION_onSessionDestroyed = 2;
    
    static final int TRANSACTION_onShuffleModeChanged = 10;
    
    static final int TRANSACTION_onVolumeInfoChanged = 8;
    
    public Stub() {
      attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
    }
    
    public static IMediaControllerCallback asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
      return (iInterface != null && iInterface instanceof IMediaControllerCallback) ? (IMediaControllerCallback)iInterface : new Proxy(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) {
      Bundle bundle2;
      String str1;
      PlaybackStateCompat playbackStateCompat1;
      MediaMetadataCompat mediaMetadataCompat1;
      CharSequence charSequence1;
      Bundle bundle1;
      ParcelableVolumeInfo parcelableVolumeInfo;
      String str2 = null;
      PlaybackStateCompat playbackStateCompat2 = null;
      MediaMetadataCompat mediaMetadataCompat2 = null;
      CharSequence charSequence2 = null;
      Bundle bundle3 = null;
      Parcel parcel = null;
      boolean bool = true;
      switch (param1Int1) {
        default:
          return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
        case 1598968902:
          param1Parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
          return bool;
        case 1:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          str2 = param1Parcel1.readString();
          param1Parcel2 = parcel;
          if (param1Parcel1.readInt() != 0)
            bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
          onEvent(str2, bundle2);
          return bool;
        case 2:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          onSessionDestroyed();
          return bool;
        case 3:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          str1 = str2;
          if (param1Parcel1.readInt() != 0)
            playbackStateCompat1 = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(param1Parcel1); 
          onPlaybackStateChanged(playbackStateCompat1);
          return bool;
        case 4:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          playbackStateCompat1 = playbackStateCompat2;
          if (param1Parcel1.readInt() != 0)
            mediaMetadataCompat1 = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(param1Parcel1); 
          onMetadataChanged(mediaMetadataCompat1);
          return bool;
        case 5:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          onQueueChanged(param1Parcel1.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
          return bool;
        case 6:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          mediaMetadataCompat1 = mediaMetadataCompat2;
          if (param1Parcel1.readInt() != 0)
            charSequence1 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(param1Parcel1); 
          onQueueTitleChanged(charSequence1);
          return bool;
        case 7:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          charSequence1 = charSequence2;
          if (param1Parcel1.readInt() != 0)
            bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
          onExtrasChanged(bundle1);
          return bool;
        case 8:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          bundle1 = bundle3;
          if (param1Parcel1.readInt() != 0)
            parcelableVolumeInfo = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(param1Parcel1); 
          onVolumeInfoChanged(parcelableVolumeInfo);
          return bool;
        case 9:
          param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          onRepeatModeChanged(param1Parcel1.readInt());
          return bool;
        case 10:
          break;
      } 
      param1Parcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
      if (param1Parcel1.readInt() != 0) {
        null = true;
      } else {
        null = false;
      } 
      onShuffleModeChanged(null);
      return bool;
    }
    
    private static class Proxy implements IMediaControllerCallback {
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor() {
        return "android.support.v4.media.session.IMediaControllerCallback";
      }
      
      public void onEvent(String param2String, Bundle param2Bundle) {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          parcel.writeString(param2String);
          if (param2Bundle != null) {
            parcel.writeInt(1);
            param2Bundle.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.mRemote.transact(1, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onExtrasChanged(Bundle param2Bundle) {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2Bundle != null) {
            parcel.writeInt(1);
            param2Bundle.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.mRemote.transact(7, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onMetadataChanged(MediaMetadataCompat param2MediaMetadataCompat) {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2MediaMetadataCompat != null) {
            parcel.writeInt(1);
            param2MediaMetadataCompat.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.mRemote.transact(4, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onPlaybackStateChanged(PlaybackStateCompat param2PlaybackStateCompat) {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2PlaybackStateCompat != null) {
            parcel.writeInt(1);
            param2PlaybackStateCompat.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.mRemote.transact(3, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onQueueChanged(List<MediaSessionCompat.QueueItem> param2List) {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          parcel.writeTypedList(param2List);
          this.mRemote.transact(5, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onQueueTitleChanged(CharSequence param2CharSequence) {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2CharSequence != null) {
            parcel.writeInt(1);
            TextUtils.writeToParcel(param2CharSequence, parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.mRemote.transact(6, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onRepeatModeChanged(int param2Int) {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          parcel.writeInt(param2Int);
          this.mRemote.transact(9, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onSessionDestroyed() {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          this.mRemote.transact(2, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onShuffleModeChanged(boolean param2Boolean) {
        boolean bool = true;
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (!param2Boolean)
            bool = false; 
          parcel.writeInt(bool);
          this.mRemote.transact(10, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void onVolumeInfoChanged(ParcelableVolumeInfo param2ParcelableVolumeInfo) {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
          if (param2ParcelableVolumeInfo != null) {
            parcel.writeInt(1);
            param2ParcelableVolumeInfo.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.mRemote.transact(8, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements IMediaControllerCallback {
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public String getInterfaceDescriptor() {
      return "android.support.v4.media.session.IMediaControllerCallback";
    }
    
    public void onEvent(String param1String, Bundle param1Bundle) {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        parcel.writeString(param1String);
        if (param1Bundle != null) {
          parcel.writeInt(1);
          param1Bundle.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.mRemote.transact(1, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onExtrasChanged(Bundle param1Bundle) {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1Bundle != null) {
          parcel.writeInt(1);
          param1Bundle.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.mRemote.transact(7, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onMetadataChanged(MediaMetadataCompat param1MediaMetadataCompat) {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1MediaMetadataCompat != null) {
          parcel.writeInt(1);
          param1MediaMetadataCompat.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.mRemote.transact(4, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onPlaybackStateChanged(PlaybackStateCompat param1PlaybackStateCompat) {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1PlaybackStateCompat != null) {
          parcel.writeInt(1);
          param1PlaybackStateCompat.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.mRemote.transact(3, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onQueueChanged(List<MediaSessionCompat.QueueItem> param1List) {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        parcel.writeTypedList(param1List);
        this.mRemote.transact(5, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onQueueTitleChanged(CharSequence param1CharSequence) {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1CharSequence != null) {
          parcel.writeInt(1);
          TextUtils.writeToParcel(param1CharSequence, parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.mRemote.transact(6, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onRepeatModeChanged(int param1Int) {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        parcel.writeInt(param1Int);
        this.mRemote.transact(9, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onSessionDestroyed() {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        this.mRemote.transact(2, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onShuffleModeChanged(boolean param1Boolean) {
      boolean bool = true;
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (!param1Boolean)
          bool = false; 
        parcel.writeInt(bool);
        this.mRemote.transact(10, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void onVolumeInfoChanged(ParcelableVolumeInfo param1ParcelableVolumeInfo) {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
        if (param1ParcelableVolumeInfo != null) {
          parcel.writeInt(1);
          param1ParcelableVolumeInfo.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.mRemote.transact(8, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\media\session\IMediaControllerCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */