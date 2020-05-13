package com.zz.sdk.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zz.sdk.ParamChain;
import com.zz.sdk.b.k;
import com.zz.sdk.b.m;
import com.zz.sdk.i.a;
import com.zz.sdk.i.aq;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cd;
import com.zz.sdk.i.cf;
import com.zz.sdk.i.cg;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.df;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import com.zz.sdk.lib.widget.roundview.RoundLinearLayout;
import com.zz.sdk.lib.widget.roundview.c;
import java.util.ArrayList;
import java.util.List;

public class ce extends a implements ViewPager.OnPageChangeListener {
  private ci A = new cf(this);
  
  private Context o;
  
  private TextView p;
  
  private TextView q;
  
  private TextView r;
  
  private ViewPager s;
  
  private List t = new ArrayList();
  
  private View u;
  
  private ha v;
  
  private String w;
  
  private ai x;
  
  private ia y;
  
  private ba z;
  
  public ce(Context paramContext, ParamChain paramParamChain) {
    super(paramContext, paramParamChain);
    this.o = paramContext;
    c(paramContext);
    this.p.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.s.setOnPageChangeListener(this);
    this.x = new ai(this.o, this.w, this);
    this.x.setOnItemClickListener(this.A);
    this.y = new ia(this.o, this.w);
    this.y.setOnItemClickListener(this.A);
    this.z = new ba(this.o, this.w);
    this.z.setOnItemClickListener(this.A);
    this.t.add(this.x);
    this.t.add(this.y);
    this.t.add(this.z);
    this.v = new ha(this.t);
    this.s.setAdapter(this.v);
    onClick((View)this.p);
    a(ch.a(this.p.getId()));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3) {
    TextView textView1 = (TextView)findViewById(ch.a.a());
    TextView textView2 = (TextView)findViewById(ch.b.a());
    TextView textView3 = (TextView)findViewById(ch.c.a());
    textView1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, paramInt1);
    textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, paramInt2);
    textView3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, paramInt3);
  }
  
  private void a(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3) {
    TextView textView1 = (TextView)findViewById(ch.c.a());
    TextView textView2 = (TextView)findViewById(ch.b.a());
    TextView textView3 = (TextView)findViewById(ch.a.a());
    textView1.setBackgroundDrawable(paramDrawable3);
    textView2.setBackgroundDrawable(paramDrawable2);
    textView3.setBackgroundDrawable(paramDrawable1);
  }
  
  private void a(m paramm, TextView paramTextView) {
    String str = paramm.g();
    aq aq = aq.a(str);
    switch (cg.a[aq.ordinal()]) {
      default:
        paramTextView.setText("(未知)" + str);
        paramTextView.setTextColor(-16777216);
        return;
      case 1:
      case 2:
        paramTextView.setText("正在充值中...");
        paramTextView.setTextColor(-7829368);
        return;
      case 3:
        paramTextView.setText("已成功");
        paramTextView.setTextColor(Color.rgb(60, 179, 113));
        return;
      case 4:
        if (a.a()) {
          str = cg.c.a();
        } else {
          str = cg.b.a();
        } 
        paramTextView.setText("充值为" + str);
        paramTextView.setTextColor(Color.rgb(60, 179, 113));
        return;
      case 5:
        paramTextView.setText("订单异常,请联系客服");
        paramTextView.setTextColor(-16776961);
        return;
      case 6:
        paramTextView.setText("下单失败");
        paramTextView.setTextColor(-65536);
        return;
      case 7:
        break;
    } 
    paramTextView.setText("支付失败");
    paramTextView.setTextColor(-65536);
  }
  
  private void a(ch paramch) {
    if (ch.a.a() == paramch.a()) {
      a(ci.a(this.o, 2130837670), ci.a(this.o, 2130837669), ci.a(this.o, 2130837669));
      return;
    } 
    if (ch.c.a() == paramch.a()) {
      a(ci.a(this.o, 2130837669), ci.a(this.o, 2130837669), ci.a(this.o, 2130837670));
      return;
    } 
    a(ci.a(this.o, 2130837669), ci.a(this.o, 2130837670), ci.a(this.o, 2130837669));
  }
  
  private TextView c(String paramString) {
    int i = cc.a(30.0F);
    TextView textView = new TextView(this.o);
    textView.setText(paramString);
    textView.setTextSize(2, 16.0F);
    textView.setTextColor(new ColorStateList(new int[][] { { 16842913 }, , { 16842910 },  }, new int[] { -236427, -7367267 }));
    textView.setGravity(17);
    textView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, i, 1.0F));
    return textView;
  }
  
  private void w() {
    setBackgroundColor(Color.rgb(245, 245, 245));
    FrameLayout frameLayout = getSubjectContainer();
    RelativeLayout relativeLayout = new RelativeLayout(this.o);
    relativeLayout.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    frameLayout.addView((View)relativeLayout);
    LinearLayout linearLayout = new LinearLayout(this.o);
    linearLayout.setGravity(17);
    linearLayout.setId(1);
    linearLayout.setOrientation(0);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, cc.b.a());
    int i = df.a(this.o, 40.0F);
    layoutParams.setMargins(i, 0, i, 0);
    relativeLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
    this.p = c(" 全 部 ");
    this.p.setId(ch.a.a());
    this.p.setTag(Integer.valueOf(1));
    this.p.setGravity(17);
    linearLayout.addView((View)this.p);
    this.q = c("充值成功");
    this.q.setId(ch.b.a());
    this.q.setTag(Integer.valueOf(1));
    this.q.setGravity(17);
    linearLayout.addView((View)this.q);
    this.r = c("充值失败");
    this.r.setId(ch.c.a());
    this.r.setTag(Integer.valueOf(1));
    this.r.setGravity(17);
    linearLayout.addView((View)this.r);
    this.s = new ViewPager(this.o);
    this.s.setOffscreenPageLimit(1);
    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
    layoutParams.addRule(3, linearLayout.getId());
    relativeLayout.addView((View)this.s, (ViewGroup.LayoutParams)layoutParams);
  }
  
  protected void a(Context paramContext, ParamChain paramParamChain) {
    this.w = (String)paramParamChain.get("global.user.login_name", String.class);
  }
  
  public void a(m paramm) {
    if (paramm != null) {
      RoundLinearLayout roundLinearLayout = new RoundLinearLayout(this.o);
      roundLinearLayout.setOrientation(1);
      c c = roundLinearLayout.getDelegate();
      c.c(5);
      c.a(-1);
      roundLinearLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(cc.a(275.0F), -2, 17));
      cd.b.a((View)roundLinearLayout);
      RelativeLayout relativeLayout2 = new RelativeLayout(this.o);
      cd.e.a((View)relativeLayout2);
      TextView textView3 = a(this.o, (cg)null);
      textView3.setText("充值金额");
      textView3.setTextColor(-13421773);
      cf.b.a(textView3);
      RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
      layoutParams5.addRule(15);
      relativeLayout2.addView((View)textView3, (ViewGroup.LayoutParams)layoutParams5);
      textView3 = a(this.o, (cg)null);
      textView3.setText("¥" + paramm.c());
      textView3.setGravity(5);
      textView3.setTextColor(-13421773);
      cf.g.a(textView3);
      layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
      layoutParams5.addRule(15);
      layoutParams5.addRule(11);
      relativeLayout2.addView((View)textView3, (ViewGroup.LayoutParams)layoutParams5);
      roundLinearLayout.addView((View)relativeLayout2);
      ImageView imageView = new ImageView(this.o);
      imageView.setBackgroundDrawable(ca.ar.a(this.o));
      roundLinearLayout.addView((View)imageView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, cc.a(1.0F)));
      RelativeLayout relativeLayout1 = new RelativeLayout(this.o);
      cd.e.a((View)relativeLayout1);
      textView3 = a(this.o, (cg)null);
      textView3.setText("订单号");
      textView3.setTextColor(-7367267);
      cf.h.a(textView3);
      layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
      layoutParams5.addRule(15);
      relativeLayout1.addView((View)textView3, (ViewGroup.LayoutParams)layoutParams5);
      textView3 = a(this.o, (cg)null);
      textView3.setText(paramm.d());
      textView3.setGravity(5);
      textView3.setTextColor(-13421773);
      cf.h.a(textView3);
      layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
      layoutParams5.addRule(15);
      layoutParams5.addRule(11);
      relativeLayout1.addView((View)textView3, (ViewGroup.LayoutParams)layoutParams5);
      roundLinearLayout.addView((View)relativeLayout1);
      relativeLayout1 = new RelativeLayout(this.o);
      cd.e.a((View)relativeLayout1);
      TextView textView5 = a(this.o, (cg)null);
      textView5.setText("订单状态");
      textView5.setTextColor(-7367267);
      cf.h.a(textView5);
      RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
      layoutParams3.addRule(15);
      relativeLayout1.addView((View)textView5, (ViewGroup.LayoutParams)layoutParams3);
      textView5 = a(this.o, (cg)null);
      a(paramm, textView5);
      textView5.setGravity(5);
      cf.h.a(textView5);
      layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
      layoutParams3.addRule(15);
      layoutParams3.addRule(11);
      relativeLayout1.addView((View)textView5, (ViewGroup.LayoutParams)layoutParams3);
      roundLinearLayout.addView((View)relativeLayout1);
      relativeLayout1 = new RelativeLayout(this.o);
      cd.e.a((View)relativeLayout1);
      TextView textView2 = a(this.o, (cg)null);
      textView2.setText("支付方式");
      textView2.setTextColor(-7367267);
      cf.h.a(textView2);
      RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
      layoutParams4.addRule(15);
      relativeLayout1.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams4);
      TextView textView4 = a(this.o, (cg)null);
      textView4.setText(k.a(cv.a(paramm.f(), 82)));
      textView4.setGravity(5);
      textView4.setTextColor(-13421773);
      cf.h.a(textView4);
      RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
      layoutParams2.addRule(15);
      layoutParams2.addRule(11);
      relativeLayout1.addView((View)textView4, (ViewGroup.LayoutParams)layoutParams2);
      roundLinearLayout.addView((View)relativeLayout1);
      relativeLayout1 = new RelativeLayout(this.o);
      cd.e.a((View)relativeLayout1);
      textView4 = a(this.o, (cg)null);
      textView4.setText("支付时间");
      textView4.setTextColor(-7367267);
      cf.h.a(textView4);
      layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
      layoutParams2.addRule(15);
      relativeLayout1.addView((View)textView4, (ViewGroup.LayoutParams)layoutParams2);
      TextView textView1 = a(this.o, (cg)null);
      textView1.setText(paramm.e());
      textView1.setGravity(5);
      textView1.setTextColor(-13421773);
      cf.h.a(textView1);
      RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
      layoutParams1.addRule(15);
      layoutParams1.addRule(11);
      relativeLayout1.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams1);
      roundLinearLayout.addView((View)relativeLayout1);
      FancyButton fancyButton = new FancyButton(this.f);
      fancyButton.setId(ch.d.a());
      fancyButton.setRadius(cc.a(25.0F));
      fancyButton.setBorderColor(-236427);
      fancyButton.setBackgroundColor(-236427);
      fancyButton.setFocusBackgroundColor(-1421723);
      fancyButton.setText("确认");
      fancyButton.setTextColor(-1);
      fancyButton.setTextSize(16);
      fancyButton.setOnClickListener(this);
      cd.v.a((View)fancyButton);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
      layoutParams.topMargin = cc.a(10.0F);
      layoutParams.gravity = 1;
      roundLinearLayout.addView((View)fancyButton, (ViewGroup.LayoutParams)layoutParams);
      a((View)roundLinearLayout);
    } 
  }
  
  protected void b(Context paramContext) {
    setTileTypeText("交易记录");
    w();
  }
  
  public void onClick(View paramView) {
    byte b;
    if (ch.a(paramView.getId()) == ch.d) {
      f();
      return;
    } 
    Object object = paramView.getTag();
    if (object != null && object instanceof Integer) {
      b = ((Integer)object).intValue();
    } else {
      b = -1;
    } 
    if (b == 1) {
      if (this.u != paramView) {
        if (this.u != null)
          this.u.setSelected(false); 
        this.u = paramView;
        if (paramView == this.p) {
          this.s.setCurrentItem(0);
          paramView.setSelected(true);
          return;
        } 
        if (paramView == this.q) {
          this.s.setCurrentItem(1);
          paramView.setSelected(true);
          return;
        } 
        if (paramView == this.r) {
          this.s.setCurrentItem(2);
          paramView.setSelected(true);
          return;
        } 
        if (paramView == this.a)
          b(); 
      } 
      return;
    } 
    super.onClick(paramView);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {
    if (paramInt == 0) {
      onClick((View)this.p);
      a(ch.a(this.p.getId()));
      return;
    } 
    if (paramInt == 1) {
      onClick((View)this.q);
      a(ch.a(this.q.getId()));
      return;
    } 
    onClick((View)this.r);
    a(ch.a(this.r.getId()));
  }
  
  public void v() {
    this.y.b();
    this.z.b();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */