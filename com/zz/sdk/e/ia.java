package com.zz.sdk.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.zz.sdk.b.n;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import java.util.LinkedList;

public class ia extends LinearLayout {
  String a;
  
  private Context b;
  
  private ListView c;
  
  private LinkedList d = new LinkedList();
  
  private n e;
  
  private bx f;
  
  private ci g;
  
  public ia(Context paramContext, String paramString) {
    super(paramContext);
    this.a = paramString;
    this.b = paramContext;
    this.e = new n(paramContext);
    a();
    (new ib(this, paramString)).start();
  }
  
  protected void a() {
    setOrientation(1);
    int i = cc.a(12.0F);
    ImageView imageView = new ImageView(this.b);
    imageView.setBackgroundDrawable(ca.ar.a(this.b));
    imageView.setPadding(i, 0, i, 0);
    addView((View)imageView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, cc.a(1.0F)));
    this.c = new ListView(this.b);
    this.c.setDivider(ca.ar.a(this.b));
    this.c.setDividerHeight(cc.a(1.0F));
    this.c.setPadding(i, 0, i, i);
    this.c.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    addView((View)this.c);
  }
  
  public void b() {
    (new ib(this, this.a)).start();
  }
  
  public void setOnItemClickListener(ci paramci) {
    this.g = paramci;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */