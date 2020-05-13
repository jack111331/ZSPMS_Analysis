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
import com.zz.sdk.d.a;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Map;
import java.util.Timer;

public class ay extends w implements View.OnClickListener, a {
  private static final int t = 90;
  
  private Timer A = null;
  
  private int B = 90;
  
  protected EditText a;
  
  protected EditText n;
  
  protected ImageView o;
  
  protected FancyButton p;
  
  protected TextView q;
  
  private TextView r;
  
  private boolean s = false;
  
  private View u;
  
  private View x;
  
  private cq y;
  
  private v z;
  
  public ay(Activity paramActivity) {
    super(paramActivity);
  }
  
  public ay(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    G();
    bi bi = new bi(this);
    this.A = new Timer();
    this.A.schedule(bi, 0L, 1000L);
  }
  
  private void G() {
    if (this.A != null) {
      this.A.purge();
      this.A.cancel();
      this.A = null;
      this.s = true;
    } 
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    this.l.p();
    a.a().a((Context)this.b, paramString1, paramInt, paramString2, new bk(this));
  }
  
  private void a(String paramString1, String paramString2) {
    p();
    a.a().e((Context)this.b, paramString1, paramString2, new bc(this, paramString1));
    a.a().e((Context)this.b, paramString1, paramString2, new be(this, paramString1));
  }
  
  private void b(String paramString) {
    p();
    a.a().d((Context)this.b, paramString, new bg(this));
  }
  
  void a() {
    setTitle(2131165236);
    findViewById(2131296408).setOnClickListener(this);
    this.r = (TextView)findViewById(2131296405);
    if (this.z.i == 1) {
      str = cq.a((Context)this.b).a();
      if (!TextUtils.isEmpty(str)) {
        str = cv.p(cv.q(str));
      } else {
        str = cv.p(cv.q(this.z.b));
      } 
    } else {
      str = cq.a((Context)this.b).a();
      if (!TextUtils.isEmpty(str)) {
        str = cv.p(cv.q(str));
      } else {
        str = cv.p(this.y.k());
      } 
    } 
    String str = String.format(e(2131165356), new Object[] { str });
    this.r.setText((CharSequence)Html.fromHtml(str));
    this.x = findViewById(2131296352);
    this.u = findViewById(2131296349);
    this.o = (ImageView)findViewById(2131296406);
    this.o.setOnClickListener(this);
    this.a = (EditText)findViewById(2131296392);
    this.a.addTextChangedListener(new az(this));
    this.a.setOnFocusChangeListener(new ba(this));
    this.n = (EditText)findViewById(2131296407);
    this.n.setOnFocusChangeListener(new bb(this));
    this.p = (FancyButton)findViewById(2131296395);
    this.p.setOnClickListener(this);
    this.a.setText("");
    if (this.z.i == 1) {
      String str1 = cq.a((Context)this.b).a();
      str = str1;
      if (TextUtils.isEmpty(str1))
        str = this.z.b; 
      this.a.setText(str);
      this.a.setEnabled(false);
      this.n.requestFocus();
      return;
    } 
    if (!TextUtils.isEmpty(cq.a((Context)this.b).a())) {
      this.a.setText(cq.a((Context)this.b).a());
      this.a.setEnabled(false);
      this.n.requestFocus();
    } 
  }
  
  public void a(Boolean paramBoolean) {
    if (paramBoolean.booleanValue())
      a(this.a.getText().toString(), 2, cq.a((Context)this.b).j()); 
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.y = cq.a((Context)this.b);
    this.z = (cq.a((Context)this.b)).a;
  }
  
  int c() {
    return 2130903063;
  }
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296395) {
      String str = h.b((TextView)this.a);
      if (str != null) {
        if (!this.s) {
          b(str);
          return;
        } 
        (new br((Context)this.b, ci.a((Context)this.b, 2131230726), this)).show();
      } 
      return;
    } 
    if (i == 2131296408) {
      String str = h.b((TextView)this.a);
      if (str != null) {
        String str1 = this.n.getText().toString();
        if (TextUtils.isEmpty(str1)) {
          b(2131165249);
          return;
        } 
        a(str, str1);
      } 
      return;
    } 
    if (i == 2131296406)
      this.a.setText(""); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */