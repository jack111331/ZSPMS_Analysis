package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup implements DrawerLayoutImpl {
  private static final boolean ALLOW_EDGE_LOCK = false;
  
  static final boolean CAN_HIDE_DESCENDANTS;
  
  private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
  
  private static final int DEFAULT_SCRIM_COLOR = -1728053248;
  
  private static final int DRAWER_ELEVATION = 10;
  
  static final DrawerLayoutCompatImpl IMPL;
  
  static final int[] LAYOUT_ATTRS = new int[] { 16842931 };
  
  public static final int LOCK_MODE_LOCKED_CLOSED = 1;
  
  public static final int LOCK_MODE_LOCKED_OPEN = 2;
  
  public static final int LOCK_MODE_UNDEFINED = 3;
  
  public static final int LOCK_MODE_UNLOCKED = 0;
  
  private static final int MIN_DRAWER_MARGIN = 64;
  
  private static final int MIN_FLING_VELOCITY = 400;
  
  private static final int PEEK_DELAY = 160;
  
  private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION;
  
  public static final int STATE_DRAGGING = 1;
  
  public static final int STATE_IDLE = 0;
  
  public static final int STATE_SETTLING = 2;
  
  private static final String TAG = "DrawerLayout";
  
  private static final float TOUCH_SLOP_SENSITIVITY = 1.0F;
  
  private final ChildAccessibilityDelegate mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
  
  private boolean mChildrenCanceledTouch;
  
  private boolean mDisallowInterceptRequested;
  
  private boolean mDrawStatusBarBackground;
  
  private float mDrawerElevation;
  
  private int mDrawerState;
  
  private boolean mFirstLayout = true;
  
  private boolean mInLayout;
  
  private float mInitialMotionX;
  
  private float mInitialMotionY;
  
  private Object mLastInsets;
  
  private final ViewDragCallback mLeftCallback;
  
  private final ViewDragHelper mLeftDragger;
  
  @Nullable
  private DrawerListener mListener;
  
  private List<DrawerListener> mListeners;
  
  private int mLockModeEnd = 3;
  
  private int mLockModeLeft = 3;
  
  private int mLockModeRight = 3;
  
  private int mLockModeStart = 3;
  
  private int mMinDrawerMargin;
  
  private final ArrayList<View> mNonDrawerViews;
  
  private final ViewDragCallback mRightCallback;
  
  private final ViewDragHelper mRightDragger;
  
  private int mScrimColor = -1728053248;
  
  private float mScrimOpacity;
  
  private Paint mScrimPaint = new Paint();
  
  private Drawable mShadowEnd = null;
  
  private Drawable mShadowLeft = null;
  
  private Drawable mShadowLeftResolved;
  
  private Drawable mShadowRight = null;
  
  private Drawable mShadowRightResolved;
  
  private Drawable mShadowStart = null;
  
  private Drawable mStatusBarBackground;
  
  private CharSequence mTitleLeft;
  
  private CharSequence mTitleRight;
  
  static {
    if (Build.VERSION.SDK_INT >= 19) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    CAN_HIDE_DESCENDANTS = bool2;
    boolean bool2 = bool1;
    if (Build.VERSION.SDK_INT >= 21)
      bool2 = true; 
    SET_DRAWER_SHADOW_FROM_ELEVATION = bool2;
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL = new DrawerLayoutCompatImplApi21();
      return;
    } 
    IMPL = new DrawerLayoutCompatImplBase();
  }
  
  public DrawerLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f1 = (getResources().getDisplayMetrics()).density;
    this.mMinDrawerMargin = (int)(0.5F + 64.0F * f1);
    float f2 = 400.0F * f1;
    this.mLeftCallback = new ViewDragCallback(3);
    this.mRightCallback = new ViewDragCallback(5);
    this.mLeftDragger = ViewDragHelper.create(this, 1.0F, this.mLeftCallback);
    this.mLeftDragger.setEdgeTrackingEnabled(1);
    this.mLeftDragger.setMinVelocity(f2);
    this.mLeftCallback.setDragger(this.mLeftDragger);
    this.mRightDragger = ViewDragHelper.create(this, 1.0F, this.mRightCallback);
    this.mRightDragger.setEdgeTrackingEnabled(2);
    this.mRightDragger.setMinVelocity(f2);
    this.mRightCallback.setDragger(this.mRightDragger);
    setFocusableInTouchMode(true);
    ViewCompat.setImportantForAccessibility((View)this, 1);
    ViewCompat.setAccessibilityDelegate((View)this, new AccessibilityDelegate());
    ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
    if (ViewCompat.getFitsSystemWindows((View)this)) {
      IMPL.configureApplyInsets((View)this);
      this.mStatusBarBackground = IMPL.getDefaultStatusBarBackground(paramContext);
    } 
    this.mDrawerElevation = f1 * 10.0F;
    this.mNonDrawerViews = new ArrayList<View>();
  }
  
  static String gravityToString(int paramInt) {
    return ((paramInt & 0x3) == 3) ? "LEFT" : (((paramInt & 0x5) == 5) ? "RIGHT" : Integer.toHexString(paramInt));
  }
  
  private static boolean hasOpaqueBackground(View paramView) {
    boolean bool1 = false;
    Drawable drawable = paramView.getBackground();
    boolean bool2 = bool1;
    if (drawable != null) {
      bool2 = bool1;
      if (drawable.getOpacity() == -1)
        bool2 = true; 
    } 
    return bool2;
  }
  
  private boolean hasPeekingDrawer() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getChildCount : ()I
    //   4: istore_1
    //   5: iconst_0
    //   6: istore_2
    //   7: iload_2
    //   8: iload_1
    //   9: if_icmpge -> 39
    //   12: aload_0
    //   13: iload_2
    //   14: invokevirtual getChildAt : (I)Landroid/view/View;
    //   17: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   20: checkcast android/support/v4/widget/DrawerLayout$LayoutParams
    //   23: getfield isPeeking : Z
    //   26: ifeq -> 33
    //   29: iconst_1
    //   30: istore_3
    //   31: iload_3
    //   32: ireturn
    //   33: iinc #2, 1
    //   36: goto -> 7
    //   39: iconst_0
    //   40: istore_3
    //   41: goto -> 31
  }
  
  private boolean hasVisibleDrawer() {
    return (findVisibleDrawer() != null);
  }
  
  static boolean includeChildForAccessibility(View paramView) {
    return (ViewCompat.getImportantForAccessibility(paramView) != 4 && ViewCompat.getImportantForAccessibility(paramView) != 2);
  }
  
  private boolean mirror(Drawable paramDrawable, int paramInt) {
    if (paramDrawable == null || !DrawableCompat.isAutoMirrored(paramDrawable))
      return false; 
    DrawableCompat.setLayoutDirection(paramDrawable, paramInt);
    return true;
  }
  
  private Drawable resolveLeftShadow() {
    int i = ViewCompat.getLayoutDirection((View)this);
    if (i == 0) {
      if (this.mShadowStart != null) {
        mirror(this.mShadowStart, i);
        return this.mShadowStart;
      } 
    } else if (this.mShadowEnd != null) {
      mirror(this.mShadowEnd, i);
      return this.mShadowEnd;
    } 
    return this.mShadowLeft;
  }
  
  private Drawable resolveRightShadow() {
    int i = ViewCompat.getLayoutDirection((View)this);
    if (i == 0) {
      if (this.mShadowEnd != null) {
        mirror(this.mShadowEnd, i);
        return this.mShadowEnd;
      } 
    } else if (this.mShadowStart != null) {
      mirror(this.mShadowStart, i);
      return this.mShadowStart;
    } 
    return this.mShadowRight;
  }
  
  private void resolveShadowDrawables() {
    if (!SET_DRAWER_SHADOW_FROM_ELEVATION) {
      this.mShadowLeftResolved = resolveLeftShadow();
      this.mShadowRightResolved = resolveRightShadow();
    } 
  }
  
  private void updateChildrenImportantForAccessibility(View paramView, boolean paramBoolean) {
    int i = getChildCount();
    for (byte b = 0; b < i; b++) {
      View view = getChildAt(b);
      if ((!paramBoolean && !isDrawerView(view)) || (paramBoolean && view == paramView)) {
        ViewCompat.setImportantForAccessibility(view, 1);
      } else {
        ViewCompat.setImportantForAccessibility(view, 4);
      } 
    } 
  }
  
  public void addDrawerListener(@NonNull DrawerListener paramDrawerListener) {
    if (paramDrawerListener != null) {
      if (this.mListeners == null)
        this.mListeners = new ArrayList<DrawerListener>(); 
      this.mListeners.add(paramDrawerListener);
    } 
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2) {
    boolean bool = false;
    if (getDescendantFocusability() != 393216) {
      int i = getChildCount();
      int j = 0;
      byte b;
      for (b = 0; b < i; b++) {
        View view = getChildAt(b);
        if (isDrawerView(view)) {
          if (isDrawerOpen(view)) {
            j = 1;
            view.addFocusables(paramArrayList, paramInt1, paramInt2);
          } 
        } else {
          this.mNonDrawerViews.add(view);
        } 
      } 
      if (!j) {
        j = this.mNonDrawerViews.size();
        for (b = bool; b < j; b++) {
          View view = this.mNonDrawerViews.get(b);
          if (view.getVisibility() == 0)
            view.addFocusables(paramArrayList, paramInt1, paramInt2); 
        } 
      } 
      this.mNonDrawerViews.clear();
    } 
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (findOpenDrawer() != null || isDrawerView(paramView)) {
      ViewCompat.setImportantForAccessibility(paramView, 4);
    } else {
      ViewCompat.setImportantForAccessibility(paramView, 1);
    } 
    if (!CAN_HIDE_DESCENDANTS)
      ViewCompat.setAccessibilityDelegate(paramView, this.mChildAccessibilityDelegate); 
  }
  
  void cancelChildViewTouch() {
    byte b = 0;
    if (!this.mChildrenCanceledTouch) {
      long l = SystemClock.uptimeMillis();
      MotionEvent motionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      int i = getChildCount();
      while (b < i) {
        getChildAt(b).dispatchTouchEvent(motionEvent);
        b++;
      } 
      motionEvent.recycle();
      this.mChildrenCanceledTouch = true;
    } 
  }
  
  boolean checkDrawerViewAbsoluteGravity(View paramView, int paramInt) {
    return ((getDrawerViewAbsoluteGravity(paramView) & paramInt) == paramInt);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof LayoutParams && super.checkLayoutParams(paramLayoutParams));
  }
  
  public void closeDrawer(int paramInt) {
    closeDrawer(paramInt, true);
  }
  
  public void closeDrawer(int paramInt, boolean paramBoolean) {
    View view = findDrawerWithGravity(paramInt);
    if (view == null)
      throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(paramInt)); 
    closeDrawer(view, paramBoolean);
  }
  
  public void closeDrawer(View paramView) {
    closeDrawer(paramView, true);
  }
  
  public void closeDrawer(View paramView, boolean paramBoolean) {
    if (!isDrawerView(paramView))
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer"); 
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if (this.mFirstLayout) {
      layoutParams.onScreen = 0.0F;
      layoutParams.openState = 0;
    } else if (paramBoolean) {
      layoutParams.openState |= 0x4;
      if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
        this.mLeftDragger.smoothSlideViewTo(paramView, -paramView.getWidth(), paramView.getTop());
      } else {
        this.mRightDragger.smoothSlideViewTo(paramView, getWidth(), paramView.getTop());
      } 
    } else {
      moveDrawerToOffset(paramView, 0.0F);
      updateDrawerState(layoutParams.gravity, 0, paramView);
      paramView.setVisibility(4);
    } 
    invalidate();
  }
  
  public void closeDrawers() {
    closeDrawers(false);
  }
  
  void closeDrawers(boolean paramBoolean) {
    int i = getChildCount();
    boolean bool = false;
    for (byte b = 0; b < i; b++) {
      View view = getChildAt(b);
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      if (isDrawerView(view) && (!paramBoolean || layoutParams.isPeeking)) {
        int j = view.getWidth();
        if (checkDrawerViewAbsoluteGravity(view, 3)) {
          bool |= this.mLeftDragger.smoothSlideViewTo(view, -j, view.getTop());
        } else {
          bool |= this.mRightDragger.smoothSlideViewTo(view, getWidth(), view.getTop());
        } 
        layoutParams.isPeeking = false;
      } 
    } 
    this.mLeftCallback.removeCallbacks();
    this.mRightCallback.removeCallbacks();
    if (bool)
      invalidate(); 
  }
  
  public void computeScroll() {
    int i = getChildCount();
    float f = 0.0F;
    for (byte b = 0; b < i; b++)
      f = Math.max(f, ((LayoutParams)getChildAt(b).getLayoutParams()).onScreen); 
    this.mScrimOpacity = f;
    if ((this.mLeftDragger.continueSettling(true) | this.mRightDragger.continueSettling(true)) != 0)
      ViewCompat.postInvalidateOnAnimation((View)this); 
  }
  
  void dispatchOnDrawerClosed(View paramView) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if ((layoutParams.openState & 0x1) == 1) {
      layoutParams.openState = 0;
      if (this.mListeners != null)
        for (int i = this.mListeners.size() - 1; i >= 0; i--)
          ((DrawerListener)this.mListeners.get(i)).onDrawerClosed(paramView);  
      updateChildrenImportantForAccessibility(paramView, false);
      if (hasWindowFocus()) {
        paramView = getRootView();
        if (paramView != null)
          paramView.sendAccessibilityEvent(32); 
      } 
    } 
  }
  
  void dispatchOnDrawerOpened(View paramView) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if ((layoutParams.openState & 0x1) == 0) {
      layoutParams.openState = 1;
      if (this.mListeners != null)
        for (int i = this.mListeners.size() - 1; i >= 0; i--)
          ((DrawerListener)this.mListeners.get(i)).onDrawerOpened(paramView);  
      updateChildrenImportantForAccessibility(paramView, true);
      if (hasWindowFocus())
        sendAccessibilityEvent(32); 
    } 
  }
  
  void dispatchOnDrawerSlide(View paramView, float paramFloat) {
    if (this.mListeners != null)
      for (int i = this.mListeners.size() - 1; i >= 0; i--)
        ((DrawerListener)this.mListeners.get(i)).onDrawerSlide(paramView, paramFloat);  
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getHeight : ()I
    //   4: istore #5
    //   6: aload_0
    //   7: aload_2
    //   8: invokevirtual isContentView : (Landroid/view/View;)Z
    //   11: istore #6
    //   13: aload_0
    //   14: invokevirtual getWidth : ()I
    //   17: istore #7
    //   19: aload_1
    //   20: invokevirtual save : ()I
    //   23: istore #8
    //   25: iconst_0
    //   26: istore #9
    //   28: iconst_0
    //   29: istore #10
    //   31: iload #7
    //   33: istore #11
    //   35: iload #6
    //   37: ifeq -> 221
    //   40: aload_0
    //   41: invokevirtual getChildCount : ()I
    //   44: istore #12
    //   46: iconst_0
    //   47: istore #13
    //   49: iload #10
    //   51: istore #11
    //   53: iload #13
    //   55: iload #12
    //   57: if_icmpge -> 199
    //   60: aload_0
    //   61: iload #13
    //   63: invokevirtual getChildAt : (I)Landroid/view/View;
    //   66: astore #14
    //   68: aload #14
    //   70: aload_2
    //   71: if_acmpeq -> 188
    //   74: aload #14
    //   76: invokevirtual getVisibility : ()I
    //   79: ifne -> 188
    //   82: aload #14
    //   84: invokestatic hasOpaqueBackground : (Landroid/view/View;)Z
    //   87: ifeq -> 188
    //   90: aload_0
    //   91: aload #14
    //   93: invokevirtual isDrawerView : (Landroid/view/View;)Z
    //   96: ifeq -> 188
    //   99: aload #14
    //   101: invokevirtual getHeight : ()I
    //   104: iload #5
    //   106: if_icmpge -> 131
    //   109: iload #11
    //   111: istore #9
    //   113: iload #7
    //   115: istore #10
    //   117: iinc #13, 1
    //   120: iload #9
    //   122: istore #11
    //   124: iload #10
    //   126: istore #7
    //   128: goto -> 53
    //   131: aload_0
    //   132: aload #14
    //   134: iconst_3
    //   135: invokevirtual checkDrawerViewAbsoluteGravity : (Landroid/view/View;I)Z
    //   138: ifeq -> 174
    //   141: aload #14
    //   143: invokevirtual getRight : ()I
    //   146: istore #15
    //   148: iload #7
    //   150: istore #10
    //   152: iload #15
    //   154: istore #9
    //   156: iload #15
    //   158: iload #11
    //   160: if_icmpgt -> 117
    //   163: iload #7
    //   165: istore #10
    //   167: iload #11
    //   169: istore #9
    //   171: goto -> 117
    //   174: aload #14
    //   176: invokevirtual getLeft : ()I
    //   179: istore #10
    //   181: iload #10
    //   183: iload #7
    //   185: if_icmplt -> 535
    //   188: iload #7
    //   190: istore #10
    //   192: iload #11
    //   194: istore #9
    //   196: goto -> 117
    //   199: aload_1
    //   200: iload #11
    //   202: iconst_0
    //   203: iload #7
    //   205: aload_0
    //   206: invokevirtual getHeight : ()I
    //   209: invokevirtual clipRect : (IIII)Z
    //   212: pop
    //   213: iload #11
    //   215: istore #9
    //   217: iload #7
    //   219: istore #11
    //   221: aload_0
    //   222: aload_1
    //   223: aload_2
    //   224: lload_3
    //   225: invokespecial drawChild : (Landroid/graphics/Canvas;Landroid/view/View;J)Z
    //   228: istore #16
    //   230: aload_1
    //   231: iload #8
    //   233: invokevirtual restoreToCount : (I)V
    //   236: aload_0
    //   237: getfield mScrimOpacity : F
    //   240: fconst_0
    //   241: fcmpl
    //   242: ifle -> 318
    //   245: iload #6
    //   247: ifeq -> 318
    //   250: ldc_w -16777216
    //   253: aload_0
    //   254: getfield mScrimColor : I
    //   257: iand
    //   258: bipush #24
    //   260: iushr
    //   261: i2f
    //   262: aload_0
    //   263: getfield mScrimOpacity : F
    //   266: fmul
    //   267: f2i
    //   268: istore #7
    //   270: aload_0
    //   271: getfield mScrimColor : I
    //   274: istore #13
    //   276: aload_0
    //   277: getfield mScrimPaint : Landroid/graphics/Paint;
    //   280: iload #7
    //   282: bipush #24
    //   284: ishl
    //   285: ldc_w 16777215
    //   288: iload #13
    //   290: iand
    //   291: ior
    //   292: invokevirtual setColor : (I)V
    //   295: aload_1
    //   296: iload #9
    //   298: i2f
    //   299: fconst_0
    //   300: iload #11
    //   302: i2f
    //   303: aload_0
    //   304: invokevirtual getHeight : ()I
    //   307: i2f
    //   308: aload_0
    //   309: getfield mScrimPaint : Landroid/graphics/Paint;
    //   312: invokevirtual drawRect : (FFFFLandroid/graphics/Paint;)V
    //   315: iload #16
    //   317: ireturn
    //   318: aload_0
    //   319: getfield mShadowLeftResolved : Landroid/graphics/drawable/Drawable;
    //   322: ifnull -> 422
    //   325: aload_0
    //   326: aload_2
    //   327: iconst_3
    //   328: invokevirtual checkDrawerViewAbsoluteGravity : (Landroid/view/View;I)Z
    //   331: ifeq -> 422
    //   334: aload_0
    //   335: getfield mShadowLeftResolved : Landroid/graphics/drawable/Drawable;
    //   338: invokevirtual getIntrinsicWidth : ()I
    //   341: istore #9
    //   343: aload_2
    //   344: invokevirtual getRight : ()I
    //   347: istore #7
    //   349: aload_0
    //   350: getfield mLeftDragger : Landroid/support/v4/widget/ViewDragHelper;
    //   353: invokevirtual getEdgeSize : ()I
    //   356: istore #11
    //   358: fconst_0
    //   359: iload #7
    //   361: i2f
    //   362: iload #11
    //   364: i2f
    //   365: fdiv
    //   366: fconst_1
    //   367: invokestatic min : (FF)F
    //   370: invokestatic max : (FF)F
    //   373: fstore #17
    //   375: aload_0
    //   376: getfield mShadowLeftResolved : Landroid/graphics/drawable/Drawable;
    //   379: iload #7
    //   381: aload_2
    //   382: invokevirtual getTop : ()I
    //   385: iload #9
    //   387: iload #7
    //   389: iadd
    //   390: aload_2
    //   391: invokevirtual getBottom : ()I
    //   394: invokevirtual setBounds : (IIII)V
    //   397: aload_0
    //   398: getfield mShadowLeftResolved : Landroid/graphics/drawable/Drawable;
    //   401: ldc_w 255.0
    //   404: fload #17
    //   406: fmul
    //   407: f2i
    //   408: invokevirtual setAlpha : (I)V
    //   411: aload_0
    //   412: getfield mShadowLeftResolved : Landroid/graphics/drawable/Drawable;
    //   415: aload_1
    //   416: invokevirtual draw : (Landroid/graphics/Canvas;)V
    //   419: goto -> 315
    //   422: aload_0
    //   423: getfield mShadowRightResolved : Landroid/graphics/drawable/Drawable;
    //   426: ifnull -> 315
    //   429: aload_0
    //   430: aload_2
    //   431: iconst_5
    //   432: invokevirtual checkDrawerViewAbsoluteGravity : (Landroid/view/View;I)Z
    //   435: ifeq -> 315
    //   438: aload_0
    //   439: getfield mShadowRightResolved : Landroid/graphics/drawable/Drawable;
    //   442: invokevirtual getIntrinsicWidth : ()I
    //   445: istore #11
    //   447: aload_2
    //   448: invokevirtual getLeft : ()I
    //   451: istore #7
    //   453: aload_0
    //   454: invokevirtual getWidth : ()I
    //   457: istore #9
    //   459: aload_0
    //   460: getfield mRightDragger : Landroid/support/v4/widget/ViewDragHelper;
    //   463: invokevirtual getEdgeSize : ()I
    //   466: istore #13
    //   468: fconst_0
    //   469: iload #9
    //   471: iload #7
    //   473: isub
    //   474: i2f
    //   475: iload #13
    //   477: i2f
    //   478: fdiv
    //   479: fconst_1
    //   480: invokestatic min : (FF)F
    //   483: invokestatic max : (FF)F
    //   486: fstore #17
    //   488: aload_0
    //   489: getfield mShadowRightResolved : Landroid/graphics/drawable/Drawable;
    //   492: iload #7
    //   494: iload #11
    //   496: isub
    //   497: aload_2
    //   498: invokevirtual getTop : ()I
    //   501: iload #7
    //   503: aload_2
    //   504: invokevirtual getBottom : ()I
    //   507: invokevirtual setBounds : (IIII)V
    //   510: aload_0
    //   511: getfield mShadowRightResolved : Landroid/graphics/drawable/Drawable;
    //   514: ldc_w 255.0
    //   517: fload #17
    //   519: fmul
    //   520: f2i
    //   521: invokevirtual setAlpha : (I)V
    //   524: aload_0
    //   525: getfield mShadowRightResolved : Landroid/graphics/drawable/Drawable;
    //   528: aload_1
    //   529: invokevirtual draw : (Landroid/graphics/Canvas;)V
    //   532: goto -> 315
    //   535: iload #11
    //   537: istore #9
    //   539: goto -> 117
  }
  
  View findDrawerWithGravity(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: aload_0
    //   2: invokestatic getLayoutDirection : (Landroid/view/View;)I
    //   5: invokestatic getAbsoluteGravity : (II)I
    //   8: istore_2
    //   9: aload_0
    //   10: invokevirtual getChildCount : ()I
    //   13: istore_3
    //   14: iconst_0
    //   15: istore_1
    //   16: iload_1
    //   17: iload_3
    //   18: if_icmpge -> 53
    //   21: aload_0
    //   22: iload_1
    //   23: invokevirtual getChildAt : (I)Landroid/view/View;
    //   26: astore #4
    //   28: aload_0
    //   29: aload #4
    //   31: invokevirtual getDrawerViewAbsoluteGravity : (Landroid/view/View;)I
    //   34: bipush #7
    //   36: iand
    //   37: iload_2
    //   38: bipush #7
    //   40: iand
    //   41: if_icmpne -> 47
    //   44: aload #4
    //   46: areturn
    //   47: iinc #1, 1
    //   50: goto -> 16
    //   53: aconst_null
    //   54: astore #4
    //   56: goto -> 44
  }
  
  View findOpenDrawer() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getChildCount : ()I
    //   4: istore_1
    //   5: iconst_0
    //   6: istore_2
    //   7: iload_2
    //   8: iload_1
    //   9: if_icmpge -> 42
    //   12: aload_0
    //   13: iload_2
    //   14: invokevirtual getChildAt : (I)Landroid/view/View;
    //   17: astore_3
    //   18: aload_3
    //   19: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   22: checkcast android/support/v4/widget/DrawerLayout$LayoutParams
    //   25: getfield openState : I
    //   28: iconst_1
    //   29: iand
    //   30: iconst_1
    //   31: if_icmpne -> 36
    //   34: aload_3
    //   35: areturn
    //   36: iinc #2, 1
    //   39: goto -> 7
    //   42: aconst_null
    //   43: astore_3
    //   44: goto -> 34
  }
  
  View findVisibleDrawer() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getChildCount : ()I
    //   4: istore_1
    //   5: iconst_0
    //   6: istore_2
    //   7: iload_2
    //   8: iload_1
    //   9: if_icmpge -> 42
    //   12: aload_0
    //   13: iload_2
    //   14: invokevirtual getChildAt : (I)Landroid/view/View;
    //   17: astore_3
    //   18: aload_0
    //   19: aload_3
    //   20: invokevirtual isDrawerView : (Landroid/view/View;)Z
    //   23: ifeq -> 36
    //   26: aload_0
    //   27: aload_3
    //   28: invokevirtual isDrawerVisible : (Landroid/view/View;)Z
    //   31: ifeq -> 36
    //   34: aload_3
    //   35: areturn
    //   36: iinc #2, 1
    //   39: goto -> 7
    //   42: aconst_null
    //   43: astore_3
    //   44: goto -> 34
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
    return (ViewGroup.LayoutParams)new LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return (ViewGroup.LayoutParams)new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (ViewGroup.LayoutParams)((paramLayoutParams instanceof LayoutParams) ? new LayoutParams((LayoutParams)paramLayoutParams) : ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams) : new LayoutParams(paramLayoutParams)));
  }
  
  public float getDrawerElevation() {
    return SET_DRAWER_SHADOW_FROM_ELEVATION ? this.mDrawerElevation : 0.0F;
  }
  
  public int getDrawerLockMode(int paramInt) {
    int i = ViewCompat.getLayoutDirection((View)this);
    switch (paramInt) {
      default:
        return 0;
      case 3:
        if (this.mLockModeLeft != 3)
          return this.mLockModeLeft; 
        if (i == 0) {
          paramInt = this.mLockModeStart;
        } else {
          paramInt = this.mLockModeEnd;
        } 
        if (paramInt != 3)
          return paramInt; 
      case 5:
        if (this.mLockModeRight != 3)
          return this.mLockModeRight; 
        if (i == 0) {
          paramInt = this.mLockModeEnd;
        } else {
          paramInt = this.mLockModeStart;
        } 
        if (paramInt != 3)
          return paramInt; 
      case 8388611:
        if (this.mLockModeStart != 3)
          return this.mLockModeStart; 
        if (i == 0) {
          paramInt = this.mLockModeLeft;
        } else {
          paramInt = this.mLockModeRight;
        } 
        if (paramInt != 3)
          return paramInt; 
      case 8388613:
        break;
    } 
    if (this.mLockModeEnd != 3)
      return this.mLockModeEnd; 
    if (i == 0) {
      paramInt = this.mLockModeRight;
    } else {
      paramInt = this.mLockModeLeft;
    } 
    if (paramInt != 3)
      return paramInt; 
  }
  
  public int getDrawerLockMode(View paramView) {
    if (!isDrawerView(paramView))
      throw new IllegalArgumentException("View " + paramView + " is not a drawer"); 
    return getDrawerLockMode(((LayoutParams)paramView.getLayoutParams()).gravity);
  }
  
  @Nullable
  public CharSequence getDrawerTitle(int paramInt) {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection((View)this));
    return (paramInt == 3) ? this.mTitleLeft : ((paramInt == 5) ? this.mTitleRight : null);
  }
  
  int getDrawerViewAbsoluteGravity(View paramView) {
    return GravityCompat.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection((View)this));
  }
  
  float getDrawerViewOffset(View paramView) {
    return ((LayoutParams)paramView.getLayoutParams()).onScreen;
  }
  
  public Drawable getStatusBarBackgroundDrawable() {
    return this.mStatusBarBackground;
  }
  
  boolean isContentView(View paramView) {
    return (((LayoutParams)paramView.getLayoutParams()).gravity == 0);
  }
  
  public boolean isDrawerOpen(int paramInt) {
    View view = findDrawerWithGravity(paramInt);
    return (view != null) ? isDrawerOpen(view) : false;
  }
  
  public boolean isDrawerOpen(View paramView) {
    if (!isDrawerView(paramView))
      throw new IllegalArgumentException("View " + paramView + " is not a drawer"); 
    return ((((LayoutParams)paramView.getLayoutParams()).openState & 0x1) == 1);
  }
  
  boolean isDrawerView(View paramView) {
    int i = GravityCompat.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(paramView));
    return ((i & 0x3) != 0) ? true : (((i & 0x5) != 0));
  }
  
  public boolean isDrawerVisible(int paramInt) {
    View view = findDrawerWithGravity(paramInt);
    return (view != null) ? isDrawerVisible(view) : false;
  }
  
  public boolean isDrawerVisible(View paramView) {
    if (!isDrawerView(paramView))
      throw new IllegalArgumentException("View " + paramView + " is not a drawer"); 
    return (((LayoutParams)paramView.getLayoutParams()).onScreen > 0.0F);
  }
  
  void moveDrawerToOffset(View paramView, float paramFloat) {
    float f = getDrawerViewOffset(paramView);
    int i = paramView.getWidth();
    int j = (int)(f * i);
    j = (int)(i * paramFloat) - j;
    if (!checkDrawerViewAbsoluteGravity(paramView, 3))
      j = -j; 
    paramView.offsetLeftAndRight(j);
    setDrawerViewOffset(paramView, paramFloat);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
  }
  
  public void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
      int i = IMPL.getTopInset(this.mLastInsets);
      if (i > 0) {
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), i);
        this.mStatusBarBackground.draw(paramCanvas);
      } 
    } 
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: invokestatic getActionMasked : (Landroid/view/MotionEvent;)I
    //   6: istore_3
    //   7: aload_0
    //   8: getfield mLeftDragger : Landroid/support/v4/widget/ViewDragHelper;
    //   11: aload_1
    //   12: invokevirtual shouldInterceptTouchEvent : (Landroid/view/MotionEvent;)Z
    //   15: istore #4
    //   17: aload_0
    //   18: getfield mRightDragger : Landroid/support/v4/widget/ViewDragHelper;
    //   21: aload_1
    //   22: invokevirtual shouldInterceptTouchEvent : (Landroid/view/MotionEvent;)Z
    //   25: istore #5
    //   27: iload_3
    //   28: tableswitch default -> 60, 0 -> 92, 1 -> 196, 2 -> 166, 3 -> 196
    //   60: iconst_0
    //   61: istore_3
    //   62: iload #4
    //   64: iload #5
    //   66: ior
    //   67: ifne -> 88
    //   70: iload_3
    //   71: ifne -> 88
    //   74: aload_0
    //   75: invokespecial hasPeekingDrawer : ()Z
    //   78: ifne -> 88
    //   81: aload_0
    //   82: getfield mChildrenCanceledTouch : Z
    //   85: ifeq -> 90
    //   88: iconst_1
    //   89: istore_2
    //   90: iload_2
    //   91: ireturn
    //   92: aload_1
    //   93: invokevirtual getX : ()F
    //   96: fstore #6
    //   98: aload_1
    //   99: invokevirtual getY : ()F
    //   102: fstore #7
    //   104: aload_0
    //   105: fload #6
    //   107: putfield mInitialMotionX : F
    //   110: aload_0
    //   111: fload #7
    //   113: putfield mInitialMotionY : F
    //   116: aload_0
    //   117: getfield mScrimOpacity : F
    //   120: fconst_0
    //   121: fcmpl
    //   122: ifle -> 214
    //   125: aload_0
    //   126: getfield mLeftDragger : Landroid/support/v4/widget/ViewDragHelper;
    //   129: fload #6
    //   131: f2i
    //   132: fload #7
    //   134: f2i
    //   135: invokevirtual findTopChildUnder : (II)Landroid/view/View;
    //   138: astore_1
    //   139: aload_1
    //   140: ifnull -> 214
    //   143: aload_0
    //   144: aload_1
    //   145: invokevirtual isContentView : (Landroid/view/View;)Z
    //   148: ifeq -> 214
    //   151: iconst_1
    //   152: istore_3
    //   153: aload_0
    //   154: iconst_0
    //   155: putfield mDisallowInterceptRequested : Z
    //   158: aload_0
    //   159: iconst_0
    //   160: putfield mChildrenCanceledTouch : Z
    //   163: goto -> 62
    //   166: aload_0
    //   167: getfield mLeftDragger : Landroid/support/v4/widget/ViewDragHelper;
    //   170: iconst_3
    //   171: invokevirtual checkTouchSlop : (I)Z
    //   174: ifeq -> 60
    //   177: aload_0
    //   178: getfield mLeftCallback : Landroid/support/v4/widget/DrawerLayout$ViewDragCallback;
    //   181: invokevirtual removeCallbacks : ()V
    //   184: aload_0
    //   185: getfield mRightCallback : Landroid/support/v4/widget/DrawerLayout$ViewDragCallback;
    //   188: invokevirtual removeCallbacks : ()V
    //   191: iconst_0
    //   192: istore_3
    //   193: goto -> 62
    //   196: aload_0
    //   197: iconst_1
    //   198: invokevirtual closeDrawers : (Z)V
    //   201: aload_0
    //   202: iconst_0
    //   203: putfield mDisallowInterceptRequested : Z
    //   206: aload_0
    //   207: iconst_0
    //   208: putfield mChildrenCanceledTouch : Z
    //   211: goto -> 60
    //   214: iconst_0
    //   215: istore_3
    //   216: goto -> 153
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 && hasVisibleDrawer()) {
      paramKeyEvent.startTracking();
      return true;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    View view;
    if (paramInt == 4) {
      view = findVisibleDrawer();
      if (view != null && getDrawerLockMode(view) == 0)
        closeDrawers(); 
      return (view != null);
    } 
    return super.onKeyUp(paramInt, (KeyEvent)view);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield mInLayout : Z
    //   5: iload #4
    //   7: iload_2
    //   8: isub
    //   9: istore #6
    //   11: aload_0
    //   12: invokevirtual getChildCount : ()I
    //   15: istore #7
    //   17: iconst_0
    //   18: istore #4
    //   20: iload #4
    //   22: iload #7
    //   24: if_icmpge -> 446
    //   27: aload_0
    //   28: iload #4
    //   30: invokevirtual getChildAt : (I)Landroid/view/View;
    //   33: astore #8
    //   35: aload #8
    //   37: invokevirtual getVisibility : ()I
    //   40: bipush #8
    //   42: if_icmpne -> 51
    //   45: iinc #4, 1
    //   48: goto -> 20
    //   51: aload #8
    //   53: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   56: checkcast android/support/v4/widget/DrawerLayout$LayoutParams
    //   59: astore #9
    //   61: aload_0
    //   62: aload #8
    //   64: invokevirtual isContentView : (Landroid/view/View;)Z
    //   67: ifeq -> 110
    //   70: aload #8
    //   72: aload #9
    //   74: getfield leftMargin : I
    //   77: aload #9
    //   79: getfield topMargin : I
    //   82: aload #9
    //   84: getfield leftMargin : I
    //   87: aload #8
    //   89: invokevirtual getMeasuredWidth : ()I
    //   92: iadd
    //   93: aload #9
    //   95: getfield topMargin : I
    //   98: aload #8
    //   100: invokevirtual getMeasuredHeight : ()I
    //   103: iadd
    //   104: invokevirtual layout : (IIII)V
    //   107: goto -> 45
    //   110: aload #8
    //   112: invokevirtual getMeasuredWidth : ()I
    //   115: istore #10
    //   117: aload #8
    //   119: invokevirtual getMeasuredHeight : ()I
    //   122: istore #11
    //   124: aload_0
    //   125: aload #8
    //   127: iconst_3
    //   128: invokevirtual checkDrawerViewAbsoluteGravity : (Landroid/view/View;I)Z
    //   131: ifeq -> 280
    //   134: iload #10
    //   136: ineg
    //   137: istore_2
    //   138: iload #10
    //   140: i2f
    //   141: aload #9
    //   143: getfield onScreen : F
    //   146: fmul
    //   147: f2i
    //   148: iload_2
    //   149: iadd
    //   150: istore #12
    //   152: iload #10
    //   154: iload #12
    //   156: iadd
    //   157: i2f
    //   158: iload #10
    //   160: i2f
    //   161: fdiv
    //   162: fstore #13
    //   164: fload #13
    //   166: aload #9
    //   168: getfield onScreen : F
    //   171: fcmpl
    //   172: ifeq -> 310
    //   175: iconst_1
    //   176: istore #14
    //   178: aload #9
    //   180: getfield gravity : I
    //   183: bipush #112
    //   185: iand
    //   186: lookupswitch default -> 212, 16 -> 356, 80 -> 316
    //   212: aload #8
    //   214: iload #12
    //   216: aload #9
    //   218: getfield topMargin : I
    //   221: iload #10
    //   223: iload #12
    //   225: iadd
    //   226: iload #11
    //   228: aload #9
    //   230: getfield topMargin : I
    //   233: iadd
    //   234: invokevirtual layout : (IIII)V
    //   237: iload #14
    //   239: ifeq -> 250
    //   242: aload_0
    //   243: aload #8
    //   245: fload #13
    //   247: invokevirtual setDrawerViewOffset : (Landroid/view/View;F)V
    //   250: aload #9
    //   252: getfield onScreen : F
    //   255: fconst_0
    //   256: fcmpl
    //   257: ifle -> 441
    //   260: iconst_0
    //   261: istore_2
    //   262: aload #8
    //   264: invokevirtual getVisibility : ()I
    //   267: iload_2
    //   268: if_icmpeq -> 45
    //   271: aload #8
    //   273: iload_2
    //   274: invokevirtual setVisibility : (I)V
    //   277: goto -> 45
    //   280: iload #6
    //   282: iload #10
    //   284: i2f
    //   285: aload #9
    //   287: getfield onScreen : F
    //   290: fmul
    //   291: f2i
    //   292: isub
    //   293: istore #12
    //   295: iload #6
    //   297: iload #12
    //   299: isub
    //   300: i2f
    //   301: iload #10
    //   303: i2f
    //   304: fdiv
    //   305: fstore #13
    //   307: goto -> 164
    //   310: iconst_0
    //   311: istore #14
    //   313: goto -> 178
    //   316: iload #5
    //   318: iload_3
    //   319: isub
    //   320: istore_2
    //   321: aload #8
    //   323: iload #12
    //   325: iload_2
    //   326: aload #9
    //   328: getfield bottomMargin : I
    //   331: isub
    //   332: aload #8
    //   334: invokevirtual getMeasuredHeight : ()I
    //   337: isub
    //   338: iload #10
    //   340: iload #12
    //   342: iadd
    //   343: iload_2
    //   344: aload #9
    //   346: getfield bottomMargin : I
    //   349: isub
    //   350: invokevirtual layout : (IIII)V
    //   353: goto -> 237
    //   356: iload #5
    //   358: iload_3
    //   359: isub
    //   360: istore #15
    //   362: iload #15
    //   364: iload #11
    //   366: isub
    //   367: iconst_2
    //   368: idiv
    //   369: istore #16
    //   371: iload #16
    //   373: aload #9
    //   375: getfield topMargin : I
    //   378: if_icmpge -> 407
    //   381: aload #9
    //   383: getfield topMargin : I
    //   386: istore_2
    //   387: aload #8
    //   389: iload #12
    //   391: iload_2
    //   392: iload #10
    //   394: iload #12
    //   396: iadd
    //   397: iload #11
    //   399: iload_2
    //   400: iadd
    //   401: invokevirtual layout : (IIII)V
    //   404: goto -> 237
    //   407: iload #16
    //   409: istore_2
    //   410: iload #16
    //   412: iload #11
    //   414: iadd
    //   415: iload #15
    //   417: aload #9
    //   419: getfield bottomMargin : I
    //   422: isub
    //   423: if_icmple -> 387
    //   426: iload #15
    //   428: aload #9
    //   430: getfield bottomMargin : I
    //   433: isub
    //   434: iload #11
    //   436: isub
    //   437: istore_2
    //   438: goto -> 387
    //   441: iconst_4
    //   442: istore_2
    //   443: goto -> 262
    //   446: aload_0
    //   447: iconst_0
    //   448: putfield mInLayout : Z
    //   451: aload_0
    //   452: iconst_0
    //   453: putfield mFirstLayout : Z
    //   456: return
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_1
    //   1: invokestatic getMode : (I)I
    //   4: istore_3
    //   5: iload_2
    //   6: invokestatic getMode : (I)I
    //   9: istore #4
    //   11: iload_1
    //   12: invokestatic getSize : (I)I
    //   15: istore #5
    //   17: iload_2
    //   18: invokestatic getSize : (I)I
    //   21: istore #6
    //   23: iload_3
    //   24: ldc_w 1073741824
    //   27: if_icmpne -> 42
    //   30: iload #5
    //   32: istore #7
    //   34: iload #4
    //   36: ldc_w 1073741824
    //   39: if_icmpeq -> 631
    //   42: aload_0
    //   43: invokevirtual isInEditMode : ()Z
    //   46: ifeq -> 208
    //   49: iload_3
    //   50: ldc_w -2147483648
    //   53: if_icmpne -> 175
    //   56: iload #4
    //   58: ldc_w -2147483648
    //   61: if_icmpne -> 187
    //   64: iload #5
    //   66: istore #4
    //   68: aload_0
    //   69: iload #4
    //   71: iload #6
    //   73: invokevirtual setMeasuredDimension : (II)V
    //   76: aload_0
    //   77: getfield mLastInsets : Ljava/lang/Object;
    //   80: ifnull -> 219
    //   83: aload_0
    //   84: invokestatic getFitsSystemWindows : (Landroid/view/View;)Z
    //   87: ifeq -> 219
    //   90: iconst_1
    //   91: istore_3
    //   92: aload_0
    //   93: invokestatic getLayoutDirection : (Landroid/view/View;)I
    //   96: istore #8
    //   98: iconst_0
    //   99: istore #5
    //   101: iconst_0
    //   102: istore #7
    //   104: aload_0
    //   105: invokevirtual getChildCount : ()I
    //   108: istore #9
    //   110: iconst_0
    //   111: istore #10
    //   113: iload #10
    //   115: iload #9
    //   117: if_icmpge -> 638
    //   120: aload_0
    //   121: iload #10
    //   123: invokevirtual getChildAt : (I)Landroid/view/View;
    //   126: astore #11
    //   128: aload #11
    //   130: invokevirtual getVisibility : ()I
    //   133: bipush #8
    //   135: if_icmpne -> 224
    //   138: iload #7
    //   140: istore #12
    //   142: iload #5
    //   144: istore #7
    //   146: iload #12
    //   148: istore #5
    //   150: iload #10
    //   152: iconst_1
    //   153: iadd
    //   154: istore #12
    //   156: iload #7
    //   158: istore #10
    //   160: iload #5
    //   162: istore #7
    //   164: iload #10
    //   166: istore #5
    //   168: iload #12
    //   170: istore #10
    //   172: goto -> 113
    //   175: iload_3
    //   176: ifne -> 56
    //   179: sipush #300
    //   182: istore #5
    //   184: goto -> 56
    //   187: iload #5
    //   189: istore #7
    //   191: iload #4
    //   193: ifne -> 631
    //   196: sipush #300
    //   199: istore #6
    //   201: iload #5
    //   203: istore #4
    //   205: goto -> 68
    //   208: new java/lang/IllegalArgumentException
    //   211: dup
    //   212: ldc_w 'DrawerLayout must be measured with MeasureSpec.EXACTLY.'
    //   215: invokespecial <init> : (Ljava/lang/String;)V
    //   218: athrow
    //   219: iconst_0
    //   220: istore_3
    //   221: goto -> 92
    //   224: aload #11
    //   226: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   229: checkcast android/support/v4/widget/DrawerLayout$LayoutParams
    //   232: astore #13
    //   234: iload_3
    //   235: ifeq -> 274
    //   238: aload #13
    //   240: getfield gravity : I
    //   243: iload #8
    //   245: invokestatic getAbsoluteGravity : (II)I
    //   248: istore #12
    //   250: aload #11
    //   252: invokestatic getFitsSystemWindows : (Landroid/view/View;)Z
    //   255: ifeq -> 343
    //   258: getstatic android/support/v4/widget/DrawerLayout.IMPL : Landroid/support/v4/widget/DrawerLayout$DrawerLayoutCompatImpl;
    //   261: aload #11
    //   263: aload_0
    //   264: getfield mLastInsets : Ljava/lang/Object;
    //   267: iload #12
    //   269: invokeinterface dispatchChildInsets : (Landroid/view/View;Ljava/lang/Object;I)V
    //   274: aload_0
    //   275: aload #11
    //   277: invokevirtual isContentView : (Landroid/view/View;)Z
    //   280: ifeq -> 362
    //   283: aload #11
    //   285: iload #4
    //   287: aload #13
    //   289: getfield leftMargin : I
    //   292: isub
    //   293: aload #13
    //   295: getfield rightMargin : I
    //   298: isub
    //   299: ldc_w 1073741824
    //   302: invokestatic makeMeasureSpec : (II)I
    //   305: iload #6
    //   307: aload #13
    //   309: getfield topMargin : I
    //   312: isub
    //   313: aload #13
    //   315: getfield bottomMargin : I
    //   318: isub
    //   319: ldc_w 1073741824
    //   322: invokestatic makeMeasureSpec : (II)I
    //   325: invokevirtual measure : (II)V
    //   328: iload #7
    //   330: istore #12
    //   332: iload #5
    //   334: istore #7
    //   336: iload #12
    //   338: istore #5
    //   340: goto -> 150
    //   343: getstatic android/support/v4/widget/DrawerLayout.IMPL : Landroid/support/v4/widget/DrawerLayout$DrawerLayoutCompatImpl;
    //   346: aload #13
    //   348: aload_0
    //   349: getfield mLastInsets : Ljava/lang/Object;
    //   352: iload #12
    //   354: invokeinterface applyMarginInsets : (Landroid/view/ViewGroup$MarginLayoutParams;Ljava/lang/Object;I)V
    //   359: goto -> 274
    //   362: aload_0
    //   363: aload #11
    //   365: invokevirtual isDrawerView : (Landroid/view/View;)Z
    //   368: ifeq -> 579
    //   371: getstatic android/support/v4/widget/DrawerLayout.SET_DRAWER_SHADOW_FROM_ELEVATION : Z
    //   374: ifeq -> 399
    //   377: aload #11
    //   379: invokestatic getElevation : (Landroid/view/View;)F
    //   382: aload_0
    //   383: getfield mDrawerElevation : F
    //   386: fcmpl
    //   387: ifeq -> 399
    //   390: aload #11
    //   392: aload_0
    //   393: getfield mDrawerElevation : F
    //   396: invokestatic setElevation : (Landroid/view/View;F)V
    //   399: aload_0
    //   400: aload #11
    //   402: invokevirtual getDrawerViewAbsoluteGravity : (Landroid/view/View;)I
    //   405: bipush #7
    //   407: iand
    //   408: istore #14
    //   410: iload #14
    //   412: iconst_3
    //   413: if_icmpne -> 494
    //   416: iconst_1
    //   417: istore #12
    //   419: iload #12
    //   421: ifeq -> 429
    //   424: iload #5
    //   426: ifne -> 439
    //   429: iload #12
    //   431: ifne -> 500
    //   434: iload #7
    //   436: ifeq -> 500
    //   439: new java/lang/IllegalStateException
    //   442: dup
    //   443: new java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial <init> : ()V
    //   450: ldc_w 'Child drawer has absolute gravity '
    //   453: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: iload #14
    //   458: invokestatic gravityToString : (I)Ljava/lang/String;
    //   461: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: ldc_w ' but this '
    //   467: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: ldc 'DrawerLayout'
    //   472: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: ldc_w ' already has a '
    //   478: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: ldc_w 'drawer view along that edge'
    //   484: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: invokevirtual toString : ()Ljava/lang/String;
    //   490: invokespecial <init> : (Ljava/lang/String;)V
    //   493: athrow
    //   494: iconst_0
    //   495: istore #12
    //   497: goto -> 419
    //   500: iload #12
    //   502: ifeq -> 573
    //   505: iconst_1
    //   506: istore #5
    //   508: aload #11
    //   510: iload_1
    //   511: aload_0
    //   512: getfield mMinDrawerMargin : I
    //   515: aload #13
    //   517: getfield leftMargin : I
    //   520: iadd
    //   521: aload #13
    //   523: getfield rightMargin : I
    //   526: iadd
    //   527: aload #13
    //   529: getfield width : I
    //   532: invokestatic getChildMeasureSpec : (III)I
    //   535: iload_2
    //   536: aload #13
    //   538: getfield topMargin : I
    //   541: aload #13
    //   543: getfield bottomMargin : I
    //   546: iadd
    //   547: aload #13
    //   549: getfield height : I
    //   552: invokestatic getChildMeasureSpec : (III)I
    //   555: invokevirtual measure : (II)V
    //   558: iload #5
    //   560: istore #12
    //   562: iload #7
    //   564: istore #5
    //   566: iload #12
    //   568: istore #7
    //   570: goto -> 150
    //   573: iconst_1
    //   574: istore #7
    //   576: goto -> 508
    //   579: new java/lang/IllegalStateException
    //   582: dup
    //   583: new java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial <init> : ()V
    //   590: ldc_w 'Child '
    //   593: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload #11
    //   598: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   601: ldc_w ' at index '
    //   604: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: iload #10
    //   609: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   612: ldc_w ' does not have a valid layout_gravity - must be Gravity.LEFT, '
    //   615: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: ldc_w 'Gravity.RIGHT or Gravity.NO_GRAVITY'
    //   621: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual toString : ()Ljava/lang/String;
    //   627: invokespecial <init> : (Ljava/lang/String;)V
    //   630: athrow
    //   631: iload #7
    //   633: istore #4
    //   635: goto -> 68
    //   638: return
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    if (savedState.openDrawerGravity != 0) {
      View view = findDrawerWithGravity(savedState.openDrawerGravity);
      if (view != null)
        openDrawer(view); 
    } 
    if (savedState.lockModeLeft != 3)
      setDrawerLockMode(savedState.lockModeLeft, 3); 
    if (savedState.lockModeRight != 3)
      setDrawerLockMode(savedState.lockModeRight, 5); 
    if (savedState.lockModeStart != 3)
      setDrawerLockMode(savedState.lockModeStart, 8388611); 
    if (savedState.lockModeEnd != 3)
      setDrawerLockMode(savedState.lockModeEnd, 8388613); 
  }
  
  public void onRtlPropertiesChanged(int paramInt) {
    resolveShadowDrawables();
  }
  
  protected Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    int i = getChildCount();
    for (byte b = 0;; b++) {
      if (b < i) {
        boolean bool1;
        boolean bool2;
        LayoutParams layoutParams = (LayoutParams)getChildAt(b).getLayoutParams();
        if (layoutParams.openState == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (layoutParams.openState == 2) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        if (bool1 || bool2) {
          savedState.openDrawerGravity = layoutParams.gravity;
          savedState.lockModeLeft = this.mLockModeLeft;
          savedState.lockModeRight = this.mLockModeRight;
          savedState.lockModeStart = this.mLockModeStart;
          savedState.lockModeEnd = this.mLockModeEnd;
          return (Parcelable)savedState;
        } 
      } else {
        savedState.lockModeLeft = this.mLockModeLeft;
        savedState.lockModeRight = this.mLockModeRight;
        savedState.lockModeStart = this.mLockModeStart;
        savedState.lockModeEnd = this.mLockModeEnd;
        return (Parcelable)savedState;
      } 
    } 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    View view;
    float f1;
    float f2;
    this.mLeftDragger.processTouchEvent(paramMotionEvent);
    this.mRightDragger.processTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF) {
      default:
        return true;
      case 0:
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.mInitialMotionX = f1;
        this.mInitialMotionY = f2;
        this.mDisallowInterceptRequested = false;
        this.mChildrenCanceledTouch = false;
      case 1:
        f2 = paramMotionEvent.getX();
        f1 = paramMotionEvent.getY();
        view = this.mLeftDragger.findTopChildUnder((int)f2, (int)f1);
        if (view != null && isContentView(view)) {
          f2 -= this.mInitialMotionX;
          f1 -= this.mInitialMotionY;
          int i = this.mLeftDragger.getTouchSlop();
          if (f2 * f2 + f1 * f1 < (i * i)) {
            view = findOpenDrawer();
            if (view != null) {
              if (getDrawerLockMode(view) == 2) {
                bool = true;
              } else {
                bool = false;
              } 
            } else {
              break;
            } 
          } else {
            break;
          } 
        } else {
          break;
        } 
        closeDrawers(bool);
        this.mDisallowInterceptRequested = false;
      case 3:
        closeDrawers(true);
        this.mDisallowInterceptRequested = false;
        this.mChildrenCanceledTouch = false;
    } 
    boolean bool = true;
    closeDrawers(bool);
    this.mDisallowInterceptRequested = false;
  }
  
  public void openDrawer(int paramInt) {
    openDrawer(paramInt, true);
  }
  
  public void openDrawer(int paramInt, boolean paramBoolean) {
    View view = findDrawerWithGravity(paramInt);
    if (view == null)
      throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(paramInt)); 
    openDrawer(view, paramBoolean);
  }
  
  public void openDrawer(View paramView) {
    openDrawer(paramView, true);
  }
  
  public void openDrawer(View paramView, boolean paramBoolean) {
    if (!isDrawerView(paramView))
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer"); 
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if (this.mFirstLayout) {
      layoutParams.onScreen = 1.0F;
      layoutParams.openState = 1;
      updateChildrenImportantForAccessibility(paramView, true);
    } else if (paramBoolean) {
      layoutParams.openState |= 0x2;
      if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
        this.mLeftDragger.smoothSlideViewTo(paramView, 0, paramView.getTop());
      } else {
        this.mRightDragger.smoothSlideViewTo(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
      } 
    } else {
      moveDrawerToOffset(paramView, 1.0F);
      updateDrawerState(layoutParams.gravity, 0, paramView);
      paramView.setVisibility(0);
    } 
    invalidate();
  }
  
  public void removeDrawerListener(@NonNull DrawerListener paramDrawerListener) {
    if (paramDrawerListener != null && this.mListeners != null)
      this.mListeners.remove(paramDrawerListener); 
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.mDisallowInterceptRequested = paramBoolean;
    if (paramBoolean)
      closeDrawers(true); 
  }
  
  public void requestLayout() {
    if (!this.mInLayout)
      super.requestLayout(); 
  }
  
  public void setChildInsets(Object paramObject, boolean paramBoolean) {
    this.mLastInsets = paramObject;
    this.mDrawStatusBarBackground = paramBoolean;
    if (!paramBoolean && getBackground() == null) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    setWillNotDraw(paramBoolean);
    requestLayout();
  }
  
  public void setDrawerElevation(float paramFloat) {
    this.mDrawerElevation = paramFloat;
    for (byte b = 0; b < getChildCount(); b++) {
      View view = getChildAt(b);
      if (isDrawerView(view))
        ViewCompat.setElevation(view, this.mDrawerElevation); 
    } 
  }
  
  @Deprecated
  public void setDrawerListener(DrawerListener paramDrawerListener) {
    if (this.mListener != null)
      removeDrawerListener(this.mListener); 
    if (paramDrawerListener != null)
      addDrawerListener(paramDrawerListener); 
    this.mListener = paramDrawerListener;
  }
  
  public void setDrawerLockMode(int paramInt) {
    setDrawerLockMode(paramInt, 3);
    setDrawerLockMode(paramInt, 5);
  }
  
  public void setDrawerLockMode(int paramInt1, int paramInt2) {
    int i = GravityCompat.getAbsoluteGravity(paramInt2, ViewCompat.getLayoutDirection((View)this));
    switch (paramInt2) {
      default:
        if (paramInt1 != 0) {
          ViewDragHelper viewDragHelper;
          if (i == 3) {
            viewDragHelper = this.mLeftDragger;
          } else {
            viewDragHelper = this.mRightDragger;
          } 
          viewDragHelper.cancel();
        } 
        switch (paramInt1) {
          default:
            return;
          case 2:
            view = findDrawerWithGravity(i);
            if (view != null)
              openDrawer(view); 
          case 1:
            break;
        } 
        break;
      case 3:
        this.mLockModeLeft = paramInt1;
      case 5:
        this.mLockModeRight = paramInt1;
      case 8388611:
        this.mLockModeStart = paramInt1;
      case 8388613:
        this.mLockModeEnd = paramInt1;
    } 
    View view = findDrawerWithGravity(i);
    if (view != null)
      closeDrawer(view); 
  }
  
  public void setDrawerLockMode(int paramInt, View paramView) {
    if (!isDrawerView(paramView))
      throw new IllegalArgumentException("View " + paramView + " is not a " + "drawer with appropriate layout_gravity"); 
    setDrawerLockMode(paramInt, ((LayoutParams)paramView.getLayoutParams()).gravity);
  }
  
  public void setDrawerShadow(@DrawableRes int paramInt1, int paramInt2) {
    setDrawerShadow(ContextCompat.getDrawable(getContext(), paramInt1), paramInt2);
  }
  
  public void setDrawerShadow(Drawable paramDrawable, int paramInt) {
    if (!SET_DRAWER_SHADOW_FROM_ELEVATION) {
      if ((paramInt & 0x800003) == 8388611) {
        this.mShadowStart = paramDrawable;
      } else if ((paramInt & 0x800005) == 8388613) {
        this.mShadowEnd = paramDrawable;
      } else if ((paramInt & 0x3) == 3) {
        this.mShadowLeft = paramDrawable;
      } else if ((paramInt & 0x5) == 5) {
        this.mShadowRight = paramDrawable;
      } else {
        return;
      } 
      resolveShadowDrawables();
      invalidate();
    } 
  }
  
  public void setDrawerTitle(int paramInt, CharSequence paramCharSequence) {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection((View)this));
    if (paramInt == 3) {
      this.mTitleLeft = paramCharSequence;
      return;
    } 
    if (paramInt == 5)
      this.mTitleRight = paramCharSequence; 
  }
  
  void setDrawerViewOffset(View paramView, float paramFloat) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat != layoutParams.onScreen) {
      layoutParams.onScreen = paramFloat;
      dispatchOnDrawerSlide(paramView, paramFloat);
    } 
  }
  
  public void setScrimColor(@ColorInt int paramInt) {
    this.mScrimColor = paramInt;
    invalidate();
  }
  
  public void setStatusBarBackground(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = ContextCompat.getDrawable(getContext(), paramInt);
    } else {
      drawable = null;
    } 
    this.mStatusBarBackground = drawable;
    invalidate();
  }
  
  public void setStatusBarBackground(Drawable paramDrawable) {
    this.mStatusBarBackground = paramDrawable;
    invalidate();
  }
  
  public void setStatusBarBackgroundColor(@ColorInt int paramInt) {
    this.mStatusBarBackground = (Drawable)new ColorDrawable(paramInt);
    invalidate();
  }
  
  void updateDrawerState(int paramInt1, int paramInt2, View paramView) {
    paramInt1 = this.mLeftDragger.getViewDragState();
    int i = this.mRightDragger.getViewDragState();
    if (paramInt1 == 1 || i == 1) {
      paramInt1 = 1;
    } else if (paramInt1 == 2 || i == 2) {
      paramInt1 = 2;
    } else {
      paramInt1 = 0;
    } 
    if (paramView != null && paramInt2 == 0) {
      LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
      if (layoutParams.onScreen == 0.0F) {
        dispatchOnDrawerClosed(paramView);
      } else if (layoutParams.onScreen == 1.0F) {
        dispatchOnDrawerOpened(paramView);
      } 
    } 
    if (paramInt1 != this.mDrawerState) {
      this.mDrawerState = paramInt1;
      if (this.mListeners != null)
        for (paramInt2 = this.mListeners.size() - 1; paramInt2 >= 0; paramInt2--)
          ((DrawerListener)this.mListeners.get(paramInt2)).onDrawerStateChanged(paramInt1);  
    } 
  }
  
  static {
    boolean bool1 = false;
  }
  
  class AccessibilityDelegate extends AccessibilityDelegateCompat {
    private final Rect mTmpRect = new Rect();
    
    private void addChildrenForAccessibility(AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat, ViewGroup param1ViewGroup) {
      int i = param1ViewGroup.getChildCount();
      for (byte b = 0; b < i; b++) {
        View view = param1ViewGroup.getChildAt(b);
        if (DrawerLayout.includeChildForAccessibility(view))
          param1AccessibilityNodeInfoCompat.addChild(view); 
      } 
    }
    
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
    }
    
    public boolean dispatchPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      List<CharSequence> list;
      CharSequence charSequence;
      if (param1AccessibilityEvent.getEventType() == 32) {
        list = param1AccessibilityEvent.getText();
        View view = DrawerLayout.this.findVisibleDrawer();
        if (view != null) {
          int i = DrawerLayout.this.getDrawerViewAbsoluteGravity(view);
          charSequence = DrawerLayout.this.getDrawerTitle(i);
          if (charSequence != null)
            list.add(charSequence); 
        } 
        return true;
      } 
      return super.dispatchPopulateAccessibilityEvent((View)list, (AccessibilityEvent)charSequence);
    }
    
    public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      super.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
      param1AccessibilityEvent.setClassName(DrawerLayout.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      if (DrawerLayout.CAN_HIDE_DESCENDANTS) {
        super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
      } else {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(param1AccessibilityNodeInfoCompat);
        super.onInitializeAccessibilityNodeInfo(param1View, accessibilityNodeInfoCompat);
        param1AccessibilityNodeInfoCompat.setSource(param1View);
        ViewParent viewParent = ViewCompat.getParentForAccessibility(param1View);
        if (viewParent instanceof View)
          param1AccessibilityNodeInfoCompat.setParent((View)viewParent); 
        copyNodeInfoNoChildren(param1AccessibilityNodeInfoCompat, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.recycle();
        addChildrenForAccessibility(param1AccessibilityNodeInfoCompat, (ViewGroup)param1View);
      } 
      param1AccessibilityNodeInfoCompat.setClassName(DrawerLayout.class.getName());
      param1AccessibilityNodeInfoCompat.setFocusable(false);
      param1AccessibilityNodeInfoCompat.setFocused(false);
      param1AccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
      param1AccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return (DrawerLayout.CAN_HIDE_DESCENDANTS || DrawerLayout.includeChildForAccessibility(param1View)) ? super.onRequestSendAccessibilityEvent(param1ViewGroup, param1View, param1AccessibilityEvent) : false;
    }
  }
  
  final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
      if (!DrawerLayout.includeChildForAccessibility(param1View))
        param1AccessibilityNodeInfoCompat.setParent(null); 
    }
  }
  
  static interface DrawerLayoutCompatImpl {
    void applyMarginInsets(ViewGroup.MarginLayoutParams param1MarginLayoutParams, Object param1Object, int param1Int);
    
    void configureApplyInsets(View param1View);
    
    void dispatchChildInsets(View param1View, Object param1Object, int param1Int);
    
    Drawable getDefaultStatusBarBackground(Context param1Context);
    
    int getTopInset(Object param1Object);
  }
  
  static class DrawerLayoutCompatImplApi21 implements DrawerLayoutCompatImpl {
    public void applyMarginInsets(ViewGroup.MarginLayoutParams param1MarginLayoutParams, Object param1Object, int param1Int) {
      DrawerLayoutCompatApi21.applyMarginInsets(param1MarginLayoutParams, param1Object, param1Int);
    }
    
    public void configureApplyInsets(View param1View) {
      DrawerLayoutCompatApi21.configureApplyInsets(param1View);
    }
    
    public void dispatchChildInsets(View param1View, Object param1Object, int param1Int) {
      DrawerLayoutCompatApi21.dispatchChildInsets(param1View, param1Object, param1Int);
    }
    
    public Drawable getDefaultStatusBarBackground(Context param1Context) {
      return DrawerLayoutCompatApi21.getDefaultStatusBarBackground(param1Context);
    }
    
    public int getTopInset(Object param1Object) {
      return DrawerLayoutCompatApi21.getTopInset(param1Object);
    }
  }
  
  static class DrawerLayoutCompatImplBase implements DrawerLayoutCompatImpl {
    public void applyMarginInsets(ViewGroup.MarginLayoutParams param1MarginLayoutParams, Object param1Object, int param1Int) {}
    
    public void configureApplyInsets(View param1View) {}
    
    public void dispatchChildInsets(View param1View, Object param1Object, int param1Int) {}
    
    public Drawable getDefaultStatusBarBackground(Context param1Context) {
      return null;
    }
    
    public int getTopInset(Object param1Object) {
      return 0;
    }
  }
  
  public static interface DrawerListener {
    void onDrawerClosed(View param1View);
    
    void onDrawerOpened(View param1View);
    
    void onDrawerSlide(View param1View, float param1Float);
    
    void onDrawerStateChanged(int param1Int);
  }
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    private static final int FLAG_IS_CLOSING = 4;
    
    private static final int FLAG_IS_OPENED = 1;
    
    private static final int FLAG_IS_OPENING = 2;
    
    public int gravity = 0;
    
    boolean isPeeking;
    
    float onScreen;
    
    int openState;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    public LayoutParams(int param1Int1, int param1Int2, int param1Int3) {
      this(param1Int1, param1Int2);
      this.gravity = param1Int3;
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, DrawerLayout.LAYOUT_ATTRS);
      this.gravity = typedArray.getInt(0, 0);
      typedArray.recycle();
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
      this.gravity = param1LayoutParams.gravity;
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      super(param1MarginLayoutParams);
    }
  }
  
  protected static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
          public DrawerLayout.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
            return new DrawerLayout.SavedState(param2Parcel, param2ClassLoader);
          }
          
          public DrawerLayout.SavedState[] newArray(int param2Int) {
            return new DrawerLayout.SavedState[param2Int];
          }
        });
    
    int lockModeEnd;
    
    int lockModeLeft;
    
    int lockModeRight;
    
    int lockModeStart;
    
    int openDrawerGravity = 0;
    
    public SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      this.openDrawerGravity = param1Parcel.readInt();
      this.lockModeLeft = param1Parcel.readInt();
      this.lockModeRight = param1Parcel.readInt();
      this.lockModeStart = param1Parcel.readInt();
      this.lockModeEnd = param1Parcel.readInt();
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.openDrawerGravity);
      param1Parcel.writeInt(this.lockModeLeft);
      param1Parcel.writeInt(this.lockModeRight);
      param1Parcel.writeInt(this.lockModeStart);
      param1Parcel.writeInt(this.lockModeEnd);
    }
  }
  
  static final class null implements ParcelableCompatCreatorCallbacks<SavedState> {
    public DrawerLayout.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new DrawerLayout.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public DrawerLayout.SavedState[] newArray(int param1Int) {
      return new DrawerLayout.SavedState[param1Int];
    }
  }
  
  public static abstract class SimpleDrawerListener implements DrawerListener {
    public void onDrawerClosed(View param1View) {}
    
    public void onDrawerOpened(View param1View) {}
    
    public void onDrawerSlide(View param1View, float param1Float) {}
    
    public void onDrawerStateChanged(int param1Int) {}
  }
  
  private class ViewDragCallback extends ViewDragHelper.Callback {
    private final int mAbsGravity;
    
    private ViewDragHelper mDragger;
    
    private final Runnable mPeekRunnable = new Runnable() {
        public void run() {
          DrawerLayout.ViewDragCallback.this.peekDrawer();
        }
      };
    
    ViewDragCallback(int param1Int) {
      this.mAbsGravity = param1Int;
    }
    
    private void closeOtherDrawer() {
      byte b = 3;
      if (this.mAbsGravity == 3)
        b = 5; 
      View view = DrawerLayout.this.findDrawerWithGravity(b);
      if (view != null)
        DrawerLayout.this.closeDrawer(view); 
    }
    
    public int clampViewPositionHorizontal(View param1View, int param1Int1, int param1Int2) {
      if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(param1View, 3))
        return Math.max(-param1View.getWidth(), Math.min(param1Int1, 0)); 
      param1Int2 = DrawerLayout.this.getWidth();
      return Math.max(param1Int2 - param1View.getWidth(), Math.min(param1Int1, param1Int2));
    }
    
    public int clampViewPositionVertical(View param1View, int param1Int1, int param1Int2) {
      return param1View.getTop();
    }
    
    public int getViewHorizontalDragRange(View param1View) {
      return DrawerLayout.this.isDrawerView(param1View) ? param1View.getWidth() : 0;
    }
    
    public void onEdgeDragStarted(int param1Int1, int param1Int2) {
      View view;
      if ((param1Int1 & 0x1) == 1) {
        view = DrawerLayout.this.findDrawerWithGravity(3);
      } else {
        view = DrawerLayout.this.findDrawerWithGravity(5);
      } 
      if (view != null && DrawerLayout.this.getDrawerLockMode(view) == 0)
        this.mDragger.captureChildView(view, param1Int2); 
    }
    
    public boolean onEdgeLock(int param1Int) {
      return false;
    }
    
    public void onEdgeTouched(int param1Int1, int param1Int2) {
      DrawerLayout.this.postDelayed(this.mPeekRunnable, 160L);
    }
    
    public void onViewCaptured(View param1View, int param1Int) {
      ((DrawerLayout.LayoutParams)param1View.getLayoutParams()).isPeeking = false;
      closeOtherDrawer();
    }
    
    public void onViewDragStateChanged(int param1Int) {
      DrawerLayout.this.updateDrawerState(this.mAbsGravity, param1Int, this.mDragger.getCapturedView());
    }
    
    public void onViewPositionChanged(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      float f;
      param1Int2 = param1View.getWidth();
      if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(param1View, 3)) {
        f = (param1Int2 + param1Int1) / param1Int2;
      } else {
        f = (DrawerLayout.this.getWidth() - param1Int1) / param1Int2;
      } 
      DrawerLayout.this.setDrawerViewOffset(param1View, f);
      if (f == 0.0F) {
        param1Int1 = 4;
      } else {
        param1Int1 = 0;
      } 
      param1View.setVisibility(param1Int1);
      DrawerLayout.this.invalidate();
    }
    
    public void onViewReleased(View param1View, float param1Float1, float param1Float2) {
      // Byte code:
      //   0: aload_0
      //   1: getfield this$0 : Landroid/support/v4/widget/DrawerLayout;
      //   4: aload_1
      //   5: invokevirtual getDrawerViewOffset : (Landroid/view/View;)F
      //   8: fstore_3
      //   9: aload_1
      //   10: invokevirtual getWidth : ()I
      //   13: istore #4
      //   15: aload_0
      //   16: getfield this$0 : Landroid/support/v4/widget/DrawerLayout;
      //   19: aload_1
      //   20: iconst_3
      //   21: invokevirtual checkDrawerViewAbsoluteGravity : (Landroid/view/View;I)Z
      //   24: ifeq -> 79
      //   27: fload_2
      //   28: fconst_0
      //   29: fcmpl
      //   30: ifgt -> 46
      //   33: fload_2
      //   34: fconst_0
      //   35: fcmpl
      //   36: ifne -> 71
      //   39: fload_3
      //   40: ldc 0.5
      //   42: fcmpl
      //   43: ifle -> 71
      //   46: iconst_0
      //   47: istore #5
      //   49: aload_0
      //   50: getfield mDragger : Landroid/support/v4/widget/ViewDragHelper;
      //   53: iload #5
      //   55: aload_1
      //   56: invokevirtual getTop : ()I
      //   59: invokevirtual settleCapturedViewAt : (II)Z
      //   62: pop
      //   63: aload_0
      //   64: getfield this$0 : Landroid/support/v4/widget/DrawerLayout;
      //   67: invokevirtual invalidate : ()V
      //   70: return
      //   71: iload #4
      //   73: ineg
      //   74: istore #5
      //   76: goto -> 49
      //   79: aload_0
      //   80: getfield this$0 : Landroid/support/v4/widget/DrawerLayout;
      //   83: invokevirtual getWidth : ()I
      //   86: istore #6
      //   88: fload_2
      //   89: fconst_0
      //   90: fcmpg
      //   91: iflt -> 115
      //   94: iload #6
      //   96: istore #5
      //   98: fload_2
      //   99: fconst_0
      //   100: fcmpl
      //   101: ifne -> 49
      //   104: iload #6
      //   106: istore #5
      //   108: fload_3
      //   109: ldc 0.5
      //   111: fcmpl
      //   112: ifle -> 49
      //   115: iload #6
      //   117: iload #4
      //   119: isub
      //   120: istore #5
      //   122: goto -> 49
    }
    
    void peekDrawer() {
      boolean bool;
      View view;
      int i = 0;
      int j = this.mDragger.getEdgeSize();
      if (this.mAbsGravity == 3) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        view = DrawerLayout.this.findDrawerWithGravity(3);
        if (view != null)
          i = -view.getWidth(); 
        i += j;
      } else {
        view = DrawerLayout.this.findDrawerWithGravity(5);
        i = DrawerLayout.this.getWidth();
        i -= j;
      } 
      if (view != null && ((bool && view.getLeft() < i) || (!bool && view.getLeft() > i)) && DrawerLayout.this.getDrawerLockMode(view) == 0) {
        DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams)view.getLayoutParams();
        this.mDragger.smoothSlideViewTo(view, i, view.getTop());
        layoutParams.isPeeking = true;
        DrawerLayout.this.invalidate();
        closeOtherDrawer();
        DrawerLayout.this.cancelChildViewTouch();
      } 
    }
    
    public void removeCallbacks() {
      DrawerLayout.this.removeCallbacks(this.mPeekRunnable);
    }
    
    public void setDragger(ViewDragHelper param1ViewDragHelper) {
      this.mDragger = param1ViewDragHelper;
    }
    
    public boolean tryCaptureView(View param1View, int param1Int) {
      return (DrawerLayout.this.isDrawerView(param1View) && DrawerLayout.this.checkDrawerViewAbsoluteGravity(param1View, this.mAbsGravity) && DrawerLayout.this.getDrawerLockMode(param1View) == 0);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$1.peekDrawer();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\widget\DrawerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */