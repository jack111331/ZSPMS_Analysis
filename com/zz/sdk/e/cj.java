package com.zz.sdk.e;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.jdpaysdk.author.JDPayAuthor;
import com.zz.sdk.ParamChain;
import com.zz.sdk.b.a.an;
import com.zz.sdk.g.a;
import com.zz.sdk.h;
import com.zz.sdk.i.cg;

class cj extends a {
  private int o;
  
  private String p;
  
  private an q;
  
  private String r;
  
  private int s = 3;
  
  public cj(Context paramContext, ParamChain paramParamChain) {
    super(paramContext, paramParamChain);
    c(paramContext);
  }
  
  private void a(Activity paramActivity, an paraman) {
    (new JDPayAuthor()).author(paramActivity, paraman.p, paraman.q, paraman.r, paraman.s);
  }
  
  private void b(int paramInt) {
    this.s = paramInt;
    o();
    b();
  }
  
  private void v() {
    b(0);
  }
  
  private void w() {
    b(2);
  }
  
  private void x() {
    b(1);
  }
  
  private void y() {
    if (this.s != 3) {
      ParamChain paramChain = getEnv().getParent(cr.class.getName());
      if (paramChain != null)
        paramChain.add("global.paymentlist.pay_result", Integer.valueOf(this.s), h.b); 
    } 
  }
  
  private void z() {
    a(getActivity(), this.q);
  }
  
  protected void a(Context paramContext, ParamChain paramParamChain) {
    this.o = ((Integer)paramParamChain.get("global.paymentlist.pay_channel_type", Integer.class)).intValue();
    this.p = (String)paramParamChain.get("global.paymentlist.pay_channel_name", String.class);
    this.r = (String)paramParamChain.get("global.paymentlist.pay_order_number", String.class);
    this.q = (an)paramParamChain.get("global.paymentlist.pay_jd", an.class);
  }
  
  protected void b(Context paramContext) {
    cg cg = (cg)getEnv().get("global.paymentlist.pay_title", cg.class);
    if (cg != null) {
      String str;
      if (this.p != null) {
        str = String.format(cg.y.a(), new Object[] { cg.a(), this.p });
      } else {
        str = str.a();
      } 
      setTileTypeText(str);
    } 
  }
  
  public boolean c(boolean paramBoolean) {
    paramBoolean = super.c(paramBoolean);
    if (paramBoolean);
    return paramBoolean;
  }
  
  public boolean j() {
    boolean bool = super.j();
    if (!bool)
      return false; 
    this.s = 2;
    setActivityControlInterface((a)new cl(this, null));
    z();
    return bool;
  }
  
  protected void m() {
    y();
    super.m();
    this.o = -1;
    this.p = null;
    this.r = null;
    this.q = null;
  }
  
  public void onClick(View paramView) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */