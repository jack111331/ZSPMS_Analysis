package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.util.Log;

@TargetApi(18)
@RequiresApi(18)
class MediaSessionCompatApi18 {
  private static final long ACTION_SEEK_TO = 256L;
  
  private static final String TAG = "MediaSessionCompatApi18";
  
  private static boolean sIsMbrPendingIntentSupported = true;
  
  public static Object createPlaybackPositionUpdateListener(Callback paramCallback) {
    return new OnPlaybackPositionUpdateListener<Callback>(paramCallback);
  }
  
  static int getRccTransportControlFlagsFromActions(long paramLong) {
    int i = MediaSessionCompatApi14.getRccTransportControlFlagsFromActions(paramLong);
    int j = i;
    if ((0x100L & paramLong) != 0L)
      j = i | 0x100; 
    return j;
  }
  
  public static void registerMediaButtonEventReceiver(Context paramContext, PendingIntent paramPendingIntent, ComponentName paramComponentName) {
    AudioManager audioManager = (AudioManager)paramContext.getSystemService("audio");
    if (sIsMbrPendingIntentSupported)
      try {
        audioManager.registerMediaButtonEventReceiver(paramPendingIntent);
      } catch (NullPointerException nullPointerException) {
        Log.w("MediaSessionCompatApi18", "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
        sIsMbrPendingIntentSupported = false;
      }  
    if (!sIsMbrPendingIntentSupported)
      audioManager.registerMediaButtonEventReceiver(paramComponentName); 
  }
  
  public static void setOnPlaybackPositionUpdateListener(Object paramObject1, Object paramObject2) {
    ((RemoteControlClient)paramObject1).setPlaybackPositionUpdateListener((RemoteControlClient.OnPlaybackPositionUpdateListener)paramObject2);
  }
  
  public static void setState(Object paramObject, int paramInt, long paramLong1, float paramFloat, long paramLong2) {
    long l1 = 0L;
    long l2 = SystemClock.elapsedRealtime();
    long l3 = paramLong1;
    if (paramInt == 3) {
      l3 = paramLong1;
      if (paramLong1 > 0L) {
        l3 = l1;
        if (paramLong2 > 0L) {
          paramLong2 = l2 - paramLong2;
          l3 = paramLong2;
          if (paramFloat > 0.0F) {
            l3 = paramLong2;
            if (paramFloat != 1.0F)
              l3 = (long)((float)paramLong2 * paramFloat); 
          } 
        } 
        l3 = paramLong1 + l3;
      } 
    } 
    paramInt = MediaSessionCompatApi14.getRccStateFromState(paramInt);
    ((RemoteControlClient)paramObject).setPlaybackState(paramInt, l3, paramFloat);
  }
  
  public static void setTransportControlFlags(Object paramObject, long paramLong) {
    ((RemoteControlClient)paramObject).setTransportControlFlags(getRccTransportControlFlagsFromActions(paramLong));
  }
  
  public static void unregisterMediaButtonEventReceiver(Context paramContext, PendingIntent paramPendingIntent, ComponentName paramComponentName) {
    AudioManager audioManager = (AudioManager)paramContext.getSystemService("audio");
    if (sIsMbrPendingIntentSupported) {
      audioManager.unregisterMediaButtonEventReceiver(paramPendingIntent);
      return;
    } 
    audioManager.unregisterMediaButtonEventReceiver(paramComponentName);
  }
  
  static interface Callback {
    void onSeekTo(long param1Long);
  }
  
  static class OnPlaybackPositionUpdateListener<T extends Callback> implements RemoteControlClient.OnPlaybackPositionUpdateListener {
    protected final T mCallback;
    
    public OnPlaybackPositionUpdateListener(T param1T) {
      this.mCallback = param1T;
    }
    
    public void onPlaybackPositionUpdate(long param1Long) {
      this.mCallback.onSeekTo(param1Long);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\media\session\MediaSessionCompatApi18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */