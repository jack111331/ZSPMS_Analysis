package com.zz.sdk.h;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.zz.sdk.i.bg;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;

public class c {
  public static Activity a;
  
  public static PopupWindow b = null;
  
  private static LinearLayout c;
  
  private static LinearLayout d;
  
  private static TextView e;
  
  private static TextView f;
  
  public static void a() {
    try {
      bp.a("FloatNewGiftPopup...showNewGiftPopup");
      a = cv.i();
      View view = a.getLayoutInflater().inflate(ci.a((Context)a, 2130903125), null);
      view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      int i = view.getMeasuredWidth();
      int j = view.getMeasuredHeight();
      e = (TextView)view.findViewById(ci.a((Context)a, 2131296616));
      e.getPaint().setFlags(8);
      e.getPaint().setAntiAlias(true);
      TextView textView1 = e;
      d d = new d();
      this();
      textView1.setOnClickListener(d);
      c = (LinearLayout)view.findViewById(ci.a((Context)a, 2131296615));
      d = (LinearLayout)view.findViewById(ci.a((Context)a, 2131296617));
      f = (TextView)view.findViewById(ci.a((Context)a, 2131296618));
      f.getPaint().setFlags(8);
      f.getPaint().setAntiAlias(true);
      TextView textView2 = f;
      e e = new e();
      this();
      textView2.setOnClickListener(e);
      if (b == null) {
        PopupWindow popupWindow = new PopupWindow();
        this(view, i, j);
        b = popupWindow;
        popupWindow = b;
        BitmapDrawable bitmapDrawable = new BitmapDrawable();
        this();
        popupWindow.setBackgroundDrawable((Drawable)bitmapDrawable);
        j = bg.i + 4 + f.b(a).i();
        if (bg.h.booleanValue()) {
          c.setVisibility(0);
          d.setVisibility(4);
          b.showAtLocation(cv.i().getWindow().getDecorView(), 8388659, j, bg.j - 24);
          return;
        } 
      } else {
        return;
      } 
      d.setVisibility(0);
      c.setVisibility(4);
      b.showAtLocation(cv.i().getWindow().getDecorView(), 8388661, j, bg.j - 24);
    } catch (Exception exception) {}
  }
  
  public static void b() {
    try {
      bp.a("FloatDragHidePopup...hide");
      if (b != null && b.isShowing()) {
        bp.a("FloatDragHidePopup...hide...if");
        b.dismiss();
        b = null;
      } 
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\h\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */