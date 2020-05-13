package com.unionpay.mobile.android.nocard.utils;

import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;

public final class b {
  public static void a(JSONObject paramJSONObject, com.unionpay.mobile.android.model.b paramb) {
    paramb.as = j.a(paramJSONObject, "red_packet_url");
  }
  
  public static void b(JSONObject paramJSONObject, com.unionpay.mobile.android.model.b paramb) {
    paramb.aR = j.a(paramJSONObject, "pay_msg");
    paramb.bj = j.a(paramJSONObject, "reserved");
    paramb.aS = j.a(paramJSONObject, "promotion_msg");
    paramb.aT = j.a(paramJSONObject, "instalment_msg");
    paramb.aW = j.a(paramJSONObject, "temporary_pay_flag");
    if ("0".equalsIgnoreCase(paramb.aW))
      paramb.aX = j.a(paramJSONObject, "temporary_pay_info"); 
    if ("0".equalsIgnoreCase(j.a(paramJSONObject, "luck_draw_flag")))
      paramb.aV = true; 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocar\\utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */