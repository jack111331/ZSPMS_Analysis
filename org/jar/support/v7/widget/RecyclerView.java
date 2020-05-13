package org.jar.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jar.support.annotation.CallSuper;
import org.jar.support.annotation.NonNull;
import org.jar.support.annotation.Nullable;
import org.jar.support.annotation.VisibleForTesting;
import org.jar.support.v4.os.ParcelableCompat;
import org.jar.support.v4.os.ParcelableCompatCreatorCallbacks;
import org.jar.support.v4.os.TraceCompat;
import org.jar.support.v4.view.AbsSavedState;
import org.jar.support.v4.view.MotionEventCompat;
import org.jar.support.v4.view.NestedScrollingChild;
import org.jar.support.v4.view.NestedScrollingChildHelper;
import org.jar.support.v4.view.ScrollingView;
import org.jar.support.v4.view.VelocityTrackerCompat;
import org.jar.support.v4.view.ViewCompat;
import org.jar.support.v4.view.ViewConfigurationCompat;
import org.jar.support.v4.widget.EdgeEffectCompat;
import org.jar.support.v4.widget.ScrollerCompat;

public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild {
  static {
    CLIP_TO_PADDING_ATTR = new int[] { 16842987 };
    if (Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20) {
      bool = true;
    } else {
      bool = false;
    } 
    FORCE_INVALIDATE_DISPLAY_LIST = bool;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = true;
    } else {
      bool = false;
    } 
    ALLOW_SIZE_IN_UNSPECIFIED_SPEC = bool;
    LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[] { Context.class, AttributeSet.class, int.class, int.class };
    sQuinticInterpolator = new Interpolator() {
        public float getInterpolation(float param1Float) {
          param1Float--;
          return param1Float * param1Float * param1Float * param1Float * param1Float + 1.0F;
        }
      };
  }
  
  public RecyclerView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public RecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool1 = false;
    this.mEatRequestLayout = 0;
    this.mDataSetHasChangedAfterLayout = false;
    this.mLayoutOrScrollCounter = 0;
    this.mItemAnimator = new DefaultItemAnimator();
    this.mScrollState = 0;
    this.mScrollPointerId = -1;
    this.mScrollFactor = Float.MIN_VALUE;
    this.mPreserveFocusAfterLayout = true;
    this.mViewFlinger = new ViewFlinger();
    this.mState = new State();
    this.mItemsAddedOrRemoved = false;
    this.mItemsChanged = false;
    this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
    this.mPostedAnimatorRunner = false;
    this.mMinMaxLayoutPositions = new int[2];
    this.mScrollOffset = new int[2];
    this.mScrollConsumed = new int[2];
    this.mNestedOffsets = new int[2];
    this.mItemAnimatorRunner = new Runnable() {
        public void run() {
          if (RecyclerView.this.mItemAnimator != null)
            RecyclerView.this.mItemAnimator.runPendingAnimations(); 
          RecyclerView.access$602(RecyclerView.this, false);
        }
      };
    this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback() {
        public void processAppeared(RecyclerView.ViewHolder param1ViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo2) {
          RecyclerView.this.animateAppearance(param1ViewHolder, param1ItemHolderInfo1, param1ItemHolderInfo2);
        }
        
        public void processDisappeared(RecyclerView.ViewHolder param1ViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo1, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo2) {
          RecyclerView.this.mRecycler.unscrapView(param1ViewHolder);
          RecyclerView.this.animateDisappearance(param1ViewHolder, param1ItemHolderInfo1, param1ItemHolderInfo2);
        }
        
        public void processPersistent(RecyclerView.ViewHolder param1ViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo2) {
          param1ViewHolder.setIsRecyclable(false);
          if (RecyclerView.this.mDataSetHasChangedAfterLayout) {
            if (RecyclerView.this.mItemAnimator.animateChange(param1ViewHolder, param1ViewHolder, param1ItemHolderInfo1, param1ItemHolderInfo2))
              RecyclerView.this.postAnimationRunner(); 
          } else if (RecyclerView.this.mItemAnimator.animatePersistence(param1ViewHolder, param1ItemHolderInfo1, param1ItemHolderInfo2)) {
            RecyclerView.this.postAnimationRunner();
          } 
        }
        
        public void unused(RecyclerView.ViewHolder param1ViewHolder) {
          RecyclerView.this.mLayout.removeAndRecycleView(param1ViewHolder.itemView, RecyclerView.this.mRecycler);
        }
      };
    if (paramAttributeSet != null) {
      TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, CLIP_TO_PADDING_ATTR, paramInt, 0);
      this.mClipToPadding = typedArray.getBoolean(0, true);
      typedArray.recycle();
    } else {
      this.mClipToPadding = true;
    } 
    setScrollContainer(true);
    setFocusableInTouchMode(true);
    if (Build.VERSION.SDK_INT >= 16) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.mPostUpdatesOnAnimation = bool2;
    ViewConfiguration viewConfiguration = ViewConfiguration.get(paramContext);
    this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    boolean bool2 = bool1;
    if (ViewCompat.getOverScrollMode((View)this) == 2)
      bool2 = true; 
    setWillNotDraw(bool2);
    this.mItemAnimator.setListener(this.mItemAnimatorListener);
    initAdapterManager();
    initChildrenHelper();
    if (ViewCompat.getImportantForAccessibility((View)this) == 0)
      ViewCompat.setImportantForAccessibility((View)this, 1); 
    if (paramAttributeSet != null) {
      setDescendantFocusability(262144);
    } else {
      setDescendantFocusability(262144);
    } 
    setNestedScrollingEnabled(true);
  }
  
  private void addAnimatingView(ViewHolder paramViewHolder) {
    boolean bool;
    View view = paramViewHolder.itemView;
    if (view.getParent() == this) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mRecycler.unscrapView(getChildViewHolder(view));
    if (paramViewHolder.isTmpDetached()) {
      this.mChildHelper.attachViewToParent(view, -1, view.getLayoutParams(), true);
    } else if (!bool) {
      this.mChildHelper.addView(view, true);
    } else {
      this.mChildHelper.hide(view);
    } 
  }
  
  private void animateAppearance(@NonNull ViewHolder paramViewHolder, @Nullable ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull ItemAnimator.ItemHolderInfo paramItemHolderInfo2) {
    paramViewHolder.setIsRecyclable(false);
    if (this.mItemAnimator.animateAppearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2))
      postAnimationRunner(); 
  }
  
  private void animateChange(@NonNull ViewHolder paramViewHolder1, @NonNull ViewHolder paramViewHolder2, @NonNull ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull ItemAnimator.ItemHolderInfo paramItemHolderInfo2, boolean paramBoolean1, boolean paramBoolean2) {
    paramViewHolder1.setIsRecyclable(false);
    if (paramBoolean1)
      addAnimatingView(paramViewHolder1); 
    if (paramViewHolder1 != paramViewHolder2) {
      if (paramBoolean2)
        addAnimatingView(paramViewHolder2); 
      paramViewHolder1.mShadowedHolder = paramViewHolder2;
      addAnimatingView(paramViewHolder1);
      this.mRecycler.unscrapView(paramViewHolder1);
      paramViewHolder2.setIsRecyclable(false);
      paramViewHolder2.mShadowingHolder = paramViewHolder1;
    } 
    if (this.mItemAnimator.animateChange(paramViewHolder1, paramViewHolder2, paramItemHolderInfo1, paramItemHolderInfo2))
      postAnimationRunner(); 
  }
  
  private void animateDisappearance(@NonNull ViewHolder paramViewHolder, @NonNull ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @Nullable ItemAnimator.ItemHolderInfo paramItemHolderInfo2) {
    addAnimatingView(paramViewHolder);
    paramViewHolder.setIsRecyclable(false);
    if (this.mItemAnimator.animateDisappearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2))
      postAnimationRunner(); 
  }
  
  private boolean canReuseUpdatedViewHolder(ViewHolder paramViewHolder) {
    return (this.mItemAnimator == null || this.mItemAnimator.canReuseUpdatedViewHolder(paramViewHolder, paramViewHolder.getUnmodifiedPayloads()));
  }
  
  private void cancelTouch() {
    resetTouch();
    setScrollState(0);
  }
  
  private void considerReleasingGlowsOnScroll(int paramInt1, int paramInt2) {
    if (this.mLeftGlow != null && !this.mLeftGlow.isFinished() && paramInt1 > 0) {
      bool1 = this.mLeftGlow.onRelease();
    } else {
      bool1 = false;
    } 
    boolean bool2 = bool1;
    if (this.mRightGlow != null) {
      bool2 = bool1;
      if (!this.mRightGlow.isFinished()) {
        bool2 = bool1;
        if (paramInt1 < 0)
          bool2 = bool1 | this.mRightGlow.onRelease(); 
      } 
    } 
    boolean bool1 = bool2;
    if (this.mTopGlow != null) {
      bool1 = bool2;
      if (!this.mTopGlow.isFinished()) {
        bool1 = bool2;
        if (paramInt2 > 0)
          bool1 = bool2 | this.mTopGlow.onRelease(); 
      } 
    } 
    bool2 = bool1;
    if (this.mBottomGlow != null) {
      bool2 = bool1;
      if (!this.mBottomGlow.isFinished()) {
        bool2 = bool1;
        if (paramInt2 < 0)
          bool2 = bool1 | this.mBottomGlow.onRelease(); 
      } 
    } 
    if (bool2)
      ViewCompat.postInvalidateOnAnimation((View)this); 
  }
  
  private void consumePendingUpdateOperations() {
    if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
      TraceCompat.beginSection("RV FullInvalidate");
      dispatchLayout();
      TraceCompat.endSection();
      return;
    } 
    if (!this.mAdapterHelper.hasPendingUpdates())
      return; 
    if (this.mAdapterHelper.hasAnyUpdateTypes(4) && !this.mAdapterHelper.hasAnyUpdateTypes(11)) {
      TraceCompat.beginSection("RV PartialInvalidate");
      eatRequestLayout();
      this.mAdapterHelper.preProcess();
      if (!this.mLayoutRequestEaten)
        if (hasUpdatedView()) {
          dispatchLayout();
        } else {
          this.mAdapterHelper.consumePostponedUpdates();
        }  
      resumeRequestLayout(true);
      TraceCompat.endSection();
    } else if (this.mAdapterHelper.hasPendingUpdates()) {
      TraceCompat.beginSection("RV FullInvalidate");
      dispatchLayout();
      TraceCompat.endSection();
    } 
  }
  
  private void createLayoutManager(Context paramContext, String paramString, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    if (paramString != null) {
      paramString = paramString.trim();
      if (paramString.length() != 0) {
        String str = getFullClassName(paramContext, paramString);
        try {
          Object[] arrayOfObject;
          StringBuilder stringBuilder;
          if (isInEditMode()) {
            classLoader = getClass().getClassLoader();
          } else {
            classLoader = paramContext.getClassLoader();
          } 
          Class<? extends LayoutManager> clazz = classLoader.loadClass(str).asSubclass(LayoutManager.class);
          ClassLoader classLoader = null;
          try {
            Constructor<? extends LayoutManager> constructor2 = clazz.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
            arrayOfObject = new Object[] { paramContext, paramAttributeSet, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) };
            Constructor<? extends LayoutManager> constructor1 = constructor2;
          } catch (NoSuchMethodException noSuchMethodException1) {
            try {
              Constructor<? extends LayoutManager> constructor = clazz.getConstructor(new Class[0]);
              constructor.setAccessible(true);
              setLayoutManager(constructor.newInstance(arrayOfObject));
            } catch (NoSuchMethodException noSuchMethodException) {
              noSuchMethodException.initCause(noSuchMethodException1);
              IllegalStateException illegalStateException = new IllegalStateException();
              stringBuilder = new StringBuilder();
              this();
              stringBuilder.append(paramAttributeSet.getPositionDescription());
              stringBuilder.append(": Error creating LayoutManager ");
              stringBuilder.append(str);
              this(stringBuilder.toString(), noSuchMethodException);
              throw illegalStateException;
            } 
          } 
          noSuchMethodException.setAccessible(true);
          setLayoutManager(noSuchMethodException.newInstance((Object[])stringBuilder));
        } catch (ClassNotFoundException classNotFoundException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramAttributeSet.getPositionDescription());
          stringBuilder.append(": Unable to find LayoutManager ");
          stringBuilder.append(str);
          throw new IllegalStateException(stringBuilder.toString(), classNotFoundException);
        } catch (InvocationTargetException invocationTargetException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramAttributeSet.getPositionDescription());
          stringBuilder.append(": Could not instantiate the LayoutManager: ");
          stringBuilder.append(str);
          throw new IllegalStateException(stringBuilder.toString(), invocationTargetException);
        } catch (InstantiationException instantiationException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramAttributeSet.getPositionDescription());
          stringBuilder.append(": Could not instantiate the LayoutManager: ");
          stringBuilder.append(str);
          throw new IllegalStateException(stringBuilder.toString(), instantiationException);
        } catch (IllegalAccessException illegalAccessException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramAttributeSet.getPositionDescription());
          stringBuilder.append(": Cannot access non-public constructor ");
          stringBuilder.append(str);
          throw new IllegalStateException(stringBuilder.toString(), illegalAccessException);
        } catch (ClassCastException classCastException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramAttributeSet.getPositionDescription());
          stringBuilder.append(": Class is not a LayoutManager ");
          stringBuilder.append(str);
          throw new IllegalStateException(stringBuilder.toString(), classCastException);
        } 
      } 
    } 
  }
  
  private boolean didChildRangeChange(int paramInt1, int paramInt2) {
    int i = this.mChildHelper.getChildCount();
    boolean bool1 = true;
    boolean bool2 = true;
    if (i == 0) {
      boolean bool = bool2;
      if (paramInt1 == 0)
        if (paramInt2 != 0) {
          bool = bool2;
        } else {
          bool = false;
        }  
      return bool;
    } 
    findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
    boolean bool3 = bool1;
    if (this.mMinMaxLayoutPositions[0] == paramInt1)
      if (this.mMinMaxLayoutPositions[1] != paramInt2) {
        bool3 = bool1;
      } else {
        bool3 = false;
      }  
    return bool3;
  }
  
  private void dispatchChildAttached(View paramView) {
    ViewHolder viewHolder = getChildViewHolderInt(paramView);
    onChildAttachedToWindow(paramView);
    if (this.mAdapter != null && viewHolder != null)
      this.mAdapter.onViewAttachedToWindow(viewHolder); 
    if (this.mOnChildAttachStateListeners != null)
      for (int i = this.mOnChildAttachStateListeners.size() - 1; i >= 0; i--)
        ((OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(i)).onChildViewAttachedToWindow(paramView);  
  }
  
  private void dispatchChildDetached(View paramView) {
    ViewHolder viewHolder = getChildViewHolderInt(paramView);
    onChildDetachedFromWindow(paramView);
    if (this.mAdapter != null && viewHolder != null)
      this.mAdapter.onViewDetachedFromWindow(viewHolder); 
    if (this.mOnChildAttachStateListeners != null)
      for (int i = this.mOnChildAttachStateListeners.size() - 1; i >= 0; i--)
        ((OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(i)).onChildViewDetachedFromWindow(paramView);  
  }
  
  private void dispatchLayoutStep1() {
    State state = this.mState;
    boolean bool = true;
    state.assertLayoutStep(1);
    State.access$2202(this.mState, false);
    eatRequestLayout();
    this.mViewInfoStore.clear();
    onEnterLayoutOrScroll();
    saveFocusInfo();
    processAdapterUpdatesAndSetAnimationFlags();
    state = this.mState;
    if (!this.mState.mRunSimpleAnimations || !this.mItemsChanged)
      bool = false; 
    State.access$2702(state, bool);
    this.mItemsChanged = false;
    this.mItemsAddedOrRemoved = false;
    State.access$2402(this.mState, this.mState.mRunPredictiveAnimations);
    this.mState.mItemCount = this.mAdapter.getItemCount();
    findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
    if (this.mState.mRunSimpleAnimations) {
      int i = this.mChildHelper.getChildCount();
      for (byte b = 0; b < i; b++) {
        ViewHolder viewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(b));
        if (!viewHolder.shouldIgnore() && (!viewHolder.isInvalid() || this.mAdapter.hasStableIds())) {
          ItemAnimator.ItemHolderInfo itemHolderInfo = this.mItemAnimator.recordPreLayoutInformation(this.mState, viewHolder, ItemAnimator.buildAdapterChangeFlagsForAnimations(viewHolder), viewHolder.getUnmodifiedPayloads());
          this.mViewInfoStore.addToPreLayout(viewHolder, itemHolderInfo);
          if (this.mState.mTrackOldChangeHolders && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore() && !viewHolder.isInvalid()) {
            long l = getChangedHolderKey(viewHolder);
            this.mViewInfoStore.addToOldChangeHolders(l, viewHolder);
          } 
        } 
      } 
    } 
    if (this.mState.mRunPredictiveAnimations) {
      saveOldPositions();
      bool = this.mState.mStructureChanged;
      State.access$1802(this.mState, false);
      this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
      State.access$1802(this.mState, bool);
      for (byte b = 0; b < this.mChildHelper.getChildCount(); b++) {
        ViewHolder viewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(b));
        if (!viewHolder.shouldIgnore() && !this.mViewInfoStore.isInPreLayout(viewHolder)) {
          int j = ItemAnimator.buildAdapterChangeFlagsForAnimations(viewHolder);
          bool = viewHolder.hasAnyOfTheFlags(8192);
          int i = j;
          if (!bool)
            i = j | 0x1000; 
          ItemAnimator.ItemHolderInfo itemHolderInfo = this.mItemAnimator.recordPreLayoutInformation(this.mState, viewHolder, i, viewHolder.getUnmodifiedPayloads());
          if (bool) {
            recordAnimationInfoIfBouncedHiddenView(viewHolder, itemHolderInfo);
          } else {
            this.mViewInfoStore.addToAppearedInPreLayoutHolders(viewHolder, itemHolderInfo);
          } 
        } 
      } 
      clearOldPositions();
    } else {
      clearOldPositions();
    } 
    onExitLayoutOrScroll();
    resumeRequestLayout(false);
    State.access$2102(this.mState, 2);
  }
  
  private void dispatchLayoutStep2() {
    boolean bool;
    eatRequestLayout();
    onEnterLayoutOrScroll();
    this.mState.assertLayoutStep(6);
    this.mAdapterHelper.consumeUpdatesInOnePass();
    this.mState.mItemCount = this.mAdapter.getItemCount();
    State.access$1702(this.mState, 0);
    State.access$2402(this.mState, false);
    this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
    State.access$1802(this.mState, false);
    this.mPendingSavedState = null;
    State state = this.mState;
    if (this.mState.mRunSimpleAnimations && this.mItemAnimator != null) {
      bool = true;
    } else {
      bool = false;
    } 
    State.access$2502(state, bool);
    State.access$2102(this.mState, 4);
    onExitLayoutOrScroll();
    resumeRequestLayout(false);
  }
  
  private void dispatchLayoutStep3() {
    this.mState.assertLayoutStep(4);
    eatRequestLayout();
    onEnterLayoutOrScroll();
    State.access$2102(this.mState, 1);
    if (this.mState.mRunSimpleAnimations) {
      for (int i = this.mChildHelper.getChildCount() - 1; i >= 0; i--) {
        ViewHolder viewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
        if (!viewHolder.shouldIgnore()) {
          long l = getChangedHolderKey(viewHolder);
          ItemAnimator.ItemHolderInfo itemHolderInfo = this.mItemAnimator.recordPostLayoutInformation(this.mState, viewHolder);
          ViewHolder viewHolder1 = this.mViewInfoStore.getFromOldChangeHolders(l);
          if (viewHolder1 != null && !viewHolder1.shouldIgnore()) {
            boolean bool1 = this.mViewInfoStore.isDisappearing(viewHolder1);
            boolean bool2 = this.mViewInfoStore.isDisappearing(viewHolder);
            if (bool1 && viewHolder1 == viewHolder) {
              this.mViewInfoStore.addToPostLayout(viewHolder, itemHolderInfo);
            } else {
              ItemAnimator.ItemHolderInfo itemHolderInfo1 = this.mViewInfoStore.popFromPreLayout(viewHolder1);
              this.mViewInfoStore.addToPostLayout(viewHolder, itemHolderInfo);
              itemHolderInfo = this.mViewInfoStore.popFromPostLayout(viewHolder);
              if (itemHolderInfo1 == null) {
                handleMissingPreInfoForChangeError(l, viewHolder, viewHolder1);
              } else {
                animateChange(viewHolder1, viewHolder, itemHolderInfo1, itemHolderInfo, bool1, bool2);
              } 
            } 
          } else {
            this.mViewInfoStore.addToPostLayout(viewHolder, itemHolderInfo);
          } 
        } 
      } 
      this.mViewInfoStore.process(this.mViewInfoProcessCallback);
    } 
    this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    State.access$2802(this.mState, this.mState.mItemCount);
    this.mDataSetHasChangedAfterLayout = false;
    State.access$2502(this.mState, false);
    State.access$2302(this.mState, false);
    LayoutManager.access$2602(this.mLayout, false);
    if (this.mRecycler.mChangedScrap != null)
      this.mRecycler.mChangedScrap.clear(); 
    this.mLayout.onLayoutCompleted(this.mState);
    onExitLayoutOrScroll();
    resumeRequestLayout(false);
    this.mViewInfoStore.clear();
    if (didChildRangeChange(this.mMinMaxLayoutPositions[0], this.mMinMaxLayoutPositions[1]))
      dispatchOnScrolled(0, 0); 
    recoverFocusFromState();
    resetFocusInfo();
  }
  
  private boolean dispatchOnItemTouch(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getAction();
    if (this.mActiveOnItemTouchListener != null)
      if (i == 0) {
        this.mActiveOnItemTouchListener = null;
      } else {
        this.mActiveOnItemTouchListener.onTouchEvent(this, paramMotionEvent);
        if (i == 3 || i == 1)
          this.mActiveOnItemTouchListener = null; 
        return true;
      }  
    if (i != 0) {
      int j = this.mOnItemTouchListeners.size();
      for (i = 0; i < j; i++) {
        OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(i);
        if (onItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent)) {
          this.mActiveOnItemTouchListener = onItemTouchListener;
          return true;
        } 
      } 
    } 
    return false;
  }
  
  private boolean dispatchOnItemTouchIntercept(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getAction();
    if (i == 3 || i == 0)
      this.mActiveOnItemTouchListener = null; 
    int j = this.mOnItemTouchListeners.size();
    for (byte b = 0; b < j; b++) {
      OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(b);
      if (onItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent) && i != 3) {
        this.mActiveOnItemTouchListener = onItemTouchListener;
        return true;
      } 
    } 
    return false;
  }
  
  private void findMinMaxChildLayoutPositions(int[] paramArrayOfint) {
    int i = this.mChildHelper.getChildCount();
    if (i == 0) {
      paramArrayOfint[0] = 0;
      paramArrayOfint[1] = 0;
      return;
    } 
    byte b = 0;
    int j = Integer.MAX_VALUE;
    int k;
    for (k = Integer.MIN_VALUE; b < i; k = m) {
      int m;
      ViewHolder viewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(b));
      if (viewHolder.shouldIgnore()) {
        m = k;
      } else {
        int n = viewHolder.getLayoutPosition();
        int i1 = j;
        if (n < j)
          i1 = n; 
        j = i1;
        m = k;
        if (n > k) {
          m = n;
          j = i1;
        } 
      } 
      b++;
    } 
    paramArrayOfint[0] = j;
    paramArrayOfint[1] = k;
  }
  
  private int getAdapterPositionFor(ViewHolder paramViewHolder) {
    return (paramViewHolder.hasAnyOfTheFlags(524) || !paramViewHolder.isBound()) ? -1 : this.mAdapterHelper.applyPendingUpdatesToPosition(paramViewHolder.mPosition);
  }
  
  static ViewHolder getChildViewHolderInt(View paramView) {
    return (paramView == null) ? null : ((LayoutParams)paramView.getLayoutParams()).mViewHolder;
  }
  
  private int getDeepestFocusedViewWithId(View paramView) {
    int i = paramView.getId();
    while (!paramView.isFocused() && paramView instanceof ViewGroup && paramView.hasFocus()) {
      View view = ((ViewGroup)paramView).getFocusedChild();
      paramView = view;
      if (view.getId() != -1) {
        i = view.getId();
        paramView = view;
      } 
    } 
    return i;
  }
  
  private String getFullClassName(Context paramContext, String paramString) {
    if (paramString.charAt(0) == '.') {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramContext.getPackageName());
      stringBuilder1.append(paramString);
      return stringBuilder1.toString();
    } 
    if (paramString.contains("."))
      return paramString; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RecyclerView.class.getPackage().getName());
    stringBuilder.append('.');
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  private float getScrollFactor() {
    if (this.mScrollFactor == Float.MIN_VALUE) {
      TypedValue typedValue = new TypedValue();
      if (getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
        this.mScrollFactor = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
      } else {
        return 0.0F;
      } 
    } 
    return this.mScrollFactor;
  }
  
  private NestedScrollingChildHelper getScrollingChildHelper() {
    if (this.mScrollingChildHelper == null)
      this.mScrollingChildHelper = new NestedScrollingChildHelper((View)this); 
    return this.mScrollingChildHelper;
  }
  
  private void handleMissingPreInfoForChangeError(long paramLong, ViewHolder paramViewHolder1, ViewHolder paramViewHolder2) {
    StringBuilder stringBuilder1;
    int i = this.mChildHelper.getChildCount();
    for (byte b = 0; b < i; b++) {
      ViewHolder viewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(b));
      if (viewHolder != paramViewHolder1 && getChangedHolderKey(viewHolder) == paramLong) {
        if (this.mAdapter != null && this.mAdapter.hasStableIds()) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
          stringBuilder.append(viewHolder);
          stringBuilder.append(" \n View Holder 2:");
          stringBuilder.append(paramViewHolder1);
          throw new IllegalStateException(stringBuilder.toString());
        } 
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
        stringBuilder1.append(viewHolder);
        stringBuilder1.append(" \n View Holder 2:");
        stringBuilder1.append(paramViewHolder1);
        throw new IllegalStateException(stringBuilder1.toString());
      } 
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
    stringBuilder2.append(stringBuilder1);
    stringBuilder2.append(" cannot be found but it is necessary for ");
    stringBuilder2.append(paramViewHolder1);
    Log.e("RecyclerView", stringBuilder2.toString());
  }
  
  private boolean hasUpdatedView() {
    int i = this.mChildHelper.getChildCount();
    for (byte b = 0; b < i; b++) {
      ViewHolder viewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(b));
      if (viewHolder != null && !viewHolder.shouldIgnore() && viewHolder.isUpdated())
        return true; 
    } 
    return false;
  }
  
  private void initChildrenHelper() {
    this.mChildHelper = new ChildHelper(new ChildHelper.Callback() {
          public void addView(View param1View, int param1Int) {
            RecyclerView.this.addView(param1View, param1Int);
            RecyclerView.this.dispatchChildAttached(param1View);
          }
          
          public void attachViewToParent(View param1View, int param1Int, ViewGroup.LayoutParams param1LayoutParams) {
            StringBuilder stringBuilder;
            RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(param1View);
            if (viewHolder != null)
              if (viewHolder.isTmpDetached() || viewHolder.shouldIgnore()) {
                viewHolder.clearTmpDetachFlag();
              } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Called attach on a child which is not detached: ");
                stringBuilder.append(viewHolder);
                throw new IllegalArgumentException(stringBuilder.toString());
              }  
            RecyclerView.this.attachViewToParent((View)stringBuilder, param1Int, param1LayoutParams);
          }
          
          public void detachViewFromParent(int param1Int) {
            View view = getChildAt(param1Int);
            if (view != null) {
              RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(view);
              if (viewHolder != null)
                if (!viewHolder.isTmpDetached() || viewHolder.shouldIgnore()) {
                  viewHolder.addFlags(256);
                } else {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("called detach on an already detached child ");
                  stringBuilder.append(viewHolder);
                  throw new IllegalArgumentException(stringBuilder.toString());
                }  
            } 
            RecyclerView.this.detachViewFromParent(param1Int);
          }
          
          public View getChildAt(int param1Int) {
            return RecyclerView.this.getChildAt(param1Int);
          }
          
          public int getChildCount() {
            return RecyclerView.this.getChildCount();
          }
          
          public RecyclerView.ViewHolder getChildViewHolder(View param1View) {
            return RecyclerView.getChildViewHolderInt(param1View);
          }
          
          public int indexOfChild(View param1View) {
            return RecyclerView.this.indexOfChild(param1View);
          }
          
          public void onEnteredHiddenState(View param1View) {
            RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(param1View);
            if (viewHolder != null)
              viewHolder.onEnteredHiddenState(); 
          }
          
          public void onLeftHiddenState(View param1View) {
            RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(param1View);
            if (viewHolder != null)
              viewHolder.onLeftHiddenState(); 
          }
          
          public void removeAllViews() {
            int i = getChildCount();
            for (byte b = 0; b < i; b++)
              RecyclerView.this.dispatchChildDetached(getChildAt(b)); 
            RecyclerView.this.removeAllViews();
          }
          
          public void removeViewAt(int param1Int) {
            View view = RecyclerView.this.getChildAt(param1Int);
            if (view != null)
              RecyclerView.this.dispatchChildDetached(view); 
            RecyclerView.this.removeViewAt(param1Int);
          }
        });
  }
  
  private boolean isPreferredNextFocus(View paramView1, View paramView2, int paramInt) {
    byte b = 0;
    if (paramView2 == null || paramView2 == this)
      return false; 
    if (paramView1 == null)
      return true; 
    if (paramInt == 2 || paramInt == 1) {
      byte b1;
      if (this.mLayout.getLayoutDirection() == 1) {
        b1 = 1;
      } else {
        b1 = 0;
      } 
      if (paramInt == 2)
        b = 1; 
      if ((b ^ b1) != 0) {
        b1 = 66;
      } else {
        b1 = 17;
      } 
      return isPreferredNextFocusAbsolute(paramView1, paramView2, b1) ? true : ((paramInt == 2) ? isPreferredNextFocusAbsolute(paramView1, paramView2, 130) : isPreferredNextFocusAbsolute(paramView1, paramView2, 33));
    } 
    return isPreferredNextFocusAbsolute(paramView1, paramView2, paramInt);
  }
  
  private boolean isPreferredNextFocusAbsolute(View paramView1, View paramView2, int paramInt) {
    this.mTempRect.set(0, 0, paramView1.getWidth(), paramView1.getHeight());
    this.mTempRect2.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
    offsetDescendantRectToMyCoords(paramView1, this.mTempRect);
    offsetDescendantRectToMyCoords(paramView2, this.mTempRect2);
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    if (paramInt != 17) {
      if (paramInt != 33) {
        if (paramInt != 66) {
          if (paramInt == 130) {
            if ((this.mTempRect.top >= this.mTempRect2.top && this.mTempRect.bottom > this.mTempRect2.top) || this.mTempRect.bottom >= this.mTempRect2.bottom)
              bool4 = false; 
            return bool4;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("direction must be absolute. received:");
          stringBuilder.append(paramInt);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        if ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right) {
          bool4 = bool1;
        } else {
          bool4 = false;
        } 
        return bool4;
      } 
      if ((this.mTempRect.bottom > this.mTempRect2.bottom || this.mTempRect.top >= this.mTempRect2.bottom) && this.mTempRect.top > this.mTempRect2.top) {
        bool4 = bool2;
      } else {
        bool4 = false;
      } 
      return bool4;
    } 
    if ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) {
      bool4 = bool3;
    } else {
      bool4 = false;
    } 
    return bool4;
  }
  
  private void jumpToPositionForSmoothScroller(int paramInt) {
    if (this.mLayout == null)
      return; 
    this.mLayout.scrollToPosition(paramInt);
    awakenScrollBars();
  }
  
  private void onEnterLayoutOrScroll() {
    this.mLayoutOrScrollCounter++;
  }
  
  private void onExitLayoutOrScroll() {
    this.mLayoutOrScrollCounter--;
    if (this.mLayoutOrScrollCounter < 1)
      this.mLayoutOrScrollCounter = 0; 
  }
  
  private void onPointerUp(MotionEvent paramMotionEvent) {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == this.mScrollPointerId) {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      this.mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      int j = (int)(MotionEventCompat.getX(paramMotionEvent, i) + 0.5F);
      this.mLastTouchX = j;
      this.mInitialTouchX = j;
      i = (int)(MotionEventCompat.getY(paramMotionEvent, i) + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
    } 
  }
  
  private void postAnimationRunner() {
    if (!this.mPostedAnimatorRunner && this.mIsAttached) {
      ViewCompat.postOnAnimation((View)this, this.mItemAnimatorRunner);
      this.mPostedAnimatorRunner = true;
    } 
  }
  
  private boolean predictiveItemAnimationsEnabled() {
    boolean bool;
    if (this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private void processAdapterUpdatesAndSetAnimationFlags() {
    boolean bool2;
    if (this.mDataSetHasChangedAfterLayout) {
      this.mAdapterHelper.reset();
      markKnownViewsInvalid();
      this.mLayout.onItemsChanged(this);
    } 
    if (predictiveItemAnimationsEnabled()) {
      this.mAdapterHelper.preProcess();
    } else {
      this.mAdapterHelper.consumeUpdatesInOnePass();
    } 
    boolean bool = this.mItemsAddedOrRemoved;
    boolean bool1 = false;
    if (bool || this.mItemsChanged) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    State state = this.mState;
    if (this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || bool2 || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds())) {
      bool = true;
    } else {
      bool = false;
    } 
    State.access$2502(state, bool);
    state = this.mState;
    bool = bool1;
    if (this.mState.mRunSimpleAnimations) {
      bool = bool1;
      if (bool2) {
        bool = bool1;
        if (!this.mDataSetHasChangedAfterLayout) {
          bool = bool1;
          if (predictiveItemAnimationsEnabled())
            bool = true; 
        } 
      } 
    } 
    State.access$2302(state, bool);
  }
  
  private void pullGlows(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    // Byte code:
    //   0: iconst_1
    //   1: istore #5
    //   3: fload_2
    //   4: fconst_0
    //   5: fcmpg
    //   6: ifge -> 46
    //   9: aload_0
    //   10: invokevirtual ensureLeftGlow : ()V
    //   13: aload_0
    //   14: getfield mLeftGlow : Lorg/jar/support/v4/widget/EdgeEffectCompat;
    //   17: fload_2
    //   18: fneg
    //   19: aload_0
    //   20: invokevirtual getWidth : ()I
    //   23: i2f
    //   24: fdiv
    //   25: fconst_1
    //   26: fload_3
    //   27: aload_0
    //   28: invokevirtual getHeight : ()I
    //   31: i2f
    //   32: fdiv
    //   33: fsub
    //   34: invokevirtual onPull : (FF)Z
    //   37: ifeq -> 83
    //   40: iconst_1
    //   41: istore #6
    //   43: goto -> 86
    //   46: fload_2
    //   47: fconst_0
    //   48: fcmpl
    //   49: ifle -> 83
    //   52: aload_0
    //   53: invokevirtual ensureRightGlow : ()V
    //   56: aload_0
    //   57: getfield mRightGlow : Lorg/jar/support/v4/widget/EdgeEffectCompat;
    //   60: fload_2
    //   61: aload_0
    //   62: invokevirtual getWidth : ()I
    //   65: i2f
    //   66: fdiv
    //   67: fload_3
    //   68: aload_0
    //   69: invokevirtual getHeight : ()I
    //   72: i2f
    //   73: fdiv
    //   74: invokevirtual onPull : (FF)Z
    //   77: ifeq -> 83
    //   80: goto -> 40
    //   83: iconst_0
    //   84: istore #6
    //   86: fload #4
    //   88: fconst_0
    //   89: fcmpg
    //   90: ifge -> 130
    //   93: aload_0
    //   94: invokevirtual ensureTopGlow : ()V
    //   97: aload_0
    //   98: getfield mTopGlow : Lorg/jar/support/v4/widget/EdgeEffectCompat;
    //   101: fload #4
    //   103: fneg
    //   104: aload_0
    //   105: invokevirtual getHeight : ()I
    //   108: i2f
    //   109: fdiv
    //   110: fload_1
    //   111: aload_0
    //   112: invokevirtual getWidth : ()I
    //   115: i2f
    //   116: fdiv
    //   117: invokevirtual onPull : (FF)Z
    //   120: ifeq -> 175
    //   123: iload #5
    //   125: istore #6
    //   127: goto -> 175
    //   130: fload #4
    //   132: fconst_0
    //   133: fcmpl
    //   134: ifle -> 175
    //   137: aload_0
    //   138: invokevirtual ensureBottomGlow : ()V
    //   141: aload_0
    //   142: getfield mBottomGlow : Lorg/jar/support/v4/widget/EdgeEffectCompat;
    //   145: fload #4
    //   147: aload_0
    //   148: invokevirtual getHeight : ()I
    //   151: i2f
    //   152: fdiv
    //   153: fconst_1
    //   154: fload_1
    //   155: aload_0
    //   156: invokevirtual getWidth : ()I
    //   159: i2f
    //   160: fdiv
    //   161: fsub
    //   162: invokevirtual onPull : (FF)Z
    //   165: ifeq -> 175
    //   168: iload #5
    //   170: istore #6
    //   172: goto -> 175
    //   175: iload #6
    //   177: ifne -> 193
    //   180: fload_2
    //   181: fconst_0
    //   182: fcmpl
    //   183: ifne -> 193
    //   186: fload #4
    //   188: fconst_0
    //   189: fcmpl
    //   190: ifeq -> 197
    //   193: aload_0
    //   194: invokestatic postInvalidateOnAnimation : (Landroid/view/View;)V
    //   197: return
  }
  
  private void recordAnimationInfoIfBouncedHiddenView(ViewHolder paramViewHolder, ItemAnimator.ItemHolderInfo paramItemHolderInfo) {
    paramViewHolder.setFlags(0, 8192);
    if (this.mState.mTrackOldChangeHolders && paramViewHolder.isUpdated() && !paramViewHolder.isRemoved() && !paramViewHolder.shouldIgnore()) {
      long l = getChangedHolderKey(paramViewHolder);
      this.mViewInfoStore.addToOldChangeHolders(l, paramViewHolder);
    } 
    this.mViewInfoStore.addToPreLayout(paramViewHolder, paramItemHolderInfo);
  }
  
  private void recoverFocusFromState() {
    if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus())
      return; 
    if (!isFocused()) {
      View view1 = getFocusedChild();
      if (view1 == null || !this.mChildHelper.isHidden(view1))
        return; 
    } 
    ViewHolder viewHolder1 = null;
    if (this.mState.mFocusedItemPosition != -1)
      viewHolder1 = findViewHolderForAdapterPosition(this.mState.mFocusedItemPosition); 
    ViewHolder viewHolder2 = viewHolder1;
    if (viewHolder1 == null) {
      viewHolder2 = viewHolder1;
      if (this.mState.mFocusedItemId != -1L) {
        viewHolder2 = viewHolder1;
        if (this.mAdapter.hasStableIds())
          viewHolder2 = findViewHolderForItemId(this.mState.mFocusedItemId); 
      } 
    } 
    if (viewHolder2 == null || viewHolder2.itemView.hasFocus() || !viewHolder2.itemView.hasFocusable())
      return; 
    View view = viewHolder2.itemView;
    if (this.mState.mFocusedSubChildId != -1L) {
      View view1 = viewHolder2.itemView.findViewById(this.mState.mFocusedSubChildId);
      if (view1 != null && view1.isFocusable())
        view = view1; 
    } 
    view.requestFocus();
  }
  
  private void releaseGlows() {
    if (this.mLeftGlow != null) {
      bool1 = this.mLeftGlow.onRelease();
    } else {
      bool1 = false;
    } 
    boolean bool2 = bool1;
    if (this.mTopGlow != null)
      bool2 = bool1 | this.mTopGlow.onRelease(); 
    boolean bool1 = bool2;
    if (this.mRightGlow != null)
      bool1 = bool2 | this.mRightGlow.onRelease(); 
    bool2 = bool1;
    if (this.mBottomGlow != null)
      bool2 = bool1 | this.mBottomGlow.onRelease(); 
    if (bool2)
      ViewCompat.postInvalidateOnAnimation((View)this); 
  }
  
  private boolean removeAnimatingView(View paramView) {
    eatRequestLayout();
    boolean bool = this.mChildHelper.removeViewIfHidden(paramView);
    if (bool) {
      ViewHolder viewHolder = getChildViewHolderInt(paramView);
      this.mRecycler.unscrapView(viewHolder);
      this.mRecycler.recycleViewHolderInternal(viewHolder);
    } 
    resumeRequestLayout(bool ^ true);
    return bool;
  }
  
  private void repositionShadowingViews() {
    int i = this.mChildHelper.getChildCount();
    for (byte b = 0; b < i; b++) {
      View view = this.mChildHelper.getChildAt(b);
      ViewHolder viewHolder = getChildViewHolder(view);
      if (viewHolder != null && viewHolder.mShadowingHolder != null) {
        View view1 = viewHolder.mShadowingHolder.itemView;
        int j = view.getLeft();
        int k = view.getTop();
        if (j != view1.getLeft() || k != view1.getTop())
          view1.layout(j, k, view1.getWidth() + j, view1.getHeight() + k); 
      } 
    } 
  }
  
  private void resetFocusInfo() {
    this.mState.mFocusedItemId = -1L;
    this.mState.mFocusedItemPosition = -1;
    this.mState.mFocusedSubChildId = -1;
  }
  
  private void resetTouch() {
    if (this.mVelocityTracker != null)
      this.mVelocityTracker.clear(); 
    stopNestedScroll();
    releaseGlows();
  }
  
  private void saveFocusInfo() {
    ViewHolder viewHolder2;
    boolean bool = this.mPreserveFocusAfterLayout;
    ViewHolder viewHolder1 = null;
    if (bool && hasFocus() && this.mAdapter != null) {
      viewHolder2 = (ViewHolder)getFocusedChild();
    } else {
      viewHolder2 = null;
    } 
    if (viewHolder2 == null) {
      viewHolder2 = viewHolder1;
    } else {
      viewHolder2 = findContainingViewHolder((View)viewHolder2);
    } 
    if (viewHolder2 == null) {
      resetFocusInfo();
    } else {
      long l;
      int i;
      State state = this.mState;
      if (this.mAdapter.hasStableIds()) {
        l = viewHolder2.getItemId();
      } else {
        l = -1L;
      } 
      state.mFocusedItemId = l;
      state = this.mState;
      if (this.mDataSetHasChangedAfterLayout) {
        i = -1;
      } else {
        i = viewHolder2.getAdapterPosition();
      } 
      state.mFocusedItemPosition = i;
      this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(viewHolder2.itemView);
    } 
  }
  
  private void setAdapterInternal(Adapter paramAdapter, boolean paramBoolean1, boolean paramBoolean2) {
    if (this.mAdapter != null) {
      this.mAdapter.unregisterAdapterDataObserver(this.mObserver);
      this.mAdapter.onDetachedFromRecyclerView(this);
    } 
    if (!paramBoolean1 || paramBoolean2) {
      if (this.mItemAnimator != null)
        this.mItemAnimator.endAnimations(); 
      if (this.mLayout != null) {
        this.mLayout.removeAndRecycleAllViews(this.mRecycler);
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
      } 
      this.mRecycler.clear();
    } 
    this.mAdapterHelper.reset();
    Adapter adapter = this.mAdapter;
    this.mAdapter = paramAdapter;
    if (paramAdapter != null) {
      paramAdapter.registerAdapterDataObserver(this.mObserver);
      paramAdapter.onAttachedToRecyclerView(this);
    } 
    if (this.mLayout != null)
      this.mLayout.onAdapterChanged(adapter, this.mAdapter); 
    this.mRecycler.onAdapterChanged(adapter, this.mAdapter, paramBoolean1);
    State.access$1802(this.mState, true);
    markKnownViewsInvalid();
  }
  
  private void setDataSetChangedAfterLayout() {
    if (this.mDataSetHasChangedAfterLayout)
      return; 
    this.mDataSetHasChangedAfterLayout = true;
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (byte b = 0; b < i; b++) {
      ViewHolder viewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(b));
      if (viewHolder != null && !viewHolder.shouldIgnore())
        viewHolder.addFlags(512); 
    } 
    this.mRecycler.setAdapterPositionsAsUnknown();
  }
  
  private void setScrollState(int paramInt) {
    if (paramInt == this.mScrollState)
      return; 
    this.mScrollState = paramInt;
    if (paramInt != 2)
      stopScrollersInternal(); 
    dispatchOnScrollStateChanged(paramInt);
  }
  
  private void stopScrollersInternal() {
    this.mViewFlinger.stop();
    if (this.mLayout != null)
      this.mLayout.stopSmoothScroller(); 
  }
  
  void absorbGlows(int paramInt1, int paramInt2) {
    if (paramInt1 < 0) {
      ensureLeftGlow();
      this.mLeftGlow.onAbsorb(-paramInt1);
    } else if (paramInt1 > 0) {
      ensureRightGlow();
      this.mRightGlow.onAbsorb(paramInt1);
    } 
    if (paramInt2 < 0) {
      ensureTopGlow();
      this.mTopGlow.onAbsorb(-paramInt2);
    } else if (paramInt2 > 0) {
      ensureBottomGlow();
      this.mBottomGlow.onAbsorb(paramInt2);
    } 
    if (paramInt1 != 0 || paramInt2 != 0)
      ViewCompat.postInvalidateOnAnimation((View)this); 
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2) {
    if (this.mLayout == null || !this.mLayout.onAddFocusables(this, paramArrayList, paramInt1, paramInt2))
      super.addFocusables(paramArrayList, paramInt1, paramInt2); 
  }
  
  public void addItemDecoration(ItemDecoration paramItemDecoration) {
    addItemDecoration(paramItemDecoration, -1);
  }
  
  public void addItemDecoration(ItemDecoration paramItemDecoration, int paramInt) {
    if (this.mLayout != null)
      this.mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout"); 
    if (this.mItemDecorations.isEmpty())
      setWillNotDraw(false); 
    if (paramInt < 0) {
      this.mItemDecorations.add(paramItemDecoration);
    } else {
      this.mItemDecorations.add(paramInt, paramItemDecoration);
    } 
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener paramOnChildAttachStateChangeListener) {
    if (this.mOnChildAttachStateListeners == null)
      this.mOnChildAttachStateListeners = new ArrayList<OnChildAttachStateChangeListener>(); 
    this.mOnChildAttachStateListeners.add(paramOnChildAttachStateChangeListener);
  }
  
  public void addOnItemTouchListener(OnItemTouchListener paramOnItemTouchListener) {
    this.mOnItemTouchListeners.add(paramOnItemTouchListener);
  }
  
  public void addOnScrollListener(OnScrollListener paramOnScrollListener) {
    if (this.mScrollListeners == null)
      this.mScrollListeners = new ArrayList<OnScrollListener>(); 
    this.mScrollListeners.add(paramOnScrollListener);
  }
  
  void assertInLayoutOrScroll(String paramString) {
    if (!isComputingLayout()) {
      if (paramString == null)
        throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling"); 
      throw new IllegalStateException(paramString);
    } 
  }
  
  void assertNotInLayoutOrScroll(String paramString) {
    if (isComputingLayout()) {
      if (paramString == null)
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling"); 
      throw new IllegalStateException(paramString);
    } 
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    boolean bool;
    if (paramLayoutParams instanceof LayoutParams && this.mLayout.checkLayoutParams((LayoutParams)paramLayoutParams)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  void clearOldPositions() {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (byte b = 0; b < i; b++) {
      ViewHolder viewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(b));
      if (!viewHolder.shouldIgnore())
        viewHolder.clearOldPosition(); 
    } 
    this.mRecycler.clearOldPositions();
  }
  
  public void clearOnChildAttachStateChangeListeners() {
    if (this.mOnChildAttachStateListeners != null)
      this.mOnChildAttachStateListeners.clear(); 
  }
  
  public void clearOnScrollListeners() {
    if (this.mScrollListeners != null)
      this.mScrollListeners.clear(); 
  }
  
  public int computeHorizontalScrollExtent() {
    LayoutManager layoutManager = this.mLayout;
    int i = 0;
    if (layoutManager == null)
      return 0; 
    if (this.mLayout.canScrollHorizontally())
      i = this.mLayout.computeHorizontalScrollExtent(this.mState); 
    return i;
  }
  
  public int computeHorizontalScrollOffset() {
    LayoutManager layoutManager = this.mLayout;
    int i = 0;
    if (layoutManager == null)
      return 0; 
    if (this.mLayout.canScrollHorizontally())
      i = this.mLayout.computeHorizontalScrollOffset(this.mState); 
    return i;
  }
  
  public int computeHorizontalScrollRange() {
    LayoutManager layoutManager = this.mLayout;
    int i = 0;
    if (layoutManager == null)
      return 0; 
    if (this.mLayout.canScrollHorizontally())
      i = this.mLayout.computeHorizontalScrollRange(this.mState); 
    return i;
  }
  
  public int computeVerticalScrollExtent() {
    LayoutManager layoutManager = this.mLayout;
    int i = 0;
    if (layoutManager == null)
      return 0; 
    if (this.mLayout.canScrollVertically())
      i = this.mLayout.computeVerticalScrollExtent(this.mState); 
    return i;
  }
  
  public int computeVerticalScrollOffset() {
    LayoutManager layoutManager = this.mLayout;
    int i = 0;
    if (layoutManager == null)
      return 0; 
    if (this.mLayout.canScrollVertically())
      i = this.mLayout.computeVerticalScrollOffset(this.mState); 
    return i;
  }
  
  public int computeVerticalScrollRange() {
    LayoutManager layoutManager = this.mLayout;
    int i = 0;
    if (layoutManager == null)
      return 0; 
    if (this.mLayout.canScrollVertically())
      i = this.mLayout.computeVerticalScrollRange(this.mState); 
    return i;
  }
  
  void defaultOnMeasure(int paramInt1, int paramInt2) {
    setMeasuredDimension(LayoutManager.chooseSize(paramInt1, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth((View)this)), LayoutManager.chooseSize(paramInt2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight((View)this)));
  }
  
  void dispatchLayout() {
    if (this.mAdapter == null) {
      Log.e("RecyclerView", "No adapter attached; skipping layout");
      return;
    } 
    if (this.mLayout == null) {
      Log.e("RecyclerView", "No layout manager attached; skipping layout");
      return;
    } 
    State.access$2202(this.mState, false);
    if (this.mState.mLayoutStep == 1) {
      dispatchLayoutStep1();
      this.mLayout.setExactMeasureSpecsFrom(this);
      dispatchLayoutStep2();
    } else if (this.mAdapterHelper.hasUpdates() || this.mLayout.getWidth() != getWidth() || this.mLayout.getHeight() != getHeight()) {
      this.mLayout.setExactMeasureSpecsFrom(this);
      dispatchLayoutStep2();
    } else {
      this.mLayout.setExactMeasureSpecsFrom(this);
    } 
    dispatchLayoutStep3();
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return getScrollingChildHelper().dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2) {
    return getScrollingChildHelper().dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2) {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
  }
  
  void dispatchOnScrollStateChanged(int paramInt) {
    if (this.mLayout != null)
      this.mLayout.onScrollStateChanged(paramInt); 
    onScrollStateChanged(paramInt);
    if (this.mScrollListener != null)
      this.mScrollListener.onScrollStateChanged(this, paramInt); 
    if (this.mScrollListeners != null)
      for (int i = this.mScrollListeners.size() - 1; i >= 0; i--)
        ((OnScrollListener)this.mScrollListeners.get(i)).onScrollStateChanged(this, paramInt);  
  }
  
  void dispatchOnScrolled(int paramInt1, int paramInt2) {
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    onScrolled(paramInt1, paramInt2);
    if (this.mScrollListener != null)
      this.mScrollListener.onScrolled(this, paramInt1, paramInt2); 
    if (this.mScrollListeners != null)
      for (i = this.mScrollListeners.size() - 1; i >= 0; i--)
        ((OnScrollListener)this.mScrollListeners.get(i)).onScrolled(this, paramInt1, paramInt2);  
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray) {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray) {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void draw(Canvas paramCanvas) {
    super.draw(paramCanvas);
    int i = this.mItemDecorations.size();
    boolean bool = false;
    int j;
    for (j = 0; j < i; j++)
      ((ItemDecoration)this.mItemDecorations.get(j)).onDrawOver(paramCanvas, this, this.mState); 
    if (this.mLeftGlow != null && !this.mLeftGlow.isFinished()) {
      int k = paramCanvas.save();
      if (this.mClipToPadding) {
        j = getPaddingBottom();
      } else {
        j = 0;
      } 
      paramCanvas.rotate(270.0F);
      paramCanvas.translate((-getHeight() + j), 0.0F);
      if (this.mLeftGlow != null && this.mLeftGlow.draw(paramCanvas)) {
        i = 1;
      } else {
        i = 0;
      } 
      paramCanvas.restoreToCount(k);
    } else {
      i = 0;
    } 
    j = i;
    if (this.mTopGlow != null) {
      j = i;
      if (!this.mTopGlow.isFinished()) {
        int k = paramCanvas.save();
        if (this.mClipToPadding)
          paramCanvas.translate(getPaddingLeft(), getPaddingTop()); 
        if (this.mTopGlow != null && this.mTopGlow.draw(paramCanvas)) {
          j = 1;
        } else {
          j = 0;
        } 
        j = i | j;
        paramCanvas.restoreToCount(k);
      } 
    } 
    i = j;
    if (this.mRightGlow != null) {
      i = j;
      if (!this.mRightGlow.isFinished()) {
        int k = paramCanvas.save();
        int m = getWidth();
        if (this.mClipToPadding) {
          i = getPaddingTop();
        } else {
          i = 0;
        } 
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-i, -m);
        if (this.mRightGlow != null && this.mRightGlow.draw(paramCanvas)) {
          i = 1;
        } else {
          i = 0;
        } 
        i = j | i;
        paramCanvas.restoreToCount(k);
      } 
    } 
    if (this.mBottomGlow != null && !this.mBottomGlow.isFinished()) {
      int k = paramCanvas.save();
      paramCanvas.rotate(180.0F);
      if (this.mClipToPadding) {
        paramCanvas.translate((-getWidth() + getPaddingRight()), (-getHeight() + getPaddingBottom()));
      } else {
        paramCanvas.translate(-getWidth(), -getHeight());
      } 
      j = bool;
      if (this.mBottomGlow != null) {
        j = bool;
        if (this.mBottomGlow.draw(paramCanvas))
          j = 1; 
      } 
      j |= i;
      paramCanvas.restoreToCount(k);
    } else {
      j = i;
    } 
    i = j;
    if (j == 0) {
      i = j;
      if (this.mItemAnimator != null) {
        i = j;
        if (this.mItemDecorations.size() > 0) {
          i = j;
          if (this.mItemAnimator.isRunning())
            i = 1; 
        } 
      } 
    } 
    if (i != 0)
      ViewCompat.postInvalidateOnAnimation((View)this); 
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  void eatRequestLayout() {
    this.mEatRequestLayout++;
    if (this.mEatRequestLayout == 1 && !this.mLayoutFrozen)
      this.mLayoutRequestEaten = false; 
  }
  
  void ensureBottomGlow() {
    if (this.mBottomGlow != null)
      return; 
    this.mBottomGlow = new EdgeEffectCompat(getContext());
    if (this.mClipToPadding) {
      this.mBottomGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
    } else {
      this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
    } 
  }
  
  void ensureLeftGlow() {
    if (this.mLeftGlow != null)
      return; 
    this.mLeftGlow = new EdgeEffectCompat(getContext());
    if (this.mClipToPadding) {
      this.mLeftGlow.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
    } else {
      this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
    } 
  }
  
  void ensureRightGlow() {
    if (this.mRightGlow != null)
      return; 
    this.mRightGlow = new EdgeEffectCompat(getContext());
    if (this.mClipToPadding) {
      this.mRightGlow.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
    } else {
      this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
    } 
  }
  
  void ensureTopGlow() {
    if (this.mTopGlow != null)
      return; 
    this.mTopGlow = new EdgeEffectCompat(getContext());
    if (this.mClipToPadding) {
      this.mTopGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
    } else {
      this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
    } 
  }
  
  public View findChildViewUnder(float paramFloat1, float paramFloat2) {
    for (int i = this.mChildHelper.getChildCount() - 1; i >= 0; i--) {
      View view = this.mChildHelper.getChildAt(i);
      float f1 = ViewCompat.getTranslationX(view);
      float f2 = ViewCompat.getTranslationY(view);
      if (paramFloat1 >= view.getLeft() + f1 && paramFloat1 <= view.getRight() + f1 && paramFloat2 >= view.getTop() + f2 && paramFloat2 <= view.getBottom() + f2)
        return view; 
    } 
    return null;
  }
  
  @Nullable
  public View findContainingItemView(View paramView) {
    ViewParent viewParent;
    for (viewParent = paramView.getParent(); viewParent != null && viewParent != this && viewParent instanceof View; viewParent = paramView.getParent())
      paramView = (View)viewParent; 
    if (viewParent != this)
      paramView = null; 
    return paramView;
  }
  
  @Nullable
  public ViewHolder findContainingViewHolder(View paramView) {
    ViewHolder viewHolder;
    paramView = findContainingItemView(paramView);
    if (paramView == null) {
      paramView = null;
    } else {
      viewHolder = getChildViewHolder(paramView);
    } 
    return viewHolder;
  }
  
  public ViewHolder findViewHolderForAdapterPosition(int paramInt) {
    boolean bool = this.mDataSetHasChangedAfterLayout;
    ViewHolder viewHolder = null;
    if (bool)
      return null; 
    int i = this.mChildHelper.getUnfilteredChildCount();
    byte b = 0;
    while (b < i) {
      ViewHolder viewHolder1 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(b));
      ViewHolder viewHolder2 = viewHolder;
      if (viewHolder1 != null) {
        viewHolder2 = viewHolder;
        if (!viewHolder1.isRemoved()) {
          viewHolder2 = viewHolder;
          if (getAdapterPositionFor(viewHolder1) == paramInt)
            if (this.mChildHelper.isHidden(viewHolder1.itemView)) {
              viewHolder2 = viewHolder1;
            } else {
              return viewHolder1;
            }  
        } 
      } 
      b++;
      viewHolder = viewHolder2;
    } 
    return viewHolder;
  }
  
  public ViewHolder findViewHolderForItemId(long paramLong) {
    ViewHolder viewHolder;
    Adapter adapter1 = this.mAdapter;
    Adapter adapter2 = null;
    if (adapter1 == null || !this.mAdapter.hasStableIds())
      return null; 
    int i = this.mChildHelper.getUnfilteredChildCount();
    byte b = 0;
    while (b < i) {
      ViewHolder viewHolder1;
      ViewHolder viewHolder2 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(b));
      adapter1 = adapter2;
      if (viewHolder2 != null) {
        adapter1 = adapter2;
        if (!viewHolder2.isRemoved()) {
          adapter1 = adapter2;
          if (viewHolder2.getItemId() == paramLong)
            if (this.mChildHelper.isHidden(viewHolder2.itemView)) {
              viewHolder1 = viewHolder2;
            } else {
              return viewHolder2;
            }  
        } 
      } 
      b++;
      viewHolder = viewHolder1;
    } 
    return viewHolder;
  }
  
  public ViewHolder findViewHolderForLayoutPosition(int paramInt) {
    return findViewHolderForPosition(paramInt, false);
  }
  
  @Deprecated
  public ViewHolder findViewHolderForPosition(int paramInt) {
    return findViewHolderForPosition(paramInt, false);
  }
  
  ViewHolder findViewHolderForPosition(int paramInt, boolean paramBoolean) {
    int i = this.mChildHelper.getUnfilteredChildCount();
    Object object = null;
    byte b = 0;
    while (b < i) {
      ViewHolder viewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(b));
      Object object1 = object;
      if (viewHolder != null) {
        object1 = object;
        if (!viewHolder.isRemoved()) {
          if (paramBoolean) {
            if (viewHolder.mPosition != paramInt) {
              object1 = object;
              continue;
            } 
          } else if (viewHolder.getLayoutPosition() != paramInt) {
            object1 = object;
            continue;
          } 
          if (this.mChildHelper.isHidden(viewHolder.itemView)) {
            object1 = viewHolder;
          } else {
            return viewHolder;
          } 
        } 
      } 
      continue;
      b++;
      object = SYNTHETIC_LOCAL_VARIABLE_7;
    } 
    return (ViewHolder)object;
  }
  
  public boolean fling(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mLayout : Lorg/jar/support/v7/widget/RecyclerView$LayoutManager;
    //   4: ifnonnull -> 18
    //   7: ldc 'RecyclerView'
    //   9: ldc_w 'Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.'
    //   12: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   15: pop
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: getfield mLayoutFrozen : Z
    //   22: ifeq -> 27
    //   25: iconst_0
    //   26: ireturn
    //   27: aload_0
    //   28: getfield mLayout : Lorg/jar/support/v7/widget/RecyclerView$LayoutManager;
    //   31: invokevirtual canScrollHorizontally : ()Z
    //   34: istore_3
    //   35: aload_0
    //   36: getfield mLayout : Lorg/jar/support/v7/widget/RecyclerView$LayoutManager;
    //   39: invokevirtual canScrollVertically : ()Z
    //   42: istore #4
    //   44: iload_3
    //   45: ifeq -> 62
    //   48: iload_1
    //   49: istore #5
    //   51: iload_1
    //   52: invokestatic abs : (I)I
    //   55: aload_0
    //   56: getfield mMinFlingVelocity : I
    //   59: if_icmpge -> 65
    //   62: iconst_0
    //   63: istore #5
    //   65: iload #4
    //   67: ifeq -> 83
    //   70: iload_2
    //   71: istore_1
    //   72: iload_2
    //   73: invokestatic abs : (I)I
    //   76: aload_0
    //   77: getfield mMinFlingVelocity : I
    //   80: if_icmpge -> 85
    //   83: iconst_0
    //   84: istore_1
    //   85: iload #5
    //   87: ifne -> 96
    //   90: iload_1
    //   91: ifne -> 96
    //   94: iconst_0
    //   95: ireturn
    //   96: iload #5
    //   98: i2f
    //   99: fstore #6
    //   101: iload_1
    //   102: i2f
    //   103: fstore #7
    //   105: aload_0
    //   106: fload #6
    //   108: fload #7
    //   110: invokevirtual dispatchNestedPreFling : (FF)Z
    //   113: ifne -> 195
    //   116: iload_3
    //   117: ifne -> 133
    //   120: iload #4
    //   122: ifeq -> 128
    //   125: goto -> 133
    //   128: iconst_0
    //   129: istore_3
    //   130: goto -> 135
    //   133: iconst_1
    //   134: istore_3
    //   135: aload_0
    //   136: fload #6
    //   138: fload #7
    //   140: iload_3
    //   141: invokevirtual dispatchNestedFling : (FFZ)Z
    //   144: pop
    //   145: iload_3
    //   146: ifeq -> 195
    //   149: aload_0
    //   150: getfield mMaxFlingVelocity : I
    //   153: ineg
    //   154: iload #5
    //   156: aload_0
    //   157: getfield mMaxFlingVelocity : I
    //   160: invokestatic min : (II)I
    //   163: invokestatic max : (II)I
    //   166: istore_2
    //   167: aload_0
    //   168: getfield mMaxFlingVelocity : I
    //   171: ineg
    //   172: iload_1
    //   173: aload_0
    //   174: getfield mMaxFlingVelocity : I
    //   177: invokestatic min : (II)I
    //   180: invokestatic max : (II)I
    //   183: istore_1
    //   184: aload_0
    //   185: getfield mViewFlinger : Lorg/jar/support/v7/widget/RecyclerView$ViewFlinger;
    //   188: iload_2
    //   189: iload_1
    //   190: invokevirtual fling : (II)V
    //   193: iconst_1
    //   194: ireturn
    //   195: iconst_0
    //   196: ireturn
  }
  
  public View focusSearch(View paramView, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mLayout : Lorg/jar/support/v7/widget/RecyclerView$LayoutManager;
    //   4: aload_1
    //   5: iload_2
    //   6: invokevirtual onInterceptFocusSearch : (Landroid/view/View;I)Landroid/view/View;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull -> 16
    //   14: aload_3
    //   15: areturn
    //   16: aload_0
    //   17: getfield mAdapter : Lorg/jar/support/v7/widget/RecyclerView$Adapter;
    //   20: ifnull -> 50
    //   23: aload_0
    //   24: getfield mLayout : Lorg/jar/support/v7/widget/RecyclerView$LayoutManager;
    //   27: ifnull -> 50
    //   30: aload_0
    //   31: invokevirtual isComputingLayout : ()Z
    //   34: ifne -> 50
    //   37: aload_0
    //   38: getfield mLayoutFrozen : Z
    //   41: ifne -> 50
    //   44: iconst_1
    //   45: istore #4
    //   47: goto -> 53
    //   50: iconst_0
    //   51: istore #4
    //   53: invokestatic getInstance : ()Landroid/view/FocusFinder;
    //   56: astore_3
    //   57: iload #4
    //   59: ifeq -> 272
    //   62: iload_2
    //   63: iconst_2
    //   64: if_icmpeq -> 72
    //   67: iload_2
    //   68: iconst_1
    //   69: if_icmpne -> 272
    //   72: aload_0
    //   73: getfield mLayout : Lorg/jar/support/v7/widget/RecyclerView$LayoutManager;
    //   76: invokevirtual canScrollVertically : ()Z
    //   79: ifeq -> 116
    //   82: iload_2
    //   83: iconst_2
    //   84: if_icmpne -> 95
    //   87: sipush #130
    //   90: istore #4
    //   92: goto -> 99
    //   95: bipush #33
    //   97: istore #4
    //   99: aload_3
    //   100: aload_0
    //   101: aload_1
    //   102: iload #4
    //   104: invokevirtual findNextFocus : (Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;
    //   107: ifnonnull -> 116
    //   110: iconst_1
    //   111: istore #5
    //   113: goto -> 119
    //   116: iconst_0
    //   117: istore #5
    //   119: iload #5
    //   121: istore #4
    //   123: iload #5
    //   125: ifne -> 215
    //   128: iload #5
    //   130: istore #4
    //   132: aload_0
    //   133: getfield mLayout : Lorg/jar/support/v7/widget/RecyclerView$LayoutManager;
    //   136: invokevirtual canScrollHorizontally : ()Z
    //   139: ifeq -> 215
    //   142: aload_0
    //   143: getfield mLayout : Lorg/jar/support/v7/widget/RecyclerView$LayoutManager;
    //   146: invokevirtual getLayoutDirection : ()I
    //   149: iconst_1
    //   150: if_icmpne -> 159
    //   153: iconst_1
    //   154: istore #4
    //   156: goto -> 162
    //   159: iconst_0
    //   160: istore #4
    //   162: iload_2
    //   163: iconst_2
    //   164: if_icmpne -> 173
    //   167: iconst_1
    //   168: istore #5
    //   170: goto -> 176
    //   173: iconst_0
    //   174: istore #5
    //   176: iload #4
    //   178: iload #5
    //   180: ixor
    //   181: ifeq -> 191
    //   184: bipush #66
    //   186: istore #4
    //   188: goto -> 195
    //   191: bipush #17
    //   193: istore #4
    //   195: aload_3
    //   196: aload_0
    //   197: aload_1
    //   198: iload #4
    //   200: invokevirtual findNextFocus : (Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;
    //   203: ifnonnull -> 212
    //   206: iconst_1
    //   207: istore #4
    //   209: goto -> 215
    //   212: iconst_0
    //   213: istore #4
    //   215: iload #4
    //   217: ifeq -> 261
    //   220: aload_0
    //   221: invokespecial consumePendingUpdateOperations : ()V
    //   224: aload_0
    //   225: aload_1
    //   226: invokevirtual findContainingItemView : (Landroid/view/View;)Landroid/view/View;
    //   229: ifnonnull -> 234
    //   232: aconst_null
    //   233: areturn
    //   234: aload_0
    //   235: invokevirtual eatRequestLayout : ()V
    //   238: aload_0
    //   239: getfield mLayout : Lorg/jar/support/v7/widget/RecyclerView$LayoutManager;
    //   242: aload_1
    //   243: iload_2
    //   244: aload_0
    //   245: getfield mRecycler : Lorg/jar/support/v7/widget/RecyclerView$Recycler;
    //   248: aload_0
    //   249: getfield mState : Lorg/jar/support/v7/widget/RecyclerView$State;
    //   252: invokevirtual onFocusSearchFailed : (Landroid/view/View;ILorg/jar/support/v7/widget/RecyclerView$Recycler;Lorg/jar/support/v7/widget/RecyclerView$State;)Landroid/view/View;
    //   255: pop
    //   256: aload_0
    //   257: iconst_0
    //   258: invokevirtual resumeRequestLayout : (Z)V
    //   261: aload_3
    //   262: aload_0
    //   263: aload_1
    //   264: iload_2
    //   265: invokevirtual findNextFocus : (Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;
    //   268: astore_3
    //   269: goto -> 333
    //   272: aload_3
    //   273: aload_0
    //   274: aload_1
    //   275: iload_2
    //   276: invokevirtual findNextFocus : (Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;
    //   279: astore_3
    //   280: aload_3
    //   281: ifnonnull -> 333
    //   284: iload #4
    //   286: ifeq -> 333
    //   289: aload_0
    //   290: invokespecial consumePendingUpdateOperations : ()V
    //   293: aload_0
    //   294: aload_1
    //   295: invokevirtual findContainingItemView : (Landroid/view/View;)Landroid/view/View;
    //   298: ifnonnull -> 303
    //   301: aconst_null
    //   302: areturn
    //   303: aload_0
    //   304: invokevirtual eatRequestLayout : ()V
    //   307: aload_0
    //   308: getfield mLayout : Lorg/jar/support/v7/widget/RecyclerView$LayoutManager;
    //   311: aload_1
    //   312: iload_2
    //   313: aload_0
    //   314: getfield mRecycler : Lorg/jar/support/v7/widget/RecyclerView$Recycler;
    //   317: aload_0
    //   318: getfield mState : Lorg/jar/support/v7/widget/RecyclerView$State;
    //   321: invokevirtual onFocusSearchFailed : (Landroid/view/View;ILorg/jar/support/v7/widget/RecyclerView$Recycler;Lorg/jar/support/v7/widget/RecyclerView$State;)Landroid/view/View;
    //   324: astore_3
    //   325: aload_0
    //   326: iconst_0
    //   327: invokevirtual resumeRequestLayout : (Z)V
    //   330: goto -> 333
    //   333: aload_0
    //   334: aload_1
    //   335: aload_3
    //   336: iload_2
    //   337: invokespecial isPreferredNextFocus : (Landroid/view/View;Landroid/view/View;I)Z
    //   340: ifeq -> 346
    //   343: goto -> 353
    //   346: aload_0
    //   347: aload_1
    //   348: iload_2
    //   349: invokespecial focusSearch : (Landroid/view/View;I)Landroid/view/View;
    //   352: astore_3
    //   353: aload_3
    //   354: areturn
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
    if (this.mLayout != null)
      return (ViewGroup.LayoutParams)this.mLayout.generateDefaultLayoutParams(); 
    throw new IllegalStateException("RecyclerView has no LayoutManager");
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    if (this.mLayout != null)
      return (ViewGroup.LayoutParams)this.mLayout.generateLayoutParams(getContext(), paramAttributeSet); 
    throw new IllegalStateException("RecyclerView has no LayoutManager");
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    if (this.mLayout != null)
      return (ViewGroup.LayoutParams)this.mLayout.generateLayoutParams(paramLayoutParams); 
    throw new IllegalStateException("RecyclerView has no LayoutManager");
  }
  
  public Adapter getAdapter() {
    return this.mAdapter;
  }
  
  public int getBaseline() {
    return (this.mLayout != null) ? this.mLayout.getBaseline() : super.getBaseline();
  }
  
  long getChangedHolderKey(ViewHolder paramViewHolder) {
    long l;
    if (this.mAdapter.hasStableIds()) {
      l = paramViewHolder.getItemId();
    } else {
      l = paramViewHolder.mPosition;
    } 
    return l;
  }
  
  public int getChildAdapterPosition(View paramView) {
    byte b;
    ViewHolder viewHolder = getChildViewHolderInt(paramView);
    if (viewHolder != null) {
      b = viewHolder.getAdapterPosition();
    } else {
      b = -1;
    } 
    return b;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2) {
    return (this.mChildDrawingOrderCallback == null) ? super.getChildDrawingOrder(paramInt1, paramInt2) : this.mChildDrawingOrderCallback.onGetChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public long getChildItemId(View paramView) {
    Adapter adapter = this.mAdapter;
    long l = -1L;
    if (adapter == null || !this.mAdapter.hasStableIds())
      return -1L; 
    ViewHolder viewHolder = getChildViewHolderInt(paramView);
    if (viewHolder != null)
      l = viewHolder.getItemId(); 
    return l;
  }
  
  public int getChildLayoutPosition(View paramView) {
    byte b;
    ViewHolder viewHolder = getChildViewHolderInt(paramView);
    if (viewHolder != null) {
      b = viewHolder.getLayoutPosition();
    } else {
      b = -1;
    } 
    return b;
  }
  
  @Deprecated
  public int getChildPosition(View paramView) {
    return getChildAdapterPosition(paramView);
  }
  
  public ViewHolder getChildViewHolder(View paramView) {
    ViewParent viewParent = paramView.getParent();
    if (viewParent == null || viewParent == this)
      return getChildViewHolderInt(paramView); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("View ");
    stringBuilder.append(paramView);
    stringBuilder.append(" is not a direct child of ");
    stringBuilder.append(this);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public ItemAnimator getItemAnimator() {
    return this.mItemAnimator;
  }
  
  Rect getItemDecorInsetsForChild(View paramView) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!layoutParams.mInsetsDirty)
      return layoutParams.mDecorInsets; 
    Rect rect = layoutParams.mDecorInsets;
    rect.set(0, 0, 0, 0);
    int i = this.mItemDecorations.size();
    for (byte b = 0; b < i; b++) {
      this.mTempRect.set(0, 0, 0, 0);
      ((ItemDecoration)this.mItemDecorations.get(b)).getItemOffsets(this.mTempRect, paramView, this, this.mState);
      rect.left += this.mTempRect.left;
      rect.top += this.mTempRect.top;
      rect.right += this.mTempRect.right;
      rect.bottom += this.mTempRect.bottom;
    } 
    layoutParams.mInsetsDirty = false;
    return rect;
  }
  
  public LayoutManager getLayoutManager() {
    return this.mLayout;
  }
  
  public int getMaxFlingVelocity() {
    return this.mMaxFlingVelocity;
  }
  
  public int getMinFlingVelocity() {
    return this.mMinFlingVelocity;
  }
  
  public boolean getPreserveFocusAfterLayout() {
    return this.mPreserveFocusAfterLayout;
  }
  
  public RecycledViewPool getRecycledViewPool() {
    return this.mRecycler.getRecycledViewPool();
  }
  
  public int getScrollState() {
    return this.mScrollState;
  }
  
  public boolean hasFixedSize() {
    return this.mHasFixedSize;
  }
  
  public boolean hasNestedScrollingParent() {
    return getScrollingChildHelper().hasNestedScrollingParent();
  }
  
  public boolean hasPendingAdapterUpdates() {
    return (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.hasPendingUpdates());
  }
  
  void initAdapterManager() {
    this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback() {
          void dispatchUpdate(AdapterHelper.UpdateOp param1UpdateOp) {
            int i = param1UpdateOp.cmd;
            if (i != 4) {
              if (i != 8) {
                switch (i) {
                  default:
                    return;
                  case 2:
                    RecyclerView.this.mLayout.onItemsRemoved(RecyclerView.this, param1UpdateOp.positionStart, param1UpdateOp.itemCount);
                  case 1:
                    break;
                } 
                RecyclerView.this.mLayout.onItemsAdded(RecyclerView.this, param1UpdateOp.positionStart, param1UpdateOp.itemCount);
              } 
              RecyclerView.this.mLayout.onItemsMoved(RecyclerView.this, param1UpdateOp.positionStart, param1UpdateOp.itemCount, 1);
            } 
            RecyclerView.this.mLayout.onItemsUpdated(RecyclerView.this, param1UpdateOp.positionStart, param1UpdateOp.itemCount, param1UpdateOp.payload);
          }
          
          public RecyclerView.ViewHolder findViewHolder(int param1Int) {
            RecyclerView.ViewHolder viewHolder = RecyclerView.this.findViewHolderForPosition(param1Int, true);
            return (viewHolder == null) ? null : (RecyclerView.this.mChildHelper.isHidden(viewHolder.itemView) ? null : viewHolder);
          }
          
          public void markViewHoldersUpdated(int param1Int1, int param1Int2, Object param1Object) {
            RecyclerView.this.viewRangeUpdate(param1Int1, param1Int2, param1Object);
            RecyclerView.this.mItemsChanged = true;
          }
          
          public void offsetPositionsForAdd(int param1Int1, int param1Int2) {
            RecyclerView.this.offsetPositionRecordsForInsert(param1Int1, param1Int2);
            RecyclerView.this.mItemsAddedOrRemoved = true;
          }
          
          public void offsetPositionsForMove(int param1Int1, int param1Int2) {
            RecyclerView.this.offsetPositionRecordsForMove(param1Int1, param1Int2);
            RecyclerView.this.mItemsAddedOrRemoved = true;
          }
          
          public void offsetPositionsForRemovingInvisible(int param1Int1, int param1Int2) {
            RecyclerView.this.offsetPositionRecordsForRemove(param1Int1, param1Int2, true);
            RecyclerView.this.mItemsAddedOrRemoved = true;
            RecyclerView.State state = RecyclerView.this.mState;
            RecyclerView.State.access$1702(state, state.mDeletedInvisibleItemCountSincePreviousLayout + param1Int2);
          }
          
          public void offsetPositionsForRemovingLaidOutOrNewView(int param1Int1, int param1Int2) {
            RecyclerView.this.offsetPositionRecordsForRemove(param1Int1, param1Int2, false);
            RecyclerView.this.mItemsAddedOrRemoved = true;
          }
          
          public void onDispatchFirstPass(AdapterHelper.UpdateOp param1UpdateOp) {
            dispatchUpdate(param1UpdateOp);
          }
          
          public void onDispatchSecondPass(AdapterHelper.UpdateOp param1UpdateOp) {
            dispatchUpdate(param1UpdateOp);
          }
        });
  }
  
  void invalidateGlows() {
    this.mBottomGlow = null;
    this.mTopGlow = null;
    this.mRightGlow = null;
    this.mLeftGlow = null;
  }
  
  public void invalidateItemDecorations() {
    if (this.mItemDecorations.size() == 0)
      return; 
    if (this.mLayout != null)
      this.mLayout.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout"); 
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  public boolean isAnimating() {
    boolean bool;
    if (this.mItemAnimator != null && this.mItemAnimator.isRunning()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isAttachedToWindow() {
    return this.mIsAttached;
  }
  
  public boolean isComputingLayout() {
    boolean bool;
    if (this.mLayoutOrScrollCounter > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isLayoutFrozen() {
    return this.mLayoutFrozen;
  }
  
  public boolean isNestedScrollingEnabled() {
    return getScrollingChildHelper().isNestedScrollingEnabled();
  }
  
  void markItemDecorInsetsDirty() {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (byte b = 0; b < i; b++)
      ((LayoutParams)this.mChildHelper.getUnfilteredChildAt(b).getLayoutParams()).mInsetsDirty = true; 
    this.mRecycler.markItemDecorInsetsDirty();
  }
  
  void markKnownViewsInvalid() {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (byte b = 0; b < i; b++) {
      ViewHolder viewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(b));
      if (viewHolder != null && !viewHolder.shouldIgnore())
        viewHolder.addFlags(6); 
    } 
    markItemDecorInsetsDirty();
    this.mRecycler.markKnownViewsInvalid();
  }
  
  public void offsetChildrenHorizontal(int paramInt) {
    int i = this.mChildHelper.getChildCount();
    for (byte b = 0; b < i; b++)
      this.mChildHelper.getChildAt(b).offsetLeftAndRight(paramInt); 
  }
  
  public void offsetChildrenVertical(int paramInt) {
    int i = this.mChildHelper.getChildCount();
    for (byte b = 0; b < i; b++)
      this.mChildHelper.getChildAt(b).offsetTopAndBottom(paramInt); 
  }
  
  void offsetPositionRecordsForInsert(int paramInt1, int paramInt2) {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (byte b = 0; b < i; b++) {
      ViewHolder viewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(b));
      if (viewHolder != null && !viewHolder.shouldIgnore() && viewHolder.mPosition >= paramInt1) {
        viewHolder.offsetPosition(paramInt2, false);
        State.access$1802(this.mState, true);
      } 
    } 
    this.mRecycler.offsetPositionRecordsForInsert(paramInt1, paramInt2);
    requestLayout();
  }
  
  void offsetPositionRecordsForMove(int paramInt1, int paramInt2) {
    int j;
    int k;
    boolean bool;
    int i = this.mChildHelper.getUnfilteredChildCount();
    if (paramInt1 < paramInt2) {
      j = paramInt1;
      k = paramInt2;
      bool = true;
    } else {
      k = paramInt1;
      j = paramInt2;
      bool = true;
    } 
    for (byte b = 0; b < i; b++) {
      ViewHolder viewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(b));
      if (viewHolder != null && viewHolder.mPosition >= j && viewHolder.mPosition <= k) {
        if (viewHolder.mPosition == paramInt1) {
          viewHolder.offsetPosition(paramInt2 - paramInt1, false);
        } else {
          viewHolder.offsetPosition(bool, false);
        } 
        State.access$1802(this.mState, true);
      } 
    } 
    this.mRecycler.offsetPositionRecordsForMove(paramInt1, paramInt2);
    requestLayout();
  }
  
  void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean) {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (byte b = 0; b < i; b++) {
      ViewHolder viewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(b));
      if (viewHolder != null && !viewHolder.shouldIgnore())
        if (viewHolder.mPosition >= paramInt1 + paramInt2) {
          viewHolder.offsetPosition(-paramInt2, paramBoolean);
          State.access$1802(this.mState, true);
        } else if (viewHolder.mPosition >= paramInt1) {
          viewHolder.flagRemovedAndOffsetPosition(paramInt1 - 1, -paramInt2, paramBoolean);
          State.access$1802(this.mState, true);
        }  
    } 
    this.mRecycler.offsetPositionRecordsForRemove(paramInt1, paramInt2, paramBoolean);
    requestLayout();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.mLayoutOrScrollCounter = 0;
    boolean bool = true;
    this.mIsAttached = true;
    if (!this.mFirstLayoutComplete || isLayoutRequested())
      bool = false; 
    this.mFirstLayoutComplete = bool;
    if (this.mLayout != null)
      this.mLayout.dispatchAttachedToWindow(this); 
    this.mPostedAnimatorRunner = false;
  }
  
  public void onChildAttachedToWindow(View paramView) {}
  
  public void onChildDetachedFromWindow(View paramView) {}
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.mItemAnimator != null)
      this.mItemAnimator.endAnimations(); 
    stopScroll();
    this.mIsAttached = false;
    if (this.mLayout != null)
      this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler); 
    removeCallbacks(this.mItemAnimatorRunner);
    this.mViewInfoStore.onDetach();
  }
  
  public void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    int i = this.mItemDecorations.size();
    for (byte b = 0; b < i; b++)
      ((ItemDecoration)this.mItemDecorations.get(b)).onDraw(paramCanvas, this, this.mState); 
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent) {
    if (this.mLayout == null)
      return false; 
    if (this.mLayoutFrozen)
      return false; 
    if ((MotionEventCompat.getSource(paramMotionEvent) & 0x2) != 0 && paramMotionEvent.getAction() == 8) {
      float f1;
      float f2;
      if (this.mLayout.canScrollVertically()) {
        f1 = -MotionEventCompat.getAxisValue(paramMotionEvent, 9);
      } else {
        f1 = 0.0F;
      } 
      if (this.mLayout.canScrollHorizontally()) {
        f2 = MotionEventCompat.getAxisValue(paramMotionEvent, 10);
      } else {
        f2 = 0.0F;
      } 
      if (f1 != 0.0F || f2 != 0.0F) {
        float f = getScrollFactor();
        scrollByInternal((int)(f2 * f), (int)(f1 * f), paramMotionEvent);
      } 
    } 
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    StringBuilder stringBuilder;
    int[] arrayOfInt;
    boolean bool1 = this.mLayoutFrozen;
    boolean bool = false;
    if (bool1)
      return false; 
    if (dispatchOnItemTouchIntercept(paramMotionEvent)) {
      cancelTouch();
      return true;
    } 
    if (this.mLayout == null)
      return false; 
    boolean bool2 = this.mLayout.canScrollHorizontally();
    bool1 = this.mLayout.canScrollVertically();
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain(); 
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    int j = MotionEventCompat.getActionIndex(paramMotionEvent);
    switch (i) {
      case 6:
        onPointerUp(paramMotionEvent);
        break;
      case 5:
        this.mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, j);
        i = (int)(MotionEventCompat.getX(paramMotionEvent, j) + 0.5F);
        this.mLastTouchX = i;
        this.mInitialTouchX = i;
        j = (int)(MotionEventCompat.getY(paramMotionEvent, j) + 0.5F);
        this.mLastTouchY = j;
        this.mInitialTouchY = j;
        break;
      case 3:
        cancelTouch();
        break;
      case 2:
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mScrollPointerId);
        if (i < 0) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Error processing scroll; pointer index for id ");
          stringBuilder.append(this.mScrollPointerId);
          stringBuilder.append(" not found. Did any MotionEvents get skipped?");
          Log.e("RecyclerView", stringBuilder.toString());
          return false;
        } 
        j = (int)(MotionEventCompat.getX((MotionEvent)stringBuilder, i) + 0.5F);
        i = (int)(MotionEventCompat.getY((MotionEvent)stringBuilder, i) + 0.5F);
        if (this.mScrollState != 1) {
          j -= this.mInitialTouchX;
          int k = i - this.mInitialTouchY;
          byte b = -1;
          if (bool2 && Math.abs(j) > this.mTouchSlop) {
            i = this.mInitialTouchX;
            int m = this.mTouchSlop;
            if (j < 0) {
              j = -1;
            } else {
              j = 1;
            } 
            this.mLastTouchX = i + m * j;
            j = 1;
          } else {
            j = 0;
          } 
          i = j;
          if (bool1) {
            i = j;
            if (Math.abs(k) > this.mTouchSlop) {
              i = this.mInitialTouchY;
              int m = this.mTouchSlop;
              if (k < 0) {
                j = b;
              } else {
                j = 1;
              } 
              this.mLastTouchY = i + m * j;
              i = 1;
            } 
          } 
          if (i != 0)
            setScrollState(1); 
        } 
        break;
      case 1:
        this.mVelocityTracker.clear();
        stopNestedScroll();
        break;
      case 0:
        if (this.mIgnoreMotionEventTillDown)
          this.mIgnoreMotionEventTillDown = false; 
        this.mScrollPointerId = MotionEventCompat.getPointerId((MotionEvent)stringBuilder, 0);
        j = (int)(stringBuilder.getX() + 0.5F);
        this.mLastTouchX = j;
        this.mInitialTouchX = j;
        j = (int)(stringBuilder.getY() + 0.5F);
        this.mLastTouchY = j;
        this.mInitialTouchY = j;
        if (this.mScrollState == 2) {
          getParent().requestDisallowInterceptTouchEvent(true);
          setScrollState(1);
        } 
        arrayOfInt = this.mNestedOffsets;
        this.mNestedOffsets[1] = 0;
        arrayOfInt[0] = 0;
        if (bool2) {
          j = 1;
        } else {
          j = 0;
        } 
        i = j;
        if (bool1)
          i = j | 0x2; 
        startNestedScroll(i);
        break;
    } 
    if (this.mScrollState == 1)
      bool = true; 
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    TraceCompat.beginSection("RV OnLayout");
    dispatchLayout();
    TraceCompat.endSection();
    this.mFirstLayoutComplete = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (this.mLayout == null) {
      defaultOnMeasure(paramInt1, paramInt2);
      return;
    } 
    boolean bool = this.mLayout.mAutoMeasure;
    boolean bool1 = false;
    if (bool) {
      int i = View.MeasureSpec.getMode(paramInt1);
      int j = View.MeasureSpec.getMode(paramInt2);
      boolean bool2 = bool1;
      if (i == 1073741824) {
        bool2 = bool1;
        if (j == 1073741824)
          bool2 = true; 
      } 
      this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      if (bool2 || this.mAdapter == null)
        return; 
      if (this.mState.mLayoutStep == 1)
        dispatchLayoutStep1(); 
      this.mLayout.setMeasureSpecs(paramInt1, paramInt2);
      State.access$2202(this.mState, true);
      dispatchLayoutStep2();
      this.mLayout.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
      if (this.mLayout.shouldMeasureTwice()) {
        this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        State.access$2202(this.mState, true);
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
      } 
    } else {
      if (this.mHasFixedSize) {
        this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
        return;
      } 
      if (this.mAdapterUpdateDuringMeasure) {
        eatRequestLayout();
        processAdapterUpdatesAndSetAnimationFlags();
        if (this.mState.mRunPredictiveAnimations) {
          State.access$2402(this.mState, true);
        } else {
          this.mAdapterHelper.consumeUpdatesInOnePass();
          State.access$2402(this.mState, false);
        } 
        this.mAdapterUpdateDuringMeasure = false;
        resumeRequestLayout(false);
      } 
      if (this.mAdapter != null) {
        this.mState.mItemCount = this.mAdapter.getItemCount();
      } else {
        this.mState.mItemCount = 0;
      } 
      eatRequestLayout();
      this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      resumeRequestLayout(false);
      State.access$2402(this.mState, false);
    } 
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect) {
    return isComputingLayout() ? false : super.onRequestFocusInDescendants(paramInt, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    this.mPendingSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
    if (this.mLayout != null && this.mPendingSavedState.mLayoutState != null)
      this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState); 
  }
  
  protected Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    if (this.mPendingSavedState != null) {
      savedState.copyFrom(this.mPendingSavedState);
    } else if (this.mLayout != null) {
      savedState.mLayoutState = this.mLayout.onSaveInstanceState();
    } else {
      savedState.mLayoutState = null;
    } 
    return (Parcelable)savedState;
  }
  
  public void onScrollStateChanged(int paramInt) {}
  
  public void onScrolled(int paramInt1, int paramInt2) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3 || paramInt2 != paramInt4)
      invalidateGlows(); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    StringBuilder stringBuilder;
    int[] arrayOfInt;
    int k;
    int m;
    int n;
    int i1;
    float f1;
    float f2;
    boolean bool1 = this.mLayoutFrozen;
    boolean bool = false;
    if (bool1 || this.mIgnoreMotionEventTillDown)
      return false; 
    if (dispatchOnItemTouch(paramMotionEvent)) {
      cancelTouch();
      return true;
    } 
    if (this.mLayout == null)
      return false; 
    bool1 = this.mLayout.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain(); 
    MotionEvent motionEvent = MotionEvent.obtain(paramMotionEvent);
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    int j = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (i == 0) {
      int[] arrayOfInt1 = this.mNestedOffsets;
      this.mNestedOffsets[1] = 0;
      arrayOfInt1[0] = 0;
    } 
    motionEvent.offsetLocation(this.mNestedOffsets[0], this.mNestedOffsets[1]);
    switch (i) {
      default:
        j = bool;
        break;
      case 6:
        onPointerUp(paramMotionEvent);
        j = bool;
        break;
      case 5:
        this.mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, j);
        i = (int)(MotionEventCompat.getX(paramMotionEvent, j) + 0.5F);
        this.mLastTouchX = i;
        this.mInitialTouchX = i;
        j = (int)(MotionEventCompat.getY(paramMotionEvent, j) + 0.5F);
        this.mLastTouchY = j;
        this.mInitialTouchY = j;
        j = bool;
        break;
      case 3:
        cancelTouch();
        j = bool;
        break;
      case 2:
        j = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mScrollPointerId);
        if (j < 0) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Error processing scroll; pointer index for id ");
          stringBuilder.append(this.mScrollPointerId);
          stringBuilder.append(" not found. Did any MotionEvents get skipped?");
          Log.e("RecyclerView", stringBuilder.toString());
          return false;
        } 
        k = (int)(MotionEventCompat.getX((MotionEvent)stringBuilder, j) + 0.5F);
        m = (int)(MotionEventCompat.getY((MotionEvent)stringBuilder, j) + 0.5F);
        n = this.mLastTouchX - k;
        i1 = this.mLastTouchY - m;
        i = n;
        j = i1;
        if (dispatchNestedPreScroll(n, i1, this.mScrollConsumed, this.mScrollOffset)) {
          i = n - this.mScrollConsumed[0];
          j = i1 - this.mScrollConsumed[1];
          motionEvent.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]);
          arrayOfInt = this.mNestedOffsets;
          arrayOfInt[0] = arrayOfInt[0] + this.mScrollOffset[0];
          arrayOfInt = this.mNestedOffsets;
          arrayOfInt[1] = arrayOfInt[1] + this.mScrollOffset[1];
        } 
        n = i;
        i1 = j;
        if (this.mScrollState != 1) {
          if (bool1 && Math.abs(i) > this.mTouchSlop) {
            if (i > 0) {
              i -= this.mTouchSlop;
            } else {
              i += this.mTouchSlop;
            } 
            i1 = 1;
          } else {
            i1 = 0;
          } 
          int i2 = j;
          int i3 = i1;
          if (bool2) {
            i2 = j;
            i3 = i1;
            if (Math.abs(j) > this.mTouchSlop) {
              if (j > 0) {
                i2 = j - this.mTouchSlop;
              } else {
                i2 = j + this.mTouchSlop;
              } 
              i3 = 1;
            } 
          } 
          n = i;
          i1 = i2;
          if (i3 != 0) {
            setScrollState(1);
            i1 = i2;
            n = i;
          } 
        } 
        j = bool;
        if (this.mScrollState == 1) {
          this.mLastTouchX = k - this.mScrollOffset[0];
          this.mLastTouchY = m - this.mScrollOffset[1];
          if (!bool1)
            n = 0; 
          if (!bool2)
            i1 = 0; 
          j = bool;
          if (scrollByInternal(n, i1, motionEvent)) {
            getParent().requestDisallowInterceptTouchEvent(true);
            j = bool;
          } 
        } 
        break;
      case 1:
        this.mVelocityTracker.addMovement(motionEvent);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
        if (bool1) {
          f1 = -VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mScrollPointerId);
        } else {
          f1 = 0.0F;
        } 
        if (bool2) {
          f2 = -VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mScrollPointerId);
        } else {
          f2 = 0.0F;
        } 
        if ((f1 == 0.0F && f2 == 0.0F) || !fling((int)f1, (int)f2))
          setScrollState(0); 
        resetTouch();
        j = 1;
        break;
      case 0:
        this.mScrollPointerId = MotionEventCompat.getPointerId((MotionEvent)arrayOfInt, 0);
        j = (int)(arrayOfInt.getX() + 0.5F);
        this.mLastTouchX = j;
        this.mInitialTouchX = j;
        j = (int)(arrayOfInt.getY() + 0.5F);
        this.mLastTouchY = j;
        this.mInitialTouchY = j;
        if (bool1) {
          j = 1;
        } else {
          j = 0;
        } 
        i = j;
        if (bool2)
          i = j | 0x2; 
        startNestedScroll(i);
        j = bool;
        break;
    } 
    if (j == 0)
      this.mVelocityTracker.addMovement(motionEvent); 
    motionEvent.recycle();
    return true;
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean) {
    StringBuilder stringBuilder;
    ViewHolder viewHolder = getChildViewHolderInt(paramView);
    if (viewHolder != null)
      if (viewHolder.isTmpDetached()) {
        viewHolder.clearTmpDetachFlag();
      } else if (!viewHolder.shouldIgnore()) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
        stringBuilder.append(viewHolder);
        throw new IllegalArgumentException(stringBuilder.toString());
      }  
    dispatchChildDetached((View)stringBuilder);
    super.removeDetachedView((View)stringBuilder, paramBoolean);
  }
  
  public void removeItemDecoration(ItemDecoration paramItemDecoration) {
    if (this.mLayout != null)
      this.mLayout.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout"); 
    this.mItemDecorations.remove(paramItemDecoration);
    if (this.mItemDecorations.isEmpty()) {
      boolean bool;
      if (ViewCompat.getOverScrollMode((View)this) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      setWillNotDraw(bool);
    } 
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener paramOnChildAttachStateChangeListener) {
    if (this.mOnChildAttachStateListeners == null)
      return; 
    this.mOnChildAttachStateListeners.remove(paramOnChildAttachStateChangeListener);
  }
  
  public void removeOnItemTouchListener(OnItemTouchListener paramOnItemTouchListener) {
    this.mOnItemTouchListeners.remove(paramOnItemTouchListener);
    if (this.mActiveOnItemTouchListener == paramOnItemTouchListener)
      this.mActiveOnItemTouchListener = null; 
  }
  
  public void removeOnScrollListener(OnScrollListener paramOnScrollListener) {
    if (this.mScrollListeners != null)
      this.mScrollListeners.remove(paramOnScrollListener); 
  }
  
  public void requestChildFocus(View paramView1, View paramView2) {
    if (!this.mLayout.onRequestChildFocus(this, this.mState, paramView1, paramView2) && paramView2 != null) {
      this.mTempRect.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
      ViewGroup.LayoutParams layoutParams = paramView2.getLayoutParams();
      if (layoutParams instanceof LayoutParams) {
        LayoutParams layoutParams1 = (LayoutParams)layoutParams;
        if (!layoutParams1.mInsetsDirty) {
          Rect rect1 = layoutParams1.mDecorInsets;
          Rect rect2 = this.mTempRect;
          rect2.left -= rect1.left;
          rect2 = this.mTempRect;
          rect2.right += rect1.right;
          rect2 = this.mTempRect;
          rect2.top -= rect1.top;
          rect2 = this.mTempRect;
          rect2.bottom += rect1.bottom;
        } 
      } 
      offsetDescendantRectToMyCoords(paramView2, this.mTempRect);
      offsetRectIntoDescendantCoords(paramView1, this.mTempRect);
      requestChildRectangleOnScreen(paramView1, this.mTempRect, this.mFirstLayoutComplete ^ true);
    } 
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean) {
    return this.mLayout.requestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
    int i = this.mOnItemTouchListeners.size();
    for (byte b = 0; b < i; b++)
      ((OnItemTouchListener)this.mOnItemTouchListeners.get(b)).onRequestDisallowInterceptTouchEvent(paramBoolean); 
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout() {
    if (this.mEatRequestLayout == 0 && !this.mLayoutFrozen) {
      super.requestLayout();
    } else {
      this.mLayoutRequestEaten = true;
    } 
  }
  
  void resumeRequestLayout(boolean paramBoolean) {
    if (this.mEatRequestLayout < 1)
      this.mEatRequestLayout = 1; 
    if (!paramBoolean)
      this.mLayoutRequestEaten = false; 
    if (this.mEatRequestLayout == 1) {
      if (paramBoolean && this.mLayoutRequestEaten && !this.mLayoutFrozen && this.mLayout != null && this.mAdapter != null)
        dispatchLayout(); 
      if (!this.mLayoutFrozen)
        this.mLayoutRequestEaten = false; 
    } 
    this.mEatRequestLayout--;
  }
  
  void saveOldPositions() {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (byte b = 0; b < i; b++) {
      ViewHolder viewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(b));
      if (!viewHolder.shouldIgnore())
        viewHolder.saveOldPosition(); 
    } 
  }
  
  public void scrollBy(int paramInt1, int paramInt2) {
    if (this.mLayout == null) {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    } 
    if (this.mLayoutFrozen)
      return; 
    boolean bool1 = this.mLayout.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if (bool1 || bool2) {
      if (!bool1)
        paramInt1 = 0; 
      if (!bool2)
        paramInt2 = 0; 
      scrollByInternal(paramInt1, paramInt2, (MotionEvent)null);
    } 
  }
  
  boolean scrollByInternal(int paramInt1, int paramInt2, MotionEvent paramMotionEvent) {
    int[] arrayOfInt;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    consumePendingUpdateOperations();
    Adapter adapter = this.mAdapter;
    boolean bool1 = false;
    if (adapter != null) {
      eatRequestLayout();
      onEnterLayoutOrScroll();
      TraceCompat.beginSection("RV Scroll");
      if (paramInt1 != 0) {
        bool2 = this.mLayout.scrollHorizontallyBy(paramInt1, this.mRecycler, this.mState);
        bool3 = paramInt1 - bool2;
      } else {
        bool2 = false;
        bool3 = false;
      } 
      if (paramInt2 != 0) {
        bool4 = this.mLayout.scrollVerticallyBy(paramInt2, this.mRecycler, this.mState);
        bool5 = paramInt2 - bool4;
      } else {
        bool4 = false;
        bool5 = false;
      } 
      TraceCompat.endSection();
      repositionShadowingViews();
      onExitLayoutOrScroll();
      resumeRequestLayout(false);
    } else {
      bool2 = false;
      bool3 = false;
      bool4 = false;
      bool5 = false;
    } 
    if (!this.mItemDecorations.isEmpty())
      invalidate(); 
    if (dispatchNestedScroll(bool2, bool4, bool3, bool5, this.mScrollOffset)) {
      this.mLastTouchX -= this.mScrollOffset[0];
      this.mLastTouchY -= this.mScrollOffset[1];
      if (paramMotionEvent != null)
        paramMotionEvent.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]); 
      arrayOfInt = this.mNestedOffsets;
      arrayOfInt[0] = arrayOfInt[0] + this.mScrollOffset[0];
      arrayOfInt = this.mNestedOffsets;
      arrayOfInt[1] = arrayOfInt[1] + this.mScrollOffset[1];
    } else if (ViewCompat.getOverScrollMode((View)this) != 2) {
      if (arrayOfInt != null)
        pullGlows(arrayOfInt.getX(), bool3, arrayOfInt.getY(), bool5); 
      considerReleasingGlowsOnScroll(paramInt1, paramInt2);
    } 
    if (bool2 || bool4)
      dispatchOnScrolled(bool2, bool4); 
    if (!awakenScrollBars())
      invalidate(); 
    if (bool2 || bool4)
      bool1 = true; 
    return bool1;
  }
  
  public void scrollTo(int paramInt1, int paramInt2) {
    Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
  }
  
  public void scrollToPosition(int paramInt) {
    if (this.mLayoutFrozen)
      return; 
    stopScroll();
    if (this.mLayout == null) {
      Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    } 
    this.mLayout.scrollToPosition(paramInt);
    awakenScrollBars();
  }
  
  public void setAdapter(Adapter paramAdapter) {
    setLayoutFrozen(false);
    setAdapterInternal(paramAdapter, false, true);
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(ChildDrawingOrderCallback paramChildDrawingOrderCallback) {
    boolean bool;
    if (paramChildDrawingOrderCallback == this.mChildDrawingOrderCallback)
      return; 
    this.mChildDrawingOrderCallback = paramChildDrawingOrderCallback;
    if (this.mChildDrawingOrderCallback != null) {
      bool = true;
    } else {
      bool = false;
    } 
    setChildrenDrawingOrderEnabled(bool);
  }
  
  public void setClipToPadding(boolean paramBoolean) {
    if (paramBoolean != this.mClipToPadding)
      invalidateGlows(); 
    this.mClipToPadding = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.mFirstLayoutComplete)
      requestLayout(); 
  }
  
  public void setHasFixedSize(boolean paramBoolean) {
    this.mHasFixedSize = paramBoolean;
  }
  
  public void setItemAnimator(ItemAnimator paramItemAnimator) {
    if (this.mItemAnimator != null) {
      this.mItemAnimator.endAnimations();
      this.mItemAnimator.setListener(null);
    } 
    this.mItemAnimator = paramItemAnimator;
    if (this.mItemAnimator != null)
      this.mItemAnimator.setListener(this.mItemAnimatorListener); 
  }
  
  public void setItemViewCacheSize(int paramInt) {
    this.mRecycler.setViewCacheSize(paramInt);
  }
  
  public void setLayoutFrozen(boolean paramBoolean) {
    if (paramBoolean != this.mLayoutFrozen) {
      assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean) {
        this.mLayoutFrozen = false;
        if (this.mLayoutRequestEaten && this.mLayout != null && this.mAdapter != null)
          requestLayout(); 
        this.mLayoutRequestEaten = false;
      } else {
        long l = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
        this.mLayoutFrozen = true;
        this.mIgnoreMotionEventTillDown = true;
        stopScroll();
      } 
    } 
  }
  
  public void setLayoutManager(LayoutManager paramLayoutManager) {
    if (paramLayoutManager == this.mLayout)
      return; 
    stopScroll();
    if (this.mLayout != null) {
      if (this.mIsAttached)
        this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler); 
      this.mLayout.setRecyclerView(null);
    } 
    this.mRecycler.clear();
    this.mChildHelper.removeAllViewsUnfiltered();
    this.mLayout = paramLayoutManager;
    if (paramLayoutManager != null)
      if (paramLayoutManager.mRecyclerView == null) {
        this.mLayout.setRecyclerView(this);
        if (this.mIsAttached)
          this.mLayout.dispatchAttachedToWindow(this); 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LayoutManager ");
        stringBuilder.append(paramLayoutManager);
        stringBuilder.append(" is already attached to a RecyclerView: ");
        stringBuilder.append(paramLayoutManager.mRecyclerView);
        throw new IllegalArgumentException(stringBuilder.toString());
      }  
    requestLayout();
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean) {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }
  
  @Deprecated
  public void setOnScrollListener(OnScrollListener paramOnScrollListener) {
    this.mScrollListener = paramOnScrollListener;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean) {
    this.mPreserveFocusAfterLayout = paramBoolean;
  }
  
  public void setRecycledViewPool(RecycledViewPool paramRecycledViewPool) {
    this.mRecycler.setRecycledViewPool(paramRecycledViewPool);
  }
  
  public void setRecyclerListener(RecyclerListener paramRecyclerListener) {
    this.mRecyclerListener = paramRecyclerListener;
  }
  
  public void setScrollingTouchSlop(int paramInt) {
    StringBuilder stringBuilder;
    ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("setScrollingTouchSlop(): bad argument constant ");
        stringBuilder.append(paramInt);
        stringBuilder.append("; using default value");
        Log.w("RecyclerView", stringBuilder.toString());
        break;
      case 1:
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        return;
      case 0:
        break;
    } 
    this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
  }
  
  public void setViewCacheExtension(ViewCacheExtension paramViewCacheExtension) {
    this.mRecycler.setViewCacheExtension(paramViewCacheExtension);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2) {
    if (this.mLayout == null) {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    } 
    if (this.mLayoutFrozen)
      return; 
    if (!this.mLayout.canScrollHorizontally())
      paramInt1 = 0; 
    if (!this.mLayout.canScrollVertically())
      paramInt2 = 0; 
    if (paramInt1 != 0 || paramInt2 != 0)
      this.mViewFlinger.smoothScrollBy(paramInt1, paramInt2); 
  }
  
  public void smoothScrollToPosition(int paramInt) {
    if (this.mLayoutFrozen)
      return; 
    if (this.mLayout == null) {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    } 
    this.mLayout.smoothScrollToPosition(this, this.mState, paramInt);
  }
  
  public boolean startNestedScroll(int paramInt) {
    return getScrollingChildHelper().startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll() {
    getScrollingChildHelper().stopNestedScroll();
  }
  
  public void stopScroll() {
    setScrollState(0);
    stopScrollersInternal();
  }
  
  public void swapAdapter(Adapter paramAdapter, boolean paramBoolean) {
    setLayoutFrozen(false);
    setAdapterInternal(paramAdapter, true, paramBoolean);
    setDataSetChangedAfterLayout();
    requestLayout();
  }
  
  void viewRangeUpdate(int paramInt1, int paramInt2, Object paramObject) {
    int i = this.mChildHelper.getUnfilteredChildCount();
    for (byte b = 0; b < i; b++) {
      View view = this.mChildHelper.getUnfilteredChildAt(b);
      ViewHolder viewHolder = getChildViewHolderInt(view);
      if (viewHolder != null && !viewHolder.shouldIgnore() && viewHolder.mPosition >= paramInt1 && viewHolder.mPosition < paramInt1 + paramInt2) {
        viewHolder.addFlags(2);
        viewHolder.addChangePayload(paramObject);
        ((LayoutParams)view.getLayoutParams()).mInsetsDirty = true;
      } 
    } 
    this.mRecycler.viewRangeUpdate(paramInt1, paramInt2);
  }
  
  static {
    boolean bool;
  }
  
  static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
  
  private static final int[] CLIP_TO_PADDING_ATTR;
  
  private static final boolean DEBUG = false;
  
  static final boolean DISPATCH_TEMP_DETACH = false;
  
  private static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
  
  public static final int HORIZONTAL = 0;
  
  private static final int INVALID_POINTER = -1;
  
  public static final int INVALID_TYPE = -1;
  
  private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
  
  private static final int MAX_SCROLL_DURATION = 2000;
  
  private static final int[] NESTED_SCROLLING_ATTRS = new int[] { 16843830 };
  
  public static final long NO_ID = -1L;
  
  public static final int NO_POSITION = -1;
  
  public static final int SCROLL_STATE_DRAGGING = 1;
  
  public static final int SCROLL_STATE_IDLE = 0;
  
  public static final int SCROLL_STATE_SETTLING = 2;
  
  private static final String TAG = "RecyclerView";
  
  public static final int TOUCH_SLOP_DEFAULT = 0;
  
  public static final int TOUCH_SLOP_PAGING = 1;
  
  private static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
  
  private static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
  
  private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
  
  private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
  
  private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
  
  private static final String TRACE_SCROLL_TAG = "RV Scroll";
  
  public static final int VERTICAL = 1;
  
  private static final Interpolator sQuinticInterpolator;
  
  private OnItemTouchListener mActiveOnItemTouchListener;
  
  private Adapter mAdapter;
  
  AdapterHelper mAdapterHelper;
  
  private boolean mAdapterUpdateDuringMeasure;
  
  private EdgeEffectCompat mBottomGlow;
  
  private ChildDrawingOrderCallback mChildDrawingOrderCallback;
  
  ChildHelper mChildHelper;
  
  private boolean mClipToPadding;
  
  private boolean mDataSetHasChangedAfterLayout;
  
  private int mEatRequestLayout;
  
  private int mEatenAccessibilityChangeFlags;
  
  @VisibleForTesting
  boolean mFirstLayoutComplete;
  
  private boolean mHasFixedSize;
  
  private boolean mIgnoreMotionEventTillDown;
  
  private int mInitialTouchX;
  
  private int mInitialTouchY;
  
  private boolean mIsAttached;
  
  ItemAnimator mItemAnimator;
  
  private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
  
  private Runnable mItemAnimatorRunner;
  
  private final ArrayList<ItemDecoration> mItemDecorations = new ArrayList<ItemDecoration>();
  
  boolean mItemsAddedOrRemoved;
  
  boolean mItemsChanged;
  
  private int mLastTouchX;
  
  private int mLastTouchY;
  
  @VisibleForTesting
  LayoutManager mLayout;
  
  private boolean mLayoutFrozen;
  
  private int mLayoutOrScrollCounter;
  
  private boolean mLayoutRequestEaten;
  
  private EdgeEffectCompat mLeftGlow;
  
  private final int mMaxFlingVelocity;
  
  private final int mMinFlingVelocity;
  
  private final int[] mMinMaxLayoutPositions;
  
  private final int[] mNestedOffsets;
  
  private final RecyclerViewDataObserver mObserver = new RecyclerViewDataObserver();
  
  private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
  
  private final ArrayList<OnItemTouchListener> mOnItemTouchListeners = new ArrayList<OnItemTouchListener>();
  
  private SavedState mPendingSavedState;
  
  private final boolean mPostUpdatesOnAnimation;
  
  private boolean mPostedAnimatorRunner;
  
  private boolean mPreserveFocusAfterLayout;
  
  final Recycler mRecycler = new Recycler();
  
  private RecyclerListener mRecyclerListener;
  
  private EdgeEffectCompat mRightGlow;
  
  private final int[] mScrollConsumed;
  
  private float mScrollFactor;
  
  private OnScrollListener mScrollListener;
  
  private List<OnScrollListener> mScrollListeners;
  
  private final int[] mScrollOffset;
  
  private int mScrollPointerId;
  
  private int mScrollState;
  
  private NestedScrollingChildHelper mScrollingChildHelper;
  
  final State mState;
  
  private final Rect mTempRect = new Rect();
  
  private final Rect mTempRect2 = new Rect();
  
  private final RectF mTempRectF = new RectF();
  
  private EdgeEffectCompat mTopGlow;
  
  private int mTouchSlop;
  
  private final Runnable mUpdateChildViewsRunnable = new Runnable() {
      public void run() {
        if (!RecyclerView.this.mFirstLayoutComplete || RecyclerView.this.isLayoutRequested())
          return; 
        if (!RecyclerView.this.mIsAttached) {
          RecyclerView.this.requestLayout();
          return;
        } 
        if (RecyclerView.this.mLayoutFrozen) {
          RecyclerView.access$302(RecyclerView.this, true);
          return;
        } 
        RecyclerView.this.consumePendingUpdateOperations();
      }
    };
  
  private VelocityTracker mVelocityTracker;
  
  private final ViewFlinger mViewFlinger;
  
  private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
  
  final ViewInfoStore mViewInfoStore = new ViewInfoStore();
  
  public static abstract class Adapter<VH extends ViewHolder> {
    private boolean mHasStableIds = false;
    
    private final RecyclerView.AdapterDataObservable mObservable = new RecyclerView.AdapterDataObservable();
    
    public final void bindViewHolder(VH param1VH, int param1Int) {
      ((RecyclerView.ViewHolder)param1VH).mPosition = param1Int;
      if (hasStableIds())
        ((RecyclerView.ViewHolder)param1VH).mItemId = getItemId(param1Int); 
      param1VH.setFlags(1, 519);
      TraceCompat.beginSection("RV OnBindView");
      onBindViewHolder(param1VH, param1Int, param1VH.getUnmodifiedPayloads());
      param1VH.clearPayload();
      TraceCompat.endSection();
    }
    
    public final VH createViewHolder(ViewGroup param1ViewGroup, int param1Int) {
      TraceCompat.beginSection("RV CreateView");
      param1ViewGroup = (ViewGroup)onCreateViewHolder(param1ViewGroup, param1Int);
      ((RecyclerView.ViewHolder)param1ViewGroup).mItemViewType = param1Int;
      TraceCompat.endSection();
      return (VH)param1ViewGroup;
    }
    
    public abstract int getItemCount();
    
    public long getItemId(int param1Int) {
      return -1L;
    }
    
    public int getItemViewType(int param1Int) {
      return 0;
    }
    
    public final boolean hasObservers() {
      return this.mObservable.hasObservers();
    }
    
    public final boolean hasStableIds() {
      return this.mHasStableIds;
    }
    
    public final void notifyDataSetChanged() {
      this.mObservable.notifyChanged();
    }
    
    public final void notifyItemChanged(int param1Int) {
      this.mObservable.notifyItemRangeChanged(param1Int, 1);
    }
    
    public final void notifyItemChanged(int param1Int, Object param1Object) {
      this.mObservable.notifyItemRangeChanged(param1Int, 1, param1Object);
    }
    
    public final void notifyItemInserted(int param1Int) {
      this.mObservable.notifyItemRangeInserted(param1Int, 1);
    }
    
    public final void notifyItemMoved(int param1Int1, int param1Int2) {
      this.mObservable.notifyItemMoved(param1Int1, param1Int2);
    }
    
    public final void notifyItemRangeChanged(int param1Int1, int param1Int2) {
      this.mObservable.notifyItemRangeChanged(param1Int1, param1Int2);
    }
    
    public final void notifyItemRangeChanged(int param1Int1, int param1Int2, Object param1Object) {
      this.mObservable.notifyItemRangeChanged(param1Int1, param1Int2, param1Object);
    }
    
    public final void notifyItemRangeInserted(int param1Int1, int param1Int2) {
      this.mObservable.notifyItemRangeInserted(param1Int1, param1Int2);
    }
    
    public final void notifyItemRangeRemoved(int param1Int1, int param1Int2) {
      this.mObservable.notifyItemRangeRemoved(param1Int1, param1Int2);
    }
    
    public final void notifyItemRemoved(int param1Int) {
      this.mObservable.notifyItemRangeRemoved(param1Int, 1);
    }
    
    public void onAttachedToRecyclerView(RecyclerView param1RecyclerView) {}
    
    public abstract void onBindViewHolder(VH param1VH, int param1Int);
    
    public void onBindViewHolder(VH param1VH, int param1Int, List<Object> param1List) {
      onBindViewHolder(param1VH, param1Int);
    }
    
    public abstract VH onCreateViewHolder(ViewGroup param1ViewGroup, int param1Int);
    
    public void onDetachedFromRecyclerView(RecyclerView param1RecyclerView) {}
    
    public boolean onFailedToRecycleView(VH param1VH) {
      return false;
    }
    
    public void onViewAttachedToWindow(VH param1VH) {}
    
    public void onViewDetachedFromWindow(VH param1VH) {}
    
    public void onViewRecycled(VH param1VH) {}
    
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver param1AdapterDataObserver) {
      this.mObservable.registerObserver(param1AdapterDataObserver);
    }
    
    public void setHasStableIds(boolean param1Boolean) {
      if (!hasObservers()) {
        this.mHasStableIds = param1Boolean;
        return;
      } 
      throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
    }
    
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver param1AdapterDataObserver) {
      this.mObservable.unregisterObserver(param1AdapterDataObserver);
    }
  }
  
  static class AdapterDataObservable extends Observable<AdapterDataObserver> {
    public boolean hasObservers() {
      return this.mObservers.isEmpty() ^ true;
    }
    
    public void notifyChanged() {
      for (int i = this.mObservers.size() - 1; i >= 0; i--)
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onChanged(); 
    }
    
    public void notifyItemMoved(int param1Int1, int param1Int2) {
      for (int i = this.mObservers.size() - 1; i >= 0; i--)
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeMoved(param1Int1, param1Int2, 1); 
    }
    
    public void notifyItemRangeChanged(int param1Int1, int param1Int2) {
      notifyItemRangeChanged(param1Int1, param1Int2, (Object)null);
    }
    
    public void notifyItemRangeChanged(int param1Int1, int param1Int2, Object param1Object) {
      for (int i = this.mObservers.size() - 1; i >= 0; i--)
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeChanged(param1Int1, param1Int2, param1Object); 
    }
    
    public void notifyItemRangeInserted(int param1Int1, int param1Int2) {
      for (int i = this.mObservers.size() - 1; i >= 0; i--)
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeInserted(param1Int1, param1Int2); 
    }
    
    public void notifyItemRangeRemoved(int param1Int1, int param1Int2) {
      for (int i = this.mObservers.size() - 1; i >= 0; i--)
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeRemoved(param1Int1, param1Int2); 
    }
  }
  
  public static abstract class AdapterDataObserver {
    public void onChanged() {}
    
    public void onItemRangeChanged(int param1Int1, int param1Int2) {}
    
    public void onItemRangeChanged(int param1Int1, int param1Int2, Object param1Object) {
      onItemRangeChanged(param1Int1, param1Int2);
    }
    
    public void onItemRangeInserted(int param1Int1, int param1Int2) {}
    
    public void onItemRangeMoved(int param1Int1, int param1Int2, int param1Int3) {}
    
    public void onItemRangeRemoved(int param1Int1, int param1Int2) {}
  }
  
  public static interface ChildDrawingOrderCallback {
    int onGetChildDrawingOrder(int param1Int1, int param1Int2);
  }
  
  public static abstract class ItemAnimator {
    public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    
    public static final int FLAG_CHANGED = 2;
    
    public static final int FLAG_INVALIDATED = 4;
    
    public static final int FLAG_MOVED = 2048;
    
    public static final int FLAG_REMOVED = 8;
    
    private long mAddDuration = 120L;
    
    private long mChangeDuration = 250L;
    
    private ArrayList<ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList<ItemAnimatorFinishedListener>();
    
    private ItemAnimatorListener mListener = null;
    
    private long mMoveDuration = 250L;
    
    private long mRemoveDuration = 120L;
    
    static int buildAdapterChangeFlagsForAnimations(RecyclerView.ViewHolder param1ViewHolder) {
      int i = param1ViewHolder.mFlags & 0xE;
      if (param1ViewHolder.isInvalid())
        return 4; 
      int j = i;
      if ((i & 0x4) == 0) {
        int k = param1ViewHolder.getOldPosition();
        int m = param1ViewHolder.getAdapterPosition();
        j = i;
        if (k != -1) {
          j = i;
          if (m != -1) {
            j = i;
            if (k != m)
              j = i | 0x800; 
          } 
        } 
      } 
      return j;
    }
    
    public abstract boolean animateAppearance(@NonNull RecyclerView.ViewHolder param1ViewHolder, @Nullable ItemHolderInfo param1ItemHolderInfo1, @NonNull ItemHolderInfo param1ItemHolderInfo2);
    
    public abstract boolean animateChange(@NonNull RecyclerView.ViewHolder param1ViewHolder1, @NonNull RecyclerView.ViewHolder param1ViewHolder2, @NonNull ItemHolderInfo param1ItemHolderInfo1, @NonNull ItemHolderInfo param1ItemHolderInfo2);
    
    public abstract boolean animateDisappearance(@NonNull RecyclerView.ViewHolder param1ViewHolder, @NonNull ItemHolderInfo param1ItemHolderInfo1, @Nullable ItemHolderInfo param1ItemHolderInfo2);
    
    public abstract boolean animatePersistence(@NonNull RecyclerView.ViewHolder param1ViewHolder, @NonNull ItemHolderInfo param1ItemHolderInfo1, @NonNull ItemHolderInfo param1ItemHolderInfo2);
    
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder param1ViewHolder) {
      return true;
    }
    
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder param1ViewHolder, @NonNull List<Object> param1List) {
      return canReuseUpdatedViewHolder(param1ViewHolder);
    }
    
    public final void dispatchAnimationFinished(RecyclerView.ViewHolder param1ViewHolder) {
      onAnimationFinished(param1ViewHolder);
      if (this.mListener != null)
        this.mListener.onAnimationFinished(param1ViewHolder); 
    }
    
    public final void dispatchAnimationStarted(RecyclerView.ViewHolder param1ViewHolder) {
      onAnimationStarted(param1ViewHolder);
    }
    
    public final void dispatchAnimationsFinished() {
      int i = this.mFinishedListeners.size();
      for (byte b = 0; b < i; b++)
        ((ItemAnimatorFinishedListener)this.mFinishedListeners.get(b)).onAnimationsFinished(); 
      this.mFinishedListeners.clear();
    }
    
    public abstract void endAnimation(RecyclerView.ViewHolder param1ViewHolder);
    
    public abstract void endAnimations();
    
    public long getAddDuration() {
      return this.mAddDuration;
    }
    
    public long getChangeDuration() {
      return this.mChangeDuration;
    }
    
    public long getMoveDuration() {
      return this.mMoveDuration;
    }
    
    public long getRemoveDuration() {
      return this.mRemoveDuration;
    }
    
    public abstract boolean isRunning();
    
    public final boolean isRunning(ItemAnimatorFinishedListener param1ItemAnimatorFinishedListener) {
      boolean bool = isRunning();
      if (param1ItemAnimatorFinishedListener != null)
        if (!bool) {
          param1ItemAnimatorFinishedListener.onAnimationsFinished();
        } else {
          this.mFinishedListeners.add(param1ItemAnimatorFinishedListener);
        }  
      return bool;
    }
    
    public ItemHolderInfo obtainHolderInfo() {
      return new ItemHolderInfo();
    }
    
    public void onAnimationFinished(RecyclerView.ViewHolder param1ViewHolder) {}
    
    public void onAnimationStarted(RecyclerView.ViewHolder param1ViewHolder) {}
    
    @NonNull
    public ItemHolderInfo recordPostLayoutInformation(@NonNull RecyclerView.State param1State, @NonNull RecyclerView.ViewHolder param1ViewHolder) {
      return obtainHolderInfo().setFrom(param1ViewHolder);
    }
    
    @NonNull
    public ItemHolderInfo recordPreLayoutInformation(@NonNull RecyclerView.State param1State, @NonNull RecyclerView.ViewHolder param1ViewHolder, int param1Int, @NonNull List<Object> param1List) {
      return obtainHolderInfo().setFrom(param1ViewHolder);
    }
    
    public abstract void runPendingAnimations();
    
    public void setAddDuration(long param1Long) {
      this.mAddDuration = param1Long;
    }
    
    public void setChangeDuration(long param1Long) {
      this.mChangeDuration = param1Long;
    }
    
    void setListener(ItemAnimatorListener param1ItemAnimatorListener) {
      this.mListener = param1ItemAnimatorListener;
    }
    
    public void setMoveDuration(long param1Long) {
      this.mMoveDuration = param1Long;
    }
    
    public void setRemoveDuration(long param1Long) {
      this.mRemoveDuration = param1Long;
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface AdapterChanges {}
    
    public static interface ItemAnimatorFinishedListener {
      void onAnimationsFinished();
    }
    
    static interface ItemAnimatorListener {
      void onAnimationFinished(RecyclerView.ViewHolder param2ViewHolder);
    }
    
    public static class ItemHolderInfo {
      public int bottom;
      
      public int changeFlags;
      
      public int left;
      
      public int right;
      
      public int top;
      
      public ItemHolderInfo setFrom(RecyclerView.ViewHolder param2ViewHolder) {
        return setFrom(param2ViewHolder, 0);
      }
      
      public ItemHolderInfo setFrom(RecyclerView.ViewHolder param2ViewHolder, int param2Int) {
        View view = param2ViewHolder.itemView;
        this.left = view.getLeft();
        this.top = view.getTop();
        this.right = view.getRight();
        this.bottom = view.getBottom();
        return this;
      }
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AdapterChanges {}
  
  public static interface ItemAnimatorFinishedListener {
    void onAnimationsFinished();
  }
  
  static interface ItemAnimatorListener {
    void onAnimationFinished(RecyclerView.ViewHolder param1ViewHolder);
  }
  
  public static class ItemHolderInfo {
    public int bottom;
    
    public int changeFlags;
    
    public int left;
    
    public int right;
    
    public int top;
    
    public ItemHolderInfo setFrom(RecyclerView.ViewHolder param1ViewHolder) {
      return setFrom(param1ViewHolder, 0);
    }
    
    public ItemHolderInfo setFrom(RecyclerView.ViewHolder param1ViewHolder, int param1Int) {
      View view = param1ViewHolder.itemView;
      this.left = view.getLeft();
      this.top = view.getTop();
      this.right = view.getRight();
      this.bottom = view.getBottom();
      return this;
    }
  }
  
  private class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
    private ItemAnimatorRestoreListener() {}
    
    public void onAnimationFinished(RecyclerView.ViewHolder param1ViewHolder) {
      param1ViewHolder.setIsRecyclable(true);
      if (param1ViewHolder.mShadowedHolder != null && param1ViewHolder.mShadowingHolder == null)
        param1ViewHolder.mShadowedHolder = null; 
      param1ViewHolder.mShadowingHolder = null;
      if (!param1ViewHolder.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(param1ViewHolder.itemView) && param1ViewHolder.isTmpDetached())
        RecyclerView.this.removeDetachedView(param1ViewHolder.itemView, false); 
    }
  }
  
  public static abstract class ItemDecoration {
    @Deprecated
    public void getItemOffsets(Rect param1Rect, int param1Int, RecyclerView param1RecyclerView) {
      param1Rect.set(0, 0, 0, 0);
    }
    
    public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
      getItemOffsets(param1Rect, ((RecyclerView.LayoutParams)param1View.getLayoutParams()).getViewLayoutPosition(), param1RecyclerView);
    }
    
    @Deprecated
    public void onDraw(Canvas param1Canvas, RecyclerView param1RecyclerView) {}
    
    public void onDraw(Canvas param1Canvas, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
      onDraw(param1Canvas, param1RecyclerView);
    }
    
    @Deprecated
    public void onDrawOver(Canvas param1Canvas, RecyclerView param1RecyclerView) {}
    
    public void onDrawOver(Canvas param1Canvas, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
      onDrawOver(param1Canvas, param1RecyclerView);
    }
  }
  
  public static abstract class LayoutManager {
    private boolean mAutoMeasure = false;
    
    ChildHelper mChildHelper;
    
    private int mHeight;
    
    private int mHeightMode;
    
    boolean mIsAttachedToWindow = false;
    
    private boolean mMeasurementCacheEnabled = true;
    
    RecyclerView mRecyclerView;
    
    private boolean mRequestedSimpleAnimations = false;
    
    @Nullable
    RecyclerView.SmoothScroller mSmoothScroller;
    
    private int mWidth;
    
    private int mWidthMode;
    
    private void addViewInt(View param1View, int param1Int, boolean param1Boolean) {
      StringBuilder stringBuilder;
      RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(param1View);
      if (param1Boolean || viewHolder.isRemoved()) {
        this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(viewHolder);
      } else {
        this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(viewHolder);
      } 
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
      if (viewHolder.wasReturnedFromScrap() || viewHolder.isScrap()) {
        if (viewHolder.isScrap()) {
          viewHolder.unScrap();
        } else {
          viewHolder.clearReturnedFromScrapFlag();
        } 
        this.mChildHelper.attachViewToParent(param1View, param1Int, param1View.getLayoutParams(), false);
      } else if (param1View.getParent() == this.mRecyclerView) {
        int i = this.mChildHelper.indexOfChild(param1View);
        int j = param1Int;
        if (param1Int == -1)
          j = this.mChildHelper.getChildCount(); 
        if (i != -1) {
          if (i != j)
            this.mRecyclerView.mLayout.moveView(i, j); 
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
          stringBuilder.append(this.mRecyclerView.indexOfChild(param1View));
          throw new IllegalStateException(stringBuilder.toString());
        } 
      } else {
        this.mChildHelper.addView(param1View, param1Int, false);
        ((RecyclerView.LayoutParams)stringBuilder).mInsetsDirty = true;
        if (this.mSmoothScroller != null && this.mSmoothScroller.isRunning())
          this.mSmoothScroller.onChildAttachedToWindow(param1View); 
      } 
      if (((RecyclerView.LayoutParams)stringBuilder).mPendingInvalidate) {
        viewHolder.itemView.invalidate();
        ((RecyclerView.LayoutParams)stringBuilder).mPendingInvalidate = false;
      } 
    }
    
    public static int chooseSize(int param1Int1, int param1Int2, int param1Int3) {
      int i = View.MeasureSpec.getMode(param1Int1);
      param1Int1 = View.MeasureSpec.getSize(param1Int1);
      return (i != Integer.MIN_VALUE) ? ((i != 1073741824) ? Math.max(param1Int2, param1Int3) : param1Int1) : Math.min(param1Int1, Math.max(param1Int2, param1Int3));
    }
    
    private void detachViewInternal(int param1Int, View param1View) {
      this.mChildHelper.detachViewFromParent(param1Int);
    }
    
    public static int getChildMeasureSpec(int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean) {
      // Byte code:
      //   0: iconst_0
      //   1: istore #5
      //   3: iconst_0
      //   4: iload_0
      //   5: iload_2
      //   6: isub
      //   7: invokestatic max : (II)I
      //   10: istore #6
      //   12: iload #4
      //   14: ifeq -> 67
      //   17: iload_3
      //   18: iflt -> 29
      //   21: iload_3
      //   22: istore_2
      //   23: ldc 1073741824
      //   25: istore_0
      //   26: goto -> 125
      //   29: iload_3
      //   30: iconst_m1
      //   31: if_icmpne -> 120
      //   34: iload_1
      //   35: ldc -2147483648
      //   37: if_icmpeq -> 57
      //   40: iload_1
      //   41: ifeq -> 50
      //   44: iload_1
      //   45: ldc 1073741824
      //   47: if_icmpeq -> 57
      //   50: iconst_0
      //   51: istore_1
      //   52: iconst_0
      //   53: istore_0
      //   54: goto -> 60
      //   57: iload #6
      //   59: istore_0
      //   60: iload_0
      //   61: istore_2
      //   62: iload_1
      //   63: istore_0
      //   64: goto -> 125
      //   67: iload_3
      //   68: iflt -> 74
      //   71: goto -> 21
      //   74: iload_3
      //   75: iconst_m1
      //   76: if_icmpne -> 87
      //   79: iload_1
      //   80: istore_0
      //   81: iload #6
      //   83: istore_2
      //   84: goto -> 125
      //   87: iload_3
      //   88: bipush #-2
      //   90: if_icmpne -> 120
      //   93: iload_1
      //   94: ldc -2147483648
      //   96: if_icmpeq -> 111
      //   99: iload #6
      //   101: istore_2
      //   102: iload #5
      //   104: istore_0
      //   105: iload_1
      //   106: ldc 1073741824
      //   108: if_icmpne -> 125
      //   111: ldc -2147483648
      //   113: istore_0
      //   114: iload #6
      //   116: istore_2
      //   117: goto -> 125
      //   120: iconst_0
      //   121: istore_2
      //   122: iload #5
      //   124: istore_0
      //   125: iload_2
      //   126: iload_0
      //   127: invokestatic makeMeasureSpec : (II)I
      //   130: ireturn
    }
    
    @Deprecated
    public static int getChildMeasureSpec(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean) {
      // Byte code:
      //   0: iconst_0
      //   1: istore #4
      //   3: iconst_0
      //   4: iload_0
      //   5: iload_1
      //   6: isub
      //   7: invokestatic max : (II)I
      //   10: istore_0
      //   11: iload_3
      //   12: ifeq -> 35
      //   15: iload_2
      //   16: iflt -> 27
      //   19: iload_2
      //   20: istore_0
      //   21: ldc 1073741824
      //   23: istore_1
      //   24: goto -> 59
      //   27: iconst_0
      //   28: istore_0
      //   29: iload #4
      //   31: istore_1
      //   32: goto -> 59
      //   35: iload_2
      //   36: iflt -> 42
      //   39: goto -> 19
      //   42: iload_2
      //   43: iconst_m1
      //   44: if_icmpne -> 50
      //   47: goto -> 21
      //   50: iload_2
      //   51: bipush #-2
      //   53: if_icmpne -> 27
      //   56: ldc -2147483648
      //   58: istore_1
      //   59: iload_0
      //   60: iload_1
      //   61: invokestatic makeMeasureSpec : (II)I
      //   64: ireturn
    }
    
    private static boolean isMeasurementUpToDate(int param1Int1, int param1Int2, int param1Int3) {
      int i = View.MeasureSpec.getMode(param1Int2);
      param1Int2 = View.MeasureSpec.getSize(param1Int2);
      boolean bool1 = false;
      boolean bool2 = false;
      if (param1Int3 > 0 && param1Int1 != param1Int3)
        return false; 
      if (i != Integer.MIN_VALUE) {
        if (i != 0) {
          if (i != 1073741824)
            return false; 
          if (param1Int2 == param1Int1)
            bool2 = true; 
          return bool2;
        } 
        return true;
      } 
      bool2 = bool1;
      if (param1Int2 >= param1Int1)
        bool2 = true; 
      return bool2;
    }
    
    private void onSmoothScrollerStopped(RecyclerView.SmoothScroller param1SmoothScroller) {
      if (this.mSmoothScroller == param1SmoothScroller)
        this.mSmoothScroller = null; 
    }
    
    private void scrapOrRecycleView(RecyclerView.Recycler param1Recycler, int param1Int, View param1View) {
      RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(param1View);
      if (viewHolder.shouldIgnore())
        return; 
      if (viewHolder.isInvalid() && !viewHolder.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
        removeViewAt(param1Int);
        param1Recycler.recycleViewHolderInternal(viewHolder);
      } else {
        detachViewAt(param1Int);
        param1Recycler.scrapView(param1View);
        this.mRecyclerView.mViewInfoStore.onViewDetached(viewHolder);
      } 
    }
    
    public void addDisappearingView(View param1View) {
      addDisappearingView(param1View, -1);
    }
    
    public void addDisappearingView(View param1View, int param1Int) {
      addViewInt(param1View, param1Int, true);
    }
    
    public void addView(View param1View) {
      addView(param1View, -1);
    }
    
    public void addView(View param1View, int param1Int) {
      addViewInt(param1View, param1Int, false);
    }
    
    public void assertInLayoutOrScroll(String param1String) {
      if (this.mRecyclerView != null)
        this.mRecyclerView.assertInLayoutOrScroll(param1String); 
    }
    
    public void assertNotInLayoutOrScroll(String param1String) {
      if (this.mRecyclerView != null)
        this.mRecyclerView.assertNotInLayoutOrScroll(param1String); 
    }
    
    public void attachView(View param1View) {
      attachView(param1View, -1);
    }
    
    public void attachView(View param1View, int param1Int) {
      attachView(param1View, param1Int, (RecyclerView.LayoutParams)param1View.getLayoutParams());
    }
    
    public void attachView(View param1View, int param1Int, RecyclerView.LayoutParams param1LayoutParams) {
      RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(param1View);
      if (viewHolder.isRemoved()) {
        this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(viewHolder);
      } else {
        this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(viewHolder);
      } 
      this.mChildHelper.attachViewToParent(param1View, param1Int, (ViewGroup.LayoutParams)param1LayoutParams, viewHolder.isRemoved());
    }
    
    public void calculateItemDecorationsForChild(View param1View, Rect param1Rect) {
      if (this.mRecyclerView == null) {
        param1Rect.set(0, 0, 0, 0);
        return;
      } 
      param1Rect.set(this.mRecyclerView.getItemDecorInsetsForChild(param1View));
    }
    
    public boolean canScrollHorizontally() {
      return false;
    }
    
    public boolean canScrollVertically() {
      return false;
    }
    
    public boolean checkLayoutParams(RecyclerView.LayoutParams param1LayoutParams) {
      boolean bool;
      if (param1LayoutParams != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int computeHorizontalScrollExtent(RecyclerView.State param1State) {
      return 0;
    }
    
    public int computeHorizontalScrollOffset(RecyclerView.State param1State) {
      return 0;
    }
    
    public int computeHorizontalScrollRange(RecyclerView.State param1State) {
      return 0;
    }
    
    public int computeVerticalScrollExtent(RecyclerView.State param1State) {
      return 0;
    }
    
    public int computeVerticalScrollOffset(RecyclerView.State param1State) {
      return 0;
    }
    
    public int computeVerticalScrollRange(RecyclerView.State param1State) {
      return 0;
    }
    
    public void detachAndScrapAttachedViews(RecyclerView.Recycler param1Recycler) {
      for (int i = getChildCount() - 1; i >= 0; i--)
        scrapOrRecycleView(param1Recycler, i, getChildAt(i)); 
    }
    
    public void detachAndScrapView(View param1View, RecyclerView.Recycler param1Recycler) {
      scrapOrRecycleView(param1Recycler, this.mChildHelper.indexOfChild(param1View), param1View);
    }
    
    public void detachAndScrapViewAt(int param1Int, RecyclerView.Recycler param1Recycler) {
      scrapOrRecycleView(param1Recycler, param1Int, getChildAt(param1Int));
    }
    
    public void detachView(View param1View) {
      int i = this.mChildHelper.indexOfChild(param1View);
      if (i >= 0)
        detachViewInternal(i, param1View); 
    }
    
    public void detachViewAt(int param1Int) {
      detachViewInternal(param1Int, getChildAt(param1Int));
    }
    
    void dispatchAttachedToWindow(RecyclerView param1RecyclerView) {
      this.mIsAttachedToWindow = true;
      onAttachedToWindow(param1RecyclerView);
    }
    
    void dispatchDetachedFromWindow(RecyclerView param1RecyclerView, RecyclerView.Recycler param1Recycler) {
      this.mIsAttachedToWindow = false;
      onDetachedFromWindow(param1RecyclerView, param1Recycler);
    }
    
    public void endAnimation(View param1View) {
      if (this.mRecyclerView.mItemAnimator != null)
        this.mRecyclerView.mItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(param1View)); 
    }
    
    @Nullable
    public View findContainingItemView(View param1View) {
      if (this.mRecyclerView == null)
        return null; 
      param1View = this.mRecyclerView.findContainingItemView(param1View);
      return (param1View == null) ? null : (this.mChildHelper.isHidden(param1View) ? null : param1View);
    }
    
    public View findViewByPosition(int param1Int) {
      int i = getChildCount();
      for (byte b = 0; b < i; b++) {
        View view = getChildAt(b);
        RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(view);
        if (viewHolder != null && viewHolder.getLayoutPosition() == param1Int && !viewHolder.shouldIgnore() && (this.mRecyclerView.mState.isPreLayout() || !viewHolder.isRemoved()))
          return view; 
      } 
      return null;
    }
    
    public abstract RecyclerView.LayoutParams generateDefaultLayoutParams();
    
    public RecyclerView.LayoutParams generateLayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      return new RecyclerView.LayoutParams(param1Context, param1AttributeSet);
    }
    
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      return (param1LayoutParams instanceof RecyclerView.LayoutParams) ? new RecyclerView.LayoutParams((RecyclerView.LayoutParams)param1LayoutParams) : ((param1LayoutParams instanceof ViewGroup.MarginLayoutParams) ? new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)param1LayoutParams) : new RecyclerView.LayoutParams(param1LayoutParams));
    }
    
    public int getBaseline() {
      return -1;
    }
    
    public int getBottomDecorationHeight(View param1View) {
      return ((RecyclerView.LayoutParams)param1View.getLayoutParams()).mDecorInsets.bottom;
    }
    
    public View getChildAt(int param1Int) {
      View view;
      if (this.mChildHelper != null) {
        view = this.mChildHelper.getChildAt(param1Int);
      } else {
        view = null;
      } 
      return view;
    }
    
    public int getChildCount() {
      boolean bool;
      if (this.mChildHelper != null) {
        bool = this.mChildHelper.getChildCount();
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean getClipToPadding() {
      boolean bool;
      if (this.mRecyclerView != null && this.mRecyclerView.mClipToPadding) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int getColumnCountForAccessibility(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State) {
      RecyclerView recyclerView = this.mRecyclerView;
      int i = 1;
      if (recyclerView == null || this.mRecyclerView.mAdapter == null)
        return 1; 
      if (canScrollHorizontally())
        i = this.mRecyclerView.mAdapter.getItemCount(); 
      return i;
    }
    
    public int getDecoratedBottom(View param1View) {
      return param1View.getBottom() + getBottomDecorationHeight(param1View);
    }
    
    public void getDecoratedBoundsWithMargins(View param1View, Rect param1Rect) {
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
      Rect rect = layoutParams.mDecorInsets;
      param1Rect.set(param1View.getLeft() - rect.left - layoutParams.leftMargin, param1View.getTop() - rect.top - layoutParams.topMargin, param1View.getRight() + rect.right + layoutParams.rightMargin, param1View.getBottom() + rect.bottom + layoutParams.bottomMargin);
    }
    
    public int getDecoratedLeft(View param1View) {
      return param1View.getLeft() - getLeftDecorationWidth(param1View);
    }
    
    public int getDecoratedMeasuredHeight(View param1View) {
      Rect rect = ((RecyclerView.LayoutParams)param1View.getLayoutParams()).mDecorInsets;
      return param1View.getMeasuredHeight() + rect.top + rect.bottom;
    }
    
    public int getDecoratedMeasuredWidth(View param1View) {
      Rect rect = ((RecyclerView.LayoutParams)param1View.getLayoutParams()).mDecorInsets;
      return param1View.getMeasuredWidth() + rect.left + rect.right;
    }
    
    public int getDecoratedRight(View param1View) {
      return param1View.getRight() + getRightDecorationWidth(param1View);
    }
    
    public int getDecoratedTop(View param1View) {
      return param1View.getTop() - getTopDecorationHeight(param1View);
    }
    
    public View getFocusedChild() {
      if (this.mRecyclerView == null)
        return null; 
      View view = this.mRecyclerView.getFocusedChild();
      return (view == null || this.mChildHelper.isHidden(view)) ? null : view;
    }
    
    public int getHeight() {
      return this.mHeight;
    }
    
    public int getHeightMode() {
      return this.mHeightMode;
    }
    
    public int getItemCount() {
      RecyclerView.Adapter adapter;
      boolean bool;
      if (this.mRecyclerView != null) {
        adapter = this.mRecyclerView.getAdapter();
      } else {
        adapter = null;
      } 
      if (adapter != null) {
        bool = adapter.getItemCount();
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int getItemViewType(View param1View) {
      return RecyclerView.getChildViewHolderInt(param1View).getItemViewType();
    }
    
    public int getLayoutDirection() {
      return ViewCompat.getLayoutDirection((View)this.mRecyclerView);
    }
    
    public int getLeftDecorationWidth(View param1View) {
      return ((RecyclerView.LayoutParams)param1View.getLayoutParams()).mDecorInsets.left;
    }
    
    public int getMinimumHeight() {
      return ViewCompat.getMinimumHeight((View)this.mRecyclerView);
    }
    
    public int getMinimumWidth() {
      return ViewCompat.getMinimumWidth((View)this.mRecyclerView);
    }
    
    public int getPaddingBottom() {
      boolean bool;
      if (this.mRecyclerView != null) {
        bool = this.mRecyclerView.getPaddingBottom();
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int getPaddingEnd() {
      boolean bool;
      if (this.mRecyclerView != null) {
        bool = ViewCompat.getPaddingEnd((View)this.mRecyclerView);
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int getPaddingLeft() {
      boolean bool;
      if (this.mRecyclerView != null) {
        bool = this.mRecyclerView.getPaddingLeft();
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int getPaddingRight() {
      boolean bool;
      if (this.mRecyclerView != null) {
        bool = this.mRecyclerView.getPaddingRight();
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int getPaddingStart() {
      boolean bool;
      if (this.mRecyclerView != null) {
        bool = ViewCompat.getPaddingStart((View)this.mRecyclerView);
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int getPaddingTop() {
      boolean bool;
      if (this.mRecyclerView != null) {
        bool = this.mRecyclerView.getPaddingTop();
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public int getPosition(View param1View) {
      return ((RecyclerView.LayoutParams)param1View.getLayoutParams()).getViewLayoutPosition();
    }
    
    public int getRightDecorationWidth(View param1View) {
      return ((RecyclerView.LayoutParams)param1View.getLayoutParams()).mDecorInsets.right;
    }
    
    public int getRowCountForAccessibility(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State) {
      RecyclerView recyclerView = this.mRecyclerView;
      int i = 1;
      if (recyclerView == null || this.mRecyclerView.mAdapter == null)
        return 1; 
      if (canScrollVertically())
        i = this.mRecyclerView.mAdapter.getItemCount(); 
      return i;
    }
    
    public int getTopDecorationHeight(View param1View) {
      return ((RecyclerView.LayoutParams)param1View.getLayoutParams()).mDecorInsets.top;
    }
    
    public void getTransformedBoundingBox(View param1View, boolean param1Boolean, Rect param1Rect) {
      if (param1Boolean) {
        Rect rect = ((RecyclerView.LayoutParams)param1View.getLayoutParams()).mDecorInsets;
        param1Rect.set(-rect.left, -rect.top, param1View.getWidth() + rect.right, param1View.getHeight() + rect.bottom);
      } else {
        param1Rect.set(0, 0, param1View.getWidth(), param1View.getHeight());
      } 
      if (this.mRecyclerView != null) {
        Matrix matrix = param1View.getMatrix();
        if (matrix != null && !matrix.isIdentity()) {
          RectF rectF = this.mRecyclerView.mTempRectF;
          rectF.set(param1Rect);
          matrix.mapRect(rectF);
          param1Rect.set((int)Math.floor(rectF.left), (int)Math.floor(rectF.top), (int)Math.ceil(rectF.right), (int)Math.ceil(rectF.bottom));
        } 
      } 
      param1Rect.offset(param1View.getLeft(), param1View.getTop());
    }
    
    public int getWidth() {
      return this.mWidth;
    }
    
    public int getWidthMode() {
      return this.mWidthMode;
    }
    
    boolean hasFlexibleChildInBothOrientations() {
      int i = getChildCount();
      for (byte b = 0; b < i; b++) {
        ViewGroup.LayoutParams layoutParams = getChildAt(b).getLayoutParams();
        if (layoutParams.width < 0 && layoutParams.height < 0)
          return true; 
      } 
      return false;
    }
    
    public boolean hasFocus() {
      boolean bool;
      if (this.mRecyclerView != null && this.mRecyclerView.hasFocus()) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void ignoreView(View param1View) {
      if (param1View.getParent() == this.mRecyclerView && this.mRecyclerView.indexOfChild(param1View) != -1) {
        RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(param1View);
        viewHolder.addFlags(128);
        this.mRecyclerView.mViewInfoStore.removeViewHolder(viewHolder);
        return;
      } 
      throw new IllegalArgumentException("View should be fully attached to be ignored");
    }
    
    public boolean isAttachedToWindow() {
      return this.mIsAttachedToWindow;
    }
    
    public boolean isAutoMeasureEnabled() {
      return this.mAutoMeasure;
    }
    
    public boolean isFocused() {
      boolean bool;
      if (this.mRecyclerView != null && this.mRecyclerView.isFocused()) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean isLayoutHierarchical(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State) {
      return false;
    }
    
    public boolean isMeasurementCacheEnabled() {
      return this.mMeasurementCacheEnabled;
    }
    
    public boolean isSmoothScrolling() {
      boolean bool;
      if (this.mSmoothScroller != null && this.mSmoothScroller.isRunning()) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void layoutDecorated(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      Rect rect = ((RecyclerView.LayoutParams)param1View.getLayoutParams()).mDecorInsets;
      param1View.layout(param1Int1 + rect.left, param1Int2 + rect.top, param1Int3 - rect.right, param1Int4 - rect.bottom);
    }
    
    public void layoutDecoratedWithMargins(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
      Rect rect = layoutParams.mDecorInsets;
      param1View.layout(param1Int1 + rect.left + layoutParams.leftMargin, param1Int2 + rect.top + layoutParams.topMargin, param1Int3 - rect.right - layoutParams.rightMargin, param1Int4 - rect.bottom - layoutParams.bottomMargin);
    }
    
    public void measureChild(View param1View, int param1Int1, int param1Int2) {
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
      Rect rect = this.mRecyclerView.getItemDecorInsetsForChild(param1View);
      int i = rect.left;
      int j = rect.right;
      int k = rect.top;
      int m = rect.bottom;
      param1Int1 = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + param1Int1 + i + j, layoutParams.width, canScrollHorizontally());
      param1Int2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + param1Int2 + k + m, layoutParams.height, canScrollVertically());
      if (shouldMeasureChild(param1View, param1Int1, param1Int2, layoutParams))
        param1View.measure(param1Int1, param1Int2); 
    }
    
    public void measureChildWithMargins(View param1View, int param1Int1, int param1Int2) {
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
      Rect rect = this.mRecyclerView.getItemDecorInsetsForChild(param1View);
      int i = rect.left;
      int j = rect.right;
      int k = rect.top;
      int m = rect.bottom;
      param1Int1 = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin + param1Int1 + i + j, layoutParams.width, canScrollHorizontally());
      param1Int2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + param1Int2 + k + m, layoutParams.height, canScrollVertically());
      if (shouldMeasureChild(param1View, param1Int1, param1Int2, layoutParams))
        param1View.measure(param1Int1, param1Int2); 
    }
    
    public void moveView(int param1Int1, int param1Int2) {
      View view = getChildAt(param1Int1);
      if (view != null) {
        detachViewAt(param1Int1);
        attachView(view, param1Int2);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot move a child from non-existing index:");
      stringBuilder.append(param1Int1);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public void offsetChildrenHorizontal(int param1Int) {
      if (this.mRecyclerView != null)
        this.mRecyclerView.offsetChildrenHorizontal(param1Int); 
    }
    
    public void offsetChildrenVertical(int param1Int) {
      if (this.mRecyclerView != null)
        this.mRecyclerView.offsetChildrenVertical(param1Int); 
    }
    
    public void onAdapterChanged(RecyclerView.Adapter param1Adapter1, RecyclerView.Adapter param1Adapter2) {}
    
    public boolean onAddFocusables(RecyclerView param1RecyclerView, ArrayList<View> param1ArrayList, int param1Int1, int param1Int2) {
      return false;
    }
    
    @CallSuper
    public void onAttachedToWindow(RecyclerView param1RecyclerView) {}
    
    @Deprecated
    public void onDetachedFromWindow(RecyclerView param1RecyclerView) {}
    
    @CallSuper
    public void onDetachedFromWindow(RecyclerView param1RecyclerView, RecyclerView.Recycler param1Recycler) {
      onDetachedFromWindow(param1RecyclerView);
    }
    
    @Nullable
    public View onFocusSearchFailed(View param1View, int param1Int, RecyclerView.Recycler param1Recycler, RecyclerView.State param1State) {
      return null;
    }
    
    public View onInterceptFocusSearch(View param1View, int param1Int) {
      return null;
    }
    
    public void onItemsAdded(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {}
    
    public void onItemsChanged(RecyclerView param1RecyclerView) {}
    
    public void onItemsMoved(RecyclerView param1RecyclerView, int param1Int1, int param1Int2, int param1Int3) {}
    
    public void onItemsRemoved(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {}
    
    public void onItemsUpdated(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {}
    
    public void onItemsUpdated(RecyclerView param1RecyclerView, int param1Int1, int param1Int2, Object param1Object) {
      onItemsUpdated(param1RecyclerView, param1Int1, param1Int2);
    }
    
    public void onLayoutChildren(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State) {
      Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }
    
    public void onLayoutCompleted(RecyclerView.State param1State) {}
    
    public void onMeasure(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State, int param1Int1, int param1Int2) {
      this.mRecyclerView.defaultOnMeasure(param1Int1, param1Int2);
    }
    
    @Deprecated
    public boolean onRequestChildFocus(RecyclerView param1RecyclerView, View param1View1, View param1View2) {
      return (isSmoothScrolling() || param1RecyclerView.isComputingLayout());
    }
    
    public boolean onRequestChildFocus(RecyclerView param1RecyclerView, RecyclerView.State param1State, View param1View1, View param1View2) {
      return onRequestChildFocus(param1RecyclerView, param1View1, param1View2);
    }
    
    public void onRestoreInstanceState(Parcelable param1Parcelable) {}
    
    public Parcelable onSaveInstanceState() {
      return null;
    }
    
    public void onScrollStateChanged(int param1Int) {}
    
    public boolean performAccessibilityActionForItem(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State, View param1View, int param1Int, Bundle param1Bundle) {
      return false;
    }
    
    public void postOnAnimation(Runnable param1Runnable) {
      if (this.mRecyclerView != null)
        ViewCompat.postOnAnimation((View)this.mRecyclerView, param1Runnable); 
    }
    
    public void removeAllViews() {
      for (int i = getChildCount() - 1; i >= 0; i--)
        this.mChildHelper.removeViewAt(i); 
    }
    
    public void removeAndRecycleAllViews(RecyclerView.Recycler param1Recycler) {
      for (int i = getChildCount() - 1; i >= 0; i--) {
        if (!RecyclerView.getChildViewHolderInt(getChildAt(i)).shouldIgnore())
          removeAndRecycleViewAt(i, param1Recycler); 
      } 
    }
    
    void removeAndRecycleScrapInt(RecyclerView.Recycler param1Recycler) {
      int i = param1Recycler.getScrapCount();
      for (int j = i - 1; j >= 0; j--) {
        View view = param1Recycler.getScrapViewAt(j);
        RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(view);
        if (!viewHolder.shouldIgnore()) {
          viewHolder.setIsRecyclable(false);
          if (viewHolder.isTmpDetached())
            this.mRecyclerView.removeDetachedView(view, false); 
          if (this.mRecyclerView.mItemAnimator != null)
            this.mRecyclerView.mItemAnimator.endAnimation(viewHolder); 
          viewHolder.setIsRecyclable(true);
          param1Recycler.quickRecycleScrapView(view);
        } 
      } 
      param1Recycler.clearScrap();
      if (i > 0)
        this.mRecyclerView.invalidate(); 
    }
    
    public void removeAndRecycleView(View param1View, RecyclerView.Recycler param1Recycler) {
      removeView(param1View);
      param1Recycler.recycleView(param1View);
    }
    
    public void removeAndRecycleViewAt(int param1Int, RecyclerView.Recycler param1Recycler) {
      View view = getChildAt(param1Int);
      removeViewAt(param1Int);
      param1Recycler.recycleView(view);
    }
    
    public boolean removeCallbacks(Runnable param1Runnable) {
      return (this.mRecyclerView != null) ? this.mRecyclerView.removeCallbacks(param1Runnable) : false;
    }
    
    public void removeDetachedView(View param1View) {
      this.mRecyclerView.removeDetachedView(param1View, false);
    }
    
    public void removeView(View param1View) {
      this.mChildHelper.removeView(param1View);
    }
    
    public void removeViewAt(int param1Int) {
      if (getChildAt(param1Int) != null)
        this.mChildHelper.removeViewAt(param1Int); 
    }
    
    public boolean requestChildRectangleOnScreen(RecyclerView param1RecyclerView, View param1View, Rect param1Rect, boolean param1Boolean) {
      int i = getPaddingLeft();
      int j = getPaddingTop();
      int k = getWidth();
      int m = getPaddingRight();
      int n = getHeight();
      int i1 = getPaddingBottom();
      int i2 = param1View.getLeft() + param1Rect.left - param1View.getScrollX();
      int i3 = param1View.getTop() + param1Rect.top - param1View.getScrollY();
      int i4 = param1Rect.width();
      int i5 = param1Rect.height();
      int i6 = i2 - i;
      i = Math.min(0, i6);
      int i7 = i3 - j;
      j = Math.min(0, i7);
      m = i4 + i2 - k - m;
      i4 = Math.max(0, m);
      i3 = Math.max(0, i5 + i3 - n - i1);
      if (getLayoutDirection() == 1) {
        if (i4 != 0) {
          i = i4;
        } else {
          i = Math.max(i, m);
        } 
      } else if (i == 0) {
        i = Math.min(i6, i4);
      } 
      if (j == 0)
        j = Math.min(i7, i3); 
      if (i != 0 || j != 0) {
        if (param1Boolean) {
          param1RecyclerView.scrollBy(i, j);
        } else {
          param1RecyclerView.smoothScrollBy(i, j);
        } 
        return true;
      } 
      return false;
    }
    
    public void requestLayout() {
      if (this.mRecyclerView != null)
        this.mRecyclerView.requestLayout(); 
    }
    
    public void requestSimpleAnimationsInNextLayout() {
      this.mRequestedSimpleAnimations = true;
    }
    
    public int scrollHorizontallyBy(int param1Int, RecyclerView.Recycler param1Recycler, RecyclerView.State param1State) {
      return 0;
    }
    
    public void scrollToPosition(int param1Int) {}
    
    public int scrollVerticallyBy(int param1Int, RecyclerView.Recycler param1Recycler, RecyclerView.State param1State) {
      return 0;
    }
    
    public void setAutoMeasureEnabled(boolean param1Boolean) {
      this.mAutoMeasure = param1Boolean;
    }
    
    void setExactMeasureSpecsFrom(RecyclerView param1RecyclerView) {
      setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(param1RecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(param1RecyclerView.getHeight(), 1073741824));
    }
    
    void setMeasureSpecs(int param1Int1, int param1Int2) {
      this.mWidth = View.MeasureSpec.getSize(param1Int1);
      this.mWidthMode = View.MeasureSpec.getMode(param1Int1);
      if (this.mWidthMode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC)
        this.mWidth = 0; 
      this.mHeight = View.MeasureSpec.getSize(param1Int2);
      this.mHeightMode = View.MeasureSpec.getMode(param1Int2);
      if (this.mHeightMode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC)
        this.mHeight = 0; 
    }
    
    public void setMeasuredDimension(int param1Int1, int param1Int2) {
      this.mRecyclerView.setMeasuredDimension(param1Int1, param1Int2);
    }
    
    public void setMeasuredDimension(Rect param1Rect, int param1Int1, int param1Int2) {
      int i = param1Rect.width();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = param1Rect.height();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      setMeasuredDimension(chooseSize(param1Int1, i + j + k, getMinimumWidth()), chooseSize(param1Int2, m + n + i1, getMinimumHeight()));
    }
    
    void setMeasuredDimensionFromChildren(int param1Int1, int param1Int2) {
      int i = getChildCount();
      if (i == 0) {
        this.mRecyclerView.defaultOnMeasure(param1Int1, param1Int2);
        return;
      } 
      byte b = 0;
      int j = Integer.MAX_VALUE;
      int k = Integer.MAX_VALUE;
      int m = Integer.MIN_VALUE;
      int n;
      for (n = Integer.MIN_VALUE; b < i; n = i3) {
        View view = getChildAt(b);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        Rect rect = this.mRecyclerView.mTempRect;
        getDecoratedBoundsWithMargins(view, rect);
        int i1 = j;
        if (rect.left < j)
          i1 = rect.left; 
        int i2 = m;
        if (rect.right > m)
          i2 = rect.right; 
        m = k;
        if (rect.top < k)
          m = rect.top; 
        int i3 = n;
        if (rect.bottom > n)
          i3 = rect.bottom; 
        b++;
        k = m;
        j = i1;
        m = i2;
      } 
      this.mRecyclerView.mTempRect.set(j, k, m, n);
      setMeasuredDimension(this.mRecyclerView.mTempRect, param1Int1, param1Int2);
    }
    
    public void setMeasurementCacheEnabled(boolean param1Boolean) {
      this.mMeasurementCacheEnabled = param1Boolean;
    }
    
    void setRecyclerView(RecyclerView param1RecyclerView) {
      if (param1RecyclerView == null) {
        this.mRecyclerView = null;
        this.mChildHelper = null;
        this.mWidth = 0;
        this.mHeight = 0;
      } else {
        this.mRecyclerView = param1RecyclerView;
        this.mChildHelper = param1RecyclerView.mChildHelper;
        this.mWidth = param1RecyclerView.getWidth();
        this.mHeight = param1RecyclerView.getHeight();
      } 
      this.mWidthMode = 1073741824;
      this.mHeightMode = 1073741824;
    }
    
    boolean shouldMeasureChild(View param1View, int param1Int1, int param1Int2, RecyclerView.LayoutParams param1LayoutParams) {
      return (param1View.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(param1View.getWidth(), param1Int1, param1LayoutParams.width) || !isMeasurementUpToDate(param1View.getHeight(), param1Int2, param1LayoutParams.height));
    }
    
    boolean shouldMeasureTwice() {
      return false;
    }
    
    boolean shouldReMeasureChild(View param1View, int param1Int1, int param1Int2, RecyclerView.LayoutParams param1LayoutParams) {
      return (!this.mMeasurementCacheEnabled || !isMeasurementUpToDate(param1View.getMeasuredWidth(), param1Int1, param1LayoutParams.width) || !isMeasurementUpToDate(param1View.getMeasuredHeight(), param1Int2, param1LayoutParams.height));
    }
    
    public void smoothScrollToPosition(RecyclerView param1RecyclerView, RecyclerView.State param1State, int param1Int) {
      Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }
    
    public void startSmoothScroll(RecyclerView.SmoothScroller param1SmoothScroller) {
      if (this.mSmoothScroller != null && param1SmoothScroller != this.mSmoothScroller && this.mSmoothScroller.isRunning())
        this.mSmoothScroller.stop(); 
      this.mSmoothScroller = param1SmoothScroller;
      this.mSmoothScroller.start(this.mRecyclerView, this);
    }
    
    public void stopIgnoringView(View param1View) {
      RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(param1View);
      viewHolder.stopIgnoring();
      viewHolder.resetInternal();
      viewHolder.addFlags(4);
    }
    
    void stopSmoothScroller() {
      if (this.mSmoothScroller != null)
        this.mSmoothScroller.stop(); 
    }
    
    public boolean supportsPredictiveItemAnimations() {
      return false;
    }
    
    public static class Properties {
      public int orientation;
      
      public boolean reverseLayout;
      
      public int spanCount;
      
      public boolean stackFromEnd;
    }
  }
  
  public static class Properties {
    public int orientation;
    
    public boolean reverseLayout;
    
    public int spanCount;
    
    public boolean stackFromEnd;
  }
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    final Rect mDecorInsets = new Rect();
    
    boolean mInsetsDirty = true;
    
    boolean mPendingInvalidate = false;
    
    RecyclerView.ViewHolder mViewHolder;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      super(param1MarginLayoutParams);
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super((ViewGroup.LayoutParams)param1LayoutParams);
    }
    
    public int getViewAdapterPosition() {
      return this.mViewHolder.getAdapterPosition();
    }
    
    public int getViewLayoutPosition() {
      return this.mViewHolder.getLayoutPosition();
    }
    
    @Deprecated
    public int getViewPosition() {
      return this.mViewHolder.getPosition();
    }
    
    public boolean isItemChanged() {
      return this.mViewHolder.isUpdated();
    }
    
    public boolean isItemRemoved() {
      return this.mViewHolder.isRemoved();
    }
    
    public boolean isViewInvalid() {
      return this.mViewHolder.isInvalid();
    }
    
    public boolean viewNeedsUpdate() {
      return this.mViewHolder.needsUpdate();
    }
  }
  
  public static interface OnChildAttachStateChangeListener {
    void onChildViewAttachedToWindow(View param1View);
    
    void onChildViewDetachedFromWindow(View param1View);
  }
  
  public static interface OnItemTouchListener {
    boolean onInterceptTouchEvent(RecyclerView param1RecyclerView, MotionEvent param1MotionEvent);
    
    void onRequestDisallowInterceptTouchEvent(boolean param1Boolean);
    
    void onTouchEvent(RecyclerView param1RecyclerView, MotionEvent param1MotionEvent);
  }
  
  public static abstract class OnScrollListener {
    public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {}
    
    public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {}
  }
  
  public static class RecycledViewPool {
    private static final int DEFAULT_MAX_SCRAP = 5;
    
    private int mAttachCount = 0;
    
    private SparseIntArray mMaxScrap = new SparseIntArray();
    
    private SparseArray<ArrayList<RecyclerView.ViewHolder>> mScrap = new SparseArray();
    
    private ArrayList<RecyclerView.ViewHolder> getScrapHeapForType(int param1Int) {
      ArrayList<RecyclerView.ViewHolder> arrayList1 = (ArrayList)this.mScrap.get(param1Int);
      ArrayList<RecyclerView.ViewHolder> arrayList2 = arrayList1;
      if (arrayList1 == null) {
        arrayList1 = new ArrayList();
        this.mScrap.put(param1Int, arrayList1);
        arrayList2 = arrayList1;
        if (this.mMaxScrap.indexOfKey(param1Int) < 0) {
          this.mMaxScrap.put(param1Int, 5);
          arrayList2 = arrayList1;
        } 
      } 
      return arrayList2;
    }
    
    void attach(RecyclerView.Adapter param1Adapter) {
      this.mAttachCount++;
    }
    
    public void clear() {
      this.mScrap.clear();
    }
    
    void detach() {
      this.mAttachCount--;
    }
    
    public RecyclerView.ViewHolder getRecycledView(int param1Int) {
      ArrayList<RecyclerView.ViewHolder> arrayList = (ArrayList)this.mScrap.get(param1Int);
      if (arrayList != null && !arrayList.isEmpty()) {
        param1Int = arrayList.size() - 1;
        RecyclerView.ViewHolder viewHolder = arrayList.get(param1Int);
        arrayList.remove(param1Int);
        return viewHolder;
      } 
      return null;
    }
    
    void onAdapterChanged(RecyclerView.Adapter param1Adapter1, RecyclerView.Adapter param1Adapter2, boolean param1Boolean) {
      if (param1Adapter1 != null)
        detach(); 
      if (!param1Boolean && this.mAttachCount == 0)
        clear(); 
      if (param1Adapter2 != null)
        attach(param1Adapter2); 
    }
    
    public void putRecycledView(RecyclerView.ViewHolder param1ViewHolder) {
      int i = param1ViewHolder.getItemViewType();
      ArrayList<RecyclerView.ViewHolder> arrayList = getScrapHeapForType(i);
      if (this.mMaxScrap.get(i) <= arrayList.size())
        return; 
      param1ViewHolder.resetInternal();
      arrayList.add(param1ViewHolder);
    }
    
    public void setMaxRecycledViews(int param1Int1, int param1Int2) {
      this.mMaxScrap.put(param1Int1, param1Int2);
      ArrayList arrayList = (ArrayList)this.mScrap.get(param1Int1);
      if (arrayList != null)
        while (arrayList.size() > param1Int2)
          arrayList.remove(arrayList.size() - 1);  
    }
    
    int size() {
      byte b = 0;
      int i;
      for (i = 0; b < this.mScrap.size(); i = j) {
        ArrayList arrayList = (ArrayList)this.mScrap.valueAt(b);
        int j = i;
        if (arrayList != null)
          j = i + arrayList.size(); 
        b++;
      } 
      return i;
    }
  }
  
  public final class Recycler {
    private static final int DEFAULT_CACHE_SIZE = 2;
    
    final ArrayList<RecyclerView.ViewHolder> mAttachedScrap = new ArrayList<RecyclerView.ViewHolder>();
    
    final ArrayList<RecyclerView.ViewHolder> mCachedViews = new ArrayList<RecyclerView.ViewHolder>();
    
    private ArrayList<RecyclerView.ViewHolder> mChangedScrap = null;
    
    private RecyclerView.RecycledViewPool mRecyclerPool;
    
    private final List<RecyclerView.ViewHolder> mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.mAttachedScrap);
    
    private RecyclerView.ViewCacheExtension mViewCacheExtension;
    
    private int mViewCacheMax = 2;
    
    private void invalidateDisplayListInt(ViewGroup param1ViewGroup, boolean param1Boolean) {
      int i;
      for (i = param1ViewGroup.getChildCount() - 1; i >= 0; i--) {
        View view = param1ViewGroup.getChildAt(i);
        if (view instanceof ViewGroup)
          invalidateDisplayListInt((ViewGroup)view, true); 
      } 
      if (!param1Boolean)
        return; 
      if (param1ViewGroup.getVisibility() == 4) {
        param1ViewGroup.setVisibility(0);
        param1ViewGroup.setVisibility(4);
      } else {
        i = param1ViewGroup.getVisibility();
        param1ViewGroup.setVisibility(4);
        param1ViewGroup.setVisibility(i);
      } 
    }
    
    private void invalidateDisplayListInt(RecyclerView.ViewHolder param1ViewHolder) {
      if (param1ViewHolder.itemView instanceof ViewGroup)
        invalidateDisplayListInt((ViewGroup)param1ViewHolder.itemView, false); 
    }
    
    void addViewHolderToRecycledViewPool(RecyclerView.ViewHolder param1ViewHolder) {
      dispatchViewRecycled(param1ViewHolder);
      param1ViewHolder.mOwnerRecyclerView = null;
      getRecycledViewPool().putRecycledView(param1ViewHolder);
    }
    
    public void bindViewToPosition(View param1View, int param1Int) {
      RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(param1View);
      if (viewHolder != null) {
        int i = RecyclerView.this.mAdapterHelper.findPositionOffset(param1Int);
        if (i >= 0 && i < RecyclerView.this.mAdapter.getItemCount()) {
          RecyclerView.LayoutParams layoutParams;
          viewHolder.mOwnerRecyclerView = RecyclerView.this;
          RecyclerView.this.mAdapter.bindViewHolder(viewHolder, i);
          if (RecyclerView.this.mState.isPreLayout())
            viewHolder.mPreLayoutPosition = param1Int; 
          ViewGroup.LayoutParams layoutParams1 = viewHolder.itemView.getLayoutParams();
          if (layoutParams1 == null) {
            layoutParams = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
            viewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          } else if (!RecyclerView.this.checkLayoutParams((ViewGroup.LayoutParams)layoutParams)) {
            layoutParams = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams((ViewGroup.LayoutParams)layoutParams);
            viewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          } else {
            layoutParams = layoutParams;
          } 
          boolean bool = true;
          layoutParams.mInsetsDirty = true;
          layoutParams.mViewHolder = viewHolder;
          if (viewHolder.itemView.getParent() != null)
            bool = false; 
          layoutParams.mPendingInvalidate = bool;
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Inconsistency detected. Invalid item position ");
        stringBuilder.append(param1Int);
        stringBuilder.append("(offset:");
        stringBuilder.append(i);
        stringBuilder.append(").state:");
        stringBuilder.append(RecyclerView.this.mState.getItemCount());
        throw new IndexOutOfBoundsException(stringBuilder.toString());
      } 
      throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
    }
    
    public void clear() {
      this.mAttachedScrap.clear();
      recycleAndClearCachedViews();
    }
    
    void clearOldPositions() {
      int i = this.mCachedViews.size();
      boolean bool = false;
      byte b;
      for (b = 0; b < i; b++)
        ((RecyclerView.ViewHolder)this.mCachedViews.get(b)).clearOldPosition(); 
      i = this.mAttachedScrap.size();
      for (b = 0; b < i; b++)
        ((RecyclerView.ViewHolder)this.mAttachedScrap.get(b)).clearOldPosition(); 
      if (this.mChangedScrap != null) {
        i = this.mChangedScrap.size();
        for (b = bool; b < i; b++)
          ((RecyclerView.ViewHolder)this.mChangedScrap.get(b)).clearOldPosition(); 
      } 
    }
    
    void clearScrap() {
      this.mAttachedScrap.clear();
      if (this.mChangedScrap != null)
        this.mChangedScrap.clear(); 
    }
    
    public int convertPreLayoutPositionToPostLayout(int param1Int) {
      if (param1Int >= 0 && param1Int < RecyclerView.this.mState.getItemCount())
        return !RecyclerView.this.mState.isPreLayout() ? param1Int : RecyclerView.this.mAdapterHelper.findPositionOffset(param1Int); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("invalid position ");
      stringBuilder.append(param1Int);
      stringBuilder.append(". State item count is ");
      stringBuilder.append(RecyclerView.this.mState.getItemCount());
      throw new IndexOutOfBoundsException(stringBuilder.toString());
    }
    
    void dispatchViewRecycled(RecyclerView.ViewHolder param1ViewHolder) {
      if (RecyclerView.this.mRecyclerListener != null)
        RecyclerView.this.mRecyclerListener.onViewRecycled(param1ViewHolder); 
      if (RecyclerView.this.mAdapter != null)
        RecyclerView.this.mAdapter.onViewRecycled(param1ViewHolder); 
      if (RecyclerView.this.mState != null)
        RecyclerView.this.mViewInfoStore.removeViewHolder(param1ViewHolder); 
    }
    
    RecyclerView.ViewHolder getChangedScrapViewForPosition(int param1Int) {
      if (this.mChangedScrap != null) {
        int i = this.mChangedScrap.size();
        if (i != 0) {
          boolean bool = false;
          for (byte b = 0; b < i; b++) {
            RecyclerView.ViewHolder viewHolder = this.mChangedScrap.get(b);
            if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == param1Int) {
              viewHolder.addFlags(32);
              return viewHolder;
            } 
          } 
          if (RecyclerView.this.mAdapter.hasStableIds()) {
            param1Int = RecyclerView.this.mAdapterHelper.findPositionOffset(param1Int);
            if (param1Int > 0 && param1Int < RecyclerView.this.mAdapter.getItemCount()) {
              long l = RecyclerView.this.mAdapter.getItemId(param1Int);
              for (param1Int = bool; param1Int < i; param1Int++) {
                RecyclerView.ViewHolder viewHolder = this.mChangedScrap.get(param1Int);
                if (!viewHolder.wasReturnedFromScrap() && viewHolder.getItemId() == l) {
                  viewHolder.addFlags(32);
                  return viewHolder;
                } 
              } 
            } 
          } 
          return null;
        } 
      } 
      return null;
    }
    
    RecyclerView.RecycledViewPool getRecycledViewPool() {
      if (this.mRecyclerPool == null)
        this.mRecyclerPool = new RecyclerView.RecycledViewPool(); 
      return this.mRecyclerPool;
    }
    
    int getScrapCount() {
      return this.mAttachedScrap.size();
    }
    
    public List<RecyclerView.ViewHolder> getScrapList() {
      return this.mUnmodifiableAttachedScrap;
    }
    
    View getScrapViewAt(int param1Int) {
      return ((RecyclerView.ViewHolder)this.mAttachedScrap.get(param1Int)).itemView;
    }
    
    RecyclerView.ViewHolder getScrapViewForId(long param1Long, int param1Int, boolean param1Boolean) {
      int i;
      for (i = this.mAttachedScrap.size() - 1; i >= 0; i--) {
        RecyclerView.ViewHolder viewHolder = this.mAttachedScrap.get(i);
        if (viewHolder.getItemId() == param1Long && !viewHolder.wasReturnedFromScrap()) {
          if (param1Int == viewHolder.getItemViewType()) {
            viewHolder.addFlags(32);
            if (viewHolder.isRemoved() && !RecyclerView.this.mState.isPreLayout())
              viewHolder.setFlags(2, 14); 
            return viewHolder;
          } 
          if (!param1Boolean) {
            this.mAttachedScrap.remove(i);
            RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
            quickRecycleScrapView(viewHolder.itemView);
          } 
        } 
      } 
      for (i = this.mCachedViews.size() - 1; i >= 0; i--) {
        RecyclerView.ViewHolder viewHolder = this.mCachedViews.get(i);
        if (viewHolder.getItemId() == param1Long) {
          if (param1Int == viewHolder.getItemViewType()) {
            if (!param1Boolean)
              this.mCachedViews.remove(i); 
            return viewHolder;
          } 
          if (!param1Boolean)
            recycleCachedViewAt(i); 
        } 
      } 
      return null;
    }
    
    RecyclerView.ViewHolder getScrapViewForPosition(int param1Int1, int param1Int2, boolean param1Boolean) {
      int i = this.mAttachedScrap.size();
      boolean bool = false;
      int j;
      for (j = 0; j < i; j++) {
        RecyclerView.ViewHolder viewHolder = this.mAttachedScrap.get(j);
        if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == param1Int1 && !viewHolder.isInvalid() && (RecyclerView.this.mState.mInPreLayout || !viewHolder.isRemoved())) {
          if (param1Int2 != -1 && viewHolder.getItemViewType() != param1Int2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scrap view for position ");
            stringBuilder.append(param1Int1);
            stringBuilder.append(" isn't dirty but has wrong view type! (found ");
            stringBuilder.append(viewHolder.getItemViewType());
            stringBuilder.append(" but expected ");
            stringBuilder.append(param1Int2);
            stringBuilder.append(")");
            Log.e("RecyclerView", stringBuilder.toString());
            break;
          } 
          viewHolder.addFlags(32);
          return viewHolder;
        } 
      } 
      if (!param1Boolean) {
        View view = RecyclerView.this.mChildHelper.findHiddenNonRemovedView(param1Int1, param1Int2);
        if (view != null) {
          RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(view);
          RecyclerView.this.mChildHelper.unhide(view);
          param1Int1 = RecyclerView.this.mChildHelper.indexOfChild(view);
          if (param1Int1 != -1) {
            RecyclerView.this.mChildHelper.detachViewFromParent(param1Int1);
            scrapView(view);
            viewHolder.addFlags(8224);
            return viewHolder;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("layout index should not be -1 after unhiding a view:");
          stringBuilder.append(viewHolder);
          throw new IllegalStateException(stringBuilder.toString());
        } 
      } 
      j = this.mCachedViews.size();
      for (param1Int2 = bool; param1Int2 < j; param1Int2++) {
        RecyclerView.ViewHolder viewHolder = this.mCachedViews.get(param1Int2);
        if (!viewHolder.isInvalid() && viewHolder.getLayoutPosition() == param1Int1) {
          if (!param1Boolean)
            this.mCachedViews.remove(param1Int2); 
          return viewHolder;
        } 
      } 
      return null;
    }
    
    public View getViewForPosition(int param1Int) {
      return getViewForPosition(param1Int, false);
    }
    
    View getViewForPosition(int param1Int, boolean param1Boolean) {
      // Byte code:
      //   0: iload_1
      //   1: iflt -> 906
      //   4: iload_1
      //   5: aload_0
      //   6: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   9: getfield mState : Lorg/jar/support/v7/widget/RecyclerView$State;
      //   12: invokevirtual getItemCount : ()I
      //   15: if_icmpge -> 906
      //   18: aload_0
      //   19: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   22: getfield mState : Lorg/jar/support/v7/widget/RecyclerView$State;
      //   25: invokevirtual isPreLayout : ()Z
      //   28: istore_3
      //   29: iconst_1
      //   30: istore #4
      //   32: iload_3
      //   33: ifeq -> 58
      //   36: aload_0
      //   37: iload_1
      //   38: invokevirtual getChangedScrapViewForPosition : (I)Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;
      //   41: astore #5
      //   43: aload #5
      //   45: astore #6
      //   47: aload #5
      //   49: ifnull -> 61
      //   52: iconst_1
      //   53: istore #7
      //   55: goto -> 68
      //   58: aconst_null
      //   59: astore #6
      //   61: iconst_0
      //   62: istore #7
      //   64: aload #6
      //   66: astore #5
      //   68: aload #5
      //   70: astore #6
      //   72: iload #7
      //   74: istore #8
      //   76: aload #5
      //   78: ifnonnull -> 187
      //   81: aload_0
      //   82: iload_1
      //   83: iconst_m1
      //   84: iload_2
      //   85: invokevirtual getScrapViewForPosition : (IIZ)Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;
      //   88: astore #5
      //   90: aload #5
      //   92: astore #6
      //   94: iload #7
      //   96: istore #8
      //   98: aload #5
      //   100: ifnull -> 187
      //   103: aload_0
      //   104: aload #5
      //   106: invokevirtual validateViewHolderForOffsetPosition : (Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;)Z
      //   109: ifne -> 180
      //   112: iload_2
      //   113: ifne -> 170
      //   116: aload #5
      //   118: iconst_4
      //   119: invokevirtual addFlags : (I)V
      //   122: aload #5
      //   124: invokevirtual isScrap : ()Z
      //   127: ifeq -> 151
      //   130: aload_0
      //   131: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   134: aload #5
      //   136: getfield itemView : Landroid/view/View;
      //   139: iconst_0
      //   140: invokevirtual removeDetachedView : (Landroid/view/View;Z)V
      //   143: aload #5
      //   145: invokevirtual unScrap : ()V
      //   148: goto -> 164
      //   151: aload #5
      //   153: invokevirtual wasReturnedFromScrap : ()Z
      //   156: ifeq -> 164
      //   159: aload #5
      //   161: invokevirtual clearReturnedFromScrapFlag : ()V
      //   164: aload_0
      //   165: aload #5
      //   167: invokevirtual recycleViewHolderInternal : (Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;)V
      //   170: aconst_null
      //   171: astore #6
      //   173: iload #7
      //   175: istore #8
      //   177: goto -> 187
      //   180: iconst_1
      //   181: istore #8
      //   183: aload #5
      //   185: astore #6
      //   187: aload #6
      //   189: astore #5
      //   191: iload #8
      //   193: istore #9
      //   195: aload #6
      //   197: ifnonnull -> 564
      //   200: aload_0
      //   201: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   204: getfield mAdapterHelper : Lorg/jar/support/v7/widget/AdapterHelper;
      //   207: iload_1
      //   208: invokevirtual findPositionOffset : (I)I
      //   211: istore #9
      //   213: iload #9
      //   215: iflt -> 487
      //   218: iload #9
      //   220: aload_0
      //   221: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   224: invokestatic access$3100 : (Lorg/jar/support/v7/widget/RecyclerView;)Lorg/jar/support/v7/widget/RecyclerView$Adapter;
      //   227: invokevirtual getItemCount : ()I
      //   230: if_icmpge -> 487
      //   233: aload_0
      //   234: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   237: invokestatic access$3100 : (Lorg/jar/support/v7/widget/RecyclerView;)Lorg/jar/support/v7/widget/RecyclerView$Adapter;
      //   240: iload #9
      //   242: invokevirtual getItemViewType : (I)I
      //   245: istore #10
      //   247: aload #6
      //   249: astore #5
      //   251: iload #8
      //   253: istore #7
      //   255: aload_0
      //   256: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   259: invokestatic access$3100 : (Lorg/jar/support/v7/widget/RecyclerView;)Lorg/jar/support/v7/widget/RecyclerView$Adapter;
      //   262: invokevirtual hasStableIds : ()Z
      //   265: ifeq -> 316
      //   268: aload_0
      //   269: aload_0
      //   270: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   273: invokestatic access$3100 : (Lorg/jar/support/v7/widget/RecyclerView;)Lorg/jar/support/v7/widget/RecyclerView$Adapter;
      //   276: iload #9
      //   278: invokevirtual getItemId : (I)J
      //   281: iload #10
      //   283: iload_2
      //   284: invokevirtual getScrapViewForId : (JIZ)Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;
      //   287: astore #6
      //   289: aload #6
      //   291: astore #5
      //   293: iload #8
      //   295: istore #7
      //   297: aload #6
      //   299: ifnull -> 316
      //   302: aload #6
      //   304: iload #9
      //   306: putfield mPosition : I
      //   309: iconst_1
      //   310: istore #7
      //   312: aload #6
      //   314: astore #5
      //   316: aload #5
      //   318: astore #6
      //   320: aload #5
      //   322: ifnonnull -> 407
      //   325: aload #5
      //   327: astore #6
      //   329: aload_0
      //   330: getfield mViewCacheExtension : Lorg/jar/support/v7/widget/RecyclerView$ViewCacheExtension;
      //   333: ifnull -> 407
      //   336: aload_0
      //   337: getfield mViewCacheExtension : Lorg/jar/support/v7/widget/RecyclerView$ViewCacheExtension;
      //   340: aload_0
      //   341: iload_1
      //   342: iload #10
      //   344: invokevirtual getViewForPositionAndType : (Lorg/jar/support/v7/widget/RecyclerView$Recycler;II)Landroid/view/View;
      //   347: astore #11
      //   349: aload #5
      //   351: astore #6
      //   353: aload #11
      //   355: ifnull -> 407
      //   358: aload_0
      //   359: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   362: aload #11
      //   364: invokevirtual getChildViewHolder : (Landroid/view/View;)Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;
      //   367: astore #6
      //   369: aload #6
      //   371: ifnull -> 396
      //   374: aload #6
      //   376: invokevirtual shouldIgnore : ()Z
      //   379: ifne -> 385
      //   382: goto -> 407
      //   385: new java/lang/IllegalArgumentException
      //   388: dup
      //   389: ldc_w 'getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.'
      //   392: invokespecial <init> : (Ljava/lang/String;)V
      //   395: athrow
      //   396: new java/lang/IllegalArgumentException
      //   399: dup
      //   400: ldc_w 'getViewForPositionAndType returned a view which does not have a ViewHolder'
      //   403: invokespecial <init> : (Ljava/lang/String;)V
      //   406: athrow
      //   407: aload #6
      //   409: astore #11
      //   411: aload #6
      //   413: ifnonnull -> 449
      //   416: aload_0
      //   417: invokevirtual getRecycledViewPool : ()Lorg/jar/support/v7/widget/RecyclerView$RecycledViewPool;
      //   420: iload #10
      //   422: invokevirtual getRecycledView : (I)Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;
      //   425: astore #11
      //   427: aload #11
      //   429: ifnull -> 449
      //   432: aload #11
      //   434: invokevirtual resetInternal : ()V
      //   437: invokestatic access$4500 : ()Z
      //   440: ifeq -> 449
      //   443: aload_0
      //   444: aload #11
      //   446: invokespecial invalidateDisplayListInt : (Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;)V
      //   449: aload #11
      //   451: astore #5
      //   453: iload #7
      //   455: istore #9
      //   457: aload #11
      //   459: ifnonnull -> 564
      //   462: aload_0
      //   463: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   466: invokestatic access$3100 : (Lorg/jar/support/v7/widget/RecyclerView;)Lorg/jar/support/v7/widget/RecyclerView$Adapter;
      //   469: aload_0
      //   470: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   473: iload #10
      //   475: invokevirtual createViewHolder : (Landroid/view/ViewGroup;I)Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;
      //   478: astore #5
      //   480: iload #7
      //   482: istore #9
      //   484: goto -> 564
      //   487: new java/lang/StringBuilder
      //   490: dup
      //   491: invokespecial <init> : ()V
      //   494: astore #6
      //   496: aload #6
      //   498: ldc 'Inconsistency detected. Invalid item position '
      //   500: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   503: pop
      //   504: aload #6
      //   506: iload_1
      //   507: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   510: pop
      //   511: aload #6
      //   513: ldc '(offset:'
      //   515: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   518: pop
      //   519: aload #6
      //   521: iload #9
      //   523: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   526: pop
      //   527: aload #6
      //   529: ldc ').state:'
      //   531: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   534: pop
      //   535: aload #6
      //   537: aload_0
      //   538: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   541: getfield mState : Lorg/jar/support/v7/widget/RecyclerView$State;
      //   544: invokevirtual getItemCount : ()I
      //   547: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   550: pop
      //   551: new java/lang/IndexOutOfBoundsException
      //   554: dup
      //   555: aload #6
      //   557: invokevirtual toString : ()Ljava/lang/String;
      //   560: invokespecial <init> : (Ljava/lang/String;)V
      //   563: athrow
      //   564: iload #9
      //   566: ifeq -> 665
      //   569: aload_0
      //   570: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   573: getfield mState : Lorg/jar/support/v7/widget/RecyclerView$State;
      //   576: invokevirtual isPreLayout : ()Z
      //   579: ifne -> 665
      //   582: aload #5
      //   584: sipush #8192
      //   587: invokevirtual hasAnyOfTheFlags : (I)Z
      //   590: ifeq -> 665
      //   593: aload #5
      //   595: iconst_0
      //   596: sipush #8192
      //   599: invokevirtual setFlags : (II)V
      //   602: aload_0
      //   603: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   606: getfield mState : Lorg/jar/support/v7/widget/RecyclerView$State;
      //   609: invokestatic access$2500 : (Lorg/jar/support/v7/widget/RecyclerView$State;)Z
      //   612: ifeq -> 665
      //   615: aload #5
      //   617: invokestatic buildAdapterChangeFlagsForAnimations : (Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;)I
      //   620: istore #8
      //   622: aload_0
      //   623: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   626: getfield mItemAnimator : Lorg/jar/support/v7/widget/RecyclerView$ItemAnimator;
      //   629: aload_0
      //   630: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   633: getfield mState : Lorg/jar/support/v7/widget/RecyclerView$State;
      //   636: aload #5
      //   638: iload #8
      //   640: sipush #4096
      //   643: ior
      //   644: aload #5
      //   646: invokevirtual getUnmodifiedPayloads : ()Ljava/util/List;
      //   649: invokevirtual recordPreLayoutInformation : (Lorg/jar/support/v7/widget/RecyclerView$State;Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;ILjava/util/List;)Lorg/jar/support/v7/widget/RecyclerView$ItemAnimator$ItemHolderInfo;
      //   652: astore #6
      //   654: aload_0
      //   655: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   658: aload #5
      //   660: aload #6
      //   662: invokestatic access$4600 : (Lorg/jar/support/v7/widget/RecyclerView;Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;Lorg/jar/support/v7/widget/RecyclerView$ItemAnimator$ItemHolderInfo;)V
      //   665: aload_0
      //   666: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   669: getfield mState : Lorg/jar/support/v7/widget/RecyclerView$State;
      //   672: invokevirtual isPreLayout : ()Z
      //   675: ifeq -> 695
      //   678: aload #5
      //   680: invokevirtual isBound : ()Z
      //   683: ifeq -> 695
      //   686: aload #5
      //   688: iload_1
      //   689: putfield mPreLayoutPosition : I
      //   692: goto -> 722
      //   695: aload #5
      //   697: invokevirtual isBound : ()Z
      //   700: ifeq -> 727
      //   703: aload #5
      //   705: invokevirtual needsUpdate : ()Z
      //   708: ifne -> 727
      //   711: aload #5
      //   713: invokevirtual isInvalid : ()Z
      //   716: ifeq -> 722
      //   719: goto -> 727
      //   722: iconst_0
      //   723: istore_1
      //   724: goto -> 784
      //   727: aload_0
      //   728: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   731: getfield mAdapterHelper : Lorg/jar/support/v7/widget/AdapterHelper;
      //   734: iload_1
      //   735: invokevirtual findPositionOffset : (I)I
      //   738: istore #8
      //   740: aload #5
      //   742: aload_0
      //   743: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   746: putfield mOwnerRecyclerView : Lorg/jar/support/v7/widget/RecyclerView;
      //   749: aload_0
      //   750: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   753: invokestatic access$3100 : (Lorg/jar/support/v7/widget/RecyclerView;)Lorg/jar/support/v7/widget/RecyclerView$Adapter;
      //   756: aload #5
      //   758: iload #8
      //   760: invokevirtual bindViewHolder : (Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;I)V
      //   763: aload_0
      //   764: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   767: getfield mState : Lorg/jar/support/v7/widget/RecyclerView$State;
      //   770: invokevirtual isPreLayout : ()Z
      //   773: ifeq -> 782
      //   776: aload #5
      //   778: iload_1
      //   779: putfield mPreLayoutPosition : I
      //   782: iconst_1
      //   783: istore_1
      //   784: aload #5
      //   786: getfield itemView : Landroid/view/View;
      //   789: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
      //   792: astore #6
      //   794: aload #6
      //   796: ifnonnull -> 824
      //   799: aload_0
      //   800: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   803: invokevirtual generateDefaultLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
      //   806: checkcast org/jar/support/v7/widget/RecyclerView$LayoutParams
      //   809: astore #6
      //   811: aload #5
      //   813: getfield itemView : Landroid/view/View;
      //   816: aload #6
      //   818: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
      //   821: goto -> 870
      //   824: aload_0
      //   825: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   828: aload #6
      //   830: invokevirtual checkLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)Z
      //   833: ifne -> 863
      //   836: aload_0
      //   837: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   840: aload #6
      //   842: invokevirtual generateLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
      //   845: checkcast org/jar/support/v7/widget/RecyclerView$LayoutParams
      //   848: astore #6
      //   850: aload #5
      //   852: getfield itemView : Landroid/view/View;
      //   855: aload #6
      //   857: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
      //   860: goto -> 870
      //   863: aload #6
      //   865: checkcast org/jar/support/v7/widget/RecyclerView$LayoutParams
      //   868: astore #6
      //   870: aload #6
      //   872: aload #5
      //   874: putfield mViewHolder : Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;
      //   877: iload #9
      //   879: ifeq -> 892
      //   882: iload_1
      //   883: ifeq -> 892
      //   886: iload #4
      //   888: istore_2
      //   889: goto -> 894
      //   892: iconst_0
      //   893: istore_2
      //   894: aload #6
      //   896: iload_2
      //   897: putfield mPendingInvalidate : Z
      //   900: aload #5
      //   902: getfield itemView : Landroid/view/View;
      //   905: areturn
      //   906: new java/lang/StringBuilder
      //   909: dup
      //   910: invokespecial <init> : ()V
      //   913: astore #6
      //   915: aload #6
      //   917: ldc_w 'Invalid item position '
      //   920: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   923: pop
      //   924: aload #6
      //   926: iload_1
      //   927: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   930: pop
      //   931: aload #6
      //   933: ldc_w '('
      //   936: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   939: pop
      //   940: aload #6
      //   942: iload_1
      //   943: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   946: pop
      //   947: aload #6
      //   949: ldc_w '). Item count:'
      //   952: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   955: pop
      //   956: aload #6
      //   958: aload_0
      //   959: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   962: getfield mState : Lorg/jar/support/v7/widget/RecyclerView$State;
      //   965: invokevirtual getItemCount : ()I
      //   968: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   971: pop
      //   972: new java/lang/IndexOutOfBoundsException
      //   975: dup
      //   976: aload #6
      //   978: invokevirtual toString : ()Ljava/lang/String;
      //   981: invokespecial <init> : (Ljava/lang/String;)V
      //   984: athrow
    }
    
    void markItemDecorInsetsDirty() {
      int i = this.mCachedViews.size();
      for (byte b = 0; b < i; b++) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)((RecyclerView.ViewHolder)this.mCachedViews.get(b)).itemView.getLayoutParams();
        if (layoutParams != null)
          layoutParams.mInsetsDirty = true; 
      } 
    }
    
    void markKnownViewsInvalid() {
      if (RecyclerView.this.mAdapter != null && RecyclerView.this.mAdapter.hasStableIds()) {
        int i = this.mCachedViews.size();
        for (byte b = 0; b < i; b++) {
          RecyclerView.ViewHolder viewHolder = this.mCachedViews.get(b);
          if (viewHolder != null) {
            viewHolder.addFlags(6);
            viewHolder.addChangePayload(null);
          } 
        } 
      } else {
        recycleAndClearCachedViews();
      } 
    }
    
    void offsetPositionRecordsForInsert(int param1Int1, int param1Int2) {
      int i = this.mCachedViews.size();
      for (byte b = 0; b < i; b++) {
        RecyclerView.ViewHolder viewHolder = this.mCachedViews.get(b);
        if (viewHolder != null && viewHolder.mPosition >= param1Int1)
          viewHolder.offsetPosition(param1Int2, true); 
      } 
    }
    
    void offsetPositionRecordsForMove(int param1Int1, int param1Int2) {
      int i;
      int j;
      boolean bool;
      if (param1Int1 < param1Int2) {
        i = param1Int1;
        j = param1Int2;
        bool = true;
      } else {
        j = param1Int1;
        i = param1Int2;
        bool = true;
      } 
      int k = this.mCachedViews.size();
      for (byte b = 0; b < k; b++) {
        RecyclerView.ViewHolder viewHolder = this.mCachedViews.get(b);
        if (viewHolder != null && viewHolder.mPosition >= i && viewHolder.mPosition <= j)
          if (viewHolder.mPosition == param1Int1) {
            viewHolder.offsetPosition(param1Int2 - param1Int1, false);
          } else {
            viewHolder.offsetPosition(bool, false);
          }  
      } 
    }
    
    void offsetPositionRecordsForRemove(int param1Int1, int param1Int2, boolean param1Boolean) {
      for (int i = this.mCachedViews.size() - 1; i >= 0; i--) {
        RecyclerView.ViewHolder viewHolder = this.mCachedViews.get(i);
        if (viewHolder != null)
          if (viewHolder.mPosition >= param1Int1 + param1Int2) {
            viewHolder.offsetPosition(-param1Int2, param1Boolean);
          } else if (viewHolder.mPosition >= param1Int1) {
            viewHolder.addFlags(8);
            recycleCachedViewAt(i);
          }  
      } 
    }
    
    void onAdapterChanged(RecyclerView.Adapter param1Adapter1, RecyclerView.Adapter param1Adapter2, boolean param1Boolean) {
      clear();
      getRecycledViewPool().onAdapterChanged(param1Adapter1, param1Adapter2, param1Boolean);
    }
    
    void quickRecycleScrapView(View param1View) {
      RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(param1View);
      RecyclerView.ViewHolder.access$4802(viewHolder, null);
      RecyclerView.ViewHolder.access$4902(viewHolder, false);
      viewHolder.clearReturnedFromScrapFlag();
      recycleViewHolderInternal(viewHolder);
    }
    
    void recycleAndClearCachedViews() {
      for (int i = this.mCachedViews.size() - 1; i >= 0; i--)
        recycleCachedViewAt(i); 
      this.mCachedViews.clear();
    }
    
    void recycleCachedViewAt(int param1Int) {
      addViewHolderToRecycledViewPool(this.mCachedViews.get(param1Int));
      this.mCachedViews.remove(param1Int);
    }
    
    public void recycleView(View param1View) {
      RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(param1View);
      if (viewHolder.isTmpDetached())
        RecyclerView.this.removeDetachedView(param1View, false); 
      if (viewHolder.isScrap()) {
        viewHolder.unScrap();
      } else if (viewHolder.wasReturnedFromScrap()) {
        viewHolder.clearReturnedFromScrapFlag();
      } 
      recycleViewHolderInternal(viewHolder);
    }
    
    void recycleViewHolderInternal(RecyclerView.ViewHolder param1ViewHolder) {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual isScrap : ()Z
      //   4: istore_2
      //   5: iconst_1
      //   6: istore_3
      //   7: iconst_0
      //   8: istore #4
      //   10: iload_2
      //   11: ifne -> 283
      //   14: aload_1
      //   15: getfield itemView : Landroid/view/View;
      //   18: invokevirtual getParent : ()Landroid/view/ViewParent;
      //   21: ifnull -> 27
      //   24: goto -> 283
      //   27: aload_1
      //   28: invokevirtual isTmpDetached : ()Z
      //   31: ifne -> 245
      //   34: aload_1
      //   35: invokevirtual shouldIgnore : ()Z
      //   38: ifne -> 234
      //   41: aload_1
      //   42: invokestatic access$4700 : (Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;)Z
      //   45: istore_3
      //   46: aload_0
      //   47: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   50: invokestatic access$3100 : (Lorg/jar/support/v7/widget/RecyclerView;)Lorg/jar/support/v7/widget/RecyclerView$Adapter;
      //   53: ifnull -> 80
      //   56: iload_3
      //   57: ifeq -> 80
      //   60: aload_0
      //   61: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   64: invokestatic access$3100 : (Lorg/jar/support/v7/widget/RecyclerView;)Lorg/jar/support/v7/widget/RecyclerView$Adapter;
      //   67: aload_1
      //   68: invokevirtual onFailedToRecycleView : (Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;)Z
      //   71: ifeq -> 80
      //   74: iconst_1
      //   75: istore #5
      //   77: goto -> 83
      //   80: iconst_0
      //   81: istore #5
      //   83: iload #5
      //   85: ifne -> 104
      //   88: aload_1
      //   89: invokevirtual isRecyclable : ()Z
      //   92: ifeq -> 98
      //   95: goto -> 104
      //   98: iconst_0
      //   99: istore #6
      //   101: goto -> 203
      //   104: aload_1
      //   105: bipush #14
      //   107: invokevirtual hasAnyOfTheFlags : (I)Z
      //   110: ifne -> 179
      //   113: aload_0
      //   114: getfield mCachedViews : Ljava/util/ArrayList;
      //   117: invokevirtual size : ()I
      //   120: istore #6
      //   122: iload #6
      //   124: istore #5
      //   126: iload #6
      //   128: aload_0
      //   129: getfield mViewCacheMax : I
      //   132: if_icmplt -> 155
      //   135: iload #6
      //   137: istore #5
      //   139: iload #6
      //   141: ifle -> 155
      //   144: aload_0
      //   145: iconst_0
      //   146: invokevirtual recycleCachedViewAt : (I)V
      //   149: iload #6
      //   151: iconst_1
      //   152: isub
      //   153: istore #5
      //   155: iload #5
      //   157: aload_0
      //   158: getfield mViewCacheMax : I
      //   161: if_icmpge -> 179
      //   164: aload_0
      //   165: getfield mCachedViews : Ljava/util/ArrayList;
      //   168: aload_1
      //   169: invokevirtual add : (Ljava/lang/Object;)Z
      //   172: pop
      //   173: iconst_1
      //   174: istore #5
      //   176: goto -> 182
      //   179: iconst_0
      //   180: istore #5
      //   182: iload #5
      //   184: istore #6
      //   186: iload #5
      //   188: ifne -> 203
      //   191: aload_0
      //   192: aload_1
      //   193: invokevirtual addViewHolderToRecycledViewPool : (Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;)V
      //   196: iconst_1
      //   197: istore #4
      //   199: iload #5
      //   201: istore #6
      //   203: aload_0
      //   204: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   207: getfield mViewInfoStore : Lorg/jar/support/v7/widget/ViewInfoStore;
      //   210: aload_1
      //   211: invokevirtual removeViewHolder : (Lorg/jar/support/v7/widget/RecyclerView$ViewHolder;)V
      //   214: iload #6
      //   216: ifne -> 233
      //   219: iload #4
      //   221: ifne -> 233
      //   224: iload_3
      //   225: ifeq -> 233
      //   228: aload_1
      //   229: aconst_null
      //   230: putfield mOwnerRecyclerView : Lorg/jar/support/v7/widget/RecyclerView;
      //   233: return
      //   234: new java/lang/IllegalArgumentException
      //   237: dup
      //   238: ldc_w 'Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.'
      //   241: invokespecial <init> : (Ljava/lang/String;)V
      //   244: athrow
      //   245: new java/lang/StringBuilder
      //   248: dup
      //   249: invokespecial <init> : ()V
      //   252: astore #7
      //   254: aload #7
      //   256: ldc_w 'Tmp detached view should be removed from RecyclerView before it can be recycled: '
      //   259: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   262: pop
      //   263: aload #7
      //   265: aload_1
      //   266: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   269: pop
      //   270: new java/lang/IllegalArgumentException
      //   273: dup
      //   274: aload #7
      //   276: invokevirtual toString : ()Ljava/lang/String;
      //   279: invokespecial <init> : (Ljava/lang/String;)V
      //   282: athrow
      //   283: new java/lang/StringBuilder
      //   286: dup
      //   287: invokespecial <init> : ()V
      //   290: astore #7
      //   292: aload #7
      //   294: ldc_w 'Scrapped or attached views may not be recycled. isScrap:'
      //   297: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   300: pop
      //   301: aload #7
      //   303: aload_1
      //   304: invokevirtual isScrap : ()Z
      //   307: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   310: pop
      //   311: aload #7
      //   313: ldc_w ' isAttached:'
      //   316: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   319: pop
      //   320: aload_1
      //   321: getfield itemView : Landroid/view/View;
      //   324: invokevirtual getParent : ()Landroid/view/ViewParent;
      //   327: ifnull -> 333
      //   330: goto -> 335
      //   333: iconst_0
      //   334: istore_3
      //   335: aload #7
      //   337: iload_3
      //   338: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   341: pop
      //   342: new java/lang/IllegalArgumentException
      //   345: dup
      //   346: aload #7
      //   348: invokevirtual toString : ()Ljava/lang/String;
      //   351: invokespecial <init> : (Ljava/lang/String;)V
      //   354: athrow
    }
    
    void recycleViewInternal(View param1View) {
      recycleViewHolderInternal(RecyclerView.getChildViewHolderInt(param1View));
    }
    
    void scrapView(View param1View) {
      RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(param1View);
      if (viewHolder.hasAnyOfTheFlags(12) || !viewHolder.isUpdated() || RecyclerView.this.canReuseUpdatedViewHolder(viewHolder)) {
        if (!viewHolder.isInvalid() || viewHolder.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
          viewHolder.setScrapContainer(this, false);
          this.mAttachedScrap.add(viewHolder);
          return;
        } 
        throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
      } 
      if (this.mChangedScrap == null)
        this.mChangedScrap = new ArrayList<RecyclerView.ViewHolder>(); 
      viewHolder.setScrapContainer(this, true);
      this.mChangedScrap.add(viewHolder);
    }
    
    void setAdapterPositionsAsUnknown() {
      int i = this.mCachedViews.size();
      for (byte b = 0; b < i; b++) {
        RecyclerView.ViewHolder viewHolder = this.mCachedViews.get(b);
        if (viewHolder != null)
          viewHolder.addFlags(512); 
      } 
    }
    
    void setRecycledViewPool(RecyclerView.RecycledViewPool param1RecycledViewPool) {
      if (this.mRecyclerPool != null)
        this.mRecyclerPool.detach(); 
      this.mRecyclerPool = param1RecycledViewPool;
      if (param1RecycledViewPool != null)
        this.mRecyclerPool.attach(RecyclerView.this.getAdapter()); 
    }
    
    void setViewCacheExtension(RecyclerView.ViewCacheExtension param1ViewCacheExtension) {
      this.mViewCacheExtension = param1ViewCacheExtension;
    }
    
    public void setViewCacheSize(int param1Int) {
      this.mViewCacheMax = param1Int;
      for (int i = this.mCachedViews.size() - 1; i >= 0 && this.mCachedViews.size() > param1Int; i--)
        recycleCachedViewAt(i); 
    }
    
    void unscrapView(RecyclerView.ViewHolder param1ViewHolder) {
      if (param1ViewHolder.mInChangeScrap) {
        this.mChangedScrap.remove(param1ViewHolder);
      } else {
        this.mAttachedScrap.remove(param1ViewHolder);
      } 
      RecyclerView.ViewHolder.access$4802(param1ViewHolder, null);
      RecyclerView.ViewHolder.access$4902(param1ViewHolder, false);
      param1ViewHolder.clearReturnedFromScrapFlag();
    }
    
    boolean validateViewHolderForOffsetPosition(RecyclerView.ViewHolder param1ViewHolder) {
      if (param1ViewHolder.isRemoved())
        return RecyclerView.this.mState.isPreLayout(); 
      if (param1ViewHolder.mPosition >= 0 && param1ViewHolder.mPosition < RecyclerView.this.mAdapter.getItemCount()) {
        boolean bool = RecyclerView.this.mState.isPreLayout();
        boolean bool1 = false;
        if (!bool && RecyclerView.this.mAdapter.getItemViewType(param1ViewHolder.mPosition) != param1ViewHolder.getItemViewType())
          return false; 
        if (RecyclerView.this.mAdapter.hasStableIds()) {
          if (param1ViewHolder.getItemId() == RecyclerView.this.mAdapter.getItemId(param1ViewHolder.mPosition))
            bool1 = true; 
          return bool1;
        } 
        return true;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Inconsistency detected. Invalid view holder adapter position");
      stringBuilder.append(param1ViewHolder);
      throw new IndexOutOfBoundsException(stringBuilder.toString());
    }
    
    void viewRangeUpdate(int param1Int1, int param1Int2) {
      for (int i = this.mCachedViews.size() - 1; i >= 0; i--) {
        RecyclerView.ViewHolder viewHolder = this.mCachedViews.get(i);
        if (viewHolder != null) {
          int j = viewHolder.getLayoutPosition();
          if (j >= param1Int1 && j < param1Int2 + param1Int1) {
            viewHolder.addFlags(2);
            recycleCachedViewAt(i);
          } 
        } 
      } 
    }
  }
  
  public static interface RecyclerListener {
    void onViewRecycled(RecyclerView.ViewHolder param1ViewHolder);
  }
  
  private class RecyclerViewDataObserver extends AdapterDataObserver {
    private RecyclerViewDataObserver() {}
    
    public void onChanged() {
      RecyclerView.this.assertNotInLayoutOrScroll((String)null);
      if (RecyclerView.this.mAdapter.hasStableIds()) {
        RecyclerView.State.access$1802(RecyclerView.this.mState, true);
        RecyclerView.this.setDataSetChangedAfterLayout();
      } else {
        RecyclerView.State.access$1802(RecyclerView.this.mState, true);
        RecyclerView.this.setDataSetChangedAfterLayout();
      } 
      if (!RecyclerView.this.mAdapterHelper.hasPendingUpdates())
        RecyclerView.this.requestLayout(); 
    }
    
    public void onItemRangeChanged(int param1Int1, int param1Int2, Object param1Object) {
      RecyclerView.this.assertNotInLayoutOrScroll((String)null);
      if (RecyclerView.this.mAdapterHelper.onItemRangeChanged(param1Int1, param1Int2, param1Object))
        triggerUpdateProcessor(); 
    }
    
    public void onItemRangeInserted(int param1Int1, int param1Int2) {
      RecyclerView.this.assertNotInLayoutOrScroll((String)null);
      if (RecyclerView.this.mAdapterHelper.onItemRangeInserted(param1Int1, param1Int2))
        triggerUpdateProcessor(); 
    }
    
    public void onItemRangeMoved(int param1Int1, int param1Int2, int param1Int3) {
      RecyclerView.this.assertNotInLayoutOrScroll((String)null);
      if (RecyclerView.this.mAdapterHelper.onItemRangeMoved(param1Int1, param1Int2, param1Int3))
        triggerUpdateProcessor(); 
    }
    
    public void onItemRangeRemoved(int param1Int1, int param1Int2) {
      RecyclerView.this.assertNotInLayoutOrScroll((String)null);
      if (RecyclerView.this.mAdapterHelper.onItemRangeRemoved(param1Int1, param1Int2))
        triggerUpdateProcessor(); 
    }
    
    void triggerUpdateProcessor() {
      if (RecyclerView.this.mPostUpdatesOnAnimation && RecyclerView.this.mHasFixedSize && RecyclerView.this.mIsAttached) {
        ViewCompat.postOnAnimation((View)RecyclerView.this, RecyclerView.this.mUpdateChildViewsRunnable);
      } else {
        RecyclerView.access$4402(RecyclerView.this, true);
        RecyclerView.this.requestLayout();
      } 
    }
  }
  
  public static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
          public RecyclerView.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
            return new RecyclerView.SavedState(param2Parcel, param2ClassLoader);
          }
          
          public RecyclerView.SavedState[] newArray(int param2Int) {
            return new RecyclerView.SavedState[param2Int];
          }
        });
    
    Parcelable mLayoutState;
    
    SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel);
      if (param1ClassLoader == null)
        param1ClassLoader = RecyclerView.LayoutManager.class.getClassLoader(); 
      this.mLayoutState = param1Parcel.readParcelable(param1ClassLoader);
    }
    
    SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    private void copyFrom(SavedState param1SavedState) {
      this.mLayoutState = param1SavedState.mLayoutState;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeParcelable(this.mLayoutState, 0);
    }
  }
  
  static final class null implements ParcelableCompatCreatorCallbacks<SavedState> {
    public RecyclerView.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new RecyclerView.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public RecyclerView.SavedState[] newArray(int param1Int) {
      return new RecyclerView.SavedState[param1Int];
    }
  }
  
  public static class SimpleOnItemTouchListener implements OnItemTouchListener {
    public boolean onInterceptTouchEvent(RecyclerView param1RecyclerView, MotionEvent param1MotionEvent) {
      return false;
    }
    
    public void onRequestDisallowInterceptTouchEvent(boolean param1Boolean) {}
    
    public void onTouchEvent(RecyclerView param1RecyclerView, MotionEvent param1MotionEvent) {}
  }
  
  public static abstract class SmoothScroller {
    private RecyclerView.LayoutManager mLayoutManager;
    
    private boolean mPendingInitialRun;
    
    private RecyclerView mRecyclerView;
    
    private final Action mRecyclingAction = new Action(0, 0);
    
    private boolean mRunning;
    
    private int mTargetPosition = -1;
    
    private View mTargetView;
    
    private void onAnimation(int param1Int1, int param1Int2) {
      RecyclerView recyclerView = this.mRecyclerView;
      if (!this.mRunning || this.mTargetPosition == -1 || recyclerView == null)
        stop(); 
      this.mPendingInitialRun = false;
      if (this.mTargetView != null)
        if (getChildPosition(this.mTargetView) == this.mTargetPosition) {
          onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
          this.mRecyclingAction.runIfNecessary(recyclerView);
          stop();
        } else {
          Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
          this.mTargetView = null;
        }  
      if (this.mRunning) {
        onSeekTargetStep(param1Int1, param1Int2, recyclerView.mState, this.mRecyclingAction);
        boolean bool = this.mRecyclingAction.hasJumpTarget();
        this.mRecyclingAction.runIfNecessary(recyclerView);
        if (bool)
          if (this.mRunning) {
            this.mPendingInitialRun = true;
            recyclerView.mViewFlinger.postOnAnimation();
          } else {
            stop();
          }  
      } 
    }
    
    public View findViewByPosition(int param1Int) {
      return this.mRecyclerView.mLayout.findViewByPosition(param1Int);
    }
    
    public int getChildCount() {
      return this.mRecyclerView.mLayout.getChildCount();
    }
    
    public int getChildPosition(View param1View) {
      return this.mRecyclerView.getChildLayoutPosition(param1View);
    }
    
    @Nullable
    public RecyclerView.LayoutManager getLayoutManager() {
      return this.mLayoutManager;
    }
    
    public int getTargetPosition() {
      return this.mTargetPosition;
    }
    
    @Deprecated
    public void instantScrollToPosition(int param1Int) {
      this.mRecyclerView.scrollToPosition(param1Int);
    }
    
    public boolean isPendingInitialRun() {
      return this.mPendingInitialRun;
    }
    
    public boolean isRunning() {
      return this.mRunning;
    }
    
    protected void normalize(PointF param1PointF) {
      double d1 = Math.sqrt((param1PointF.x * param1PointF.x + param1PointF.y * param1PointF.y));
      double d2 = param1PointF.x;
      Double.isNaN(d2);
      param1PointF.x = (float)(d2 / d1);
      d2 = param1PointF.y;
      Double.isNaN(d2);
      param1PointF.y = (float)(d2 / d1);
    }
    
    protected void onChildAttachedToWindow(View param1View) {
      if (getChildPosition(param1View) == getTargetPosition())
        this.mTargetView = param1View; 
    }
    
    protected abstract void onSeekTargetStep(int param1Int1, int param1Int2, RecyclerView.State param1State, Action param1Action);
    
    protected abstract void onStart();
    
    protected abstract void onStop();
    
    protected abstract void onTargetFound(View param1View, RecyclerView.State param1State, Action param1Action);
    
    public void setTargetPosition(int param1Int) {
      this.mTargetPosition = param1Int;
    }
    
    void start(RecyclerView param1RecyclerView, RecyclerView.LayoutManager param1LayoutManager) {
      this.mRecyclerView = param1RecyclerView;
      this.mLayoutManager = param1LayoutManager;
      if (this.mTargetPosition != -1) {
        RecyclerView.State.access$5702(this.mRecyclerView.mState, this.mTargetPosition);
        this.mRunning = true;
        this.mPendingInitialRun = true;
        this.mTargetView = findViewByPosition(getTargetPosition());
        onStart();
        this.mRecyclerView.mViewFlinger.postOnAnimation();
        return;
      } 
      throw new IllegalArgumentException("Invalid target position");
    }
    
    protected final void stop() {
      if (!this.mRunning)
        return; 
      onStop();
      RecyclerView.State.access$5702(this.mRecyclerView.mState, -1);
      this.mTargetView = null;
      this.mTargetPosition = -1;
      this.mPendingInitialRun = false;
      this.mRunning = false;
      this.mLayoutManager.onSmoothScrollerStopped(this);
      this.mLayoutManager = null;
      this.mRecyclerView = null;
    }
    
    public static class Action {
      public static final int UNDEFINED_DURATION = -2147483648;
      
      private boolean changed = false;
      
      private int consecutiveUpdates = 0;
      
      private int mDuration;
      
      private int mDx;
      
      private int mDy;
      
      private Interpolator mInterpolator;
      
      private int mJumpToPosition = -1;
      
      public Action(int param2Int1, int param2Int2) {
        this(param2Int1, param2Int2, -2147483648, null);
      }
      
      public Action(int param2Int1, int param2Int2, int param2Int3) {
        this(param2Int1, param2Int2, param2Int3, null);
      }
      
      public Action(int param2Int1, int param2Int2, int param2Int3, Interpolator param2Interpolator) {
        this.mDx = param2Int1;
        this.mDy = param2Int2;
        this.mDuration = param2Int3;
        this.mInterpolator = param2Interpolator;
      }
      
      private void runIfNecessary(RecyclerView param2RecyclerView) {
        if (this.mJumpToPosition >= 0) {
          int i = this.mJumpToPosition;
          this.mJumpToPosition = -1;
          param2RecyclerView.jumpToPositionForSmoothScroller(i);
          this.changed = false;
          return;
        } 
        if (this.changed) {
          validate();
          if (this.mInterpolator == null) {
            if (this.mDuration == Integer.MIN_VALUE) {
              param2RecyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy);
            } else {
              param2RecyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration);
            } 
          } else {
            param2RecyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
          } 
          this.consecutiveUpdates++;
          if (this.consecutiveUpdates > 10)
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary"); 
          this.changed = false;
        } else {
          this.consecutiveUpdates = 0;
        } 
      }
      
      private void validate() {
        if (this.mInterpolator == null || this.mDuration >= 1) {
          if (this.mDuration >= 1)
            return; 
          throw new IllegalStateException("Scroll duration must be a positive number");
        } 
        throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
      }
      
      public int getDuration() {
        return this.mDuration;
      }
      
      public int getDx() {
        return this.mDx;
      }
      
      public int getDy() {
        return this.mDy;
      }
      
      public Interpolator getInterpolator() {
        return this.mInterpolator;
      }
      
      boolean hasJumpTarget() {
        boolean bool;
        if (this.mJumpToPosition >= 0) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      }
      
      public void jumpTo(int param2Int) {
        this.mJumpToPosition = param2Int;
      }
      
      public void setDuration(int param2Int) {
        this.changed = true;
        this.mDuration = param2Int;
      }
      
      public void setDx(int param2Int) {
        this.changed = true;
        this.mDx = param2Int;
      }
      
      public void setDy(int param2Int) {
        this.changed = true;
        this.mDy = param2Int;
      }
      
      public void setInterpolator(Interpolator param2Interpolator) {
        this.changed = true;
        this.mInterpolator = param2Interpolator;
      }
      
      public void update(int param2Int1, int param2Int2, int param2Int3, Interpolator param2Interpolator) {
        this.mDx = param2Int1;
        this.mDy = param2Int2;
        this.mDuration = param2Int3;
        this.mInterpolator = param2Interpolator;
        this.changed = true;
      }
    }
  }
  
  public static class Action {
    public static final int UNDEFINED_DURATION = -2147483648;
    
    private boolean changed = false;
    
    private int consecutiveUpdates = 0;
    
    private int mDuration;
    
    private int mDx;
    
    private int mDy;
    
    private Interpolator mInterpolator;
    
    private int mJumpToPosition = -1;
    
    public Action(int param1Int1, int param1Int2) {
      this(param1Int1, param1Int2, -2147483648, null);
    }
    
    public Action(int param1Int1, int param1Int2, int param1Int3) {
      this(param1Int1, param1Int2, param1Int3, null);
    }
    
    public Action(int param1Int1, int param1Int2, int param1Int3, Interpolator param1Interpolator) {
      this.mDx = param1Int1;
      this.mDy = param1Int2;
      this.mDuration = param1Int3;
      this.mInterpolator = param1Interpolator;
    }
    
    private void runIfNecessary(RecyclerView param1RecyclerView) {
      if (this.mJumpToPosition >= 0) {
        int i = this.mJumpToPosition;
        this.mJumpToPosition = -1;
        param1RecyclerView.jumpToPositionForSmoothScroller(i);
        this.changed = false;
        return;
      } 
      if (this.changed) {
        validate();
        if (this.mInterpolator == null) {
          if (this.mDuration == Integer.MIN_VALUE) {
            param1RecyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy);
          } else {
            param1RecyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration);
          } 
        } else {
          param1RecyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
        } 
        this.consecutiveUpdates++;
        if (this.consecutiveUpdates > 10)
          Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary"); 
        this.changed = false;
      } else {
        this.consecutiveUpdates = 0;
      } 
    }
    
    private void validate() {
      if (this.mInterpolator == null || this.mDuration >= 1) {
        if (this.mDuration >= 1)
          return; 
        throw new IllegalStateException("Scroll duration must be a positive number");
      } 
      throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
    }
    
    public int getDuration() {
      return this.mDuration;
    }
    
    public int getDx() {
      return this.mDx;
    }
    
    public int getDy() {
      return this.mDy;
    }
    
    public Interpolator getInterpolator() {
      return this.mInterpolator;
    }
    
    boolean hasJumpTarget() {
      boolean bool;
      if (this.mJumpToPosition >= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void jumpTo(int param1Int) {
      this.mJumpToPosition = param1Int;
    }
    
    public void setDuration(int param1Int) {
      this.changed = true;
      this.mDuration = param1Int;
    }
    
    public void setDx(int param1Int) {
      this.changed = true;
      this.mDx = param1Int;
    }
    
    public void setDy(int param1Int) {
      this.changed = true;
      this.mDy = param1Int;
    }
    
    public void setInterpolator(Interpolator param1Interpolator) {
      this.changed = true;
      this.mInterpolator = param1Interpolator;
    }
    
    public void update(int param1Int1, int param1Int2, int param1Int3, Interpolator param1Interpolator) {
      this.mDx = param1Int1;
      this.mDy = param1Int2;
      this.mDuration = param1Int3;
      this.mInterpolator = param1Interpolator;
      this.changed = true;
    }
  }
  
  public static class State {
    static final int STEP_ANIMATIONS = 4;
    
    static final int STEP_LAYOUT = 2;
    
    static final int STEP_START = 1;
    
    private SparseArray<Object> mData;
    
    private int mDeletedInvisibleItemCountSincePreviousLayout = 0;
    
    long mFocusedItemId;
    
    int mFocusedItemPosition;
    
    int mFocusedSubChildId;
    
    private boolean mInPreLayout = false;
    
    private boolean mIsMeasuring = false;
    
    int mItemCount = 0;
    
    private int mLayoutStep = 1;
    
    private int mPreviousLayoutItemCount = 0;
    
    private boolean mRunPredictiveAnimations = false;
    
    private boolean mRunSimpleAnimations = false;
    
    private boolean mStructureChanged = false;
    
    private int mTargetPosition = -1;
    
    private boolean mTrackOldChangeHolders = false;
    
    void assertLayoutStep(int param1Int) {
      if ((this.mLayoutStep & param1Int) != 0)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Layout state should be one of ");
      stringBuilder.append(Integer.toBinaryString(param1Int));
      stringBuilder.append(" but it is ");
      stringBuilder.append(Integer.toBinaryString(this.mLayoutStep));
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public boolean didStructureChange() {
      return this.mStructureChanged;
    }
    
    public <T> T get(int param1Int) {
      return (T)((this.mData == null) ? null : this.mData.get(param1Int));
    }
    
    public int getItemCount() {
      int i;
      if (this.mInPreLayout) {
        i = this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
      } else {
        i = this.mItemCount;
      } 
      return i;
    }
    
    public int getTargetScrollPosition() {
      return this.mTargetPosition;
    }
    
    public boolean hasTargetScrollPosition() {
      boolean bool;
      if (this.mTargetPosition != -1) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean isMeasuring() {
      return this.mIsMeasuring;
    }
    
    public boolean isPreLayout() {
      return this.mInPreLayout;
    }
    
    public void put(int param1Int, Object param1Object) {
      if (this.mData == null)
        this.mData = new SparseArray(); 
      this.mData.put(param1Int, param1Object);
    }
    
    public void remove(int param1Int) {
      if (this.mData == null)
        return; 
      this.mData.remove(param1Int);
    }
    
    State reset() {
      this.mTargetPosition = -1;
      if (this.mData != null)
        this.mData.clear(); 
      this.mItemCount = 0;
      this.mStructureChanged = false;
      this.mIsMeasuring = false;
      return this;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("State{mTargetPosition=");
      stringBuilder.append(this.mTargetPosition);
      stringBuilder.append(", mData=");
      stringBuilder.append(this.mData);
      stringBuilder.append(", mItemCount=");
      stringBuilder.append(this.mItemCount);
      stringBuilder.append(", mPreviousLayoutItemCount=");
      stringBuilder.append(this.mPreviousLayoutItemCount);
      stringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
      stringBuilder.append(this.mDeletedInvisibleItemCountSincePreviousLayout);
      stringBuilder.append(", mStructureChanged=");
      stringBuilder.append(this.mStructureChanged);
      stringBuilder.append(", mInPreLayout=");
      stringBuilder.append(this.mInPreLayout);
      stringBuilder.append(", mRunSimpleAnimations=");
      stringBuilder.append(this.mRunSimpleAnimations);
      stringBuilder.append(", mRunPredictiveAnimations=");
      stringBuilder.append(this.mRunPredictiveAnimations);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
    
    public boolean willRunPredictiveAnimations() {
      return this.mRunPredictiveAnimations;
    }
    
    public boolean willRunSimpleAnimations() {
      return this.mRunSimpleAnimations;
    }
    
    @Retention(RetentionPolicy.SOURCE)
    static @interface LayoutState {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  static @interface LayoutState {}
  
  public static abstract class ViewCacheExtension {
    public abstract View getViewForPositionAndType(RecyclerView.Recycler param1Recycler, int param1Int1, int param1Int2);
  }
  
  private class ViewFlinger implements Runnable {
    private boolean mEatRunOnAnimationRequest = false;
    
    private Interpolator mInterpolator = RecyclerView.sQuinticInterpolator;
    
    private int mLastFlingX;
    
    private int mLastFlingY;
    
    private boolean mReSchedulePostAnimationCallback = false;
    
    private ScrollerCompat mScroller = ScrollerCompat.create(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
    
    private int computeScrollDuration(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      boolean bool;
      int i = Math.abs(param1Int1);
      int j = Math.abs(param1Int2);
      if (i > j) {
        bool = true;
      } else {
        bool = false;
      } 
      param1Int3 = (int)Math.sqrt((param1Int3 * param1Int3 + param1Int4 * param1Int4));
      param1Int2 = (int)Math.sqrt((param1Int1 * param1Int1 + param1Int2 * param1Int2));
      if (bool) {
        param1Int1 = RecyclerView.this.getWidth();
      } else {
        param1Int1 = RecyclerView.this.getHeight();
      } 
      param1Int4 = param1Int1 / 2;
      float f1 = param1Int2;
      float f2 = param1Int1;
      float f3 = Math.min(1.0F, f1 * 1.0F / f2);
      f1 = param1Int4;
      f3 = distanceInfluenceForSnapDuration(f3);
      if (param1Int3 > 0) {
        param1Int1 = Math.round(Math.abs((f1 + f3 * f1) / param1Int3) * 1000.0F) * 4;
      } else {
        if (bool) {
          param1Int1 = i;
        } else {
          param1Int1 = j;
        } 
        param1Int1 = (int)((param1Int1 / f2 + 1.0F) * 300.0F);
      } 
      return Math.min(param1Int1, 2000);
    }
    
    private void disableRunOnAnimationRequests() {
      this.mReSchedulePostAnimationCallback = false;
      this.mEatRunOnAnimationRequest = true;
    }
    
    private float distanceInfluenceForSnapDuration(float param1Float) {
      double d = (param1Float - 0.5F);
      Double.isNaN(d);
      return (float)Math.sin((float)(d * 0.4712389167638204D));
    }
    
    private void enableRunOnAnimationRequests() {
      this.mEatRunOnAnimationRequest = false;
      if (this.mReSchedulePostAnimationCallback)
        postOnAnimation(); 
    }
    
    public void fling(int param1Int1, int param1Int2) {
      RecyclerView.this.setScrollState(2);
      this.mLastFlingY = 0;
      this.mLastFlingX = 0;
      this.mScroller.fling(0, 0, param1Int1, param1Int2, -2147483648, 2147483647, -2147483648, 2147483647);
      postOnAnimation();
    }
    
    void postOnAnimation() {
      if (this.mEatRunOnAnimationRequest) {
        this.mReSchedulePostAnimationCallback = true;
      } else {
        RecyclerView.this.removeCallbacks(this);
        ViewCompat.postOnAnimation((View)RecyclerView.this, this);
      } 
    }
    
    public void run() {
      // Byte code:
      //   0: aload_0
      //   1: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   4: getfield mLayout : Lorg/jar/support/v7/widget/RecyclerView$LayoutManager;
      //   7: ifnonnull -> 15
      //   10: aload_0
      //   11: invokevirtual stop : ()V
      //   14: return
      //   15: aload_0
      //   16: invokespecial disableRunOnAnimationRequests : ()V
      //   19: aload_0
      //   20: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   23: invokestatic access$400 : (Lorg/jar/support/v7/widget/RecyclerView;)V
      //   26: aload_0
      //   27: getfield mScroller : Lorg/jar/support/v4/widget/ScrollerCompat;
      //   30: astore_1
      //   31: aload_0
      //   32: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   35: getfield mLayout : Lorg/jar/support/v7/widget/RecyclerView$LayoutManager;
      //   38: getfield mSmoothScroller : Lorg/jar/support/v7/widget/RecyclerView$SmoothScroller;
      //   41: astore_2
      //   42: aload_1
      //   43: invokevirtual computeScrollOffset : ()Z
      //   46: ifeq -> 796
      //   49: aload_1
      //   50: invokevirtual getCurrX : ()I
      //   53: istore_3
      //   54: aload_1
      //   55: invokevirtual getCurrY : ()I
      //   58: istore #4
      //   60: iload_3
      //   61: aload_0
      //   62: getfield mLastFlingX : I
      //   65: isub
      //   66: istore #5
      //   68: iload #4
      //   70: aload_0
      //   71: getfield mLastFlingY : I
      //   74: isub
      //   75: istore #6
      //   77: aload_0
      //   78: iload_3
      //   79: putfield mLastFlingX : I
      //   82: aload_0
      //   83: iload #4
      //   85: putfield mLastFlingY : I
      //   88: aload_0
      //   89: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   92: invokestatic access$3100 : (Lorg/jar/support/v7/widget/RecyclerView;)Lorg/jar/support/v7/widget/RecyclerView$Adapter;
      //   95: ifnull -> 429
      //   98: aload_0
      //   99: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   102: invokevirtual eatRequestLayout : ()V
      //   105: aload_0
      //   106: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   109: invokestatic access$3200 : (Lorg/jar/support/v7/widget/RecyclerView;)V
      //   112: ldc 'RV Scroll'
      //   114: invokestatic beginSection : (Ljava/lang/String;)V
      //   117: iload #5
      //   119: ifeq -> 160
      //   122: aload_0
      //   123: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   126: getfield mLayout : Lorg/jar/support/v7/widget/RecyclerView$LayoutManager;
      //   129: iload #5
      //   131: aload_0
      //   132: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   135: getfield mRecycler : Lorg/jar/support/v7/widget/RecyclerView$Recycler;
      //   138: aload_0
      //   139: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   142: getfield mState : Lorg/jar/support/v7/widget/RecyclerView$State;
      //   145: invokevirtual scrollHorizontallyBy : (ILorg/jar/support/v7/widget/RecyclerView$Recycler;Lorg/jar/support/v7/widget/RecyclerView$State;)I
      //   148: istore #7
      //   150: iload #5
      //   152: iload #7
      //   154: isub
      //   155: istore #8
      //   157: goto -> 166
      //   160: iconst_0
      //   161: istore #7
      //   163: iconst_0
      //   164: istore #8
      //   166: iload #6
      //   168: ifeq -> 209
      //   171: aload_0
      //   172: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   175: getfield mLayout : Lorg/jar/support/v7/widget/RecyclerView$LayoutManager;
      //   178: iload #6
      //   180: aload_0
      //   181: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   184: getfield mRecycler : Lorg/jar/support/v7/widget/RecyclerView$Recycler;
      //   187: aload_0
      //   188: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   191: getfield mState : Lorg/jar/support/v7/widget/RecyclerView$State;
      //   194: invokevirtual scrollVerticallyBy : (ILorg/jar/support/v7/widget/RecyclerView$Recycler;Lorg/jar/support/v7/widget/RecyclerView$State;)I
      //   197: istore #9
      //   199: iload #6
      //   201: iload #9
      //   203: isub
      //   204: istore #10
      //   206: goto -> 215
      //   209: iconst_0
      //   210: istore #9
      //   212: iconst_0
      //   213: istore #10
      //   215: invokestatic endSection : ()V
      //   218: aload_0
      //   219: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   222: invokestatic access$3300 : (Lorg/jar/support/v7/widget/RecyclerView;)V
      //   225: aload_0
      //   226: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   229: invokestatic access$3400 : (Lorg/jar/support/v7/widget/RecyclerView;)V
      //   232: aload_0
      //   233: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   236: iconst_0
      //   237: invokevirtual resumeRequestLayout : (Z)V
      //   240: iload #7
      //   242: istore #11
      //   244: iload #8
      //   246: istore #12
      //   248: iload #9
      //   250: istore #13
      //   252: iload #10
      //   254: istore #14
      //   256: aload_2
      //   257: ifnull -> 441
      //   260: iload #7
      //   262: istore #11
      //   264: iload #8
      //   266: istore #12
      //   268: iload #9
      //   270: istore #13
      //   272: iload #10
      //   274: istore #14
      //   276: aload_2
      //   277: invokevirtual isPendingInitialRun : ()Z
      //   280: ifne -> 441
      //   283: iload #7
      //   285: istore #11
      //   287: iload #8
      //   289: istore #12
      //   291: iload #9
      //   293: istore #13
      //   295: iload #10
      //   297: istore #14
      //   299: aload_2
      //   300: invokevirtual isRunning : ()Z
      //   303: ifeq -> 441
      //   306: aload_0
      //   307: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   310: getfield mState : Lorg/jar/support/v7/widget/RecyclerView$State;
      //   313: invokevirtual getItemCount : ()I
      //   316: istore #11
      //   318: iload #11
      //   320: ifne -> 346
      //   323: aload_2
      //   324: invokevirtual stop : ()V
      //   327: iload #7
      //   329: istore #11
      //   331: iload #8
      //   333: istore #12
      //   335: iload #9
      //   337: istore #13
      //   339: iload #10
      //   341: istore #14
      //   343: goto -> 441
      //   346: aload_2
      //   347: invokevirtual getTargetPosition : ()I
      //   350: iload #11
      //   352: if_icmplt -> 396
      //   355: aload_2
      //   356: iload #11
      //   358: iconst_1
      //   359: isub
      //   360: invokevirtual setTargetPosition : (I)V
      //   363: aload_2
      //   364: iload #5
      //   366: iload #8
      //   368: isub
      //   369: iload #6
      //   371: iload #10
      //   373: isub
      //   374: invokestatic access$3500 : (Lorg/jar/support/v7/widget/RecyclerView$SmoothScroller;II)V
      //   377: iload #7
      //   379: istore #11
      //   381: iload #8
      //   383: istore #12
      //   385: iload #9
      //   387: istore #13
      //   389: iload #10
      //   391: istore #14
      //   393: goto -> 441
      //   396: aload_2
      //   397: iload #5
      //   399: iload #8
      //   401: isub
      //   402: iload #6
      //   404: iload #10
      //   406: isub
      //   407: invokestatic access$3500 : (Lorg/jar/support/v7/widget/RecyclerView$SmoothScroller;II)V
      //   410: iload #7
      //   412: istore #11
      //   414: iload #8
      //   416: istore #12
      //   418: iload #9
      //   420: istore #13
      //   422: iload #10
      //   424: istore #14
      //   426: goto -> 441
      //   429: iconst_0
      //   430: istore #11
      //   432: iconst_0
      //   433: istore #12
      //   435: iconst_0
      //   436: istore #13
      //   438: iconst_0
      //   439: istore #14
      //   441: aload_0
      //   442: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   445: invokestatic access$3600 : (Lorg/jar/support/v7/widget/RecyclerView;)Ljava/util/ArrayList;
      //   448: invokevirtual isEmpty : ()Z
      //   451: ifne -> 461
      //   454: aload_0
      //   455: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   458: invokevirtual invalidate : ()V
      //   461: aload_0
      //   462: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   465: invokestatic getOverScrollMode : (Landroid/view/View;)I
      //   468: iconst_2
      //   469: if_icmpeq -> 483
      //   472: aload_0
      //   473: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   476: iload #5
      //   478: iload #6
      //   480: invokestatic access$3700 : (Lorg/jar/support/v7/widget/RecyclerView;II)V
      //   483: iload #12
      //   485: ifne -> 493
      //   488: iload #14
      //   490: ifeq -> 628
      //   493: aload_1
      //   494: invokevirtual getCurrVelocity : ()F
      //   497: f2i
      //   498: istore #8
      //   500: iload #12
      //   502: iload_3
      //   503: if_icmpeq -> 531
      //   506: iload #12
      //   508: ifge -> 519
      //   511: iload #8
      //   513: ineg
      //   514: istore #7
      //   516: goto -> 534
      //   519: iload #12
      //   521: ifle -> 531
      //   524: iload #8
      //   526: istore #7
      //   528: goto -> 534
      //   531: iconst_0
      //   532: istore #7
      //   534: iload #14
      //   536: iload #4
      //   538: if_icmpeq -> 562
      //   541: iload #14
      //   543: ifge -> 554
      //   546: iload #8
      //   548: ineg
      //   549: istore #8
      //   551: goto -> 565
      //   554: iload #14
      //   556: ifle -> 562
      //   559: goto -> 565
      //   562: iconst_0
      //   563: istore #8
      //   565: aload_0
      //   566: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   569: invokestatic getOverScrollMode : (Landroid/view/View;)I
      //   572: iconst_2
      //   573: if_icmpeq -> 587
      //   576: aload_0
      //   577: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   580: iload #7
      //   582: iload #8
      //   584: invokevirtual absorbGlows : (II)V
      //   587: iload #7
      //   589: ifne -> 605
      //   592: iload #12
      //   594: iload_3
      //   595: if_icmpeq -> 605
      //   598: aload_1
      //   599: invokevirtual getFinalX : ()I
      //   602: ifne -> 628
      //   605: iload #8
      //   607: ifne -> 624
      //   610: iload #14
      //   612: iload #4
      //   614: if_icmpeq -> 624
      //   617: aload_1
      //   618: invokevirtual getFinalY : ()I
      //   621: ifne -> 628
      //   624: aload_1
      //   625: invokevirtual abortAnimation : ()V
      //   628: iload #11
      //   630: ifne -> 638
      //   633: iload #13
      //   635: ifeq -> 649
      //   638: aload_0
      //   639: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   642: iload #11
      //   644: iload #13
      //   646: invokevirtual dispatchOnScrolled : (II)V
      //   649: aload_0
      //   650: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   653: invokestatic access$3800 : (Lorg/jar/support/v7/widget/RecyclerView;)Z
      //   656: ifne -> 666
      //   659: aload_0
      //   660: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   663: invokevirtual invalidate : ()V
      //   666: iload #6
      //   668: ifeq -> 697
      //   671: aload_0
      //   672: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   675: getfield mLayout : Lorg/jar/support/v7/widget/RecyclerView$LayoutManager;
      //   678: invokevirtual canScrollVertically : ()Z
      //   681: ifeq -> 697
      //   684: iload #13
      //   686: iload #6
      //   688: if_icmpne -> 697
      //   691: iconst_1
      //   692: istore #7
      //   694: goto -> 700
      //   697: iconst_0
      //   698: istore #7
      //   700: iload #5
      //   702: ifeq -> 731
      //   705: aload_0
      //   706: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   709: getfield mLayout : Lorg/jar/support/v7/widget/RecyclerView$LayoutManager;
      //   712: invokevirtual canScrollHorizontally : ()Z
      //   715: ifeq -> 731
      //   718: iload #11
      //   720: iload #5
      //   722: if_icmpne -> 731
      //   725: iconst_1
      //   726: istore #8
      //   728: goto -> 734
      //   731: iconst_0
      //   732: istore #8
      //   734: iload #5
      //   736: ifne -> 744
      //   739: iload #6
      //   741: ifeq -> 763
      //   744: iload #8
      //   746: ifne -> 763
      //   749: iload #7
      //   751: ifeq -> 757
      //   754: goto -> 763
      //   757: iconst_0
      //   758: istore #7
      //   760: goto -> 766
      //   763: iconst_1
      //   764: istore #7
      //   766: aload_1
      //   767: invokevirtual isFinished : ()Z
      //   770: ifne -> 788
      //   773: iload #7
      //   775: ifne -> 781
      //   778: goto -> 788
      //   781: aload_0
      //   782: invokevirtual postOnAnimation : ()V
      //   785: goto -> 796
      //   788: aload_0
      //   789: getfield this$0 : Lorg/jar/support/v7/widget/RecyclerView;
      //   792: iconst_0
      //   793: invokestatic access$3900 : (Lorg/jar/support/v7/widget/RecyclerView;I)V
      //   796: aload_2
      //   797: ifnull -> 824
      //   800: aload_2
      //   801: invokevirtual isPendingInitialRun : ()Z
      //   804: ifeq -> 813
      //   807: aload_2
      //   808: iconst_0
      //   809: iconst_0
      //   810: invokestatic access$3500 : (Lorg/jar/support/v7/widget/RecyclerView$SmoothScroller;II)V
      //   813: aload_0
      //   814: getfield mReSchedulePostAnimationCallback : Z
      //   817: ifne -> 824
      //   820: aload_2
      //   821: invokevirtual stop : ()V
      //   824: aload_0
      //   825: invokespecial enableRunOnAnimationRequests : ()V
      //   828: return
    }
    
    public void smoothScrollBy(int param1Int1, int param1Int2) {
      smoothScrollBy(param1Int1, param1Int2, 0, 0);
    }
    
    public void smoothScrollBy(int param1Int1, int param1Int2, int param1Int3) {
      smoothScrollBy(param1Int1, param1Int2, param1Int3, RecyclerView.sQuinticInterpolator);
    }
    
    public void smoothScrollBy(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      smoothScrollBy(param1Int1, param1Int2, computeScrollDuration(param1Int1, param1Int2, param1Int3, param1Int4));
    }
    
    public void smoothScrollBy(int param1Int1, int param1Int2, int param1Int3, Interpolator param1Interpolator) {
      if (this.mInterpolator != param1Interpolator) {
        this.mInterpolator = param1Interpolator;
        this.mScroller = ScrollerCompat.create(RecyclerView.this.getContext(), param1Interpolator);
      } 
      RecyclerView.this.setScrollState(2);
      this.mLastFlingY = 0;
      this.mLastFlingX = 0;
      this.mScroller.startScroll(0, 0, param1Int1, param1Int2, param1Int3);
      postOnAnimation();
    }
    
    public void stop() {
      RecyclerView.this.removeCallbacks(this);
      this.mScroller.abortAnimation();
    }
  }
  
  public static abstract class ViewHolder {
    static final int FLAG_ADAPTER_FULLUPDATE = 1024;
    
    static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
    
    static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    
    static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
    
    static final int FLAG_BOUND = 1;
    
    static final int FLAG_IGNORE = 128;
    
    static final int FLAG_INVALID = 4;
    
    static final int FLAG_MOVED = 2048;
    
    static final int FLAG_NOT_RECYCLABLE = 16;
    
    static final int FLAG_REMOVED = 8;
    
    static final int FLAG_RETURNED_FROM_SCRAP = 32;
    
    static final int FLAG_TMP_DETACHED = 256;
    
    static final int FLAG_UPDATE = 2;
    
    private static final List<Object> FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
    
    public final View itemView;
    
    private int mFlags;
    
    private boolean mInChangeScrap = false;
    
    private int mIsRecyclableCount = 0;
    
    long mItemId = -1L;
    
    int mItemViewType = -1;
    
    int mOldPosition = -1;
    
    RecyclerView mOwnerRecyclerView;
    
    List<Object> mPayloads = null;
    
    int mPosition = -1;
    
    int mPreLayoutPosition = -1;
    
    private RecyclerView.Recycler mScrapContainer = null;
    
    ViewHolder mShadowedHolder = null;
    
    ViewHolder mShadowingHolder = null;
    
    List<Object> mUnmodifiedPayloads = null;
    
    private int mWasImportantForAccessibilityBeforeHidden = 0;
    
    public ViewHolder(View param1View) {
      if (param1View != null) {
        this.itemView = param1View;
        return;
      } 
      throw new IllegalArgumentException("itemView may not be null");
    }
    
    private void createPayloadsIfNeeded() {
      if (this.mPayloads == null) {
        this.mPayloads = new ArrayList();
        this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
      } 
    }
    
    private boolean doesTransientStatePreventRecycling() {
      boolean bool;
      if ((this.mFlags & 0x10) == 0 && ViewCompat.hasTransientState(this.itemView)) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    private void onEnteredHiddenState() {
      this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
      ViewCompat.setImportantForAccessibility(this.itemView, 4);
    }
    
    private void onLeftHiddenState() {
      ViewCompat.setImportantForAccessibility(this.itemView, this.mWasImportantForAccessibilityBeforeHidden);
      this.mWasImportantForAccessibilityBeforeHidden = 0;
    }
    
    private boolean shouldBeKeptAsChild() {
      boolean bool;
      if ((this.mFlags & 0x10) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    void addChangePayload(Object param1Object) {
      if (param1Object == null) {
        addFlags(1024);
      } else if ((0x400 & this.mFlags) == 0) {
        createPayloadsIfNeeded();
        this.mPayloads.add(param1Object);
      } 
    }
    
    void addFlags(int param1Int) {
      this.mFlags = param1Int | this.mFlags;
    }
    
    void clearOldPosition() {
      this.mOldPosition = -1;
      this.mPreLayoutPosition = -1;
    }
    
    void clearPayload() {
      if (this.mPayloads != null)
        this.mPayloads.clear(); 
      this.mFlags &= 0xFFFFFBFF;
    }
    
    void clearReturnedFromScrapFlag() {
      this.mFlags &= 0xFFFFFFDF;
    }
    
    void clearTmpDetachFlag() {
      this.mFlags &= 0xFFFFFEFF;
    }
    
    void flagRemovedAndOffsetPosition(int param1Int1, int param1Int2, boolean param1Boolean) {
      addFlags(8);
      offsetPosition(param1Int2, param1Boolean);
      this.mPosition = param1Int1;
    }
    
    public final int getAdapterPosition() {
      return (this.mOwnerRecyclerView == null) ? -1 : this.mOwnerRecyclerView.getAdapterPositionFor(this);
    }
    
    public final long getItemId() {
      return this.mItemId;
    }
    
    public final int getItemViewType() {
      return this.mItemViewType;
    }
    
    public final int getLayoutPosition() {
      int i;
      if (this.mPreLayoutPosition == -1) {
        i = this.mPosition;
      } else {
        i = this.mPreLayoutPosition;
      } 
      return i;
    }
    
    public final int getOldPosition() {
      return this.mOldPosition;
    }
    
    @Deprecated
    public final int getPosition() {
      int i;
      if (this.mPreLayoutPosition == -1) {
        i = this.mPosition;
      } else {
        i = this.mPreLayoutPosition;
      } 
      return i;
    }
    
    List<Object> getUnmodifiedPayloads() {
      return ((this.mFlags & 0x400) == 0) ? ((this.mPayloads == null || this.mPayloads.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads) : FULLUPDATE_PAYLOADS;
    }
    
    boolean hasAnyOfTheFlags(int param1Int) {
      boolean bool;
      if ((param1Int & this.mFlags) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    boolean isAdapterPositionUnknown() {
      return ((this.mFlags & 0x200) != 0 || isInvalid());
    }
    
    boolean isBound() {
      int i = this.mFlags;
      boolean bool = true;
      if ((i & 0x1) == 0)
        bool = false; 
      return bool;
    }
    
    boolean isInvalid() {
      boolean bool;
      if ((this.mFlags & 0x4) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public final boolean isRecyclable() {
      boolean bool;
      if ((this.mFlags & 0x10) == 0 && !ViewCompat.hasTransientState(this.itemView)) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    boolean isRemoved() {
      boolean bool;
      if ((this.mFlags & 0x8) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    boolean isScrap() {
      boolean bool;
      if (this.mScrapContainer != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    boolean isTmpDetached() {
      boolean bool;
      if ((this.mFlags & 0x100) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    boolean isUpdated() {
      boolean bool;
      if ((this.mFlags & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    boolean needsUpdate() {
      boolean bool;
      if ((this.mFlags & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    void offsetPosition(int param1Int, boolean param1Boolean) {
      if (this.mOldPosition == -1)
        this.mOldPosition = this.mPosition; 
      if (this.mPreLayoutPosition == -1)
        this.mPreLayoutPosition = this.mPosition; 
      if (param1Boolean)
        this.mPreLayoutPosition += param1Int; 
      this.mPosition += param1Int;
      if (this.itemView.getLayoutParams() != null)
        ((RecyclerView.LayoutParams)this.itemView.getLayoutParams()).mInsetsDirty = true; 
    }
    
    void resetInternal() {
      this.mFlags = 0;
      this.mPosition = -1;
      this.mOldPosition = -1;
      this.mItemId = -1L;
      this.mPreLayoutPosition = -1;
      this.mIsRecyclableCount = 0;
      this.mShadowedHolder = null;
      this.mShadowingHolder = null;
      clearPayload();
      this.mWasImportantForAccessibilityBeforeHidden = 0;
    }
    
    void saveOldPosition() {
      if (this.mOldPosition == -1)
        this.mOldPosition = this.mPosition; 
    }
    
    void setFlags(int param1Int1, int param1Int2) {
      this.mFlags = param1Int1 & param1Int2 | this.mFlags & (param1Int2 ^ 0xFFFFFFFF);
    }
    
    public final void setIsRecyclable(boolean param1Boolean) {
      int i;
      if (param1Boolean) {
        i = this.mIsRecyclableCount - 1;
      } else {
        i = this.mIsRecyclableCount + 1;
      } 
      this.mIsRecyclableCount = i;
      if (this.mIsRecyclableCount < 0) {
        this.mIsRecyclableCount = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
        stringBuilder.append(this);
        Log.e("View", stringBuilder.toString());
      } else if (!param1Boolean && this.mIsRecyclableCount == 1) {
        this.mFlags |= 0x10;
      } else if (param1Boolean && this.mIsRecyclableCount == 0) {
        this.mFlags &= 0xFFFFFFEF;
      } 
    }
    
    void setScrapContainer(RecyclerView.Recycler param1Recycler, boolean param1Boolean) {
      this.mScrapContainer = param1Recycler;
      this.mInChangeScrap = param1Boolean;
    }
    
    boolean shouldIgnore() {
      boolean bool;
      if ((this.mFlags & 0x80) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    void stopIgnoring() {
      this.mFlags &= 0xFFFFFF7F;
    }
    
    public String toString() {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("ViewHolder{");
      stringBuilder1.append(Integer.toHexString(hashCode()));
      stringBuilder1.append(" position=");
      stringBuilder1.append(this.mPosition);
      stringBuilder1.append(" id=");
      stringBuilder1.append(this.mItemId);
      stringBuilder1.append(", oldPos=");
      stringBuilder1.append(this.mOldPosition);
      stringBuilder1.append(", pLpos:");
      stringBuilder1.append(this.mPreLayoutPosition);
      StringBuilder stringBuilder2 = new StringBuilder(stringBuilder1.toString());
      if (isScrap()) {
        String str;
        stringBuilder2.append(" scrap ");
        if (this.mInChangeScrap) {
          str = "[changeScrap]";
        } else {
          str = "[attachedScrap]";
        } 
        stringBuilder2.append(str);
      } 
      if (isInvalid())
        stringBuilder2.append(" invalid"); 
      if (!isBound())
        stringBuilder2.append(" unbound"); 
      if (needsUpdate())
        stringBuilder2.append(" update"); 
      if (isRemoved())
        stringBuilder2.append(" removed"); 
      if (shouldIgnore())
        stringBuilder2.append(" ignored"); 
      if (isTmpDetached())
        stringBuilder2.append(" tmpDetached"); 
      if (!isRecyclable()) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(" not recyclable(");
        stringBuilder1.append(this.mIsRecyclableCount);
        stringBuilder1.append(")");
        stringBuilder2.append(stringBuilder1.toString());
      } 
      if (isAdapterPositionUnknown())
        stringBuilder2.append(" undefined adapter position"); 
      if (this.itemView.getParent() == null)
        stringBuilder2.append(" no parent"); 
      stringBuilder2.append("}");
      return stringBuilder2.toString();
    }
    
    void unScrap() {
      this.mScrapContainer.unscrapView(this);
    }
    
    boolean wasReturnedFromScrap() {
      boolean bool;
      if ((this.mFlags & 0x20) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v7\widget\RecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */