package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.zz.sdk.c.a;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.h;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;

public class ci extends w implements View.OnClickListener {
  protected EditText a;
  
  protected ImageView n;
  
  protected FancyButton o;
  
  private View p;
  
  public ci(Activity paramActivity) {
    super(paramActivity);
  }
  
  private void b(String paramString) {
    c(2131165272);
    a.a().f((Context)this.b, cq.a((Context)this.b).v(), paramString, new cl(this, paramString));
  }
  
  void a() {
    setTitle(2131165329);
    this.n = (ImageView)findViewById(2131296406);
    this.n.setOnClickListener(this);
    this.p = findViewById(2131296417);
    this.a = (EditText)findViewById(2131296416);
    this.a.addTextChangedListener(new cj(this));
    this.a.setOnFocusChangeListener(new ck(this));
    this.o = (FancyButton)findViewById(2131296408);
    this.o.setOnClickListener(this);
    this.a.setText("");
  }
  
  int c() {
    return 2130903071;
  }
  
  public void onClick(View paramView) {
    int i = a(paramView);
    if (i == 2131296406) {
      this.a.setText("");
      return;
    } 
    if (i == 2131296408) {
      String str = this.a.getEditableText().toString().trim();
      if (TextUtils.isEmpty(str)) {
        b(2131165333);
        return;
      } 
      if (!h.b(str)) {
        b(2131165334);
        return;
      } 
      b(str);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */