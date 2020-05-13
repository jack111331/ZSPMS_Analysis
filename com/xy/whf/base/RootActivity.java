package com.xy.whf.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import com.xy.whf.helper.LangHelper;
import com.xy.whf.helper.PermissionHelper;
import com.xy.whf.helper.StatusBarHelper;

public class RootActivity extends Activity {
  protected PermissionHelper.PermissionCallBack mPermissionCallBack;
  
  @TargetApi(23)
  public void applyMultiplyPermissions(int paramInt, String[] paramArrayOfString, PermissionHelper.PermissionCallBack paramPermissionCallBack) {
    this.mPermissionCallBack = paramPermissionCallBack;
    if (!LangHelper.isNullOrEmpty((Object[])paramArrayOfString)) {
      ActivityCompat.requestPermissions(this, paramArrayOfString, paramInt);
      return;
    } 
    paramPermissionCallBack.result(paramInt, -1, "传入正确的权限");
  }
  
  @TargetApi(23)
  public void applySinglePermission(int paramInt, String paramString, PermissionHelper.PermissionCallBack paramPermissionCallBack) {
    this.mPermissionCallBack = paramPermissionCallBack;
    if (!LangHelper.isNullOrEmpty(paramString)) {
      ActivityCompat.requestPermissions(this, new String[] { paramString }, paramInt);
      return;
    } 
    paramPermissionCallBack.result(paramInt, -1, "传入正确的权限");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1) {
      default:
        return;
      case 50001:
        if (PermissionHelper.a((Context)this))
          this.mPermissionCallBack.result(paramInt1, 0, "已开启定位"); 
        this.mPermissionCallBack.result(paramInt1, 1, "系统检测到未开启GPS定位服务,前往设置页面开启");
      case 60003:
        if (PermissionHelper.a((Context)this, "android.permission.ACCESS_FINE_LOCATION"))
          this.mPermissionCallBack.result(paramInt1, 0, "已同意"); 
        this.mPermissionCallBack.result(paramInt1, -3, "拒绝权限，且不能再次发起");
      case 60004:
        if (PermissionHelper.a((Context)this, "android.permission.READ_CONTACTS"))
          this.mPermissionCallBack.result(paramInt1, 0, "已同意"); 
        this.mPermissionCallBack.result(paramInt1, -3, "拒绝权限，且不能再次发起");
      case 60005:
        if (PermissionHelper.a((Context)this, "android.permission.READ_CALL_LOG"))
          this.mPermissionCallBack.result(paramInt1, 0, "已同意"); 
        this.mPermissionCallBack.result(paramInt1, -3, "拒绝权限，且不能再次发起");
      case 60006:
        break;
    } 
    if (PermissionHelper.a((Context)this, "android.permission.READ_SMS"))
      this.mPermissionCallBack.result(paramInt1, 0, "已同意"); 
    this.mPermissionCallBack.result(paramInt1, -3, "拒绝权限，且不能再次发起");
  }
  
  protected void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    a.a().a(this);
    StatusBarHelper.translucent(this);
  }
  
  protected void onDestroy() {
    super.onDestroy();
    a.a().b(this);
  }
  
  @TargetApi(23)
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfint) {
    byte b = 0;
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfint);
    if (paramInt == 70000) {
      try {
        if (!LangHelper.isNullOrEmpty((Object[])paramArrayOfString))
          while (true) {
            if (b < paramArrayOfString.length) {
              if (paramArrayOfint[b] != 0) {
                if (shouldShowRequestPermissionRationale(paramArrayOfString[b])) {
                  this.mPermissionCallBack.result(paramInt, -2, "拒绝权限，可以再次发起");
                  return;
                } 
                this.mPermissionCallBack.result(paramInt, -3, "拒绝权限，且不能再次发起");
                return;
              } 
            } else {
              return;
            } 
            b++;
          }  
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      return;
    } 
    if (paramArrayOfint.length > 0 && paramArrayOfint[0] == 0) {
      this.mPermissionCallBack.result(paramInt, 0, "已同意");
      return;
    } 
    if (shouldShowRequestPermissionRationale((String)exception[0])) {
      this.mPermissionCallBack.result(paramInt, -2, "拒绝权限，可以再次发起");
      return;
    } 
    this.mPermissionCallBack.result(paramInt, -3, "拒绝权限，且不能再次发起");
  }
  
  public void openGps(int paramInt, PermissionHelper.PermissionCallBack paramPermissionCallBack) {
    this.mPermissionCallBack = paramPermissionCallBack;
    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\base\RootActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */