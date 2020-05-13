package com.zz.sdk.third;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.zz.sdk.i.s;
import com.zz.sdk.third.a.a;
import com.zz.sdk.third.b.b;
import java.util.Map;

public abstract class a implements b, b {
  private static final String d = "third_";
  
  private static final String e = "third_uid";
  
  private static final String f = "third_token";
  
  private static final String g = "third_expires";
  
  protected Activity a;
  
  protected a b;
  
  protected Handler c;
  
  public a(Activity paramActivity) {
    this.a = paramActivity;
    this.c = new Handler(paramActivity.getMainLooper());
  }
  
  protected Activity a() {
    return this.a;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent) {}
  
  public void a(a parama) {
    this.b = parama;
    SharedPreferences.Editor editor = s.a((Context)this.a).edit();
    editor.putString("third_uid", parama.d());
    editor.putString("third_token", parama.e());
    editor.putLong("third_expires", parama.f());
    editor.apply();
  }
  
  abstract void a(Map paramMap);
  
  public void b() {}
  
  public a c() {
    if (this.b != null)
      return this.b; 
    SharedPreferences sharedPreferences = s.a((Context)this.a);
    String str1 = sharedPreferences.getString("third_uid", "");
    String str2 = sharedPreferences.getString("third_token", "");
    long l = sharedPreferences.getLong("third_expires", -1L);
    if (TextUtils.isEmpty(str1) || TextUtils.isEmpty(str2) || l < 0L)
      return null; 
    this.b = new a(str1, str2, l);
    this.b.a(e());
    return this.b;
  }
  
  public void d() {
    SharedPreferences.Editor editor = s.a((Context)this.a).edit();
    editor.remove("third_uid");
    editor.remove("third_token");
    editor.remove("third_expires");
    editor.apply();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\third\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */