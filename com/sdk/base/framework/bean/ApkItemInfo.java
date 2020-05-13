package com.sdk.base.framework.bean;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.sdk.base.framework.utils.c.a;
import java.io.File;

public class ApkItemInfo {
  private String apkfile;
  
  private Drawable icon;
  
  private int isSystemApp = -1;
  
  private CharSequence lable;
  
  private PackageInfo packageInfo;
  
  private String pkName;
  
  private int versionCode;
  
  private String versionName;
  
  public ApkItemInfo(Context paramContext, File paramFile) {
    if (paramFile != null) {
      PackageManager packageManager = paramContext.getPackageManager();
      PackageInfo packageInfo = packageManager.getPackageArchiveInfo(paramFile.getPath(), 0);
      ApplicationInfo applicationInfo = packageInfo.applicationInfo;
      applicationInfo.sourceDir = paramFile.getPath();
      applicationInfo.publicSourceDir = paramFile.getPath();
      getApkItemInfo(packageManager, packageInfo, applicationInfo);
    } 
  }
  
  public ApkItemInfo(Context paramContext, String paramString) {
    PackageManager packageManager = paramContext.getPackageManager();
    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(paramString, 128);
    getApkItemInfo(packageManager, packageManager.getPackageInfo(paramString, 0), applicationInfo);
  }
  
  public void getApkItemInfo(PackageManager paramPackageManager, PackageInfo paramPackageInfo, ApplicationInfo paramApplicationInfo) {
    try {
      this.icon = paramPackageManager.getApplicationIcon(paramPackageInfo.applicationInfo);
    } catch (Exception exception) {
      this.icon = paramPackageManager.getDefaultActivityIcon();
    } 
    try {
      this.lable = paramPackageManager.getApplicationLabel(paramPackageInfo.applicationInfo);
    } catch (Exception exception) {}
    try {
      if ((paramPackageInfo.applicationInfo.flags & 0x1) == 0) {
        this.isSystemApp = 0;
      } else {
        this.isSystemApp = 1;
      } 
    } catch (Exception exception) {}
    this.pkName = paramApplicationInfo.packageName;
    this.versionName = paramPackageInfo.versionName;
    this.versionCode = paramPackageInfo.versionCode;
    this.apkfile = paramApplicationInfo.sourceDir;
    this.packageInfo = paramPackageInfo;
  }
  
  public String getApkfile() {
    return this.apkfile;
  }
  
  public Drawable getIcon() {
    return this.icon;
  }
  
  public int getIsSystemApp() {
    return this.isSystemApp;
  }
  
  public CharSequence getLable() {
    return this.lable;
  }
  
  public PackageInfo getPackageInfo() {
    return this.packageInfo;
  }
  
  public String getPkName() {
    return this.pkName;
  }
  
  public int getVersionCode() {
    return this.versionCode;
  }
  
  public String getVersionName() {
    return this.versionName;
  }
  
  public void setApkfile(String paramString) {
    this.apkfile = paramString;
  }
  
  public void setIcon(Drawable paramDrawable) {
    this.icon = paramDrawable;
  }
  
  public void setIsSystemApp(int paramInt) {
    this.isSystemApp = paramInt;
  }
  
  public void setLable(CharSequence paramCharSequence) {
    this.lable = paramCharSequence;
  }
  
  public void setPackageInfo(PackageInfo paramPackageInfo) {
    this.packageInfo = paramPackageInfo;
  }
  
  public void setPkName(String paramString) {
    this.pkName = paramString;
  }
  
  public void setVersionCode(int paramInt) {
    this.versionCode = paramInt;
  }
  
  public void setVersionName(String paramString) {
    this.versionName = paramString;
  }
  
  public String toJsonString() {
    return a.a(this);
  }
  
  public String toString() {
    return "ApkItemInfo [icon=" + this.icon + ", pkName=" + this.pkName + ", lable=" + this.lable + ", versionName=" + this.versionName + ", versionCode=" + this.versionCode + ", apkfile=" + this.apkfile + ", packageInfo=" + this.packageInfo + "]";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\bean\ApkItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */