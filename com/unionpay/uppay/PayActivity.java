package com.unionpay.uppay;

import android.content.Context;
import android.content.Intent;
import android.nfc.NfcManager;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.unionpay.mobile.android.fully.a;
import com.unionpay.mobile.android.hce.f;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.views.b;
import com.unionpay.mobile.android.nocard.views.l;
import com.unionpay.mobile.android.pboctransaction.nfc.a;
import com.unionpay.mobile.android.pboctransaction.nfc.b;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.pro.pboc.engine.b;
import com.unionpay.mobile.android.pro.views.a;
import com.unionpay.mobile.android.pro.views.j;
import com.unionpay.mobile.android.pro.views.k;
import com.unionpay.mobile.android.pro.views.v;
import com.unionpay.mobile.android.pro.views.x;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.utils.o;

public final class PayActivity extends BaseActivity {
  public static String a = "";
  
  private b d = null;
  
  private f e = null;
  
  private o f;
  
  private k g = null;
  
  public final b a(int paramInt, e parame) {
    j j;
    k k1;
    e e1 = null;
    switch (paramInt) {
      default:
        return (b)e1;
      case 1:
        j = new j((Context)this);
        ((l)j).a(a());
        return (b)j;
      case 2:
        return (b)new v((Context)this, (e)j);
      case 6:
        return (b)new x((Context)this, (e)j);
      case 17:
        k1 = new k((Context)this, (e)j, (UPPayEngine)a(UPPayEngine.class.toString()));
        this.g = k1;
        this.g.r = c();
        this.g.a(this.c);
        return (b)k1;
      case 18:
        break;
    } 
    return (b)new a((Context)this, (e)k1, (UPPayEngine)a(UPPayEngine.class.toString()));
  }
  
  public final Object a(String paramString) {
    if (b.class.toString().equalsIgnoreCase(paramString)) {
      if (this.d == null)
        this.d = new b((Context)this, c()); 
      return this.d;
    } 
    if (f.class.toString().equalsIgnoreCase(paramString)) {
      if (this.e == null)
        this.e = new f((Context)this); 
      return this.e;
    } 
    return super.a(paramString);
  }
  
  public final boolean a() {
    boolean bool;
    if (Build.VERSION.SDK_INT < 10)
      return false; 
    if (getPackageManager().checkPermission("android.permission.NFC", f.b((Context)this)) == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return !bool ? false : ((((NfcManager)getSystemService("nfc")).getDefaultAdapter() != null));
  }
  
  public final UPPayEngine d() {
    this.f = new o((Context)this);
    return (UPPayEngine)this.f;
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.g != null && this.g.getParent() != null)
      this.g.a(this.c); 
  }
  
  public final void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  protected final void onDestroy() {
    super.onDestroy();
    if (this.d != null) {
      this.d.a();
      this.d = null;
    } 
    this.f.h();
    this.f = null;
    this.g = null;
    a = "";
  }
  
  protected final void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    Parcelable parcelable = paramIntent.getParcelableExtra("android.nfc.extra.TAG");
    if (parcelable != null) {
      Log.d("NFCTAG", paramIntent.getAction());
      b.b b1 = new b.b(IsoDep.get((Tag)parcelable));
      b1.a();
      a a = new a((a)a(UPPayEngine.class.toString()), b1);
      if (this.g != null && this.g.getParent() != null)
        this.g.a(a); 
    } 
  }
  
  protected final void onResume() {
    super.onResume();
    if (this.g != null && this.g.getParent() != null)
      this.g.a(this.c); 
  }
  
  static {
    System.loadLibrary("entryexpro");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpa\\uppay\PayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */