package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.zz.sdk.c.a;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import java.util.Map;

public class gu extends w implements View.OnClickListener {
  protected EditText a;
  
  protected ImageView n;
  
  protected FancyButton o;
  
  private View p;
  
  private String q;
  
  public gu(Activity paramActivity) {
    super(paramActivity);
  }
  
  public gu(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void b(String paramString) {
    p();
    a.a().c((Context)this.b, cq.a((Context)this.b).v(), paramString, new gy(this, paramString));
  }
  
  void a() {
    setTitle(2131165232);
    this.o = (FancyButton)findViewById(2131296408);
    this.o.setOnClickListener(this);
    this.p = findViewById(2131296349);
    this.n = (ImageView)findViewById(2131296406);
    this.n.setOnClickListener(this);
    this.a = (EditText)findViewById(2131296392);
    this.a.addTextChangedListener(new gv(this));
    this.a.setOnFocusChangeListener(new gw(this));
    this.a.setText("");
    findViewById(2131296409).setVisibility(8);
    findViewById(2131296410).setOnClickListener(new gx(this));
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.q = (String)a("action");
  }
  
  int c() {
    return 2130903089;
  }
  
  public void onClick(View paramView) {
    String str;
    switch (a(paramView)) {
      default:
        return;
      case 2131296408:
        t.a((Context)this.b).b("Save_platform", "guest_bind_next", 1);
        str = h.b((TextView)this.a);
        if (str != null)
          b(str); 
      case 2131296406:
        break;
    } 
    this.a.setText("");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\gu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */