package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.zz.sdk.a.a.a;
import com.zz.sdk.b.a.n;
import com.zz.sdk.b.e;
import com.zz.sdk.b.f;
import com.zz.sdk.b.v;
import com.zz.sdk.c.a;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class k extends w implements View.OnClickListener {
  private TextView a;
  
  private GridView n;
  
  private cq o;
  
  private v p;
  
  private List q = new ArrayList();
  
  private a r;
  
  private String s;
  
  private String t;
  
  private String u;
  
  public k(Activity paramActivity) {
    super(paramActivity);
  }
  
  public k(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    p();
    a.a().c((Context)this.b, cq.a((Context)this.b).v(), new m(this));
  }
  
  private void a(n paramn) {
    this.o.b(paramn.X);
    this.s = paramn.Z;
    this.t = paramn.aa;
    this.u = paramn.j();
    byte b = 0;
    boolean bool = false;
    while (b < this.q.size()) {
      byte b1;
      e e = this.q.get(b);
      switch (o.a[e.c.ordinal()]) {
        case 1:
          if (paramn.W == 0) {
            b1 = 1;
          } else {
            b1 = 2;
          } 
          e.d = b1;
          if (e.d == 2) {
            e.b = e(ci.a((Context)this.b, 2131165236));
          } else {
            e.b = e(ci.a((Context)this.b, 2131165367));
          } 
          b++;
          break;
        case 2:
          if (TextUtils.isEmpty(paramn.X)) {
            b1 = 1;
          } else {
            b1 = 2;
          } 
          e.d = b1;
          b++;
          break;
        case 3:
          if (paramn.Y == 0) {
            b1 = 1;
          } else {
            b1 = 2;
          } 
          e.d = b1;
          b++;
          break;
        case 4:
          bool = true;
          b++;
          break;
      } 
    } 
    if (!TextUtils.isEmpty(this.u) && !bool) {
      e e = new e();
      e.a = f.g.i;
      e.b = e(f.g.j);
      e.c = f.g.k;
      this.q.add(e);
    } 
    if (this.r != null)
      this.r.notifyDataSetChanged(); 
  }
  
  void a() {
    String str;
    this.a = (TextView)findViewById(2131296376);
    this.n = (GridView)findViewById(2131296377);
    if (this.p.i == 1) {
      if (!TextUtils.isEmpty(this.u)) {
        str = cv.p(this.u);
      } else {
        str = cv.p(this.o.k());
      } 
    } else if (!TextUtils.isEmpty(this.u)) {
      str = cv.p(this.u);
    } else {
      str = cv.p(this.o.k());
    } 
    this.a.setText((CharSequence)Html.fromHtml(e(2131165349) + str));
    this.r = new a((Context)this.b, this.q);
    this.n.setAdapter((ListAdapter)this.r);
    this.n.setOnItemClickListener(new l(this));
  }
  
  public void a(Map paramMap) {
    List<f> list;
    super.a(paramMap);
    this.o = cq.a((Context)this.b);
    this.p = this.o.a;
    this.u = this.o.a();
    if (this.p.i == 1 || !TextUtils.isEmpty(this.u)) {
      list = f.b(1);
    } else {
      list = f.b(this.p.i);
    } 
    byte b = 0;
    while (b < list.size()) {
      continue;
      f = list.get(b);
      switch (o.a[f.k.ordinal()]) {
        case 1:
        case 5:
        
      } 
    } 
  }
  
  int c() {
    return 2130903057;
  }
  
  public void e() {
    super.e();
    F();
  }
  
  public void f() {
    super.f();
    F();
  }
  
  public void onClick(View paramView) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */