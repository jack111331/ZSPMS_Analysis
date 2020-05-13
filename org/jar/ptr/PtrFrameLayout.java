package org.jar.ptr;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Scroller;
import android.widget.TextView;
import org.jar.bloc.R;
import org.jar.bloc.utils.ResUtils;
import org.jar.ptr.indicator.PtrIndicator;
import org.jar.ptr.util.PtrCLog;

public class PtrFrameLayout extends FrameLayout {
  public static boolean DEBUG = false;
  
  private static final boolean DEBUG_LAYOUT = true;
  
  private static byte FLAG_AUTO_REFRESH_AT_ONCE = 1;
  
  private static byte FLAG_AUTO_REFRESH_BUT_LATER = 2;
  
  private static byte FLAG_ENABLE_NEXT_PTR_AT_ONCE = 4;
  
  private static byte FLAG_PIN_CONTENT = 8;
  
  private static int ID = 1;
  
  private static byte MASK_AUTO_REFRESH = 3;
  
  public static final byte PTR_STATUS_COMPLETE = 4;
  
  public static final byte PTR_STATUS_INIT = 1;
  
  public static final byte PTR_STATUS_LOADING = 3;
  
  public static final byte PTR_STATUS_PREPARE = 2;
  
  protected final String LOG_TAG;
  
  private int mContainerId;
  
  protected View mContent;
  
  private boolean mDisableWhenHorizontalMove;
  
  private MotionEvent mDownEvent;
  
  private int mDurationToClose;
  
  private int mDurationToCloseHeader;
  
  private int mFlag;
  
  private boolean mHasSendCancelEvent;
  
  private int mHeaderHeight;
  
  private int mHeaderId;
  
  private View mHeaderView;
  
  private boolean mKeepHeaderWhenRefresh;
  
  private MotionEvent mLastMoveEvent;
  
  private int mLoadingMinTime;
  
  private long mLoadingStartTime;
  
  private int mPagingTouchSlop;
  
  private boolean mPreventForHorizontal;
  
  private PtrHandler mPtrHandler;
  
  private PtrIndicator mPtrIndicator;
  
  private PtrUIHandlerHolder mPtrUIHandlerHolder;
  
  private boolean mPullToRefresh;
  
  private PtrUIHandlerHook mRefreshCompleteHook;
  
  private ScrollChecker mScrollChecker;
  
  private byte mStatus;
  
  public PtrFrameLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public PtrFrameLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PtrFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("org.jar.ptr-frame-");
    paramInt = ID + 1;
    ID = paramInt;
    stringBuilder.append(paramInt);
    this.LOG_TAG = stringBuilder.toString();
    this.mHeaderId = 0;
    this.mContainerId = 0;
    this.mDurationToClose = 200;
    this.mDurationToCloseHeader = 1000;
    this.mKeepHeaderWhenRefresh = true;
    this.mPullToRefresh = false;
    this.mPtrUIHandlerHolder = PtrUIHandlerHolder.create();
    this.mStatus = (byte)1;
    this.mDisableWhenHorizontalMove = false;
    this.mFlag = 0;
    this.mPreventForHorizontal = false;
    this.mLoadingMinTime = 500;
    this.mLoadingStartTime = 0L;
    this.mHasSendCancelEvent = false;
    this.mPtrIndicator = new PtrIndicator();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, ResUtils.ids(paramContext, R.styleable.PtrFrameLayout), 0, 0);
    if (typedArray != null) {
      this.mHeaderId = typedArray.getResourceId(ResUtils.id(paramContext, R.styleable.PtrFrameLayout_ptr_header), this.mHeaderId);
      this.mContainerId = typedArray.getResourceId(ResUtils.id(paramContext, R.styleable.PtrFrameLayout_ptr_content), this.mContainerId);
      this.mPtrIndicator.setResistance(typedArray.getFloat(ResUtils.id(paramContext, R.styleable.PtrFrameLayout_ptr_resistance), this.mPtrIndicator.getResistance()));
      this.mDurationToClose = typedArray.getInt(ResUtils.id(paramContext, R.styleable.PtrFrameLayout_ptr_duration_to_close), this.mDurationToClose);
      this.mDurationToCloseHeader = typedArray.getInt(ResUtils.id(paramContext, R.styleable.PtrFrameLayout_ptr_duration_to_close_header), this.mDurationToCloseHeader);
      float f = this.mPtrIndicator.getRatioOfHeaderToHeightRefresh();
      f = typedArray.getFloat(ResUtils.id(paramContext, R.styleable.PtrFrameLayout_ptr_ratio_of_header_height_to_refresh), f);
      this.mPtrIndicator.setRatioOfHeaderHeightToRefresh(f);
      this.mKeepHeaderWhenRefresh = typedArray.getBoolean(ResUtils.id(paramContext, R.styleable.PtrFrameLayout_ptr_keep_header_when_refresh), this.mKeepHeaderWhenRefresh);
      this.mPullToRefresh = typedArray.getBoolean(ResUtils.id(paramContext, R.styleable.PtrFrameLayout_ptr_pull_to_fresh), this.mPullToRefresh);
      typedArray.recycle();
    } 
    this.mScrollChecker = new ScrollChecker();
    this.mPagingTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
  }
  
  private void clearFlag() {
    this.mFlag &= MASK_AUTO_REFRESH ^ 0xFFFFFFFF;
  }
  
  private void layoutChildren() {
    int i = this.mPtrIndicator.getCurrentPosY();
    int j = getPaddingLeft();
    int k = getPaddingTop();
    if (this.mHeaderView != null) {
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.mHeaderView.getLayoutParams();
      int m = marginLayoutParams.leftMargin + j;
      int n = marginLayoutParams.topMargin + k + i - this.mHeaderHeight;
      int i1 = this.mHeaderView.getMeasuredWidth() + m;
      int i2 = this.mHeaderView.getMeasuredHeight() + n;
      this.mHeaderView.layout(m, n, i1, i2);
      if (DEBUG)
        PtrCLog.d(this.LOG_TAG, "onLayout header: %s %s %s %s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2) }); 
    } 
    if (this.mContent != null) {
      if (isPinContent())
        i = 0; 
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.mContent.getLayoutParams();
      j += marginLayoutParams.leftMargin;
      i = k + marginLayoutParams.topMargin + i;
      int m = this.mContent.getMeasuredWidth() + j;
      k = this.mContent.getMeasuredHeight() + i;
      if (DEBUG)
        PtrCLog.d(this.LOG_TAG, "onLayout content: %s %s %s %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(k) }); 
      this.mContent.layout(j, i, m, k);
    } 
  }
  
  private void measureContentView(View paramView, int paramInt1, int paramInt2) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin, marginLayoutParams.height));
  }
  
  private void movePos(float paramFloat) {
    if (paramFloat < 0.0F && this.mPtrIndicator.isInStartPosition()) {
      if (DEBUG)
        PtrCLog.e(this.LOG_TAG, String.format("has reached the top", new Object[0])); 
      return;
    } 
    int i = this.mPtrIndicator.getCurrentPosY();
    int j = (int)paramFloat + i;
    i = j;
    if (this.mPtrIndicator.willOverTop(j)) {
      if (DEBUG)
        PtrCLog.e(this.LOG_TAG, String.format("over top", new Object[0])); 
      i = 0;
    } 
    this.mPtrIndicator.setCurrentPos(i);
    updatePos(i - this.mPtrIndicator.getLastPosY());
  }
  
  private void notifyUIRefreshComplete(boolean paramBoolean) {
    if (this.mPtrIndicator.hasLeftStartPosition() && !paramBoolean && this.mRefreshCompleteHook != null) {
      if (DEBUG)
        PtrCLog.d(this.LOG_TAG, "notifyUIRefreshComplete mRefreshCompleteHook run."); 
      this.mRefreshCompleteHook.takeOver();
      return;
    } 
    if (this.mPtrUIHandlerHolder.hasHandler()) {
      if (DEBUG)
        PtrCLog.i(this.LOG_TAG, "PtrUIHandler: onUIRefreshComplete"); 
      this.mPtrUIHandlerHolder.onUIRefreshComplete(this);
    } 
    this.mPtrIndicator.onUIRefreshComplete();
    tryScrollBackToTopAfterComplete();
    tryToNotifyReset();
  }
  
  private void onRelease(boolean paramBoolean) {
    tryToPerformRefresh();
    if (this.mStatus == 3) {
      if (this.mKeepHeaderWhenRefresh) {
        if (this.mPtrIndicator.isOverOffsetToKeepHeaderWhileLoading() && !paramBoolean)
          this.mScrollChecker.tryToScrollTo(this.mPtrIndicator.getOffsetToKeepHeaderWhileLoading(), this.mDurationToClose); 
      } else {
        tryScrollBackToTopWhileLoading();
      } 
    } else if (this.mStatus == 4) {
      notifyUIRefreshComplete(false);
    } else {
      tryScrollBackToTopAbortRefresh();
    } 
  }
  
  private boolean performAutoRefreshButLater() {
    boolean bool;
    if ((this.mFlag & MASK_AUTO_REFRESH) == FLAG_AUTO_REFRESH_BUT_LATER) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private void performRefresh() {
    this.mLoadingStartTime = System.currentTimeMillis();
    if (this.mPtrUIHandlerHolder.hasHandler()) {
      this.mPtrUIHandlerHolder.onUIRefreshBegin(this);
      if (DEBUG)
        PtrCLog.i(this.LOG_TAG, "PtrUIHandler: onUIRefreshBegin"); 
    } 
    if (this.mPtrHandler != null)
      this.mPtrHandler.onRefreshBegin(this); 
  }
  
  private void performRefreshComplete() {
    this.mStatus = (byte)4;
    if (this.mScrollChecker.mIsRunning && isAutoRefresh()) {
      if (DEBUG)
        PtrCLog.d(this.LOG_TAG, "performRefreshComplete do nothing, scrolling: %s, auto refresh: %s", new Object[] { Boolean.valueOf(ScrollChecker.access$200(this.mScrollChecker)), Integer.valueOf(this.mFlag) }); 
      return;
    } 
    notifyUIRefreshComplete(false);
  }
  
  private void sendCancelEvent() {
    if (DEBUG)
      PtrCLog.d(this.LOG_TAG, "send cancel event"); 
    MotionEvent motionEvent = this.mDownEvent;
    motionEvent = this.mLastMoveEvent;
    dispatchTouchEventSupper(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime() + ViewConfiguration.getLongPressTimeout(), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState()));
  }
  
  private void sendDownEvent() {
    if (DEBUG)
      PtrCLog.d(this.LOG_TAG, "send down event"); 
    MotionEvent motionEvent = this.mLastMoveEvent;
    dispatchTouchEventSupper(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 0, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState()));
  }
  
  private void tryScrollBackToTop() {
    if (!this.mPtrIndicator.isUnderTouch())
      this.mScrollChecker.tryToScrollTo(0, this.mDurationToCloseHeader); 
  }
  
  private void tryScrollBackToTopAbortRefresh() {
    tryScrollBackToTop();
  }
  
  private void tryScrollBackToTopAfterComplete() {
    tryScrollBackToTop();
  }
  
  private void tryScrollBackToTopWhileLoading() {
    tryScrollBackToTop();
  }
  
  private boolean tryToNotifyReset() {
    if ((this.mStatus == 4 || this.mStatus == 2) && this.mPtrIndicator.isInStartPosition()) {
      if (this.mPtrUIHandlerHolder.hasHandler()) {
        this.mPtrUIHandlerHolder.onUIReset(this);
        if (DEBUG)
          PtrCLog.i(this.LOG_TAG, "PtrUIHandler: onUIReset"); 
      } 
      this.mStatus = (byte)1;
      clearFlag();
      return true;
    } 
    return false;
  }
  
  private boolean tryToPerformRefresh() {
    if (this.mStatus != 2)
      return false; 
    if ((this.mPtrIndicator.isOverOffsetToKeepHeaderWhileLoading() && isAutoRefresh()) || this.mPtrIndicator.isOverOffsetToRefresh()) {
      this.mStatus = (byte)3;
      performRefresh();
    } 
    return false;
  }
  
  private void updatePos(int paramInt) {
    if (paramInt == 0)
      return; 
    boolean bool = this.mPtrIndicator.isUnderTouch();
    if (bool && !this.mHasSendCancelEvent && this.mPtrIndicator.hasMovedAfterPressedDown()) {
      this.mHasSendCancelEvent = true;
      sendCancelEvent();
    } 
    if ((this.mPtrIndicator.hasJustLeftStartPosition() && this.mStatus == 1) || (this.mPtrIndicator.goDownCrossFinishPosition() && this.mStatus == 4 && isEnabledNextPtrAtOnce())) {
      this.mStatus = (byte)2;
      this.mPtrUIHandlerHolder.onUIRefreshPrepare(this);
      if (DEBUG)
        PtrCLog.i(this.LOG_TAG, "PtrUIHandler: onUIRefreshPrepare, mFlag %s", new Object[] { Integer.valueOf(this.mFlag) }); 
    } 
    if (this.mPtrIndicator.hasJustBackToStartPosition()) {
      tryToNotifyReset();
      if (bool)
        sendDownEvent(); 
    } 
    if (this.mStatus == 2) {
      if (bool && !isAutoRefresh() && this.mPullToRefresh && this.mPtrIndicator.crossRefreshLineFromTopToBottom())
        tryToPerformRefresh(); 
      if (performAutoRefreshButLater() && this.mPtrIndicator.hasJustReachedHeaderHeightFromTopToBottom())
        tryToPerformRefresh(); 
    } 
    if (DEBUG)
      PtrCLog.v(this.LOG_TAG, "updatePos: change: %s, current: %s last: %s, top: %s, headerHeight: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mPtrIndicator.getCurrentPosY()), Integer.valueOf(this.mPtrIndicator.getLastPosY()), Integer.valueOf(this.mContent.getTop()), Integer.valueOf(this.mHeaderHeight) }); 
    this.mHeaderView.offsetTopAndBottom(paramInt);
    if (!isPinContent())
      this.mContent.offsetTopAndBottom(paramInt); 
    invalidate();
    if (this.mPtrUIHandlerHolder.hasHandler())
      this.mPtrUIHandlerHolder.onUIPositionChange(this, bool, this.mStatus, this.mPtrIndicator); 
    onPositionChange(bool, this.mStatus, this.mPtrIndicator);
  }
  
  public void addPtrUIHandler(PtrUIHandler paramPtrUIHandler) {
    PtrUIHandlerHolder.addHandler(this.mPtrUIHandlerHolder, paramPtrUIHandler);
  }
  
  public void autoRefresh() {
    autoRefresh(true, this.mDurationToCloseHeader);
  }
  
  public void autoRefresh(boolean paramBoolean) {
    autoRefresh(paramBoolean, this.mDurationToCloseHeader);
  }
  
  public void autoRefresh(boolean paramBoolean, int paramInt) {
    byte b;
    if (this.mStatus != 1)
      return; 
    int i = this.mFlag;
    if (paramBoolean) {
      b = FLAG_AUTO_REFRESH_AT_ONCE;
    } else {
      b = FLAG_AUTO_REFRESH_BUT_LATER;
    } 
    this.mFlag = i | b;
    this.mStatus = (byte)2;
    if (this.mPtrUIHandlerHolder.hasHandler()) {
      this.mPtrUIHandlerHolder.onUIRefreshPrepare(this);
      if (DEBUG)
        PtrCLog.i(this.LOG_TAG, "PtrUIHandler: onUIRefreshPrepare, mFlag %s", new Object[] { Integer.valueOf(this.mFlag) }); 
    } 
    this.mScrollChecker.tryToScrollTo(this.mPtrIndicator.getOffsetToRefresh(), paramInt);
    if (paramBoolean) {
      this.mStatus = (byte)3;
      performRefresh();
    } 
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void disableWhenHorizontalMove(boolean paramBoolean) {
    this.mDisableWhenHorizontalMove = paramBoolean;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    float f1;
    float f2;
    boolean bool;
    int i;
    boolean bool1;
    if (!isEnabled() || this.mContent == null || this.mHeaderView == null)
      return dispatchTouchEventSupper(paramMotionEvent); 
    switch (paramMotionEvent.getAction()) {
      default:
        return dispatchTouchEventSupper(paramMotionEvent);
      case 2:
        this.mLastMoveEvent = paramMotionEvent;
        this.mPtrIndicator.onMove(paramMotionEvent.getX(), paramMotionEvent.getY());
        f1 = this.mPtrIndicator.getOffsetX();
        f2 = this.mPtrIndicator.getOffsetY();
        if (this.mDisableWhenHorizontalMove && !this.mPreventForHorizontal && (Math.abs(f1) > this.mPagingTouchSlop || Math.abs(f1) > Math.abs(f2) * 3.0F) && this.mPtrIndicator.isInStartPosition())
          this.mPreventForHorizontal = true; 
        if (this.mPreventForHorizontal)
          return dispatchTouchEventSupper(paramMotionEvent); 
        if (f2 > 0.0F) {
          bool = true;
        } else {
          bool = false;
        } 
        i = bool ^ true;
        bool1 = this.mPtrIndicator.hasLeftStartPosition();
        if (DEBUG) {
          boolean bool2;
          if (this.mPtrHandler != null && this.mPtrHandler.checkCanDoRefresh(this, this.mContent, this.mHeaderView)) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          PtrCLog.v(this.LOG_TAG, "ACTION_MOVE: offsetY:%s, mCurrentPos: %s, moveUp: %s, canMoveUp: %s, moveDown: %s: canMoveDown: %s", new Object[] { Float.valueOf(f2), Integer.valueOf(this.mPtrIndicator.getCurrentPosY()), Boolean.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool), Boolean.valueOf(bool2) });
        } 
        if (bool && this.mPtrHandler != null && !this.mPtrHandler.checkCanDoRefresh(this, this.mContent, this.mHeaderView))
          return dispatchTouchEventSupper(paramMotionEvent); 
        if ((i != 0 && bool1) || bool) {
          movePos(f2);
          return true;
        } 
      case 1:
      case 3:
        this.mPtrIndicator.onRelease();
        if (this.mPtrIndicator.hasLeftStartPosition()) {
          if (DEBUG)
            PtrCLog.d(this.LOG_TAG, "call onRelease when user release"); 
          onRelease(false);
          if (this.mPtrIndicator.hasMovedAfterPressedDown()) {
            sendCancelEvent();
            return true;
          } 
          return dispatchTouchEventSupper(paramMotionEvent);
        } 
        return dispatchTouchEventSupper(paramMotionEvent);
      case 0:
        break;
    } 
    this.mHasSendCancelEvent = false;
    this.mDownEvent = paramMotionEvent;
    this.mPtrIndicator.onPressDown(paramMotionEvent.getX(), paramMotionEvent.getY());
    this.mScrollChecker.abortIfWorking();
    this.mPreventForHorizontal = false;
    if (!this.mPtrIndicator.hasLeftStartPosition())
      dispatchTouchEventSupper(paramMotionEvent); 
    return true;
  }
  
  public boolean dispatchTouchEventSupper(MotionEvent paramMotionEvent) {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected FrameLayout.LayoutParams generateDefaultLayoutParams() {
    return new LayoutParams(-1, -1);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (ViewGroup.LayoutParams)new LayoutParams(paramLayoutParams);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public View getContentView() {
    return this.mContent;
  }
  
  public float getDurationToClose() {
    return this.mDurationToClose;
  }
  
  public long getDurationToCloseHeader() {
    return this.mDurationToCloseHeader;
  }
  
  public int getHeaderHeight() {
    return this.mHeaderHeight;
  }
  
  public View getHeaderView() {
    return this.mHeaderView;
  }
  
  public int getOffsetToKeepHeaderWhileLoading() {
    return this.mPtrIndicator.getOffsetToKeepHeaderWhileLoading();
  }
  
  public int getOffsetToRefresh() {
    return this.mPtrIndicator.getOffsetToRefresh();
  }
  
  public float getRatioOfHeaderToHeightRefresh() {
    return this.mPtrIndicator.getRatioOfHeaderToHeightRefresh();
  }
  
  public float getResistance() {
    return this.mPtrIndicator.getResistance();
  }
  
  public boolean isAutoRefresh() {
    boolean bool;
    if ((this.mFlag & MASK_AUTO_REFRESH) > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isEnabledNextPtrAtOnce() {
    boolean bool;
    if ((this.mFlag & FLAG_ENABLE_NEXT_PTR_AT_ONCE) > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isKeepHeaderWhenRefresh() {
    return this.mKeepHeaderWhenRefresh;
  }
  
  public boolean isPinContent() {
    boolean bool;
    if ((this.mFlag & FLAG_PIN_CONTENT) > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isPullToRefresh() {
    return this.mPullToRefresh;
  }
  
  protected void onFinishInflate() {
    int i = getChildCount();
    if (i <= 2) {
      if (i == 2) {
        if (this.mHeaderId != 0 && this.mHeaderView == null)
          this.mHeaderView = findViewById(this.mHeaderId); 
        if (this.mContainerId != 0 && this.mContent == null)
          this.mContent = findViewById(this.mContainerId); 
        if (this.mContent == null || this.mHeaderView == null) {
          View view1 = getChildAt(0);
          View view2 = getChildAt(1);
          if (view1 instanceof PtrUIHandler) {
            this.mHeaderView = view1;
            this.mContent = view2;
          } else if (view2 instanceof PtrUIHandler) {
            this.mHeaderView = view2;
            this.mContent = view1;
          } else if (this.mContent == null && this.mHeaderView == null) {
            this.mHeaderView = view1;
            this.mContent = view2;
          } else if (this.mHeaderView == null) {
            View view = view1;
            if (this.mContent == view1)
              view = view2; 
            this.mHeaderView = view;
          } else {
            View view = view1;
            if (this.mHeaderView == view1)
              view = view2; 
            this.mContent = view;
          } 
        } 
      } else if (i == 1) {
        this.mContent = getChildAt(0);
      } else {
        TextView textView = new TextView(getContext());
        textView.setClickable(true);
        textView.setTextColor(-39424);
        textView.setGravity(17);
        textView.setTextSize(20.0F);
        textView.setText("The content view in PtrFrameLayout is empty. Do you forget to specify its id in xml layout file?");
        this.mContent = (View)textView;
        addView(this.mContent);
      } 
      if (this.mHeaderView != null)
        this.mHeaderView.bringToFront(); 
      super.onFinishInflate();
      return;
    } 
    throw new IllegalStateException("PtrFrameLayout only can host 2 elements");
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    layoutChildren();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (DEBUG)
      PtrCLog.d(this.LOG_TAG, "onMeasure frame: width: %s, height: %s, padding: %s %s %s %s", new Object[] { Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getPaddingLeft()), Integer.valueOf(getPaddingRight()), Integer.valueOf(getPaddingTop()), Integer.valueOf(getPaddingBottom()) }); 
    if (this.mHeaderView != null) {
      measureChildWithMargins(this.mHeaderView, paramInt1, 0, paramInt2, 0);
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.mHeaderView.getLayoutParams();
      this.mHeaderHeight = this.mHeaderView.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
      this.mPtrIndicator.setHeaderHeight(this.mHeaderHeight);
    } 
    if (this.mContent != null) {
      measureContentView(this.mContent, paramInt1, paramInt2);
      if (DEBUG) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.mContent.getLayoutParams();
        PtrCLog.d(this.LOG_TAG, "onMeasure content, width: %s, height: %s, margin: %s %s %s %s", new Object[] { Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight()), Integer.valueOf(marginLayoutParams.leftMargin), Integer.valueOf(marginLayoutParams.topMargin), Integer.valueOf(marginLayoutParams.rightMargin), Integer.valueOf(marginLayoutParams.bottomMargin) });
        PtrCLog.d(this.LOG_TAG, "onMeasure, mCurrentPos: %s, mLastPos: %s, top: %s", new Object[] { Integer.valueOf(this.mPtrIndicator.getCurrentPosY()), Integer.valueOf(this.mPtrIndicator.getLastPosY()), Integer.valueOf(this.mContent.getTop()) });
      } 
    } 
  }
  
  protected void onPositionChange(boolean paramBoolean, byte paramByte, PtrIndicator paramPtrIndicator) {}
  
  protected void onPtrScrollAbort() {
    if (this.mPtrIndicator.hasLeftStartPosition() && isAutoRefresh()) {
      if (DEBUG)
        PtrCLog.d(this.LOG_TAG, "call onRelease after scroll abort"); 
      onRelease(true);
    } 
  }
  
  protected void onPtrScrollFinish() {
    if (this.mPtrIndicator.hasLeftStartPosition() && isAutoRefresh()) {
      if (DEBUG)
        PtrCLog.d(this.LOG_TAG, "call onRelease after scroll finish"); 
      onRelease(true);
    } 
  }
  
  public final void refreshComplete() {
    if (DEBUG)
      PtrCLog.i(this.LOG_TAG, "refreshComplete"); 
    if (this.mRefreshCompleteHook != null)
      this.mRefreshCompleteHook.reset(); 
    int i = (int)(this.mLoadingMinTime - System.currentTimeMillis() - this.mLoadingStartTime);
    if (i <= 0) {
      if (DEBUG)
        PtrCLog.d(this.LOG_TAG, "performRefreshComplete at once"); 
      performRefreshComplete();
    } else {
      postDelayed(new Runnable() {
            public void run() {
              PtrFrameLayout.this.performRefreshComplete();
            }
          },  i);
      if (DEBUG)
        PtrCLog.d(this.LOG_TAG, "performRefreshComplete after delay: %s", new Object[] { Integer.valueOf(i) }); 
    } 
  }
  
  public void removePtrUIHandler(PtrUIHandler paramPtrUIHandler) {
    this.mPtrUIHandlerHolder = PtrUIHandlerHolder.removeHandler(this.mPtrUIHandlerHolder, paramPtrUIHandler);
  }
  
  public void setDurationToClose(int paramInt) {
    this.mDurationToClose = paramInt;
  }
  
  public void setDurationToCloseHeader(int paramInt) {
    this.mDurationToCloseHeader = paramInt;
  }
  
  public void setEnabledNextPtrAtOnce(boolean paramBoolean) {
    if (paramBoolean) {
      this.mFlag |= FLAG_ENABLE_NEXT_PTR_AT_ONCE;
    } else {
      this.mFlag &= FLAG_ENABLE_NEXT_PTR_AT_ONCE ^ 0xFFFFFFFF;
    } 
  }
  
  public void setHeaderView(View paramView) {
    if (this.mHeaderView != null && paramView != null && this.mHeaderView != paramView)
      removeView(this.mHeaderView); 
    if (paramView.getLayoutParams() == null)
      paramView.setLayoutParams((ViewGroup.LayoutParams)new LayoutParams(-1, -2)); 
    this.mHeaderView = paramView;
    addView(paramView);
  }
  
  @Deprecated
  public void setInterceptEventWhileWorking(boolean paramBoolean) {}
  
  public void setKeepHeaderWhenRefresh(boolean paramBoolean) {
    this.mKeepHeaderWhenRefresh = paramBoolean;
  }
  
  public void setLoadingMinTime(int paramInt) {
    this.mLoadingMinTime = paramInt;
  }
  
  public void setOffsetToKeepHeaderWhileLoading(int paramInt) {
    this.mPtrIndicator.setOffsetToKeepHeaderWhileLoading(paramInt);
  }
  
  public void setOffsetToRefresh(int paramInt) {
    this.mPtrIndicator.setOffsetToRefresh(paramInt);
  }
  
  public void setPinContent(boolean paramBoolean) {
    if (paramBoolean) {
      this.mFlag |= FLAG_PIN_CONTENT;
    } else {
      this.mFlag &= FLAG_PIN_CONTENT ^ 0xFFFFFFFF;
    } 
  }
  
  public void setPtrHandler(PtrHandler paramPtrHandler) {
    this.mPtrHandler = paramPtrHandler;
  }
  
  public void setPtrIndicator(PtrIndicator paramPtrIndicator) {
    if (this.mPtrIndicator != null && this.mPtrIndicator != paramPtrIndicator)
      paramPtrIndicator.convertFrom(this.mPtrIndicator); 
    this.mPtrIndicator = paramPtrIndicator;
  }
  
  public void setPullToRefresh(boolean paramBoolean) {
    this.mPullToRefresh = paramBoolean;
  }
  
  public void setRatioOfHeaderHeightToRefresh(float paramFloat) {
    this.mPtrIndicator.setRatioOfHeaderHeightToRefresh(paramFloat);
  }
  
  public void setRefreshCompleteHook(PtrUIHandlerHook paramPtrUIHandlerHook) {
    this.mRefreshCompleteHook = paramPtrUIHandlerHook;
    paramPtrUIHandlerHook.setResumeAction(new Runnable() {
          public void run() {
            if (PtrFrameLayout.DEBUG)
              PtrCLog.d(PtrFrameLayout.this.LOG_TAG, "mRefreshCompleteHook resume."); 
            PtrFrameLayout.this.notifyUIRefreshComplete(true);
          }
        });
  }
  
  public void setResistance(float paramFloat) {
    this.mPtrIndicator.setResistance(paramFloat);
  }
  
  public static class LayoutParams extends FrameLayout.LayoutParams {
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
  }
  
  class ScrollChecker implements Runnable {
    private boolean mIsRunning = false;
    
    private int mLastFlingY;
    
    private Scroller mScroller = new Scroller(PtrFrameLayout.this.getContext());
    
    private int mStart;
    
    private int mTo;
    
    private void finish() {
      if (PtrFrameLayout.DEBUG)
        PtrCLog.v(PtrFrameLayout.this.LOG_TAG, "finish, mCurrentPos:%s", new Object[] { Integer.valueOf(PtrFrameLayout.access$300(this.this$0).getCurrentPosY()) }); 
      reset();
      PtrFrameLayout.this.onPtrScrollFinish();
    }
    
    private void reset() {
      this.mIsRunning = false;
      this.mLastFlingY = 0;
      PtrFrameLayout.this.removeCallbacks(this);
    }
    
    public void abortIfWorking() {
      if (this.mIsRunning) {
        if (!this.mScroller.isFinished())
          this.mScroller.forceFinished(true); 
        PtrFrameLayout.this.onPtrScrollAbort();
        reset();
      } 
    }
    
    public void run() {
      boolean bool;
      if (!this.mScroller.computeScrollOffset() || this.mScroller.isFinished()) {
        bool = true;
      } else {
        bool = false;
      } 
      int i = this.mScroller.getCurrY();
      int j = i - this.mLastFlingY;
      if (PtrFrameLayout.DEBUG && j != 0)
        PtrCLog.v(PtrFrameLayout.this.LOG_TAG, "scroll: %s, start: %s, to: %s, mCurrentPos: %s, current :%s, last: %s, delta: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.mStart), Integer.valueOf(this.mTo), Integer.valueOf(PtrFrameLayout.access$300(this.this$0).getCurrentPosY()), Integer.valueOf(i), Integer.valueOf(this.mLastFlingY), Integer.valueOf(j) }); 
      if (!bool) {
        this.mLastFlingY = i;
        PtrFrameLayout.this.movePos(j);
        PtrFrameLayout.this.post(this);
      } else {
        finish();
      } 
    }
    
    public void tryToScrollTo(int param1Int1, int param1Int2) {
      if (PtrFrameLayout.this.mPtrIndicator.isAlreadyHere(param1Int1))
        return; 
      this.mStart = PtrFrameLayout.this.mPtrIndicator.getCurrentPosY();
      this.mTo = param1Int1;
      int i = param1Int1 - this.mStart;
      if (PtrFrameLayout.DEBUG)
        PtrCLog.d(PtrFrameLayout.this.LOG_TAG, "tryToScrollTo: start: %s, distance:%s, to:%s", new Object[] { Integer.valueOf(this.mStart), Integer.valueOf(i), Integer.valueOf(param1Int1) }); 
      PtrFrameLayout.this.removeCallbacks(this);
      this.mLastFlingY = 0;
      if (!this.mScroller.isFinished())
        this.mScroller.forceFinished(true); 
      this.mScroller.startScroll(0, 0, 0, i, param1Int2);
      PtrFrameLayout.this.post(this);
      this.mIsRunning = true;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\ptr\PtrFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */