package com.zz.sdk.floatdlg.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.zz.sdk.floatdlg.a.s;
import com.zz.sdk.i.ci;

class bg implements Runnable {
  bg(be parambe, View paramView) {}
  
  public void run() {
    try {
      if (be.b(this.b) != null && (be.b(this.b)).length > 0) {
        be.a(this.b, (ListView)this.a.findViewById(ci.a(be.c(this.b), 2131296623)));
        be.d(this.b).setVisibility(0);
        s s = new s();
        this((Context)this.b.getActivity(), be.b(this.b), "2");
        be.d(this.b).setAdapter((ListAdapter)s);
        be.b(this.b, be.d(this.b));
        be.a(this.b, (ImageView)this.a.findViewById(ci.a(be.c(this.b), 2131296622)));
        be.e(this.b).setVisibility(0);
        be.f(this.b).setText(this.b.getString(ci.a(be.c(this.b), 2131165456)));
      } 
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */