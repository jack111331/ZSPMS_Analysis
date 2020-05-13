package com.chuanglan.shanyan_sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;

public class LCMResource {
  private static final String a = "drawable";
  
  private static final String b = "id";
  
  private static final String c = "layout";
  
  private static LCMResource d = null;
  
  private Context e = null;
  
  private Resources f;
  
  private LayoutInflater g;
  
  private int h = 0;
  
  private LCMResource(Context paramContext) {
    if (paramContext != null)
      this.e = paramContext.getApplicationContext(); 
    this.f = this.e.getResources();
    this.g = LayoutInflater.from(this.e);
  }
  
  public static LCMResource getInstance(Context paramContext) {
    if (d == null)
      try {
        LCMResource lCMResource = new LCMResource();
        this(paramContext);
        d = lCMResource;
      } catch (Exception exception) {
        exception.printStackTrace();
        L.d("ExceptionLogger", "LCMResource()Exception == " + exception.toString());
      }  
    return d;
  }
  
  public Drawable getDrawable(String paramString) {
    int i;
    Drawable drawable = null;
    null = drawable;
    if (this.f != null) {
      i = this.f.getIdentifier(paramString, "drawable", this.e.getPackageName());
      if (i == 0)
        return drawable; 
    } else {
      return null;
    } 
    return this.f.getDrawable(i);
  }
  
  public int getId(String paramString) {
    return (this.f != null) ? this.f.getIdentifier(paramString, "id", this.e.getPackageName()) : this.h;
  }
  
  public int getLayoutForId(String paramString) {
    return (this.f != null) ? this.f.getIdentifier(paramString, "layout", this.e.getPackageName()) : this.h;
  }
  
  public View getLayoutForView(String paramString) {
    View view1 = null;
    View view2 = view1;
    if (this.f != null) {
      int i = this.f.getIdentifier(paramString, "layout", this.e.getPackageName());
      view2 = view1;
      if (this.g != null) {
        view2 = view1;
        if (i != 0)
          view2 = this.g.inflate(i, null); 
      } 
    } 
    return view2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\LCMResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */