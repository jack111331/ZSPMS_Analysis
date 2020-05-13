package com.aliyun.sls.android.sdk.core;

import com.aliyun.sls.android.sdk.core.http.HttpMethod;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class RequestMessage {
  public Map<String, String> headers = new HashMap<String, String>();
  
  public HttpMethod method;
  
  private long readStreamLength;
  
  private byte[] uploadData;
  
  private String uploadFilePath;
  
  private InputStream uploadInputStream;
  
  public String url;
  
  public Map<String, String> getHeaders() {
    return this.headers;
  }
  
  public HttpMethod getMethod() {
    return this.method;
  }
  
  public long getReadStreamLength() {
    return this.readStreamLength;
  }
  
  public byte[] getUploadData() {
    return this.uploadData;
  }
  
  public String getUploadFilePath() {
    return this.uploadFilePath;
  }
  
  public InputStream getUploadInputStream() {
    return this.uploadInputStream;
  }
  
  public void setUploadData(byte[] paramArrayOfbyte) {
    this.uploadData = paramArrayOfbyte;
  }
  
  public void setUploadFilePath(String paramString) {
    this.uploadFilePath = paramString;
  }
  
  public void setUploadInputStream(InputStream paramInputStream, long paramLong) {
    if (paramInputStream != null) {
      this.uploadInputStream = paramInputStream;
      this.readStreamLength = paramLong;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\core\RequestMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */