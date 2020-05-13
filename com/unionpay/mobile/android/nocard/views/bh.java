package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.location.Location;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.c;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.widgets.ad;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bh {
  public static LinearLayout a(Context paramContext, JSONArray paramJSONArray, int paramInt1, int paramInt2) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    linearLayout.setBackgroundColor(-1);
    linearLayout.setOrientation(1);
    (new LinearLayout.LayoutParams(-1, -2)).topMargin = a.d;
    JSONObject jSONObject = null;
    while (paramInt1 < paramInt2 && paramInt1 < paramJSONArray.length()) {
      try {
        JSONObject jSONObject1 = paramJSONArray.getJSONObject(paramInt1);
        jSONObject = jSONObject1;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      linearLayout.addView((View)new ad(paramContext, a.I, jSONObject, ""));
      paramInt1++;
    } 
    return linearLayout;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    JSONObject jSONObject = new JSONObject();
    try {
      String str2;
      String str1;
      jSONObject.put("tn", paramString1);
      jSONObject.put("user", f.d(paramContext));
      jSONObject.put("locale", a(f.a()));
      jSONObject.put("terminal_version", f.a(paramContext));
      jSONObject.put("terminal_resolution", f.d());
      jSONObject.put("os_name", paramString2);
      jSONObject.put("os_version", Build.VERSION.RELEASE.trim());
      jSONObject.put("device_model", a(f.c()));
      jSONObject.put("terminal_type", paramString3);
      jSONObject.put("appId", paramString4);
      jSONObject.put("uid", PreferenceUtils.a(paramContext));
      jSONObject.put("mac", a(f.c(paramContext)));
      try {
        jSONObject.put("time_zone", a(f.f()));
      } catch (Exception exception) {}
      try {
        jSONObject.put("network_mode", f.f(paramContext));
      } catch (Exception exception) {}
      try {
        jSONObject.put("imsi", a(f.e(paramContext)));
      } catch (Exception exception) {}
      try {
        jSONObject.put("baseband_version", a(f.e()));
      } catch (Exception exception) {}
      try {
        StringBuffer stringBuffer = new StringBuffer();
        this("000");
        if (!"000".equals(paramString5))
          stringBuffer.setCharAt(2, '1'); 
        if (Build.VERSION.SDK_INT >= 10) {
          NfcAdapter nfcAdapter = ((NfcManager)paramContext.getSystemService("nfc")).getDefaultAdapter();
          if (nfcAdapter != null) {
            if (nfcAdapter.isEnabled()) {
              stringBuffer.setCharAt(0, '1');
            } else {
              stringBuffer.setCharAt(0, '2');
            } 
            if (Build.VERSION.SDK_INT >= 19 && paramContext.getPackageManager().hasSystemFeature("android.hardware.nfc.hce"))
              stringBuffer.setCharAt(1, '1'); 
          } 
        } 
        jSONObject.put("support_map", stringBuffer.toString());
      } catch (Exception exception) {}
      try {
        jSONObject.put("se_map", paramString5);
      } catch (Exception exception) {}
      jSONObject.put("root", f.b());
      jSONObject.put("country", a(Locale.getDefault().getCountry()));
      jSONObject.put("package", a(f.b(paramContext)));
      Location location2 = f.g(paramContext);
      if (location2 != null) {
        str2 = Double.valueOf(location2.getLatitude()).toString();
      } else {
        str2 = "";
      } 
      jSONObject.put("latitude", a(str2));
      Location location1 = f.g(paramContext);
      if (location1 != null) {
        str1 = Double.valueOf(location1.getLongitude()).toString();
      } else {
        str1 = "";
      } 
      jSONObject.put("longitude", a(str1));
      jSONObject.put("tel", a(f.h(paramContext)));
      jSONObject.put("packageId", c.b(paramContext));
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } catch (PatternSyntaxException patternSyntaxException) {
      patternSyntaxException.printStackTrace();
    } 
    String str = jSONObject.toString();
    str = str.substring(1, str.length() - 1);
    k.a("uppay", "init: " + str);
    return str;
  }
  
  private static String a(String paramString) throws PatternSyntaxException {
    return (paramString != null) ? Pattern.compile("[\":,\\[\\]{}]").matcher(paramString).replaceAll("").trim() : "";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4) {
    return String.format("\"first_pay_flag\":\"%s\",\"card\":\"%s\",\"pay_type\":\"%s\",\"pay_mode\":\"%s\"", new Object[] { paramString1, paramString2, paramString3, paramString4 });
  }
  
  public static String a(JSONObject paramJSONObject) {
    k.a("uppay", "action:" + j.a(paramJSONObject, "action"));
    return j.a(paramJSONObject, "action");
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("amount", paramString1);
      jSONObject.put("aid", paramString5);
      jSONObject.put("user", f.d(paramContext));
      jSONObject.put("locale", a(f.a()));
      jSONObject.put("terminal_version", f.a(paramContext));
      jSONObject.put("terminal_resolution", f.d());
      jSONObject.put("os_name", paramString2);
      jSONObject.put("os_version", Build.VERSION.RELEASE.trim());
      jSONObject.put("device_model", a(f.c()));
      jSONObject.put("terminal_type", paramString3);
      jSONObject.put("appId", paramString4);
      jSONObject.put("uid", PreferenceUtils.a(paramContext));
      jSONObject.put("mac", a(f.c(paramContext)));
      try {
        jSONObject.put("time_zone", a(f.f()));
      } catch (Exception exception) {}
      try {
        jSONObject.put("network_mode", f.f(paramContext));
      } catch (Exception exception) {}
      try {
        jSONObject.put("imsi", a(f.e(paramContext)));
      } catch (Exception exception) {}
      try {
        jSONObject.put("baseband_version", a(f.e()));
      } catch (Exception exception) {}
      jSONObject.put("root", f.b());
      jSONObject.put("country", a(Locale.getDefault().getCountry()));
      jSONObject.put("package", a(f.b(paramContext)));
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } catch (PatternSyntaxException patternSyntaxException) {
      patternSyntaxException.printStackTrace();
    } 
    String str = jSONObject.toString();
    str = str.substring(1, str.length() - 1);
    k.c("uppay", "init: " + str);
    return str;
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4) {
    return String.format("\"first_pay_flag\":\"%s\",%s,\"pay_type\":\"%s\",\"pay_mode\":\"%s\"", new Object[] { paramString1, paramString2, paramString3, paramString4 });
  }
  
  public static String c(String paramString1, String paramString2, String paramString3, String paramString4) {
    return (paramString3 != null && paramString3.length() > 0) ? String.format("\"pay_type\":\"%s\",\"pay_mode\":\"%s\",%s,%s", new Object[] { paramString1, paramString2, paramString3, paramString4 }) : String.format("\"pay_type\":\"%s\",\"pay_mode\":\"%s\",%s", new Object[] { paramString1, paramString2, paramString4 });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */