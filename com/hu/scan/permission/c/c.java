package com.hu.scan.permission.c;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;

public class c extends d {
  private Fragment a;
  
  public c(Fragment paramFragment) {
    this.a = paramFragment;
  }
  
  public Context a() {
    return (Context)this.a.getActivity();
  }
  
  public void a(Intent paramIntent) {
    this.a.startActivity(paramIntent);
  }
  
  public void a(Intent paramIntent, int paramInt) {
    this.a.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */