package com.zz.sdk.floatdlg.tabview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zz.sdk.R;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.cv;
import java.util.ArrayList;
import java.util.List;

public class TabView extends RelativeLayout {
  private static final int a = -1;
  
  private static final int b = -2;
  
  private static final int c = -2;
  
  private static final int d = -1;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private List m;
  
  private int n = 3;
  
  private int o = 0;
  
  private LinearLayout p;
  
  private List q;
  
  private FrameLayout r;
  
  private FragmentManager s;
  
  private Fragment[] t;
  
  private int u = 0;
  
  private int v;
  
  private Context w;
  
  private b x = null;
  
  public TabView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    try {
      a(paramContext);
      a(paramContext, paramAttributeSet);
      b(paramContext);
    } catch (Exception exception) {}
  }
  
  private void a(int paramInt, TypedArray paramTypedArray) {
    if (paramInt == 0) {
      this.e = paramTypedArray.getColor(paramInt, this.e);
      return;
    } 
    if (paramInt == 1) {
      this.f = paramTypedArray.getColor(paramInt, this.f);
      return;
    } 
    if (paramInt == 2) {
      this.g = paramTypedArray.getColor(paramInt, this.g);
      return;
    } 
    if (paramInt == 3) {
      this.h = paramTypedArray.getDimensionPixelSize(paramInt, this.h);
      return;
    } 
    if (paramInt == 4) {
      this.i = paramTypedArray.getDimensionPixelSize(paramInt, this.i);
      return;
    } 
    if (paramInt == 5) {
      this.j = paramTypedArray.getDimensionPixelSize(paramInt, this.j);
      return;
    } 
    if (paramInt == 6) {
      this.k = paramTypedArray.getDimensionPixelSize(paramInt, this.k);
      return;
    } 
    if (paramInt == 7) {
      this.l = paramTypedArray.getDimensionPixelSize(paramInt, this.l);
      return;
    } 
    if (paramInt == 8) {
      this.n = paramTypedArray.getInt(paramInt, this.n);
      return;
    } 
    if (paramInt == 9)
      this.o = paramTypedArray.getInteger(paramInt, this.o); 
  }
  
  private void a(Context paramContext) {
    this.w = paramContext;
    this.e = Color.rgb(252, 88, 17);
    this.f = Color.rgb(129, 130, 149);
    this.g = Color.rgb(255, 255, 255);
    this.h = d.a(paramContext, 52.0F);
    this.i = d.a(paramContext, 2.0F);
    this.j = d.b(paramContext, 14.0F);
    this.k = d.a(paramContext, 30.0F);
    this.l = d.a(paramContext, 30.0F);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TabView);
    int i = typedArray.getIndexCount();
    for (byte b1 = 0; b1 < i; b1++)
      a(typedArray.getIndex(b1), typedArray); 
    typedArray.recycle();
  }
  
  private void b() {
    this.p.removeAllViews();
    this.q = new ArrayList();
    this.t = new Fragment[this.m.size()];
    byte b1;
    for (b1 = 0; b1 < this.t.length; b1++) {
      c c = this.m.get(b1);
      this.t[b1] = c.d();
    } 
    if (this.o >= this.m.size()) {
      String str = this.t[0].getClass().getName();
      str = str.substring(str.lastIndexOf(".") + 1);
      bp.a("TabView...initTabChildView if tag:" + str);
      this.s.beginTransaction().add(2131296257, this.t[0], str).show(this.t[0]).commit();
    } else {
      String str = this.t[this.o].getClass().getName();
      str = str.substring(str.lastIndexOf(".") + 1);
      bp.a("TabView...initTabChildView else tag:" + str);
      this.s.beginTransaction().add(2131296257, this.t[this.o], str).show(this.t[this.o]).commit();
    } 
    for (b1 = 0; b1 < this.m.size(); b1++) {
      LinearLayout.LayoutParams layoutParams1;
      c c = this.m.get(b1);
      LinearLayout linearLayout = new LinearLayout(getContext());
      linearLayout.setGravity(17);
      linearLayout.setOrientation(1);
      if (cv.u(this.w)) {
        layoutParams1 = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        layoutParams1.gravity = 16;
      } else {
        layoutParams1 = new LinearLayout.LayoutParams(0, -1, 1.0F);
        layoutParams1.gravity = 1;
      } 
      linearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
      ImageView imageView = new ImageView(getContext());
      LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.k, this.l);
      layoutParams2.gravity = 17;
      imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
      imageView.setImageResource(c.b());
      this.q.add(Integer.valueOf(c.b()));
      linearLayout.addView((View)imageView);
      TextView textView = new TextView(getContext());
      textView.setText(c.c());
      textView.setTextColor(this.f);
      textView.setTextSize(0, this.j);
      layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
      layoutParams2.gravity = 17;
      layoutParams2.topMargin = this.i;
      textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
      linearLayout.addView((View)textView);
      this.p.addView((View)linearLayout);
      if (this.o >= this.m.size()) {
        if (b1 == 0) {
          imageView.setImageResource(c.a());
          textView.setText(c.c());
          textView.setTextColor(this.e);
        } 
      } else if (this.o == b1) {
        imageView.setImageResource(c.a());
        textView.setText(c.c());
        textView.setTextColor(this.e);
      } 
      linearLayout.setOnClickListener(new a(this, imageView, c, textView, b1));
    } 
  }
  
  private void b(Context paramContext) {
    RelativeLayout.LayoutParams layoutParams1;
    this.p = new LinearLayout(paramContext);
    this.p.setId(2131296256);
    this.r = new FrameLayout(paramContext);
    this.r.setId(2131296257);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    if (cv.u(paramContext)) {
      layoutParams1 = new RelativeLayout.LayoutParams(this.h, -1);
      this.p.setOrientation(1);
      layoutParams1.addRule(9);
      layoutParams2.addRule(1, 2131296256);
    } else {
      layoutParams1 = new RelativeLayout.LayoutParams(-1, this.h);
      this.p.setOrientation(0);
      layoutParams1.addRule(12);
      layoutParams2.addRule(2, 2131296256);
    } 
    this.p.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.p.setBackgroundColor(this.g);
    this.r.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    addView((View)this.p);
    addView((View)this.r);
  }
  
  private void c() {
    for (byte b1 = 0; b1 < this.p.getChildCount(); b1++) {
      LinearLayout linearLayout = (LinearLayout)this.p.getChildAt(b1);
      for (byte b2 = 0; b2 < linearLayout.getChildCount(); b2++) {
        ImageView imageView = (ImageView)linearLayout.getChildAt(0);
        TextView textView = (TextView)linearLayout.getChildAt(1);
        imageView.setImageResource(((Integer)this.q.get(b1)).intValue());
        textView.setTextColor(this.f);
      } 
    } 
  }
  
  private void d() {
    if (this.v != this.u) {
      FragmentTransaction fragmentTransaction = this.s.beginTransaction();
      fragmentTransaction.hide(this.t[this.v]);
      String str = this.t[this.u].getClass().getName();
      str = str.substring(str.lastIndexOf(".") + 1);
      if (!this.t[this.u].isAdded() && this.s.findFragmentByTag(str) == null) {
        bp.a("TabView...initTabChildView if tag:" + str);
        fragmentTransaction.add(2131296257, this.t[this.u], str);
        fragmentTransaction.show(this.t[this.u]).commitAllowingStateLoss();
      } else {
        a();
        fragmentTransaction.show(this.t[this.u]).commitAllowingStateLoss();
      } 
    } 
    this.v = this.u;
  }
  
  public void a() {
    int i = this.s.getBackStackEntryCount();
    bp.a("TabView...backStackCount:" + i);
    for (byte b1 = 0; b1 < i; b1++)
      this.s.popBackStack(); 
  }
  
  public void a(List paramList, FragmentManager paramFragmentManager) {
    this.m = paramList;
    this.s = paramFragmentManager;
    if (this.o >= paramList.size()) {
      this.u = 0;
      this.v = 0;
      this.o = 0;
    } 
    b();
  }
  
  public void setImageViewHeight(int paramInt) {
    this.l = paramInt;
  }
  
  public void setImageViewTextViewMargin(int paramInt) {
    this.i = paramInt;
  }
  
  public void setImageViewWidth(int paramInt) {
    this.k = paramInt;
  }
  
  public void setOnTabChildClickListener(b paramb) {
    this.x = paramb;
  }
  
  public void setTabViewBackgroundColor(int paramInt) {
    this.g = paramInt;
    this.p.setBackgroundColor(paramInt);
  }
  
  public void setTabViewDefaultPosition(int paramInt) {
    this.o = paramInt;
    this.u = paramInt;
    this.v = paramInt;
  }
  
  public void setTabViewGravity(int paramInt) {
    this.n = paramInt;
  }
  
  public void setTabViewHeight(int paramInt) {
    this.h = paramInt;
  }
  
  public void setTextViewSelectedColor(int paramInt) {
    this.e = paramInt;
  }
  
  public void setTextViewSize(int paramInt) {
    this.j = d.b(getContext(), paramInt);
  }
  
  public void setTextViewUnSelectedColor(int paramInt) {
    this.f = paramInt;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\tabview\TabView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */