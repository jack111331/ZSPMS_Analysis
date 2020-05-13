package org.jar.photo.zoom;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;

public class ImageViewTouch extends ImageViewTouchBase {
  protected ScaleGestureDetector a;
  
  protected GestureDetector b;
  
  protected int c;
  
  protected float d;
  
  protected int e;
  
  protected GestureDetector.OnGestureListener f;
  
  protected ScaleGestureDetector.OnScaleGestureListener g;
  
  protected boolean h = true;
  
  protected boolean i = true;
  
  protected boolean j = true;
  
  private b y;
  
  private c z;
  
  public ImageViewTouch(Context paramContext) {
    super(paramContext);
  }
  
  public ImageViewTouch(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImageViewTouch(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected float a(float paramFloat1, float paramFloat2) {
    if (this.e == 1) {
      if (this.d * 2.0F + paramFloat1 <= paramFloat2)
        return paramFloat1 + this.d; 
      this.e = -1;
      return paramFloat2;
    } 
    this.e = 1;
    return 1.0F;
  }
  
  protected void a(float paramFloat) {
    if (paramFloat < getMinScale())
      c(getMinScale(), 50.0F); 
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super.a(paramContext, paramAttributeSet, paramInt);
    this.c = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.f = getGestureListener();
    this.g = getScaleListener();
    this.a = new ScaleGestureDetector(getContext(), this.g);
    this.b = new GestureDetector(getContext(), this.f, null, true);
    this.e = 1;
  }
  
  protected void a(Drawable paramDrawable, Matrix paramMatrix, float paramFloat1, float paramFloat2) {
    super.a(paramDrawable, paramMatrix, paramFloat1, paramFloat2);
    this.d = getMaxScale() / 3.0F;
  }
  
  public boolean a(int paramInt) {
    RectF rectF = getBitmapRect();
    a(rectF, this.x);
    Rect rect = new Rect();
    getGlobalVisibleRect(rect);
    boolean bool1 = false;
    boolean bool2 = false;
    if (rectF == null)
      return false; 
    if (rectF.right >= rect.right && paramInt < 0) {
      if (Math.abs(rectF.right - rect.right) > 1.0F)
        bool2 = true; 
      return bool2;
    } 
    bool2 = bool1;
    if (Math.abs(rectF.left - this.x.left) > 1.0D)
      bool2 = true; 
    return bool2;
  }
  
  public boolean a(MotionEvent paramMotionEvent) {
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
    if (getScale() == 1.0F)
      return false; 
    this.q = true;
    d(-paramFloat1, -paramFloat2);
    invalidate();
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent) {
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
    float f1 = paramMotionEvent2.getX();
    float f2 = paramMotionEvent1.getX();
    float f3 = paramMotionEvent2.getY();
    float f4 = paramMotionEvent1.getY();
    if (Math.abs(paramFloat1) > 800.0F || Math.abs(paramFloat2) > 800.0F) {
      this.q = true;
      a((f1 - f2) / 2.0F, (f3 - f4) / 2.0F, 300.0D);
      invalidate();
      return true;
    } 
    return false;
  }
  
  public boolean c(MotionEvent paramMotionEvent) {
    if (getScale() < getMinScale())
      c(getMinScale(), 50.0F); 
    return true;
  }
  
  public boolean d(MotionEvent paramMotionEvent) {
    return true;
  }
  
  public boolean getDoubleTapEnabled() {
    return this.h;
  }
  
  protected GestureDetector.OnGestureListener getGestureListener() {
    return (GestureDetector.OnGestureListener)new a(this);
  }
  
  protected ScaleGestureDetector.OnScaleGestureListener getScaleListener() {
    return (ScaleGestureDetector.OnScaleGestureListener)new d(this);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    this.a.onTouchEvent(paramMotionEvent);
    if (!this.a.isInProgress())
      this.b.onTouchEvent(paramMotionEvent); 
    return ((paramMotionEvent.getAction() & 0xFF) != 1) ? true : c(paramMotionEvent);
  }
  
  public void setDoubleTapEnabled(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public void setDoubleTapListener(b paramb) {
    this.y = paramb;
  }
  
  public void setScaleEnabled(boolean paramBoolean) {
    this.i = paramBoolean;
  }
  
  public void setScrollEnabled(boolean paramBoolean) {
    this.j = paramBoolean;
  }
  
  public void setSingleTapListener(c paramc) {
    this.z = paramc;
  }
  
  public class a extends GestureDetector.SimpleOnGestureListener {
    public a(ImageViewTouch this$0) {}
    
    public boolean onDoubleTap(MotionEvent param1MotionEvent) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onDoubleTap. double tap enabled? ");
      stringBuilder.append(this.a.h);
      Log.i("ImageViewTouchBase", stringBuilder.toString());
      if (this.a.h) {
        this.a.q = true;
        float f = this.a.getScale();
        f = this.a.a(f, this.a.getMaxScale());
        f = Math.min(this.a.getMaxScale(), Math.max(f, this.a.getMinScale()));
        this.a.a(f, param1MotionEvent.getX(), param1MotionEvent.getY(), 200.0F);
        this.a.invalidate();
      } 
      if (ImageViewTouch.b(this.a) != null)
        ImageViewTouch.b(this.a).a(); 
      return super.onDoubleTap(param1MotionEvent);
    }
    
    public boolean onDown(MotionEvent param1MotionEvent) {
      return this.a.b(param1MotionEvent);
    }
    
    public boolean onFling(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
      return !this.a.j ? false : ((param1MotionEvent1.getPointerCount() > 1 || param1MotionEvent2.getPointerCount() > 1) ? false : (this.a.a.isInProgress() ? false : ((this.a.getScale() == 1.0F) ? false : this.a.b(param1MotionEvent1, param1MotionEvent2, param1Float1, param1Float2))));
    }
    
    public void onLongPress(MotionEvent param1MotionEvent) {
      if (this.a.isLongClickable() && !this.a.a.isInProgress()) {
        this.a.setPressed(true);
        this.a.performLongClick();
      } 
    }
    
    public boolean onScroll(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
      return !this.a.j ? false : ((param1MotionEvent1 == null || param1MotionEvent2 == null || param1MotionEvent1.getPointerCount() > 1 || param1MotionEvent2.getPointerCount() > 1) ? false : (this.a.a.isInProgress() ? false : this.a.a(param1MotionEvent1, param1MotionEvent2, param1Float1, param1Float2)));
    }
    
    public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
      if (ImageViewTouch.a(this.a) != null)
        ImageViewTouch.a(this.a).a(); 
      return this.a.a(param1MotionEvent);
    }
    
    public boolean onSingleTapUp(MotionEvent param1MotionEvent) {
      return this.a.d(param1MotionEvent);
    }
  }
  
  public static interface b {
    void a();
  }
  
  public static interface c {
    void a();
  }
  
  public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    protected boolean a = false;
    
    public d(ImageViewTouch this$0) {}
    
    public boolean onScale(ScaleGestureDetector param1ScaleGestureDetector) {
      float f1 = param1ScaleGestureDetector.getCurrentSpan();
      float f2 = param1ScaleGestureDetector.getPreviousSpan();
      float f3 = this.b.getScale();
      float f4 = param1ScaleGestureDetector.getScaleFactor();
      if (this.b.i) {
        if (this.a && f1 - f2 != 0.0F) {
          this.b.q = true;
          f1 = Math.min(this.b.getMaxScale(), Math.max(f3 * f4, this.b.getMinScale() - 0.1F));
          this.b.b(f1, param1ScaleGestureDetector.getFocusX(), param1ScaleGestureDetector.getFocusY());
          this.b.e = 1;
          this.b.invalidate();
          return true;
        } 
        if (!this.a)
          this.a = true; 
      } 
      return true;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\zoom\ImageViewTouch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */