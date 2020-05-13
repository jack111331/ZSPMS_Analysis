package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;

class GoogleVrProxy extends c implements GoogleVrVideo {
  private boolean f = false;
  
  private boolean g = false;
  
  private Runnable h = null;
  
  private Vector i = new Vector();
  
  private SurfaceView j = null;
  
  private a k = new a(this);
  
  private Thread l = null;
  
  private Handler m = new Handler(this, Looper.getMainLooper()) {
      public final void handleMessage(Message param1Message) {
        Surface surface;
        Iterator<GoogleVrVideo.GoogleVrVideoCallbacks> iterator2;
        if (param1Message.what != 135711) {
          super.handleMessage(param1Message);
          return;
        } 
        switch (param1Message.arg1) {
          default:
            super.handleMessage(param1Message);
            return;
          case 2147483646:
            surface = (Surface)param1Message.obj;
            iterator2 = GoogleVrProxy.a(this.a).iterator();
            while (iterator2.hasNext())
              ((GoogleVrVideo.GoogleVrVideoCallbacks)iterator2.next()).onSurfaceAvailable(surface); 
            return;
          case 2147483645:
            break;
        } 
        Iterator<GoogleVrVideo.GoogleVrVideoCallbacks> iterator1 = GoogleVrProxy.a(this.a).iterator();
        while (iterator1.hasNext())
          ((GoogleVrVideo.GoogleVrVideoCallbacks)iterator1.next()).onFrameAvailable(); 
      }
    };
  
  public GoogleVrProxy(f paramf) {
    super("Google VR", paramf);
    initVrJni();
  }
  
  private void a(boolean paramBoolean) {
    this.k.d = paramBoolean;
  }
  
  private static boolean a(int paramInt) {
    return (Build.VERSION.SDK_INT >= paramInt);
  }
  
  private boolean a(ClassLoader paramClassLoader) {
    try {
      Class<?> clazz = paramClassLoader.loadClass("com.unity3d.unitygvr.GoogleVR");
      Object object = clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
      o o = new o();
      this(clazz, object);
      o.a("initialize", new Class[] { Activity.class, Context.class, SurfaceView.class, boolean.class, Handler.class });
      o.a("deinitialize", new Class[0]);
      o.a("load", new Class[] { boolean.class, boolean.class, boolean.class, boolean.class, boolean.class, Runnable.class });
      o.a("enable", new Class[] { boolean.class });
      o.a("unload", new Class[0]);
      o.a("pause", new Class[0]);
      o.a("resume", new Class[0]);
      o.a("getGvrLayout", new Class[0]);
      o.a("getVideoSurfaceId", new Class[0]);
      o.a("getVideoSurface", new Class[0]);
      this.a = o;
      return true;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("Exception initializing GoogleVR from Unity library. ");
      stringBuilder.append(exception.getLocalizedMessage());
      reportError(stringBuilder.toString());
      return false;
    } 
  }
  
  private boolean d() {
    return this.k.d;
  }
  
  private void e() {
    Activity activity = (Activity)this.c;
    if (this.g && !this.k.f && activity != null) {
      this.k.f = true;
      Intent intent = new Intent("android.intent.action.MAIN");
      intent.addCategory("android.intent.category.HOME");
      intent.setFlags(268435456);
      activity.startActivity(intent);
    } 
  }
  
  private final native void initVrJni();
  
  private final native boolean isQuiting();
  
  private final native void setVrVideoTransform(float[][] paramArrayOffloat);
  
  public final void a(Intent paramIntent) {
    if (paramIntent != null && paramIntent.getBooleanExtra("android.intent.extra.VR_LAUNCH", false))
      this.g = true; 
  }
  
  public final boolean a() {
    return this.k.a;
  }
  
  public final boolean a(Activity paramActivity, Context paramContext, SurfaceView paramSurfaceView, Runnable paramRunnable) {
    String str;
    boolean bool;
    if (paramActivity == null || paramContext == null || paramSurfaceView == null || paramRunnable == null) {
      str = "Invalid parameters passed to Google VR initiialization.";
      reportError(str);
      return false;
    } 
    this.k.b();
    this.c = paramContext;
    this.h = paramRunnable;
    if (!a(19)) {
      str = "Google VR requires a device that supports an api version of 19 (KitKat) or better.";
      reportError(str);
      return false;
    } 
    if (this.g && !a(24)) {
      str = "Daydream requires a device that supports an api version of 24 (Nougat) or better.";
      reportError(str);
      return false;
    } 
    if (!a(UnityPlayer.class.getClassLoader()))
      return false; 
    try {
      bool = ((Boolean)this.a.a("initialize", new Object[] { str, paramContext, paramSurfaceView, Boolean.valueOf(this.g), this.m })).booleanValue();
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("Exception while trying to intialize Unity Google VR Library. ");
      stringBuilder.append(exception.getLocalizedMessage());
      reportError(stringBuilder.toString());
      bool = false;
    } 
    if (!bool) {
      str = "Unable to initialize GoogleVR library.";
      reportError(str);
      return false;
    } 
    this.j = paramSurfaceView;
    this.k.a = true;
    this.d = "";
    return true;
  }
  
  public final void b() {
    resumeGvrLayout();
  }
  
  public final void c() {
    if (this.j != null)
      this.j.getHolder().setSizeFromLayout(); 
  }
  
  public void deregisterGoogleVrVideoListener(GoogleVrVideo.GoogleVrVideoCallbacks paramGoogleVrVideoCallbacks) {
    if (this.i.contains(paramGoogleVrVideoCallbacks)) {
      paramGoogleVrVideoCallbacks.onSurfaceUnavailable();
      this.i.remove(paramGoogleVrVideoCallbacks);
    } 
  }
  
  protected Object getVideoSurface() {
    if (d() && !this.k.e)
      try {
        return this.a.a("getVideoSurface", new Object[0]);
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder("Exception caught while Getting GoogleVR Video Surface. ");
        stringBuilder.append(exception.getLocalizedMessage());
        reportError(stringBuilder.toString());
      }  
    return null;
  }
  
  protected int getVideoSurfaceId() {
    if (d() && !this.k.e)
      try {
        return ((Integer)this.a.a("getVideoSurfaceId", new Object[0])).intValue();
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder("Exception caught while getting Video Surface ID from GoogleVR. ");
        stringBuilder.append(exception.getLocalizedMessage());
        reportError(stringBuilder.toString());
      }  
    return -1;
  }
  
  protected long loadGoogleVr(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5) {
    String str;
    if (!this.k.a)
      return 0L; 
    AtomicLong atomicLong = new AtomicLong(0L);
    if (paramBoolean1 || paramBoolean2) {
      str = "Daydream";
    } else {
      str = "Cardboard";
    } 
    this.d = str;
    if (!runOnUiThreadWithSync(new Runnable(this, atomicLong, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5) {
          public final void run() {
            try {
              this.a.set(((Long)this.g.a.a("load", new Object[] { Boolean.valueOf(this.b), Boolean.valueOf(this.c), Boolean.valueOf(this.d), Boolean.valueOf(this.e), Boolean.valueOf(this.f), GoogleVrProxy.b(this.g) })).longValue());
              (GoogleVrProxy.c(this.g)).b = true;
              return;
            } catch (Exception exception) {
              GoogleVrProxy googleVrProxy = this.g;
              StringBuilder stringBuilder = new StringBuilder("Exception caught while loading GoogleVR. ");
              stringBuilder.append(exception.getLocalizedMessage());
              googleVrProxy.reportError(stringBuilder.toString());
              this.a.set(0L);
              return;
            } 
          }
        }) || atomicLong.longValue() == 0L)
      reportError("Google VR had a fatal issue while loading. VR will not be available."); 
    return atomicLong.longValue();
  }
  
  protected void pauseGvrLayout() {
    if (!this.k.a())
      return; 
    if (!this.k.e) {
      if (d()) {
        Iterator<GoogleVrVideo.GoogleVrVideoCallbacks> iterator = this.i.iterator();
        while (iterator.hasNext())
          ((GoogleVrVideo.GoogleVrVideoCallbacks)iterator.next()).onSurfaceUnavailable(); 
      } 
      if (this.a != null)
        this.a.a("pause", new Object[0]); 
      this.k.e = true;
    } 
  }
  
  public void registerGoogleVrVideoListener(GoogleVrVideo.GoogleVrVideoCallbacks paramGoogleVrVideoCallbacks) {
    if (!this.i.contains(paramGoogleVrVideoCallbacks)) {
      this.i.add(paramGoogleVrVideoCallbacks);
      Surface surface = (Surface)getVideoSurface();
      if (surface != null)
        paramGoogleVrVideoCallbacks.onSurfaceAvailable(surface); 
    } 
  }
  
  protected void resumeGvrLayout() {
    if (!this.k.a())
      return; 
    if (this.k.e) {
      if (this.a != null)
        this.a.a("resume", new Object[0]); 
      this.k.e = false;
    } 
  }
  
  protected void setGoogleVrModeEnabled(boolean paramBoolean) {
    if (!this.k.a())
      return; 
    if (this.b != null && this.c != null) {
      if (!paramBoolean && isQuiting())
        e(); 
      runOnUiThread(new Runnable(this, paramBoolean) {
            public final void run() {
              if (this.a == GoogleVrProxy.d(this.b))
                return; 
              try {
                if (this.a && !GoogleVrProxy.d(this.b)) {
                  if (this.b.a != null && this.b.b != null && !this.b.b.addViewToPlayer((View)this.b.a.a("getGvrLayout", new Object[0]), true)) {
                    this.b.reportError("Unable to add Google VR to view hierarchy.");
                    return;
                  } 
                  if (this.b.a != null)
                    this.b.a.a("enable", new Object[] { Boolean.valueOf(true) }); 
                  GoogleVrProxy.a(this.b, true);
                  return;
                } 
                if (!this.a && GoogleVrProxy.d(this.b)) {
                  GoogleVrProxy.a(this.b, false);
                  if (this.b.a != null)
                    this.b.a.a("enable", new Object[] { Boolean.valueOf(false) }); 
                  if (this.b.a != null && this.b.b != null)
                    this.b.b.removeViewFromPlayer((View)this.b.a.a("getGvrLayout", new Object[0])); 
                } 
                return;
              } catch (Exception exception) {
                GoogleVrProxy googleVrProxy = this.b;
                StringBuilder stringBuilder = new StringBuilder("Exception enabling Google VR on UI Thread. ");
                stringBuilder.append(exception.getLocalizedMessage());
                googleVrProxy.reportError(stringBuilder.toString());
                return;
              } 
            }
          });
    } 
  }
  
  public void setVideoLocationTransform(float[] paramArrayOffloat) {
    float[][] arrayOfFloat = new float[4][4];
    for (byte b = 0; b < 4; b++) {
      for (byte b1 = 0; b1 < 4; b1++)
        arrayOfFloat[b][b1] = paramArrayOffloat[b * 4 + b1]; 
    } 
    setVrVideoTransform(arrayOfFloat);
  }
  
  protected void unloadGoogleVr() {
    if (this.k.d)
      setGoogleVrModeEnabled(false); 
    if (this.k.c)
      this.k.c = false; 
    this.j = null;
    runOnUiThread(new Runnable(this) {
          public final void run() {
            try {
              if (this.a.a != null) {
                this.a.a.a("unload", new Object[0]);
                this.a.a.a("deinitialize", new Object[0]);
                this.a.a = null;
              } 
              (GoogleVrProxy.c(this.a)).b = false;
              return;
            } catch (Exception exception) {
              GoogleVrProxy googleVrProxy = this.a;
              StringBuilder stringBuilder = new StringBuilder("Exception unloading Google VR on UI Thread. ");
              stringBuilder.append(exception.getLocalizedMessage());
              googleVrProxy.reportError(stringBuilder.toString());
              return;
            } 
          }
        });
  }
  
  final class a {
    public boolean a = false;
    
    public boolean b = false;
    
    public boolean c = false;
    
    public boolean d = false;
    
    public boolean e = true;
    
    public boolean f = false;
    
    a(GoogleVrProxy this$0) {}
    
    public final boolean a() {
      return (this.a && this.b);
    }
    
    public final void b() {
      this.a = false;
      this.b = false;
      this.d = false;
      this.e = true;
      this.f = false;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\GoogleVrProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */