package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.Iterator;

final class c implements Runnable {
  c(b paramb) {}
  
  public final void run() {
    ArrayList arrayList = new ArrayList();
    arrayList.addAll(a.a(this.l.k));
    Iterator<OAuthListener> iterator = arrayList.iterator();
    while (iterator.hasNext())
      ((OAuthListener)iterator.next()).onQrcodeScanned(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\diffdev\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */