package org.jar.photo.zoom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

public abstract class ImageViewTouchBase extends ImageView {
  private float a = -1.0F;
  
  private float b = -1.0F;
  
  private boolean c;
  
  private boolean d;
  
  private int e = -1;
  
  private int f = -1;
  
  private PointF g = new PointF();
  
  private boolean h;
  
  private boolean i;
  
  private b j;
  
  protected b k = new a();
  
  protected Matrix l = new Matrix();
  
  protected Matrix m = new Matrix();
  
  protected Matrix n;
  
  protected Handler o = new Handler();
  
  protected Runnable p = null;
  
  protected boolean q = false;
  
  protected final Matrix r = new Matrix();
  
  protected final float[] s = new float[9];
  
  protected a t = a.a;
  
  protected final int u = 200;
  
  protected RectF v = new RectF();
  
  protected RectF w = new RectF();
  
  protected RectF x = new RectF();
  
  private c y;
  
  public ImageViewTouchBase(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ImageViewTouchBase(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImageViewTouchBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  protected float a() {
    Drawable drawable = getDrawable();
    return (drawable == null) ? 1.0F : (Math.max(drawable.getIntrinsicWidth() / this.e, drawable.getIntrinsicHeight() / this.f) * 8.0F);
  }
  
  protected float a(Matrix paramMatrix, int paramInt) {
    paramMatrix.getValues(this.s);
    return this.s[paramInt];
  }
  
  protected float a(a parama) {
    return (parama == a.b) ? 1.0F : ((parama == a.c) ? Math.min(1.0F, 1.0F / c(this.l)) : (1.0F / c(this.l)));
  }
  
  public Matrix a(Matrix paramMatrix) {
    this.r.set(this.l);
    this.r.postConcat(paramMatrix);
    return this.r;
  }
  
  protected RectF a(Matrix paramMatrix, boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getDrawable : ()Landroid/graphics/drawable/Drawable;
    //   4: ifnonnull -> 19
    //   7: new android/graphics/RectF
    //   10: dup
    //   11: fconst_0
    //   12: fconst_0
    //   13: fconst_0
    //   14: fconst_0
    //   15: invokespecial <init> : (FFFF)V
    //   18: areturn
    //   19: aload_0
    //   20: getfield w : Landroid/graphics/RectF;
    //   23: fconst_0
    //   24: fconst_0
    //   25: fconst_0
    //   26: fconst_0
    //   27: invokevirtual set : (FFFF)V
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual b : (Landroid/graphics/Matrix;)Landroid/graphics/RectF;
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual height : ()F
    //   40: fstore #4
    //   42: aload_1
    //   43: invokevirtual width : ()F
    //   46: fstore #5
    //   48: iload_3
    //   49: ifeq -> 137
    //   52: aload_0
    //   53: getfield f : I
    //   56: i2f
    //   57: fstore #6
    //   59: fload #4
    //   61: fload #6
    //   63: fcmpg
    //   64: ifge -> 92
    //   67: fload #6
    //   69: fload #4
    //   71: fsub
    //   72: fconst_2
    //   73: fdiv
    //   74: fstore #4
    //   76: aload_1
    //   77: getfield top : F
    //   80: fstore #6
    //   82: fload #4
    //   84: fload #6
    //   86: fsub
    //   87: fstore #6
    //   89: goto -> 140
    //   92: aload_1
    //   93: getfield top : F
    //   96: fconst_0
    //   97: fcmpl
    //   98: ifle -> 111
    //   101: aload_1
    //   102: getfield top : F
    //   105: fneg
    //   106: fstore #6
    //   108: goto -> 140
    //   111: aload_1
    //   112: getfield bottom : F
    //   115: fload #6
    //   117: fcmpg
    //   118: ifge -> 137
    //   121: aload_0
    //   122: getfield f : I
    //   125: i2f
    //   126: fstore #4
    //   128: aload_1
    //   129: getfield bottom : F
    //   132: fstore #6
    //   134: goto -> 82
    //   137: fconst_0
    //   138: fstore #6
    //   140: iload_2
    //   141: ifeq -> 222
    //   144: aload_0
    //   145: getfield e : I
    //   148: i2f
    //   149: fstore #4
    //   151: fload #5
    //   153: fload #4
    //   155: fcmpg
    //   156: ifge -> 184
    //   159: fload #4
    //   161: fload #5
    //   163: fsub
    //   164: fconst_2
    //   165: fdiv
    //   166: fstore #4
    //   168: aload_1
    //   169: getfield left : F
    //   172: fstore #5
    //   174: fload #4
    //   176: fload #5
    //   178: fsub
    //   179: fstore #4
    //   181: goto -> 225
    //   184: aload_1
    //   185: getfield left : F
    //   188: fconst_0
    //   189: fcmpl
    //   190: ifle -> 203
    //   193: aload_1
    //   194: getfield left : F
    //   197: fneg
    //   198: fstore #4
    //   200: goto -> 225
    //   203: aload_1
    //   204: getfield right : F
    //   207: fload #4
    //   209: fcmpg
    //   210: ifge -> 222
    //   213: aload_1
    //   214: getfield right : F
    //   217: fstore #5
    //   219: goto -> 174
    //   222: fconst_0
    //   223: fstore #4
    //   225: aload_0
    //   226: getfield w : Landroid/graphics/RectF;
    //   229: fload #4
    //   231: fload #6
    //   233: fconst_0
    //   234: fconst_0
    //   235: invokevirtual set : (FFFF)V
    //   238: aload_0
    //   239: getfield w : Landroid/graphics/RectF;
    //   242: areturn
  }
  
  protected void a(double paramDouble1, double paramDouble2) {
    RectF rectF = getBitmapRect();
    this.x.set((float)paramDouble1, (float)paramDouble2, 0.0F, 0.0F);
    a(rectF, this.x);
    b(this.x.left, this.x.top);
    a(true, true);
  }
  
  protected void a(float paramFloat) {}
  
  protected void a(float paramFloat1, float paramFloat2, double paramDouble) {
    double d1 = paramFloat1;
    double d2 = paramFloat2;
    long l = System.currentTimeMillis();
    this.o.post(new e(this, paramDouble, l, d1, d2));
  }
  
  protected void a(float paramFloat1, float paramFloat2, float paramFloat3) {
    this.m.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    setImageMatrix(getImageViewMatrix());
  }
  
  protected void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    float f1 = paramFloat1;
    if (paramFloat1 > getMaxScale())
      f1 = getMaxScale(); 
    long l = System.currentTimeMillis();
    float f2 = getScale();
    Matrix matrix = new Matrix(this.m);
    matrix.postScale(f1, f1, paramFloat2, paramFloat3);
    RectF rectF = a(matrix, true, true);
    paramFloat1 = rectF.left;
    float f3 = rectF.top;
    this.o.post(new f(this, paramFloat4, l, f1 - f2, f2, paramFloat2 + paramFloat1 * f1, paramFloat3 + f3 * f1));
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.y != null)
      this.y.a(true, paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  public void a(Bitmap paramBitmap, Matrix paramMatrix, float paramFloat1, float paramFloat2) {
    if (paramBitmap != null) {
      b(new c(paramBitmap), paramMatrix, paramFloat1, paramFloat2);
    } else {
      b((Drawable)null, paramMatrix, paramFloat1, paramFloat2);
    } 
  }
  
  protected void a(RectF paramRectF1, RectF paramRectF2) {
    if (paramRectF1 == null)
      return; 
    if (paramRectF1.top >= 0.0F && paramRectF1.bottom <= this.f)
      paramRectF2.top = 0.0F; 
    if (paramRectF1.left >= 0.0F && paramRectF1.right <= this.e)
      paramRectF2.left = 0.0F; 
    if (paramRectF1.top + paramRectF2.top >= 0.0F && paramRectF1.bottom > this.f)
      paramRectF2.top = (int)(0.0F - paramRectF1.top); 
    if (paramRectF1.bottom + paramRectF2.top <= (this.f + 0) && paramRectF1.top < 0.0F)
      paramRectF2.top = (int)((this.f + 0) - paramRectF1.bottom); 
    if (paramRectF1.left + paramRectF2.left >= 0.0F)
      paramRectF2.left = (int)(0.0F - paramRectF1.left); 
    if (paramRectF1.right + paramRectF2.left <= (this.e + 0))
      paramRectF2.left = (int)((this.e + 0) - paramRectF1.right); 
  }
  
  protected void a(Drawable paramDrawable) {
    b(paramDrawable);
  }
  
  protected void a(Drawable paramDrawable, Matrix paramMatrix) {
    float f1 = this.e;
    float f2 = this.f;
    float f3 = paramDrawable.getIntrinsicWidth();
    float f4 = paramDrawable.getIntrinsicHeight();
    paramMatrix.reset();
    if (f3 <= f1);
    float f5 = Math.min(f1 / f3, f2 / f4);
    paramMatrix.postScale(f5, f5);
    paramMatrix.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
  }
  
  protected void a(Drawable paramDrawable, Matrix paramMatrix, float paramFloat1, float paramFloat2) {
    if (paramDrawable == null) {
      this.l.reset();
      paramDrawable = null;
    } 
    super.setImageDrawable(paramDrawable);
    if (paramFloat1 != -1.0F && paramFloat2 != -1.0F) {
      paramFloat1 = Math.min(paramFloat1, paramFloat2);
      paramFloat2 = Math.max(paramFloat1, paramFloat2);
      this.b = paramFloat1;
      this.a = paramFloat2;
      this.d = true;
      this.c = true;
      if (this.t == a.b || this.t == a.c) {
        if (this.b >= 1.0F) {
          this.d = false;
          this.b = -1.0F;
        } 
        if (this.a <= 1.0F) {
          this.c = true;
          this.a = -1.0F;
        } 
      } 
    } else {
      this.b = -1.0F;
      this.a = -1.0F;
      this.d = false;
      this.c = false;
    } 
    if (paramMatrix != null)
      this.n = new Matrix(paramMatrix); 
    this.i = true;
    requestLayout();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {
    if (getDrawable() == null)
      return; 
    RectF rectF = a(this.m, paramBoolean1, paramBoolean2);
    if (rectF.left != 0.0F || rectF.top != 0.0F)
      b(rectF.left, rectF.top); 
  }
  
  protected float b() {
    return (getDrawable() == null) ? 1.0F : Math.min(1.0F, 1.0F / c(this.l));
  }
  
  protected RectF b(Matrix paramMatrix) {
    Drawable drawable = getDrawable();
    if (drawable == null)
      return null; 
    paramMatrix = a(paramMatrix);
    this.v.set(0.0F, 0.0F, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    paramMatrix.mapRect(this.v);
    return this.v;
  }
  
  protected void b(float paramFloat) {
    float f = paramFloat;
    if (paramFloat > getMaxScale())
      f = getMaxScale(); 
    paramFloat = f;
    if (f < getMinScale())
      paramFloat = getMinScale(); 
    PointF pointF = getCenter();
    b(paramFloat, pointF.x, pointF.y);
  }
  
  protected void b(float paramFloat1, float paramFloat2) {
    if (paramFloat1 != 0.0F || paramFloat2 != 0.0F) {
      this.m.postTranslate(paramFloat1, paramFloat2);
      setImageMatrix(getImageViewMatrix());
    } 
  }
  
  protected void b(float paramFloat1, float paramFloat2, float paramFloat3) {
    float f = paramFloat1;
    if (paramFloat1 > getMaxScale())
      f = getMaxScale(); 
    a(f / getScale(), paramFloat2, paramFloat3);
    c(getScale());
    a(true, true);
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void b(Drawable paramDrawable) {
    if (this.j != null)
      this.j.a(paramDrawable); 
  }
  
  public void b(Drawable paramDrawable, Matrix paramMatrix, float paramFloat1, float paramFloat2) {
    if (getWidth() <= 0) {
      this.p = new d(this, paramDrawable, paramMatrix, paramFloat1, paramFloat2);
      return;
    } 
    a(paramDrawable, paramMatrix, paramFloat1, paramFloat2);
  }
  
  protected float c(Matrix paramMatrix) {
    return a(paramMatrix, 0);
  }
  
  protected void c() {}
  
  protected void c(float paramFloat) {}
  
  public void c(float paramFloat1, float paramFloat2) {
    PointF pointF = getCenter();
    a(paramFloat1, pointF.x, pointF.y, paramFloat2);
  }
  
  public void d(float paramFloat1, float paramFloat2) {
    a(paramFloat1, paramFloat2);
  }
  
  public float getBaseScale() {
    return c(this.l);
  }
  
  public RectF getBitmapRect() {
    return b(this.m);
  }
  
  protected PointF getCenter() {
    return this.g;
  }
  
  public Matrix getDisplayMatrix() {
    return new Matrix(this.m);
  }
  
  public a getDisplayType() {
    return this.t;
  }
  
  public Matrix getImageViewMatrix() {
    return a(this.m);
  }
  
  public float getMaxScale() {
    if (this.a == -1.0F)
      this.a = a(); 
    return this.a;
  }
  
  public float getMinScale() {
    if (this.b == -1.0F)
      this.b = b(); 
    return this.b;
  }
  
  @SuppressLint({"Override"})
  public float getRotation() {
    return 0.0F;
  }
  
  public float getScale() {
    return c(this.m);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: iload_3
    //   4: iload #4
    //   6: iload #5
    //   8: invokespecial onLayout : (ZIIII)V
    //   11: iload_1
    //   12: ifeq -> 92
    //   15: aload_0
    //   16: getfield e : I
    //   19: istore #6
    //   21: aload_0
    //   22: getfield f : I
    //   25: istore #7
    //   27: aload_0
    //   28: iload #4
    //   30: iload_2
    //   31: isub
    //   32: putfield e : I
    //   35: aload_0
    //   36: iload #5
    //   38: iload_3
    //   39: isub
    //   40: putfield f : I
    //   43: aload_0
    //   44: getfield e : I
    //   47: iload #6
    //   49: isub
    //   50: istore #6
    //   52: aload_0
    //   53: getfield f : I
    //   56: iload #7
    //   58: isub
    //   59: istore #7
    //   61: aload_0
    //   62: getfield g : Landroid/graphics/PointF;
    //   65: aload_0
    //   66: getfield e : I
    //   69: i2f
    //   70: fconst_2
    //   71: fdiv
    //   72: putfield x : F
    //   75: aload_0
    //   76: getfield g : Landroid/graphics/PointF;
    //   79: aload_0
    //   80: getfield f : I
    //   83: i2f
    //   84: fconst_2
    //   85: fdiv
    //   86: putfield y : F
    //   89: goto -> 98
    //   92: iconst_0
    //   93: istore #6
    //   95: iconst_0
    //   96: istore #7
    //   98: aload_0
    //   99: getfield p : Ljava/lang/Runnable;
    //   102: astore #8
    //   104: aload #8
    //   106: ifnull -> 121
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield p : Ljava/lang/Runnable;
    //   114: aload #8
    //   116: invokeinterface run : ()V
    //   121: aload_0
    //   122: invokevirtual getDrawable : ()Landroid/graphics/drawable/Drawable;
    //   125: astore #8
    //   127: aload #8
    //   129: ifnull -> 525
    //   132: iload_1
    //   133: ifne -> 150
    //   136: aload_0
    //   137: getfield h : Z
    //   140: ifne -> 150
    //   143: aload_0
    //   144: getfield i : Z
    //   147: ifeq -> 590
    //   150: aload_0
    //   151: aload_0
    //   152: getfield t : Lorg/jar/photo/zoom/ImageViewTouchBase$a;
    //   155: invokevirtual a : (Lorg/jar/photo/zoom/ImageViewTouchBase$a;)F
    //   158: pop
    //   159: aload_0
    //   160: aload_0
    //   161: getfield l : Landroid/graphics/Matrix;
    //   164: invokevirtual c : (Landroid/graphics/Matrix;)F
    //   167: fstore #9
    //   169: aload_0
    //   170: invokevirtual getScale : ()F
    //   173: fstore #10
    //   175: fconst_1
    //   176: fconst_1
    //   177: fload #9
    //   179: fdiv
    //   180: invokestatic min : (FF)F
    //   183: fstore #11
    //   185: aload_0
    //   186: aload #8
    //   188: aload_0
    //   189: getfield l : Landroid/graphics/Matrix;
    //   192: invokevirtual a : (Landroid/graphics/drawable/Drawable;Landroid/graphics/Matrix;)V
    //   195: aload_0
    //   196: aload_0
    //   197: getfield l : Landroid/graphics/Matrix;
    //   200: invokevirtual c : (Landroid/graphics/Matrix;)F
    //   203: fstore #12
    //   205: aload_0
    //   206: getfield i : Z
    //   209: ifne -> 339
    //   212: aload_0
    //   213: getfield h : Z
    //   216: ifeq -> 222
    //   219: goto -> 339
    //   222: iload_1
    //   223: ifeq -> 333
    //   226: aload_0
    //   227: getfield d : Z
    //   230: ifne -> 239
    //   233: aload_0
    //   234: ldc -1.0
    //   236: putfield b : F
    //   239: aload_0
    //   240: getfield c : Z
    //   243: ifne -> 252
    //   246: aload_0
    //   247: ldc -1.0
    //   249: putfield a : F
    //   252: aload_0
    //   253: aload_0
    //   254: invokevirtual getImageViewMatrix : ()Landroid/graphics/Matrix;
    //   257: invokevirtual setImageMatrix : (Landroid/graphics/Matrix;)V
    //   260: aload_0
    //   261: iload #6
    //   263: ineg
    //   264: i2f
    //   265: iload #7
    //   267: ineg
    //   268: i2f
    //   269: invokevirtual b : (FF)V
    //   272: aload_0
    //   273: getfield q : Z
    //   276: ifne -> 298
    //   279: aload_0
    //   280: aload_0
    //   281: getfield t : Lorg/jar/photo/zoom/ImageViewTouchBase$a;
    //   284: invokevirtual a : (Lorg/jar/photo/zoom/ImageViewTouchBase$a;)F
    //   287: fstore #9
    //   289: aload_0
    //   290: fload #9
    //   292: invokevirtual b : (F)V
    //   295: goto -> 420
    //   298: fload #10
    //   300: fload #11
    //   302: fsub
    //   303: invokestatic abs : (F)F
    //   306: f2d
    //   307: ldc2_w 0.001
    //   310: dcmpl
    //   311: ifle -> 327
    //   314: fload #9
    //   316: fload #12
    //   318: fdiv
    //   319: fload #10
    //   321: fmul
    //   322: fstore #9
    //   324: goto -> 289
    //   327: fconst_1
    //   328: fstore #9
    //   330: goto -> 289
    //   333: fconst_1
    //   334: fstore #9
    //   336: goto -> 420
    //   339: aload_0
    //   340: getfield n : Landroid/graphics/Matrix;
    //   343: ifnull -> 371
    //   346: aload_0
    //   347: getfield m : Landroid/graphics/Matrix;
    //   350: aload_0
    //   351: getfield n : Landroid/graphics/Matrix;
    //   354: invokevirtual set : (Landroid/graphics/Matrix;)V
    //   357: aload_0
    //   358: aconst_null
    //   359: putfield n : Landroid/graphics/Matrix;
    //   362: aload_0
    //   363: invokevirtual getScale : ()F
    //   366: fstore #11
    //   368: goto -> 391
    //   371: aload_0
    //   372: getfield m : Landroid/graphics/Matrix;
    //   375: invokevirtual reset : ()V
    //   378: aload_0
    //   379: aload_0
    //   380: getfield t : Lorg/jar/photo/zoom/ImageViewTouchBase$a;
    //   383: invokevirtual a : (Lorg/jar/photo/zoom/ImageViewTouchBase$a;)F
    //   386: fstore #11
    //   388: goto -> 368
    //   391: aload_0
    //   392: aload_0
    //   393: invokevirtual getImageViewMatrix : ()Landroid/graphics/Matrix;
    //   396: invokevirtual setImageMatrix : (Landroid/graphics/Matrix;)V
    //   399: fload #11
    //   401: fstore #9
    //   403: fload #11
    //   405: aload_0
    //   406: invokevirtual getScale : ()F
    //   409: fcmpl
    //   410: ifeq -> 420
    //   413: fload #11
    //   415: fstore #9
    //   417: goto -> 289
    //   420: aload_0
    //   421: iconst_0
    //   422: putfield q : Z
    //   425: fload #9
    //   427: aload_0
    //   428: invokevirtual getMaxScale : ()F
    //   431: fcmpl
    //   432: ifgt -> 445
    //   435: fload #9
    //   437: aload_0
    //   438: invokevirtual getMinScale : ()F
    //   441: fcmpg
    //   442: ifge -> 451
    //   445: aload_0
    //   446: fload #9
    //   448: invokevirtual b : (F)V
    //   451: aload_0
    //   452: iconst_1
    //   453: iconst_1
    //   454: invokevirtual a : (ZZ)V
    //   457: aload_0
    //   458: getfield i : Z
    //   461: ifeq -> 470
    //   464: aload_0
    //   465: aload #8
    //   467: invokevirtual a : (Landroid/graphics/drawable/Drawable;)V
    //   470: iload_1
    //   471: ifne -> 488
    //   474: aload_0
    //   475: getfield i : Z
    //   478: ifne -> 488
    //   481: aload_0
    //   482: getfield h : Z
    //   485: ifeq -> 498
    //   488: aload_0
    //   489: iload_2
    //   490: iload_3
    //   491: iload #4
    //   493: iload #5
    //   495: invokevirtual b : (IIII)V
    //   498: aload_0
    //   499: getfield h : Z
    //   502: ifeq -> 510
    //   505: aload_0
    //   506: iconst_0
    //   507: putfield h : Z
    //   510: aload_0
    //   511: getfield i : Z
    //   514: ifeq -> 590
    //   517: aload_0
    //   518: iconst_0
    //   519: putfield i : Z
    //   522: goto -> 590
    //   525: aload_0
    //   526: getfield i : Z
    //   529: ifeq -> 538
    //   532: aload_0
    //   533: aload #8
    //   535: invokevirtual a : (Landroid/graphics/drawable/Drawable;)V
    //   538: iload_1
    //   539: ifne -> 556
    //   542: aload_0
    //   543: getfield i : Z
    //   546: ifne -> 556
    //   549: aload_0
    //   550: getfield h : Z
    //   553: ifeq -> 566
    //   556: aload_0
    //   557: iload_2
    //   558: iload_3
    //   559: iload #4
    //   561: iload #5
    //   563: invokevirtual b : (IIII)V
    //   566: aload_0
    //   567: getfield i : Z
    //   570: ifeq -> 578
    //   573: aload_0
    //   574: iconst_0
    //   575: putfield i : Z
    //   578: aload_0
    //   579: getfield h : Z
    //   582: ifeq -> 590
    //   585: aload_0
    //   586: iconst_0
    //   587: putfield h : Z
    //   590: return
  }
  
  public void setDisplayType(a parama) {
    if (parama != this.t) {
      this.q = false;
      this.t = parama;
      this.h = true;
      requestLayout();
    } 
  }
  
  public void setImageBitmap(Bitmap paramBitmap) {
    a(paramBitmap, (Matrix)null, -1.0F, -1.0F);
  }
  
  public void setImageDrawable(Drawable paramDrawable) {
    b(paramDrawable, (Matrix)null, -1.0F, -1.0F);
  }
  
  public void setImageMatrix(Matrix paramMatrix) {
    boolean bool;
    Matrix matrix = getImageMatrix();
    if ((paramMatrix == null && !matrix.isIdentity()) || (paramMatrix != null && !matrix.equals(paramMatrix))) {
      bool = true;
    } else {
      bool = false;
    } 
    super.setImageMatrix(paramMatrix);
    if (bool)
      c(); 
  }
  
  public void setImageResource(int paramInt) {
    setImageDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  protected void setMaxScale(float paramFloat) {
    this.a = paramFloat;
  }
  
  protected void setMinScale(float paramFloat) {
    this.b = paramFloat;
  }
  
  public void setOnDrawableChangedListener(b paramb) {
    this.j = paramb;
  }
  
  public void setOnLayoutChangeListener(c paramc) {
    this.y = paramc;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType) {
    if (paramScaleType == ImageView.ScaleType.MATRIX) {
      super.setScaleType(paramScaleType);
    } else {
      Log.w("ImageViewTouchBase", "Unsupported scaletype. Only MATRIX can be used");
    } 
  }
  
  public enum a {
    a, b, c;
  }
  
  public static interface b {
    void a(Drawable param1Drawable);
  }
  
  public static interface c {
    void a(boolean param1Boolean, int param1Int1, int param1Int2, int param1Int3, int param1Int4);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\zoom\ImageViewTouchBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */