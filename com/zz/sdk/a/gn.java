package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.zz.sdk.c.a;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.EditTextWithDel;
import java.util.Map;

public class gn extends w implements View.OnClickListener {
  private ImageView A;
  
  private ImageView B;
  
  private ImageView C;
  
  private EditTextWithDel D;
  
  private EditTextWithDel E;
  
  private ImageView F;
  
  private ImageView G;
  
  private EditTextWithDel H;
  
  private String a;
  
  private String n;
  
  private String o;
  
  private boolean p = false;
  
  private boolean q = false;
  
  private boolean r = false;
  
  private boolean s = false;
  
  private View t;
  
  private View u;
  
  private View x;
  
  private cq y;
  
  private boolean z;
  
  public gn(Activity paramActivity) {
    super(paramActivity);
  }
  
  private void F() {
    if (!cv.a((TextView)this.H, e(2131165276))) {
      this.a = this.H.getText().toString();
      Pair pair = cq.h(this.a);
      if (!((Boolean)pair.first).booleanValue()) {
        Toast.makeText((Context)this.b, (CharSequence)pair.second, 0).show();
        return;
      } 
      this.n = this.D.getText().toString().trim();
      pair = cq.m(this.n);
      if (!((Boolean)pair.first).booleanValue()) {
        a((CharSequence)pair.second);
        return;
      } 
      this.o = this.E.getText().toString().trim();
      pair = cq.n(this.o);
      if (!((Boolean)pair.first).booleanValue()) {
        a((CharSequence)pair.second);
        return;
      } 
      if (this.o.equals(this.n)) {
        b(2131165275);
        return;
      } 
      a(this.a, this.n, this.o);
    } 
  }
  
  private void a(String paramString1, String paramString2, String paramString3) {
    c(2131165245);
    a.a().a((Context)this.b, paramString1, paramString2, paramString3, new gr(this));
  }
  
  void a() {
    setTitle(2131165236);
    this.y = cq.a((Context)this.b);
    this.A = (ImageView)findViewById(2131296363);
    this.B = (ImageView)findViewById(2131296367);
    this.C = (ImageView)findViewById(2131296471);
    this.H = (EditTextWithDel)findViewById(2131296361);
    String str = (bs.a((Context)this.b)).e;
    this.t = findViewById(2131296469);
    this.u = findViewById(2131296470);
    this.x = findViewById(2131296474);
    if (str != null && str.length() >= 6)
      this.H.setText(str); 
    this.H.setOnFocusChangeListener(new go(this));
    this.D = (EditTextWithDel)findViewById(2131296368);
    this.D.setTransformationMethod((TransformationMethod)new PasswordTransformationMethod());
    str = (bs.a((Context)this.b)).f;
    if (str != null && str.length() >= 6)
      this.D.setText(str); 
    this.D.setOnFocusChangeListener(new gp(this));
    this.E = (EditTextWithDel)findViewById(2131296472);
    this.E.setTransformationMethod((TransformationMethod)new PasswordTransformationMethod());
    this.E.setOnFocusChangeListener(new gq(this));
    findViewById(2131296383).setOnClickListener(this);
    this.F = (ImageView)findViewById(2131296369);
    this.F.setOnClickListener(this);
    this.G = (ImageView)findViewById(2131296473);
    this.G.setOnClickListener(this);
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.z = ((Boolean)a("isUserPlatform", Boolean.valueOf(false))).booleanValue();
  }
  
  int c() {
    return 2130903086;
  }
  
  public void onClick(View paramView) {
    switch (a(paramView)) {
      default:
        return;
      case 2131296383:
        t.a((Context)this.b).b("Login_platform", "platform_modify", 1);
        F();
      case 2131296369:
        if (this.p)
          this.r = h.a(this.r, (Context)this.b, this.D, this.F); 
      case 2131296473:
        break;
    } 
    if (this.q)
      this.s = h.a(this.s, (Context)this.b, this.E, this.G); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\gn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */