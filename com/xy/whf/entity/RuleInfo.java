package com.xy.whf.entity;

import android.support.annotation.NonNull;
import com.xy.whf.helper.LangHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class RuleInfo implements Serializable {
  private static final long serialVersionUID = 7119538996093173973L;
  
  public int dataPos = 0;
  
  public int dataType = 1;
  
  public List<RandomParam> keys = new ArrayList<RandomParam>();
  
  public LogData logData = new LogData();
  
  public int number = 0;
  
  public String startTime = "";
  
  public int uploadType = 0;
  
  public String url = "";
  
  public RuleInfo() {}
  
  public RuleInfo(JSONObject paramJSONObject) {
    try {
      this.dataType = paramJSONObject.optInt("dataType", 0);
      this.uploadType = paramJSONObject.optInt("uploadType", 0);
      this.dataPos = paramJSONObject.optInt("dataPos", 0);
      this.number = paramJSONObject.optInt("number", 0);
      this.startTime = paramJSONObject.optString("startTime", "");
      this.url = paramJSONObject.optString("url", "");
      JSONArray jSONArray = paramJSONObject.optJSONArray("keys");
      if (!LangHelper.isNullOrEmpty(jSONArray))
        while (b < jSONArray.length()) {
          RandomParam randomParam = new RandomParam();
          this(jSONArray.optJSONObject(b));
          this.keys.add(randomParam);
          b++;
        }  
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  @NonNull
  public String toString() {
    return "RuleInfo{dataType=" + this.dataType + ", url='" + this.url + '\'' + ", uploadType=" + this.uploadType + ", keys=" + this.keys + ", number=" + this.number + ", dataPos=" + this.dataPos + ", startTime='" + this.startTime + '\'' + '}';
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\entity\RuleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */