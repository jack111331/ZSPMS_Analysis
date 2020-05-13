package com.zz.sdk.floatdlg;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.zz.sdk.floatdlg.b.ab;
import com.zz.sdk.floatdlg.b.am;
import com.zz.sdk.floatdlg.b.ax;
import com.zz.sdk.floatdlg.b.bu;
import com.zz.sdk.floatdlg.b.cg;
import com.zz.sdk.floatdlg.tabview.TabView;
import com.zz.sdk.floatdlg.tabview.c;
import com.zz.sdk.floatdlg.tabview.d;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class FloatDialog extends FragmentActivity {
  private static final int j = 10001;
  
  private c a;
  
  private int b;
  
  private boolean c = false;
  
  private boolean d = false;
  
  private boolean e = false;
  
  private boolean f = false;
  
  private View g;
  
  private List h = new ArrayList();
  
  private TabView i;
  
  private int a(int paramInt) {
    return (int)((getResources().getDisplayMetrics()).density * paramInt);
  }
  
  private void b() {
    try {
      String str = cm.c((Context)this, "key_sys_config", "");
      JSONObject jSONObject2 = new JSONObject();
      this(str);
      JSONObject jSONObject1 = jSONObject2.getJSONObject("buoyConf");
      this.c = jSONObject1.getString("giftPkgEnable").equals("1");
      this.d = jSONObject1.getString("shareRewardEnable").equals("1");
      this.e = jSONObject1.getString("clubEnable").equals("1");
      this.f = jSONObject1.getString("wikiEnable").equals("1");
    } catch (Exception exception) {}
  }
  
  private void c() {
    this.i = (TabView)findViewById(ci.a((Context)this, 2131296529));
    c c1 = new c(ci.a((Context)this, 2130837570), ci.a((Context)this, 2130837569), "我的", (Fragment)new ax());
    c c2 = new c(ci.a((Context)this, 2130837564), ci.a((Context)this, 2130837561), "礼包", (Fragment)am.a());
    c c3 = new c(ci.a((Context)this, 2130837584), ci.a((Context)this, 2130837583), "分享有奖", (Fragment)new bu());
    c c4 = new c(ci.a((Context)this, 2130837558), ci.a((Context)this, 2130837557), "客服", (Fragment)new ab());
    c c5 = new c(ci.a((Context)this, 2130837594), ci.a((Context)this, 2130837593), "wiki", (Fragment)new cg());
    this.h.add(c1);
    if (this.c)
      this.h.add(c2); 
    if (this.d)
      this.h.add(c3); 
    if (this.e)
      this.h.add(c4); 
    if (this.f)
      this.h.add(c5); 
    this.i.setTabViewDefaultPosition(this.b);
    this.i.setImageViewWidth(d.a((Context)this, 25.0F));
    this.i.setImageViewHeight(d.a((Context)this, 25.0F));
    this.i.setImageViewTextViewMargin(d.a((Context)this, 2.0F));
    this.i.setTextViewSelectedColor(-173706);
    this.i.setTextViewUnSelectedColor(-7367270);
    this.i.setTextViewSize(12);
    this.i.setTabViewHeight(d.a((Context)this, 55.0F));
    this.i.a(this.h, getSupportFragmentManager());
    this.i.setOnTabChildClickListener(new a(this));
    View view = findViewById(ci.a((Context)this, 2131296530));
    if (cv.u((Context)this)) {
      RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(d.a((Context)this, 2.0F), -1);
      layoutParams1.setMargins(d.a((Context)this, 55.0F), 0, 0, 0);
      layoutParams1.addRule(9);
      view.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    } else {
      RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, d.a((Context)this, 2.0F));
      layoutParams1.setMargins(0, 0, 0, d.a((Context)this, 55.0F));
      layoutParams1.addRule(12);
      view.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    } 
    this.g = findViewById(ci.a((Context)this, 2131296531));
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(22, 22);
    if (cv.u((Context)this)) {
      layoutParams.setMargins(120, cv.b((Context)this) / this.h.size() + cv.b((Context)this) / this.h.size() / 2 - a(26), 0, 0);
    } else {
      layoutParams.setMargins(cv.c((Context)this) / this.h.size() + cv.c((Context)this) / this.h.size() / 2 + a(13), cv.b((Context)this) - 150, 0, 0);
    } 
    this.g.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    a();
  }
  
  public void a() {
    runOnUiThread(new b(this));
  }
  
  public void a(c paramc) {
    this.a = paramc;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10001 && paramInt2 == -1) {
      finish();
      overridePendingTransition(0, 0);
    } 
  }
  
  public void onBackPressed() {
    finish();
    overridePendingTransition(0, 0);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    try {
      requestWindowFeature(1);
      getWindow().setFlags(1024, 1024);
      this.b = getIntent().getExtras().getInt("position");
      setContentView(ci.a((Context)this, 2130903109));
      b();
      c();
      t.a((Context)this).b("Buoy", "Click_Main", 1);
    } catch (Exception exception) {}
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfint) {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfint);
    if (paramInt == 123)
      for (paramInt = 0; paramInt < paramArrayOfString.length; paramInt++) {
        String str = paramArrayOfString[paramInt];
        bp.a("FloatDialog onRequestPermissionsResult:" + str);
        if (paramArrayOfint[0] == 0) {
          if ("android.permission.READ_CONTACTS".equals(str))
            this.a.a(); 
        } else if ("android.permission.READ_CONTACTS".equals(str)) {
          this.a.b();
        } 
      }  
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\FloatDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */