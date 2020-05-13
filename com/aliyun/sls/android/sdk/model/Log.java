package com.aliyun.sls.android.sdk.model;

import java.util.HashMap;
import java.util.Map;

public class Log {
  Map<String, Object> mContent = new HashMap<String, Object>();
  
  public Log() {
    this.mContent.put("__time__", Integer.valueOf((new Long(System.currentTimeMillis() / 1000L)).intValue()));
  }
  
  public Map<String, Object> GetContent() {
    return this.mContent;
  }
  
  public void PutContent(String paramString1, String paramString2) {
    if (paramString1 == null || paramString1.isEmpty())
      return; 
    if (paramString2 == null) {
      this.mContent.put(paramString1, "");
    } else {
      this.mContent.put(paramString1, paramString2);
    } 
  }
  
  public void PutTime(int paramInt) {
    this.mContent.put("__time__", Integer.valueOf(paramInt));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\model\Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */