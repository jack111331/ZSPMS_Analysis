package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
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
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
  
  static final int[] LAYOUT_ATTRS = new int[] { 16842931 };
  
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
  
  PagerAdapter mAdapter;
  
  private List<OnAdapterChangeListener> mAdapterChangeListeners;
  
  private int mBottomPageBounds;
  
  private boolean mCalledSuper;
  
  private int mChildHeightMeasureSpec;
  
  private int mChildWidthMeasureSpec;
  
  private int mCloseEnough;
  
  int mCurItem;
  
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
  
  private int mPageTransformerLayerType;
  
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
        float f = paramItemInfo2.offset;
        f3 = paramItemInfo2.widthFactor;
        j++;
        f3 = f + f3 + f1;
        byte b = 0;
        while (j <= paramItemInfo1.position && b < this.mItems.size()) {
          for (paramItemInfo2 = this.mItems.get(b); j > paramItemInfo2.position && b < this.mItems.size() - 1; paramItemInfo2 = this.mItems.get(++b));
          while (j < paramItemInfo2.position) {
            f = this.mAdapter.getPageWidth(j);
            j++;
            f3 = f + f1 + f3;
          } 
          paramItemInfo2.offset = f3;
          f3 += paramItemInfo2.widthFactor + f1;
          j++;
        } 
      } else if (j > paramItemInfo1.position) {
        int n = this.mItems.size();
        f3 = paramItemInfo2.offset;
        while (--j >= paramItemInfo1.position && --n >= 0) {
          for (paramItemInfo2 = this.mItems.get(n); j < paramItemInfo2.position && n > 0; paramItemInfo2 = this.mItems.get(--n));
          while (j > paramItemInfo2.position) {
            float f = this.mAdapter.getPageWidth(j);
            j--;
            f3 -= f + f1;
          } 
          f3 -= paramItemInfo2.widthFactor + f1;
          paramItemInfo2.offset = f3;
          j--;
        } 
      } 
    } 
    int m = this.mItems.size();
    float f2 = paramItemInfo1.offset;
    j = paramItemInfo1.position - 1;
    if (paramItemInfo1.position == 0) {
      f3 = paramItemInfo1.offset;
    } else {
      f3 = -3.4028235E38F;
    } 
    this.mFirstOffset = f3;
    if (paramItemInfo1.position == i - 1) {
      f3 = paramItemInfo1.offset + paramItemInfo1.widthFactor - 1.0F;
    } else {
      f3 = Float.MAX_VALUE;
    } 
    this.mLastOffset = f3;
    int k = paramInt - 1;
    float f3 = f2;
    while (k >= 0) {
      paramItemInfo2 = this.mItems.get(k);
      while (j > paramItemInfo2.position) {
        f3 -= this.mAdapter.getPageWidth(j) + f1;
        j--;
      } 
      f3 -= paramItemInfo2.widthFactor + f1;
      paramItemInfo2.offset = f3;
      if (paramItemInfo2.position == 0)
        this.mFirstOffset = f3; 
      j--;
      k--;
    } 
    f3 = f1 + paramItemInfo1.offset + paramItemInfo1.widthFactor;
    k = paramItemInfo1.position + 1;
    j = paramInt + 1;
    paramInt = k;
    while (j < m) {
      paramItemInfo1 = this.mItems.get(j);
      while (paramInt < paramItemInfo1.position) {
        f3 += this.mAdapter.getPageWidth(paramInt) + f1;
        paramInt++;
      } 
      if (paramItemInfo1.position == i - 1)
        this.mLastOffset = paramItemInfo1.widthFactor + f3 - 1.0F; 
      paramItemInfo1.offset = f3;
      f3 += paramItemInfo1.widthFactor + f1;
      paramInt++;
      j++;
    } 
    this.mNeedCalculatePageOffsets = false;
  }
  
  private void completeScroll(boolean paramBoolean) {
    boolean bool;
    if (this.mScrollState == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      int i;
      setScrollingCacheEnabled(false);
      if (!this.mScroller.isFinished()) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i) {
        this.mScroller.abortAnimation();
        int j = getScrollX();
        int k = getScrollY();
        int m = this.mScroller.getCurrX();
        i = this.mScroller.getCurrY();
        if (j != m || k != i) {
          scrollTo(m, i);
          if (m != j)
            pageScrolled(m); 
        } 
      } 
    } 
    this.mPopulatePending = false;
    for (byte b = 0; b < this.mItems.size(); b++) {
      ItemInfo itemInfo = this.mItems.get(b);
      if (itemInfo.scrolling) {
        itemInfo.scrolling = false;
        bool = true;
      } 
    } 
    if (bool) {
      if (paramBoolean) {
        ViewCompat.postOnAnimation((View)this, this.mEndScrollRunnable);
        return;
      } 
    } else {
      return;
    } 
    this.mEndScrollRunnable.run();
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
      paramInt1 += (int)(f + paramFloat);
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
      int i = this.mOnPageChangeListeners.size();
      for (byte b = 0; b < i; b++) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(b);
        if (onPageChangeListener != null)
          onPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2); 
      } 
    } 
    if (this.mInternalPageChangeListener != null)
      this.mInternalPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2); 
  }
  
  private void dispatchOnPageSelected(int paramInt) {
    if (this.mOnPageChangeListener != null)
      this.mOnPageChangeListener.onPageSelected(paramInt); 
    if (this.mOnPageChangeListeners != null) {
      int i = this.mOnPageChangeListeners.size();
      for (byte b = 0; b < i; b++) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(b);
        if (onPageChangeListener != null)
          onPageChangeListener.onPageSelected(paramInt); 
      } 
    } 
    if (this.mInternalPageChangeListener != null)
      this.mInternalPageChangeListener.onPageSelected(paramInt); 
  }
  
  private void dispatchOnScrollStateChanged(int paramInt) {
    if (this.mOnPageChangeListener != null)
      this.mOnPageChangeListener.onPageScrollStateChanged(paramInt); 
    if (this.mOnPageChangeListeners != null) {
      int i = this.mOnPageChangeListeners.size();
      for (byte b = 0; b < i; b++) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(b);
        if (onPageChangeListener != null)
          onPageChangeListener.onPageScrollStateChanged(paramInt); 
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
        bool = this.mPageTransformerLayerType;
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
    if (paramRect == null)
      paramRect = new Rect(); 
    if (paramView == null) {
      paramRect.set(0, 0, 0, 0);
      return paramRect;
    } 
    paramRect.left = paramView.getLeft();
    paramRect.right = paramView.getRight();
    paramRect.top = paramView.getTop();
    paramRect.bottom = paramView.getBottom();
    ViewParent viewParent = paramView.getParent();
    while (true) {
      if (viewParent instanceof ViewGroup && viewParent != this) {
        ViewGroup viewGroup = (ViewGroup)viewParent;
        paramRect.left += viewGroup.getLeft();
        paramRect.right += viewGroup.getRight();
        paramRect.top += viewGroup.getTop();
        paramRect.bottom += viewGroup.getBottom();
        ViewParent viewParent1 = viewGroup.getParent();
        continue;
      } 
      return paramRect;
    } 
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
    boolean bool = true;
    int j = -1;
    float f3 = 0.0F;
    float f4 = 0.0F;
    i = 0;
    for (ItemInfo itemInfo = null;; itemInfo = itemInfo1) {
      ItemInfo itemInfo1;
      if (i < this.mItems.size()) {
        itemInfo1 = this.mItems.get(i);
        if (!bool && itemInfo1.position != j + 1) {
          itemInfo1 = this.mTempItem;
          itemInfo1.offset = f3 + f4 + f2;
          itemInfo1.position = j + 1;
          itemInfo1.widthFactor = this.mAdapter.getPageWidth(itemInfo1.position);
          i--;
        } 
        f3 = itemInfo1.offset;
        f4 = itemInfo1.widthFactor;
        if (bool || f1 >= f3) {
          itemInfo = itemInfo1;
          if (f1 >= f4 + f3 + f2) {
            if (i == this.mItems.size() - 1)
              return itemInfo1; 
          } else {
            return itemInfo;
          } 
        } else {
          return itemInfo;
        } 
      } else {
        return itemInfo;
      } 
      j = itemInfo1.position;
      f4 = itemInfo1.widthFactor;
      i++;
      bool = false;
    } 
  }
  
  private static boolean isDecorView(@NonNull View paramView) {
    return (paramView.getClass().getAnnotation(DecorView.class) != null);
  }
  
  private boolean isGutterDrag(float paramFloat1, float paramFloat2) {
    return ((paramFloat1 < this.mGutterSize && paramFloat2 > 0.0F) || (paramFloat1 > (getWidth() - this.mGutterSize) && paramFloat2 < 0.0F));
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent) {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      this.mLastMotionX = paramMotionEvent.getX(i);
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
      if (this.mVelocityTracker != null)
        this.mVelocityTracker.clear(); 
    } 
  }
  
  private boolean pageScrolled(int paramInt) {
    null = false;
    if (this.mItems.size() == 0) {
      if (!this.mFirstLayout) {
        this.mCalledSuper = false;
        onPageScrolled(0, 0.0F, 0);
        if (!this.mCalledSuper)
          throw new IllegalStateException("onPageScrolled did not call superclass implementation"); 
      } 
      return null;
    } 
    ItemInfo itemInfo = infoForCurrentScrollPosition();
    int i = getClientWidth();
    int j = this.mPageMargin;
    float f = this.mPageMargin / i;
    int k = itemInfo.position;
    f = (paramInt / i - itemInfo.offset) / (itemInfo.widthFactor + f);
    paramInt = (int)((j + i) * f);
    this.mCalledSuper = false;
    onPageScrolled(k, f, paramInt);
    if (!this.mCalledSuper)
      throw new IllegalStateException("onPageScrolled did not call superclass implementation"); 
    return true;
  }
  
  private boolean performDrag(float paramFloat) {
    boolean bool3;
    boolean bool1 = false;
    boolean bool = false;
    boolean bool2 = true;
    float f1 = this.mLastMotionX;
    this.mLastMotionX = paramFloat;
    float f2 = f1 - paramFloat + getScrollX();
    int i = getClientWidth();
    paramFloat = i * this.mFirstOffset;
    f1 = i;
    float f3 = this.mLastOffset;
    ItemInfo itemInfo1 = this.mItems.get(0);
    ItemInfo itemInfo2 = this.mItems.get(this.mItems.size() - 1);
    if (itemInfo1.position != 0) {
      paramFloat = itemInfo1.offset * i;
      bool3 = false;
    } else {
      bool3 = true;
    } 
    if (itemInfo2.position != this.mAdapter.getCount() - 1) {
      f1 = itemInfo2.offset * i;
      bool2 = false;
    } else {
      f1 *= f3;
    } 
    if (f2 < paramFloat) {
      f1 = paramFloat;
      if (bool3) {
        bool = this.mLeftEdge.onPull(Math.abs(paramFloat - f2) / i);
        f1 = paramFloat;
      } 
      this.mLastMotionX += f1 - (int)f1;
      scrollTo((int)f1, getScrollY());
      pageScrolled((int)f1);
      return bool;
    } 
    if (f2 > f1) {
      bool = bool1;
      if (bool2)
        bool = this.mRightEdge.onPull(Math.abs(f2 - f1) / i); 
      this.mLastMotionX += f1 - (int)f1;
      scrollTo((int)f1, getScrollY());
      pageScrolled((int)f1);
      return bool;
    } 
    f1 = f2;
    this.mLastMotionX += f1 - (int)f1;
    scrollTo((int)f1, getScrollY());
    pageScrolled((int)f1);
    return bool;
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    float f;
    if (paramInt2 > 0 && !this.mItems.isEmpty()) {
      if (!this.mScroller.isFinished()) {
        this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        return;
      } 
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      f = getScrollX() / (paramInt2 - k - m + paramInt4);
      scrollTo((int)((paramInt1 - i - j + paramInt3) * f), getScrollY());
      return;
    } 
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
      float f = getClientWidth();
      bool = (int)(Math.max(this.mFirstOffset, Math.min(itemInfo.offset, this.mLastOffset)) * f);
    } else {
      bool = false;
    } 
    if (paramBoolean1) {
      smoothScrollTo(bool, 0, paramInt2);
      if (paramBoolean2)
        dispatchOnPageSelected(paramInt1); 
      return;
    } 
    if (paramBoolean2)
      dispatchOnPageSelected(paramInt1); 
    completeScroll(false);
    scrollTo(bool, 0);
    pageScrolled(bool);
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
    if ((j != 262144 || i == paramArrayList.size()) && isFocusable() && ((paramInt2 & 0x1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && paramArrayList != null)
      paramArrayList.add(this); 
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
  
  public void addOnAdapterChangeListener(@NonNull OnAdapterChangeListener paramOnAdapterChangeListener) {
    if (this.mAdapterChangeListeners == null)
      this.mAdapterChangeListeners = new ArrayList<OnAdapterChangeListener>(); 
    this.mAdapterChangeListeners.add(paramOnAdapterChangeListener);
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
    if (!checkLayoutParams(paramLayoutParams))
      paramLayoutParams = generateLayoutParams(paramLayoutParams); 
    LayoutParams layoutParams = (LayoutParams)paramLayoutParams;
    layoutParams.isDecor |= isDecorView(paramView);
    if (this.mInLayout) {
      if (layoutParams != null && layoutParams.isDecor)
        throw new IllegalStateException("Cannot add pager decor view during layout"); 
      layoutParams.needsMeasure = true;
      addViewInLayout(paramView, paramInt, paramLayoutParams);
      return;
    } 
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public boolean arrowScroll(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual findFocus : ()Landroid/view/View;
    //   4: astore_2
    //   5: aload_2
    //   6: aload_0
    //   7: if_acmpne -> 98
    //   10: aconst_null
    //   11: astore_3
    //   12: invokestatic getInstance : ()Landroid/view/FocusFinder;
    //   15: aload_0
    //   16: aload_3
    //   17: iload_1
    //   18: invokevirtual findNextFocus : (Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull -> 307
    //   26: aload_2
    //   27: aload_3
    //   28: if_acmpeq -> 307
    //   31: iload_1
    //   32: bipush #17
    //   34: if_icmpne -> 244
    //   37: aload_0
    //   38: aload_0
    //   39: getfield mTempRect : Landroid/graphics/Rect;
    //   42: aload_2
    //   43: invokespecial getChildRectInPagerCoordinates : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   46: getfield left : I
    //   49: istore #4
    //   51: aload_0
    //   52: aload_0
    //   53: getfield mTempRect : Landroid/graphics/Rect;
    //   56: aload_3
    //   57: invokespecial getChildRectInPagerCoordinates : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   60: getfield left : I
    //   63: istore #5
    //   65: aload_3
    //   66: ifnull -> 235
    //   69: iload #4
    //   71: iload #5
    //   73: if_icmplt -> 235
    //   76: aload_0
    //   77: invokevirtual pageLeft : ()Z
    //   80: istore #6
    //   82: iload #6
    //   84: ifeq -> 95
    //   87: aload_0
    //   88: iload_1
    //   89: invokestatic getContantForFocusDirection : (I)I
    //   92: invokevirtual playSoundEffect : (I)V
    //   95: iload #6
    //   97: ireturn
    //   98: aload_2
    //   99: ifnull -> 353
    //   102: aload_2
    //   103: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   106: astore_3
    //   107: aload_3
    //   108: instanceof android/view/ViewGroup
    //   111: ifeq -> 358
    //   114: aload_3
    //   115: aload_0
    //   116: if_acmpne -> 190
    //   119: iconst_1
    //   120: istore #5
    //   122: iload #5
    //   124: ifne -> 353
    //   127: new java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial <init> : ()V
    //   134: astore #7
    //   136: aload #7
    //   138: aload_2
    //   139: invokevirtual getClass : ()Ljava/lang/Class;
    //   142: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_2
    //   150: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   153: astore_3
    //   154: aload_3
    //   155: instanceof android/view/ViewGroup
    //   158: ifeq -> 200
    //   161: aload #7
    //   163: ldc_w ' => '
    //   166: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_3
    //   170: invokevirtual getClass : ()Ljava/lang/Class;
    //   173: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   176: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_3
    //   181: invokeinterface getParent : ()Landroid/view/ViewParent;
    //   186: astore_3
    //   187: goto -> 154
    //   190: aload_3
    //   191: invokeinterface getParent : ()Landroid/view/ViewParent;
    //   196: astore_3
    //   197: goto -> 107
    //   200: ldc 'ViewPager'
    //   202: new java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial <init> : ()V
    //   209: ldc_w 'arrowScroll tried to find focus based on non-child current focused view '
    //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload #7
    //   217: invokevirtual toString : ()Ljava/lang/String;
    //   220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual toString : ()Ljava/lang/String;
    //   226: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   229: pop
    //   230: aconst_null
    //   231: astore_3
    //   232: goto -> 12
    //   235: aload_2
    //   236: invokevirtual requestFocus : ()Z
    //   239: istore #6
    //   241: goto -> 82
    //   244: iload_1
    //   245: bipush #66
    //   247: if_icmpne -> 347
    //   250: aload_0
    //   251: aload_0
    //   252: getfield mTempRect : Landroid/graphics/Rect;
    //   255: aload_2
    //   256: invokespecial getChildRectInPagerCoordinates : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   259: getfield left : I
    //   262: istore #4
    //   264: aload_0
    //   265: aload_0
    //   266: getfield mTempRect : Landroid/graphics/Rect;
    //   269: aload_3
    //   270: invokespecial getChildRectInPagerCoordinates : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   273: getfield left : I
    //   276: istore #5
    //   278: aload_3
    //   279: ifnull -> 298
    //   282: iload #4
    //   284: iload #5
    //   286: if_icmpgt -> 298
    //   289: aload_0
    //   290: invokevirtual pageRight : ()Z
    //   293: istore #6
    //   295: goto -> 82
    //   298: aload_2
    //   299: invokevirtual requestFocus : ()Z
    //   302: istore #6
    //   304: goto -> 82
    //   307: iload_1
    //   308: bipush #17
    //   310: if_icmpeq -> 318
    //   313: iload_1
    //   314: iconst_1
    //   315: if_icmpne -> 327
    //   318: aload_0
    //   319: invokevirtual pageLeft : ()Z
    //   322: istore #6
    //   324: goto -> 82
    //   327: iload_1
    //   328: bipush #66
    //   330: if_icmpeq -> 338
    //   333: iload_1
    //   334: iconst_2
    //   335: if_icmpne -> 347
    //   338: aload_0
    //   339: invokevirtual pageRight : ()Z
    //   342: istore #6
    //   344: goto -> 82
    //   347: iconst_0
    //   348: istore #6
    //   350: goto -> 82
    //   353: aload_2
    //   354: astore_3
    //   355: goto -> 12
    //   358: iconst_0
    //   359: istore #5
    //   361: goto -> 122
  }
  
  public boolean beginFakeDrag() {
    boolean bool = false;
    if (!this.mIsBeingDragged) {
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
      bool = true;
    } 
    return bool;
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
      paramBoolean = bool;
      return !ViewCompat.canScrollHorizontally(paramView, -paramInt1) ? false : paramBoolean;
    } 
    return false;
  }
  
  public boolean canScrollHorizontally(int paramInt) {
    boolean bool1 = false;
    if (this.mAdapter == null)
      return bool1; 
    int i = getClientWidth();
    int j = getScrollX();
    if (paramInt < 0) {
      boolean bool = bool1;
      return (j > (int)(i * this.mFirstOffset)) ? true : bool;
    } 
    boolean bool2 = bool1;
    if (paramInt > 0) {
      bool2 = bool1;
      if (j < (int)(i * this.mLastOffset))
        return true; 
    } 
    return bool2;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof LayoutParams && super.checkLayoutParams(paramLayoutParams));
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
    int i = this.mAdapter.getCount();
    this.mExpectedAdapterCount = i;
    if (this.mItems.size() < this.mOffscreenPageLimit * 2 + 1 && this.mItems.size() < i) {
      j = 1;
    } else {
      j = 0;
    } 
    int k = this.mCurItem;
    int m = j;
    int j = 0;
    int n = 0;
    while (true) {
      if (n < this.mItems.size()) {
        ItemInfo itemInfo = this.mItems.get(n);
        int i1 = this.mAdapter.getItemPosition(itemInfo.object);
        if (i1 == -1) {
          i1 = n;
          n = j;
          j = m;
          m = i1;
        } else if (i1 == -2) {
          this.mItems.remove(n);
          m = n - 1;
          n = j;
          if (j == 0) {
            this.mAdapter.startUpdate(this);
            n = 1;
          } 
          this.mAdapter.destroyItem(this, itemInfo.position, itemInfo.object);
          if (this.mCurItem == itemInfo.position) {
            k = Math.max(0, Math.min(this.mCurItem, i - 1));
            j = 1;
          } else {
            j = 1;
          } 
        } else if (itemInfo.position != i1) {
          if (itemInfo.position == this.mCurItem)
            k = i1; 
          itemInfo.position = i1;
          m = n;
          n = j;
          j = 1;
        } else {
          i1 = n;
          int i2 = m;
          n = j;
          m = i1;
          j = i2;
        } 
        i1 = n;
        n = m + 1;
        m = j;
        j = i1;
        continue;
      } 
      if (j != 0)
        this.mAdapter.finishUpdate(this); 
      Collections.sort(this.mItems, COMPARATOR);
      if (m != 0) {
        n = getChildCount();
        for (j = 0; j < n; j++) {
          LayoutParams layoutParams = (LayoutParams)getChildAt(j).getLayoutParams();
          if (!layoutParams.isDecor)
            layoutParams.widthFactor = 0.0F; 
        } 
        setCurrentItemInternal(k, false, true);
        requestLayout();
      } 
      return;
    } 
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return (super.dispatchKeyEvent(paramKeyEvent) || executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    boolean bool = false;
    if (paramAccessibilityEvent.getEventType() == 4096)
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent); 
    int i = getChildCount();
    byte b = 0;
    while (true) {
      boolean bool1 = bool;
      if (b < i) {
        View view = getChildAt(b);
        if (view.getVisibility() == 0) {
          ItemInfo itemInfo = infoForChild(view);
          if (itemInfo != null && itemInfo.position == this.mCurItem && view.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))
            return true; 
        } 
        b++;
        continue;
      } 
      return bool1;
    } 
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat) {
    return (float)Math.sin((float)(0.4712389167638204D * (paramFloat - 0.5F)));
  }
  
  public void draw(Canvas paramCanvas) {
    boolean bool;
    int i = 0;
    int j = 0;
    super.draw(paramCanvas);
    int k = getOverScrollMode();
    if (k == 0 || (k == 1 && this.mAdapter != null && this.mAdapter.getCount() > 1)) {
      if (!this.mLeftEdge.isFinished()) {
        i = paramCanvas.save();
        k = getHeight() - getPaddingTop() - getPaddingBottom();
        j = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate((-k + getPaddingTop()), this.mFirstOffset * j);
        this.mLeftEdge.setSize(k, j);
        j = this.mLeftEdge.draw(paramCanvas) | false;
        paramCanvas.restoreToCount(i);
      } 
      i = j;
      if (!this.mRightEdge.isFinished()) {
        k = paramCanvas.save();
        int m = getWidth();
        int n = getHeight();
        int i1 = getPaddingTop();
        i = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(1.0F + this.mLastOffset) * m);
        this.mRightEdge.setSize(n - i1 - i, m);
        bool = j | this.mRightEdge.draw(paramCanvas);
        paramCanvas.restoreToCount(k);
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
    if (!this.mFakeDragging)
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first."); 
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
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode()) {
        default:
          return false;
        case 21:
          return arrowScroll(17);
        case 22:
          return arrowScroll(66);
        case 61:
          break;
      } 
      if (Build.VERSION.SDK_INT >= 11) {
        if (KeyEventCompat.hasNoModifiers(paramKeyEvent))
          return arrowScroll(2); 
        if (KeyEventCompat.hasModifiers(paramKeyEvent, 1))
          return arrowScroll(1); 
      } 
    } 
  }
  
  public void fakeDragBy(float paramFloat) {
    if (!this.mFakeDragging)
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first."); 
    if (this.mAdapter != null) {
      this.mLastMotionX += paramFloat;
      float f1 = getScrollX() - paramFloat;
      int i = getClientWidth();
      paramFloat = i;
      float f2 = this.mFirstOffset;
      float f3 = i;
      float f4 = this.mLastOffset;
      ItemInfo itemInfo1 = this.mItems.get(0);
      ItemInfo itemInfo2 = this.mItems.get(this.mItems.size() - 1);
      if (itemInfo1.position != 0) {
        paramFloat = itemInfo1.offset * i;
      } else {
        paramFloat *= f2;
      } 
      if (itemInfo2.position != this.mAdapter.getCount() - 1) {
        f4 = itemInfo2.offset * i;
      } else {
        f4 = f3 * f4;
      } 
      if (f1 >= paramFloat)
        if (f1 > f4) {
          paramFloat = f4;
        } else {
          paramFloat = f1;
        }  
      this.mLastMotionX += paramFloat - (int)paramFloat;
      scrollTo((int)paramFloat, getScrollY());
      pageScrolled((int)paramFloat);
      long l = SystemClock.uptimeMillis();
      MotionEvent motionEvent = MotionEvent.obtain(this.mFakeDragBeginTime, l, 2, this.mLastMotionX, 0.0F, 0);
      this.mVelocityTracker.addMovement(motionEvent);
      motionEvent.recycle();
    } 
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
        if (viewParent == null || !(viewParent instanceof View))
          return null; 
        paramView = (View)viewParent;
        continue;
      } 
      return infoForChild(paramView);
    } 
  }
  
  ItemInfo infoForChild(View paramView) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iload_2
    //   3: aload_0
    //   4: getfield mItems : Ljava/util/ArrayList;
    //   7: invokevirtual size : ()I
    //   10: if_icmpge -> 50
    //   13: aload_0
    //   14: getfield mItems : Ljava/util/ArrayList;
    //   17: iload_2
    //   18: invokevirtual get : (I)Ljava/lang/Object;
    //   21: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   24: astore_3
    //   25: aload_0
    //   26: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   29: aload_1
    //   30: aload_3
    //   31: getfield object : Ljava/lang/Object;
    //   34: invokevirtual isViewFromObject : (Landroid/view/View;Ljava/lang/Object;)Z
    //   37: ifeq -> 44
    //   40: aload_3
    //   41: astore_1
    //   42: aload_1
    //   43: areturn
    //   44: iinc #2, 1
    //   47: goto -> 2
    //   50: aconst_null
    //   51: astore_1
    //   52: goto -> 42
  }
  
  ItemInfo infoForPosition(int paramInt) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iload_2
    //   3: aload_0
    //   4: getfield mItems : Ljava/util/ArrayList;
    //   7: invokevirtual size : ()I
    //   10: if_icmpge -> 41
    //   13: aload_0
    //   14: getfield mItems : Ljava/util/ArrayList;
    //   17: iload_2
    //   18: invokevirtual get : (I)Ljava/lang/Object;
    //   21: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   24: astore_3
    //   25: aload_3
    //   26: getfield position : I
    //   29: iload_1
    //   30: if_icmpne -> 35
    //   33: aload_3
    //   34: areturn
    //   35: iinc #2, 1
    //   38: goto -> 2
    //   41: aconst_null
    //   42: astore_3
    //   43: goto -> 33
  }
  
  void initViewPager() {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context context = getContext();
    this.mScroller = new Scroller(context, sInterpolator);
    ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
    float f = (context.getResources().getDisplayMetrics()).density;
    this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
    this.mMinimumVelocity = (int)(400.0F * f);
    this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    this.mLeftEdge = new EdgeEffectCompat(context);
    this.mRightEdge = new EdgeEffectCompat(context);
    this.mFlingDistance = (int)(25.0F * f);
    this.mCloseEnough = (int)(2.0F * f);
    this.mDefaultGutterSize = (int)(16.0F * f);
    ViewCompat.setAccessibilityDelegate((View)this, new MyAccessibilityDelegate());
    if (ViewCompat.getImportantForAccessibility((View)this) == 0)
      ViewCompat.setImportantForAccessibility((View)this, 1); 
    ViewCompat.setOnApplyWindowInsetsListener((View)this, new OnApplyWindowInsetsListener() {
          private final Rect mTempRect = new Rect();
          
          public WindowInsetsCompat onApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat) {
            WindowInsetsCompat windowInsetsCompat = ViewCompat.onApplyWindowInsets(param1View, param1WindowInsetsCompat);
            if (!windowInsetsCompat.isConsumed()) {
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
              windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
            } 
            return windowInsetsCompat;
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
      float f1 = this.mPageMargin / j;
      ItemInfo itemInfo = this.mItems.get(0);
      float f2 = itemInfo.offset;
      int k = this.mItems.size();
      int m = itemInfo.position;
      int n = ((ItemInfo)this.mItems.get(k - 1)).position;
      byte b = 0;
      while (true) {
        if (m < n) {
          ItemInfo itemInfo1;
          float f;
          while (m > itemInfo.position && b < k) {
            ArrayList<ItemInfo> arrayList = this.mItems;
            itemInfo1 = arrayList.get(++b);
          } 
          if (m == itemInfo1.position) {
            f = (itemInfo1.offset + itemInfo1.widthFactor) * j;
            f2 = itemInfo1.offset + itemInfo1.widthFactor + f1;
          } else {
            float f3 = this.mAdapter.getPageWidth(m);
            f = (f2 + f3) * j;
            f2 += f3 + f1;
          } 
          if (this.mPageMargin + f > i) {
            this.mMarginDrawable.setBounds(Math.round(f), this.mTopPageBounds, Math.round(this.mPageMargin + f), this.mBottomPageBounds);
            this.mMarginDrawable.draw(paramCanvas);
          } 
          if (f <= (i + j)) {
            m++;
            continue;
          } 
        } 
        return;
      } 
    } 
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: invokevirtual getAction : ()I
    //   6: sipush #255
    //   9: iand
    //   10: istore_3
    //   11: iload_3
    //   12: iconst_3
    //   13: if_icmpeq -> 21
    //   16: iload_3
    //   17: iconst_1
    //   18: if_icmpne -> 32
    //   21: aload_0
    //   22: invokespecial resetTouch : ()Z
    //   25: pop
    //   26: iload_2
    //   27: istore #4
    //   29: iload #4
    //   31: ireturn
    //   32: iload_3
    //   33: ifeq -> 59
    //   36: aload_0
    //   37: getfield mIsBeingDragged : Z
    //   40: ifeq -> 49
    //   43: iconst_1
    //   44: istore #4
    //   46: goto -> 29
    //   49: iload_2
    //   50: istore #4
    //   52: aload_0
    //   53: getfield mIsUnableToDrag : Z
    //   56: ifne -> 29
    //   59: iload_3
    //   60: lookupswitch default -> 96, 0 -> 377, 2 -> 127, 6 -> 520
    //   96: aload_0
    //   97: getfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   100: ifnonnull -> 110
    //   103: aload_0
    //   104: invokestatic obtain : ()Landroid/view/VelocityTracker;
    //   107: putfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   110: aload_0
    //   111: getfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   114: aload_1
    //   115: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   118: aload_0
    //   119: getfield mIsBeingDragged : Z
    //   122: istore #4
    //   124: goto -> 29
    //   127: aload_0
    //   128: getfield mActivePointerId : I
    //   131: istore_3
    //   132: iload_3
    //   133: iconst_m1
    //   134: if_icmpeq -> 96
    //   137: aload_1
    //   138: iload_3
    //   139: invokevirtual findPointerIndex : (I)I
    //   142: istore_3
    //   143: aload_1
    //   144: iload_3
    //   145: invokevirtual getX : (I)F
    //   148: fstore #5
    //   150: fload #5
    //   152: aload_0
    //   153: getfield mLastMotionX : F
    //   156: fsub
    //   157: fstore #6
    //   159: fload #6
    //   161: invokestatic abs : (F)F
    //   164: fstore #7
    //   166: aload_1
    //   167: iload_3
    //   168: invokevirtual getY : (I)F
    //   171: fstore #8
    //   173: fload #8
    //   175: aload_0
    //   176: getfield mInitialMotionY : F
    //   179: fsub
    //   180: invokestatic abs : (F)F
    //   183: fstore #9
    //   185: fload #6
    //   187: fconst_0
    //   188: fcmpl
    //   189: ifeq -> 246
    //   192: aload_0
    //   193: aload_0
    //   194: getfield mLastMotionX : F
    //   197: fload #6
    //   199: invokespecial isGutterDrag : (FF)Z
    //   202: ifne -> 246
    //   205: aload_0
    //   206: aload_0
    //   207: iconst_0
    //   208: fload #6
    //   210: f2i
    //   211: fload #5
    //   213: f2i
    //   214: fload #8
    //   216: f2i
    //   217: invokevirtual canScroll : (Landroid/view/View;ZIII)Z
    //   220: ifeq -> 246
    //   223: aload_0
    //   224: fload #5
    //   226: putfield mLastMotionX : F
    //   229: aload_0
    //   230: fload #8
    //   232: putfield mLastMotionY : F
    //   235: aload_0
    //   236: iconst_1
    //   237: putfield mIsUnableToDrag : Z
    //   240: iload_2
    //   241: istore #4
    //   243: goto -> 29
    //   246: fload #7
    //   248: aload_0
    //   249: getfield mTouchSlop : I
    //   252: i2f
    //   253: fcmpl
    //   254: ifle -> 358
    //   257: ldc_w 0.5
    //   260: fload #7
    //   262: fmul
    //   263: fload #9
    //   265: fcmpl
    //   266: ifle -> 358
    //   269: aload_0
    //   270: iconst_1
    //   271: putfield mIsBeingDragged : Z
    //   274: aload_0
    //   275: iconst_1
    //   276: invokespecial requestParentDisallowInterceptTouchEvent : (Z)V
    //   279: aload_0
    //   280: iconst_1
    //   281: invokevirtual setScrollState : (I)V
    //   284: fload #6
    //   286: fconst_0
    //   287: fcmpl
    //   288: ifle -> 343
    //   291: aload_0
    //   292: getfield mInitialMotionX : F
    //   295: aload_0
    //   296: getfield mTouchSlop : I
    //   299: i2f
    //   300: fadd
    //   301: fstore #9
    //   303: aload_0
    //   304: fload #9
    //   306: putfield mLastMotionX : F
    //   309: aload_0
    //   310: fload #8
    //   312: putfield mLastMotionY : F
    //   315: aload_0
    //   316: iconst_1
    //   317: invokespecial setScrollingCacheEnabled : (Z)V
    //   320: aload_0
    //   321: getfield mIsBeingDragged : Z
    //   324: ifeq -> 96
    //   327: aload_0
    //   328: fload #5
    //   330: invokespecial performDrag : (F)Z
    //   333: ifeq -> 96
    //   336: aload_0
    //   337: invokestatic postInvalidateOnAnimation : (Landroid/view/View;)V
    //   340: goto -> 96
    //   343: aload_0
    //   344: getfield mInitialMotionX : F
    //   347: aload_0
    //   348: getfield mTouchSlop : I
    //   351: i2f
    //   352: fsub
    //   353: fstore #9
    //   355: goto -> 303
    //   358: fload #9
    //   360: aload_0
    //   361: getfield mTouchSlop : I
    //   364: i2f
    //   365: fcmpl
    //   366: ifle -> 320
    //   369: aload_0
    //   370: iconst_1
    //   371: putfield mIsUnableToDrag : Z
    //   374: goto -> 320
    //   377: aload_1
    //   378: invokevirtual getX : ()F
    //   381: fstore #9
    //   383: aload_0
    //   384: fload #9
    //   386: putfield mInitialMotionX : F
    //   389: aload_0
    //   390: fload #9
    //   392: putfield mLastMotionX : F
    //   395: aload_1
    //   396: invokevirtual getY : ()F
    //   399: fstore #9
    //   401: aload_0
    //   402: fload #9
    //   404: putfield mInitialMotionY : F
    //   407: aload_0
    //   408: fload #9
    //   410: putfield mLastMotionY : F
    //   413: aload_0
    //   414: aload_1
    //   415: iconst_0
    //   416: invokevirtual getPointerId : (I)I
    //   419: putfield mActivePointerId : I
    //   422: aload_0
    //   423: iconst_0
    //   424: putfield mIsUnableToDrag : Z
    //   427: aload_0
    //   428: iconst_1
    //   429: putfield mIsScrollStarted : Z
    //   432: aload_0
    //   433: getfield mScroller : Landroid/widget/Scroller;
    //   436: invokevirtual computeScrollOffset : ()Z
    //   439: pop
    //   440: aload_0
    //   441: getfield mScrollState : I
    //   444: iconst_2
    //   445: if_icmpne -> 507
    //   448: aload_0
    //   449: getfield mScroller : Landroid/widget/Scroller;
    //   452: invokevirtual getFinalX : ()I
    //   455: aload_0
    //   456: getfield mScroller : Landroid/widget/Scroller;
    //   459: invokevirtual getCurrX : ()I
    //   462: isub
    //   463: invokestatic abs : (I)I
    //   466: aload_0
    //   467: getfield mCloseEnough : I
    //   470: if_icmple -> 507
    //   473: aload_0
    //   474: getfield mScroller : Landroid/widget/Scroller;
    //   477: invokevirtual abortAnimation : ()V
    //   480: aload_0
    //   481: iconst_0
    //   482: putfield mPopulatePending : Z
    //   485: aload_0
    //   486: invokevirtual populate : ()V
    //   489: aload_0
    //   490: iconst_1
    //   491: putfield mIsBeingDragged : Z
    //   494: aload_0
    //   495: iconst_1
    //   496: invokespecial requestParentDisallowInterceptTouchEvent : (Z)V
    //   499: aload_0
    //   500: iconst_1
    //   501: invokevirtual setScrollState : (I)V
    //   504: goto -> 96
    //   507: aload_0
    //   508: iconst_0
    //   509: invokespecial completeScroll : (Z)V
    //   512: aload_0
    //   513: iconst_0
    //   514: putfield mIsBeingDragged : Z
    //   517: goto -> 96
    //   520: aload_0
    //   521: aload_1
    //   522: invokespecial onSecondaryPointerUp : (Landroid/view/MotionEvent;)V
    //   525: goto -> 96
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getChildCount : ()I
    //   4: istore #6
    //   6: iload #4
    //   8: iload_2
    //   9: isub
    //   10: istore #7
    //   12: iload #5
    //   14: iload_3
    //   15: isub
    //   16: istore #8
    //   18: aload_0
    //   19: invokevirtual getPaddingLeft : ()I
    //   22: istore_2
    //   23: aload_0
    //   24: invokevirtual getPaddingTop : ()I
    //   27: istore_3
    //   28: aload_0
    //   29: invokevirtual getPaddingRight : ()I
    //   32: istore #5
    //   34: aload_0
    //   35: invokevirtual getPaddingBottom : ()I
    //   38: istore #4
    //   40: aload_0
    //   41: invokevirtual getScrollX : ()I
    //   44: istore #9
    //   46: iconst_0
    //   47: istore #10
    //   49: iconst_0
    //   50: istore #11
    //   52: iload #11
    //   54: iload #6
    //   56: if_icmpge -> 423
    //   59: aload_0
    //   60: iload #11
    //   62: invokevirtual getChildAt : (I)Landroid/view/View;
    //   65: astore #12
    //   67: aload #12
    //   69: invokevirtual getVisibility : ()I
    //   72: bipush #8
    //   74: if_icmpeq -> 634
    //   77: aload #12
    //   79: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   82: checkcast android/support/v4/view/ViewPager$LayoutParams
    //   85: astore #13
    //   87: aload #13
    //   89: getfield isDecor : Z
    //   92: ifeq -> 634
    //   95: aload #13
    //   97: getfield gravity : I
    //   100: istore #14
    //   102: aload #13
    //   104: getfield gravity : I
    //   107: istore #15
    //   109: iload #14
    //   111: bipush #7
    //   113: iand
    //   114: tableswitch default -> 148, 1 -> 293, 2 -> 148, 3 -> 275, 4 -> 148, 5 -> 312
    //   148: iload_2
    //   149: istore #14
    //   151: iload #15
    //   153: bipush #112
    //   155: iand
    //   156: lookupswitch default -> 192, 16 -> 358, 48 -> 346, 80 -> 383
    //   192: iload_3
    //   193: istore #15
    //   195: iload #14
    //   197: iload #9
    //   199: iadd
    //   200: istore #14
    //   202: aload #12
    //   204: iload #14
    //   206: iload_3
    //   207: aload #12
    //   209: invokevirtual getMeasuredWidth : ()I
    //   212: iload #14
    //   214: iadd
    //   215: aload #12
    //   217: invokevirtual getMeasuredHeight : ()I
    //   220: iload_3
    //   221: iadd
    //   222: invokevirtual layout : (IIII)V
    //   225: iinc #10, 1
    //   228: iload #5
    //   230: istore #14
    //   232: iload #4
    //   234: istore_3
    //   235: iload_2
    //   236: istore #4
    //   238: iload #10
    //   240: istore #5
    //   242: iload #14
    //   244: istore_2
    //   245: iinc #11, 1
    //   248: iload #5
    //   250: istore #10
    //   252: iload #4
    //   254: istore #5
    //   256: iload_2
    //   257: istore #14
    //   259: iload_3
    //   260: istore #4
    //   262: iload #15
    //   264: istore_3
    //   265: iload #5
    //   267: istore_2
    //   268: iload #14
    //   270: istore #5
    //   272: goto -> 52
    //   275: aload #12
    //   277: invokevirtual getMeasuredWidth : ()I
    //   280: istore #16
    //   282: iload_2
    //   283: istore #14
    //   285: iload #16
    //   287: iload_2
    //   288: iadd
    //   289: istore_2
    //   290: goto -> 151
    //   293: iload #7
    //   295: aload #12
    //   297: invokevirtual getMeasuredWidth : ()I
    //   300: isub
    //   301: iconst_2
    //   302: idiv
    //   303: iload_2
    //   304: invokestatic max : (II)I
    //   307: istore #14
    //   309: goto -> 151
    //   312: aload #12
    //   314: invokevirtual getMeasuredWidth : ()I
    //   317: istore #14
    //   319: aload #12
    //   321: invokevirtual getMeasuredWidth : ()I
    //   324: istore #16
    //   326: iload #7
    //   328: iload #5
    //   330: isub
    //   331: iload #14
    //   333: isub
    //   334: istore #14
    //   336: iload #5
    //   338: iload #16
    //   340: iadd
    //   341: istore #5
    //   343: goto -> 151
    //   346: aload #12
    //   348: invokevirtual getMeasuredHeight : ()I
    //   351: iload_3
    //   352: iadd
    //   353: istore #15
    //   355: goto -> 195
    //   358: iload #8
    //   360: aload #12
    //   362: invokevirtual getMeasuredHeight : ()I
    //   365: isub
    //   366: iconst_2
    //   367: idiv
    //   368: iload_3
    //   369: invokestatic max : (II)I
    //   372: istore #16
    //   374: iload_3
    //   375: istore #15
    //   377: iload #16
    //   379: istore_3
    //   380: goto -> 195
    //   383: aload #12
    //   385: invokevirtual getMeasuredHeight : ()I
    //   388: istore #16
    //   390: aload #12
    //   392: invokevirtual getMeasuredHeight : ()I
    //   395: iload #4
    //   397: iadd
    //   398: istore #15
    //   400: iload #8
    //   402: iload #4
    //   404: isub
    //   405: iload #16
    //   407: isub
    //   408: istore #16
    //   410: iload #15
    //   412: istore #4
    //   414: iload_3
    //   415: istore #15
    //   417: iload #16
    //   419: istore_3
    //   420: goto -> 195
    //   423: iload #7
    //   425: iload_2
    //   426: isub
    //   427: iload #5
    //   429: isub
    //   430: istore #15
    //   432: iconst_0
    //   433: istore #5
    //   435: iload #5
    //   437: iload #6
    //   439: if_icmpge -> 590
    //   442: aload_0
    //   443: iload #5
    //   445: invokevirtual getChildAt : (I)Landroid/view/View;
    //   448: astore #17
    //   450: aload #17
    //   452: invokevirtual getVisibility : ()I
    //   455: bipush #8
    //   457: if_icmpeq -> 584
    //   460: aload #17
    //   462: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   465: checkcast android/support/v4/view/ViewPager$LayoutParams
    //   468: astore #13
    //   470: aload #13
    //   472: getfield isDecor : Z
    //   475: ifne -> 584
    //   478: aload_0
    //   479: aload #17
    //   481: invokevirtual infoForChild : (Landroid/view/View;)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   484: astore #12
    //   486: aload #12
    //   488: ifnull -> 584
    //   491: iload #15
    //   493: i2f
    //   494: fstore #18
    //   496: aload #12
    //   498: getfield offset : F
    //   501: fload #18
    //   503: fmul
    //   504: f2i
    //   505: iload_2
    //   506: iadd
    //   507: istore #14
    //   509: aload #13
    //   511: getfield needsMeasure : Z
    //   514: ifeq -> 561
    //   517: aload #13
    //   519: iconst_0
    //   520: putfield needsMeasure : Z
    //   523: iload #15
    //   525: i2f
    //   526: fstore #18
    //   528: aload #17
    //   530: aload #13
    //   532: getfield widthFactor : F
    //   535: fload #18
    //   537: fmul
    //   538: f2i
    //   539: ldc_w 1073741824
    //   542: invokestatic makeMeasureSpec : (II)I
    //   545: iload #8
    //   547: iload_3
    //   548: isub
    //   549: iload #4
    //   551: isub
    //   552: ldc_w 1073741824
    //   555: invokestatic makeMeasureSpec : (II)I
    //   558: invokevirtual measure : (II)V
    //   561: aload #17
    //   563: iload #14
    //   565: iload_3
    //   566: aload #17
    //   568: invokevirtual getMeasuredWidth : ()I
    //   571: iload #14
    //   573: iadd
    //   574: aload #17
    //   576: invokevirtual getMeasuredHeight : ()I
    //   579: iload_3
    //   580: iadd
    //   581: invokevirtual layout : (IIII)V
    //   584: iinc #5, 1
    //   587: goto -> 435
    //   590: aload_0
    //   591: iload_3
    //   592: putfield mTopPageBounds : I
    //   595: aload_0
    //   596: iload #8
    //   598: iload #4
    //   600: isub
    //   601: putfield mBottomPageBounds : I
    //   604: aload_0
    //   605: iload #10
    //   607: putfield mDecorChildCount : I
    //   610: aload_0
    //   611: getfield mFirstLayout : Z
    //   614: ifeq -> 628
    //   617: aload_0
    //   618: aload_0
    //   619: getfield mCurItem : I
    //   622: iconst_0
    //   623: iconst_0
    //   624: iconst_0
    //   625: invokespecial scrollToItem : (IZIZ)V
    //   628: aload_0
    //   629: iconst_0
    //   630: putfield mFirstLayout : Z
    //   633: return
    //   634: iload #4
    //   636: istore #14
    //   638: iload_2
    //   639: istore #4
    //   641: iload #5
    //   643: istore_2
    //   644: iload_3
    //   645: istore #15
    //   647: iload #10
    //   649: istore #5
    //   651: iload #14
    //   653: istore_3
    //   654: goto -> 245
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
    //   18: istore_1
    //   19: aload_0
    //   20: iload_1
    //   21: bipush #10
    //   23: idiv
    //   24: aload_0
    //   25: getfield mDefaultGutterSize : I
    //   28: invokestatic min : (II)I
    //   31: putfield mGutterSize : I
    //   34: iload_1
    //   35: aload_0
    //   36: invokevirtual getPaddingLeft : ()I
    //   39: isub
    //   40: aload_0
    //   41: invokevirtual getPaddingRight : ()I
    //   44: isub
    //   45: istore_1
    //   46: aload_0
    //   47: invokevirtual getMeasuredHeight : ()I
    //   50: aload_0
    //   51: invokevirtual getPaddingTop : ()I
    //   54: isub
    //   55: aload_0
    //   56: invokevirtual getPaddingBottom : ()I
    //   59: isub
    //   60: istore_2
    //   61: aload_0
    //   62: invokevirtual getChildCount : ()I
    //   65: istore_3
    //   66: iconst_0
    //   67: istore #4
    //   69: iload #4
    //   71: iload_3
    //   72: if_icmpge -> 387
    //   75: aload_0
    //   76: iload #4
    //   78: invokevirtual getChildAt : (I)Landroid/view/View;
    //   81: astore #5
    //   83: iload_1
    //   84: istore #6
    //   86: iload_2
    //   87: istore #7
    //   89: aload #5
    //   91: invokevirtual getVisibility : ()I
    //   94: bipush #8
    //   96: if_icmpeq -> 316
    //   99: aload #5
    //   101: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   104: checkcast android/support/v4/view/ViewPager$LayoutParams
    //   107: astore #8
    //   109: iload_1
    //   110: istore #6
    //   112: iload_2
    //   113: istore #7
    //   115: aload #8
    //   117: ifnull -> 316
    //   120: iload_1
    //   121: istore #6
    //   123: iload_2
    //   124: istore #7
    //   126: aload #8
    //   128: getfield isDecor : Z
    //   131: ifeq -> 316
    //   134: aload #8
    //   136: getfield gravity : I
    //   139: bipush #7
    //   141: iand
    //   142: istore #7
    //   144: aload #8
    //   146: getfield gravity : I
    //   149: bipush #112
    //   151: iand
    //   152: istore #9
    //   154: ldc_w -2147483648
    //   157: istore #10
    //   159: ldc_w -2147483648
    //   162: istore #6
    //   164: iload #9
    //   166: bipush #48
    //   168: if_icmpeq -> 178
    //   171: iload #9
    //   173: bipush #80
    //   175: if_icmpne -> 328
    //   178: iconst_1
    //   179: istore #9
    //   181: iload #7
    //   183: iconst_3
    //   184: if_icmpeq -> 193
    //   187: iload #7
    //   189: iconst_5
    //   190: if_icmpne -> 334
    //   193: iconst_1
    //   194: istore #11
    //   196: iload #9
    //   198: ifeq -> 340
    //   201: ldc_w 1073741824
    //   204: istore #7
    //   206: aload #8
    //   208: getfield width : I
    //   211: bipush #-2
    //   213: if_icmpeq -> 523
    //   216: ldc_w 1073741824
    //   219: istore #10
    //   221: aload #8
    //   223: getfield width : I
    //   226: iconst_m1
    //   227: if_icmpeq -> 517
    //   230: aload #8
    //   232: getfield width : I
    //   235: istore #7
    //   237: aload #8
    //   239: getfield height : I
    //   242: bipush #-2
    //   244: if_icmpeq -> 511
    //   247: ldc_w 1073741824
    //   250: istore #12
    //   252: iload #12
    //   254: istore #6
    //   256: aload #8
    //   258: getfield height : I
    //   261: iconst_m1
    //   262: if_icmpeq -> 511
    //   265: aload #8
    //   267: getfield height : I
    //   270: istore #13
    //   272: iload #12
    //   274: istore #6
    //   276: iload #13
    //   278: istore #12
    //   280: aload #5
    //   282: iload #7
    //   284: iload #10
    //   286: invokestatic makeMeasureSpec : (II)I
    //   289: iload #12
    //   291: iload #6
    //   293: invokestatic makeMeasureSpec : (II)I
    //   296: invokevirtual measure : (II)V
    //   299: iload #9
    //   301: ifeq -> 361
    //   304: iload_2
    //   305: aload #5
    //   307: invokevirtual getMeasuredHeight : ()I
    //   310: isub
    //   311: istore #7
    //   313: iload_1
    //   314: istore #6
    //   316: iinc #4, 1
    //   319: iload #6
    //   321: istore_1
    //   322: iload #7
    //   324: istore_2
    //   325: goto -> 69
    //   328: iconst_0
    //   329: istore #9
    //   331: goto -> 181
    //   334: iconst_0
    //   335: istore #11
    //   337: goto -> 196
    //   340: iload #10
    //   342: istore #7
    //   344: iload #11
    //   346: ifeq -> 206
    //   349: ldc_w 1073741824
    //   352: istore #6
    //   354: iload #10
    //   356: istore #7
    //   358: goto -> 206
    //   361: iload_1
    //   362: istore #6
    //   364: iload_2
    //   365: istore #7
    //   367: iload #11
    //   369: ifeq -> 316
    //   372: iload_1
    //   373: aload #5
    //   375: invokevirtual getMeasuredWidth : ()I
    //   378: isub
    //   379: istore #6
    //   381: iload_2
    //   382: istore #7
    //   384: goto -> 316
    //   387: aload_0
    //   388: iload_1
    //   389: ldc_w 1073741824
    //   392: invokestatic makeMeasureSpec : (II)I
    //   395: putfield mChildWidthMeasureSpec : I
    //   398: aload_0
    //   399: iload_2
    //   400: ldc_w 1073741824
    //   403: invokestatic makeMeasureSpec : (II)I
    //   406: putfield mChildHeightMeasureSpec : I
    //   409: aload_0
    //   410: iconst_1
    //   411: putfield mInLayout : Z
    //   414: aload_0
    //   415: invokevirtual populate : ()V
    //   418: aload_0
    //   419: iconst_0
    //   420: putfield mInLayout : Z
    //   423: aload_0
    //   424: invokevirtual getChildCount : ()I
    //   427: istore #7
    //   429: iconst_0
    //   430: istore_2
    //   431: iload_2
    //   432: iload #7
    //   434: if_icmpge -> 533
    //   437: aload_0
    //   438: iload_2
    //   439: invokevirtual getChildAt : (I)Landroid/view/View;
    //   442: astore #5
    //   444: aload #5
    //   446: invokevirtual getVisibility : ()I
    //   449: bipush #8
    //   451: if_icmpeq -> 505
    //   454: aload #5
    //   456: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   459: checkcast android/support/v4/view/ViewPager$LayoutParams
    //   462: astore #8
    //   464: aload #8
    //   466: ifnull -> 477
    //   469: aload #8
    //   471: getfield isDecor : Z
    //   474: ifne -> 505
    //   477: iload_1
    //   478: i2f
    //   479: fstore #14
    //   481: aload #5
    //   483: aload #8
    //   485: getfield widthFactor : F
    //   488: fload #14
    //   490: fmul
    //   491: f2i
    //   492: ldc_w 1073741824
    //   495: invokestatic makeMeasureSpec : (II)I
    //   498: aload_0
    //   499: getfield mChildHeightMeasureSpec : I
    //   502: invokevirtual measure : (II)V
    //   505: iinc #2, 1
    //   508: goto -> 431
    //   511: iload_2
    //   512: istore #12
    //   514: goto -> 280
    //   517: iload_1
    //   518: istore #7
    //   520: goto -> 237
    //   523: iload #7
    //   525: istore #10
    //   527: iload_1
    //   528: istore #7
    //   530: goto -> 237
    //   533: return
  }
  
  @CallSuper
  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mDecorChildCount : I
    //   4: ifle -> 259
    //   7: aload_0
    //   8: invokevirtual getScrollX : ()I
    //   11: istore #4
    //   13: aload_0
    //   14: invokevirtual getPaddingLeft : ()I
    //   17: istore #5
    //   19: aload_0
    //   20: invokevirtual getPaddingRight : ()I
    //   23: istore #6
    //   25: aload_0
    //   26: invokevirtual getWidth : ()I
    //   29: istore #7
    //   31: aload_0
    //   32: invokevirtual getChildCount : ()I
    //   35: istore #8
    //   37: iconst_0
    //   38: istore #9
    //   40: iload #9
    //   42: iload #8
    //   44: if_icmpge -> 259
    //   47: aload_0
    //   48: iload #9
    //   50: invokevirtual getChildAt : (I)Landroid/view/View;
    //   53: astore #10
    //   55: aload #10
    //   57: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   60: checkcast android/support/v4/view/ViewPager$LayoutParams
    //   63: astore #11
    //   65: aload #11
    //   67: getfield isDecor : Z
    //   70: ifne -> 87
    //   73: iload #6
    //   75: istore #12
    //   77: iinc #9, 1
    //   80: iload #12
    //   82: istore #6
    //   84: goto -> 40
    //   87: aload #11
    //   89: getfield gravity : I
    //   92: bipush #7
    //   94: iand
    //   95: tableswitch default -> 128, 1 -> 189, 2 -> 128, 3 -> 176, 4 -> 128, 5 -> 217
    //   128: iload #5
    //   130: istore #13
    //   132: iload #5
    //   134: iload #4
    //   136: iadd
    //   137: aload #10
    //   139: invokevirtual getLeft : ()I
    //   142: isub
    //   143: istore #14
    //   145: iload #6
    //   147: istore #12
    //   149: iload #13
    //   151: istore #5
    //   153: iload #14
    //   155: ifeq -> 77
    //   158: aload #10
    //   160: iload #14
    //   162: invokevirtual offsetLeftAndRight : (I)V
    //   165: iload #6
    //   167: istore #12
    //   169: iload #13
    //   171: istore #5
    //   173: goto -> 77
    //   176: aload #10
    //   178: invokevirtual getWidth : ()I
    //   181: iload #5
    //   183: iadd
    //   184: istore #13
    //   186: goto -> 132
    //   189: iload #7
    //   191: aload #10
    //   193: invokevirtual getMeasuredWidth : ()I
    //   196: isub
    //   197: iconst_2
    //   198: idiv
    //   199: iload #5
    //   201: invokestatic max : (II)I
    //   204: istore #12
    //   206: iload #5
    //   208: istore #13
    //   210: iload #12
    //   212: istore #5
    //   214: goto -> 132
    //   217: aload #10
    //   219: invokevirtual getMeasuredWidth : ()I
    //   222: istore #12
    //   224: aload #10
    //   226: invokevirtual getMeasuredWidth : ()I
    //   229: istore #13
    //   231: iload #7
    //   233: iload #6
    //   235: isub
    //   236: iload #12
    //   238: isub
    //   239: istore #12
    //   241: iload #6
    //   243: iload #13
    //   245: iadd
    //   246: istore #6
    //   248: iload #5
    //   250: istore #13
    //   252: iload #12
    //   254: istore #5
    //   256: goto -> 132
    //   259: aload_0
    //   260: iload_1
    //   261: fload_2
    //   262: iload_3
    //   263: invokespecial dispatchOnPageScrolled : (IFI)V
    //   266: aload_0
    //   267: getfield mPageTransformer : Landroid/support/v4/view/ViewPager$PageTransformer;
    //   270: ifnull -> 349
    //   273: aload_0
    //   274: invokevirtual getScrollX : ()I
    //   277: istore #5
    //   279: aload_0
    //   280: invokevirtual getChildCount : ()I
    //   283: istore_3
    //   284: iconst_0
    //   285: istore_1
    //   286: iload_1
    //   287: iload_3
    //   288: if_icmpge -> 349
    //   291: aload_0
    //   292: iload_1
    //   293: invokevirtual getChildAt : (I)Landroid/view/View;
    //   296: astore #10
    //   298: aload #10
    //   300: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   303: checkcast android/support/v4/view/ViewPager$LayoutParams
    //   306: getfield isDecor : Z
    //   309: ifeq -> 318
    //   312: iinc #1, 1
    //   315: goto -> 286
    //   318: aload #10
    //   320: invokevirtual getLeft : ()I
    //   323: iload #5
    //   325: isub
    //   326: i2f
    //   327: aload_0
    //   328: invokespecial getClientWidth : ()I
    //   331: i2f
    //   332: fdiv
    //   333: fstore_2
    //   334: aload_0
    //   335: getfield mPageTransformer : Landroid/support/v4/view/ViewPager$PageTransformer;
    //   338: aload #10
    //   340: fload_2
    //   341: invokeinterface transformPage : (Landroid/view/View;F)V
    //   346: goto -> 312
    //   349: aload_0
    //   350: iconst_1
    //   351: putfield mCalledSuper : Z
    //   354: return
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_m1
    //   3: istore #4
    //   5: aload_0
    //   6: invokevirtual getChildCount : ()I
    //   9: istore #5
    //   11: iload_1
    //   12: iconst_2
    //   13: iand
    //   14: ifeq -> 87
    //   17: iload #5
    //   19: istore #4
    //   21: iconst_1
    //   22: istore #6
    //   24: iconst_0
    //   25: istore #5
    //   27: iload #5
    //   29: iload #4
    //   31: if_icmpeq -> 106
    //   34: aload_0
    //   35: iload #5
    //   37: invokevirtual getChildAt : (I)Landroid/view/View;
    //   40: astore #7
    //   42: aload #7
    //   44: invokevirtual getVisibility : ()I
    //   47: ifne -> 96
    //   50: aload_0
    //   51: aload #7
    //   53: invokevirtual infoForChild : (Landroid/view/View;)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   56: astore #8
    //   58: aload #8
    //   60: ifnull -> 96
    //   63: aload #8
    //   65: getfield position : I
    //   68: aload_0
    //   69: getfield mCurItem : I
    //   72: if_icmpne -> 96
    //   75: aload #7
    //   77: iload_1
    //   78: aload_2
    //   79: invokevirtual requestFocus : (ILandroid/graphics/Rect;)Z
    //   82: ifeq -> 96
    //   85: iload_3
    //   86: ireturn
    //   87: iinc #5, -1
    //   90: iconst_m1
    //   91: istore #6
    //   93: goto -> 27
    //   96: iload #5
    //   98: iload #6
    //   100: iadd
    //   101: istore #5
    //   103: goto -> 27
    //   106: iconst_0
    //   107: istore_3
    //   108: goto -> 85
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    paramParcelable = paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.mAdapter != null) {
      this.mAdapter.restoreState(((SavedState)paramParcelable).adapterState, ((SavedState)paramParcelable).loader);
      setCurrentItemInternal(((SavedState)paramParcelable).position, false, true);
      return;
    } 
    this.mRestoredCurItem = ((SavedState)paramParcelable).position;
    this.mRestoredAdapterState = ((SavedState)paramParcelable).adapterState;
    this.mRestoredClassLoader = ((SavedState)paramParcelable).loader;
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.position = this.mCurItem;
    if (this.mAdapter != null)
      savedState.adapterState = this.mAdapter.saveState(); 
    return savedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
      recomputeScrollPosition(paramInt1, paramInt3, this.mPageMargin, this.mPageMargin); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield mFakeDragging : Z
    //   6: ifeq -> 13
    //   9: iconst_1
    //   10: istore_3
    //   11: iload_3
    //   12: ireturn
    //   13: aload_1
    //   14: invokevirtual getAction : ()I
    //   17: ifne -> 32
    //   20: aload_1
    //   21: invokevirtual getEdgeFlags : ()I
    //   24: ifeq -> 32
    //   27: iconst_0
    //   28: istore_3
    //   29: goto -> 11
    //   32: aload_0
    //   33: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   36: ifnull -> 49
    //   39: aload_0
    //   40: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   43: invokevirtual getCount : ()I
    //   46: ifne -> 54
    //   49: iconst_0
    //   50: istore_3
    //   51: goto -> 11
    //   54: aload_0
    //   55: getfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   58: ifnonnull -> 68
    //   61: aload_0
    //   62: invokestatic obtain : ()Landroid/view/VelocityTracker;
    //   65: putfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   68: aload_0
    //   69: getfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   72: aload_1
    //   73: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   76: iload_2
    //   77: istore_3
    //   78: aload_1
    //   79: invokevirtual getAction : ()I
    //   82: sipush #255
    //   85: iand
    //   86: tableswitch default -> 128, 0 -> 143, 1 -> 420, 2 -> 209, 3 -> 561, 4 -> 130, 5 -> 589, 6 -> 620
    //   128: iload_2
    //   129: istore_3
    //   130: iload_3
    //   131: ifeq -> 138
    //   134: aload_0
    //   135: invokestatic postInvalidateOnAnimation : (Landroid/view/View;)V
    //   138: iconst_1
    //   139: istore_3
    //   140: goto -> 11
    //   143: aload_0
    //   144: getfield mScroller : Landroid/widget/Scroller;
    //   147: invokevirtual abortAnimation : ()V
    //   150: aload_0
    //   151: iconst_0
    //   152: putfield mPopulatePending : Z
    //   155: aload_0
    //   156: invokevirtual populate : ()V
    //   159: aload_1
    //   160: invokevirtual getX : ()F
    //   163: fstore #4
    //   165: aload_0
    //   166: fload #4
    //   168: putfield mInitialMotionX : F
    //   171: aload_0
    //   172: fload #4
    //   174: putfield mLastMotionX : F
    //   177: aload_1
    //   178: invokevirtual getY : ()F
    //   181: fstore #4
    //   183: aload_0
    //   184: fload #4
    //   186: putfield mInitialMotionY : F
    //   189: aload_0
    //   190: fload #4
    //   192: putfield mLastMotionY : F
    //   195: aload_0
    //   196: aload_1
    //   197: iconst_0
    //   198: invokevirtual getPointerId : (I)I
    //   201: putfield mActivePointerId : I
    //   204: iload_2
    //   205: istore_3
    //   206: goto -> 130
    //   209: aload_0
    //   210: getfield mIsBeingDragged : Z
    //   213: ifne -> 374
    //   216: aload_1
    //   217: aload_0
    //   218: getfield mActivePointerId : I
    //   221: invokevirtual findPointerIndex : (I)I
    //   224: istore #5
    //   226: iload #5
    //   228: iconst_m1
    //   229: if_icmpne -> 240
    //   232: aload_0
    //   233: invokespecial resetTouch : ()Z
    //   236: istore_3
    //   237: goto -> 130
    //   240: aload_1
    //   241: iload #5
    //   243: invokevirtual getX : (I)F
    //   246: fstore #6
    //   248: fload #6
    //   250: aload_0
    //   251: getfield mLastMotionX : F
    //   254: fsub
    //   255: invokestatic abs : (F)F
    //   258: fstore #4
    //   260: aload_1
    //   261: iload #5
    //   263: invokevirtual getY : (I)F
    //   266: fstore #7
    //   268: fload #7
    //   270: aload_0
    //   271: getfield mLastMotionY : F
    //   274: fsub
    //   275: invokestatic abs : (F)F
    //   278: fstore #8
    //   280: fload #4
    //   282: aload_0
    //   283: getfield mTouchSlop : I
    //   286: i2f
    //   287: fcmpl
    //   288: ifle -> 374
    //   291: fload #4
    //   293: fload #8
    //   295: fcmpl
    //   296: ifle -> 374
    //   299: aload_0
    //   300: iconst_1
    //   301: putfield mIsBeingDragged : Z
    //   304: aload_0
    //   305: iconst_1
    //   306: invokespecial requestParentDisallowInterceptTouchEvent : (Z)V
    //   309: fload #6
    //   311: aload_0
    //   312: getfield mInitialMotionX : F
    //   315: fsub
    //   316: fconst_0
    //   317: fcmpl
    //   318: ifle -> 405
    //   321: aload_0
    //   322: getfield mInitialMotionX : F
    //   325: aload_0
    //   326: getfield mTouchSlop : I
    //   329: i2f
    //   330: fadd
    //   331: fstore #4
    //   333: aload_0
    //   334: fload #4
    //   336: putfield mLastMotionX : F
    //   339: aload_0
    //   340: fload #7
    //   342: putfield mLastMotionY : F
    //   345: aload_0
    //   346: iconst_1
    //   347: invokevirtual setScrollState : (I)V
    //   350: aload_0
    //   351: iconst_1
    //   352: invokespecial setScrollingCacheEnabled : (Z)V
    //   355: aload_0
    //   356: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   359: astore #9
    //   361: aload #9
    //   363: ifnull -> 374
    //   366: aload #9
    //   368: iconst_1
    //   369: invokeinterface requestDisallowInterceptTouchEvent : (Z)V
    //   374: iload_2
    //   375: istore_3
    //   376: aload_0
    //   377: getfield mIsBeingDragged : Z
    //   380: ifeq -> 130
    //   383: aload_0
    //   384: aload_1
    //   385: aload_1
    //   386: aload_0
    //   387: getfield mActivePointerId : I
    //   390: invokevirtual findPointerIndex : (I)I
    //   393: invokevirtual getX : (I)F
    //   396: invokespecial performDrag : (F)Z
    //   399: iconst_0
    //   400: ior
    //   401: istore_3
    //   402: goto -> 130
    //   405: aload_0
    //   406: getfield mInitialMotionX : F
    //   409: aload_0
    //   410: getfield mTouchSlop : I
    //   413: i2f
    //   414: fsub
    //   415: fstore #4
    //   417: goto -> 333
    //   420: iload_2
    //   421: istore_3
    //   422: aload_0
    //   423: getfield mIsBeingDragged : Z
    //   426: ifeq -> 130
    //   429: aload_0
    //   430: getfield mVelocityTracker : Landroid/view/VelocityTracker;
    //   433: astore #9
    //   435: aload #9
    //   437: sipush #1000
    //   440: aload_0
    //   441: getfield mMaximumVelocity : I
    //   444: i2f
    //   445: invokevirtual computeCurrentVelocity : (IF)V
    //   448: aload #9
    //   450: aload_0
    //   451: getfield mActivePointerId : I
    //   454: invokestatic getXVelocity : (Landroid/view/VelocityTracker;I)F
    //   457: f2i
    //   458: istore #5
    //   460: aload_0
    //   461: iconst_1
    //   462: putfield mPopulatePending : Z
    //   465: aload_0
    //   466: invokespecial getClientWidth : ()I
    //   469: istore #10
    //   471: aload_0
    //   472: invokevirtual getScrollX : ()I
    //   475: istore #11
    //   477: aload_0
    //   478: invokespecial infoForCurrentScrollPosition : ()Landroid/support/v4/view/ViewPager$ItemInfo;
    //   481: astore #9
    //   483: aload_0
    //   484: getfield mPageMargin : I
    //   487: i2f
    //   488: iload #10
    //   490: i2f
    //   491: fdiv
    //   492: fstore #4
    //   494: aload_0
    //   495: aload_0
    //   496: aload #9
    //   498: getfield position : I
    //   501: iload #11
    //   503: i2f
    //   504: iload #10
    //   506: i2f
    //   507: fdiv
    //   508: aload #9
    //   510: getfield offset : F
    //   513: fsub
    //   514: aload #9
    //   516: getfield widthFactor : F
    //   519: fload #4
    //   521: fadd
    //   522: fdiv
    //   523: iload #5
    //   525: aload_1
    //   526: aload_1
    //   527: aload_0
    //   528: getfield mActivePointerId : I
    //   531: invokevirtual findPointerIndex : (I)I
    //   534: invokevirtual getX : (I)F
    //   537: aload_0
    //   538: getfield mInitialMotionX : F
    //   541: fsub
    //   542: f2i
    //   543: invokespecial determineTargetPage : (IFII)I
    //   546: iconst_1
    //   547: iconst_1
    //   548: iload #5
    //   550: invokevirtual setCurrentItemInternal : (IZZI)V
    //   553: aload_0
    //   554: invokespecial resetTouch : ()Z
    //   557: istore_3
    //   558: goto -> 130
    //   561: iload_2
    //   562: istore_3
    //   563: aload_0
    //   564: getfield mIsBeingDragged : Z
    //   567: ifeq -> 130
    //   570: aload_0
    //   571: aload_0
    //   572: getfield mCurItem : I
    //   575: iconst_1
    //   576: iconst_0
    //   577: iconst_0
    //   578: invokespecial scrollToItem : (IZIZ)V
    //   581: aload_0
    //   582: invokespecial resetTouch : ()Z
    //   585: istore_3
    //   586: goto -> 130
    //   589: aload_1
    //   590: invokestatic getActionIndex : (Landroid/view/MotionEvent;)I
    //   593: istore #5
    //   595: aload_0
    //   596: aload_1
    //   597: iload #5
    //   599: invokevirtual getX : (I)F
    //   602: putfield mLastMotionX : F
    //   605: aload_0
    //   606: aload_1
    //   607: iload #5
    //   609: invokevirtual getPointerId : (I)I
    //   612: putfield mActivePointerId : I
    //   615: iload_2
    //   616: istore_3
    //   617: goto -> 130
    //   620: aload_0
    //   621: aload_1
    //   622: invokespecial onSecondaryPointerUp : (Landroid/view/MotionEvent;)V
    //   625: aload_0
    //   626: aload_1
    //   627: aload_1
    //   628: aload_0
    //   629: getfield mActivePointerId : I
    //   632: invokevirtual findPointerIndex : (I)I
    //   635: invokevirtual getX : (I)F
    //   638: putfield mLastMotionX : F
    //   641: iload_2
    //   642: istore_3
    //   643: goto -> 130
  }
  
  boolean pageLeft() {
    null = true;
    if (this.mCurItem > 0) {
      setCurrentItem(this.mCurItem - 1, true);
      return null;
    } 
    return false;
  }
  
  boolean pageRight() {
    null = true;
    if (this.mAdapter != null && this.mCurItem < this.mAdapter.getCount() - 1) {
      setCurrentItem(this.mCurItem + 1, true);
      return null;
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
    //   5: if_icmpeq -> 1237
    //   8: aload_0
    //   9: aload_0
    //   10: getfield mCurItem : I
    //   13: invokevirtual infoForPosition : (I)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   16: astore_2
    //   17: aload_0
    //   18: iload_1
    //   19: putfield mCurItem : I
    //   22: aload_0
    //   23: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   26: ifnonnull -> 34
    //   29: aload_0
    //   30: invokespecial sortChildDrawingOrder : ()V
    //   33: return
    //   34: aload_0
    //   35: getfield mPopulatePending : Z
    //   38: ifeq -> 48
    //   41: aload_0
    //   42: invokespecial sortChildDrawingOrder : ()V
    //   45: goto -> 33
    //   48: aload_0
    //   49: invokevirtual getWindowToken : ()Landroid/os/IBinder;
    //   52: ifnull -> 33
    //   55: aload_0
    //   56: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   59: aload_0
    //   60: invokevirtual startUpdate : (Landroid/view/ViewGroup;)V
    //   63: aload_0
    //   64: getfield mOffscreenPageLimit : I
    //   67: istore_1
    //   68: iconst_0
    //   69: aload_0
    //   70: getfield mCurItem : I
    //   73: iload_1
    //   74: isub
    //   75: invokestatic max : (II)I
    //   78: istore_3
    //   79: aload_0
    //   80: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   83: invokevirtual getCount : ()I
    //   86: istore #4
    //   88: iload #4
    //   90: iconst_1
    //   91: isub
    //   92: iload_1
    //   93: aload_0
    //   94: getfield mCurItem : I
    //   97: iadd
    //   98: invokestatic min : (II)I
    //   101: istore #5
    //   103: iload #4
    //   105: aload_0
    //   106: getfield mExpectedAdapterCount : I
    //   109: if_icmpeq -> 221
    //   112: aload_0
    //   113: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   116: aload_0
    //   117: invokevirtual getId : ()I
    //   120: invokevirtual getResourceName : (I)Ljava/lang/String;
    //   123: astore #6
    //   125: new java/lang/IllegalStateException
    //   128: dup
    //   129: new java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial <init> : ()V
    //   136: ldc_w 'The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: '
    //   139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_0
    //   143: getfield mExpectedAdapterCount : I
    //   146: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   149: ldc_w ', found: '
    //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: iload #4
    //   157: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   160: ldc_w ' Pager id: '
    //   163: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload #6
    //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc_w ' Pager class: '
    //   174: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: invokevirtual getClass : ()Ljava/lang/Class;
    //   181: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   184: ldc_w ' Problematic adapter: '
    //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_0
    //   191: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   194: invokevirtual getClass : ()Ljava/lang/Class;
    //   197: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   200: invokevirtual toString : ()Ljava/lang/String;
    //   203: invokespecial <init> : (Ljava/lang/String;)V
    //   206: athrow
    //   207: astore #6
    //   209: aload_0
    //   210: invokevirtual getId : ()I
    //   213: invokestatic toHexString : (I)Ljava/lang/String;
    //   216: astore #6
    //   218: goto -> 125
    //   221: iconst_0
    //   222: istore_1
    //   223: iload_1
    //   224: aload_0
    //   225: getfield mItems : Ljava/util/ArrayList;
    //   228: invokevirtual size : ()I
    //   231: if_icmpge -> 1231
    //   234: aload_0
    //   235: getfield mItems : Ljava/util/ArrayList;
    //   238: iload_1
    //   239: invokevirtual get : (I)Ljava/lang/Object;
    //   242: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   245: astore #6
    //   247: aload #6
    //   249: getfield position : I
    //   252: aload_0
    //   253: getfield mCurItem : I
    //   256: if_icmplt -> 593
    //   259: aload #6
    //   261: getfield position : I
    //   264: aload_0
    //   265: getfield mCurItem : I
    //   268: if_icmpne -> 1231
    //   271: aload #6
    //   273: ifnonnull -> 1224
    //   276: iload #4
    //   278: ifle -> 1224
    //   281: aload_0
    //   282: aload_0
    //   283: getfield mCurItem : I
    //   286: iload_1
    //   287: invokevirtual addNewItem : (II)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   290: astore #7
    //   292: aload #7
    //   294: ifnull -> 468
    //   297: iload_1
    //   298: iconst_1
    //   299: isub
    //   300: istore #8
    //   302: iload #8
    //   304: iflt -> 599
    //   307: aload_0
    //   308: getfield mItems : Ljava/util/ArrayList;
    //   311: iload #8
    //   313: invokevirtual get : (I)Ljava/lang/Object;
    //   316: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   319: astore #6
    //   321: aload_0
    //   322: invokespecial getClientWidth : ()I
    //   325: istore #9
    //   327: iload #9
    //   329: ifgt -> 605
    //   332: fconst_0
    //   333: fstore #10
    //   335: aload_0
    //   336: getfield mCurItem : I
    //   339: istore #11
    //   341: fconst_0
    //   342: fstore #12
    //   344: iinc #11, -1
    //   347: iload #11
    //   349: iflt -> 371
    //   352: fload #12
    //   354: fload #10
    //   356: fcmpl
    //   357: iflt -> 740
    //   360: iload #11
    //   362: iload_3
    //   363: if_icmpge -> 740
    //   366: aload #6
    //   368: ifnonnull -> 627
    //   371: aload #7
    //   373: getfield widthFactor : F
    //   376: fstore #12
    //   378: iload_1
    //   379: iconst_1
    //   380: iadd
    //   381: istore #8
    //   383: fload #12
    //   385: fconst_2
    //   386: fcmpg
    //   387: ifge -> 460
    //   390: iload #8
    //   392: aload_0
    //   393: getfield mItems : Ljava/util/ArrayList;
    //   396: invokevirtual size : ()I
    //   399: if_icmpge -> 876
    //   402: aload_0
    //   403: getfield mItems : Ljava/util/ArrayList;
    //   406: iload #8
    //   408: invokevirtual get : (I)Ljava/lang/Object;
    //   411: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   414: astore #6
    //   416: iload #9
    //   418: ifgt -> 882
    //   421: fconst_0
    //   422: fstore #10
    //   424: aload_0
    //   425: getfield mCurItem : I
    //   428: istore #11
    //   430: iinc #11, 1
    //   433: iload #11
    //   435: iload #4
    //   437: if_icmpge -> 460
    //   440: fload #12
    //   442: fload #10
    //   444: fcmpl
    //   445: iflt -> 979
    //   448: iload #11
    //   450: iload #5
    //   452: if_icmple -> 979
    //   455: aload #6
    //   457: ifnonnull -> 898
    //   460: aload_0
    //   461: aload #7
    //   463: iload_1
    //   464: aload_2
    //   465: invokespecial calculatePageOffsets : (Landroid/support/v4/view/ViewPager$ItemInfo;ILandroid/support/v4/view/ViewPager$ItemInfo;)V
    //   468: aload_0
    //   469: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   472: astore_2
    //   473: aload_0
    //   474: getfield mCurItem : I
    //   477: istore_1
    //   478: aload #7
    //   480: ifnull -> 1108
    //   483: aload #7
    //   485: getfield object : Ljava/lang/Object;
    //   488: astore #6
    //   490: aload_2
    //   491: aload_0
    //   492: iload_1
    //   493: aload #6
    //   495: invokevirtual setPrimaryItem : (Landroid/view/ViewGroup;ILjava/lang/Object;)V
    //   498: aload_0
    //   499: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   502: aload_0
    //   503: invokevirtual finishUpdate : (Landroid/view/ViewGroup;)V
    //   506: aload_0
    //   507: invokevirtual getChildCount : ()I
    //   510: istore #8
    //   512: iconst_0
    //   513: istore_1
    //   514: iload_1
    //   515: iload #8
    //   517: if_icmpge -> 1114
    //   520: aload_0
    //   521: iload_1
    //   522: invokevirtual getChildAt : (I)Landroid/view/View;
    //   525: astore_2
    //   526: aload_2
    //   527: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   530: checkcast android/support/v4/view/ViewPager$LayoutParams
    //   533: astore #6
    //   535: aload #6
    //   537: iload_1
    //   538: putfield childIndex : I
    //   541: aload #6
    //   543: getfield isDecor : Z
    //   546: ifne -> 587
    //   549: aload #6
    //   551: getfield widthFactor : F
    //   554: fconst_0
    //   555: fcmpl
    //   556: ifne -> 587
    //   559: aload_0
    //   560: aload_2
    //   561: invokevirtual infoForChild : (Landroid/view/View;)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   564: astore_2
    //   565: aload_2
    //   566: ifnull -> 587
    //   569: aload #6
    //   571: aload_2
    //   572: getfield widthFactor : F
    //   575: putfield widthFactor : F
    //   578: aload #6
    //   580: aload_2
    //   581: getfield position : I
    //   584: putfield position : I
    //   587: iinc #1, 1
    //   590: goto -> 514
    //   593: iinc #1, 1
    //   596: goto -> 223
    //   599: aconst_null
    //   600: astore #6
    //   602: goto -> 321
    //   605: fconst_2
    //   606: aload #7
    //   608: getfield widthFactor : F
    //   611: fsub
    //   612: aload_0
    //   613: invokevirtual getPaddingLeft : ()I
    //   616: i2f
    //   617: iload #9
    //   619: i2f
    //   620: fdiv
    //   621: fadd
    //   622: fstore #10
    //   624: goto -> 335
    //   627: iload #11
    //   629: aload #6
    //   631: getfield position : I
    //   634: if_icmpne -> 1242
    //   637: aload #6
    //   639: getfield scrolling : Z
    //   642: ifne -> 1242
    //   645: aload_0
    //   646: getfield mItems : Ljava/util/ArrayList;
    //   649: iload #8
    //   651: invokevirtual remove : (I)Ljava/lang/Object;
    //   654: pop
    //   655: aload_0
    //   656: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   659: aload_0
    //   660: iload #11
    //   662: aload #6
    //   664: getfield object : Ljava/lang/Object;
    //   667: invokevirtual destroyItem : (Landroid/view/ViewGroup;ILjava/lang/Object;)V
    //   670: iinc #8, -1
    //   673: iload_1
    //   674: iconst_1
    //   675: isub
    //   676: istore #13
    //   678: iload #8
    //   680: iflt -> 727
    //   683: aload_0
    //   684: getfield mItems : Ljava/util/ArrayList;
    //   687: iload #8
    //   689: invokevirtual get : (I)Ljava/lang/Object;
    //   692: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   695: astore #6
    //   697: iload #8
    //   699: istore_1
    //   700: iload #13
    //   702: istore #8
    //   704: iload #11
    //   706: iconst_1
    //   707: isub
    //   708: istore #13
    //   710: iload #8
    //   712: istore #11
    //   714: iload_1
    //   715: istore #8
    //   717: iload #11
    //   719: istore_1
    //   720: iload #13
    //   722: istore #11
    //   724: goto -> 347
    //   727: aconst_null
    //   728: astore #6
    //   730: iload #8
    //   732: istore_1
    //   733: iload #13
    //   735: istore #8
    //   737: goto -> 704
    //   740: aload #6
    //   742: ifnull -> 811
    //   745: iload #11
    //   747: aload #6
    //   749: getfield position : I
    //   752: if_icmpne -> 811
    //   755: fload #12
    //   757: aload #6
    //   759: getfield widthFactor : F
    //   762: fadd
    //   763: fstore #12
    //   765: iload #8
    //   767: iconst_1
    //   768: isub
    //   769: istore #13
    //   771: iload #13
    //   773: iflt -> 799
    //   776: aload_0
    //   777: getfield mItems : Ljava/util/ArrayList;
    //   780: iload #13
    //   782: invokevirtual get : (I)Ljava/lang/Object;
    //   785: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   788: astore #6
    //   790: iload_1
    //   791: istore #8
    //   793: iload #13
    //   795: istore_1
    //   796: goto -> 704
    //   799: iload_1
    //   800: istore #8
    //   802: aconst_null
    //   803: astore #6
    //   805: iload #13
    //   807: istore_1
    //   808: goto -> 704
    //   811: fload #12
    //   813: aload_0
    //   814: iload #11
    //   816: iload #8
    //   818: iconst_1
    //   819: iadd
    //   820: invokevirtual addNewItem : (II)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   823: getfield widthFactor : F
    //   826: fadd
    //   827: fstore #12
    //   829: iload_1
    //   830: iconst_1
    //   831: iadd
    //   832: istore #13
    //   834: iload #8
    //   836: iflt -> 863
    //   839: aload_0
    //   840: getfield mItems : Ljava/util/ArrayList;
    //   843: iload #8
    //   845: invokevirtual get : (I)Ljava/lang/Object;
    //   848: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   851: astore #6
    //   853: iload #8
    //   855: istore_1
    //   856: iload #13
    //   858: istore #8
    //   860: goto -> 704
    //   863: aconst_null
    //   864: astore #6
    //   866: iload #8
    //   868: istore_1
    //   869: iload #13
    //   871: istore #8
    //   873: goto -> 704
    //   876: aconst_null
    //   877: astore #6
    //   879: goto -> 416
    //   882: fconst_2
    //   883: aload_0
    //   884: invokevirtual getPaddingRight : ()I
    //   887: i2f
    //   888: iload #9
    //   890: i2f
    //   891: fdiv
    //   892: fadd
    //   893: fstore #10
    //   895: goto -> 424
    //   898: iload #11
    //   900: aload #6
    //   902: getfield position : I
    //   905: if_icmpne -> 1221
    //   908: aload #6
    //   910: getfield scrolling : Z
    //   913: ifne -> 1221
    //   916: aload_0
    //   917: getfield mItems : Ljava/util/ArrayList;
    //   920: iload #8
    //   922: invokevirtual remove : (I)Ljava/lang/Object;
    //   925: pop
    //   926: aload_0
    //   927: getfield mAdapter : Landroid/support/v4/view/PagerAdapter;
    //   930: aload_0
    //   931: iload #11
    //   933: aload #6
    //   935: getfield object : Ljava/lang/Object;
    //   938: invokevirtual destroyItem : (Landroid/view/ViewGroup;ILjava/lang/Object;)V
    //   941: iload #8
    //   943: aload_0
    //   944: getfield mItems : Ljava/util/ArrayList;
    //   947: invokevirtual size : ()I
    //   950: if_icmpge -> 973
    //   953: aload_0
    //   954: getfield mItems : Ljava/util/ArrayList;
    //   957: iload #8
    //   959: invokevirtual get : (I)Ljava/lang/Object;
    //   962: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   965: astore #6
    //   967: iinc #11, 1
    //   970: goto -> 433
    //   973: aconst_null
    //   974: astore #6
    //   976: goto -> 967
    //   979: aload #6
    //   981: ifnull -> 1046
    //   984: iload #11
    //   986: aload #6
    //   988: getfield position : I
    //   991: if_icmpne -> 1046
    //   994: aload #6
    //   996: getfield widthFactor : F
    //   999: fstore #14
    //   1001: iinc #8, 1
    //   1004: iload #8
    //   1006: aload_0
    //   1007: getfield mItems : Ljava/util/ArrayList;
    //   1010: invokevirtual size : ()I
    //   1013: if_icmpge -> 1040
    //   1016: aload_0
    //   1017: getfield mItems : Ljava/util/ArrayList;
    //   1020: iload #8
    //   1022: invokevirtual get : (I)Ljava/lang/Object;
    //   1025: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   1028: astore #6
    //   1030: fload #12
    //   1032: fload #14
    //   1034: fadd
    //   1035: fstore #12
    //   1037: goto -> 967
    //   1040: aconst_null
    //   1041: astore #6
    //   1043: goto -> 1030
    //   1046: aload_0
    //   1047: iload #11
    //   1049: iload #8
    //   1051: invokevirtual addNewItem : (II)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   1054: astore #6
    //   1056: iinc #8, 1
    //   1059: aload #6
    //   1061: getfield widthFactor : F
    //   1064: fstore #14
    //   1066: iload #8
    //   1068: aload_0
    //   1069: getfield mItems : Ljava/util/ArrayList;
    //   1072: invokevirtual size : ()I
    //   1075: if_icmpge -> 1102
    //   1078: aload_0
    //   1079: getfield mItems : Ljava/util/ArrayList;
    //   1082: iload #8
    //   1084: invokevirtual get : (I)Ljava/lang/Object;
    //   1087: checkcast android/support/v4/view/ViewPager$ItemInfo
    //   1090: astore #6
    //   1092: fload #12
    //   1094: fload #14
    //   1096: fadd
    //   1097: fstore #12
    //   1099: goto -> 967
    //   1102: aconst_null
    //   1103: astore #6
    //   1105: goto -> 1092
    //   1108: aconst_null
    //   1109: astore #6
    //   1111: goto -> 490
    //   1114: aload_0
    //   1115: invokespecial sortChildDrawingOrder : ()V
    //   1118: aload_0
    //   1119: invokevirtual hasFocus : ()Z
    //   1122: ifeq -> 33
    //   1125: aload_0
    //   1126: invokevirtual findFocus : ()Landroid/view/View;
    //   1129: astore #6
    //   1131: aload #6
    //   1133: ifnull -> 1215
    //   1136: aload_0
    //   1137: aload #6
    //   1139: invokevirtual infoForAnyChild : (Landroid/view/View;)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   1142: astore #6
    //   1144: aload #6
    //   1146: ifnull -> 1161
    //   1149: aload #6
    //   1151: getfield position : I
    //   1154: aload_0
    //   1155: getfield mCurItem : I
    //   1158: if_icmpeq -> 33
    //   1161: iconst_0
    //   1162: istore_1
    //   1163: iload_1
    //   1164: aload_0
    //   1165: invokevirtual getChildCount : ()I
    //   1168: if_icmpge -> 33
    //   1171: aload_0
    //   1172: iload_1
    //   1173: invokevirtual getChildAt : (I)Landroid/view/View;
    //   1176: astore #6
    //   1178: aload_0
    //   1179: aload #6
    //   1181: invokevirtual infoForChild : (Landroid/view/View;)Landroid/support/v4/view/ViewPager$ItemInfo;
    //   1184: astore_2
    //   1185: aload_2
    //   1186: ifnull -> 1209
    //   1189: aload_2
    //   1190: getfield position : I
    //   1193: aload_0
    //   1194: getfield mCurItem : I
    //   1197: if_icmpne -> 1209
    //   1200: aload #6
    //   1202: iconst_2
    //   1203: invokevirtual requestFocus : (I)Z
    //   1206: ifne -> 33
    //   1209: iinc #1, 1
    //   1212: goto -> 1163
    //   1215: aconst_null
    //   1216: astore #6
    //   1218: goto -> 1144
    //   1221: goto -> 967
    //   1224: aload #6
    //   1226: astore #7
    //   1228: goto -> 292
    //   1231: aconst_null
    //   1232: astore #6
    //   1234: goto -> 271
    //   1237: aconst_null
    //   1238: astore_2
    //   1239: goto -> 22
    //   1242: iload_1
    //   1243: istore #13
    //   1245: iload #8
    //   1247: istore_1
    //   1248: iload #13
    //   1250: istore #8
    //   1252: goto -> 704
    // Exception table:
    //   from	to	target	type
    //   112	125	207	android/content/res/Resources$NotFoundException
  }
  
  public void removeOnAdapterChangeListener(@NonNull OnAdapterChangeListener paramOnAdapterChangeListener) {
    if (this.mAdapterChangeListeners != null)
      this.mAdapterChangeListeners.remove(paramOnAdapterChangeListener); 
  }
  
  public void removeOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener) {
    if (this.mOnPageChangeListeners != null)
      this.mOnPageChangeListeners.remove(paramOnPageChangeListener); 
  }
  
  public void removeView(View paramView) {
    if (this.mInLayout) {
      removeViewInLayout(paramView);
      return;
    } 
    super.removeView(paramView);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter) {
    byte b = 0;
    if (this.mAdapter != null) {
      this.mAdapter.setViewPagerObserver(null);
      this.mAdapter.startUpdate(this);
      for (byte b1 = 0; b1 < this.mItems.size(); b1++) {
        ItemInfo itemInfo = this.mItems.get(b1);
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
    if (this.mAdapterChangeListeners != null && !this.mAdapterChangeListeners.isEmpty()) {
      int i = this.mAdapterChangeListeners.size();
      for (byte b1 = b; b1 < i; b1++)
        ((OnAdapterChangeListener)this.mAdapterChangeListeners.get(b1)).onAdapterChanged(this, pagerAdapter, paramPagerAdapter); 
    } 
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
    boolean bool;
    this.mPopulatePending = false;
    if (!this.mFirstLayout) {
      bool = true;
    } else {
      bool = false;
    } 
    setCurrentItemInternal(paramInt, bool, false);
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
    boolean bool = false;
    if (this.mAdapter == null || this.mAdapter.getCount() <= 0) {
      setScrollingCacheEnabled(false);
      return;
    } 
    if (!paramBoolean2 && this.mCurItem == paramInt1 && this.mItems.size() != 0) {
      setScrollingCacheEnabled(false);
      return;
    } 
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
    paramBoolean2 = bool;
    if (this.mCurItem != i)
      paramBoolean2 = true; 
    if (this.mFirstLayout) {
      this.mCurItem = i;
      if (paramBoolean2)
        dispatchOnPageSelected(i); 
      requestLayout();
      return;
    } 
    populate(i);
    scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener paramOnPageChangeListener) {
    OnPageChangeListener onPageChangeListener = this.mInternalPageChangeListener;
    this.mInternalPageChangeListener = paramOnPageChangeListener;
    return onPageChangeListener;
  }
  
  public void setOffscreenPageLimit(int paramInt) {
    int i = paramInt;
    if (paramInt < 1) {
      Log.w("ViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to " + '\001');
      i = 1;
    } 
    if (i != this.mOffscreenPageLimit) {
      this.mOffscreenPageLimit = i;
      populate();
    } 
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
  
  public void setPageMarginDrawable(@DrawableRes int paramInt) {
    setPageMarginDrawable(ContextCompat.getDrawable(getContext(), paramInt));
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
    setPageTransformer(paramBoolean, paramPageTransformer, 2);
  }
  
  public void setPageTransformer(boolean paramBoolean, PageTransformer paramPageTransformer, int paramInt) {
    byte b = 1;
    if (Build.VERSION.SDK_INT >= 11) {
      boolean bool1;
      boolean bool2;
      boolean bool3;
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
        this.mPageTransformerLayerType = paramInt;
      } else {
        this.mDrawingOrder = 0;
      } 
      if (bool3)
        populate(); 
    } 
  }
  
  void setScrollState(int paramInt) {
    if (this.mScrollState != paramInt) {
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
    float f1 = Math.min(1.0F, Math.abs(k) * 1.0F / paramInt1);
    float f2 = m;
    float f3 = m;
    f1 = distanceInfluenceForSnapDuration(f1);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0) {
      paramInt1 = Math.round(1000.0F * Math.abs((f3 * f1 + f2) / paramInt3)) * 4;
    } else {
      f3 = paramInt1;
      f2 = this.mAdapter.getPageWidth(this.mCurItem);
      paramInt1 = (int)((Math.abs(k) / (f3 * f2 + this.mPageMargin) + 1.0F) * 100.0F);
    } 
    paramInt1 = Math.min(paramInt1, 600);
    this.mIsScrollStarted = false;
    this.mScroller.startScroll(i, j, k, paramInt2, paramInt1);
    ViewCompat.postInvalidateOnAnimation((View)this);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable) {
    return (super.verifyDrawable(paramDrawable) || paramDrawable == this.mMarginDrawable);
  }
  
  @Inherited
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE})
  public static @interface DecorView {}
  
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
  
  class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
    private boolean canScroll() {
      boolean bool = true;
      if (ViewPager.this.mAdapter == null || ViewPager.this.mAdapter.getCount() <= 1)
        bool = false; 
      return bool;
    }
    
    public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      super.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
      param1AccessibilityEvent.setClassName(ViewPager.class.getName());
      AccessibilityRecordCompat accessibilityRecordCompat = AccessibilityEventCompat.asRecord(param1AccessibilityEvent);
      accessibilityRecordCompat.setScrollable(canScroll());
      if (param1AccessibilityEvent.getEventType() == 4096 && ViewPager.this.mAdapter != null) {
        accessibilityRecordCompat.setItemCount(ViewPager.this.mAdapter.getCount());
        accessibilityRecordCompat.setFromIndex(ViewPager.this.mCurItem);
        accessibilityRecordCompat.setToIndex(ViewPager.this.mCurItem);
      } 
    }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
      param1AccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
      param1AccessibilityNodeInfoCompat.setScrollable(canScroll());
      if (ViewPager.this.canScrollHorizontally(1))
        param1AccessibilityNodeInfoCompat.addAction(4096); 
      if (ViewPager.this.canScrollHorizontally(-1))
        param1AccessibilityNodeInfoCompat.addAction(8192); 
    }
    
    public boolean performAccessibilityAction(View param1View, int param1Int, Bundle param1Bundle) {
      boolean bool = true;
      if (!super.performAccessibilityAction(param1View, param1Int, param1Bundle)) {
        switch (param1Int) {
          default:
            return false;
          case 4096:
            if (ViewPager.this.canScrollHorizontally(1)) {
              ViewPager.this.setCurrentItem(ViewPager.this.mCurItem + 1);
              return bool;
            } 
            return false;
          case 8192:
            break;
        } 
        if (ViewPager.this.canScrollHorizontally(-1)) {
          ViewPager.this.setCurrentItem(ViewPager.this.mCurItem - 1);
          return bool;
        } 
        bool = false;
      } 
      return bool;
    }
  }
  
  public static interface OnAdapterChangeListener {
    void onAdapterChanged(@NonNull ViewPager param1ViewPager, @Nullable PagerAdapter param1PagerAdapter1, @Nullable PagerAdapter param1PagerAdapter2);
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
    public void onChanged() {
      ViewPager.this.dataSetChanged();
    }
    
    public void onInvalidated() {
      ViewPager.this.dataSetChanged();
    }
  }
  
  public static class SavedState extends AbsSavedState {
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
      super(param1Parcel, param1ClassLoader);
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
      return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
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
      return (layoutParams1.isDecor != layoutParams2.isDecor) ? (layoutParams1.isDecor ? 1 : -1) : (layoutParams1.position - layoutParams2.position);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\view\ViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */