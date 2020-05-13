package com.zz.sdk.e;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zz.sdk.i.bl;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;

class bn extends Dialog {
  public bn(Context paramContext) {
    super(paramContext);
    getWindow().requestFeature(1);
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    LinearLayout linearLayout = new LinearLayout(paramContext);
    linearLayout.setOrientation(1);
    linearLayout.setGravity(1);
    linearLayout.setBackgroundDrawable(ca.bt.a(paramContext));
    linearLayout.setPadding(cc.a(35.0F), cc.a(15.0F), cc.a(35.0F), cc.a(15.0F));
    TextView textView = new TextView(paramContext);
    textView.setTextColor(Color.rgb(255, 113, 1));
    textView.setText("自动登录游戏");
    textView.setTextSize(16.0F);
    bl bl = new bl(paramContext);
    Button button = new Button(paramContext);
    button.setBackgroundDrawable((Drawable)ca.a(paramContext, ca.bD, ca.bE));
    button.setOnClickListener(new bo(this));
    button.setPadding(cc.a(35.0F), cc.a(12.0F), cc.a(35.0F), cc.a(12.0F));
    button.setText("取消");
    button.setTextColor(-1);
    linearLayout.addView((View)textView, -2, -2);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
    layoutParams.topMargin = cc.a(10.0F);
    linearLayout.addView((View)bl, (ViewGroup.LayoutParams)layoutParams);
    layoutParams = new LinearLayout.LayoutParams(-2, -2);
    layoutParams.topMargin = cc.a(10.0F);
    linearLayout.addView((View)button, (ViewGroup.LayoutParams)layoutParams);
    setContentView((View)linearLayout);
    setCanceledOnTouchOutside(false);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */