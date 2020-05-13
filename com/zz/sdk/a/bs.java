package com.zz.sdk.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import com.zz.sdk.i.ci;

public class bs {
  public static bs a;
  
  public String b = "";
  
  public String c = "";
  
  public String d = "";
  
  public String e = "";
  
  public String f = "";
  
  public String g = "";
  
  public String h = "";
  
  public String i = "";
  
  public String j = "";
  
  public String k = "";
  
  public String l = "";
  
  public String m = "";
  
  public String n = "";
  
  public String o = "";
  
  public String p = "";
  
  public int q = -1;
  
  private lj r;
  
  private bs(Context paramContext) {
    if (paramContext == null)
      throw new RuntimeException("Context can not be null !"); 
    this.r = new lj(paramContext);
    this.r.requestWindowFeature(1);
    this.r.getWindow().setBackgroundDrawable(paramContext.getResources().getDrawable(ci.a(paramContext, 2130837539)));
  }
  
  public static bs a(Context paramContext) {
    if (a == null)
      a = new bs(paramContext); 
    return a;
  }
  
  public static void a(Context paramContext, View paramView, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    if (paramContext instanceof Activity && (Build.VERSION.SDK_INT < 17 || !((Activity)paramContext).isDestroyed()))
      bv.a((Activity)paramContext, ht.class, bv.a().a("key_old_view", paramView).a("key_title", paramString).a("key_show_back", Boolean.valueOf(paramBoolean1)).a("key_show_close", Boolean.valueOf(paramBoolean2)).a("key_overlay", Boolean.valueOf(paramBoolean3))); 
  }
  
  public static void b(Context paramContext) {
    if (paramContext instanceof Activity)
      bv.e((Activity)paramContext); 
  }
  
  public lj a() {
    return this.r;
  }
  
  public void b() {
    a = null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */