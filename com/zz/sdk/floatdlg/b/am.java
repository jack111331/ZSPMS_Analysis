package com.zz.sdk.floatdlg.b;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import com.zz.sdk.b.a.y;
import com.zz.sdk.b.h;
import com.zz.sdk.floatdlg.FloatDialog;
import com.zz.sdk.h.g;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.i.v;
import java.util.ArrayList;

public class am extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener, RadioGroup.OnCheckedChangeListener {
  private static t h;
  
  private Context a;
  
  private View b;
  
  private View c;
  
  private ListView d;
  
  private ListView e;
  
  private LinearLayout f;
  
  private ImageView g;
  
  private h[] i;
  
  private h[] j;
  
  public static am a() {
    return new am();
  }
  
  private void a(View paramView) {
    try {
      this.f = (LinearLayout)paramView.findViewById(ci.a(this.a, 2131296508));
      this.f.setOnClickListener(this);
      this.g = (ImageView)paramView.findViewById(ci.a(this.a, 2131296557));
      this.g.setOnClickListener(this);
      ((RadioGroup)paramView.findViewById(ci.a(this.a, 2131296558))).setOnCheckedChangeListener(this);
      this.b = paramView.findViewById(ci.a(this.a, 2131296561));
      this.c = paramView.findViewById(ci.a(this.a, 2131296562));
      this.d = (ListView)paramView.findViewById(ci.a(this.a, 2131296550));
      this.d.setEmptyView(paramView.findViewById(ci.a(this.a, 2131296551)));
      this.d.setOnItemClickListener(this);
      this.e = (ListView)paramView.findViewById(ci.a(this.a, 2131296605));
      this.e.setEmptyView(paramView.findViewById(ci.a(this.a, 2131296606)));
      this.e.setOnItemClickListener(this);
      b();
    } catch (Exception exception) {}
  }
  
  private void b() {
    try {
      h.a(this.a, false);
      h = t.a(this.a);
      Thread thread = new Thread();
      an an = new an();
      this(this);
      this(an);
      thread.start();
    } catch (Exception exception) {}
  }
  
  private void c() {
    boolean bool = false;
    if (cm.b((Context)getActivity(), (cq.a((Context)getActivity())).a.o))
      bool = true; 
    y y = h.a(bool);
    if (y.c()) {
      this.i = y.n;
      d();
      g();
    } else {
      bp.a("领取礼包数据请求失败：" + y.f());
    } 
    h.c();
  }
  
  private void d() {
    ArrayList<h> arrayList = new ArrayList();
    for (h h1 : this.i) {
      if (h1.k == 1)
        if (h1.i == 1) {
          if (h1.q < h1.r) {
            bp.a("");
            arrayList.add(h1);
          } 
        } else {
          arrayList.add(h1);
        }  
    } 
    if (arrayList.size() > 0) {
      v.q = true;
    } else {
      v.q = false;
    } 
    if (this.a instanceof FloatDialog)
      ((FloatDialog)this.a).a(); 
    g.b().l();
  }
  
  private void e() {
    y y = h.h();
    if (y.c()) {
      this.j = y.n;
      f();
    } else {
      bp.a("received gift error:" + y.f());
    } 
    h.c();
  }
  
  private void f() {
    cv.a(new ao(this));
  }
  
  private void g() {
    if (getActivity() != null)
      getActivity().runOnUiThread(new ap(this)); 
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt) {
    if (paramInt == ci.a(this.a, 2131296559)) {
      this.b.setVisibility(0);
      this.c.setVisibility(8);
      return;
    } 
    if (paramInt == ci.a(this.a, 2131296560)) {
      this.b.setVisibility(8);
      this.c.setVisibility(0);
    } 
  }
  
  public void onClick(View paramView) {
    getActivity().finish();
    getActivity().overridePendingTransition(0, 0);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    this.a = (Context)getActivity();
    View view = paramLayoutInflater.inflate(ci.a(this.a, 2130903119), paramViewGroup, false);
    a(view);
    return view;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    h h1;
    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
    if (paramAdapterView.getId() == ci.a(this.a).a(2131296550)) {
      h1 = this.i[paramInt];
    } else if (h1.getId() == ci.a(this.a).a(2131296605)) {
      h1 = this.j[paramInt];
    } else {
      h1 = null;
    } 
    fragmentManager.beginTransaction().replace(2131296257, as.a(h1)).addToBackStack(null).commit();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */