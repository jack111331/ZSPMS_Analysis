package com.unionpay;

import android.content.Context;
import org.json.JSONObject;

final class w implements ac {
  w(UPPayWapActivity paramUPPayWapActivity) {}
  
  public final void a(String paramString, ad paramad) {
    try {
      String str3;
      String str4;
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      String str2 = "";
      try {
        paramString = (String)jSONObject.get("url");
        try {
          str3 = (String)jSONObject.get("app");
          try {
            str4 = (String)jSONObject.get("title");
            try {
              str5 = (String)jSONObject.get("desp");
              try {
                String str = (String)jSONObject.get("md5");
                UPPayAssistEx.a((Context)this.a, paramString, str3, str4, str5, str);
              } catch (Exception null) {
                String str = paramString;
                paramString = str5;
                str5 = str;
              } 
            } catch (Exception null) {
              String str = "";
              str5 = paramString;
              paramString = str;
            } 
          } catch (Exception null) {
            str4 = "";
            String str = "";
            str5 = paramString;
            paramString = str;
          } 
        } catch (Exception null) {
          str3 = "";
          str4 = "";
          String str = "";
          str5 = paramString;
          paramString = str;
        } 
      } catch (Exception exception) {
        str5 = "";
        str3 = "";
        str4 = "";
        paramString = "";
      } 
      if (paramad != null) {
        UPPayWapActivity uPPayWapActivity = this.a;
        paramad.a(UPPayWapActivity.a("1", exception.getMessage(), (String)null));
      } 
      String str1 = str5;
      String str5 = paramString;
      paramString = str1;
      str1 = str2;
      UPPayAssistEx.a((Context)this.a, paramString, str3, str4, str5, str1);
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */