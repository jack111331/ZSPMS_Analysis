package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zz.sdk.b.v;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.lib.widget.EditTextWithDel;
import java.util.Map;

public class kc extends w implements View.OnClickListener {
  private TextView a;
  
  private v n;
  
  private View o;
  
  private EditTextWithDel p;
  
  private ImageView q;
  
  private boolean r = false;
  
  private boolean s = false;
  
  private cq t;
  
  public kc(Activity paramActivity) {
    super(paramActivity);
  }
  
  public kc(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    b(e(2131165279));
    String str1 = this.p.getText().toString();
    Pair pair = cq.o(str1);
    if (!((Boolean)pair.first).booleanValue()) {
      a((CharSequence)pair.second);
      r();
      return;
    } 
    String str3 = (bs.a((Context)this.b)).c;
    String str2 = (bs.a((Context)this.b)).b;
    (bs.a((Context)this.b)).c = "";
    (bs.a((Context)this.b)).b = "";
    (new Thread(new ke(this, str3, str2, str1))).start();
  }
  
  void a() {
    setTitle(2131165358);
    this.a = (TextView)findViewById(2131296405);
    if (this.n.i == 1) {
      str = cv.p(cv.q(this.n.b));
    } else {
      str = cq.a((Context)this.b).a();
      if (!TextUtils.isEmpty(str)) {
        str = cv.p(cv.q(str));
      } else {
        str = cv.p(this.t.k());
      } 
    } 
    String str = String.format(e(2131165355), new Object[] { str });
    this.a.setText((CharSequence)Html.fromHtml(str));
    findViewById(2131296408).setOnClickListener(this);
    this.p = (EditTextWithDel)findViewById(2131296368);
    this.p.setTransformationMethod((TransformationMethod)new PasswordTransformationMethod());
    this.o = findViewById(2131296370);
    this.q = (ImageView)findViewById(2131296369);
    this.q.setOnClickListener(this);
    this.p.setOnFocusChangeListener(new kd(this));
    this.p.a();
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.t = cq.a((Context)this.b);
    this.n = this.t.a;
  }
  
  int c() {
    return 2130903100;
  }
  
  public void onClick(View paramView) {
    switch (a(paramView)) {
      default:
        return;
      case 2131296408:
        F();
      case 2131296369:
        break;
    } 
    if (this.r)
      this.s = h.b(this.s, (Context)this.b, this.p, this.q); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\kc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */