package com.zz.sdk.b;

import java.util.ArrayList;
import java.util.List;

public enum f {
  a(2130837596, 2131165364, a.a),
  b(2130837640, 2131165365, a.b),
  c(2130837622, 2131165366, a.c),
  d(2130837647, 2131165367, a.d),
  e(2130837602, 2131165368, a.e),
  f(2130837643, 2131165369, a.f),
  g(2130837605, 2131165363, a.g),
  h(2130837604, 2131165236, a.h);
  
  public int i;
  
  public int j;
  
  public a k;
  
  f(int paramInt1, int paramInt2, a parama) {
    this.i = paramInt1;
    this.j = paramInt2;
    this.k = parama;
  }
  
  public static List a(int paramInt) {
    ArrayList<f> arrayList = new ArrayList();
    switch (paramInt) {
      default:
        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(c);
        return arrayList;
      case 1:
        break;
    } 
    arrayList.add(a);
    arrayList.add(c);
    return arrayList;
  }
  
  public static List b(int paramInt) {
    ArrayList<f> arrayList = new ArrayList();
    switch (paramInt) {
      default:
        arrayList.add(e);
        arrayList.add(f);
        arrayList.add(h);
        return arrayList;
      case 1:
        break;
    } 
    arrayList.add(d);
    arrayList.add(e);
    arrayList.add(f);
    arrayList.add(g);
    return arrayList;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */