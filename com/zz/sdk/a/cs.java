package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.EditTextWithDel;
import java.util.Map;

public class cs extends w implements View.OnClickListener, View.OnFocusChangeListener {
  public static final String a = "phone";
  
  public static final String n = "email";
  
  private cq o;
  
  private t p;
  
  private boolean q = false;
  
  private boolean r = false;
  
  private ImageView s;
  
  private View t;
  
  private EditTextWithDel u;
  
  private String x;
  
  private String y;
  
  private String z;
  
  public cs(Activity paramActivity) {
    super(paramActivity);
  }
  
  private void F() {
    b(e(2131165279));
    String str1 = this.u.getText().toString();
    Pair pair = cq.o(str1);
    if (!((Boolean)pair.first).booleanValue()) {
      a((CharSequence)pair.second);
      r();
      return;
    } 
    if (this.x != null && this.x.equals("email")) {
      (new Thread(new cu(this, str1))).start();
      return;
    } 
    String str2 = (bs.a((Context)this.b)).c;
    String str3 = (bs.a((Context)this.b)).b;
    (bs.a((Context)this.b)).c = "";
    (bs.a((Context)this.b)).b = "";
    (new Thread(new cx(this, str2, str3, str1))).start();
  }
  
  void a() {
    setTitle(2131165236);
    this.o = cq.a((Context)this.b);
    this.p = t.a((Context)this.b);
    this.t = findViewById(2131296370);
    this.u = (EditTextWithDel)findViewById(2131296368);
    this.u.setTransformationMethod((TransformationMethod)new PasswordTransformationMethod());
    this.u.setOnFocusChangeListener(this);
    this.s = (ImageView)findViewById(2131296369);
    findViewById(2131296383).setOnClickListener(this);
    this.s.setOnClickListener(this);
    findViewById(2131296418).setOnClickListener(new ct(this));
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.x = (String)a("type");
    this.y = (String)a("email");
    this.z = (String)a("code");
  }
  
  int c() {
    return 2130903075;
  }
  
  public void onClick(View paramView) {
    switch (a(paramView)) {
      default:
        return;
      case 2131296369:
        if (this.r)
          this.q = h.a(this.q, (Context)this.b, this.u, this.s); 
      case 2131296383:
        break;
    } 
    t.a((Context)this.b).b("Login_platform", "platform_modify", 1);
    F();
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    this.r = h.a(paramBoolean, this.s);
    h.a((Context)this.b, null, paramBoolean, null, null, this.t);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */