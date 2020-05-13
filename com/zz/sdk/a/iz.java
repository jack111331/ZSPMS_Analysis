package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
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
import java.util.Timer;

public class iz extends w implements View.OnClickListener, a {
  private static final int t = 90;
  
  private int A = 90;
  
  protected EditText a;
  
  protected ImageView n;
  
  protected EditText o;
  
  protected FancyButton p;
  
  protected FancyButton q;
  
  protected TextView r;
  
  private boolean s = false;
  
  private View u;
  
  private View x;
  
  private ContentObserver y;
  
  private Timer z = null;
  
  public iz(Activity paramActivity) {
    super(paramActivity);
  }
  
  public iz(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    G();
    jh jh = new jh(this);
    this.z = new Timer();
    this.z.schedule(jh, 0L, 1000L);
  }
  
  private void G() {
    if (this.z != null) {
      this.z.purge();
      this.z.cancel();
      this.z = null;
      this.s = true;
    } 
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    this.l.p();
    a.a().a((Context)this.b, paramString1, paramInt, paramString2, new jj(this));
  }
  
  private void a(String paramString1, String paramString2) {
    c(2131165244);
    a.a().b((Context)this.b, paramString1, paramString2, new jd(this));
  }
  
  private void b(String paramString) {
    p();
    a.a().b((Context)this.b, paramString, new jf(this));
  }
  
  void a() {
    setTitle(2131165212);
    this.n = (ImageView)findViewById(2131296406);
    this.n.setOnClickListener(this);
    this.a = (EditText)findViewById(2131296392);
    this.a.addTextChangedListener(new ja(this));
    this.u = findViewById(2131296349);
    this.x = findViewById(2131296352);
    this.a.setOnFocusChangeListener(new jb(this));
    this.a.setText((CharSequence)a("phone", ""));
    this.o = (EditText)findViewById(2131296407);
    this.o.setOnFocusChangeListener(new jc(this));
    this.p = (FancyButton)findViewById(2131296395);
    this.p.setOnClickListener(this);
    this.q = (FancyButton)findViewById(2131296467);
    this.q.setOnClickListener(this);
    this.r = (TextView)findViewById(2131296488);
    h.a(this.r);
    this.y = h.a((Context)this.b, (TextView)this.a, (TextView)this.o);
  }
  
  public void a(Boolean paramBoolean) {
    if (paramBoolean.booleanValue())
      a(this.a.getText().toString(), 3, cq.a((Context)this.b).j()); 
  }
  
  int c() {
    return 2130903094;
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
      } else {
        return;
      } 
      (new br((Context)this.b, ci.a((Context)this.b, 2131230726), this)).show();
      return;
    } 
    if (i == 2131296467) {
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
  
  public void s() {
    super.s();
    try {
      if (this.y != null)
        this.b.getContentResolver().unregisterContentObserver(this.y); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\iz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */