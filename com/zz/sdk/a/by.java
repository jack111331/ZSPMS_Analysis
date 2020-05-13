package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.zz.sdk.b.v;
import com.zz.sdk.c.a;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Map;

public class by extends w implements View.OnClickListener {
  protected TextView a;
  
  protected EditText n;
  
  protected ImageView o;
  
  protected FancyButton p;
  
  private View q;
  
  private cq r;
  
  private v s;
  
  public by(Activity paramActivity) {
    super(paramActivity);
  }
  
  private void b(String paramString) {
    c(2131165272);
    a.a().f((Context)this.b, cq.a((Context)this.b).v(), paramString, new cb(this, paramString));
  }
  
  void a() {
    String str;
    setTitle(2131165328);
    if (this.s.i == 1) {
      str = cq.a((Context)this.b).a();
      if (!TextUtils.isEmpty(str)) {
        str = cv.p(cv.q(str));
      } else {
        str = cv.p(this.s.b);
      } 
    } else {
      str = cq.a((Context)this.b).a();
      if (!TextUtils.isEmpty(str)) {
        str = cv.p(cv.q(str));
      } else {
        str = cv.p(this.r.k());
      } 
    } 
    this.a = (TextView)findViewById(2131296415);
    this.a.setText((CharSequence)Html.fromHtml(String.format(e(2131165330), new Object[] { str })));
    this.o = (ImageView)findViewById(2131296406);
    this.o.setOnClickListener(this);
    this.o.setVisibility(8);
    this.q = findViewById(2131296417);
    this.n = (EditText)findViewById(2131296416);
    this.n.addTextChangedListener(new bz(this));
    this.n.setOnFocusChangeListener(new ca(this));
    this.p = (FancyButton)findViewById(2131296408);
    this.p.setOnClickListener(this);
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.r = cq.a((Context)this.b);
    this.s = (cq.a((Context)this.b)).a;
  }
  
  int c() {
    return 2130903069;
  }
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296406) {
      this.n.setText("");
      return;
    } 
    if (i == 2131296408) {
      t.a((Context)this.b).b("Bind_platform", "bind_email_next", 1);
      String str = this.n.getEditableText().toString().trim();
      if (TextUtils.isEmpty(str)) {
        b(2131165333);
        return;
      } 
      if (!h.b(str)) {
        b(2131165334);
        return;
      } 
      b(str);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */