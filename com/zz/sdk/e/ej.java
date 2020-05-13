package com.zz.sdk.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.zz.sdk.ParamChain;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.ce;
import com.zz.sdk.i.cg;
import java.util.ArrayList;
import java.util.List;

public class ej extends a {
  public List o = new ArrayList();
  
  private Context p;
  
  private int q = -1;
  
  public ej(Context paramContext, ParamChain paramParamChain) {
    super(paramContext, paramParamChain);
    c(paramContext);
    this.p = paramContext;
    v();
  }
  
  private void a(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3) {
    Button button1 = (Button)findViewById(em.g.a());
    Button button2 = (Button)findViewById(em.f.a());
    Button button3 = (Button)findViewById(em.e.a());
    if (paramDrawable1 != null) {
      button3.setTextColor(-1);
      button2.setTextColor(-16777216);
      button1.setTextColor(-16777216);
    } else if (paramDrawable2 != null) {
      button3.setTextColor(-16777216);
      button2.setTextColor(-1);
      button1.setTextColor(-16777216);
    } else {
      button3.setTextColor(-16777216);
      button2.setTextColor(-16777216);
      button1.setTextColor(-1);
    } 
    button1.setBackgroundDrawable(paramDrawable3);
    button1.setPadding(cc.a(10.0F), cc.a(0.0F), cc.a(10.0F), cc.a(0.0F));
    button2.setBackgroundDrawable(paramDrawable2);
    button2.setPadding(cc.a(10.0F), cc.a(0.0F), cc.a(10.0F), cc.a(0.0F));
    button3.setBackgroundDrawable(paramDrawable1);
    button3.setPadding(cc.a(10.0F), cc.a(0.0F), cc.a(10.0F), cc.a(0.0F));
  }
  
  private void a(em paramem) {
    if (em.e.a() == paramem.a()) {
      a(ca.aL.a(this.p), (Drawable)null, (Drawable)null);
      return;
    } 
    if (em.g.a() == paramem.a()) {
      a((Drawable)null, (Drawable)null, ca.aL.a(this.p));
      return;
    } 
    a((Drawable)null, ca.aL.a(this.p), (Drawable)null);
  }
  
  private void b(int paramInt) {
    LinearLayout linearLayout = (LinearLayout)findViewById(paramInt);
    if (linearLayout.getVisibility() == 0) {
      linearLayout.setVisibility(8);
      return;
    } 
    linearLayout.setVisibility(0);
  }
  
  private View d(Context paramContext) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    linearLayout.setOrientation(0);
    linearLayout.setPadding(cc.a(20.0F), 0, cc.a(20.0F), 0);
    LinearLayout.LayoutParams layoutParams = a(2);
    layoutParams.weight = 0.3F;
    layoutParams.setMargins(cc.a(10.0F), 0, cc.a(10.0F), 0);
    layoutParams.gravity = 1;
    int[] arrayOfInt1 = { 16842919 };
    int[] arrayOfInt2 = { 16842912 };
    ColorStateList colorStateList = new ColorStateList(new int[][] { arrayOfInt1, { 16842913 }, , arrayOfInt2, {} }, new int[] { -1, -1, -1, -16777216 });
    Button button = new Button(paramContext);
    button.setText("全部");
    button.setPadding(cc.a(10.0F), cc.a(0.0F), cc.a(10.0F), cc.a(0.0F));
    button.setTextColor(colorStateList);
    button.setId(em.e.a());
    button.setSelected(true);
    button.setBackgroundDrawable(ca.aL.a(paramContext));
    button.setOnClickListener(this);
    linearLayout.addView((View)button, (ViewGroup.LayoutParams)layoutParams);
    button = new Button(paramContext);
    button.setText("已成功");
    button.setTextColor(colorStateList);
    button.setId(em.f.a());
    button.setBackgroundColor(-1);
    button.setPadding(cc.a(10.0F), cc.a(0.0F), cc.a(10.0F), cc.a(0.0F));
    button.setOnClickListener(this);
    linearLayout.addView((View)button, (ViewGroup.LayoutParams)layoutParams);
    button = new Button(paramContext);
    button.setId(em.g.a());
    button.setText("未成功");
    button.setTextColor(colorStateList);
    button.setBackgroundColor(0);
    button.setPadding(cc.a(10.0F), cc.a(0.0F), cc.a(10.0F), cc.a(0.0F));
    button.setOnClickListener(this);
    linearLayout.addView((View)button, (ViewGroup.LayoutParams)layoutParams);
    linearLayout.setBackgroundDrawable(ca.aq.a(paramContext));
    return (View)linearLayout;
  }
  
  private View e(Context paramContext) {
    ExpandableListView expandableListView = new ExpandableListView(paramContext);
    en en = new en(this);
    expandableListView.setAdapter((ExpandableListAdapter)en);
    expandableListView.setOnItemClickListener(new ek(this, en));
    return (View)expandableListView;
  }
  
  private void v() {
    for (byte b = 0; b < 6; b++)
      this.o.add("88"); 
  }
  
  protected void a(Context paramContext, ParamChain paramParamChain) {}
  
  protected void b(Context paramContext) {
    FrameLayout frameLayout = getSubjectContainer();
    setTileTypeText("交易记录");
    LinearLayout linearLayout2 = new LinearLayout(paramContext);
    frameLayout.addView((View)linearLayout2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2, 17));
    linearLayout2.setId(em.a.a());
    linearLayout2.setVisibility(0);
    linearLayout2.setOrientation(1);
    ProgressBar progressBar = new ProgressBar(paramContext);
    progressBar.setIndeterminate(true);
    progressBar.setId(em.b.a());
    LinearLayout.LayoutParams layoutParams = a(2);
    layoutParams.gravity = 1;
    linearLayout2.addView((View)progressBar, (ViewGroup.LayoutParams)layoutParams);
    TextView textView2 = a(paramContext, cg.aY);
    textView2.setGravity(17);
    linearLayout2.addView((View)textView2, (ViewGroup.LayoutParams)a(3));
    textView2.setTextColor(ce.h.a());
    ScrollView scrollView = new ScrollView(paramContext);
    scrollView.setId(em.c.a());
    scrollView.setVisibility(8);
    scrollView.setVerticalScrollBarEnabled(false);
    frameLayout.addView((View)scrollView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    TextView textView1 = c(paramContext, cg.bs);
    textView1.setVisibility(8);
    textView1.setId(em.d.a());
    frameLayout.addView((View)textView1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    textView1.setTextColor(ce.l.a());
    textView1.setTextSize(18.0F);
    textView1.setGravity(17);
    LinearLayout linearLayout1 = new LinearLayout(paramContext);
    linearLayout1.setOrientation(1);
    linearLayout1.addView(d(paramContext));
    linearLayout1.addView(e(paramContext), (ViewGroup.LayoutParams)a(1));
    frameLayout.addView((View)linearLayout1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void onClick(View paramView) {
    em em = em.a(paramView.getId());
    switch (el.a[em.ordinal()]) {
      default:
        super.onClick(paramView);
        return;
      case 1:
        a(em);
        return;
      case 2:
        a(em);
        return;
      case 3:
        break;
    } 
    a(em);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */