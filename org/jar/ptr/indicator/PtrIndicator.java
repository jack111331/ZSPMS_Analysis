package org.jar.ptr.indicator;

import android.graphics.PointF;

public class PtrIndicator {
  public static final int POS_START = 0;
  
  private int mCurrentPos = 0;
  
  private int mHeaderHeight;
  
  private boolean mIsUnderTouch = false;
  
  private int mLastPos = 0;
  
  private int mOffsetToKeepHeaderWhileLoading = -1;
  
  protected int mOffsetToRefresh = 0;
  
  private float mOffsetX;
  
  private float mOffsetY;
  
  private int mPressedPos = 0;
  
  private PointF mPtLastMove = new PointF();
  
  private float mRatioOfHeaderHeightToRefresh = 1.2F;
  
  private int mRefreshCompleteY = 0;
  
  private float mResistance = 1.7F;
  
  public void convertFrom(PtrIndicator paramPtrIndicator) {
    this.mCurrentPos = paramPtrIndicator.mCurrentPos;
    this.mLastPos = paramPtrIndicator.mLastPos;
    this.mHeaderHeight = paramPtrIndicator.mHeaderHeight;
  }
  
  public boolean crossRefreshLineFromTopToBottom() {
    boolean bool;
    if (this.mLastPos < getOffsetToRefresh() && this.mCurrentPos >= getOffsetToRefresh()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public float getCurrentPercent() {
    float f;
    if (this.mHeaderHeight == 0) {
      f = 0.0F;
    } else {
      f = this.mCurrentPos * 1.0F / this.mHeaderHeight;
    } 
    return f;
  }
  
  public int getCurrentPosY() {
    return this.mCurrentPos;
  }
  
  public int getHeaderHeight() {
    return this.mHeaderHeight;
  }
  
  public float getLastPercent() {
    float f;
    if (this.mHeaderHeight == 0) {
      f = 0.0F;
    } else {
      f = this.mLastPos * 1.0F / this.mHeaderHeight;
    } 
    return f;
  }
  
  public int getLastPosY() {
    return this.mLastPos;
  }
  
  public int getOffsetToKeepHeaderWhileLoading() {
    int i;
    if (this.mOffsetToKeepHeaderWhileLoading >= 0) {
      i = this.mOffsetToKeepHeaderWhileLoading;
    } else {
      i = this.mHeaderHeight;
    } 
    return i;
  }
  
  public int getOffsetToRefresh() {
    return this.mOffsetToRefresh;
  }
  
  public float getOffsetX() {
    return this.mOffsetX;
  }
  
  public float getOffsetY() {
    return this.mOffsetY;
  }
  
  public float getRatioOfHeaderToHeightRefresh() {
    return this.mRatioOfHeaderHeightToRefresh;
  }
  
  public float getResistance() {
    return this.mResistance;
  }
  
  public boolean goDownCrossFinishPosition() {
    boolean bool;
    if (this.mCurrentPos >= this.mRefreshCompleteY) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasJustBackToStartPosition() {
    boolean bool;
    if (this.mLastPos != 0 && isInStartPosition()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasJustLeftStartPosition() {
    boolean bool;
    if (this.mLastPos == 0 && hasLeftStartPosition()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasJustReachedHeaderHeightFromTopToBottom() {
    boolean bool;
    if (this.mLastPos < this.mHeaderHeight && this.mCurrentPos >= this.mHeaderHeight) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasLeftStartPosition() {
    boolean bool;
    if (this.mCurrentPos > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasMovedAfterPressedDown() {
    boolean bool;
    if (this.mCurrentPos != this.mPressedPos) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isAlreadyHere(int paramInt) {
    boolean bool;
    if (this.mCurrentPos == paramInt) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isInStartPosition() {
    boolean bool;
    if (this.mCurrentPos == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isOverOffsetToKeepHeaderWhileLoading() {
    boolean bool;
    if (this.mCurrentPos > getOffsetToKeepHeaderWhileLoading()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isOverOffsetToRefresh() {
    boolean bool;
    if (this.mCurrentPos >= getOffsetToRefresh()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isUnderTouch() {
    return this.mIsUnderTouch;
  }
  
  public final void onMove(float paramFloat1, float paramFloat2) {
    processOnMove(paramFloat1, paramFloat2, paramFloat1 - this.mPtLastMove.x, paramFloat2 - this.mPtLastMove.y);
    this.mPtLastMove.set(paramFloat1, paramFloat2);
  }
  
  public void onPressDown(float paramFloat1, float paramFloat2) {
    this.mIsUnderTouch = true;
    this.mPressedPos = this.mCurrentPos;
    this.mPtLastMove.set(paramFloat1, paramFloat2);
  }
  
  public void onRelease() {
    this.mIsUnderTouch = false;
  }
  
  public void onUIRefreshComplete() {
    this.mRefreshCompleteY = this.mCurrentPos;
  }
  
  protected void onUpdatePos(int paramInt1, int paramInt2) {}
  
  protected void processOnMove(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    setOffset(paramFloat3, paramFloat4 / this.mResistance);
  }
  
  public final void setCurrentPos(int paramInt) {
    this.mLastPos = this.mCurrentPos;
    this.mCurrentPos = paramInt;
    onUpdatePos(paramInt, this.mLastPos);
  }
  
  public void setHeaderHeight(int paramInt) {
    this.mHeaderHeight = paramInt;
    updateHeight();
  }
  
  protected void setOffset(float paramFloat1, float paramFloat2) {
    this.mOffsetX = paramFloat1;
    this.mOffsetY = paramFloat2;
  }
  
  public void setOffsetToKeepHeaderWhileLoading(int paramInt) {
    this.mOffsetToKeepHeaderWhileLoading = paramInt;
  }
  
  public void setOffsetToRefresh(int paramInt) {
    this.mRatioOfHeaderHeightToRefresh = (this.mHeaderHeight / paramInt);
    this.mOffsetToRefresh = paramInt;
  }
  
  public void setRatioOfHeaderHeightToRefresh(float paramFloat) {
    this.mRatioOfHeaderHeightToRefresh = paramFloat;
    this.mOffsetToRefresh = (int)(this.mHeaderHeight * paramFloat);
  }
  
  public void setResistance(float paramFloat) {
    this.mResistance = paramFloat;
  }
  
  protected void updateHeight() {
    this.mOffsetToRefresh = (int)(this.mRatioOfHeaderHeightToRefresh * this.mHeaderHeight);
  }
  
  public boolean willOverTop(int paramInt) {
    boolean bool;
    if (paramInt < 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\ptr\indicator\PtrIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */