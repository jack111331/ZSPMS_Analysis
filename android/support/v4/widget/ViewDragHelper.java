package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class ViewDragHelper {
  private static final int BASE_SETTLE_DURATION = 256;
  
  public static final int DIRECTION_ALL = 3;
  
  public static final int DIRECTION_HORIZONTAL = 1;
  
  public static final int DIRECTION_VERTICAL = 2;
  
  public static final int EDGE_ALL = 15;
  
  public static final int EDGE_BOTTOM = 8;
  
  public static final int EDGE_LEFT = 1;
  
  public static final int EDGE_RIGHT = 2;
  
  private static final int EDGE_SIZE = 20;
  
  public static final int EDGE_TOP = 4;
  
  public static final int INVALID_POINTER = -1;
  
  private static final int MAX_SETTLE_DURATION = 600;
  
  public static final int STATE_DRAGGING = 1;
  
  public static final int STATE_IDLE = 0;
  
  public static final int STATE_SETTLING = 2;
  
  private static final String TAG = "ViewDragHelper";
  
  private static final Interpolator sInterpolator = new Interpolator() {
      public float getInterpolation(float param1Float) {
        param1Float--;
        return param1Float * param1Float * param1Float * param1Float * param1Float + 1.0F;
      }
    };
  
  private int mActivePointerId = -1;
  
  private final Callback mCallback;
  
  private View mCapturedView;
  
  private int mDragState;
  
  private int[] mEdgeDragsInProgress;
  
  private int[] mEdgeDragsLocked;
  
  private int mEdgeSize;
  
  private int[] mInitialEdgesTouched;
  
  private float[] mInitialMotionX;
  
  private float[] mInitialMotionY;
  
  private float[] mLastMotionX;
  
  private float[] mLastMotionY;
  
  private float mMaxVelocity;
  
  private float mMinVelocity;
  
  private final ViewGroup mParentView;
  
  private int mPointersDown;
  
  private boolean mReleaseInProgress;
  
  private ScrollerCompat mScroller;
  
  private final Runnable mSetIdleRunnable = new Runnable() {
      public void run() {
        ViewDragHelper.this.setDragState(0);
      }
    };
  
  private int mTouchSlop;
  
  private int mTrackingEdges;
  
  private VelocityTracker mVelocityTracker;
  
  private ViewDragHelper(Context paramContext, ViewGroup paramViewGroup, Callback paramCallback) {
    if (paramViewGroup == null)
      throw new IllegalArgumentException("Parent view may not be null"); 
    if (paramCallback == null)
      throw new IllegalArgumentException("Callback may not be null"); 
    this.mParentView = paramViewGroup;
    this.mCallback = paramCallback;
    ViewConfiguration viewConfiguration = ViewConfiguration.get(paramContext);
    this.mEdgeSize = (int)(0.5F + 20.0F * (paramContext.getResources().getDisplayMetrics()).density);
    this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
    this.mScroller = ScrollerCompat.create(paramContext, sInterpolator);
  }
  
  private boolean checkNewEdgeDrag(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
    boolean bool1 = false;
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    boolean bool2 = bool1;
    if ((this.mInitialEdgesTouched[paramInt1] & paramInt2) == paramInt2) {
      bool2 = bool1;
      if ((this.mTrackingEdges & paramInt2) != 0) {
        bool2 = bool1;
        if ((this.mEdgeDragsLocked[paramInt1] & paramInt2) != paramInt2) {
          bool2 = bool1;
          if ((this.mEdgeDragsInProgress[paramInt1] & paramInt2) != paramInt2) {
            if (paramFloat1 <= this.mTouchSlop && paramFloat2 <= this.mTouchSlop)
              return bool1; 
          } else {
            return bool2;
          } 
        } else {
          return bool2;
        } 
      } else {
        return bool2;
      } 
    } else {
      return bool2;
    } 
    if (paramFloat1 < paramFloat2 * 0.5F && this.mCallback.onEdgeLock(paramInt2)) {
      int[] arrayOfInt = this.mEdgeDragsLocked;
      arrayOfInt[paramInt1] = arrayOfInt[paramInt1] | paramInt2;
      return bool1;
    } 
    bool2 = bool1;
    if ((this.mEdgeDragsInProgress[paramInt1] & paramInt2) == 0) {
      bool2 = bool1;
      if (paramFloat1 > this.mTouchSlop)
        bool2 = true; 
    } 
    return bool2;
  }
  
  private boolean checkTouchSlop(View paramView, float paramFloat1, float paramFloat2) {
    boolean bool2;
    boolean bool3;
    boolean bool1 = false;
    if (paramView == null)
      return bool1; 
    if (this.mCallback.getViewHorizontalDragRange(paramView) > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (this.mCallback.getViewVerticalDragRange(paramView) > 0) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (bool2 && bool3) {
      boolean bool = bool1;
      return (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > (this.mTouchSlop * this.mTouchSlop)) ? true : bool;
    } 
    if (bool2) {
      if (Math.abs(paramFloat1) <= this.mTouchSlop)
        return bool1; 
    } else {
      boolean bool = bool1;
      if (bool3) {
        if (Math.abs(paramFloat2) <= this.mTouchSlop)
          return bool1; 
      } else {
        return bool;
      } 
    } 
    return true;
  }
  
  private float clampMag(float paramFloat1, float paramFloat2, float paramFloat3) {
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2)
      return 0.0F; 
    if (f > paramFloat3) {
      paramFloat2 = paramFloat3;
      if (paramFloat1 <= 0.0F)
        paramFloat2 = -paramFloat3; 
      return paramFloat2;
    } 
    return paramFloat1;
  }
  
  private int clampMag(int paramInt1, int paramInt2, int paramInt3) {
    int i = Math.abs(paramInt1);
    if (i < paramInt2)
      return 0; 
    if (i > paramInt3) {
      paramInt2 = paramInt3;
      if (paramInt1 <= 0)
        paramInt2 = -paramInt3; 
      return paramInt2;
    } 
    return paramInt1;
  }
  
  private void clearMotionHistory() {
    if (this.mInitialMotionX != null) {
      Arrays.fill(this.mInitialMotionX, 0.0F);
      Arrays.fill(this.mInitialMotionY, 0.0F);
      Arrays.fill(this.mLastMotionX, 0.0F);
      Arrays.fill(this.mLastMotionY, 0.0F);
      Arrays.fill(this.mInitialEdgesTouched, 0);
      Arrays.fill(this.mEdgeDragsInProgress, 0);
      Arrays.fill(this.mEdgeDragsLocked, 0);
      this.mPointersDown = 0;
    } 
  }
  
  private void clearMotionHistory(int paramInt) {
    if (this.mInitialMotionX != null && isPointerDown(paramInt)) {
      this.mInitialMotionX[paramInt] = 0.0F;
      this.mInitialMotionY[paramInt] = 0.0F;
      this.mLastMotionX[paramInt] = 0.0F;
      this.mLastMotionY[paramInt] = 0.0F;
      this.mInitialEdgesTouched[paramInt] = 0;
      this.mEdgeDragsInProgress[paramInt] = 0;
      this.mEdgeDragsLocked[paramInt] = 0;
      this.mPointersDown &= 1 << paramInt ^ 0xFFFFFFFF;
    } 
  }
  
  private int computeAxisDuration(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 == 0)
      return 0; 
    int i = this.mParentView.getWidth();
    int j = i / 2;
    float f1 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f2 = j;
    float f3 = j;
    f1 = distanceInfluenceForSnapDuration(f1);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {
      paramInt1 = Math.round(Math.abs((f1 * f3 + f2) / paramInt2) * 1000.0F) * 4;
    } else {
      paramInt1 = (int)(256.0F * (Math.abs(paramInt1) / paramInt3 + 1.0F));
    } 
    return Math.min(paramInt1, 600);
  }
  
  private int computeSettleDuration(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    float f1;
    paramInt3 = clampMag(paramInt3, (int)this.mMinVelocity, (int)this.mMaxVelocity);
    paramInt4 = clampMag(paramInt4, (int)this.mMinVelocity, (int)this.mMaxVelocity);
    int i = Math.abs(paramInt1);
    int j = Math.abs(paramInt2);
    int k = Math.abs(paramInt3);
    int m = Math.abs(paramInt4);
    int n = k + m;
    int i1 = i + j;
    if (paramInt3 != 0) {
      f1 = k / n;
    } else {
      f1 = i / i1;
    } 
    if (paramInt4 != 0) {
      float f4 = m / n;
      paramInt1 = computeAxisDuration(paramInt1, paramInt3, this.mCallback.getViewHorizontalDragRange(paramView));
      paramInt2 = computeAxisDuration(paramInt2, paramInt4, this.mCallback.getViewVerticalDragRange(paramView));
      float f5 = paramInt1;
      return (int)(f4 * paramInt2 + f1 * f5);
    } 
    float f2 = j / i1;
    paramInt1 = computeAxisDuration(paramInt1, paramInt3, this.mCallback.getViewHorizontalDragRange(paramView));
    paramInt2 = computeAxisDuration(paramInt2, paramInt4, this.mCallback.getViewVerticalDragRange(paramView));
    float f3 = paramInt1;
    return (int)(f2 * paramInt2 + f1 * f3);
  }
  
  public static ViewDragHelper create(ViewGroup paramViewGroup, float paramFloat, Callback paramCallback) {
    ViewDragHelper viewDragHelper = create(paramViewGroup, paramCallback);
    viewDragHelper.mTouchSlop = (int)(viewDragHelper.mTouchSlop * 1.0F / paramFloat);
    return viewDragHelper;
  }
  
  public static ViewDragHelper create(ViewGroup paramViewGroup, Callback paramCallback) {
    return new ViewDragHelper(paramViewGroup.getContext(), paramViewGroup, paramCallback);
  }
  
  private void dispatchViewReleased(float paramFloat1, float paramFloat2) {
    this.mReleaseInProgress = true;
    this.mCallback.onViewReleased(this.mCapturedView, paramFloat1, paramFloat2);
    this.mReleaseInProgress = false;
    if (this.mDragState == 1)
      setDragState(0); 
  }
  
  private float distanceInfluenceForSnapDuration(float paramFloat) {
    return (float)Math.sin((float)(0.4712389167638204D * (paramFloat - 0.5F)));
  }
  
  private void dragTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = this.mCapturedView.getLeft();
    int j = this.mCapturedView.getTop();
    if (paramInt3 != 0) {
      paramInt1 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, paramInt1, paramInt3);
      ViewCompat.offsetLeftAndRight(this.mCapturedView, paramInt1 - i);
    } 
    if (paramInt4 != 0) {
      paramInt2 = this.mCallback.clampViewPositionVertical(this.mCapturedView, paramInt2, paramInt4);
      ViewCompat.offsetTopAndBottom(this.mCapturedView, paramInt2 - j);
    } 
    if (paramInt3 != 0 || paramInt4 != 0)
      this.mCallback.onViewPositionChanged(this.mCapturedView, paramInt1, paramInt2, paramInt1 - i, paramInt2 - j); 
  }
  
  private void ensureMotionHistorySizeForId(int paramInt) {
    if (this.mInitialMotionX == null || this.mInitialMotionX.length <= paramInt) {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.mInitialMotionX != null) {
        System.arraycopy(this.mInitialMotionX, 0, arrayOfFloat1, 0, this.mInitialMotionX.length);
        System.arraycopy(this.mInitialMotionY, 0, arrayOfFloat2, 0, this.mInitialMotionY.length);
        System.arraycopy(this.mLastMotionX, 0, arrayOfFloat3, 0, this.mLastMotionX.length);
        System.arraycopy(this.mLastMotionY, 0, arrayOfFloat4, 0, this.mLastMotionY.length);
        System.arraycopy(this.mInitialEdgesTouched, 0, arrayOfInt1, 0, this.mInitialEdgesTouched.length);
        System.arraycopy(this.mEdgeDragsInProgress, 0, arrayOfInt2, 0, this.mEdgeDragsInProgress.length);
        System.arraycopy(this.mEdgeDragsLocked, 0, arrayOfInt3, 0, this.mEdgeDragsLocked.length);
      } 
      this.mInitialMotionX = arrayOfFloat1;
      this.mInitialMotionY = arrayOfFloat2;
      this.mLastMotionX = arrayOfFloat3;
      this.mLastMotionY = arrayOfFloat4;
      this.mInitialEdgesTouched = arrayOfInt1;
      this.mEdgeDragsInProgress = arrayOfInt2;
      this.mEdgeDragsLocked = arrayOfInt3;
    } 
  }
  
  private boolean forceSettleCapturedViewAt(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    null = false;
    int i = this.mCapturedView.getLeft();
    int j = this.mCapturedView.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if (paramInt1 == 0 && paramInt2 == 0) {
      this.mScroller.abortAnimation();
      setDragState(0);
      return null;
    } 
    paramInt3 = computeSettleDuration(this.mCapturedView, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mScroller.startScroll(i, j, paramInt1, paramInt2, paramInt3);
    setDragState(2);
    return true;
  }
  
  private int getEdgesTouched(int paramInt1, int paramInt2) {
    int i = this.mParentView.getLeft();
    int j = this.mEdgeSize;
    int k = 0;
    if (paramInt1 < j + i)
      k = 1; 
    j = k;
    if (paramInt2 < this.mParentView.getTop() + this.mEdgeSize)
      j = k | 0x4; 
    k = j;
    if (paramInt1 > this.mParentView.getRight() - this.mEdgeSize)
      k = j | 0x2; 
    paramInt1 = k;
    if (paramInt2 > this.mParentView.getBottom() - this.mEdgeSize)
      paramInt1 = k | 0x8; 
    return paramInt1;
  }
  
  private boolean isValidPointerForActionMove(int paramInt) {
    if (!isPointerDown(paramInt)) {
      Log.e("ViewDragHelper", "Ignoring pointerId=" + paramInt + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
      return false;
    } 
    return true;
  }
  
  private void releaseViewForPointerUp() {
    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
    dispatchViewReleased(clampMag(VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
  }
  
  private void reportNewEdgeDrags(float paramFloat1, float paramFloat2, int paramInt) {
    int i = 1;
    if (!checkNewEdgeDrag(paramFloat1, paramFloat2, paramInt, 1))
      i = 0; 
    int j = i;
    if (checkNewEdgeDrag(paramFloat2, paramFloat1, paramInt, 4))
      j = i | 0x4; 
    i = j;
    if (checkNewEdgeDrag(paramFloat1, paramFloat2, paramInt, 2))
      i = j | 0x2; 
    j = i;
    if (checkNewEdgeDrag(paramFloat2, paramFloat1, paramInt, 8))
      j = i | 0x8; 
    if (j != 0) {
      int[] arrayOfInt = this.mEdgeDragsInProgress;
      arrayOfInt[paramInt] = arrayOfInt[paramInt] | j;
      this.mCallback.onEdgeDragStarted(j, paramInt);
    } 
  }
  
  private void saveInitialMotion(float paramFloat1, float paramFloat2, int paramInt) {
    ensureMotionHistorySizeForId(paramInt);
    float[] arrayOfFloat = this.mInitialMotionX;
    this.mLastMotionX[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.mInitialMotionY;
    this.mLastMotionY[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.mInitialEdgesTouched[paramInt] = getEdgesTouched((int)paramFloat1, (int)paramFloat2);
    this.mPointersDown |= 1 << paramInt;
  }
  
  private void saveLastMotion(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getPointerCount();
    for (byte b = 0; b < i; b++) {
      int j = paramMotionEvent.getPointerId(b);
      if (isValidPointerForActionMove(j)) {
        float f1 = paramMotionEvent.getX(b);
        float f2 = paramMotionEvent.getY(b);
        this.mLastMotionX[j] = f1;
        this.mLastMotionY[j] = f2;
      } 
    } 
  }
  
  public void abort() {
    cancel();
    if (this.mDragState == 2) {
      int i = this.mScroller.getCurrX();
      int j = this.mScroller.getCurrY();
      this.mScroller.abortAnimation();
      int k = this.mScroller.getCurrX();
      int m = this.mScroller.getCurrY();
      this.mCallback.onViewPositionChanged(this.mCapturedView, k, m, k - i, m - j);
    } 
    setDragState(0);
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramView instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      int i = paramView.getScrollX();
      int j = paramView.getScrollY();
      for (int k = viewGroup.getChildCount() - 1; k >= 0; k--) {
        View view = viewGroup.getChildAt(k);
        if (paramInt3 + i >= view.getLeft() && paramInt3 + i < view.getRight() && paramInt4 + j >= view.getTop() && paramInt4 + j < view.getBottom() && canScroll(view, true, paramInt1, paramInt2, paramInt3 + i - view.getLeft(), paramInt4 + j - view.getTop()))
          return true; 
      } 
    } 
    return (paramBoolean && (ViewCompat.canScrollHorizontally(paramView, -paramInt1) || ViewCompat.canScrollVertically(paramView, -paramInt2)));
  }
  
  public void cancel() {
    this.mActivePointerId = -1;
    clearMotionHistory();
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    } 
  }
  
  public void captureChildView(View paramView, int paramInt) {
    if (paramView.getParent() != this.mParentView)
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")"); 
    this.mCapturedView = paramView;
    this.mActivePointerId = paramInt;
    this.mCallback.onViewCaptured(paramView, paramInt);
    setDragState(1);
  }
  
  public boolean checkTouchSlop(int paramInt) {
    boolean bool = false;
    int i = this.mInitialMotionX.length;
    for (byte b = 0;; b++) {
      boolean bool1 = bool;
      if (b < i) {
        if (checkTouchSlop(paramInt, b))
          return true; 
      } else {
        return bool1;
      } 
    } 
  }
  
  public boolean checkTouchSlop(int paramInt1, int paramInt2) {
    boolean bool2;
    boolean bool1 = false;
    if (!isPointerDown(paramInt2))
      return bool1; 
    if ((paramInt1 & 0x1) == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if ((paramInt1 & 0x2) == 2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    } 
    float f1 = this.mLastMotionX[paramInt2] - this.mInitialMotionX[paramInt2];
    float f2 = this.mLastMotionY[paramInt2] - this.mInitialMotionY[paramInt2];
    if (bool2 && paramInt1 != 0) {
      boolean bool = bool1;
      return (f1 * f1 + f2 * f2 > (this.mTouchSlop * this.mTouchSlop)) ? true : bool;
    } 
    if (bool2) {
      if (Math.abs(f1) <= this.mTouchSlop)
        return bool1; 
    } else {
      boolean bool = bool1;
      if (paramInt1 != 0) {
        if (Math.abs(f2) <= this.mTouchSlop)
          return bool1; 
      } else {
        return bool;
      } 
    } 
    return true;
  }
  
  public boolean continueSettling(boolean paramBoolean) {
    if (this.mDragState == 2) {
      boolean bool = this.mScroller.computeScrollOffset();
      int i = this.mScroller.getCurrX();
      int j = this.mScroller.getCurrY();
      int k = i - this.mCapturedView.getLeft();
      int m = j - this.mCapturedView.getTop();
      if (k != 0)
        ViewCompat.offsetLeftAndRight(this.mCapturedView, k); 
      if (m != 0)
        ViewCompat.offsetTopAndBottom(this.mCapturedView, m); 
      if (k != 0 || m != 0)
        this.mCallback.onViewPositionChanged(this.mCapturedView, i, j, k, m); 
      if (bool && i == this.mScroller.getFinalX() && j == this.mScroller.getFinalY()) {
        this.mScroller.abortAnimation();
        bool = false;
      } 
      if (!bool)
        if (paramBoolean) {
          this.mParentView.post(this.mSetIdleRunnable);
        } else {
          setDragState(0);
        }  
    } 
    return (this.mDragState == 2);
  }
  
  public View findTopChildUnder(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mParentView : Landroid/view/ViewGroup;
    //   4: invokevirtual getChildCount : ()I
    //   7: iconst_1
    //   8: isub
    //   9: istore_3
    //   10: iload_3
    //   11: iflt -> 76
    //   14: aload_0
    //   15: getfield mParentView : Landroid/view/ViewGroup;
    //   18: aload_0
    //   19: getfield mCallback : Landroid/support/v4/widget/ViewDragHelper$Callback;
    //   22: iload_3
    //   23: invokevirtual getOrderedChildIndex : (I)I
    //   26: invokevirtual getChildAt : (I)Landroid/view/View;
    //   29: astore #4
    //   31: iload_1
    //   32: aload #4
    //   34: invokevirtual getLeft : ()I
    //   37: if_icmplt -> 70
    //   40: iload_1
    //   41: aload #4
    //   43: invokevirtual getRight : ()I
    //   46: if_icmpge -> 70
    //   49: iload_2
    //   50: aload #4
    //   52: invokevirtual getTop : ()I
    //   55: if_icmplt -> 70
    //   58: iload_2
    //   59: aload #4
    //   61: invokevirtual getBottom : ()I
    //   64: if_icmpge -> 70
    //   67: aload #4
    //   69: areturn
    //   70: iinc #3, -1
    //   73: goto -> 10
    //   76: aconst_null
    //   77: astore #4
    //   79: goto -> 67
  }
  
  public void flingCapturedView(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!this.mReleaseInProgress)
      throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased"); 
    this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), paramInt1, paramInt3, paramInt2, paramInt4);
    setDragState(2);
  }
  
  public int getActivePointerId() {
    return this.mActivePointerId;
  }
  
  public View getCapturedView() {
    return this.mCapturedView;
  }
  
  public int getEdgeSize() {
    return this.mEdgeSize;
  }
  
  public float getMinVelocity() {
    return this.mMinVelocity;
  }
  
  public int getTouchSlop() {
    return this.mTouchSlop;
  }
  
  public int getViewDragState() {
    return this.mDragState;
  }
  
  public boolean isCapturedViewUnder(int paramInt1, int paramInt2) {
    return isViewUnder(this.mCapturedView, paramInt1, paramInt2);
  }
  
  public boolean isEdgeTouched(int paramInt) {
    boolean bool = false;
    int i = this.mInitialEdgesTouched.length;
    for (byte b = 0;; b++) {
      boolean bool1 = bool;
      if (b < i) {
        if (isEdgeTouched(paramInt, b))
          return true; 
      } else {
        return bool1;
      } 
    } 
  }
  
  public boolean isEdgeTouched(int paramInt1, int paramInt2) {
    return (isPointerDown(paramInt2) && (this.mInitialEdgesTouched[paramInt2] & paramInt1) != 0);
  }
  
  public boolean isPointerDown(int paramInt) {
    boolean bool = true;
    if ((this.mPointersDown & 1 << paramInt) == 0)
      bool = false; 
    return bool;
  }
  
  public boolean isViewUnder(View paramView, int paramInt1, int paramInt2) {
    return (paramView != null && paramInt1 >= paramView.getLeft() && paramInt1 < paramView.getRight() && paramInt2 >= paramView.getTop() && paramInt2 < paramView.getBottom());
  }
  
  public void processTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_1
    //   5: invokestatic getActionMasked : (Landroid/view/MotionEvent;)I
    //   8: istore #4
    //   10: aload_1
    //   11: invokestatic getActionIndex : (Landroid/view/MotionEvent;)I
    //   14: istore #5
    //   16: iload #4
    //   18: ifne -> 25
    //   21: aload_0
    //   22: invokevirtual cancel : ()V
    //   25: aload_0
    //   26: getfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   29: ifnonnull -> 39
    //   32: aload_0
    //   33: invokestatic obtain : ()Landroid/view/VelocityTracker;
    //   36: putfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   39: aload_0
    //   40: getfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   43: aload_1
    //   44: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   47: iload #4
    //   49: tableswitch default -> 92, 0 -> 93, 1 -> 643, 2 -> 285, 3 -> 662, 4 -> 92, 5 -> 171, 6 -> 520
    //   92: return
    //   93: aload_1
    //   94: invokevirtual getX : ()F
    //   97: fstore #6
    //   99: aload_1
    //   100: invokevirtual getY : ()F
    //   103: fstore #7
    //   105: aload_1
    //   106: iconst_0
    //   107: invokevirtual getPointerId : (I)I
    //   110: istore_3
    //   111: aload_0
    //   112: fload #6
    //   114: f2i
    //   115: fload #7
    //   117: f2i
    //   118: invokevirtual findTopChildUnder : (II)Landroid/view/View;
    //   121: astore_1
    //   122: aload_0
    //   123: fload #6
    //   125: fload #7
    //   127: iload_3
    //   128: invokespecial saveInitialMotion : (FFI)V
    //   131: aload_0
    //   132: aload_1
    //   133: iload_3
    //   134: invokevirtual tryCaptureViewForDrag : (Landroid/view/View;I)Z
    //   137: pop
    //   138: aload_0
    //   139: getfield mInitialEdgesTouched : [I
    //   142: iload_3
    //   143: iaload
    //   144: istore_2
    //   145: aload_0
    //   146: getfield mTrackingEdges : I
    //   149: iload_2
    //   150: iand
    //   151: ifeq -> 92
    //   154: aload_0
    //   155: getfield mCallback : Landroid/support/v4/widget/ViewDragHelper$Callback;
    //   158: iload_2
    //   159: aload_0
    //   160: getfield mTrackingEdges : I
    //   163: iand
    //   164: iload_3
    //   165: invokevirtual onEdgeTouched : (II)V
    //   168: goto -> 92
    //   171: aload_1
    //   172: iload #5
    //   174: invokevirtual getPointerId : (I)I
    //   177: istore_2
    //   178: aload_1
    //   179: iload #5
    //   181: invokevirtual getX : (I)F
    //   184: fstore #7
    //   186: aload_1
    //   187: iload #5
    //   189: invokevirtual getY : (I)F
    //   192: fstore #6
    //   194: aload_0
    //   195: fload #7
    //   197: fload #6
    //   199: iload_2
    //   200: invokespecial saveInitialMotion : (FFI)V
    //   203: aload_0
    //   204: getfield mDragState : I
    //   207: ifne -> 259
    //   210: aload_0
    //   211: aload_0
    //   212: fload #7
    //   214: f2i
    //   215: fload #6
    //   217: f2i
    //   218: invokevirtual findTopChildUnder : (II)Landroid/view/View;
    //   221: iload_2
    //   222: invokevirtual tryCaptureViewForDrag : (Landroid/view/View;I)Z
    //   225: pop
    //   226: aload_0
    //   227: getfield mInitialEdgesTouched : [I
    //   230: iload_2
    //   231: iaload
    //   232: istore_3
    //   233: aload_0
    //   234: getfield mTrackingEdges : I
    //   237: iload_3
    //   238: iand
    //   239: ifeq -> 92
    //   242: aload_0
    //   243: getfield mCallback : Landroid/support/v4/widget/ViewDragHelper$Callback;
    //   246: iload_3
    //   247: aload_0
    //   248: getfield mTrackingEdges : I
    //   251: iand
    //   252: iload_2
    //   253: invokevirtual onEdgeTouched : (II)V
    //   256: goto -> 92
    //   259: aload_0
    //   260: fload #7
    //   262: f2i
    //   263: fload #6
    //   265: f2i
    //   266: invokevirtual isCapturedViewUnder : (II)Z
    //   269: ifeq -> 92
    //   272: aload_0
    //   273: aload_0
    //   274: getfield mCapturedView : Landroid/view/View;
    //   277: iload_2
    //   278: invokevirtual tryCaptureViewForDrag : (Landroid/view/View;I)Z
    //   281: pop
    //   282: goto -> 92
    //   285: aload_0
    //   286: getfield mDragState : I
    //   289: iconst_1
    //   290: if_icmpne -> 387
    //   293: aload_0
    //   294: aload_0
    //   295: getfield mActivePointerId : I
    //   298: invokespecial isValidPointerForActionMove : (I)Z
    //   301: ifeq -> 92
    //   304: aload_1
    //   305: aload_0
    //   306: getfield mActivePointerId : I
    //   309: invokevirtual findPointerIndex : (I)I
    //   312: istore_2
    //   313: aload_1
    //   314: iload_2
    //   315: invokevirtual getX : (I)F
    //   318: fstore #6
    //   320: aload_1
    //   321: iload_2
    //   322: invokevirtual getY : (I)F
    //   325: fstore #7
    //   327: fload #6
    //   329: aload_0
    //   330: getfield mLastMotionX : [F
    //   333: aload_0
    //   334: getfield mActivePointerId : I
    //   337: faload
    //   338: fsub
    //   339: f2i
    //   340: istore_3
    //   341: fload #7
    //   343: aload_0
    //   344: getfield mLastMotionY : [F
    //   347: aload_0
    //   348: getfield mActivePointerId : I
    //   351: faload
    //   352: fsub
    //   353: f2i
    //   354: istore_2
    //   355: aload_0
    //   356: aload_0
    //   357: getfield mCapturedView : Landroid/view/View;
    //   360: invokevirtual getLeft : ()I
    //   363: iload_3
    //   364: iadd
    //   365: aload_0
    //   366: getfield mCapturedView : Landroid/view/View;
    //   369: invokevirtual getTop : ()I
    //   372: iload_2
    //   373: iadd
    //   374: iload_3
    //   375: iload_2
    //   376: invokespecial dragTo : (IIII)V
    //   379: aload_0
    //   380: aload_1
    //   381: invokespecial saveLastMotion : (Landroid/view/MotionEvent;)V
    //   384: goto -> 92
    //   387: aload_1
    //   388: invokevirtual getPointerCount : ()I
    //   391: istore #5
    //   393: iload_3
    //   394: istore_2
    //   395: iload_2
    //   396: iload #5
    //   398: if_icmpge -> 474
    //   401: aload_1
    //   402: iload_2
    //   403: invokevirtual getPointerId : (I)I
    //   406: istore_3
    //   407: aload_0
    //   408: iload_3
    //   409: invokespecial isValidPointerForActionMove : (I)Z
    //   412: ifne -> 421
    //   415: iinc #2, 1
    //   418: goto -> 395
    //   421: aload_1
    //   422: iload_2
    //   423: invokevirtual getX : (I)F
    //   426: fstore #7
    //   428: aload_1
    //   429: iload_2
    //   430: invokevirtual getY : (I)F
    //   433: fstore #8
    //   435: fload #7
    //   437: aload_0
    //   438: getfield mInitialMotionX : [F
    //   441: iload_3
    //   442: faload
    //   443: fsub
    //   444: fstore #6
    //   446: fload #8
    //   448: aload_0
    //   449: getfield mInitialMotionY : [F
    //   452: iload_3
    //   453: faload
    //   454: fsub
    //   455: fstore #9
    //   457: aload_0
    //   458: fload #6
    //   460: fload #9
    //   462: iload_3
    //   463: invokespecial reportNewEdgeDrags : (FFI)V
    //   466: aload_0
    //   467: getfield mDragState : I
    //   470: iconst_1
    //   471: if_icmpne -> 482
    //   474: aload_0
    //   475: aload_1
    //   476: invokespecial saveLastMotion : (Landroid/view/MotionEvent;)V
    //   479: goto -> 92
    //   482: aload_0
    //   483: fload #7
    //   485: f2i
    //   486: fload #8
    //   488: f2i
    //   489: invokevirtual findTopChildUnder : (II)Landroid/view/View;
    //   492: astore #10
    //   494: aload_0
    //   495: aload #10
    //   497: fload #6
    //   499: fload #9
    //   501: invokespecial checkTouchSlop : (Landroid/view/View;FF)Z
    //   504: ifeq -> 415
    //   507: aload_0
    //   508: aload #10
    //   510: iload_3
    //   511: invokevirtual tryCaptureViewForDrag : (Landroid/view/View;I)Z
    //   514: ifeq -> 415
    //   517: goto -> 474
    //   520: aload_1
    //   521: iload #5
    //   523: invokevirtual getPointerId : (I)I
    //   526: istore_3
    //   527: aload_0
    //   528: getfield mDragState : I
    //   531: iconst_1
    //   532: if_icmpne -> 635
    //   535: iload_3
    //   536: aload_0
    //   537: getfield mActivePointerId : I
    //   540: if_icmpne -> 635
    //   543: aload_1
    //   544: invokevirtual getPointerCount : ()I
    //   547: istore #5
    //   549: iload_2
    //   550: iload #5
    //   552: if_icmpge -> 683
    //   555: aload_1
    //   556: iload_2
    //   557: invokevirtual getPointerId : (I)I
    //   560: istore #4
    //   562: iload #4
    //   564: aload_0
    //   565: getfield mActivePointerId : I
    //   568: if_icmpne -> 577
    //   571: iinc #2, 1
    //   574: goto -> 549
    //   577: aload_1
    //   578: iload_2
    //   579: invokevirtual getX : (I)F
    //   582: fstore #6
    //   584: aload_1
    //   585: iload_2
    //   586: invokevirtual getY : (I)F
    //   589: fstore #7
    //   591: aload_0
    //   592: fload #6
    //   594: f2i
    //   595: fload #7
    //   597: f2i
    //   598: invokevirtual findTopChildUnder : (II)Landroid/view/View;
    //   601: aload_0
    //   602: getfield mCapturedView : Landroid/view/View;
    //   605: if_acmpne -> 571
    //   608: aload_0
    //   609: aload_0
    //   610: getfield mCapturedView : Landroid/view/View;
    //   613: iload #4
    //   615: invokevirtual tryCaptureViewForDrag : (Landroid/view/View;I)Z
    //   618: ifeq -> 571
    //   621: aload_0
    //   622: getfield mActivePointerId : I
    //   625: istore_2
    //   626: iload_2
    //   627: iconst_m1
    //   628: if_icmpne -> 635
    //   631: aload_0
    //   632: invokespecial releaseViewForPointerUp : ()V
    //   635: aload_0
    //   636: iload_3
    //   637: invokespecial clearMotionHistory : (I)V
    //   640: goto -> 92
    //   643: aload_0
    //   644: getfield mDragState : I
    //   647: iconst_1
    //   648: if_icmpne -> 655
    //   651: aload_0
    //   652: invokespecial releaseViewForPointerUp : ()V
    //   655: aload_0
    //   656: invokevirtual cancel : ()V
    //   659: goto -> 92
    //   662: aload_0
    //   663: getfield mDragState : I
    //   666: iconst_1
    //   667: if_icmpne -> 676
    //   670: aload_0
    //   671: fconst_0
    //   672: fconst_0
    //   673: invokespecial dispatchViewReleased : (FF)V
    //   676: aload_0
    //   677: invokevirtual cancel : ()V
    //   680: goto -> 92
    //   683: iconst_m1
    //   684: istore_2
    //   685: goto -> 626
  }
  
  void setDragState(int paramInt) {
    this.mParentView.removeCallbacks(this.mSetIdleRunnable);
    if (this.mDragState != paramInt) {
      this.mDragState = paramInt;
      this.mCallback.onViewDragStateChanged(paramInt);
      if (this.mDragState == 0)
        this.mCapturedView = null; 
    } 
  }
  
  public void setEdgeTrackingEnabled(int paramInt) {
    this.mTrackingEdges = paramInt;
  }
  
  public void setMinVelocity(float paramFloat) {
    this.mMinVelocity = paramFloat;
  }
  
  public boolean settleCapturedViewAt(int paramInt1, int paramInt2) {
    if (!this.mReleaseInProgress)
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased"); 
    return forceSettleCapturedViewAt(paramInt1, paramInt2, (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId));
  }
  
  public boolean shouldInterceptTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic getActionMasked : (Landroid/view/MotionEvent;)I
    //   4: istore_2
    //   5: aload_1
    //   6: invokestatic getActionIndex : (Landroid/view/MotionEvent;)I
    //   9: istore_3
    //   10: iload_2
    //   11: ifne -> 18
    //   14: aload_0
    //   15: invokevirtual cancel : ()V
    //   18: aload_0
    //   19: getfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   22: ifnonnull -> 32
    //   25: aload_0
    //   26: invokestatic obtain : ()Landroid/view/VelocityTracker;
    //   29: putfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   32: aload_0
    //   33: getfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   36: aload_1
    //   37: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   40: iload_2
    //   41: tableswitch default -> 84, 0 -> 98, 1 -> 601, 2 -> 298, 3 -> 601, 4 -> 84, 5 -> 192, 6 -> 589
    //   84: aload_0
    //   85: getfield mDragState : I
    //   88: iconst_1
    //   89: if_icmpne -> 608
    //   92: iconst_1
    //   93: istore #4
    //   95: iload #4
    //   97: ireturn
    //   98: aload_1
    //   99: invokevirtual getX : ()F
    //   102: fstore #5
    //   104: aload_1
    //   105: invokevirtual getY : ()F
    //   108: fstore #6
    //   110: aload_1
    //   111: iconst_0
    //   112: invokevirtual getPointerId : (I)I
    //   115: istore_2
    //   116: aload_0
    //   117: fload #5
    //   119: fload #6
    //   121: iload_2
    //   122: invokespecial saveInitialMotion : (FFI)V
    //   125: aload_0
    //   126: fload #5
    //   128: f2i
    //   129: fload #6
    //   131: f2i
    //   132: invokevirtual findTopChildUnder : (II)Landroid/view/View;
    //   135: astore_1
    //   136: aload_1
    //   137: aload_0
    //   138: getfield mCapturedView : Landroid/view/View;
    //   141: if_acmpne -> 159
    //   144: aload_0
    //   145: getfield mDragState : I
    //   148: iconst_2
    //   149: if_icmpne -> 159
    //   152: aload_0
    //   153: aload_1
    //   154: iload_2
    //   155: invokevirtual tryCaptureViewForDrag : (Landroid/view/View;I)Z
    //   158: pop
    //   159: aload_0
    //   160: getfield mInitialEdgesTouched : [I
    //   163: iload_2
    //   164: iaload
    //   165: istore_3
    //   166: aload_0
    //   167: getfield mTrackingEdges : I
    //   170: iload_3
    //   171: iand
    //   172: ifeq -> 84
    //   175: aload_0
    //   176: getfield mCallback : Landroid/support/v4/widget/ViewDragHelper$Callback;
    //   179: iload_3
    //   180: aload_0
    //   181: getfield mTrackingEdges : I
    //   184: iand
    //   185: iload_2
    //   186: invokevirtual onEdgeTouched : (II)V
    //   189: goto -> 84
    //   192: aload_1
    //   193: iload_3
    //   194: invokevirtual getPointerId : (I)I
    //   197: istore_2
    //   198: aload_1
    //   199: iload_3
    //   200: invokevirtual getX : (I)F
    //   203: fstore #6
    //   205: aload_1
    //   206: iload_3
    //   207: invokevirtual getY : (I)F
    //   210: fstore #5
    //   212: aload_0
    //   213: fload #6
    //   215: fload #5
    //   217: iload_2
    //   218: invokespecial saveInitialMotion : (FFI)V
    //   221: aload_0
    //   222: getfield mDragState : I
    //   225: ifne -> 261
    //   228: aload_0
    //   229: getfield mInitialEdgesTouched : [I
    //   232: iload_2
    //   233: iaload
    //   234: istore_3
    //   235: aload_0
    //   236: getfield mTrackingEdges : I
    //   239: iload_3
    //   240: iand
    //   241: ifeq -> 84
    //   244: aload_0
    //   245: getfield mCallback : Landroid/support/v4/widget/ViewDragHelper$Callback;
    //   248: iload_3
    //   249: aload_0
    //   250: getfield mTrackingEdges : I
    //   253: iand
    //   254: iload_2
    //   255: invokevirtual onEdgeTouched : (II)V
    //   258: goto -> 84
    //   261: aload_0
    //   262: getfield mDragState : I
    //   265: iconst_2
    //   266: if_icmpne -> 84
    //   269: aload_0
    //   270: fload #6
    //   272: f2i
    //   273: fload #5
    //   275: f2i
    //   276: invokevirtual findTopChildUnder : (II)Landroid/view/View;
    //   279: astore_1
    //   280: aload_1
    //   281: aload_0
    //   282: getfield mCapturedView : Landroid/view/View;
    //   285: if_acmpne -> 84
    //   288: aload_0
    //   289: aload_1
    //   290: iload_2
    //   291: invokevirtual tryCaptureViewForDrag : (Landroid/view/View;I)Z
    //   294: pop
    //   295: goto -> 84
    //   298: aload_0
    //   299: getfield mInitialMotionX : [F
    //   302: ifnull -> 84
    //   305: aload_0
    //   306: getfield mInitialMotionY : [F
    //   309: ifnull -> 84
    //   312: aload_1
    //   313: invokevirtual getPointerCount : ()I
    //   316: istore #7
    //   318: iconst_0
    //   319: istore_3
    //   320: iload_3
    //   321: iload #7
    //   323: if_icmpge -> 540
    //   326: aload_1
    //   327: iload_3
    //   328: invokevirtual getPointerId : (I)I
    //   331: istore #8
    //   333: aload_0
    //   334: iload #8
    //   336: invokespecial isValidPointerForActionMove : (I)Z
    //   339: ifne -> 348
    //   342: iinc #3, 1
    //   345: goto -> 320
    //   348: aload_1
    //   349: iload_3
    //   350: invokevirtual getX : (I)F
    //   353: fstore #6
    //   355: aload_1
    //   356: iload_3
    //   357: invokevirtual getY : (I)F
    //   360: fstore #9
    //   362: fload #6
    //   364: aload_0
    //   365: getfield mInitialMotionX : [F
    //   368: iload #8
    //   370: faload
    //   371: fsub
    //   372: fstore #10
    //   374: fload #9
    //   376: aload_0
    //   377: getfield mInitialMotionY : [F
    //   380: iload #8
    //   382: faload
    //   383: fsub
    //   384: fstore #5
    //   386: aload_0
    //   387: fload #6
    //   389: f2i
    //   390: fload #9
    //   392: f2i
    //   393: invokevirtual findTopChildUnder : (II)Landroid/view/View;
    //   396: astore #11
    //   398: aload #11
    //   400: ifnull -> 548
    //   403: aload_0
    //   404: aload #11
    //   406: fload #10
    //   408: fload #5
    //   410: invokespecial checkTouchSlop : (Landroid/view/View;FF)Z
    //   413: ifeq -> 548
    //   416: iconst_1
    //   417: istore_2
    //   418: iload_2
    //   419: ifeq -> 553
    //   422: aload #11
    //   424: invokevirtual getLeft : ()I
    //   427: istore #12
    //   429: fload #10
    //   431: f2i
    //   432: istore #13
    //   434: aload_0
    //   435: getfield mCallback : Landroid/support/v4/widget/ViewDragHelper$Callback;
    //   438: aload #11
    //   440: iload #13
    //   442: iload #12
    //   444: iadd
    //   445: fload #10
    //   447: f2i
    //   448: invokevirtual clampViewPositionHorizontal : (Landroid/view/View;II)I
    //   451: istore #13
    //   453: aload #11
    //   455: invokevirtual getTop : ()I
    //   458: istore #14
    //   460: fload #5
    //   462: f2i
    //   463: istore #15
    //   465: aload_0
    //   466: getfield mCallback : Landroid/support/v4/widget/ViewDragHelper$Callback;
    //   469: aload #11
    //   471: iload #15
    //   473: iload #14
    //   475: iadd
    //   476: fload #5
    //   478: f2i
    //   479: invokevirtual clampViewPositionVertical : (Landroid/view/View;II)I
    //   482: istore #15
    //   484: aload_0
    //   485: getfield mCallback : Landroid/support/v4/widget/ViewDragHelper$Callback;
    //   488: aload #11
    //   490: invokevirtual getViewHorizontalDragRange : (Landroid/view/View;)I
    //   493: istore #16
    //   495: aload_0
    //   496: getfield mCallback : Landroid/support/v4/widget/ViewDragHelper$Callback;
    //   499: aload #11
    //   501: invokevirtual getViewVerticalDragRange : (Landroid/view/View;)I
    //   504: istore #17
    //   506: iload #16
    //   508: ifeq -> 523
    //   511: iload #16
    //   513: ifle -> 553
    //   516: iload #13
    //   518: iload #12
    //   520: if_icmpne -> 553
    //   523: iload #17
    //   525: ifeq -> 540
    //   528: iload #17
    //   530: ifle -> 553
    //   533: iload #15
    //   535: iload #14
    //   537: if_icmpne -> 553
    //   540: aload_0
    //   541: aload_1
    //   542: invokespecial saveLastMotion : (Landroid/view/MotionEvent;)V
    //   545: goto -> 84
    //   548: iconst_0
    //   549: istore_2
    //   550: goto -> 418
    //   553: aload_0
    //   554: fload #10
    //   556: fload #5
    //   558: iload #8
    //   560: invokespecial reportNewEdgeDrags : (FFI)V
    //   563: aload_0
    //   564: getfield mDragState : I
    //   567: iconst_1
    //   568: if_icmpeq -> 540
    //   571: iload_2
    //   572: ifeq -> 342
    //   575: aload_0
    //   576: aload #11
    //   578: iload #8
    //   580: invokevirtual tryCaptureViewForDrag : (Landroid/view/View;I)Z
    //   583: ifeq -> 342
    //   586: goto -> 540
    //   589: aload_0
    //   590: aload_1
    //   591: iload_3
    //   592: invokevirtual getPointerId : (I)I
    //   595: invokespecial clearMotionHistory : (I)V
    //   598: goto -> 84
    //   601: aload_0
    //   602: invokevirtual cancel : ()V
    //   605: goto -> 84
    //   608: iconst_0
    //   609: istore #4
    //   611: goto -> 95
  }
  
  public boolean smoothSlideViewTo(View paramView, int paramInt1, int paramInt2) {
    this.mCapturedView = paramView;
    this.mActivePointerId = -1;
    boolean bool = forceSettleCapturedViewAt(paramInt1, paramInt2, 0, 0);
    if (!bool && this.mDragState == 0 && this.mCapturedView != null)
      this.mCapturedView = null; 
    return bool;
  }
  
  boolean tryCaptureViewForDrag(View paramView, int paramInt) {
    boolean bool = true;
    if (paramView != this.mCapturedView || this.mActivePointerId != paramInt) {
      if (paramView != null && this.mCallback.tryCaptureView(paramView, paramInt)) {
        this.mActivePointerId = paramInt;
        captureChildView(paramView, paramInt);
        return bool;
      } 
      bool = false;
    } 
    return bool;
  }
  
  public static abstract class Callback {
    public int clampViewPositionHorizontal(View param1View, int param1Int1, int param1Int2) {
      return 0;
    }
    
    public int clampViewPositionVertical(View param1View, int param1Int1, int param1Int2) {
      return 0;
    }
    
    public int getOrderedChildIndex(int param1Int) {
      return param1Int;
    }
    
    public int getViewHorizontalDragRange(View param1View) {
      return 0;
    }
    
    public int getViewVerticalDragRange(View param1View) {
      return 0;
    }
    
    public void onEdgeDragStarted(int param1Int1, int param1Int2) {}
    
    public boolean onEdgeLock(int param1Int) {
      return false;
    }
    
    public void onEdgeTouched(int param1Int1, int param1Int2) {}
    
    public void onViewCaptured(View param1View, int param1Int) {}
    
    public void onViewDragStateChanged(int param1Int) {}
    
    public void onViewPositionChanged(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {}
    
    public void onViewReleased(View param1View, float param1Float1, float param1Float2) {}
    
    public abstract boolean tryCaptureView(View param1View, int param1Int);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\widget\ViewDragHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */