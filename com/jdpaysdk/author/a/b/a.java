package com.jdpaysdk.author.a.b;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

public abstract class a<T> {
  public static a a = new b();
  
  public void a(int paramInt) {}
  
  public abstract void a(T paramT, int paramInt);
  
  public abstract void a(Call paramCall, Exception paramException, int paramInt);
  
  public void a(Request paramRequest, int paramInt) {}
  
  public boolean a(Response paramResponse, int paramInt) {
    return paramResponse.isSuccessful();
  }
  
  public abstract T b(Response paramResponse, int paramInt);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */