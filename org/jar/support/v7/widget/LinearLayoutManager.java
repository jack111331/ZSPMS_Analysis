package org.jar.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.util.List;
import org.jar.support.v7.widget.helper.ItemTouchHelper;

public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler {
  private static final boolean DEBUG = false;
  
  public static final int HORIZONTAL = 0;
  
  public static final int INVALID_OFFSET = -2147483648;
  
  private static final float MAX_SCROLL_FACTOR = 0.33333334F;
  
  private static final String TAG = "LinearLayoutManager";
  
  public static final int VERTICAL = 1;
  
  final AnchorInfo mAnchorInfo = new AnchorInfo();
  
  private boolean mLastStackFromEnd;
  
  private LayoutState mLayoutState;
  
  int mOrientation;
  
  OrientationHelper mOrientationHelper;
  
  SavedState mPendingSavedState = null;
  
  int mPendingScrollPosition = -1;
  
  int mPendingScrollPositionOffset = Integer.MIN_VALUE;
  
  private boolean mRecycleChildrenOnDetach;
  
  private boolean mReverseLayout = false;
  
  boolean mShouldReverseLayout = false;
  
  private boolean mSmoothScrollbarEnabled = true;
  
  private boolean mStackFromEnd = false;
  
  public LinearLayoutManager(Context paramContext) {
    this(paramContext, 1, false);
  }
  
  public LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean) {
    setOrientation(paramInt);
    setReverseLayout(paramBoolean);
    setAutoMeasureEnabled(true);
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    setAutoMeasureEnabled(true);
  }
  
  private int computeScrollExtent(RecyclerView.State paramState) {
    if (getChildCount() == 0)
      return 0; 
    ensureLayoutState();
    return ScrollbarHelper.computeScrollExtent(paramState, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled);
  }
  
  private int computeScrollOffset(RecyclerView.State paramState) {
    if (getChildCount() == 0)
      return 0; 
    ensureLayoutState();
    return ScrollbarHelper.computeScrollOffset(paramState, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
  }
  
  private int computeScrollRange(RecyclerView.State paramState) {
    if (getChildCount() == 0)
      return 0; 
    ensureLayoutState();
    return ScrollbarHelper.computeScrollRange(paramState, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled);
  }
  
  private View findFirstReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return findReferenceChild(paramRecycler, paramState, 0, getChildCount(), paramState.getItemCount());
  }
  
  private View findFirstVisibleChildClosestToEnd(boolean paramBoolean1, boolean paramBoolean2) {
    return this.mShouldReverseLayout ? findOneVisibleChild(0, getChildCount(), paramBoolean1, paramBoolean2) : findOneVisibleChild(getChildCount() - 1, -1, paramBoolean1, paramBoolean2);
  }
  
  private View findFirstVisibleChildClosestToStart(boolean paramBoolean1, boolean paramBoolean2) {
    return this.mShouldReverseLayout ? findOneVisibleChild(getChildCount() - 1, -1, paramBoolean1, paramBoolean2) : findOneVisibleChild(0, getChildCount(), paramBoolean1, paramBoolean2);
  }
  
  private View findLastReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return findReferenceChild(paramRecycler, paramState, getChildCount() - 1, -1, paramState.getItemCount());
  }
  
  private View findReferenceChildClosestToEnd(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    View view;
    if (this.mShouldReverseLayout) {
      view = findFirstReferenceChild(paramRecycler, paramState);
    } else {
      view = findLastReferenceChild((RecyclerView.Recycler)view, paramState);
    } 
    return view;
  }
  
  private View findReferenceChildClosestToStart(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    View view;
    if (this.mShouldReverseLayout) {
      view = findLastReferenceChild(paramRecycler, paramState);
    } else {
      view = findFirstReferenceChild((RecyclerView.Recycler)view, paramState);
    } 
    return view;
  }
  
  private int fixLayoutEndGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean) {
    int i = this.mOrientationHelper.getEndAfterPadding() - paramInt;
    if (i > 0) {
      i = -scrollBy(-i, paramRecycler, paramState);
      if (paramBoolean) {
        paramInt = this.mOrientationHelper.getEndAfterPadding() - paramInt + i;
        if (paramInt > 0) {
          this.mOrientationHelper.offsetChildren(paramInt);
          return paramInt + i;
        } 
      } 
      return i;
    } 
    return 0;
  }
  
  private int fixLayoutStartGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean) {
    int i = paramInt - this.mOrientationHelper.getStartAfterPadding();
    if (i > 0) {
      i = -scrollBy(i, paramRecycler, paramState);
      if (paramBoolean) {
        paramInt = paramInt + i - this.mOrientationHelper.getStartAfterPadding();
        if (paramInt > 0) {
          this.mOrientationHelper.offsetChildren(-paramInt);
          return i - paramInt;
        } 
      } 
      return i;
    } 
    return 0;
  }
  
  private View getChildClosestToEnd() {
    int i;
    if (this.mShouldReverseLayout) {
      i = 0;
    } else {
      i = getChildCount() - 1;
    } 
    return getChildAt(i);
  }
  
  private View getChildClosestToStart() {
    boolean bool;
    if (this.mShouldReverseLayout) {
      bool = getChildCount() - 1;
    } else {
      bool = false;
    } 
    return getChildAt(bool);
  }
  
  private void layoutForPredictiveAnimations(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2) {
    if (!paramState.willRunPredictiveAnimations() || getChildCount() == 0 || paramState.isPreLayout() || !supportsPredictiveItemAnimations())
      return; 
    List<RecyclerView.ViewHolder> list = paramRecycler.getScrapList();
    int i = list.size();
    int j = getPosition(getChildAt(0));
    byte b = 0;
    int k = 0;
    int m = 0;
    while (b < i) {
      RecyclerView.ViewHolder viewHolder = list.get(b);
      if (!viewHolder.isRemoved()) {
        boolean bool;
        int n = viewHolder.getLayoutPosition();
        byte b1 = 1;
        if (n < j) {
          bool = true;
        } else {
          bool = false;
        } 
        if (bool != this.mShouldReverseLayout)
          b1 = -1; 
        if (b1 == -1) {
          k += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
        } else {
          m += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
        } 
      } 
      b++;
    } 
    this.mLayoutState.mScrapList = list;
    if (k > 0) {
      updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), paramInt1);
      this.mLayoutState.mExtra = k;
      this.mLayoutState.mAvailable = 0;
      this.mLayoutState.assignPositionFromScrapList();
      fill(paramRecycler, this.mLayoutState, paramState, false);
    } 
    if (m > 0) {
      updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), paramInt2);
      this.mLayoutState.mExtra = m;
      this.mLayoutState.mAvailable = 0;
      this.mLayoutState.assignPositionFromScrapList();
      fill(paramRecycler, this.mLayoutState, paramState, false);
    } 
    this.mLayoutState.mScrapList = null;
  }
  
  private void logChildren() {
    Log.d("LinearLayoutManager", "internal representation of views on the screen");
    for (byte b = 0; b < getChildCount(); b++) {
      View view = getChildAt(b);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("item ");
      stringBuilder.append(getPosition(view));
      stringBuilder.append(", coord:");
      stringBuilder.append(this.mOrientationHelper.getDecoratedStart(view));
      Log.d("LinearLayoutManager", stringBuilder.toString());
    } 
    Log.d("LinearLayoutManager", "==============");
  }
  
  private void recycleByLayoutState(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState) {
    if (!paramLayoutState.mRecycle || paramLayoutState.mInfinite)
      return; 
    if (paramLayoutState.mLayoutDirection == -1) {
      recycleViewsFromEnd(paramRecycler, paramLayoutState.mScrollingOffset);
    } else {
      recycleViewsFromStart(paramRecycler, paramLayoutState.mScrollingOffset);
    } 
  }
  
  private void recycleChildren(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2) {
    if (paramInt1 == paramInt2)
      return; 
    int i = paramInt1;
    if (paramInt2 > paramInt1) {
      while (--paramInt2 >= paramInt1) {
        removeAndRecycleViewAt(paramInt2, paramRecycler);
        paramInt2--;
      } 
    } else {
      while (i > paramInt2) {
        removeAndRecycleViewAt(i, paramRecycler);
        i--;
      } 
    } 
  }
  
  private void recycleViewsFromEnd(RecyclerView.Recycler paramRecycler, int paramInt) {
    int i = getChildCount();
    if (paramInt < 0)
      return; 
    int j = this.mOrientationHelper.getEnd() - paramInt;
    if (this.mShouldReverseLayout) {
      for (paramInt = 0; paramInt < i; paramInt++) {
        View view = getChildAt(paramInt);
        if (this.mOrientationHelper.getDecoratedStart(view) < j || this.mOrientationHelper.getTransformedStartWithDecoration(view) < j) {
          recycleChildren(paramRecycler, 0, paramInt);
          return;
        } 
      } 
    } else {
      for (paramInt = --i; paramInt >= 0; paramInt--) {
        View view = getChildAt(paramInt);
        if (this.mOrientationHelper.getDecoratedStart(view) < j || this.mOrientationHelper.getTransformedStartWithDecoration(view) < j) {
          recycleChildren(paramRecycler, i, paramInt);
          return;
        } 
      } 
    } 
  }
  
  private void recycleViewsFromStart(RecyclerView.Recycler paramRecycler, int paramInt) {
    if (paramInt < 0)
      return; 
    int i = getChildCount();
    if (this.mShouldReverseLayout) {
      for (int j = --i; j >= 0; j--) {
        View view = getChildAt(j);
        if (this.mOrientationHelper.getDecoratedEnd(view) > paramInt || this.mOrientationHelper.getTransformedEndWithDecoration(view) > paramInt) {
          recycleChildren(paramRecycler, i, j);
          return;
        } 
      } 
    } else {
      for (byte b = 0; b < i; b++) {
        View view = getChildAt(b);
        if (this.mOrientationHelper.getDecoratedEnd(view) > paramInt || this.mOrientationHelper.getTransformedEndWithDecoration(view) > paramInt) {
          recycleChildren(paramRecycler, 0, b);
          return;
        } 
      } 
    } 
  }
  
  private void resolveShouldLayoutReverse() {
    if (this.mOrientation == 1 || !isLayoutRTL()) {
      this.mShouldReverseLayout = this.mReverseLayout;
      return;
    } 
    this.mShouldReverseLayout = this.mReverseLayout ^ true;
  }
  
  private boolean updateAnchorFromChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AnchorInfo paramAnchorInfo) {
    View view1;
    int i = getChildCount();
    int j = 0;
    if (i == 0)
      return false; 
    View view2 = getFocusedChild();
    if (view2 != null && paramAnchorInfo.isViewValidAsAnchor(view2, paramState)) {
      paramAnchorInfo.assignFromViewAndKeepVisibleRect(view2);
      return true;
    } 
    if (this.mLastStackFromEnd != this.mStackFromEnd)
      return false; 
    if (paramAnchorInfo.mLayoutFromEnd) {
      view1 = findReferenceChildClosestToEnd(paramRecycler, paramState);
    } else {
      view1 = findReferenceChildClosestToStart((RecyclerView.Recycler)view1, paramState);
    } 
    if (view1 != null) {
      paramAnchorInfo.assignFromView(view1);
      if (!paramState.isPreLayout() && supportsPredictiveItemAnimations()) {
        if (this.mOrientationHelper.getDecoratedStart(view1) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(view1) < this.mOrientationHelper.getStartAfterPadding())
          j = 1; 
        if (j) {
          if (paramAnchorInfo.mLayoutFromEnd) {
            j = this.mOrientationHelper.getEndAfterPadding();
          } else {
            j = this.mOrientationHelper.getStartAfterPadding();
          } 
          paramAnchorInfo.mCoordinate = j;
        } 
      } 
      return true;
    } 
    return false;
  }
  
  private boolean updateAnchorFromPendingData(RecyclerView.State paramState, AnchorInfo paramAnchorInfo) {
    boolean bool = paramState.isPreLayout();
    boolean bool1 = false;
    if (bool || this.mPendingScrollPosition == -1)
      return false; 
    if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= paramState.getItemCount()) {
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      return false;
    } 
    paramAnchorInfo.mPosition = this.mPendingScrollPosition;
    if (this.mPendingSavedState != null && this.mPendingSavedState.hasValidAnchor()) {
      paramAnchorInfo.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
      if (paramAnchorInfo.mLayoutFromEnd) {
        paramAnchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
      } else {
        paramAnchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
      } 
      return true;
    } 
    if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
      View view = findViewByPosition(this.mPendingScrollPosition);
      if (view != null) {
        int i;
        if (this.mOrientationHelper.getDecoratedMeasurement(view) > this.mOrientationHelper.getTotalSpace()) {
          paramAnchorInfo.assignCoordinateFromPadding();
          return true;
        } 
        if (this.mOrientationHelper.getDecoratedStart(view) - this.mOrientationHelper.getStartAfterPadding() < 0) {
          paramAnchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
          paramAnchorInfo.mLayoutFromEnd = false;
          return true;
        } 
        if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view) < 0) {
          paramAnchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
          paramAnchorInfo.mLayoutFromEnd = true;
          return true;
        } 
        if (paramAnchorInfo.mLayoutFromEnd) {
          i = this.mOrientationHelper.getDecoratedEnd(view) + this.mOrientationHelper.getTotalSpaceChange();
        } else {
          i = this.mOrientationHelper.getDecoratedStart(view);
        } 
        paramAnchorInfo.mCoordinate = i;
      } else {
        if (getChildCount() > 0) {
          int i = getPosition(getChildAt(0));
          if (this.mPendingScrollPosition < i) {
            bool = true;
          } else {
            bool = false;
          } 
          if (bool == this.mShouldReverseLayout)
            bool1 = true; 
          paramAnchorInfo.mLayoutFromEnd = bool1;
        } 
        paramAnchorInfo.assignCoordinateFromPadding();
      } 
      return true;
    } 
    paramAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
    if (this.mShouldReverseLayout) {
      paramAnchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
    } else {
      paramAnchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
    } 
    return true;
  }
  
  private void updateAnchorInfoForLayout(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AnchorInfo paramAnchorInfo) {
    boolean bool;
    if (updateAnchorFromPendingData(paramState, paramAnchorInfo))
      return; 
    if (updateAnchorFromChildren(paramRecycler, paramState, paramAnchorInfo))
      return; 
    paramAnchorInfo.assignCoordinateFromPadding();
    if (this.mStackFromEnd) {
      bool = paramState.getItemCount() - 1;
    } else {
      bool = false;
    } 
    paramAnchorInfo.mPosition = bool;
  }
  
  private void updateLayoutState(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.State paramState) {
    this.mLayoutState.mInfinite = resolveIsInfinite();
    this.mLayoutState.mExtra = getExtraLayoutSpace(paramState);
    this.mLayoutState.mLayoutDirection = paramInt1;
    byte b = -1;
    if (paramInt1 == 1) {
      LayoutState layoutState1 = this.mLayoutState;
      layoutState1.mExtra += this.mOrientationHelper.getEndPadding();
      View view = getChildClosestToEnd();
      LayoutState layoutState2 = this.mLayoutState;
      if (!this.mShouldReverseLayout)
        b = 1; 
      layoutState2.mItemDirection = b;
      this.mLayoutState.mCurrentPosition = getPosition(view) + this.mLayoutState.mItemDirection;
      this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(view);
      paramInt1 = this.mOrientationHelper.getDecoratedEnd(view) - this.mOrientationHelper.getEndAfterPadding();
    } else {
      View view = getChildClosestToStart();
      LayoutState layoutState = this.mLayoutState;
      layoutState.mExtra += this.mOrientationHelper.getStartAfterPadding();
      layoutState = this.mLayoutState;
      if (this.mShouldReverseLayout)
        b = 1; 
      layoutState.mItemDirection = b;
      this.mLayoutState.mCurrentPosition = getPosition(view) + this.mLayoutState.mItemDirection;
      this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(view);
      paramInt1 = -this.mOrientationHelper.getDecoratedStart(view) + this.mOrientationHelper.getStartAfterPadding();
    } 
    this.mLayoutState.mAvailable = paramInt2;
    if (paramBoolean) {
      LayoutState layoutState = this.mLayoutState;
      layoutState.mAvailable -= paramInt1;
    } 
    this.mLayoutState.mScrollingOffset = paramInt1;
  }
  
  private void updateLayoutStateToFillEnd(int paramInt1, int paramInt2) {
    boolean bool;
    this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - paramInt2;
    LayoutState layoutState = this.mLayoutState;
    if (this.mShouldReverseLayout) {
      bool = true;
    } else {
      bool = true;
    } 
    layoutState.mItemDirection = bool;
    this.mLayoutState.mCurrentPosition = paramInt1;
    this.mLayoutState.mLayoutDirection = 1;
    this.mLayoutState.mOffset = paramInt2;
    this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
  }
  
  private void updateLayoutStateToFillEnd(AnchorInfo paramAnchorInfo) {
    updateLayoutStateToFillEnd(paramAnchorInfo.mPosition, paramAnchorInfo.mCoordinate);
  }
  
  private void updateLayoutStateToFillStart(int paramInt1, int paramInt2) {
    this.mLayoutState.mAvailable = paramInt2 - this.mOrientationHelper.getStartAfterPadding();
    this.mLayoutState.mCurrentPosition = paramInt1;
    LayoutState layoutState = this.mLayoutState;
    if (this.mShouldReverseLayout) {
      paramInt1 = 1;
    } else {
      paramInt1 = -1;
    } 
    layoutState.mItemDirection = paramInt1;
    this.mLayoutState.mLayoutDirection = -1;
    this.mLayoutState.mOffset = paramInt2;
    this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
  }
  
  private void updateLayoutStateToFillStart(AnchorInfo paramAnchorInfo) {
    updateLayoutStateToFillStart(paramAnchorInfo.mPosition, paramAnchorInfo.mCoordinate);
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
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState) {
    return computeScrollExtent(paramState);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState) {
    return computeScrollOffset(paramState);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState) {
    return computeScrollRange(paramState);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt) {
    if (getChildCount() == 0)
      return null; 
    boolean bool = false;
    int i = getPosition(getChildAt(0));
    boolean bool1 = true;
    if (paramInt < i)
      bool = true; 
    paramInt = bool1;
    if (bool != this.mShouldReverseLayout)
      paramInt = -1; 
    return (this.mOrientation == 0) ? new PointF(paramInt, 0.0F) : new PointF(0.0F, paramInt);
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
  
  int convertFocusDirectionToLayoutDirection(int paramInt) {
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
  
  LayoutState createLayoutState() {
    return new LayoutState();
  }
  
  void ensureLayoutState() {
    if (this.mLayoutState == null)
      this.mLayoutState = createLayoutState(); 
    if (this.mOrientationHelper == null)
      this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, this.mOrientation); 
  }
  
  int fill(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState, RecyclerView.State paramState, boolean paramBoolean) {
    int i = paramLayoutState.mAvailable;
    if (paramLayoutState.mScrollingOffset != Integer.MIN_VALUE) {
      if (paramLayoutState.mAvailable < 0)
        paramLayoutState.mScrollingOffset += paramLayoutState.mAvailable; 
      recycleByLayoutState(paramRecycler, paramLayoutState);
    } 
    int j = paramLayoutState.mAvailable + paramLayoutState.mExtra;
    LayoutChunkResult layoutChunkResult = new LayoutChunkResult();
    while (true) {
      while (true)
        break; 
      if (paramBoolean) {
        Object object = SYNTHETIC_LOCAL_VARIABLE_8;
        if (layoutChunkResult.mFocusable)
          break; 
      } 
    } 
    return i - paramLayoutState.mAvailable;
  }
  
  public int findFirstCompletelyVisibleItemPosition() {
    int i;
    View view = findOneVisibleChild(0, getChildCount(), true, false);
    if (view == null) {
      i = -1;
    } else {
      i = getPosition(view);
    } 
    return i;
  }
  
  public int findFirstVisibleItemPosition() {
    int i;
    View view = findOneVisibleChild(0, getChildCount(), false, true);
    if (view == null) {
      i = -1;
    } else {
      i = getPosition(view);
    } 
    return i;
  }
  
  public int findLastCompletelyVisibleItemPosition() {
    int i = getChildCount();
    int j = -1;
    View view = findOneVisibleChild(i - 1, -1, true, false);
    if (view != null)
      j = getPosition(view); 
    return j;
  }
  
  public int findLastVisibleItemPosition() {
    int i = getChildCount();
    int j = -1;
    View view = findOneVisibleChild(i - 1, -1, false, true);
    if (view != null)
      j = getPosition(view); 
    return j;
  }
  
  View findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
    byte b;
    ensureLayoutState();
    int i = this.mOrientationHelper.getStartAfterPadding();
    int j = this.mOrientationHelper.getEndAfterPadding();
    if (paramInt2 > paramInt1) {
      b = 1;
    } else {
      b = -1;
    } 
    View view;
    for (view = null; paramInt1 != paramInt2; view = view2) {
      View view1 = getChildAt(paramInt1);
      int k = this.mOrientationHelper.getDecoratedStart(view1);
      int m = this.mOrientationHelper.getDecoratedEnd(view1);
      View view2 = view;
      if (k < j) {
        view2 = view;
        if (m > i)
          if (paramBoolean1) {
            if (k >= i && m <= j)
              return view1; 
            view2 = view;
            if (paramBoolean2) {
              view2 = view;
              if (view == null)
                view2 = view1; 
            } 
          } else {
            return view1;
          }  
      } 
      paramInt1 += b;
    } 
    return view;
  }
  
  View findReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, int paramInt3) {
    View view;
    RecyclerView.Recycler recycler;
    byte b;
    ensureLayoutState();
    int i = this.mOrientationHelper.getStartAfterPadding();
    int j = this.mOrientationHelper.getEndAfterPadding();
    if (paramInt2 > paramInt1) {
      b = 1;
    } else {
      b = -1;
    } 
    paramState = null;
    for (paramRecycler = null; paramInt1 != paramInt2; paramRecycler = recycler1) {
      View view2;
      View view1 = getChildAt(paramInt1);
      int k = getPosition(view1);
      RecyclerView.State state = paramState;
      RecyclerView.Recycler recycler1 = paramRecycler;
      if (k >= 0) {
        state = paramState;
        recycler1 = paramRecycler;
        if (k < paramInt3)
          if (((RecyclerView.LayoutParams)view1.getLayoutParams()).isItemRemoved()) {
            state = paramState;
            recycler1 = paramRecycler;
            if (paramRecycler == null) {
              View view3 = view1;
              state = paramState;
            } 
          } else if (this.mOrientationHelper.getDecoratedStart(view1) >= j || this.mOrientationHelper.getDecoratedEnd(view1) < i) {
            state = paramState;
            recycler1 = paramRecycler;
            if (paramState == null) {
              view2 = view1;
              recycler1 = paramRecycler;
            } 
          } else {
            return view1;
          }  
      } 
      paramInt1 += b;
      view = view2;
    } 
    if (view == null)
      recycler = paramRecycler; 
    return (View)recycler;
  }
  
  public View findViewByPosition(int paramInt) {
    int i = getChildCount();
    if (i == 0)
      return null; 
    int j = paramInt - getPosition(getChildAt(0));
    if (j >= 0 && j < i) {
      View view = getChildAt(j);
      if (getPosition(view) == paramInt)
        return view; 
    } 
    return super.findViewByPosition(paramInt);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams() {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  protected int getExtraLayoutSpace(RecyclerView.State paramState) {
    return paramState.hasTargetScrollPosition() ? this.mOrientationHelper.getTotalSpace() : 0;
  }
  
  public int getOrientation() {
    return this.mOrientation;
  }
  
  public boolean getRecycleChildrenOnDetach() {
    return this.mRecycleChildrenOnDetach;
  }
  
  public boolean getReverseLayout() {
    return this.mReverseLayout;
  }
  
  public boolean getStackFromEnd() {
    return this.mStackFromEnd;
  }
  
  protected boolean isLayoutRTL() {
    int i = getLayoutDirection();
    boolean bool = true;
    if (i != 1)
      bool = false; 
    return bool;
  }
  
  public boolean isSmoothScrollbarEnabled() {
    return this.mSmoothScrollbarEnabled;
  }
  
  void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LayoutState paramLayoutState, LayoutChunkResult paramLayoutChunkResult) {
    int i;
    int j;
    int k;
    int m;
    View view = paramLayoutState.next(paramRecycler);
    if (view == null) {
      paramLayoutChunkResult.mFinished = true;
      return;
    } 
    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
    if (paramLayoutState.mScrapList == null) {
      boolean bool2;
      boolean bool1 = this.mShouldReverseLayout;
      if (paramLayoutState.mLayoutDirection == -1) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if (bool1 == bool2) {
        addView(view);
      } else {
        addView(view, 0);
      } 
    } else {
      boolean bool2;
      boolean bool1 = this.mShouldReverseLayout;
      if (paramLayoutState.mLayoutDirection == -1) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if (bool1 == bool2) {
        addDisappearingView(view);
      } else {
        addDisappearingView(view, 0);
      } 
    } 
    measureChildWithMargins(view, 0, 0);
    paramLayoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(view);
    if (this.mOrientation == 1) {
      if (isLayoutRTL()) {
        i = getWidth() - getPaddingRight();
        j = i - this.mOrientationHelper.getDecoratedMeasurementInOther(view);
      } else {
        j = getPaddingLeft();
        i = this.mOrientationHelper.getDecoratedMeasurementInOther(view) + j;
      } 
      if (paramLayoutState.mLayoutDirection == -1) {
        k = paramLayoutState.mOffset;
        int n = paramLayoutState.mOffset - paramLayoutChunkResult.mConsumed;
        m = i;
        i = n;
      } else {
        int n = paramLayoutState.mOffset;
        k = paramLayoutState.mOffset + paramLayoutChunkResult.mConsumed;
        m = i;
        i = n;
      } 
    } else {
      m = getPaddingTop();
      i = this.mOrientationHelper.getDecoratedMeasurementInOther(view) + m;
      if (paramLayoutState.mLayoutDirection == -1) {
        int n = paramLayoutState.mOffset;
        j = paramLayoutState.mOffset;
        int i1 = paramLayoutChunkResult.mConsumed;
        k = i;
        j -= i1;
        i = m;
        m = n;
      } else {
        int n = paramLayoutState.mOffset;
        int i1 = paramLayoutState.mOffset + paramLayoutChunkResult.mConsumed;
        j = m;
        k = i;
        m = i1;
        i = j;
        j = n;
      } 
    } 
    layoutDecoratedWithMargins(view, j, i, m, k);
    if (layoutParams.isItemRemoved() || layoutParams.isItemChanged())
      paramLayoutChunkResult.mIgnoreConsumed = true; 
    paramLayoutChunkResult.mFocusable = view.isFocusable();
  }
  
  void onAnchorReady(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AnchorInfo paramAnchorInfo, int paramInt) {}
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler) {
    super.onDetachedFromWindow(paramRecyclerView, paramRecycler);
    if (this.mRecycleChildrenOnDetach) {
      removeAndRecycleAllViews(paramRecycler);
      paramRecycler.clear();
    } 
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    View view;
    resolveShouldLayoutReverse();
    if (getChildCount() == 0)
      return null; 
    paramInt = convertFocusDirectionToLayoutDirection(paramInt);
    if (paramInt == Integer.MIN_VALUE)
      return null; 
    ensureLayoutState();
    if (paramInt == -1) {
      paramView = findReferenceChildClosestToStart(paramRecycler, paramState);
    } else {
      paramView = findReferenceChildClosestToEnd(paramRecycler, paramState);
    } 
    if (paramView == null)
      return null; 
    ensureLayoutState();
    updateLayoutState(paramInt, (int)(this.mOrientationHelper.getTotalSpace() * 0.33333334F), false, paramState);
    this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
    this.mLayoutState.mRecycle = false;
    fill(paramRecycler, this.mLayoutState, paramState, true);
    if (paramInt == -1) {
      view = getChildClosestToStart();
    } else {
      view = getChildClosestToEnd();
    } 
    return (view == paramView || !view.isFocusable()) ? null : view;
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    SavedState savedState = this.mPendingSavedState;
    int i = -1;
    if ((savedState != null || this.mPendingScrollPosition != -1) && paramState.getItemCount() == 0) {
      removeAndRecycleAllViews(paramRecycler);
      return;
    } 
    if (this.mPendingSavedState != null && this.mPendingSavedState.hasValidAnchor())
      this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition; 
    ensureLayoutState();
    this.mLayoutState.mRecycle = false;
    resolveShouldLayoutReverse();
    if (!this.mAnchorInfo.mValid || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
      this.mAnchorInfo.reset();
      this.mAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
      updateAnchorInfoForLayout(paramRecycler, paramState, this.mAnchorInfo);
      this.mAnchorInfo.mValid = true;
    } 
    int j = getExtraLayoutSpace(paramState);
    if (this.mLayoutState.mLastScrollDelta >= 0) {
      k = j;
      j = 0;
    } else {
      k = 0;
    } 
    int m = j + this.mOrientationHelper.getStartAfterPadding();
    int n = k + this.mOrientationHelper.getEndPadding();
    int k = m;
    j = n;
    if (paramState.isPreLayout()) {
      k = m;
      j = n;
      if (this.mPendingScrollPosition != -1) {
        k = m;
        j = n;
        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
          View view = findViewByPosition(this.mPendingScrollPosition);
          k = m;
          j = n;
          if (view != null) {
            if (this.mShouldReverseLayout) {
              k = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view) - this.mPendingScrollPositionOffset;
            } else {
              j = this.mOrientationHelper.getDecoratedStart(view);
              k = this.mOrientationHelper.getStartAfterPadding();
              k = this.mPendingScrollPositionOffset - j - k;
            } 
            if (k > 0) {
              k = m + k;
              j = n;
            } else {
              j = n - k;
              k = m;
            } 
          } 
        } 
      } 
    } 
    if (this.mAnchorInfo.mLayoutFromEnd ? this.mShouldReverseLayout : !this.mShouldReverseLayout)
      i = 1; 
    onAnchorReady(paramRecycler, paramState, this.mAnchorInfo, i);
    detachAndScrapAttachedViews(paramRecycler);
    this.mLayoutState.mInfinite = resolveIsInfinite();
    this.mLayoutState.mIsPreLayout = paramState.isPreLayout();
    if (this.mAnchorInfo.mLayoutFromEnd) {
      updateLayoutStateToFillStart(this.mAnchorInfo);
      this.mLayoutState.mExtra = k;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      i = this.mLayoutState.mOffset;
      n = this.mLayoutState.mCurrentPosition;
      k = j;
      if (this.mLayoutState.mAvailable > 0)
        k = j + this.mLayoutState.mAvailable; 
      updateLayoutStateToFillEnd(this.mAnchorInfo);
      this.mLayoutState.mExtra = k;
      LayoutState layoutState = this.mLayoutState;
      layoutState.mCurrentPosition += this.mLayoutState.mItemDirection;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      m = this.mLayoutState.mOffset;
      j = i;
      k = m;
      if (this.mLayoutState.mAvailable > 0) {
        k = this.mLayoutState.mAvailable;
        updateLayoutStateToFillStart(n, i);
        this.mLayoutState.mExtra = k;
        fill(paramRecycler, this.mLayoutState, paramState, false);
        j = this.mLayoutState.mOffset;
        k = m;
      } 
    } else {
      updateLayoutStateToFillEnd(this.mAnchorInfo);
      this.mLayoutState.mExtra = j;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      i = this.mLayoutState.mOffset;
      n = this.mLayoutState.mCurrentPosition;
      j = k;
      if (this.mLayoutState.mAvailable > 0)
        j = k + this.mLayoutState.mAvailable; 
      updateLayoutStateToFillStart(this.mAnchorInfo);
      this.mLayoutState.mExtra = j;
      LayoutState layoutState = this.mLayoutState;
      layoutState.mCurrentPosition += this.mLayoutState.mItemDirection;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      m = this.mLayoutState.mOffset;
      j = m;
      k = i;
      if (this.mLayoutState.mAvailable > 0) {
        k = this.mLayoutState.mAvailable;
        updateLayoutStateToFillEnd(n, i);
        this.mLayoutState.mExtra = k;
        fill(paramRecycler, this.mLayoutState, paramState, false);
        k = this.mLayoutState.mOffset;
        j = m;
      } 
    } 
    i = j;
    m = k;
    if (getChildCount() > 0)
      if ((this.mShouldReverseLayout ^ this.mStackFromEnd) != 0) {
        m = fixLayoutEndGap(k, paramRecycler, paramState, true);
        i = j + m;
        j = fixLayoutStartGap(i, paramRecycler, paramState, false);
        i += j;
        m = k + m + j;
      } else {
        i = fixLayoutStartGap(j, paramRecycler, paramState, true);
        m = k + i;
        k = fixLayoutEndGap(m, paramRecycler, paramState, false);
        i = j + i + k;
        m += k;
      }  
    layoutForPredictiveAnimations(paramRecycler, paramState, i, m);
    if (!paramState.isPreLayout()) {
      this.mOrientationHelper.onLayoutComplete();
    } else {
      this.mAnchorInfo.reset();
    } 
    this.mLastStackFromEnd = this.mStackFromEnd;
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState) {
    super.onLayoutCompleted(paramState);
    this.mPendingSavedState = null;
    this.mPendingScrollPosition = -1;
    this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
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
    if (getChildCount() > 0) {
      ensureLayoutState();
      int i = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
      savedState.mAnchorLayoutFromEnd = i;
      if (i != 0) {
        View view = getChildClosestToEnd();
        savedState.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view);
        savedState.mAnchorPosition = getPosition(view);
      } else {
        View view = getChildClosestToStart();
        savedState.mAnchorPosition = getPosition(view);
        savedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(view) - this.mOrientationHelper.getStartAfterPadding();
      } 
    } else {
      savedState.invalidateAnchor();
    } 
    return savedState;
  }
  
  public void prepareForDrop(View paramView1, View paramView2, int paramInt1, int paramInt2) {
    assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
    ensureLayoutState();
    resolveShouldLayoutReverse();
    paramInt1 = getPosition(paramView1);
    paramInt2 = getPosition(paramView2);
    if (paramInt1 < paramInt2) {
      paramInt1 = 1;
    } else {
      paramInt1 = -1;
    } 
    if (this.mShouldReverseLayout) {
      if (paramInt1 == 1) {
        scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedStart(paramView2) + this.mOrientationHelper.getDecoratedMeasurement(paramView1));
      } else {
        scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(paramView2));
      } 
    } else if (paramInt1 == -1) {
      scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getDecoratedStart(paramView2));
    } else {
      scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getDecoratedEnd(paramView2) - this.mOrientationHelper.getDecoratedMeasurement(paramView1));
    } 
  }
  
  boolean resolveIsInfinite() {
    boolean bool;
    if (this.mOrientationHelper.getMode() == 0 && this.mOrientationHelper.getEnd() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  int scrollBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    byte b;
    if (getChildCount() == 0 || paramInt == 0)
      return 0; 
    this.mLayoutState.mRecycle = true;
    ensureLayoutState();
    if (paramInt > 0) {
      b = 1;
    } else {
      b = -1;
    } 
    int i = Math.abs(paramInt);
    updateLayoutState(b, i, true, paramState);
    int j = this.mLayoutState.mScrollingOffset + fill(paramRecycler, this.mLayoutState, paramState, false);
    if (j < 0)
      return 0; 
    if (i > j)
      paramInt = b * j; 
    this.mOrientationHelper.offsetChildren(-paramInt);
    this.mLayoutState.mLastScrollDelta = paramInt;
    return paramInt;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return (this.mOrientation == 1) ? 0 : scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void scrollToPosition(int paramInt) {
    this.mPendingScrollPosition = paramInt;
    this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
    if (this.mPendingSavedState != null)
      this.mPendingSavedState.invalidateAnchor(); 
    requestLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2) {
    this.mPendingScrollPosition = paramInt1;
    this.mPendingScrollPositionOffset = paramInt2;
    if (this.mPendingSavedState != null)
      this.mPendingSavedState.invalidateAnchor(); 
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return (this.mOrientation == 0) ? 0 : scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void setOrientation(int paramInt) {
    if (paramInt == 0 || paramInt == 1) {
      assertNotInLayoutOrScroll((String)null);
      if (paramInt == this.mOrientation)
        return; 
      this.mOrientation = paramInt;
      this.mOrientationHelper = null;
      requestLayout();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("invalid orientation:");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void setRecycleChildrenOnDetach(boolean paramBoolean) {
    this.mRecycleChildrenOnDetach = paramBoolean;
  }
  
  public void setReverseLayout(boolean paramBoolean) {
    assertNotInLayoutOrScroll((String)null);
    if (paramBoolean == this.mReverseLayout)
      return; 
    this.mReverseLayout = paramBoolean;
    requestLayout();
  }
  
  public void setSmoothScrollbarEnabled(boolean paramBoolean) {
    this.mSmoothScrollbarEnabled = paramBoolean;
  }
  
  public void setStackFromEnd(boolean paramBoolean) {
    assertNotInLayoutOrScroll((String)null);
    if (this.mStackFromEnd == paramBoolean)
      return; 
    this.mStackFromEnd = paramBoolean;
    requestLayout();
  }
  
  boolean shouldMeasureTwice() {
    boolean bool;
    if (getHeightMode() != 1073741824 && getWidthMode() != 1073741824 && hasFlexibleChildInBothOrientations()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt) {
    LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(paramRecyclerView.getContext()) {
        public PointF computeScrollVectorForPosition(int param1Int) {
          return LinearLayoutManager.this.computeScrollVectorForPosition(param1Int);
        }
      };
    linearSmoothScroller.setTargetPosition(paramInt);
    startSmoothScroll(linearSmoothScroller);
  }
  
  public boolean supportsPredictiveItemAnimations() {
    boolean bool;
    if (this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  void validateChildOrder() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("validating child count ");
    stringBuilder.append(getChildCount());
    Log.d("LinearLayoutManager", stringBuilder.toString());
    if (getChildCount() < 1)
      return; 
    boolean bool1 = false;
    boolean bool2 = false;
    int i = getPosition(getChildAt(0));
    int j = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
    if (this.mShouldReverseLayout) {
      byte b = 1;
      while (b < getChildCount()) {
        View view = getChildAt(b);
        int k = getPosition(view);
        int m = this.mOrientationHelper.getDecoratedStart(view);
        if (k < i) {
          logChildren();
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("detected invalid position. loc invalid? ");
          if (m < j)
            bool2 = true; 
          stringBuilder1.append(bool2);
          throw new RuntimeException(stringBuilder1.toString());
        } 
        if (m <= j) {
          b++;
          continue;
        } 
        logChildren();
        throw new RuntimeException("detected invalid location");
      } 
    } else {
      byte b = 1;
      while (b < getChildCount()) {
        View view = getChildAt(b);
        int k = getPosition(view);
        int m = this.mOrientationHelper.getDecoratedStart(view);
        if (k < i) {
          logChildren();
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("detected invalid position. loc invalid? ");
          bool2 = bool1;
          if (m < j)
            bool2 = true; 
          stringBuilder1.append(bool2);
          throw new RuntimeException(stringBuilder1.toString());
        } 
        if (m >= j) {
          b++;
          continue;
        } 
        logChildren();
        throw new RuntimeException("detected invalid location");
      } 
    } 
  }
  
  class AnchorInfo {
    int mCoordinate;
    
    boolean mLayoutFromEnd;
    
    int mPosition;
    
    boolean mValid;
    
    AnchorInfo() {
      reset();
    }
    
    private boolean isViewValidAsAnchor(View param1View, RecyclerView.State param1State) {
      boolean bool;
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
      if (!layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < param1State.getItemCount()) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    void assignCoordinateFromPadding() {
      int i;
      if (this.mLayoutFromEnd) {
        i = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding();
      } else {
        i = LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
      } 
      this.mCoordinate = i;
    }
    
    public void assignFromView(View param1View) {
      if (this.mLayoutFromEnd) {
        this.mCoordinate = LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(param1View) + LinearLayoutManager.this.mOrientationHelper.getTotalSpaceChange();
      } else {
        this.mCoordinate = LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(param1View);
      } 
      this.mPosition = LinearLayoutManager.this.getPosition(param1View);
    }
    
    public void assignFromViewAndKeepVisibleRect(View param1View) {
      int i = LinearLayoutManager.this.mOrientationHelper.getTotalSpaceChange();
      if (i >= 0) {
        assignFromView(param1View);
        return;
      } 
      this.mPosition = LinearLayoutManager.this.getPosition(param1View);
      if (this.mLayoutFromEnd) {
        int j = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - i - LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(param1View);
        this.mCoordinate = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - j;
        if (j > 0) {
          int k = LinearLayoutManager.this.mOrientationHelper.getDecoratedMeasurement(param1View);
          int m = this.mCoordinate;
          int n = LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
          n = m - k - n + Math.min(LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(param1View) - n, 0);
          if (n < 0)
            this.mCoordinate += Math.min(j, -n); 
        } 
      } else {
        int k = LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(param1View);
        int j = k - LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
        this.mCoordinate = k;
        if (j > 0) {
          int m = LinearLayoutManager.this.mOrientationHelper.getDecoratedMeasurement(param1View);
          int i1 = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding();
          int n = LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(param1View);
          n = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - Math.min(0, i1 - i - n) - k + m;
          if (n < 0)
            this.mCoordinate -= Math.min(j, -n); 
        } 
      } 
    }
    
    void reset() {
      this.mPosition = -1;
      this.mCoordinate = Integer.MIN_VALUE;
      this.mLayoutFromEnd = false;
      this.mValid = false;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("AnchorInfo{mPosition=");
      stringBuilder.append(this.mPosition);
      stringBuilder.append(", mCoordinate=");
      stringBuilder.append(this.mCoordinate);
      stringBuilder.append(", mLayoutFromEnd=");
      stringBuilder.append(this.mLayoutFromEnd);
      stringBuilder.append(", mValid=");
      stringBuilder.append(this.mValid);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  protected static class LayoutChunkResult {
    public int mConsumed;
    
    public boolean mFinished;
    
    public boolean mFocusable;
    
    public boolean mIgnoreConsumed;
    
    void resetInternal() {
      this.mConsumed = 0;
      this.mFinished = false;
      this.mIgnoreConsumed = false;
      this.mFocusable = false;
    }
  }
  
  static class LayoutState {
    static final int INVALID_LAYOUT = -2147483648;
    
    static final int ITEM_DIRECTION_HEAD = -1;
    
    static final int ITEM_DIRECTION_TAIL = 1;
    
    static final int LAYOUT_END = 1;
    
    static final int LAYOUT_START = -1;
    
    static final int SCOLLING_OFFSET_NaN = -2147483648;
    
    static final String TAG = "LLM#LayoutState";
    
    int mAvailable;
    
    int mCurrentPosition;
    
    int mExtra = 0;
    
    boolean mInfinite;
    
    boolean mIsPreLayout = false;
    
    int mItemDirection;
    
    int mLastScrollDelta;
    
    int mLayoutDirection;
    
    int mOffset;
    
    boolean mRecycle = true;
    
    List<RecyclerView.ViewHolder> mScrapList = null;
    
    int mScrollingOffset;
    
    private View nextViewFromScrapList() {
      int i = this.mScrapList.size();
      for (byte b = 0; b < i; b++) {
        View view = ((RecyclerView.ViewHolder)this.mScrapList.get(b)).itemView;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        if (!layoutParams.isItemRemoved() && this.mCurrentPosition == layoutParams.getViewLayoutPosition()) {
          assignPositionFromScrapList(view);
          return view;
        } 
      } 
      return null;
    }
    
    public void assignPositionFromScrapList() {
      assignPositionFromScrapList(null);
    }
    
    public void assignPositionFromScrapList(View param1View) {
      param1View = nextViewInLimitedList(param1View);
      if (param1View == null) {
        this.mCurrentPosition = -1;
      } else {
        this.mCurrentPosition = ((RecyclerView.LayoutParams)param1View.getLayoutParams()).getViewLayoutPosition();
      } 
    }
    
    boolean hasMore(RecyclerView.State param1State) {
      boolean bool;
      if (this.mCurrentPosition >= 0 && this.mCurrentPosition < param1State.getItemCount()) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    void log() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("avail:");
      stringBuilder.append(this.mAvailable);
      stringBuilder.append(", ind:");
      stringBuilder.append(this.mCurrentPosition);
      stringBuilder.append(", dir:");
      stringBuilder.append(this.mItemDirection);
      stringBuilder.append(", offset:");
      stringBuilder.append(this.mOffset);
      stringBuilder.append(", layoutDir:");
      stringBuilder.append(this.mLayoutDirection);
      Log.d("LLM#LayoutState", stringBuilder.toString());
    }
    
    View next(RecyclerView.Recycler param1Recycler) {
      if (this.mScrapList != null)
        return nextViewFromScrapList(); 
      View view = param1Recycler.getViewForPosition(this.mCurrentPosition);
      this.mCurrentPosition += this.mItemDirection;
      return view;
    }
    
    public View nextViewInLimitedList(View param1View) {
      View view2;
      int i = this.mScrapList.size();
      View view1 = null;
      int j = Integer.MAX_VALUE;
      byte b = 0;
      while (true) {
        view2 = view1;
        if (b < i) {
          View view = ((RecyclerView.ViewHolder)this.mScrapList.get(b)).itemView;
          RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
          view2 = view1;
          int k = j;
          if (view != param1View)
            if (layoutParams.isItemRemoved()) {
              view2 = view1;
              k = j;
            } else {
              int m = (layoutParams.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
              if (m < 0) {
                view2 = view1;
                k = j;
              } else {
                view2 = view1;
                k = j;
                if (m < j) {
                  if (m == 0) {
                    view2 = view;
                    break;
                  } 
                  view2 = view;
                  k = m;
                } 
              } 
            }  
          b++;
          view1 = view2;
          j = k;
          continue;
        } 
        break;
      } 
      return view2;
    }
  }
  
  public static class SavedState implements Parcelable {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public LinearLayoutManager.SavedState createFromParcel(Parcel param2Parcel) {
          return new LinearLayoutManager.SavedState(param2Parcel);
        }
        
        public LinearLayoutManager.SavedState[] newArray(int param2Int) {
          return new LinearLayoutManager.SavedState[param2Int];
        }
      };
    
    boolean mAnchorLayoutFromEnd;
    
    int mAnchorOffset;
    
    int mAnchorPosition;
    
    public SavedState() {}
    
    SavedState(Parcel param1Parcel) {
      this.mAnchorPosition = param1Parcel.readInt();
      this.mAnchorOffset = param1Parcel.readInt();
      int i = param1Parcel.readInt();
      boolean bool = true;
      if (i != 1)
        bool = false; 
      this.mAnchorLayoutFromEnd = bool;
    }
    
    public SavedState(SavedState param1SavedState) {
      this.mAnchorPosition = param1SavedState.mAnchorPosition;
      this.mAnchorOffset = param1SavedState.mAnchorOffset;
      this.mAnchorLayoutFromEnd = param1SavedState.mAnchorLayoutFromEnd;
    }
    
    public int describeContents() {
      return 0;
    }
    
    boolean hasValidAnchor() {
      boolean bool;
      if (this.mAnchorPosition >= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    void invalidateAnchor() {
      this.mAnchorPosition = -1;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Parcel.writeInt(this.mAnchorPosition);
      param1Parcel.writeInt(this.mAnchorOffset);
      param1Parcel.writeInt(this.mAnchorLayoutFromEnd);
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public LinearLayoutManager.SavedState createFromParcel(Parcel param1Parcel) {
      return new LinearLayoutManager.SavedState(param1Parcel);
    }
    
    public LinearLayoutManager.SavedState[] newArray(int param1Int) {
      return new LinearLayoutManager.SavedState[param1Int];
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v7\widget\LinearLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */