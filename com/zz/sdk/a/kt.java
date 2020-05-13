package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.zz.sdk.a.a.c;
import com.zz.sdk.a.a.m;
import com.zz.sdk.b.e;
import com.zz.sdk.b.f;
import com.zz.sdk.b.v;
import com.zz.sdk.c.a;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class kt extends w implements View.OnClickListener {
  private List A = new ArrayList();
  
  private LinearLayout a;
  
  private LinearLayout n;
  
  private GridView o;
  
  private GridView p;
  
  private TextView q;
  
  private c r;
  
  private m s;
  
  private cq t;
  
  private v u;
  
  private boolean x;
  
  private String y;
  
  private List z = new ArrayList();
  
  public kt(Activity paramActivity) {
    super(paramActivity);
  }
  
  public kt(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    List<f> list;
    bp.a("UPD...getFunctionData");
    this.z.clear();
    if (this.u.i == 1 || this.x) {
      list = f.a(1);
    } else {
      list = f.a(this.u.i);
    } 
    for (byte b = 0; b < list.size(); b++) {
      f f = list.get(b);
      e e = new e();
      e.a = f.i;
      e.b = e(f.j);
      e.c = f.k;
      this.z.add(e);
    } 
  }
  
  private void G() {
    bp.a("UPD...getGameData");
    a.a().g((Context)this.b, cq.a((Context)this.b).v(), new kv(this));
  }
  
  void a() {
    bp.a("UPD...initView");
    setTitle(2131165344);
    B();
    findViewById(2131296502).setOnClickListener(this);
    this.a = (LinearLayout)findViewById(2131296501);
    this.o = (GridView)findViewById(2131296503);
    this.n = (LinearLayout)findViewById(2131296504);
    this.p = (GridView)findViewById(2131296505);
    this.q = (TextView)findViewById(2131296284);
    if (this.u.i == 1) {
      String str1 = this.t.a();
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
        str2 = this.t.k(); 
      str2 = cv.p(str2);
      this.a.setVisibility(8);
      this.q.setText((CharSequence)Html.fromHtml(str2));
      this.y = e(2131165347);
    } else if (this.u.i == 3) {
      if (this.x) {
        String str = cv.p(this.t.a());
        this.a.setVisibility(8);
        this.q.setText((CharSequence)Html.fromHtml(str));
        this.y = e(2131165347);
      } else {
        String str = cv.p(this.t.k());
        this.q.setText((CharSequence)Html.fromHtml(e(2131165345) + str));
        this.y = e(2131165348);
      } 
    } else if (this.x) {
      String str = cv.p(this.t.a());
      this.a.setVisibility(8);
      this.q.setText((CharSequence)Html.fromHtml(str));
      this.y = e(2131165347);
    } else {
      String str = cv.p(this.t.k());
      this.q.setText((CharSequence)Html.fromHtml(e(2131165346) + str));
      this.y = e(2131165186);
    } 
    this.s = new m((Context)this.b, this.z);
    this.o.setAdapter((ListAdapter)this.s);
    this.o.setOnItemClickListener(new ku(this));
    this.r = new c((Context)this.b, this.A);
    this.p.setAdapter((ListAdapter)this.r);
    G();
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    bp.a("UPD...initData");
    this.t = cq.a((Context)this.b);
    this.u = this.t.a;
    this.x = false;
    if (!TextUtils.isEmpty(this.t.a()))
      this.x = true; 
    F();
  }
  
  int c() {
    return 2130903102;
  }
  
  public void e() {
    super.e();
    bp.a("UPD...onResume");
    if (!TextUtils.isEmpty(this.t.a()))
      this.x = true; 
    if (this.u.i != 1 && this.x) {
      String str = cv.p(this.t.a());
      this.a.setVisibility(8);
      this.q.setText((CharSequence)Html.fromHtml(str));
      this.y = e(2131165347);
    } 
    F();
    if (this.s != null)
      this.s.notifyDataSetChanged(); 
  }
  
  public void onClick(View paramView) {
    switch (a(paramView)) {
      default:
        return;
      case 2131296502:
        break;
    } 
    bv.a(this.b, fr.class, z().a("key_user", this.u).a("canBack", Boolean.valueOf(true)), true);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\kt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */