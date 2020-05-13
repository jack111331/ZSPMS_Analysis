package com.zz.sdk.lib.widget.fancybuttons;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class a {
  private static Map a = new HashMap<Object, Object>();
  
  public static int a(Context paramContext, float paramFloat) {
    return Math.round(paramFloat / (paramContext.getResources().getDisplayMetrics()).scaledDensity);
  }
  
  public static Typeface a(Context paramContext, String paramString1, String paramString2) {
    if (paramString1 == null)
      return Typeface.DEFAULT; 
    String str1 = (new File(paramString1)).getName();
    String str2 = "";
    if (!TextUtils.isEmpty(paramString2))
      str2 = (new File(paramString2)).getName(); 
    if (a.containsKey(str1))
      return (Typeface)a.get(str1); 
    try {
      assetManager = paramContext.getResources().getAssets();
      if (Arrays.<String>asList(assetManager.list("")).contains(paramString1)) {
        typeface = Typeface.createFromAsset(paramContext.getAssets(), str1);
        a.put(str1, typeface);
        return typeface;
      } 
    } catch (Exception exception1) {
      return Typeface.DEFAULT;
    } 
    if (Arrays.<String>asList(assetManager.list("fonts")).contains(str1)) {
      typeface = Typeface.createFromAsset(paramContext.getAssets(), String.format("fonts/%s", new Object[] { str1 }));
      a.put(str1, typeface);
      return typeface;
    } 
    if (Arrays.<String>asList(assetManager.list("iconfonts")).contains(str1)) {
      typeface = Typeface.createFromAsset(typeface.getAssets(), String.format("iconfonts/%s", new Object[] { str1 }));
      a.put(str1, typeface);
      return typeface;
    } 
    if (!TextUtils.isEmpty(paramString2) && Arrays.<String>asList(assetManager.list("")).contains(paramString2)) {
      typeface = Typeface.createFromAsset(typeface.getAssets(), paramString2);
      a.put(str2, typeface);
      return typeface;
    } 
    Exception exception = new Exception();
    this("Font not Found");
    Typeface typeface;
    AssetManager assetManager;
    throw exception;
  }
  
  public static int b(Context paramContext, float paramFloat) {
    return Math.round((paramContext.getResources().getDisplayMetrics()).scaledDensity * paramFloat);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\fancybuttons\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */