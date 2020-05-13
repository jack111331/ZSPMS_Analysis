package com.zz.sdk.floatdlg.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.zz.sdk.SDKManager;
import com.zz.sdk.a.a.c;
import com.zz.sdk.b.a.aa;
import com.zz.sdk.b.h;
import com.zz.sdk.b.v;
import com.zz.sdk.c.a;
import com.zz.sdk.i.bg;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.ArrayList;
import java.util.List;

public class ax extends Fragment implements View.OnClickListener {
  private Context a;
  
  private ImageView b;
  
  private LinearLayout c;
  
  private LinearLayout d;
  
  private GridView e;
  
  private TextView f;
  
  private c g;
  
  private FancyButton h;
  
  private TextView i;
  
  private TextView j;
  
  private FancyButton k;
  
  private FancyButton l;
  
  private FancyButton m;
  
  private FancyButton n;
  
  private ImageView o;
  
  private TextView p;
  
  private cq q;
  
  private v r;
  
  private boolean s;
  
  private List t = new ArrayList();
  
  private aa u;
  
  private TextView v;
  
  private TextView w;
  
  private Handler x = new ay(this);
  
  private void a() {
    try {
      this.q = cq.a(this.a);
      this.r = this.q.a;
      this.s = false;
      if (!TextUtils.isEmpty(this.q.a()))
        this.s = true; 
    } catch (Exception exception) {}
  }
  
  private void a(int paramInt) {
    try {
      if (!bg.k) {
        if (paramInt == 0) {
          this.v.setText(getString(ci.a(this.a, 2131165370)));
          this.j.setText("");
          return;
        } 
      } else {
        return;
      } 
      this.v.setText(getString(ci.a(this.a, 2131165288)));
      this.j.setText(getString(ci.a(this.a, 2131165289)));
      this.j.setTextColor(getResources().getColor(ci.a(this.a, 2131034286)));
    } catch (Exception exception) {}
  }
  
  private void a(int paramInt1, int paramInt2) {
    this.l.setVisibility(paramInt1);
    this.m.setVisibility(paramInt2);
  }
  
  private void a(View paramView) {
    try {
      bp.a("FM...initViews");
      a();
      cv.v((Context)getActivity());
      this.d = (LinearLayout)paramView.findViewById(ci.a(this.a, 2131296521));
      this.e = (GridView)paramView.findViewById(ci.a(this.a, 2131296522));
      this.f = (TextView)paramView.findViewById(ci.a(this.a, 2131296512));
      this.b = (ImageView)paramView.findViewById(ci.a(this.a, 2131296283));
      this.b.setOnClickListener(this);
      this.h = (FancyButton)paramView.findViewById(ci.a(this.a, 2131296294));
      this.h.setOnClickListener(this);
      this.k = (FancyButton)paramView.findViewById(ci.a(this.a, 2131296517));
      this.k.setOnClickListener(this);
      this.i = (TextView)paramView.findViewById(ci.a(this.a, 2131296519));
      this.j = (TextView)paramView.findViewById(ci.a(this.a, 2131296516));
      this.j.setOnClickListener(this);
      this.l = (FancyButton)paramView.findViewById(ci.a(this.a, 2131296291));
      this.l.setOnClickListener(this);
      this.m = (FancyButton)paramView.findViewById(ci.a(this.a, 2131296520));
      this.m.setOnClickListener(this);
      this.n = (FancyButton)paramView.findViewById(ci.a(this.a, 2131296514));
      this.n.setOnClickListener(this);
      this.o = (ImageView)paramView.findViewById(ci.a(this.a, 2131296282));
      this.o.setOnClickListener(this);
      this.c = (LinearLayout)paramView.findViewById(ci.a(this.a, 2131296508));
      this.c.setOnClickListener(this);
      this.p = (TextView)paramView.findViewById(ci.a(this.a, 2131296513));
      this.v = (TextView)paramView.findViewById(ci.a(this.a, 2131296515));
      this.w = (TextView)paramView.findViewById(ci.a(this.a, 2131296518));
      b();
      if (this.r.i == 1) {
        bp.a("FM...initViews...if");
        String str2 = this.q.a();
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
          str1 = this.q.k(); 
        str2 = cv.p(str1);
        this.f.setText((CharSequence)Html.fromHtml(str2));
        this.i.setText(cv.q(str1));
        a(8, 0);
      } else if (this.r.i == 3) {
        bp.a("FM...initViews...else if");
        if (this.s) {
          this.i.setText(cv.q(this.q.a()));
          a(8, 0);
          String str = cv.p(this.q.a());
          this.f.setText((CharSequence)Html.fromHtml(str));
        } else {
          this.i.setText(getString(ci.a(this.a, 2131165386)));
          a(0, 8);
          String str = cv.p(this.q.k());
          this.f.setText((CharSequence)Html.fromHtml(str));
        } 
      } else {
        bp.a("FM...initViews...else");
        if (this.s) {
          this.i.setText(cv.q(this.q.a()));
          a(8, 0);
          String str = cv.p(this.q.a());
          this.f.setText((CharSequence)Html.fromHtml(str));
        } else {
          this.i.setText(getString(ci.a(this.a, 2131165386)));
          bp.a("");
          a(0, 8);
          String str = cv.p(this.q.k());
          this.f.setText((CharSequence)Html.fromHtml(str));
        } 
      } 
      this.p.setText(cq.a(this.a).s());
      c c1 = new c();
      this(this.a, this.t);
      this.g = c1;
      this.e.setAdapter((ListAdapter)this.g);
      c();
      Thread thread = new Thread();
      az az = new az();
      this(this);
      this(az);
      thread.start();
    } catch (Exception exception) {}
  }
  
  private void b() {
    if (bg.k) {
      this.j.setText(this.a.getString(ci.a(this.a, 2131165291)));
      this.j.setTextColor(getResources().getColor(ci.a(this.a, 2131034299)));
      this.k.setText(getString(ci.a(this.a, 2131165435)));
      return;
    } 
    this.j.setText(getString(ci.a(this.a, 2131165289)));
    this.j.setTextColor(getResources().getColor(ci.a(this.a, 2131034286)));
    this.k.setText(getString(ci.a(this.a, 2131165290)));
  }
  
  private void b(int paramInt) {
    try {
      if (this.r.i != 1 && !this.s) {
        if (paramInt == 0) {
          this.w.setText(getString(ci.a(this.a, 2131165232)));
          this.i.setText("");
          return;
        } 
      } else {
        return;
      } 
      this.w.setText(getString(ci.a(this.a, 2131165472)));
      this.i.setText(getString(ci.a(this.a, 2131165386)));
    } catch (Exception exception) {}
  }
  
  private void c() {
    bp.a("FM...getGameData");
    a.a().g(this.a, cq.a(this.a).v(), new ba(this));
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == ci.a(this.a, 2131296294)) {
      getActivity().getSupportFragmentManager().beginTransaction().replace(2131296257, ae.a(false, (h)null)).addToBackStack(null).commit();
      return;
    } 
    if (i == ci.a(this.a, 2131296514)) {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
      SDKManager.getInstance((Context)cv.i()).showLoginView(bg.m, bg.n, false);
      return;
    } 
    if (i == ci.a(this.a, 2131296282)) {
      getActivity().getSupportFragmentManager().beginTransaction().replace(2131296257, bc.a(this.f.getText().toString())).addToBackStack(null).commit();
      return;
    } 
    if (i == ci.a(this.a, 2131296517)) {
      if (!bg.k) {
        ((FragmentActivity)this.a).getSupportFragmentManager().beginTransaction().replace(2131296257, be.a(false)).addToBackStack(null).commit();
        return;
      } 
      ((FragmentActivity)this.a).getSupportFragmentManager().beginTransaction().replace(2131296257, new br()).addToBackStack(null).commit();
      return;
    } 
    if (i == ci.a(this.a, 2131296291)) {
      ((FragmentActivity)this.a).getSupportFragmentManager().beginTransaction().replace(2131296257, a.a(false)).addToBackStack(null).commit();
      return;
    } 
    if (i == ci.a(this.a, 2131296520)) {
      ((FragmentActivity)this.a).getSupportFragmentManager().beginTransaction().replace(2131296257, new bw()).addToBackStack(null).commit();
      return;
    } 
    if (i == ci.a(this.a, 2131296283) || i == ci.a(this.a, 2131296508)) {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.a = (Context)getActivity();
    bp.a("FM...onCreateView");
    View view = paramLayoutInflater.inflate(ci.a(this.a, 2130903105), paramViewGroup, false);
    a(view);
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    bp.a("FM...onDestroy");
  }
  
  public void onResume() {
    super.onResume();
    bp.a("FM...onResume");
    b();
    try {
      if (this.u != null && !bg.k) {
        if (this.u.h() == 0) {
          this.j.setText("");
          return;
        } 
      } else {
        return;
      } 
      this.j.setText(getString(ci.a(this.a, 2131165289)));
      this.j.setTextColor(getResources().getColor(ci.a(this.a, 2131034286)));
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */