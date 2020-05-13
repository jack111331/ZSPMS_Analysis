package com.zz.sdk.floatdlg.b;

import com.zz.sdk.b.a.w;
import com.zz.sdk.b.g;
import com.zz.sdk.i.bp;

class bb implements Runnable {
  bb(ba paramba, w paramw) {}
  
  public void run() {
    if (this.a != null && this.a.c()) {
      bp.a("FM...getGameData onPostExecute...if");
      ax.d(this.b.a).clear();
      ax.d(this.b.a).addAll(this.a.m);
      ax.e(this.b.a).notifyDataSetChanged();
      for (g g : this.a.m)
        bp.a("gameUrl: " + g.a); 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */