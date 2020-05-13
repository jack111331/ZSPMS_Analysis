package com.herosdk.a;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.herosdk.d.au;

public class l extends i {
  private RadioGroup a;
  
  private int b;
  
  private int c = -1;
  
  private Handler d = new Handler();
  
  private TextView e;
  
  private Runnable f = new m(this);
  
  public l(Context paramContext) {
    super(paramContext);
    a(paramContext, (CharSequence)null);
  }
  
  public l(Context paramContext, CharSequence paramCharSequence) {
    super(paramContext);
    a(paramContext, paramCharSequence);
  }
  
  private void a(Context paramContext, CharSequence paramCharSequence) {
    getWindow().requestFeature(1);
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    setContentView(au.h(paramContext, "hu_dialog_loading"));
    setCanceledOnTouchOutside(false);
    this.a = (RadioGroup)findViewById(au.g(paramContext, "hu_loading_rdoGroup"));
    this.a.setVisibility(0);
    this.b = this.a.getChildCount();
    this.e = (TextView)findViewById(au.g(paramContext, "hu_loading_txtTitle"));
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.e.setVisibility(0);
      this.e.setText(paramCharSequence);
      return;
    } 
    this.e.setVisibility(8);
  }
  
  public void dismiss() {
    super.dismiss();
    this.d.removeCallbacks(this.f);
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.e.setVisibility(0);
      this.e.setText(paramCharSequence);
      return;
    } 
    this.e.setVisibility(8);
  }
  
  public void show() {
    super.show();
    if (this.a != null)
      this.d.postDelayed(this.f, 500L); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */