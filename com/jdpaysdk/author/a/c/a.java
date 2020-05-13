package com.jdpaysdk.author.a.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.jdpaysdk.author.a.a.b;
import com.jdpaysdk.author.a.b;
import com.jdpaysdk.author.c.e;
import com.jdpaysdk.author.c.f;
import okhttp3.MediaType;

public class a {
  private Activity a;
  
  private void a(String paramString1, String paramString2, com.jdpaysdk.author.a.d.a parama) {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1))
      str = "http://jdpaycert.jd.com/service/verifyAppKey"; 
    ((b)b.c().a(str)).a(MediaType.parse("application/json; charset=utf-8")).b(paramString2).a().b((com.jdpaysdk.author.a.b.a)new b(this, parama));
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, com.jdpaysdk.author.a.d.a parama) {
    this.a = paramActivity;
    if (!e.a((Context)this.a)) {
      parama.b();
      parama.a("1009", paramActivity.getString(f.b("net_no_connect")));
      return;
    } 
    a(paramString1, paramString2, parama);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */