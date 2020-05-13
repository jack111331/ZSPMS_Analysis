package com.alipay.sdk.packet.impl;

import android.content.Context;
import com.alipay.sdk.packet.b;
import com.alipay.sdk.packet.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends d {
  public static final String t = "log_v";
  
  public final b a(Context paramContext, String paramString) throws Throwable {
    return a(paramContext, paramString, "https://mcgw.alipay.com/sdklog.do", true);
  }
  
  protected final String a(String paramString, JSONObject paramJSONObject) {
    return paramString;
  }
  
  protected final List<Header> a(boolean paramBoolean, String paramString) {
    ArrayList<BasicHeader> arrayList = new ArrayList();
    arrayList.add(new BasicHeader("msp-gzip", String.valueOf(paramBoolean)));
    arrayList.add(new BasicHeader("content-type", "application/octet-stream"));
    arrayList.add(new BasicHeader("des-mode", "CBC"));
    return (List)arrayList;
  }
  
  protected final JSONObject a() throws JSONException {
    return null;
  }
  
  protected final String c() throws JSONException {
    HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
    hashMap1.put("api_name", "/sdk/log");
    hashMap1.put("api_version", "1.0.0");
    HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
    hashMap2.put("log_v", "1.0");
    return a(hashMap1, hashMap2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\packet\impl\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */