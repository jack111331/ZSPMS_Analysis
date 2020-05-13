package org.jar.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.jar.support.v4.os.ParcelableCompat;
import org.jar.support.v4.os.ParcelableCompatCreatorCallbacks;
import org.jar.support.v4.widget.EdgeEffectCompat;

public class ViewPager extends ViewGroup {
  private static final int CLOSE_ENOUGH = 2;
  
  private static final Comparator<ItemInfo> COMPARATOR;
  
  private static final boolean DEBUG = false;
  
  private static final int DEFAULT_GUTTER_SIZE = 16;
  
  private static final int DEFAULT_OFFSCREEN_PAGES = 1;
  
  private static final int DRAW_ORDER_DEFAULT = 0;
  
  private static final int DRAW_ORDER_FORWARD = 1;
  
  private static final int DRAW_ORDER_REVERSE = 2;
  
  private static final int INVALID_POINTER = -1;
  
  private static final int[] LAYOUT_ATTRS = new int[] { 16842931 };
  
  private static final int MAX_SETTLE_DURATION = 600;
  
  private static final int MIN_DISTANCE_FOR_FLING = 25;
  
  private static final int MIN_FLING_VELOCITY = 400;
  
  public static final int SCROLL_STATE_DRAGGING = 1;
  
  public static final int SCROLL_STATE_IDLE = 0;
  
  public static final int SCROLL_STATE_SETTLING = 2;
  
  private static final String TAG = "ViewPager";
  
  private static final boolean USE_CACHE = false;
  
  private static final Interpolator sInterpolator;
  
  private static final ViewPositionComparator sPositionComparator;
  
  private int mActivePointerId = -1;
  
  private PagerAdapter mAdapter;
  
  private OnAdapterChangeListener mAdapterChangeListener;
  
  private int mBottomPageBounds;
  
  private boolean mCalledSuper;
  
  private int mChildHeightMeasureSpec;
  
  private int mChildWidthMeasureSpec;
  
  private int mCloseEnough;
  
  private int mCurItem;
  
  private int mDecorChildCount;
  
  private int mDefaultGutterSize;
  
  private int mDrawingOrder;
  
  private ArrayList<View> mDrawingOrderedChildren;
  
  private final Runnable mEndScrollRunnable = new Runnable() {
      public void run() {
        ViewPager.this.setScrollState(0);
        ViewPager.this.populate();
      }
    };
  
  private int mExpectedAdapterCount;
  
  private long mFakeDragBeginTime;
  
  private boolean mFakeDragging;
  
  private boolean mFirstLayout = true;
  
  private float mFirstOffset = -3.4028235E38F;
  
  private int mFlingDistance;
  
  private int mGutterSize;
  
  private boolean mInLayout;
  
  private float mInitialMotionX;
  
  private float mInitialMotionY;
  
  private OnPageChangeListener mInternalPageChangeListener;
  
  private boolean mIsBeingDragged;
  
  private boolean mIsScrollStarted;
  
  private boolean mIsUnableToDrag;
  
  private final ArrayList<ItemInfo> mItems = new ArrayList<ItemInfo>();
  
  private float mLastMotionX;
  
  private float mLastMotionY;
  
  private float mLastOffset = Float.MAX_VALUE;
  
  private EdgeEffectCompat mLeftEdge;
  
  private Drawable mMarginDrawable;
  
  private int mMaximumVelocity;
  
  private int mMinimumVelocity;
  
  private boolean mNeedCalculatePageOffsets = false;
  
  private PagerObserver mObserver;
  
  private int mOffscreenPageLimit = 1;
  
  private OnPageChangeListener mOnPageChangeListener;
  
  private List<OnPageChangeListener> mOnPageChangeListeners;
  
  private int mPageMargin;
  
  private PageTransformer mPageTransformer;
  
  private boolean mPopulatePending;
  
  private Parcelable mRestoredAdapterState = null;
  
  private ClassLoader mRestoredClassLoader = null;
  
  private int mRestoredCurItem = -1;
  
  private EdgeEffectCompat mRightEdge;
  
  private int mScrollState = 0;
  
  private Scroller mScroller;
  
  private boolean mScrollingCacheEnabled;
  
  private Method mSetChildrenDrawingOrderEnabled;
  
  private final ItemInfo mTempItem = new ItemInfo();
  
  private final Rect mTempRect = new Rect();
  
  private int mTopPageBounds;
  
  private int mTouchSlop;
  
  private VelocityTracker mVelocityTracker;
  
  static {
    COMPARATOR = new Comparator<ItemInfo>() {
        public int compare(ViewPager.ItemInfo param1ItemInfo1, ViewPager.ItemInfo param1ItemInfo2) {
          return param1ItemInfo1.position - param1ItemInfo2.position;
        }
      };
    sInterpolator = new Interpolator() {
        public float getInterpolation(float param1Float) {
          param1Float--;
          return param1Float * param1Float * param1Float * param1Float * param1Float + 1.0F;
        }
      };
    sPositionComparator = new ViewPositionComparator();
  }
  
  public ViewPager(Context paramContext) {
    super(paramContext);
    initViewPager();
  }
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    initViewPager();
  }
  
  private void calculatePageOffsets(ItemInfo paramItemInfo1, int paramInt, ItemInfo paramItemInfo2) {
    float f1;
    int i = this.mAdapter.getCount();
    int j = getClientWidth();
    if (j > 0) {
      f1 = this.mPageMargin / j;
    } else {
      f1 = 0.0F;
    } 
    if (paramItemInfo2 != null) {
      j = paramItemInfo2.position;
      if (j < paramItemInfo1.position) {
        f2 = paramItemInfo2.offset + paramItemInfo2.widthFactor + f1;
        j++;
        byte b = 0;
        while (j <= paramItemInfo1.position && b < this.mItems.size()) {
          int n;
          float f;
          paramItemInfo2 = this.mItems.get(b);
          while (true) {
            n = j;
            f = f2;
            if (j > paramItemInfo2.position) {
              n = j;
              f = f2;
              if (b < this.mItems.size() - 1) {
                paramItemInfo2 = this.mItems.get(++b);
                continue;
              } 
            } 
            break;
          } 
          while (n < paramItemInfo2.position) {
            f += this.mAdapter.getPageWidth(n) + f1;
            n++;
          } 
          paramItemInfo2.offset = f;
          f2 = f + paramItemInfo2.widthFactor + f1;
          j = n + 1;
        } 
      } else if (j > paramItemInfo1.position) {
        int n = this.mItems.size() - 1;
        f2 = paramItemInfo2.offset;
        while (--j >= paramItemInfo1.position && n >= 0) {
          int i1;
          float f;
          paramItemInfo2 = this.mItems.get(n);
          while (true) {
            i1 = j;
            f = f2;
            if (j < paramItemInfo2.position) {
              i1 = j;
              f = f2;
              if (n > 0) {
                paramItemInfo2 = this.mItems.get(--n);
                continue;
              } 
            } 
            break;
          } 
          while (i1 > paramItemInfo2.position) {
            f -= this.mAdapter.getPageWidth(i1) + f1;
            i1--;
          } 
          f2 = f - paramItemInfo2.widthFactor + f1;
          paramItemInfo2.offset = f2;
          j = i1 - 1;
        } 
      } 
    } 
    int m = this.mItems.size();
    float f3 = paramItemInfo1.offset;
    j = paramItemInfo1.position - 1;
    if (paramItemInfo1.position == 0) {
      f2 = paramItemInfo1.offset;
    } else {
      f2 = -3.4028235E38F;
    } 
    this.mFirstOffset = f2;
    int k = paramItemInfo1.position;
    if (k == --i) {
      f2 = paramItemInfo1.offset + paramItemInfo1.widthFactor - 1.0F;
    } else {
      f2 = Float.MAX_VALUE;
    } 
    this.mLastOffset = f2;
    k = paramInt - 1;
    float f2 = f3;
    while (k >= 0) {
      paramItemInfo2 = this.mItems.get(k);
      while (j > paramItemInfo2.position) {
        f2 -= this.mAdapter.getPageWidth(j) + f1;
        j--;
      } 
      f2 -= paramItemInfo2.widthFactor + f1;
      paramItemInfo2.offset = f2;
      if (paramItemInfo2.position == 0)
        this.mFirstOffset = f2; 
      k--;
      j--;
    } 
    f2 = paramItemInfo1.offset + paramItemInfo1.widthFactor + f1;
    k = paramItemInfo1.position + 1;
    j = paramInt + 1;
    for (paramInt = k; j < m; paramInt++) {
      paramItemInfo1 = this.mItems.get(j);
      while (paramInt < paramItemInfo1.position) {
        f2 += this.mAdapter.getPageWidth(paramInt) + f1;
        paramInt++;
      } 
      if (paramItemInfo1.position == i)
        this.mLastOffset = paramItemInfo1.widthFactor + f2 - 1.0F; 
      paramItemInfo1.offset = f2;
      f2 += paramItemInfo1.widthFactor + f1;
      j++;
    } 
    this.mNeedCalculatePageOffsets = false;
  }
  
  private void completeScroll(boolean paramBoolean) {
    if (this.mScrollState == 2) {
      b1 = 1;
    } else {
      b1 = 0;
    } 
    if (b1) {
      setScrollingCacheEnabled(false);
      if ((this.mScroller.isFinished() ^ true) != 0) {
        this.mScroller.abortAnimation();
        int i = getScrollX();
        int j = getScrollY();
        int k = this.mScroller.getCurrX();
        int m = this.mScroller.getCurrY();
        if (i != k || j != m) {
          scrollTo(k, m);
          if (k != i)
            pageScrolled(k); 
        } 
      } 
    } 
    this.mPopulatePending = false;
    byte b3 = 0;
    byte b2 = b1;
    for (byte b1 = b3; b1 < this.mItems.size(); b1++) {
      ItemInfo itemInfo = this.mItems.get(b1);
      if (itemInfo.scrolling) {
        itemInfo.scrolling = false;
        b2 = 1;
      } 
    } 
    if (b2 != 0)
      if (paramBoolean) {
        ViewCompat.postOnAnimation((View)this, this.mEndScrollRunnable);
      } else {
        this.mEndScrollRunnable.run();
      }  
  }
  
  private int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3) {
    if (Math.abs(paramInt3) > this.mFlingDistance && Math.abs(paramInt2) > this.mMinimumVelocity) {
      if (paramInt2 <= 0)
        paramInt1++; 
    } else {
      float f;
      if (paramInt1 >= this.mCurItem) {
        f = 0.4F;
      } else {
        f = 0.6F;
      } 
      paramInt1 = (int)(paramInt1 + paramFloat + f);
    } 
    paramInt2 = paramInt1;
    if (this.mItems.size() > 0) {
      ItemInfo itemInfo1 = this.mItems.get(0);
      ItemInfo itemInfo2 = this.mItems.get(this.mItems.size() - 1);
      paramInt2 = Math.max(itemInfo1.position, Math.min(paramInt1, itemInfo2.position));
    } 
    return paramInt2;
  }
  
  private void dispatchOnPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    if (this.mOnPageChangeListener != null)
      this.mOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2); 
    if (this.mOnPageChangeListeners != null) {
      byte b = 0;
      int i = this.mOnPageChangeListeners.size();
      while (b < i) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(b);
        if (onPageChangeListener != null)
          onPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2); 
        b++;
      } 
    } 
    if (this.mInternalPageChangeListener != null)
      this.mInternalPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2); 
  }
  
  private void dispatchOnPageSelected(int paramInt) {
    if (this.mOnPageChangeListener != null)
      this.mOnPageChangeListener.onPageSelected(paramInt); 
    if (this.mOnPageChangeListeners != null) {
      byte b = 0;
      int i = this.mOnPageChangeListeners.size();
      while (b < i) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(b);
        if (onPageChangeListener != null)
          onPageChangeListener.onPageSelected(paramInt); 
        b++;
      } 
    } 
    if (this.mInternalPageChangeListener != null)
      this.mInternalPageChangeListener.onPageSelected(paramInt); 
  }
  
  private void dispatchOnScrollStateChanged(int paramInt) {
    if (this.mOnPageChangeListener != null)
      this.mOnPageChangeListener.onPageScrollStateChanged(paramInt); 
    if (this.mOnPageChangeListeners != null) {
      byte b = 0;
      int i = this.mOnPageChangeListeners.size();
      while (b < i) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(b);
        if (onPageChangeListener != null)
          onPageChangeListener.onPageScrollStateChanged(paramInt); 
        b++;
      } 
    } 
    if (this.mInternalPageChangeListener != null)
      this.mInternalPageChangeListener.onPageScrollStateChanged(paramInt); 
  }
  
  private void enableLayers(boolean paramBoolean) {
    int i = getChildCount();
    for (byte b = 0; b < i; b++) {
      boolean bool;
      if (paramBoolean) {
        bool = true;
      } else {
        bool = false;
      } 
      ViewCompat.setLayerType(getChildAt(b), bool, null);
    } 
  }
  
  private void endDrag() {
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    } 
  }
  
  private Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView) {
    Rect rect = paramRect;
    if (paramRect == null)
      rect = new Rect(); 
    if (paramView == null) {
      rect.set(0, 0, 0, 0);
      return rect;
    } 
    rect.left = paramView.getLeft();
    rect.right = paramView.getRight();
    rect.top = paramView.getTop();
    rect.bottom = paramView.getBottom();
    ViewParent viewParent = paramView.getParent();
    while (viewParent instanceof ViewGroup && viewParent != this) {
      ViewGroup viewGroup = (ViewGroup)viewParent;
      rect.left += viewGroup.getLeft();
      rect.right += viewGroup.getRight();
      rect.top += viewGroup.getTop();
      rect.bottom += viewGroup.getBottom();
      ViewParent viewParent1 = viewGroup.getParent();
    } 
    return rect;
  }
  
  private int getClientWidth() {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private ItemInfo infoForCurrentScrollPosition() {
    float f1;
    float f2;
    int i = getClientWidth();
    if (i > 0) {
      f1 = getScrollX() / i;
    } else {
      f1 = 0.0F;
    } 
    if (i > 0) {
      f2 = this.mPageMargin / i;
    } else {
      f2 = 0.0F;
    } 
    ItemInfo itemInfo = null;
    i = 0;
    boolean bool = true;
    int j = -1;
    float f3 = 0.0F;
    float f4 = 0.0F;
    while (i < this.mItems.size()) {
      ItemInfo itemInfo1 = this.mItems.get(i);
      int k = i;
      ItemInfo itemInfo2 = itemInfo1;
      if (!bool) {
        int m = itemInfo1.position;
        j++;
        k = i;
        itemInfo2 = itemInfo1;
        if (m != j) {
          itemInfo2 = this.mTempItem;
          itemInfo2.offset = f3 + f4 + f2;
          itemInfo2.position = j;
          itemInfo2.widthFactor = this.mAdapter.getPageWidth(itemInfo2.position);
          k = i - 1;
        } 
      } 
      f3 = itemInfo2.offset;
      f4 = itemInfo2.widthFactor;
      if (bool || f1 >= f3) {
        if (f1 < f4 + f3 + f2 || k == this.mItems.size() - 1)
          return itemInfo2; 
        j = itemInfo2.position;
        f4 = itemInfo2.widthFactor;
        i = k + 1;
        bool = false;
        itemInfo = itemInfo2;
        continue;
      } 
      return itemInfo;
    } 
    return itemInfo;
  }
  
  private boolean isGutterDrag(float paramFloat1, float paramFloat2) {
    boolean bool;
    if ((paramFloat1 < this.mGutterSize && paramFloat2 > 0.0F) || (paramFloat1 > (getWidth() - this.mGutterSize) && paramFloat2 < 0.0F)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent) {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == this.mActivePointerId) {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, i);
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      if (this.mVelocityTracker != null)
        this.mVelocityTracker.clear(); 
    } 
  }
  
  private boolean pageScrolled(int paramInt) {
    if (this.mItems.size() == 0) {
      if (this.mFirstLayout)
        return false; 
      this.mCalledSuper = false;
      onPageScrolled(0, 0.0F, 0);
      if (this.mCalledSuper)
        return false; 
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    } 
    ItemInfo itemInfo = infoForCurrentScrollPosition();
    int i = getClientWidth();
    int j = this.mPageMargin;
    float f1 = this.mPageMargin;
    float f2 = i;
    f1 /= f2;
    int k = itemInfo.position;
    f2 = (paramInt / f2 - itemInfo.offset) / (itemInfo.widthFactor + f1);
    paramInt = (int)((j + i) * f2);
    this.mCalledSuper = false;
    onPageScrolled(k, f2, paramInt);
    if (this.mCalledSuper)
      return true; 
    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
  }
  
  private boolean performDrag(float paramFloat) {
    float f1 = this.mLastMotionX;
    this.mLastMotionX = paramFloat;
    float f2 = getScrollX() + f1 - paramFloat;
    float f3 = getClientWidth();
    paramFloat = this.mFirstOffset * f3;
    f1 = this.mLastOffset * f3;
    ArrayList<ItemInfo> arrayList1 = this.mItems;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool = false;
    ItemInfo itemInfo1 = arrayList1.get(0);
    ArrayList<ItemInfo> arrayList2 = this.mItems;
    int i = this.mItems.size();
    boolean bool3 = true;
    ItemInfo itemInfo2 = arrayList2.get(i - 1);
    if (itemInfo1.position != 0) {
      paramFloat = itemInfo1.offset * f3;
      i = 0;
    } else {
      i = 1;
    } 
    if (itemInfo2.position != this.mAdapter.getCount() - 1) {
      f1 = itemInfo2.offset * f3;
      bool3 = false;
    } 
    if (f2 < paramFloat) {
      if (i != 0)
        bool = this.mLeftEdge.onPull(Math.abs(paramFloat - f2) / f3); 
    } else {
      bool = bool2;
      paramFloat = f2;
      if (f2 > f1) {
        bool = bool1;
        if (bool3)
          bool = this.mRightEdge.onPull(Math.abs(f2 - f1) / f3); 
        paramFloat = f1;
      } 
    } 
    f1 = this.mLastMotionX;
    i = (int)paramFloat;
    this.mLastMotionX = f1 + paramFloat - i;
    scrollTo(i, getScrollY());
    pageScrolled(i);
    return bool;
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramInt2 > 0 && !this.mItems.isEmpty()) {
      if (!this.mScroller.isFinished()) {
        this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
      } else {
        int i = getPaddingLeft();
        int j = getPaddingRight();
        int k = getPaddingLeft();
        int m = getPaddingRight();
        scrollTo((int)(getScrollX() / (paramInt2 - k - m + paramInt4) * (paramInt1 - i - j + paramInt3)), getScrollY());
      } 
    } else {
      float f;
      ItemInfo itemInfo = infoForPosition(this.mCurItem);
      if (itemInfo != null) {
        f = Math.min(itemInfo.offset, this.mLastOffset);
      } else {
        f = 0.0F;
      } 
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 != getScrollX()) {
        completeScroll(false);
        scrollTo(paramInt1, getScrollY());
      } 
    } 
  }
  
  private void removeNonDecorViews() {
    for (int i = 0; i < getChildCount(); i = j + 1) {
      int j = i;
      if (!((LayoutParams)getChildAt(i).getLayoutParams()).isDecor) {
        removeViewAt(i);
        j = i - 1;
      } 
    } 
  }
  
  private void requestParentDisallowInterceptTouchEvent(boolean paramBoolean) {
    ViewParent viewParent = getParent();
    if (viewParent != null)
      viewParent.requestDisallowInterceptTouchEvent(paramBoolean); 
  }
  
  private boolean resetTouch() {
    this.mActivePointerId = -1;
    endDrag();
    return this.mLeftEdge.onRelease() | this.mRightEdge.onRelease();
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2) {
    boolean bool;
    ItemInfo itemInfo = infoForPosition(paramInt1);
    if (itemInfo != null) {
      bool = (int)(getClientWidth() * Math.max(this.mFirstOffset, Math.min(itemInfo.offset, this.mLastOffset)));
    } else {
      bool = false;
    } 
    if (paramBoolean1) {
      smoothScrollTo(bool, 0, paramInt2);
      if (paramBoolean2)
        dispatchOnPageSelected(paramInt1); 
    } else {
      if (paramBoolean2)
        dispatchOnPageSelected(paramInt1); 
      completeScroll(false);
      scrollTo(bool, 0);
      pageScrolled(bool);
    } 
  }
  
  private void setScrollState(int paramInt) {
    if (this.mScrollState == paramInt)
      return; 
    this.mScrollState = paramInt;
    if (this.mPageTransformer != null) {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      enableLayers(bool);
    } 
    dispatchOnScrollStateChanged(paramInt);
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean) {
    if (this.mScrollingCacheEnabled != paramBoolean)
      this.mScrollingCacheEnabled = paramBoolean; 
  }
  
  private void sortChildDrawingOrder() {
    if (this.mDrawingOrder != 0) {
      if (this.mDrawingOrderedChildren == null) {
        this.mDrawingOrderedChildren = new ArrayList<View>();
      } else {
        this.mDrawingOrderedChildren.clear();
      } 
      int i = getChildCount();
      for (byte b = 0; b < i; b++) {
        View view = getChildAt(b);
        this.mDrawingOrderedChildren.add(view);
      } 
      Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
    } 
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2) {
    int i = paramArrayList.size();
    int j = getDescendantFocusability();
    if (j != 393216)
      for (byte b = 0; b < getChildCount(); b++) {
        View view = getChildAt(b);
        if (view.getVisibility() == 0) {
          ItemInfo itemInfo = infoForChild(view);
          if (itemInfo != null && itemInfo.position == this.mCurItem)
            view.addFocusables(paramArrayList, paramInt1, paramInt2); 
        } 
      }  
    if (j != 262144 || i == paramArrayList.size()) {
      if (!isFocusable())
        return; 
      if ((paramInt2 & 0x1) == 1 && isInTouchMode() && !isFocusableInTouchMode())
        return; 
      if (paramArrayList != null)
        paramArrayList.add(this); 
    } 
  }
  
  ItemInfo addNewItem(int paramInt1, int paramInt2) {
    ItemInfo itemInfo = new ItemInfo();
    itemInfo.position = paramInt1;
    itemInfo.object = this.mAdapter.instantiateItem(this, paramInt1);
    itemInfo.widthFactor = this.mAdapter.getPageWidth(paramInt1);
    if (paramInt2 < 0 || paramInt2 >= this.mItems.size()) {
      this.mItems.add(itemInfo);
      return itemInfo;
    } 
    this.mItems.add(paramInt2, itemInfo);
    return itemInfo;
  }
  
  public void addOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener) {
    if (this.mOnPageChangeListeners == null)
      this.mOnPageChangeListeners = new ArrayList<OnPageChangeListener>(); 
    this.mOnPageChangeListeners.add(paramOnPageChangeListener);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList) {
    for (byte b = 0; b < getChildCount(); b++) {
      View view = getChildAt(b);
      if (view.getVisibility() == 0) {
        ItemInfo itemInfo = infoForChild(view);
        if (itemInfo != null && itemInfo.position == this.mCurItem)
          view.addTouchables(paramArrayList); 
      } 
    } 
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    ViewGroup.LayoutParams layoutParams = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams))
      layoutParams = generateLayoutParams(paramLayoutParams); 
    paramLayoutParams = layoutParams;
    ((LayoutParams)paramLayoutParams).isDecor |= paramView instanceof Decor;
    if (this.mInLayout) {
      if (paramLayoutParams == null || !((LayoutParams)paramLayoutParams).isDecor) {
        ((LayoutParams)paramLayoutParams).needsMeasure = true;
        addViewInLayout(paramView, paramInt, layoutParams);
        return;
      } 
      throw new IllegalStateException("Cannot add pager decor view during layout");
    } 
    super.addView(paramView, paramInt, layoutParams);
  }
  
  public boolean arrowScroll(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual findFocus : ()Landroid/view/View;
    //   4: astore_2
    //   5: iconst_0
    //   6: istore_3
    //   7: aconst_null
    //   8: astore #4
    //   10: aload_2
    //   11: aload_0
    //   12: if_acmpne -> 22
    //   15: aload #4
    //   17: astore #5
    //   19: goto -> 193
    //   22: aload_2
    //   23: ifnull -> 190
    //   26: aload_2
    //   27: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   30: astore #5
    //   32: aload #5
    //   34: instanceof android/view/ViewGroup
    //   37: ifeq -> 64
    //   40: aload #5
    //   42: aload_0
    //   43: if_acmpne -> 52
    //   46: iconst_1
    //   47: istore #6
    //   49: goto -> 67
    //   52: aload #5
    //   54: invokeinterface getParent : ()Landroid/view/ViewParent;
    //   59: astore #5
    //   61: goto -> 32
    //   64: iconst_0
    //   65: istore #6
    //   67: iload #6
    //   69: ifne -> 190
    //   72: new java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: astore #7
    //   81: aload #7
    //   83: aload_2
    //   84: invokevirtual getClass : ()Ljava/lang/Class;
    //   87: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_2
    //   95: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   98: astore #5
    //   100: aload #5
    //   102: instanceof android/view/ViewGroup
    //   105: ifeq -> 143
    //   108: aload #7
    //   110: ldc_w ' => '
    //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload #7
    //   119: aload #5
    //   121: invokevirtual getClass : ()Ljava/lang/Class;
    //   124: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload #5
    //   133: invokeinterface getParent : ()Landroid/view/ViewParent;
    //   138: astore #5
    //   140: goto -> 100
    //   143: new java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial <init> : ()V
    //   150: astore #5
    //   152: aload #5
    //   154: ldc_w 'arrowScroll tried to find focus based on non-child current focused view '
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload #5
    //   163: aload #7
    //   165: invokevirtual toString : ()Ljava/lang/String;
    //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: ldc 'ViewPager'
    //   174: aload #5
    //   176: invokevirtual toString : ()Ljava/lang/String;
    //   179: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   182: pop
    //   183: aload #4
    //   185: astore #5
    //   187: goto -> 193
    //   190: aload_2
    //   191: astore #5
    //   193: invokestatic getInstance : ()Landroid/view/FocusFinder;
    //   196: aload_0
    //   197: aload #5
    //   199: iload_1
    //   200: invokevirtual findNextFocus : (Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;
    //   203: astore #4
    //   205: aload #4
    //   207: ifnull -> 347
    //   210: aload #4
    //   212: aload #5
    //   214: if_acmpeq -> 347
    //   217: iload_1
    //   218: bipush #17
    //   220: if_icmpne -> 282
    //   223: aload_0
    //   224: aload_0
    //   225: getfield mTempRect : Landroid/graphics/Rect;
    //   228: aload #4
    //   230: invokespecial getChildRectInPagerCoordinates : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   233: getfield left : I
    //   236: istore #6
    //   238: aload_0
    //   239: aload_0
    //   240: getfield mTempRect : Landroid/graphics/Rect;
    //   243: aload #5
    //   245: invokespecial getChildRectInPagerCoordinates : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   248: getfield left : I
    //   251: istore #8
    //   253: aload #5
    //   255: ifnull -> 273
    //   258: iload #6
    //   260: iload #8
    //   262: if_icmplt -> 273
    //   265: aload_0
    //   266: invokevirtual pageLeft : ()Z
    //   269: istore_3
    //   270: goto -> 279
    //   273: aload #4
    //   275: invokevirtual requestFocus : ()Z
    //   278: istore_3
    //   279: goto -> 385
    //   282: iload_1
    //   283: bipush #66
    //   285: if_icmpne -> 385
    //   288: aload_0
    //   289: aload_0
    //   290: getfield mTempRect : Landroid/graphics/Rect;
    //   293: aload #4
    //   295: invokespecial getChildRectInPagerCoordinates : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   298: getfield left : I
    //   301: istore #6
    //   303: aload_0
    //   304: aload_0
    //   305: getfield mTempRect : Landroid/graphics/Rect;
    //   308: aload #5
    //   310: invokespecial getChildRectInPagerCoordinates : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   313: getfield left : I
    //   316: istore #8
    //   318: aload #5
    //   320: ifnull -> 338
    //   323: iload #6
    //   325: iload #8
    //   327: if_icmpgt -> 338
    //   330: aload_0
    //   331: invokevirtual pageRight : ()Z
    //   334: istore_3
    //   335: goto -> 279
    //   338: aload #4
    //   340: invokevirtual requestFocus : ()Z
    //   343: istore_3
    //   344: goto -> 279
    //   347: iload_1
    //   348: bipush #17
    //   350: if_icmpeq -> 380
    //   353: iload_1
    //   354: iconst_1
    //   355: if_icmpne -> 361
    //   358: goto -> 380
    //   361: iload_1
    //   362: bipush #66
    //   364: if_icmpeq -> 372
    //   367: iload_1
    //   368: iconst_2
    //   369: if_icmpne -> 385
    //   372: aload_0
    //   373: invokevirtual pageRight : ()Z
    //   376: istore_3
    //   377: goto -> 385
    //   380: aload_0
    //   381: invokevirtual pageLeft : ()Z
    //   384: istore_3
    //   385: iload_3
    //   386: ifeq -> 397
    //   389: aload_0
    //   390: iload_1
    //   391: invokestatic getContantForFocusDirection : (I)I
    //   394: invokevirtual playSoundEffect : (I)V
    //   397: iload_3
    //   398: ireturn
  }
  
  public boolean beginFakeDrag() {
    if (this.mIsBeingDragged)
      return false; 
    this.mFakeDragging = true;
    setScrollState(1);
    this.mLastMotionX = 0.0F;
    this.mInitialMotionX = 0.0F;
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    } else {
      this.mVelocityTracker.clear();
    } 
    long l = SystemClock.uptimeMillis();
    MotionEvent motionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
    this.mVelocityTracker.addMovement(motionEvent);
    motionEvent.recycle();
    this.mFakeDragBeginTime = l;
    return true;
  }
  
  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
    boolean bool = paramView instanceof ViewGroup;
    boolean bool1 = true;
    if (bool) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      int i = paramView.getScrollX();
      int j = paramView.getScrollY();
      for (int k = viewGroup.getChildCount() - 1; k >= 0; k--) {
        View view = viewGroup.getChildAt(k);
        int m = paramInt2 + i;
        if (m >= view.getLeft() && m < view.getRight()) {
          int n = paramInt3 + j;
          if (n >= view.getTop() && n < view.getBottom() && canScroll(view, true, paramInt1, m - view.getLeft(), n - view.getTop()))
            return true; 
        } 
      } 
    } 
    if (paramBoolean && ViewCompat.canScrollHorizontally(paramView, -paramInt1)) {
      paramBoolean = bool1;
    } else {
      paramBoolean = false;
    } 
    return paramBoolean;
  }
  
  public boolean canScrollHorizontally(int paramInt) {
    PagerAdapter pagerAdapter = this.mAdapter;
    boolean bool1 = false;
    boolean bool2 = false;
    if (pagerAdapter == null)
      return false; 
    int i = getClientWidth();
    int j = getScrollX();
    if (paramInt < 0) {
      if (j > (int)(i * this.mFirstOffset))
        bool2 = true; 
      return bool2;
    } 
    if (paramInt > 0) {
      bool2 = bool1;
      if (j < (int)(i * this.mLastOffset))
        bool2 = true; 
      return bool2;
    } 
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    boolean bool;
    if (paramLayoutParams instanceof LayoutParams && super.checkLayoutParams(paramLayoutParams)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void clearOnPageChangeListeners() {
    if (this.mOnPageChangeListeners != null)
      this.mOnPageChangeListeners.clear(); 
  }
  
  public void computeScroll() {
    this.mIsScrollStarted = true;
    if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.mScroller.getCurrX();
      int m = this.mScroller.getCurrY();
      if (i != k || j != m) {
        scrollTo(k, m);
        if (!pageScrolled(k)) {
          this.mScroller.abortAnimation();
          scrollTo(0, m);
        } 
      } 
      ViewCompat.postInvalidateOnAnimation((View)this);
      return;
    } 
    completeScroll(true);
  }
  
  void dataSetChanged() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mAdapter : Lorg/jar/support/v4/view/PagerAdapter;
    //   4: invokevirtual getCount : ()I
    //   7: istore_1
    //   8: aload_0
    //   9: iload_1
    //   10: putfield mExpectedAdapterCount : I
    //   13: aload_0
    //   14: getfield mItems : Ljava/util/ArrayList;
    //   17: invokevirtual size : ()I
    //   20: aload_0
    //   21: getfield mOffscreenPageLimit : I
    //   24: iconst_2
    //   25: imul
    //   26: iconst_1
    //   27: iadd
    //   28: if_icmpge -> 47
    //   31: aload_0
    //   32: getfield mItems : Ljava/util/ArrayList;
    //   35: invokevirtual size : ()I
    //   38: iload_1
    //   39: if_icmpge -> 47
    //   42: iconst_1
    //   43: istore_2
    //   44: goto -> 49
    //   47: iconst_0
    //   48: istore_2
    //   49: aload_0
    //   50: getfield mCurItem : I
    //   53: istore_3
    //   54: iload_2
    //   55: istore #4
    //   57: iload_3
    //   58: istore_2
    //   59: iconst_0
    //   60: istore #5
    //   62: iconst_0
    //   63: istore_3
    //   64: iload #5
    //   66: aload_0
    //   67: getfield mItems : Ljava/util/ArrayList;
    //   70: invokevirtual size : ()I
    //   73: if_icmpge -> 299
    //   76: aload_0
    //   77: getfield mItems : Ljava/util/ArrayList;
    //   80: iload #5
    //   82: invokevirtual get : (I)Ljava/lang/Object;
    //   85: checkcast org/jar/support/v4/view/ViewPager$ItemInfo
    //   88: astore #6
    //   90: aload_0
    //   91: getfield mAdapter : Lorg/jar/support/v4/view/PagerAdapter;
    //   94: aload #6
    //   96: getfield object : Ljava/lang/Object;
    //   99: invokevirtual getItemPosition : (Ljava/lang/Object;)I
    //   102: istore #7
    //   104: iload #7
    //   106: iconst_m1
    //   107: if_icmpne -> 123
    //   110: iload #5
    //   112: istore #8
    //   114: iload_3
    //   115: istore #9
    //   117: iload_2
    //   118: istore #10
    //   120: goto -> 284
    //   123: iload #7
    //   125: bipush #-2
    //   127: if_icmpne -> 239
    //   130: aload_0
    //   131: getfield mItems : Ljava/util/ArrayList;
    //   134: iload #5
    //   136: invokevirtual remove : (I)Ljava/lang/Object;
    //   139: pop
    //   140: iload #5
    //   142: iconst_1
    //   143: isub
    //   144: istore #9
    //   146: iload_3
    //   147: istore #8
    //   149: iload_3
    //   150: ifne -> 164
    //   153: aload_0
    //   154: getfield mAdapter : Lorg/jar/support/v4/view/PagerAdapter;
    //   157: aload_0
    //   158: invokevirtual startUpdate : (Landroid/view/ViewGroup;)V
    //   161: iconst_1
    //   162: istore #8
    //   164: aload_0
    //   165: getfield mAdapter : Lorg/jar/support/v4/view/PagerAdapter;
    //   168: aload_0
    //   169: aload #6
    //   171: getfield position : I
    //   174: aload #6
    //   176: getfield object : Ljava/lang/Object;
    //   179: invokevirtual destroyItem : (Landroid/view/ViewGroup;ILjava/lang/Object;)V
    //   182: iload #9
    //   184: istore #5
    //   186: iload #8
    //   188: istore_3
    //   189: aload_0
    //   190: getfield mCurItem : I
    //   193: aload #6
    //   195: getfield position : I
    //   198: if_icmpne -> 223
    //   201: iconst_0
    //   202: aload_0
    //   203: getfield mCurItem : I
    //   206: iload_1
    //   207: iconst_1
    //   208: isub
    //   209: invokestatic min : (II)I
    //   212: invokestatic max : (II)I
    //   215: istore_2
    //   216: iload #8
    //   218: istore_3
    //   219: iload #9
    //   221: istore #5
    //   223: iconst_1
    //   224: istore #4
    //   226: iload #5
    //   228: istore #8
    //   230: iload_3
    //   231: istore #9
    //   233: iload_2
    //   234: istore #10
    //   236: goto -> 284
    //   239: iload #5
    //   241: istore #8
    //   243: iload_3
    //   244: istore #9
    //   246: iload_2
    //   247: istore #10
    //   249: aload #6
    //   251: getfield position : I
    //   254: iload #7
    //   256: if_icmpeq -> 284
    //   259: aload #6
    //   261: getfield position : I
    //   264: aload_0
    //   265: getfield mCurItem : I
    //   268: if_icmpne -> 274
    //   271: iload #7
    //   273: istore_2
    //   274: aload #6
    //   276: iload #7
    //   278: putfield position : I
    //   281: goto -> 223
    //   284: iload #8
    //   286: iconst_1
    //   287: iadd
    //   288: istore #5
    //   290: iload #9
    //   292: istore_3
    //   293: iload #10
    //   295: istore_2
    //   296: goto -> 64
    //   299: iload_3
    //   300: ifeq -> 311
    //   303: aload_0
    //   304: getfield mAdapter : Lorg/jar/support/v4/view/PagerAdapter;
    //   307: aload_0
    //   308: invokevirtual finishUpdate : (Landroid/view/ViewGroup;)V
    //   311: aload_0
    //   312: getfield mItems : Ljava/util/ArrayList;
    //   315: getstatic org/jar/support/v4/view/ViewPager.COMPARATOR : Ljava/util/Comparator;
    //   318: invokestatic sort : (Ljava/util/List;Ljava/util/Comparator;)V
    //   321: iload #4
    //   323: ifeq -> 384
    //   326: aload_0
    //   327: invokevirtual getChildCount : ()I
    //   330: istore #5
    //   332: iconst_0
    //   333: istore_3
    //   334: iload_3
    //   335: iload #5
    //   337: if_icmpge -> 373
    //   340: aload_0
    //   341: iload_3
    //   342: invokevirtual getChildAt : (I)Landroid/view/View;
    //   345: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   348: checkcast org/jar/support/v4/view/ViewPager$LayoutParams
    //   351: astore #6
    //   353: aload #6
    //   355: getfield isDecor : Z
    //   358: ifne -> 367
    //   361: aload #6
    //   363: fconst_0
    //   364: putfield widthFactor : F
    //   367: iinc #3, 1
    //   370: goto -> 334
    //   373: aload_0
    //   374: iload_2
    //   375: iconst_0
    //   376: iconst_1
    //   377: invokevirtual setCurrentItemInternal : (IZZ)V
    //   380: aload_0
    //   381: invokevirtual requestLayout : ()V
    //   384: return
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return (super.dispatchKeyEvent(paramKeyEvent) || executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    int i = getChildCount();
    for (byte b = 0; b < i; b++) {
      View view = getChildAt(b);
      if (view.getVisibility() == 0) {
        ItemInfo itemInfo = infoForChild(view);
        if (itemInfo != null && itemInfo.position == this.mCurItem && view.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))
          return true; 
      } 
    } 
    return false;
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat) {
    double d = (paramFloat - 0.5F);
    Double.isNaN(d);
    return (float)Math.sin((float)(d * 0.4712389167638204D));
  }
  
  public void draw(Canvas paramCanvas) {
    boolean bool;
    super.draw(paramCanvas);
    int i = ViewCompat.getOverScrollMode((View)this);
    int j = 0;
    int k = 0;
    if (i == 0 || (i == 1 && this.mAdapter != null && this.mAdapter.getCount() > 1)) {
      if (!this.mLeftEdge.isFinished()) {
        j = paramCanvas.save();
        k = getHeight() - getPaddingTop() - getPaddingBottom();
        i = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate((-k + getPaddingTop()), this.mFirstOffset * i);
        this.mLeftEdge.setSize(k, i);
        k = false | this.mLeftEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(j);
      } 
      j = k;
      if (!this.mRightEdge.isFinished()) {
        i = paramCanvas.save();
        int m = getWidth();
        int n = getHeight();
        j = getPaddingTop();
        int i1 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.mLastOffset + 1.0F) * m);
        this.mRightEdge.setSize(n - j - i1, m);
        bool = k | this.mRightEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(i);
      } 
    } else {
      this.mLeftEdge.finish();
      this.mRightEdge.finish();
    } 
    if (bool)
      ViewCompat.postInvalidateOnAnimation((View)this); 
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    Drawable drawable = this.mMarginDrawable;
    if (drawable != null && drawable.isStateful())
      drawable.setState(getDrawableState()); 
  }
  
  public void endFakeDrag() {
    if (this.mFakeDragging) {
      if (this.mAdapter != null) {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int i = (int)VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
        this.mPopulatePending = true;
        int j = getClientWidth();
        int k = getScrollX();
        ItemInfo itemInfo = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(itemInfo.position, (k / j - itemInfo.offset) / itemInfo.widthFactor, i, (int)(this.mLastMotionX - this.mInitialMotionX)), true, true, i);
      } 
      endDrag();
      this.mFakeDragging = false;
      return;
    } 
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 0)
      switch (paramKeyEvent.getKeyCode()) {
        case 22:
          return arrowScroll(66);
        case 21:
          return arrowScroll(17);
      }  
    return false;
  }
  
  public void fakeDragBy(float paramFloat) {
    if (this.mFakeDragging) {
      if (this.mAdapter == null)
        return; 
      this.mLastMotionX += paramFloat;
      float f1 = getScrollX() - paramFloat;
      float f2 = getClientWidth();
      paramFloat = this.mFirstOffset * f2;
      float f3 = this.mLastOffset * f2;
      ItemInfo itemInfo1 = this.mItems.get(0);
      ItemInfo itemInfo2 = this.mItems.get(this.mItems.size() - 1);
      if (itemInfo1.position != 0)
        paramFloat = itemInfo1.offset * f2; 
      if (itemInfo2.position != this.mAdapter.getCount() - 1)
        f3 = itemInfo2.offset * f2; 
      if (f1 >= paramFloat) {
        paramFloat = f1;
        if (f1 > f3)
          paramFloat = f3; 
      } 
      f3 = this.mLastMotionX;
      int i = (int)paramFloat;
      this.mLastMotionX = f3 + paramFloat - i;
      scrollTo(i, getScrollY());
      pageScrolled(i);
      long l = SystemClock.uptimeMillis();
      MotionEvent motionEvent = MotionEvent.obtain(this.mFakeDragBeginTime, l, 2, this.mLastMotionX, 0.0F, 0);
      this.mVelocityTracker.addMovement(motionEvent);
      motionEvent.recycle();
      return;
    } 
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return generateDefaultLayoutParams();
  }
  
  public PagerAdapter getAdapter() {
    return this.mAdapter;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2) {
    int i = paramInt2;
    if (this.mDrawingOrder == 2)
      i = paramInt1 - 1 - paramInt2; 
    return ((LayoutParams)((View)this.mDrawingOrderedChildren.get(i)).getLayoutParams()).childIndex;
  }
  
  public int getCurrentItem() {
    return this.mCurItem;
  }
  
  public int getOffscreenPageLimit() {
    return this.mOffscreenPageLimit;
  }
  
  public int getPageMargin() {
    return this.mPageMargin;
  }
  
  ItemInfo infoForAnyChild(View paramView) {
    while (true) {
      ViewParent viewParent = paramView.getParent();
      if (viewParent != this) {
        if (viewParent != null) {
          if (!(viewParent instanceof View))
            return null; 
          paramView = (View)viewParent;
          continue;
        } 
        continue;
      } 
      return infoForChild(paramView);
    } 
  }
  
  ItemInfo infoForChild(View paramView) {
    for (byte b = 0; b < this.mItems.size(); b++) {
      ItemInfo itemInfo = this.mItems.get(b);
      if (this.mAdapter.isViewFromObject(paramView, itemInfo.object))
        return itemInfo; 
    } 
    return null;
  }
  
  ItemInfo infoForPosition(int paramInt) {
    for (byte b = 0; b < this.mItems.size(); b++) {
      ItemInfo itemInfo = this.mItems.get(b);
      if (itemInfo.position == paramInt)
        return itemInfo; 
    } 
    return null;
  }
  
  void initViewPager() {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context context = getContext();
    this.mScroller = new Scroller(context, sInterpolator);
    ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
    float f = (context.getResources().getDisplayMetrics()).density;
    this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
    this.mMinimumVelocity = (int)(400.0F * f);
    this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    this.mLeftEdge = new EdgeEffectCompat(context);
    this.mRightEdge = new EdgeEffectCompat(context);
    this.mFlingDistance = (int)(25.0F * f);
    this.mCloseEnough = (int)(2.0F * f);
    this.mDefaultGutterSize = (int)(f * 16.0F);
    if (ViewCompat.getImportantForAccessibility((View)this) == 0)
      ViewCompat.setImportantForAccessibility((View)this, 1); 
    ViewCompat.setOnApplyWindowInsetsListener((View)this, new OnApplyWindowInsetsListener() {
          private final Rect mTempRect = new Rect();
          
          public WindowInsetsCompat onApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat) {
            WindowInsetsCompat windowInsetsCompat = ViewCompat.onApplyWindowInsets(param1View, param1WindowInsetsCompat);
            if (windowInsetsCompat.isConsumed())
              return windowInsetsCompat; 
            Rect rect = this.mTempRect;
            rect.left = windowInsetsCompat.getSystemWindowInsetLeft();
            rect.top = windowInsetsCompat.getSystemWindowInsetTop();
            rect.right = windowInsetsCompat.getSystemWindowInsetRight();
            rect.bottom = windowInsetsCompat.getSystemWindowInsetBottom();
            byte b = 0;
            int i = ViewPager.this.getChildCount();
            while (b < i) {
              param1WindowInsetsCompat = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(b), windowInsetsCompat);
              rect.left = Math.min(param1WindowInsetsCompat.getSystemWindowInsetLeft(), rect.left);
              rect.top = Math.min(param1WindowInsetsCompat.getSystemWindowInsetTop(), rect.top);
              rect.right = Math.min(param1WindowInsetsCompat.getSystemWindowInsetRight(), rect.right);
              rect.bottom = Math.min(param1WindowInsetsCompat.getSystemWindowInsetBottom(), rect.bottom);
              b++;
            } 
            return windowInsetsCompat.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
          }
        });
  }
  
  public boolean isFakeDragging() {
    return this.mFakeDragging;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow() {
    removeCallbacks(this.mEndScrollRunnable);
    if (this.mScroller != null && !this.mScroller.isFinished())
      this.mScroller.abortAnimation(); 
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
      int i = getScrollX();
      int j = getWidth();
      float f1 = this.mPageMargin;
      float f2 = j;
      float f3 = f1 / f2;
      ArrayList<ItemInfo> arrayList = this.mItems;
      byte b = 0;
      ItemInfo itemInfo = arrayList.get(0);
      f1 = itemInfo.offset;
      int k = this.mItems.size();
      int m = itemInfo.position;
      int n = ((ItemInfo)this.mItems.get(k - 1)).position;
      while (m < n) {
        ItemInfo itemInfo1;
        float f;
        while (m > itemInfo.position && b < k) {
          ArrayList<ItemInfo> arrayList1 = this.mItems;
          itemInfo1 = arrayList1.get(++b);
        } 
        if (m == itemInfo1.position) {
          f = (itemInfo1.offset + itemInfo1.widthFactor) * f2;
          f1 = itemInfo1.offset + itemInfo1.widthFactor + f3;
        } else {
          float f4 = this.mAdapter.getPageWidth(m);
          f = f1 + f4 + f3;
          f4 = (f1 + f4) * f2;
          f1 = f;
          f = f4;
        } 
        if (this.mPageMargin + f > i) {
          this.mMarginDrawable.setBounds(Math.round(f), this.mTopPageBounds, Math.round(this.mPageMargin + f), this.mBottomPageBounds);
          this.mMarginDrawable.draw(paramCanvas);
        } 
        if (f > (i + j))
          break; 
        m++;
      } 
    } 
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 3 || i == 1) {
      resetTouch();
      return false;
    } 
    if (i != 0) {
      if (this.mIsBeingDragged)
        return true; 
      if (this.mIsUnableToDrag)
        return false; 
    } 
    if (i != 0) {
      if (i != 2) {
        if (i == 6)
          onSecondaryPointerUp(paramMotionEvent); 
      } else {
        i = this.mActivePointerId;
        if (i != -1) {
          i = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
          float f1 = MotionEventCompat.getX(paramMotionEvent, i);
          float f2 = f1 - this.mLastMotionX;
          float f3 = Math.abs(f2);
          float f4 = MotionEventCompat.getY(paramMotionEvent, i);
          float f5 = Math.abs(f4 - this.mInitialMotionY);
          if (f2 != 0.0F && !isGutterDrag(this.mLastMotionX, f2) && canScroll((View)this, false, (int)f2, (int)f1, (int)f4)) {
            this.mLastMotionX = f1;
            this.mLastMotionY = f4;
            this.mIsUnableToDrag = true;
            return false;
          } 
          if (f3 > this.mTouchSlop && f3 * 0.5F > f5) {
            this.mIsBeingDragged = true;
            requestParentDisallowInterceptTouchEvent(true);
            setScrollState(1);
            if (f2 > 0.0F) {
              f3 = this.mInitialMotionX + this.mTouchSlop;
            } else {
              f3 = this.mInitialMotionX - this.mTouchSlop;
            } 
            this.mLastMotionX = f3;
            this.mLastMotionY = f4;
            setScrollingCacheEnabled(true);
          } else if (f5 > this.mTouchSlop) {
            this.mIsUnableToDrag = true;
          } 
          if (this.mIsBeingDragged && performDrag(f1))
            ViewCompat.postInvalidateOnAnimation((View)this); 
        } 
      } 
    } else {
      float f = paramMotionEvent.getX();
      this.mInitialMotionX = f;
      this.mLastMotionX = f;
      f = paramMotionEvent.getY();
      this.mInitialMotionY = f;
      this.mLastMotionY = f;
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      this.mIsUnableToDrag = false;
      this.mIsScrollStarted = true;
      this.mScroller.computeScrollOffset();
      if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        this.mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        setScrollState(1);
      } else {
        completeScroll(false);
        this.mIsBeingDragged = false;
      } 
    } 
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain(); 
    this.mVelocityTracker.addMovement(paramMotionEvent);
    return this.mIsBeingDragged;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = getChildCount();
    int j = paramInt3 - paramInt1;
    int k = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int m = getPaddingRight();
    paramInt4 = getPaddingBottom();
    int n = getScrollX();
    int i1 = 0;
    byte b = 0;
    while (b < i) {
      View view = getChildAt(b);
      int i2 = paramInt2;
      int i3 = m;
      int i4 = paramInt1;
      int i5 = paramInt4;
      paramInt3 = i1;
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        i2 = paramInt2;
        i3 = m;
        i4 = paramInt1;
        i5 = paramInt4;
        paramInt3 = i1;
        if (layoutParams.isDecor) {
          paramInt3 = layoutParams.gravity & 0x7;
          i5 = layoutParams.gravity & 0x70;
          if (paramInt3 != 1) {
            if (paramInt3 != 3) {
              if (paramInt3 != 5) {
                paramInt3 = paramInt2;
                i2 = paramInt2;
              } else {
                paramInt3 = j - m - view.getMeasuredWidth();
                m += view.getMeasuredWidth();
                i2 = paramInt2;
              } 
            } else {
              i2 = view.getMeasuredWidth();
              paramInt3 = paramInt2;
              i2 += paramInt2;
            } 
          } else {
            paramInt3 = Math.max((j - view.getMeasuredWidth()) / 2, paramInt2);
            i2 = paramInt2;
          } 
          if (i5 != 16) {
            if (i5 != 48) {
              if (i5 != 80) {
                paramInt2 = paramInt1;
              } else {
                paramInt2 = k - paramInt4 - view.getMeasuredHeight();
                paramInt4 += view.getMeasuredHeight();
              } 
            } else {
              i5 = view.getMeasuredHeight();
              paramInt2 = paramInt1;
              paramInt1 = i5 + paramInt1;
            } 
          } else {
            paramInt2 = Math.max((k - view.getMeasuredHeight()) / 2, paramInt1);
          } 
          paramInt3 += n;
          view.layout(paramInt3, paramInt2, view.getMeasuredWidth() + paramInt3, paramInt2 + view.getMeasuredHeight());
          paramInt3 = i1 + 1;
          i5 = paramInt4;
          i4 = paramInt1;
          i3 = m;
        } 
      } 
      b++;
      paramInt2 = i2;
      m = i3;
      paramInt1 = i4;
      paramInt4 = i5;
      i1 = paramInt3;
    } 
    for (paramInt3 = 0; paramInt3 < i; paramInt3++) {
      View view = getChildAt(paramInt3);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (!layoutParams.isDecor) {
          ItemInfo itemInfo = infoForChild(view);
          if (itemInfo != null) {
            float f = (j - paramInt2 - m);
            int i2 = (int)(itemInfo.offset * f) + paramInt2;
            if (layoutParams.needsMeasure) {
              layoutParams.needsMeasure = false;
              view.measure(View.MeasureSpec.makeMeasureSpec((int)(f * layoutParams.widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec(k - paramInt1 - paramInt4, 1073741824));
            } 
            view.layout(i2, paramInt1, view.getMeasuredWidth() + i2, view.getMeasuredHeight() + paramInt1);
          } 
        } 
      } 
    } 
    this.mTopPageBounds = paramInt1;
    this.mBottomPageBounds = k - paramInt4;
    this.mDecorChildCount = i1;
    if (this.mFirstLayout)
      scrollToItem(this.mCurItem, false, 0, false); 
    this.mFirstLayout = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: iload_1
    //   3: invokestatic getDefaultSize : (II)I
    //   6: iconst_0
    //   7: iload_2
    //   8: invokestatic getDefaultSize : (II)I
    //   11: invokevirtual setMeasuredDimension : (II)V
    //   14: aload_0
    //   15: invokevirtual getMeasuredWidth : ()I
    //   18: istore_3
    //   19: aload_0
    //   20: iload_3
    //   21: bipush #10
    //   23: idiv
    //   24: aload_0
    //   25: getfield mDefaultGutterSize : I
    //   28: invokestatic min : (II)I
    //   31: putfield mGutterSize : I
    //   34: aload_0
    //   35: invokevirtual getPaddingLeft : ()I
    //   38: istore_1
    //   39: aload_0
    //   40: invokevirtual getPaddingRight : ()I
    //   43: istore #4
    //   45: aload_0
    //   46: invokevirtual getMeasuredHeight : ()I
    //   49: istore #5
    //   51: aload_0
    //   52: invokevirtual getPaddingTop : ()I
    //   55: istore_2
    //   56: aload_0
    //   57: invokevirtual getPaddingBottom : ()I
    //   60: istore #6
    //   62: aload_0
    //   63: invokevirtual getChildCount : ()I
    //   66: istore #7
    //   68: iload #5
    //   70: iload_2
    //   71: isub
    //   72: iload #6
    //   74: isub
    //   75: istore_2
    //   76: iload_3
    //   77: iload_1
    //   78: isub
    //   79: iload #4
    //   81: isub
    //   82: istore_1
    //   83: iconst_0
    //   84: istore #5
    //   86: iconst_1
    //   87: istore #8
    //   89: ldc_w 1073741824
    //   92: istore #9
    //   94: iload #5
    //   96: iload #7
    //   98: if_icmpge -> 427
    //   101: aload_0
    //   102: iload #5
    //   104: invokevirtual getChildAt : (I)Landroid/view/View;
    //   107: astore #10
    //   109: iload_1
    //   110: istore #4
    //   112: iload_2
    //   113: istore_3
    //   114: aload #10
    //   116: invokevirtual getVisibility : ()I
    //   119: bipush #8
    //   121: if_icmpeq -> 416
    //   124: aload #10
    //   126: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   129: checkcast org/jar/support/v4/view/ViewPager$LayoutParams
    //   132: astore #11
    //   134: iload_1
    //   135: istore #4
    //   137: iload_2
    //   138: istore_3
    //   139: aload #11
    //   141: ifnull -> 416
    //   144: iload_1
    //   145: istore #4
    //   147: iload_2
    //   148: istore_3
    //   149: aload #11
    //   151: getfield isDecor : Z
    //   154: ifeq -> 416
    //   157: aload #11
    //   159: getfield gravity : I
    //   162: bipush #7
    //   164: iand
    //   165: istore_3
    //   166: aload #11
    //   168: getfield gravity : I
    //   171: bipush #112
    //   173: iand
    //   174: istore #4
    //   176: iload #4
    //   178: bipush #48
    //   180: if_icmpeq -> 199
    //   183: iload #4
    //   185: bipush #80
    //   187: if_icmpne -> 193
    //   190: goto -> 199
    //   193: iconst_0
    //   194: istore #12
    //   196: goto -> 202
    //   199: iconst_1
    //   200: istore #12
    //   202: iload #8
    //   204: istore #6
    //   206: iload_3
    //   207: iconst_3
    //   208: if_icmpeq -> 226
    //   211: iload_3
    //   212: iconst_5
    //   213: if_icmpne -> 223
    //   216: iload #8
    //   218: istore #6
    //   220: goto -> 226
    //   223: iconst_0
    //   224: istore #6
    //   226: ldc_w -2147483648
    //   229: istore #8
    //   231: iload #12
    //   233: ifeq -> 248
    //   236: ldc_w 1073741824
    //   239: istore #4
    //   241: ldc_w -2147483648
    //   244: istore_3
    //   245: goto -> 265
    //   248: iload #8
    //   250: istore #4
    //   252: iload #6
    //   254: ifeq -> 241
    //   257: ldc_w 1073741824
    //   260: istore_3
    //   261: iload #8
    //   263: istore #4
    //   265: aload #11
    //   267: getfield width : I
    //   270: bipush #-2
    //   272: if_icmpeq -> 309
    //   275: aload #11
    //   277: getfield width : I
    //   280: iconst_m1
    //   281: if_icmpeq -> 294
    //   284: aload #11
    //   286: getfield width : I
    //   289: istore #4
    //   291: goto -> 297
    //   294: iload_1
    //   295: istore #4
    //   297: ldc_w 1073741824
    //   300: istore #8
    //   302: iload #4
    //   304: istore #13
    //   306: goto -> 316
    //   309: iload_1
    //   310: istore #13
    //   312: iload #4
    //   314: istore #8
    //   316: aload #11
    //   318: getfield height : I
    //   321: bipush #-2
    //   323: if_icmpeq -> 349
    //   326: aload #11
    //   328: getfield height : I
    //   331: iconst_m1
    //   332: if_icmpeq -> 344
    //   335: aload #11
    //   337: getfield height : I
    //   340: istore_3
    //   341: goto -> 358
    //   344: iload_2
    //   345: istore_3
    //   346: goto -> 358
    //   349: iload_2
    //   350: istore #4
    //   352: iload_3
    //   353: istore #9
    //   355: iload #4
    //   357: istore_3
    //   358: aload #10
    //   360: iload #13
    //   362: iload #8
    //   364: invokestatic makeMeasureSpec : (II)I
    //   367: iload_3
    //   368: iload #9
    //   370: invokestatic makeMeasureSpec : (II)I
    //   373: invokevirtual measure : (II)V
    //   376: iload #12
    //   378: ifeq -> 395
    //   381: iload_2
    //   382: aload #10
    //   384: invokevirtual getMeasuredHeight : ()I
    //   387: isub
    //   388: istore_3
    //   389: iload_1
    //   390: istore #4
    //   392: goto -> 416
    //   395: iload_1
    //   396: istore #4
    //   398: iload_2
    //   399: istore_3
    //   400: iload #6
    //   402: ifeq -> 416
    //   405: iload_1
    //   406: aload #10
    //   408: invokevirtual getMeasuredWidth : ()I
    //   411: isub
    //   412: istore #4
    //   414: iload_2
    //   415: istore_3
    //   416: iinc #5, 1
    //   419: iload #4
    //   421: istore_1
    //   422: iload_3
    //   423: istore_2
    //   424: goto -> 86
    //   427: aload_0
    //   428: iload_1
    //   429: ldc_w 1073741824
    //   432: invokestatic makeMeasureSpec : (II)I
    //   435: putfield mChildWidthMeasureSpec : I
    //   438: aload_0
    //   439: iload_2
    //   440: ldc_w 1073741824
    //   443: invokestatic makeMeasureSpec : (II)I
    //   446: putfield mChildHeightMeasureSpec : I
    //   449: aload_0
    //   450: iconst_1
    //   451: putfield mInLayout : Z
    //   454: aload_0
    //   455: invokevirtual populate : ()V
    //   458: iconst_0
    //   459: istore_2
    //   460: aload_0
    //   461: iconst_0
    //   462: putfield mInLayout : Z
    //   465: aload_0
    //   466: invokevirtual getChildCount : ()I
    //   469: istore_3
    //   470: iload_2
    //   471: iload_3
    //   472: if_icmpge -> 545
    //   475: aload_0
    //   476: iload_2
    //   477: invokevirtual getChildAt : (I)Landroid/view/View;
    //   480: astore #11
    //   482: aload #11
    //   484: invokevirtual getVisibility : ()I
    //   487: bipush #8
    //   489: if_icmpeq -> 539
    //   492: aload #11
    //   494: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   497: checkcast org/jar/support/v4/view/ViewPager$LayoutParams
    //   500: astore #10
    //   502: aload #10
    //   504: ifnull -> 515
    //   507: aload #10
    //   509: getfield isDecor : Z
    //   512: ifne -> 539
    //   515: aload #11
    //   517: iload_1
    //   518: i2f
    //   519: aload #10
    //   521: getfield widthFactor : F
    //   524: fmul
    //   525: f2i
    //   526: ldc_w 1073741824
    //   529: invokestatic makeMeasureSpec : (II)I
    //   532: aload_0
    //   533: getfield mChildHeightMeasureSpec : I
    //   536: invokevirtual measure : (II)V
    //   539: iinc #2, 1
    //   542: goto -> 470
    //   545: return
  }
  
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    int i = this.mDecorChildCount;
    boolean bool = false;
    if (i > 0) {
      int j = getScrollX();
      i = getPaddingLeft();
      int k = getPaddingRight();
      int m = getWidth();
      int n = getChildCount();
      for (byte b = 0; b < n; b++) {
        View view = getChildAt(b);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.isDecor) {
          int i1 = layoutParams.gravity & 0x7;
          if (i1 != 1) {
            if (i1 != 3) {
              if (i1 != 5) {
                int i2 = i;
                i1 = i;
                i = i2;
              } else {
                i1 = m - k - view.getMeasuredWidth();
                k += view.getMeasuredWidth();
              } 
            } else {
              int i2 = view.getWidth() + i;
              i1 = i;
              i = i2;
            } 
          } else {
            i1 = Math.max((m - view.getMeasuredWidth()) / 2, i);
          } 
          i1 = i1 + j - view.getLeft();
          if (i1 != 0)
            view.offsetLeftAndRight(i1); 
        } 
      } 
    } 
    dispatchOnPageScrolled(paramInt1, paramFloat, paramInt2);
    if (this.mPageTransformer != null) {
      i = getScrollX();
      paramInt2 = getChildCount();
      for (paramInt1 = bool; paramInt1 < paramInt2; paramInt1++) {
        View view = getChildAt(paramInt1);
        if (!((LayoutParams)view.getLayoutParams()).isDecor) {
          paramFloat = (view.getLeft() - i) / getClientWidth();
          this.mPageTransformer.transformPage(view, paramFloat);
        } 
      } 
    } 
    this.mCalledSuper = true;
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect) {
    byte b;
    int i = getChildCount();
    int j = -1;
    if ((paramInt & 0x2) != 0) {
      j = i;
      i = 0;
      b = 1;
    } else {
      i--;
      b = -1;
    } 
    while (i != j) {
      View view = getChildAt(i);
      if (view.getVisibility() == 0) {
        ItemInfo itemInfo = infoForChild(view);
        if (itemInfo != null && itemInfo.position == this.mCurItem && view.requestFocus(paramInt, paramRect))
          return true; 
      } 
      i += b;
    } 
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    if (this.mAdapter != null) {
      this.mAdapter.restoreState(savedState.adapterState, savedState.loader);
      setCurrentItemInternal(savedState.position, false, true);
    } else {
      this.mRestoredCurItem = savedState.position;
      this.mRestoredAdapterState = savedState.adapterState;
      this.mRestoredClassLoader = savedState.loader;
    } 
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.position = this.mCurItem;
    if (this.mAdapter != null)
      savedState.adapterState = this.mAdapter.saveState(); 
    return (Parcelable)savedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
      recomputeScrollPosition(paramInt1, paramInt3, this.mPageMargin, this.mPageMargin); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    float f;
    if (this.mFakeDragging)
      return true; 
    int i = paramMotionEvent.getAction();
    boolean bool = false;
    if (i == 0 && paramMotionEvent.getEdgeFlags() != 0)
      return false; 
    if (this.mAdapter == null || this.mAdapter.getCount() == 0)
      return false; 
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain(); 
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF) {
      case 6:
        onSecondaryPointerUp(paramMotionEvent);
        this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId));
        break;
      case 5:
        i = MotionEventCompat.getActionIndex(paramMotionEvent);
        this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, i);
        this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
        break;
      case 3:
        if (this.mIsBeingDragged) {
          scrollToItem(this.mCurItem, true, 0, false);
          bool = resetTouch();
        } 
        break;
      case 2:
        if (!this.mIsBeingDragged) {
          i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
          if (i == -1) {
            bool = resetTouch();
            break;
          } 
          float f1 = MotionEventCompat.getX(paramMotionEvent, i);
          float f2 = Math.abs(f1 - this.mLastMotionX);
          float f3 = MotionEventCompat.getY(paramMotionEvent, i);
          float f4 = Math.abs(f3 - this.mLastMotionY);
          if (f2 > this.mTouchSlop && f2 > f4) {
            this.mIsBeingDragged = true;
            requestParentDisallowInterceptTouchEvent(true);
            if (f1 - this.mInitialMotionX > 0.0F) {
              f2 = this.mInitialMotionX + this.mTouchSlop;
            } else {
              f2 = this.mInitialMotionX - this.mTouchSlop;
            } 
            this.mLastMotionX = f2;
            this.mLastMotionY = f3;
            setScrollState(1);
            setScrollingCacheEnabled(true);
            ViewParent viewParent = getParent();
            if (viewParent != null)
              viewParent.requestDisallowInterceptTouchEvent(true); 
          } 
        } 
        if (this.mIsBeingDragged)
          int j = false | performDrag(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId))); 
        break;
      case 1:
        if (this.mIsBeingDragged) {
          VelocityTracker velocityTracker = this.mVelocityTracker;
          velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
          i = (int)VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
          this.mPopulatePending = true;
          int j = getClientWidth();
          int k = getScrollX();
          ItemInfo itemInfo = infoForCurrentScrollPosition();
          float f2 = this.mPageMargin;
          float f1 = j;
          f2 /= f1;
          setCurrentItemInternal(determineTargetPage(itemInfo.position, (k / f1 - itemInfo.offset) / (itemInfo.widthFactor + f2), i, (int)(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId)) - this.mInitialMotionX)), true, true, i);
          bool = resetTouch();
        } 
        break;
      case 0:
        this.mScroller.abortAnimation();
        this.mPopulatePending = false;
        populate();
        f = paramMotionEvent.getX();
        this.mInitialMotionX = f;
        this.mLastMotionX = f;
        f = paramMotionEvent.getY();
        this.mInitialMotionY = f;
        this.mLastMotionY = f;
        this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        break;
    } 
    if (bool)
      ViewCompat.postInvalidateOnAnimation((View)this); 
    return true;
  }
  
  boolean pageLeft() {
    if (this.mCurItem > 0) {
      setCurrentItem(this.mCurItem - 1, true);
      return true;
    } 
    return false;
  }
  
  boolean pageRight() {
    if (this.mAdapter != null && this.mCurItem < this.mAdapter.getCount() - 1) {
      setCurrentItem(this.mCurItem + 1, true);
      return true;
    } 
    return false;
  }
  
  void populate() {
    populate(this.mCurItem);
  }
  
  void populate(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mCurItem : I
    //   4: iload_1
    //   5: if_icmpeq -> 25
    //   8: aload_0
    //   9: aload_0
    //   10: getfield mCurItem : I
    //   13: invokevirtual infoForPosition : (I)Lorg/jar/support/v4/view/ViewPager$ItemInfo;
    //   16: astore_2
    //   17: aload_0
    //   18: iload_1
    //   19: putfield mCurItem : I
    //   22: goto -> 27
    //   25: aconst_null
    //   26: astore_2
    //   27: aload_0
    //   28: getfield mAdapter : Lorg/jar/support/v4/view/PagerAdapter;
    //   31: ifnonnull -> 39
    //   34: aload_0
    //   35: invokespecial sortChildDrawingOrder : ()V
    //   38: return
    //   39: aload_0
    //   40: getfield mPopulatePending : Z
    //   43: ifeq -> 51
    //   46: aload_0
    //   47: invokespecial sortChildDrawingOrder : ()V
    //   50: return
    //   51: aload_0
    //   52: invokevirtual getWindowToken : ()Landroid/os/IBinder;
    //   55: ifnonnull -> 59
    //   58: return
    //   59: aload_0
    //   60: getfield mAdapter : Lorg/jar/support/v4/view/PagerAdapter;
    //   63: aload_0
    //   64: invokevirtual startUpdate : (Landroid/view/ViewGroup;)V
    //   67: aload_0
    //   68: getfield mOffscreenPageLimit : I
    //   71: istore_1
    //   72: iconst_0
    //   73: aload_0
    //   74: getfield mCurItem : I
    //   77: iload_1
    //   78: isub
    //   79: invokestatic max : (II)I
    //   82: istore_3
    //   83: aload_0
    //   84: getfield mAdapter : Lorg/jar/support/v4/view/PagerAdapter;
    //   87: invokevirtual getCount : ()I
    //   90: istore #4
    //   92: iload #4
    //   94: iconst_1
    //   95: isub
    //   96: aload_0
    //   97: getfield mCurItem : I
    //   100: iload_1
    //   101: iadd
    //   102: invokestatic min : (II)I
    //   105: istore #5
    //   107: iload #4
    //   109: aload_0
    //   110: getfield mExpectedAdapterCount : I
    //   113: if_icmpne -> 1239
    //   116: iconst_0
    //   117: istore_1
    //   118: iload_1
    //   119: aload_0
    //   120: getfield mItems : Ljava/util/ArrayList;
    //   123: invokevirtual size : ()I
    //   126: if_icmpge -> 175
    //   129: aload_0
    //   130: getfield mItems : Ljava/util/ArrayList;
    //   133: iload_1
    //   134: invokevirtual get : (I)Ljava/lang/Object;
    //   137: checkcast org/jar/support/v4/view/ViewPager$ItemInfo
    //   140: astore #6
    //   142: aload #6
    //   144: getfield position : I
    //   147: aload_0
    //   148: getfield mCurItem : I
    //   151: if_icmplt -> 169
    //   154: aload #6
    //   156: getfield position : I
    //   159: aload_0
    //   160: getfield mCurItem : I
    //   163: if_icmpne -> 175
    //   166: goto -> 178
    //   169: iinc #1, 1
    //   172: goto -> 118
    //   175: aconst_null
    //   176: astore #6
    //   178: aload #6
    //   180: astore #7
    //   182: aload #6
    //   184: ifnonnull -> 207
    //   187: aload #6
    //   189: astore #7
    //   191: iload #4
    //   193: ifle -> 207
    //   196: aload_0
    //   197: aload_0
    //   198: getfield mCurItem : I
    //   201: iload_1
    //   202: invokevirtual addNewItem : (II)Lorg/jar/support/v4/view/ViewPager$ItemInfo;
    //   205: astore #7
    //   207: aload #7
    //   209: ifnull -> 997
    //   212: iload_1
    //   213: iconst_1
    //   214: isub
    //   215: istore #8
    //   217: iload #8
    //   219: iflt -> 239
    //   222: aload_0
    //   223: getfield mItems : Ljava/util/ArrayList;
    //   226: iload #8
    //   228: invokevirtual get : (I)Ljava/lang/Object;
    //   231: checkcast org/jar/support/v4/view/ViewPager$ItemInfo
    //   234: astore #6
    //   236: goto -> 242
    //   239: aconst_null
    //   240: astore #6
    //   242: aload_0
    //   243: invokespecial getClientWidth : ()I
    //   246: istore #9
    //   248: iload #9
    //   250: ifgt -> 259
    //   253: fconst_0
    //   254: fstore #10
    //   256: goto -> 278
    //   259: fconst_2
    //   260: aload #7
    //   262: getfield widthFactor : F
    //   265: fsub
    //   266: aload_0
    //   267: invokevirtual getPaddingLeft : ()I
    //   270: i2f
    //   271: iload #9
    //   273: i2f
    //   274: fdiv
    //   275: fadd
    //   276: fstore #10
    //   278: aload_0
    //   279: getfield mCurItem : I
    //   282: iconst_1
    //   283: isub
    //   284: istore #11
    //   286: fconst_0
    //   287: fstore #12
    //   289: iload_1
    //   290: istore #13
    //   292: aload #6
    //   294: astore #14
    //   296: iload #11
    //   298: iflt -> 603
    //   301: fload #12
    //   303: fload #10
    //   305: fcmpl
    //   306: iflt -> 442
    //   309: iload #11
    //   311: iload_3
    //   312: if_icmpge -> 442
    //   315: aload #14
    //   317: ifnonnull -> 323
    //   320: goto -> 603
    //   323: fload #12
    //   325: fstore #15
    //   327: iload #8
    //   329: istore_1
    //   330: aload #14
    //   332: astore #6
    //   334: iload #13
    //   336: istore #16
    //   338: iload #11
    //   340: aload #14
    //   342: getfield position : I
    //   345: if_icmpne -> 582
    //   348: fload #12
    //   350: fstore #15
    //   352: iload #8
    //   354: istore_1
    //   355: aload #14
    //   357: astore #6
    //   359: iload #13
    //   361: istore #16
    //   363: aload #14
    //   365: getfield scrolling : Z
    //   368: ifne -> 582
    //   371: aload_0
    //   372: getfield mItems : Ljava/util/ArrayList;
    //   375: iload #8
    //   377: invokevirtual remove : (I)Ljava/lang/Object;
    //   380: pop
    //   381: aload_0
    //   382: getfield mAdapter : Lorg/jar/support/v4/view/PagerAdapter;
    //   385: aload_0
    //   386: iload #11
    //   388: aload #14
    //   390: getfield object : Ljava/lang/Object;
    //   393: invokevirtual destroyItem : (Landroid/view/ViewGroup;ILjava/lang/Object;)V
    //   396: iinc #8, -1
    //   399: iinc #13, -1
    //   402: fload #12
    //   404: fstore #15
    //   406: iload #8
    //   408: istore_1
    //   409: iload #13
    //   411: istore #16
    //   413: iload #8
    //   415: iflt -> 571
    //   418: aload_0
    //   419: getfield mItems : Ljava/util/ArrayList;
    //   422: iload #8
    //   424: invokevirtual get : (I)Ljava/lang/Object;
    //   427: checkcast org/jar/support/v4/view/ViewPager$ItemInfo
    //   430: astore #6
    //   432: fload #12
    //   434: fstore #15
    //   436: iload #8
    //   438: istore_1
    //   439: goto -> 578
    //   442: aload #14
    //   444: ifnull -> 510
    //   447: iload #11
    //   449: aload #14
    //   451: getfield position : I
    //   454: if_icmpne -> 510
    //   457: fload #12
    //   459: aload #14
    //   461: getfield widthFactor : F
    //   464: fadd
    //   465: fstore #12
    //   467: iinc #8, -1
    //   470: fload #12
    //   472: fstore #15
    //   474: iload #8
    //   476: istore_1
    //   477: iload #13
    //   479: istore #16
    //   481: iload #8
    //   483: iflt -> 571
    //   486: aload_0
    //   487: getfield mItems : Ljava/util/ArrayList;
    //   490: iload #8
    //   492: invokevirtual get : (I)Ljava/lang/Object;
    //   495: checkcast org/jar/support/v4/view/ViewPager$ItemInfo
    //   498: astore #6
    //   500: fload #12
    //   502: fstore #15
    //   504: iload #8
    //   506: istore_1
    //   507: goto -> 578
    //   510: fload #12
    //   512: aload_0
    //   513: iload #11
    //   515: iload #8
    //   517: iconst_1
    //   518: iadd
    //   519: invokevirtual addNewItem : (II)Lorg/jar/support/v4/view/ViewPager$ItemInfo;
    //   522: getfield widthFactor : F
    //   525: fadd
    //   526: fstore #12
    //   528: iinc #13, 1
    //   531: fload #12
    //   533: fstore #15
    //   535: iload #8
    //   537: istore_1
    //   538: iload #13
    //   540: istore #16
    //   542: iload #8
    //   544: iflt -> 571
    //   547: aload_0
    //   548: getfield mItems : Ljava/util/ArrayList;
    //   551: iload #8
    //   553: invokevirtual get : (I)Ljava/lang/Object;
    //   556: checkcast org/jar/support/v4/view/ViewPager$ItemInfo
    //   559: astore #6
    //   561: fload #12
    //   563: fstore #15
    //   565: iload #8
    //   567: istore_1
    //   568: goto -> 578
    //   571: aconst_null
    //   572: astore #6
    //   574: iload #16
    //   576: istore #13
    //   578: iload #13
    //   580: istore #16
    //   582: iinc #11, -1
    //   585: fload #15
    //   587: fstore #12
    //   589: iload_1
    //   590: istore #8
    //   592: aload #6
    //   594: astore #14
    //   596: iload #16
    //   598: istore #13
    //   600: goto -> 296
    //   603: aload #7
    //   605: getfield widthFactor : F
    //   608: fstore #12
    //   610: iload #13
    //   612: iconst_1
    //   613: iadd
    //   614: istore #16
    //   616: fload #12
    //   618: fconst_2
    //   619: fcmpg
    //   620: ifge -> 988
    //   623: iload #16
    //   625: aload_0
    //   626: getfield mItems : Ljava/util/ArrayList;
    //   629: invokevirtual size : ()I
    //   632: if_icmpge -> 652
    //   635: aload_0
    //   636: getfield mItems : Ljava/util/ArrayList;
    //   639: iload #16
    //   641: invokevirtual get : (I)Ljava/lang/Object;
    //   644: checkcast org/jar/support/v4/view/ViewPager$ItemInfo
    //   647: astore #6
    //   649: goto -> 655
    //   652: aconst_null
    //   653: astore #6
    //   655: iload #9
    //   657: ifgt -> 666
    //   660: fconst_0
    //   661: fstore #10
    //   663: goto -> 679
    //   666: aload_0
    //   667: invokevirtual getPaddingRight : ()I
    //   670: i2f
    //   671: iload #9
    //   673: i2f
    //   674: fdiv
    //   675: fconst_2
    //   676: fadd
    //   677: fstore #10
    //   679: aload_0
    //   680: getfield mCurItem : I
    //   683: istore_1
    //   684: aload #6
    //   686: astore #14
    //   688: iload_1
    //   689: iconst_1
    //   690: iadd
    //   691: istore #8
    //   693: iload #8
    //   695: iload #4
    //   697: if_icmpge -> 988
    //   700: fload #12
    //   702: fload #10
    //   704: fcmpl
    //   705: iflt -> 837
    //   708: iload #8
    //   710: iload #5
    //   712: if_icmple -> 837
    //   715: aload #14
    //   717: ifnonnull -> 723
    //   720: goto -> 988
    //   723: fload #12
    //   725: fstore #15
    //   727: iload #16
    //   729: istore_1
    //   730: aload #14
    //   732: astore #6
    //   734: iload #8
    //   736: aload #14
    //   738: getfield position : I
    //   741: if_icmpne -> 971
    //   744: fload #12
    //   746: fstore #15
    //   748: iload #16
    //   750: istore_1
    //   751: aload #14
    //   753: astore #6
    //   755: aload #14
    //   757: getfield scrolling : Z
    //   760: ifne -> 971
    //   763: aload_0
    //   764: getfield mItems : Ljava/util/ArrayList;
    //   767: iload #16
    //   769: invokevirtual remove : (I)Ljava/lang/Object;
    //   772: pop
    //   773: aload_0
    //   774: getfield mAdapter : Lorg/jar/support/v4/view/PagerAdapter;
    //   777: aload_0
    //   778: iload #8
    //   780: aload #14
    //   782: getfield object : Ljava/lang/Object;
    //   785: invokevirtual destroyItem : (Landroid/view/ViewGroup;ILjava/lang/Object;)V
    //   788: fload #12
    //   790: fstore #15
    //   792: iload #16
    //   794: istore_1
    //   795: iload #16
    //   797: aload_0
    //   798: getfield mItems : Ljava/util/ArrayList;
    //   801: invokevirtual size : ()I
    //   804: if_icmpge -> 831
    //   807: aload_0
    //   808: getfield mItems : Ljava/util/ArrayList;
    //   811: iload #16
    //   813: invokevirtual get : (I)Ljava/lang/Object;
    //   816: checkcast org/jar/support/v4/view/ViewPager$ItemInfo
    //   819: astore #6
    //   821: fload #12
    //   823: fstore #15
    //   825: iload #16
    //   827: istore_1
    //   828: goto -> 971
    //   831: aconst_null
    //   832: astore #6
    //   834: goto -> 971
    //   837: aload #14
    //   839: ifnull -> 908
    //   842: iload #8
    //   844: aload #14
    //   846: getfield position : I
    //   849: if_icmpne -> 908
    //   852: fload #12
    //   854: aload #14
    //   856: getfield widthFactor : F
    //   859: fadd
    //   860: fstore #12
    //   862: iinc #16, 1
    //   865: fload #12
    //   867: fstore #15
    //   869: iload #16
    //   871: istore_1
    //   872: iload #16
    //   874: aload_0
    //   875: getfield mItems : Ljava/util/ArrayList;
    //   878: invokevirtual size : ()I
    //   881: if_icmpge -> 831
    //   884: aload_0
    //   885: getfield mItems : Ljava/util/ArrayList;
    //   888: iload #16
    //   890: invokevirtual get : (I)Ljava/lang/Object;
    //   893: checkcast org/jar/support/v4/view/ViewPager$ItemInfo
    //   896: astore #6
    //   898: fload #12
    //   900: fstore #15
    //   902: iload #16
    //   904: istore_1
    //   905: goto -> 971
    //   908: aload_0
    //   909: iload #8
    //   911: iload #16
    //   913: invokevirtual addNewItem : (II)Lorg/jar/support/v4/view/ViewPager$ItemInfo;
    //   916: astore #6
    //   918: iinc #16, 1
    //   921: fload #12
    //   923: aload #6
    //   925: getfield widthFactor : F
    //   928: fadd
    //   929: fstore #12
    //   931: fload #12
    //   933: fstore #15
    //   935: iload #16
    //   937: istore_1
    //   938: iload #16
    //   940: aload_0
    //   941: getfield mItems : Ljava/util/ArrayList;
    //   944: invokevirtual size : ()I
    //   947: if_icmpge -> 831
    //   950: aload_0
    //   951: getfield mItems : Ljava/util/ArrayList;
    //   954: iload #16
    //   956: invokevirtual get : (I)Ljava/lang/Object;
    //   959: checkcast org/jar/support/v4/view/ViewPager$ItemInfo
    //   962: astore #6
    //   964: iload #16
    //   966: istore_1
    //   967: fload #12
    //   969: fstore #15
    //   971: fload #15
    //   973: fstore #12
    //   975: iload_1
    //   976: istore #16
    //   978: aload #6
    //   980: astore #14
    //   982: iload #8
    //   984: istore_1
    //   985: goto -> 688
    //   988: aload_0
    //   989: aload #7
    //   991: iload #13
    //   993: aload_2
    //   994: invokespecial calculatePageOffsets : (Lorg/jar/support/v4/view/ViewPager$ItemInfo;ILorg/jar/support/v4/view/ViewPager$ItemInfo;)V
    //   997: aload_0
    //   998: getfield mAdapter : Lorg/jar/support/v4/view/PagerAdapter;
    //   1001: astore_2
    //   1002: aload_0
    //   1003: getfield mCurItem : I
    //   1006: istore_1
    //   1007: aload #7
    //   1009: ifnull -> 1022
    //   1012: aload #7
    //   1014: getfield object : Ljava/lang/Object;
    //   1017: astore #6
    //   1019: goto -> 1025
    //   1022: aconst_null
    //   1023: astore #6
    //   1025: aload_2
    //   1026: aload_0
    //   1027: iload_1
    //   1028: aload #6
    //   1030: invokevirtual setPrimaryItem : (Landroid/view/ViewGroup;ILjava/lang/Object;)V
    //   1033: aload_0
    //   1034: getfield mAdapter : Lorg/jar/support/v4/view/PagerAdapter;
    //   1037: aload_0
    //   1038: invokevirtual finishUpdate : (Landroid/view/ViewGroup;)V
    //   1041: aload_0
    //   1042: invokevirtual getChildCount : ()I
    //   1045: istore #13
    //   1047: iconst_0
    //   1048: istore_1
    //   1049: iload_1
    //   1050: iload #13
    //   1052: if_icmpge -> 1128
    //   1055: aload_0
    //   1056: iload_1
    //   1057: invokevirtual getChildAt : (I)Landroid/view/View;
    //   1060: astore_2
    //   1061: aload_2
    //   1062: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1065: checkcast org/jar/support/v4/view/ViewPager$LayoutParams
    //   1068: astore #6
    //   1070: aload #6
    //   1072: iload_1
    //   1073: putfield childIndex : I
    //   1076: aload #6
    //   1078: getfield isDecor : Z
    //   1081: ifne -> 1122
    //   1084: aload #6
    //   1086: getfield widthFactor : F
    //   1089: fconst_0
    //   1090: fcmpl
    //   1091: ifne -> 1122
    //   1094: aload_0
    //   1095: aload_2
    //   1096: invokevirtual infoForChild : (Landroid/view/View;)Lorg/jar/support/v4/view/ViewPager$ItemInfo;
    //   1099: astore_2
    //   1100: aload_2
    //   1101: ifnull -> 1122
    //   1104: aload #6
    //   1106: aload_2
    //   1107: getfield widthFactor : F
    //   1110: putfield widthFactor : F
    //   1113: aload #6
    //   1115: aload_2
    //   1116: getfield position : I
    //   1119: putfield position : I
    //   1122: iinc #1, 1
    //   1125: goto -> 1049
    //   1128: aload_0
    //   1129: invokespecial sortChildDrawingOrder : ()V
    //   1132: aload_0
    //   1133: invokevirtual hasFocus : ()Z
    //   1136: ifeq -> 1238
    //   1139: aload_0
    //   1140: invokevirtual findFocus : ()Landroid/view/View;
    //   1143: astore #6
    //   1145: aload #6
    //   1147: ifnull -> 1161
    //   1150: aload_0
    //   1151: aload #6
    //   1153: invokevirtual infoForAnyChild : (Landroid/view/View;)Lorg/jar/support/v4/view/ViewPager$ItemInfo;
    //   1156: astore #6
    //   1158: goto -> 1164
    //   1161: aconst_null
    //   1162: astore #6
    //   1164: aload #6
    //   1166: ifnull -> 1181
    //   1169: aload #6
    //   1171: getfield position : I
    //   1174: aload_0
    //   1175: getfield mCurItem : I
    //   1178: if_icmpeq -> 1238
    //   1181: iconst_0
    //   1182: istore_1
    //   1183: iload_1
    //   1184: aload_0
    //   1185: invokevirtual getChildCount : ()I
    //   1188: if_icmpge -> 1238
    //   1191: aload_0
    //   1192: iload_1
    //   1193: invokevirtual getChildAt : (I)Landroid/view/View;
    //   1196: astore #6
    //   1198: aload_0
    //   1199: aload #6
    //   1201: invokevirtual infoForChild : (Landroid/view/View;)Lorg/jar/support/v4/view/ViewPager$ItemInfo;
    //   1204: astore_2
    //   1205: aload_2
    //   1206: ifnull -> 1232
    //   1209: aload_2
    //   1210: getfield position : I
    //   1213: aload_0
    //   1214: getfield mCurItem : I
    //   1217: if_icmpne -> 1232
    //   1220: aload #6
    //   1222: iconst_2
    //   1223: invokevirtual requestFocus : (I)Z
    //   1226: ifeq -> 1232
    //   1229: goto -> 1238
    //   1232: iinc #1, 1
    //   1235: goto -> 1183
    //   1238: return
    //   1239: aload_0
    //   1240: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1243: aload_0
    //   1244: invokevirtual getId : ()I
    //   1247: invokevirtual getResourceName : (I)Ljava/lang/String;
    //   1250: astore #6
    //   1252: goto -> 1266
    //   1255: astore #6
    //   1257: aload_0
    //   1258: invokevirtual getId : ()I
    //   1261: invokestatic toHexString : (I)Ljava/lang/String;
    //   1264: astore #6
    //   1266: new java/lang/StringBuilder
    //   1269: dup
    //   1270: invokespecial <init> : ()V
    //   1273: astore_2
    //   1274: aload_2
    //   1275: ldc_w 'The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: '
    //   1278: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: pop
    //   1282: aload_2
    //   1283: aload_0
    //   1284: getfield mExpectedAdapterCount : I
    //   1287: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: aload_2
    //   1292: ldc_w ', found: '
    //   1295: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: pop
    //   1299: aload_2
    //   1300: iload #4
    //   1302: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1305: pop
    //   1306: aload_2
    //   1307: ldc_w ' Pager id: '
    //   1310: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: pop
    //   1314: aload_2
    //   1315: aload #6
    //   1317: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: pop
    //   1321: aload_2
    //   1322: ldc_w ' Pager class: '
    //   1325: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: pop
    //   1329: aload_2
    //   1330: aload_0
    //   1331: invokevirtual getClass : ()Ljava/lang/Class;
    //   1334: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1337: pop
    //   1338: aload_2
    //   1339: ldc_w ' Problematic adapter: '
    //   1342: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1345: pop
    //   1346: aload_2
    //   1347: aload_0
    //   1348: getfield mAdapter : Lorg/jar/support/v4/view/PagerAdapter;
    //   1351: invokevirtual getClass : ()Ljava/lang/Class;
    //   1354: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1357: pop
    //   1358: new java/lang/IllegalStateException
    //   1361: dup
    //   1362: aload_2
    //   1363: invokevirtual toString : ()Ljava/lang/String;
    //   1366: invokespecial <init> : (Ljava/lang/String;)V
    //   1369: athrow
    // Exception table:
    //   from	to	target	type
    //   1239	1252	1255	android/content/res/Resources$NotFoundException
  }
  
  public void removeOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener) {
    if (this.mOnPageChangeListeners != null)
      this.mOnPageChangeListeners.remove(paramOnPageChangeListener); 
  }
  
  public void removeView(View paramView) {
    if (this.mInLayout) {
      removeViewInLayout(paramView);
    } else {
      super.removeView(paramView);
    } 
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter) {
    if (this.mAdapter != null) {
      this.mAdapter.setViewPagerObserver(null);
      this.mAdapter.startUpdate(this);
      for (byte b = 0; b < this.mItems.size(); b++) {
        ItemInfo itemInfo = this.mItems.get(b);
        this.mAdapter.destroyItem(this, itemInfo.position, itemInfo.object);
      } 
      this.mAdapter.finishUpdate(this);
      this.mItems.clear();
      removeNonDecorViews();
      this.mCurItem = 0;
      scrollTo(0, 0);
    } 
    PagerAdapter pagerAdapter = this.mAdapter;
    this.mAdapter = paramPagerAdapter;
    this.mExpectedAdapterCount = 0;
    if (this.mAdapter != null) {
      if (this.mObserver == null)
        this.mObserver = new PagerObserver(); 
      this.mAdapter.setViewPagerObserver(this.mObserver);
      this.mPopulatePending = false;
      boolean bool = this.mFirstLayout;
      this.mFirstLayout = true;
      this.mExpectedAdapterCount = this.mAdapter.getCount();
      if (this.mRestoredCurItem >= 0) {
        this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
        setCurrentItemInternal(this.mRestoredCurItem, false, true);
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
      } else if (!bool) {
        populate();
      } else {
        requestLayout();
      } 
    } 
    if (this.mAdapterChangeListener != null && pagerAdapter != paramPagerAdapter)
      this.mAdapterChangeListener.onAdapterChanged(pagerAdapter, paramPagerAdapter); 
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 7) {
      if (this.mSetChildrenDrawingOrderEnabled == null)
        try {
          this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { boolean.class });
        } catch (NoSuchMethodException noSuchMethodException) {
          Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", noSuchMethodException);
        }  
      try {
        this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
      } catch (Exception exception) {
        Log.e("ViewPager", "Error changing children drawing order", exception);
      } 
    } 
  }
  
  public void setCurrentItem(int paramInt) {
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, this.mFirstLayout ^ true, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean) {
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, paramBoolean, false);
  }
  
  void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2) {
    int i;
    if (this.mAdapter == null || this.mAdapter.getCount() <= 0) {
      setScrollingCacheEnabled(false);
      return;
    } 
    if (!paramBoolean2 && this.mCurItem == paramInt1 && this.mItems.size() != 0) {
      setScrollingCacheEnabled(false);
      return;
    } 
    paramBoolean2 = true;
    if (paramInt1 < 0) {
      i = 0;
    } else {
      i = paramInt1;
      if (paramInt1 >= this.mAdapter.getCount())
        i = this.mAdapter.getCount() - 1; 
    } 
    paramInt1 = this.mOffscreenPageLimit;
    if (i > this.mCurItem + paramInt1 || i < this.mCurItem - paramInt1)
      for (paramInt1 = 0; paramInt1 < this.mItems.size(); paramInt1++)
        ((ItemInfo)this.mItems.get(paramInt1)).scrolling = true;  
    if (this.mCurItem == i)
      paramBoolean2 = false; 
    if (this.mFirstLayout) {
      this.mCurItem = i;
      if (paramBoolean2)
        dispatchOnPageSelected(i); 
      requestLayout();
    } else {
      populate(i);
      scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
    } 
  }
  
  OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener paramOnPageChangeListener) {
    OnPageChangeListener onPageChangeListener = this.mInternalPageChangeListener;
    this.mInternalPageChangeListener = paramOnPageChangeListener;
    return onPageChangeListener;
  }
  
  public void setOffscreenPageLimit(int paramInt) {
    int i = paramInt;
    if (paramInt < 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Requested offscreen page limit ");
      stringBuilder.append(paramInt);
      stringBuilder.append(" too small; defaulting to ");
      stringBuilder.append(1);
      Log.w("ViewPager", stringBuilder.toString());
      i = 1;
    } 
    if (i != this.mOffscreenPageLimit) {
      this.mOffscreenPageLimit = i;
      populate();
    } 
  }
  
  void setOnAdapterChangeListener(OnAdapterChangeListener paramOnAdapterChangeListener) {
    this.mAdapterChangeListener = paramOnAdapterChangeListener;
  }
  
  @Deprecated
  public void setOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener) {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt) {
    int i = this.mPageMargin;
    this.mPageMargin = paramInt;
    int j = getWidth();
    recomputeScrollPosition(j, j, paramInt, i);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt) {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable) {
    boolean bool;
    this.mMarginDrawable = paramDrawable;
    if (paramDrawable != null)
      refreshDrawableState(); 
    if (paramDrawable == null) {
      bool = true;
    } else {
      bool = false;
    } 
    setWillNotDraw(bool);
    invalidate();
  }
  
  public void setPageTransformer(boolean paramBoolean, PageTransformer paramPageTransformer) {
    if (Build.VERSION.SDK_INT >= 11) {
      boolean bool1;
      boolean bool2;
      boolean bool3;
      byte b = 1;
      if (paramPageTransformer != null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (this.mPageTransformer != null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if (bool1 != bool2) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      this.mPageTransformer = paramPageTransformer;
      setChildrenDrawingOrderEnabledCompat(bool1);
      if (bool1) {
        if (paramBoolean)
          b = 2; 
        this.mDrawingOrder = b;
      } else {
        this.mDrawingOrder = 0;
      } 
      if (bool3)
        populate(); 
    } 
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2) {
    smoothScrollTo(paramInt1, paramInt2, 0);
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3) {
    int i;
    if (getChildCount() == 0) {
      setScrollingCacheEnabled(false);
      return;
    } 
    if (this.mScroller != null && !this.mScroller.isFinished()) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      if (this.mIsScrollStarted) {
        i = this.mScroller.getCurrX();
      } else {
        i = this.mScroller.getStartX();
      } 
      this.mScroller.abortAnimation();
      setScrollingCacheEnabled(false);
    } else {
      i = getScrollX();
    } 
    int j = getScrollY();
    int k = paramInt1 - i;
    paramInt2 -= j;
    if (k == 0 && paramInt2 == 0) {
      completeScroll(false);
      populate();
      setScrollState(0);
      return;
    } 
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int m = paramInt1 / 2;
    float f1 = Math.abs(k);
    float f2 = paramInt1;
    float f3 = Math.min(1.0F, f1 * 1.0F / f2);
    f1 = m;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt1 = Math.abs(paramInt3);
    if (paramInt1 > 0) {
      paramInt1 = Math.round(Math.abs((f1 + f3 * f1) / paramInt1) * 1000.0F) * 4;
    } else {
      f1 = this.mAdapter.getPageWidth(this.mCurItem);
      paramInt1 = (int)((Math.abs(k) / (f2 * f1 + this.mPageMargin) + 1.0F) * 100.0F);
    } 
    paramInt1 = Math.min(paramInt1, 600);
    this.mIsScrollStarted = false;
    this.mScroller.startScroll(i, j, k, paramInt2, paramInt1);
    ViewCompat.postInvalidateOnAnimation((View)this);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable) {
    return (super.verifyDrawable(paramDrawable) || paramDrawable == this.mMarginDrawable);
  }
  
  static interface Decor {}
  
  static class ItemInfo {
    Object object;
    
    float offset;
    
    int position;
    
    boolean scrolling;
    
    float widthFactor;
  }
  
  public static class LayoutParams extends ViewGroup.LayoutParams {
    int childIndex;
    
    public int gravity;
    
    public boolean isDecor;
    
    boolean needsMeasure;
    
    int position;
    
    float widthFactor = 0.0F;
    
    public LayoutParams() {
      super(-1, -1);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, ViewPager.LAYOUT_ATTRS);
      this.gravity = typedArray.getInteger(0, 48);
      typedArray.recycle();
    }
  }
  
  static interface OnAdapterChangeListener {
    void onAdapterChanged(PagerAdapter param1PagerAdapter1, PagerAdapter param1PagerAdapter2);
  }
  
  public static interface OnPageChangeListener {
    void onPageScrollStateChanged(int param1Int);
    
    void onPageScrolled(int param1Int1, float param1Float, int param1Int2);
    
    void onPageSelected(int param1Int);
  }
  
  public static interface PageTransformer {
    void transformPage(View param1View, float param1Float);
  }
  
  private class PagerObserver extends DataSetObserver {
    private PagerObserver() {}
    
    public void onChanged() {
      ViewPager.this.dataSetChanged();
    }
    
    public void onInvalidated() {
      ViewPager.this.dataSetChanged();
    }
  }
  
  public static class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
          public ViewPager.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
            return new ViewPager.SavedState(param2Parcel, param2ClassLoader);
          }
          
          public ViewPager.SavedState[] newArray(int param2Int) {
            return new ViewPager.SavedState[param2Int];
          }
        });
    
    Parcelable adapterState;
    
    ClassLoader loader;
    
    int position;
    
    SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel);
      ClassLoader classLoader = param1ClassLoader;
      if (param1ClassLoader == null)
        classLoader = getClass().getClassLoader(); 
      this.position = param1Parcel.readInt();
      this.adapterState = param1Parcel.readParcelable(classLoader);
      this.loader = classLoader;
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("FragmentPager.SavedState{");
      stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      stringBuilder.append(" position=");
      stringBuilder.append(this.position);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.position);
      param1Parcel.writeParcelable(this.adapterState, param1Int);
    }
  }
  
  static final class null implements ParcelableCompatCreatorCallbacks<SavedState> {
    public ViewPager.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new ViewPager.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public ViewPager.SavedState[] newArray(int param1Int) {
      return new ViewPager.SavedState[param1Int];
    }
  }
  
  public static class SimpleOnPageChangeListener implements OnPageChangeListener {
    public void onPageScrollStateChanged(int param1Int) {}
    
    public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
    
    public void onPageSelected(int param1Int) {}
  }
  
  static class ViewPositionComparator implements Comparator<View> {
    public int compare(View param1View1, View param1View2) {
      ViewPager.LayoutParams layoutParams1 = (ViewPager.LayoutParams)param1View1.getLayoutParams();
      ViewPager.LayoutParams layoutParams2 = (ViewPager.LayoutParams)param1View2.getLayoutParams();
      if (layoutParams1.isDecor != layoutParams2.isDecor) {
        byte b;
        if (layoutParams1.isDecor) {
          b = 1;
        } else {
          b = -1;
        } 
        return b;
      } 
      return layoutParams1.position - layoutParams2.position;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\view\ViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */