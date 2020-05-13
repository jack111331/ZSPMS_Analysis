package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ListAdapter;
import com.zz.sdk.a.a.k;
import com.zz.sdk.i.cv;
import com.zz.sdk.lib.widget.LinesGridView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class kb extends w {
  private LinesGridView a;
  
  private k n;
  
  private String o;
  
  private String p;
  
  private String q;
  
  private List r = new ArrayList();
  
  public kb(Activity paramActivity) {
    super(paramActivity);
  }
  
  public kb(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void F() {
    String str = String.format(e(2131165374), new Object[] { cv.p(this.o) });
    this.r.add(str);
    str = String.format(e(2131165375), new Object[] { cv.p(this.p) });
    this.r.add(str);
    if (TextUtils.isEmpty(this.q)) {
      str = String.format(e(2131165376), new Object[] { cv.p(e(2131165383)) });
    } else {
      str = String.format(e(2131165376), new Object[] { cv.p(String.format(e(2131165378), new Object[] { cv.q(this.q) })) });
    } 
    this.r.add(str);
  }
  
  void a() {
    setTitle(2131165370);
    this.a = (LinesGridView)findViewById(2131296496);
    this.a.setSideLine(true);
    this.n = new k((Context)this.b, this.r);
    this.a.setAdapter((ListAdapter)this.n);
  }
  
  public void a(Map paramMap) {
    super.a(paramMap);
    this.o = (String)a("realname", "");
    this.p = (String)a("idCard", "");
    this.q = (String)a("phone", "");
    F();
  }
  
  int c() {
    return 2130903097;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\kb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */