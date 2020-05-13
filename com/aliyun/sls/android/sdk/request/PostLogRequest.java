package com.aliyun.sls.android.sdk.request;

import com.aliyun.sls.android.sdk.core.Request;
import com.aliyun.sls.android.sdk.model.LogGroup;

public class PostLogRequest extends Request {
  public String logContentType = "application/json";
  
  public LogGroup mLogGroup;
  
  public String mLogStoreName;
  
  public String mProject;
  
  public PostLogRequest(String paramString1, String paramString2, LogGroup paramLogGroup) {
    this.mProject = paramString1;
    this.mLogStoreName = paramString2;
    this.mLogGroup = paramLogGroup;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\request\PostLogRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */