package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.fully.a;
import com.unionpay.mobile.android.net.c;
import com.unionpay.mobile.android.net.d;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class o extends UPPayEngine implements a {
  private Context b;
  
  public o(Context paramContext) {
    super(paramContext);
    this.b = paramContext;
  }
  
  public final String a(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      jSONObject.put("reqtm", i());
      String str1 = jSONObject.toString();
      paramString = str1;
    } catch (JSONException jSONException) {}
    k.c("uppay", "post message = " + paramString);
    String str = f(paramString);
    null = d();
    if (null != null) {
      try {
        null.a(str);
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        this(1);
        hashMap.put("sid", f());
        null.a(hashMap);
        g();
        if (this.a == null) {
          c c = new c();
          this(null, this.b);
          this.a = c;
        } 
        int i = this.a.a();
        String str1 = this.a.c();
        if (i == 0) {
          str1 = g(str1);
          StringBuilder stringBuilder = new StringBuilder();
          this("[ response msg ] ");
          k.a("uppay", stringBuilder.append(str1).toString());
          return str1;
        } 
        Handler handler = e();
        if (handler != null) {
          Message message = handler.obtainMessage(2);
          message.arg1 = i;
          handler.sendMessage(message);
        } 
        str1 = null;
      } catch (Exception exception) {
        exception = null;
      } 
      return (String)exception;
    } 
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\utils\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */