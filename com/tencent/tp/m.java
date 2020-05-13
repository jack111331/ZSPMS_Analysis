package com.tencent.tp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class m {
  AlertDialog a = null;
  
  private Context b;
  
  private String c;
  
  private String d;
  
  private a e;
  
  private DialogInterface.OnDismissListener f = new n(this);
  
  public m(Context paramContext, String paramString1, String paramString2, String paramString3, a parama) {
    this.b = paramContext;
    this.c = paramString2;
    this.d = paramString3;
    this.e = parama;
  }
  
  private int a(Context paramContext, int paramInt) {
    DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
    return (int)(paramInt * displayMetrics.density + 0.5F);
  }
  
  public void a() {
    AlertDialog.Builder builder;
    if (Build.VERSION.SDK_INT >= 11) {
      builder = new AlertDialog.Builder(this.b, 1);
    } else {
      builder = new AlertDialog.Builder(this.b);
    } 
    builder.setCancelable(false);
    int i = a(this.b, 10);
    int j = a(this.b, 6);
    int k = a(this.b, 10);
    TextView textView = new TextView(this.b);
    textView.setText(this.c);
    textView.setTextColor(Color.parseColor("#FFFFFF"));
    textView.setTextSize(2, 18.0F);
    textView.setBackgroundColor(Color.parseColor("#000000"));
    textView.setPadding(i, j, i, k);
    builder.setView((View)textView);
    builder.setNeutralButton(this.d, null);
    this.a = builder.create();
    this.a.setOnDismissListener(this.f);
    this.a.setOnShowListener(new o(this));
    this.a.show();
    b();
  }
  
  protected void b() {
    if (this.b != null && this.a != null) {
      float f1;
      float f2;
      WindowManager.LayoutParams layoutParams = this.a.getWindow().getAttributes();
      Display display = ((WindowManager)this.b.getSystemService("window")).getDefaultDisplay();
      if (display.getHeight() > display.getWidth()) {
        f1 = display.getWidth();
        f2 = 0.9F;
      } else {
        f1 = display.getWidth();
        f2 = 0.6F;
      } 
      layoutParams.width = (int)(f1 * f2);
      this.a.getWindow().setAttributes(layoutParams);
      this.a.getWindow().setGravity(17);
      this.a.setCanceledOnTouchOutside(false);
    } 
  }
  
  public void c() {
    if (this.a != null) {
      this.a.dismiss();
      this.a = null;
    } 
  }
  
  public static interface a {
    void a(int param1Int);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */