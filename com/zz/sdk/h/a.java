package com.zz.sdk.h;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.zz.sdk.i.bg;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;

public class a {
  public static Activity a;
  
  public static PopupWindow b = null;
  
  public static void a() {
    try {
      bp.a("FloatDragHidePopup...showDragHidePopup");
      a = cv.i();
      View view = a.getLayoutInflater().inflate(ci.a((Context)a, 2130903121), null);
      view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      int i = view.getMeasuredWidth();
      int j = view.getMeasuredHeight();
      if (b == null) {
        PopupWindow popupWindow1 = new PopupWindow();
        this(view, i, j);
        b = popupWindow1;
        b.setFocusable(true);
        b.setOutsideTouchable(true);
        popupWindow1 = b;
        BitmapDrawable bitmapDrawable = new BitmapDrawable();
        this();
        popupWindow1.setBackgroundDrawable((Drawable)bitmapDrawable);
        b.showAtLocation(cv.i().getWindow().getDecorView(), 80, 0, 40);
        PopupWindow popupWindow2 = b;
        b b = new b();
        this();
        popupWindow2.setOnDismissListener(b);
      } 
      b(0.5F);
      int k = cv.c((Context)cv.i());
      int m = cv.b((Context)cv.i());
      ImageView imageView = (ImageView)view.findViewById(ci.a((Context)a, 2131296283));
      imageView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      int n = imageView.getMeasuredWidth();
      i = imageView.getMeasuredHeight();
      bg.d = k / 2 - n / 2;
      bg.e = k / 2 + n / 2;
      bg.f = m - j - 24;
      bg.g = i + bg.f;
    } catch (Exception exception) {}
  }
  
  public static void b() {
    try {
      bp.a("FloatDragHidePopup...hide");
      if (b != null && b.isShowing()) {
        bp.a("FloatDragHidePopup...hide...if");
        b.dismiss();
        b = null;
        b(1.0F);
      } 
    } catch (Exception exception) {}
  }
  
  private static void b(float paramFloat) {
    try {
      WindowManager.LayoutParams layoutParams = a.getWindow().getAttributes();
      layoutParams.alpha = paramFloat;
      a.getWindow().setAttributes(layoutParams);
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */