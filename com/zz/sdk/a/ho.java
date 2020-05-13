package com.zz.sdk.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zz.sdk.i.bl;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.ci;

class ho extends Dialog {
  public ho(hl paramhl, Context paramContext) {
    super(paramContext);
    getWindow().requestFeature(1);
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    LinearLayout linearLayout = new LinearLayout(paramContext);
    linearLayout.setOrientation(1);
    linearLayout.setGravity(1);
    linearLayout.setBackgroundDrawable(paramhl.b.getResources().getDrawable(ci.a((Context)paramhl.b, 2130837543)));
    linearLayout.setPadding(cc.a(50.0F), cc.a(10.0F), cc.a(50.0F), cc.a(10.0F));
    TextView textView = new TextView(paramContext);
    textView.setTextColor(Color.rgb(255, 113, 1));
    textView.setText(paramhl.e(2131165297));
    textView.setTextSize(16.0F);
    bl bl = new bl(paramContext);
    linearLayout.addView((View)textView, -2, -2);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
    layoutParams.topMargin = cc.a(10.0F);
    linearLayout.addView((View)bl, (ViewGroup.LayoutParams)layoutParams);
    (new LinearLayout.LayoutParams(-2, -2)).topMargin = cc.a(10.0F);
    setContentView((View)linearLayout);
    setCanceledOnTouchOutside(false);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */