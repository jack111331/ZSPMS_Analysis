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

public class ba extends LinearLayout {
  private Context a;
  
  private ListView b;
  
  private LinkedList c = new LinkedList();
  
  private n d;
  
  private bx e;
  
  private String f;
  
  private ci g;
  
  public ba(Context paramContext, String paramString) {
    super(paramContext);
    this.f = paramString;
    this.a = paramContext;
    this.d = new n(paramContext);
    a();
    (new bb(this, paramString)).start();
  }
  
  protected void a() {
    setOrientation(1);
    int i = cc.a(12.0F);
    ImageView imageView = new ImageView(this.a);
    imageView.setBackgroundDrawable(ca.ar.a(this.a));
    imageView.setPadding(i, 0, i, 0);
    addView((View)imageView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, cc.a(1.0F)));
    this.b = new ListView(this.a);
    this.b.setDivider(ca.ar.a(this.a));
    this.b.setDividerHeight(cc.a(1.0F));
    this.b.setPadding(i, 0, i, i);
    this.b.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    addView((View)this.b);
  }
  
  public void b() {
    (new bb(this, this.f)).start();
  }
  
  public void setOnItemClickListener(ci paramci) {
    this.g = paramci;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */