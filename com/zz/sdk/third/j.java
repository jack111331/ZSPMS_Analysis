package com.zz.sdk.third;

import android.os.Bundle;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboException;
import com.zz.sdk.i.bp;
import com.zz.sdk.third.a.a;

class j implements WeiboAuthListener {
  private j(h paramh) {}
  
  public void onCancel() {
    bp.a("ThirdSina login onCancel");
    if (h.a(this.a) != null)
      h.a(this.a).a(this.a.e()); 
  }
  
  public void onComplete(Bundle paramBundle) {
    bp.a("ThirdSina login onComplete -->" + paramBundle);
    Oauth2AccessToken oauth2AccessToken = Oauth2AccessToken.parseAccessToken(paramBundle);
    if (oauth2AccessToken.isSessionValid()) {
      a a = new a(this.a.e());
      a.c(oauth2AccessToken.getToken());
      a.b(oauth2AccessToken.getUid());
      a.a(oauth2AccessToken.getExpiresTime());
      this.a.a(a);
      if (h.a(this.a) != null)
        h.a(this.a).a(this.a.e(), a); 
      return;
    } 
    h.a(this.a).a(this.a.e(), null);
  }
  
  public void onWeiboException(WeiboException paramWeiboException) {
    bp.a("ThirdSina login onWeiboException -->" + paramWeiboException.toString());
    if (h.a(this.a) != null)
      h.a(this.a).a(this.a.e(), null); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\third\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */