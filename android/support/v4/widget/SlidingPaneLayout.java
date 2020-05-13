package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
  private static final int DEFAULT_FADE_COLOR = -858993460;
  
  private static final int DEFAULT_OVERHANG_SIZE = 32;
  
  static final SlidingPanelLayoutImpl IMPL = new SlidingPanelLayoutImplBase();
  
  private static final int MIN_FLING_VELOCITY = 400;
  
  private static final String TAG = "SlidingPaneLayout";
  
  private boolean mCanSlide;
  
  private int mCoveredFadeColor;
  
  final ViewDragHelper mDragHelper;
  
  private boolean mFirstLayout = true;
  
  private float mInitialMotionX;
  
  private float mInitialMotionY;
  
  boolean mIsUnableToDrag;
  
  private final int mOverhangSize;
  
  private PanelSlideListener mPanelSlideListener;
  
  private int mParallaxBy;
  
  private float mParallaxOffset;
  
  final ArrayList<DisableLayerRunnable> mPostedRunnables = new ArrayList<DisableLayerRunnable>();
  
  boolean mPreservedOpenState;
  
  private Drawable mShadowDrawableLeft;
  
  private Drawable mShadowDrawableRight;
  
  float mSlideOffset;
  
  int mSlideRange;
  
  View mSlideableView;
  
  private int mSliderFadeColor = -858993460;
  
  private final Rect mTmpRect = new Rect();
  
  public SlidingPaneLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    float f = (paramContext.getResources().getDisplayMetrics()).density;
    this.mOverhangSize = (int)(32.0F * f + 0.5F);
    ViewConfiguration.get(paramContext);
    setWillNotDraw(false);
    ViewCompat.setAccessibilityDelegate((View)this, new AccessibilityDelegate());
    ViewCompat.setImportantForAccessibility((View)this, 1);
    this.mDragHelper = ViewDragHelper.create(this, 0.5F, new DragHelperCallback());
    this.mDragHelper.setMinVelocity(f * 400.0F);
  }
  
  private boolean closePane(View paramView, int paramInt) {
    boolean bool = false;
    if (this.mFirstLayout || smoothSlideTo(0.0F, paramInt)) {
      this.mPreservedOpenState = false;
      bool = true;
    } 
    return bool;
  }
  
  private void dimChildView(View paramView, float paramFloat, int paramInt) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat > 0.0F && paramInt != 0) {
      int i = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (layoutParams.dimPaint == null)
        layoutParams.dimPaint = new Paint(); 
      layoutParams.dimPaint.setColorFilter((ColorFilter)new PorterDuffColorFilter(i << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
      if (ViewCompat.getLayerType(paramView) != 2)
        ViewCompat.setLayerType(paramView, 2, layoutParams.dimPaint); 
      invalidateChildRegion(paramView);
      return;
    } 
    if (ViewCompat.getLayerType(paramView) != 0) {
      if (layoutParams.dimPaint != null)
        layoutParams.dimPaint.setColorFilter(null); 
      DisableLayerRunnable disableLayerRunnable = new DisableLayerRunnable(paramView);
      this.mPostedRunnables.add(disableLayerRunnable);
      ViewCompat.postOnAnimation((View)this, disableLayerRunnable);
    } 
  }
  
  private boolean openPane(View paramView, int paramInt) {
    null = true;
    if (this.mFirstLayout || smoothSlideTo(1.0F, paramInt)) {
      this.mPreservedOpenState = true;
      return null;
    } 
    return false;
  }
  
  private void parallaxOtherViews(float paramFloat) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual isLayoutRtlSupport : ()Z
    //   4: istore_2
    //   5: aload_0
    //   6: getfield mSlideableView : Landroid/view/View;
    //   9: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   12: checkcast android/support/v4/widget/SlidingPaneLayout$LayoutParams
    //   15: astore_3
    //   16: aload_3
    //   17: getfield dimWhenOffset : Z
    //   20: ifeq -> 87
    //   23: iload_2
    //   24: ifeq -> 78
    //   27: aload_3
    //   28: getfield rightMargin : I
    //   31: istore #4
    //   33: iload #4
    //   35: ifgt -> 87
    //   38: iconst_1
    //   39: istore #4
    //   41: aload_0
    //   42: invokevirtual getChildCount : ()I
    //   45: istore #5
    //   47: iconst_0
    //   48: istore #6
    //   50: iload #6
    //   52: iload #5
    //   54: if_icmpge -> 189
    //   57: aload_0
    //   58: iload #6
    //   60: invokevirtual getChildAt : (I)Landroid/view/View;
    //   63: astore_3
    //   64: aload_3
    //   65: aload_0
    //   66: getfield mSlideableView : Landroid/view/View;
    //   69: if_acmpne -> 93
    //   72: iinc #6, 1
    //   75: goto -> 50
    //   78: aload_3
    //   79: getfield leftMargin : I
    //   82: istore #4
    //   84: goto -> 33
    //   87: iconst_0
    //   88: istore #4
    //   90: goto -> 41
    //   93: fconst_1
    //   94: aload_0
    //   95: getfield mParallaxOffset : F
    //   98: fsub
    //   99: aload_0
    //   100: getfield mParallaxBy : I
    //   103: i2f
    //   104: fmul
    //   105: f2i
    //   106: istore #7
    //   108: aload_0
    //   109: fload_1
    //   110: putfield mParallaxOffset : F
    //   113: iload #7
    //   115: fconst_1
    //   116: fload_1
    //   117: fsub
    //   118: aload_0
    //   119: getfield mParallaxBy : I
    //   122: i2f
    //   123: fmul
    //   124: f2i
    //   125: isub
    //   126: istore #8
    //   128: iload #8
    //   130: istore #7
    //   132: iload_2
    //   133: ifeq -> 141
    //   136: iload #8
    //   138: ineg
    //   139: istore #7
    //   141: aload_3
    //   142: iload #7
    //   144: invokevirtual offsetLeftAndRight : (I)V
    //   147: iload #4
    //   149: ifeq -> 72
    //   152: iload_2
    //   153: ifeq -> 178
    //   156: aload_0
    //   157: getfield mParallaxOffset : F
    //   160: fconst_1
    //   161: fsub
    //   162: fstore #9
    //   164: aload_0
    //   165: aload_3
    //   166: fload #9
    //   168: aload_0
    //   169: getfield mCoveredFadeColor : I
    //   172: invokespecial dimChildView : (Landroid/view/View;FI)V
    //   175: goto -> 72
    //   178: fconst_1
    //   179: aload_0
    //   180: getfield mParallaxOffset : F
    //   183: fsub
    //   184: fstore #9
    //   186: goto -> 164
    //   189: return
  }
  
  private static boolean viewIsOpaque(View paramView) {
    boolean bool = false;
    if (!paramView.isOpaque()) {
      boolean bool1 = bool;
      if (Build.VERSION.SDK_INT < 18) {
        Drawable drawable = paramView.getBackground();
        bool1 = bool;
        if (drawable != null) {
          if (drawable.getOpacity() != -1)
            return bool; 
        } else {
          return bool1;
        } 
      } else {
        return bool1;
      } 
    } 
    return true;
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
    boolean bool = true;
    if (paramView instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      int i = paramView.getScrollX();
      int j = paramView.getScrollY();
      for (int k = viewGroup.getChildCount() - 1; k >= 0; k--) {
        View view = viewGroup.getChildAt(k);
        if (paramInt2 + i >= view.getLeft() && paramInt2 + i < view.getRight() && paramInt3 + j >= view.getTop() && paramInt3 + j < view.getBottom() && canScroll(view, true, paramInt1, paramInt2 + i - view.getLeft(), paramInt3 + j - view.getTop()))
          return bool; 
      } 
    } 
    if (paramBoolean) {
      if (!isLayoutRtlSupport())
        paramInt1 = -paramInt1; 
      paramBoolean = bool;
      return !ViewCompat.canScrollHorizontally(paramView, paramInt1) ? false : paramBoolean;
    } 
    return false;
  }
  
  @Deprecated
  public boolean canSlide() {
    return this.mCanSlide;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof LayoutParams && super.checkLayoutParams(paramLayoutParams));
  }
  
  public boolean closePane() {
    return closePane(this.mSlideableView, 0);
  }
  
  public void computeScroll() {
    if (this.mDragHelper.continueSettling(true)) {
      if (!this.mCanSlide) {
        this.mDragHelper.abort();
        return;
      } 
    } else {
      return;
    } 
    ViewCompat.postInvalidateOnAnimation((View)this);
  }
  
  void dispatchOnPanelClosed(View paramView) {
    if (this.mPanelSlideListener != null)
      this.mPanelSlideListener.onPanelClosed(paramView); 
    sendAccessibilityEvent(32);
  }
  
  void dispatchOnPanelOpened(View paramView) {
    if (this.mPanelSlideListener != null)
      this.mPanelSlideListener.onPanelOpened(paramView); 
    sendAccessibilityEvent(32);
  }
  
  void dispatchOnPanelSlide(View paramView) {
    if (this.mPanelSlideListener != null)
      this.mPanelSlideListener.onPanelSlide(paramView, this.mSlideOffset); 
  }
  
  public void draw(Canvas paramCanvas) {
    Drawable drawable;
    View view;
    super.draw(paramCanvas);
    if (isLayoutRtlSupport()) {
      drawable = this.mShadowDrawableRight;
    } else {
      drawable = this.mShadowDrawableLeft;
    } 
    if (getChildCount() > 1) {
      view = getChildAt(1);
    } else {
      view = null;
    } 
    if (view != null && drawable != null) {
      int m;
      int n;
      int i = view.getTop();
      int j = view.getBottom();
      int k = drawable.getIntrinsicWidth();
      if (isLayoutRtlSupport()) {
        m = view.getRight();
        n = m + k;
      } else {
        n = view.getLeft();
        m = n - k;
      } 
      drawable.setBounds(m, i, n, j);
      drawable.draw(paramCanvas);
    } 
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramCanvas.save(2);
    if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null) {
      paramCanvas.getClipBounds(this.mTmpRect);
      if (isLayoutRtlSupport()) {
        this.mTmpRect.left = Math.max(this.mTmpRect.left, this.mSlideableView.getRight());
      } else {
        this.mTmpRect.right = Math.min(this.mTmpRect.right, this.mSlideableView.getLeft());
      } 
      paramCanvas.clipRect(this.mTmpRect);
    } 
    if (Build.VERSION.SDK_INT >= 11) {
      boolean bool1 = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i);
      return bool1;
    } 
    if (layoutParams.dimWhenOffset && this.mSlideOffset > 0.0F) {
      if (!paramView.isDrawingCacheEnabled())
        paramView.setDrawingCacheEnabled(true); 
      Bitmap bitmap = paramView.getDrawingCache();
      if (bitmap != null) {
        paramCanvas.drawBitmap(bitmap, paramView.getLeft(), paramView.getTop(), layoutParams.dimPaint);
        boolean bool2 = false;
        paramCanvas.restoreToCount(i);
        return bool2;
      } 
      Log.e("SlidingPaneLayout", "drawChild: child view " + paramView + " returned null drawing cache");
      boolean bool1 = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i);
      return bool1;
    } 
    if (paramView.isDrawingCacheEnabled())
      paramView.setDrawingCacheEnabled(false); 
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(i);
    return bool;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
    return (ViewGroup.LayoutParams)new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return (ViewGroup.LayoutParams)new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (ViewGroup.LayoutParams)((paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams) : new LayoutParams(paramLayoutParams));
  }
  
  @ColorInt
  public int getCoveredFadeColor() {
    return this.mCoveredFadeColor;
  }
  
  public int getParallaxDistance() {
    return this.mParallaxBy;
  }
  
  @ColorInt
  public int getSliderFadeColor() {
    return this.mSliderFadeColor;
  }
  
  void invalidateChildRegion(View paramView) {
    IMPL.invalidateChildRegion(this, paramView);
  }
  
  boolean isDimmed(View paramView) {
    boolean bool = false;
    if (paramView != null) {
      LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
      if (this.mCanSlide && layoutParams.dimWhenOffset && this.mSlideOffset > 0.0F)
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  boolean isLayoutRtlSupport() {
    boolean bool = true;
    if (ViewCompat.getLayoutDirection((View)this) != 1)
      bool = false; 
    return bool;
  }
  
  public boolean isOpen() {
    return (!this.mCanSlide || this.mSlideOffset == 1.0F);
  }
  
  public boolean isSlideable() {
    return this.mCanSlide;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
    int i = this.mPostedRunnables.size();
    for (byte b = 0; b < i; b++)
      ((DisableLayerRunnable)this.mPostedRunnables.get(b)).run(); 
    this.mPostedRunnables.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: invokestatic getActionMasked : (Landroid/view/MotionEvent;)I
    //   6: istore_3
    //   7: aload_0
    //   8: getfield mCanSlide : Z
    //   11: ifne -> 69
    //   14: iload_3
    //   15: ifne -> 69
    //   18: aload_0
    //   19: invokevirtual getChildCount : ()I
    //   22: iconst_1
    //   23: if_icmple -> 69
    //   26: aload_0
    //   27: iconst_1
    //   28: invokevirtual getChildAt : (I)Landroid/view/View;
    //   31: astore #4
    //   33: aload #4
    //   35: ifnull -> 69
    //   38: aload_0
    //   39: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
    //   42: aload #4
    //   44: aload_1
    //   45: invokevirtual getX : ()F
    //   48: f2i
    //   49: aload_1
    //   50: invokevirtual getY : ()F
    //   53: f2i
    //   54: invokevirtual isViewUnder : (Landroid/view/View;II)Z
    //   57: ifne -> 104
    //   60: iconst_1
    //   61: istore #5
    //   63: aload_0
    //   64: iload #5
    //   66: putfield mPreservedOpenState : Z
    //   69: aload_0
    //   70: getfield mCanSlide : Z
    //   73: ifeq -> 87
    //   76: aload_0
    //   77: getfield mIsUnableToDrag : Z
    //   80: ifeq -> 110
    //   83: iload_3
    //   84: ifeq -> 110
    //   87: aload_0
    //   88: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
    //   91: invokevirtual cancel : ()V
    //   94: aload_0
    //   95: aload_1
    //   96: invokespecial onInterceptTouchEvent : (Landroid/view/MotionEvent;)Z
    //   99: istore #5
    //   101: iload #5
    //   103: ireturn
    //   104: iconst_0
    //   105: istore #5
    //   107: goto -> 63
    //   110: iload_3
    //   111: iconst_3
    //   112: if_icmpeq -> 120
    //   115: iload_3
    //   116: iconst_1
    //   117: if_icmpne -> 133
    //   120: aload_0
    //   121: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
    //   124: invokevirtual cancel : ()V
    //   127: iload_2
    //   128: istore #5
    //   130: goto -> 101
    //   133: iload_3
    //   134: tableswitch default -> 160, 0 -> 186, 1 -> 160, 2 -> 251
    //   160: iconst_0
    //   161: istore_3
    //   162: aload_0
    //   163: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
    //   166: aload_1
    //   167: invokevirtual shouldInterceptTouchEvent : (Landroid/view/MotionEvent;)Z
    //   170: ifne -> 180
    //   173: iload_2
    //   174: istore #5
    //   176: iload_3
    //   177: ifeq -> 101
    //   180: iconst_1
    //   181: istore #5
    //   183: goto -> 101
    //   186: aload_0
    //   187: iconst_0
    //   188: putfield mIsUnableToDrag : Z
    //   191: aload_1
    //   192: invokevirtual getX : ()F
    //   195: fstore #6
    //   197: aload_1
    //   198: invokevirtual getY : ()F
    //   201: fstore #7
    //   203: aload_0
    //   204: fload #6
    //   206: putfield mInitialMotionX : F
    //   209: aload_0
    //   210: fload #7
    //   212: putfield mInitialMotionY : F
    //   215: aload_0
    //   216: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
    //   219: aload_0
    //   220: getfield mSlideableView : Landroid/view/View;
    //   223: fload #6
    //   225: f2i
    //   226: fload #7
    //   228: f2i
    //   229: invokevirtual isViewUnder : (Landroid/view/View;II)Z
    //   232: ifeq -> 160
    //   235: aload_0
    //   236: aload_0
    //   237: getfield mSlideableView : Landroid/view/View;
    //   240: invokevirtual isDimmed : (Landroid/view/View;)Z
    //   243: ifeq -> 160
    //   246: iconst_1
    //   247: istore_3
    //   248: goto -> 162
    //   251: aload_1
    //   252: invokevirtual getX : ()F
    //   255: fstore #7
    //   257: aload_1
    //   258: invokevirtual getY : ()F
    //   261: fstore #6
    //   263: fload #7
    //   265: aload_0
    //   266: getfield mInitialMotionX : F
    //   269: fsub
    //   270: invokestatic abs : (F)F
    //   273: fstore #7
    //   275: fload #6
    //   277: aload_0
    //   278: getfield mInitialMotionY : F
    //   281: fsub
    //   282: invokestatic abs : (F)F
    //   285: fstore #6
    //   287: fload #7
    //   289: aload_0
    //   290: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
    //   293: invokevirtual getTouchSlop : ()I
    //   296: i2f
    //   297: fcmpl
    //   298: ifle -> 160
    //   301: fload #6
    //   303: fload #7
    //   305: fcmpl
    //   306: ifle -> 160
    //   309: aload_0
    //   310: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
    //   313: invokevirtual cancel : ()V
    //   316: aload_0
    //   317: iconst_1
    //   318: putfield mIsUnableToDrag : Z
    //   321: iload_2
    //   322: istore #5
    //   324: goto -> 101
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual isLayoutRtlSupport : ()Z
    //   4: istore #6
    //   6: iload #6
    //   8: ifeq -> 124
    //   11: aload_0
    //   12: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
    //   15: iconst_2
    //   16: invokevirtual setEdgeTrackingEnabled : (I)V
    //   19: iload #4
    //   21: iload_2
    //   22: isub
    //   23: istore #7
    //   25: iload #6
    //   27: ifeq -> 135
    //   30: aload_0
    //   31: invokevirtual getPaddingRight : ()I
    //   34: istore_3
    //   35: iload #6
    //   37: ifeq -> 143
    //   40: aload_0
    //   41: invokevirtual getPaddingLeft : ()I
    //   44: istore #5
    //   46: aload_0
    //   47: invokevirtual getPaddingTop : ()I
    //   50: istore #8
    //   52: aload_0
    //   53: invokevirtual getChildCount : ()I
    //   56: istore #9
    //   58: aload_0
    //   59: getfield mFirstLayout : Z
    //   62: ifeq -> 88
    //   65: aload_0
    //   66: getfield mCanSlide : Z
    //   69: ifeq -> 152
    //   72: aload_0
    //   73: getfield mPreservedOpenState : Z
    //   76: ifeq -> 152
    //   79: fconst_1
    //   80: fstore #10
    //   82: aload_0
    //   83: fload #10
    //   85: putfield mSlideOffset : F
    //   88: iconst_0
    //   89: istore #11
    //   91: iload_3
    //   92: istore_2
    //   93: iload #11
    //   95: iload #9
    //   97: if_icmpge -> 426
    //   100: aload_0
    //   101: iload #11
    //   103: invokevirtual getChildAt : (I)Landroid/view/View;
    //   106: astore #12
    //   108: aload #12
    //   110: invokevirtual getVisibility : ()I
    //   113: bipush #8
    //   115: if_icmpne -> 158
    //   118: iinc #11, 1
    //   121: goto -> 93
    //   124: aload_0
    //   125: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
    //   128: iconst_1
    //   129: invokevirtual setEdgeTrackingEnabled : (I)V
    //   132: goto -> 19
    //   135: aload_0
    //   136: invokevirtual getPaddingLeft : ()I
    //   139: istore_3
    //   140: goto -> 35
    //   143: aload_0
    //   144: invokevirtual getPaddingRight : ()I
    //   147: istore #5
    //   149: goto -> 46
    //   152: fconst_0
    //   153: fstore #10
    //   155: goto -> 82
    //   158: aload #12
    //   160: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   163: checkcast android/support/v4/widget/SlidingPaneLayout$LayoutParams
    //   166: astore #13
    //   168: aload #12
    //   170: invokevirtual getMeasuredWidth : ()I
    //   173: istore #14
    //   175: aload #13
    //   177: getfield slideable : Z
    //   180: ifeq -> 368
    //   183: aload #13
    //   185: getfield leftMargin : I
    //   188: istore #4
    //   190: aload #13
    //   192: getfield rightMargin : I
    //   195: istore #15
    //   197: iload_2
    //   198: iload #7
    //   200: iload #5
    //   202: isub
    //   203: aload_0
    //   204: getfield mOverhangSize : I
    //   207: isub
    //   208: invokestatic min : (II)I
    //   211: iload_3
    //   212: isub
    //   213: iload #4
    //   215: iload #15
    //   217: iadd
    //   218: isub
    //   219: istore #15
    //   221: aload_0
    //   222: iload #15
    //   224: putfield mSlideRange : I
    //   227: iload #6
    //   229: ifeq -> 353
    //   232: aload #13
    //   234: getfield rightMargin : I
    //   237: istore #4
    //   239: iload_3
    //   240: iload #4
    //   242: iadd
    //   243: iload #15
    //   245: iadd
    //   246: iload #14
    //   248: iconst_2
    //   249: idiv
    //   250: iadd
    //   251: iload #7
    //   253: iload #5
    //   255: isub
    //   256: if_icmple -> 363
    //   259: iconst_1
    //   260: istore_1
    //   261: aload #13
    //   263: iload_1
    //   264: putfield dimWhenOffset : Z
    //   267: iload #15
    //   269: i2f
    //   270: aload_0
    //   271: getfield mSlideOffset : F
    //   274: fmul
    //   275: f2i
    //   276: istore #15
    //   278: aload_0
    //   279: iload #15
    //   281: i2f
    //   282: aload_0
    //   283: getfield mSlideRange : I
    //   286: i2f
    //   287: fdiv
    //   288: putfield mSlideOffset : F
    //   291: iload_3
    //   292: iload #4
    //   294: iload #15
    //   296: iadd
    //   297: iadd
    //   298: istore_3
    //   299: iconst_0
    //   300: istore #4
    //   302: iload #6
    //   304: ifeq -> 410
    //   307: iload #4
    //   309: iload #7
    //   311: iload_3
    //   312: isub
    //   313: iadd
    //   314: istore #4
    //   316: iload #4
    //   318: iload #14
    //   320: isub
    //   321: istore #15
    //   323: aload #12
    //   325: iload #15
    //   327: iload #8
    //   329: iload #4
    //   331: aload #12
    //   333: invokevirtual getMeasuredHeight : ()I
    //   336: iload #8
    //   338: iadd
    //   339: invokevirtual layout : (IIII)V
    //   342: aload #12
    //   344: invokevirtual getWidth : ()I
    //   347: iload_2
    //   348: iadd
    //   349: istore_2
    //   350: goto -> 118
    //   353: aload #13
    //   355: getfield leftMargin : I
    //   358: istore #4
    //   360: goto -> 239
    //   363: iconst_0
    //   364: istore_1
    //   365: goto -> 261
    //   368: aload_0
    //   369: getfield mCanSlide : Z
    //   372: ifeq -> 402
    //   375: aload_0
    //   376: getfield mParallaxBy : I
    //   379: ifeq -> 402
    //   382: fconst_1
    //   383: aload_0
    //   384: getfield mSlideOffset : F
    //   387: fsub
    //   388: aload_0
    //   389: getfield mParallaxBy : I
    //   392: i2f
    //   393: fmul
    //   394: f2i
    //   395: istore #4
    //   397: iload_2
    //   398: istore_3
    //   399: goto -> 302
    //   402: iconst_0
    //   403: istore #4
    //   405: iload_2
    //   406: istore_3
    //   407: goto -> 302
    //   410: iload_3
    //   411: iload #4
    //   413: isub
    //   414: istore #15
    //   416: iload #15
    //   418: iload #14
    //   420: iadd
    //   421: istore #4
    //   423: goto -> 323
    //   426: aload_0
    //   427: getfield mFirstLayout : Z
    //   430: ifeq -> 495
    //   433: aload_0
    //   434: getfield mCanSlide : Z
    //   437: ifeq -> 501
    //   440: aload_0
    //   441: getfield mParallaxBy : I
    //   444: ifeq -> 455
    //   447: aload_0
    //   448: aload_0
    //   449: getfield mSlideOffset : F
    //   452: invokespecial parallaxOtherViews : (F)V
    //   455: aload_0
    //   456: getfield mSlideableView : Landroid/view/View;
    //   459: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   462: checkcast android/support/v4/widget/SlidingPaneLayout$LayoutParams
    //   465: getfield dimWhenOffset : Z
    //   468: ifeq -> 487
    //   471: aload_0
    //   472: aload_0
    //   473: getfield mSlideableView : Landroid/view/View;
    //   476: aload_0
    //   477: getfield mSlideOffset : F
    //   480: aload_0
    //   481: getfield mSliderFadeColor : I
    //   484: invokespecial dimChildView : (Landroid/view/View;FI)V
    //   487: aload_0
    //   488: aload_0
    //   489: getfield mSlideableView : Landroid/view/View;
    //   492: invokevirtual updateObscuredViewsVisibility : (Landroid/view/View;)V
    //   495: aload_0
    //   496: iconst_0
    //   497: putfield mFirstLayout : Z
    //   500: return
    //   501: iconst_0
    //   502: istore_2
    //   503: iload_2
    //   504: iload #9
    //   506: if_icmpge -> 487
    //   509: aload_0
    //   510: aload_0
    //   511: iload_2
    //   512: invokevirtual getChildAt : (I)Landroid/view/View;
    //   515: fconst_0
    //   516: aload_0
    //   517: getfield mSliderFadeColor : I
    //   520: invokespecial dimChildView : (Landroid/view/View;FI)V
    //   523: iinc #2, 1
    //   526: goto -> 503
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_1
    //   1: invokestatic getMode : (I)I
    //   4: istore_3
    //   5: iload_1
    //   6: invokestatic getSize : (I)I
    //   9: istore #4
    //   11: iload_2
    //   12: invokestatic getMode : (I)I
    //   15: istore_1
    //   16: iload_2
    //   17: invokestatic getSize : (I)I
    //   20: istore #5
    //   22: iload_3
    //   23: ldc_w 1073741824
    //   26: if_icmpeq -> 211
    //   29: aload_0
    //   30: invokevirtual isInEditMode : ()Z
    //   33: ifeq -> 200
    //   36: iload_3
    //   37: ldc_w -2147483648
    //   40: if_icmpne -> 184
    //   43: iload #4
    //   45: istore_2
    //   46: iload_1
    //   47: istore_3
    //   48: iload #5
    //   50: istore_1
    //   51: iload_3
    //   52: lookupswitch default -> 80, -2147483648 -> 269, 1073741824 -> 251
    //   80: iconst_0
    //   81: istore_1
    //   82: iconst_m1
    //   83: istore #5
    //   85: iload_2
    //   86: aload_0
    //   87: invokevirtual getPaddingLeft : ()I
    //   90: isub
    //   91: aload_0
    //   92: invokevirtual getPaddingRight : ()I
    //   95: isub
    //   96: istore #6
    //   98: aload_0
    //   99: invokevirtual getChildCount : ()I
    //   102: istore #7
    //   104: iload #7
    //   106: iconst_2
    //   107: if_icmple -> 119
    //   110: ldc 'SlidingPaneLayout'
    //   112: ldc_w 'onMeasure: More than two child views are not supported.'
    //   115: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   118: pop
    //   119: aload_0
    //   120: aconst_null
    //   121: putfield mSlideableView : Landroid/view/View;
    //   124: fconst_0
    //   125: fstore #8
    //   127: iload #6
    //   129: istore #4
    //   131: iconst_0
    //   132: istore #9
    //   134: iconst_0
    //   135: istore #10
    //   137: iload #9
    //   139: iload #7
    //   141: if_icmpge -> 571
    //   144: aload_0
    //   145: iload #9
    //   147: invokevirtual getChildAt : (I)Landroid/view/View;
    //   150: astore #11
    //   152: aload #11
    //   154: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   157: checkcast android/support/v4/widget/SlidingPaneLayout$LayoutParams
    //   160: astore #12
    //   162: aload #11
    //   164: invokevirtual getVisibility : ()I
    //   167: bipush #8
    //   169: if_icmpne -> 287
    //   172: aload #12
    //   174: iconst_0
    //   175: putfield dimWhenOffset : Z
    //   178: iinc #9, 1
    //   181: goto -> 137
    //   184: iload_3
    //   185: ifne -> 1043
    //   188: sipush #300
    //   191: istore_2
    //   192: iload_1
    //   193: istore_3
    //   194: iload #5
    //   196: istore_1
    //   197: goto -> 51
    //   200: new java/lang/IllegalStateException
    //   203: dup
    //   204: ldc_w 'Width must have an exact value or MATCH_PARENT'
    //   207: invokespecial <init> : (Ljava/lang/String;)V
    //   210: athrow
    //   211: iload_1
    //   212: ifne -> 1043
    //   215: aload_0
    //   216: invokevirtual isInEditMode : ()Z
    //   219: ifeq -> 240
    //   222: iload_1
    //   223: ifne -> 1043
    //   226: sipush #300
    //   229: istore_1
    //   230: iload #4
    //   232: istore_2
    //   233: ldc_w -2147483648
    //   236: istore_3
    //   237: goto -> 51
    //   240: new java/lang/IllegalStateException
    //   243: dup
    //   244: ldc_w 'Height must not be UNSPECIFIED'
    //   247: invokespecial <init> : (Ljava/lang/String;)V
    //   250: athrow
    //   251: iload_1
    //   252: aload_0
    //   253: invokevirtual getPaddingTop : ()I
    //   256: isub
    //   257: aload_0
    //   258: invokevirtual getPaddingBottom : ()I
    //   261: isub
    //   262: istore_1
    //   263: iload_1
    //   264: istore #5
    //   266: goto -> 85
    //   269: iload_1
    //   270: aload_0
    //   271: invokevirtual getPaddingTop : ()I
    //   274: isub
    //   275: aload_0
    //   276: invokevirtual getPaddingBottom : ()I
    //   279: isub
    //   280: istore #5
    //   282: iconst_0
    //   283: istore_1
    //   284: goto -> 85
    //   287: fload #8
    //   289: fstore #13
    //   291: aload #12
    //   293: getfield weight : F
    //   296: fconst_0
    //   297: fcmpl
    //   298: ifle -> 326
    //   301: fload #8
    //   303: aload #12
    //   305: getfield weight : F
    //   308: fadd
    //   309: fstore #8
    //   311: fload #8
    //   313: fstore #13
    //   315: aload #12
    //   317: getfield width : I
    //   320: ifne -> 326
    //   323: goto -> 178
    //   326: aload #12
    //   328: getfield leftMargin : I
    //   331: aload #12
    //   333: getfield rightMargin : I
    //   336: iadd
    //   337: istore #14
    //   339: aload #12
    //   341: getfield width : I
    //   344: bipush #-2
    //   346: if_icmpne -> 486
    //   349: iload #6
    //   351: iload #14
    //   353: isub
    //   354: ldc_w -2147483648
    //   357: invokestatic makeMeasureSpec : (II)I
    //   360: istore #14
    //   362: aload #12
    //   364: getfield height : I
    //   367: bipush #-2
    //   369: if_icmpne -> 527
    //   372: iload #5
    //   374: ldc_w -2147483648
    //   377: invokestatic makeMeasureSpec : (II)I
    //   380: istore #15
    //   382: aload #11
    //   384: iload #14
    //   386: iload #15
    //   388: invokevirtual measure : (II)V
    //   391: aload #11
    //   393: invokevirtual getMeasuredWidth : ()I
    //   396: istore #15
    //   398: aload #11
    //   400: invokevirtual getMeasuredHeight : ()I
    //   403: istore #16
    //   405: iload_1
    //   406: istore #14
    //   408: iload_3
    //   409: ldc_w -2147483648
    //   412: if_icmpne -> 433
    //   415: iload_1
    //   416: istore #14
    //   418: iload #16
    //   420: iload_1
    //   421: if_icmple -> 433
    //   424: iload #16
    //   426: iload #5
    //   428: invokestatic min : (II)I
    //   431: istore #14
    //   433: iload #4
    //   435: iload #15
    //   437: isub
    //   438: istore #4
    //   440: iload #4
    //   442: ifge -> 565
    //   445: iconst_1
    //   446: istore #17
    //   448: aload #12
    //   450: iload #17
    //   452: putfield slideable : Z
    //   455: aload #12
    //   457: getfield slideable : Z
    //   460: ifeq -> 469
    //   463: aload_0
    //   464: aload #11
    //   466: putfield mSlideableView : Landroid/view/View;
    //   469: fload #13
    //   471: fstore #8
    //   473: iload #10
    //   475: iload #17
    //   477: ior
    //   478: istore #10
    //   480: iload #14
    //   482: istore_1
    //   483: goto -> 178
    //   486: aload #12
    //   488: getfield width : I
    //   491: iconst_m1
    //   492: if_icmpne -> 511
    //   495: iload #6
    //   497: iload #14
    //   499: isub
    //   500: ldc_w 1073741824
    //   503: invokestatic makeMeasureSpec : (II)I
    //   506: istore #14
    //   508: goto -> 362
    //   511: aload #12
    //   513: getfield width : I
    //   516: ldc_w 1073741824
    //   519: invokestatic makeMeasureSpec : (II)I
    //   522: istore #14
    //   524: goto -> 362
    //   527: aload #12
    //   529: getfield height : I
    //   532: iconst_m1
    //   533: if_icmpne -> 549
    //   536: iload #5
    //   538: ldc_w 1073741824
    //   541: invokestatic makeMeasureSpec : (II)I
    //   544: istore #15
    //   546: goto -> 382
    //   549: aload #12
    //   551: getfield height : I
    //   554: ldc_w 1073741824
    //   557: invokestatic makeMeasureSpec : (II)I
    //   560: istore #15
    //   562: goto -> 382
    //   565: iconst_0
    //   566: istore #17
    //   568: goto -> 448
    //   571: iload #10
    //   573: ifne -> 583
    //   576: fload #8
    //   578: fconst_0
    //   579: fcmpl
    //   580: ifle -> 998
    //   583: iload #6
    //   585: aload_0
    //   586: getfield mOverhangSize : I
    //   589: isub
    //   590: istore #9
    //   592: iconst_0
    //   593: istore #14
    //   595: iload #14
    //   597: iload #7
    //   599: if_icmpge -> 998
    //   602: aload_0
    //   603: iload #14
    //   605: invokevirtual getChildAt : (I)Landroid/view/View;
    //   608: astore #12
    //   610: aload #12
    //   612: invokevirtual getVisibility : ()I
    //   615: bipush #8
    //   617: if_icmpne -> 626
    //   620: iinc #14, 1
    //   623: goto -> 595
    //   626: aload #12
    //   628: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   631: checkcast android/support/v4/widget/SlidingPaneLayout$LayoutParams
    //   634: astore #11
    //   636: aload #12
    //   638: invokevirtual getVisibility : ()I
    //   641: bipush #8
    //   643: if_icmpeq -> 620
    //   646: aload #11
    //   648: getfield width : I
    //   651: ifne -> 752
    //   654: aload #11
    //   656: getfield weight : F
    //   659: fconst_0
    //   660: fcmpl
    //   661: ifle -> 752
    //   664: iconst_1
    //   665: istore_3
    //   666: iload_3
    //   667: ifeq -> 757
    //   670: iconst_0
    //   671: istore #15
    //   673: iload #10
    //   675: ifeq -> 818
    //   678: aload #12
    //   680: aload_0
    //   681: getfield mSlideableView : Landroid/view/View;
    //   684: if_acmpeq -> 818
    //   687: aload #11
    //   689: getfield width : I
    //   692: ifge -> 620
    //   695: iload #15
    //   697: iload #9
    //   699: if_icmpgt -> 712
    //   702: aload #11
    //   704: getfield weight : F
    //   707: fconst_0
    //   708: fcmpl
    //   709: ifle -> 620
    //   712: iload_3
    //   713: ifeq -> 803
    //   716: aload #11
    //   718: getfield height : I
    //   721: bipush #-2
    //   723: if_icmpne -> 767
    //   726: iload #5
    //   728: ldc_w -2147483648
    //   731: invokestatic makeMeasureSpec : (II)I
    //   734: istore_3
    //   735: aload #12
    //   737: iload #9
    //   739: ldc_w 1073741824
    //   742: invokestatic makeMeasureSpec : (II)I
    //   745: iload_3
    //   746: invokevirtual measure : (II)V
    //   749: goto -> 620
    //   752: iconst_0
    //   753: istore_3
    //   754: goto -> 666
    //   757: aload #12
    //   759: invokevirtual getMeasuredWidth : ()I
    //   762: istore #15
    //   764: goto -> 673
    //   767: aload #11
    //   769: getfield height : I
    //   772: iconst_m1
    //   773: if_icmpne -> 788
    //   776: iload #5
    //   778: ldc_w 1073741824
    //   781: invokestatic makeMeasureSpec : (II)I
    //   784: istore_3
    //   785: goto -> 735
    //   788: aload #11
    //   790: getfield height : I
    //   793: ldc_w 1073741824
    //   796: invokestatic makeMeasureSpec : (II)I
    //   799: istore_3
    //   800: goto -> 735
    //   803: aload #12
    //   805: invokevirtual getMeasuredHeight : ()I
    //   808: ldc_w 1073741824
    //   811: invokestatic makeMeasureSpec : (II)I
    //   814: istore_3
    //   815: goto -> 735
    //   818: aload #11
    //   820: getfield weight : F
    //   823: fconst_0
    //   824: fcmpl
    //   825: ifle -> 620
    //   828: aload #11
    //   830: getfield width : I
    //   833: ifne -> 944
    //   836: aload #11
    //   838: getfield height : I
    //   841: bipush #-2
    //   843: if_icmpne -> 908
    //   846: iload #5
    //   848: ldc_w -2147483648
    //   851: invokestatic makeMeasureSpec : (II)I
    //   854: istore_3
    //   855: iload #10
    //   857: ifeq -> 959
    //   860: aload #11
    //   862: getfield leftMargin : I
    //   865: istore #16
    //   867: iload #6
    //   869: aload #11
    //   871: getfield rightMargin : I
    //   874: iload #16
    //   876: iadd
    //   877: isub
    //   878: istore #16
    //   880: iload #16
    //   882: ldc_w 1073741824
    //   885: invokestatic makeMeasureSpec : (II)I
    //   888: istore #18
    //   890: iload #15
    //   892: iload #16
    //   894: if_icmpeq -> 620
    //   897: aload #12
    //   899: iload #18
    //   901: iload_3
    //   902: invokevirtual measure : (II)V
    //   905: goto -> 620
    //   908: aload #11
    //   910: getfield height : I
    //   913: iconst_m1
    //   914: if_icmpne -> 929
    //   917: iload #5
    //   919: ldc_w 1073741824
    //   922: invokestatic makeMeasureSpec : (II)I
    //   925: istore_3
    //   926: goto -> 855
    //   929: aload #11
    //   931: getfield height : I
    //   934: ldc_w 1073741824
    //   937: invokestatic makeMeasureSpec : (II)I
    //   940: istore_3
    //   941: goto -> 855
    //   944: aload #12
    //   946: invokevirtual getMeasuredHeight : ()I
    //   949: ldc_w 1073741824
    //   952: invokestatic makeMeasureSpec : (II)I
    //   955: istore_3
    //   956: goto -> 855
    //   959: iconst_0
    //   960: iload #4
    //   962: invokestatic max : (II)I
    //   965: istore #16
    //   967: aload #12
    //   969: aload #11
    //   971: getfield weight : F
    //   974: iload #16
    //   976: i2f
    //   977: fmul
    //   978: fload #8
    //   980: fdiv
    //   981: f2i
    //   982: iload #15
    //   984: iadd
    //   985: ldc_w 1073741824
    //   988: invokestatic makeMeasureSpec : (II)I
    //   991: iload_3
    //   992: invokevirtual measure : (II)V
    //   995: goto -> 620
    //   998: aload_0
    //   999: iload_2
    //   1000: aload_0
    //   1001: invokevirtual getPaddingTop : ()I
    //   1004: iload_1
    //   1005: iadd
    //   1006: aload_0
    //   1007: invokevirtual getPaddingBottom : ()I
    //   1010: iadd
    //   1011: invokevirtual setMeasuredDimension : (II)V
    //   1014: aload_0
    //   1015: iload #10
    //   1017: putfield mCanSlide : Z
    //   1020: aload_0
    //   1021: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
    //   1024: invokevirtual getViewDragState : ()I
    //   1027: ifeq -> 1042
    //   1030: iload #10
    //   1032: ifne -> 1042
    //   1035: aload_0
    //   1036: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
    //   1039: invokevirtual abort : ()V
    //   1042: return
    //   1043: iload #4
    //   1045: istore_2
    //   1046: iload_1
    //   1047: istore_3
    //   1048: iload #5
    //   1050: istore_1
    //   1051: goto -> 51
  }
  
  void onPanelDragged(int paramInt) {
    if (this.mSlideableView == null) {
      this.mSlideOffset = 0.0F;
      return;
    } 
    boolean bool = isLayoutRtlSupport();
    LayoutParams layoutParams = (LayoutParams)this.mSlideableView.getLayoutParams();
    int i = this.mSlideableView.getWidth();
    int j = paramInt;
    if (bool)
      j = getWidth() - paramInt - i; 
    if (bool) {
      paramInt = getPaddingRight();
    } else {
      paramInt = getPaddingLeft();
    } 
    if (bool) {
      i = layoutParams.rightMargin;
    } else {
      i = layoutParams.leftMargin;
    } 
    this.mSlideOffset = (j - i + paramInt) / this.mSlideRange;
    if (this.mParallaxBy != 0)
      parallaxOtherViews(this.mSlideOffset); 
    if (layoutParams.dimWhenOffset)
      dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor); 
    dispatchOnPanelSlide(this.mSlideableView);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    if (savedState.isOpen) {
      openPane();
    } else {
      closePane();
    } 
    this.mPreservedOpenState = savedState.isOpen;
  }
  
  protected Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    if (isSlideable()) {
      boolean bool1 = isOpen();
      savedState.isOpen = bool1;
      return (Parcelable)savedState;
    } 
    boolean bool = this.mPreservedOpenState;
    savedState.isOpen = bool;
    return (Parcelable)savedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
      this.mFirstLayout = true; 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    float f1;
    float f2;
    if (!this.mCanSlide)
      return super.onTouchEvent(paramMotionEvent); 
    this.mDragHelper.processTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    boolean bool2 = true;
    switch (i & 0xFF) {
      default:
        return bool2;
      case 0:
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.mInitialMotionX = f1;
        this.mInitialMotionY = f2;
        return bool2;
      case 1:
        break;
    } 
    boolean bool1 = bool2;
    if (isDimmed(this.mSlideableView)) {
      f2 = paramMotionEvent.getX();
      float f3 = paramMotionEvent.getY();
      f1 = f2 - this.mInitialMotionX;
      float f4 = f3 - this.mInitialMotionY;
      i = this.mDragHelper.getTouchSlop();
      bool1 = bool2;
      if (f1 * f1 + f4 * f4 < (i * i)) {
        bool1 = bool2;
        if (this.mDragHelper.isViewUnder(this.mSlideableView, (int)f2, (int)f3)) {
          closePane(this.mSlideableView, 0);
          bool1 = bool2;
        } 
      } 
    } 
    return bool1;
  }
  
  public boolean openPane() {
    return openPane(this.mSlideableView, 0);
  }
  
  public void requestChildFocus(View paramView1, View paramView2) {
    super.requestChildFocus(paramView1, paramView2);
    if (!isInTouchMode() && !this.mCanSlide) {
      boolean bool;
      if (paramView1 == this.mSlideableView) {
        bool = true;
      } else {
        bool = false;
      } 
      this.mPreservedOpenState = bool;
    } 
  }
  
  void setAllChildrenVisible() {
    int i = getChildCount();
    for (byte b = 0; b < i; b++) {
      View view = getChildAt(b);
      if (view.getVisibility() == 4)
        view.setVisibility(0); 
    } 
  }
  
  public void setCoveredFadeColor(@ColorInt int paramInt) {
    this.mCoveredFadeColor = paramInt;
  }
  
  public void setPanelSlideListener(PanelSlideListener paramPanelSlideListener) {
    this.mPanelSlideListener = paramPanelSlideListener;
  }
  
  public void setParallaxDistance(int paramInt) {
    this.mParallaxBy = paramInt;
    requestLayout();
  }
  
  @Deprecated
  public void setShadowDrawable(Drawable paramDrawable) {
    setShadowDrawableLeft(paramDrawable);
  }
  
  public void setShadowDrawableLeft(Drawable paramDrawable) {
    this.mShadowDrawableLeft = paramDrawable;
  }
  
  public void setShadowDrawableRight(Drawable paramDrawable) {
    this.mShadowDrawableRight = paramDrawable;
  }
  
  @Deprecated
  public void setShadowResource(@DrawableRes int paramInt) {
    setShadowDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setShadowResourceLeft(int paramInt) {
    setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setShadowResourceRight(int paramInt) {
    setShadowDrawableRight(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setSliderFadeColor(@ColorInt int paramInt) {
    this.mSliderFadeColor = paramInt;
  }
  
  @Deprecated
  public void smoothSlideClosed() {
    closePane();
  }
  
  @Deprecated
  public void smoothSlideOpen() {
    openPane();
  }
  
  boolean smoothSlideTo(float paramFloat, int paramInt) {
    if (!this.mCanSlide)
      return false; 
    null = isLayoutRtlSupport();
    LayoutParams layoutParams = (LayoutParams)this.mSlideableView.getLayoutParams();
    if (null) {
      paramInt = getPaddingRight();
      int i = layoutParams.rightMargin;
      int j = this.mSlideableView.getWidth();
      paramInt = (int)(getWidth() - (i + paramInt) + this.mSlideRange * paramFloat + j);
    } else {
      paramInt = getPaddingLeft();
      paramInt = (int)((layoutParams.leftMargin + paramInt) + this.mSlideRange * paramFloat);
    } 
    if (this.mDragHelper.smoothSlideViewTo(this.mSlideableView, paramInt, this.mSlideableView.getTop())) {
      setAllChildrenVisible();
      ViewCompat.postInvalidateOnAnimation((View)this);
      return true;
    } 
    return false;
  }
  
  void updateObscuredViewsVisibility(View paramView) {
    int i;
    int j;
    byte b1;
    byte b2;
    byte b3;
    byte b4;
    boolean bool = isLayoutRtlSupport();
    if (bool) {
      i = getWidth() - getPaddingRight();
    } else {
      i = getPaddingLeft();
    } 
    if (bool) {
      j = getPaddingLeft();
    } else {
      j = getWidth() - getPaddingRight();
    } 
    int k = getPaddingTop();
    int m = getHeight();
    int n = getPaddingBottom();
    if (paramView != null && viewIsOpaque(paramView)) {
      b1 = paramView.getLeft();
      b2 = paramView.getRight();
      b3 = paramView.getTop();
      b4 = paramView.getBottom();
    } else {
      b4 = 0;
      b3 = 0;
      b2 = 0;
      b1 = 0;
    } 
    int i1 = getChildCount();
    byte b5 = 0;
    while (true) {
      if (b5 < i1) {
        View view = getChildAt(b5);
        if (view != paramView) {
          if (view.getVisibility() != 8) {
            if (bool) {
              i2 = j;
            } else {
              i2 = i;
            } 
            int i3 = Math.max(i2, view.getLeft());
            int i4 = Math.max(k, view.getTop());
            if (bool) {
              i2 = i;
            } else {
              i2 = j;
            } 
            int i5 = Math.min(i2, view.getRight());
            int i2 = Math.min(m - n, view.getBottom());
            if (i3 >= b1 && i4 >= b3 && i5 <= b2 && i2 <= b4) {
              i2 = 4;
            } else {
              i2 = 0;
            } 
            view.setVisibility(i2);
          } 
          b5++;
          continue;
        } 
      } 
      return;
    } 
  }
  
  static {
    int i = Build.VERSION.SDK_INT;
    if (i >= 17) {
      IMPL = new SlidingPanelLayoutImplJBMR1();
      return;
    } 
    if (i >= 16) {
      IMPL = new SlidingPanelLayoutImplJB();
      return;
    } 
  }
  
  class AccessibilityDelegate extends AccessibilityDelegateCompat {
    private final Rect mTmpRect = new Rect();
    
    private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat2) {
      Rect rect = this.mTmpRect;
      param1AccessibilityNodeInfoCompat2.getBoundsInParent(rect);
      param1AccessibilityNodeInfoCompat1.setBoundsInParent(rect);
      param1AccessibilityNodeInfoCompat2.getBoundsInScreen(rect);
      param1AccessibilityNodeInfoCompat1.setBoundsInScreen(rect);
      param1AccessibilityNodeInfoCompat1.setVisibleToUser(param1AccessibilityNodeInfoCompat2.isVisibleToUser());
      param1AccessibilityNodeInfoCompat1.setPackageName(param1AccessibilityNodeInfoCompat2.getPackageName());
      param1AccessibilityNodeInfoCompat1.setClassName(param1AccessibilityNodeInfoCompat2.getClassName());
      param1AccessibilityNodeInfoCompat1.setContentDescription(param1AccessibilityNodeInfoCompat2.getContentDescription());
      param1AccessibilityNodeInfoCompat1.setEnabled(param1AccessibilityNodeInfoCompat2.isEnabled());
      param1AccessibilityNodeInfoCompat1.setClickable(param1AccessibilityNodeInfoCompat2.isClickable());
      param1AccessibilityNodeInfoCompat1.setFocusable(param1AccessibilityNodeInfoCompat2.isFocusable());
      param1AccessibilityNodeInfoCompat1.setFocused(param1AccessibilityNodeInfoCompat2.isFocused());
      param1AccessibilityNodeInfoCompat1.setAccessibilityFocused(param1AccessibilityNodeInfoCompat2.isAccessibilityFocused());
      param1AccessibilityNodeInfoCompat1.setSelected(param1AccessibilityNodeInfoCompat2.isSelected());
      param1AccessibilityNodeInfoCompat1.setLongClickable(param1AccessibilityNodeInfoCompat2.isLongClickable());
      param1AccessibilityNodeInfoCompat1.addAction(param1AccessibilityNodeInfoCompat2.getActions());
      param1AccessibilityNodeInfoCompat1.setMovementGranularities(param1AccessibilityNodeInfoCompat2.getMovementGranularities());
    }
    
    public boolean filter(View param1View) {
      return SlidingPaneLayout.this.isDimmed(param1View);
    }
    
    public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      super.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
      param1AccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(param1AccessibilityNodeInfoCompat);
      super.onInitializeAccessibilityNodeInfo(param1View, accessibilityNodeInfoCompat);
      copyNodeInfoNoChildren(param1AccessibilityNodeInfoCompat, accessibilityNodeInfoCompat);
      accessibilityNodeInfoCompat.recycle();
      param1AccessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
      param1AccessibilityNodeInfoCompat.setSource(param1View);
      ViewParent viewParent = ViewCompat.getParentForAccessibility(param1View);
      if (viewParent instanceof View)
        param1AccessibilityNodeInfoCompat.setParent((View)viewParent); 
      int i = SlidingPaneLayout.this.getChildCount();
      for (byte b = 0; b < i; b++) {
        View view = SlidingPaneLayout.this.getChildAt(b);
        if (!filter(view) && view.getVisibility() == 0) {
          ViewCompat.setImportantForAccessibility(view, 1);
          param1AccessibilityNodeInfoCompat.addChild(view);
        } 
      } 
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return !filter(param1View) ? super.onRequestSendAccessibilityEvent(param1ViewGroup, param1View, param1AccessibilityEvent) : false;
    }
  }
  
  private class DisableLayerRunnable implements Runnable {
    final View mChildView;
    
    DisableLayerRunnable(View param1View) {
      this.mChildView = param1View;
    }
    
    public void run() {
      if (this.mChildView.getParent() == SlidingPaneLayout.this) {
        ViewCompat.setLayerType(this.mChildView, 0, null);
        SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
      } 
      SlidingPaneLayout.this.mPostedRunnables.remove(this);
    }
  }
  
  private class DragHelperCallback extends ViewDragHelper.Callback {
    public int clampViewPositionHorizontal(View param1View, int param1Int1, int param1Int2) {
      SlidingPaneLayout.LayoutParams layoutParams = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.this.mSlideableView.getLayoutParams();
      if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
        param1Int2 = SlidingPaneLayout.this.getWidth();
        int j = SlidingPaneLayout.this.getPaddingRight();
        j = param1Int2 - layoutParams.rightMargin + j + SlidingPaneLayout.this.mSlideableView.getWidth();
        param1Int2 = SlidingPaneLayout.this.mSlideRange;
        return Math.max(Math.min(param1Int1, j), j - param1Int2);
      } 
      param1Int2 = SlidingPaneLayout.this.getPaddingLeft();
      int i = layoutParams.leftMargin + param1Int2;
      param1Int2 = SlidingPaneLayout.this.mSlideRange;
      return Math.min(Math.max(param1Int1, i), param1Int2 + i);
    }
    
    public int clampViewPositionVertical(View param1View, int param1Int1, int param1Int2) {
      return param1View.getTop();
    }
    
    public int getViewHorizontalDragRange(View param1View) {
      return SlidingPaneLayout.this.mSlideRange;
    }
    
    public void onEdgeDragStarted(int param1Int1, int param1Int2) {
      SlidingPaneLayout.this.mDragHelper.captureChildView(SlidingPaneLayout.this.mSlideableView, param1Int2);
    }
    
    public void onViewCaptured(View param1View, int param1Int) {
      SlidingPaneLayout.this.setAllChildrenVisible();
    }
    
    public void onViewDragStateChanged(int param1Int) {
      if (SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0) {
        if (SlidingPaneLayout.this.mSlideOffset == 0.0F) {
          SlidingPaneLayout.this.updateObscuredViewsVisibility(SlidingPaneLayout.this.mSlideableView);
          SlidingPaneLayout.this.dispatchOnPanelClosed(SlidingPaneLayout.this.mSlideableView);
          SlidingPaneLayout.this.mPreservedOpenState = false;
          return;
        } 
      } else {
        return;
      } 
      SlidingPaneLayout.this.dispatchOnPanelOpened(SlidingPaneLayout.this.mSlideableView);
      SlidingPaneLayout.this.mPreservedOpenState = true;
    }
    
    public void onViewPositionChanged(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      SlidingPaneLayout.this.onPanelDragged(param1Int1);
      SlidingPaneLayout.this.invalidate();
    }
    
    public void onViewReleased(View param1View, float param1Float1, float param1Float2) {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
      //   4: checkcast android/support/v4/widget/SlidingPaneLayout$LayoutParams
      //   7: astore #4
      //   9: aload_0
      //   10: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   13: invokevirtual isLayoutRtlSupport : ()Z
      //   16: ifeq -> 135
      //   19: aload_0
      //   20: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   23: invokevirtual getPaddingRight : ()I
      //   26: istore #5
      //   28: aload #4
      //   30: getfield rightMargin : I
      //   33: iload #5
      //   35: iadd
      //   36: istore #6
      //   38: fload_2
      //   39: fconst_0
      //   40: fcmpg
      //   41: iflt -> 71
      //   44: iload #6
      //   46: istore #5
      //   48: fload_2
      //   49: fconst_0
      //   50: fcmpl
      //   51: ifne -> 83
      //   54: iload #6
      //   56: istore #5
      //   58: aload_0
      //   59: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   62: getfield mSlideOffset : F
      //   65: ldc 0.5
      //   67: fcmpl
      //   68: ifle -> 83
      //   71: iload #6
      //   73: aload_0
      //   74: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   77: getfield mSlideRange : I
      //   80: iadd
      //   81: istore #5
      //   83: aload_0
      //   84: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   87: getfield mSlideableView : Landroid/view/View;
      //   90: invokevirtual getWidth : ()I
      //   93: istore #6
      //   95: aload_0
      //   96: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   99: invokevirtual getWidth : ()I
      //   102: iload #5
      //   104: isub
      //   105: iload #6
      //   107: isub
      //   108: istore #5
      //   110: aload_0
      //   111: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   114: getfield mDragHelper : Landroid/support/v4/widget/ViewDragHelper;
      //   117: iload #5
      //   119: aload_1
      //   120: invokevirtual getTop : ()I
      //   123: invokevirtual settleCapturedViewAt : (II)Z
      //   126: pop
      //   127: aload_0
      //   128: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   131: invokevirtual invalidate : ()V
      //   134: return
      //   135: aload_0
      //   136: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   139: invokevirtual getPaddingLeft : ()I
      //   142: istore #5
      //   144: aload #4
      //   146: getfield leftMargin : I
      //   149: iload #5
      //   151: iadd
      //   152: istore #6
      //   154: fload_2
      //   155: fconst_0
      //   156: fcmpl
      //   157: ifgt -> 187
      //   160: iload #6
      //   162: istore #5
      //   164: fload_2
      //   165: fconst_0
      //   166: fcmpl
      //   167: ifne -> 110
      //   170: iload #6
      //   172: istore #5
      //   174: aload_0
      //   175: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   178: getfield mSlideOffset : F
      //   181: ldc 0.5
      //   183: fcmpl
      //   184: ifle -> 110
      //   187: iload #6
      //   189: aload_0
      //   190: getfield this$0 : Landroid/support/v4/widget/SlidingPaneLayout;
      //   193: getfield mSlideRange : I
      //   196: iadd
      //   197: istore #5
      //   199: goto -> 110
    }
    
    public boolean tryCaptureView(View param1View, int param1Int) {
      return SlidingPaneLayout.this.mIsUnableToDrag ? false : ((SlidingPaneLayout.LayoutParams)param1View.getLayoutParams()).slideable;
    }
  }
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    private static final int[] ATTRS = new int[] { 16843137 };
    
    Paint dimPaint;
    
    boolean dimWhenOffset;
    
    boolean slideable;
    
    public float weight = 0.0F;
    
    public LayoutParams() {
      super(-1, -1);
    }
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, ATTRS);
      this.weight = typedArray.getFloat(0, 0.0F);
      typedArray.recycle();
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
      this.weight = param1LayoutParams.weight;
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      super(param1MarginLayoutParams);
    }
  }
  
  public static interface PanelSlideListener {
    void onPanelClosed(View param1View);
    
    void onPanelOpened(View param1View);
    
    void onPanelSlide(View param1View, float param1Float);
  }
  
  static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
          public SlidingPaneLayout.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
            return new SlidingPaneLayout.SavedState(param2Parcel, param2ClassLoader);
          }
          
          public SlidingPaneLayout.SavedState[] newArray(int param2Int) {
            return new SlidingPaneLayout.SavedState[param2Int];
          }
        });
    
    boolean isOpen;
    
    SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      boolean bool;
      if (param1Parcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.isOpen = bool;
    }
    
    SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      if (this.isOpen) {
        param1Int = 1;
      } else {
        param1Int = 0;
      } 
      param1Parcel.writeInt(param1Int);
    }
  }
  
  static final class null implements ParcelableCompatCreatorCallbacks<SavedState> {
    public SlidingPaneLayout.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new SlidingPaneLayout.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public SlidingPaneLayout.SavedState[] newArray(int param1Int) {
      return new SlidingPaneLayout.SavedState[param1Int];
    }
  }
  
  public static class SimplePanelSlideListener implements PanelSlideListener {
    public void onPanelClosed(View param1View) {}
    
    public void onPanelOpened(View param1View) {}
    
    public void onPanelSlide(View param1View, float param1Float) {}
  }
  
  static interface SlidingPanelLayoutImpl {
    void invalidateChildRegion(SlidingPaneLayout param1SlidingPaneLayout, View param1View);
  }
  
  static class SlidingPanelLayoutImplBase implements SlidingPanelLayoutImpl {
    public void invalidateChildRegion(SlidingPaneLayout param1SlidingPaneLayout, View param1View) {
      ViewCompat.postInvalidateOnAnimation((View)param1SlidingPaneLayout, param1View.getLeft(), param1View.getTop(), param1View.getRight(), param1View.getBottom());
    }
  }
  
  static class SlidingPanelLayoutImplJB extends SlidingPanelLayoutImplBase {
    private Method mGetDisplayList;
    
    private Field mRecreateDisplayList;
    
    SlidingPanelLayoutImplJB() {
      try {
        this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", (Class[])null);
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", noSuchMethodException);
      } 
      try {
        this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
        this.mRecreateDisplayList.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", noSuchFieldException);
      } 
    }
    
    public void invalidateChildRegion(SlidingPaneLayout param1SlidingPaneLayout, View param1View) {
      if (this.mGetDisplayList != null && this.mRecreateDisplayList != null) {
        try {
          this.mRecreateDisplayList.setBoolean(param1View, true);
          this.mGetDisplayList.invoke(param1View, (Object[])null);
        } catch (Exception exception) {
          Log.e("SlidingPaneLayout", "Error refreshing display list state", exception);
        } 
        super.invalidateChildRegion(param1SlidingPaneLayout, param1View);
        return;
      } 
      param1View.invalidate();
    }
  }
  
  static class SlidingPanelLayoutImplJBMR1 extends SlidingPanelLayoutImplBase {
    public void invalidateChildRegion(SlidingPaneLayout param1SlidingPaneLayout, View param1View) {
      ViewCompat.setLayerPaint(param1View, ((SlidingPaneLayout.LayoutParams)param1View.getLayoutParams()).dimPaint);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\widget\SlidingPaneLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */