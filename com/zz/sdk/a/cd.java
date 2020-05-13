package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.zz.sdk.c.a;
import com.zz.sdk.i.h;
import com.zz.sdk.i.t;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;

public class cd extends w implements View.OnClickListener {
  protected EditText a;
  
  protected ImageView n;
  
  protected FancyButton o;
  
  public cd(Activity paramActivity) {
    super(paramActivity);
  }
  
  public cd(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void b(String paramString) {
    p();
    a.a().f((Context)this.b, paramString, new cg(this, paramString));
  }
  
  void a() {
    setTitle(2131165413);
    this.n = (ImageView)findViewById(2131296406);
    this.n.setOnClickListener(this);
    this.a = (EditText)findViewById(2131296416);
    this.a.addTextChangedListener(new ce(this));
    this.a.setOnFocusChangeListener(new cf(this));
    this.o = (FancyButton)findViewById(2131296408);
    findViewById(2131296418).setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.a.setText("");
  }
  
  int c() {
    return 2130903070;
  }
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296408) {
      t.a((Context)this.b).b("Forget_platform", "forget_pass_next", 1);
      String str = h.c((TextView)this.a);
      if (str != null)
        b(str); 
      return;
    } 
    if (i == 2131296406)
      this.a.setText(""); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */