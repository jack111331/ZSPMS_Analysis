package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import java.lang.ref.WeakReference;

public class UPScrollView extends ScrollView {
  private WeakReference<a> a;
  
  private int b;
  
  private ViewTreeObserver.OnGlobalLayoutListener c = new u(this);
  
  private Handler d = new v(this);
  
  public UPScrollView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public UPScrollView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UPScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(a parama) {
    this.a = new WeakReference<a>(parama);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    getViewTreeObserver().addOnGlobalLayoutListener(this.c);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    getViewTreeObserver().removeGlobalOnLayoutListener(this.c);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (this.a != null && this.a.get() != null) {
      a a = this.a.get();
      int i = getScrollY();
      this.b = i;
      a.e(i);
    } 
    switch (paramMotionEvent.getAction()) {
      default:
        return super.onTouchEvent(paramMotionEvent);
      case 1:
        break;
    } 
    this.d.sendMessageDelayed(this.d.obtainMessage(), 5L);
  }
  
  public static interface a {
    void e(int param1Int);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\UPScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */