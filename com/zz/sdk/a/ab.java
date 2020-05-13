package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.zz.sdk.c.a;
import com.zz.sdk.d.a;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.h;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Map;
import java.util.Timer;

public class ab extends w implements View.OnClickListener, a {
  private static final int u = 90;
  
  private Timer A = null;
  
  private int B = 90;
  
  protected EditText a;
  
  protected ImageView n;
  
  protected EditText o;
  
  protected FancyButton p;
  
  protected FancyButton q;
  
  protected TextView r;
  
  public String s;
  
  private boolean t = false;
  
  private View x;
  
  private View y;
  
  private String z;
  
  public ab(Activity paramActivity) {
    super(paramActivity);
  }
  
  public ab(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    G();
    aj aj = new aj(this);
    this.A = new Timer();
    this.A.schedule(aj, 0L, 1000L);
  }
  
  private void G() {
    if (this.A != null) {
      this.A.purge();
      this.A.cancel();
      this.A = null;
      this.t = true;
    } 
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    this.l.p();
    a.a().a((Context)this.b, paramString1, paramInt, paramString2, new al(this));
  }
  
  private void a(String paramString1, String paramString2) {
    c(2131165272);
    a.a().a((Context)this.b, this.s, this.z, paramString1, paramString2, 6, new af(this, paramString1));
  }
  
  private void b(String paramString) {
    p();
    a.a().a((Context)this.b, this.s, paramString, 6, new ah(this));
  }
  
  void a() {
    setTitle(2131165363);
    findViewById(2131296408).setOnClickListener(this);
    this.y = findViewById(2131296352);
    this.x = findViewById(2131296349);
    this.n = (ImageView)findViewById(2131296406);
    this.n.setOnClickListener(this);
    this.a = (EditText)findViewById(2131296392);
    this.a.addTextChangedListener(new ac(this));
    this.a.setOnFocusChangeListener(new ad(this));
    this.o = (EditText)findViewById(2131296407);
    this.o.setOnFocusChangeListener(new ae(this));
    this.p = (FancyButton)findViewById(2131296395);
    this.p.setOnClickListener(this);
    this.a.setText("");
  }
  
  public void a(Boolean paramBoolean) {
    if (paramBoolean.booleanValue())
      a(this.a.getText().toString(), 6, cq.a((Context)this.b).j()); 
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.z = (String)a("oldPhone");
    this.s = cq.a((Context)this.b).v();
  }
  
  int c() {
    return 2130903064;
  }
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296395) {
      String str = h.b((TextView)this.a);
      if (str != null) {
        if (str.equals(this.z)) {
          b(2131165380);
          return;
        } 
        if (!this.t) {
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
        String str1 = this.o.getText().toString();
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */