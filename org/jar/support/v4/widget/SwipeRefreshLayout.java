package org.jar.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import org.jar.support.v4.view.MotionEventCompat;
import org.jar.support.v4.view.NestedScrollingChild;
import org.jar.support.v4.view.NestedScrollingChildHelper;
import org.jar.support.v4.view.NestedScrollingParent;
import org.jar.support.v4.view.NestedScrollingParentHelper;
import org.jar.support.v4.view.ViewCompat;

public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
  private static final int ALPHA_ANIMATION_DURATION = 300;
  
  private static final int ANIMATE_TO_START_DURATION = 200;
  
  private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
  
  private static final int CIRCLE_BG_LIGHT = -328966;
  
  private static final int CIRCLE_DIAMETER = 40;
  
  private static final int CIRCLE_DIAMETER_LARGE = 56;
  
  private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0F;
  
  public static final int DEFAULT = 1;
  
  private static final int DEFAULT_CIRCLE_TARGET = 64;
  
  private static final float DRAG_RATE = 0.5F;
  
  private static final int INVALID_POINTER = -1;
  
  public static final int LARGE = 0;
  
  private static final int[] LAYOUT_ATTRS = new int[] { 16842766 };
  
  private static final String LOG_TAG = "SwipeRefreshLayout";
  
  private static final int MAX_ALPHA = 255;
  
  private static final float MAX_PROGRESS_ANGLE = 0.8F;
  
  private static final int SCALE_DOWN_DURATION = 150;
  
  private static final int STARTING_PROGRESS_ALPHA = 76;
  
  private int mActivePointerId = -1;
  
  private Animation mAlphaMaxAnimation;
  
  private Animation mAlphaStartAnimation;
  
  private final Animation mAnimateToCorrectPosition = new Animation() {
      public void applyTransformation(float param1Float, Transformation param1Transformation) {
        if (!SwipeRefreshLayout.this.mUsingCustomStart) {
          i = (int)(SwipeRefreshLayout.this.mSpinnerFinalOffset - Math.abs(SwipeRefreshLayout.this.mOriginalOffsetTop));
        } else {
          i = (int)SwipeRefreshLayout.this.mSpinnerFinalOffset;
        } 
        int j = SwipeRefreshLayout.this.mFrom;
        int k = (int)((i - SwipeRefreshLayout.this.mFrom) * param1Float);
        int i = SwipeRefreshLayout.this.mCircleView.getTop();
        SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(j + k - i, false);
        SwipeRefreshLayout.this.mProgress.setArrowScale(1.0F - param1Float);
      }
    };
  
  private final Animation mAnimateToStartPosition = new Animation() {
      public void applyTransformation(float param1Float, Transformation param1Transformation) {
        SwipeRefreshLayout.this.moveToStart(param1Float);
      }
    };
  
  private int mCircleHeight;
  
  private CircleImageView mCircleView;
  
  private int mCircleViewIndex = -1;
  
  private int mCircleWidth;
  
  private int mCurrentTargetOffsetTop;
  
  private final DecelerateInterpolator mDecelerateInterpolator;
  
  protected int mFrom;
  
  private float mInitialDownY;
  
  private float mInitialMotionY;
  
  private boolean mIsBeingDragged;
  
  private OnRefreshListener mListener;
  
  private int mMediumAnimationDuration;
  
  private boolean mNestedScrollInProgress;
  
  private final NestedScrollingChildHelper mNestedScrollingChildHelper;
  
  private final NestedScrollingParentHelper mNestedScrollingParentHelper;
  
  private boolean mNotify;
  
  private boolean mOriginalOffsetCalculated = false;
  
  protected int mOriginalOffsetTop;
  
  private final int[] mParentOffsetInWindow = new int[2];
  
  private final int[] mParentScrollConsumed = new int[2];
  
  private MaterialProgressDrawable mProgress;
  
  private Animation.AnimationListener mRefreshListener = new Animation.AnimationListener() {
      public void onAnimationEnd(Animation param1Animation) {
        if (SwipeRefreshLayout.this.mRefreshing) {
          SwipeRefreshLayout.this.mProgress.setAlpha(255);
          SwipeRefreshLayout.this.mProgress.start();
          if (SwipeRefreshLayout.this.mNotify && SwipeRefreshLayout.this.mListener != null)
            SwipeRefreshLayout.this.mListener.onRefresh(); 
          SwipeRefreshLayout.access$402(SwipeRefreshLayout.this, SwipeRefreshLayout.this.mCircleView.getTop());
        } else {
          SwipeRefreshLayout.this.reset();
        } 
      }
      
      public void onAnimationRepeat(Animation param1Animation) {}
      
      public void onAnimationStart(Animation param1Animation) {}
    };
  
  private boolean mRefreshing = false;
  
  private boolean mReturningToStart;
  
  private boolean mScale;
  
  private Animation mScaleAnimation;
  
  private Animation mScaleDownAnimation;
  
  private Animation mScaleDownToStartAnimation;
  
  private float mSpinnerFinalOffset;
  
  private float mStartingScale;
  
  private View mTarget;
  
  private float mTotalDragDistance = -1.0F;
  
  private float mTotalUnconsumed;
  
  private int mTouchSlop;
  
  private boolean mUsingCustomStart;
  
  public SwipeRefreshLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mMediumAnimationDuration = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.mDecelerateInterpolator = new DecelerateInterpolator(2.0F);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, LAYOUT_ATTRS);
    setEnabled(typedArray.getBoolean(0, true));
    typedArray.recycle();
    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
    this.mCircleWidth = (int)(displayMetrics.density * 40.0F);
    this.mCircleHeight = (int)(displayMetrics.density * 40.0F);
    createProgressView();
    ViewCompat.setChildrenDrawingOrderEnabled(this, true);
    this.mSpinnerFinalOffset = displayMetrics.density * 64.0F;
    this.mTotalDragDistance = this.mSpinnerFinalOffset;
    this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    this.mNestedScrollingChildHelper = new NestedScrollingChildHelper((View)this);
    setNestedScrollingEnabled(true);
  }
  
  private void animateOffsetToCorrectPosition(int paramInt, Animation.AnimationListener paramAnimationListener) {
    this.mFrom = paramInt;
    this.mAnimateToCorrectPosition.reset();
    this.mAnimateToCorrectPosition.setDuration(200L);
    this.mAnimateToCorrectPosition.setInterpolator((Interpolator)this.mDecelerateInterpolator);
    if (paramAnimationListener != null)
      this.mCircleView.setAnimationListener(paramAnimationListener); 
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
  }
  
  private void animateOffsetToStartPosition(int paramInt, Animation.AnimationListener paramAnimationListener) {
    if (this.mScale) {
      startScaleDownReturnToStartAnimation(paramInt, paramAnimationListener);
    } else {
      this.mFrom = paramInt;
      this.mAnimateToStartPosition.reset();
      this.mAnimateToStartPosition.setDuration(200L);
      this.mAnimateToStartPosition.setInterpolator((Interpolator)this.mDecelerateInterpolator);
      if (paramAnimationListener != null)
        this.mCircleView.setAnimationListener(paramAnimationListener); 
      this.mCircleView.clearAnimation();
      this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    } 
  }
  
  private void createProgressView() {
    this.mCircleView = new CircleImageView(getContext(), -328966, 20.0F);
    this.mProgress = new MaterialProgressDrawable(getContext(), (View)this);
    this.mProgress.setBackgroundColor(-328966);
    this.mCircleView.setImageDrawable(this.mProgress);
    this.mCircleView.setVisibility(8);
    addView((View)this.mCircleView);
  }
  
  private void ensureTarget() {
    if (this.mTarget == null)
      for (byte b = 0; b < getChildCount(); b++) {
        View view = getChildAt(b);
        if (!view.equals(this.mCircleView)) {
          this.mTarget = view;
          break;
        } 
      }  
  }
  
  private void finishSpinner(float paramFloat) {
    if (paramFloat > this.mTotalDragDistance) {
      setRefreshing(true, true);
    } else {
      this.mRefreshing = false;
      this.mProgress.setStartEndTrim(0.0F, 0.0F);
      Animation.AnimationListener animationListener = null;
      if (!this.mScale)
        animationListener = new Animation.AnimationListener() {
            public void onAnimationEnd(Animation param1Animation) {
              if (!SwipeRefreshLayout.this.mScale)
                SwipeRefreshLayout.this.startScaleDownAnimation((Animation.AnimationListener)null); 
            }
            
            public void onAnimationRepeat(Animation param1Animation) {}
            
            public void onAnimationStart(Animation param1Animation) {}
          }; 
      animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, animationListener);
      this.mProgress.showArrow(false);
    } 
  }
  
  private float getMotionEventY(MotionEvent paramMotionEvent, int paramInt) {
    paramInt = MotionEventCompat.findPointerIndex(paramMotionEvent, paramInt);
    return (paramInt < 0) ? -1.0F : MotionEventCompat.getY(paramMotionEvent, paramInt);
  }
  
  private boolean isAlphaUsedForScale() {
    boolean bool;
    if (Build.VERSION.SDK_INT < 11) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private boolean isAnimationRunning(Animation paramAnimation) {
    boolean bool;
    if (paramAnimation != null && paramAnimation.hasStarted() && !paramAnimation.hasEnded()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private void moveSpinner(float paramFloat) {
    float f5;
    this.mProgress.showArrow(true);
    float f1 = Math.min(1.0F, Math.abs(paramFloat / this.mTotalDragDistance));
    double d1 = f1;
    Double.isNaN(d1);
    float f2 = (float)Math.max(d1 - 0.4D, 0.0D) * 5.0F / 3.0F;
    float f3 = Math.abs(paramFloat);
    float f4 = this.mTotalDragDistance;
    if (this.mUsingCustomStart) {
      f5 = this.mSpinnerFinalOffset - this.mOriginalOffsetTop;
    } else {
      f5 = this.mSpinnerFinalOffset;
    } 
    double d2 = (Math.max(0.0F, Math.min(f3 - f4, f5 * 2.0F) / f5) / 4.0F);
    d1 = Math.pow(d2, 2.0D);
    Double.isNaN(d2);
    f3 = (float)(d2 - d1) * 2.0F;
    int i = this.mOriginalOffsetTop;
    int j = (int)(f5 * f1 + f5 * f3 * 2.0F);
    if (this.mCircleView.getVisibility() != 0)
      this.mCircleView.setVisibility(0); 
    if (!this.mScale) {
      ViewCompat.setScaleX((View)this.mCircleView, 1.0F);
      ViewCompat.setScaleY((View)this.mCircleView, 1.0F);
    } 
    if (this.mScale)
      setAnimationProgress(Math.min(1.0F, paramFloat / this.mTotalDragDistance)); 
    if (paramFloat < this.mTotalDragDistance) {
      if (this.mProgress.getAlpha() > 76 && !isAnimationRunning(this.mAlphaStartAnimation))
        startProgressAlphaStartAnimation(); 
    } else if (this.mProgress.getAlpha() < 255 && !isAnimationRunning(this.mAlphaMaxAnimation)) {
      startProgressAlphaMaxAnimation();
    } 
    this.mProgress.setStartEndTrim(0.0F, Math.min(0.8F, f2 * 0.8F));
    this.mProgress.setArrowScale(Math.min(1.0F, f2));
    this.mProgress.setProgressRotation((f2 * 0.4F - 0.25F + f3 * 2.0F) * 0.5F);
    setTargetOffsetTopAndBottom(i + j - this.mCurrentTargetOffsetTop, true);
  }
  
  private void moveToStart(float paramFloat) {
    setTargetOffsetTopAndBottom(this.mFrom + (int)((this.mOriginalOffsetTop - this.mFrom) * paramFloat) - this.mCircleView.getTop(), false);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent) {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == this.mActivePointerId) {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
    } 
  }
  
  private void reset() {
    this.mCircleView.clearAnimation();
    this.mProgress.stop();
    this.mCircleView.setVisibility(8);
    setColorViewAlpha(255);
    if (this.mScale) {
      setAnimationProgress(0.0F);
    } else {
      setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop, true);
    } 
    this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
  }
  
  private void setAnimationProgress(float paramFloat) {
    if (isAlphaUsedForScale()) {
      setColorViewAlpha((int)(paramFloat * 255.0F));
    } else {
      ViewCompat.setScaleX((View)this.mCircleView, paramFloat);
      ViewCompat.setScaleY((View)this.mCircleView, paramFloat);
    } 
  }
  
  private void setColorViewAlpha(int paramInt) {
    this.mCircleView.getBackground().setAlpha(paramInt);
    this.mProgress.setAlpha(paramInt);
  }
  
  private void setRefreshing(boolean paramBoolean1, boolean paramBoolean2) {
    if (this.mRefreshing != paramBoolean1) {
      this.mNotify = paramBoolean2;
      ensureTarget();
      this.mRefreshing = paramBoolean1;
      if (this.mRefreshing) {
        animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
      } else {
        startScaleDownAnimation(this.mRefreshListener);
      } 
    } 
  }
  
  private void setTargetOffsetTopAndBottom(int paramInt, boolean paramBoolean) {
    this.mCircleView.bringToFront();
    this.mCircleView.offsetTopAndBottom(paramInt);
    this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    if (paramBoolean && Build.VERSION.SDK_INT < 11)
      invalidate(); 
  }
  
  private Animation startAlphaAnimation(final int startingAlpha, final int endingAlpha) {
    if (this.mScale && isAlphaUsedForScale())
      return null; 
    Animation animation = new Animation() {
        public void applyTransformation(float param1Float, Transformation param1Transformation) {
          SwipeRefreshLayout.this.mProgress.setAlpha((int)(startingAlpha + (endingAlpha - startingAlpha) * param1Float));
        }
      };
    animation.setDuration(300L);
    this.mCircleView.setAnimationListener((Animation.AnimationListener)null);
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(animation);
    return animation;
  }
  
  private void startProgressAlphaMaxAnimation() {
    this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
  }
  
  private void startProgressAlphaStartAnimation() {
    this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
  }
  
  private void startScaleDownAnimation(Animation.AnimationListener paramAnimationListener) {
    this.mScaleDownAnimation = new Animation() {
        public void applyTransformation(float param1Float, Transformation param1Transformation) {
          SwipeRefreshLayout.this.setAnimationProgress(1.0F - param1Float);
        }
      };
    this.mScaleDownAnimation.setDuration(150L);
    this.mCircleView.setAnimationListener(paramAnimationListener);
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mScaleDownAnimation);
  }
  
  private void startScaleDownReturnToStartAnimation(int paramInt, Animation.AnimationListener paramAnimationListener) {
    this.mFrom = paramInt;
    if (isAlphaUsedForScale()) {
      this.mStartingScale = this.mProgress.getAlpha();
    } else {
      this.mStartingScale = ViewCompat.getScaleX((View)this.mCircleView);
    } 
    this.mScaleDownToStartAnimation = new Animation() {
        public void applyTransformation(float param1Float, Transformation param1Transformation) {
          float f1 = SwipeRefreshLayout.this.mStartingScale;
          float f2 = -SwipeRefreshLayout.this.mStartingScale;
          SwipeRefreshLayout.this.setAnimationProgress(f1 + f2 * param1Float);
          SwipeRefreshLayout.this.moveToStart(param1Float);
        }
      };
    this.mScaleDownToStartAnimation.setDuration(150L);
    if (paramAnimationListener != null)
      this.mCircleView.setAnimationListener(paramAnimationListener); 
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
  }
  
  private void startScaleUpAnimation(Animation.AnimationListener paramAnimationListener) {
    this.mCircleView.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 11)
      this.mProgress.setAlpha(255); 
    this.mScaleAnimation = new Animation() {
        public void applyTransformation(float param1Float, Transformation param1Transformation) {
          SwipeRefreshLayout.this.setAnimationProgress(param1Float);
        }
      };
    this.mScaleAnimation.setDuration(this.mMediumAnimationDuration);
    if (paramAnimationListener != null)
      this.mCircleView.setAnimationListener(paramAnimationListener); 
    this.mCircleView.clearAnimation();
    this.mCircleView.startAnimation(this.mScaleAnimation);
  }
  
  public boolean canChildScrollUp() {
    if (Build.VERSION.SDK_INT < 14) {
      boolean bool = this.mTarget instanceof AbsListView;
      boolean bool1 = true;
      boolean bool2 = true;
      if (bool) {
        AbsListView absListView = (AbsListView)this.mTarget;
        if (absListView.getChildCount() > 0) {
          bool = bool2;
          if (absListView.getFirstVisiblePosition() <= 0) {
            if (absListView.getChildAt(0).getTop() < absListView.getPaddingTop())
              return bool2; 
          } else {
            return bool;
          } 
        } 
        return false;
      } 
      bool = bool1;
      if (!ViewCompat.canScrollVertically(this.mTarget, -1))
        if (this.mTarget.getScrollY() > 0) {
          bool = bool1;
        } else {
          bool = false;
        }  
      return bool;
    } 
    return ViewCompat.canScrollVertically(this.mTarget, -1);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return this.mNestedScrollingChildHelper.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2) {
    return this.mNestedScrollingChildHelper.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2) {
    return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    return this.mNestedScrollingChildHelper.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2) {
    return (this.mCircleViewIndex < 0) ? paramInt2 : ((paramInt2 == paramInt1 - 1) ? this.mCircleViewIndex : ((paramInt2 >= this.mCircleViewIndex) ? (paramInt2 + 1) : paramInt2));
  }
  
  public int getNestedScrollAxes() {
    return this.mNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  public int getProgressCircleDiameter() {
    boolean bool;
    if (this.mCircleView != null) {
      bool = this.mCircleView.getMeasuredHeight();
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasNestedScrollingParent() {
    return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
  }
  
  public boolean isNestedScrollingEnabled() {
    return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
  }
  
  public boolean isRefreshing() {
    return this.mRefreshing;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    reset();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    ensureTarget();
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (this.mReturningToStart && i == 0)
      this.mReturningToStart = false; 
    if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress)
      return false; 
    if (i != 6) {
      switch (i) {
        default:
          return this.mIsBeingDragged;
        case 2:
          if (this.mActivePointerId == -1) {
            Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
            return false;
          } 
          f = getMotionEventY(paramMotionEvent, this.mActivePointerId);
          if (f == -1.0F)
            return false; 
          if (f - this.mInitialDownY > this.mTouchSlop && !this.mIsBeingDragged) {
            this.mInitialMotionY = this.mInitialDownY + this.mTouchSlop;
            this.mIsBeingDragged = true;
            this.mProgress.setAlpha(76);
          } 
        case 1:
        case 3:
          this.mIsBeingDragged = false;
          this.mActivePointerId = -1;
        case 0:
          break;
      } 
      setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop(), true);
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      this.mIsBeingDragged = false;
      float f = getMotionEventY(paramMotionEvent, this.mActivePointerId);
      if (f == -1.0F)
        return false; 
      this.mInitialDownY = f;
    } 
    onSecondaryPointerUp(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt1 = getMeasuredWidth();
    paramInt4 = getMeasuredHeight();
    if (getChildCount() == 0)
      return; 
    if (this.mTarget == null)
      ensureTarget(); 
    if (this.mTarget == null)
      return; 
    View view = this.mTarget;
    paramInt2 = getPaddingLeft();
    paramInt3 = getPaddingTop();
    view.layout(paramInt2, paramInt3, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt2, paramInt4 - getPaddingTop() - getPaddingBottom() + paramInt3);
    paramInt3 = this.mCircleView.getMeasuredWidth();
    paramInt2 = this.mCircleView.getMeasuredHeight();
    CircleImageView circleImageView = this.mCircleView;
    paramInt1 /= 2;
    paramInt3 /= 2;
    circleImageView.layout(paramInt1 - paramInt3, this.mCurrentTargetOffsetTop, paramInt1 + paramInt3, this.mCurrentTargetOffsetTop + paramInt2);
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mTarget == null)
      ensureTarget(); 
    if (this.mTarget == null)
      return; 
    this.mTarget.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
    this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleHeight, 1073741824));
    if (!this.mUsingCustomStart && !this.mOriginalOffsetCalculated) {
      this.mOriginalOffsetCalculated = true;
      paramInt1 = -this.mCircleView.getMeasuredHeight();
      this.mOriginalOffsetTop = paramInt1;
      this.mCurrentTargetOffsetTop = paramInt1;
    } 
    this.mCircleViewIndex = -1;
    for (paramInt1 = 0; paramInt1 < getChildCount(); paramInt1++) {
      if (getChildAt(paramInt1) == this.mCircleView) {
        this.mCircleViewIndex = paramInt1;
        break;
      } 
    } 
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2) {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint) {
    if (paramInt2 > 0 && this.mTotalUnconsumed > 0.0F) {
      float f = paramInt2;
      if (f > this.mTotalUnconsumed) {
        paramArrayOfint[1] = paramInt2 - (int)this.mTotalUnconsumed;
        this.mTotalUnconsumed = 0.0F;
      } else {
        this.mTotalUnconsumed -= f;
        paramArrayOfint[1] = paramInt2;
      } 
      moveSpinner(this.mTotalUnconsumed);
    } 
    if (this.mUsingCustomStart && paramInt2 > 0 && this.mTotalUnconsumed == 0.0F && Math.abs(paramInt2 - paramArrayOfint[1]) > 0)
      this.mCircleView.setVisibility(8); 
    int[] arrayOfInt = this.mParentScrollConsumed;
    if (dispatchNestedPreScroll(paramInt1 - paramArrayOfint[0], paramInt2 - paramArrayOfint[1], arrayOfInt, (int[])null)) {
      paramArrayOfint[0] = paramArrayOfint[0] + arrayOfInt[0];
      paramArrayOfint[1] = paramArrayOfint[1] + arrayOfInt[1];
    } 
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.mParentOffsetInWindow);
    paramInt1 = paramInt4 + this.mParentOffsetInWindow[1];
    if (paramInt1 < 0 && !canChildScrollUp()) {
      this.mTotalUnconsumed += Math.abs(paramInt1);
      moveSpinner(this.mTotalUnconsumed);
    } 
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) {
    this.mNestedScrollingParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    startNestedScroll(paramInt & 0x2);
    this.mTotalUnconsumed = 0.0F;
    this.mNestedScrollInProgress = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt) {
    boolean bool;
    if (isEnabled() && !this.mReturningToStart && !this.mRefreshing && (paramInt & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void onStopNestedScroll(View paramView) {
    this.mNestedScrollingParentHelper.onStopNestedScroll(paramView);
    this.mNestedScrollInProgress = false;
    if (this.mTotalUnconsumed > 0.0F) {
      finishSpinner(this.mTotalUnconsumed);
      this.mTotalUnconsumed = 0.0F;
    } 
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    float f1;
    float f2;
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (this.mReturningToStart && i == 0)
      this.mReturningToStart = false; 
    if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mNestedScrollInProgress)
      return false; 
    switch (i) {
      default:
        return true;
      case 6:
        onSecondaryPointerUp(paramMotionEvent);
      case 5:
        i = MotionEventCompat.getActionIndex(paramMotionEvent);
        if (i < 0) {
          Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
          return false;
        } 
        this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      case 3:
        return false;
      case 2:
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
        if (i < 0) {
          Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
          return false;
        } 
        f1 = (MotionEventCompat.getY(paramMotionEvent, i) - this.mInitialMotionY) * 0.5F;
        if (this.mIsBeingDragged)
          if (f1 > 0.0F) {
            moveSpinner(f1);
          } else {
            return false;
          }  
      case 1:
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
        if (i < 0) {
          Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
          return false;
        } 
        f2 = MotionEventCompat.getY(paramMotionEvent, i);
        f1 = this.mInitialMotionY;
        this.mIsBeingDragged = false;
        finishSpinner((f2 - f1) * 0.5F);
        this.mActivePointerId = -1;
        return false;
      case 0:
        break;
    } 
    this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
    this.mIsBeingDragged = false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
    if ((Build.VERSION.SDK_INT >= 21 || !(this.mTarget instanceof AbsListView)) && (this.mTarget == null || ViewCompat.isNestedScrollingEnabled(this.mTarget)))
      super.requestDisallowInterceptTouchEvent(paramBoolean); 
  }
  
  @Deprecated
  public void setColorScheme(int... paramVarArgs) {
    setColorSchemeResources(paramVarArgs);
  }
  
  public void setColorSchemeColors(int... paramVarArgs) {
    ensureTarget();
    this.mProgress.setColorSchemeColors(paramVarArgs);
  }
  
  public void setColorSchemeResources(int... paramVarArgs) {
    Resources resources = getResources();
    int[] arrayOfInt = new int[paramVarArgs.length];
    for (byte b = 0; b < paramVarArgs.length; b++)
      arrayOfInt[b] = resources.getColor(paramVarArgs[b]); 
    setColorSchemeColors(arrayOfInt);
  }
  
  public void setDistanceToTriggerSync(int paramInt) {
    this.mTotalDragDistance = paramInt;
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean) {
    this.mNestedScrollingChildHelper.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnRefreshListener(OnRefreshListener paramOnRefreshListener) {
    this.mListener = paramOnRefreshListener;
  }
  
  @Deprecated
  public void setProgressBackgroundColor(int paramInt) {
    setProgressBackgroundColorSchemeResource(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeColor(int paramInt) {
    this.mCircleView.setBackgroundColor(paramInt);
    this.mProgress.setBackgroundColor(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeResource(int paramInt) {
    setProgressBackgroundColorSchemeColor(getResources().getColor(paramInt));
  }
  
  public void setProgressViewEndTarget(boolean paramBoolean, int paramInt) {
    this.mSpinnerFinalOffset = paramInt;
    this.mScale = paramBoolean;
    this.mCircleView.invalidate();
  }
  
  public void setProgressViewOffset(boolean paramBoolean, int paramInt1, int paramInt2) {
    this.mScale = paramBoolean;
    this.mCircleView.setVisibility(8);
    this.mCurrentTargetOffsetTop = paramInt1;
    this.mOriginalOffsetTop = paramInt1;
    this.mSpinnerFinalOffset = paramInt2;
    this.mUsingCustomStart = true;
    this.mCircleView.invalidate();
  }
  
  public void setRefreshing(boolean paramBoolean) {
    if (paramBoolean && this.mRefreshing != paramBoolean) {
      int i;
      this.mRefreshing = paramBoolean;
      if (!this.mUsingCustomStart) {
        i = (int)(this.mSpinnerFinalOffset + this.mOriginalOffsetTop);
      } else {
        i = (int)this.mSpinnerFinalOffset;
      } 
      setTargetOffsetTopAndBottom(i - this.mCurrentTargetOffsetTop, true);
      this.mNotify = false;
      startScaleUpAnimation(this.mRefreshListener);
    } else {
      setRefreshing(paramBoolean, false);
    } 
  }
  
  public void setSize(int paramInt) {
    if (paramInt != 0 && paramInt != 1)
      return; 
    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
    if (paramInt == 0) {
      int i = (int)(displayMetrics.density * 56.0F);
      this.mCircleWidth = i;
      this.mCircleHeight = i;
    } else {
      int i = (int)(displayMetrics.density * 40.0F);
      this.mCircleWidth = i;
      this.mCircleHeight = i;
    } 
    this.mCircleView.setImageDrawable(null);
    this.mProgress.updateSizes(paramInt);
    this.mCircleView.setImageDrawable(this.mProgress);
  }
  
  public boolean startNestedScroll(int paramInt) {
    return this.mNestedScrollingChildHelper.startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll() {
    this.mNestedScrollingChildHelper.stopNestedScroll();
  }
  
  public static interface OnRefreshListener {
    void onRefresh();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\widget\SwipeRefreshLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */