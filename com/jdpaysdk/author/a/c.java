package com.jdpaysdk.author.a;

import com.jdpaysdk.author.a.b.a;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

class c implements Callback {
  c(b paramb, a parama, int paramInt) {}
  
  public void onFailure(Call paramCall, IOException paramIOException) {
    this.c.a(paramCall, paramIOException, this.a, this.b);
  }
  
  public void onResponse(Call paramCall, Response paramResponse) {
    if (paramCall.isCanceled()) {
      this.c.a(paramCall, new IOException("Canceled!"), this.a, this.b);
      return;
    } 
    if (!this.a.a(paramResponse, this.b)) {
      this.c.a(paramCall, new IOException("request failed , reponse's code is : " + paramResponse.code()), this.a, this.b);
      return;
    } 
    try {
      Object object = this.a.b(paramResponse, this.b);
      this.c.a(object, this.a, this.b);
    } catch (Exception exception) {
      this.c.a(paramCall, exception, this.a, this.b);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */