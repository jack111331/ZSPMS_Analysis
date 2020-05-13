package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.zz.sdk.c.a;
import com.zz.sdk.d.a;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Timer;

public class jl extends w implements View.OnClickListener, a {
  private static final int p = 90;
  
  private View A;
  
  private boolean B = false;
  
  private boolean C = false;
  
  private ContentObserver D;
  
  private Timer E = null;
  
  private int F = 90;
  
  protected ImageView a;
  
  protected FancyButton n;
  
  private boolean o = false;
  
  private EditText q;
  
  private EditText r;
  
  private FancyButton s;
  
  private EditText t;
  
  private ImageView u;
  
  private ImageView x;
  
  private View y;
  
  private View z;
  
  public jl(Activity paramActivity) {
    super(paramActivity);
  }
  
  public jl(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    G();
    jt jt = new jt(this);
    this.E = new Timer();
    this.E.schedule(jt, 0L, 1000L);
  }
  
  private void G() {
    if (this.E != null) {
      this.E.purge();
      this.E.cancel();
      this.E = null;
      this.o = true;
    } 
  }
  
  private void a(String paramString1, int paramInt, String paramString2) {
    this.l.p();
    a.a().a((Context)this.b, paramString1, paramInt, paramString2, new jv(this));
  }
  
  private void a(String paramString1, String paramString2, String paramString3) {
    p();
    a.a().b((Context)this.b, paramString1, paramString2, paramString3, "", "", new jp(this));
  }
  
  public static boolean a(boolean paramBoolean, Context paramContext, EditText paramEditText, ImageView paramImageView) {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramBoolean) {
      try {
        PasswordTransformationMethod passwordTransformationMethod = new PasswordTransformationMethod();
        this();
        paramEditText.setTransformationMethod((TransformationMethod)passwordTransformationMethod);
        paramImageView.setImageDrawable(ca.cM.a(paramContext));
        paramBoolean = bool2;
        if (!TextUtils.isEmpty(paramEditText.getText().toString().trim())) {
          paramEditText.setSelection(paramEditText.getText().toString().trim().length());
          paramBoolean = bool2;
        } 
        return paramBoolean;
      } catch (Throwable null) {
        paramBoolean = bool1;
      } 
    } else {
      paramEditText.setTransformationMethod(null);
      paramImageView.setImageDrawable(ca.cL.a((Context)throwable));
      try {
        if (!TextUtils.isEmpty(paramEditText.getText().toString().trim()))
          paramEditText.setSelection(paramEditText.getText().toString().trim().length()); 
        paramBoolean = true;
      } catch (Throwable throwable) {
        paramBoolean = true;
      } 
      return paramBoolean;
    } 
    throwable.printStackTrace();
    return paramBoolean;
  }
  
  private void b(String paramString) {
    p();
    a.a().e((Context)this.b, paramString, new jr(this));
  }
  
  void a() {
    setTitle(2131165256);
    this.a = (ImageView)findViewById(2131296406);
    this.a.setOnClickListener(this);
    this.z = findViewById(2131296352);
    this.y = findViewById(2131296349);
    this.A = findViewById(2131296379);
    this.q = (EditText)findViewById(2131296392);
    this.q.addTextChangedListener(new jx(this, (View)this.a, null));
    this.q.setOnFocusChangeListener(new jm(this));
    this.r = (EditText)findViewById(2131296407);
    this.r.setOnFocusChangeListener(new jn(this));
    this.s = (FancyButton)findViewById(2131296395);
    this.s.setOnClickListener(this);
    this.n = (FancyButton)findViewById(2131296467);
    this.n.setOnClickListener(this);
    findViewById(2131296491).setOnClickListener(this);
    h.a((TextView)findViewById(2131296488));
    this.q.setText("");
    this.x = (ImageView)findViewById(2131296369);
    this.x.setOnClickListener(this);
    this.u = (ImageView)findViewById(2131296490);
    this.u.setOnClickListener(this);
    this.t = (EditText)findViewById(2131296489);
    this.t.setTransformationMethod((TransformationMethod)new PasswordTransformationMethod());
    this.t.addTextChangedListener(new jx(this, (View)this.u, (View)this.x));
    this.t.setOnFocusChangeListener(new jo(this));
    this.t.setText("");
    this.D = h.a((Context)this.b, (TextView)this.q, (TextView)this.r);
  }
  
  public void a(Boolean paramBoolean) {
    if (paramBoolean.booleanValue())
      a(this.q.getText().toString(), 0, cq.a((Context)this.b).j()); 
  }
  
  int c() {
    return 2130903095;
  }
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296395) {
      t.a((Context)this.b).b("Login_platform", "register_phone_code", 1);
      String str = h.b((TextView)this.q);
      if (str != null && !this.o) {
        b(str);
        return;
      } 
      if (str != null && this.o)
        (new br((Context)this.b, ci.a((Context)this.b, 2131230726), this)).show(); 
      return;
    } 
    if (i == 2131296467) {
      t.a((Context)this.b).b("Login_platform", "register_phone", 1);
      String str = h.b((TextView)this.q);
      if (str != null) {
        String str1 = this.r.getText().toString();
        if (TextUtils.isEmpty(str1)) {
          b(2131165249);
          return;
        } 
        String str2 = this.t.getText().toString();
        Pair pair = cq.o(str2);
        if (!((Boolean)pair.first).booleanValue()) {
          a((CharSequence)pair.second);
          return;
        } 
        a(str, str1, str2);
      } 
      return;
    } 
    if (i == 2131296406) {
      this.q.setText("");
      return;
    } 
    if (i == 2131296490) {
      this.t.setText("");
      return;
    } 
    if (i == 2131296491) {
      t.a((Context)this.b).b("Login_platform", "register_platform_click", 1);
      if (!cv.a((TextView)this.q, e(2131165276))) {
        (bs.a((Context)this.b)).i = this.q.getText().toString();
        (bs.a((Context)this.b)).j = this.r.getText().toString().trim();
        (bs.a((Context)this.b)).k = this.t.getText().toString().trim();
        bv.a(this.b, p.class, z());
      } 
      return;
    } 
    if (i == 2131296369 && this.B)
      this.C = a(this.C, (Context)this.b, this.t, this.x); 
  }
  
  public void s() {
    super.s();
    try {
      if (this.D != null)
        this.b.getContentResolver().unregisterContentObserver(this.D); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\jl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */