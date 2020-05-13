package org.jar.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
  private static final boolean DEBUG = false;
  
  public static final int DEFAULT_SPAN_COUNT = -1;
  
  private static final String TAG = "GridLayoutManager";
  
  int[] mCachedBorders;
  
  final Rect mDecorInsets = new Rect();
  
  boolean mPendingSpanCountChange = false;
  
  final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
  
  final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
  
  View[] mSet;
  
  int mSpanCount = -1;
  
  SpanSizeLookup mSpanSizeLookup = new DefaultSpanSizeLookup();
  
  public GridLayoutManager(Context paramContext, int paramInt) {
    super(paramContext);
    setSpanCount(paramInt);
  }
  
  public GridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean) {
    super(paramContext, paramInt2, paramBoolean);
    setSpanCount(paramInt1);
  }
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private void assignSpans(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, boolean paramBoolean) {
    byte b1;
    byte b2;
    byte b;
    paramInt2 = 0;
    if (paramBoolean) {
      b1 = paramInt1;
      paramInt1 = 0;
      b2 = 1;
    } else {
      paramInt1--;
      b1 = -1;
      b2 = -1;
    } 
    if (this.mOrientation == 1 && isLayoutRTL()) {
      paramInt2 = this.mSpanCount - 1;
      b = -1;
    } else {
      b = 1;
    } 
    while (paramInt1 != b1) {
      View view = this.mSet[paramInt1];
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      LayoutParams.access$102(layoutParams, getSpanSize(paramRecycler, paramState, getPosition(view)));
      if (b == -1 && layoutParams.mSpanSize > 1) {
        LayoutParams.access$002(layoutParams, paramInt2 - layoutParams.mSpanSize - 1);
      } else {
        LayoutParams.access$002(layoutParams, paramInt2);
      } 
      paramInt2 += layoutParams.mSpanSize * b;
      paramInt1 += b2;
    } 
  }
  
  private void cachePreLayoutSpanMapping() {
    int i = getChildCount();
    for (byte b = 0; b < i; b++) {
      LayoutParams layoutParams = (LayoutParams)getChildAt(b).getLayoutParams();
      int j = layoutParams.getViewLayoutPosition();
      this.mPreLayoutSpanSizeCache.put(j, layoutParams.getSpanSize());
      this.mPreLayoutSpanIndexCache.put(j, layoutParams.getSpanIndex());
    } 
  }
  
  private void calculateItemBorders(int paramInt) {
    this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, paramInt);
  }
  
  static int[] calculateItemBorders(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: ifnull -> 27
    //   6: aload_0
    //   7: arraylength
    //   8: iload_1
    //   9: iconst_1
    //   10: iadd
    //   11: if_icmpne -> 27
    //   14: aload_0
    //   15: astore #4
    //   17: aload_0
    //   18: aload_0
    //   19: arraylength
    //   20: iconst_1
    //   21: isub
    //   22: iaload
    //   23: iload_2
    //   24: if_icmpeq -> 34
    //   27: iload_1
    //   28: iconst_1
    //   29: iadd
    //   30: newarray int
    //   32: astore #4
    //   34: iconst_0
    //   35: istore #5
    //   37: aload #4
    //   39: iconst_0
    //   40: iconst_0
    //   41: iastore
    //   42: iload_2
    //   43: iload_1
    //   44: idiv
    //   45: istore #6
    //   47: iload_2
    //   48: iload_1
    //   49: irem
    //   50: istore #7
    //   52: iconst_0
    //   53: istore #8
    //   55: iload #5
    //   57: istore_2
    //   58: iload_3
    //   59: iload_1
    //   60: if_icmpgt -> 116
    //   63: iload_2
    //   64: iload #7
    //   66: iadd
    //   67: istore_2
    //   68: iload_2
    //   69: ifle -> 93
    //   72: iload_1
    //   73: iload_2
    //   74: isub
    //   75: iload #7
    //   77: if_icmpge -> 93
    //   80: iload #6
    //   82: iconst_1
    //   83: iadd
    //   84: istore #5
    //   86: iload_2
    //   87: iload_1
    //   88: isub
    //   89: istore_2
    //   90: goto -> 97
    //   93: iload #6
    //   95: istore #5
    //   97: iload #8
    //   99: iload #5
    //   101: iadd
    //   102: istore #8
    //   104: aload #4
    //   106: iload_3
    //   107: iload #8
    //   109: iastore
    //   110: iinc #3, 1
    //   113: goto -> 58
    //   116: aload #4
    //   118: areturn
  }
  
  private void clearPreLayoutSpanMappingCache() {
    this.mPreLayoutSpanSizeCache.clear();
    this.mPreLayoutSpanIndexCache.clear();
  }
  
  private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo, int paramInt) {
    int i;
    if (paramInt == 1) {
      i = 1;
    } else {
      i = 0;
    } 
    paramInt = getSpanIndex(paramRecycler, paramState, paramAnchorInfo.mPosition);
    if (i) {
      while (paramInt > 0 && paramAnchorInfo.mPosition > 0) {
        paramAnchorInfo.mPosition--;
        paramInt = getSpanIndex(paramRecycler, paramState, paramAnchorInfo.mPosition);
      } 
    } else {
      int j = paramState.getItemCount();
      i = paramAnchorInfo.mPosition;
      while (i < j - 1) {
        int k = i + 1;
        int m = getSpanIndex(paramRecycler, paramState, k);
        if (m > paramInt) {
          i = k;
          paramInt = m;
        } 
      } 
      paramAnchorInfo.mPosition = i;
    } 
  }
  
  private void ensureViewSet() {
    if (this.mSet == null || this.mSet.length != this.mSpanCount)
      this.mSet = new View[this.mSpanCount]; 
  }
  
  private int getSpanGroupIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt) {
    if (!paramState.isPreLayout())
      return this.mSpanSizeLookup.getSpanGroupIndex(paramInt, this.mSpanCount); 
    int i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot find span size for pre layout position. ");
      stringBuilder.append(paramInt);
      Log.w("GridLayoutManager", stringBuilder.toString());
      return 0;
    } 
    return this.mSpanSizeLookup.getSpanGroupIndex(i, this.mSpanCount);
  }
  
  private int getSpanIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt) {
    if (!paramState.isPreLayout())
      return this.mSpanSizeLookup.getCachedSpanIndex(paramInt, this.mSpanCount); 
    int i = this.mPreLayoutSpanIndexCache.get(paramInt, -1);
    if (i != -1)
      return i; 
    i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
      stringBuilder.append(paramInt);
      Log.w("GridLayoutManager", stringBuilder.toString());
      return 0;
    } 
    return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
  }
  
  private int getSpanSize(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt) {
    if (!paramState.isPreLayout())
      return this.mSpanSizeLookup.getSpanSize(paramInt); 
    int i = this.mPreLayoutSpanSizeCache.get(paramInt, -1);
    if (i != -1)
      return i; 
    i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
      stringBuilder.append(paramInt);
      Log.w("GridLayoutManager", stringBuilder.toString());
      return 1;
    } 
    return this.mSpanSizeLookup.getSpanSize(i);
  }
  
  private void guessMeasurement(float paramFloat, int paramInt) {
    calculateItemBorders(Math.max(Math.round(paramFloat * this.mSpanCount), paramInt));
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_0
    //   3: getfield mDecorInsets : Landroid/graphics/Rect;
    //   6: invokevirtual calculateItemDecorationsForChild : (Landroid/view/View;Landroid/graphics/Rect;)V
    //   9: aload_1
    //   10: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   13: checkcast org/jar/support/v7/widget/RecyclerView$LayoutParams
    //   16: astore #6
    //   18: iload #4
    //   20: ifne -> 34
    //   23: iload_2
    //   24: istore #7
    //   26: aload_0
    //   27: getfield mOrientation : I
    //   30: iconst_1
    //   31: if_icmpne -> 67
    //   34: aload_0
    //   35: iload_2
    //   36: aload #6
    //   38: getfield leftMargin : I
    //   41: aload_0
    //   42: getfield mDecorInsets : Landroid/graphics/Rect;
    //   45: getfield left : I
    //   48: iadd
    //   49: aload #6
    //   51: getfield rightMargin : I
    //   54: aload_0
    //   55: getfield mDecorInsets : Landroid/graphics/Rect;
    //   58: getfield right : I
    //   61: iadd
    //   62: invokespecial updateSpecWithExtra : (III)I
    //   65: istore #7
    //   67: iload #4
    //   69: ifne -> 81
    //   72: iload_3
    //   73: istore_2
    //   74: aload_0
    //   75: getfield mOrientation : I
    //   78: ifne -> 113
    //   81: aload_0
    //   82: iload_3
    //   83: aload #6
    //   85: getfield topMargin : I
    //   88: aload_0
    //   89: getfield mDecorInsets : Landroid/graphics/Rect;
    //   92: getfield top : I
    //   95: iadd
    //   96: aload #6
    //   98: getfield bottomMargin : I
    //   101: aload_0
    //   102: getfield mDecorInsets : Landroid/graphics/Rect;
    //   105: getfield bottom : I
    //   108: iadd
    //   109: invokespecial updateSpecWithExtra : (III)I
    //   112: istore_2
    //   113: iload #5
    //   115: ifeq -> 133
    //   118: aload_0
    //   119: aload_1
    //   120: iload #7
    //   122: iload_2
    //   123: aload #6
    //   125: invokevirtual shouldReMeasureChild : (Landroid/view/View;IILorg/jar/support/v7/widget/RecyclerView$LayoutParams;)Z
    //   128: istore #4
    //   130: goto -> 145
    //   133: aload_0
    //   134: aload_1
    //   135: iload #7
    //   137: iload_2
    //   138: aload #6
    //   140: invokevirtual shouldMeasureChild : (Landroid/view/View;IILorg/jar/support/v7/widget/RecyclerView$LayoutParams;)Z
    //   143: istore #4
    //   145: iload #4
    //   147: ifeq -> 157
    //   150: aload_1
    //   151: iload #7
    //   153: iload_2
    //   154: invokevirtual measure : (II)V
    //   157: return
  }
  
  private void updateMeasurements() {
    int i;
    if (getOrientation() == 1) {
      i = getWidth() - getPaddingRight() - getPaddingLeft();
    } else {
      i = getHeight() - getPaddingBottom() - getPaddingTop();
    } 
    calculateItemBorders(i);
  }
  
  private int updateSpecWithExtra(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 == 0 && paramInt3 == 0)
      return paramInt1; 
    int i = View.MeasureSpec.getMode(paramInt1);
    return (i == Integer.MIN_VALUE || i == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i) : paramInt1;
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  View findReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, int paramInt3) {
    byte b;
    ensureLayoutState();
    int i = this.mOrientationHelper.getStartAfterPadding();
    int j = this.mOrientationHelper.getEndAfterPadding();
    if (paramInt2 > paramInt1) {
      b = 1;
    } else {
      b = -1;
    } 
    View view1 = null;
    View view2;
    for (view2 = null; paramInt1 != paramInt2; view2 = view5) {
      View view3 = getChildAt(paramInt1);
      int k = getPosition(view3);
      View view4 = view1;
      View view5 = view2;
      if (k >= 0) {
        view4 = view1;
        view5 = view2;
        if (k < paramInt3)
          if (getSpanIndex(paramRecycler, paramState, k) != 0) {
            view4 = view1;
            view5 = view2;
          } else if (((RecyclerView.LayoutParams)view3.getLayoutParams()).isItemRemoved()) {
            view4 = view1;
            view5 = view2;
            if (view2 == null) {
              view5 = view3;
              view4 = view1;
            } 
          } else if (this.mOrientationHelper.getDecoratedStart(view3) >= j || this.mOrientationHelper.getDecoratedEnd(view3) < i) {
            view4 = view1;
            view5 = view2;
            if (view1 == null) {
              view4 = view3;
              view5 = view2;
            } 
          } else {
            return view3;
          }  
      } 
      paramInt1 += b;
      view1 = view4;
    } 
    if (view1 != null)
      view2 = view1; 
    return view2;
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
    return (this.mOrientation == 1) ? this.mSpanCount : ((paramState.getItemCount() < 1) ? 0 : (getSpanGroupIndex(paramRecycler, paramState, paramState.getItemCount() - 1) + 1));
  }
  
  public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    return (this.mOrientation == 0) ? this.mSpanCount : ((paramState.getItemCount() < 1) ? 0 : (getSpanGroupIndex(paramRecycler, paramState, paramState.getItemCount() - 1) + 1));
  }
  
  public int getSpanCount() {
    return this.mSpanCount;
  }
  
  public SpanSizeLookup getSpanSizeLookup() {
    return this.mSpanSizeLookup;
  }
  
  void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, LinearLayoutManager.LayoutChunkResult paramLayoutChunkResult) {
    StringBuilder stringBuilder;
    int k;
    boolean bool;
    LinearLayoutManager.LayoutState layoutState = paramLayoutState;
    int i = this.mOrientationHelper.getModeInOther();
    if (i != 1073741824) {
      j = 1;
    } else {
      j = 0;
    } 
    if (getChildCount() > 0) {
      k = this.mCachedBorders[this.mSpanCount];
    } else {
      k = 0;
    } 
    if (j)
      updateMeasurements(); 
    if (layoutState.mItemDirection == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    int m = this.mSpanCount;
    if (!bool)
      m = getSpanIndex(paramRecycler, paramState, layoutState.mCurrentPosition) + getSpanSize(paramRecycler, paramState, layoutState.mCurrentPosition); 
    int n = 0;
    byte b = 0;
    while (b < this.mSpanCount && layoutState.hasMore(paramState) && m > 0) {
      int i1 = layoutState.mCurrentPosition;
      int i2 = getSpanSize(paramRecycler, paramState, i1);
      if (i2 <= this.mSpanCount) {
        m -= i2;
        if (m < 0)
          break; 
        View view = layoutState.next(paramRecycler);
        if (view == null)
          break; 
        n += i2;
        this.mSet[b] = view;
        b++;
        continue;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Item at position ");
      stringBuilder.append(i1);
      stringBuilder.append(" requires ");
      stringBuilder.append(i2);
      stringBuilder.append(" spans but GridLayoutManager has only ");
      stringBuilder.append(this.mSpanCount);
      stringBuilder.append(" spans.");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    if (b == 0) {
      paramLayoutChunkResult.mFinished = true;
      return;
    } 
    assignSpans((RecyclerView.Recycler)stringBuilder, paramState, b, n, bool);
    m = 0;
    float f = 0.0F;
    for (n = 0; n < b; n++) {
      View view = this.mSet[n];
      if (paramLayoutState.mScrapList == null) {
        if (bool) {
          addView(view);
        } else {
          addView(view, 0);
        } 
      } else if (bool) {
        addDisappearingView(view);
      } else {
        addDisappearingView(view, 0);
      } 
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      int i3 = this.mCachedBorders[layoutParams.mSpanIndex + layoutParams.mSpanSize];
      int i1 = this.mCachedBorders[layoutParams.mSpanIndex];
      if (this.mOrientation == 0) {
        i2 = layoutParams.height;
      } else {
        i2 = layoutParams.width;
      } 
      i1 = getChildMeasureSpec(i3 - i1, i, 0, i2, false);
      i3 = this.mOrientationHelper.getTotalSpace();
      int i4 = this.mOrientationHelper.getMode();
      if (this.mOrientation == 1) {
        i2 = layoutParams.height;
      } else {
        i2 = layoutParams.width;
      } 
      int i2 = getChildMeasureSpec(i3, i4, 0, i2, true);
      if (this.mOrientation == 1) {
        boolean bool1;
        if (layoutParams.height == -1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        measureChildWithDecorationsAndMargin(view, i1, i2, bool1, false);
      } else {
        boolean bool1;
        if (layoutParams.width == -1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        measureChildWithDecorationsAndMargin(view, i2, i1, bool1, false);
      } 
      i2 = this.mOrientationHelper.getDecoratedMeasurement(view);
      if (i2 > m)
        m = i2; 
      float f1 = this.mOrientationHelper.getDecoratedMeasurementInOther(view) * 1.0F / layoutParams.mSpanSize;
      if (f1 > f)
        f = f1; 
    } 
    if (j) {
      guessMeasurement(f, k);
      j = 0;
      for (m = 0; j < b; m = k) {
        View view = this.mSet[j];
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        n = this.mCachedBorders[layoutParams.mSpanIndex + layoutParams.mSpanSize];
        i = this.mCachedBorders[layoutParams.mSpanIndex];
        if (this.mOrientation == 0) {
          k = layoutParams.height;
        } else {
          k = layoutParams.width;
        } 
        n = getChildMeasureSpec(n - i, 1073741824, 0, k, false);
        int i1 = this.mOrientationHelper.getTotalSpace();
        i = this.mOrientationHelper.getMode();
        if (this.mOrientation == 1) {
          k = layoutParams.height;
        } else {
          k = layoutParams.width;
        } 
        k = getChildMeasureSpec(i1, i, 0, k, true);
        if (this.mOrientation == 1) {
          measureChildWithDecorationsAndMargin(view, n, k, false, true);
        } else {
          measureChildWithDecorationsAndMargin(view, k, n, false, true);
        } 
        n = this.mOrientationHelper.getDecoratedMeasurement(view);
        k = m;
        if (n > m)
          k = n; 
        j++;
      } 
    } 
    n = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
    int j;
    for (j = 0; j < b; j++) {
      View view = this.mSet[j];
      if (this.mOrientationHelper.getDecoratedMeasurement(view) != m) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        int i1 = this.mCachedBorders[layoutParams.mSpanIndex + layoutParams.mSpanSize];
        i = this.mCachedBorders[layoutParams.mSpanIndex];
        if (this.mOrientation == 0) {
          k = layoutParams.height;
        } else {
          k = layoutParams.width;
        } 
        k = getChildMeasureSpec(i1 - i, 1073741824, 0, k, false);
        if (this.mOrientation == 1) {
          measureChildWithDecorationsAndMargin(view, k, n, true, true);
        } else {
          measureChildWithDecorationsAndMargin(view, n, k, true, true);
        } 
      } 
    } 
    i = 0;
    paramLayoutChunkResult.mConsumed = m;
    if (this.mOrientation == 1) {
      if (paramLayoutState.mLayoutDirection == -1) {
        k = paramLayoutState.mOffset;
        j = k;
        m = k - m;
      } else {
        k = paramLayoutState.mOffset;
        j = k;
        k += m;
        m = j;
        j = k;
      } 
      k = 0;
      n = 0;
    } else if (paramLayoutState.mLayoutDirection == -1) {
      k = paramLayoutState.mOffset;
      boolean bool1 = false;
      j = 0;
      n = k;
      k -= m;
      m = bool1;
    } else {
      k = paramLayoutState.mOffset;
      n = k + m;
      m = 0;
      j = 0;
    } 
    while (i < b) {
      View view = this.mSet[i];
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      if (this.mOrientation == 1) {
        if (isLayoutRTL()) {
          n = getPaddingLeft() + this.mCachedBorders[layoutParams.mSpanIndex + layoutParams.mSpanSize];
          int i2 = this.mOrientationHelper.getDecoratedMeasurementInOther(view);
          k = n;
          n -= i2;
        } else {
          k = getPaddingLeft() + this.mCachedBorders[layoutParams.mSpanIndex];
          n = this.mOrientationHelper.getDecoratedMeasurementInOther(view) + k;
          int i2 = k;
          k = n;
          n = i2;
        } 
      } else {
        m = getPaddingTop() + this.mCachedBorders[layoutParams.mSpanIndex];
        j = this.mOrientationHelper.getDecoratedMeasurementInOther(view) + m;
        int i2 = k;
        k = n;
        n = i2;
      } 
      layoutDecoratedWithMargins(view, n, m, k, j);
      if (layoutParams.isItemRemoved() || layoutParams.isItemChanged())
        paramLayoutChunkResult.mIgnoreConsumed = true; 
      paramLayoutChunkResult.mFocusable |= view.isFocusable();
      int i1 = i + 1;
      i = k;
      k = n;
      n = i;
      i = i1;
    } 
    Arrays.fill((Object[])this.mSet, (Object)null);
  }
  
  void onAnchorReady(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo, int paramInt) {
    super.onAnchorReady(paramRecycler, paramState, paramAnchorInfo, paramInt);
    updateMeasurements();
    if (paramState.getItemCount() > 0 && !paramState.isPreLayout())
      ensureAnchorIsInCorrectSpan(paramRecycler, paramState, paramAnchorInfo, paramInt); 
    ensureViewSet();
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual findContainingItemView : (Landroid/view/View;)Landroid/view/View;
    //   5: astore #5
    //   7: aconst_null
    //   8: astore #6
    //   10: aload #5
    //   12: ifnonnull -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: aload #5
    //   19: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   22: checkcast org/jar/support/v7/widget/GridLayoutManager$LayoutParams
    //   25: astore #7
    //   27: aload #7
    //   29: invokestatic access$000 : (Lorg/jar/support/v7/widget/GridLayoutManager$LayoutParams;)I
    //   32: istore #8
    //   34: aload #7
    //   36: invokestatic access$000 : (Lorg/jar/support/v7/widget/GridLayoutManager$LayoutParams;)I
    //   39: aload #7
    //   41: invokestatic access$100 : (Lorg/jar/support/v7/widget/GridLayoutManager$LayoutParams;)I
    //   44: iadd
    //   45: istore #9
    //   47: aload_0
    //   48: aload_1
    //   49: iload_2
    //   50: aload_3
    //   51: aload #4
    //   53: invokespecial onFocusSearchFailed : (Landroid/view/View;ILorg/jar/support/v7/widget/RecyclerView$Recycler;Lorg/jar/support/v7/widget/RecyclerView$State;)Landroid/view/View;
    //   56: ifnonnull -> 61
    //   59: aconst_null
    //   60: areturn
    //   61: aload_0
    //   62: iload_2
    //   63: invokevirtual convertFocusDirectionToLayoutDirection : (I)I
    //   66: iconst_1
    //   67: if_icmpne -> 76
    //   70: iconst_1
    //   71: istore #10
    //   73: goto -> 79
    //   76: iconst_0
    //   77: istore #10
    //   79: iload #10
    //   81: aload_0
    //   82: getfield mShouldReverseLayout : Z
    //   85: if_icmpeq -> 93
    //   88: iconst_1
    //   89: istore_2
    //   90: goto -> 95
    //   93: iconst_0
    //   94: istore_2
    //   95: iload_2
    //   96: ifeq -> 115
    //   99: aload_0
    //   100: invokevirtual getChildCount : ()I
    //   103: iconst_1
    //   104: isub
    //   105: istore_2
    //   106: iconst_m1
    //   107: istore #11
    //   109: iconst_m1
    //   110: istore #12
    //   112: goto -> 126
    //   115: aload_0
    //   116: invokevirtual getChildCount : ()I
    //   119: istore #11
    //   121: iconst_0
    //   122: istore_2
    //   123: iconst_1
    //   124: istore #12
    //   126: aload_0
    //   127: getfield mOrientation : I
    //   130: iconst_1
    //   131: if_icmpne -> 147
    //   134: aload_0
    //   135: invokevirtual isLayoutRTL : ()Z
    //   138: ifeq -> 147
    //   141: iconst_1
    //   142: istore #13
    //   144: goto -> 150
    //   147: iconst_0
    //   148: istore #13
    //   150: iconst_0
    //   151: istore #14
    //   153: iconst_m1
    //   154: istore #15
    //   156: iload_2
    //   157: istore #16
    //   159: aload #6
    //   161: astore_1
    //   162: iconst_1
    //   163: istore_2
    //   164: iload #16
    //   166: iload #11
    //   168: if_icmpeq -> 355
    //   171: aload_0
    //   172: iload #16
    //   174: invokevirtual getChildAt : (I)Landroid/view/View;
    //   177: astore_3
    //   178: aload_3
    //   179: aload #5
    //   181: if_acmpne -> 187
    //   184: goto -> 355
    //   187: aload_3
    //   188: invokevirtual isFocusable : ()Z
    //   191: ifne -> 197
    //   194: goto -> 345
    //   197: aload_3
    //   198: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   201: checkcast org/jar/support/v7/widget/GridLayoutManager$LayoutParams
    //   204: astore #4
    //   206: aload #4
    //   208: invokestatic access$000 : (Lorg/jar/support/v7/widget/GridLayoutManager$LayoutParams;)I
    //   211: istore #17
    //   213: aload #4
    //   215: invokestatic access$000 : (Lorg/jar/support/v7/widget/GridLayoutManager$LayoutParams;)I
    //   218: aload #4
    //   220: invokestatic access$100 : (Lorg/jar/support/v7/widget/GridLayoutManager$LayoutParams;)I
    //   223: iadd
    //   224: istore #18
    //   226: iload #17
    //   228: iload #8
    //   230: if_icmpne -> 242
    //   233: iload #18
    //   235: iload #9
    //   237: if_icmpne -> 242
    //   240: aload_3
    //   241: areturn
    //   242: aload_1
    //   243: ifnonnull -> 249
    //   246: goto -> 309
    //   249: iload #17
    //   251: iload #8
    //   253: invokestatic max : (II)I
    //   256: istore_2
    //   257: iload #18
    //   259: iload #9
    //   261: invokestatic min : (II)I
    //   264: iload_2
    //   265: isub
    //   266: istore_2
    //   267: iload_2
    //   268: iload #14
    //   270: if_icmple -> 278
    //   273: iconst_1
    //   274: istore_2
    //   275: goto -> 309
    //   278: iload_2
    //   279: iload #14
    //   281: if_icmpne -> 307
    //   284: iload #17
    //   286: iload #15
    //   288: if_icmple -> 296
    //   291: iconst_1
    //   292: istore_2
    //   293: goto -> 298
    //   296: iconst_0
    //   297: istore_2
    //   298: iload #13
    //   300: iload_2
    //   301: if_icmpne -> 307
    //   304: goto -> 273
    //   307: iconst_0
    //   308: istore_2
    //   309: iload_2
    //   310: ifeq -> 345
    //   313: aload #4
    //   315: invokestatic access$000 : (Lorg/jar/support/v7/widget/GridLayoutManager$LayoutParams;)I
    //   318: istore #15
    //   320: iload #18
    //   322: iload #9
    //   324: invokestatic min : (II)I
    //   327: istore_2
    //   328: iload #17
    //   330: iload #8
    //   332: invokestatic max : (II)I
    //   335: istore #14
    //   337: iload_2
    //   338: iload #14
    //   340: isub
    //   341: istore #14
    //   343: aload_3
    //   344: astore_1
    //   345: iload #16
    //   347: iload #12
    //   349: iadd
    //   350: istore #16
    //   352: goto -> 162
    //   355: aload_1
    //   356: areturn
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView) {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject) {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    if (paramState.isPreLayout())
      cachePreLayoutSpanMapping(); 
    super.onLayoutChildren(paramRecycler, paramState);
    clearPreLayoutSpanMappingCache();
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState) {
    super.onLayoutCompleted(paramState);
    this.mPendingSpanCountChange = false;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    updateMeasurements();
    ensureViewSet();
    return super.scrollHorizontallyBy(paramInt, paramRecycler, paramState);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    updateMeasurements();
    ensureViewSet();
    return super.scrollVerticallyBy(paramInt, paramRecycler, paramState);
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2) {
    if (this.mCachedBorders == null)
      super.setMeasuredDimension(paramRect, paramInt1, paramInt2); 
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1) {
      paramInt2 = chooseSize(paramInt2, paramRect.height() + j, getMinimumHeight());
      paramInt1 = chooseSize(paramInt1, this.mCachedBorders[this.mCachedBorders.length - 1] + i, getMinimumWidth());
    } else {
      paramInt1 = chooseSize(paramInt1, paramRect.width() + i, getMinimumWidth());
      paramInt2 = chooseSize(paramInt2, this.mCachedBorders[this.mCachedBorders.length - 1] + j, getMinimumHeight());
    } 
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setSpanCount(int paramInt) {
    if (paramInt == this.mSpanCount)
      return; 
    this.mPendingSpanCountChange = true;
    if (paramInt >= 1) {
      this.mSpanCount = paramInt;
      this.mSpanSizeLookup.invalidateSpanIndexCache();
      requestLayout();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Span count should be at least 1. Provided ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void setSpanSizeLookup(SpanSizeLookup paramSpanSizeLookup) {
    this.mSpanSizeLookup = paramSpanSizeLookup;
  }
  
  public void setStackFromEnd(boolean paramBoolean) {
    if (!paramBoolean) {
      super.setStackFromEnd(false);
      return;
    } 
    throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
  }
  
  public boolean supportsPredictiveItemAnimations() {
    boolean bool;
    if (this.mPendingSavedState == null && !this.mPendingSpanCountChange) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
    public int getSpanIndex(int param1Int1, int param1Int2) {
      return param1Int1 % param1Int2;
    }
    
    public int getSpanSize(int param1Int) {
      return 1;
    }
  }
  
  public static class LayoutParams extends RecyclerView.LayoutParams {
    public static final int INVALID_SPAN_ID = -1;
    
    private int mSpanIndex = -1;
    
    private int mSpanSize = 0;
    
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
    
    public int getSpanIndex() {
      return this.mSpanIndex;
    }
    
    public int getSpanSize() {
      return this.mSpanSize;
    }
  }
  
  public static abstract class SpanSizeLookup {
    private boolean mCacheSpanIndices = false;
    
    final SparseIntArray mSpanIndexCache = new SparseIntArray();
    
    int findReferenceIndexFromCache(int param1Int) {
      int i = this.mSpanIndexCache.size() - 1;
      int j = 0;
      while (j <= i) {
        int k = j + i >>> 1;
        if (this.mSpanIndexCache.keyAt(k) < param1Int) {
          j = k + 1;
          continue;
        } 
        i = k - 1;
      } 
      param1Int = j - 1;
      return (param1Int >= 0 && param1Int < this.mSpanIndexCache.size()) ? this.mSpanIndexCache.keyAt(param1Int) : -1;
    }
    
    int getCachedSpanIndex(int param1Int1, int param1Int2) {
      if (!this.mCacheSpanIndices)
        return getSpanIndex(param1Int1, param1Int2); 
      int i = this.mSpanIndexCache.get(param1Int1, -1);
      if (i != -1)
        return i; 
      param1Int2 = getSpanIndex(param1Int1, param1Int2);
      this.mSpanIndexCache.put(param1Int1, param1Int2);
      return param1Int2;
    }
    
    public int getSpanGroupIndex(int param1Int1, int param1Int2) {
      int i = getSpanSize(param1Int1);
      byte b = 0;
      int j = 0;
      int k;
      for (k = 0; b < param1Int1; k = i1) {
        int i1;
        int m = getSpanSize(b);
        int n = j + m;
        if (n == param1Int2) {
          i1 = k + 1;
          j = 0;
        } else {
          j = n;
          i1 = k;
          if (n > param1Int2) {
            i1 = k + 1;
            j = m;
          } 
        } 
        b++;
      } 
      param1Int1 = k;
      if (j + i > param1Int2)
        param1Int1 = k + 1; 
      return param1Int1;
    }
    
    public int getSpanIndex(int param1Int1, int param1Int2) {
      // Byte code:
      //   0: aload_0
      //   1: iload_1
      //   2: invokevirtual getSpanSize : (I)I
      //   5: istore_3
      //   6: iload_3
      //   7: iload_2
      //   8: if_icmpne -> 13
      //   11: iconst_0
      //   12: ireturn
      //   13: aload_0
      //   14: getfield mCacheSpanIndices : Z
      //   17: ifeq -> 66
      //   20: aload_0
      //   21: getfield mSpanIndexCache : Landroid/util/SparseIntArray;
      //   24: invokevirtual size : ()I
      //   27: ifle -> 66
      //   30: aload_0
      //   31: iload_1
      //   32: invokevirtual findReferenceIndexFromCache : (I)I
      //   35: istore #4
      //   37: iload #4
      //   39: iflt -> 66
      //   42: aload_0
      //   43: getfield mSpanIndexCache : Landroid/util/SparseIntArray;
      //   46: iload #4
      //   48: invokevirtual get : (I)I
      //   51: aload_0
      //   52: iload #4
      //   54: invokevirtual getSpanSize : (I)I
      //   57: iadd
      //   58: istore #5
      //   60: iinc #4, 1
      //   63: goto -> 72
      //   66: iconst_0
      //   67: istore #4
      //   69: iconst_0
      //   70: istore #5
      //   72: iload #4
      //   74: iload_1
      //   75: if_icmpge -> 125
      //   78: aload_0
      //   79: iload #4
      //   81: invokevirtual getSpanSize : (I)I
      //   84: istore #6
      //   86: iload #5
      //   88: iload #6
      //   90: iadd
      //   91: istore #7
      //   93: iload #7
      //   95: iload_2
      //   96: if_icmpne -> 105
      //   99: iconst_0
      //   100: istore #5
      //   102: goto -> 119
      //   105: iload #7
      //   107: istore #5
      //   109: iload #7
      //   111: iload_2
      //   112: if_icmple -> 119
      //   115: iload #6
      //   117: istore #5
      //   119: iinc #4, 1
      //   122: goto -> 72
      //   125: iload_3
      //   126: iload #5
      //   128: iadd
      //   129: iload_2
      //   130: if_icmpgt -> 136
      //   133: iload #5
      //   135: ireturn
      //   136: iconst_0
      //   137: ireturn
    }
    
    public abstract int getSpanSize(int param1Int);
    
    public void invalidateSpanIndexCache() {
      this.mSpanIndexCache.clear();
    }
    
    public boolean isSpanIndexCacheEnabled() {
      return this.mCacheSpanIndices;
    }
    
    public void setSpanIndexCacheEnabled(boolean param1Boolean) {
      this.mCacheSpanIndices = param1Boolean;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v7\widget\GridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */