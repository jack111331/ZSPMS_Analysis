package com.sdk.base.framework.utils.m;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sdk.base.framework.c.c;

public class a extends AlertDialog {
  private static final String a = a.class.getSimpleName();
  
  private static Boolean b = Boolean.valueOf(c.h);
  
  private String c;
  
  private Context d;
  
  private AnimationDrawable e;
  
  private TextView f;
  
  private RelativeLayout g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private boolean l;
  
  public a(Context paramContext, String paramString) {
    super(paramContext);
    this.d = paramContext;
    this.c = paramString;
  }
  
  private void a() {
    if (this.h != 0 && this.i != 0)
      this.g.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(this.h, this.i)); 
    if (this.k != 0)
      this.f.setTextSize(this.k); 
    if (this.j != 0)
      this.f.setTextColor(this.j); 
    if (!this.l)
      this.f.setVisibility(8); 
  }
  
  public void a(int paramInt) {
    this.k = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public void a(boolean paramBoolean) {
    this.l = paramBoolean;
  }
  
  public void b(int paramInt) {
    this.j = paramInt;
  }
  
  @SuppressLint({"ResourceType"})
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    try {
      Window window = getWindow();
      ColorDrawable colorDrawable = new ColorDrawable();
      this(0);
      window.setBackgroundDrawable((Drawable)colorDrawable);
    } catch (Exception exception) {}
    setContentView(com.sdk.base.framework.utils.e.a.a(getContext(), "layout", "oauth_loading_dialog"));
    this.f = (TextView)findViewById(com.sdk.base.framework.utils.e.a.a(getContext(), "id", "oauth_loading_dialog_txt"));
    this.g = (RelativeLayout)findViewById(com.sdk.base.framework.utils.e.a.a(getContext(), "id", "loading_parent"));
    this.e = (AnimationDrawable)((ImageView)findViewById(com.sdk.base.framework.utils.e.a.a(getContext(), "id", "oauth_loading_dialog_img"))).getDrawable();
    if (com.sdk.base.framework.utils.k.a.b(this.c).booleanValue())
      this.f.setText(this.c); 
    a();
  }
  
  protected void onStart() {
    this.e.start();
    super.onStart();
  }
  
  protected void onStop() {
    this.e.stop();
    super.onStop();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\m\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */