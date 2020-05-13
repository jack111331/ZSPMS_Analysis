package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.zz.sdk.b.a.r;
import com.zz.sdk.c.a;
import com.zz.sdk.e.bg;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import java.util.Map;

public class bm extends w {
  private bg a;
  
  public bm(Activity paramActivity) {
    super(paramActivity);
  }
  
  public bm(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    r r = cv.h();
    cq cq = cq.a((Context)this.b);
    int i = cq.d();
    int j = cq.f();
    if (i == 3 && j == 3) {
      b((CharSequence)null, false);
      String str2 = cq.a((Context)this.b).q();
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = cq.a((Context)this.b).v(); 
      a.a().g((Context)this.b, str1, cq.a((Context)this.b).c(), new bn(this, r));
      return;
    } 
    if (r != null && r.k() != 0) {
      b((CharSequence)null, false);
      String str2 = cq.a((Context)this.b).q();
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = cq.a((Context)this.b).v(); 
      a.a().g((Context)this.b, str1, cq.a((Context)this.b).c(), new bp(this, r));
      return;
    } 
    bv.f(this.b);
  }
  
  void a() {
    this.j.getDelegate().a(0);
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.a = (bg)paramMap.get("payLayout");
  }
  
  int c() {
    return 0;
  }
  
  public void f() {
    super.f();
    F();
  }
  
  protected View k() {
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */