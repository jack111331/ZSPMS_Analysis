package com.hu.zxlib.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;
import com.hu.zxlib.common.b;
import java.io.Closeable;
import java.io.IOException;

public final class a implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, Closeable {
  private static final String a = "a";
  
  private static final float b = 0.1F;
  
  private static final long c = 200L;
  
  private final Activity d;
  
  private MediaPlayer e;
  
  private boolean f;
  
  private boolean g;
  
  public a(Activity paramActivity) {
    this.d = paramActivity;
    this.e = null;
    a();
  }
  
  private MediaPlayer a(Context paramContext) {
    MediaPlayer mediaPlayer = new MediaPlayer();
    mediaPlayer.setAudioStreamType(3);
    mediaPlayer.setOnCompletionListener(this);
    mediaPlayer.setOnErrorListener(this);
    try {
      AssetFileDescriptor assetFileDescriptor = paramContext.getResources().openRawResourceFd(b.i(paramContext, "zx_beep"));
      try {
        mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        assetFileDescriptor.close();
        mediaPlayer.setVolume(0.1F, 0.1F);
        return mediaPlayer;
      } finally {
        assetFileDescriptor.close();
      } 
    } catch (IOException iOException) {
      Log.w(a, iOException);
      mediaPlayer.release();
      return null;
    } 
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Z
    //   6: ifeq -> 36
    //   9: aload_0
    //   10: getfield e : Landroid/media/MediaPlayer;
    //   13: ifnonnull -> 36
    //   16: aload_0
    //   17: getfield d : Landroid/app/Activity;
    //   20: iconst_3
    //   21: invokevirtual setVolumeControlStream : (I)V
    //   24: aload_0
    //   25: aload_0
    //   26: aload_0
    //   27: getfield d : Landroid/app/Activity;
    //   30: invokespecial a : (Landroid/content/Context;)Landroid/media/MediaPlayer;
    //   33: putfield e : Landroid/media/MediaPlayer;
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Exception table:
    //   from	to	target	type
    //   2	36	39	finally
  }
  
  public void a(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  @SuppressLint({"MissingPermission"})
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Z
    //   6: ifeq -> 23
    //   9: aload_0
    //   10: getfield e : Landroid/media/MediaPlayer;
    //   13: ifnull -> 23
    //   16: aload_0
    //   17: getfield e : Landroid/media/MediaPlayer;
    //   20: invokevirtual start : ()V
    //   23: aload_0
    //   24: getfield g : Z
    //   27: ifeq -> 48
    //   30: aload_0
    //   31: getfield d : Landroid/app/Activity;
    //   34: ldc 'vibrator'
    //   36: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   39: checkcast android/os/Vibrator
    //   42: ldc2_w 200
    //   45: invokevirtual vibrate : (J)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	51	finally
    //   23	48	51	finally
  }
  
  public void b(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public void close() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Landroid/media/MediaPlayer;
    //   6: ifnull -> 21
    //   9: aload_0
    //   10: getfield e : Landroid/media/MediaPlayer;
    //   13: invokevirtual release : ()V
    //   16: aload_0
    //   17: aconst_null
    //   18: putfield e : Landroid/media/MediaPlayer;
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	24	finally
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer) {
    paramMediaPlayer.seekTo(0);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
    /* monitor enter ThisExpression{ObjectType{com/hu/zxlib/base/a}} */
    if (paramInt1 == 100) {
      try {
        this.d.finish();
      } finally {}
    } else {
      paramMediaPlayer.release();
      this.e = null;
      a();
    } 
    /* monitor exit ThisExpression{ObjectType{com/hu/zxlib/base/a}} */
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\base\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */