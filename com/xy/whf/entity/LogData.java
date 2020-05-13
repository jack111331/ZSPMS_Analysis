package com.xy.whf.entity;

import com.xy.whf.helper.LangHelper;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

public class LogData implements Serializable {
  private static final long serialVersionUID = 2839512295256926733L;
  
  public JSONObject data = null;
  
  public int dataPos = 0;
  
  public int dataType = 0;
  
  public JSONArray rows = null;
  
  public int statusCode = 0;
  
  public LogData() {}
  
  public LogData(int paramInt1, int paramInt2, int paramInt3) {
    this.dataType = paramInt1;
    this.dataPos = paramInt2;
    this.statusCode = paramInt3;
  }
  
  public LogData(int paramInt1, int paramInt2, JSONArray paramJSONArray) {
    this.dataType = paramInt1;
    this.dataPos = paramInt2;
    this.rows = paramJSONArray;
  }
  
  public LogData(int paramInt1, int paramInt2, JSONObject paramJSONObject) {
    this.dataType = paramInt1;
    this.dataPos = paramInt2;
    this.data = paramJSONObject;
  }
  
  public JSONObject toJSONObject() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("data_type", this.dataType);
      jSONObject.put("data_pos", this.dataPos);
      if (!LangHelper.isNullOrEmpty(this.rows)) {
        jSONObject.put("data_rows", this.rows);
        return jSONObject;
      } 
      jSONObject.put("data_obj", this.data);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return jSONObject;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\entity\LogData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */