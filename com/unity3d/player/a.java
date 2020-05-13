package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class a {
  private static CameraManager b;
  
  private static String[] c;
  
  private static Semaphore e = new Semaphore(1);
  
  private CameraCaptureSession.CaptureCallback A = new CameraCaptureSession.CaptureCallback(this) {
      public final void onCaptureCompleted(CameraCaptureSession param1CameraCaptureSession, CaptureRequest param1CaptureRequest, TotalCaptureResult param1TotalCaptureResult) {
        a.a(this.a, param1CaptureRequest.getTag());
      }
      
      public final void onCaptureFailed(CameraCaptureSession param1CameraCaptureSession, CaptureRequest param1CaptureRequest, CaptureFailure param1CaptureFailure) {
        StringBuilder stringBuilder = new StringBuilder("Camera2: Capture session failed ");
        stringBuilder.append(param1CaptureRequest.getTag());
        stringBuilder.append(" reason ");
        stringBuilder.append(param1CaptureFailure.getReason());
        g.Log(5, stringBuilder.toString());
        a.a(this.a, param1CaptureRequest.getTag());
      }
      
      public final void onCaptureSequenceAborted(CameraCaptureSession param1CameraCaptureSession, int param1Int) {}
      
      public final void onCaptureSequenceCompleted(CameraCaptureSession param1CameraCaptureSession, int param1Int, long param1Long) {}
    };
  
  private final CameraDevice.StateCallback B = new CameraDevice.StateCallback(this) {
      public final void onClosed(CameraDevice param1CameraDevice) {
        a.f().release();
      }
      
      public final void onDisconnected(CameraDevice param1CameraDevice) {
        g.Log(5, "Camera2: CameraDevice disconnected.");
        a.b(this.a, param1CameraDevice);
        a.f().release();
      }
      
      public final void onError(CameraDevice param1CameraDevice, int param1Int) {
        StringBuilder stringBuilder = new StringBuilder("Camera2: Error opeining CameraDevice ");
        stringBuilder.append(param1Int);
        g.Log(6, stringBuilder.toString());
        a.b(this.a, param1CameraDevice);
        a.f().release();
      }
      
      public final void onOpened(CameraDevice param1CameraDevice) {
        a.a(this.a, param1CameraDevice);
        a.f().release();
      }
    };
  
  private final ImageReader.OnImageAvailableListener C = new ImageReader.OnImageAvailableListener(this) {
      public final void onImageAvailable(ImageReader param1ImageReader) {
        if (a.f().tryAcquire()) {
          Image image = param1ImageReader.acquireNextImage();
          if (image != null) {
            Image.Plane[] arrayOfPlane = image.getPlanes();
            if (image.getFormat() == 35 && arrayOfPlane != null && arrayOfPlane.length == 3) {
              a.h(this.a).a(arrayOfPlane[0].getBuffer(), arrayOfPlane[1].getBuffer(), arrayOfPlane[2].getBuffer(), arrayOfPlane[0].getRowStride(), arrayOfPlane[1].getRowStride(), arrayOfPlane[1].getPixelStride());
            } else {
              g.Log(6, "Camera2: Wrong image format.");
            } 
            if (a.i(this.a) != null)
              a.i(this.a).close(); 
            a.a(this.a, image);
          } 
          a.f().release();
        } 
      }
    };
  
  private final SurfaceTexture.OnFrameAvailableListener D = new SurfaceTexture.OnFrameAvailableListener(this) {
      public final void onFrameAvailable(SurfaceTexture param1SurfaceTexture) {
        a.h(this.a).a(param1SurfaceTexture);
      }
    };
  
  private d a = null;
  
  private CameraDevice d;
  
  private HandlerThread f;
  
  private Handler g;
  
  private Rect h;
  
  private Rect i;
  
  private int j;
  
  private int k;
  
  private float l = -1.0F;
  
  private float m = -1.0F;
  
  private int n;
  
  private int o;
  
  private boolean p = false;
  
  private Range q;
  
  private ImageReader r = null;
  
  private Image s;
  
  private CaptureRequest.Builder t;
  
  private CameraCaptureSession u = null;
  
  private Object v = new Object();
  
  private int w;
  
  private SurfaceTexture x;
  
  private Surface y = null;
  
  private int z = a.c;
  
  protected a(d paramd) {
    this.a = paramd;
    g();
  }
  
  public static int a(Context paramContext) {
    return (c(paramContext)).length;
  }
  
  public static int a(Context paramContext, int paramInt) {
    try {
      return ((Integer)b(paramContext).getCameraCharacteristics(c(paramContext)[paramInt]).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    } catch (CameraAccessException cameraAccessException) {
      StringBuilder stringBuilder = new StringBuilder("Camera2: CameraAccessException ");
      stringBuilder.append(cameraAccessException);
      g.Log(6, stringBuilder.toString());
      return 0;
    } 
  }
  
  private static int a(Range[] paramArrayOfRange, int paramInt) {
    byte b = -1;
    double d1 = Double.MAX_VALUE;
    byte b1 = 0;
    while (b1 < paramArrayOfRange.length) {
      int i = ((Integer)paramArrayOfRange[b1].getLower()).intValue();
      int j = ((Integer)paramArrayOfRange[b1].getUpper()).intValue();
      float f = paramInt;
      if (f + 0.1F > i && f - 0.1F < j)
        return paramInt; 
      double d2 = Math.min(Math.abs(paramInt - i), Math.abs(paramInt - j));
      double d3 = d1;
      if (d2 < d1) {
        b = b1;
        d3 = d2;
      } 
      b1++;
      d1 = d3;
    } 
    if (paramInt > ((Integer)paramArrayOfRange[b].getUpper()).intValue()) {
      comparable = paramArrayOfRange[b].getUpper();
      return ((Integer)comparable).intValue();
    } 
    Comparable comparable = comparable[b].getLower();
    return ((Integer)comparable).intValue();
  }
  
  private static Rect a(Size[] paramArrayOfSize, double paramDouble1, double paramDouble2) {
    double d1 = Double.MAX_VALUE;
    byte b = 0;
    int i = 0;
    int j = 0;
    while (b < paramArrayOfSize.length) {
      int k = paramArrayOfSize[b].getWidth();
      int m = paramArrayOfSize[b].getHeight();
      double d2 = k;
      Double.isNaN(d2);
      d2 = Math.abs(Math.log(paramDouble1 / d2));
      double d3 = m;
      Double.isNaN(d3);
      d3 = d2 + Math.abs(Math.log(paramDouble2 / d3));
      d2 = d1;
      if (d3 < d1) {
        i = k;
        j = m;
        d2 = d3;
      } 
      b++;
      d1 = d2;
    } 
    return new Rect(0, 0, i, j);
  }
  
  private void a(CameraDevice paramCameraDevice) {
    synchronized (this.v) {
      this.u = null;
      paramCameraDevice.close();
      this.d = null;
      return;
    } 
  }
  
  private void a(Object paramObject) {
    if (paramObject == "Focus") {
      this.p = false;
      synchronized (this.v) {
        CameraCaptureSession cameraCaptureSession = this.u;
        if (cameraCaptureSession != null)
          try {
            this.t.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(0));
            this.t.setTag("Regular");
            this.u.setRepeatingRequest(this.t.build(), this.A, this.g);
          } catch (CameraAccessException cameraAccessException) {
            StringBuilder stringBuilder = new StringBuilder();
            this("Camera2: CameraAccessException ");
            stringBuilder.append(cameraAccessException);
            g.Log(6, stringBuilder.toString());
          }  
        return;
      } 
    } 
    if (paramObject == "Cancel focus")
      synchronized (this.v) {
        if (this.u != null)
          j(); 
        return;
      }  
  }
  
  private static Size[] a(CameraCharacteristics paramCameraCharacteristics) {
    String str2;
    String str1;
    StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap)paramCameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
    if (streamConfigurationMap == null) {
      str2 = "Camera2: configuration map is not available.";
      g.Log(6, str2);
      return null;
    } 
    Size[] arrayOfSize = str2.getOutputSizes(35);
    if (arrayOfSize == null || arrayOfSize.length == 0) {
      str1 = "Camera2: output sizes for YUV_420_888 format are not avialable.";
      g.Log(6, str1);
      return null;
    } 
    return (Size[])str1;
  }
  
  private static CameraManager b(Context paramContext) {
    if (b == null)
      b = (CameraManager)paramContext.getSystemService("camera"); 
    return b;
  }
  
  private void b(CameraCharacteristics paramCameraCharacteristics) {
    this.k = ((Integer)paramCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
    if (this.k > 0) {
      this.i = (Rect)paramCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
      float f1 = this.i.width() / this.i.height();
      float f2 = this.h.width() / this.h.height();
      if (f2 > f1) {
        this.n = 0;
        this.o = (int)((this.i.height() - this.i.width() / f2) / 2.0F);
      } else {
        this.o = 0;
        this.n = (int)((this.i.width() - this.i.height() * f2) / 2.0F);
      } 
      this.j = Math.min(this.i.width(), this.i.height()) / 20;
    } 
  }
  
  public static boolean b(Context paramContext, int paramInt) {
    try {
      paramInt = ((Integer)b(paramContext).getCameraCharacteristics(c(paramContext)[paramInt]).get(CameraCharacteristics.LENS_FACING)).intValue();
      return (paramInt == 0);
    } catch (CameraAccessException cameraAccessException) {
      StringBuilder stringBuilder = new StringBuilder("Camera2: CameraAccessException ");
      stringBuilder.append(cameraAccessException);
      g.Log(6, stringBuilder.toString());
      return false;
    } 
  }
  
  public static boolean c(Context paramContext, int paramInt) {
    try {
      paramInt = ((Integer)b(paramContext).getCameraCharacteristics(c(paramContext)[paramInt]).get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
      return (paramInt > 0);
    } catch (CameraAccessException cameraAccessException) {
      StringBuilder stringBuilder = new StringBuilder("Camera2: CameraAccessException ");
      stringBuilder.append(cameraAccessException);
      g.Log(6, stringBuilder.toString());
      return false;
    } 
  }
  
  private static String[] c(Context paramContext) {
    if (c == null)
      try {
        c = b(paramContext).getCameraIdList();
      } catch (CameraAccessException cameraAccessException) {
        StringBuilder stringBuilder = new StringBuilder("Camera2: CameraAccessException ");
        stringBuilder.append(cameraAccessException);
        g.Log(6, stringBuilder.toString());
        c = new String[0];
      }  
    return c;
  }
  
  public static int[] d(Context paramContext, int paramInt) {
    try {
      CameraCharacteristics cameraCharacteristics = b(paramContext).getCameraCharacteristics(c(paramContext)[paramInt]);
      Size[] arrayOfSize = a(cameraCharacteristics);
      if (arrayOfSize != null) {
        int[] arrayOfInt = new int[arrayOfSize.length * 2];
        for (paramInt = 0; paramInt < arrayOfSize.length; paramInt++) {
          int i = paramInt * 2;
          arrayOfInt[i] = arrayOfSize[paramInt].getWidth();
          arrayOfInt[i + 1] = arrayOfSize[paramInt].getHeight();
        } 
        return arrayOfInt;
      } 
      return null;
    } catch (CameraAccessException cameraAccessException) {
      StringBuilder stringBuilder = new StringBuilder("Camera2: CameraAccessException ");
      stringBuilder.append(cameraAccessException);
      g.Log(6, stringBuilder.toString());
      return null;
    } 
  }
  
  private void g() {
    this.f = new HandlerThread("CameraBackground");
    this.f.start();
    this.g = new Handler(this.f.getLooper());
  }
  
  private void h() {
    this.f.quit();
    try {
      this.f.join(4000L);
      this.f = null;
      this.g = null;
      return;
    } catch (InterruptedException interruptedException) {
      this.f.interrupt();
      StringBuilder stringBuilder = new StringBuilder("Camera2: Interrupted while waiting for the background thread to finish ");
      stringBuilder.append(interruptedException);
      g.Log(6, stringBuilder.toString());
      return;
    } 
  }
  
  private void i() {
    try {
      if (!e.tryAcquire(4L, TimeUnit.SECONDS)) {
        g.Log(5, "Camera2: Timeout waiting to lock camera for closing.");
        return;
      } 
      this.d.close();
      try {
        if (!e.tryAcquire(4L, TimeUnit.SECONDS))
          g.Log(5, "Camera2: Timeout waiting to close camera."); 
      } catch (InterruptedException interruptedException) {
        StringBuilder stringBuilder = new StringBuilder("Camera2: Interrupted while waiting to close camera ");
        stringBuilder.append(interruptedException);
        g.Log(6, stringBuilder.toString());
      } 
      this.d = null;
      e.release();
      return;
    } catch (InterruptedException interruptedException) {
      StringBuilder stringBuilder = new StringBuilder("Camera2: Interrupted while trying to lock camera for closing ");
      stringBuilder.append(interruptedException);
      g.Log(6, stringBuilder.toString());
      return;
    } 
  }
  
  private void j() {
    try {
      if (this.k == 0 || this.l < 0.0F || this.l > 1.0F || this.m < 0.0F || this.m > 1.0F) {
        this.t.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        this.t.setTag("Regular");
        if (this.u != null)
          this.u.setRepeatingRequest(this.t.build(), this.A, this.g); 
        return;
      } 
      this.p = true;
      int i = (int)((this.i.width() - this.n * 2) * this.l + this.n);
      double d1 = (this.i.height() - this.o * 2);
      float f = this.m;
      double d2 = f;
      Double.isNaN(d2);
      Double.isNaN(d1);
      int j = this.o;
      double d3 = j;
      Double.isNaN(d3);
      j = (int)(d1 * (1.0D - d2) + d3);
      i = Math.max(this.j + 1, Math.min(i, this.i.width() - this.j - 1));
      j = Math.max(this.j + 1, Math.min(j, this.i.height() - this.j - 1));
      CaptureRequest.Builder builder = this.t;
      CaptureRequest.Key key = CaptureRequest.CONTROL_AF_REGIONS;
      MeteringRectangle meteringRectangle = new MeteringRectangle();
      this(i - this.j, j - this.j, this.j * 2, this.j * 2, 999);
      builder.set(key, new MeteringRectangle[] { meteringRectangle });
      this.t.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
      this.t.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      this.t.setTag("Focus");
      this.u.capture(this.t.build(), this.A, this.g);
      return;
    } catch (CameraAccessException cameraAccessException) {
      StringBuilder stringBuilder = new StringBuilder("Camera2: CameraAccessException ");
      stringBuilder.append(cameraAccessException);
      g.Log(6, stringBuilder.toString());
      return;
    } 
  }
  
  private void k() {
    try {
      if (this.u != null) {
        this.u.stopRepeating();
        this.t.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
        this.t.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(0));
        this.t.setTag("Cancel focus");
        this.u.capture(this.t.build(), this.A, this.g);
      } 
      return;
    } catch (CameraAccessException cameraAccessException) {
      StringBuilder stringBuilder = new StringBuilder("Camera2: CameraAccessException ");
      stringBuilder.append(cameraAccessException);
      g.Log(6, stringBuilder.toString());
      return;
    } 
  }
  
  public final Rect a() {
    return this.h;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2) {
    if (this.k > 0) {
      if (!this.p) {
        this.l = paramFloat1;
        this.m = paramFloat2;
        synchronized (this.v) {
          if (this.u != null && this.z != a.b)
            k(); 
          return true;
        } 
      } 
      g.Log(5, "Camera2: Setting manual focus point already started.");
    } 
    return false;
  }
  
  public final boolean a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    try {
      CameraCharacteristics cameraCharacteristics = b.getCameraCharacteristics(c(paramContext)[paramInt1]);
      if (((Integer)cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
        g.Log(5, "Camera2: only LEGACY hardware level is supported.");
        return false;
      } 
      Size[] arrayOfSize = a(cameraCharacteristics);
      if (arrayOfSize != null && arrayOfSize.length != 0) {
        this.h = a(arrayOfSize, paramInt2, paramInt3);
        Range[] arrayOfRange = (Range[])cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (arrayOfRange == null || arrayOfRange.length == 0) {
          g.Log(6, "Camera2: target FPS ranges are not avialable.");
          return false;
        } 
        paramInt2 = a(arrayOfRange, paramInt4);
        this.q = new Range(Integer.valueOf(paramInt2), Integer.valueOf(paramInt2));
        try {
          if (!e.tryAcquire(4L, TimeUnit.SECONDS)) {
            g.Log(5, "Camera2: Timeout waiting to lock camera for opening.");
            return false;
          } 
          try {
            b.openCamera(c(paramContext)[paramInt1], this.B, this.g);
            try {
              if (!e.tryAcquire(4L, TimeUnit.SECONDS)) {
                g.Log(5, "Camera2: Timeout waiting to open camera.");
                return false;
              } 
              e.release();
            } catch (InterruptedException interruptedException) {
              StringBuilder stringBuilder = new StringBuilder("Camera2: Interrupted while waiting to open camera ");
              stringBuilder.append(interruptedException);
              g.Log(6, stringBuilder.toString());
            } 
            this.w = paramInt5;
            b(cameraCharacteristics);
            return (this.d != null);
          } catch (CameraAccessException cameraAccessException) {
            StringBuilder stringBuilder = new StringBuilder("Camera2: CameraAccessException ");
            stringBuilder.append(cameraAccessException);
            g.Log(6, stringBuilder.toString());
            e.release();
            return false;
          } 
        } catch (InterruptedException interruptedException) {
          StringBuilder stringBuilder = new StringBuilder("Camera2: Interrupted while trying to lock camera for opening ");
          stringBuilder.append(interruptedException);
          g.Log(6, stringBuilder.toString());
          return false;
        } 
      } 
      return false;
    } catch (CameraAccessException cameraAccessException) {
      StringBuilder stringBuilder = new StringBuilder("Camera2: CameraAccessException ");
      stringBuilder.append(cameraAccessException);
      g.Log(6, stringBuilder.toString());
      return false;
    } 
  }
  
  public final void b() {
    if (this.d != null) {
      e();
      i();
      this.A = null;
      this.y = null;
      this.x = null;
      if (this.s != null) {
        this.s.close();
        this.s = null;
      } 
      if (this.r != null) {
        this.r.close();
        this.r = null;
      } 
    } 
    h();
  }
  
  public final void c() {
    if (this.r == null) {
      this.r = ImageReader.newInstance(this.h.width(), this.h.height(), 35, 2);
      this.r.setOnImageAvailableListener(this.C, this.g);
      this.s = null;
      if (this.w != 0) {
        this.x = new SurfaceTexture(this.w);
        this.x.setDefaultBufferSize(this.h.width(), this.h.height());
        this.x.setOnFrameAvailableListener(this.D, this.g);
        this.y = new Surface(this.x);
      } 
    } 
    try {
      if (this.u != null) {
        if (this.z == a.b)
          this.u.setRepeatingRequest(this.t.build(), this.A, this.g); 
      } else {
        Surface[] arrayOfSurface;
        CameraDevice cameraDevice = this.d;
        if (this.y != null) {
          arrayOfSurface = new Surface[2];
          arrayOfSurface[0] = this.y;
          arrayOfSurface[1] = this.r.getSurface();
        } else {
          arrayOfSurface = new Surface[1];
          arrayOfSurface[0] = this.r.getSurface();
        } 
        List<Surface> list = Arrays.asList(arrayOfSurface);
        CameraCaptureSession.StateCallback stateCallback = new CameraCaptureSession.StateCallback() {
            public final void onConfigureFailed(CameraCaptureSession param1CameraCaptureSession) {
              g.Log(6, "Camera2: CaptureSession configuration failed.");
            }
            
            public final void onConfigured(CameraCaptureSession param1CameraCaptureSession) {
              if (a.a(this.a) == null)
                return; 
              synchronized (a.b(this.a)) {
                a.a(this.a, param1CameraCaptureSession);
                try {
                  a.a(this.a, a.a(this.a).createCaptureRequest(1));
                  if (a.c(this.a) != null)
                    a.d(this.a).addTarget(a.c(this.a)); 
                  a.d(this.a).addTarget(a.e(this.a).getSurface());
                  a.d(this.a).set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, a.f(this.a));
                  a.g(this.a);
                } catch (CameraAccessException cameraAccessException) {
                  StringBuilder stringBuilder = new StringBuilder();
                  this("Camera2: CameraAccessException ");
                  stringBuilder.append(cameraAccessException);
                  g.Log(6, stringBuilder.toString());
                } 
                return;
              } 
            }
          };
        super(this);
        cameraDevice.createCaptureSession(list, stateCallback, this.g);
      } 
      this.z = a.a;
      return;
    } catch (CameraAccessException cameraAccessException) {
      StringBuilder stringBuilder = new StringBuilder("Camera2: CameraAccessException ");
      stringBuilder.append(cameraAccessException);
      g.Log(6, stringBuilder.toString());
      return;
    } 
  }
  
  public final void d() {
    synchronized (this.v) {
      CameraCaptureSession cameraCaptureSession = this.u;
      if (cameraCaptureSession != null)
        try {
          this.u.stopRepeating();
          this.z = a.b;
        } catch (CameraAccessException cameraAccessException) {
          StringBuilder stringBuilder = new StringBuilder();
          this("Camera2: CameraAccessException ");
          stringBuilder.append(cameraAccessException);
          g.Log(6, stringBuilder.toString());
        }  
      return;
    } 
  }
  
  public final void e() {
    synchronized (this.v) {
      CameraCaptureSession cameraCaptureSession = this.u;
      if (cameraCaptureSession != null) {
        try {
          this.u.abortCaptures();
        } catch (CameraAccessException cameraAccessException) {
          StringBuilder stringBuilder = new StringBuilder();
          this("Camera2: CameraAccessException ");
          stringBuilder.append(cameraAccessException);
          g.Log(6, stringBuilder.toString());
        } 
        this.u.close();
        this.u = null;
        this.z = a.c;
      } 
      return;
    } 
  }
  
  private enum a {
    a, b, c;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */