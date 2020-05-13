package com.chuanglan.shanyan_sdk.view;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.TraceLogger;
import com.chuanglan.shanyan_sdk.OneKeyLoginManager;
import com.chuanglan.shanyan_sdk.b;
import com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig;
import com.chuanglan.shanyan_sdk.tool.b;
import com.chuanglan.shanyan_sdk.tool.e;
import com.chuanglan.shanyan_sdk.tool.h;
import com.chuanglan.shanyan_sdk.tool.j;
import com.chuanglan.shanyan_sdk.tool.k;
import com.chuanglan.shanyan_sdk.tool.l;
import com.chuanglan.shanyan_sdk.tool.m;
import com.chuanglan.shanyan_sdk.utils.AbScreenUtils;
import com.chuanglan.shanyan_sdk.utils.AppStringUtils;
import com.chuanglan.shanyan_sdk.utils.AppSysMgr;
import com.chuanglan.shanyan_sdk.utils.L;
import com.chuanglan.shanyan_sdk.utils.LCMResource;
import com.chuanglan.shanyan_sdk.utils.SPTool;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ShanYanOneKeyActivity extends Activity {
  public static WeakReference<ShanYanOneKeyActivity> a;
  
  private TextView b;
  
  private Button c;
  
  private ImageView d;
  
  private String e;
  
  private Context f;
  
  private ShanYanUIConfig g;
  
  private RelativeLayout h;
  
  private TextView i;
  
  private ImageView j;
  
  private RelativeLayout k;
  
  private TextView l;
  
  private TextView m;
  
  private ArrayList<a> n = null;
  
  private RelativeLayout o;
  
  private RelativeLayout p;
  
  private String q;
  
  private String r;
  
  private boolean s;
  
  private CheckBox t;
  
  private View u;
  
  private boolean v = true;
  
  private View w;
  
  private RelativeLayout x;
  
  private void a() {
    String str = getIntent().getStringExtra("number");
    this.e = getIntent().getStringExtra("accessCode");
    this.q = getIntent().getStringExtra("operatorAppId");
    this.r = getIntent().getStringExtra("operatorAppKey");
    this.s = getIntent().getBooleanExtra("isFinish", true);
    this.b = (TextView)findViewById(LCMResource.getInstance((Context)this).getId("tv_per_code"));
    this.c = (Button)findViewById(LCMResource.getInstance((Context)this).getId("bt_one_key_login"));
    this.d = (ImageView)findViewById(LCMResource.getInstance((Context)this).getId("shanyan_navigationbar_back"));
    this.h = (RelativeLayout)findViewById(LCMResource.getInstance((Context)this).getId("shanyan_navigationbar_include"));
    this.i = (TextView)findViewById(LCMResource.getInstance((Context)this).getId("shanyan_navigationbar_title"));
    this.j = (ImageView)findViewById(LCMResource.getInstance((Context)this).getId("sysdk_log_image"));
    this.k = (RelativeLayout)findViewById(LCMResource.getInstance((Context)this).getId("shanyan_navigationbar_back_root"));
    this.l = (TextView)findViewById(LCMResource.getInstance((Context)this).getId("sysdk_identify_tv"));
    this.m = (TextView)findViewById(LCMResource.getInstance((Context)this).getId("shanyan_privacy_text"));
    this.t = (CheckBox)findViewById(LCMResource.getInstance((Context)this).getId("shanyan_privacy_checkbox"));
    this.x = (RelativeLayout)findViewById(LCMResource.getInstance((Context)this).getId("shanyan_privacy_checkbox_rootlayout"));
    this.u = findViewById(LCMResource.getInstance((Context)this).getId("shanyan_privacy_include"));
    this.p = (RelativeLayout)findViewById(LCMResource.getInstance((Context)this).getId("sysdk_ctcc_login_layout"));
    this.b.setText(str);
    this.c.setEnabled(true);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            b.O = SystemClock.uptimeMillis();
            b.N = System.currentTimeMillis();
            if (ShanYanOneKeyActivity.a(this.a).isChecked()) {
              ShanYanOneKeyActivity.b(this.a).setOnClickListener(null);
              ShanYanOneKeyActivity.b(this.a).setVisibility(0);
            } else {
              ShanYanOneKeyActivity.b(this.a).setVisibility(8);
            } 
            if (ShanYanOneKeyActivity.c(this.a)) {
              ShanYanOneKeyActivity.d(this.a).setEnabled(false);
              String str2 = (String)SPTool.get(ShanYanOneKeyActivity.e(this.a), "SIMSerial", "");
              String str1 = (String)SPTool.get(ShanYanOneKeyActivity.e(this.a), "SIMOperator", "");
              if (AppStringUtils.isNotEmpty(AppSysMgr.getSIMSerial(ShanYanOneKeyActivity.e(this.a))) && AppSysMgr.getSIMSerial(ShanYanOneKeyActivity.e(this.a)).equals(str2) && AppStringUtils.isNotEmpty(AppSysMgr.getOperatorType(ShanYanOneKeyActivity.e(this.a))) && AppSysMgr.getOperatorType(ShanYanOneKeyActivity.e(this.a)).equals(str1) && System.currentTimeMillis() < ((Long)SPTool.get(ShanYanOneKeyActivity.e(this.a), "timeend", Long.valueOf(1L))).longValue()) {
                if (b.h) {
                  CtAuth.getInstance().init(ShanYanOneKeyActivity.e(this.a), ShanYanOneKeyActivity.f(this.a), ShanYanOneKeyActivity.g(this.a), new TraceLogger(this) {
                        public void debug(String param2String1, String param2String2) {
                          L.d("TraceLogger", "debug===S==" + param2String1 + "S1==" + param2String2);
                        }
                        
                        public void info(String param2String1, String param2String2) {
                          L.d("TraceLogger", "info===S==" + param2String1 + "S1==" + param2String2);
                        }
                        
                        public void warn(String param2String1, String param2String2, Throwable param2Throwable) {
                          L.d("TraceLogger", "warn===S==" + param2String1 + "S1==" + param2String2 + "Throwable==" + param2Throwable);
                        }
                      });
                } else {
                  CtAuth.getInstance().init(ShanYanOneKeyActivity.e(this.a), ShanYanOneKeyActivity.f(this.a), ShanYanOneKeyActivity.g(this.a), null);
                } 
                j.a().a(ShanYanOneKeyActivity.h(this.a), ShanYanOneKeyActivity.i(this.a));
              } else {
                k.a().a(4);
              } 
              SPTool.put(ShanYanOneKeyActivity.e(this.a), "ctcc_number", "");
              SPTool.put(ShanYanOneKeyActivity.e(this.a), "ctcc_accessCode", "");
              SPTool.put(ShanYanOneKeyActivity.e(this.a), "timeend", Long.valueOf(0L));
              return;
            } 
            AbScreenUtils.showToast(ShanYanOneKeyActivity.e(this.a), "请勾选协议!");
          }
        });
    this.k.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.finish();
            h.a().a(1011, "点击返回，用户取消免密登录", 3, "", "", 0L);
          }
        });
    this.x.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            ShanYanOneKeyActivity.a(this.a).performClick();
          }
        });
    this.t.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            if (param1Boolean) {
              ShanYanOneKeyActivity.a(this.a, true);
              if (ShanYanOneKeyActivity.j(this.a).getCheckedImgPath() != null) {
                ShanYanOneKeyActivity.a(this.a).setBackground(ShanYanOneKeyActivity.j(this.a).getCheckedImgPath());
                return;
              } 
              ShanYanOneKeyActivity.a(this.a).setBackgroundResource(ShanYanOneKeyActivity.e(this.a).getResources().getIdentifier("umcsdk_check_image", "drawable", ShanYanOneKeyActivity.e(this.a).getPackageName()));
              return;
            } 
            ShanYanOneKeyActivity.a(this.a, false);
            if (ShanYanOneKeyActivity.j(this.a).getUncheckedImgPath() != null) {
              ShanYanOneKeyActivity.a(this.a).setBackground(ShanYanOneKeyActivity.j(this.a).getUncheckedImgPath());
              return;
            } 
            ShanYanOneKeyActivity.a(this.a).setBackgroundResource(ShanYanOneKeyActivity.e(this.a).getResources().getIdentifier("umcsdk_uncheck_image", "drawable", ShanYanOneKeyActivity.e(this.a).getPackageName()));
          }
        });
  }
  
  private void b() {
    if (this.g.getAuthBGImgPath() != null) {
      this.p.setBackground(this.g.getAuthBGImgPath());
    } else {
      this.p.setBackgroundResource(this.f.getResources().getIdentifier("authbackground_image", "drawable", this.f.getPackageName()));
    } 
    this.h.setBackgroundColor(this.g.getNavColor());
    if (this.g.isAuthNavTransparent())
      this.h.getBackground().setAlpha(0); 
    if (this.g.isAuthNavHidden()) {
      this.h.setVisibility(8);
    } else {
      this.h.setVisibility(0);
    } 
    this.i.setText(this.g.getNavText());
    this.i.setTextColor(this.g.getNavTextColor());
    this.i.setTextSize(this.g.getNavTextSize());
    if (this.g.getNavReturnImgPath() != null)
      this.d.setImageDrawable(this.g.getNavReturnImgPath()); 
    if (this.g.getLogoImgPath() != null)
      this.j.setImageDrawable(this.g.getLogoImgPath()); 
    m.b(this.f, (View)this.j, this.g.getLogoOffsetX(), this.g.getLogoOffsetY(), this.g.getLogoOffsetBottomY(), this.g.getLogoWidth(), this.g.getLogoHeight());
    if (this.g.isLogoHidden()) {
      this.j.setVisibility(8);
    } else {
      this.j.setVisibility(0);
    } 
    if (this.g.isNavReturnImgHidden()) {
      this.k.setVisibility(8);
    } else {
      this.k.setVisibility(0);
      m.a(this.f, (View)this.k, this.g.getNavReturnBtnOffsetX(), this.g.getNavReturnBtnOffsetY(), this.g.getNavReturnBtnOffsetRightX(), this.g.getReturnBtnWidth(), this.g.getReturnBtnHeight(), this.d);
    } 
    this.b.setTextColor(this.g.getNumberColor());
    this.b.setTextSize(this.g.getNumberSize());
    m.b(this.f, (View)this.b, this.g.getNumFieldOffsetX(), this.g.getNumFieldOffsetY(), this.g.getNumFieldOffsetBottomY(), this.g.getNumFieldWidth(), this.g.getNumFieldHeight());
    this.c.setText(this.g.getLogBtnText());
    this.c.setTextColor(this.g.getLogBtnTextColor());
    this.c.setTextSize(this.g.getLogBtnTextSize());
    if (this.g.getLogBtnBackgroundPath() != null)
      this.c.setBackground(this.g.getLogBtnBackgroundPath()); 
    this.v = this.g.isPrivacyState();
    if (this.g.isCheckBoxHidden()) {
      this.x.setVisibility(8);
    } else {
      this.x.setVisibility(0);
    } 
    if (this.v) {
      this.t.setChecked(true);
      if (this.g.getCheckedImgPath() != null) {
        this.t.setBackground(this.g.getCheckedImgPath());
      } else {
        this.t.setBackgroundResource(this.f.getResources().getIdentifier("umcsdk_check_image", "drawable", this.f.getPackageName()));
      } 
    } else {
      this.t.setChecked(false);
      if (this.g.getUncheckedImgPath() != null) {
        this.t.setBackground(this.g.getUncheckedImgPath());
      } else {
        this.t.setBackgroundResource(this.f.getResources().getIdentifier("umcsdk_uncheck_image", "drawable", this.f.getPackageName()));
      } 
    } 
    m.a(this.f, (View)this.c, this.g.getLogBtnOffsetX(), this.g.getLogBtnOffsetY(), this.g.getLogBtnOffsetBottomY(), this.g.getLogBtnWidth(), this.g.getLogBtnHeight());
    this.l.setTextColor(this.g.getSloganTextColor());
    this.l.setTextSize(this.g.getSloganTextSize());
    m.a(this.f, (View)this.l, this.g.getSloganOffsetX(), this.g.getSloganOffsetY(), this.g.getSloganOffsetBottomY());
    if (this.g.isSloganHidden()) {
      this.l.setVisibility(8);
    } else {
      this.l.setVisibility(0);
    } 
    if (this.n == null)
      this.n = new ArrayList<a>(); 
    if (this.g.getCustomViews() != null) {
      this.n.clear();
      this.n.addAll(this.g.getCustomViews());
      for (byte b = 0; b < this.n.size(); b++) {
        if (((a)this.n.get(b)).b) {
          this.h.addView(((a)this.n.get(b)).c);
        } else {
          this.o.addView(((a)this.n.get(b)).c);
        } 
        ((a)this.n.get(b)).c.setOnClickListener(new View.OnClickListener(this, b) {
              public void onClick(View param1View) {
                if (((a)ShanYanOneKeyActivity.k(this.b).get(this.a)).a)
                  this.b.finish(); 
                if (((a)ShanYanOneKeyActivity.k(this.b).get(this.a)).d != null)
                  ((a)ShanYanOneKeyActivity.k(this.b).get(this.a)).d.onClick(ShanYanOneKeyActivity.e(this.b), param1View); 
              }
            });
      } 
    } 
    if (this.g.getLoadingView() != null) {
      this.w = this.g.getLoadingView();
      this.w.bringToFront();
      this.o.addView(this.w);
      this.w.setVisibility(8);
      return;
    } 
    this.w = findViewById(LCMResource.getInstance((Context)this).getId("shanyan_onkeylogin_loading"));
  }
  
  private void c() {
    Window window = getWindow();
    if (Build.VERSION.SDK_INT >= 21) {
      window.clearFlags(67108864);
      window.getDecorView().setSystemUiVisibility(1024);
      if (Build.VERSION.SDK_INT >= 23)
        window.getDecorView().setSystemUiVisibility(9216); 
      window.addFlags(-2147483648);
      window.setStatusBarColor(0);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 19)
      getWindow().addFlags(67108864); 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.f = getApplicationContext();
    b.r = false;
    c();
    OneKeyLoginManager.getInstance().ShanyanAuthListenerGetPhoneCode(1000, "授权页拉起成功");
    L.d("ProcessLogger", "授权页拉起成功===code=1000");
    long l1 = SystemClock.uptimeMillis();
    long l2 = b.J;
    b.L = System.currentTimeMillis();
    b.M = SystemClock.uptimeMillis();
    b.P = System.currentTimeMillis();
    e.a().a(1000, 3, "3", "1", "授权页拉起成功", b.P + "", 0L, l1 - l2, "1000", "授权页拉起成功", false, false);
    a = new WeakReference<ShanYanOneKeyActivity>(this);
    this.g = l.a(this.f).a();
    try {
      if (this.g.isDialogTheme())
        m.a(this, this.g.getDialogWidth(), this.g.getDialogHeight(), this.g.getDialogX(), this.g.getDialogY(), this.g.isDialogBottom()); 
      setContentView(LCMResource.getInstance((Context)this).getLayoutForView("sysdk_activity_onekey_login"));
      this.o = (RelativeLayout)findViewById(LCMResource.getInstance((Context)this).getId("sysdk_login_boby"));
      a();
      b();
      this.m.setTextSize(this.g.getPrivacyTextSize());
      b.a(this.f, this.m, "天翼服务及隐私协议", this.g.getClauseName(), this.g.getClauseNameTwo(), "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", this.g.getClauseUrl(), this.g.getClauseUrlTwo(), this.g.getClauseColor(), this.g.getClauseBaseColor(), this.u, this.g.getPrivacyOffsetY(), this.g.getPrivacyOffsetBottomY(), this.g.getPrivacyOffsetX(), "CTCC");
    } catch (Exception exception) {
      exception.printStackTrace();
      h.a().a(1014, "ShanYanOneKeyActivity.onCreate()" + exception.toString(), 3, "", exception.toString(), SystemClock.uptimeMillis() - b.M);
      finish();
    } 
  }
  
  protected void onDestroy() {
    super.onDestroy();
    try {
      if (this.n != null) {
        this.n.clear();
        this.n = null;
      } 
      if (this.h != null)
        this.h.removeAllViews(); 
      if (this.o != null)
        this.o.removeAllViews(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 && paramKeyEvent.getRepeatCount() == 0) {
      finish();
      h.a().a(1011, "点击返回，用户取消免密登录", 4, "", "", SystemClock.uptimeMillis() - b.M);
      return true;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume() {
    super.onResume();
    b.q = true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\view\ShanYanOneKeyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */