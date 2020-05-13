package org.jar.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import org.jar.support.annotation.NonNull;
import org.jar.support.annotation.Nullable;

public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager {
  private static final boolean DEBUG = false;
  
  @Deprecated
  public static final int GAP_HANDLING_LAZY = 1;
  
  public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
  
  public static final int GAP_HANDLING_NONE = 0;
  
  public static final int HORIZONTAL = 0;
  
  private static final int INVALID_OFFSET = -2147483648;
  
  private static final float MAX_SCROLL_FACTOR = 0.33333334F;
  
  public static final String TAG = "StaggeredGridLayoutManager";
  
  public static final int VERTICAL = 1;
  
  private final AnchorInfo mAnchorInfo = new AnchorInfo();
  
  private final Runnable mCheckForGapsRunnable;
  
  private int mFullSizeSpec;
  
  private int mGapStrategy = 2;
  
  private boolean mLaidOutInvalidFullSpan = false;
  
  private boolean mLastLayoutFromEnd;
  
  private boolean mLastLayoutRTL;
  
  @NonNull
  private final LayoutState mLayoutState;
  
  LazySpanLookup mLazySpanLookup = new LazySpanLookup();
  
  private int mOrientation;
  
  private SavedState mPendingSavedState;
  
  int mPendingScrollPosition = -1;
  
  int mPendingScrollPositionOffset = Integer.MIN_VALUE;
  
  @NonNull
  OrientationHelper mPrimaryOrientation;
  
  private BitSet mRemainingSpans;
  
  private boolean mReverseLayout = false;
  
  @NonNull
  OrientationHelper mSecondaryOrientation;
  
  boolean mShouldReverseLayout = false;
  
  private int mSizePerSpan;
  
  private boolean mSmoothScrollbarEnabled;
  
  private int mSpanCount = -1;
  
  private Span[] mSpans;
  
  private final Rect mTmpRect = new Rect();
  
  public StaggeredGridLayoutManager(int paramInt1, int paramInt2) {
    boolean bool = true;
    this.mSmoothScrollbarEnabled = true;
    this.mCheckForGapsRunnable = new Runnable() {
        public void run() {
          StaggeredGridLayoutManager.this.checkForGaps();
        }
      };
    this.mOrientation = paramInt2;
    setSpanCount(paramInt1);
    if (this.mGapStrategy == 0)
      bool = false; 
    setAutoMeasureEnabled(bool);
    this.mLayoutState = new LayoutState();
    createOrientationHelpers();
  }
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    boolean bool = true;
    this.mSmoothScrollbarEnabled = true;
    this.mCheckForGapsRunnable = new Runnable() {
        public void run() {
          StaggeredGridLayoutManager.this.checkForGaps();
        }
      };
    if (this.mGapStrategy == 0)
      bool = false; 
    setAutoMeasureEnabled(bool);
    this.mLayoutState = new LayoutState();
    createOrientationHelpers();
  }
  
  private void appendViewToAllSpans(View paramView) {
    for (int i = this.mSpanCount - 1; i >= 0; i--)
      this.mSpans[i].appendToSpan(paramView); 
  }
  
  private void applyPendingSavedState(AnchorInfo paramAnchorInfo) {
    if (this.mPendingSavedState.mSpanOffsetsSize > 0)
      if (this.mPendingSavedState.mSpanOffsetsSize == this.mSpanCount) {
        for (byte b = 0; b < this.mSpanCount; b++) {
          this.mSpans[b].clear();
          int i = this.mPendingSavedState.mSpanOffsets[b];
          int j = i;
          if (i != Integer.MIN_VALUE)
            if (this.mPendingSavedState.mAnchorLayoutFromEnd) {
              j = i + this.mPrimaryOrientation.getEndAfterPadding();
            } else {
              j = i + this.mPrimaryOrientation.getStartAfterPadding();
            }  
          this.mSpans[b].setLine(j);
        } 
      } else {
        this.mPendingSavedState.invalidateSpanInfo();
        this.mPendingSavedState.mAnchorPosition = this.mPendingSavedState.mVisibleAnchorPosition;
      }  
    this.mLastLayoutRTL = this.mPendingSavedState.mLastLayoutRTL;
    setReverseLayout(this.mPendingSavedState.mReverseLayout);
    resolveShouldLayoutReverse();
    if (this.mPendingSavedState.mAnchorPosition != -1) {
      this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
      paramAnchorInfo.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
    } else {
      paramAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
    } 
    if (this.mPendingSavedState.mSpanLookupSize > 1) {
      this.mLazySpanLookup.mData = this.mPendingSavedState.mSpanLookup;
      this.mLazySpanLookup.mFullSpanItems = this.mPendingSavedState.mFullSpanItems;
    } 
  }
  
  private void attachViewToSpans(View paramView, LayoutParams paramLayoutParams, LayoutState paramLayoutState) {
    if (paramLayoutState.mLayoutDirection == 1) {
      if (paramLayoutParams.mFullSpan) {
        appendViewToAllSpans(paramView);
      } else {
        paramLayoutParams.mSpan.appendToSpan(paramView);
      } 
    } else if (paramLayoutParams.mFullSpan) {
      prependViewToAllSpans(paramView);
    } else {
      paramLayoutParams.mSpan.prependToSpan(paramView);
    } 
  }
  
  private int calculateScrollDirectionForPosition(int paramInt) {
    boolean bool;
    int i = getChildCount();
    byte b = -1;
    if (i == 0) {
      if (this.mShouldReverseLayout)
        b = 1; 
      return b;
    } 
    if (paramInt < getFirstChildPosition()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool == this.mShouldReverseLayout)
      b = 1; 
    return b;
  }
  
  private boolean checkForGaps() {
    int i;
    int j;
    byte b;
    if (getChildCount() == 0 || this.mGapStrategy == 0 || !isAttachedToWindow())
      return false; 
    if (this.mShouldReverseLayout) {
      i = getLastChildPosition();
      j = getFirstChildPosition();
    } else {
      i = getFirstChildPosition();
      j = getLastChildPosition();
    } 
    if (i == 0 && hasGapsToFix() != null) {
      this.mLazySpanLookup.clear();
      requestSimpleAnimationsInNextLayout();
      requestLayout();
      return true;
    } 
    if (!this.mLaidOutInvalidFullSpan)
      return false; 
    if (this.mShouldReverseLayout) {
      b = -1;
    } else {
      b = 1;
    } 
    LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
    LazySpanLookup.FullSpanItem fullSpanItem1 = lazySpanLookup.getFirstFullSpanItemInRange(i, ++j, b, true);
    if (fullSpanItem1 == null) {
      this.mLaidOutInvalidFullSpan = false;
      this.mLazySpanLookup.forceInvalidateAfter(j);
      return false;
    } 
    LazySpanLookup.FullSpanItem fullSpanItem2 = this.mLazySpanLookup.getFirstFullSpanItemInRange(i, fullSpanItem1.mPosition, b * -1, true);
    if (fullSpanItem2 == null) {
      this.mLazySpanLookup.forceInvalidateAfter(fullSpanItem1.mPosition);
    } else {
      this.mLazySpanLookup.forceInvalidateAfter(fullSpanItem2.mPosition + 1);
    } 
    requestSimpleAnimationsInNextLayout();
    requestLayout();
    return true;
  }
  
  private boolean checkSpanForGap(Span paramSpan) {
    if (this.mShouldReverseLayout) {
      if (paramSpan.getEndLine() < this.mPrimaryOrientation.getEndAfterPadding())
        return (paramSpan.getLayoutParams(paramSpan.mViews.get(paramSpan.mViews.size() - 1))).mFullSpan ^ true; 
    } else if (paramSpan.getStartLine() > this.mPrimaryOrientation.getStartAfterPadding()) {
      return (paramSpan.getLayoutParams(paramSpan.mViews.get(0))).mFullSpan ^ true;
    } 
    return false;
  }
  
  private int computeScrollExtent(RecyclerView.State paramState) {
    return (getChildCount() == 0) ? 0 : ScrollbarHelper.computeScrollExtent(paramState, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled);
  }
  
  private int computeScrollOffset(RecyclerView.State paramState) {
    return (getChildCount() == 0) ? 0 : ScrollbarHelper.computeScrollOffset(paramState, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
  }
  
  private int computeScrollRange(RecyclerView.State paramState) {
    return (getChildCount() == 0) ? 0 : ScrollbarHelper.computeScrollRange(paramState, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled);
  }
  
  private int convertFocusDirectionToLayoutDirection(int paramInt) {
    int i = -1;
    int j = Integer.MIN_VALUE;
    if (paramInt != 17) {
      if (paramInt != 33) {
        if (paramInt != 66) {
          if (paramInt != 130) {
            switch (paramInt) {
              default:
                return Integer.MIN_VALUE;
              case 2:
                return (this.mOrientation == 1) ? 1 : (isLayoutRTL() ? -1 : 1);
              case 1:
                break;
            } 
            return (this.mOrientation == 1) ? -1 : (isLayoutRTL() ? 1 : -1);
          } 
          if (this.mOrientation == 1)
            j = 1; 
          return j;
        } 
        if (this.mOrientation == 0)
          j = 1; 
        return j;
      } 
      if (this.mOrientation != 1)
        i = Integer.MIN_VALUE; 
      return i;
    } 
    if (this.mOrientation != 0)
      i = Integer.MIN_VALUE; 
    return i;
  }
  
  private LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int paramInt) {
    LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
    fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
    for (byte b = 0; b < this.mSpanCount; b++)
      fullSpanItem.mGapPerSpan[b] = paramInt - this.mSpans[b].getEndLine(paramInt); 
    return fullSpanItem;
  }
  
  private LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int paramInt) {
    LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
    fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
    for (byte b = 0; b < this.mSpanCount; b++)
      fullSpanItem.mGapPerSpan[b] = this.mSpans[b].getStartLine(paramInt) - paramInt; 
    return fullSpanItem;
  }
  
  private void createOrientationHelpers() {
    this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
    this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
  }
  
  private int fill(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState, RecyclerView.State paramState) {
    int i;
    this.mRemainingSpans.set(0, this.mSpanCount, true);
    if (this.mLayoutState.mInfinite) {
      if (paramLayoutState.mLayoutDirection == 1) {
        i = Integer.MAX_VALUE;
      } else {
        i = Integer.MIN_VALUE;
      } 
    } else if (paramLayoutState.mLayoutDirection == 1) {
      i = paramLayoutState.mEndLine + paramLayoutState.mAvailable;
    } else {
      i = paramLayoutState.mStartLine - paramLayoutState.mAvailable;
    } 
    updateAllRemainingSpans(paramLayoutState.mLayoutDirection, i);
    if (this.mShouldReverseLayout) {
      j = this.mPrimaryOrientation.getEndAfterPadding();
    } else {
      j = this.mPrimaryOrientation.getStartAfterPadding();
    } 
    int k;
    for (k = 0; paramLayoutState.hasMore(paramState) && (this.mLayoutState.mInfinite || !this.mRemainingSpans.isEmpty()); k = 1) {
      int n;
      Span span;
      int i1;
      int i2;
      View view = paramLayoutState.next(paramRecycler);
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      int m = layoutParams.getViewLayoutPosition();
      k = this.mLazySpanLookup.getSpan(m);
      if (k == -1) {
        n = 1;
      } else {
        n = 0;
      } 
      if (n) {
        if (layoutParams.mFullSpan) {
          span = this.mSpans[0];
        } else {
          span = getNextSpan(paramLayoutState);
        } 
        this.mLazySpanLookup.setSpan(m, span);
      } else {
        span = this.mSpans[k];
      } 
      layoutParams.mSpan = span;
      if (paramLayoutState.mLayoutDirection == 1) {
        addView(view);
      } else {
        addView(view, 0);
      } 
      measureChildWithDecorationsAndMargin(view, layoutParams, false);
      if (paramLayoutState.mLayoutDirection == 1) {
        if (layoutParams.mFullSpan) {
          k = getMaxEnd(j);
        } else {
          k = span.getEndLine(j);
        } 
        i1 = this.mPrimaryOrientation.getDecoratedMeasurement(view);
        if (n && layoutParams.mFullSpan) {
          LazySpanLookup.FullSpanItem fullSpanItem = createFullSpanItemFromEnd(k);
          fullSpanItem.mGapDir = -1;
          fullSpanItem.mPosition = m;
          this.mLazySpanLookup.addFullSpanItem(fullSpanItem);
        } 
        i2 = i1 + k;
        i1 = k;
      } else {
        if (layoutParams.mFullSpan) {
          k = getMinStart(j);
        } else {
          k = span.getStartLine(j);
        } 
        i1 = k - this.mPrimaryOrientation.getDecoratedMeasurement(view);
        if (n && layoutParams.mFullSpan) {
          LazySpanLookup.FullSpanItem fullSpanItem = createFullSpanItemFromStart(k);
          fullSpanItem.mGapDir = 1;
          fullSpanItem.mPosition = m;
          this.mLazySpanLookup.addFullSpanItem(fullSpanItem);
        } 
        i2 = k;
      } 
      if (layoutParams.mFullSpan && paramLayoutState.mItemDirection == -1)
        if (n) {
          this.mLaidOutInvalidFullSpan = true;
        } else {
          boolean bool;
          if (paramLayoutState.mLayoutDirection == 1) {
            bool = areAllEndsEqual();
          } else {
            bool = areAllStartsEqual();
          } 
          if ((bool ^ true) != 0) {
            LazySpanLookup.FullSpanItem fullSpanItem = this.mLazySpanLookup.getFullSpanItem(m);
            if (fullSpanItem != null)
              fullSpanItem.mHasUnwantedGapAfter = true; 
            this.mLaidOutInvalidFullSpan = true;
          } 
        }  
      attachViewToSpans(view, layoutParams, paramLayoutState);
      if (isLayoutRTL() && this.mOrientation == 1) {
        if (layoutParams.mFullSpan) {
          k = this.mSecondaryOrientation.getEndAfterPadding();
        } else {
          k = this.mSecondaryOrientation.getEndAfterPadding() - (this.mSpanCount - 1 - span.mIndex) * this.mSizePerSpan;
        } 
        m = this.mSecondaryOrientation.getDecoratedMeasurement(view);
        n = k;
        k -= m;
        m = n;
      } else {
        if (layoutParams.mFullSpan) {
          k = this.mSecondaryOrientation.getStartAfterPadding();
        } else {
          k = span.mIndex * this.mSizePerSpan + this.mSecondaryOrientation.getStartAfterPadding();
        } 
        m = this.mSecondaryOrientation.getDecoratedMeasurement(view);
        n = k;
        m += k;
        k = n;
      } 
      if (this.mOrientation == 1) {
        layoutDecoratedWithMargins(view, k, i1, m, i2);
      } else {
        layoutDecoratedWithMargins(view, i1, k, i2, m);
      } 
      if (layoutParams.mFullSpan) {
        updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, i);
      } else {
        updateRemainingSpans(span, this.mLayoutState.mLayoutDirection, i);
      } 
      recycle(paramRecycler, this.mLayoutState);
      if (this.mLayoutState.mStopInFocusable && view.isFocusable())
        if (layoutParams.mFullSpan) {
          this.mRemainingSpans.clear();
        } else {
          this.mRemainingSpans.set(span.mIndex, false);
        }  
    } 
    int j = 0;
    if (k == 0)
      recycle(paramRecycler, this.mLayoutState); 
    if (this.mLayoutState.mLayoutDirection == -1) {
      i = getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
      i = this.mPrimaryOrientation.getStartAfterPadding() - i;
    } else {
      i = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
    } 
    k = j;
    if (i > 0)
      k = Math.min(paramLayoutState.mAvailable, i); 
    return k;
  }
  
  private int findFirstReferenceChildPosition(int paramInt) {
    int i = getChildCount();
    for (byte b = 0; b < i; b++) {
      int j = getPosition(getChildAt(b));
      if (j >= 0 && j < paramInt)
        return j; 
    } 
    return 0;
  }
  
  private int findLastReferenceChildPosition(int paramInt) {
    for (int i = getChildCount() - 1; i >= 0; i--) {
      int j = getPosition(getChildAt(i));
      if (j >= 0 && j < paramInt)
        return j; 
    } 
    return 0;
  }
  
  private void fixEndGap(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean) {
    int i = getMaxEnd(-2147483648);
    if (i == Integer.MIN_VALUE)
      return; 
    i = this.mPrimaryOrientation.getEndAfterPadding() - i;
    if (i > 0) {
      i -= -scrollBy(-i, paramRecycler, paramState);
      if (paramBoolean && i > 0)
        this.mPrimaryOrientation.offsetChildren(i); 
      return;
    } 
  }
  
  private void fixStartGap(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean) {
    int i = getMinStart(2147483647);
    if (i == Integer.MAX_VALUE)
      return; 
    i -= this.mPrimaryOrientation.getStartAfterPadding();
    if (i > 0) {
      i -= scrollBy(i, paramRecycler, paramState);
      if (paramBoolean && i > 0)
        this.mPrimaryOrientation.offsetChildren(-i); 
      return;
    } 
  }
  
  private int getFirstChildPosition() {
    int i = getChildCount();
    int j = 0;
    if (i != 0)
      j = getPosition(getChildAt(0)); 
    return j;
  }
  
  private int getLastChildPosition() {
    int i = getChildCount();
    if (i == 0) {
      i = 0;
    } else {
      i = getPosition(getChildAt(i - 1));
    } 
    return i;
  }
  
  private int getMaxEnd(int paramInt) {
    int i = this.mSpans[0].getEndLine(paramInt);
    byte b = 1;
    while (b < this.mSpanCount) {
      int j = this.mSpans[b].getEndLine(paramInt);
      int k = i;
      if (j > i)
        k = j; 
      b++;
      i = k;
    } 
    return i;
  }
  
  private int getMaxStart(int paramInt) {
    int i = this.mSpans[0].getStartLine(paramInt);
    byte b = 1;
    while (b < this.mSpanCount) {
      int j = this.mSpans[b].getStartLine(paramInt);
      int k = i;
      if (j > i)
        k = j; 
      b++;
      i = k;
    } 
    return i;
  }
  
  private int getMinEnd(int paramInt) {
    int i = this.mSpans[0].getEndLine(paramInt);
    byte b = 1;
    while (b < this.mSpanCount) {
      int j = this.mSpans[b].getEndLine(paramInt);
      int k = i;
      if (j < i)
        k = j; 
      b++;
      i = k;
    } 
    return i;
  }
  
  private int getMinStart(int paramInt) {
    int i = this.mSpans[0].getStartLine(paramInt);
    byte b = 1;
    while (b < this.mSpanCount) {
      int j = this.mSpans[b].getStartLine(paramInt);
      int k = i;
      if (j < i)
        k = j; 
      b++;
      i = k;
    } 
    return i;
  }
  
  private Span getNextSpan(LayoutState paramLayoutState) {
    int j;
    byte b;
    boolean bool = preferLastSpan(paramLayoutState.mLayoutDirection);
    int i = -1;
    if (bool) {
      j = this.mSpanCount - 1;
      b = -1;
    } else {
      j = 0;
      i = this.mSpanCount;
      b = 1;
    } 
    int k = paramLayoutState.mLayoutDirection;
    Span span2 = null;
    paramLayoutState = null;
    if (k == 1) {
      Span span;
      int i1 = Integer.MAX_VALUE;
      int i2 = this.mPrimaryOrientation.getStartAfterPadding();
      k = j;
      while (k != i) {
        span2 = this.mSpans[k];
        int i3 = span2.getEndLine(i2);
        j = i1;
        if (i3 < i1) {
          span = span2;
          j = i3;
        } 
        k += b;
        i1 = j;
      } 
      return span;
    } 
    k = Integer.MIN_VALUE;
    int n = this.mPrimaryOrientation.getEndAfterPadding();
    Span span1 = span2;
    int m = j;
    while (m != i) {
      span2 = this.mSpans[m];
      int i1 = span2.getStartLine(n);
      j = k;
      if (i1 > k) {
        span1 = span2;
        j = i1;
      } 
      m += b;
      k = j;
    } 
    return span1;
  }
  
  private void handleUpdate(int paramInt1, int paramInt2, int paramInt3) {
    if (this.mShouldReverseLayout) {
      int k = getLastChildPosition();
    } else {
      int k = getFirstChildPosition();
    } 
    if (paramInt3 == 8) {
      if (paramInt1 < paramInt2) {
        i = paramInt2 + 1;
      } else {
        int k = paramInt1 + 1;
        i = paramInt2;
        this.mLazySpanLookup.invalidateAfter(i);
      } 
    } else {
      i = paramInt1 + paramInt2;
    } 
    int j = i;
    int i = paramInt1;
    this.mLazySpanLookup.invalidateAfter(i);
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
    calculateItemDecorationsForChild(paramView, this.mTmpRect);
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    paramInt1 = updateSpecWithExtra(paramInt1, layoutParams.leftMargin + this.mTmpRect.left, layoutParams.rightMargin + this.mTmpRect.right);
    paramInt2 = updateSpecWithExtra(paramInt2, layoutParams.topMargin + this.mTmpRect.top, layoutParams.bottomMargin + this.mTmpRect.bottom);
    if (paramBoolean) {
      paramBoolean = shouldReMeasureChild(paramView, paramInt1, paramInt2, layoutParams);
    } else {
      paramBoolean = shouldMeasureChild(paramView, paramInt1, paramInt2, layoutParams);
    } 
    if (paramBoolean)
      paramView.measure(paramInt1, paramInt2); 
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, LayoutParams paramLayoutParams, boolean paramBoolean) {
    if (paramLayoutParams.mFullSpan) {
      if (this.mOrientation == 1) {
        measureChildWithDecorationsAndMargin(paramView, this.mFullSizeSpec, getChildMeasureSpec(getHeight(), getHeightMode(), 0, paramLayoutParams.height, true), paramBoolean);
      } else {
        measureChildWithDecorationsAndMargin(paramView, getChildMeasureSpec(getWidth(), getWidthMode(), 0, paramLayoutParams.width, true), this.mFullSizeSpec, paramBoolean);
      } 
    } else if (this.mOrientation == 1) {
      measureChildWithDecorationsAndMargin(paramView, getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, paramLayoutParams.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), 0, paramLayoutParams.height, true), paramBoolean);
    } else {
      measureChildWithDecorationsAndMargin(paramView, getChildMeasureSpec(getWidth(), getWidthMode(), 0, paramLayoutParams.width, true), getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, paramLayoutParams.height, false), paramBoolean);
    } 
  }
  
  private void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mAnchorInfo : Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$AnchorInfo;
    //   4: astore #4
    //   6: aload_0
    //   7: getfield mPendingSavedState : Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$SavedState;
    //   10: ifnonnull -> 21
    //   13: aload_0
    //   14: getfield mPendingScrollPosition : I
    //   17: iconst_m1
    //   18: if_icmpeq -> 39
    //   21: aload_2
    //   22: invokevirtual getItemCount : ()I
    //   25: ifne -> 39
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual removeAndRecycleAllViews : (Lorg/jar/support/v7/widget/RecyclerView$Recycler;)V
    //   33: aload #4
    //   35: invokevirtual reset : ()V
    //   38: return
    //   39: aload #4
    //   41: getfield mValid : Z
    //   44: istore #5
    //   46: iconst_1
    //   47: istore #6
    //   49: iload #5
    //   51: ifeq -> 69
    //   54: aload_0
    //   55: getfield mPendingScrollPosition : I
    //   58: iconst_m1
    //   59: if_icmpne -> 69
    //   62: aload_0
    //   63: getfield mPendingSavedState : Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$SavedState;
    //   66: ifnull -> 116
    //   69: aload #4
    //   71: invokevirtual reset : ()V
    //   74: aload_0
    //   75: getfield mPendingSavedState : Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$SavedState;
    //   78: ifnull -> 90
    //   81: aload_0
    //   82: aload #4
    //   84: invokespecial applyPendingSavedState : (Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$AnchorInfo;)V
    //   87: goto -> 103
    //   90: aload_0
    //   91: invokespecial resolveShouldLayoutReverse : ()V
    //   94: aload #4
    //   96: aload_0
    //   97: getfield mShouldReverseLayout : Z
    //   100: putfield mLayoutFromEnd : Z
    //   103: aload_0
    //   104: aload_2
    //   105: aload #4
    //   107: invokevirtual updateAnchorInfoForLayout : (Lorg/jar/support/v7/widget/RecyclerView$State;Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$AnchorInfo;)V
    //   110: aload #4
    //   112: iconst_1
    //   113: putfield mValid : Z
    //   116: aload_0
    //   117: getfield mPendingSavedState : Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$SavedState;
    //   120: ifnonnull -> 167
    //   123: aload_0
    //   124: getfield mPendingScrollPosition : I
    //   127: iconst_m1
    //   128: if_icmpne -> 167
    //   131: aload #4
    //   133: getfield mLayoutFromEnd : Z
    //   136: aload_0
    //   137: getfield mLastLayoutFromEnd : Z
    //   140: if_icmpne -> 154
    //   143: aload_0
    //   144: invokevirtual isLayoutRTL : ()Z
    //   147: aload_0
    //   148: getfield mLastLayoutRTL : Z
    //   151: if_icmpeq -> 167
    //   154: aload_0
    //   155: getfield mLazySpanLookup : Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$LazySpanLookup;
    //   158: invokevirtual clear : ()V
    //   161: aload #4
    //   163: iconst_1
    //   164: putfield mInvalidateOffsets : Z
    //   167: aload_0
    //   168: invokevirtual getChildCount : ()I
    //   171: ifle -> 290
    //   174: aload_0
    //   175: getfield mPendingSavedState : Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$SavedState;
    //   178: ifnull -> 192
    //   181: aload_0
    //   182: getfield mPendingSavedState : Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$SavedState;
    //   185: getfield mSpanOffsetsSize : I
    //   188: iconst_1
    //   189: if_icmpge -> 290
    //   192: aload #4
    //   194: getfield mInvalidateOffsets : Z
    //   197: ifeq -> 253
    //   200: iconst_0
    //   201: istore #7
    //   203: iload #7
    //   205: aload_0
    //   206: getfield mSpanCount : I
    //   209: if_icmpge -> 290
    //   212: aload_0
    //   213: getfield mSpans : [Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$Span;
    //   216: iload #7
    //   218: aaload
    //   219: invokevirtual clear : ()V
    //   222: aload #4
    //   224: getfield mOffset : I
    //   227: ldc -2147483648
    //   229: if_icmpeq -> 247
    //   232: aload_0
    //   233: getfield mSpans : [Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$Span;
    //   236: iload #7
    //   238: aaload
    //   239: aload #4
    //   241: getfield mOffset : I
    //   244: invokevirtual setLine : (I)V
    //   247: iinc #7, 1
    //   250: goto -> 203
    //   253: iconst_0
    //   254: istore #7
    //   256: iload #7
    //   258: aload_0
    //   259: getfield mSpanCount : I
    //   262: if_icmpge -> 290
    //   265: aload_0
    //   266: getfield mSpans : [Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$Span;
    //   269: iload #7
    //   271: aaload
    //   272: aload_0
    //   273: getfield mShouldReverseLayout : Z
    //   276: aload #4
    //   278: getfield mOffset : I
    //   281: invokevirtual cacheReferenceLineAndClear : (ZI)V
    //   284: iinc #7, 1
    //   287: goto -> 256
    //   290: aload_0
    //   291: aload_1
    //   292: invokevirtual detachAndScrapAttachedViews : (Lorg/jar/support/v7/widget/RecyclerView$Recycler;)V
    //   295: aload_0
    //   296: getfield mLayoutState : Lorg/jar/support/v7/widget/LayoutState;
    //   299: iconst_0
    //   300: putfield mRecycle : Z
    //   303: aload_0
    //   304: iconst_0
    //   305: putfield mLaidOutInvalidFullSpan : Z
    //   308: aload_0
    //   309: aload_0
    //   310: getfield mSecondaryOrientation : Lorg/jar/support/v7/widget/OrientationHelper;
    //   313: invokevirtual getTotalSpace : ()I
    //   316: invokevirtual updateMeasureSpecs : (I)V
    //   319: aload_0
    //   320: aload #4
    //   322: getfield mPosition : I
    //   325: aload_2
    //   326: invokespecial updateLayoutState : (ILorg/jar/support/v7/widget/RecyclerView$State;)V
    //   329: aload #4
    //   331: getfield mLayoutFromEnd : Z
    //   334: ifeq -> 392
    //   337: aload_0
    //   338: iconst_m1
    //   339: invokespecial setLayoutStateDirection : (I)V
    //   342: aload_0
    //   343: aload_1
    //   344: aload_0
    //   345: getfield mLayoutState : Lorg/jar/support/v7/widget/LayoutState;
    //   348: aload_2
    //   349: invokespecial fill : (Lorg/jar/support/v7/widget/RecyclerView$Recycler;Lorg/jar/support/v7/widget/LayoutState;Lorg/jar/support/v7/widget/RecyclerView$State;)I
    //   352: pop
    //   353: aload_0
    //   354: iconst_1
    //   355: invokespecial setLayoutStateDirection : (I)V
    //   358: aload_0
    //   359: getfield mLayoutState : Lorg/jar/support/v7/widget/LayoutState;
    //   362: aload #4
    //   364: getfield mPosition : I
    //   367: aload_0
    //   368: getfield mLayoutState : Lorg/jar/support/v7/widget/LayoutState;
    //   371: getfield mItemDirection : I
    //   374: iadd
    //   375: putfield mCurrentPosition : I
    //   378: aload_0
    //   379: aload_1
    //   380: aload_0
    //   381: getfield mLayoutState : Lorg/jar/support/v7/widget/LayoutState;
    //   384: aload_2
    //   385: invokespecial fill : (Lorg/jar/support/v7/widget/RecyclerView$Recycler;Lorg/jar/support/v7/widget/LayoutState;Lorg/jar/support/v7/widget/RecyclerView$State;)I
    //   388: pop
    //   389: goto -> 444
    //   392: aload_0
    //   393: iconst_1
    //   394: invokespecial setLayoutStateDirection : (I)V
    //   397: aload_0
    //   398: aload_1
    //   399: aload_0
    //   400: getfield mLayoutState : Lorg/jar/support/v7/widget/LayoutState;
    //   403: aload_2
    //   404: invokespecial fill : (Lorg/jar/support/v7/widget/RecyclerView$Recycler;Lorg/jar/support/v7/widget/LayoutState;Lorg/jar/support/v7/widget/RecyclerView$State;)I
    //   407: pop
    //   408: aload_0
    //   409: iconst_m1
    //   410: invokespecial setLayoutStateDirection : (I)V
    //   413: aload_0
    //   414: getfield mLayoutState : Lorg/jar/support/v7/widget/LayoutState;
    //   417: aload #4
    //   419: getfield mPosition : I
    //   422: aload_0
    //   423: getfield mLayoutState : Lorg/jar/support/v7/widget/LayoutState;
    //   426: getfield mItemDirection : I
    //   429: iadd
    //   430: putfield mCurrentPosition : I
    //   433: aload_0
    //   434: aload_1
    //   435: aload_0
    //   436: getfield mLayoutState : Lorg/jar/support/v7/widget/LayoutState;
    //   439: aload_2
    //   440: invokespecial fill : (Lorg/jar/support/v7/widget/RecyclerView$Recycler;Lorg/jar/support/v7/widget/LayoutState;Lorg/jar/support/v7/widget/RecyclerView$State;)I
    //   443: pop
    //   444: aload_0
    //   445: invokespecial repositionToWrapContentIfNecessary : ()V
    //   448: aload_0
    //   449: invokevirtual getChildCount : ()I
    //   452: ifle -> 493
    //   455: aload_0
    //   456: getfield mShouldReverseLayout : Z
    //   459: ifeq -> 479
    //   462: aload_0
    //   463: aload_1
    //   464: aload_2
    //   465: iconst_1
    //   466: invokespecial fixEndGap : (Lorg/jar/support/v7/widget/RecyclerView$Recycler;Lorg/jar/support/v7/widget/RecyclerView$State;Z)V
    //   469: aload_0
    //   470: aload_1
    //   471: aload_2
    //   472: iconst_0
    //   473: invokespecial fixStartGap : (Lorg/jar/support/v7/widget/RecyclerView$Recycler;Lorg/jar/support/v7/widget/RecyclerView$State;Z)V
    //   476: goto -> 493
    //   479: aload_0
    //   480: aload_1
    //   481: aload_2
    //   482: iconst_1
    //   483: invokespecial fixStartGap : (Lorg/jar/support/v7/widget/RecyclerView$Recycler;Lorg/jar/support/v7/widget/RecyclerView$State;Z)V
    //   486: aload_0
    //   487: aload_1
    //   488: aload_2
    //   489: iconst_0
    //   490: invokespecial fixEndGap : (Lorg/jar/support/v7/widget/RecyclerView$Recycler;Lorg/jar/support/v7/widget/RecyclerView$State;Z)V
    //   493: iload_3
    //   494: ifeq -> 569
    //   497: aload_2
    //   498: invokevirtual isPreLayout : ()Z
    //   501: ifne -> 569
    //   504: aload_0
    //   505: getfield mGapStrategy : I
    //   508: ifeq -> 538
    //   511: aload_0
    //   512: invokevirtual getChildCount : ()I
    //   515: ifle -> 538
    //   518: aload_0
    //   519: getfield mLaidOutInvalidFullSpan : Z
    //   522: ifne -> 532
    //   525: aload_0
    //   526: invokevirtual hasGapsToFix : ()Landroid/view/View;
    //   529: ifnull -> 538
    //   532: iconst_1
    //   533: istore #7
    //   535: goto -> 541
    //   538: iconst_0
    //   539: istore #7
    //   541: iload #7
    //   543: ifeq -> 569
    //   546: aload_0
    //   547: aload_0
    //   548: getfield mCheckForGapsRunnable : Ljava/lang/Runnable;
    //   551: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)Z
    //   554: pop
    //   555: aload_0
    //   556: invokespecial checkForGaps : ()Z
    //   559: ifeq -> 569
    //   562: iload #6
    //   564: istore #7
    //   566: goto -> 572
    //   569: iconst_0
    //   570: istore #7
    //   572: aload_2
    //   573: invokevirtual isPreLayout : ()Z
    //   576: ifeq -> 586
    //   579: aload_0
    //   580: getfield mAnchorInfo : Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$AnchorInfo;
    //   583: invokevirtual reset : ()V
    //   586: aload_0
    //   587: aload #4
    //   589: getfield mLayoutFromEnd : Z
    //   592: putfield mLastLayoutFromEnd : Z
    //   595: aload_0
    //   596: aload_0
    //   597: invokevirtual isLayoutRTL : ()Z
    //   600: putfield mLastLayoutRTL : Z
    //   603: iload #7
    //   605: ifeq -> 622
    //   608: aload_0
    //   609: getfield mAnchorInfo : Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$AnchorInfo;
    //   612: invokevirtual reset : ()V
    //   615: aload_0
    //   616: aload_1
    //   617: aload_2
    //   618: iconst_0
    //   619: invokespecial onLayoutChildren : (Lorg/jar/support/v7/widget/RecyclerView$Recycler;Lorg/jar/support/v7/widget/RecyclerView$State;Z)V
    //   622: return
  }
  
  private boolean preferLastSpan(int paramInt) {
    boolean bool;
    int i = this.mOrientation;
    boolean bool1 = false;
    boolean bool2 = false;
    if (i == 0) {
      if (paramInt == -1) {
        bool = true;
      } else {
        bool = false;
      } 
      bool1 = bool2;
      if (bool != this.mShouldReverseLayout)
        bool1 = true; 
      return bool1;
    } 
    if (paramInt == -1) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool == this.mShouldReverseLayout) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool == isLayoutRTL())
      bool1 = true; 
    return bool1;
  }
  
  private void prependViewToAllSpans(View paramView) {
    for (int i = this.mSpanCount - 1; i >= 0; i--)
      this.mSpans[i].prependToSpan(paramView); 
  }
  
  private void recycle(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState) {
    if (!paramLayoutState.mRecycle || paramLayoutState.mInfinite)
      return; 
    if (paramLayoutState.mAvailable == 0) {
      if (paramLayoutState.mLayoutDirection == -1) {
        recycleFromEnd(paramRecycler, paramLayoutState.mEndLine);
      } else {
        recycleFromStart(paramRecycler, paramLayoutState.mStartLine);
      } 
    } else if (paramLayoutState.mLayoutDirection == -1) {
      int i = paramLayoutState.mStartLine - getMaxStart(paramLayoutState.mStartLine);
      if (i < 0) {
        i = paramLayoutState.mEndLine;
      } else {
        i = paramLayoutState.mEndLine - Math.min(i, paramLayoutState.mAvailable);
      } 
      recycleFromEnd(paramRecycler, i);
    } else {
      int i;
      int j = getMinEnd(paramLayoutState.mEndLine) - paramLayoutState.mEndLine;
      if (j < 0) {
        i = paramLayoutState.mStartLine;
      } else {
        i = paramLayoutState.mStartLine;
        i = Math.min(j, paramLayoutState.mAvailable) + i;
      } 
      recycleFromStart(paramRecycler, i);
    } 
  }
  
  private void recycleFromEnd(RecyclerView.Recycler paramRecycler, int paramInt) {
    int i = getChildCount() - 1;
    while (i >= 0) {
      View view = getChildAt(i);
      if (this.mPrimaryOrientation.getDecoratedStart(view) >= paramInt && this.mPrimaryOrientation.getTransformedStartWithDecoration(view) >= paramInt) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.mFullSpan) {
          byte b3;
          byte b1 = 0;
          byte b2 = 0;
          while (true) {
            b3 = b1;
            if (b2 < this.mSpanCount) {
              if ((this.mSpans[b2]).mViews.size() == 1)
                return; 
              b2++;
              continue;
            } 
            break;
          } 
          while (b3 < this.mSpanCount) {
            this.mSpans[b3].popEnd();
            b3++;
          } 
        } else {
          if (layoutParams.mSpan.mViews.size() == 1)
            return; 
          layoutParams.mSpan.popEnd();
        } 
        removeAndRecycleView(view, paramRecycler);
        i--;
        continue;
      } 
      return;
    } 
  }
  
  private void recycleFromStart(RecyclerView.Recycler paramRecycler, int paramInt) {
    while (getChildCount() > 0) {
      byte b = 0;
      View view = getChildAt(0);
      if (this.mPrimaryOrientation.getDecoratedEnd(view) <= paramInt && this.mPrimaryOrientation.getTransformedEndWithDecoration(view) <= paramInt) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.mFullSpan) {
          byte b2;
          byte b1 = 0;
          while (true) {
            b2 = b;
            if (b1 < this.mSpanCount) {
              if ((this.mSpans[b1]).mViews.size() == 1)
                return; 
              b1++;
              continue;
            } 
            break;
          } 
          while (b2 < this.mSpanCount) {
            this.mSpans[b2].popStart();
            b2++;
          } 
        } else {
          if (layoutParams.mSpan.mViews.size() == 1)
            return; 
          layoutParams.mSpan.popStart();
        } 
        removeAndRecycleView(view, paramRecycler);
        continue;
      } 
      return;
    } 
  }
  
  private void repositionToWrapContentIfNecessary() {
    if (this.mSecondaryOrientation.getMode() == 1073741824)
      return; 
    int i = getChildCount();
    int j = 0;
    int k = 0;
    float f = 0.0F;
    while (k < i) {
      View view = getChildAt(k);
      float f1 = this.mSecondaryOrientation.getDecoratedMeasurement(view);
      if (f1 >= f) {
        float f2 = f1;
        if (((LayoutParams)view.getLayoutParams()).isFullSpan())
          f2 = f1 * 1.0F / this.mSpanCount; 
        f = Math.max(f, f2);
      } 
      k++;
    } 
    int m = this.mSizePerSpan;
    int n = Math.round(f * this.mSpanCount);
    k = n;
    if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE)
      k = Math.min(n, this.mSecondaryOrientation.getTotalSpace()); 
    updateMeasureSpecs(k);
    k = j;
    if (this.mSizePerSpan == m)
      return; 
    while (k < i) {
      View view = getChildAt(k);
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      if (!layoutParams.mFullSpan)
        if (isLayoutRTL() && this.mOrientation == 1) {
          view.offsetLeftAndRight(-(this.mSpanCount - 1 - layoutParams.mSpan.mIndex) * this.mSizePerSpan - -(this.mSpanCount - 1 - layoutParams.mSpan.mIndex) * m);
        } else {
          n = layoutParams.mSpan.mIndex * this.mSizePerSpan;
          j = layoutParams.mSpan.mIndex * m;
          if (this.mOrientation == 1) {
            view.offsetLeftAndRight(n - j);
          } else {
            view.offsetTopAndBottom(n - j);
          } 
        }  
      k++;
    } 
  }
  
  private void resolveShouldLayoutReverse() {
    if (this.mOrientation == 1 || !isLayoutRTL()) {
      this.mShouldReverseLayout = this.mReverseLayout;
      return;
    } 
    this.mShouldReverseLayout = this.mReverseLayout ^ true;
  }
  
  private void setLayoutStateDirection(int paramInt) {
    boolean bool2;
    this.mLayoutState.mLayoutDirection = paramInt;
    LayoutState layoutState = this.mLayoutState;
    boolean bool1 = this.mShouldReverseLayout;
    boolean bool = true;
    if (paramInt == -1) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (bool1 == bool2) {
      paramInt = bool;
    } else {
      paramInt = -1;
    } 
    layoutState.mItemDirection = paramInt;
  }
  
  private void updateAllRemainingSpans(int paramInt1, int paramInt2) {
    for (byte b = 0; b < this.mSpanCount; b++) {
      if (!(this.mSpans[b]).mViews.isEmpty())
        updateRemainingSpans(this.mSpans[b], paramInt1, paramInt2); 
    } 
  }
  
  private boolean updateAnchorFromChildren(RecyclerView.State paramState, AnchorInfo paramAnchorInfo) {
    int i;
    if (this.mLastLayoutFromEnd) {
      i = findLastReferenceChildPosition(paramState.getItemCount());
    } else {
      i = findFirstReferenceChildPosition(paramState.getItemCount());
    } 
    paramAnchorInfo.mPosition = i;
    paramAnchorInfo.mOffset = Integer.MIN_VALUE;
    return true;
  }
  
  private void updateLayoutState(int paramInt, RecyclerView.State paramState) {
    LayoutState layoutState = this.mLayoutState;
    boolean bool1 = false;
    layoutState.mAvailable = 0;
    this.mLayoutState.mCurrentPosition = paramInt;
    if (isSmoothScrolling()) {
      int i = paramState.getTargetScrollPosition();
      if (i != -1) {
        boolean bool3 = this.mShouldReverseLayout;
        if (i < paramInt) {
          bool4 = true;
        } else {
          bool4 = false;
        } 
        if (bool3 == bool4) {
          i = this.mPrimaryOrientation.getTotalSpace();
          paramInt = 0;
        } else {
          paramInt = this.mPrimaryOrientation.getTotalSpace();
          i = 0;
        } 
        if (getClipToPadding()) {
          this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - paramInt;
          this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + i;
        } else {
          this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEnd() + i;
          this.mLayoutState.mStartLine = -paramInt;
        } 
        this.mLayoutState.mStopInFocusable = false;
        this.mLayoutState.mRecycle = true;
        LayoutState layoutState1 = this.mLayoutState;
        boolean bool4 = bool1;
        if (this.mPrimaryOrientation.getMode() == 0) {
          bool4 = bool1;
          if (this.mPrimaryOrientation.getEnd() == 0)
            bool4 = true; 
        } 
        layoutState1.mInfinite = bool4;
        return;
      } 
    } 
    paramInt = 0;
    boolean bool2 = false;
  }
  
  private void updateRemainingSpans(Span paramSpan, int paramInt1, int paramInt2) {
    int i = paramSpan.getDeletedSize();
    if (paramInt1 == -1) {
      if (paramSpan.getStartLine() + i <= paramInt2)
        this.mRemainingSpans.set(paramSpan.mIndex, false); 
    } else if (paramSpan.getEndLine() - i >= paramInt2) {
      this.mRemainingSpans.set(paramSpan.mIndex, false);
    } 
  }
  
  private int updateSpecWithExtra(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 == 0 && paramInt3 == 0)
      return paramInt1; 
    int i = View.MeasureSpec.getMode(paramInt1);
    return (i == Integer.MIN_VALUE || i == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i) : paramInt1;
  }
  
  boolean areAllEndsEqual() {
    int i = this.mSpans[0].getEndLine(-2147483648);
    for (byte b = 1; b < this.mSpanCount; b++) {
      if (this.mSpans[b].getEndLine(-2147483648) != i)
        return false; 
    } 
    return true;
  }
  
  boolean areAllStartsEqual() {
    int i = this.mSpans[0].getStartLine(-2147483648);
    for (byte b = 1; b < this.mSpanCount; b++) {
      if (this.mSpans[b].getStartLine(-2147483648) != i)
        return false; 
    } 
    return true;
  }
  
  public void assertNotInLayoutOrScroll(String paramString) {
    if (this.mPendingSavedState == null)
      super.assertNotInLayoutOrScroll(paramString); 
  }
  
  public boolean canScrollHorizontally() {
    boolean bool;
    if (this.mOrientation == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean canScrollVertically() {
    int i = this.mOrientation;
    boolean bool = true;
    if (i != 1)
      bool = false; 
    return bool;
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState) {
    return computeScrollExtent(paramState);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState) {
    return computeScrollOffset(paramState);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState) {
    return computeScrollRange(paramState);
  }
  
  public int computeVerticalScrollExtent(RecyclerView.State paramState) {
    return computeScrollExtent(paramState);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState) {
    return computeScrollOffset(paramState);
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState) {
    return computeScrollRange(paramState);
  }
  
  public int[] findFirstCompletelyVisibleItemPositions(int[] paramArrayOfint) {
    if (paramArrayOfint == null) {
      paramArrayOfint = new int[this.mSpanCount];
    } else if (paramArrayOfint.length < this.mSpanCount) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
      stringBuilder.append(this.mSpanCount);
      stringBuilder.append(", array size:");
      stringBuilder.append(paramArrayOfint.length);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    for (byte b = 0; b < this.mSpanCount; b++)
      paramArrayOfint[b] = this.mSpans[b].findFirstCompletelyVisibleItemPosition(); 
    return paramArrayOfint;
  }
  
  View findFirstVisibleItemClosestToEnd(boolean paramBoolean1, boolean paramBoolean2) {
    int i = this.mPrimaryOrientation.getStartAfterPadding();
    int j = this.mPrimaryOrientation.getEndAfterPadding();
    int k = getChildCount() - 1;
    View view;
    for (view = null; k >= 0; view = view2) {
      View view1 = getChildAt(k);
      int m = this.mPrimaryOrientation.getDecoratedStart(view1);
      int n = this.mPrimaryOrientation.getDecoratedEnd(view1);
      View view2 = view;
      if (n > i)
        if (m >= j) {
          view2 = view;
        } else {
          if (n <= j || !paramBoolean1)
            return view1; 
          view2 = view;
          if (paramBoolean2) {
            view2 = view;
            if (view == null)
              view2 = view1; 
          } 
        }  
      k--;
    } 
    return view;
  }
  
  View findFirstVisibleItemClosestToStart(boolean paramBoolean1, boolean paramBoolean2) {
    int i = this.mPrimaryOrientation.getStartAfterPadding();
    int j = this.mPrimaryOrientation.getEndAfterPadding();
    int k = getChildCount();
    View view = null;
    byte b = 0;
    while (b < k) {
      View view1 = getChildAt(b);
      int m = this.mPrimaryOrientation.getDecoratedStart(view1);
      View view2 = view;
      if (this.mPrimaryOrientation.getDecoratedEnd(view1) > i)
        if (m >= j) {
          view2 = view;
        } else {
          if (m >= i || !paramBoolean1)
            return view1; 
          view2 = view;
          if (paramBoolean2) {
            view2 = view;
            if (view == null)
              view2 = view1; 
          } 
        }  
      b++;
      view = view2;
    } 
    return view;
  }
  
  int findFirstVisibleItemPositionInt() {
    View view;
    int i;
    if (this.mShouldReverseLayout) {
      view = findFirstVisibleItemClosestToEnd(true, true);
    } else {
      view = findFirstVisibleItemClosestToStart(true, true);
    } 
    if (view == null) {
      i = -1;
    } else {
      i = getPosition(view);
    } 
    return i;
  }
  
  public int[] findFirstVisibleItemPositions(int[] paramArrayOfint) {
    if (paramArrayOfint == null) {
      paramArrayOfint = new int[this.mSpanCount];
    } else if (paramArrayOfint.length < this.mSpanCount) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
      stringBuilder.append(this.mSpanCount);
      stringBuilder.append(", array size:");
      stringBuilder.append(paramArrayOfint.length);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    for (byte b = 0; b < this.mSpanCount; b++)
      paramArrayOfint[b] = this.mSpans[b].findFirstVisibleItemPosition(); 
    return paramArrayOfint;
  }
  
  public int[] findLastCompletelyVisibleItemPositions(int[] paramArrayOfint) {
    if (paramArrayOfint == null) {
      paramArrayOfint = new int[this.mSpanCount];
    } else if (paramArrayOfint.length < this.mSpanCount) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
      stringBuilder.append(this.mSpanCount);
      stringBuilder.append(", array size:");
      stringBuilder.append(paramArrayOfint.length);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    for (byte b = 0; b < this.mSpanCount; b++)
      paramArrayOfint[b] = this.mSpans[b].findLastCompletelyVisibleItemPosition(); 
    return paramArrayOfint;
  }
  
  public int[] findLastVisibleItemPositions(int[] paramArrayOfint) {
    if (paramArrayOfint == null) {
      paramArrayOfint = new int[this.mSpanCount];
    } else if (paramArrayOfint.length < this.mSpanCount) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
      stringBuilder.append(this.mSpanCount);
      stringBuilder.append(", array size:");
      stringBuilder.append(paramArrayOfint.length);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    for (byte b = 0; b < this.mSpanCount; b++)
      paramArrayOfint[b] = this.mSpans[b].findLastVisibleItemPosition(); 
    return paramArrayOfint;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams() {
    return (this.mOrientation == 0) ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet) {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams) : new LayoutParams(paramLayoutParams);
  }
  
  public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return (this.mOrientation == 1) ? this.mSpanCount : super.getColumnCountForAccessibility(paramRecycler, paramState);
  }
  
  public int getGapStrategy() {
    return this.mGapStrategy;
  }
  
  public int getOrientation() {
    return this.mOrientation;
  }
  
  public boolean getReverseLayout() {
    return this.mReverseLayout;
  }
  
  public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return (this.mOrientation == 0) ? this.mSpanCount : super.getRowCountForAccessibility(paramRecycler, paramState);
  }
  
  public int getSpanCount() {
    return this.mSpanCount;
  }
  
  View hasGapsToFix() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getChildCount : ()I
    //   4: iconst_1
    //   5: isub
    //   6: istore_1
    //   7: new java/util/BitSet
    //   10: dup
    //   11: aload_0
    //   12: getfield mSpanCount : I
    //   15: invokespecial <init> : (I)V
    //   18: astore_2
    //   19: aload_2
    //   20: iconst_0
    //   21: aload_0
    //   22: getfield mSpanCount : I
    //   25: iconst_1
    //   26: invokevirtual set : (IIZ)V
    //   29: aload_0
    //   30: getfield mOrientation : I
    //   33: istore_3
    //   34: iconst_m1
    //   35: istore #4
    //   37: iload_3
    //   38: iconst_1
    //   39: if_icmpne -> 54
    //   42: aload_0
    //   43: invokevirtual isLayoutRTL : ()Z
    //   46: ifeq -> 54
    //   49: iconst_1
    //   50: istore_3
    //   51: goto -> 56
    //   54: iconst_m1
    //   55: istore_3
    //   56: aload_0
    //   57: getfield mShouldReverseLayout : Z
    //   60: ifeq -> 69
    //   63: iconst_m1
    //   64: istore #5
    //   66: goto -> 76
    //   69: iload_1
    //   70: iconst_1
    //   71: iadd
    //   72: istore #5
    //   74: iconst_0
    //   75: istore_1
    //   76: iload_1
    //   77: istore #6
    //   79: iload_1
    //   80: iload #5
    //   82: if_icmpge -> 91
    //   85: iconst_1
    //   86: istore #4
    //   88: iload_1
    //   89: istore #6
    //   91: iload #6
    //   93: iload #5
    //   95: if_icmpeq -> 350
    //   98: aload_0
    //   99: iload #6
    //   101: invokevirtual getChildAt : (I)Landroid/view/View;
    //   104: astore #7
    //   106: aload #7
    //   108: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   111: checkcast org/jar/support/v7/widget/StaggeredGridLayoutManager$LayoutParams
    //   114: astore #8
    //   116: aload_2
    //   117: aload #8
    //   119: getfield mSpan : Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$Span;
    //   122: getfield mIndex : I
    //   125: invokevirtual get : (I)Z
    //   128: ifeq -> 158
    //   131: aload_0
    //   132: aload #8
    //   134: getfield mSpan : Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$Span;
    //   137: invokespecial checkSpanForGap : (Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$Span;)Z
    //   140: ifeq -> 146
    //   143: aload #7
    //   145: areturn
    //   146: aload_2
    //   147: aload #8
    //   149: getfield mSpan : Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$Span;
    //   152: getfield mIndex : I
    //   155: invokevirtual clear : (I)V
    //   158: aload #8
    //   160: getfield mFullSpan : Z
    //   163: ifeq -> 169
    //   166: goto -> 340
    //   169: iload #6
    //   171: iload #4
    //   173: iadd
    //   174: istore_1
    //   175: iload_1
    //   176: iload #5
    //   178: if_icmpeq -> 340
    //   181: aload_0
    //   182: iload_1
    //   183: invokevirtual getChildAt : (I)Landroid/view/View;
    //   186: astore #9
    //   188: aload_0
    //   189: getfield mShouldReverseLayout : Z
    //   192: ifeq -> 234
    //   195: aload_0
    //   196: getfield mPrimaryOrientation : Lorg/jar/support/v7/widget/OrientationHelper;
    //   199: aload #7
    //   201: invokevirtual getDecoratedEnd : (Landroid/view/View;)I
    //   204: istore_1
    //   205: aload_0
    //   206: getfield mPrimaryOrientation : Lorg/jar/support/v7/widget/OrientationHelper;
    //   209: aload #9
    //   211: invokevirtual getDecoratedEnd : (Landroid/view/View;)I
    //   214: istore #10
    //   216: iload_1
    //   217: iload #10
    //   219: if_icmpge -> 225
    //   222: aload #7
    //   224: areturn
    //   225: iload_1
    //   226: iload #10
    //   228: if_icmpne -> 275
    //   231: goto -> 270
    //   234: aload_0
    //   235: getfield mPrimaryOrientation : Lorg/jar/support/v7/widget/OrientationHelper;
    //   238: aload #7
    //   240: invokevirtual getDecoratedStart : (Landroid/view/View;)I
    //   243: istore_1
    //   244: aload_0
    //   245: getfield mPrimaryOrientation : Lorg/jar/support/v7/widget/OrientationHelper;
    //   248: aload #9
    //   250: invokevirtual getDecoratedStart : (Landroid/view/View;)I
    //   253: istore #10
    //   255: iload_1
    //   256: iload #10
    //   258: if_icmple -> 264
    //   261: aload #7
    //   263: areturn
    //   264: iload_1
    //   265: iload #10
    //   267: if_icmpne -> 275
    //   270: iconst_1
    //   271: istore_1
    //   272: goto -> 277
    //   275: iconst_0
    //   276: istore_1
    //   277: iload_1
    //   278: ifeq -> 340
    //   281: aload #9
    //   283: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   286: checkcast org/jar/support/v7/widget/StaggeredGridLayoutManager$LayoutParams
    //   289: astore #9
    //   291: aload #8
    //   293: getfield mSpan : Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$Span;
    //   296: getfield mIndex : I
    //   299: aload #9
    //   301: getfield mSpan : Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$Span;
    //   304: getfield mIndex : I
    //   307: isub
    //   308: ifge -> 316
    //   311: iconst_1
    //   312: istore_1
    //   313: goto -> 318
    //   316: iconst_0
    //   317: istore_1
    //   318: iload_3
    //   319: ifge -> 328
    //   322: iconst_1
    //   323: istore #10
    //   325: goto -> 331
    //   328: iconst_0
    //   329: istore #10
    //   331: iload_1
    //   332: iload #10
    //   334: if_icmpeq -> 340
    //   337: aload #7
    //   339: areturn
    //   340: iload #6
    //   342: iload #4
    //   344: iadd
    //   345: istore #6
    //   347: goto -> 91
    //   350: aconst_null
    //   351: areturn
  }
  
  public void invalidateSpanAssignments() {
    this.mLazySpanLookup.clear();
    requestLayout();
  }
  
  boolean isLayoutRTL() {
    int i = getLayoutDirection();
    boolean bool = true;
    if (i != 1)
      bool = false; 
    return bool;
  }
  
  public void offsetChildrenHorizontal(int paramInt) {
    super.offsetChildrenHorizontal(paramInt);
    for (byte b = 0; b < this.mSpanCount; b++)
      this.mSpans[b].onOffset(paramInt); 
  }
  
  public void offsetChildrenVertical(int paramInt) {
    super.offsetChildrenVertical(paramInt);
    for (byte b = 0; b < this.mSpanCount; b++)
      this.mSpans[b].onOffset(paramInt); 
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler) {
    removeCallbacks(this.mCheckForGapsRunnable);
    for (byte b = 0; b < this.mSpanCount; b++)
      this.mSpans[b].clear(); 
    paramRecyclerView.requestLayout();
  }
  
  @Nullable
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    if (getChildCount() == 0)
      return null; 
    paramView = findContainingItemView(paramView);
    if (paramView == null)
      return null; 
    resolveShouldLayoutReverse();
    int i = convertFocusDirectionToLayoutDirection(paramInt);
    if (i == Integer.MIN_VALUE)
      return null; 
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    boolean bool = layoutParams.mFullSpan;
    Span span = layoutParams.mSpan;
    if (i == 1) {
      paramInt = getLastChildPosition();
    } else {
      paramInt = getFirstChildPosition();
    } 
    updateLayoutState(paramInt, paramState);
    setLayoutStateDirection(i);
    this.mLayoutState.mCurrentPosition = this.mLayoutState.mItemDirection + paramInt;
    this.mLayoutState.mAvailable = (int)(this.mPrimaryOrientation.getTotalSpace() * 0.33333334F);
    this.mLayoutState.mStopInFocusable = true;
    LayoutState layoutState = this.mLayoutState;
    int j = 0;
    layoutState.mRecycle = false;
    fill(paramRecycler, this.mLayoutState, paramState);
    this.mLastLayoutFromEnd = this.mShouldReverseLayout;
    if (!bool) {
      View view = span.getFocusableViewAfter(paramInt, i);
      if (view != null && view != paramView)
        return view; 
    } 
    if (preferLastSpan(i)) {
      for (j = this.mSpanCount - 1; j >= 0; j--) {
        View view = this.mSpans[j].getFocusableViewAfter(paramInt, i);
        if (view != null && view != paramView)
          return view; 
      } 
    } else {
      while (j < this.mSpanCount) {
        View view = this.mSpans[j].getFocusableViewAfter(paramInt, i);
        if (view != null && view != paramView)
          return view; 
        j++;
      } 
    } 
    return null;
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    handleUpdate(paramInt1, paramInt2, 1);
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView) {
    this.mLazySpanLookup.clear();
    requestLayout();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {
    handleUpdate(paramInt1, paramInt2, 8);
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    handleUpdate(paramInt1, paramInt2, 2);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject) {
    handleUpdate(paramInt1, paramInt2, 4);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    onLayoutChildren(paramRecycler, paramState, true);
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState) {
    super.onLayoutCompleted(paramState);
    this.mPendingScrollPosition = -1;
    this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
    this.mPendingSavedState = null;
    this.mAnchorInfo.reset();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (paramParcelable instanceof SavedState) {
      this.mPendingSavedState = (SavedState)paramParcelable;
      requestLayout();
    } 
  }
  
  public Parcelable onSaveInstanceState() {
    if (this.mPendingSavedState != null)
      return new SavedState(this.mPendingSavedState); 
    SavedState savedState = new SavedState();
    savedState.mReverseLayout = this.mReverseLayout;
    savedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
    savedState.mLastLayoutRTL = this.mLastLayoutRTL;
    LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
    byte b = 0;
    if (lazySpanLookup != null && this.mLazySpanLookup.mData != null) {
      savedState.mSpanLookup = this.mLazySpanLookup.mData;
      savedState.mSpanLookupSize = savedState.mSpanLookup.length;
      savedState.mFullSpanItems = this.mLazySpanLookup.mFullSpanItems;
    } else {
      savedState.mSpanLookupSize = 0;
    } 
    if (getChildCount() > 0) {
      int i;
      if (this.mLastLayoutFromEnd) {
        i = getLastChildPosition();
      } else {
        i = getFirstChildPosition();
      } 
      savedState.mAnchorPosition = i;
      savedState.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
      savedState.mSpanOffsetsSize = this.mSpanCount;
      savedState.mSpanOffsets = new int[this.mSpanCount];
      while (b < this.mSpanCount) {
        if (this.mLastLayoutFromEnd) {
          int j = this.mSpans[b].getEndLine(-2147483648);
          i = j;
          if (j != Integer.MIN_VALUE)
            i = j - this.mPrimaryOrientation.getEndAfterPadding(); 
        } else {
          int j = this.mSpans[b].getStartLine(-2147483648);
          i = j;
          if (j != Integer.MIN_VALUE)
            i = j - this.mPrimaryOrientation.getStartAfterPadding(); 
        } 
        savedState.mSpanOffsets[b] = i;
        b++;
      } 
    } else {
      savedState.mAnchorPosition = -1;
      savedState.mVisibleAnchorPosition = -1;
      savedState.mSpanOffsetsSize = 0;
    } 
    return savedState;
  }
  
  public void onScrollStateChanged(int paramInt) {
    if (paramInt == 0)
      checkForGaps(); 
  }
  
  int scrollBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    if (paramInt > 0) {
      i = getLastChildPosition();
      j = 1;
    } else {
      i = getFirstChildPosition();
      j = -1;
    } 
    this.mLayoutState.mRecycle = true;
    updateLayoutState(i, paramState);
    setLayoutStateDirection(j);
    this.mLayoutState.mCurrentPosition = i + this.mLayoutState.mItemDirection;
    int i = Math.abs(paramInt);
    this.mLayoutState.mAvailable = i;
    int j = fill(paramRecycler, this.mLayoutState, paramState);
    if (i >= j)
      if (paramInt < 0) {
        paramInt = -j;
      } else {
        paramInt = j;
      }  
    this.mPrimaryOrientation.offsetChildren(-paramInt);
    this.mLastLayoutFromEnd = this.mShouldReverseLayout;
    return paramInt;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void scrollToPosition(int paramInt) {
    if (this.mPendingSavedState != null && this.mPendingSavedState.mAnchorPosition != paramInt)
      this.mPendingSavedState.invalidateAnchorPositionInfo(); 
    this.mPendingScrollPosition = paramInt;
    this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
    requestLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2) {
    if (this.mPendingSavedState != null)
      this.mPendingSavedState.invalidateAnchorPositionInfo(); 
    this.mPendingScrollPosition = paramInt1;
    this.mPendingScrollPositionOffset = paramInt2;
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void setGapStrategy(int paramInt) {
    assertNotInLayoutOrScroll((String)null);
    if (paramInt == this.mGapStrategy)
      return; 
    if (paramInt == 0 || paramInt == 2) {
      boolean bool;
      this.mGapStrategy = paramInt;
      if (this.mGapStrategy != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      setAutoMeasureEnabled(bool);
      requestLayout();
      return;
    } 
    throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2) {
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1) {
      paramInt2 = chooseSize(paramInt2, paramRect.height() + j, getMinimumHeight());
      paramInt1 = chooseSize(paramInt1, this.mSizePerSpan * this.mSpanCount + i, getMinimumWidth());
    } else {
      paramInt1 = chooseSize(paramInt1, paramRect.width() + i, getMinimumWidth());
      paramInt2 = chooseSize(paramInt2, this.mSizePerSpan * this.mSpanCount + j, getMinimumHeight());
    } 
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setOrientation(int paramInt) {
    if (paramInt == 0 || paramInt == 1) {
      assertNotInLayoutOrScroll((String)null);
      if (paramInt == this.mOrientation)
        return; 
      this.mOrientation = paramInt;
      OrientationHelper orientationHelper = this.mPrimaryOrientation;
      this.mPrimaryOrientation = this.mSecondaryOrientation;
      this.mSecondaryOrientation = orientationHelper;
      requestLayout();
      return;
    } 
    throw new IllegalArgumentException("invalid orientation.");
  }
  
  public void setReverseLayout(boolean paramBoolean) {
    assertNotInLayoutOrScroll((String)null);
    if (this.mPendingSavedState != null && this.mPendingSavedState.mReverseLayout != paramBoolean)
      this.mPendingSavedState.mReverseLayout = paramBoolean; 
    this.mReverseLayout = paramBoolean;
    requestLayout();
  }
  
  public void setSpanCount(int paramInt) {
    assertNotInLayoutOrScroll((String)null);
    if (paramInt != this.mSpanCount) {
      invalidateSpanAssignments();
      this.mSpanCount = paramInt;
      this.mRemainingSpans = new BitSet(this.mSpanCount);
      this.mSpans = new Span[this.mSpanCount];
      for (paramInt = 0; paramInt < this.mSpanCount; paramInt++)
        this.mSpans[paramInt] = new Span(paramInt); 
      requestLayout();
    } 
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt) {
    LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(paramRecyclerView.getContext()) {
        public PointF computeScrollVectorForPosition(int param1Int) {
          param1Int = StaggeredGridLayoutManager.this.calculateScrollDirectionForPosition(param1Int);
          return (param1Int == 0) ? null : ((StaggeredGridLayoutManager.this.mOrientation == 0) ? new PointF(param1Int, 0.0F) : new PointF(0.0F, param1Int));
        }
      };
    linearSmoothScroller.setTargetPosition(paramInt);
    startSmoothScroll(linearSmoothScroller);
  }
  
  public boolean supportsPredictiveItemAnimations() {
    boolean bool;
    if (this.mPendingSavedState == null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  boolean updateAnchorFromPendingData(RecyclerView.State paramState, AnchorInfo paramAnchorInfo) {
    boolean bool = paramState.isPreLayout();
    boolean bool1 = false;
    if (bool || this.mPendingScrollPosition == -1)
      return false; 
    if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= paramState.getItemCount()) {
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      return false;
    } 
    if (this.mPendingSavedState == null || this.mPendingSavedState.mAnchorPosition == -1 || this.mPendingSavedState.mSpanOffsetsSize < 1) {
      View view = findViewByPosition(this.mPendingScrollPosition);
      if (view != null) {
        if (this.mShouldReverseLayout) {
          i = getLastChildPosition();
        } else {
          i = getFirstChildPosition();
        } 
        paramAnchorInfo.mPosition = i;
        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
          if (paramAnchorInfo.mLayoutFromEnd) {
            paramAnchorInfo.mOffset = this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset - this.mPrimaryOrientation.getDecoratedEnd(view);
          } else {
            paramAnchorInfo.mOffset = this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset - this.mPrimaryOrientation.getDecoratedStart(view);
          } 
          return true;
        } 
        if (this.mPrimaryOrientation.getDecoratedMeasurement(view) > this.mPrimaryOrientation.getTotalSpace()) {
          if (paramAnchorInfo.mLayoutFromEnd) {
            i = this.mPrimaryOrientation.getEndAfterPadding();
          } else {
            i = this.mPrimaryOrientation.getStartAfterPadding();
          } 
          paramAnchorInfo.mOffset = i;
          return true;
        } 
        int i = this.mPrimaryOrientation.getDecoratedStart(view) - this.mPrimaryOrientation.getStartAfterPadding();
        if (i < 0) {
          paramAnchorInfo.mOffset = -i;
          return true;
        } 
        i = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(view);
        if (i < 0) {
          paramAnchorInfo.mOffset = i;
          return true;
        } 
        paramAnchorInfo.mOffset = Integer.MIN_VALUE;
      } else {
        paramAnchorInfo.mPosition = this.mPendingScrollPosition;
        if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
          if (calculateScrollDirectionForPosition(paramAnchorInfo.mPosition) == 1)
            bool1 = true; 
          paramAnchorInfo.mLayoutFromEnd = bool1;
          paramAnchorInfo.assignCoordinateFromPadding();
        } else {
          paramAnchorInfo.assignCoordinateFromPadding(this.mPendingScrollPositionOffset);
        } 
        paramAnchorInfo.mInvalidateOffsets = true;
      } 
      return true;
    } 
    paramAnchorInfo.mOffset = Integer.MIN_VALUE;
    paramAnchorInfo.mPosition = this.mPendingScrollPosition;
    return true;
  }
  
  void updateAnchorInfoForLayout(RecyclerView.State paramState, AnchorInfo paramAnchorInfo) {
    if (updateAnchorFromPendingData(paramState, paramAnchorInfo))
      return; 
    if (updateAnchorFromChildren(paramState, paramAnchorInfo))
      return; 
    paramAnchorInfo.assignCoordinateFromPadding();
    paramAnchorInfo.mPosition = 0;
  }
  
  void updateMeasureSpecs(int paramInt) {
    this.mSizePerSpan = paramInt / this.mSpanCount;
    this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(paramInt, this.mSecondaryOrientation.getMode());
  }
  
  class AnchorInfo {
    boolean mInvalidateOffsets;
    
    boolean mLayoutFromEnd;
    
    int mOffset;
    
    int mPosition;
    
    boolean mValid;
    
    public AnchorInfo() {
      reset();
    }
    
    void assignCoordinateFromPadding() {
      int i;
      if (this.mLayoutFromEnd) {
        i = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
      } else {
        i = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
      } 
      this.mOffset = i;
    }
    
    void assignCoordinateFromPadding(int param1Int) {
      if (this.mLayoutFromEnd) {
        this.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding() - param1Int;
      } else {
        this.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding() + param1Int;
      } 
    }
    
    void reset() {
      this.mPosition = -1;
      this.mOffset = Integer.MIN_VALUE;
      this.mLayoutFromEnd = false;
      this.mInvalidateOffsets = false;
      this.mValid = false;
    }
  }
  
  public static class LayoutParams extends RecyclerView.LayoutParams {
    public static final int INVALID_SPAN_ID = -1;
    
    boolean mFullSpan;
    
    StaggeredGridLayoutManager.Span mSpan;
    
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
    
    public LayoutParams(RecyclerView.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public final int getSpanIndex() {
      return (this.mSpan == null) ? -1 : this.mSpan.mIndex;
    }
    
    public boolean isFullSpan() {
      return this.mFullSpan;
    }
    
    public void setFullSpan(boolean param1Boolean) {
      this.mFullSpan = param1Boolean;
    }
  }
  
  static class LazySpanLookup {
    private static final int MIN_SIZE = 10;
    
    int[] mData;
    
    List<FullSpanItem> mFullSpanItems;
    
    private int invalidateFullSpansAfter(int param1Int) {
      // Byte code:
      //   0: aload_0
      //   1: getfield mFullSpanItems : Ljava/util/List;
      //   4: ifnonnull -> 9
      //   7: iconst_m1
      //   8: ireturn
      //   9: aload_0
      //   10: iload_1
      //   11: invokevirtual getFullSpanItem : (I)Lorg/jar/support/v7/widget/StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
      //   14: astore_2
      //   15: aload_2
      //   16: ifnull -> 30
      //   19: aload_0
      //   20: getfield mFullSpanItems : Ljava/util/List;
      //   23: aload_2
      //   24: invokeinterface remove : (Ljava/lang/Object;)Z
      //   29: pop
      //   30: aload_0
      //   31: getfield mFullSpanItems : Ljava/util/List;
      //   34: invokeinterface size : ()I
      //   39: istore_3
      //   40: iconst_0
      //   41: istore #4
      //   43: iload #4
      //   45: iload_3
      //   46: if_icmpge -> 79
      //   49: aload_0
      //   50: getfield mFullSpanItems : Ljava/util/List;
      //   53: iload #4
      //   55: invokeinterface get : (I)Ljava/lang/Object;
      //   60: checkcast org/jar/support/v7/widget/StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
      //   63: getfield mPosition : I
      //   66: iload_1
      //   67: if_icmplt -> 73
      //   70: goto -> 82
      //   73: iinc #4, 1
      //   76: goto -> 43
      //   79: iconst_m1
      //   80: istore #4
      //   82: iload #4
      //   84: iconst_m1
      //   85: if_icmpeq -> 120
      //   88: aload_0
      //   89: getfield mFullSpanItems : Ljava/util/List;
      //   92: iload #4
      //   94: invokeinterface get : (I)Ljava/lang/Object;
      //   99: checkcast org/jar/support/v7/widget/StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
      //   102: astore_2
      //   103: aload_0
      //   104: getfield mFullSpanItems : Ljava/util/List;
      //   107: iload #4
      //   109: invokeinterface remove : (I)Ljava/lang/Object;
      //   114: pop
      //   115: aload_2
      //   116: getfield mPosition : I
      //   119: ireturn
      //   120: iconst_m1
      //   121: ireturn
    }
    
    private void offsetFullSpansForAddition(int param1Int1, int param1Int2) {
      if (this.mFullSpanItems == null)
        return; 
      for (int i = this.mFullSpanItems.size() - 1; i >= 0; i--) {
        FullSpanItem fullSpanItem = this.mFullSpanItems.get(i);
        if (fullSpanItem.mPosition >= param1Int1)
          fullSpanItem.mPosition += param1Int2; 
      } 
    }
    
    private void offsetFullSpansForRemoval(int param1Int1, int param1Int2) {
      if (this.mFullSpanItems == null)
        return; 
      for (int i = this.mFullSpanItems.size() - 1; i >= 0; i--) {
        FullSpanItem fullSpanItem = this.mFullSpanItems.get(i);
        if (fullSpanItem.mPosition >= param1Int1)
          if (fullSpanItem.mPosition < param1Int1 + param1Int2) {
            this.mFullSpanItems.remove(i);
          } else {
            fullSpanItem.mPosition -= param1Int2;
          }  
      } 
    }
    
    public void addFullSpanItem(FullSpanItem param1FullSpanItem) {
      if (this.mFullSpanItems == null)
        this.mFullSpanItems = new ArrayList<FullSpanItem>(); 
      int i = this.mFullSpanItems.size();
      for (byte b = 0; b < i; b++) {
        FullSpanItem fullSpanItem = this.mFullSpanItems.get(b);
        if (fullSpanItem.mPosition == param1FullSpanItem.mPosition)
          this.mFullSpanItems.remove(b); 
        if (fullSpanItem.mPosition >= param1FullSpanItem.mPosition) {
          this.mFullSpanItems.add(b, param1FullSpanItem);
          return;
        } 
      } 
      this.mFullSpanItems.add(param1FullSpanItem);
    }
    
    void clear() {
      if (this.mData != null)
        Arrays.fill(this.mData, -1); 
      this.mFullSpanItems = null;
    }
    
    void ensureSize(int param1Int) {
      if (this.mData == null) {
        this.mData = new int[Math.max(param1Int, 10) + 1];
        Arrays.fill(this.mData, -1);
      } else if (param1Int >= this.mData.length) {
        int[] arrayOfInt = this.mData;
        this.mData = new int[sizeForPosition(param1Int)];
        System.arraycopy(arrayOfInt, 0, this.mData, 0, arrayOfInt.length);
        Arrays.fill(this.mData, arrayOfInt.length, this.mData.length, -1);
      } 
    }
    
    int forceInvalidateAfter(int param1Int) {
      if (this.mFullSpanItems != null)
        for (int i = this.mFullSpanItems.size() - 1; i >= 0; i--) {
          if (((FullSpanItem)this.mFullSpanItems.get(i)).mPosition >= param1Int)
            this.mFullSpanItems.remove(i); 
        }  
      return invalidateAfter(param1Int);
    }
    
    public FullSpanItem getFirstFullSpanItemInRange(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean) {
      if (this.mFullSpanItems == null)
        return null; 
      int i = this.mFullSpanItems.size();
      for (byte b = 0; b < i; b++) {
        FullSpanItem fullSpanItem = this.mFullSpanItems.get(b);
        if (fullSpanItem.mPosition >= param1Int2)
          return null; 
        if (fullSpanItem.mPosition >= param1Int1 && (param1Int3 == 0 || fullSpanItem.mGapDir == param1Int3 || (param1Boolean && fullSpanItem.mHasUnwantedGapAfter)))
          return fullSpanItem; 
      } 
      return null;
    }
    
    public FullSpanItem getFullSpanItem(int param1Int) {
      if (this.mFullSpanItems == null)
        return null; 
      for (int i = this.mFullSpanItems.size() - 1; i >= 0; i--) {
        FullSpanItem fullSpanItem = this.mFullSpanItems.get(i);
        if (fullSpanItem.mPosition == param1Int)
          return fullSpanItem; 
      } 
      return null;
    }
    
    int getSpan(int param1Int) {
      return (this.mData == null || param1Int >= this.mData.length) ? -1 : this.mData[param1Int];
    }
    
    int invalidateAfter(int param1Int) {
      if (this.mData == null)
        return -1; 
      if (param1Int >= this.mData.length)
        return -1; 
      int i = invalidateFullSpansAfter(param1Int);
      if (i == -1) {
        Arrays.fill(this.mData, param1Int, this.mData.length, -1);
        return this.mData.length;
      } 
      int[] arrayOfInt = this.mData;
      Arrays.fill(arrayOfInt, param1Int, ++i, -1);
      return i;
    }
    
    void offsetForAddition(int param1Int1, int param1Int2) {
      if (this.mData == null || param1Int1 >= this.mData.length)
        return; 
      int i = param1Int1 + param1Int2;
      ensureSize(i);
      System.arraycopy(this.mData, param1Int1, this.mData, i, this.mData.length - param1Int1 - param1Int2);
      Arrays.fill(this.mData, param1Int1, i, -1);
      offsetFullSpansForAddition(param1Int1, param1Int2);
    }
    
    void offsetForRemoval(int param1Int1, int param1Int2) {
      if (this.mData == null || param1Int1 >= this.mData.length)
        return; 
      int i = param1Int1 + param1Int2;
      ensureSize(i);
      System.arraycopy(this.mData, i, this.mData, param1Int1, this.mData.length - param1Int1 - param1Int2);
      Arrays.fill(this.mData, this.mData.length - param1Int2, this.mData.length, -1);
      offsetFullSpansForRemoval(param1Int1, param1Int2);
    }
    
    void setSpan(int param1Int, StaggeredGridLayoutManager.Span param1Span) {
      ensureSize(param1Int);
      this.mData[param1Int] = param1Span.mIndex;
    }
    
    int sizeForPosition(int param1Int) {
      int i;
      for (i = this.mData.length; i <= param1Int; i *= 2);
      return i;
    }
    
    static class FullSpanItem implements Parcelable {
      public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
          public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFromParcel(Parcel param3Parcel) {
            return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(param3Parcel);
          }
          
          public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] newArray(int param3Int) {
            return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[param3Int];
          }
        };
      
      int mGapDir;
      
      int[] mGapPerSpan;
      
      boolean mHasUnwantedGapAfter;
      
      int mPosition;
      
      public FullSpanItem() {}
      
      public FullSpanItem(Parcel param2Parcel) {
        this.mPosition = param2Parcel.readInt();
        this.mGapDir = param2Parcel.readInt();
        int i = param2Parcel.readInt();
        boolean bool = true;
        if (i != 1)
          bool = false; 
        this.mHasUnwantedGapAfter = bool;
        i = param2Parcel.readInt();
        if (i > 0) {
          this.mGapPerSpan = new int[i];
          param2Parcel.readIntArray(this.mGapPerSpan);
        } 
      }
      
      public int describeContents() {
        return 0;
      }
      
      int getGapForSpan(int param2Int) {
        if (this.mGapPerSpan == null) {
          param2Int = 0;
        } else {
          param2Int = this.mGapPerSpan[param2Int];
        } 
        return param2Int;
      }
      
      public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FullSpanItem{mPosition=");
        stringBuilder.append(this.mPosition);
        stringBuilder.append(", mGapDir=");
        stringBuilder.append(this.mGapDir);
        stringBuilder.append(", mHasUnwantedGapAfter=");
        stringBuilder.append(this.mHasUnwantedGapAfter);
        stringBuilder.append(", mGapPerSpan=");
        stringBuilder.append(Arrays.toString(this.mGapPerSpan));
        stringBuilder.append('}');
        return stringBuilder.toString();
      }
      
      public void writeToParcel(Parcel param2Parcel, int param2Int) {
        param2Parcel.writeInt(this.mPosition);
        param2Parcel.writeInt(this.mGapDir);
        param2Parcel.writeInt(this.mHasUnwantedGapAfter);
        if (this.mGapPerSpan != null && this.mGapPerSpan.length > 0) {
          param2Parcel.writeInt(this.mGapPerSpan.length);
          param2Parcel.writeIntArray(this.mGapPerSpan);
        } else {
          param2Parcel.writeInt(0);
        } 
      }
    }
    
    static final class null implements Parcelable.Creator<FullSpanItem> {
      public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFromParcel(Parcel param2Parcel) {
        return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(param2Parcel);
      }
      
      public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] newArray(int param2Int) {
        return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[param2Int];
      }
    }
  }
  
  static class FullSpanItem implements Parcelable {
    public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
        public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFromParcel(Parcel param3Parcel) {
          return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(param3Parcel);
        }
        
        public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] newArray(int param3Int) {
          return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[param3Int];
        }
      };
    
    int mGapDir;
    
    int[] mGapPerSpan;
    
    boolean mHasUnwantedGapAfter;
    
    int mPosition;
    
    public FullSpanItem() {}
    
    public FullSpanItem(Parcel param1Parcel) {
      this.mPosition = param1Parcel.readInt();
      this.mGapDir = param1Parcel.readInt();
      int i = param1Parcel.readInt();
      boolean bool = true;
      if (i != 1)
        bool = false; 
      this.mHasUnwantedGapAfter = bool;
      i = param1Parcel.readInt();
      if (i > 0) {
        this.mGapPerSpan = new int[i];
        param1Parcel.readIntArray(this.mGapPerSpan);
      } 
    }
    
    public int describeContents() {
      return 0;
    }
    
    int getGapForSpan(int param1Int) {
      if (this.mGapPerSpan == null) {
        param1Int = 0;
      } else {
        param1Int = this.mGapPerSpan[param1Int];
      } 
      return param1Int;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("FullSpanItem{mPosition=");
      stringBuilder.append(this.mPosition);
      stringBuilder.append(", mGapDir=");
      stringBuilder.append(this.mGapDir);
      stringBuilder.append(", mHasUnwantedGapAfter=");
      stringBuilder.append(this.mHasUnwantedGapAfter);
      stringBuilder.append(", mGapPerSpan=");
      stringBuilder.append(Arrays.toString(this.mGapPerSpan));
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeInt(this.mPosition);
      param1Parcel.writeInt(this.mGapDir);
      param1Parcel.writeInt(this.mHasUnwantedGapAfter);
      if (this.mGapPerSpan != null && this.mGapPerSpan.length > 0) {
        param1Parcel.writeInt(this.mGapPerSpan.length);
        param1Parcel.writeIntArray(this.mGapPerSpan);
      } else {
        param1Parcel.writeInt(0);
      } 
    }
  }
  
  static final class null implements Parcelable.Creator<LazySpanLookup.FullSpanItem> {
    public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFromParcel(Parcel param1Parcel) {
      return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(param1Parcel);
    }
    
    public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] newArray(int param1Int) {
      return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[param1Int];
    }
  }
  
  public static class SavedState implements Parcelable {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public StaggeredGridLayoutManager.SavedState createFromParcel(Parcel param2Parcel) {
          return new StaggeredGridLayoutManager.SavedState(param2Parcel);
        }
        
        public StaggeredGridLayoutManager.SavedState[] newArray(int param2Int) {
          return new StaggeredGridLayoutManager.SavedState[param2Int];
        }
      };
    
    boolean mAnchorLayoutFromEnd;
    
    int mAnchorPosition;
    
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> mFullSpanItems;
    
    boolean mLastLayoutRTL;
    
    boolean mReverseLayout;
    
    int[] mSpanLookup;
    
    int mSpanLookupSize;
    
    int[] mSpanOffsets;
    
    int mSpanOffsetsSize;
    
    int mVisibleAnchorPosition;
    
    public SavedState() {}
    
    SavedState(Parcel param1Parcel) {
      this.mAnchorPosition = param1Parcel.readInt();
      this.mVisibleAnchorPosition = param1Parcel.readInt();
      this.mSpanOffsetsSize = param1Parcel.readInt();
      if (this.mSpanOffsetsSize > 0) {
        this.mSpanOffsets = new int[this.mSpanOffsetsSize];
        param1Parcel.readIntArray(this.mSpanOffsets);
      } 
      this.mSpanLookupSize = param1Parcel.readInt();
      if (this.mSpanLookupSize > 0) {
        this.mSpanLookup = new int[this.mSpanLookupSize];
        param1Parcel.readIntArray(this.mSpanLookup);
      } 
      int i = param1Parcel.readInt();
      boolean bool1 = false;
      if (i == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      this.mReverseLayout = bool2;
      if (param1Parcel.readInt() == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      this.mAnchorLayoutFromEnd = bool2;
      boolean bool2 = bool1;
      if (param1Parcel.readInt() == 1)
        bool2 = true; 
      this.mLastLayoutRTL = bool2;
      this.mFullSpanItems = param1Parcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
    }
    
    public SavedState(SavedState param1SavedState) {
      this.mSpanOffsetsSize = param1SavedState.mSpanOffsetsSize;
      this.mAnchorPosition = param1SavedState.mAnchorPosition;
      this.mVisibleAnchorPosition = param1SavedState.mVisibleAnchorPosition;
      this.mSpanOffsets = param1SavedState.mSpanOffsets;
      this.mSpanLookupSize = param1SavedState.mSpanLookupSize;
      this.mSpanLookup = param1SavedState.mSpanLookup;
      this.mReverseLayout = param1SavedState.mReverseLayout;
      this.mAnchorLayoutFromEnd = param1SavedState.mAnchorLayoutFromEnd;
      this.mLastLayoutRTL = param1SavedState.mLastLayoutRTL;
      this.mFullSpanItems = param1SavedState.mFullSpanItems;
    }
    
    public int describeContents() {
      return 0;
    }
    
    void invalidateAnchorPositionInfo() {
      this.mSpanOffsets = null;
      this.mSpanOffsetsSize = 0;
      this.mAnchorPosition = -1;
      this.mVisibleAnchorPosition = -1;
    }
    
    void invalidateSpanInfo() {
      this.mSpanOffsets = null;
      this.mSpanOffsetsSize = 0;
      this.mSpanLookupSize = 0;
      this.mSpanLookup = null;
      this.mFullSpanItems = null;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeInt(this.mAnchorPosition);
      param1Parcel.writeInt(this.mVisibleAnchorPosition);
      param1Parcel.writeInt(this.mSpanOffsetsSize);
      if (this.mSpanOffsetsSize > 0)
        param1Parcel.writeIntArray(this.mSpanOffsets); 
      param1Parcel.writeInt(this.mSpanLookupSize);
      if (this.mSpanLookupSize > 0)
        param1Parcel.writeIntArray(this.mSpanLookup); 
      param1Parcel.writeInt(this.mReverseLayout);
      param1Parcel.writeInt(this.mAnchorLayoutFromEnd);
      param1Parcel.writeInt(this.mLastLayoutRTL);
      param1Parcel.writeList(this.mFullSpanItems);
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public StaggeredGridLayoutManager.SavedState createFromParcel(Parcel param1Parcel) {
      return new StaggeredGridLayoutManager.SavedState(param1Parcel);
    }
    
    public StaggeredGridLayoutManager.SavedState[] newArray(int param1Int) {
      return new StaggeredGridLayoutManager.SavedState[param1Int];
    }
  }
  
  class Span {
    static final int INVALID_LINE = -2147483648;
    
    int mCachedEnd = Integer.MIN_VALUE;
    
    int mCachedStart = Integer.MIN_VALUE;
    
    int mDeletedSize = 0;
    
    final int mIndex;
    
    private ArrayList<View> mViews = new ArrayList<View>();
    
    private Span(int param1Int) {
      this.mIndex = param1Int;
    }
    
    void appendToSpan(View param1View) {
      StaggeredGridLayoutManager.LayoutParams layoutParams = getLayoutParams(param1View);
      layoutParams.mSpan = this;
      this.mViews.add(param1View);
      this.mCachedEnd = Integer.MIN_VALUE;
      if (this.mViews.size() == 1)
        this.mCachedStart = Integer.MIN_VALUE; 
      if (layoutParams.isItemRemoved() || layoutParams.isItemChanged())
        this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(param1View); 
    }
    
    void cacheReferenceLineAndClear(boolean param1Boolean, int param1Int) {
      int i;
      if (param1Boolean) {
        i = getEndLine(-2147483648);
      } else {
        i = getStartLine(-2147483648);
      } 
      clear();
      if (i == Integer.MIN_VALUE)
        return; 
      if ((param1Boolean && i < StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding()) || (!param1Boolean && i > StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding()))
        return; 
      int j = i;
      if (param1Int != Integer.MIN_VALUE)
        j = i + param1Int; 
      this.mCachedEnd = j;
      this.mCachedStart = j;
    }
    
    void calculateCachedEnd() {
      View view = this.mViews.get(this.mViews.size() - 1);
      StaggeredGridLayoutManager.LayoutParams layoutParams = getLayoutParams(view);
      this.mCachedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
      if (layoutParams.mFullSpan) {
        StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition());
        if (fullSpanItem != null && fullSpanItem.mGapDir == 1)
          this.mCachedEnd += fullSpanItem.getGapForSpan(this.mIndex); 
      } 
    }
    
    void calculateCachedStart() {
      View view = this.mViews.get(0);
      StaggeredGridLayoutManager.LayoutParams layoutParams = getLayoutParams(view);
      this.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
      if (layoutParams.mFullSpan) {
        StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition());
        if (fullSpanItem != null && fullSpanItem.mGapDir == -1)
          this.mCachedStart -= fullSpanItem.getGapForSpan(this.mIndex); 
      } 
    }
    
    void clear() {
      this.mViews.clear();
      invalidateCache();
      this.mDeletedSize = 0;
    }
    
    public int findFirstCompletelyVisibleItemPosition() {
      int i;
      if (StaggeredGridLayoutManager.this.mReverseLayout) {
        i = findOneVisibleChild(this.mViews.size() - 1, -1, true);
      } else {
        i = findOneVisibleChild(0, this.mViews.size(), true);
      } 
      return i;
    }
    
    public int findFirstVisibleItemPosition() {
      int i;
      if (StaggeredGridLayoutManager.this.mReverseLayout) {
        i = findOneVisibleChild(this.mViews.size() - 1, -1, false);
      } else {
        i = findOneVisibleChild(0, this.mViews.size(), false);
      } 
      return i;
    }
    
    public int findLastCompletelyVisibleItemPosition() {
      int i;
      if (StaggeredGridLayoutManager.this.mReverseLayout) {
        i = findOneVisibleChild(0, this.mViews.size(), true);
      } else {
        i = findOneVisibleChild(this.mViews.size() - 1, -1, true);
      } 
      return i;
    }
    
    public int findLastVisibleItemPosition() {
      int i;
      if (StaggeredGridLayoutManager.this.mReverseLayout) {
        i = findOneVisibleChild(0, this.mViews.size(), false);
      } else {
        i = findOneVisibleChild(this.mViews.size() - 1, -1, false);
      } 
      return i;
    }
    
    int findOneVisibleChild(int param1Int1, int param1Int2, boolean param1Boolean) {
      byte b;
      int i = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
      int j = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
      if (param1Int2 > param1Int1) {
        b = 1;
      } else {
        b = -1;
      } 
      while (param1Int1 != param1Int2) {
        View view = this.mViews.get(param1Int1);
        int k = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
        int m = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
        if (k < j && m > i)
          if (param1Boolean) {
            if (k >= i && m <= j)
              return StaggeredGridLayoutManager.this.getPosition(view); 
          } else {
            return StaggeredGridLayoutManager.this.getPosition(view);
          }  
        param1Int1 += b;
      } 
      return -1;
    }
    
    public int getDeletedSize() {
      return this.mDeletedSize;
    }
    
    int getEndLine() {
      if (this.mCachedEnd != Integer.MIN_VALUE)
        return this.mCachedEnd; 
      calculateCachedEnd();
      return this.mCachedEnd;
    }
    
    int getEndLine(int param1Int) {
      if (this.mCachedEnd != Integer.MIN_VALUE)
        return this.mCachedEnd; 
      if (this.mViews.size() == 0)
        return param1Int; 
      calculateCachedEnd();
      return this.mCachedEnd;
    }
    
    public View getFocusableViewAfter(int param1Int1, int param1Int2) {
      View view1 = null;
      View view2 = null;
      if (param1Int2 == -1) {
        int i = this.mViews.size();
        param1Int2 = 0;
        while (true) {
          view1 = view2;
          if (param1Int2 < i) {
            View view = this.mViews.get(param1Int2);
            view1 = view2;
            if (view.isFocusable()) {
              boolean bool;
              if (StaggeredGridLayoutManager.this.getPosition(view) > param1Int1) {
                bool = true;
              } else {
                bool = false;
              } 
              view1 = view2;
              if (bool == StaggeredGridLayoutManager.this.mReverseLayout) {
                param1Int2++;
                view2 = view;
                continue;
              } 
            } 
          } 
          break;
        } 
      } else {
        param1Int2 = this.mViews.size() - 1;
        view2 = view1;
        while (true) {
          view1 = view2;
          if (param1Int2 >= 0) {
            View view = this.mViews.get(param1Int2);
            view1 = view2;
            if (view.isFocusable()) {
              boolean bool;
              if (StaggeredGridLayoutManager.this.getPosition(view) > param1Int1) {
                bool = true;
              } else {
                bool = false;
              } 
              view1 = view2;
              if (bool == (StaggeredGridLayoutManager.this.mReverseLayout ^ true)) {
                param1Int2--;
                view2 = view;
                continue;
              } 
            } 
          } 
          break;
        } 
      } 
      return view1;
    }
    
    StaggeredGridLayoutManager.LayoutParams getLayoutParams(View param1View) {
      return (StaggeredGridLayoutManager.LayoutParams)param1View.getLayoutParams();
    }
    
    int getStartLine() {
      if (this.mCachedStart != Integer.MIN_VALUE)
        return this.mCachedStart; 
      calculateCachedStart();
      return this.mCachedStart;
    }
    
    int getStartLine(int param1Int) {
      if (this.mCachedStart != Integer.MIN_VALUE)
        return this.mCachedStart; 
      if (this.mViews.size() == 0)
        return param1Int; 
      calculateCachedStart();
      return this.mCachedStart;
    }
    
    void invalidateCache() {
      this.mCachedStart = Integer.MIN_VALUE;
      this.mCachedEnd = Integer.MIN_VALUE;
    }
    
    void onOffset(int param1Int) {
      if (this.mCachedStart != Integer.MIN_VALUE)
        this.mCachedStart += param1Int; 
      if (this.mCachedEnd != Integer.MIN_VALUE)
        this.mCachedEnd += param1Int; 
    }
    
    void popEnd() {
      int i = this.mViews.size();
      View view = this.mViews.remove(i - 1);
      StaggeredGridLayoutManager.LayoutParams layoutParams = getLayoutParams(view);
      layoutParams.mSpan = null;
      if (layoutParams.isItemRemoved() || layoutParams.isItemChanged())
        this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view); 
      if (i == 1)
        this.mCachedStart = Integer.MIN_VALUE; 
      this.mCachedEnd = Integer.MIN_VALUE;
    }
    
    void popStart() {
      View view = this.mViews.remove(0);
      StaggeredGridLayoutManager.LayoutParams layoutParams = getLayoutParams(view);
      layoutParams.mSpan = null;
      if (this.mViews.size() == 0)
        this.mCachedEnd = Integer.MIN_VALUE; 
      if (layoutParams.isItemRemoved() || layoutParams.isItemChanged())
        this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view); 
      this.mCachedStart = Integer.MIN_VALUE;
    }
    
    void prependToSpan(View param1View) {
      StaggeredGridLayoutManager.LayoutParams layoutParams = getLayoutParams(param1View);
      layoutParams.mSpan = this;
      this.mViews.add(0, param1View);
      this.mCachedStart = Integer.MIN_VALUE;
      if (this.mViews.size() == 1)
        this.mCachedEnd = Integer.MIN_VALUE; 
      if (layoutParams.isItemRemoved() || layoutParams.isItemChanged())
        this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(param1View); 
    }
    
    void setLine(int param1Int) {
      this.mCachedStart = param1Int;
      this.mCachedEnd = param1Int;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v7\widget\StaggeredGridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */