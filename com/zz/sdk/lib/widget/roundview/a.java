package com.zz.sdk.lib.widget.roundview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class a extends RelativeLayout {
  private c a;
  
  public a(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = new c((View)this, paramContext, paramAttributeSet);
  }
  
  public c getDelegate() {
    return this.a;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    this.a.a(paramCanvas);
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (this.a.i() && getWidth() > 0 && getHeight() > 0) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max(getWidth(), getHeight()), 1073741824);
      super.onMeasure(paramInt1, paramInt1);
      return;
    } 
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    this.a.a(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener) {
    this.a.a(paramOnClickListener);
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener) {
    this.a.a(paramOnLongClickListener);
    super.setOnLongClickListener(paramOnLongClickListener);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\roundview\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */