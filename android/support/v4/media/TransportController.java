package android.support.v4.media;

@Deprecated
public abstract class TransportController {
  @Deprecated
  public abstract int getBufferPercentage();
  
  @Deprecated
  public abstract long getCurrentPosition();
  
  @Deprecated
  public abstract long getDuration();
  
  @Deprecated
  public abstract int getTransportControlFlags();
  
  @Deprecated
  public abstract boolean isPlaying();
  
  @Deprecated
  public abstract void pausePlaying();
  
  @Deprecated
  public abstract void registerStateListener(TransportStateListener paramTransportStateListener);
  
  @Deprecated
  public abstract void seekTo(long paramLong);
  
  @Deprecated
  public abstract void startPlaying();
  
  @Deprecated
  public abstract void stopPlaying();
  
  @Deprecated
  public abstract void unregisterStateListener(TransportStateListener paramTransportStateListener);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\media\TransportController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */