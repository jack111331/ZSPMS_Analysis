package com.tencent.open;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;

public class SocialApi {
  private SocialApiIml a;
  
  public SocialApi(QQToken paramQQToken) {
    this.a = new SocialApiIml(paramQQToken);
  }
  
  public void ask(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    this.a.ask(paramActivity, paramBundle, paramIUiListener);
  }
  
  public void gift(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    this.a.gift(paramActivity, paramBundle, paramIUiListener);
  }
  
  public void invite(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    this.a.invite(paramActivity, paramBundle, paramIUiListener);
  }
  
  public void story(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    this.a.story(paramActivity, paramBundle, paramIUiListener);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\open\SocialApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */