package com.cmic.sso.sdk;

import android.text.TextUtils;

public class AuthThemeConfig {
  private int CLAUSE_BASE_COLOR = -1;
  
  private int CLAUSE_COLOR = -1;
  
  private String CLAUSE_NAME = null;
  
  private String CLAUSE_NAME_TWO = null;
  
  private String CLAUSE_URL = null;
  
  private String CLAUSE_URL_TWO = null;
  
  private String authBGImgPath = null;
  
  private boolean authNavTransparent = false;
  
  private String checkedImgPath;
  
  private String logBtnBackgroundPath;
  
  private int logBtnOffsetY = -1;
  
  private int logBtnOffsetY_B = 0;
  
  private String logBtnText;
  
  private int logBtnTextColor = -1;
  
  private int logoHeight = -1;
  
  private boolean logoHidden;
  
  private String logoImgPath;
  
  private int logoOffsetY = -1;
  
  private int logoOffsetY_B = 0;
  
  private int logoWidth = -1;
  
  private int navColor = -1;
  
  private String navReturnImgPath;
  
  private String navText;
  
  private int navTextColor = -1;
  
  private int numFieldOffsetY = -1;
  
  private int numFieldOffsetY_B = 0;
  
  private int numberColor = -1;
  
  private int numberSize = -1;
  
  private int privacyOffsetY = -1;
  
  private int privacyOffsetY_B = 0;
  
  private boolean privacyState = false;
  
  private int sloganOffsetY = -1;
  
  private int sloganOffsetY_B = 0;
  
  private int sloganTextColor = -1;
  
  private String smsBGImgPath = null;
  
  private int smsCodeBtnTextColor = -1;
  
  private String smsCodeImgPath = null;
  
  private String smsLogBtnImgPath;
  
  private String smsLogBtnText;
  
  private int smsLogBtnTextColor;
  
  private String smsNavText;
  
  private boolean smsNavTransparent = false;
  
  private int smsSloganTextColor = -1;
  
  private boolean switchAccHidden;
  
  private int switchAccOffsetY = -1;
  
  private int switchAccTextColor = -1;
  
  private int switchOffsetY_B = 0;
  
  private String uncheckedImgPath;
  
  private AuthThemeConfig(Builder paramBuilder) {
    this.navColor = paramBuilder.navColor;
    this.navText = paramBuilder.navText;
    this.navTextColor = paramBuilder.navTextColor;
    this.navReturnImgPath = paramBuilder.navReturnImgPath;
    this.logoImgPath = paramBuilder.logoImgPath;
    this.logoWidth = paramBuilder.logoWidth;
    this.logoHeight = paramBuilder.logoHeight;
    this.logoOffsetY = paramBuilder.logoOffsetY;
    this.logoHidden = paramBuilder.logoHidden;
    this.numberColor = paramBuilder.numberColor;
    this.switchAccHidden = paramBuilder.switchAccHidden;
    this.switchAccTextColor = paramBuilder.switchAccTextColor;
    this.numFieldOffsetY = paramBuilder.numFieldOffsetY;
    this.logBtnText = paramBuilder.logBtnText;
    this.logBtnOffsetY = paramBuilder.logBtnOffsetY;
    this.logBtnTextColor = paramBuilder.logBtnTextColor;
    this.logBtnBackgroundPath = paramBuilder.logBtnBackgroundPath;
    this.switchAccOffsetY = paramBuilder.switchAccOffsetY;
    this.uncheckedImgPath = paramBuilder.uncheckedImgPath;
    this.checkedImgPath = paramBuilder.checkedImgPath;
    this.privacyOffsetY = paramBuilder.privacyOffsetY;
    this.CLAUSE_NAME = paramBuilder.CLAUSE_NAME;
    this.CLAUSE_URL = paramBuilder.CLAUSE_URL;
    this.CLAUSE_BASE_COLOR = paramBuilder.CLAUSE_BASE_COLOR;
    this.CLAUSE_COLOR = paramBuilder.CLAUSE_COLOR;
    this.CLAUSE_NAME_TWO = paramBuilder.CLAUSE_NAME_TWO;
    this.CLAUSE_URL_TWO = paramBuilder.CLAUSE_URL_TWO;
    this.sloganOffsetY = paramBuilder.sloganOffsetY;
    this.sloganTextColor = paramBuilder.sloganTextColor;
    this.smsNavText = paramBuilder.smsNavText;
    this.smsLogBtnText = paramBuilder.smsLogBtnText;
    this.smsLogBtnTextColor = paramBuilder.smsLogBtnTextColor;
    this.smsLogBtnImgPath = paramBuilder.smsLogBtnImgPath;
    this.authBGImgPath = paramBuilder.authBGImgPath;
    this.authNavTransparent = paramBuilder.authNavTransparent;
    this.smsNavTransparent = paramBuilder.smsNavTransparent;
    this.smsBGImgPath = paramBuilder.smsBGImgPath;
    this.smsCodeImgPath = paramBuilder.smsCodeImgPath;
    this.smsCodeBtnTextColor = paramBuilder.smsCodeBtnTextColor;
    this.smsSloganTextColor = paramBuilder.smsSloganTextColor;
    this.logoOffsetY_B = paramBuilder.logoOffsetY_B;
    this.numFieldOffsetY_B = paramBuilder.numFieldOffsetY_B;
    this.switchOffsetY_B = paramBuilder.switchOffsetY_B;
    this.logBtnOffsetY_B = paramBuilder.logBtnOffsetY_B;
    this.privacyOffsetY_B = paramBuilder.privacyOffsetY_B;
    this.sloganOffsetY_B = paramBuilder.sloganOffsetY_B;
    this.numberSize = paramBuilder.numberSize;
    this.privacyState = paramBuilder.privacyState;
  }
  
  public String getAuthBGImgPath() {
    return this.authBGImgPath;
  }
  
  public boolean getAuthNavTransparent() {
    return this.authNavTransparent;
  }
  
  public String getCheckedImgPath() {
    return this.checkedImgPath;
  }
  
  public int getClauseBaseColor() {
    return this.CLAUSE_BASE_COLOR;
  }
  
  public int getClauseColor() {
    return this.CLAUSE_COLOR;
  }
  
  public String getClauseName() {
    return this.CLAUSE_NAME;
  }
  
  public String getClauseNameTwo() {
    return this.CLAUSE_NAME_TWO;
  }
  
  public String getClauseUrl() {
    return this.CLAUSE_URL;
  }
  
  public String getClauseUrlTwo() {
    return this.CLAUSE_URL_TWO;
  }
  
  public String getLogBtnBackgroundPath() {
    return this.logBtnBackgroundPath;
  }
  
  public int getLogBtnOffsetY() {
    return this.logBtnOffsetY;
  }
  
  public int getLogBtnOffsetY_B() {
    return this.logBtnOffsetY_B;
  }
  
  public String getLogBtnText() {
    return this.logBtnText;
  }
  
  public int getLogBtnTextColor() {
    return this.logBtnTextColor;
  }
  
  public int getLogoHeight() {
    return this.logoHeight;
  }
  
  public String getLogoImgPath() {
    return this.logoImgPath;
  }
  
  public int getLogoOffsetY() {
    return this.logoOffsetY;
  }
  
  public int getLogoOffsetY_B() {
    return this.logoOffsetY_B;
  }
  
  public int getLogoWidth() {
    return this.logoWidth;
  }
  
  public int getNavColor() {
    return this.navColor;
  }
  
  public String getNavReturnImgPath() {
    return this.navReturnImgPath;
  }
  
  public String getNavText() {
    return this.navText;
  }
  
  public int getNavTextColor() {
    return this.navTextColor;
  }
  
  public int getNumFieldOffsetY() {
    return this.numFieldOffsetY;
  }
  
  public int getNumFieldOffsetY_B() {
    return this.numFieldOffsetY_B;
  }
  
  public int getNumberColor() {
    return this.numberColor;
  }
  
  public int getNumberSize() {
    return this.numberSize;
  }
  
  public int getPrivacyOffsetY() {
    return this.privacyOffsetY;
  }
  
  public int getPrivacyOffsetY_B() {
    return this.privacyOffsetY_B;
  }
  
  public boolean getPrivacyState() {
    return this.privacyState;
  }
  
  public int getSloganOffsetY() {
    return this.sloganOffsetY;
  }
  
  public int getSloganOffsetY_B() {
    return this.sloganOffsetY_B;
  }
  
  public int getSloganTextColor() {
    return this.sloganTextColor;
  }
  
  public String getSmsBGImgPath() {
    return this.smsBGImgPath;
  }
  
  public int getSmsCodeBtnTextColor() {
    return this.smsCodeBtnTextColor;
  }
  
  public String getSmsCodeImgPath() {
    return this.smsCodeImgPath;
  }
  
  public String getSmsLogBtnImgPath() {
    return this.smsLogBtnImgPath;
  }
  
  public String getSmsLogBtnText() {
    return this.smsLogBtnText;
  }
  
  public int getSmsLogBtnTextColor() {
    return this.smsLogBtnTextColor;
  }
  
  public String getSmsNavText() {
    return this.smsNavText;
  }
  
  public boolean getSmsNavTransparent() {
    return this.smsNavTransparent;
  }
  
  public int getSmsSloganTextColor() {
    return this.smsSloganTextColor;
  }
  
  public int getSwitchAccOffsetY() {
    return this.switchAccOffsetY;
  }
  
  public int getSwitchAccTextColor() {
    return this.switchAccTextColor;
  }
  
  public int getSwitchOffsetY_B() {
    return this.switchOffsetY_B;
  }
  
  public String getUncheckedImgPath() {
    return this.uncheckedImgPath;
  }
  
  public boolean isLogoHidden() {
    return this.logoHidden;
  }
  
  public boolean isSwitchAccHidden() {
    return this.switchAccHidden;
  }
  
  public static class Builder {
    private int CLAUSE_BASE_COLOR = -10066330;
    
    private int CLAUSE_COLOR = -16007674;
    
    private String CLAUSE_NAME = null;
    
    private String CLAUSE_NAME_TWO = null;
    
    private String CLAUSE_URL = null;
    
    private String CLAUSE_URL_TWO = null;
    
    private String authBGImgPath = null;
    
    private boolean authNavTransparent = false;
    
    private String checkedImgPath = "umcsdk_check_image";
    
    private String logBtnBackgroundPath = "umcsdk_login_btn_bg";
    
    private int logBtnOffsetY = 254;
    
    private int logBtnOffsetY_B = 0;
    
    private String logBtnText = "本机号码一键登录";
    
    private int logBtnTextColor = -1;
    
    private int logoHeight = 70;
    
    private boolean logoHidden = false;
    
    private String logoImgPath = "mobile_logo";
    
    private int logoOffsetY = 100;
    
    private int logoOffsetY_B = 0;
    
    private int logoWidth = 70;
    
    private int navColor = -16742704;
    
    private String navReturnImgPath = "return_bg";
    
    private String navText = "登录";
    
    private int navTextColor = -1;
    
    private int numFieldOffsetY = 184;
    
    private int numFieldOffsetY_B = 0;
    
    private int numberColor = -16742704;
    
    private int numberSize = 18;
    
    private int privacyOffsetY = 0;
    
    private int privacyOffsetY_B = 30;
    
    private boolean privacyState = false;
    
    private int sloganOffsetY = 224;
    
    private int sloganOffsetY_B = 0;
    
    private int sloganTextColor = -10066330;
    
    private String smsBGImgPath = null;
    
    private int smsCodeBtnTextColor = -1;
    
    private String smsCodeImgPath = null;
    
    private String smsLogBtnImgPath = "umcsdk_login_btn_bg";
    
    private String smsLogBtnText = "短信验证码登录";
    
    private int smsLogBtnTextColor = -1;
    
    private String smsNavText = "登录";
    
    private boolean smsNavTransparent = false;
    
    private int smsSloganTextColor = -6710887;
    
    private boolean switchAccHidden;
    
    private int switchAccOffsetY = 300;
    
    private int switchAccTextColor = -11365671;
    
    private int switchOffsetY_B = 0;
    
    private String uncheckedImgPath = "umcsdk_uncheck_image";
    
    public AuthThemeConfig build() {
      return new AuthThemeConfig(this);
    }
    
    public Builder setAuthBGImgPath(String param1String) {
      this.authBGImgPath = param1String;
      return this;
    }
    
    public Builder setAuthNavTransparent(boolean param1Boolean) {
      this.authNavTransparent = param1Boolean;
      return this;
    }
    
    public Builder setCheckedImgPath(String param1String) {
      this.checkedImgPath = param1String;
      return this;
    }
    
    public Builder setClauseColor(int param1Int1, int param1Int2) {
      this.CLAUSE_BASE_COLOR = param1Int1;
      this.CLAUSE_COLOR = param1Int2;
      return this;
    }
    
    public Builder setClauseOne(String param1String1, String param1String2) {
      if (TextUtils.isEmpty(param1String1)) {
        this.CLAUSE_NAME = param1String1;
        this.CLAUSE_URL = param1String2;
        return this;
      } 
      this.CLAUSE_NAME = param1String1;
      this.CLAUSE_URL = param1String2;
      return this;
    }
    
    public Builder setClauseTwo(String param1String1, String param1String2) {
      if (TextUtils.isEmpty(param1String1)) {
        this.CLAUSE_NAME_TWO = param1String1;
        this.CLAUSE_URL_TWO = param1String2;
        return this;
      } 
      this.CLAUSE_NAME_TWO = param1String1;
      this.CLAUSE_URL_TWO = param1String2;
      return this;
    }
    
    public Builder setLogBtnImgPath(String param1String) {
      this.logBtnBackgroundPath = param1String;
      return this;
    }
    
    public Builder setLogBtnOffsetY(int param1Int) {
      this.logBtnOffsetY = param1Int;
      return this;
    }
    
    public Builder setLogBtnOffsetY_B(int param1Int) {
      this.logBtnOffsetY_B = param1Int;
      return this;
    }
    
    public Builder setLogBtnText(String param1String) {
      this.logBtnText = param1String;
      return this;
    }
    
    public Builder setLogBtnTextColor(int param1Int) {
      this.logBtnTextColor = param1Int;
      return this;
    }
    
    public Builder setLogoHeightDip(int param1Int) {
      this.logoHeight = param1Int;
      return this;
    }
    
    public Builder setLogoHidden(boolean param1Boolean) {
      this.logoHidden = param1Boolean;
      return this;
    }
    
    public Builder setLogoImgPath(String param1String) {
      this.logoImgPath = param1String;
      return this;
    }
    
    public Builder setLogoOffsetY(int param1Int) {
      this.logoOffsetY = param1Int;
      return this;
    }
    
    public Builder setLogoOffsetY_B(int param1Int) {
      this.logoOffsetY_B = param1Int;
      return this;
    }
    
    public Builder setLogoWidthDip(int param1Int) {
      this.logoWidth = param1Int;
      return this;
    }
    
    public Builder setNavColor(int param1Int) {
      this.navColor = param1Int;
      return this;
    }
    
    public Builder setNavReturnImgPath(String param1String) {
      this.navReturnImgPath = param1String;
      return this;
    }
    
    public Builder setNavText(String param1String) {
      this.navText = param1String;
      return this;
    }
    
    public Builder setNavTextColor(int param1Int) {
      this.navTextColor = param1Int;
      return this;
    }
    
    public Builder setNumFieldOffsetY(int param1Int) {
      this.numFieldOffsetY = param1Int;
      return this;
    }
    
    public Builder setNumFieldOffsetY_B(int param1Int) {
      this.numFieldOffsetY_B = param1Int;
      return this;
    }
    
    public Builder setNumberColor(int param1Int) {
      this.numberColor = param1Int;
      return this;
    }
    
    public Builder setNumberSize(int param1Int) {
      this.numberSize = param1Int;
      return this;
    }
    
    public Builder setPrivacyOffsetY(int param1Int) {
      this.privacyOffsetY = param1Int;
      return this;
    }
    
    public Builder setPrivacyOffsetY_B(int param1Int) {
      this.privacyOffsetY_B = param1Int;
      return this;
    }
    
    public Builder setPrivacyState(boolean param1Boolean) {
      this.privacyState = param1Boolean;
      return this;
    }
    
    public Builder setSloganOffsetY(int param1Int) {
      this.sloganOffsetY = param1Int;
      return this;
    }
    
    public Builder setSloganOffsetY_B(int param1Int) {
      this.sloganOffsetY_B = param1Int;
      return this;
    }
    
    public Builder setSloganTextColor(int param1Int) {
      this.sloganTextColor = param1Int;
      return this;
    }
    
    public Builder setSmsBGImgPath(String param1String) {
      this.smsBGImgPath = param1String;
      return this;
    }
    
    public Builder setSmsCodeBtnTextColor(int param1Int) {
      this.smsCodeBtnTextColor = param1Int;
      return this;
    }
    
    public Builder setSmsCodeImgPath(String param1String) {
      this.smsCodeImgPath = param1String;
      return this;
    }
    
    public Builder setSmsLogBtnImgPath(String param1String) {
      this.smsLogBtnImgPath = param1String;
      return this;
    }
    
    public Builder setSmsLogBtnText(String param1String) {
      this.smsLogBtnText = param1String;
      return this;
    }
    
    public Builder setSmsLogBtnTextColor(int param1Int) {
      this.smsLogBtnTextColor = param1Int;
      return this;
    }
    
    public Builder setSmsNavText(String param1String) {
      this.smsNavText = param1String;
      return this;
    }
    
    public Builder setSmsNavTransparent(boolean param1Boolean) {
      this.smsNavTransparent = param1Boolean;
      return this;
    }
    
    public Builder setSmsSloganTextColor(int param1Int) {
      this.smsSloganTextColor = param1Int;
      return this;
    }
    
    public Builder setSwitchAccHidden(boolean param1Boolean) {
      this.switchAccHidden = param1Boolean;
      return this;
    }
    
    public Builder setSwitchAccTextColor(int param1Int) {
      this.switchAccTextColor = param1Int;
      return this;
    }
    
    public Builder setSwitchOffsetY(int param1Int) {
      this.switchAccOffsetY = param1Int;
      return this;
    }
    
    public Builder setSwitchOffsetY_B(int param1Int) {
      this.switchOffsetY_B = param1Int;
      return this;
    }
    
    public Builder setUncheckedImgPath(String param1String) {
      this.uncheckedImgPath = param1String;
      return this;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\AuthThemeConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */