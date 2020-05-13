package com.zz.sdk.a;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.zz.sdk.d.a;
import com.zz.sdk.i.ci;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;

public class br extends Dialog implements View.OnClickListener {
  public static final int a = 1;
  
  public static final int b = 0;
  
  public static final int c = 3;
  
  public static final int d = 2;
  
  public static final int e = 4;
  
  private Context f;
  
  private FancyButton g;
  
  private FancyButton h;
  
  private a i;
  
  public br(Context paramContext, int paramInt, a parama) {
    super(paramContext, paramInt);
    this.f = paramContext;
    this.i = parama;
    requestWindowFeature(1);
    setContentView(ci.a(this.f, 2130903060));
    a();
  }
  
  private void a() {
    this.g = (FancyButton)findViewById(ci.a(this.f, 2131296398));
    this.h = (FancyButton)findViewById(ci.a(this.f, 2131296397));
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
  }
  
  public void onClick(View paramView) {
    if (paramView == this.g) {
      this.i.a(Boolean.valueOf(true));
      dismiss();
      return;
    } 
    if (paramView == this.h)
      dismiss(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */