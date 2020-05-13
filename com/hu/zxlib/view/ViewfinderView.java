package com.hu.zxlib.view;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.a.ab;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.google.zxing.ResultPoint;
import com.hu.zxlib.a.a;
import com.hu.zxlib.b.e;
import com.hu.zxlib.common.b;
import java.util.ArrayList;
import java.util.List;

public final class ViewfinderView extends View {
  private static final long a = 80L;
  
  private static final int b = 160;
  
  private static final int c = 20;
  
  private static final int d = 6;
  
  private e e;
  
  private Paint f;
  
  private Paint g;
  
  private Paint h;
  
  private Paint i;
  
  private Bitmap j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private int p = -1;
  
  private List<ResultPoint> q;
  
  private List<ResultPoint> r;
  
  private int s;
  
  private a t;
  
  private ValueAnimator u;
  
  private Rect v;
  
  public ViewfinderView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ViewfinderView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewfinderView(Context paramContext, @ab AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.k = getResources().getColor(b.c(paramContext, "zx_viewfinder_mask"));
    this.l = getResources().getColor(b.c(paramContext, "zx_result_view"));
    this.m = getResources().getColor(b.c(paramContext, "zx_possible_result_points"));
    this.q = new ArrayList<ResultPoint>(10);
    this.r = null;
  }
  
  private int a(int paramInt) {
    return (int)TypedValue.applyDimension(1, paramInt, getResources().getDisplayMetrics());
  }
  
  private void a(Canvas paramCanvas, Rect paramRect) {
    if (this.p != -1)
      paramCanvas.drawRect(paramRect, this.i); 
    double d = paramRect.width();
    Double.isNaN(d);
    int i = (int)(d * 0.07D);
    d = i;
    Double.isNaN(d);
    int j = (int)(d * 0.2D);
    int k = j;
    if (j > 15)
      k = 15; 
    paramCanvas.drawRect((paramRect.left - k), paramRect.top, paramRect.left, (paramRect.top + i), this.h);
    paramCanvas.drawRect((paramRect.left - k), (paramRect.top - k), (paramRect.left + i), paramRect.top, this.h);
    paramCanvas.drawRect(paramRect.right, paramRect.top, (paramRect.right + k), (paramRect.top + i), this.h);
    paramCanvas.drawRect((paramRect.right - i), (paramRect.top - k), (paramRect.right + k), paramRect.top, this.h);
    paramCanvas.drawRect((paramRect.left - k), (paramRect.bottom - i), paramRect.left, paramRect.bottom, this.h);
    paramCanvas.drawRect((paramRect.left - k), paramRect.bottom, (paramRect.left + i), (paramRect.bottom + k), this.h);
    paramCanvas.drawRect(paramRect.right, (paramRect.bottom - i), (paramRect.right + k), paramRect.bottom, this.h);
    paramCanvas.drawRect((paramRect.right - i), paramRect.bottom, (paramRect.right + k), (paramRect.bottom + k), this.h);
  }
  
  private void a(Canvas paramCanvas, Rect paramRect, int paramInt1, int paramInt2) {
    int i;
    Paint paint = this.f;
    if (this.j != null) {
      i = this.l;
    } else {
      i = this.k;
    } 
    paint.setColor(i);
    float f = paramInt1;
    paramCanvas.drawRect(0.0F, 0.0F, f, paramRect.top, this.f);
    paramCanvas.drawRect(0.0F, paramRect.top, paramRect.left, (paramRect.bottom + 1), this.f);
    paramCanvas.drawRect((paramRect.right + 1), paramRect.top, f, (paramRect.bottom + 1), this.f);
    paramCanvas.drawRect(0.0F, (paramRect.bottom + 1), f, paramInt2, this.f);
  }
  
  private void a(Canvas paramCanvas, Rect paramRect1, Rect paramRect2) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual width : ()I
    //   4: i2f
    //   5: aload_3
    //   6: invokevirtual width : ()I
    //   9: i2f
    //   10: fdiv
    //   11: fstore #4
    //   13: aload_2
    //   14: invokevirtual height : ()I
    //   17: i2f
    //   18: aload_3
    //   19: invokevirtual height : ()I
    //   22: i2f
    //   23: fdiv
    //   24: fstore #5
    //   26: aload_0
    //   27: getfield q : Ljava/util/List;
    //   30: astore #6
    //   32: aload_0
    //   33: getfield r : Ljava/util/List;
    //   36: astore_3
    //   37: aload_2
    //   38: getfield left : I
    //   41: istore #7
    //   43: aload_2
    //   44: getfield top : I
    //   47: istore #8
    //   49: aload #6
    //   51: invokeinterface isEmpty : ()Z
    //   56: ifeq -> 67
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield r : Ljava/util/List;
    //   64: goto -> 182
    //   67: aload_0
    //   68: new java/util/ArrayList
    //   71: dup
    //   72: iconst_5
    //   73: invokespecial <init> : (I)V
    //   76: putfield q : Ljava/util/List;
    //   79: aload_0
    //   80: aload #6
    //   82: putfield r : Ljava/util/List;
    //   85: aload_0
    //   86: getfield f : Landroid/graphics/Paint;
    //   89: sipush #160
    //   92: invokevirtual setAlpha : (I)V
    //   95: aload_0
    //   96: getfield f : Landroid/graphics/Paint;
    //   99: aload_0
    //   100: getfield m : I
    //   103: invokevirtual setColor : (I)V
    //   106: aload #6
    //   108: monitorenter
    //   109: aload #6
    //   111: invokeinterface iterator : ()Ljava/util/Iterator;
    //   116: astore #9
    //   118: aload #9
    //   120: invokeinterface hasNext : ()Z
    //   125: ifeq -> 179
    //   128: aload #9
    //   130: invokeinterface next : ()Ljava/lang/Object;
    //   135: checkcast com/google/zxing/ResultPoint
    //   138: astore #10
    //   140: aload_1
    //   141: aload #10
    //   143: invokevirtual getX : ()F
    //   146: fload #4
    //   148: fmul
    //   149: f2i
    //   150: iload #7
    //   152: iadd
    //   153: i2f
    //   154: aload #10
    //   156: invokevirtual getY : ()F
    //   159: fload #5
    //   161: fmul
    //   162: f2i
    //   163: iload #8
    //   165: iadd
    //   166: i2f
    //   167: ldc 6.0
    //   169: aload_0
    //   170: getfield f : Landroid/graphics/Paint;
    //   173: invokevirtual drawCircle : (FFFLandroid/graphics/Paint;)V
    //   176: goto -> 118
    //   179: aload #6
    //   181: monitorexit
    //   182: aload_3
    //   183: ifnull -> 287
    //   186: aload_0
    //   187: getfield f : Landroid/graphics/Paint;
    //   190: bipush #80
    //   192: invokevirtual setAlpha : (I)V
    //   195: aload_0
    //   196: getfield f : Landroid/graphics/Paint;
    //   199: aload_0
    //   200: getfield m : I
    //   203: invokevirtual setColor : (I)V
    //   206: aload_3
    //   207: monitorenter
    //   208: aload_3
    //   209: invokeinterface iterator : ()Ljava/util/Iterator;
    //   214: astore #6
    //   216: aload #6
    //   218: invokeinterface hasNext : ()Z
    //   223: ifeq -> 277
    //   226: aload #6
    //   228: invokeinterface next : ()Ljava/lang/Object;
    //   233: checkcast com/google/zxing/ResultPoint
    //   236: astore #9
    //   238: aload_1
    //   239: aload #9
    //   241: invokevirtual getX : ()F
    //   244: fload #4
    //   246: fmul
    //   247: f2i
    //   248: iload #7
    //   250: iadd
    //   251: i2f
    //   252: aload #9
    //   254: invokevirtual getY : ()F
    //   257: fload #5
    //   259: fmul
    //   260: f2i
    //   261: iload #8
    //   263: iadd
    //   264: i2f
    //   265: ldc 3.0
    //   267: aload_0
    //   268: getfield f : Landroid/graphics/Paint;
    //   271: invokevirtual drawCircle : (FFFLandroid/graphics/Paint;)V
    //   274: goto -> 216
    //   277: aload_3
    //   278: monitorexit
    //   279: goto -> 287
    //   282: astore_1
    //   283: aload_3
    //   284: monitorexit
    //   285: aload_1
    //   286: athrow
    //   287: aload_0
    //   288: ldc2_w 80
    //   291: aload_2
    //   292: getfield left : I
    //   295: bipush #6
    //   297: isub
    //   298: aload_2
    //   299: getfield top : I
    //   302: bipush #6
    //   304: isub
    //   305: aload_2
    //   306: getfield right : I
    //   309: bipush #6
    //   311: iadd
    //   312: aload_2
    //   313: getfield bottom : I
    //   316: bipush #6
    //   318: iadd
    //   319: invokevirtual postInvalidateDelayed : (JIIII)V
    //   322: return
    //   323: astore_1
    //   324: aload #6
    //   326: monitorexit
    //   327: aload_1
    //   328: athrow
    // Exception table:
    //   from	to	target	type
    //   109	118	323	finally
    //   118	176	323	finally
    //   179	182	323	finally
    //   208	216	282	finally
    //   216	274	282	finally
    //   277	279	282	finally
    //   283	285	282	finally
    //   324	327	323	finally
  }
  
  private void b() {
    this.f = new Paint(1);
    this.h = new Paint(1);
    this.h.setColor(this.n);
    this.h.setStyle(Paint.Style.FILL);
    this.h.setStrokeWidth(a(1));
    if (this.p != -1) {
      this.i = new Paint(1);
      this.i.setColor(getResources().getColor(this.t.a()));
      this.i.setStrokeWidth(a(1));
      this.i.setStyle(Paint.Style.STROKE);
    } 
    this.g = new Paint(1);
    this.g.setStrokeWidth(a(2));
    this.g.setStyle(Paint.Style.FILL);
    this.g.setDither(true);
    this.g.setColor(this.o);
  }
  
  private void b(Canvas paramCanvas, Rect paramRect) {
    paramCanvas.drawLine(paramRect.left, this.s, paramRect.right, this.s, this.g);
  }
  
  private void c() {
    if (this.u == null) {
      this.u = ValueAnimator.ofInt(new int[] { this.v.top, this.v.bottom });
      this.u.setDuration(3000L);
      this.u.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      this.u.setRepeatMode(1);
      this.u.setRepeatCount(-1);
      this.u.addUpdateListener(new b(this));
      this.u.start();
    } 
  }
  
  public void a() {
    Bitmap bitmap = this.j;
    this.j = null;
    if (bitmap != null)
      bitmap.recycle(); 
    invalidate();
  }
  
  public void a(Bitmap paramBitmap) {
    this.j = paramBitmap;
    invalidate();
  }
  
  public void a(ResultPoint paramResultPoint) {
    synchronized (this.q) {
      null.add(paramResultPoint);
      int i = null.size();
      if (i > 20)
        null.subList(0, i - 10).clear(); 
      return;
    } 
  }
  
  @SuppressLint({"DrawAllocation"})
  public void onDraw(Canvas paramCanvas) {
    if (this.e == null)
      return; 
    this.v = this.e.e();
    Rect rect = this.e.f();
    if (this.v != null && rect != null) {
      c();
      int i = paramCanvas.getWidth();
      int j = paramCanvas.getHeight();
      a(paramCanvas, this.v, i, j);
      a(paramCanvas, this.v);
      if (this.j != null) {
        this.f.setAlpha(160);
        paramCanvas.drawBitmap(this.j, null, this.v, this.f);
      } else {
        b(paramCanvas, this.v);
      } 
    } 
  }
  
  public void setCameraManager(e parame) {
    this.e = parame;
  }
  
  public void setZxingConfig(a parama) {
    this.t = parama;
    this.n = getResources().getColor(b.c(getContext(), "zx_react"));
    if (parama.a() != -1)
      this.p = getResources().getColor(parama.a()); 
    this.o = getResources().getColor(b.c(getContext(), "zx_scanLineColor"));
    b();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\view\ViewfinderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */