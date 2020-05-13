package com.chuanglan.shanyan_sdk.tool;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.chuanglan.shanyan_sdk.utils.AbScreenUtils;
import com.cmic.sso.sdk.AuthRegisterViewConfig;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.utils.rglistener.CustomInterface;

public class m {
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
    Window window = paramActivity.getWindow();
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    layoutParams.width = AbScreenUtils.dp2px(paramActivity.getApplicationContext(), paramInt1);
    layoutParams.height = AbScreenUtils.dp2px(paramActivity.getApplicationContext(), paramInt2);
    layoutParams.x = paramInt3;
    if (paramBoolean) {
      layoutParams.gravity = 80;
    } else {
      layoutParams.y = paramInt4;
    } 
    window.setAttributes(layoutParams);
  }
  
  public static void a(Context paramContext, View paramView, int paramInt1, int paramInt2, int paramInt3) {
    ViewGroup.LayoutParams layoutParams1 = paramView.getLayoutParams();
    layoutParams1.width = -2;
    layoutParams1.height = -2;
    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(paramView.getLayoutParams());
    paramInt2 = AbScreenUtils.dp2px(paramContext, paramInt2);
    int i = AbScreenUtils.dp2px(paramContext, paramInt1);
    int j = AbScreenUtils.dp2px(paramContext, paramInt3);
    if (paramInt1 == -1 && paramInt3 == -1) {
      marginLayoutParams.setMargins(0, paramInt2, 0, 0);
    } else if (paramInt1 == -1 && paramInt3 != -1) {
      marginLayoutParams.setMargins(0, 0, 0, j);
    } else if (paramInt1 != -1 && paramInt3 == -1) {
      marginLayoutParams.setMargins(i, paramInt2, 0, 0);
    } else if (paramInt1 != -1 && paramInt3 != -1) {
      marginLayoutParams.setMargins(i, 0, 0, j);
    } 
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginLayoutParams);
    if (paramInt1 == -1 && paramInt3 == -1) {
      layoutParams.addRule(10);
      layoutParams.addRule(14);
    } else if (paramInt1 == -1 && paramInt3 != -1) {
      layoutParams.addRule(12);
      layoutParams.addRule(14);
    } else if (paramInt1 != -1 && paramInt3 == -1) {
      layoutParams.addRule(10);
      layoutParams.addRule(9);
    } else if (paramInt1 != -1 && paramInt3 != -1) {
      layoutParams.addRule(12);
      layoutParams.addRule(9);
    } 
    paramView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public static void a(Context paramContext, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    ViewGroup.LayoutParams layoutParams1 = paramView.getLayoutParams();
    layoutParams1.width = -1;
    layoutParams1.height = -2;
    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams1);
    int i = AbScreenUtils.dp2px(paramContext, paramInt2);
    int j = AbScreenUtils.dp2px(paramContext, paramInt1);
    paramInt2 = AbScreenUtils.dp2px(paramContext, paramInt3);
    if (paramInt1 == -1 && paramInt3 == -1) {
      marginLayoutParams.setMargins(0, i, 0, 0);
    } else if (paramInt1 == -1 && paramInt3 != -1) {
      marginLayoutParams.setMargins(0, 0, 0, paramInt2);
    } else if (paramInt1 != -1 && paramInt3 == -1) {
      marginLayoutParams.setMargins(j, i, 0, 0);
    } else if (paramInt1 != -1 && paramInt3 != -1) {
      marginLayoutParams.setMargins(j, 0, 0, paramInt2);
    } 
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginLayoutParams);
    if (paramInt5 != -1)
      layoutParams.height = AbScreenUtils.dp2px(paramContext, paramInt5); 
    if (paramInt4 == -1) {
      layoutParams.leftMargin = AbScreenUtils.dp2px(paramContext, 47.0F);
      layoutParams.rightMargin = AbScreenUtils.dp2px(paramContext, 47.0F);
    } else {
      layoutParams.width = AbScreenUtils.dp2px(paramContext, paramInt4);
    } 
    if (paramInt1 == -1 && paramInt3 == -1) {
      layoutParams.addRule(10);
      layoutParams.addRule(14);
    } else if (paramInt1 == -1 && paramInt3 != -1) {
      layoutParams.addRule(12);
      layoutParams.addRule(14);
    } else if (paramInt1 != -1 && paramInt3 == -1) {
      layoutParams.addRule(10);
      layoutParams.addRule(9);
    } else if (paramInt1 != -1 && paramInt3 != -1) {
      layoutParams.addRule(12);
      layoutParams.addRule(9);
    } 
    paramView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public static void a(Context paramContext, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, ImageView paramImageView) {
    ViewGroup.LayoutParams layoutParams2 = paramView.getLayoutParams();
    layoutParams2.width = -2;
    layoutParams2.height = -2;
    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams2);
    int i = AbScreenUtils.dp2px(paramContext, paramInt2);
    paramInt1 = AbScreenUtils.dp2px(paramContext, paramInt1);
    int j = AbScreenUtils.dp2px(paramContext, paramInt3);
    if (paramInt2 == -1 && paramInt3 == -1) {
      marginLayoutParams.setMargins(paramInt1, 0, 0, 0);
    } else if (paramInt2 == -1 && paramInt3 != -1) {
      marginLayoutParams.setMargins(0, 0, j, 0);
    } else if (paramInt2 != -1 && paramInt3 == -1) {
      marginLayoutParams.setMargins(paramInt1, i, 0, 0);
    } else if (paramInt2 != -1 && paramInt3 != -1) {
      marginLayoutParams.setMargins(0, i, j, 0);
    } 
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginLayoutParams);
    ViewGroup.LayoutParams layoutParams1 = paramImageView.getLayoutParams();
    if (paramInt5 != -1) {
      layoutParams1.height = AbScreenUtils.dp2px(paramContext, paramInt5);
    } else {
      layoutParams1.height = -2;
    } 
    if (paramInt4 == -1) {
      layoutParams1.width = -2;
    } else {
      layoutParams1.width = AbScreenUtils.dp2px(paramContext, paramInt4);
    } 
    paramImageView.setLayoutParams(layoutParams1);
    if (paramInt2 == -1 && paramInt3 == -1) {
      layoutParams.addRule(9);
      layoutParams.addRule(15);
    } else if (paramInt2 == -1 && paramInt3 != -1) {
      layoutParams.addRule(11);
      layoutParams.addRule(15);
    } else if (paramInt2 != -1 && paramInt3 == -1) {
      layoutParams.addRule(10);
      layoutParams.addRule(9);
    } else if (paramInt2 != -1 && paramInt3 != -1) {
      layoutParams.addRule(10);
      layoutParams.addRule(11);
    } 
    paramView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public static void a(Context paramContext, String paramString, View paramView, int paramInt) {
    AuthnHelper.getInstance(paramContext).addAuthRegistViewConfig(paramString, (new AuthRegisterViewConfig.Builder()).setView(paramView).setRootViewId(paramInt).setCustomInterface(new CustomInterface() {
            public void onClick(Context param1Context) {}
          }).build());
  }
  
  public static void b(Context paramContext, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    ViewGroup.LayoutParams layoutParams1 = paramView.getLayoutParams();
    layoutParams1.width = -2;
    layoutParams1.height = -2;
    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams1);
    int i = AbScreenUtils.dp2px(paramContext, paramInt2);
    paramInt2 = AbScreenUtils.dp2px(paramContext, paramInt1);
    int j = AbScreenUtils.dp2px(paramContext, paramInt3);
    if (paramInt1 == -1 && paramInt3 == -1) {
      marginLayoutParams.setMargins(0, i, 0, 0);
    } else if (paramInt1 == -1 && paramInt3 != -1) {
      marginLayoutParams.setMargins(0, 0, 0, j);
    } else if (paramInt1 != -1 && paramInt3 == -1) {
      marginLayoutParams.setMargins(paramInt2, i, 0, 0);
    } else if (paramInt1 != -1 && paramInt3 != -1) {
      marginLayoutParams.setMargins(paramInt2, 0, 0, j);
    } 
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginLayoutParams);
    if (paramInt5 != -1)
      layoutParams.height = AbScreenUtils.dp2px(paramContext, paramInt5); 
    if (paramInt4 != -1)
      layoutParams.width = AbScreenUtils.dp2px(paramContext, paramInt4); 
    if (paramInt1 == -1 && paramInt3 == -1) {
      layoutParams.addRule(10);
      layoutParams.addRule(14);
    } else if (paramInt1 == -1 && paramInt3 != -1) {
      layoutParams.addRule(12);
      layoutParams.addRule(14);
    } else if (paramInt1 != -1 && paramInt3 == -1) {
      layoutParams.addRule(10);
      layoutParams.addRule(9);
    } else if (paramInt1 != -1 && paramInt3 != -1) {
      layoutParams.addRule(12);
      layoutParams.addRule(9);
    } 
    paramView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\tool\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */