package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.zz.sdk.b.a.ab;
import com.zz.sdk.i.a;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.h;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Map;

public class hv extends w implements View.OnClickListener {
  protected Handler a = new Handler();
  
  private TextView n;
  
  private FancyButton o;
  
  private String p;
  
  private String q;
  
  public hv(Activity paramActivity) {
    super(paramActivity);
  }
  
  private void F() {
    (new hw(this)).start();
  }
  
  private void a(ab paramab) {
    this.a.post(new hx(this, paramab));
  }
  
  void a() {
    setTitle(2131165415);
    this.n = (TextView)findViewById(2131296486);
    if (TextUtils.isEmpty(this.p)) {
      this.n.setText(ci.a((Context)this.b, 2131165419));
    } else {
      this.n.setText(String.format(e(2131165420), new Object[] { this.p }));
    } 
    this.o = (FancyButton)findViewById(2131296487);
    findViewById(2131296487).setOnClickListener(this);
    ab ab = h.b();
    if (ab == null || !ab.c()) {
      if (a.a()) {
        this.o.setText(String.format(e(2131165421), new Object[] { "028-69605988" }));
        this.q = "028-69605988";
      } else {
        this.o.setText(String.format(e(2131165421), new Object[] { "4009925888" }));
        this.q = "4009925888";
      } 
      F();
      return;
    } 
    a(ab);
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.p = (String)a("account");
  }
  
  int c() {
    return 2130903091;
  }
  
  public void onClick(View paramView) {
    if (a(paramView) == 2131296487)
      h.a((Context)this.b, this.q); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\hv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */