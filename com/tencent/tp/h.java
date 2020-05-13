package com.tencent.tp;

class h implements m.a {
  h(g paramg) {}
  
  public void a(int paramInt) {
    String str = g.a(this.a);
    if (g.a(this.a) == null)
      g.a(this.a, "0"); 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("msg_box_dismiss:sys:");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("|msg_box_id=");
    stringBuilder2.append(str);
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("|btn_id=");
    stringBuilder2.append(paramInt);
    stringBuilder1.append(stringBuilder2.toString());
    u.a(stringBuilder1.toString());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */