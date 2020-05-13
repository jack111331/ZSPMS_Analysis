package com.zz.sdk.lib.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.zz.sdk.a.lj;
import com.zz.sdk.i.ci;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import com.zz.sdk.lib.widget.roundview.RoundLinearLayout;

public class a extends lj {
  private TextView a;
  
  private TextView b;
  
  private FrameLayout c;
  
  private FancyButton d;
  
  private FancyButton e;
  
  private RoundLinearLayout f;
  
  private Context g;
  
  public a(Context paramContext) {
    super(paramContext, ci.a(paramContext, 2131230726));
    this.g = paramContext;
    a();
  }
  
  private void a() {
    setContentView(ci.a(this.g, 2130903067));
    b();
  }
  
  private void a(FancyButton paramFancyButton, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener) {
    if (paramCharSequence == null || paramCharSequence.length() == 0) {
      paramFancyButton.setVisibility(8);
      return;
    } 
    paramFancyButton.setText(paramCharSequence);
    paramFancyButton.setVisibility(0);
    paramFancyButton.setOnClickListener(new b(this, paramOnClickListener));
  }
  
  private void b() {
    this.a = (TextView)findViewById(2131296411);
    this.b = (TextView)findViewById(2131296412);
    this.c = (FrameLayout)findViewById(2131296400);
    this.d = (FancyButton)findViewById(2131296413);
    this.e = (FancyButton)findViewById(2131296414);
    this.f = (RoundLinearLayout)findViewById(2131296396);
    b((CharSequence)null);
    a((CharSequence)null);
    a((CharSequence)null, (DialogInterface.OnClickListener)null);
    b((CharSequence)null, (DialogInterface.OnClickListener)null);
  }
  
  public int E() {
    return -2;
  }
  
  public a a(int paramInt) {
    return b(this.g.getResources().getText(ci.a(this.g, paramInt)));
  }
  
  public a a(CharSequence paramCharSequence) {
    if (paramCharSequence == null || paramCharSequence.length() == 0) {
      this.c.setVisibility(8);
      return this;
    } 
    this.c.setVisibility(0);
    this.b.setText(paramCharSequence);
    return this;
  }
  
  public a a(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener) {
    a(this.e, paramCharSequence, paramOnClickListener);
    return this;
  }
  
  public a b(CharSequence paramCharSequence) {
    if (paramCharSequence == null || paramCharSequence.length() == 0) {
      this.a.setVisibility(8);
      return this;
    } 
    this.a.setVisibility(0);
    this.a.setText(paramCharSequence);
    return this;
  }
  
  public a b(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener) {
    a(this.d, paramCharSequence, paramOnClickListener);
    return this;
  }
  
  public View findViewById(int paramInt) {
    int i = ci.a(this.g, paramInt);
    View view = super.findViewById(i);
    view.setTag(i, Integer.valueOf(paramInt));
    return view;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */