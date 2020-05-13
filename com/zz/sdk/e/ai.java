package com.zz.sdk.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.zz.sdk.b.n;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import java.util.LinkedList;

public class ai extends LinearLayout {
  String a;
  
  Handler b = new Handler();
  
  ce c;
  
  private Context d;
  
  private ListView e;
  
  private n f;
  
  private bx g;
  
  private LinkedList h;
  
  private ci i;
  
  public ai(Context paramContext, String paramString, ce paramce) {
    super(paramContext);
    this.a = paramString;
    this.d = paramContext;
    b();
    this.f = new n(this.d);
    this.c = paramce;
    (new aj(this, paramString)).start();
  }
  
  private void b() {
    setOrientation(1);
    int i = cc.a(12.0F);
    ImageView imageView = new ImageView(this.d);
    imageView.setBackgroundDrawable(ca.ar.a(this.d));
    imageView.setPadding(i, 0, i, 0);
    addView((View)imageView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, cc.a(1.0F)));
    this.e = new ListView(this.d);
    this.e.setDivider(ca.ar.a(this.d));
    this.e.setDividerHeight(cc.a(1.0F));
    this.e.setPadding(i, 0, i, i);
    this.e.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    addView((View)this.e);
  }
  
  public void a() {
    (new aj(this, this.a)).start();
  }
  
  public void setOnItemClickListener(ci paramci) {
    this.i = paramci;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */