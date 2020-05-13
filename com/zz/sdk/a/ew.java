package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zz.sdk.c.a;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.EditTextWithDel;

public class ew extends w implements View.OnClickListener {
  private boolean a = false;
  
  private boolean n = false;
  
  private String o;
  
  private String p;
  
  private cq q;
  
  private EditTextWithDel r;
  
  private ImageView s;
  
  private EditTextWithDel t;
  
  private View u;
  
  private View x;
  
  public ew(Activity paramActivity) {
    super(paramActivity);
  }
  
  private void a(String paramString1, String paramString2, String paramString3) {
    c(2131165244);
    a.a().b((Context)this.b, paramString1, paramString2, paramString3, new ez(this, paramString2, paramString3));
  }
  
  void a() {
    setTitle(e(2131165233));
    this.q = cq.a((Context)this.b);
    this.u = findViewById(2131296378);
    this.x = findViewById(2131296379);
    this.r = (EditTextWithDel)findViewById(2131296361);
    this.r.setOnFocusChangeListener(new ex(this));
    this.t = (EditTextWithDel)findViewById(2131296368);
    this.t.setTransformationMethod((TransformationMethod)new PasswordTransformationMethod());
    this.t.setOnFocusChangeListener(new ey(this));
    this.s = (ImageView)findViewById(2131296369);
    this.s.setOnClickListener(this);
    findViewById(2131296371).setOnClickListener(this);
  }
  
  int c() {
    return 2130903099;
  }
  
  public void onClick(View paramView) {
    switch (a(paramView)) {
      default:
        return;
      case 2131296371:
        t.a((Context)this.b).b("Bind_platform", "bind_username", 1);
        if (!cv.a((TextView)this.r, e(2131165276))) {
          this.o = this.r.getText().toString().trim();
          Pair pair = cq.i(this.o);
          if (!((Boolean)pair.first).booleanValue())
            a((CharSequence)pair.second); 
          this.p = this.t.getText().toString().trim();
          pair = cq.o(this.p);
          if (!((Boolean)pair.first).booleanValue())
            a((CharSequence)pair.second); 
          String str2 = cq.a((Context)this.b).q();
          String str1 = str2;
          if (TextUtils.isEmpty(str2))
            str1 = cq.a((Context)this.b).v(); 
          a(str1, this.o, this.p);
        } 
      case 2131296369:
        break;
    } 
    if (this.n)
      this.a = h.a(this.a, (Context)this.b, this.t, this.s); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */