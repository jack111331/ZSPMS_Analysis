package com.aliyun.sls.android.sdk.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogGroup {
  protected List<Log> mContent = new ArrayList<Log>();
  
  private String mSource = "";
  
  private String mTopic = "";
  
  public LogGroup() {}
  
  public LogGroup(String paramString1, String paramString2) {
    this.mTopic = paramString1;
    this.mSource = paramString2;
  }
  
  public String LogGroupToJsonString() {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("__source__", this.mSource);
    jSONObject.put("__topic__", this.mTopic);
    JSONArray jSONArray = new JSONArray();
    Iterator<Log> iterator = this.mContent.iterator();
    while (iterator.hasNext())
      jSONArray.add(new JSONObject(((Log)iterator.next()).GetContent())); 
    jSONObject.put("__logs__", jSONArray);
    return jSONObject.toJSONString();
  }
  
  public void PutLog(Log paramLog) {
    this.mContent.add(paramLog);
  }
  
  public void PutSource(String paramString) {
    this.mSource = paramString;
  }
  
  public void PutTopic(String paramString) {
    this.mTopic = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\model\LogGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */