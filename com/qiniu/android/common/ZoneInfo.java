package com.qiniu.android.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ZoneInfo {
  private static int DOMAIN_FROZEN_SECONDS = 600;
  
  private final int ttl;
  
  public final List<String> upDomainsList;
  
  public final Map<String, Long> upDomainsMap;
  
  public ZoneInfo(int paramInt, List<String> paramList, Map<String, Long> paramMap) {
    this.ttl = paramInt;
    this.upDomainsList = paramList;
    this.upDomainsMap = paramMap;
  }
  
  public static ZoneInfo buildFromJson(JSONObject paramJSONObject) throws JSONException {
    int i = paramJSONObject.getInt("ttl");
    ArrayList<String> arrayList = new ArrayList();
    ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>();
    JSONObject jSONObject = paramJSONObject.getJSONObject("up");
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "acc";
    arrayOfString[1] = "src";
    arrayOfString[2] = "old_acc";
    arrayOfString[3] = "old_src";
    int j = arrayOfString.length;
    byte b = 0;
    while (true) {
      if (b < j) {
        JSONObject jSONObject1 = jSONObject.getJSONObject(arrayOfString[b]);
        JSONArray jSONArray = jSONObject1.getJSONArray("main");
        byte b1;
        for (b1 = 0; b1 < jSONArray.length(); b1++) {
          String str = jSONArray.getString(b1);
          arrayList.add(str);
          concurrentHashMap.put(str, Long.valueOf(0L));
        } 
        try {
          JSONArray jSONArray1 = jSONObject1.getJSONArray("backup");
          if (jSONArray1 != null)
            for (b1 = 0; b1 < jSONArray1.length(); b1++) {
              String str = jSONArray1.getString(b1);
              arrayList.add(str);
              concurrentHashMap.put(str, Long.valueOf(0L));
            }  
        } catch (JSONException jSONException) {}
        b++;
        continue;
      } 
      return new ZoneInfo(i, arrayList, (Map)concurrentHashMap);
    } 
  }
  
  public void frozenDomain(String paramString) {
    this.upDomainsMap.put(paramString, Long.valueOf(System.currentTimeMillis() / 1000L + DOMAIN_FROZEN_SECONDS));
  }
  
  public String toString() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("ttl", Integer.valueOf(this.ttl));
    hashMap.put("upDomainList", this.upDomainsList);
    hashMap.put("upDomainMap", this.upDomainsMap);
    return (new JSONObject(hashMap)).toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\common\ZoneInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */