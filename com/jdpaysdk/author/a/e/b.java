package com.jdpaysdk.author.a.e;

import com.jdpaysdk.author.a.f.a;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class b extends a {
  private static MediaType g = MediaType.parse("text/plain;charset=utf-8");
  
  private String h;
  
  private MediaType i;
  
  public b(String paramString1, Object paramObject, Map<String, String> paramMap1, Map<String, String> paramMap2, String paramString2, MediaType paramMediaType, int paramInt) {
    super(paramString1, paramObject, paramMap1, paramMap2, paramInt);
    this.h = paramString2;
    this.i = paramMediaType;
    if (this.h == null)
      a.a("the content can not be null !", new Object[0]); 
    if (this.i == null)
      this.i = g; 
  }
  
  protected Request a(RequestBody paramRequestBody) {
    return this.f.post(paramRequestBody).build();
  }
  
  protected RequestBody a() {
    return RequestBody.create(this.i, this.h);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\a\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */