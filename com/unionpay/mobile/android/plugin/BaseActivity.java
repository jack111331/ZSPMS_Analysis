package com.unionpay.mobile.android.plugin;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.views.b;
import com.unionpay.mobile.android.nocard.views.l;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.widgets.m;
import com.unionpay.sdk.UPAgent;
import java.util.ArrayList;

public abstract class BaseActivity extends Activity implements a, b {
  public static IntentFilter[] FILTERS;
  
  public static String[][] TECHLISTS;
  
  private static int f = 0;
  
  private l a = null;
  
  protected ArrayList<b> b = null;
  
  protected NfcAdapter c;
  
  private a d = null;
  
  private m e = null;
  
  private PendingIntent g;
  
  static {
    try {
      String str1 = IsoDep.class.getName();
      String str2 = NfcV.class.getName();
      String str3 = NfcF.class.getName();
      TECHLISTS = new String[][] { { str1 }, { str2 }, { str3 } };
      IntentFilter intentFilter = new IntentFilter();
      this("android.nfc.action.TECH_DISCOVERED", "*/*");
      FILTERS = new IntentFilter[] { intentFilter };
    } catch (Exception exception) {}
  }
  
  public Object a(String paramString) {
    m m1;
    b b1 = null;
    if (paramString == null)
      return this.d.a; 
    if (paramString.equalsIgnoreCase(UPPayEngine.class.toString()))
      return this.d.b; 
    if (paramString.equalsIgnoreCase(m.class.toString()))
      m1 = this.e; 
    return m1;
  }
  
  public final void a(int paramInt) {
    if (this.b != null) {
      int i = this.b.size() - 1;
      this.b.get(i);
      for (int j = i;; j--) {
        b b1;
        if (j >= 0) {
          b1 = this.b.get(j);
          if (b1.h() == paramInt) {
            b1.s();
            setContentView((View)b1);
            return;
          } 
        } else {
          return;
        } 
        if (j == i)
          b1.t(); 
        this.b.remove(j);
      } 
    } 
  }
  
  public final void a(b paramb) {
    if (this.b != null) {
      int i = this.b.size();
      if (i > 0)
        ((b)this.b.get(i - 1)).t(); 
      paramb.s();
      this.b.add(paramb);
      setContentView((View)paramb);
    } 
  }
  
  public boolean a() {
    return false;
  }
  
  public final void b() {
    if (this.b != null) {
      int i = this.b.size();
      if (i > 0) {
        this.b.get(i - 1);
        ((b)this.b.get(i - 1)).t();
        this.b.remove(i - 1);
        if (this.b.size() != 0) {
          ((b)this.b.get(this.b.size() - 1)).s();
          setContentView((View)this.b.get(this.b.size() - 1));
        } 
      } 
    } 
  }
  
  public final String c() {
    return this.d.a.a;
  }
  
  public Resources getResources() {
    Resources resources = super.getResources();
    Configuration configuration = new Configuration();
    configuration.setToDefaults();
    resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    return resources;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (this.a != null)
      this.a.y(); 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle) {
    k.a("uppay", "PayActivityEx.onCreate() +++");
    c.a();
    com.unionpay.mobile.android.global.a.a((Context)this);
    this.b = new ArrayList<b>(1);
    this.d = new a(this, d());
    this.e = new m((Context)this);
    UPAgent.LOG_ON = false;
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    this.a = (l)a(1, (e)null);
    setContentView((View)this.a);
    getWindow().addFlags(8192);
    f++;
    k.a("uppay", "PayActivityEx.onCreate() ---");
    if (a()) {
      this.c = NfcAdapter.getDefaultAdapter((Context)this);
      this.g = PendingIntent.getActivity((Context)this, 0, (new Intent((Context)this, getClass())).addFlags(536870912), 0);
      onNewIntent(getIntent());
    } 
  }
  
  protected void onDestroy() {
    if (this.b != null)
      this.b.clear(); 
    if (this.a != null)
      this.a.B(); 
    this.a = null;
    b.bl = false;
    b.bb = null;
    b.bm = false;
    int i = f - 1;
    f = i;
    if (i == 0)
      c.a((Context)this).a(); 
    this.e.c();
    this.e = null;
    this.d.b = null;
    this.d.a = null;
    this.d = null;
    ((ViewGroup)getWindow().getDecorView().findViewById(16908290)).removeAllViews();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      if (this.b != null && this.b.size() > 0)
        ((b)this.b.get(this.b.size() - 1)).l(); 
      return true;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause() {
    super.onPause();
    if (a() && this.c != null)
      this.c.disableForegroundDispatch(this); 
  }
  
  protected void onResume() {
    super.onResume();
    if (this.e.a())
      this.e.b(); 
    if (a() && this.c != null)
      this.c.enableForegroundDispatch(this, this.g, FILTERS, TECHLISTS); 
  }
  
  private final class a {
    public b a = null;
    
    public UPPayEngine b = null;
    
    public a(BaseActivity this$0, UPPayEngine param1UPPayEngine) {
      this.a = new b();
      this.b = param1UPPayEngine;
      this.b.a(this.a);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\plugin\BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */