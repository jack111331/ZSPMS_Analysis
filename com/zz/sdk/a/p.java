package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.zz.sdk.c.a;
import com.zz.sdk.i.a;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.EditTextWithDel;
import com.zz.sdk.lib.widget.VerificationCodeView;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;

public class p extends w implements View.OnClickListener, View.OnFocusChangeListener {
  private cq A;
  
  private ImageView B;
  
  private EditText C;
  
  private View D;
  
  private View E;
  
  private View F;
  
  private ImageView a;
  
  private ImageView n;
  
  private boolean o = false;
  
  private TextView p;
  
  private TextView q;
  
  private VerificationCodeView r;
  
  private EditTextWithDel s;
  
  private EditTextWithDel t;
  
  private String u;
  
  private String x;
  
  private String y;
  
  private FancyButton z;
  
  public p(Activity paramActivity) {
    super(paramActivity);
  }
  
  private void F() {
    this.r.setEnabled(false);
    this.r.setvCode("");
    a.a().a((Context)this.b, new s(this));
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    c(2131165244);
    a.a().a((Context)this.b, paramString1, paramString2, paramString3, paramString4, paramString5, new u(this));
  }
  
  private void g(boolean paramBoolean) {
    if (this.B != null) {
      if (paramBoolean) {
        this.B.setVisibility(0);
        return;
      } 
    } else {
      return;
    } 
    this.B.setVisibility(8);
  }
  
  void a() {
    setTitle(2131165255);
    this.A = cq.a((Context)this.b);
    this.s = (EditTextWithDel)findViewById(2131296361);
    this.D = findViewById(2131296378);
    this.F = findViewById(2131296352);
    this.E = findViewById(2131296379);
    this.s.setOnFocusChangeListener(new q(this));
    this.t = (EditTextWithDel)findViewById(2131296368);
    this.t.setTransformationMethod((TransformationMethod)new PasswordTransformationMethod());
    this.t.setOnFocusChangeListener(this);
    this.C = (EditText)findViewById(2131296381);
    this.C.setOnFocusChangeListener(new r(this));
    this.z = (FancyButton)findViewById(2131296383);
    this.z.setOnClickListener(this);
    this.r = (VerificationCodeView)findViewById(2131296382);
    this.r.setOnClickListener(this);
    this.r.setNetCode(true);
    F();
    this.p = (TextView)findViewById(2131296384);
    this.B = (ImageView)findViewById(2131296369);
    this.B.setOnClickListener(this);
    this.a = (ImageView)findViewById(2131296367);
    this.n = (ImageView)findViewById(2131296363);
    if (a.a()) {
      this.p.setText(e(2131165228));
    } else {
      this.p.setText("库洛游戏隐私政策");
    } 
    this.p.setOnClickListener(this);
    this.q = (TextView)findViewById(2131296385);
    this.q.setOnClickListener(this);
  }
  
  public void a(ImageView paramImageView, boolean paramBoolean, Context paramContext, Drawable paramDrawable1, Drawable paramDrawable2) {
    if (paramBoolean) {
      paramImageView.setImageDrawable(paramDrawable1);
      return;
    } 
    paramImageView.setImageDrawable(paramDrawable2);
  }
  
  int c() {
    return 2130903058;
  }
  
  public void onClick(View paramView) {
    switch (a(paramView)) {
      default:
        return;
      case 2131296382:
        t.a((Context)this.b).b("Login_platform", "register_code", 1);
        F();
      case 2131296384:
        t.a((Context)this.b).b("Login_platform", "register_protocol", 1);
        if (!cv.a((TextView)this.s, e(2131165276))) {
          String str = this.s.getText().toString();
          (bs.a((Context)this.b)).g = str;
          str = this.t.getText().toString().trim();
          (bs.a((Context)this.b)).h = str;
          h.a(this.b, "库洛游戏隐私政策");
        } 
      case 2131296385:
        if (!cv.a((TextView)this.s, e(2131165276))) {
          String str = this.s.getText().toString();
          (bs.a((Context)this.b)).g = str;
          str = this.t.getText().toString().trim();
          (bs.a((Context)this.b)).h = str;
          h.a(this.b, "库洛游戏用户协议");
        } 
      case 2131296383:
        t.a((Context)this.b).b("Login_platform", "register_platform", 1);
        if (!cv.a((TextView)this.s, e(2131165276))) {
          this.u = this.s.getText().toString();
          Pair pair = cq.i(this.u);
          if (!((Boolean)pair.first).booleanValue())
            Toast.makeText((Context)this.b, (CharSequence)pair.second, 0).show(); 
          this.x = this.t.getText().toString().trim();
          pair = cq.o(this.x);
          if (!((Boolean)pair.first).booleanValue())
            Toast.makeText((Context)this.b, (CharSequence)pair.second, 0).show(); 
          this.y = this.C.getText().toString().trim();
          if (TextUtils.isEmpty(this.y))
            Toast.makeText((Context)this.b, this.C.getHint(), 0).show(); 
          a(this.u, this.x, (bs.a((Context)this.b)).n, (bs.a((Context)this.b)).o, this.y);
        } 
      case 2131296369:
        break;
    } 
    this.o = h.a(this.o, (Context)this.b, this.t, this.B);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    g(paramBoolean);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */