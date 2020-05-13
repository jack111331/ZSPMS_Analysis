package com.hu.scan.permission.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class a extends d {
  private Activity a;
  
  public a(Activity paramActivity) {
    this.a = paramActivity;
  }
  
  public Context a() {
    return (Context)this.a;
  }
  
  public void a(Intent paramIntent) {
    this.a.startActivity(paramIntent);
  }
  
  public void a(Intent paramIntent, int paramInt) {
    this.a.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */