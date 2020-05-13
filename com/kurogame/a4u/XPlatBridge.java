package com.kurogame.a4u;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.kurogame.notchwrapper.NotchWrapper;

public class XPlatBridge {
  private ClipboardManager clipboardManager;
  
  private NotchWrapper notchWrapper = new NotchWrapper();
  
  private Activity unityActivity;
  
  private Activity getActivity() {
    if (this.unityActivity == null)
      try {
        Class<?> clazz = Class.forName("com.unity3d.player.UnityPlayer");
        this.unityActivity = (Activity)clazz.getDeclaredField("currentActivity").get(clazz);
      } catch (IllegalAccessException illegalAccessException) {
        illegalAccessException.printStackTrace();
      } catch (ClassNotFoundException classNotFoundException) {
        classNotFoundException.printStackTrace();
      } catch (NoSuchFieldException noSuchFieldException) {
        noSuchFieldException.printStackTrace();
      }  
    return this.unityActivity;
  }
  
  public boolean checkPackageInstalled(String paramString) {
    boolean bool = false;
    try {
      PackageInfo packageInfo = getActivity().getPackageManager().getPackageInfo(paramString, 0);
      if (packageInfo != null)
        bool = true; 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return bool;
  }
  
  public void copyToClipBoard(String paramString) {
    if (this.clipboardManager == null)
      this.clipboardManager = (ClipboardManager)getActivity().getSystemService("clipboard"); 
    ClipData clipData = ClipData.newPlainText("Label", paramString);
    this.clipboardManager.setPrimaryClip(clipData);
  }
  
  public String getAppMetaData(String paramString) {
    try {
      return (getActivity().getPackageManager().getApplicationInfo(getActivity().getPackageName(), 128)).metaData.getString(paramString);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public String getAppPackageName() {
    return getActivity().getApplicationContext().getPackageName();
  }
  
  public int getNotchSize() {
    return this.notchWrapper.getNotchSize(getActivity());
  }
  
  public void startScheme(String paramString) {
    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    getActivity().startActivity(intent);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\kurogame\a4u\XPlatBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */