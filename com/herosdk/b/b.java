package com.herosdk.b;

import android.content.Context;
import android.util.Log;
import com.herosdk.bean.c;
import com.herosdk.bean.e;
import com.herosdk.d.g;
import com.herosdk.d.r;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.f;
import org.json.JSONObject;

class b implements Runnable {
  b(a parama, Context paramContext, f paramf) {}
  
  public void run() {
    try {
      JSONObject jSONObject;
      x.a().c("");
      x.a().d("");
      ar ar = a.a(this.c).a(this.a);
      if (ar != null && ar.b()) {
        jSONObject = ar.e();
        int i = jSONObject.optInt("code", -9999);
        if (i == 0) {
          Log.d(a.b(), "i success");
          x.a().c(jSONObject.optString("ak"));
          x.a().d(jSONObject.optString("aki"));
          c c = new c();
          this();
          c.e(jSONObject.optString("orderListUrl"));
          JSONObject jSONObject1 = jSONObject.optJSONObject("control");
          if (jSONObject1 != null) {
            JSONObject jSONObject2 = jSONObject1.optJSONObject("login");
            if (jSONObject2 != null)
              if (jSONObject2.optInt("swStatus", -1) != 0) {
                e e = new e();
                this(Boolean.valueOf(false), jSONObject2.optString("swTip"));
                c.a(e);
              } else {
                e e = new e();
                this(Boolean.valueOf(true), jSONObject2.optString("swTip"));
                c.a(e);
              }  
            jSONObject2 = jSONObject1.optJSONObject("pay");
            if (jSONObject2 != null)
              if (jSONObject2.optInt("swStatus", -1) != 0) {
                e e = new e();
                this(Boolean.valueOf(false), jSONObject2.optString("swTip"));
                c.b(e);
              } else {
                e e = new e();
                this(Boolean.valueOf(true), jSONObject2.optString("swTip"));
                c.b(e);
              }  
            jSONObject2 = jSONObject1.optJSONObject("login_fb");
            if (jSONObject2 != null)
              if (jSONObject2.optInt("swStatus", 0) != 0) {
                e e = new e();
                this(Boolean.valueOf(true), jSONObject2.optString("swTip"));
                c.c(e);
              } else {
                e e = new e();
                this(Boolean.valueOf(false), jSONObject2.optString("swTip"));
                c.c(e);
              }  
            jSONObject2 = jSONObject1.optJSONObject("sw_login");
            if (jSONObject2 != null)
              if (jSONObject2.optInt("swStatus", 0) != 0) {
                e e = new e();
                this(Boolean.valueOf(true), jSONObject2.optString("swTip"));
                c.d(e);
                g.a().a(Boolean.valueOf(true));
              } else {
                e e = new e();
                this(Boolean.valueOf(false), jSONObject2.optString("swTip"));
                c.d(e);
                g.a().a(Boolean.valueOf(false));
              }  
            if (jSONObject1.optInt("upload_pkg", 0) != 0) {
              c.a(Boolean.valueOf(true));
            } else {
              c.a(Boolean.valueOf(false));
            } 
            if (jSONObject1.optInt("check_order_status", 0) != 0) {
              c.a(true);
            } else {
              c.a(false);
            } 
          } 
          jSONObject1 = jSONObject.optJSONObject("notice");
          if (jSONObject1 != null) {
            c.b(jSONObject1.optInt("type"));
            c.c(jSONObject1.optString("msg"));
            c.d(jSONObject1.optString("title"));
          } else {
            c.b(-1);
          } 
          jSONObject = jSONObject.optJSONObject("update");
          if (jSONObject != null) {
            c.a(jSONObject.optInt("type"));
            c.a(jSONObject.optString("msg"));
            c.b(jSONObject.optString("url"));
          } else {
            c.a(-1);
          } 
          this.b.a(c);
        } else if (i == 1001) {
          Log.d(a.b(), "i rak");
          this.c.a(this.a);
        } else {
          this.b.a(i, jSONObject.optString("msg"));
        } 
      } else {
        String str = a.b();
        StringBuilder stringBuilder = new StringBuilder();
        this();
        Log.e(str, stringBuilder.append("do i but error:").append(jSONObject.a()).toString());
      } 
      return;
    } catch (Exception exception) {
      x.a().a(2);
      x.a().a(-35749, exception.getMessage());
      ErrorUtils.printExceptionInfo(exception);
      return;
    } finally {
      r.a().b();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */