package com.zz.sdk.floatdlg.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.zz.sdk.floatdlg.a.s;
import com.zz.sdk.i.ci;

class h implements Runnable {
  h(a parama, View paramView) {}
  
  public void run() {
    if (a.b(this.b) != null && (a.b(this.b)).length > 0) {
      a.a(this.b, (ListView)this.a.findViewById(ci.a(a.c(this.b)).a(2131296535)));
      a.d(this.b).setVisibility(0);
      s s = new s(a.c(this.b), a.b(this.b), "1");
      a.d(this.b).setAdapter((ListAdapter)s);
      a.b(this.b, a.d(this.b));
      a.a(this.b, (ImageView)this.a.findViewById(ci.a(a.c(this.b)).a(2131296534)));
      a.e(this.b).setVisibility(0);
      this.b.g.setText(this.b.getString(ci.a(a.c(this.b)).a(2131165456)));
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */