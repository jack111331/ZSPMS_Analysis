package com.jdpaysdk.author;

import android.content.Context;
import com.google.gson.Gson;
import com.jdpaysdk.author.a.d.a;
import com.jdpaysdk.author.c.a;
import com.jdpaysdk.author.d.a;
import com.jdpaysdk.author.protocol.VerifyAppKeyResponse;

class c implements a {
  c(AuthorActivity paramAuthorActivity) {}
  
  public void a() {
    a.a((Context)this.a);
  }
  
  public void a(String paramString) {
    try {
      Gson gson = new Gson();
      this();
      VerifyAppKeyResponse verifyAppKeyResponse = (VerifyAppKeyResponse)gson.fromJson(paramString, VerifyAppKeyResponse.class);
      if (verifyAppKeyResponse == null || !verifyAppKeyResponse.getResultCode().equals("0")) {
        AuthorActivity.b(this.a, verifyAppKeyResponse.getErrorCode());
        return;
      } 
      if (!a.a((Context)this.a, "com.jingdong.app.mall")) {
        AuthorActivity.b(this.a);
        return;
      } 
    } catch (Exception exception) {
      AuthorActivity.b(this.a, "");
      return;
    } 
    AuthorActivity.c(this.a);
  }
  
  public void a(String paramString1, String paramString2) {
    AuthorActivity.b(this.a, paramString1);
  }
  
  public void b() {
    a.a();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */