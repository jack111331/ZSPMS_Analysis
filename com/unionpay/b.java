package com.unionpay;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.unionpay.utils.UPUtils;
import com.unionpay.utils.b;
import com.unionpay.utils.g;
import org.json.JSONArray;
import org.json.JSONObject;

final class b implements Handler.Callback {
  public final boolean handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return true;
      case 1002:
        try {
          if (paramMessage.obj != null) {
            JSONObject jSONObject = new JSONObject();
            this((String)paramMessage.obj);
            String str = g.a(jSONObject, "sign");
            try {
              int i = Integer.parseInt(UPPayAssistEx.g());
              String str2 = new String();
              this(Base64.decode(jSONObject.getString("configs"), 2));
              String str3 = "";
              if (jSONObject.has("sePayConf")) {
                str3 = new String();
                this(Base64.decode(jSONObject.getString("sePayConf"), 2));
              } 
              if (TextUtils.isEmpty(str3))
                str3 = ""; 
              StringBuilder stringBuilder = new StringBuilder();
              this();
              String str1 = b.a(UPUtils.a(stringBuilder.append(str2).append(str3).append(UPPayAssistEx.h()).toString()));
              if (UPUtils.forConfig(i, str).equals(str1)) {
                UPUtils.a(UPPayAssistEx.c(), (String)paramMessage.obj, "configs");
                UPUtils.a(UPPayAssistEx.c(), UPPayAssistEx.g(), "mode");
                UPUtils.a(UPPayAssistEx.c(), UPPayAssistEx.h(), "or");
                if (!TextUtils.isEmpty(UPPayAssistEx.i())) {
                  Context context = UPPayAssistEx.c();
                  StringBuilder stringBuilder1 = new StringBuilder();
                  this("se_configs");
                  UPUtils.a(context, str3, stringBuilder1.append(UPPayAssistEx.i()).toString());
                } 
                if (!UPPayAssistEx.j()) {
                  JSONArray jSONArray = new JSONArray();
                  this(str2);
                  UPPayAssistEx.a(UPPayAssistEx.a(jSONArray, "sort"));
                  UPPayAssistEx.b(str3);
                } 
              } 
              if (!UPPayAssistEx.j())
                UPPayAssistEx.a(UPPayAssistEx.c(), UPPayAssistEx.k(), UPPayAssistEx.l()); 
            } catch (NumberFormatException numberFormatException) {
              boolean bool = false;
            } 
          } 
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        if (!UPPayAssistEx.j())
          UPPayAssistEx.a(UPPayAssistEx.c(), UPPayAssistEx.k(), UPPayAssistEx.l()); 
      case 1001:
        break;
    } 
    UPPayAssistEx.m();
    UPPayAssistEx.a(UPPayAssistEx.c(), UPPayAssistEx.k(), UPPayAssistEx.l());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */