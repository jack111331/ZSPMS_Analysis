package com.unity3d.player;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class UnityPlayer extends FrameLayout implements f {
  public static Activity currentActivity;
  
  e a;
  
  k b;
  
  private int c;
  
  private boolean d;
  
  private boolean e;
  
  private n f;
  
  private final ConcurrentLinkedQueue g;
  
  private BroadcastReceiver h;
  
  private boolean i;
  
  private c j;
  
  private TelephonyManager k;
  
  private ClipboardManager l;
  
  private l m;
  
  private GoogleARCoreApi n;
  
  private a o;
  
  private Camera2Wrapper p;
  
  private Context q;
  
  private SurfaceView r;
  
  private boolean s;
  
  private q t;
  
  static {
    (new m()).a();
    try {
      System.loadLibrary("main");
      return;
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      g.Log(6, "Failed to load 'libmain.so', the application will terminate.");
      throw unsatisfiedLinkError;
    } 
  }
  
  public UnityPlayer(Context paramContext) {
    super(paramContext);
    AlertDialog alertDialog;
    this.c = -1;
    this.d = false;
    this.e = true;
    this.f = new n();
    this.g = new ConcurrentLinkedQueue();
    this.h = null;
    this.a = new e((byte)0);
    this.i = false;
    this.j = new c((byte)0);
    this.n = null;
    this.o = new a(this);
    this.p = null;
    this.b = null;
    if (paramContext instanceof Activity) {
      currentActivity = (Activity)paramContext;
      this.c = currentActivity.getRequestedOrientation();
    } 
    a(currentActivity);
    this.q = paramContext;
    if (currentActivity != null && k()) {
      this.m = new l(this.q, l.a.a()[getSplashMode()]);
      addView(this.m);
    } 
    a(this.q.getApplicationInfo());
    if (!n.c()) {
      alertDialog = (new AlertDialog.Builder(this.q)).setTitle("Failure to initialize!").setPositiveButton("OK", new DialogInterface.OnClickListener(this) {
            public final void onClick(DialogInterface param1DialogInterface, int param1Int) {
              UnityPlayer.d(this.a);
            }
          }).setMessage("Your hardware does not support this application, sorry!").create();
      alertDialog.setCancelable(false);
      alertDialog.show();
      return;
    } 
    initJni((Context)alertDialog);
    this.f.c(true);
    this.r = c();
    this.r.setContentDescription(a((Context)alertDialog));
    addView((View)this.r);
    bringChildToFront(this.m);
    this.s = false;
    nativeInitWebRequest(UnityWebRequest.class);
    m();
    this.k = (TelephonyManager)this.q.getSystemService("phone");
    this.l = (ClipboardManager)this.q.getSystemService("clipboard");
    this.p = new Camera2Wrapper(this.q);
    this.a.start();
  }
  
  public static void UnitySendMessage(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder;
    if (!n.c()) {
      stringBuilder = new StringBuilder("Native libraries not loaded - dropping message for ");
      stringBuilder.append(paramString1);
      stringBuilder.append(".");
      stringBuilder.append(paramString2);
      g.Log(5, stringBuilder.toString());
      return;
    } 
    try {
      nativeUnitySendMessage(paramString1, paramString2, stringBuilder.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {}
  }
  
  private static String a(Context paramContext) {
    return paramContext.getResources().getString(paramContext.getResources().getIdentifier("game_view_content_description", "string", paramContext.getPackageName()));
  }
  
  private void a() {
    a(new Runnable(this) {
          public final void run() {
            this.a.removeView(UnityPlayer.e(this.a));
            UnityPlayer.f(this.a);
          }
        });
  }
  
  private void a(int paramInt, Surface paramSurface) {
    if (this.d)
      return; 
    b(0, paramSurface);
  }
  
  private static void a(Activity paramActivity) {
    if (paramActivity != null && paramActivity.getIntent().getBooleanExtra("android.intent.extra.VR_LAUNCH", false) && paramActivity.getWindow() != null) {
      View view = paramActivity.getWindow().getDecorView();
      if (view != null)
        view.setSystemUiVisibility(7); 
    } 
  }
  
  private static void a(ApplicationInfo paramApplicationInfo) {
    if (NativeLoader.load(paramApplicationInfo.nativeLibraryDir)) {
      n.a();
      return;
    } 
    g.Log(6, "NativeLoader.load failure, Unity libraries were not loaded.");
  }
  
  private void a(View paramView1, View paramView2) {
    boolean bool;
    if (!this.f.d()) {
      pause();
      bool = true;
    } else {
      bool = false;
    } 
    if (paramView1 != null) {
      ViewParent viewParent = paramView1.getParent();
      if (!(viewParent instanceof UnityPlayer) || (UnityPlayer)viewParent != this) {
        if (viewParent instanceof ViewGroup)
          ((ViewGroup)viewParent).removeView(paramView1); 
        addView(paramView1);
        bringChildToFront(paramView1);
        paramView1.setVisibility(0);
      } 
    } 
    if (paramView2 != null && paramView2.getParent() == this) {
      paramView2.setVisibility(8);
      removeView(paramView2);
    } 
    if (bool)
      resume(); 
  }
  
  private void a(f paramf) {
    if (isFinishing())
      return; 
    c(paramf);
  }
  
  private void a(Runnable paramRunnable) {
    if (this.q instanceof Activity) {
      ((Activity)this.q).runOnUiThread(paramRunnable);
      return;
    } 
    g.Log(5, "Not running Unity from an Activity; ignored...");
  }
  
  private static void b(Runnable paramRunnable) {
    (new Handler(Looper.getMainLooper())).post(paramRunnable);
  }
  
  private static boolean b() {
    if (currentActivity == null)
      return false; 
    TypedValue typedValue = new TypedValue();
    return (currentActivity.getTheme().resolveAttribute(16842840, typedValue, true) && typedValue.type == 18 && typedValue.data == 1);
  }
  
  private boolean b(int paramInt, Surface paramSurface) {
    if (!n.c() || !this.f.e())
      return false; 
    Semaphore semaphore = new Semaphore(0);
    Runnable runnable = new Runnable(this, paramInt, paramSurface, semaphore) {
        public final void run() {
          UnityPlayer.a(this.d, this.a, this.b);
          this.c.release();
        }
      };
    if (paramInt == 0) {
      if (paramSurface == null) {
        this.a.b(runnable);
      } else {
        this.a.c(runnable);
      } 
    } else {
      runnable.run();
    } 
    if (paramSurface == null && paramInt == 0)
      try {
        if (!semaphore.tryAcquire(4L, TimeUnit.SECONDS))
          g.Log(5, "Timeout while trying detaching primary window."); 
      } catch (InterruptedException interruptedException) {
        g.Log(5, "UI thread got interrupted while trying to detach the primary window from the Unity Engine.");
      }  
    return true;
  }
  
  private SurfaceView c() {
    SurfaceView surfaceView = new SurfaceView(this.q);
    if (b()) {
      surfaceView.getHolder().setFormat(-3);
      surfaceView.setZOrderOnTop(true);
    } else {
      surfaceView.getHolder().setFormat(-1);
    } 
    surfaceView.getHolder().addCallback(new SurfaceHolder.Callback(this) {
          public final void surfaceChanged(SurfaceHolder param1SurfaceHolder, int param1Int1, int param1Int2, int param1Int3) {
            UnityPlayer.a(this.a, param1SurfaceHolder.getSurface());
            UnityPlayer.g(this.a);
          }
          
          public final void surfaceCreated(SurfaceHolder param1SurfaceHolder) {
            UnityPlayer.a(this.a, param1SurfaceHolder.getSurface());
          }
          
          public final void surfaceDestroyed(SurfaceHolder param1SurfaceHolder) {
            UnityPlayer.a(this.a, (Surface)null);
          }
        });
    surfaceView.setFocusable(true);
    surfaceView.setFocusableInTouchMode(true);
    return surfaceView;
  }
  
  private void c(Runnable paramRunnable) {
    if (!n.c())
      return; 
    if (Thread.currentThread() == this.a) {
      paramRunnable.run();
      return;
    } 
    this.g.add(paramRunnable);
  }
  
  private void d() {
    if (n.c() && this.f.e()) {
      Runnable runnable = new Runnable(this) {
          public final void run() {
            UnityPlayer.h(this.a);
          }
        };
      this.a.d(runnable);
    } 
  }
  
  private void e() {
    if (this.q instanceof Activity && !((Activity)this.q).isFinishing())
      ((Activity)this.q).finish(); 
  }
  
  private void f() {
    reportSoftInputStr((String)null, 1, true);
    if (!this.f.g())
      return; 
    if (n.c()) {
      Runnable runnable;
      Semaphore semaphore = new Semaphore(0);
      if (isFinishing()) {
        runnable = new Runnable(this, semaphore) {
            public final void run() {
              UnityPlayer.k(this.b);
              this.a.release();
            }
          };
      } else {
        runnable = new Runnable(this, semaphore) {
            public final void run() {
              if (UnityPlayer.l(this.b)) {
                UnityPlayer.m(this.b);
                UnityPlayer.k(this.b);
                this.a.release(2);
                return;
              } 
              this.a.release();
            }
          };
      } 
      this.a.a(runnable);
      try {
        if (!semaphore.tryAcquire(4L, TimeUnit.SECONDS))
          g.Log(5, "Timeout while trying to pause the Unity Engine."); 
      } catch (InterruptedException interruptedException) {
        g.Log(5, "UI thread got interrupted while trying to pause the Unity Engine.");
      } 
      if (semaphore.drainPermits() > 0)
        destroy(); 
    } 
    this.f.d(false);
    this.f.b(true);
    if (this.i)
      this.k.listen(this.j, 0); 
  }
  
  private void g() {
    nativeDone();
    this.f.c(false);
  }
  
  private void h() {
    if (!this.f.f())
      return; 
    this.f.d(true);
    c(new Runnable(this) {
          public final void run() {
            UnityPlayer.o(this.a);
          }
        });
    this.a.b();
  }
  
  private static void i() {
    if (!n.c())
      return; 
    if (NativeLoader.unload()) {
      n.b();
      return;
    } 
    throw new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
  }
  
  private final native void initJni(Context paramContext);
  
  private ApplicationInfo j() {
    return this.q.getPackageManager().getApplicationInfo(this.q.getPackageName(), 128);
  }
  
  private boolean k() {
    try {
      return (j()).metaData.getBoolean("unity.splash-enable");
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private boolean l() {
    try {
      return (j()).metaData.getBoolean("unity.tango-enable");
    } catch (Exception exception) {
      return false;
    } 
  }
  
  protected static boolean loadLibraryStatic(String paramString) {
    StringBuilder stringBuilder;
    try {
      System.loadLibrary(paramString);
      return true;
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      StringBuilder stringBuilder1 = new StringBuilder("Unable to find ");
      stringBuilder1.append(paramString);
      stringBuilder = stringBuilder1;
    } catch (Exception exception) {
      stringBuilder = new StringBuilder("Unknown error ");
      stringBuilder.append(exception);
    } 
    g.Log(6, stringBuilder.toString());
    return false;
  }
  
  private void m() {
    if (this.q instanceof Activity)
      ((Activity)this.q).getWindow().setFlags(1024, 1024); 
  }
  
  private final native void nativeDone();
  
  private final native void nativeFocusChanged(boolean paramBoolean);
  
  private final native void nativeInitWebRequest(Class paramClass);
  
  private final native boolean nativeInjectEvent(InputEvent paramInputEvent);
  
  private final native boolean nativeIsAutorotationOn();
  
  private final native void nativeLowMemory();
  
  private final native void nativeMuteMasterAudio(boolean paramBoolean);
  
  private final native boolean nativePause();
  
  private final native void nativeRecreateGfxState(int paramInt, Surface paramSurface);
  
  private final native boolean nativeRender();
  
  private final native void nativeRestartActivityIndicator();
  
  private final native void nativeResume();
  
  private final native void nativeSendSurfaceChangedEvent();
  
  private final native void nativeSetInputSelection(int paramInt1, int paramInt2);
  
  private final native void nativeSetInputString(String paramString);
  
  private final native void nativeSoftInputCanceled();
  
  private final native void nativeSoftInputClosed();
  
  private final native void nativeSoftInputLostFocus();
  
  private static native void nativeUnitySendMessage(String paramString1, String paramString2, byte[] paramArrayOfbyte);
  
  protected void addPhoneCallListener() {
    this.i = true;
    this.k.listen(this.j, 32);
  }
  
  public boolean addViewToPlayer(View paramView, boolean paramBoolean) {
    // Byte code:
    //   0: iload_2
    //   1: ifeq -> 12
    //   4: aload_0
    //   5: getfield r : Landroid/view/SurfaceView;
    //   8: astore_3
    //   9: goto -> 14
    //   12: aconst_null
    //   13: astore_3
    //   14: aload_0
    //   15: aload_1
    //   16: aload_3
    //   17: invokespecial a : (Landroid/view/View;Landroid/view/View;)V
    //   20: aload_1
    //   21: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   24: astore_1
    //   25: iconst_0
    //   26: istore #4
    //   28: aload_1
    //   29: aload_0
    //   30: if_acmpne -> 39
    //   33: iconst_1
    //   34: istore #5
    //   36: goto -> 42
    //   39: iconst_0
    //   40: istore #5
    //   42: iload_2
    //   43: ifeq -> 62
    //   46: aload_0
    //   47: getfield r : Landroid/view/SurfaceView;
    //   50: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   53: ifnonnull -> 62
    //   56: iconst_1
    //   57: istore #6
    //   59: goto -> 65
    //   62: iconst_0
    //   63: istore #6
    //   65: aload_0
    //   66: getfield r : Landroid/view/SurfaceView;
    //   69: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   72: aload_0
    //   73: if_acmpne -> 82
    //   76: iconst_1
    //   77: istore #7
    //   79: goto -> 85
    //   82: iconst_0
    //   83: istore #7
    //   85: iload #4
    //   87: istore_2
    //   88: iload #5
    //   90: ifeq -> 108
    //   93: iload #6
    //   95: ifne -> 106
    //   98: iload #4
    //   100: istore_2
    //   101: iload #7
    //   103: ifeq -> 108
    //   106: iconst_1
    //   107: istore_2
    //   108: iload_2
    //   109: ifne -> 143
    //   112: iload #5
    //   114: ifne -> 125
    //   117: bipush #6
    //   119: ldc_w 'addViewToPlayer: Failure adding view to hierarchy'
    //   122: invokestatic Log : (ILjava/lang/String;)V
    //   125: iload #6
    //   127: ifne -> 143
    //   130: iload #7
    //   132: ifne -> 143
    //   135: bipush #6
    //   137: ldc_w 'addViewToPlayer: Failure removing old view from hierarchy'
    //   140: invokestatic Log : (ILjava/lang/String;)V
    //   143: iload_2
    //   144: ireturn
  }
  
  public void configurationChanged(Configuration paramConfiguration) {
    if (this.r instanceof SurfaceView)
      this.r.getHolder().setSizeFromLayout(); 
    if (this.t != null)
      this.t.c(); 
    GoogleVrProxy googleVrProxy = GoogleVrApi.b();
    if (googleVrProxy != null)
      googleVrProxy.c(); 
  }
  
  public void destroy() {
    if (GoogleVrApi.b() != null)
      GoogleVrApi.a(); 
    if (this.p != null) {
      this.p.a();
      this.p = null;
    } 
    this.s = true;
    if (!this.f.d())
      pause(); 
    this.a.a();
    try {
      this.a.join(4000L);
    } catch (InterruptedException interruptedException) {
      this.a.interrupt();
    } 
    if (this.h != null)
      this.q.unregisterReceiver(this.h); 
    this.h = null;
    if (n.c())
      removeAllViews(); 
    kill();
    i();
  }
  
  protected void disableLogger() {
    g.a = true;
  }
  
  public boolean displayChanged(int paramInt, Surface paramSurface) {
    if (paramInt == 0) {
      boolean bool;
      if (paramSurface != null) {
        bool = true;
      } else {
        bool = false;
      } 
      this.d = bool;
      a(new Runnable(this) {
            public final void run() {
              if (UnityPlayer.i(this.a)) {
                this.a.removeView((View)UnityPlayer.j(this.a));
                return;
              } 
              this.a.addView((View)UnityPlayer.j(this.a));
            }
          });
    } 
    return b(paramInt, paramSurface);
  }
  
  protected void executeGLThreadJobs() {
    while (true) {
      Runnable runnable = this.g.poll();
      if (runnable != null) {
        runnable.run();
        continue;
      } 
      break;
    } 
  }
  
  protected String getClipboardText() {
    String str = "";
    ClipData clipData = this.l.getPrimaryClip();
    if (clipData != null)
      str = clipData.getItemAt(0).coerceToText(this.q).toString(); 
    return str;
  }
  
  public Bundle getSettings() {
    return Bundle.EMPTY;
  }
  
  protected int getSplashMode() {
    try {
      return (j()).metaData.getInt("unity.splash-mode");
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  public View getView() {
    return (View)this;
  }
  
  protected void hideSoftInput() {
    b(new Runnable(this) {
          public final void run() {
            if (this.a.b != null) {
              this.a.b.dismiss();
              this.a.b = null;
            } 
          }
        });
  }
  
  public void init(int paramInt, boolean paramBoolean) {}
  
  protected boolean initializeGoogleAr() {
    if (this.n == null && currentActivity != null && l()) {
      this.n = new GoogleARCoreApi();
      this.n.initializeARCore(currentActivity);
      if (!this.f.d())
        this.n.resumeARCore(); 
    } 
    return false;
  }
  
  protected boolean initializeGoogleVr() {
    GoogleVrProxy googleVrProxy1 = GoogleVrApi.b();
    GoogleVrProxy googleVrProxy2 = googleVrProxy1;
    if (googleVrProxy1 == null) {
      GoogleVrApi.a(this);
      googleVrProxy1 = GoogleVrApi.b();
      googleVrProxy2 = googleVrProxy1;
      if (googleVrProxy1 == null) {
        g.Log(6, "Unable to create Google VR subsystem.");
        return false;
      } 
    } 
    Semaphore semaphore = new Semaphore(0);
    a(new Runnable(this, googleVrProxy2, new Runnable(this) {
            public final void run() {
              this.a.injectEvent((InputEvent)new KeyEvent(0, 4));
              this.a.injectEvent((InputEvent)new KeyEvent(1, 4));
            }
          }semaphore) {
          public final void run() {
            if (!this.a.a(UnityPlayer.currentActivity, UnityPlayer.p(this.d), UnityPlayer.s(this.d), this.b))
              g.Log(6, "Unable to initialize Google VR subsystem."); 
            if (UnityPlayer.currentActivity != null)
              this.a.a(UnityPlayer.currentActivity.getIntent()); 
            this.c.release();
          }
        });
    try {
      if (!semaphore.tryAcquire(4L, TimeUnit.SECONDS)) {
        g.Log(5, "Timeout while trying to initialize Google VR.");
        return false;
      } 
      return googleVrProxy2.a();
    } catch (InterruptedException interruptedException) {
      StringBuilder stringBuilder = new StringBuilder("UI thread was interrupted while initializing Google VR. ");
      stringBuilder.append(interruptedException.getLocalizedMessage());
      g.Log(5, stringBuilder.toString());
      return false;
    } 
  }
  
  public boolean injectEvent(InputEvent paramInputEvent) {
    return !n.c() ? false : nativeInjectEvent(paramInputEvent);
  }
  
  protected boolean isFinishing() {
    if (!this.s) {
      boolean bool;
      if (this.q instanceof Activity && ((Activity)this.q).isFinishing()) {
        bool = true;
      } else {
        bool = false;
      } 
      this.s = bool;
      if (!bool)
        return false; 
    } 
    return true;
  }
  
  protected void kill() {
    Process.killProcess(Process.myPid());
  }
  
  protected boolean loadLibrary(String paramString) {
    return loadLibraryStatic(paramString);
  }
  
  public void lowMemory() {
    if (!n.c())
      return; 
    c(new Runnable(this) {
          public final void run() {
            UnityPlayer.n(this.a);
          }
        });
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent) {
    return injectEvent((InputEvent)paramMotionEvent);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    return injectEvent((InputEvent)paramKeyEvent);
  }
  
  public boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent) {
    return injectEvent((InputEvent)paramKeyEvent);
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent) {
    return injectEvent((InputEvent)paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    return injectEvent((InputEvent)paramKeyEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return injectEvent((InputEvent)paramMotionEvent);
  }
  
  public void pause() {
    if (this.n != null)
      this.n.pauseARCore(); 
    if (this.t != null)
      this.t.a(); 
    GoogleVrProxy googleVrProxy = GoogleVrApi.b();
    if (googleVrProxy != null)
      googleVrProxy.pauseGvrLayout(); 
    f();
  }
  
  public void quit() {
    destroy();
  }
  
  public void removeViewFromPlayer(View paramView) {
    boolean bool2;
    boolean bool3;
    a((View)this.r, paramView);
    ViewParent viewParent = paramView.getParent();
    boolean bool1 = false;
    if (viewParent == null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (this.r.getParent() == this) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    boolean bool4 = bool1;
    if (bool2) {
      bool4 = bool1;
      if (bool3)
        bool4 = true; 
    } 
    if (!bool4) {
      if (!bool2)
        g.Log(6, "removeViewFromPlayer: Failure removing view from hierarchy"); 
      if (!bool3)
        g.Log(6, "removeVireFromPlayer: Failure agging old view to hierarchy"); 
    } 
  }
  
  public void reportError(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(": ");
    stringBuilder.append(paramString2);
    g.Log(6, stringBuilder.toString());
  }
  
  protected void reportSoftInputSelection(int paramInt1, int paramInt2) {
    a(new f(this, paramInt1, paramInt2) {
          public final void a() {
            UnityPlayer.a(this.c, this.a, this.b);
          }
        });
  }
  
  protected void reportSoftInputStr(String paramString, int paramInt, boolean paramBoolean) {
    if (paramInt == 1)
      hideSoftInput(); 
    a(new f(this, paramBoolean, paramString, paramInt) {
          public final void a() {
            if (this.a) {
              UnityPlayer.q(this.d);
            } else if (this.b != null) {
              UnityPlayer.a(this.d, this.b);
            } 
            if (this.c == 1)
              UnityPlayer.r(this.d); 
          }
        });
  }
  
  protected void requestUserAuthorization(String paramString) {
    if (j.c && paramString != null && !paramString.isEmpty() && currentActivity != null)
      j.d.a(currentActivity, paramString); 
  }
  
  public void resume() {
    if (this.n != null)
      this.n.resumeARCore(); 
    this.f.b(false);
    if (this.t != null)
      this.t.b(); 
    h();
    nativeRestartActivityIndicator();
    GoogleVrProxy googleVrProxy = GoogleVrApi.b();
    if (googleVrProxy != null)
      googleVrProxy.b(); 
  }
  
  protected void setCharacterLimit(int paramInt) {
    a(new Runnable(this, paramInt) {
          public final void run() {
            if (this.b.b != null)
              this.b.b.a(this.a); 
          }
        });
  }
  
  protected void setClipboardText(String paramString) {
    ClipData clipData = ClipData.newPlainText("Text", paramString);
    this.l.setPrimaryClip(clipData);
  }
  
  protected void setHideInputField(boolean paramBoolean) {
    a(new Runnable(this, paramBoolean) {
          public final void run() {
            if (this.b.b != null)
              this.b.b.a(this.a); 
          }
        });
  }
  
  protected void setSelection(int paramInt1, int paramInt2) {
    a(new Runnable(this, paramInt1, paramInt2) {
          public final void run() {
            if (this.c.b != null)
              this.c.b.a(this.a, this.b); 
          }
        });
  }
  
  protected void setSoftInputStr(String paramString) {
    a(new Runnable(this, paramString) {
          public final void run() {
            if (this.b.b != null && this.a != null)
              this.b.b.a(this.a); 
          }
        });
  }
  
  protected void showSoftInput(String paramString1, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2, int paramInt2, boolean paramBoolean5) {
    b(new Runnable(this, this, paramString1, paramInt1, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramString2, paramInt2, paramBoolean5) {
          public final void run() {
            this.k.b = new k(UnityPlayer.p(this.k), this.a, this.b, this.c, this.d, this.e, this.f, this.h, this.i, this.j);
            this.k.b.show();
          }
        });
  }
  
  protected boolean showVideoPlayer(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5) {
    if (this.t == null)
      this.t = new q(this); 
    paramBoolean = this.t.a(this.q, paramString, paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramInt5, new q.a(this) {
          public final void a() {
            UnityPlayer.t(this.a);
          }
        });
    if (paramBoolean)
      a(new Runnable(this) {
            public final void run() {
              if (UnityPlayer.u(this.a) && UnityPlayer.p(this.a) instanceof Activity)
                ((Activity)UnityPlayer.p(this.a)).setRequestedOrientation(UnityPlayer.v(this.a)); 
            }
          }); 
    return paramBoolean;
  }
  
  protected boolean skipPermissionsDialog() {
    return (j.c && currentActivity != null) ? j.d.a(currentActivity) : false;
  }
  
  public void start() {}
  
  public void stop() {}
  
  protected void toggleGyroscopeSensor(boolean paramBoolean) {
    SensorManager sensorManager = (SensorManager)this.q.getSystemService("sensor");
    Sensor sensor = sensorManager.getDefaultSensor(11);
    if (paramBoolean) {
      sensorManager.registerListener(this.o, sensor, 1);
      return;
    } 
    sensorManager.unregisterListener(this.o);
  }
  
  public void windowFocusChanged(boolean paramBoolean) {
    this.f.a(paramBoolean);
    if (!this.f.e())
      return; 
    if (paramBoolean) {
      this.a.c();
    } else {
      this.a.d();
    } 
    h();
  }
  
  final class a implements SensorEventListener {
    a(UnityPlayer this$0) {}
    
    public final void onAccuracyChanged(Sensor param1Sensor, int param1Int) {}
    
    public final void onSensorChanged(SensorEvent param1SensorEvent) {}
  }
  
  enum b {
    a, b, c;
  }
  
  private final class c extends PhoneStateListener {
    private c(UnityPlayer this$0) {}
    
    public final void onCallStateChanged(int param1Int, String param1String) {
      UnityPlayer unityPlayer = this.a;
      boolean bool = true;
      if (param1Int != 1)
        bool = false; 
      UnityPlayer.b(unityPlayer, bool);
    }
  }
  
  enum d {
    a, b, c, d, e, f, g, h;
  }
  
  private final class e extends Thread {
    Handler a;
    
    boolean b = false;
    
    boolean c = false;
    
    int d = UnityPlayer.b.b;
    
    int e = 5;
    
    private e(UnityPlayer this$0) {}
    
    private void a(UnityPlayer.d param1d) {
      if (this.a != null)
        Message.obtain(this.a, 2269, param1d).sendToTarget(); 
    }
    
    public final void a() {
      a(UnityPlayer.d.c);
    }
    
    public final void a(Runnable param1Runnable) {
      if (this.a == null)
        return; 
      a(UnityPlayer.d.a);
      Message.obtain(this.a, param1Runnable).sendToTarget();
    }
    
    public final void b() {
      a(UnityPlayer.d.b);
    }
    
    public final void b(Runnable param1Runnable) {
      if (this.a == null)
        return; 
      a(UnityPlayer.d.d);
      Message.obtain(this.a, param1Runnable).sendToTarget();
    }
    
    public final void c() {
      a(UnityPlayer.d.g);
    }
    
    public final void c(Runnable param1Runnable) {
      if (this.a == null)
        return; 
      Message.obtain(this.a, param1Runnable).sendToTarget();
      a(UnityPlayer.d.e);
    }
    
    public final void d() {
      a(UnityPlayer.d.f);
    }
    
    public final void d(Runnable param1Runnable) {
      if (this.a != null)
        Message.obtain(this.a, param1Runnable).sendToTarget(); 
    }
    
    public final void run() {
      setName("UnityMain");
      Looper.prepare();
      this.a = new Handler(new Handler.Callback(this) {
            private void a() {
              if (this.a.d == UnityPlayer.b.c && this.a.c) {
                UnityPlayer.a(this.a.f, true);
                this.a.d = UnityPlayer.b.a;
              } 
            }
            
            public final boolean handleMessage(Message param2Message) {
              if (param2Message.what != 2269)
                return false; 
              UnityPlayer.d d = (UnityPlayer.d)param2Message.obj;
              if (d == UnityPlayer.d.h)
                return true; 
              if (d == UnityPlayer.d.c) {
                Looper.myLooper().quit();
              } else if (d == UnityPlayer.d.b) {
                this.a.b = true;
              } else if (d == UnityPlayer.d.a) {
                this.a.b = false;
              } else if (d == UnityPlayer.d.d) {
                this.a.c = false;
              } else {
                if (d == UnityPlayer.d.e) {
                  this.a.c = true;
                } else {
                  if (d == UnityPlayer.d.f) {
                    if (this.a.d == UnityPlayer.b.a)
                      UnityPlayer.a(this.a.f, false); 
                    this.a.d = UnityPlayer.b.b;
                  } else {
                    if (d == UnityPlayer.d.g) {
                      this.a.d = UnityPlayer.b.c;
                    } else {
                      return true;
                    } 
                    a();
                  } 
                  return true;
                } 
                a();
              } 
              return true;
            }
          });
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler(this) {
            public final boolean queueIdle() {
              this.a.f.executeGLThreadJobs();
              if (!this.a.b)
                return true; 
              if (!this.a.c)
                return true; 
              if (this.a.e >= 0) {
                if (this.a.e == 0 && UnityPlayer.a(this.a.f))
                  UnityPlayer.b(this.a.f); 
                UnityPlayer.e e1 = this.a;
                e1.e--;
              } 
              if (!this.a.f.isFinishing() && !UnityPlayer.c(this.a.f))
                UnityPlayer.d(this.a.f); 
              Message.obtain(this.a.a, 2269, UnityPlayer.d.h).sendToTarget();
              return true;
            }
          });
      Looper.loop();
    }
  }
  
  final class null implements Handler.Callback {
    null(UnityPlayer this$0) {}
    
    private void a() {
      if (this.a.d == UnityPlayer.b.c && this.a.c) {
        UnityPlayer.a(this.a.f, true);
        this.a.d = UnityPlayer.b.a;
      } 
    }
    
    public final boolean handleMessage(Message param1Message) {
      if (param1Message.what != 2269)
        return false; 
      UnityPlayer.d d = (UnityPlayer.d)param1Message.obj;
      if (d == UnityPlayer.d.h)
        return true; 
      if (d == UnityPlayer.d.c) {
        Looper.myLooper().quit();
      } else if (d == UnityPlayer.d.b) {
        this.a.b = true;
      } else if (d == UnityPlayer.d.a) {
        this.a.b = false;
      } else if (d == UnityPlayer.d.d) {
        this.a.c = false;
      } else {
        if (d == UnityPlayer.d.e) {
          this.a.c = true;
        } else {
          if (d == UnityPlayer.d.f) {
            if (this.a.d == UnityPlayer.b.a)
              UnityPlayer.a(this.a.f, false); 
            this.a.d = UnityPlayer.b.b;
          } else {
            if (d == UnityPlayer.d.g) {
              this.a.d = UnityPlayer.b.c;
            } else {
              return true;
            } 
            a();
          } 
          return true;
        } 
        a();
      } 
      return true;
    }
  }
  
  final class null implements MessageQueue.IdleHandler {
    null(UnityPlayer this$0) {}
    
    public final boolean queueIdle() {
      this.a.f.executeGLThreadJobs();
      if (!this.a.b)
        return true; 
      if (!this.a.c)
        return true; 
      if (this.a.e >= 0) {
        if (this.a.e == 0 && UnityPlayer.a(this.a.f))
          UnityPlayer.b(this.a.f); 
        UnityPlayer.e e1 = this.a;
        e1.e--;
      } 
      if (!this.a.f.isFinishing() && !UnityPlayer.c(this.a.f))
        UnityPlayer.d(this.a.f); 
      Message.obtain(this.a.a, 2269, UnityPlayer.d.h).sendToTarget();
      return true;
    }
  }
  
  private abstract class f implements Runnable {
    private f(UnityPlayer this$0) {}
    
    public abstract void a();
    
    public final void run() {
      if (!this.e.isFinishing())
        a(); 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\UnityPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */