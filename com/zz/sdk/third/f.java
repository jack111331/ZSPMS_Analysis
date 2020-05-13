package com.zz.sdk.third;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.zz.sdk.i.bp;
import com.zz.sdk.third.b.c;
import java.util.Map;

public class f extends a {
  private static final String d = "all";
  
  private Object e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private c i;
  
  private IUiListener j = new g(this);
  
  public f(Activity paramActivity) {
    super(paramActivity);
  }
  
  private Tencent a(String paramString) {
    if (this.e != null)
      return (Tencent)this.e; 
    if (TextUtils.isEmpty(paramString)) {
      Toast.makeText((Context)this.a, "未配置[QQ_APP_ID]", 1).show();
      return null;
    } 
    Tencent tencent = Tencent.createInstance(paramString, (Context)this.a);
    this.e = tencent;
    return tencent;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {
    if (this.e != null && paramInt1 == 11101)
      try {
        Tencent.onActivityResultData(paramInt1, paramInt2, paramIntent, this.j);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public void a(c paramc) {
    this.i = paramc;
    Tencent tencent = a(this.f);
    if (tencent == null) {
      if (paramc != null)
        paramc.a(e(), null); 
      return;
    } 
    tencent.login(this.a, this.h, this.j);
  }
  
  void a(Map paramMap) {
    Object object = null;
    if (paramMap != null) {
      String str;
      Object object1 = paramMap.get("QQ_APP_ID");
      if (object1 == null) {
        object1 = null;
      } else {
        object1 = object1 + "";
      } 
      this.f = (String)object1;
      object1 = paramMap.get("QQ_APP_KEY");
      if (object1 == null) {
        object1 = object;
      } else {
        object1 = object1 + "";
      } 
      this.g = (String)object1;
      paramMap = (Map)paramMap.get("QQ_SCOPE");
      if (paramMap == null) {
        str = "all";
      } else {
        str = str + "";
      } 
      this.h = str;
    } 
    if (TextUtils.isEmpty(this.f))
      bp.b("未配置[QQ_APP_ID]"); 
    if (TextUtils.isEmpty(this.g))
      bp.b("未配置[QQ_APP_KEY]"); 
  }
  
  public c e() {
    return c.a;
  }
  
  public boolean f() {
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\third\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */