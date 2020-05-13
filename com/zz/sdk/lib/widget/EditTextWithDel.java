package com.zz.sdk.lib.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.df;

public class EditTextWithDel extends EditText {
  private Drawable a;
  
  public EditTextWithDel(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public EditTextWithDel(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public EditTextWithDel(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    this.a = ca.da.a(paramContext);
    setCompoundDrawablePadding(df.a(paramContext, 2.0F));
    addTextChangedListener(new k(this));
    b();
  }
  
  private void b() {
    try {
      if (length() < 1 || !hasFocus()) {
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      } 
      setCompoundDrawablesWithIntrinsicBounds(null, null, this.a, null);
    } catch (Exception exception) {}
  }
  
  public void a() {
    setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  protected void finalize() {
    super.finalize();
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect) {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean) {
      setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      return;
    } 
    if (length() > 0)
      setCompoundDrawablesWithIntrinsicBounds(null, null, this.a, null); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    boolean bool = true;
    if (this.a != null && paramMotionEvent.getAction() == 1 && getCompoundDrawables()[2] != null) {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      int k = getCompoundDrawables()[2].getBounds().height();
      int m = (getHeight() - k) / 2;
      if (i > getWidth() - getTotalPaddingRight() && i < getWidth() - getPaddingRight()) {
        i = 1;
      } else {
        i = 0;
      } 
      if (j <= m || j >= k + m)
        bool = false; 
      if (i != 0 && bool)
        setText(""); 
    } 
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\EditTextWithDel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */