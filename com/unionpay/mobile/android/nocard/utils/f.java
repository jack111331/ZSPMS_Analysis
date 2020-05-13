package com.unionpay.mobile.android.nocard.utils;

import android.text.TextUtils;
import com.unionpay.mobile.android.model.a;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.utils.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
  public static int a(b paramb, JSONObject paramJSONObject) {
    paramb.bt = j.a(paramJSONObject, "promotion_change_info");
    paramb.z = j.d(paramJSONObject, "rules");
    paramb.ad = j.d(paramJSONObject, "available_area_codes");
    paramb.D = j.d(paramJSONObject, "entrust_rules");
    paramb.E = j.a(paramJSONObject, "pre_cmd");
    paramb.A = j.a(paramJSONObject, "title");
    paramb.C = j.c(paramJSONObject, "rules_button");
    paramb.al = j.c(paramJSONObject, "service_checkbox");
    paramb.am = j.c(paramJSONObject, "bind_card_checkbox");
    String str2 = j.a(paramJSONObject, "timeout_msg");
    if (str2 != null && !TextUtils.isEmpty(str2))
      paramb.ak = str2; 
    paramb.p = new HashMap<Object, Object>();
    JSONObject jSONObject = j.c(paramJSONObject, "f55");
    str2 = j.a(jSONObject, "order_amount");
    HashMap<String, String> hashMap2 = paramb.p;
    if (str2 == null || str2.length() <= 0)
      str2 = "000000000000"; 
    hashMap2.put("trans_amt", str2);
    str2 = j.a(jSONObject, "order_currency");
    hashMap2 = paramb.p;
    if (str2 == null || str2.length() <= 0)
      str2 = "0156"; 
    hashMap2.put("trans currcy code", str2);
    str2 = j.a(jSONObject, "trans_type");
    hashMap2 = paramb.p;
    if (str2 == null || str2.length() <= 0)
      str2 = "00"; 
    hashMap2.put("trans_type", str2);
    str2 = j.a(jSONObject, "mer_name");
    HashMap<String, String> hashMap1 = paramb.p;
    if (str2 == null || str2.length() <= 0)
      str2 = ""; 
    hashMap1.put("mer_name", str2);
    paramb.aq = j.a(paramJSONObject, "pan");
    paramb.bf = j.a(paramJSONObject, "encrypt_key");
    paramb.bg = j.a(paramJSONObject, "auth_id");
    String str1 = j.a(paramJSONObject, "fail_continue");
    if (str1 != null && str1.equalsIgnoreCase("0"))
      paramb.F = true; 
    return ((paramb.z == null || paramb.z.length() <= 0) && (paramb.D == null || paramb.D.length() <= 0)) ? 2 : 0;
  }
  
  public static int a(b paramb, JSONObject paramJSONObject, boolean paramBoolean) {
    if (!paramBoolean)
      paramb.G = paramJSONObject; 
    return a(paramb, paramJSONObject);
  }
  
  public static e a(JSONObject paramJSONObject) {
    com.unionpay.mobile.android.model.f f1 = new com.unionpay.mobile.android.model.f();
    f1.a("promotion", j.c(paramJSONObject, "promotion"));
    f1.a("instalment", j.c(paramJSONObject, "instalment"));
    f1.a("promotion_instalment_msgbox", j.c(paramJSONObject, "promotion_instalment_msgbox"));
    return (e)f1;
  }
  
  public static boolean a(JSONArray paramJSONArray) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramJSONArray != null)
      for (byte b = 0;; b++) {
        bool2 = bool1;
        if (b < paramJSONArray.length()) {
          try {
            JSONObject jSONObject = paramJSONArray.getJSONObject(b);
            String str2 = j.a(jSONObject, "type");
            String str1 = j.a(jSONObject, "readonly");
            if ("pan".equalsIgnoreCase(str2)) {
              boolean bool = "true".equalsIgnoreCase(str1);
              bool2 = bool1;
              if (bool)
                bool2 = true; 
              return bool2;
            } 
          } catch (JSONException jSONException) {
            jSONException.printStackTrace();
          } 
        } else {
          return bool2;
        } 
      }  
    return bool2;
  }
  
  public static int b(b paramb, JSONObject paramJSONObject) {
    boolean bool;
    if (paramJSONObject == null) {
      bool = true;
    } else {
      bool = false;
    } 
    if (paramb.ab == null)
      paramb.ab = new ArrayList(); 
    paramb.ab.clear();
    List<JSONArray> list = j.e(paramJSONObject, "user_cards");
    if (list != null && list.size() > 0)
      for (byte b1 = 0; list != null && b1 < list.size(); b1++) {
        a a = new a(j.a(list.get(b1), 0), j.a(list.get(b1), 1), j.a(list.get(b1), 2), (byte)0);
        paramb.ab.add(a);
      }  
    paramb.ad = j.d(paramJSONObject, "available_area_codes");
    paramb.bt = j.a(paramJSONObject, "promotion_change_info");
    paramb.ac = j.d(paramJSONObject, "user_info");
    paramb.z = j.d(paramJSONObject, "rules");
    paramb.Z = j.c(paramJSONObject, "service_url");
    paramb.aa = j.c(paramJSONObject, "bind_url");
    paramb.ae = j.a(paramJSONObject, "empty_info");
    paramb.aY = j.a(paramJSONObject, "add_card_tip");
    paramb.aq = j.a(paramJSONObject, "pan");
    return bool;
  }
  
  public static boolean c(b paramb, JSONObject paramJSONObject) {
    boolean bool = false;
    paramb.aF = null;
    paramb.aF = j.c(paramJSONObject, "cardExpireMsgBox");
    if (paramb.aF == null)
      paramb.aF = j.c(paramJSONObject, "openByCounterMsgBox"); 
    if (paramb.aF == null)
      paramb.aF = j.c(paramJSONObject, "restrictPayMsgBox"); 
    if (paramb.aF != null) {
      paramb.aG = j.a(paramb.aF, "title");
      paramb.aH = j.a(paramb.aF, "text");
      JSONObject jSONObject = j.c(paramb.aF, "func");
      paramJSONObject = j.c(paramb.aF, "cancel");
      paramb.aK = j.a(jSONObject, "label");
      paramb.aL = j.a(jSONObject, "action");
      paramb.aI = j.a(paramJSONObject, "label");
      paramb.aJ = j.a(paramJSONObject, "action");
      bool = true;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocar\\utils\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */