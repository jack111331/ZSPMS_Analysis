package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.MediaController;
import java.io.FileInputStream;
import java.io.IOException;

public final class p extends FrameLayout implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, MediaController.MediaPlayerControl {
  private static boolean a;
  
  private final Context b;
  
  private final SurfaceView c;
  
  private final SurfaceHolder d;
  
  private final String e;
  
  private final int f;
  
  private final int g;
  
  private final boolean h;
  
  private final long i;
  
  private final long j;
  
  private final FrameLayout k;
  
  private final Display l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  private MediaPlayer q;
  
  private MediaController r;
  
  private boolean s = false;
  
  private boolean t = false;
  
  private int u = 0;
  
  private boolean v = false;
  
  private boolean w = false;
  
  private a x;
  
  private b y;
  
  private volatile int z = 0;
  
  protected p(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong1, long paramLong2, a parama) {
    super(paramContext);
    this.x = parama;
    this.b = paramContext;
    this.k = this;
    this.c = new SurfaceView(paramContext);
    this.d = this.c.getHolder();
    this.d.addCallback(this);
    this.k.setBackgroundColor(paramInt1);
    this.k.addView((View)this.c);
    this.l = ((WindowManager)this.b.getSystemService("window")).getDefaultDisplay();
    this.e = paramString;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramBoolean;
    this.i = paramLong1;
    this.j = paramLong2;
    if (a) {
      StringBuilder stringBuilder = new StringBuilder("fileName: ");
      stringBuilder.append(this.e);
      b(stringBuilder.toString());
    } 
    if (a) {
      StringBuilder stringBuilder = new StringBuilder("backgroundColor: ");
      stringBuilder.append(paramInt1);
      b(stringBuilder.toString());
    } 
    if (a) {
      StringBuilder stringBuilder = new StringBuilder("controlMode: ");
      stringBuilder.append(this.f);
      b(stringBuilder.toString());
    } 
    if (a) {
      StringBuilder stringBuilder = new StringBuilder("scalingMode: ");
      stringBuilder.append(this.g);
      b(stringBuilder.toString());
    } 
    if (a) {
      StringBuilder stringBuilder = new StringBuilder("isURL: ");
      stringBuilder.append(this.h);
      b(stringBuilder.toString());
    } 
    if (a) {
      StringBuilder stringBuilder = new StringBuilder("videoOffset: ");
      stringBuilder.append(this.i);
      b(stringBuilder.toString());
    } 
    if (a) {
      StringBuilder stringBuilder = new StringBuilder("videoLength: ");
      stringBuilder.append(this.j);
      b(stringBuilder.toString());
    } 
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void a(int paramInt) {
    this.z = paramInt;
    if (this.x != null)
      this.x.a(this.z); 
  }
  
  private static void b(String paramString) {
    StringBuilder stringBuilder = new StringBuilder("VideoPlayer: ");
    stringBuilder.append(paramString);
    Log.i("Video", stringBuilder.toString());
  }
  
  private void c() {
    if (this.q != null) {
      this.q.setDisplay(this.d);
      if (!this.v) {
        if (a)
          b("Resuming playback"); 
        this.q.start();
      } 
      return;
    } 
    a(0);
    doCleanUp();
    try {
      MediaPlayer mediaPlayer = new MediaPlayer();
      this();
      this.q = mediaPlayer;
      if (this.h) {
        this.q.setDataSource(this.b, Uri.parse(this.e));
      } else {
        Thread thread1;
        if (this.j != 0L) {
          FileInputStream fileInputStream = new FileInputStream();
          this(this.e);
          this.q.setDataSource(fileInputStream.getFD(), this.i, this.j);
        } else {
          AssetManager assetManager = getResources().getAssets();
          try {
            AssetFileDescriptor assetFileDescriptor = assetManager.openFd(this.e);
            this.q.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            assetFileDescriptor.close();
          } catch (IOException iOException) {
            FileInputStream fileInputStream = new FileInputStream();
            this(this.e);
            this.q.setDataSource(fileInputStream.getFD());
            fileInputStream.close();
          } 
          this.q.setDisplay(this.d);
          this.q.setScreenOnWhilePlaying(true);
          this.q.setOnBufferingUpdateListener(this);
          this.q.setOnCompletionListener(this);
          this.q.setOnPreparedListener(this);
          this.q.setOnVideoSizeChangedListener(this);
          this.q.setAudioStreamType(3);
          this.q.prepareAsync();
          b b2 = new b();
          this(this, this);
          this.y = b2;
          thread1 = new Thread();
          this(this.y);
          thread1.start();
        } 
        thread1.close();
      } 
      this.q.setDisplay(this.d);
      this.q.setScreenOnWhilePlaying(true);
      this.q.setOnBufferingUpdateListener(this);
      this.q.setOnCompletionListener(this);
      this.q.setOnPreparedListener(this);
      this.q.setOnVideoSizeChangedListener(this);
      this.q.setAudioStreamType(3);
      this.q.prepareAsync();
      b b1 = new b();
      this(this, this);
      this.y = b1;
      Thread thread = new Thread();
      this(this.y);
      thread.start();
    } catch (Exception exception) {
      if (a) {
        StringBuilder stringBuilder = new StringBuilder("error: ");
        stringBuilder.append(exception.getMessage());
        stringBuilder.append(exception);
        b(stringBuilder.toString());
      } 
      a(2);
      return;
    } 
  }
  
  private void d() {
    if (isPlaying())
      return; 
    a(1);
    if (a)
      b("startVideoPlayback"); 
    updateVideoLayout();
    if (!this.v)
      start(); 
  }
  
  public final void CancelOnPrepare() {
    a(2);
  }
  
  final boolean a() {
    return this.v;
  }
  
  public final boolean canPause() {
    return true;
  }
  
  public final boolean canSeekBackward() {
    return true;
  }
  
  public final boolean canSeekForward() {
    return true;
  }
  
  protected final void destroyPlayer() {
    if (a)
      b("destroyPlayer"); 
    if (!this.v)
      pause(); 
    doCleanUp();
  }
  
  protected final void doCleanUp() {
    if (this.y != null) {
      this.y.a();
      this.y = null;
    } 
    if (this.q != null) {
      this.q.release();
      this.q = null;
    } 
    this.o = 0;
    this.p = 0;
    this.t = false;
    this.s = false;
  }
  
  public final int getBufferPercentage() {
    return this.h ? this.u : 100;
  }
  
  public final int getCurrentPosition() {
    return (this.q == null) ? 0 : this.q.getCurrentPosition();
  }
  
  public final int getDuration() {
    return (this.q == null) ? 0 : this.q.getDuration();
  }
  
  public final boolean isPlaying() {
    boolean bool;
    if (this.t && this.s) {
      bool = true;
    } else {
      bool = false;
    } 
    return (this.q == null) ? (!bool) : ((this.q.isPlaying() || !bool));
  }
  
  public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt) {
    if (a) {
      StringBuilder stringBuilder = new StringBuilder("onBufferingUpdate percent:");
      stringBuilder.append(paramInt);
      b(stringBuilder.toString());
    } 
    this.u = paramInt;
  }
  
  public final void onCompletion(MediaPlayer paramMediaPlayer) {
    if (a)
      b("onCompletion called"); 
    destroyPlayer();
    a(3);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 || (this.f == 2 && paramInt != 0 && !paramKeyEvent.isSystem())) {
      destroyPlayer();
      a(3);
      return true;
    } 
    return (this.r != null) ? this.r.onKeyDown(paramInt, paramKeyEvent) : super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final void onPrepared(MediaPlayer paramMediaPlayer) {
    if (a)
      b("onPrepared called"); 
    if (this.y != null) {
      this.y.a();
      this.y = null;
    } 
    if (this.f == 0 || this.f == 1) {
      this.r = new MediaController(this.b);
      this.r.setMediaPlayer(this);
      this.r.setAnchorView((View)this);
      this.r.setEnabled(true);
      if (this.b instanceof Activity) {
        Activity activity = (Activity)this.b;
        this.r.setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility());
      } 
      this.r.show();
    } 
    this.t = true;
    if (this.t && this.s)
      d(); 
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getAction();
    if (this.f == 2 && (i & 0xFF) == 0) {
      destroyPlayer();
      a(3);
      return true;
    } 
    return (this.r != null) ? this.r.onTouchEvent(paramMotionEvent) : super.onTouchEvent(paramMotionEvent);
  }
  
  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
    if (a) {
      StringBuilder stringBuilder = new StringBuilder("onVideoSizeChanged called ");
      stringBuilder.append(paramInt1);
      stringBuilder.append("x");
      stringBuilder.append(paramInt2);
      b(stringBuilder.toString());
    } 
    if (paramInt1 == 0 || paramInt2 == 0) {
      if (a) {
        StringBuilder stringBuilder = new StringBuilder("invalid video width(");
        stringBuilder.append(paramInt1);
        stringBuilder.append(") or height(");
        stringBuilder.append(paramInt2);
        stringBuilder.append(")");
        b(stringBuilder.toString());
      } 
      return;
    } 
    this.s = true;
    this.o = paramInt1;
    this.p = paramInt2;
    if (this.t && this.s)
      d(); 
  }
  
  public final void pause() {
    if (this.q == null)
      return; 
    if (this.w)
      this.q.pause(); 
    this.v = true;
  }
  
  public final void seekTo(int paramInt) {
    if (this.q == null)
      return; 
    this.q.seekTo(paramInt);
  }
  
  public final void start() {
    if (a)
      b("Start"); 
    if (this.q == null)
      return; 
    if (this.w)
      this.q.start(); 
    this.v = false;
  }
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {
    if (a) {
      StringBuilder stringBuilder = new StringBuilder("surfaceChanged called ");
      stringBuilder.append(paramInt1);
      stringBuilder.append(" ");
      stringBuilder.append(paramInt2);
      stringBuilder.append("x");
      stringBuilder.append(paramInt3);
      b(stringBuilder.toString());
    } 
    if (this.m != paramInt2 || this.n != paramInt3) {
      this.m = paramInt2;
      this.n = paramInt3;
      if (this.w)
        updateVideoLayout(); 
    } 
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder) {
    if (a)
      b("surfaceCreated called"); 
    this.w = true;
    c();
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {
    if (a)
      b("surfaceDestroyed called"); 
    this.w = false;
  }
  
  protected final void updateVideoLayout() {
    // Byte code:
    //   0: getstatic com/unity3d/player/p.a : Z
    //   3: ifeq -> 12
    //   6: ldc_w 'updateVideoLayout'
    //   9: invokestatic b : (Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield q : Landroid/media/MediaPlayer;
    //   16: ifnonnull -> 20
    //   19: return
    //   20: aload_0
    //   21: getfield m : I
    //   24: ifeq -> 34
    //   27: aload_0
    //   28: getfield n : I
    //   31: ifne -> 81
    //   34: aload_0
    //   35: getfield b : Landroid/content/Context;
    //   38: ldc 'window'
    //   40: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   43: checkcast android/view/WindowManager
    //   46: astore_1
    //   47: new android/util/DisplayMetrics
    //   50: dup
    //   51: invokespecial <init> : ()V
    //   54: astore_2
    //   55: aload_1
    //   56: invokeinterface getDefaultDisplay : ()Landroid/view/Display;
    //   61: aload_2
    //   62: invokevirtual getMetrics : (Landroid/util/DisplayMetrics;)V
    //   65: aload_0
    //   66: aload_2
    //   67: getfield widthPixels : I
    //   70: putfield m : I
    //   73: aload_0
    //   74: aload_2
    //   75: getfield heightPixels : I
    //   78: putfield n : I
    //   81: aload_0
    //   82: getfield m : I
    //   85: istore_3
    //   86: aload_0
    //   87: getfield n : I
    //   90: istore #4
    //   92: aload_0
    //   93: getfield s : Z
    //   96: ifeq -> 224
    //   99: aload_0
    //   100: getfield o : I
    //   103: i2f
    //   104: aload_0
    //   105: getfield p : I
    //   108: i2f
    //   109: fdiv
    //   110: fstore #5
    //   112: aload_0
    //   113: getfield m : I
    //   116: i2f
    //   117: aload_0
    //   118: getfield n : I
    //   121: i2f
    //   122: fdiv
    //   123: fstore #6
    //   125: aload_0
    //   126: getfield g : I
    //   129: iconst_1
    //   130: if_icmpne -> 176
    //   133: fload #6
    //   135: fload #5
    //   137: fcmpg
    //   138: ifgt -> 158
    //   141: aload_0
    //   142: getfield m : I
    //   145: i2f
    //   146: fload #5
    //   148: fdiv
    //   149: f2i
    //   150: istore #7
    //   152: iload_3
    //   153: istore #8
    //   155: goto -> 250
    //   158: aload_0
    //   159: getfield n : I
    //   162: i2f
    //   163: fload #5
    //   165: fmul
    //   166: f2i
    //   167: istore #8
    //   169: iload #4
    //   171: istore #7
    //   173: goto -> 250
    //   176: aload_0
    //   177: getfield g : I
    //   180: iconst_2
    //   181: if_icmpne -> 195
    //   184: fload #6
    //   186: fload #5
    //   188: fcmpl
    //   189: iflt -> 158
    //   192: goto -> 141
    //   195: iload_3
    //   196: istore #8
    //   198: iload #4
    //   200: istore #7
    //   202: aload_0
    //   203: getfield g : I
    //   206: ifne -> 250
    //   209: aload_0
    //   210: getfield o : I
    //   213: istore #8
    //   215: aload_0
    //   216: getfield p : I
    //   219: istore #7
    //   221: goto -> 250
    //   224: iload_3
    //   225: istore #8
    //   227: iload #4
    //   229: istore #7
    //   231: getstatic com/unity3d/player/p.a : Z
    //   234: ifeq -> 250
    //   237: ldc_w 'updateVideoLayout: Video size is not known yet'
    //   240: invokestatic b : (Ljava/lang/String;)V
    //   243: iload #4
    //   245: istore #7
    //   247: iload_3
    //   248: istore #8
    //   250: aload_0
    //   251: getfield m : I
    //   254: iload #8
    //   256: if_icmpne -> 268
    //   259: aload_0
    //   260: getfield n : I
    //   263: iload #7
    //   265: if_icmpeq -> 340
    //   268: getstatic com/unity3d/player/p.a : Z
    //   271: ifeq -> 314
    //   274: new java/lang/StringBuilder
    //   277: dup
    //   278: ldc_w 'frameWidth = '
    //   281: invokespecial <init> : (Ljava/lang/String;)V
    //   284: astore_1
    //   285: aload_1
    //   286: iload #8
    //   288: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload_1
    //   293: ldc_w '; frameHeight = '
    //   296: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload_1
    //   301: iload #7
    //   303: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_1
    //   308: invokevirtual toString : ()Ljava/lang/String;
    //   311: invokestatic b : (Ljava/lang/String;)V
    //   314: new android/widget/FrameLayout$LayoutParams
    //   317: dup
    //   318: iload #8
    //   320: iload #7
    //   322: bipush #17
    //   324: invokespecial <init> : (III)V
    //   327: astore_1
    //   328: aload_0
    //   329: getfield k : Landroid/widget/FrameLayout;
    //   332: aload_0
    //   333: getfield c : Landroid/view/SurfaceView;
    //   336: aload_1
    //   337: invokevirtual updateViewLayout : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   340: return
  }
  
  public static interface a {
    void a(int param1Int);
  }
  
  public final class b implements Runnable {
    private p b;
    
    private boolean c;
    
    public b(p this$0, p param1p1) {
      this.b = param1p1;
      this.c = false;
    }
    
    public final void a() {
      this.c = true;
    }
    
    public final void run() {
      try {
        Thread.sleep(5000L);
      } catch (InterruptedException interruptedException) {
        Thread.currentThread().interrupt();
      } 
      if (!this.c) {
        if (p.b())
          p.a("Stopping the video player due to timeout."); 
        this.b.CancelOnPrepare();
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */