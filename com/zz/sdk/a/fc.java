package com.zz.sdk.a;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.zz.sdk.i.ci;

public class fc extends lj {
  private RadioGroup a;
  
  private int b;
  
  private int c = -1;
  
  private Handler d = new Handler();
  
  private TextView e;
  
  private Runnable f = new fd(this);
  
  public fc(Context paramContext) {
    super(paramContext);
    a(paramContext, (CharSequence)null);
  }
  
  public fc(Context paramContext, CharSequence paramCharSequence) {
    super(paramContext);
    a(paramContext, paramCharSequence);
  }
  
  private void a(Context paramContext, CharSequence paramCharSequence) {
    getWindow().requestFeature(1);
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    setContentView(ci.a(paramContext, 2130903083));
    setCanceledOnTouchOutside(false);
    this.a = (RadioGroup)findViewById(ci.a(paramContext, 2131296449));
    this.a.setVisibility(0);
    this.b = this.a.getChildCount();
    this.e = (TextView)findViewById(ci.a(paramContext, 2131296411));
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\fc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */