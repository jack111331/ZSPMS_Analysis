package com.zz.sdk.i;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class bl extends LinearLayout {
  private ImageView[] a;
  
  private Context b;
  
  private TextView c;
  
  private boolean d = false;
  
  private Handler e = new bn(this);
  
  public bl(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public bl(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    a();
  }
  
  private int a(int paramInt) {
    return cc.a(paramInt);
  }
  
  private void a() {
    byte b = 0;
    setOrientation(1);
    ImageView imageView1 = new ImageView(this.b);
    ImageView imageView2 = new ImageView(this.b);
    ImageView imageView3 = new ImageView(this.b);
    ImageView imageView4 = new ImageView(this.b);
    this.a = new ImageView[4];
    this.a[0] = imageView1;
    this.a[1] = imageView2;
    this.a[2] = imageView3;
    this.a[3] = imageView4;
    LinearLayout linearLayout = new LinearLayout(this.b);
    linearLayout.setOrientation(0);
    ImageView[] arrayOfImageView = this.a;
    int i = arrayOfImageView.length;
    while (b < i) {
      imageView3 = arrayOfImageView[b];
      imageView3.setImageDrawable(d.b(this.b, "zz_res/dian_05.png"));
      imageView3.setPadding(a(3), a(3), a(3), a(3));
      linearLayout.addView((View)imageView3);
      b++;
    } 
    addView((View)linearLayout);
    (new bm(this)).start();
  }
  
  public void setTextColor(int paramInt) {
    this.c.setTextColor(paramInt);
  }
  
  public void setVisibility(int paramInt) {
    super.setVisibility(paramInt);
    switch (paramInt) {
      default:
        return;
      case 4:
      case 8:
        break;
    } 
    this.d = true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */