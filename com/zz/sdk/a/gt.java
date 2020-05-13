package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zz.sdk.i.h;

public class gt extends w implements View.OnClickListener {
  private TextView a;
  
  private TextView n;
  
  private LinearLayout o;
  
  private LinearLayout p;
  
  private LinearLayout q;
  
  public gt(Activity paramActivity) {
    super(paramActivity);
  }
  
  public gt(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  void a() {
    setTitle(2131165399);
    ImageView imageView = (ImageView)findViewById(2131296360);
    this.a = (TextView)findViewById(2131296482);
    this.n = (TextView)findViewById(2131296479);
    this.o = (LinearLayout)findViewById(2131296480);
    this.p = (LinearLayout)findViewById(2131296483);
    this.q = (LinearLayout)findViewById(2131296454);
    TextView textView = (TextView)findViewById(2131296484);
    ((TextView)findViewById(2131296485)).setText(String.format(e(2131165400), new Object[] { "v3.4.4" }));
    h.a(imageView);
    h.a(this.a, false, textView, this.n, this.o, this.p, this.q);
    findViewById(2131296480).setOnClickListener(this);
    findViewById(2131296454).setOnClickListener(this);
  }
  
  protected boolean b() {
    return true;
  }
  
  int c() {
    return 2130903088;
  }
  
  public void onClick(View paramView) {
    String str;
    switch (a(paramView)) {
      default:
        return;
      case 2131296480:
        str = this.a.getText().toString().trim();
        if (!TextUtils.isEmpty(str))
          bv.a(this.b, aa.class, z().a("phone", str)); 
      case 2131296454:
        break;
    } 
    h.c((Context)this.b, this.n.getText().toString() + "");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\gt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */