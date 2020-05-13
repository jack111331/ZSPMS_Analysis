package com.chuanglan.shanyan_sdk.tool;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.chuanglan.shanyan_sdk.listener.ShanYanCustomInterface;
import com.chuanglan.shanyan_sdk.utils.AppStringUtils;
import com.chuanglan.shanyan_sdk.view.a;
import com.cmic.sso.sdk.AuthThemeConfig;
import java.util.ArrayList;

public class ShanYanUIConfig {
  private int A;
  
  private int B;
  
  private int C;
  
  private int D;
  
  private int E;
  
  private int F;
  
  private int G;
  
  private boolean H;
  
  private int I;
  
  private String J;
  
  private int K;
  
  private int L;
  
  private int M;
  
  private int N;
  
  private Drawable O;
  
  private int P;
  
  private int Q;
  
  private Drawable R;
  
  private Drawable S;
  
  private boolean T;
  
  private boolean U;
  
  private int V;
  
  private int W;
  
  private int X;
  
  private boolean Y;
  
  private String Z;
  
  private Drawable a;
  
  private String aa;
  
  private String ab;
  
  private String ac;
  
  private int ad;
  
  private String ae;
  
  private String af;
  
  private String ag;
  
  private String ah;
  
  private int ai;
  
  private int aj;
  
  private boolean ak;
  
  private boolean al;
  
  private int am;
  
  private int an;
  
  private int ao;
  
  private int ap;
  
  private View aq;
  
  private boolean ar;
  
  private AuthThemeConfig.Builder as;
  
  private ArrayList<a> at;
  
  private int b;
  
  private String c;
  
  private int d;
  
  private int e;
  
  private boolean f;
  
  private boolean g;
  
  private int h;
  
  private Drawable i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private boolean n;
  
  private int o;
  
  private int p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private boolean t;
  
  private Drawable u;
  
  private int v;
  
  private int w;
  
  private int x;
  
  private int y;
  
  private int z;
  
  private ShanYanUIConfig(Builder paramBuilder) {
    this.a = paramBuilder.a;
    this.b = paramBuilder.b;
    this.c = paramBuilder.c;
    this.d = paramBuilder.d;
    this.e = paramBuilder.e;
    this.f = paramBuilder.f;
    this.g = paramBuilder.g;
    this.h = paramBuilder.h;
    this.i = paramBuilder.i;
    this.j = paramBuilder.j;
    this.k = paramBuilder.k;
    this.l = paramBuilder.l;
    this.m = paramBuilder.m;
    this.n = paramBuilder.n;
    this.o = paramBuilder.o;
    this.p = paramBuilder.p;
    this.q = paramBuilder.q;
    this.r = paramBuilder.r;
    this.s = paramBuilder.s;
    this.t = paramBuilder.t;
    this.u = paramBuilder.u;
    this.v = paramBuilder.v;
    this.w = paramBuilder.w;
    this.x = paramBuilder.x;
    this.y = paramBuilder.y;
    this.z = paramBuilder.z;
    this.A = paramBuilder.A;
    this.B = paramBuilder.B;
    this.C = paramBuilder.C;
    this.D = paramBuilder.D;
    this.E = paramBuilder.E;
    this.F = paramBuilder.F;
    this.G = paramBuilder.G;
    this.H = paramBuilder.H;
    this.I = paramBuilder.I;
    this.J = paramBuilder.J;
    this.K = paramBuilder.K;
    this.L = paramBuilder.L;
    this.M = paramBuilder.M;
    this.N = paramBuilder.N;
    this.O = paramBuilder.O;
    this.P = paramBuilder.P;
    this.Q = paramBuilder.Q;
    this.R = paramBuilder.R;
    this.S = paramBuilder.S;
    this.T = paramBuilder.T;
    this.U = paramBuilder.U;
    this.V = paramBuilder.V;
    this.W = paramBuilder.W;
    this.X = paramBuilder.X;
    this.Y = paramBuilder.Y;
    this.Z = paramBuilder.Z;
    this.aa = paramBuilder.aa;
    this.ab = paramBuilder.ab;
    this.ac = paramBuilder.ac;
    this.ad = paramBuilder.ad;
    this.ae = paramBuilder.ae;
    this.af = paramBuilder.af;
    this.ag = paramBuilder.ag;
    this.ah = paramBuilder.ah;
    this.ai = paramBuilder.ai;
    this.aj = paramBuilder.aj;
    this.ak = paramBuilder.ak;
    this.al = paramBuilder.al;
    this.am = paramBuilder.am;
    this.an = paramBuilder.an;
    this.ao = paramBuilder.ao;
    this.ap = paramBuilder.ap;
    this.aq = paramBuilder.aq;
    this.ar = paramBuilder.ar;
    this.as = (new AuthThemeConfig.Builder()).setNavColor(this.b).setNavText(paramBuilder.c).setNavTextColor(paramBuilder.d).setAuthNavTransparent(paramBuilder.f).setLogoImgPath("umcsdk_return_bg").setLogoWidthDip(paramBuilder.r).setLogoHeightDip(paramBuilder.s).setLogoOffsetY(paramBuilder.o).setLogoHidden(paramBuilder.t).setNumberColor(paramBuilder.x).setNumberSize(paramBuilder.B).setSwitchAccHidden(true).setNumFieldOffsetY(paramBuilder.y).setNumFieldOffsetY_B(paramBuilder.z).setLogBtnText(paramBuilder.J).setLogBtnOffsetY(paramBuilder.K).setLogBtnOffsetY_B(paramBuilder.W).setLogBtnTextColor(paramBuilder.N).setPrivacyOffsetY(paramBuilder.V).setPrivacyOffsetY_B(paramBuilder.W).setPrivacyState(paramBuilder.T).setClauseColor(paramBuilder.ai, this.aj).setClauseOne(paramBuilder.ae, this.af).setClauseTwo(paramBuilder.ag, this.ah).setSloganOffsetY(paramBuilder.C).setSloganOffsetY_B(paramBuilder.D).setSloganTextColor(paramBuilder.F);
    this.at = paramBuilder.as;
  }
  
  public Drawable getAuthBGImgPath() {
    return this.a;
  }
  
  public Drawable getCheckedImgPath() {
    return this.S;
  }
  
  public int getClauseBaseColor() {
    return this.ai;
  }
  
  public int getClauseColor() {
    return this.aj;
  }
  
  public String getClauseName() {
    return this.ae;
  }
  
  public String getClauseNameTwo() {
    return this.ag;
  }
  
  public String getClauseUrl() {
    return this.af;
  }
  
  public String getClauseUrlTwo() {
    return this.ah;
  }
  
  public AuthThemeConfig.Builder getCmUIConfigBuilder() {
    return this.as;
  }
  
  public ArrayList<a> getCustomViews() {
    return this.at;
  }
  
  public int getDialogHeight() {
    return this.an;
  }
  
  public int getDialogWidth() {
    return this.am;
  }
  
  public int getDialogX() {
    return this.ao;
  }
  
  public int getDialogY() {
    return this.ap;
  }
  
  public View getLoadingView() {
    return this.aq;
  }
  
  public Drawable getLogBtnBackgroundPath() {
    return this.O;
  }
  
  public int getLogBtnHeight() {
    return this.Q;
  }
  
  public int getLogBtnOffsetBottomY() {
    return this.L;
  }
  
  public int getLogBtnOffsetX() {
    return this.M;
  }
  
  public int getLogBtnOffsetY() {
    return this.K;
  }
  
  public String getLogBtnText() {
    return this.J;
  }
  
  public int getLogBtnTextColor() {
    return this.N;
  }
  
  public int getLogBtnTextSize() {
    return this.I;
  }
  
  public int getLogBtnWidth() {
    return this.P;
  }
  
  public int getLogoHeight() {
    return this.s;
  }
  
  public Drawable getLogoImgPath() {
    return this.u;
  }
  
  public int getLogoOffsetBottomY() {
    return this.p;
  }
  
  public int getLogoOffsetX() {
    return this.q;
  }
  
  public int getLogoOffsetY() {
    return this.o;
  }
  
  public int getLogoWidth() {
    return this.r;
  }
  
  public int getNavColor() {
    return this.b;
  }
  
  public int getNavReturnBtnOffsetRightX() {
    return this.l;
  }
  
  public int getNavReturnBtnOffsetX() {
    return this.j;
  }
  
  public int getNavReturnBtnOffsetY() {
    return this.k;
  }
  
  public Drawable getNavReturnImgPath() {
    return this.i;
  }
  
  public String getNavText() {
    return this.c;
  }
  
  public int getNavTextColor() {
    return this.d;
  }
  
  public int getNavTextSize() {
    return this.e;
  }
  
  public int getNumFieldHeight() {
    return this.v;
  }
  
  public int getNumFieldOffsetBottomY() {
    return this.z;
  }
  
  public int getNumFieldOffsetX() {
    return this.A;
  }
  
  public int getNumFieldOffsetY() {
    return this.y;
  }
  
  public int getNumFieldWidth() {
    return this.w;
  }
  
  public int getNumberColor() {
    return this.x;
  }
  
  public int getNumberSize() {
    return this.B;
  }
  
  public int getPrivacyOffsetBottomY() {
    return this.W;
  }
  
  public int getPrivacyOffsetX() {
    return this.X;
  }
  
  public int getPrivacyOffsetY() {
    return this.V;
  }
  
  public String getPrivacyTextEnd() {
    return this.ac;
  }
  
  public String getPrivacyTextHead() {
    return this.Z;
  }
  
  public String getPrivacyTextMidOne() {
    return this.aa;
  }
  
  public String getPrivacyTextMidTwo() {
    return this.ab;
  }
  
  public int getPrivacyTextSize() {
    return this.ad;
  }
  
  public int getReturnBtnHeight() {
    return this.m;
  }
  
  public int getReturnBtnWidth() {
    return this.h;
  }
  
  public int getSloganOffsetBottomY() {
    return this.D;
  }
  
  public int getSloganOffsetX() {
    return this.E;
  }
  
  public int getSloganOffsetY() {
    return this.C;
  }
  
  public int getSloganTextColor() {
    return this.F;
  }
  
  public int getSloganTextSize() {
    return this.G;
  }
  
  public Drawable getUncheckedImgPath() {
    return this.R;
  }
  
  public boolean isAuthNavHidden() {
    return this.g;
  }
  
  public boolean isAuthNavTransparent() {
    return this.f;
  }
  
  public boolean isCheckBoxHidden() {
    return this.U;
  }
  
  public boolean isDialogBottom() {
    return this.al;
  }
  
  public boolean isDialogTheme() {
    return this.ak;
  }
  
  public boolean isLogoHidden() {
    return this.t;
  }
  
  public boolean isNavReturnImgHidden() {
    return this.n;
  }
  
  public boolean isPrivacyOffsetGravityLeft() {
    return this.Y;
  }
  
  public boolean isPrivacyState() {
    return this.T;
  }
  
  public boolean isScreenLandscape() {
    return this.ar;
  }
  
  public boolean isSloganHidden() {
    return this.H;
  }
  
  public static class Builder {
    private int A = -1;
    
    private int B = 18;
    
    private int C = 195;
    
    private int D = -1;
    
    private int E = -1;
    
    private int F = -6710887;
    
    private int G = 10;
    
    private boolean H = false;
    
    private int I = 15;
    
    private String J = "本机号码一键登录";
    
    private int K = 220;
    
    private int L = -1;
    
    private int M = -1;
    
    private int N = -1;
    
    private Drawable O = null;
    
    private int P = -1;
    
    private int Q = 46;
    
    private Drawable R = null;
    
    private Drawable S = null;
    
    private boolean T = true;
    
    private boolean U = false;
    
    private int V = -1;
    
    private int W = 30;
    
    private int X = -1;
    
    private boolean Y = false;
    
    private String Z = null;
    
    private Drawable a = null;
    
    private String aa = null;
    
    private String ab = null;
    
    private String ac = null;
    
    private int ad = 10;
    
    private String ae = null;
    
    private String af = null;
    
    private String ag = null;
    
    private String ah = null;
    
    private int ai = -10066330;
    
    private int aj = -16742960;
    
    private boolean ak = false;
    
    private boolean al = false;
    
    private int am = 300;
    
    private int an = 500;
    
    private int ao = 0;
    
    private int ap = 0;
    
    private View aq = null;
    
    private boolean ar = false;
    
    private ArrayList<a> as = null;
    
    private int b = -1;
    
    private String c = "免密登录";
    
    private int d = -16250872;
    
    private int e = 16;
    
    private boolean f = true;
    
    private boolean g = false;
    
    private int h = 25;
    
    private Drawable i = null;
    
    private int j = 0;
    
    private int k = -1;
    
    private int l = -1;
    
    private int m = 25;
    
    private boolean n = false;
    
    private int o = 50;
    
    private int p = -1;
    
    private int q = -1;
    
    private int r = 75;
    
    private int s = 75;
    
    private boolean t = false;
    
    private Drawable u = null;
    
    private int v = -1;
    
    private int w = -1;
    
    private int x = -13421773;
    
    private int y = 140;
    
    private int z = -1;
    
    private Builder setNumFieldHeight(int param1Int) {
      this.v = param1Int;
      return this;
    }
    
    public Builder addCustomView(View param1View, boolean param1Boolean1, boolean param1Boolean2, ShanYanCustomInterface param1ShanYanCustomInterface) {
      if (param1View != null) {
        if (this.as == null)
          this.as = new ArrayList<a>(); 
        a a = new a();
        a.a = param1Boolean1;
        a.b = param1Boolean2;
        a.c = param1View;
        a.d = param1ShanYanCustomInterface;
        this.as.add(a);
      } 
      return this;
    }
    
    public ShanYanUIConfig build() {
      return new ShanYanUIConfig(this);
    }
    
    public Builder setAppPrivacyColor(int param1Int1, int param1Int2) {
      this.ai = param1Int1;
      this.aj = param1Int2;
      return this;
    }
    
    public Builder setAppPrivacyOne(String param1String1, String param1String2) {
      if (AppStringUtils.isNotEmpty(param1String1) && AppStringUtils.isNotEmpty(param1String2)) {
        this.ae = param1String1;
        this.af = param1String2;
        return this;
      } 
      this.af = "";
      this.ae = "";
      return this;
    }
    
    public Builder setAppPrivacyTwo(String param1String1, String param1String2) {
      if (AppStringUtils.isNotEmpty(param1String1) && AppStringUtils.isNotEmpty(param1String2)) {
        this.ag = param1String1;
        this.ah = param1String2;
        return this;
      } 
      this.ah = "";
      this.ag = "";
      return this;
    }
    
    public Builder setAuthBGImgPath(Drawable param1Drawable) {
      this.a = param1Drawable;
      return this;
    }
    
    public Builder setAuthNavHidden(boolean param1Boolean) {
      this.g = param1Boolean;
      return this;
    }
    
    public Builder setAuthNavTransparent(boolean param1Boolean) {
      this.f = param1Boolean;
      return this;
    }
    
    public Builder setCheckBoxHidden(boolean param1Boolean) {
      this.U = param1Boolean;
      return this;
    }
    
    public Builder setCheckedImgPath(Drawable param1Drawable) {
      this.S = param1Drawable;
      return this;
    }
    
    public Builder setDialogTheme(boolean param1Boolean1, int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean2) {
      this.ak = param1Boolean1;
      this.am = param1Int1;
      this.an = param1Int2;
      this.ao = param1Int3;
      this.ap = param1Int4;
      this.al = param1Boolean2;
      return this;
    }
    
    public Builder setLoadingView(View param1View) {
      this.aq = param1View;
      return this;
    }
    
    public Builder setLogBtnHeight(int param1Int) {
      this.Q = param1Int;
      return this;
    }
    
    public Builder setLogBtnImgPath(Drawable param1Drawable) {
      this.O = param1Drawable;
      return this;
    }
    
    public Builder setLogBtnOffsetBottomY(int param1Int) {
      this.L = param1Int;
      return this;
    }
    
    public Builder setLogBtnOffsetX(int param1Int) {
      this.M = param1Int;
      return this;
    }
    
    public Builder setLogBtnOffsetY(int param1Int) {
      this.K = param1Int;
      return this;
    }
    
    public Builder setLogBtnText(String param1String) {
      this.J = param1String;
      return this;
    }
    
    public Builder setLogBtnTextColor(int param1Int) {
      this.N = param1Int;
      return this;
    }
    
    public Builder setLogBtnTextSize(int param1Int) {
      this.I = param1Int;
      return this;
    }
    
    public Builder setLogBtnWidth(int param1Int) {
      this.P = param1Int;
      return this;
    }
    
    public Builder setLogoHeight(int param1Int) {
      this.s = param1Int;
      return this;
    }
    
    public Builder setLogoHidden(boolean param1Boolean) {
      this.t = param1Boolean;
      return this;
    }
    
    public Builder setLogoImgPath(Drawable param1Drawable) {
      this.u = param1Drawable;
      return this;
    }
    
    public Builder setLogoOffsetBottomY(int param1Int) {
      this.p = param1Int;
      return this;
    }
    
    public Builder setLogoOffsetX(int param1Int) {
      this.q = param1Int;
      return this;
    }
    
    public Builder setLogoOffsetY(int param1Int) {
      this.o = param1Int;
      return this;
    }
    
    public Builder setLogoWidth(int param1Int) {
      this.r = param1Int;
      return this;
    }
    
    public Builder setNavColor(int param1Int) {
      this.b = param1Int;
      return this;
    }
    
    public Builder setNavReturnBtnHeight(int param1Int) {
      this.m = param1Int;
      return this;
    }
    
    public Builder setNavReturnBtnOffsetRightX(int param1Int) {
      this.l = param1Int;
      return this;
    }
    
    public Builder setNavReturnBtnOffsetX(int param1Int) {
      this.j = param1Int;
      return this;
    }
    
    public Builder setNavReturnBtnOffsetY(int param1Int) {
      this.k = param1Int;
      return this;
    }
    
    public Builder setNavReturnBtnWidth(int param1Int) {
      this.h = param1Int;
      return this;
    }
    
    public Builder setNavReturnImgHidden(boolean param1Boolean) {
      this.n = param1Boolean;
      return this;
    }
    
    public Builder setNavReturnImgPath(Drawable param1Drawable) {
      this.i = param1Drawable;
      return this;
    }
    
    public Builder setNavText(String param1String) {
      this.c = param1String;
      return this;
    }
    
    public Builder setNavTextColor(int param1Int) {
      this.d = param1Int;
      return this;
    }
    
    public Builder setNavTextSize(int param1Int) {
      this.e = param1Int;
      return this;
    }
    
    public Builder setNumFieldOffsetBottomY(int param1Int) {
      this.z = param1Int;
      return this;
    }
    
    public Builder setNumFieldOffsetX(int param1Int) {
      this.A = param1Int;
      return this;
    }
    
    public Builder setNumFieldOffsetY(int param1Int) {
      this.y = param1Int;
      return this;
    }
    
    public Builder setNumFieldWidth(int param1Int) {
      this.w = param1Int;
      return this;
    }
    
    public Builder setNumberColor(int param1Int) {
      this.x = param1Int;
      return this;
    }
    
    public Builder setNumberSize(int param1Int) {
      this.B = param1Int;
      return this;
    }
    
    public Builder setPrivacyOffsetBottomY(int param1Int) {
      this.W = param1Int;
      return this;
    }
    
    public Builder setPrivacyOffsetGravityLeft(boolean param1Boolean) {
      this.Y = param1Boolean;
      return this;
    }
    
    public Builder setPrivacyOffsetX(int param1Int) {
      this.X = param1Int;
      return this;
    }
    
    public Builder setPrivacyOffsetY(int param1Int) {
      this.V = param1Int;
      return this;
    }
    
    public Builder setPrivacyState(boolean param1Boolean) {
      this.T = param1Boolean;
      return this;
    }
    
    public Builder setPrivacyText(String param1String1, String param1String2, String param1String3, String param1String4) {
      this.Z = param1String1;
      this.aa = param1String2;
      this.ab = param1String3;
      this.ac = param1String4;
      return this;
    }
    
    public Builder setPrivacyTextSize(int param1Int) {
      this.ad = param1Int;
      return this;
    }
    
    public Builder setScreenLandscape(boolean param1Boolean) {
      this.ar = param1Boolean;
      return this;
    }
    
    public Builder setSloganHidden(boolean param1Boolean) {
      this.H = param1Boolean;
      return this;
    }
    
    public Builder setSloganOffsetBottomY(int param1Int) {
      this.D = param1Int;
      return this;
    }
    
    public Builder setSloganOffsetX(int param1Int) {
      this.E = param1Int;
      return this;
    }
    
    public Builder setSloganOffsetY(int param1Int) {
      this.C = param1Int;
      return this;
    }
    
    public Builder setSloganTextColor(int param1Int) {
      this.F = param1Int;
      return this;
    }
    
    public Builder setSloganTextSize(int param1Int) {
      this.G = param1Int;
      return this;
    }
    
    public Builder setUncheckedImgPath(Drawable param1Drawable) {
      this.R = param1Drawable;
      return this;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\tool\ShanYanUIConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */