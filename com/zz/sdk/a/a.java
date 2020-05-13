package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;
import com.zz.sdk.b.v;
import com.zz.sdk.b.w;
import com.zz.sdk.e.br;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.EditTextWithDel;

public class a extends w implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener {
  static v[] a;
  
  private ImageView A;
  
  private ImageView B;
  
  private ImageView C;
  
  private TextView D;
  
  private TextView E;
  
  private cq n;
  
  private String o;
  
  private String p;
  
  private boolean q = false;
  
  private ImageView r;
  
  private boolean s = false;
  
  private MultiAutoCompleteTextView t;
  
  private EditTextWithDel u;
  
  private br x;
  
  private br y;
  
  private ImageView z;
  
  public a(Activity paramActivity) {
    super(paramActivity);
  }
  
  private void a(Context paramContext) {
    v v1;
    a = w.a(paramContext).a(0);
    if (a != null) {
      this.y = new br(paramContext, a);
      this.t.setAdapter((ListAdapter)this.y);
      this.t.setOnItemClickListener(new f(this));
      if (a.length > 0) {
        v1 = a[0];
        this.t.setText(v1.b);
        this.u.setText(v1.c);
      } 
      this.x = this.y;
    } else {
      this.x = new br((Context)v1, new v[0]);
    } 
    this.x.a(new g(this));
  }
  
  private void a(String paramString1, String paramString2) {
    c(2131165244);
    com.zz.sdk.c.a.a().a((Context)this.b, paramString1, paramString2, new i(this));
  }
  
  private void g(boolean paramBoolean) {
    if (paramBoolean) {
      if (!TextUtils.isEmpty(this.t.getText().toString().trim()))
        this.z.setVisibility(0); 
      return;
    } 
    this.z.setVisibility(8);
  }
  
  void a() {
    this.n = cq.a((Context)this.b);
    v v1 = this.n.a;
    h.a((ImageView)findViewById(2131296360));
    if (v1 != null && v1.h == 0) {
      this.o = this.n.j();
      this.p = this.n.r();
    } 
    this.z = (ImageView)findViewById(2131296364);
    this.z.setOnClickListener(this);
    this.t = (MultiAutoCompleteTextView)findViewById(2131296361);
    this.t.setOnFocusChangeListener(this);
    this.t.addTextChangedListener(this);
    this.t.setOnEditorActionListener(new b(this));
    this.u = (EditTextWithDel)findViewById(2131296368);
    this.u.setTransformationMethod((TransformationMethod)new PasswordTransformationMethod());
    this.D = (TextView)findViewById(2131296366);
    this.E = (TextView)findViewById(2131296370);
    this.t.setBackgroundDrawable(null);
    if (this.o != null && this.o.length() > 0)
      this.t.setText(this.o); 
    this.t.setSingleLine(true);
    this.t.setDropDownBackgroundDrawable(this.b.getResources().getDrawable(ci.a((Context)this.b, 2130837542)));
    this.t.clearListSelection();
    this.t.setAutoLinkMask(1);
    this.t.setTokenizer((MultiAutoCompleteTextView.Tokenizer)new MultiAutoCompleteTextView.CommaTokenizer());
    this.t.setOnKeyListener(new c(this));
    this.C = (ImageView)findViewById(2131296369);
    this.C.setOnClickListener(this);
    this.u.setOnFocusChangeListener(new d(this));
    this.u.setOnClickListener(new e(this));
    this.u.setImeOptions(6);
    if (this.p != null && this.p.length() > 0)
      this.u.setText(this.p); 
    this.u.a();
    this.A = (ImageView)findViewById(2131296363);
    this.B = (ImageView)findViewById(2131296365);
    this.B.setOnClickListener(this);
    this.r = (ImageView)findViewById(2131296367);
    TextView textView2 = (TextView)findViewById(2131296373);
    TextView textView1 = (TextView)findViewById(2131296374);
    findViewById(2131296371).setOnClickListener(this);
    findViewById(2131296374).setOnClickListener(this);
    textView1.getPaint().setFlags(8);
    findViewById(2131296372).setOnClickListener(this);
    findViewById(2131296375).setOnClickListener(this);
    a((Context)this.b);
    if (cv.a("accReg", "enabled", "1").equals("1")) {
      textView2.setVisibility(0);
      textView1.setVisibility(0);
      return;
    } 
    textView2.setVisibility(8);
    textView1.setVisibility(8);
  }
  
  public void afterTextChanged(Editable paramEditable) {
    if (this.t.hasFocus() && !TextUtils.isEmpty(this.t.getText().toString().trim())) {
      this.z.setVisibility(0);
      return;
    } 
    this.z.setVisibility(8);
  }
  
  protected boolean b() {
    return true;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  int c() {
    return 2130903056;
  }
  
  public void d() {
    super.d();
  }
  
  public void e() {
    super.e();
    this.n = cq.a((Context)this.b);
    a((Context)this.b);
  }
  
  public void onClick(View paramView) {
    switch (a(paramView)) {
      default:
        return;
      case 2131296364:
        this.t.setText("");
      case 2131296365:
        if (this.x.getCount() > 3) {
          this.t.setDropDownHeight(a(120.0F));
        } else {
          this.t.setDropDownHeight(-2);
        } 
        this.t.showDropDown();
      case 2131296369:
        if (this.q)
          this.s = h.a(this.s, (Context)this.b, this.u, this.C); 
      case 2131296371:
        t.a((Context)this.b).b("Login_platform", "platform_login", 1);
        if (!cv.a((TextView)this.t, e(2131165276))) {
          this.o = this.t.getText().toString();
          Pair pair = cq.h(this.o);
          if (!((Boolean)pair.first).booleanValue())
            Toast.makeText((Context)this.b, (CharSequence)pair.second, 0).show(); 
          this.p = this.u.getText().toString().trim();
          pair = cq.l(this.p);
          if (!((Boolean)pair.first).booleanValue())
            Toast.makeText((Context)this.b, (CharSequence)pair.second, 0).show(); 
          a(this.o, this.p);
        } 
      case 2131296374:
        t.a((Context)this.b).b("Login_platform", "platform_register_click", 1);
        bv.a(this.b, p.class, z());
      case 2131296372:
        t.a((Context)this.b).b("Login_platform", "platform_modify_click", 1);
        if (!cv.a((TextView)this.t, e(2131165276))) {
          String str = this.t.getText().toString();
          if (str != null && str.length() >= 6)
            (bs.a((Context)this.b)).e = str; 
          str = this.u.getText().toString().trim();
          if (str != null && str.length() >= 6)
            (bs.a((Context)this.b)).f = str; 
          bv.a(this.b, gn.class, z());
        } 
      case 2131296375:
        break;
    } 
    t.a((Context)this.b).b("Login_platform", "platform_forget_click", 1);
    this.o = this.t.getText().toString();
    bv.a(this.b, da.class, z().a("account", this.o), false);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    g(paramBoolean);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */