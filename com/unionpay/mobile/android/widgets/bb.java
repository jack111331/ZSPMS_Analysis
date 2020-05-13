package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class bb {
  private static int a = com.unionpay.mobile.android.global.a.r;
  
  private static int b = 40;
  
  private static List<Integer> i = new ArrayList<Integer>(10);
  
  private Context c = null;
  
  private View.OnClickListener d = null;
  
  private PopupWindow e = null;
  
  private View f = null;
  
  private ScrollView g = null;
  
  private int h = -1;
  
  private PopupWindow.OnDismissListener j = new bc(this);
  
  static {
    for (byte b = 0; b < 10; b++)
      i.add(Integer.valueOf(b)); 
  }
  
  public bb(Context paramContext, View.OnClickListener paramOnClickListener, View paramView) {
    this.c = paramContext;
    this.d = paramOnClickListener;
    a = g.a(this.c, 55.0F);
    b = g.a(this.c, 40.0F);
    ViewParent viewParent = (ViewParent)paramView;
    while (true) {
      if (viewParent != null)
        if (viewParent instanceof ScrollView) {
          this.g = (ScrollView)viewParent;
          k.a("UPWidgetKeyBoard", "mSV : " + this.g.toString());
          k.a("UPWidgetKeyBoard", "mSV H:" + this.g.getHeight());
          this.f = ((ScrollView)viewParent).getChildAt(0);
        } else {
          viewParent = viewParent.getParent();
          continue;
        }  
      RelativeLayout relativeLayout2 = new RelativeLayout(paramContext);
      (new RelativeLayout.LayoutParams(-1, -2)).setMargins(0, 0, 0, 0);
      relativeLayout2.setBackgroundColor(-1342177280);
      RelativeLayout relativeLayout1 = new RelativeLayout(paramContext);
      relativeLayout1.setBackgroundColor(-13290188);
      RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
      layoutParams.setMargins(0, 0, 0, 0);
      relativeLayout2.addView((View)relativeLayout1, (ViewGroup.LayoutParams)layoutParams);
      relativeLayout1.addView((View)new b(this, this.c), (ViewGroup.LayoutParams)layoutParams);
      this.e = new PopupWindow((View)relativeLayout2, -1, -2, true);
      new RelativeLayout.LayoutParams(-1, -2);
      this.e.setBackgroundDrawable((Drawable)new BitmapDrawable());
      this.e.setOutsideTouchable(false);
      this.e.setFocusable(false);
      this.e.setOnDismissListener(this.j);
      return;
    } 
  }
  
  private static int d() {
    int i = a * 4 + b;
    k.c("UPWidgetKeyBoard", "kbH=" + i);
    return i;
  }
  
  public final void a() {
    if (this.e != null)
      this.e.dismiss(); 
  }
  
  public final void a(View paramView) {
    if (this.e != null) {
      this.e.showAtLocation(paramView, 80, 0, 0);
      if (this.f != null) {
        paramView.setVisibility(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.g.getLayoutParams();
        this.h = marginLayoutParams.height;
        Rect rect = new Rect();
        paramView.getWindowVisibleDisplayFrame(rect);
        marginLayoutParams.height = com.unionpay.mobile.android.global.a.t - rect.top - com.unionpay.mobile.android.global.a.k - d();
        k.a("UPWidgetKeyBoard", "height = " + marginLayoutParams.height);
        marginLayoutParams.bottomMargin = d();
        this.g.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
      } 
    } 
  }
  
  public final boolean b() {
    return this.e.isShowing();
  }
  
  private final class a extends BaseAdapter {
    private a(bb this$0) {}
    
    public final int getCount() {
      return bb.c().size() + 2;
    }
    
    public final Object getItem(int param1Int) {
      return null;
    }
    
    public final long getItemId(int param1Int) {
      return param1Int;
    }
    
    public final View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      int i = 10;
      LinearLayout linearLayout = new LinearLayout(bb.c(this.a));
      Drawable drawable1 = c.a(bb.c(this.a)).a(1022);
      Drawable drawable2 = c.a(bb.c(this.a)).a(1022);
      linearLayout.setBackgroundDrawable(h.a(drawable1, drawable2, drawable2, drawable1));
      linearLayout.setMinimumHeight(g.a(bb.c(this.a), 55.0F));
      linearLayout.setClickable(true);
      linearLayout.setOnClickListener(bb.d(this.a));
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
      layoutParams.gravity = 17;
      if (param1Int == 9 || param1Int == 11) {
        ImageView imageView = new ImageView(bb.c(this.a));
        if (param1Int != 9)
          i = 20; 
        if (param1Int == 9) {
          param1Int = 1024;
        } else {
          param1Int = 1025;
        } 
        imageView.setImageDrawable(c.a(bb.c(this.a)).a(param1Int, -1, g.a(bb.c(this.a), 20.0F)));
        linearLayout.setId(i);
        linearLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams);
        return (View)linearLayout;
      } 
      TextView textView = new TextView(bb.c(this.a));
      textView.setTextColor(-1);
      textView.getPaint().setFakeBoldText(true);
      textView.setTextSize(30.0F);
      textView.setGravity(17);
      i = param1Int;
      if (param1Int == 10)
        i = 9; 
      param1Int = ((Integer)bb.c().get(i)).intValue();
      linearLayout.setId(param1Int);
      textView.setText(param1Int);
      linearLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
      return (View)linearLayout;
    }
  }
  
  private final class b extends LinearLayout {
    public b(bb this$0, Context param1Context) {
      super(param1Context);
      setOrientation(1);
      setBackgroundColor(-11316397);
      LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      layoutParams2.gravity = 17;
      LinearLayout linearLayout = new LinearLayout(param1Context);
      int i = g.a(param1Context, 5.0F);
      linearLayout.setPadding(0, i, 0, i);
      linearLayout.setGravity(17);
      linearLayout.setBackgroundColor(-13816531);
      linearLayout.setOrientation(0);
      i = g.a(param1Context, 24.0F);
      Drawable drawable = c.a(param1Context).a(1020, -1, i);
      ImageView imageView = new ImageView(param1Context);
      imageView.setImageDrawable(drawable);
      linearLayout.addView((View)imageView);
      addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
      Collections.shuffle(bb.c());
      LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      layoutParams1.gravity = 17;
      GridView gridView = new GridView(param1Context);
      gridView.setNumColumns(3);
      gridView.setAdapter((ListAdapter)new bb.a((byte)0));
      gridView.setGravity(17);
      gridView.setStretchMode(2);
      gridView.setHorizontalScrollBarEnabled(false);
      gridView.setVerticalScrollBarEnabled(false);
      gridView.setEnabled(true);
      i = g.a(bb.c(this.a), 1.0F);
      gridView.setHorizontalSpacing(i);
      gridView.setVerticalSpacing(i);
      int j = -i;
      gridView.setPadding(j, i, j, j);
      addView((View)gridView, (ViewGroup.LayoutParams)layoutParams1);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */