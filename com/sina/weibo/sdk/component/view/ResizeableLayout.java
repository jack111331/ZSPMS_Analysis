package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ResizeableLayout extends RelativeLayout {
  private int mHeight = 0;
  
  private SizeChangeListener mSizeChangeListener = null;
  
  private int mWidth = 0;
  
  public ResizeableLayout(Context paramContext) {
    super(paramContext);
  }
  
  public ResizeableLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public ResizeableLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.mSizeChangeListener != null)
      this.mSizeChangeListener.onSizeChanged(getWidth(), getHeight(), this.mWidth, this.mHeight); 
    this.mHeight = getHeight();
    this.mWidth = getWidth();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setSizeChangeListener(SizeChangeListener paramSizeChangeListener) {
    this.mSizeChangeListener = paramSizeChangeListener;
  }
  
  public static interface SizeChangeListener {
    void onSizeChanged(int param1Int1, int param1Int2, int param1Int3, int param1Int4);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\component\view\ResizeableLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */