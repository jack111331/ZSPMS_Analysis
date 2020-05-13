package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alipay.sdk.packet.b;
import com.alipay.sdk.packet.impl.a;
import com.alipay.sdk.protocol.a;
import com.alipay.sdk.protocol.b;
import java.util.List;

final class i implements Runnable {
  i(Activity paramActivity, StringBuilder paramStringBuilder, APAuthInfo paramAPAuthInfo) {}
  
  public final void run() {
    try {
      StringBuilder stringBuilder;
      a a = new a();
      this();
      b b = null;
      try {
        b b2 = a.a((Context)this.a, this.b.toString());
        b = b2;
      } catch (Throwable throwable) {}
      if (h.a() != null) {
        h.a().b();
        h.b();
      } 
      if (b == null) {
        stringBuilder = new StringBuilder();
        this();
        h.a(stringBuilder.append(this.c.getRedirectUri()).append("?resultCode=202").toString());
        h.a(this.a, h.c());
        return;
      } 
      List list = b.a(stringBuilder.a().optJSONObject("form").optJSONObject("onload"));
      byte b1 = 0;
      while (true) {
        if (b1 < list.size())
          if (((b)list.get(b1)).a == a.b) {
            h.a(((b)list.get(b1)).b[0]);
          } else {
            b1++;
            continue;
          }  
        if (TextUtils.isEmpty(h.c())) {
          StringBuilder stringBuilder1 = new StringBuilder();
          this();
          h.a(stringBuilder1.append(this.c.getRedirectUri()).append("?resultCode=202").toString());
          h.a(this.a, h.c());
          return;
        } 
        Intent intent = new Intent();
        this((Context)this.a, AuthActivity.class);
        intent.putExtra("params", h.c());
        intent.putExtra("redirectUri", this.c.getRedirectUri());
        this.a.startActivity(intent);
        return;
      } 
    } catch (Exception exception) {
      return;
    } finally {
      if (h.a() != null)
        h.a().b(); 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\auth\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */