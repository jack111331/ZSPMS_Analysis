package com.herosdk.a;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.herosdk.d.au;
import com.herosdk.error.ErrorUtils;
import com.herosdk.widget.FancyButton;

public class d extends i {
  private TextView a;
  
  private TextView b;
  
  private FrameLayout c;
  
  private FancyButton d;
  
  private FancyButton e;
  
  private Context f;
  
  public d(Context paramContext) {
    super(paramContext, au.j(paramContext, "HuThemeCustomDialog"));
    this.f = paramContext;
    b();
  }
  
  private void a(FancyButton paramFancyButton, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener) {
    if (paramCharSequence == null || paramCharSequence.length() == 0) {
      paramFancyButton.setVisibility(8);
      return;
    } 
    paramFancyButton.setText(paramCharSequence);
    paramFancyButton.setVisibility(0);
    paramFancyButton.setOnClickListener(new e(this, paramOnClickListener));
  }
  
  private void b() {
    try {
      getWindow().requestFeature(1);
      setContentView(au.h(this.f, "hu_dialog_custom"));
      c();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  private void c() {
    this.a = (TextView)findViewById(au.g(this.f, "huc_txtTitle"));
    this.b = (TextView)findViewById(au.g(this.f, "huc_txtContent"));
    this.c = (FrameLayout)findViewById(au.g(this.f, "huc_layoutContent"));
    this.d = (FancyButton)findViewById(au.g(this.f, "huc_btnLeft"));
    this.e = (FancyButton)findViewById(au.g(this.f, "huc_btnRight"));
    b((CharSequence)null);
    a((CharSequence)null);
    a((CharSequence)null, (DialogInterface.OnClickListener)null);
    b((CharSequence)null, (DialogInterface.OnClickListener)null);
  }
  
  public int a() {
    return -2;
  }
  
  public d a(CharSequence paramCharSequence) {
    if (paramCharSequence == null || paramCharSequence.length() == 0) {
      this.c.setVisibility(8);
      return this;
    } 
    this.c.setVisibility(0);
    this.b.setText(paramCharSequence);
    return this;
  }
  
  public d a(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener) {
    a(this.e, paramCharSequence, paramOnClickListener);
    return this;
  }
  
  public d b(CharSequence paramCharSequence) {
    if (paramCharSequence == null || paramCharSequence.length() == 0) {
      this.a.setVisibility(8);
      return this;
    } 
    this.a.setVisibility(0);
    this.a.setText(paramCharSequence);
    return this;
  }
  
  public d b(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener) {
    a(this.d, paramCharSequence, paramOnClickListener);
    return this;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */