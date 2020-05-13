package com.xy.whf.widget;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.Nullable;

public class RoundDrawable extends GradientDrawable {
  private ColorStateList mFillColors;
  
  private boolean mRadiusAdjustBounds = true;
  
  private ColorStateList mStrokeColors;
  
  private int mStrokeWidth = 0;
  
  private boolean hasNativeStateListAPI() {
    return (Build.VERSION.SDK_INT >= 21);
  }
  
  public boolean isStateful() {
    return ((this.mFillColors != null && this.mFillColors.isStateful()) || (this.mStrokeColors != null && this.mStrokeColors.isStateful()) || super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect) {
    super.onBoundsChange(paramRect);
    if (this.mRadiusAdjustBounds)
      setCornerRadius((Math.min(paramRect.width(), paramRect.height()) / 2)); 
  }
  
  protected boolean onStateChange(int[] paramArrayOfint) {
    boolean bool = true;
    boolean bool1 = super.onStateChange(paramArrayOfint);
    if (this.mFillColors != null) {
      setColor(this.mFillColors.getColorForState(paramArrayOfint, 0));
      bool1 = true;
    } 
    if (this.mStrokeColors != null) {
      int i = this.mStrokeColors.getColorForState(paramArrayOfint, 0);
      setStroke(this.mStrokeWidth, i);
      bool1 = bool;
    } 
    return bool1;
  }
  
  public void setBgData(@Nullable ColorStateList paramColorStateList) {
    int i = 0;
    if (hasNativeStateListAPI()) {
      setColor(paramColorStateList);
      return;
    } 
    this.mFillColors = paramColorStateList;
    if (paramColorStateList != null)
      i = paramColorStateList.getColorForState(getState(), 0); 
    setColor(i);
  }
  
  public void setIsRadiusAdjustBounds(boolean paramBoolean) {
    this.mRadiusAdjustBounds = paramBoolean;
  }
  
  public void setStrokeData(int paramInt, @Nullable ColorStateList paramColorStateList) {
    int i = 0;
    if (hasNativeStateListAPI()) {
      setStroke(paramInt, paramColorStateList);
      return;
    } 
    this.mStrokeWidth = paramInt;
    this.mStrokeColors = paramColorStateList;
    if (paramColorStateList != null)
      i = paramColorStateList.getColorForState(getState(), 0); 
    setStroke(paramInt, i);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\widget\RoundDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */